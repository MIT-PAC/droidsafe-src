package android.support.v7.widget;

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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.appcompat.R;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/**
 * Provides the contents for the suggestion drop-down list.in {@link SearchView}.
 * @hide
 */
class SuggestionsAdapter extends ResourceCursorAdapter implements OnClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.488 -0400", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")


    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.491 -0400", hash_original_field = "13F3B2DF0FCA764230D27EDCE01E4B44", hash_generated_field = "10677C9028A9E03475AECA5E3EA8B569")

    private static final String LOG_TAG = "SuggestionsAdapter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.493 -0400", hash_original_field = "D04EB07A765EF1EE52AC28FA2FDF7843", hash_generated_field = "719CAAA89185A96380841381EE84A3E5")

    private static final int QUERY_LIMIT = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.495 -0400", hash_original_field = "AE137D8B61EF1E6708FA70587481FB25", hash_generated_field = "98E9087104FBAF95AD5B62C304A0CCFF")


    static final int REFINE_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.497 -0400", hash_original_field = "49FA411F6050649582B6B5F150971B04", hash_generated_field = "837D31B49612E7145EBEC07CF04BC9EF")

    static final int REFINE_BY_ENTRY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.500 -0400", hash_original_field = "90161AE390B510C1E11A62F475389C14", hash_generated_field = "8DB1B3241AF2F750ED09F16EC1479E52")

    static final int REFINE_ALL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.537 -0400", hash_original_field = "79922DB043510C9A19B5CA2602F88574", hash_generated_field = "5DFAE43769080A8126AF66611D827CF3")


    static final int INVALID_INDEX = -1;

    /**
     * Gets the value of a string column by name.
     *
     * @param cursor Cursor to read the value from.
     * @param columnName The name of the column to read.
     * @return The value of the given column, or <code>null</null>
     *         if the cursor does not contain the given column.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.643 -0400", hash_original_method = "1DF3663A5B3A428C1CADE4AE8EEC8EDE", hash_generated_method = "B318FA4151B5A29D427C1B2BE29C2145")
    
public static String getColumnString(Cursor cursor, String columnName) {
        int col = cursor.getColumnIndex(columnName);
        return getStringOrNull(cursor, col);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.645 -0400", hash_original_method = "6E518F16AD3C7946ABDBA44CD98ACB5C", hash_generated_method = "25CD0B399C84A3E56E6B09E8E2824AD9")
    
private static String getStringOrNull(Cursor cursor, int col) {
        if (col == INVALID_INDEX) {
            return null;
        }
        try {
            return cursor.getString(col);
        } catch (Exception e) {
            Log.e(LOG_TAG,
                    "unexpected error retrieving valid column from cursor, "
                            + "did the remote process die?", e);
            return null;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.502 -0400", hash_original_field = "8470BADEE289DF0AB053E4469CD24A3C", hash_generated_field = "EC37B561700692089320F9D5E535EAC6")


    private SearchManager mSearchManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.504 -0400", hash_original_field = "60229949E2319A4FB0EE2E6EFEBE4F16", hash_generated_field = "1366187FE3CF01EF5FC13B6B4154C3DB")

    private SearchView mSearchView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.506 -0400", hash_original_field = "48D170239934FB4D79AA195112CE1340", hash_generated_field = "6F1511307A7DE5E4BDCE1D082D25D113")

    private SearchableInfo mSearchable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.508 -0400", hash_original_field = "645E76F452820CC114766EFD3070B1B6", hash_generated_field = "7C7A305D33D1BC28D819A6E4A2AAAF6C")

    private Context mProviderContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.523 -0400", hash_original_field = "85CA298CA9E19AB500DC7A2717B5FC7E", hash_generated_field = "B85E917372D3BED3B3CE8F4DA3D3A6D3")

    private WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.530 -0400", hash_original_field = "68E7C3569E191B98218FD7A043574AEA", hash_generated_field = "0FB4858B613824FE6FDA94A379EBC4D0")

    private boolean mClosed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.532 -0400", hash_original_field = "6E617A4FB95250F9CD6EA0C54DE93455", hash_generated_field = "EE7267ACB8B58771C9C5C8A0A163549B")

    private int mQueryRefinement = REFINE_BY_ENTRY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.534 -0400", hash_original_field = "57C291B3164982AD0687D4EADF8BDA2D", hash_generated_field = "0BE8AC4A70015275FE70EEC0CAC1F0EC")

    private ColorStateList mUrlColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.539 -0400", hash_original_field = "A2B647E0971CFE2DEA78B505C491F962", hash_generated_field = "B162451730ABFB26D08AF54099E233CC")

    private int mText1Col = INVALID_INDEX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.541 -0400", hash_original_field = "56439C1EABE1C46EF49D13C417F0B7E7", hash_generated_field = "745DF2DCD7F688EC03809FDC06531CFD")

    private int mText2Col = INVALID_INDEX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.543 -0400", hash_original_field = "7F93AACF5917FDD5339DB73ED8C1BDB9", hash_generated_field = "C018328754CF1F9AD85EF4F02F2ABCC4")

    private int mText2UrlCol = INVALID_INDEX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.545 -0400", hash_original_field = "B5518914EA713E94D3250A072F89DADB", hash_generated_field = "ABAB9A496D404B9E527D4F1BABD73E1F")

    private int mIconName1Col = INVALID_INDEX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.547 -0400", hash_original_field = "3BD18096E3B45399E7BF219B2F25C7B0", hash_generated_field = "A3074C22725E90C5CD06EEE589A84779")

    private int mIconName2Col = INVALID_INDEX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.549 -0400", hash_original_field = "7F5B47997249F69E2A4C64ED41F81B10", hash_generated_field = "8627CEDD9E8AF7896BE8D1B2E6FCBF94")

    private int mFlagsCol = INVALID_INDEX;

    // private final Runnable mStartSpinnerRunnable;
    // private final Runnable mStopSpinnerRunnable;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.552 -0400", hash_original_method = "5F2388728937314883F4AB4A89437D16", hash_generated_method = "5C1E0882FF7BDAF2DD442370AAE3CE3A")
    
public SuggestionsAdapter(Context context, SearchView searchView,
            SearchableInfo searchable,
            WeakHashMap<String, Drawable.ConstantState> outsideDrawablesCache) {
        super(context, R.layout.abc_search_dropdown_item_icons_2line,
                null,   // no initial cursor
                true);  // auto-requery
        mSearchManager = (SearchManager) mContext.getSystemService(Context.SEARCH_SERVICE);
        mSearchView = searchView;
        mSearchable = searchable;
        // set up provider resources (gives us icons, etc.)
        mProviderContext = context;

        mOutsideDrawablesCache = outsideDrawablesCache;
    }

    /**
     * Enables query refinement for all suggestions. This means that an additional icon
     * will be shown for each entry. When clicked, the suggested text on that line will be
     * copied to the query text field.
     * <p>
     *
     * @param refineWhat which queries to refine. Possible values are {@link #REFINE_NONE},
     * {@link #REFINE_BY_ENTRY}, and {@link #REFINE_ALL}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.554 -0400", hash_original_method = "7E34E1FAECF41C65A10194A4E061AD6D", hash_generated_method = "D15ED0FB71828B2C6CFB1A8A0693DFDB")
    
public void setQueryRefinement(int refineWhat) {
        mQueryRefinement = refineWhat;
    }

    /**
     * Returns the current query refinement preference.
     * @return value of query refinement preference
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.557 -0400", hash_original_method = "986E9EFF340372ED6B6AF1389D87F9A0", hash_generated_method = "8FEA08FFD485B597F21E8838992C3BFE")
    
public int getQueryRefinement() {
        return mQueryRefinement;
    }

    /**
     * Overridden to always return <code>false</code>, since we cannot be sure that
     * suggestion sources return stable IDs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.559 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "BF2ED6D8AA7E3F26499C1DEA76CA3447")
    
@Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * Use the search suggestions provider to obtain a live cursor.  This will be called
     * in a worker thread, so it's OK if the query is slow (e.g. round trip for suggestions).
     * The results will be processed in the UI thread and changeCursor() will be called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.561 -0400", hash_original_method = "751D905881D500785FB6386F5B08F863", hash_generated_method = "5D3AE3B6F9B4A4BADCE160BAD2076E7C")
    
@Override
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        if (DBG) Log.d(LOG_TAG, "runQueryOnBackgroundThread(" + constraint + ")");
        String query = (constraint == null) ? "" : constraint.toString();
        /**
         * for in app search we show the progress spinner until the cursor is returned with
         * the results.
         */
        Cursor cursor = null;
        if (mSearchView.getVisibility() != View.VISIBLE
                || mSearchView.getWindowVisibility() != View.VISIBLE) {
            return null;
        }
        try {
            cursor = getSearchManagerSuggestions(mSearchable, query, QUERY_LIMIT);
            // trigger fill window so the spinner stays up until the results are copied over and
            // closer to being ready
            if (cursor != null) {
                cursor.getCount();
                return cursor;
            }
        } catch (RuntimeException e) {
            Log.w(LOG_TAG, "Search suggestions query threw an exception.", e);
        }
        // If cursor is null or an exception was thrown, stop the spinner and return null.
        // changeCursor doesn't get called if cursor is null
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.563 -0400", hash_original_method = "31DDF4DC630B78B5374FE58E89B45EA8", hash_generated_method = "2C9484A65BE8C192838B5102B106BDA1")
    
