/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2011 The Android Open Source Project
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

final class SearchBoxImpl implements SearchBox {

    // This is used as a hackish alternative to javascript escaping.
    // There appears to be no such functionality in the core framework.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.673 -0500", hash_original_method = "23CD50AF565A02DDF453F7E3EB51F47E", hash_generated_method = "C15F2BA0A91192903FE989EE4437EAAD")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.406 -0500", hash_original_field = "32D5D06714ACDE4129DECE45C72B2B46", hash_generated_field = "819A93424AAC60BCE5306002E4BD460F")

    private static final String TAG = "WebKit.SearchBoxImpl";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.408 -0500", hash_original_field = "460F2C83E0D94EBC13A197248B6A9445", hash_generated_field = "DF56DD8704C5A8B1DA706FFE38A49BE4")
 static final String JS_INTERFACE_NAME = "searchBoxJavaBridge_";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.411 -0500", hash_original_field = "6B8A75BB5314681BC372633003AE2D13", hash_generated_field = "E4AD40B852C98FC933D90C0E6C1B89FF")
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.413 -0500", hash_original_field = "C8C1F163C4E69667B9C677C20039A21A", hash_generated_field = "4470EB5525AD373A2C4F43799BA466F8")

    private static final String SET_QUERY_SCRIPT
            = "if (window.chrome && window.chrome.searchBox) {"
            + "  window.chrome.searchBox.setValue(%s);"
            + "}";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.416 -0500", hash_original_field = "59A72176902BBC0D7B642BC1FCFBF0DF", hash_generated_field = "0C5C707F45DE4F6CFD9A208D4566A0A5")

    private static final String SET_VERBATIM_SCRIPT
            =  "if (window.chrome && window.chrome.searchBox) {"
            + "  window.chrome.searchBox.verbatim = %1$s;"
            + "}";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.418 -0500", hash_original_field = "5AF07DAFA5F39F33C19C5BF695B6DC45", hash_generated_field = "E9B2CD13776B5B6A12E4BA5BD48197CA")

    private static final String SET_SELECTION_SCRIPT
            = "if (window.chrome && window.chrome.searchBox) {"
            + "  var f = window.chrome.searchBox;"
            + "  f.selectionStart = %d"
            + "  f.selectionEnd = %d"
            + "}";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.420 -0500", hash_original_field = "99396ADE40CB205FEAAF3E4E44ADDF53", hash_generated_field = "6E66E9714562A833C543542D31083DA8")

    private static final String SET_DIMENSIONS_SCRIPT
            = "if (window.chrome && window.chrome.searchBox) { "
            + "  var f = window.chrome.searchBox;"
            + "  f.x = %d;"
            + "  f.y = %d;"
            + "  f.width = %d;"
            + "  f.height = %d;"
            + "}";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.422 -0500", hash_original_field = "474A53BB297CF8E768BCF7869545E416", hash_generated_field = "E98C117A13350ABF9CB7A23E12B72C8E")

    private static final String DISPATCH_EVENT_SCRIPT
            = "if (window.chrome && window.chrome.searchBox && window.chrome.searchBox.on%1$s) {"
            + "  window.chrome.searchBox.on%1$s();"
            + "  window.searchBoxJavaBridge_.dispatchCompleteCallback('%1$s', %2$d, true);"
            + "} else {"
            + "  window.searchBoxJavaBridge_.dispatchCompleteCallback('%1$s', %2$d, false);"
            + "}";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.425 -0500", hash_original_field = "15A1EF11A0348A462099CFF8DC7251E3", hash_generated_field = "B64DA4EAFE146BA5C8999FC1184F7D6A")

    private static final String EVENT_CHANGE = "change";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.428 -0500", hash_original_field = "D8DDC02A119FE0E62ADCBF73F68A9C89", hash_generated_field = "D7414F48B25CA14ABCD6CCDD103A43F9")

    private static final String EVENT_SUBMIT = "submit";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.430 -0500", hash_original_field = "5377AAD04AAFB00F76568755AEF8C209", hash_generated_field = "D400DF2C0BA758C5943C5647CA02F15E")

    private static final String EVENT_RESIZE = "resize";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.432 -0500", hash_original_field = "66E4329FD416FBF03D0F0D1047C1BE85", hash_generated_field = "886A42B5C86749B3A453CB23489182F4")

    private static final String EVENT_CANCEL = "cancel";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.435 -0500", hash_original_field = "E714B0C78BCF62E8C7E9C0673724069A", hash_generated_field = "9ADA0EA1F1813A1825E091DB0D4474BC")

    private static final String IS_SUPPORTED_SCRIPT
            = "if (window.searchBoxJavaBridge_) {"
            + "  if (window.chrome && window.chrome.sv) {"
            + "    window.searchBoxJavaBridge_.isSupportedCallback(true);"
            + "  } else {"
            + "    window.searchBoxJavaBridge_.isSupportedCallback(false);"
            + "  }}";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.437 -0500", hash_original_field = "4C0A24B9E60F3EF61165EA033E9064B1", hash_generated_field = "4C7B3AD4D5F853385EAEBF459FCD952D")

