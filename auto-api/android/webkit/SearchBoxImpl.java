package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebViewCore.EventHub;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

final class SearchBoxImpl implements SearchBox {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.331 -0400", hash_original_field = "2F2828353527044AFD6820F84A8A1FAB", hash_generated_field = "4C7B3AD4D5F853385EAEBF459FCD952D")

    private List<SearchBoxListener> mListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.331 -0400", hash_original_field = "9371E2004CE9EC2E60E3F0EBE8ED2E84", hash_generated_field = "73DACDCC92B5BF8822959B0368CF2255")

    private WebViewCore mWebViewCore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.331 -0400", hash_original_field = "957B64C4FA99E51BCE1B62690725D115", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private CallbackProxy mCallbackProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.331 -0400", hash_original_field = "17A0B012B1F0003FA951407B6DC13CCC", hash_generated_field = "0CF205629AE05DCA51E14A224D53E502")

    private IsSupportedCallback mSupportedCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.331 -0400", hash_original_field = "BB7303575963C9B6DC3AE8895F099701", hash_generated_field = "2C672208EA2C403ED48EE8D4B7A0B99C")

    private int mNextEventId = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.331 -0400", hash_original_field = "C0478676263755B89B1EA3C7937F07B3", hash_generated_field = "D244CC115998E0D29D9A833AA1713C9D")

    private HashMap<Integer, SearchBoxListener> mEventCallbacks;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.332 -0400", hash_original_method = "BE2818047EEFAAD053C1CB5A67BA80EE", hash_generated_method = "09DFB2445AC38991E895C14A35CDD681")
      SearchBoxImpl(WebViewCore webViewCore, CallbackProxy callbackProxy) {
        mListeners = new ArrayList<SearchBoxListener>();
        mWebViewCore = webViewCore;
        mCallbackProxy = callbackProxy;
        mEventCallbacks = new HashMap<Integer, SearchBoxListener>();
        // ---------- Original Method ----------
        //mListeners = new ArrayList<SearchBoxListener>();
        //mWebViewCore = webViewCore;
        //mCallbackProxy = callbackProxy;
        //mEventCallbacks = new HashMap<Integer, SearchBoxListener>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.333 -0400", hash_original_method = "69D13D1B78E6CC04010F4F58CC03E4DB", hash_generated_method = "BA878022F8153F1944CE7FEDF93D1827")
    @Override
    public void setQuery(String query) {
        String formattedQuery;
        formattedQuery = jsonSerialize(query);
        {
            String js;
            js = String.format(SET_QUERY_SCRIPT, formattedQuery);
            dispatchJs(js);
        } //End block
        addTaint(query.getTaint());
        // ---------- Original Method ----------
        //final String formattedQuery = jsonSerialize(query);
        //if (formattedQuery != null) {
            //final String js = String.format(SET_QUERY_SCRIPT, formattedQuery);
            //dispatchJs(js);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.333 -0400", hash_original_method = "F4645E95CEF728912C8FFD847CD99687", hash_generated_method = "3BC8F36DA77C83959A3782D4980DE316")
    @Override
    public void setVerbatim(boolean verbatim) {
        String js;
        js = String.format(SET_VERBATIM_SCRIPT, String.valueOf(verbatim));
        dispatchJs(js);
        addTaint(verbatim);
        // ---------- Original Method ----------
        //final String js = String.format(SET_VERBATIM_SCRIPT, String.valueOf(verbatim));
        //dispatchJs(js);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.333 -0400", hash_original_method = "17AF7417B2F09AA0D0ABD8E30884C551", hash_generated_method = "8FFB8A9D0DAEB95B006755D3BF76FF7F")
    @Override
    public void setSelection(int selectionStart, int selectionEnd) {
        String js;
        js = String.format(SET_SELECTION_SCRIPT, selectionStart, selectionEnd);
        dispatchJs(js);
        addTaint(selectionStart);
        addTaint(selectionEnd);
        // ---------- Original Method ----------
        //final String js = String.format(SET_SELECTION_SCRIPT, selectionStart, selectionEnd);
        //dispatchJs(js);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.346 -0400", hash_original_method = "3F5D408BAF5562BDB02B02A5584A2237", hash_generated_method = "86C73ADE6D1E793C21191CF66B0ECD5B")
    @Override
    public void setDimensions(int x, int y, int width, int height) {
        String js;
        js = String.format(SET_DIMENSIONS_SCRIPT, x, y, width, height);
        dispatchJs(js);
        addTaint(x);
        addTaint(y);
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
        //final String js = String.format(SET_DIMENSIONS_SCRIPT, x, y, width, height);
        //dispatchJs(js);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.346 -0400", hash_original_method = "04D618AD2022FEDF404B516FE649EE82", hash_generated_method = "6A0D1A08AB123CAE617BBBAA12C59F5F")
    @Override
    public void onchange(SearchBoxListener callback) {
        dispatchEvent(EVENT_CHANGE, callback);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //dispatchEvent(EVENT_CHANGE, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.347 -0400", hash_original_method = "68A030D65CB81232DB62B50A199680F0", hash_generated_method = "7528017EBCD59DE3D4E97BA5D0EC677E")
    @Override
    public void onsubmit(SearchBoxListener callback) {
        dispatchEvent(EVENT_SUBMIT, callback);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //dispatchEvent(EVENT_SUBMIT, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.347 -0400", hash_original_method = "D6D3A3A0D6A558E958E2068BE41C1D21", hash_generated_method = "42C9AA565BB1C8188C7A9571CBF8802A")
    @Override
    public void onresize(SearchBoxListener callback) {
        dispatchEvent(EVENT_RESIZE, callback);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //dispatchEvent(EVENT_RESIZE, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.347 -0400", hash_original_method = "4B87C4E375885BEBD3886D24C31C68DE", hash_generated_method = "6BE49ED24ED079FF8247A5C2AA30A388")
    @Override
    public void oncancel(SearchBoxListener callback) {
        dispatchEvent(EVENT_CANCEL, callback);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //dispatchEvent(EVENT_CANCEL, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.348 -0400", hash_original_method = "0E7A74EC5A809F6DFBB442DC7E16E1A0", hash_generated_method = "1FFEC087C2FDD6A40D69CB2855BEBCCE")
    private void dispatchEvent(String eventName, SearchBoxListener callback) {
        int eventId;
        {
            {
                eventId = mNextEventId++;
                mEventCallbacks.put(eventId, callback);
            } //End block
        } //End block
        {
            eventId = 0;
        } //End block
        String js;
        js = String.format(DISPATCH_EVENT_SCRIPT, eventName, eventId);
        dispatchJs(js);
        addTaint(eventName.getTaint());
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //int eventId;
        //if (callback != null) {
            //synchronized(this) {
                //eventId = mNextEventId++;
                //mEventCallbacks.put(eventId, callback);
            //}
        //} else {
            //eventId = 0;
        //}
        //final String js = String.format(DISPATCH_EVENT_SCRIPT, eventName, eventId);
        //dispatchJs(js);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.353 -0400", hash_original_method = "5370F8C01605302B1467DBB9DF339726", hash_generated_method = "6B80AB76BFBD09C0EB6D911967048C6A")
    private void dispatchJs(String js) {
        mWebViewCore.sendMessage(EventHub.EXECUTE_JS, js);
        addTaint(js.getTaint());
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.EXECUTE_JS, js);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.353 -0400", hash_original_method = "75DBA8FC630C68A524C5FD798F0853F0", hash_generated_method = "DC199F8DDCAA59D376D27AEE1FD1FCE1")
    @Override
    public void addSearchBoxListener(SearchBoxListener l) {
        {
            mListeners.add(l);
        } //End block
        addTaint(l.getTaint());
        // ---------- Original Method ----------
        //synchronized (mListeners) {
            //mListeners.add(l);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.353 -0400", hash_original_method = "A2F25B5F8B55F38BA970C737BDED0215", hash_generated_method = "28FFFFAC062CD28C80A31C5F3501071B")
    @Override
    public void removeSearchBoxListener(SearchBoxListener l) {
        {
            mListeners.remove(l);
        } //End block
        addTaint(l.getTaint());
        // ---------- Original Method ----------
        //synchronized (mListeners) {
            //mListeners.remove(l);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.494 -0400", hash_original_method = "4EF33A8B225D914A7FCB3AC708790107", hash_generated_method = "804E217B58A12B4F759DD455E2CC0413")
    @Override
    public void isSupported(IsSupportedCallback callback) {
        mSupportedCallback = callback;
        dispatchJs(IS_SUPPORTED_SCRIPT);
        // ---------- Original Method ----------
        //mSupportedCallback = callback;
        //dispatchJs(IS_SUPPORTED_SCRIPT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.494 -0400", hash_original_method = "4877F0D83188BECC4CDDDB6D5995495C", hash_generated_method = "A28C79191F6CEDF5962E819DD90B156C")
    public void isSupportedCallback(boolean isSupported) {
        mCallbackProxy.onIsSupportedCallback(isSupported);
        addTaint(isSupported);
        // ---------- Original Method ----------
        //mCallbackProxy.onIsSupportedCallback(isSupported);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.495 -0400", hash_original_method = "F0A6215B6FD6EC7F638B89101A583567", hash_generated_method = "321D530CDC81E0BE216100E8BB85E414")
    public void handleIsSupportedCallback(boolean isSupported) {
        IsSupportedCallback callback;
        callback = mSupportedCallback;
        mSupportedCallback = null;
        {
            callback.searchBoxIsSupported(isSupported);
        } //End block
        addTaint(isSupported);
        // ---------- Original Method ----------
        //IsSupportedCallback callback = mSupportedCallback;
        //mSupportedCallback = null;
        //if (callback != null) {
            //callback.searchBoxIsSupported(isSupported);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.495 -0400", hash_original_method = "1BE9DC6DEB4EE04368F068C1F3428727", hash_generated_method = "DD2E7DF1408C74C29E9123443F4225BB")
    public void dispatchCompleteCallback(String function, int id, boolean successful) {
        mCallbackProxy.onSearchboxDispatchCompleteCallback(function, id, successful);
        addTaint(function.getTaint());
        addTaint(id);
        addTaint(successful);
        // ---------- Original Method ----------
        //mCallbackProxy.onSearchboxDispatchCompleteCallback(function, id, successful);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.497 -0400", hash_original_method = "13087A2ACEC42B3D60BBA33C9A36B092", hash_generated_method = "DE3F93481BEABDD3CC0475CF10ED1BF1")
    public void handleDispatchCompleteCallback(String function, int id, boolean successful) {
        {
            SearchBoxListener listener;
            {
                listener = mEventCallbacks.get(id);
                mEventCallbacks.remove(id);
            } //End block
            {
                {
                    boolean var8A6D95D5BBCA49C99302E851E6AFD91A_1642674127 = (TextUtils.equals(EVENT_CHANGE, function));
                    {
                        listener.onChangeComplete(successful);
                    } //End block
                    {
                        boolean varB4A2A7D3F979BE1412195D701810CE38_707275166 = (TextUtils.equals(EVENT_SUBMIT, function));
                        {
                            listener.onSubmitComplete(successful);
                        } //End block
                        {
                            boolean var75BF19FF11FC20A3CA037FF8EDA616CC_240170845 = (TextUtils.equals(EVENT_RESIZE, function));
                            {
                                listener.onResizeComplete(successful);
                            } //End block
                            {
                                boolean var6F839BA8D408E6BED4250D5B5DFAD5E4_1667361965 = (TextUtils.equals(EVENT_CANCEL, function));
                                {
                                    listener.onCancelComplete(successful);
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(function.getTaint());
        addTaint(id);
        addTaint(successful);
        // ---------- Original Method ----------
        //if (id != 0) {
            //SearchBoxListener listener;
            //synchronized(this) {
                //listener = mEventCallbacks.get(id);
                //mEventCallbacks.remove(id);
            //}
            //if (listener != null) {
                //if (TextUtils.equals(EVENT_CHANGE, function)) {
                    //listener.onChangeComplete(successful);
                //} else if (TextUtils.equals(EVENT_SUBMIT, function)) {
                    //listener.onSubmitComplete(successful);
                //} else if (TextUtils.equals(EVENT_RESIZE, function)) {
                    //listener.onResizeComplete(successful);
                //} else if (TextUtils.equals(EVENT_CANCEL, function)) {
                    //listener.onCancelComplete(successful);
                //}
            //}
        //}
    }

    
        private static String jsonSerialize(String query) {
        JSONStringer stringer = new JSONStringer();
        try {
            stringer.array().value(query).endArray();
        } catch (JSONException e) {
            Log.w(TAG, "Error serializing query : " + query);
            return null;
        }
        return stringer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.511 -0400", hash_original_method = "723B81EF282859FA8736F1ECF566541C", hash_generated_method = "4B6E2B4F9BC9C6DEC6222AC4BC8CA566")
    public void setSuggestions(String jsonArguments) {
        String query;
        query = null;
        List<String> suggestions;
        suggestions = new ArrayList<String>();
        try 
        {
            JSONObject suggestionsJson;
            suggestionsJson = new JSONObject(jsonArguments);
            query = suggestionsJson.getString("query");
            JSONArray suggestionsArray;
            suggestionsArray = suggestionsJson.getJSONArray("suggestions");
            {
                int i;
                i = 0;
                boolean var7C8AF5DA666F2DD1B86E9AB79BB5F76A_424021964 = (i < suggestionsArray.length());
                {
                    JSONObject suggestion;
                    suggestion = suggestionsArray.getJSONObject(i);
                    String value;
                    value = suggestion.getString("value");
                    {
                        suggestions.add(value);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (JSONException je)
        { }
        mCallbackProxy.onSearchboxSuggestionsReceived(query, suggestions);
        addTaint(jsonArguments.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.512 -0400", hash_original_method = "8DC1A9FA12B51F46AD62CD522978A75D", hash_generated_method = "EEA3F3D739F97E2D909D131B17257AFC")
     void handleSuggestions(String query, List<String> suggestions) {
        {
            {
                int i;
                i = mListeners.size() - 1;
                {
                    mListeners.get(i).onSuggestionsReceived(query, suggestions);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(query.getTaint());
        addTaint(suggestions.getTaint());
        // ---------- Original Method ----------
        //synchronized (mListeners) {
            //for (int i = mListeners.size() - 1; i >= 0; i--) {
                //mListeners.get(i).onSuggestionsReceived(query, suggestions);
            //}
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.512 -0400", hash_original_field = "8E0CFD0BB374865E2E33B5FAC28A0F32", hash_generated_field = "B7ADD70015A3E80F96A398B95FCEDABC")

    private static String TAG = "WebKit.SearchBoxImpl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.512 -0400", hash_original_field = "436A9E755F358A0E43400108B5494B82", hash_generated_field = "A1028A9042BD62F92C031FC39BD441BA")

    static String JS_INTERFACE_NAME = "searchBoxJavaBridge_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.512 -0400", hash_original_field = "848FB0EA523D0C9D18C9D92BF5E71BB2", hash_generated_field = "6980FF7C3B8371E2C5B917515B2FF998")

    static String JS_BRIDGE = "(function()"
            + "{"
            + "if (!window.chrome) {"
            + "  window.chrome = {};"
            + "}"
            + "if (!window.chrome.searchBox) {"
            + "  var sb = window.chrome.searchBox = {};"
            + "  sb.setSuggestions = function(suggestions) {"
            + "    if (window.searchBoxJavaBridge_) {"
            + "      window.searchBoxJavaBridge_.setSuggestions(JSON.stringify(suggestions));"
            + "    }"
            + "  };"
            + "  sb.setValue = function(valueArray) { sb.value = valueArray[0]; };"
            + "  sb.value = '';"
            + "  sb.x = 0;"
            + "  sb.y = 0;"
            + "  sb.width = 0;"
            + "  sb.height = 0;"
            + "  sb.selectionStart = 0;"
            + "  sb.selectionEnd = 0;"
            + "  sb.verbatim = false;"
            + "}"
            + "})();";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.512 -0400", hash_original_field = "B782261ECDF67D2DDE62CED03995E5F9", hash_generated_field = "933693590FDCF3A90ECE341164D674D3")

    private static String SET_QUERY_SCRIPT = "if (window.chrome && window.chrome.searchBox) {"
            + "  window.chrome.searchBox.setValue(%s);"
            + "}";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.513 -0400", hash_original_field = "C4C3115CE2276890332820A42C71DBA7", hash_generated_field = "27962C3C05FA477788FE7B6635FED3FE")

    private static String SET_VERBATIM_SCRIPT = "if (window.chrome && window.chrome.searchBox) {"
            + "  window.chrome.searchBox.verbatim = %1$s;"
            + "}";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.513 -0400", hash_original_field = "FB5792162622966F509EF6E061609AA3", hash_generated_field = "653D88B00F138063270894B2A6859A9C")

    private static String SET_SELECTION_SCRIPT = "if (window.chrome && window.chrome.searchBox) {"
            + "  var f = window.chrome.searchBox;"
            + "  f.selectionStart = %d"
            + "  f.selectionEnd = %d"
            + "}";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.513 -0400", hash_original_field = "77C7FFD8AA1857AEF9F85A9FB84494CF", hash_generated_field = "431EB982CD259508DA5E0BAD971728AA")

    private static String SET_DIMENSIONS_SCRIPT = "if (window.chrome && window.chrome.searchBox) { "
            + "  var f = window.chrome.searchBox;"
            + "  f.x = %d;"
            + "  f.y = %d;"
            + "  f.width = %d;"
            + "  f.height = %d;"
            + "}";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.513 -0400", hash_original_field = "E5053DFAC38BFE9648363869A0C9036B", hash_generated_field = "AECF98F676021591AF19841F594583A4")

    private static String DISPATCH_EVENT_SCRIPT = "if (window.chrome && window.chrome.searchBox && window.chrome.searchBox.on%1$s) {"
            + "  window.chrome.searchBox.on%1$s();"
            + "  window.searchBoxJavaBridge_.dispatchCompleteCallback('%1$s', %2$d, true);"
            + "} else {"
            + "  window.searchBoxJavaBridge_.dispatchCompleteCallback('%1$s', %2$d, false);"
            + "}";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.513 -0400", hash_original_field = "520BA3C07A5A1855677994497402AA63", hash_generated_field = "9F2DC06506D292909EF92FE1ACB0A67D")

    private static String EVENT_CHANGE = "change";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.513 -0400", hash_original_field = "C5080F6BD2F7B264155F2C31DDAB3111", hash_generated_field = "30A2BC4D8187BB0365BD55FA944877D2")

    private static String EVENT_SUBMIT = "submit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.513 -0400", hash_original_field = "DCDB15FF251F136B991BEFA9883AB2C9", hash_generated_field = "D9CB23A0929223A44C1C647247738581")

    private static String EVENT_RESIZE = "resize";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.513 -0400", hash_original_field = "0664A481F696EABC129F93E92738E4DB", hash_generated_field = "10CC2ED3E6B120137BFC8ECB9D526868")

    private static String EVENT_CANCEL = "cancel";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.513 -0400", hash_original_field = "450B1F1DBC15D84DD884304978815EDC", hash_generated_field = "8D6DA4E5EF04A8765E61177195736D56")

    private static String IS_SUPPORTED_SCRIPT = "if (window.searchBoxJavaBridge_) {"
            + "  if (window.chrome && window.chrome.sv) {"
            + "    window.searchBoxJavaBridge_.isSupportedCallback(true);"
            + "  } else {"
            + "    window.searchBoxJavaBridge_.isSupportedCallback(false);"
            + "  }}";
}

