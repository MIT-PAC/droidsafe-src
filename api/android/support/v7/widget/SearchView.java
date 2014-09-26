/*
 * Copyright (C) 2013 The Android Open Source Project
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

package android.support.v7.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.speech.RecognizerIntent;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.appcompat.R;
import android.support.v7.view.CollapsibleActionView;
import android.text.Editable;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import java.lang.reflect.Method;
import java.util.WeakHashMap;

import static android.support.v7.widget.SuggestionsAdapter.getColumnString;

/**
 * A widget that provides a user interface for the user to enter a search query and submit a request
 * to a search provider. Shows a list of query suggestions or results, if available, and allows the
 * user to pick a suggestion or result to launch into.
 *
 * <p class="note"><strong>Note:</strong> This class is included in the <a
 * href="{@docRoot}tools/extras/support-library.html">support library</a> for compatibility
 * with API level 7 and higher. If you're developing your app for API level 11 and higher
 * <em>only</em>, you should instead use the framework {@link android.widget.SearchView} class.</p>
 *
 * <p>
 * When the SearchView is used in an {@link android.support.v7.app.ActionBar}
 * as an action view, it's collapsed by default, so you must provide an icon for the action.
 * </p>
 * <p>
 * If you want the search field to always be visible, then call
 * {@link #setIconifiedByDefault(boolean) setIconifiedByDefault(false)}.
 * </p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about using {@code SearchView}, read the
 * <a href="{@docRoot}guide/topics/search/index.html">Search</a> API guide.
 * Additional information about action views is also available in the <<a
 * href="{@docRoot}guide/topics/ui/actionbar.html#ActionView">Action Bar</a> API guide</p>
 * </div>
 *
 * @see android.support.v4.view.MenuItemCompat#SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW
 */
public class SearchView extends LinearLayout implements CollapsibleActionView {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.311 -0400", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")


    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.315 -0400", hash_original_field = "285462A5A2F0D193A8AC4963A14D117D", hash_generated_field = "DEE7E6EBCAD52D0BE04774C5F3845528")

    private static final String LOG_TAG = "SearchView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.319 -0400", hash_original_field = "C4734236EF81A78AAB39B6B639767E8D", hash_generated_field = "7875B207C54E2B6D5ABF1652FFF3F22A")

    private static final String IME_OPTION_NO_MICROPHONE = "nm";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.408 -0400", hash_original_field = "84ABD9B5C5185B4C6C9C5D67F550C3E4", hash_generated_field = "9A0BB803E93B38C38BCD5BFB84DC1FAD")


    static final AutoCompleteTextViewReflector HIDDEN_METHOD_INVOKER = new AutoCompleteTextViewReflector();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.688 -0400", hash_original_method = "1515F3198E379060DCB8EFB4F4DD3EF3", hash_generated_method = "068CF4650A3DEA4B1C4E446DD99717AD")
                
