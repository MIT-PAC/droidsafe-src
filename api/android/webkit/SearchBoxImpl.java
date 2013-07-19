package android.webkit;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebViewCore.EventHub;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

final class SearchBoxImpl implements SearchBox {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.889 -0400", hash_original_field = "2F2828353527044AFD6820F84A8A1FAB", hash_generated_field = "4C7B3AD4D5F853385EAEBF459FCD952D")

    private List<SearchBoxListener> mListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.889 -0400", hash_original_field = "9371E2004CE9EC2E60E3F0EBE8ED2E84", hash_generated_field = "73DACDCC92B5BF8822959B0368CF2255")

    private WebViewCore mWebViewCore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.889 -0400", hash_original_field = "957B64C4FA99E51BCE1B62690725D115", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private CallbackProxy mCallbackProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.889 -0400", hash_original_field = "17A0B012B1F0003FA951407B6DC13CCC", hash_generated_field = "0CF205629AE05DCA51E14A224D53E502")

    private IsSupportedCallback mSupportedCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.889 -0400", hash_original_field = "BB7303575963C9B6DC3AE8895F099701", hash_generated_field = "2C672208EA2C403ED48EE8D4B7A0B99C")

    private int mNextEventId = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.890 -0400", hash_original_field = "C0478676263755B89B1EA3C7937F07B3", hash_generated_field = "D244CC115998E0D29D9A833AA1713C9D")

    private HashMap<Integer, SearchBoxListener> mEventCallbacks;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.890 -0400", hash_original_method = "BE2818047EEFAAD053C1CB5A67BA80EE", hash_generated_method = "09DFB2445AC38991E895C14A35CDD681")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.890 -0400", hash_original_method = "69D13D1B78E6CC04010F4F58CC03E4DB", hash_generated_method = "8D80AE8FCE1665C3B9139C69C02DCCDA")
    @Override
    public void setQuery(String query) {
        addTaint(query.getTaint());
        final String formattedQuery = jsonSerialize(query);
        if(formattedQuery != null)        
        {
            final String js = String.format(SET_QUERY_SCRIPT, formattedQuery);
            dispatchJs(js);
        } //End block
        // ---------- Original Method ----------
        //final String formattedQuery = jsonSerialize(query);
        //if (formattedQuery != null) {
            //final String js = String.format(SET_QUERY_SCRIPT, formattedQuery);
            //dispatchJs(js);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.890 -0400", hash_original_method = "F4645E95CEF728912C8FFD847CD99687", hash_generated_method = "198158AE2BE438D1A45A18594DDF56A1")
    @Override
    public void setVerbatim(boolean verbatim) {
        addTaint(verbatim);
        final String js = String.format(SET_VERBATIM_SCRIPT, String.valueOf(verbatim));
        dispatchJs(js);
        // ---------- Original Method ----------
        //final String js = String.format(SET_VERBATIM_SCRIPT, String.valueOf(verbatim));
        //dispatchJs(js);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.890 -0400", hash_original_method = "17AF7417B2F09AA0D0ABD8E30884C551", hash_generated_method = "1C4D168D0474C5FE38373321542118EB")
    @Override
    public void setSelection(int selectionStart, int selectionEnd) {
        addTaint(selectionEnd);
        addTaint(selectionStart);
        final String js = String.format(SET_SELECTION_SCRIPT, selectionStart, selectionEnd);
        dispatchJs(js);
        // ---------- Original Method ----------
        //final String js = String.format(SET_SELECTION_SCRIPT, selectionStart, selectionEnd);
        //dispatchJs(js);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.890 -0400", hash_original_method = "3F5D408BAF5562BDB02B02A5584A2237", hash_generated_method = "0C4A93A6A58D6F162598D4ADBA6023CE")
    @Override
    public void setDimensions(int x, int y, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        final String js = String.format(SET_DIMENSIONS_SCRIPT, x, y, width, height);
        dispatchJs(js);
        // ---------- Original Method ----------
        //final String js = String.format(SET_DIMENSIONS_SCRIPT, x, y, width, height);
        //dispatchJs(js);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.890 -0400", hash_original_method = "04D618AD2022FEDF404B516FE649EE82", hash_generated_method = "D625FF63A26847B1B1538143C30FED15")
    @Override
    public void onchange(SearchBoxListener callback) {
        addTaint(callback.getTaint());
        dispatchEvent(EVENT_CHANGE, callback);
        // ---------- Original Method ----------
        //dispatchEvent(EVENT_CHANGE, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.890 -0400", hash_original_method = "68A030D65CB81232DB62B50A199680F0", hash_generated_method = "ED1EABE985D9EEECAE81CBFB4BEAD698")
    @Override
    public void onsubmit(SearchBoxListener callback) {
        addTaint(callback.getTaint());
        dispatchEvent(EVENT_SUBMIT, callback);
        // ---------- Original Method ----------
        //dispatchEvent(EVENT_SUBMIT, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.891 -0400", hash_original_method = "D6D3A3A0D6A558E958E2068BE41C1D21", hash_generated_method = "0F0B69F932FCD2B67D43CEA21AC1F801")
    @Override
    public void onresize(SearchBoxListener callback) {
        addTaint(callback.getTaint());
        dispatchEvent(EVENT_RESIZE, callback);
        // ---------- Original Method ----------
        //dispatchEvent(EVENT_RESIZE, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.891 -0400", hash_original_method = "4B87C4E375885BEBD3886D24C31C68DE", hash_generated_method = "C4BEB694A3B94DDC583CB1576893E642")
    @Override
    public void oncancel(SearchBoxListener callback) {
        addTaint(callback.getTaint());
        dispatchEvent(EVENT_CANCEL, callback);
        // ---------- Original Method ----------
        //dispatchEvent(EVENT_CANCEL, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.891 -0400", hash_original_method = "0E7A74EC5A809F6DFBB442DC7E16E1A0", hash_generated_method = "13865A76F2C331542A3537D969ED4FCC")
    private void dispatchEvent(String eventName, SearchBoxListener callback) {
        addTaint(callback.getTaint());
        addTaint(eventName.getTaint());
        int eventId;
        if(callback != null)        
        {
            synchronized
(this)            {
                eventId = mNextEventId++;
                mEventCallbacks.put(eventId, callback);
            } //End block
        } //End block
        else
        {
            eventId = 0;
        } //End block
        final String js = String.format(DISPATCH_EVENT_SCRIPT, eventName, eventId);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.891 -0400", hash_original_method = "5370F8C01605302B1467DBB9DF339726", hash_generated_method = "37AF8CFF5863D5F32B3AE6B870433E33")
    private void dispatchJs(String js) {
        addTaint(js.getTaint());
        mWebViewCore.sendMessage(EventHub.EXECUTE_JS, js);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.EXECUTE_JS, js);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.891 -0400", hash_original_method = "75DBA8FC630C68A524C5FD798F0853F0", hash_generated_method = "15282A75FEF6C469D2B4F035A99DC2A3")
    @Override
    public void addSearchBoxListener(SearchBoxListener l) {
        addTaint(l.getTaint());
        synchronized
(mListeners)        {
            mListeners.add(l);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mListeners) {
            //mListeners.add(l);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.891 -0400", hash_original_method = "A2F25B5F8B55F38BA970C737BDED0215", hash_generated_method = "162E3ADF8238BA00CCACB397C4A5975A")
    @Override
    public void removeSearchBoxListener(SearchBoxListener l) {
        addTaint(l.getTaint());
        synchronized
(mListeners)        {
            mListeners.remove(l);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mListeners) {
            //mListeners.remove(l);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.891 -0400", hash_original_method = "4EF33A8B225D914A7FCB3AC708790107", hash_generated_method = "804E217B58A12B4F759DD455E2CC0413")
    @Override
    public void isSupported(IsSupportedCallback callback) {
        mSupportedCallback = callback;
        dispatchJs(IS_SUPPORTED_SCRIPT);
        // ---------- Original Method ----------
        //mSupportedCallback = callback;
        //dispatchJs(IS_SUPPORTED_SCRIPT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.892 -0400", hash_original_method = "4877F0D83188BECC4CDDDB6D5995495C", hash_generated_method = "1F74EFCE8B18911926F44DD045194B1D")
    public void isSupportedCallback(boolean isSupported) {
        addTaint(isSupported);
        mCallbackProxy.onIsSupportedCallback(isSupported);
        // ---------- Original Method ----------
        //mCallbackProxy.onIsSupportedCallback(isSupported);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.892 -0400", hash_original_method = "F0A6215B6FD6EC7F638B89101A583567", hash_generated_method = "37E34C7017F1F593093B9DCFF6392BF1")
    public void handleIsSupportedCallback(boolean isSupported) {
        addTaint(isSupported);
        IsSupportedCallback callback = mSupportedCallback;
        mSupportedCallback = null;
        if(callback != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.892 -0400", hash_original_method = "1BE9DC6DEB4EE04368F068C1F3428727", hash_generated_method = "A7ECBD450BE1C642A79CE31EEEDB9089")
    public void dispatchCompleteCallback(String function, int id, boolean successful) {
        addTaint(successful);
        addTaint(id);
        addTaint(function.getTaint());
        mCallbackProxy.onSearchboxDispatchCompleteCallback(function, id, successful);
        // ---------- Original Method ----------
        //mCallbackProxy.onSearchboxDispatchCompleteCallback(function, id, successful);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.892 -0400", hash_original_method = "13087A2ACEC42B3D60BBA33C9A36B092", hash_generated_method = "7E139DDB7E2326946FAA9D37D66759D9")
    public void handleDispatchCompleteCallback(String function, int id, boolean successful) {
        addTaint(successful);
        addTaint(id);
        addTaint(function.getTaint());
        if(id != 0)        
        {
            SearchBoxListener listener;
            synchronized
(this)            {
                listener = mEventCallbacks.get(id);
                mEventCallbacks.remove(id);
            } //End block
            if(listener != null)            
            {
                if(TextUtils.equals(EVENT_CHANGE, function))                
                {
                    listener.onChangeComplete(successful);
                } //End block
                else
                if(TextUtils.equals(EVENT_SUBMIT, function))                
                {
                    listener.onSubmitComplete(successful);
                } //End block
                else
                if(TextUtils.equals(EVENT_RESIZE, function))                
                {
                    listener.onResizeComplete(successful);
                } //End block
                else
                if(TextUtils.equals(EVENT_CANCEL, function))                
                {
                    listener.onCancelComplete(successful);
                } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.892 -0400", hash_original_method = "723B81EF282859FA8736F1ECF566541C", hash_generated_method = "BF9A7978F0E289A2B95F4BB206FFF11E")
    public void setSuggestions(String jsonArguments) {
        addTaint(jsonArguments.getTaint());
        if(jsonArguments == null)        
        {
            return;
        } //End block
        String query = null;
        List<String> suggestions = new ArrayList<String>();
        try 
        {
            JSONObject suggestionsJson = new JSONObject(jsonArguments);
            query = suggestionsJson.getString("query");
            final JSONArray suggestionsArray = suggestionsJson.getJSONArray("suggestions");
for(int i = 0;i < suggestionsArray.length();++i)
            {
                final JSONObject suggestion = suggestionsArray.getJSONObject(i);
                final String value = suggestion.getString("value");
                if(value != null)                
                {
                    suggestions.add(value);
                } //End block
            } //End block
        } //End block
        catch (JSONException je)
        {
            return;
        } //End block
        mCallbackProxy.onSearchboxSuggestionsReceived(query, suggestions);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.893 -0400", hash_original_method = "8DC1A9FA12B51F46AD62CD522978A75D", hash_generated_method = "99A8152D0645B75819E13189D1BCA3AD")
     void handleSuggestions(String query, List<String> suggestions) {
        addTaint(suggestions.getTaint());
        addTaint(query.getTaint());
        synchronized
(mListeners)        {
for(int i = mListeners.size() - 1;i >= 0;i--)
            {
                mListeners.get(i).onSuggestionsReceived(query, suggestions);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mListeners) {
            //for (int i = mListeners.size() - 1; i >= 0; i--) {
                //mListeners.get(i).onSuggestionsReceived(query, suggestions);
            //}
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.893 -0400", hash_original_field = "8E0CFD0BB374865E2E33B5FAC28A0F32", hash_generated_field = "819A93424AAC60BCE5306002E4BD460F")

    private static final String TAG = "WebKit.SearchBoxImpl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.893 -0400", hash_original_field = "436A9E755F358A0E43400108B5494B82", hash_generated_field = "DF56DD8704C5A8B1DA706FFE38A49BE4")

    static final String JS_INTERFACE_NAME = "searchBoxJavaBridge_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.893 -0400", hash_original_field = "848FB0EA523D0C9D18C9D92BF5E71BB2", hash_generated_field = "E4AD40B852C98FC933D90C0E6C1B89FF")

    static final String JS_BRIDGE = "(function()"
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.893 -0400", hash_original_field = "B782261ECDF67D2DDE62CED03995E5F9", hash_generated_field = "4470EB5525AD373A2C4F43799BA466F8")

    private static final String SET_QUERY_SCRIPT = "if (window.chrome && window.chrome.searchBox) {"
            + "  window.chrome.searchBox.setValue(%s);"
            + "}";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.893 -0400", hash_original_field = "C4C3115CE2276890332820A42C71DBA7", hash_generated_field = "0C5C707F45DE4F6CFD9A208D4566A0A5")

    private static final String SET_VERBATIM_SCRIPT = "if (window.chrome && window.chrome.searchBox) {"
            + "  window.chrome.searchBox.verbatim = %1$s;"
            + "}";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.893 -0400", hash_original_field = "FB5792162622966F509EF6E061609AA3", hash_generated_field = "E9B2CD13776B5B6A12E4BA5BD48197CA")

    private static final String SET_SELECTION_SCRIPT = "if (window.chrome && window.chrome.searchBox) {"
            + "  var f = window.chrome.searchBox;"
            + "  f.selectionStart = %d"
            + "  f.selectionEnd = %d"
            + "}";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.893 -0400", hash_original_field = "77C7FFD8AA1857AEF9F85A9FB84494CF", hash_generated_field = "6E66E9714562A833C543542D31083DA8")

    private static final String SET_DIMENSIONS_SCRIPT = "if (window.chrome && window.chrome.searchBox) { "
            + "  var f = window.chrome.searchBox;"
            + "  f.x = %d;"
            + "  f.y = %d;"
            + "  f.width = %d;"
            + "  f.height = %d;"
            + "}";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.893 -0400", hash_original_field = "E5053DFAC38BFE9648363869A0C9036B", hash_generated_field = "E98C117A13350ABF9CB7A23E12B72C8E")

    private static final String DISPATCH_EVENT_SCRIPT = "if (window.chrome && window.chrome.searchBox && window.chrome.searchBox.on%1$s) {"
            + "  window.chrome.searchBox.on%1$s();"
            + "  window.searchBoxJavaBridge_.dispatchCompleteCallback('%1$s', %2$d, true);"
            + "} else {"
            + "  window.searchBoxJavaBridge_.dispatchCompleteCallback('%1$s', %2$d, false);"
            + "}";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.893 -0400", hash_original_field = "520BA3C07A5A1855677994497402AA63", hash_generated_field = "B64DA4EAFE146BA5C8999FC1184F7D6A")

    private static final String EVENT_CHANGE = "change";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.893 -0400", hash_original_field = "C5080F6BD2F7B264155F2C31DDAB3111", hash_generated_field = "D7414F48B25CA14ABCD6CCDD103A43F9")

    private static final String EVENT_SUBMIT = "submit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.893 -0400", hash_original_field = "DCDB15FF251F136B991BEFA9883AB2C9", hash_generated_field = "D400DF2C0BA758C5943C5647CA02F15E")

    private static final String EVENT_RESIZE = "resize";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.893 -0400", hash_original_field = "0664A481F696EABC129F93E92738E4DB", hash_generated_field = "886A42B5C86749B3A453CB23489182F4")

    private static final String EVENT_CANCEL = "cancel";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.893 -0400", hash_original_field = "450B1F1DBC15D84DD884304978815EDC", hash_generated_field = "9ADA0EA1F1813A1825E091DB0D4474BC")

    private static final String IS_SUPPORTED_SCRIPT = "if (window.searchBoxJavaBridge_) {"
            + "  if (window.chrome && window.chrome.sv) {"
            + "    window.searchBoxJavaBridge_.isSupportedCallback(true);"
            + "  } else {"
            + "    window.searchBoxJavaBridge_.isSupportedCallback(false);"
            + "  }}";
}