public void close() {
        if (DBG) Log.d(LOG_TAG, "close()");
        changeCursor(null);
        mClosed = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.565 -0400", hash_original_method = "6C6F9D84444AF89C1AA3B4F24466FCA3", hash_generated_method = "8114E027C251957471CAB0AA4D5386E6")
    
@Override
    public void notifyDataSetChanged() {
        if (DBG) Log.d(LOG_TAG, "notifyDataSetChanged");
        super.notifyDataSetChanged();

        updateSpinnerState(getCursor());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.569 -0400", hash_original_method = "C9146AC3C36F793606A0389850806FAD", hash_generated_method = "FE6CF0A454D78923538D15273EA24206")
    
@Override
    public void notifyDataSetInvalidated() {
        if (DBG) Log.d(LOG_TAG, "notifyDataSetInvalidated");
        super.notifyDataSetInvalidated();

        updateSpinnerState(getCursor());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.572 -0400", hash_original_method = "1E3B20B61BE1D7016BA8A5BF351CC500", hash_generated_method = "75128AEEA184A16354158836160AA137")
    
private void updateSpinnerState(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (DBG) {
            Log.d(LOG_TAG, "updateSpinnerState - extra = "
                    + (extras != null
                    ? extras.getBoolean(SearchManager.CURSOR_EXTRA_KEY_IN_PROGRESS)
                    : null));
        }
        // Check if the Cursor indicates that the query is not complete and show the spinner
        if (extras != null
                && extras.getBoolean(SearchManager.CURSOR_EXTRA_KEY_IN_PROGRESS)) {
            return;
        }
        // If cursor is null or is done, stop the spinner
    }

    /**
     * Cache of the child views of drop-drown list items, to avoid looking up the children
     * each time the contents of a list item are changed.
     */
    private final static class ChildViewCache {
        public final TextView mText1;
        public final TextView mText2;
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;

        public ChildViewCache(View v) {
            mText1 = (TextView) v.findViewById(android.R.id.text1);
            mText2 = (TextView) v.findViewById(android.R.id.text2);
            mIcon1 = (ImageView) v.findViewById(android.R.id.icon1);
            mIcon2 = (ImageView) v.findViewById(android.R.id.icon2);
            mIconRefine = (ImageView) v.findViewById(R.id.edit_query);
        }
    }

    /**
     * Cache columns.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.574 -0400", hash_original_method = "148392FC8CA03B9EFECB202A68AE28AE", hash_generated_method = "CE0EE09920B5212A4945C1129DC818D5")
    
@Override
    public void changeCursor(Cursor c) {
        if (DBG) Log.d(LOG_TAG, "changeCursor(" + c + ")");

        if (mClosed) {
            Log.w(LOG_TAG, "Tried to change cursor after adapter was closed.");
            if (c != null) c.close();
            return;
        }

        try {
            super.changeCursor(c);

            if (c != null) {
                mText1Col = c.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1);
                mText2Col = c.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_2);
                mText2UrlCol = c.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_2_URL);
                mIconName1Col = c.getColumnIndex(SearchManager.SUGGEST_COLUMN_ICON_1);
                mIconName2Col = c.getColumnIndex(SearchManager.SUGGEST_COLUMN_ICON_2);
                mFlagsCol = c.getColumnIndex(SearchManager.SUGGEST_COLUMN_FLAGS);
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, "error changing cursor and caching columns", e);
        }
    }

    /**
     * Tags the view with cached child view look-ups.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.577 -0400", hash_original_method = "FF2C15D5C77CB986FFC483C5693D319F", hash_generated_method = "8FC17E37CE7826FC731CFDA2E6F6822A")
    
@Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View v = super.newView(context, cursor, parent);
        v.setTag(new ChildViewCache(v));
        return v;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.598 -0400", hash_original_method = "9ABFACDD3FE80D43883DC10EAA51920C", hash_generated_method = "BFA92484CCFF61190E75E1EF10D3492B")
    
@Override
    public void bindView(View view, Context context, Cursor cursor) {
        ChildViewCache views = (ChildViewCache) view.getTag();

        int flags = 0;
        if (mFlagsCol != INVALID_INDEX) {
            flags = cursor.getInt(mFlagsCol);
        }
        if (views.mText1 != null) {
            String text1 = getStringOrNull(cursor, mText1Col);
            setViewText(views.mText1, text1);
        }
        if (views.mText2 != null) {
            // First check TEXT_2_URL
            CharSequence text2 = getStringOrNull(cursor, mText2UrlCol);
            if (text2 != null) {
                text2 = formatUrl(text2);
            } else {
                text2 = getStringOrNull(cursor, mText2Col);
            }

            // If no second line of text is indicated, allow the first line of text
            // to be up to two lines if it wants to be.
            if (TextUtils.isEmpty(text2)) {
                if (views.mText1 != null) {
                    views.mText1.setSingleLine(false);
                    views.mText1.setMaxLines(2);
                }
            } else {
                if (views.mText1 != null) {
                    views.mText1.setSingleLine(true);
                    views.mText1.setMaxLines(1);
                }
            }
            setViewText(views.mText2, text2);
        }

        if (views.mIcon1 != null) {
            setViewDrawable(views.mIcon1, getIcon1(cursor), View.INVISIBLE);
        }
        if (views.mIcon2 != null) {
            setViewDrawable(views.mIcon2, getIcon2(cursor), View.GONE);
        }
        if (mQueryRefinement == REFINE_ALL
                || (mQueryRefinement == REFINE_BY_ENTRY
                && (flags & SearchManager.FLAG_QUERY_REFINEMENT) != 0)) {
            views.mIconRefine.setVisibility(View.VISIBLE);
            views.mIconRefine.setTag(views.mText1.getText());
            views.mIconRefine.setOnClickListener(this);
        } else {
            views.mIconRefine.setVisibility(View.GONE);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.600 -0400", hash_original_method = "21562F430356DF0ADAE2AB54659D8C55", hash_generated_method = "5D8A5AF0DF375611FC111AC52F452F73")
    
public void onClick(View v) {
        Object tag = v.getTag();
        if (tag instanceof CharSequence) {
            mSearchView.onQueryRefine((CharSequence) tag);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.603 -0400", hash_original_method = "9779DF5ADEE23E8777317BAD132048A5", hash_generated_method = "82E7BBC70B8DE1DEC8EA6F2641AEE768")
    
private CharSequence formatUrl(CharSequence url) {
        if (mUrlColor == null) {
            // Lazily get the URL color from the current theme.
            TypedValue colorValue = new TypedValue();
            mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, colorValue, true);
            mUrlColor = mContext.getResources().getColorStateList(colorValue.resourceId);
        }

        SpannableString text = new SpannableString(url);
        text.setSpan(new TextAppearanceSpan(null, 0, 0, mUrlColor, null),
                0, url.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return text;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.606 -0400", hash_original_method = "8F61D57F1A865E44B5C7D5D6842EB2D0", hash_generated_method = "85FC7203F9DB42EE6A227B5F2991653F")
    
private void setViewText(TextView v, CharSequence text) {
        // Set the text even if it's null, since we need to clear any previous text.
        v.setText(text);

        if (TextUtils.isEmpty(text)) {
            v.setVisibility(View.GONE);
        } else {
            v.setVisibility(View.VISIBLE);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.609 -0400", hash_original_method = "11EBBD91023FF77979C98F4482283D5C", hash_generated_method = "84F96B932E02F25F65A07FFC546AC21C")
    
private Drawable getIcon1(Cursor cursor) {
        if (mIconName1Col == INVALID_INDEX) {
            return null;
        }
        String value = cursor.getString(mIconName1Col);
        Drawable drawable = getDrawableFromResourceValue(value);
        if (drawable != null) {
            return drawable;
        }
        return getDefaultIcon1(cursor);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.612 -0400", hash_original_method = "E54FBD6C00322E8129D2706226F8DB3F", hash_generated_method = "8B681026B02719AD651FEBC592E0A4A5")
    
private Drawable getIcon2(Cursor cursor) {
        if (mIconName2Col == INVALID_INDEX) {
            return null;
        }
        String value = cursor.getString(mIconName2Col);
        return getDrawableFromResourceValue(value);
    }

    /**
     * Sets the drawable in an image view, makes sure the view is only visible if there
     * is a drawable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.614 -0400", hash_original_method = "DC13C6A1012A85758DE954F51DF05728", hash_generated_method = "35FCB15D203F3076388F2C3CD53C3644")
    
private void setViewDrawable(ImageView v, Drawable drawable, int nullVisibility) {
        // Set the icon even if the drawable is null, since we need to clear any
        // previous icon.
        v.setImageDrawable(drawable);

        if (drawable == null) {
            v.setVisibility(nullVisibility);
        } else {
            v.setVisibility(View.VISIBLE);

            // This is a hack to get any animated drawables (like a 'working' spinner)
            // to animate. You have to setVisible true on an AnimationDrawable to get
            // it to start animating, but it must first have been false or else the
            // call to setVisible will be ineffective. We need to clear up the story
            // about animated drawables in the future, see http://b/1878430.
            drawable.setVisible(false, false);
            drawable.setVisible(true, false);
        }
    }

    /**
     * Gets the text to show in the query field when a suggestion is selected.
     *
     * @param cursor The Cursor to read the suggestion data from. The Cursor should already
     *        be moved to the suggestion that is to be read from.
     * @return The text to show, or <code>null</code> if the query should not be
     *         changed when selecting this suggestion.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.617 -0400", hash_original_method = "EEAFA1105ED04DD7E614744D210BB1BA", hash_generated_method = "B81DD5AB449E12F988064BBF1FA0C514")
    
@Override
    public CharSequence convertToString(Cursor cursor) {
        if (cursor == null) {
            return null;
        }

        String query = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_QUERY);
        if (query != null) {
            return query;
        }

        if (mSearchable.shouldRewriteQueryFromData()) {
            String data = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_INTENT_DATA);
            if (data != null) {
                return data;
            }
        }

        if (mSearchable.shouldRewriteQueryFromText()) {
            String text1 = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_TEXT_1);
            if (text1 != null) {
                return text1;
            }
        }

        return null;
    }

    /**
     * This method is overridden purely to provide a bit of protection against
     * flaky content providers.
     *
     * @see android.widget.ListAdapter#getView(int, View, ViewGroup)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.620 -0400", hash_original_method = "EC9A6ABF4CBFA211B4EDA728AA0B1D68", hash_generated_method = "6F756B9030C9DE6578298DBB4587359F")
    
@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            return super.getView(position, convertView, parent);
        } catch (RuntimeException e) {
            Log.w(LOG_TAG, "Search suggestions cursor threw exception.", e);
            // Put exception string in item title
            View v = newView(mContext, mCursor, parent);
            if (v != null) {
                ChildViewCache views = (ChildViewCache) v.getTag();
                TextView tv = views.mText1;
                tv.setText(e.toString());
            }
            return v;
        }
    }

    /**
     * Gets a drawable given a value provided by a suggestion provider.
     *
     * This value could be just the string value of a resource id
     * (e.g., "2130837524"), in which case we will try to retrieve a drawable from
     * the provider's resources. If the value is not an integer, it is
     * treated as a Uri and opened with
     * {@link ContentResolver#openOutputStream(android.net.Uri, String)}.
     *
     * All resources and URIs are read using the suggestion provider's context.
     *
     * If the string is not formatted as expected, or no drawable can be found for
     * the provided value, this method returns null.
     *
     * @param drawableId a string like "2130837524",
     *        "android.resource://com.android.alarmclock/2130837524",
     *        or "content://contacts/photos/253".
     * @return a Drawable, or null if none found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.623 -0400", hash_original_method = "ECCFFE0E1CBB9F4B996BB7824AA88154", hash_generated_method = "F143C829BCED0CD0E23C248E07D799B0")
    
private Drawable getDrawableFromResourceValue(String drawableId) {
        if (drawableId == null || drawableId.length() == 0 || "0".equals(drawableId)) {
            return null;
        }
        try {
            // First, see if it's just an integer
            int resourceId = Integer.parseInt(drawableId);
            // It's an int, look for it in the cache
            String drawableUri = ContentResolver.SCHEME_ANDROID_RESOURCE
                    + "://" + mProviderContext.getPackageName() + "/" + resourceId;
            // Must use URI as cache key, since ints are app-specific
            Drawable drawable = checkIconCache(drawableUri);
            if (drawable != null) {
                return drawable;
            }
            // Not cached, find it by resource ID
            drawable = mProviderContext.getResources().getDrawable(resourceId);
            // Stick it in the cache, using the URI as key
            storeInIconCache(drawableUri, drawable);
            return drawable;
        } catch (NumberFormatException nfe) {
            // It's not an integer, use it as a URI
            Drawable drawable = checkIconCache(drawableId);
            if (drawable != null) {
                return drawable;
            }
            Uri uri = Uri.parse(drawableId);
            drawable = getDrawable(uri);
            storeInIconCache(drawableId, drawable);
            return drawable;
        } catch (Resources.NotFoundException nfe) {
            // It was an integer, but it couldn't be found, bail out
            Log.w(LOG_TAG, "Icon resource not found: " + drawableId);
            return null;
        }
    }

    /**
     * Gets a drawable by URI, without using the cache.
     *
     * @return A drawable, or {@code null} if the drawable could not be loaded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.627 -0400", hash_original_method = "EF7649F83B1A402082B7C652F676EB63", hash_generated_method = "4B802A827725C03AF2A2C6FEDB99257E")
    
private Drawable getDrawable(Uri uri) {
        try {
            String scheme = uri.getScheme();
            if (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(scheme)) {
                // Load drawables through Resources, to get the source density information
                try {
                    return getDrawableFromResourceUri(uri);
                } catch (Resources.NotFoundException ex) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            } else {
                // Let the ContentResolver handle content and file URIs.
                InputStream stream = mProviderContext.getContentResolver().openInputStream(uri);
                if (stream == null) {
                    throw new FileNotFoundException("Failed to open " + uri);
                }
                try {
                    return Drawable.createFromStream(stream, null);
                } finally {
                    try {
                        stream.close();
                    } catch (IOException ex) {
                        Log.e(LOG_TAG, "Error closing icon stream for " + uri, ex);
                    }
                }
            }
        } catch (FileNotFoundException fnfe) {
            Log.w(LOG_TAG, "Icon not found: " + uri + ", " + fnfe.getMessage());
            return null;
        }
    }



    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.629 -0400", hash_original_method = "9553535B4A93F8E44A1EFE31D535ED8E", hash_generated_method = "535FC01315FAC95DA4A22A433C2BB95A")
    
private Drawable checkIconCache(String resourceUri) {
        Drawable.ConstantState cached = mOutsideDrawablesCache.get(resourceUri);
        if (cached == null) {
            return null;
        }
        if (DBG) Log.d(LOG_TAG, "Found icon in cache: " + resourceUri);
        return cached.newDrawable();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.632 -0400", hash_original_method = "7BF5C76588E6E73B227833C6CD1AD962", hash_generated_method = "F2790FE892428FEA44ED738A696811B5")
    
private void storeInIconCache(String resourceUri, Drawable drawable) {
        if (drawable != null) {
            mOutsideDrawablesCache.put(resourceUri, drawable.getConstantState());
        }
    }

    /**
     * Gets the left-hand side icon that will be used for the current suggestion
     * if the suggestion contains an icon column but no icon or a broken icon.
     *
     * @param cursor A cursor positioned at the current suggestion.
     * @return A non-null drawable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.634 -0400", hash_original_method = "24C6C5F14DA2AC5DBA34633E0C5BC43B", hash_generated_method = "600C5EABD197F315812F68BD7A0F364A")
    
private Drawable getDefaultIcon1(Cursor cursor) {
        // Check the component that gave us the suggestion
        Drawable drawable = getActivityIconWithCache(mSearchable.getSearchActivity());
        if (drawable != null) {
            return drawable;
        }

        // Fall back to a default icon
        return mContext.getPackageManager().getDefaultActivityIcon();
    }

    /**
     * Gets the activity or application icon for an activity.
     * Uses the local icon cache for fast repeated lookups.
     *
     * @param component Name of an activity.
     * @return A drawable, or {@code null} if neither the activity nor the application
     *         has an icon set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.636 -0400", hash_original_method = "1ABDDD143C3A87EFB8B7D38CA2C4068F", hash_generated_method = "9470B1CB2A297DF303A94DB2B6FC4035")
    
private Drawable getActivityIconWithCache(ComponentName component) {
        // First check the icon cache
        String componentIconKey = component.flattenToShortString();
        // Using containsKey() since we also store null values.
        if (mOutsideDrawablesCache.containsKey(componentIconKey)) {
            Drawable.ConstantState cached = mOutsideDrawablesCache.get(componentIconKey);
            return cached == null ? null : cached.newDrawable(mProviderContext.getResources());
        }
        // Then try the activity or application icon
        Drawable drawable = getActivityIcon(component);
        // Stick it in the cache so we don't do this lookup again.
        Drawable.ConstantState toCache = drawable == null ? null : drawable.getConstantState();
        mOutsideDrawablesCache.put(componentIconKey, toCache);
        return drawable;
    }

    /**
     * Gets the activity or application icon for an activity.
     *
     * @param component Name of an activity.
     * @return A drawable, or {@code null} if neither the acitivy or the application
     *         have an icon set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.639 -0400", hash_original_method = "62EED478ECA0AB495E91A21A2EB22E87", hash_generated_method = "F92B2945ABEDD05BB5FAD9853AAEFA5E")
    
private Drawable getActivityIcon(ComponentName component) {
        PackageManager pm = mContext.getPackageManager();
        final ActivityInfo activityInfo;
        try {
            activityInfo = pm.getActivityInfo(component, PackageManager.GET_META_DATA);
        } catch (NameNotFoundException ex) {
            Log.w(LOG_TAG, ex.toString());
            return null;
        }
        int iconId = activityInfo.getIconResource();
        if (iconId == 0) return null;
        String pkg = component.getPackageName();
        Drawable drawable = pm.getDrawable(pkg, iconId, activityInfo.applicationInfo);
        if (drawable == null) {
            Log.w(LOG_TAG, "Invalid icon resource " + iconId + " for "
                    + component.flattenToShortString());
            return null;
        }
        return drawable;
    }

    /**
     * Import of hidden method: ContentResolver.getResourceId(Uri).
     * Modified to return a drawable, rather than a hidden type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.650 -0400", hash_original_method = "9E384FEA5815EA48E2B02C69F0EA4F52", hash_generated_method = "9E384FEA5815EA48E2B02C69F0EA4F52")
    
Drawable getDrawableFromResourceUri(Uri uri) throws FileNotFoundException {
        String authority = uri.getAuthority();
        Resources r;
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        } else {
            try {
                r = mContext.getPackageManager().getResourcesForApplication(authority);
            } catch (NameNotFoundException ex) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        List<String> path = uri.getPathSegments();
        if (path == null) {
            throw new FileNotFoundException("No path: " + uri);
        }
        int len = path.size();
        int id;
        if (len == 1) {
            try {
                id = Integer.parseInt(path.get(0));
            } catch (NumberFormatException e) {
                throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
            }
        } else if (len == 2) {
            id = r.getIdentifier(path.get(1), path.get(0), authority);
        } else {
            throw new FileNotFoundException("More than two path segments: " + uri);
        }
        if (id == 0) {
            throw new FileNotFoundException("No resource found for: " + uri);
        }
        return r.getDrawable(id);
    }

    /**
     * Import of hidden method: SearchManager.getSuggestions(SearchableInfo, String, int).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.654 -0400", hash_original_method = "E86AE55FA0C102FD3EAB1828DDDB5CD0", hash_generated_method = "5142028732664A4575BEBDA5D19E079E")
    
Cursor getSearchManagerSuggestions(SearchableInfo searchable, String query, int limit) {
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
            uriBuilder.appendQueryParameter("limit", String.valueOf(limit));
        }

        Uri uri = uriBuilder.build();

        // finally, make the query
        return mContext.getContentResolver().query(uri, null, selection, selArgs, null);
    }
}