static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.322 -0400", hash_original_field = "D71B2E306714DA8E1EF41A767F883DED", hash_generated_field = "20DE7328B76C4576C54CEA1C31A5A5DD")


    private OnQueryTextListener mOnQueryChangeListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.325 -0400", hash_original_field = "049DE66D3E82D49950E638157EA51E49", hash_generated_field = "3E6EDBFCD15829E88C823AD6BD9DA13F")

    private OnCloseListener mOnCloseListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.332 -0400", hash_original_field = "6601F107A8D1A37F0189E8B363065759", hash_generated_field = "BA3630914309DC20B34438C376A73829")

    private View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.336 -0400", hash_original_field = "A4C60A6FDF2D74F85C2F22EEE3D861DD", hash_generated_field = "8D8A066C35D08D2636C4C1260524D2BF")

    private OnSuggestionListener mOnSuggestionListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.339 -0400", hash_original_field = "BFC2F37F5F0D6EE9424797ECB999C4A8", hash_generated_field = "4CE2C18E09AA7469BBEF676CF87B216F")

    private OnClickListener mOnSearchClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.342 -0400", hash_original_field = "8C35EB60F6E37267D6E27D8228401F77", hash_generated_field = "DBB17EC605FD9389E7F62B38DE47A3A4")


    private boolean mIconifiedByDefault;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.344 -0400", hash_original_field = "03390C90FB7F945E48A21937ED57883A", hash_generated_field = "77805A492451B977E1816BA9783A9397")

    private boolean mIconified;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.347 -0400", hash_original_field = "2D560F2EF6D8A5DB488E85C52927C19F", hash_generated_field = "2E9A26C4761764604246CFEB2C060F9B")

    private CursorAdapter mSuggestionsAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.349 -0400", hash_original_field = "4B76F17A434B771375421D4498E1F275", hash_generated_field = "95F86E17693F7357E97225DE31C237B8")

    private View mSearchButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.352 -0400", hash_original_field = "CD2B8321D7DBE9ED3C675A7CEAB94533", hash_generated_field = "5B6BED2A64238CE3908B3B8A74F943A0")

    private View mSubmitButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.355 -0400", hash_original_field = "7E4809667357258106E5CE84F733E49D", hash_generated_field = "BFE96959B9AF28F7C0E58BC61493C3DB")

    private View mSearchPlate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.358 -0400", hash_original_field = "8310BF4F3C1960C585AE74B70C2DCF9E", hash_generated_field = "BC8307BFA7D8BAD259EA185F504A6263")

    private View mSubmitArea;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.361 -0400", hash_original_field = "A22152BADA7AFC5C9326BB72ADD51693", hash_generated_field = "F2F2EE3489EA7D1D3E79DE10F3C92864")

    private ImageView mCloseButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.363 -0400", hash_original_field = "89644D705D09F3026F5A346132960449", hash_generated_field = "FA2C49A395FA13278ED063933D3B9887")

    private View mSearchEditFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.366 -0400", hash_original_field = "5948F68E8F9AADF250B98C3279982B51", hash_generated_field = "008F39BAA0ECCE0EB48B634A42A71E8D")

    private View mVoiceButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.369 -0400", hash_original_field = "3E6408CFA1197295F5B30326193638BA", hash_generated_field = "2624CFC6240E328ABC658DAF35FB4ED1")

    private SearchAutoComplete mQueryTextView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.372 -0400", hash_original_field = "3CCEAF366A9381BE0BFDD9FABF1B53F9", hash_generated_field = "843247771C656AC3967CC38CD7762802")

    private View mDropDownAnchor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.375 -0400", hash_original_field = "551B8BDA6196EC6524DF687AFF25E7EE", hash_generated_field = "E9A5F2E0A5AECD994F77BB6139C386D7")

    private ImageView mSearchHintIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.377 -0400", hash_original_field = "791CF9D7B270535BEDC41F14225AD77C", hash_generated_field = "F0EDF0CA4EF3F26D48862E3A0541ACC7")

    private boolean mSubmitButtonEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.380 -0400", hash_original_field = "067000A4A3FBA63E9CB8E6EEC8B5ED99", hash_generated_field = "986A565C1B04C031BC149F5E489100AA")

    private CharSequence mQueryHint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.382 -0400", hash_original_field = "50431A8E3DAA46ACC5FE0777B49F4D0B", hash_generated_field = "E038E258E9530F2A3E67A290C3460468")

    private boolean mQueryRefinement;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.385 -0400", hash_original_field = "D5EA4EB876825FC7CCCBB7E077CC6B73", hash_generated_field = "9D126837B9B8B29E1CD350C323EA754B")

    private boolean mClearingFocus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.388 -0400", hash_original_field = "DE6F7D0025A7518849324A9E1601224A", hash_generated_field = "538F7241A30BB30063B42E9CD336B31C")

    private int mMaxWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.390 -0400", hash_original_field = "74B589D5A9137AFC0CDBF486C68561E7", hash_generated_field = "6F563F6D96E3715972347A08AA7ECEA8")

    private boolean mVoiceButtonEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.393 -0400", hash_original_field = "6388D9D1F5B77380381DA71917F00ABA", hash_generated_field = "548274ED005EA0BA1FFEE17A1050C8BD")

    private CharSequence mOldQueryText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.395 -0400", hash_original_field = "F72953951C817A3A275D7FAC7D9BDB5C", hash_generated_field = "3AEB2D2A42F37E91B98257CE593EDED2")

    private CharSequence mUserQuery;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.398 -0400", hash_original_field = "6D7E618F85AF1C222A21BC6EEBC06222", hash_generated_field = "EC81987BA3E4E312EA0C0424E31419B5")

    private boolean mExpandedInActionView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.400 -0400", hash_original_field = "69490274A566B2368DE29D49E57F783B", hash_generated_field = "1D7B31D5465A178BB6E6B80FD3070C61")

    private int mCollapsedImeOptions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.403 -0400", hash_original_field = "48D170239934FB4D79AA195112CE1340", hash_generated_field = "6F1511307A7DE5E4BDCE1D082D25D113")


    private SearchableInfo mSearchable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.405 -0400", hash_original_field = "15421EAEB4E151ECA9251D997F5C011B", hash_generated_field = "59F218E5E058390715FC276BA2A49292")

    private Bundle mAppSearchData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.416 -0400", hash_original_field = "E485A8F01C5FA92CF489DEC7697516E6", hash_generated_field = "7E064CF55E900335F94FA1E5196711A6")

    private Runnable mShowImeRunnable = new Runnable() {
        public void run() {
            InputMethodManager imm = (InputMethodManager)
                    getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

            if (imm != null) {
                HIDDEN_METHOD_INVOKER.showSoftInputUnchecked(imm, SearchView.this, 0);
            }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.422 -0400", hash_original_field = "ABBD044399DFF308E6A48CA29870A248", hash_generated_field = "26DD1A0C04DF75721BF9C984A385D525")


    private Runnable mUpdateDrawableStateRunnable = new Runnable() {
        public void run() {
            updateFocusedState();
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.428 -0400", hash_original_field = "C3F02173F568114A92276DA2E8FE583D", hash_generated_field = "AFABA5D8AB606B2E33C096BDAE201C9A")


    private Runnable mReleaseCursorRunnable = new Runnable() {
        public void run() {
            if (mSuggestionsAdapter != null && mSuggestionsAdapter instanceof SuggestionsAdapter) {
                mSuggestionsAdapter.changeCursor(null);
            }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.431 -0400", hash_original_field = "E4F65C89D480286574889D20EDDB2F1E", hash_generated_field = "72504DA1E4071FF872DD4C2D7A26922B")

    private  Intent mVoiceWebSearchIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.434 -0400", hash_original_field = "349320321140031AC947D7B95CC99F5A", hash_generated_field = "FEBA65D5D58AD1CB3F0ABB729B735300")

    private  Intent mVoiceAppSearchIntent;

    /**
     * Callbacks for changes to the query text.
     */
    public interface OnQueryTextListener {

        /**
         * Called when the user submits the query. This could be due to a key press on the
         * keyboard or due to pressing a submit button.
         * The listener can override the standard behavior by returning true
         * to indicate that it has handled the submit request. Otherwise return false to
         * let the SearchView handle the submission by launching any associated intent.
         *
         * @param query the query text that is to be submitted
         *
         * @return true if the query has been handled by the listener, false to let the
         * SearchView perform the default action.
         */
        boolean onQueryTextSubmit(String query);

        /**
         * Called when the query text is changed by the user.
         *
         * @param newText the new content of the query text field.
         *
         * @return false if the SearchView should perform the default action of showing any
         * suggestions if available, true if the action was handled by the listener.
         */
        boolean onQueryTextChange(String newText);
    }

    public interface OnCloseListener {

        /**
         * The user is attempting to close the SearchView.
         *
         * @return true if the listener wants to override the default behavior of clearing the
         * text field and dismissing it, false otherwise.
         */
        boolean onClose();
    }

    /**
     * Callback interface for selection events on suggestions. These callbacks
     * are only relevant when a SearchableInfo has been specified by {@link #setSearchableInfo}.
     */
    public interface OnSuggestionListener {

        /**
         * Called when a suggestion was selected by navigating to it.
         * @param position the absolute position in the list of suggestions.
         *
         * @return true if the listener handles the event and wants to override the default
         * behavior of possibly rewriting the query based on the selected item, false otherwise.
         */
        boolean onSuggestionSelect(int position);

        /**
         * Called when a suggestion was clicked.
         * @param position the absolute position of the clicked item in the list of suggestions.
         *
         * @return true if the listener handles the event and wants to override the default
         * behavior of launching any intent or submitting a search query specified on that item.
         * Return false otherwise.
         */
        boolean onSuggestionClick(int position);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.436 -0400", hash_original_field = "065D0F583FEAE6788D485E8109A54A30", hash_generated_field = "92AC805A05A3D1A200EE0CC098E93071")

    // more than once.
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache =
            new WeakHashMap<String, Drawable.ConstantState>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.585 -0400", hash_original_field = "2A506A8E67594D93F57922AC5B16C0AB", hash_generated_field = "FC78C71AE885D02C82BD9F2374A54A16")


    private final OnClickListener mOnClickListener = new OnClickListener() {

        public void onClick(View v) {
            if (v == mSearchButton) {
                onSearchClicked();
            } else if (v == mCloseButton) {
                onCloseClicked();
            } else if (v == mSubmitButton) {
                onSubmitQuery();
            } else if (v == mVoiceButton) {
                onVoiceClicked();
            } else if (v == mQueryTextView) {
                forceSuggestionQuery();
            }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.595 -0400", hash_original_field = "43FA389A50EF03D7566A12BBD34F10D4", hash_generated_field = "F0BAA7B10AED1597242BD6772FA801FB")

    View.OnKeyListener mTextKeyListener = new View.OnKeyListener() {
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            // guard against possible race conditions
            if (mSearchable == null) {
                return false;
            }

            if (DBG) {
                Log.d(LOG_TAG, "mTextListener.onKey(" + keyCode + "," + event + "), selection: "
                        + mQueryTextView.getListSelection());
            }

            // If a suggestion is selected, handle enter, search key, and action keys
            // as presses on the selected suggestion
            if (mQueryTextView.isPopupShowing()
                    && mQueryTextView.getListSelection() != ListView.INVALID_POSITION) {
                return onSuggestionsKey(v, keyCode, event);
            }

            // If there is text in the query box, handle enter, and action keys
            // The search key is handled by the dialog's onKeyDown().
            if (!mQueryTextView.isEmpty() && KeyEventCompat.hasNoModifiers(event)) {
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        v.cancelLongPress();

                        // Launch as a regular search.
                        launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null, mQueryTextView.getText()
                                .toString());
                        return true;
                    }
                }
            }
            return false;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.616 -0400", hash_original_field = "233059F5F43076B703D2E177C72B67B0", hash_generated_field = "6F07156C9AD9482F93C507A6F64408CC")


    private final OnEditorActionListener mOnEditorActionListener = new OnEditorActionListener() {

        /**
         * Called when the input method default action key is pressed.
         */
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            onSubmitQuery();
            return true;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.651 -0400", hash_original_field = "959489BF40BB958C75A92A19EC215207", hash_generated_field = "D787B2DF56A912011D2E520CD40860EE")


    private final OnItemClickListener mOnItemClickListener = new OnItemClickListener() {

        /**
         * Implements OnItemClickListener
         */
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (DBG) Log.d(LOG_TAG, "onItemClick() position " + position);
            onItemClicked(position, KeyEvent.KEYCODE_UNKNOWN, null);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.659 -0400", hash_original_field = "AC76BC4431BD6E1E87151319792B3314", hash_generated_field = "3228634D353F032F19BC71C0D1C6FD2A")


    private final OnItemSelectedListener mOnItemSelectedListener = new OnItemSelectedListener() {

        /**
         * Implements OnItemSelectedListener
         */
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (DBG) Log.d(LOG_TAG, "onItemSelected() position " + position);
            SearchView.this.onItemSelected(position);
        }

        /**
         * Implements OnItemSelectedListener
         */
        public void onNothingSelected(AdapterView<?> parent) {
            if (DBG)
                Log.d(LOG_TAG, "onNothingSelected()");
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.698 -0400", hash_original_field = "BBDBB7E3DF24FA45E265D0C1F6DB28ED", hash_generated_field = "9E3D5ADA526A5927900E57CAAC897875")

    private TextWatcher mTextWatcher = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int before, int after) { }

        public void onTextChanged(CharSequence s, int start,
                int before, int after) {
            SearchView.this.onTextChanged(s);
        }

        public void afterTextChanged(Editable s) {
        }
    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.450 -0400", hash_original_method = "C1ED4F339F78000C40B1DF7945901DEA", hash_generated_method = "5E808D3C82C90AF1D2E0DF44FC1C629D")
                
public SearchView(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.464 -0400", hash_original_method = "A0CCB777A0267290C19318D62048CEEA", hash_generated_method = "E4FC4684931A9A53B01B460EA3A5D42F")
                
public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.abc_search_view, this, true);

        mSearchButton = findViewById(R.id.search_button);
        mQueryTextView = (SearchAutoComplete) findViewById(R.id.search_src_text);
        mQueryTextView.setSearchView(this);

        mSearchEditFrame = findViewById(R.id.search_edit_frame);
        mSearchPlate = findViewById(R.id.search_plate);
        mSubmitArea = findViewById(R.id.submit_area);
        mSubmitButton = findViewById(R.id.search_go_btn);
        mCloseButton = (ImageView) findViewById(R.id.search_close_btn);
        mVoiceButton = findViewById(R.id.search_voice_btn);
        mSearchHintIcon = (ImageView) findViewById(R.id.search_mag_icon);

        mSearchButton.setOnClickListener(mOnClickListener);
        mCloseButton.setOnClickListener(mOnClickListener);
        mSubmitButton.setOnClickListener(mOnClickListener);
        mVoiceButton.setOnClickListener(mOnClickListener);
        mQueryTextView.setOnClickListener(mOnClickListener);

        mQueryTextView.addTextChangedListener(mTextWatcher);
        mQueryTextView.setOnEditorActionListener(mOnEditorActionListener);
        mQueryTextView.setOnItemClickListener(mOnItemClickListener);
        mQueryTextView.setOnItemSelectedListener(mOnItemSelectedListener);
        mQueryTextView.setOnKeyListener(mTextKeyListener);
        // Inform any listener of focus changes
        mQueryTextView.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (mOnQueryTextFocusChangeListener != null) {
                    mOnQueryTextFocusChangeListener.onFocusChange(SearchView.this, hasFocus);
                }
            }
        });

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SearchView, 0, 0);
        setIconifiedByDefault(a.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
        int maxWidth = a.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
        if (maxWidth != -1) {
            setMaxWidth(maxWidth);
        }
        CharSequence queryHint = a.getText(R.styleable.SearchView_queryHint);
        if (!TextUtils.isEmpty(queryHint)) {
            setQueryHint(queryHint);
        }
        int imeOptions = a.getInt(R.styleable.SearchView_android_imeOptions, -1);
        if (imeOptions != -1) {
            setImeOptions(imeOptions);
        }
        int inputType = a.getInt(R.styleable.SearchView_android_inputType, -1);
        if (inputType != -1) {
            setInputType(inputType);
        }

        a.recycle();

        boolean focusable = true;

        a = context.obtainStyledAttributes(attrs, R.styleable.View, 0, 0);
        focusable = a.getBoolean(R.styleable.View_android_focusable, focusable);
        a.recycle();
        setFocusable(focusable);

        // Save voice intent for later queries/launching
        mVoiceWebSearchIntent = new Intent(RecognizerIntent.ACTION_WEB_SEARCH);
        mVoiceWebSearchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mVoiceWebSearchIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);

        mVoiceAppSearchIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mVoiceAppSearchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        mDropDownAnchor = findViewById(mQueryTextView.getDropDownAnchor());
        if (mDropDownAnchor != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                addOnLayoutChangeListenerToDropDownAnchorSDK11();
            } else {
                addOnLayoutChangeListenerToDropDownAnchorBase();
            }
        }

        updateViewsVisibility(mIconifiedByDefault);
        updateQueryHint();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.471 -0400", hash_original_method = "46A7452C85106D0F4649C160834C88C8", hash_generated_method = "91F013C0C41501213018AADBE5AD8C33")
                
private void addOnLayoutChangeListenerToDropDownAnchorSDK11() {
        mDropDownAnchor.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom,
                    int oldLeft, int oldTop, int oldRight, int oldBottom) {
                adjustDropDownSizeAndPosition();
            }
        });
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.478 -0400", hash_original_method = "9786864648F02B4210CBE8DCA0D2F57C", hash_generated_method = "9DFE06A6B64554595A83B2D13B6C0281")
                
private void addOnLayoutChangeListenerToDropDownAnchorBase() {
        mDropDownAnchor.getViewTreeObserver()
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        adjustDropDownSizeAndPosition();
                    }
                });
    }

    /**
     * Sets the SearchableInfo for this SearchView. Properties in the SearchableInfo are used
     * to display labels, hints, suggestions, create intents for launching search results screens
     * and controlling other affordances such as a voice button.
     *
     * @param searchable a SearchableInfo can be retrieved from the SearchManager, for a specific
     * activity or a global search provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.480 -0400", hash_original_method = "D9A30BFA849ECE06409E134B6DE5C1F0", hash_generated_method = "645DBFC6428E88C8ECB5E97434D6A9CB")
                
public void setSearchableInfo(SearchableInfo searchable) {
        mSearchable = searchable;
        if (mSearchable != null) {
            updateSearchAutoComplete();
            updateQueryHint();
        }
        // Cache the voice search capability
        mVoiceButtonEnabled = hasVoiceSearch();

        if (mVoiceButtonEnabled) {
            // Disable the microphone on the keyboard, as a mic is displayed near the text box
            // TODO: use imeOptions to disable voice input when the new API will be available
            mQueryTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
        }
        updateViewsVisibility(isIconified());
    }

    /**
     * Sets the APP_DATA for legacy SearchDialog use.
     * @param appSearchData bundle provided by the app when launching the search dialog
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.483 -0400", hash_original_method = "EBA44227BB74F0B08E6F1C70EA9AD0F7", hash_generated_method = "310FAEB2EE884C76AEABC6F83B96FDCA")
                
public void setAppSearchData(Bundle appSearchData) {
        mAppSearchData = appSearchData;
    }

    /**
     * Sets the IME options on the query text field.
     *
     * @see TextView#setImeOptions(int)
     * @param imeOptions the options to set on the query text field
     *
     * @attr ref android.R.styleable#SearchView_imeOptions
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.485 -0400", hash_original_method = "A9C55FF5F962662498ECAD2C137876AF", hash_generated_method = "CD89AF8E515C0184BE23683937420891")
                
public void setImeOptions(int imeOptions) {
        mQueryTextView.setImeOptions(imeOptions);
    }

    /**
     * Returns the IME options set on the query text field.
     * @return the ime options
     * @see TextView#setImeOptions(int)
     *
     * @attr ref android.R.styleable#SearchView_imeOptions
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.487 -0400", hash_original_method = "9BD867EAFEF2C8E82AABD37C920DA81D", hash_generated_method = "86885423A6879813CEE02F12A5E9C10D")
                
public int getImeOptions() {
        return mQueryTextView.getImeOptions();
    }

    /**
     * Sets the input type on the query text field.
     *
     * @see TextView#setInputType(int)
     * @param inputType the input type to set on the query text field
     *
     * @attr ref android.R.styleable#SearchView_inputType
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.489 -0400", hash_original_method = "48CC06180C89621288EE9E924CBC5764", hash_generated_method = "346C2C21BCF3B3A413D45389660087CA")
                
public void setInputType(int inputType) {
        mQueryTextView.setInputType(inputType);
    }

    /**
     * Returns the input type set on the query text field.
     * @return the input type
     *
     * @attr ref android.R.styleable#SearchView_inputType
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.492 -0400", hash_original_method = "BE1EDC4AE4E3B9AB4BA408F44C171D6C", hash_generated_method = "A8EA5B4B2DDEF6C22C8249B352532439")
                
public int getInputType() {
        return mQueryTextView.getInputType();
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.498 -0400", hash_original_method = "83E343EB647417E47B475AFEA392BC7D", hash_generated_method = "1761412290BB35D10E0439D748A4962E")
                
@Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        // Don't accept focus if in the middle of clearing focus
        if (mClearingFocus) return false;
        // Check if SearchView is focusable.
        if (!isFocusable()) return false;
        // If it is not iconified, then give the focus to the text field
        if (!isIconified()) {
            boolean result = mQueryTextView.requestFocus(direction, previouslyFocusedRect);
            if (result) {
                updateViewsVisibility(false);
            }
            return result;
        } else {
            return super.requestFocus(direction, previouslyFocusedRect);
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.501 -0400", hash_original_method = "65B369A9FAEBC12EA58ACD6F427C9883", hash_generated_method = "63FBD5DD240AAA1F7E25DA4F6E31636B")
                
@Override
    public void clearFocus() {
        mClearingFocus = true;
        setImeVisibility(false);
        super.clearFocus();
        mQueryTextView.clearFocus();
        mClearingFocus = false;
    }

    /**
     * Sets a listener for user actions within the SearchView.
     *
     * @param listener the listener object that receives callbacks when the user performs
     * actions in the SearchView such as clicking on buttons or typing a query.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.503 -0400", hash_original_method = "5F51E4234BD6E41AFB4ED2E85F8CC1A5", hash_generated_method = "F731C6D2D30300297FC406B8FA6ABD04")
                
public void setOnQueryTextListener(OnQueryTextListener listener) {
        mOnQueryChangeListener = listener;
    }

    /**
     * Sets a listener to inform when the user closes the SearchView.
     *
     * @param listener the listener to call when the user closes the SearchView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.506 -0400", hash_original_method = "5C0B64E237CFC180C92A60294DA35470", hash_generated_method = "A1E5647D03EE3F8EEDCB1074B1734E38")
                
public void setOnCloseListener(OnCloseListener listener) {
        mOnCloseListener = listener;
    }

    /**
     * Sets a listener to inform when the focus of the query text field changes.
     *
     * @param listener the listener to inform of focus changes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.508 -0400", hash_original_method = "2E189EEDC80EC67610C89143836C4DBB", hash_generated_method = "0EA58FC48A5D9D8D979AA20C6545B62B")
                
public void setOnQueryTextFocusChangeListener(OnFocusChangeListener listener) {
        mOnQueryTextFocusChangeListener = listener;
    }

    /**
     * Sets a listener to inform when a suggestion is focused or clicked.
     *
     * @param listener the listener to inform of suggestion selection events.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.510 -0400", hash_original_method = "5242CF20D6A154AA5BAD996C3A14A890", hash_generated_method = "85A5B72DC2BB7473FFED56F694357D7C")
                
public void setOnSuggestionListener(OnSuggestionListener listener) {
        mOnSuggestionListener = listener;
    }

    /**
     * Sets a listener to inform when the search button is pressed. This is only
     * relevant when the text field is not visible by default. Calling {@link #setIconified
     * setIconified(false)} can also cause this listener to be informed.
     *
     * @param listener the listener to inform when the search button is clicked or
     * the text field is programmatically de-iconified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.512 -0400", hash_original_method = "AFFD80E7D30CC6B8E84DA9D0AC11DA43", hash_generated_method = "6929C53F98015CCBDE8E8E7C150A004B")
                
public void setOnSearchClickListener(OnClickListener listener) {
        mOnSearchClickListener = listener;
    }

    /**
     * Returns the query string currently in the text field.
     *
     * @return the query string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.515 -0400", hash_original_method = "BDCF19F1BD9841AC2C41BDBA087D55A0", hash_generated_method = "6AB3F6E16C358175AE4C893210CE3A7A")
                
public CharSequence getQuery() {
        return mQueryTextView.getText();
    }

    /**
     * Sets a query string in the text field and optionally submits the query as well.
     *
     * @param query the query string. This replaces any query text already present in the
     * text field.
     * @param submit whether to submit the query right now or only update the contents of
     * text field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.517 -0400", hash_original_method = "5A003F43910A9D1575D33030D363451B", hash_generated_method = "AF0B00D82064BDC024C095E543F65AA8")
                
public void setQuery(CharSequence query, boolean submit) {
        mQueryTextView.setText(query);
        if (query != null) {
            mQueryTextView.setSelection(mQueryTextView.length());
            mUserQuery = query;
        }

        // If the query is not empty and submit is requested, submit the query
        if (submit && !TextUtils.isEmpty(query)) {
            onSubmitQuery();
        }
    }

    /**
     * Sets the hint text to display in the query text field. This overrides any hint specified
     * in the SearchableInfo.
     *
     * @param hint the hint text to display
     *
     * @attr ref android.R.styleable#SearchView_queryHint
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.522 -0400", hash_original_method = "E72A59E6C313C94D91D305DFD6AC06A2", hash_generated_method = "A6C99F300FD2422A675F2D7AC022816F")
                
public void setQueryHint(CharSequence hint) {
        mQueryHint = hint;
        updateQueryHint();
    }

    /**
     * Gets the hint text to display in the query text field.
     * @return the query hint text, if specified, null otherwise.
     *
     * @attr ref android.R.styleable#SearchView_queryHint
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.524 -0400", hash_original_method = "447395ADF27FDA41A2F76699B67B870D", hash_generated_method = "77FD312F5C2E598C4EBD93B2C74672F6")
                
public CharSequence getQueryHint() {
        if (mQueryHint != null) {
            return mQueryHint;
        } else if (mSearchable != null) {
            CharSequence hint = null;
            int hintId = mSearchable.getHintId();
            if (hintId != 0) {
                hint = getContext().getString(hintId);
            }
            return hint;
        }
        return null;
    }

    /**
     * Sets the default or resting state of the search field. If true, a single search icon is
     * shown by default and expands to show the text field and other buttons when pressed. Also,
     * if the default state is iconified, then it collapses to that state when the close button
     * is pressed. Changes to this property will take effect immediately.
     *
     * <p>The default value is true.</p>
     *
     * @param iconified whether the search field should be iconified by default
     *
     * @attr ref android.R.styleable#SearchView_iconifiedByDefault
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.527 -0400", hash_original_method = "ACA6D63CA1F64B4CD762BEE0367B8A15", hash_generated_method = "37460F3A41A1EEC6E2E27D431FF93FA6")
                
public void setIconifiedByDefault(boolean iconified) {
        if (mIconifiedByDefault == iconified) return;
        mIconifiedByDefault = iconified;
        updateViewsVisibility(iconified);
        updateQueryHint();
    }

    /**
     * Returns the default iconified state of the search field.
     * @return
     *
     * @attr ref android.R.styleable#SearchView_iconifiedByDefault
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.529 -0400", hash_original_method = "B0C72E24DA4703D19B476F7F5669A367", hash_generated_method = "59FB4606BFD94C63A1AF9141ED9ACF1C")
                
public boolean isIconfiedByDefault() {
        return mIconifiedByDefault;
    }

    /**
     * Iconifies or expands the SearchView. Any query text is cleared when iconified. This is
     * a temporary state and does not override the default iconified state set by
     * {@link #setIconifiedByDefault(boolean)}. If the default state is iconified, then
     * a false here will only be valid until the user closes the field. And if the default
     * state is expanded, then a true here will only clear the text field and not close it.
     *
     * @param iconify a true value will collapse the SearchView to an icon, while a false will
     * expand it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.531 -0400", hash_original_method = "1D615B467973354655EE36C4E6E1B780", hash_generated_method = "C09A92E6147C8CBBBE9D074799B9E1A8")
                
public void setIconified(boolean iconify) {
        if (iconify) {
            onCloseClicked();
        } else {
            onSearchClicked();
        }
    }

    /**
     * Returns the current iconified state of the SearchView.
     *
     * @return true if the SearchView is currently iconified, false if the search field is
     * fully visible.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.533 -0400", hash_original_method = "844ED2B05054700D6A1A7C47A43DB3F5", hash_generated_method = "3685A368962CA6F1123C758E5F5A80B4")
                
public boolean isIconified() {
        return mIconified;
    }

    /**
     * Enables showing a submit button when the query is non-empty. In cases where the SearchView
     * is being used to filter the contents of the current activity and doesn't launch a separate
     * results activity, then the submit button should be disabled.
     *
     * @param enabled true to show a submit button for submitting queries, false if a submit
     * button is not required.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.535 -0400", hash_original_method = "3C1CA8493C58EB873C43522E7F5B066C", hash_generated_method = "62F6D438D9FC3DF5B9250D19DB86393F")
                
public void setSubmitButtonEnabled(boolean enabled) {
        mSubmitButtonEnabled = enabled;
        updateViewsVisibility(isIconified());
    }

    /**
     * Returns whether the submit button is enabled when necessary or never displayed.
     *
     * @return whether the submit button is enabled automatically when necessary
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.537 -0400", hash_original_method = "A8CFD3302CC6C1FBD45FF4B867C72D5B", hash_generated_method = "15D691DC348FF7CF2F97A6CFE98C0D36")
                
public boolean isSubmitButtonEnabled() {
        return mSubmitButtonEnabled;
    }

    /**
     * Specifies if a query refinement button should be displayed alongside each suggestion
     * or if it should depend on the flags set in the individual items retrieved from the
     * suggestions provider. Clicking on the query refinement button will replace the text
     * in the query text field with the text from the suggestion. This flag only takes effect
     * if a SearchableInfo has been specified with {@link #setSearchableInfo(SearchableInfo)}
     * and not when using a custom adapter.
     *
     * @param enable true if all items should have a query refinement button, false if only
     * those items that have a query refinement flag set should have the button.
     *
     * @see SearchManager#SUGGEST_COLUMN_FLAGS
     * @see SearchManager#FLAG_QUERY_REFINEMENT
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.540 -0400", hash_original_method = "29051F8E555BD7A9218D5240E768869F", hash_generated_method = "FA290228C60F39E8CD705DE61626A847")
                
public void setQueryRefinementEnabled(boolean enable) {
        mQueryRefinement = enable;
        if (mSuggestionsAdapter instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) mSuggestionsAdapter).setQueryRefinement(
                    enable ? SuggestionsAdapter.REFINE_ALL : SuggestionsAdapter.REFINE_BY_ENTRY);
        }
    }

    /**
     * Returns whether query refinement is enabled for all items or only specific ones.
     * @return true if enabled for all items, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.542 -0400", hash_original_method = "A374A24A58636548BF0B2ADA0B696601", hash_generated_method = "8CB506AF9702E3CC4D45FBBD6AA96696")
                
public boolean isQueryRefinementEnabled() {
        return mQueryRefinement;
    }

    /**
     * You can set a custom adapter if you wish. Otherwise the default adapter is used to
     * display the suggestions from the suggestions provider associated with the SearchableInfo.
     *
     * @see #setSearchableInfo(SearchableInfo)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.544 -0400", hash_original_method = "23DC9EA74A588F20B69495720EC7B1A3", hash_generated_method = "EAF523923DE2DC5C33F8163068A192C3")
                
public void setSuggestionsAdapter(CursorAdapter adapter) {
        mSuggestionsAdapter = adapter;

        mQueryTextView.setAdapter(mSuggestionsAdapter);
    }

    /**
     * Returns the adapter used for suggestions, if any.
     * @return the suggestions adapter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.546 -0400", hash_original_method = "D43CFDAE734651DCDEBEEE22CB7FB2A7", hash_generated_method = "AA1D3A38C42022ACB4D7A2264775BA6D")
                
public CursorAdapter getSuggestionsAdapter() {
        return mSuggestionsAdapter;
    }

    /**
     * Makes the view at most this many pixels wide
     *
     * @attr ref android.R.styleable#SearchView_maxWidth
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.548 -0400", hash_original_method = "8FF296A57B18752E84CEF7286CDC8903", hash_generated_method = "35898894372962CF4B39196DCA943707")
                
public void setMaxWidth(int maxpixels) {
        mMaxWidth = maxpixels;

        requestLayout();
    }

    /**
     * Gets the specified maximum width in pixels, if set. Returns zero if
     * no maximum width was specified.
     * @return the maximum width of the view
     *
     * @attr ref android.R.styleable#SearchView_maxWidth
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.550 -0400", hash_original_method = "76706798F49D12B3284BCD11A87CAB2A", hash_generated_method = "20AE422C6C3600ED5C08982C78A986AB")
                
public int getMaxWidth() {
        return mMaxWidth;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.553 -0400", hash_original_method = "455591DBA8980F8F128C9C99FA0F791A", hash_generated_method = "C04B9D8722CAA0D6B8C17D9F254771AE")
                
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Let the standard measurements take effect in iconified state.
        if (isIconified()) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);

        switch (widthMode) {
            case MeasureSpec.AT_MOST:
                // If there is an upper limit, don't exceed maximum width (explicit or implicit)
                if (mMaxWidth > 0) {
                    width = Math.min(mMaxWidth, width);
                } else {
                    width = Math.min(getPreferredWidth(), width);
                }
                break;
            case MeasureSpec.EXACTLY:
                // If an exact width is specified, still don't exceed any specified maximum width
                if (mMaxWidth > 0) {
                    width = Math.min(mMaxWidth, width);
                }
                break;
            case MeasureSpec.UNSPECIFIED:
                // Use maximum width, if specified, else preferred width
                width = mMaxWidth > 0 ? mMaxWidth : getPreferredWidth();
                break;
        }
        widthMode = MeasureSpec.EXACTLY;
        super.onMeasure(MeasureSpec.makeMeasureSpec(width, widthMode), heightMeasureSpec);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.555 -0400", hash_original_method = "A382CB5B23A797D1354D3CFF9420A6EA", hash_generated_method = "5771CE8D7B28EB091BE1057EFBDBD24F")
                
private int getPreferredWidth() {
        return getContext().getResources()
                .getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.558 -0400", hash_original_method = "7F3DE149B8C5E14764DBC69CC4EE105A", hash_generated_method = "1196652786F5812346058BF26B05A7CA")
                
private void updateViewsVisibility(final boolean collapsed) {
        mIconified = collapsed;
        // Visibility of views that are visible when collapsed
        final int visCollapsed = collapsed ? VISIBLE : GONE;
        // Is there text in the query
        final boolean hasText = !TextUtils.isEmpty(mQueryTextView.getText());

        mSearchButton.setVisibility(visCollapsed);
        updateSubmitButton(hasText);
        mSearchEditFrame.setVisibility(collapsed ? GONE : VISIBLE);
        mSearchHintIcon.setVisibility(mIconifiedByDefault ? GONE : VISIBLE);
        updateCloseButton();
        updateVoiceButton(!hasText);
        updateSubmitArea();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.560 -0400", hash_original_method = "1F6B21487B2FA81D5679515DB4F108DF", hash_generated_method = "1BB2BF66E14BCD3AE44340217B36AD5B")
                
private boolean hasVoiceSearch() {
        if (mSearchable != null && mSearchable.getVoiceSearchEnabled()) {
            Intent testIntent = null;
            if (mSearchable.getVoiceSearchLaunchWebSearch()) {
                testIntent = mVoiceWebSearchIntent;
            } else if (mSearchable.getVoiceSearchLaunchRecognizer()) {
                testIntent = mVoiceAppSearchIntent;
            }
            if (testIntent != null) {
                ResolveInfo ri = getContext().getPackageManager().resolveActivity(testIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                return ri != null;
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.562 -0400", hash_original_method = "E98BAF533B4581CBC109A603E4339AE5", hash_generated_method = "AD23F41A7E00EA85995BEB5AD85CBAC4")
                
private boolean isSubmitAreaEnabled() {
        return (mSubmitButtonEnabled || mVoiceButtonEnabled) && !isIconified();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.564 -0400", hash_original_method = "956EC0D217930FCBDABBCC447139885F", hash_generated_method = "73529CCDE2A6E9981D3FEBF7D75D0B13")
                
private void updateSubmitButton(boolean hasText) {
        int visibility = GONE;
        if (mSubmitButtonEnabled && isSubmitAreaEnabled() && hasFocus()
                && (hasText || !mVoiceButtonEnabled)) {
            visibility = VISIBLE;
        }
        mSubmitButton.setVisibility(visibility);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.567 -0400", hash_original_method = "FF9871F833F63C36B3921C4F59B0ED2F", hash_generated_method = "1B38B8A2A8BAB3CCCB5E4A3FD23CF235")
                
private void updateSubmitArea() {
        int visibility = GONE;
        if (isSubmitAreaEnabled()
                && (mSubmitButton.getVisibility() == VISIBLE
                || mVoiceButton.getVisibility() == VISIBLE)) {
            visibility = VISIBLE;
        }
        mSubmitArea.setVisibility(visibility);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.569 -0400", hash_original_method = "31438C0932D7B883B0B6F7C1A8D11C73", hash_generated_method = "5944F95480569FD75D5F773EF6D2938F")
                
private void updateCloseButton() {
        final boolean hasText = !TextUtils.isEmpty(mQueryTextView.getText());
        // Should we show the close button? It is not shown if there's no focus,
        // field is not iconified by default and there is no text in it.
        final boolean showClose = hasText || (mIconifiedByDefault && !mExpandedInActionView);
        mCloseButton.setVisibility(showClose ? VISIBLE : GONE);
        mCloseButton.getDrawable().setState(hasText ? ENABLED_STATE_SET : EMPTY_STATE_SET);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.571 -0400", hash_original_method = "A19187F7BD510E54AC677DCF71153712", hash_generated_method = "AD57BDCA7E253262647EAEFB8A94D7E2")
                
private void postUpdateFocusedState() {
        post(mUpdateDrawableStateRunnable);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.573 -0400", hash_original_method = "2FABE728CB7CDC63DD618939E6086EE5", hash_generated_method = "C1E3D4F2A6D6D989B4BA04D8A52BC794")
                
private void updateFocusedState() {
        boolean focused = mQueryTextView.hasFocus();
        mSearchPlate.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        mSubmitArea.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        invalidate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.575 -0400", hash_original_method = "466B44C18A399269336D5B13075B3DD5", hash_generated_method = "E87FADC23B2C7E10E4785C8106E6563D")
                
@Override
    protected void onDetachedFromWindow() {
        removeCallbacks(mUpdateDrawableStateRunnable);
        post(mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.577 -0400", hash_original_method = "10C83777364EAA061E75B08DB527338D", hash_generated_method = "13EC671B668FDD461062FA3FC7A304D2")
                
private void setImeVisibility(final boolean visible) {
        if (visible) {
            post(mShowImeRunnable);
        } else {
            removeCallbacks(mShowImeRunnable);
            InputMethodManager imm = (InputMethodManager)
                    getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

            if (imm != null) {
                imm.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        }
    }

    /**
     * Called by the SuggestionsAdapter
     * @hide
     */
    /* package */@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.580 -0400", hash_original_method = "364D10214479FA13BFF6BDB192F3E0CD", hash_generated_method = "364D10214479FA13BFF6BDB192F3E0CD")
                
