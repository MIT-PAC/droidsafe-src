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
    private List<SearchBoxListener> mListeners;
    private WebViewCore mWebViewCore;
    private CallbackProxy mCallbackProxy;
    private IsSupportedCallback mSupportedCallback;
    private int mNextEventId = 1;
    private HashMap<Integer, SearchBoxListener> mEventCallbacks;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.727 -0400", hash_original_method = "BE2818047EEFAAD053C1CB5A67BA80EE", hash_generated_method = "677635952AEB55850475F1696C13442C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SearchBoxImpl(WebViewCore webViewCore, CallbackProxy callbackProxy) {
        dsTaint.addTaint(callbackProxy.dsTaint);
        dsTaint.addTaint(webViewCore.dsTaint);
        mListeners = new ArrayList<SearchBoxListener>();
        mEventCallbacks = new HashMap<Integer, SearchBoxListener>();
        // ---------- Original Method ----------
        //mListeners = new ArrayList<SearchBoxListener>();
        //mWebViewCore = webViewCore;
        //mCallbackProxy = callbackProxy;
        //mEventCallbacks = new HashMap<Integer, SearchBoxListener>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.728 -0400", hash_original_method = "69D13D1B78E6CC04010F4F58CC03E4DB", hash_generated_method = "4F7792F970F078D392D1E9D6F95DA46E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setQuery(String query) {
        dsTaint.addTaint(query);
        String formattedQuery;
        formattedQuery = jsonSerialize(query);
        {
            String js;
            js = String.format(SET_QUERY_SCRIPT, formattedQuery);
            dispatchJs(js);
        } //End block
        // ---------- Original Method ----------
        //final String formattedQuery = jsonSerialize(query);
        //if (formattedQuery != null) {
            //final String js = String.format(SET_QUERY_SCRIPT, formattedQuery);
            //dispatchJs(js);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.729 -0400", hash_original_method = "F4645E95CEF728912C8FFD847CD99687", hash_generated_method = "E74CBBBA8A7282C47B42673F63EBCE30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setVerbatim(boolean verbatim) {
        dsTaint.addTaint(verbatim);
        String js;
        js = String.format(SET_VERBATIM_SCRIPT, String.valueOf(verbatim));
        dispatchJs(js);
        // ---------- Original Method ----------
        //final String js = String.format(SET_VERBATIM_SCRIPT, String.valueOf(verbatim));
        //dispatchJs(js);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.730 -0400", hash_original_method = "17AF7417B2F09AA0D0ABD8E30884C551", hash_generated_method = "180E72C765FDF87E57C574E0ECE867E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSelection(int selectionStart, int selectionEnd) {
        dsTaint.addTaint(selectionEnd);
        dsTaint.addTaint(selectionStart);
        String js;
        js = String.format(SET_SELECTION_SCRIPT, selectionStart, selectionEnd);
        dispatchJs(js);
        // ---------- Original Method ----------
        //final String js = String.format(SET_SELECTION_SCRIPT, selectionStart, selectionEnd);
        //dispatchJs(js);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.730 -0400", hash_original_method = "3F5D408BAF5562BDB02B02A5584A2237", hash_generated_method = "B33B6B4445B9171FEB11A170305EF66C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDimensions(int x, int y, int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        String js;
        js = String.format(SET_DIMENSIONS_SCRIPT, x, y, width, height);
        dispatchJs(js);
        // ---------- Original Method ----------
        //final String js = String.format(SET_DIMENSIONS_SCRIPT, x, y, width, height);
        //dispatchJs(js);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.730 -0400", hash_original_method = "04D618AD2022FEDF404B516FE649EE82", hash_generated_method = "CCAB23D54689F63501AD7A6A516E043C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onchange(SearchBoxListener callback) {
        dsTaint.addTaint(callback.dsTaint);
        dispatchEvent(EVENT_CHANGE, callback);
        // ---------- Original Method ----------
        //dispatchEvent(EVENT_CHANGE, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.730 -0400", hash_original_method = "68A030D65CB81232DB62B50A199680F0", hash_generated_method = "8F36F3C570FC1346847D193EAE72154B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onsubmit(SearchBoxListener callback) {
        dsTaint.addTaint(callback.dsTaint);
        dispatchEvent(EVENT_SUBMIT, callback);
        // ---------- Original Method ----------
        //dispatchEvent(EVENT_SUBMIT, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.730 -0400", hash_original_method = "D6D3A3A0D6A558E958E2068BE41C1D21", hash_generated_method = "3266CADA0B3A3AB6DEEA4F33C12BFCDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onresize(SearchBoxListener callback) {
        dsTaint.addTaint(callback.dsTaint);
        dispatchEvent(EVENT_RESIZE, callback);
        // ---------- Original Method ----------
        //dispatchEvent(EVENT_RESIZE, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.730 -0400", hash_original_method = "4B87C4E375885BEBD3886D24C31C68DE", hash_generated_method = "2D2C7D645E58B346CD1584801C18206C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void oncancel(SearchBoxListener callback) {
        dsTaint.addTaint(callback.dsTaint);
        dispatchEvent(EVENT_CANCEL, callback);
        // ---------- Original Method ----------
        //dispatchEvent(EVENT_CANCEL, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.731 -0400", hash_original_method = "0E7A74EC5A809F6DFBB442DC7E16E1A0", hash_generated_method = "B4711BDBC7114C0B09B0784F30740DE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dispatchEvent(String eventName, SearchBoxListener callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(eventName);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.731 -0400", hash_original_method = "5370F8C01605302B1467DBB9DF339726", hash_generated_method = "B66E28E9B71EE005FCA2DFD12F481150")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dispatchJs(String js) {
        dsTaint.addTaint(js);
        mWebViewCore.sendMessage(EventHub.EXECUTE_JS, js);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.EXECUTE_JS, js);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.731 -0400", hash_original_method = "75DBA8FC630C68A524C5FD798F0853F0", hash_generated_method = "273282236EE99A6CF0BB339D65CDB4DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addSearchBoxListener(SearchBoxListener l) {
        dsTaint.addTaint(l.dsTaint);
        {
            mListeners.add(l);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mListeners) {
            //mListeners.add(l);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.731 -0400", hash_original_method = "A2F25B5F8B55F38BA970C737BDED0215", hash_generated_method = "93627FEBAC1092DE53550BF0D8C31B36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void removeSearchBoxListener(SearchBoxListener l) {
        dsTaint.addTaint(l.dsTaint);
        {
            mListeners.remove(l);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mListeners) {
            //mListeners.remove(l);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.731 -0400", hash_original_method = "4EF33A8B225D914A7FCB3AC708790107", hash_generated_method = "B726773202C0FB44327F1183D7F3C068")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void isSupported(IsSupportedCallback callback) {
        dsTaint.addTaint(callback.dsTaint);
        dispatchJs(IS_SUPPORTED_SCRIPT);
        // ---------- Original Method ----------
        //mSupportedCallback = callback;
        //dispatchJs(IS_SUPPORTED_SCRIPT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.732 -0400", hash_original_method = "4877F0D83188BECC4CDDDB6D5995495C", hash_generated_method = "6DD1BA2BB7853053E37A37162158B0A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void isSupportedCallback(boolean isSupported) {
        dsTaint.addTaint(isSupported);
        mCallbackProxy.onIsSupportedCallback(isSupported);
        // ---------- Original Method ----------
        //mCallbackProxy.onIsSupportedCallback(isSupported);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.732 -0400", hash_original_method = "F0A6215B6FD6EC7F638B89101A583567", hash_generated_method = "7046520372C1EA3B5B3D3341200B3DF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleIsSupportedCallback(boolean isSupported) {
        dsTaint.addTaint(isSupported);
        IsSupportedCallback callback;
        callback = mSupportedCallback;
        mSupportedCallback = null;
        {
            callback.searchBoxIsSupported(isSupported);
        } //End block
        // ---------- Original Method ----------
        //IsSupportedCallback callback = mSupportedCallback;
        //mSupportedCallback = null;
        //if (callback != null) {
            //callback.searchBoxIsSupported(isSupported);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.732 -0400", hash_original_method = "1BE9DC6DEB4EE04368F068C1F3428727", hash_generated_method = "9303CE1877FAECE585F4478DF5390224")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchCompleteCallback(String function, int id, boolean successful) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(successful);
        dsTaint.addTaint(function);
        mCallbackProxy.onSearchboxDispatchCompleteCallback(function, id, successful);
        // ---------- Original Method ----------
        //mCallbackProxy.onSearchboxDispatchCompleteCallback(function, id, successful);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.732 -0400", hash_original_method = "13087A2ACEC42B3D60BBA33C9A36B092", hash_generated_method = "6CB3839CFAFE9516FA18E06F846E6678")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleDispatchCompleteCallback(String function, int id, boolean successful) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(successful);
        dsTaint.addTaint(function);
        {
            SearchBoxListener listener;
            {
                listener = mEventCallbacks.get(id);
                mEventCallbacks.remove(id);
            } //End block
            {
                {
                    boolean var8A6D95D5BBCA49C99302E851E6AFD91A_1998075180 = (TextUtils.equals(EVENT_CHANGE, function));
                    {
                        listener.onChangeComplete(successful);
                    } //End block
                    {
                        boolean varB4A2A7D3F979BE1412195D701810CE38_1974388532 = (TextUtils.equals(EVENT_SUBMIT, function));
                        {
                            listener.onSubmitComplete(successful);
                        } //End block
                        {
                            boolean var75BF19FF11FC20A3CA037FF8EDA616CC_989126681 = (TextUtils.equals(EVENT_RESIZE, function));
                            {
                                listener.onResizeComplete(successful);
                            } //End block
                            {
                                boolean var6F839BA8D408E6BED4250D5B5DFAD5E4_986298387 = (TextUtils.equals(EVENT_CANCEL, function));
                                {
                                    listener.onCancelComplete(successful);
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.733 -0400", hash_original_method = "723B81EF282859FA8736F1ECF566541C", hash_generated_method = "77DACC00849A7CDF65F2ADD6ACCCEB42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSuggestions(String jsonArguments) {
        dsTaint.addTaint(jsonArguments);
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
                boolean var7C8AF5DA666F2DD1B86E9AB79BB5F76A_2065469838 = (i < suggestionsArray.length());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.733 -0400", hash_original_method = "8DC1A9FA12B51F46AD62CD522978A75D", hash_generated_method = "DA7AE4F267C6E5723FD534BA78928F79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void handleSuggestions(String query, List<String> suggestions) {
        dsTaint.addTaint(query);
        dsTaint.addTaint(suggestions.dsTaint);
        {
            {
                int i;
                i = mListeners.size() - 1;
                {
                    mListeners.get(i).onSuggestionsReceived(query, suggestions);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (mListeners) {
            //for (int i = mListeners.size() - 1; i >= 0; i--) {
                //mListeners.get(i).onSuggestionsReceived(query, suggestions);
            //}
        //}
    }

    
    private static final String TAG = "WebKit.SearchBoxImpl";
    static final String JS_INTERFACE_NAME = "searchBoxJavaBridge_";
    static final String JS_BRIDGE
            = "(function()"
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
    private static final String SET_QUERY_SCRIPT
            = "if (window.chrome && window.chrome.searchBox) {"
            + "  window.chrome.searchBox.setValue(%s);"
            + "}";
    private static final String SET_VERBATIM_SCRIPT
            =  "if (window.chrome && window.chrome.searchBox) {"
            + "  window.chrome.searchBox.verbatim = %1$s;"
            + "}";
    private static final String SET_SELECTION_SCRIPT
            = "if (window.chrome && window.chrome.searchBox) {"
            + "  var f = window.chrome.searchBox;"
            + "  f.selectionStart = %d"
            + "  f.selectionEnd = %d"
            + "}";
    private static final String SET_DIMENSIONS_SCRIPT
            = "if (window.chrome && window.chrome.searchBox) { "
            + "  var f = window.chrome.searchBox;"
            + "  f.x = %d;"
            + "  f.y = %d;"
            + "  f.width = %d;"
            + "  f.height = %d;"
            + "}";
    private static final String DISPATCH_EVENT_SCRIPT
            = "if (window.chrome && window.chrome.searchBox && window.chrome.searchBox.on%1$s) {"
            + "  window.chrome.searchBox.on%1$s();"
            + "  window.searchBoxJavaBridge_.dispatchCompleteCallback('%1$s', %2$d, true);"
            + "} else {"
            + "  window.searchBoxJavaBridge_.dispatchCompleteCallback('%1$s', %2$d, false);"
            + "}";
    private static final String EVENT_CHANGE = "change";
    private static final String EVENT_SUBMIT = "submit";
    private static final String EVENT_RESIZE = "resize";
    private static final String EVENT_CANCEL = "cancel";
    private static final String IS_SUPPORTED_SCRIPT
            = "if (window.searchBoxJavaBridge_) {"
            + "  if (window.chrome && window.chrome.sv) {"
            + "    window.searchBoxJavaBridge_.isSupportedCallback(true);"
            + "  } else {"
            + "    window.searchBoxJavaBridge_.isSupportedCallback(false);"
            + "  }}";
}