    private  List<SearchBoxListener> mListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.439 -0500", hash_original_field = "799AB033E7CD1CC92AF93A69917908BF", hash_generated_field = "73DACDCC92B5BF8822959B0368CF2255")

    private  WebViewCore mWebViewCore;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.441 -0500", hash_original_field = "C50B804397335F4C59F495D6A5AAA565", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private  CallbackProxy mCallbackProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.443 -0500", hash_original_field = "D37517739359ED03D1B1DD4CFC8B0B1D", hash_generated_field = "0CF205629AE05DCA51E14A224D53E502")

    private IsSupportedCallback mSupportedCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.446 -0500", hash_original_field = "7339AC1EA6FB5D77ECADD751023FF99E", hash_generated_field = "2C672208EA2C403ED48EE8D4B7A0B99C")

    private int mNextEventId = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.448 -0500", hash_original_field = "9A8EF44C1B186057227EC5AC89DB4122", hash_generated_field = "D244CC115998E0D29D9A833AA1713C9D")

    private  HashMap<Integer, SearchBoxListener> mEventCallbacks;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.451 -0500", hash_original_method = "BE2818047EEFAAD053C1CB5A67BA80EE", hash_generated_method = "BE2818047EEFAAD053C1CB5A67BA80EE")
    
SearchBoxImpl(WebViewCore webViewCore, CallbackProxy callbackProxy) {
        mListeners = new ArrayList<SearchBoxListener>();
        mWebViewCore = webViewCore;
        mCallbackProxy = callbackProxy;
        mEventCallbacks = new HashMap<Integer, SearchBoxListener>();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.453 -0500", hash_original_method = "69D13D1B78E6CC04010F4F58CC03E4DB", hash_generated_method = "81C235A2DB78521972CE084A700B4C41")
    
@Override
    public void setQuery(String query) {
        final String formattedQuery = jsonSerialize(query);
        if (formattedQuery != null) {
            final String js = String.format(SET_QUERY_SCRIPT, formattedQuery);
            dispatchJs(js);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.456 -0500", hash_original_method = "F4645E95CEF728912C8FFD847CD99687", hash_generated_method = "68CF22879A18CA897ECD4A616AA990BC")
    
@Override
    public void setVerbatim(boolean verbatim) {
        final String js = String.format(SET_VERBATIM_SCRIPT, String.valueOf(verbatim));
        dispatchJs(js);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.458 -0500", hash_original_method = "17AF7417B2F09AA0D0ABD8E30884C551", hash_generated_method = "A1C163D0930C34E1D3F2806274F8FC1A")
    
@Override
    public void setSelection(int selectionStart, int selectionEnd) {
        final String js = String.format(SET_SELECTION_SCRIPT, selectionStart, selectionEnd);
        dispatchJs(js);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.460 -0500", hash_original_method = "3F5D408BAF5562BDB02B02A5584A2237", hash_generated_method = "3E8775BE9D3C13926F0D278BBFD73B0D")
    
@Override
    public void setDimensions(int x, int y, int width, int height) {
        final String js = String.format(SET_DIMENSIONS_SCRIPT, x, y, width, height);
        dispatchJs(js);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.462 -0500", hash_original_method = "04D618AD2022FEDF404B516FE649EE82", hash_generated_method = "9E4DB469743B2A521FFB3FF8A2D2DFAC")
    
@Override
    public void onchange(SearchBoxListener callback) {
        dispatchEvent(EVENT_CHANGE, callback);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.464 -0500", hash_original_method = "68A030D65CB81232DB62B50A199680F0", hash_generated_method = "43E35A6FB93A644F1DFF0F4D52180F8C")
    
@Override
    public void onsubmit(SearchBoxListener callback) {
        dispatchEvent(EVENT_SUBMIT, callback);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.467 -0500", hash_original_method = "D6D3A3A0D6A558E958E2068BE41C1D21", hash_generated_method = "2E05F45C9E11EDC27D335E0A7D4ACA8F")
    
@Override
    public void onresize(SearchBoxListener callback) {
        dispatchEvent(EVENT_RESIZE, callback);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.469 -0500", hash_original_method = "4B87C4E375885BEBD3886D24C31C68DE", hash_generated_method = "A845972973BE570AAFC0C388AD089ECB")
    
@Override
    public void oncancel(SearchBoxListener callback) {
        dispatchEvent(EVENT_CANCEL, callback);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.471 -0500", hash_original_method = "0E7A74EC5A809F6DFBB442DC7E16E1A0", hash_generated_method = "1ACCD46BF3B5708BFD96F8A0CE719BD0")
    
private void dispatchEvent(String eventName, SearchBoxListener callback) {
        int eventId;
        if (callback != null) {
            synchronized(this) {
                eventId = mNextEventId++;
                mEventCallbacks.put(eventId, callback);
            }
        } else {
            eventId = 0;
        }
        final String js = String.format(DISPATCH_EVENT_SCRIPT, eventName, eventId);
        dispatchJs(js);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.473 -0500", hash_original_method = "5370F8C01605302B1467DBB9DF339726", hash_generated_method = "FC40A72B0C0D7C9C3C273E0736580532")
    
private void dispatchJs(String js) {
        mWebViewCore.sendMessage(EventHub.EXECUTE_JS, js);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.476 -0500", hash_original_method = "75DBA8FC630C68A524C5FD798F0853F0", hash_generated_method = "50897BBAA14781A28AA8C8CD63FBA5A5")
    
@Override
    public void addSearchBoxListener(SearchBoxListener l) {
        synchronized (mListeners) {
            mListeners.add(l);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.478 -0500", hash_original_method = "A2F25B5F8B55F38BA970C737BDED0215", hash_generated_method = "645B0F2B8847C80D461DFBE1B7858510")
    
@Override
    public void removeSearchBoxListener(SearchBoxListener l) {
        synchronized (mListeners) {
            mListeners.remove(l);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.480 -0500", hash_original_method = "4EF33A8B225D914A7FCB3AC708790107", hash_generated_method = "25A3ADB8F1DCD21318D570D1F0869BFC")
    
@Override
    public void isSupported(IsSupportedCallback callback) {
        mSupportedCallback = callback;
        dispatchJs(IS_SUPPORTED_SCRIPT);
    }

    // Called by Javascript through the Java bridge.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.483 -0500", hash_original_method = "4877F0D83188BECC4CDDDB6D5995495C", hash_generated_method = "8A91161FB6DBDD58F05BC5C1208A5C61")
    
public void isSupportedCallback(boolean isSupported) {
        mCallbackProxy.onIsSupportedCallback(isSupported);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.486 -0500", hash_original_method = "F0A6215B6FD6EC7F638B89101A583567", hash_generated_method = "B5D9C2F7C5021FEA032C2EE5AFDE3127")
    
public void handleIsSupportedCallback(boolean isSupported) {
        IsSupportedCallback callback = mSupportedCallback;
        mSupportedCallback = null;
        if (callback != null) {
            callback.searchBoxIsSupported(isSupported);
        }
    }

    // Called by Javascript through the Java bridge.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.488 -0500", hash_original_method = "1BE9DC6DEB4EE04368F068C1F3428727", hash_generated_method = "FF05A1E6C9696BE57E1BF6F3120C951D")
    
public void dispatchCompleteCallback(String function, int id, boolean successful) {
        mCallbackProxy.onSearchboxDispatchCompleteCallback(function, id, successful);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.670 -0500", hash_original_method = "13087A2ACEC42B3D60BBA33C9A36B092", hash_generated_method = "6D3181CBAFE32D23C1A85C9F86AB5E9A")
    
public void handleDispatchCompleteCallback(String function, int id, boolean successful) {
        if (id != 0) {
            SearchBoxListener listener;
            synchronized(this) {
                listener = mEventCallbacks.get(id);
                mEventCallbacks.remove(id);
            }
            if (listener != null) {
                if (TextUtils.equals(EVENT_CHANGE, function)) {
                    listener.onChangeComplete(successful);
                } else if (TextUtils.equals(EVENT_SUBMIT, function)) {
                    listener.onSubmitComplete(successful);
                } else if (TextUtils.equals(EVENT_RESIZE, function)) {
                    listener.onResizeComplete(successful);
                } else if (TextUtils.equals(EVENT_CANCEL, function)) {
                    listener.onCancelComplete(successful);
                }
            }
        }
    }

    // Called by Javascript through the Java bridge.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.676 -0500", hash_original_method = "723B81EF282859FA8736F1ECF566541C", hash_generated_method = "3A5D811A4151D9B9EE9FD0D730BF4738")
    
public void setSuggestions(String jsonArguments) {
        if (jsonArguments == null) {
            return;
        }

        String query = null;
        List<String> suggestions = new ArrayList<String>();
        try {
            JSONObject suggestionsJson = new JSONObject(jsonArguments);
            query = suggestionsJson.getString("query");

            final JSONArray suggestionsArray = suggestionsJson.getJSONArray("suggestions");
            for (int i = 0; i < suggestionsArray.length(); ++i) {
                final JSONObject suggestion = suggestionsArray.getJSONObject(i);
                final String value = suggestion.getString("value");
                if (value != null) {
                    suggestions.add(value);
                }
                // We currently ignore the "type" of the suggestion. This isn't
                // documented anywhere in the API documents.
                // final String type = suggestions.getString("type");
            }
        } catch (JSONException je) {
            Log.w(TAG, "Error parsing json [" + jsonArguments + "], exception = " + je);
            return;
        }

        mCallbackProxy.onSearchboxSuggestionsReceived(query, suggestions);
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.678 -0500", hash_original_method = "8DC1A9FA12B51F46AD62CD522978A75D", hash_generated_method = "8DC1A9FA12B51F46AD62CD522978A75D")
    
void handleSuggestions(String query, List<String> suggestions) {
        synchronized (mListeners) {
            for (int i = mListeners.size() - 1; i >= 0; i--) {
                mListeners.get(i).onSuggestionsReceived(query, suggestions);
            }
        }
    }
}