void onQueryRefine(CharSequence queryText) {
        setQuery(queryText);
    }

    /**
     * Handles the key down event for dealing with action keys.
     *
     * @param keyCode This is the keycode of the typed key, and is the same value as
     *        found in the KeyEvent parameter.
     * @param event The complete event record for the typed key
     *
     * @return true if the event was handled here, or false if not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.588 -0400", hash_original_method = "FC84E4A8BF0E09073CCD70635A812333", hash_generated_method = "BF5EA9E7A15462E00E7029C2C6C6D36E")
                
@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mSearchable == null) {
            return false;
        }

        return super.onKeyDown(keyCode, event);
    }

    /**
     * React to the user typing while in the suggestions list. First, check for
     * action keys. If not handled, try refocusing regular characters into the
     * EditText.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.598 -0400", hash_original_method = "46431FBFEF9551A6D8E8837913415000", hash_generated_method = "B20B377478F75480AD1EA0BA6BD2E5D8")
                
private boolean onSuggestionsKey(View v, int keyCode, KeyEvent event) {
        // guard against possible race conditions (late arrival after dismiss)
        if (mSearchable == null) {
            return false;
        }
        if (mSuggestionsAdapter == null) {
            return false;
        }
        if (event.getAction() == KeyEvent.ACTION_DOWN && KeyEventCompat.hasNoModifiers(event)) {
            // First, check for enter or search (both of which we'll treat as a
            // "click")
            if (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_SEARCH
                    || keyCode == KeyEvent.KEYCODE_TAB) {
                int position = mQueryTextView.getListSelection();
                return onItemClicked(position, KeyEvent.KEYCODE_UNKNOWN, null);
            }

            // Next, check for left/right moves, which we use to "return" the
            // user to the edit view
            if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT || keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
                // give "focus" to text editor, with cursor at the beginning if
                // left key, at end if right key
                int selPoint = (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) ? 0 : mQueryTextView
                        .length();
                mQueryTextView.setSelection(selPoint);
                mQueryTextView.setListSelection(0);
                mQueryTextView.clearListSelection();
                HIDDEN_METHOD_INVOKER.ensureImeVisible(mQueryTextView, true);

                return true;
            }

            // Next, check for an "up and out" move
            if (keyCode == KeyEvent.KEYCODE_DPAD_UP && 0 == mQueryTextView.getListSelection()) {
                // TODO: restoreUserQuery();
                // let ACTV complete the move
                return false;
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.600 -0400", hash_original_method = "91811970C9F8C86EE5433C59C9AF7DFD", hash_generated_method = "56B62EAD89A0427F348F8FD4E0E7675C")
                
private int getSearchIconId() {
        TypedValue outValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.searchViewSearchIcon, outValue, true);
        return outValue.resourceId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.603 -0400", hash_original_method = "BEC25B8B383259674E4804BA5A8143D3", hash_generated_method = "44066A10F8E9500F3FAB028F54FF591C")
                
private CharSequence getDecoratedHint(CharSequence hintText) {
        // If the field is always expanded, then don't add the search icon to the hint
        if (!mIconifiedByDefault) return hintText;

        SpannableStringBuilder ssb = new SpannableStringBuilder("   "); // for the icon
        ssb.append(hintText);
        Drawable searchIcon = getContext().getResources().getDrawable(getSearchIconId());
        int textSize = (int) (mQueryTextView.getTextSize() * 1.25);
        searchIcon.setBounds(0, 0, textSize, textSize);
        ssb.setSpan(new ImageSpan(searchIcon), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.605 -0400", hash_original_method = "86FF55CF6755F81D1B5EAA7CA81FA50B", hash_generated_method = "92448411192D34826A399651377BD42A")
                
private void updateQueryHint() {
        if (mQueryHint != null) {
            mQueryTextView.setHint(getDecoratedHint(mQueryHint));
        } else if (mSearchable != null) {
            CharSequence hint = null;
            int hintId = mSearchable.getHintId();
            if (hintId != 0) {
                hint = getContext().getString(hintId);
            }
            if (hint != null) {
                mQueryTextView.setHint(getDecoratedHint(hint));
            }
        } else {
            mQueryTextView.setHint(getDecoratedHint(""));
        }
    }

    /**
     * Updates the auto-complete text view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.608 -0400", hash_original_method = "2738F80C50C0F9505AEBBB0DF2ACB0FD", hash_generated_method = "A9673426F6DC0CC80584FEA05F9F4914")
                
private void updateSearchAutoComplete() {
        mQueryTextView.setThreshold(mSearchable.getSuggestThreshold());
        mQueryTextView.setImeOptions(mSearchable.getImeOptions());
        int inputType = mSearchable.getInputType();
        // We only touch this if the input type is set up for text (which it almost certainly
        // should be, in the case of search!)
        if ((inputType & InputType.TYPE_MASK_CLASS) == InputType.TYPE_CLASS_TEXT) {
            // The existence of a suggestions authority is the proxy for "suggestions
            // are available here"
            inputType &= ~InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
            if (mSearchable.getSuggestAuthority() != null) {
                inputType |= InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
                // TYPE_TEXT_FLAG_AUTO_COMPLETE means that the text editor is performing
                // auto-completion based on its own semantics, which it will present to the user
                // as they type. This generally means that the input method should not show its
                // own candidates, and the spell checker should not be in action. The text editor
                // supplies its candidates by calling InputMethodManager.displayCompletions(),
                // which in turn will call InputMethodSession.displayCompletions().
                inputType |= InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS;
            }
        }
        mQueryTextView.setInputType(inputType);
        if (mSuggestionsAdapter != null) {
            mSuggestionsAdapter.changeCursor(null);
        }
      /*  // attach the suggestions adapter, if suggestions are available
        // The existence of a suggestions authority is the proxy for "suggestions available here"
        if (mSearchable.getSuggestAuthority() != null) {
            mSuggestionsAdapter = new SuggestionsAdapter(getContext(),
                    this, mSearchable, null);
            
            mQueryTextView.setAdapter(mSuggestionsAdapter);
            ((SuggestionsAdapter) mSuggestionsAdapter).setQueryRefinement(
                    mQueryRefinement ? SuggestionsAdapter.REFINE_ALL
                            : SuggestionsAdapter.REFINE_BY_ENTRY);
        }*/
    }

    /**
     * Update the visibility of the voice button.  There are actually two voice search modes,
     * either of which will activate the button.
     * @param empty whether the search query text field is empty. If it is, then the other
     * criteria apply to make the voice button visible.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.611 -0400", hash_original_method = "3C9F3ABEF9459DE6C607B751B6CB866E", hash_generated_method = "1FD85F4CFDE1CDE27B49BF424218A660")
                
private void updateVoiceButton(boolean empty) {
        int visibility = GONE;
        if (mVoiceButtonEnabled && !isIconified() && empty) {
            visibility = VISIBLE;
            mSubmitButton.setVisibility(GONE);
        }
        mVoiceButton.setVisibility(visibility);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.618 -0400", hash_original_method = "1411F54CFFACC3FC33F099091662F124", hash_generated_method = "3C397B31E83B8A3D9C285FE1141EDC6C")
                
private void onTextChanged(CharSequence newText) {
        CharSequence text = mQueryTextView.getText();
        mUserQuery = text;
        boolean hasText = !TextUtils.isEmpty(text);
        updateSubmitButton(hasText);
        updateVoiceButton(!hasText);
        updateCloseButton();
        updateSubmitArea();
        if (mOnQueryChangeListener != null && !TextUtils.equals(newText, mOldQueryText)) {
            mOnQueryChangeListener.onQueryTextChange(newText.toString());
        }
        mOldQueryText = newText.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.620 -0400", hash_original_method = "5AEA0BD14CD513B7E21145454A43DADF", hash_generated_method = "A414A69964DB2EDDD93A5DD5422F8F53")
                
private void onSubmitQuery() {
        CharSequence query = mQueryTextView.getText();
        if (query != null && TextUtils.getTrimmedLength(query) > 0) {
            if (mOnQueryChangeListener == null
                    || !mOnQueryChangeListener.onQueryTextSubmit(query.toString())) {
                if (mSearchable != null) {
                    launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null, query.toString());
                    setImeVisibility(false);
                }
                dismissSuggestions();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.622 -0400", hash_original_method = "8D9A2C9AF67AD5F3EB2818A3F7453E73", hash_generated_method = "F96111D7026ABAE36329B7CFE45D22EB")
                
private void dismissSuggestions() {
        mQueryTextView.dismissDropDown();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.625 -0400", hash_original_method = "E1C21CB17E5E6548A25ED1EEE1C98C9D", hash_generated_method = "0C53F7B2978BD459719E403313087410")
                
private void onCloseClicked() {
        CharSequence text = mQueryTextView.getText();
        if (TextUtils.isEmpty(text)) {
            if (mIconifiedByDefault) {
                // If the app doesn't override the close behavior
                if (mOnCloseListener == null || !mOnCloseListener.onClose()) {
                    // hide the keyboard and remove focus
                    clearFocus();
                    // collapse the search field
                    updateViewsVisibility(true);
                }
            }
        } else {
            mQueryTextView.setText("");
            mQueryTextView.requestFocus();
            setImeVisibility(true);
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.627 -0400", hash_original_method = "4C174341C531719A99E642D8022F787E", hash_generated_method = "D65670BA560AE783A84167E5E8E45789")
                
private void onSearchClicked() {
        updateViewsVisibility(false);
        mQueryTextView.requestFocus();
        setImeVisibility(true);
        if (mOnSearchClickListener != null) {
            mOnSearchClickListener.onClick(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.629 -0400", hash_original_method = "5B2168D9C175988BD80847D561C5C5CC", hash_generated_method = "AAF32B7AB04CF54D05C73A4D63265109")
                
private void onVoiceClicked() {
        // guard against possible race conditions
        if (mSearchable == null) {
            return;
        }
        SearchableInfo searchable = mSearchable;
        try {
            if (searchable.getVoiceSearchLaunchWebSearch()) {
                Intent webSearchIntent = createVoiceWebSearchIntent(mVoiceWebSearchIntent,
                        searchable);
                getContext().startActivity(webSearchIntent);
            } else if (searchable.getVoiceSearchLaunchRecognizer()) {
                Intent appSearchIntent = createVoiceAppSearchIntent(mVoiceAppSearchIntent,
                        searchable);
                getContext().startActivity(appSearchIntent);
            }
        } catch (ActivityNotFoundException e) {
            // Should not happen, since we check the availability of
            // voice search before showing the button. But just in case...
            Log.w(LOG_TAG, "Could not find voice search activity");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.631 -0400", hash_original_method = "4D3FC77D85FEC9D80C6560FAE74CDA60", hash_generated_method = "5C44600C46592041A47B81971EB66968")
                
void onTextFocusChanged() {
        updateViewsVisibility(isIconified());
        // Delayed update to make sure that the focus has settled down and window focus changes
        // don't affect it. A synchronous update was not working.
        postUpdateFocusedState();
        if (mQueryTextView.hasFocus()) {
            forceSuggestionQuery();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.634 -0400", hash_original_method = "6BC34AF35099192BA7E60BCC11E3C756", hash_generated_method = "F7D1510C3205597107CC3CA86E133104")
                
@Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);

        postUpdateFocusedState();
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.636 -0400", hash_original_method = "5D7477A3D9C6D568A19E621F4FAE5DD7", hash_generated_method = "8E15890FE8C1E16FFF8183FE8EA51626")
                
@Override
    public void onActionViewCollapsed() {
        clearFocus();
        updateViewsVisibility(true);
        mQueryTextView.setImeOptions(mCollapsedImeOptions);
        mExpandedInActionView = false;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.638 -0400", hash_original_method = "F734C19BE6B7D5E142C7745125215DDF", hash_generated_method = "C9ABA9855018003C93815F32D566CE45")
                
@Override
    public void onActionViewExpanded() {
        if (mExpandedInActionView) return;

        mExpandedInActionView = true;
        mCollapsedImeOptions = mQueryTextView.getImeOptions();
        mQueryTextView.setImeOptions(mCollapsedImeOptions | EditorInfo.IME_FLAG_NO_FULLSCREEN);
        mQueryTextView.setText("");
        setIconified(false);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.640 -0400", hash_original_method = "58D1D0E657FD45AA5397F00624675B63", hash_generated_method = "60FBB7C67290152B18F46FD3323D7822")
                
private void adjustDropDownSizeAndPosition() {
        if (mDropDownAnchor.getWidth() > 1) {
            Resources res = getContext().getResources();
            int anchorPadding = mSearchPlate.getPaddingLeft();
            Rect dropDownPadding = new Rect();
            int iconOffset = mIconifiedByDefault
                    ? res.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width)
                    + res.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left)
                    : 0;
            mQueryTextView.getDropDownBackground().getPadding(dropDownPadding);
            int offset = anchorPadding - (dropDownPadding.left + iconOffset);
            mQueryTextView.setDropDownHorizontalOffset(offset);
            final int width = mDropDownAnchor.getWidth() + dropDownPadding.left
                    + dropDownPadding.right + iconOffset - anchorPadding;
            mQueryTextView.setDropDownWidth(width);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.643 -0400", hash_original_method = "5FDC493391F791D62FF75AE849BF4213", hash_generated_method = "D97A43FE417E7623923C8248271D9B22")
                
private boolean onItemClicked(int position, int actionKey, String actionMsg) {
        if (mOnSuggestionListener == null
                || !mOnSuggestionListener.onSuggestionClick(position)) {
            launchSuggestion(position, KeyEvent.KEYCODE_UNKNOWN, null);
            setImeVisibility(false);
            dismissSuggestions();
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.645 -0400", hash_original_method = "08FFA8C71E803D9BC52878D0BDC1227B", hash_generated_method = "D9287C4CC7F8F95FC25FFE15955460C1")
                
private boolean onItemSelected(int position) {
        if (mOnSuggestionListener == null
                || !mOnSuggestionListener.onSuggestionSelect(position)) {
            rewriteQueryFromSuggestion(position);
            return true;
        }
        return false;
    }

    /**
     * Query rewriting.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.662 -0400", hash_original_method = "FE5C7BD493A3B7C4988BF7B094450FE1", hash_generated_method = "2E791D59EA01A15F27EF5E146953F31F")
                
private void rewriteQueryFromSuggestion(int position) {
        CharSequence oldQuery = mQueryTextView.getText();
        Cursor c = mSuggestionsAdapter.getCursor();
        if (c == null) {
            return;
        }
        if (c.moveToPosition(position)) {
            // Get the new query from the suggestion.
            CharSequence newQuery = mSuggestionsAdapter.convertToString(c);
            if (newQuery != null) {
                // The suggestion rewrites the query.
                // Update the text field, without getting new suggestions.
                setQuery(newQuery);
            } else {
                // The suggestion does not rewrite the query, restore the user's query.
                setQuery(oldQuery);
            }
        } else {
            // We got a bad position, restore the user's query.
            setQuery(oldQuery);
        }
    }

    /**
     * Launches an intent based on a suggestion.
     *
     * @param position The index of the suggestion to create the intent from.
     * @param actionKey The key code of the action key that was pressed,
     *        or {@link KeyEvent#KEYCODE_UNKNOWN} if none.
     * @param actionMsg The message for the action key that was pressed,
     *        or <code>null</code> if none.
     * @return true if a successful launch, false if could not (e.g. bad position).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.664 -0400", hash_original_method = "1026A945AA7D5E936A04225BB74423F6", hash_generated_method = "526AD01A8145198E6E90EDF77DA844EA")
                
private boolean launchSuggestion(int position, int actionKey, String actionMsg) {
        Cursor c = mSuggestionsAdapter.getCursor();
        if ((c != null) && c.moveToPosition(position)) {

            Intent intent = createIntentFromSuggestion(c, actionKey, actionMsg);

            // launch the intent
            launchIntent(intent);

            return true;
        }
        return false;
    }

    /**
     * Launches an intent, including any special intent handling.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.666 -0400", hash_original_method = "B092F13CA13C6A372C37DCEFCF94B5BC", hash_generated_method = "584E434D946C5FE4F9C56FDAC4C7DDDE")
                
private void launchIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            // If the intent was created from a suggestion, it will always have an explicit
            // component here.
            getContext().startActivity(intent);
        } catch (RuntimeException ex) {
            Log.e(LOG_TAG, "Failed launch activity: " + intent, ex);
        }
    }

    /**
     * Sets the text in the query box, without updating the suggestions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.668 -0400", hash_original_method = "DBAD05D6D0FBDB0F3C2E2D7A3D1DEA39", hash_generated_method = "4A5B9A3A0047F83968B622CE9280338F")
                
private void setQuery(CharSequence query) {
        mQueryTextView.setText(query);
        // Move the cursor to the end
        mQueryTextView.setSelection(TextUtils.isEmpty(query) ? 0 : query.length());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.671 -0400", hash_original_method = "A610C255BB7D93FEE4A49CEF406D7E3C", hash_generated_method = "3A7DF92BD5F041D72A8251C175ACCB40")
                
private void launchQuerySearch(int actionKey, String actionMsg, String query) {
        String action = Intent.ACTION_SEARCH;
        Intent intent = createIntent(action, null, null, query, actionKey, actionMsg);
        getContext().startActivity(intent);
    }

    /**
     * Constructs an intent from the given information and the search dialog state.
     *
     * @param action Intent action.
     * @param data Intent data, or <code>null</code>.
     * @param extraData Data for {@link SearchManager#EXTRA_DATA_KEY} or <code>null</code>.
     * @param query Intent query, or <code>null</code>.
     * @param actionKey The key code of the action key that was pressed,
     *        or {@link KeyEvent#KEYCODE_UNKNOWN} if none.
     * @param actionMsg The message for the action key that was pressed,
     *        or <code>null</code> if none.
     * @return The intent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.674 -0400", hash_original_method = "7931502AE551A2F220A0C85C1181EB09", hash_generated_method = "1F0A50D12F3AF83BCB8DD4F3AC55A247")
                
private Intent createIntent(String action, Uri data, String extraData, String query,
            int actionKey, String actionMsg) {
        // Now build the Intent
        Intent intent = new Intent(action);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // We need CLEAR_TOP to avoid reusing an old task that has other activities
        // on top of the one we want. We don't want to do this in in-app search though,
        // as it can be destructive to the activity stack.
        if (data != null) {
            intent.setData(data);
        }
        intent.putExtra(SearchManager.USER_QUERY, mUserQuery);
        if (query != null) {
            intent.putExtra(SearchManager.QUERY, query);
        }
        if (extraData != null) {
            intent.putExtra(SearchManager.EXTRA_DATA_KEY, extraData);
        }
        if (mAppSearchData != null) {
            intent.putExtra(SearchManager.APP_DATA, mAppSearchData);
        }
        if (actionKey != KeyEvent.KEYCODE_UNKNOWN) {
            intent.putExtra(SearchManager.ACTION_KEY, actionKey);
            intent.putExtra(SearchManager.ACTION_MSG, actionMsg);
        }
        intent.setComponent(mSearchable.getSearchActivity());
        return intent;
    }

    /**
     * Create and return an Intent that can launch the voice search activity for web search.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.676 -0400", hash_original_method = "88ED2A4CD1E55FCB278985A3652D43A1", hash_generated_method = "4283836B167ED982507321DF5E9FF938")
                
private Intent createVoiceWebSearchIntent(Intent baseIntent, SearchableInfo searchable) {
        Intent voiceIntent = new Intent(baseIntent);
        ComponentName searchActivity = searchable.getSearchActivity();
        voiceIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, searchActivity == null ? null
                : searchActivity.flattenToShortString());
        return voiceIntent;
    }

    /**
     * Create and return an Intent that can launch the voice search activity, perform a specific
     * voice transcription, and forward the results to the searchable activity.
     *
     * @param baseIntent The voice app search intent to start from
     * @return A completely-configured intent ready to send to the voice search activity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.680 -0400", hash_original_method = "5D74F0494562FB84F425FDE65654BA8C", hash_generated_method = "AA02645CC7E117FF9A241D2B087075EA")
                
private Intent createVoiceAppSearchIntent(Intent baseIntent, SearchableInfo searchable) {
        ComponentName searchActivity = searchable.getSearchActivity();

        // create the necessary intent to set up a search-and-forward operation
        // in the voice search system.   We have to keep the bundle separate,
        // because it becomes immutable once it enters the PendingIntent
        Intent queryIntent = new Intent(Intent.ACTION_SEARCH);
        queryIntent.setComponent(searchActivity);
        PendingIntent pending = PendingIntent.getActivity(getContext(), 0, queryIntent,
                PendingIntent.FLAG_ONE_SHOT);

        // Now set up the bundle that will be inserted into the pending intent
        // when it's time to do the search.  We always build it here (even if empty)
        // because the voice search activity will always need to insert "QUERY" into
        // it anyway.
        Bundle queryExtras = new Bundle();
        if (mAppSearchData != null) {
            queryExtras.putParcelable(SearchManager.APP_DATA, mAppSearchData);
        }

        // Now build the intent to launch the voice search.  Add all necessary
        // extras to launch the voice recognizer, and then all the necessary extras
        // to forward the results to the searchable activity
        Intent voiceIntent = new Intent(baseIntent);

        // Add all of the configuration options supplied by the searchable's metadata
        String languageModel = RecognizerIntent.LANGUAGE_MODEL_FREE_FORM;
        String prompt = null;
        String language = null;
        int maxResults = 1;

        Resources resources = getResources();
        if (searchable.getVoiceLanguageModeId() != 0) {
            languageModel = resources.getString(searchable.getVoiceLanguageModeId());
        }
        if (searchable.getVoicePromptTextId() != 0) {
            prompt = resources.getString(searchable.getVoicePromptTextId());
        }
        if (searchable.getVoiceLanguageId() != 0) {
            language = resources.getString(searchable.getVoiceLanguageId());
        }
        if (searchable.getVoiceMaxResults() != 0) {
            maxResults = searchable.getVoiceMaxResults();
        }
        voiceIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, languageModel);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, prompt);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, language);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, maxResults);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, searchActivity == null ? null
                : searchActivity.flattenToShortString());

        // Add the values that configure forwarding the results
        voiceIntent.putExtra(RecognizerIntent.EXTRA_RESULTS_PENDINGINTENT, pending);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_RESULTS_PENDINGINTENT_BUNDLE, queryExtras);

        return voiceIntent;
    }

    /**
     * When a particular suggestion has been selected, perform the various lookups required
     * to use the suggestion.  This includes checking the cursor for suggestion-specific data,
     * and/or falling back to the XML for defaults;  It also creates REST style Uri data when
     * the suggestion includes a data id.
     *
     * @param c The suggestions cursor, moved to the row of the user's selection
     * @param actionKey The key code of the action key that was pressed,
     *        or {@link KeyEvent#KEYCODE_UNKNOWN} if none.
     * @param actionMsg The message for the action key that was pressed,
     *        or <code>null</code> if none.
     * @return An intent for the suggestion at the cursor's position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.683 -0400", hash_original_method = "AB898CD02BDAC1EC395FEB762AAF8CC2", hash_generated_method = "858861D843B36063B9DA287E078A747D")
                
private Intent createIntentFromSuggestion(Cursor c, int actionKey, String actionMsg) {
        try {
            // use specific action if supplied, or default action if supplied, or fixed default
            String action = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_ACTION);

            if (action == null) {
                action = mSearchable.getSuggestIntentAction();
            }
            if (action == null) {
                action = Intent.ACTION_SEARCH;
            }

            // use specific data if supplied, or default data if supplied
            String data = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_DATA);
            if (data == null) {
                data = mSearchable.getSuggestIntentData();
            }
            // then, if an ID was provided, append it.
            if (data != null) {
                String id = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID);
                if (id != null) {
                    data = data + "/" + Uri.encode(id);
                }
            }
            Uri dataUri = (data == null) ? null : Uri.parse(data);

            String query = getColumnString(c, SearchManager.SUGGEST_COLUMN_QUERY);
            String extraData = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_EXTRA_DATA);

            return createIntent(action, dataUri, extraData, query, actionKey, actionMsg);
        } catch (RuntimeException e ) {
            int rowNum;
            try {                       // be really paranoid now
                rowNum = c.getPosition();
            } catch (RuntimeException e2 ) {
                rowNum = -1;
            }
            Log.w(LOG_TAG, "Search suggestions cursor at row " + rowNum +
                    " returned exception.", e);
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:22:44.686 -0400", hash_original_method = "366325057160BB83E1BEC9126629B266", hash_generated_method = "AAA914BA2146378156C18412928647ED")
                
private void forceSuggestionQuery() {
        HIDDEN_METHOD_INVOKER.doBeforeTextChanged(mQueryTextView);
        HIDDEN_METHOD_INVOKER.doAfterTextChanged(mQueryTextView);
    }

    /**
     * Local subclass for AutoCompleteTextView.
     * @hide
     */
    public static class SearchAutoComplete extends AutoCompleteTextView {

        private int mThreshold;
        private SearchView mSearchView;

        public SearchAutoComplete(Context context) {
            super(context);
            mThreshold = getThreshold();
        }

        public SearchAutoComplete(Context context, AttributeSet attrs) {
            super(context, attrs);
            mThreshold = getThreshold();
        }

        public SearchAutoComplete(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            mThreshold = getThreshold();
        }

        void setSearchView(SearchView searchView) {
            mSearchView = searchView;
        }

        @Override
        public void setThreshold(int threshold) {
            super.setThreshold(threshold);
            mThreshold = threshold;
        }

        /**
         * Returns true if the text field is empty, or contains only whitespace.
         */
        private boolean isEmpty() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /**
         * We override this method to avoid replacing the query box text when a
         * suggestion is clicked.
         */
        @Override
        protected void replaceText(CharSequence text) {
        }

        /**
         * We override this method to avoid an extra onItemClick being called on
         * the drop-down's OnItemClickListener by
         * {@link AutoCompleteTextView#onKeyUp(int, KeyEvent)} when an item is
         * clicked with the trackball.
         */
        @Override
        public void performCompletion() {
        }

        /**
         * We override this method to be sure and show the soft keyboard if
         * appropriate when the TextView has focus.
         */
        @Override
        public void onWindowFocusChanged(boolean hasWindowFocus) {
            super.onWindowFocusChanged(hasWindowFocus);

            if (hasWindowFocus && mSearchView.hasFocus() && getVisibility() == VISIBLE) {
                InputMethodManager inputManager = (InputMethodManager) getContext()
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(this, 0);
                // If in landscape mode, then make sure that
                // the ime is in front of the dropdown.
                if (isLandscapeMode(getContext())) {
                    HIDDEN_METHOD_INVOKER.ensureImeVisible(this, true);
                }
            }
        }

        @Override
        protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
            mSearchView.onTextFocusChanged();
        }

        /**
         * We override this method so that we can allow a threshold of zero,
         * which ACTV does not.
         */
        @Override
        public boolean enoughToFilter() {
            return mThreshold <= 0 || super.enoughToFilter();
        }

        @Override
        public boolean onKeyPreIme(int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                // special case for the back key, we do not even try to send it
                // to the drop down list but instead, consume it immediately
                if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if (state != null) {
                        state.startTracking(event, this);
                    }
                    return true;
                } else if (event.getAction() == KeyEvent.ACTION_UP) {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if (state != null) {
                        state.handleUpEvent(event);
                    }
                    if (event.isTracking() && !event.isCanceled()) {
                        mSearchView.clearFocus();
                        mSearchView.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(keyCode, event);
        }
    }

    private static class AutoCompleteTextViewReflector {
        private Method doBeforeTextChanged, doAfterTextChanged;
        private Method ensureImeVisible;
        private Method showSoftInputUnchecked;

        AutoCompleteTextViewReflector() {
            try {
                doBeforeTextChanged = AutoCompleteTextView.class
                        .getDeclaredMethod("doBeforeTextChanged");
                doBeforeTextChanged.setAccessible(true);
            } catch (NoSuchMethodException e) {
                // Ah well.
            }
            try {
                doAfterTextChanged = AutoCompleteTextView.class
                        .getDeclaredMethod("doAfterTextChanged");
                doAfterTextChanged.setAccessible(true);
            } catch (NoSuchMethodException e) {
                // Ah well.
            }
            try {
                ensureImeVisible = AutoCompleteTextView.class
                        .getMethod("ensureImeVisible", boolean.class);
                ensureImeVisible.setAccessible(true);
            } catch (NoSuchMethodException e) {
                // Ah well.
            }
            try {
                showSoftInputUnchecked = InputMethodManager.class.getMethod(
                        "showSoftInputUnchecked", int.class, ResultReceiver.class);
                showSoftInputUnchecked.setAccessible(true);
            } catch (NoSuchMethodException e) {
                // Ah well.
            }
        }

        void doBeforeTextChanged(AutoCompleteTextView view) {
            if (doBeforeTextChanged != null) {
                try {
                    doBeforeTextChanged.invoke(view);
                } catch (Exception e) {
                }
            }
        }

        void doAfterTextChanged(AutoCompleteTextView view) {
            if (doAfterTextChanged != null) {
                try {
                    doAfterTextChanged.invoke(view);
                } catch (Exception e) {
                }
            }
        }

        void ensureImeVisible(AutoCompleteTextView view, boolean visible) {
            if (ensureImeVisible != null) {
                try {
                    ensureImeVisible.invoke(view, visible);
                } catch (Exception e) {
                }
            }
        }

        void showSoftInputUnchecked(InputMethodManager imm, View view, int flags) {
            if (showSoftInputUnchecked != null) {
                try {
                    showSoftInputUnchecked.invoke(imm, flags, null);
                    return;
                } catch (Exception e) {
                }
            }

            // Hidden method failed, call public version instead
            imm.showSoftInput(view, flags);
        }
    }
}