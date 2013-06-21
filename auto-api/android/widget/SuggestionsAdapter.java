package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.SearchDialog;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContentResolver.OpenResourceIdResult;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import com.android.internal.R;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.WeakHashMap;

class SuggestionsAdapter extends ResourceCursorAdapter implements OnClickListener {
    private SearchManager mSearchManager;
    private SearchView mSearchView;
    private SearchableInfo mSearchable;
    private Context mProviderContext;
    private WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    private boolean mClosed = false;
    private int mQueryRefinement = REFINE_BY_ENTRY;
    private ColorStateList mUrlColor;
    private int mText1Col = INVALID_INDEX;
    private int mText2Col = INVALID_INDEX;
    private int mText2UrlCol = INVALID_INDEX;
    private int mIconName1Col = INVALID_INDEX;
    private int mIconName2Col = INVALID_INDEX;
    private int mFlagsCol = INVALID_INDEX;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.678 -0400", hash_original_method = "190CAF11C7DD896719D5F8C797EB7D95", hash_generated_method = "BB286506D55DBFB950E87120C4301C55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SuggestionsAdapter(Context context, SearchView searchView,
            SearchableInfo searchable,
            WeakHashMap<String, Drawable.ConstantState> outsideDrawablesCache) {
        super(context,
                com.android.internal.R.layout.search_dropdown_item_icons_2line,
                null,   
                true);
        dsTaint.addTaint(searchView.dsTaint);
        dsTaint.addTaint(outsideDrawablesCache.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(searchable.dsTaint);
        mSearchManager = (SearchManager) mContext.getSystemService(Context.SEARCH_SERVICE);
        Context activityContext;
        activityContext = mSearchable.getActivityContext(mContext);
        mProviderContext = mSearchable.getProviderContext(mContext, activityContext);
        getFilter().setDelayer(new Filter.Delayer() {            private int mPreviousLength = 0;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.678 -0400", hash_original_method = "724CD13B980D98DDBE94BB34EF222B8A", hash_generated_method = "63D52EF8109213D6FAF390E4025E61AF")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public long getPostingDelay(CharSequence constraint) {
                dsTaint.addTaint(constraint);
                long delay;
                boolean var86130193B74E4EA7B26601F90461C8D2_1359536037 = (constraint.length() < mPreviousLength);
                delay = DELETE_KEY_POST_DELAY;
                delay = 0;
                mPreviousLength = constraint.length();
                return dsTaint.getTaintLong();
                // ---------- Original Method ----------
                //if (constraint == null) return 0;
                //long delay = constraint.length() < mPreviousLength ? DELETE_KEY_POST_DELAY : 0;
                //mPreviousLength = constraint.length();
                //return delay;
            }
});
        // ---------- Original Method ----------
        //mSearchManager = (SearchManager) mContext.getSystemService(Context.SEARCH_SERVICE);
        //mSearchView = searchView;
        //mSearchable = searchable;
        //Context activityContext = mSearchable.getActivityContext(mContext);
        //mProviderContext = mSearchable.getProviderContext(mContext, activityContext);
        //mOutsideDrawablesCache = outsideDrawablesCache;
        //getFilter().setDelayer(new Filter.Delayer() {
            //private int mPreviousLength = 0;
            //public long getPostingDelay(CharSequence constraint) {
                //if (constraint == null) return 0;
                //long delay = constraint.length() < mPreviousLength ? DELETE_KEY_POST_DELAY : 0;
                //mPreviousLength = constraint.length();
                //return delay;
            //}
        //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.679 -0400", hash_original_method = "7E34E1FAECF41C65A10194A4E061AD6D", hash_generated_method = "D6232FA5799293F0CA955082086D8813")
    @DSModeled(DSC.SAFE)
    public void setQueryRefinement(int refineWhat) {
        dsTaint.addTaint(refineWhat);
        // ---------- Original Method ----------
        //mQueryRefinement = refineWhat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.679 -0400", hash_original_method = "986E9EFF340372ED6B6AF1389D87F9A0", hash_generated_method = "E02396CF407050E6B314F8D240078CB9")
    @DSModeled(DSC.SAFE)
    public int getQueryRefinement() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mQueryRefinement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.679 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "EFF95DEF7F8614606ED71B7F0D898399")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean hasStableIds() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.679 -0400", hash_original_method = "94A214A70A9BD5FB24F7DC72C91FA8E3", hash_generated_method = "9008977CC5D3159DE7FA1E018AEB64A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        dsTaint.addTaint(constraint);
        Log.d(LOG_TAG, "runQueryOnBackgroundThread(" + constraint + ")");
        String query;
        query = "";
        query = constraint.toString();
        Cursor cursor;
        cursor = null;
        {
            boolean var1FD321E2413C37BB7BF6265879DF7132_1177712281 = (mSearchView.getVisibility() != View.VISIBLE
                || mSearchView.getWindowVisibility() != View.VISIBLE);
        } //End collapsed parenthetic
        try 
        {
            cursor = mSearchManager.getSuggestions(mSearchable, query, QUERY_LIMIT);
            {
                cursor.getCount();
            } //End block
        } //End block
        catch (RuntimeException e)
        { }
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (DBG) Log.d(LOG_TAG, "runQueryOnBackgroundThread(" + constraint + ")");
        //String query = (constraint == null) ? "" : constraint.toString();
        //Cursor cursor = null;
        //if (mSearchView.getVisibility() != View.VISIBLE
                //|| mSearchView.getWindowVisibility() != View.VISIBLE) {
            //return null;
        //}
        //try {
            //cursor = mSearchManager.getSuggestions(mSearchable, query, QUERY_LIMIT);
            //if (cursor != null) {
                //cursor.getCount();
                //return cursor;
            //}
        //} catch (RuntimeException e) {
            //Log.w(LOG_TAG, "Search suggestions query threw an exception.", e);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.679 -0400", hash_original_method = "31DDF4DC630B78B5374FE58E89B45EA8", hash_generated_method = "C7D7BD489C69CF8812EDED66E65A8F4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        Log.d(LOG_TAG, "close()");
        changeCursor(null);
        mClosed = true;
        // ---------- Original Method ----------
        //if (DBG) Log.d(LOG_TAG, "close()");
        //changeCursor(null);
        //mClosed = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.680 -0400", hash_original_method = "6C6F9D84444AF89C1AA3B4F24466FCA3", hash_generated_method = "8B9EEDC1009B20B2D1E17A6FA08ADD72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void notifyDataSetChanged() {
        Log.d(LOG_TAG, "notifyDataSetChanged");
        super.notifyDataSetChanged();
        updateSpinnerState(getCursor());
        // ---------- Original Method ----------
        //if (DBG) Log.d(LOG_TAG, "notifyDataSetChanged");
        //super.notifyDataSetChanged();
        //updateSpinnerState(getCursor());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.680 -0400", hash_original_method = "C9146AC3C36F793606A0389850806FAD", hash_generated_method = "6B93AEE0079E5CB1BBCFFD1FCD57FEA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void notifyDataSetInvalidated() {
        Log.d(LOG_TAG, "notifyDataSetInvalidated");
        super.notifyDataSetInvalidated();
        updateSpinnerState(getCursor());
        // ---------- Original Method ----------
        //if (DBG) Log.d(LOG_TAG, "notifyDataSetInvalidated");
        //super.notifyDataSetInvalidated();
        //updateSpinnerState(getCursor());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.680 -0400", hash_original_method = "1E3B20B61BE1D7016BA8A5BF351CC500", hash_generated_method = "7475F87A568B7A519CDBC15DBCA6DAB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateSpinnerState(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        Bundle extras;
        extras = cursor.getExtras();
        extras = null;
        {
            Log.d(LOG_TAG, "updateSpinnerState - extra = "
                + (extras != null
                        ? extras.getBoolean(SearchManager.CURSOR_EXTRA_KEY_IN_PROGRESS)
                        : null));
        } //End block
        {
            boolean var50462C069FC0D18F392466D196957EC9_1032482870 = (extras != null
                && extras.getBoolean(SearchManager.CURSOR_EXTRA_KEY_IN_PROGRESS));
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Bundle extras = cursor != null ? cursor.getExtras() : null;
        //if (DBG) {
            //Log.d(LOG_TAG, "updateSpinnerState - extra = "
                //+ (extras != null
                        //? extras.getBoolean(SearchManager.CURSOR_EXTRA_KEY_IN_PROGRESS)
                        //: null));
        //}
        //if (extras != null
                //&& extras.getBoolean(SearchManager.CURSOR_EXTRA_KEY_IN_PROGRESS)) {
            //return;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.681 -0400", hash_original_method = "148392FC8CA03B9EFECB202A68AE28AE", hash_generated_method = "BDBB5ACAA1EDE3EE2DA95483D1EBAC8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void changeCursor(Cursor c) {
        dsTaint.addTaint(c.dsTaint);
        Log.d(LOG_TAG, "changeCursor(" + c + ")");
        {
            c.close();
        } //End block
        try 
        {
            super.changeCursor(c);
            {
                mText1Col = c.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1);
                mText2Col = c.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_2);
                mText2UrlCol = c.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_2_URL);
                mIconName1Col = c.getColumnIndex(SearchManager.SUGGEST_COLUMN_ICON_1);
                mIconName2Col = c.getColumnIndex(SearchManager.SUGGEST_COLUMN_ICON_2);
                mFlagsCol = c.getColumnIndex(SearchManager.SUGGEST_COLUMN_FLAGS);
            } //End block
        } //End block
        catch (Exception e)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.681 -0400", hash_original_method = "FF2C15D5C77CB986FFC483C5693D319F", hash_generated_method = "8332ED2EAE6D7022551B529B04218104")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        dsTaint.addTaint(cursor.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        View v;
        v = super.newView(context, cursor, parent);
        v.setTag(new ChildViewCache(v));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //View v = super.newView(context, cursor, parent);
        //v.setTag(new ChildViewCache(v));
        //return v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.681 -0400", hash_original_method = "9ABFACDD3FE80D43883DC10EAA51920C", hash_generated_method = "3EE85540067F892C4630127B2DD0D112")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        ChildViewCache views;
        views = (ChildViewCache) view.getTag();
        int flags;
        flags = 0;
        {
            flags = cursor.getInt(mFlagsCol);
        } //End block
        {
            String text1;
            text1 = getStringOrNull(cursor, mText1Col);
            setViewText(views.mText1, text1);
        } //End block
        {
            CharSequence text2;
            text2 = getStringOrNull(cursor, mText2UrlCol);
            {
                text2 = formatUrl(text2);
            } //End block
            {
                text2 = getStringOrNull(cursor, mText2Col);
            } //End block
            {
                boolean varB9DE4693D5C635CA8EC30AA4FD17DA9F_1679250937 = (TextUtils.isEmpty(text2));
                {
                    {
                        views.mText1.setSingleLine(false);
                        views.mText1.setMaxLines(2);
                    } //End block
                } //End block
                {
                    {
                        views.mText1.setSingleLine(true);
                        views.mText1.setMaxLines(1);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            setViewText(views.mText2, text2);
        } //End block
        {
            setViewDrawable(views.mIcon1, getIcon1(cursor), View.INVISIBLE);
        } //End block
        {
            setViewDrawable(views.mIcon2, getIcon2(cursor), View.GONE);
        } //End block
        {
            views.mIconRefine.setVisibility(View.VISIBLE);
            views.mIconRefine.setTag(views.mText1.getText());
            views.mIconRefine.setOnClickListener(this);
        } //End block
        {
            views.mIconRefine.setVisibility(View.GONE);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.682 -0400", hash_original_method = "21562F430356DF0ADAE2AB54659D8C55", hash_generated_method = "EAA3D4BD24B971479AF196DE420CC0F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        Object tag;
        tag = v.getTag();
        {
            mSearchView.onQueryRefine((CharSequence) tag);
        } //End block
        // ---------- Original Method ----------
        //Object tag = v.getTag();
        //if (tag instanceof CharSequence) {
            //mSearchView.onQueryRefine((CharSequence) tag);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.682 -0400", hash_original_method = "9779DF5ADEE23E8777317BAD132048A5", hash_generated_method = "DAA89060B8D8FD5D7E4FBC26387AF9E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence formatUrl(CharSequence url) {
        dsTaint.addTaint(url);
        {
            TypedValue colorValue;
            colorValue = new TypedValue();
            mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, colorValue, true);
            mUrlColor = mContext.getResources().getColorStateList(colorValue.resourceId);
        } //End block
        SpannableString text;
        text = new SpannableString(url);
        text.setSpan(new TextAppearanceSpan(null, 0, 0, mUrlColor, null),
                0, url.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mUrlColor == null) {
            //TypedValue colorValue = new TypedValue();
            //mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, colorValue, true);
            //mUrlColor = mContext.getResources().getColorStateList(colorValue.resourceId);
        //}
        //SpannableString text = new SpannableString(url);
        //text.setSpan(new TextAppearanceSpan(null, 0, 0, mUrlColor, null),
                //0, url.length(),
                //Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //return text;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.682 -0400", hash_original_method = "8F61D57F1A865E44B5C7D5D6842EB2D0", hash_generated_method = "AB3AA0C24664AEDE6FE310F6EAACC666")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setViewText(TextView v, CharSequence text) {
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(text);
        v.setText(text);
        {
            boolean var6C86A511CD0D2845B6E0259573F6A612_49883536 = (TextUtils.isEmpty(text));
            {
                v.setVisibility(View.GONE);
            } //End block
            {
                v.setVisibility(View.VISIBLE);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //v.setText(text);
        //if (TextUtils.isEmpty(text)) {
            //v.setVisibility(View.GONE);
        //} else {
            //v.setVisibility(View.VISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.682 -0400", hash_original_method = "11EBBD91023FF77979C98F4482283D5C", hash_generated_method = "8D3412A9FE2A7ADD705A32F9DE9F2EEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Drawable getIcon1(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        String value;
        value = cursor.getString(mIconName1Col);
        Drawable drawable;
        drawable = getDrawableFromResourceValue(value);
        Drawable varA7254A79BF8227C473929FBB20F67481_1835214406 = (getDefaultIcon1(cursor));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mIconName1Col == INVALID_INDEX) {
            //return null;
        //}
        //String value = cursor.getString(mIconName1Col);
        //Drawable drawable = getDrawableFromResourceValue(value);
        //if (drawable != null) {
            //return drawable;
        //}
        //return getDefaultIcon1(cursor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.683 -0400", hash_original_method = "E54FBD6C00322E8129D2706226F8DB3F", hash_generated_method = "955DAED32CF5B889C6370F149B44A77E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Drawable getIcon2(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        String value;
        value = cursor.getString(mIconName2Col);
        Drawable var6FA7A9BFC3F19648D9B89708D89F32FB_1819225429 = (getDrawableFromResourceValue(value));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mIconName2Col == INVALID_INDEX) {
            //return null;
        //}
        //String value = cursor.getString(mIconName2Col);
        //return getDrawableFromResourceValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.683 -0400", hash_original_method = "DC13C6A1012A85758DE954F51DF05728", hash_generated_method = "087266FF1AC0C74D905E7148548200CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setViewDrawable(ImageView v, Drawable drawable, int nullVisibility) {
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(nullVisibility);
        dsTaint.addTaint(drawable.dsTaint);
        v.setImageDrawable(drawable);
        {
            v.setVisibility(nullVisibility);
        } //End block
        {
            v.setVisibility(View.VISIBLE);
            drawable.setVisible(false, false);
            drawable.setVisible(true, false);
        } //End block
        // ---------- Original Method ----------
        //v.setImageDrawable(drawable);
        //if (drawable == null) {
            //v.setVisibility(nullVisibility);
        //} else {
            //v.setVisibility(View.VISIBLE);
            //drawable.setVisible(false, false);
            //drawable.setVisible(true, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.683 -0400", hash_original_method = "EEAFA1105ED04DD7E614744D210BB1BA", hash_generated_method = "C636B962CB704F83DD05179F66DC4ACB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharSequence convertToString(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        String query;
        query = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_QUERY);
        {
            boolean varE8FE5C36D8FE1523056BAB9AB236D1EA_765808696 = (mSearchable.shouldRewriteQueryFromData());
            {
                String data;
                data = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_INTENT_DATA);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var29845B1F9A9491B3FE6CECDC2E20A3FE_1410944310 = (mSearchable.shouldRewriteQueryFromText());
            {
                String text1;
                text1 = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_TEXT_1);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (cursor == null) {
            //return null;
        //}
        //String query = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_QUERY);
        //if (query != null) {
            //return query;
        //}
        //if (mSearchable.shouldRewriteQueryFromData()) {
            //String data = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_INTENT_DATA);
            //if (data != null) {
                //return data;
            //}
        //}
        //if (mSearchable.shouldRewriteQueryFromText()) {
            //String text1 = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_TEXT_1);
            //if (text1 != null) {
                //return text1;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.684 -0400", hash_original_method = "EC9A6ABF4CBFA211B4EDA728AA0B1D68", hash_generated_method = "3D94B42AA6876B8CCCED5C4E2B29078B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
        try 
        {
            View var2553C553947CC5FE13256BFAA9B5B77C_209500747 = (super.getView(position, convertView, parent));
        } //End block
        catch (RuntimeException e)
        {
            View v;
            v = newView(mContext, mCursor, parent);
            {
                ChildViewCache views;
                views = (ChildViewCache) v.getTag();
                TextView tv;
                tv = views.mText1;
                tv.setText(e.toString());
            } //End block
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.getView(position, convertView, parent);
        //} catch (RuntimeException e) {
            //Log.w(LOG_TAG, "Search suggestions cursor threw exception.", e);
            //View v = newView(mContext, mCursor, parent);
            //if (v != null) {
                //ChildViewCache views = (ChildViewCache) v.getTag();
                //TextView tv = views.mText1;
                //tv.setText(e.toString());
            //}
            //return v;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.684 -0400", hash_original_method = "2062B3ECC79D4C838F6E4FC0FEE6243A", hash_generated_method = "FEB5B1B8C0B3B6E09BFD4987C15FF7CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Drawable getDrawableFromResourceValue(String drawableId) {
        dsTaint.addTaint(drawableId);
        {
            boolean var28BB864B60CF8C657D6DC33CCB43E344_1723849276 = (drawableId == null || drawableId.length() == 0 || "0".equals(drawableId));
        } //End collapsed parenthetic
        try 
        {
            int resourceId;
            resourceId = Integer.parseInt(drawableId);
            String drawableUri;
            drawableUri = ContentResolver.SCHEME_ANDROID_RESOURCE
                    + "://" + mProviderContext.getPackageName() + "/" + resourceId;
            Drawable drawable;
            drawable = checkIconCache(drawableUri);
            drawable = mProviderContext.getResources().getDrawable(resourceId);
            storeInIconCache(drawableUri, drawable);
        } //End block
        catch (NumberFormatException nfe)
        {
            Drawable drawable;
            drawable = checkIconCache(drawableId);
            Uri uri;
            uri = Uri.parse(drawableId);
            drawable = getDrawable(uri);
            storeInIconCache(drawableId, drawable);
        } //End block
        catch (Resources.NotFoundException nfe)
        { }
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.685 -0400", hash_original_method = "3801EEB25227B54F215AA02CEF91B89D", hash_generated_method = "91AB7C8FCF97052666F7155401AA5738")
    @DSModeled(DSC.SPEC)
    private Drawable getDrawable(Uri uri) {
        dsTaint.addTaint(uri.dsTaint);
        try 
        {
            String scheme;
            scheme = uri.getScheme();
            {
                boolean varF1920ADB7A324A214864F4BBBDD05F45_385720514 = (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(scheme));
                {
                    OpenResourceIdResult r;
                    r = mProviderContext.getContentResolver().getResourceId(uri);
                    try 
                    {
                        Drawable var7F295D05A124B615C62364D80A88D817_588824304 = (r.r.getDrawable(r.id));
                    } //End block
                    catch (Resources.NotFoundException ex)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Resource does not exist: " + uri);
                    } //End block
                } //End block
                {
                    InputStream stream;
                    stream = mProviderContext.getContentResolver().openInputStream(uri);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Failed to open " + uri);
                    } //End block
                    try 
                    {
                        Drawable var8725F60FBBD404E9E81DDD148BAC6855_1432402155 = (Drawable.createFromStream(stream, null));
                    } //End block
                    finally 
                    {
                        try 
                        {
                            stream.close();
                        } //End block
                        catch (IOException ex)
                        { }
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (FileNotFoundException fnfe)
        { }
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.685 -0400", hash_original_method = "9553535B4A93F8E44A1EFE31D535ED8E", hash_generated_method = "93B1B90634A676724735FFCA8D8D00FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Drawable checkIconCache(String resourceUri) {
        dsTaint.addTaint(resourceUri);
        Drawable.ConstantState cached;
        cached = mOutsideDrawablesCache.get(resourceUri);
        Log.d(LOG_TAG, "Found icon in cache: " + resourceUri);
        Drawable varF8321DCF1088E9B65A28B7A4C23CE113_1144108832 = (cached.newDrawable());
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Drawable.ConstantState cached = mOutsideDrawablesCache.get(resourceUri);
        //if (cached == null) {
            //return null;
        //}
        //if (DBG) Log.d(LOG_TAG, "Found icon in cache: " + resourceUri);
        //return cached.newDrawable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.685 -0400", hash_original_method = "7BF5C76588E6E73B227833C6CD1AD962", hash_generated_method = "DE7DE036C12BA81D366C13DC13064607")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void storeInIconCache(String resourceUri, Drawable drawable) {
        dsTaint.addTaint(drawable.dsTaint);
        dsTaint.addTaint(resourceUri);
        {
            mOutsideDrawablesCache.put(resourceUri, drawable.getConstantState());
        } //End block
        // ---------- Original Method ----------
        //if (drawable != null) {
            //mOutsideDrawablesCache.put(resourceUri, drawable.getConstantState());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.686 -0400", hash_original_method = "24C6C5F14DA2AC5DBA34633E0C5BC43B", hash_generated_method = "30B5B6244E7EB38051D52B6345EB7CDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Drawable getDefaultIcon1(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        Drawable drawable;
        drawable = getActivityIconWithCache(mSearchable.getSearchActivity());
        Drawable var95330689E0E66C925061B71A331F99A2_335371392 = (mContext.getPackageManager().getDefaultActivityIcon());
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Drawable drawable = getActivityIconWithCache(mSearchable.getSearchActivity());
        //if (drawable != null) {
            //return drawable;
        //}
        //return mContext.getPackageManager().getDefaultActivityIcon();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.686 -0400", hash_original_method = "1ABDDD143C3A87EFB8B7D38CA2C4068F", hash_generated_method = "5F168FCB58A6D6C773AC7D30DD38F446")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Drawable getActivityIconWithCache(ComponentName component) {
        dsTaint.addTaint(component.dsTaint);
        String componentIconKey;
        componentIconKey = component.flattenToShortString();
        {
            boolean var5A3FED2D0F34D844AB05B6B3BADFCD1F_1018957527 = (mOutsideDrawablesCache.containsKey(componentIconKey));
            {
                Drawable.ConstantState cached;
                cached = mOutsideDrawablesCache.get(componentIconKey);
                {
                    Object varF8F978832589390FCF74B6CD5D194914_1624487011 = (cached.newDrawable(mProviderContext.getResources()));
                } //End flattened ternary
            } //End block
        } //End collapsed parenthetic
        Drawable drawable;
        drawable = getActivityIcon(component);
        Drawable.ConstantState toCache;
        toCache = null;
        toCache = drawable.getConstantState();
        mOutsideDrawablesCache.put(componentIconKey, toCache);
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String componentIconKey = component.flattenToShortString();
        //if (mOutsideDrawablesCache.containsKey(componentIconKey)) {
            //Drawable.ConstantState cached = mOutsideDrawablesCache.get(componentIconKey);
            //return cached == null ? null : cached.newDrawable(mProviderContext.getResources());
        //}
        //Drawable drawable = getActivityIcon(component);
        //Drawable.ConstantState toCache = drawable == null ? null : drawable.getConstantState();
        //mOutsideDrawablesCache.put(componentIconKey, toCache);
        //return drawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.686 -0400", hash_original_method = "62EED478ECA0AB495E91A21A2EB22E87", hash_generated_method = "472C2D5156B8D9FC38E007912B5F3C9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Drawable getActivityIcon(ComponentName component) {
        dsTaint.addTaint(component.dsTaint);
        PackageManager pm;
        pm = mContext.getPackageManager();
        ActivityInfo activityInfo;
        try 
        {
            activityInfo = pm.getActivityInfo(component, PackageManager.GET_META_DATA);
        } //End block
        catch (NameNotFoundException ex)
        { }
        int iconId;
        iconId = activityInfo.getIconResource();
        String pkg;
        pkg = component.getPackageName();
        Drawable drawable;
        drawable = pm.getDrawable(pkg, iconId, activityInfo.applicationInfo);
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PackageManager pm = mContext.getPackageManager();
        //final ActivityInfo activityInfo;
        //try {
            //activityInfo = pm.getActivityInfo(component, PackageManager.GET_META_DATA);
        //} catch (NameNotFoundException ex) {
            //Log.w(LOG_TAG, ex.toString());
            //return null;
        //}
        //int iconId = activityInfo.getIconResource();
        //if (iconId == 0) return null;
        //String pkg = component.getPackageName();
        //Drawable drawable = pm.getDrawable(pkg, iconId, activityInfo.applicationInfo);
        //if (drawable == null) {
            //Log.w(LOG_TAG, "Invalid icon resource " + iconId + " for "
                    //+ component.flattenToShortString());
            //return null;
        //}
        //return drawable;
    }

    
        public static String getColumnString(Cursor cursor, String columnName) {
        int col = cursor.getColumnIndex(columnName);
        return getStringOrNull(cursor, col);
    }

    
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

    
    private final static class ChildViewCache {
        public TextView mText1;
        public TextView mText2;
        public ImageView mIcon1;
        public ImageView mIcon2;
        public ImageView mIconRefine;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.687 -0400", hash_original_method = "0CE27F5D43D07582A33280C2CC2EDB09", hash_generated_method = "C7B0FD7AD3743D1EA30D90F82657193E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ChildViewCache(View v) {
            dsTaint.addTaint(v.dsTaint);
            mText1 = (TextView) v.findViewById(com.android.internal.R.id.text1);
            mText2 = (TextView) v.findViewById(com.android.internal.R.id.text2);
            mIcon1 = (ImageView) v.findViewById(com.android.internal.R.id.icon1);
            mIcon2 = (ImageView) v.findViewById(com.android.internal.R.id.icon2);
            mIconRefine = (ImageView) v.findViewById(com.android.internal.R.id.edit_query);
            // ---------- Original Method ----------
            //mText1 = (TextView) v.findViewById(com.android.internal.R.id.text1);
            //mText2 = (TextView) v.findViewById(com.android.internal.R.id.text2);
            //mIcon1 = (ImageView) v.findViewById(com.android.internal.R.id.icon1);
            //mIcon2 = (ImageView) v.findViewById(com.android.internal.R.id.icon2);
            //mIconRefine = (ImageView) v.findViewById(com.android.internal.R.id.edit_query);
        }

        
    }


    
    private static final boolean DBG = false;
    private static final String LOG_TAG = "SuggestionsAdapter";
    private static final int QUERY_LIMIT = 50;
    static final int REFINE_NONE = 0;
    static final int REFINE_BY_ENTRY = 1;
    static final int REFINE_ALL = 2;
    static final int INVALID_INDEX = -1;
    private static final long DELETE_KEY_POST_DELAY = 500L;
}

