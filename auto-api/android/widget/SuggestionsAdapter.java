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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.061 -0400", hash_original_field = "32BBEFAC8E5B50979F727CF657FBCDC5", hash_generated_field = "EC37B561700692089320F9D5E535EAC6")

    private SearchManager mSearchManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.061 -0400", hash_original_field = "D1972F87341AF3F5EA90C2B878C0DF14", hash_generated_field = "1366187FE3CF01EF5FC13B6B4154C3DB")

    private SearchView mSearchView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.061 -0400", hash_original_field = "43A23F0BB5F798E421F2CC49BC43D947", hash_generated_field = "6F1511307A7DE5E4BDCE1D082D25D113")

    private SearchableInfo mSearchable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.061 -0400", hash_original_field = "6126F3ADE7D1E4549FE0617BECDD3490", hash_generated_field = "7C7A305D33D1BC28D819A6E4A2AAAF6C")

    private Context mProviderContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.061 -0400", hash_original_field = "14D278A9ED4C8ACF824369307E3457F8", hash_generated_field = "B85E917372D3BED3B3CE8F4DA3D3A6D3")

    private WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.061 -0400", hash_original_field = "D72871D5CE2EB17105099280224B0CCD", hash_generated_field = "0FB4858B613824FE6FDA94A379EBC4D0")

    private boolean mClosed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.062 -0400", hash_original_field = "47B6CCCA247AD0969BBB9DFE3215D674", hash_generated_field = "EE7267ACB8B58771C9C5C8A0A163549B")

    private int mQueryRefinement = REFINE_BY_ENTRY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.062 -0400", hash_original_field = "572AE80BBC94E324C0BFEBD467E07E42", hash_generated_field = "0BE8AC4A70015275FE70EEC0CAC1F0EC")

    private ColorStateList mUrlColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.062 -0400", hash_original_field = "5E58DD57932DBAE40306F966514F2E48", hash_generated_field = "B162451730ABFB26D08AF54099E233CC")

    private int mText1Col = INVALID_INDEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.062 -0400", hash_original_field = "75C325501E7825234D0F714A4256FF6C", hash_generated_field = "745DF2DCD7F688EC03809FDC06531CFD")

    private int mText2Col = INVALID_INDEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.062 -0400", hash_original_field = "EBA70A48EF4356CBB3A99AAD4D731AB6", hash_generated_field = "C018328754CF1F9AD85EF4F02F2ABCC4")

    private int mText2UrlCol = INVALID_INDEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.062 -0400", hash_original_field = "ACF51633A3F89F63F9253117F8735E9E", hash_generated_field = "ABAB9A496D404B9E527D4F1BABD73E1F")

    private int mIconName1Col = INVALID_INDEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.062 -0400", hash_original_field = "74BEF9EF815025303F456B54D93D06B1", hash_generated_field = "A3074C22725E90C5CD06EEE589A84779")

    private int mIconName2Col = INVALID_INDEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.062 -0400", hash_original_field = "E9D1C3E619DB3C340A682F18A7C6A32F", hash_generated_field = "8627CEDD9E8AF7896BE8D1B2E6FCBF94")

    private int mFlagsCol = INVALID_INDEX;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.063 -0400", hash_original_method = "190CAF11C7DD896719D5F8C797EB7D95", hash_generated_method = "4C59514CD71A01B7FFE8356CB712F6D6")
    public  SuggestionsAdapter(Context context, SearchView searchView,
            SearchableInfo searchable,
            WeakHashMap<String, Drawable.ConstantState> outsideDrawablesCache) {
        super(context,
                com.android.internal.R.layout.search_dropdown_item_icons_2line,
                null,   
                true);
        mSearchManager = (SearchManager) mContext.getSystemService(Context.SEARCH_SERVICE);
        mSearchView = searchView;
        mSearchable = searchable;
        Context activityContext;
        activityContext = mSearchable.getActivityContext(mContext);
        mProviderContext = mSearchable.getProviderContext(mContext, activityContext);
        mOutsideDrawablesCache = outsideDrawablesCache;
        getFilter().setDelayer(new Filter.Delayer() {            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.062 -0400", hash_original_field = "4C620C4F670D4AEB734E374E4D2C5DE7", hash_generated_field = "3C2C3FA0C1C7472676EEF8CAC895BC8D")
            private int mPreviousLength = 0;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.063 -0400", hash_original_method = "724CD13B980D98DDBE94BB34EF222B8A", hash_generated_method = "DC55063DA6E2C077A99966FB95A6C3DE")
            public long getPostingDelay(CharSequence constraint) {
                long delay;
                boolean var86130193B74E4EA7B26601F90461C8D2_2051185670 = (constraint.length() < mPreviousLength);
                delay = DELETE_KEY_POST_DELAY;
                delay = 0;
                mPreviousLength = constraint.length();
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1851202042 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1851202042;
                // ---------- Original Method ----------
                //if (constraint == null) return 0;
                //long delay = constraint.length() < mPreviousLength ? DELETE_KEY_POST_DELAY : 0;
                //mPreviousLength = constraint.length();
                //return delay;
            }
});
        addTaint(context.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.063 -0400", hash_original_method = "7E34E1FAECF41C65A10194A4E061AD6D", hash_generated_method = "C864B094F1586B649248412EF85B9AC7")
    public void setQueryRefinement(int refineWhat) {
        mQueryRefinement = refineWhat;
        // ---------- Original Method ----------
        //mQueryRefinement = refineWhat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.066 -0400", hash_original_method = "986E9EFF340372ED6B6AF1389D87F9A0", hash_generated_method = "B07AECEBAF0D65AA1633EEE09F9B79A9")
    public int getQueryRefinement() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_485892675 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_485892675;
        // ---------- Original Method ----------
        //return mQueryRefinement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.074 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "1DFE17A9BC1211FDE44A3B80DE65FB2F")
    @Override
    public boolean hasStableIds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1695506547 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1695506547;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.098 -0400", hash_original_method = "94A214A70A9BD5FB24F7DC72C91FA8E3", hash_generated_method = "EFF1A060283A589A36B758A1ABC5F6CD")
    @Override
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_2121814735 = null; //Variable for return #1
        Cursor varB4EAC82CA7396A68D541C85D26508E83_2048525249 = null; //Variable for return #2
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1009985888 = null; //Variable for return #3
        Log.d(LOG_TAG, "runQueryOnBackgroundThread(" + constraint + ")");
        String query;
        query = "";
        query = constraint.toString();
        Cursor cursor;
        cursor = null;
        {
            boolean var1FD321E2413C37BB7BF6265879DF7132_1524363625 = (mSearchView.getVisibility() != View.VISIBLE
                || mSearchView.getWindowVisibility() != View.VISIBLE);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2121814735 = null;
            } //End block
        } //End collapsed parenthetic
        try 
        {
            cursor = mSearchManager.getSuggestions(mSearchable, query, QUERY_LIMIT);
            {
                cursor.getCount();
                varB4EAC82CA7396A68D541C85D26508E83_2048525249 = cursor;
            } //End block
        } //End block
        catch (RuntimeException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1009985888 = null;
        addTaint(constraint.getTaint());
        Cursor varA7E53CE21691AB073D9660D615818899_1156165842; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1156165842 = varB4EAC82CA7396A68D541C85D26508E83_2121814735;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1156165842 = varB4EAC82CA7396A68D541C85D26508E83_2048525249;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1156165842 = varB4EAC82CA7396A68D541C85D26508E83_1009985888;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1156165842.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1156165842;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.106 -0400", hash_original_method = "31DDF4DC630B78B5374FE58E89B45EA8", hash_generated_method = "C7D7BD489C69CF8812EDED66E65A8F4C")
    public void close() {
        Log.d(LOG_TAG, "close()");
        changeCursor(null);
        mClosed = true;
        // ---------- Original Method ----------
        //if (DBG) Log.d(LOG_TAG, "close()");
        //changeCursor(null);
        //mClosed = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.112 -0400", hash_original_method = "6C6F9D84444AF89C1AA3B4F24466FCA3", hash_generated_method = "8B9EEDC1009B20B2D1E17A6FA08ADD72")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.112 -0400", hash_original_method = "C9146AC3C36F793606A0389850806FAD", hash_generated_method = "6B93AEE0079E5CB1BBCFFD1FCD57FEA0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.113 -0400", hash_original_method = "1E3B20B61BE1D7016BA8A5BF351CC500", hash_generated_method = "8127158D0329E0A96A02FC9324D38BEF")
    private void updateSpinnerState(Cursor cursor) {
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
            boolean var50462C069FC0D18F392466D196957EC9_579190343 = (extras != null
                && extras.getBoolean(SearchManager.CURSOR_EXTRA_KEY_IN_PROGRESS));
        } //End collapsed parenthetic
        addTaint(cursor.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.114 -0400", hash_original_method = "148392FC8CA03B9EFECB202A68AE28AE", hash_generated_method = "13DB8FA6532C059DCDAD7D2B0364B6D8")
    @Override
    public void changeCursor(Cursor c) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.116 -0400", hash_original_method = "FF2C15D5C77CB986FFC483C5693D319F", hash_generated_method = "36F43D9F7587FA1D7F8C4759776F2E71")
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_1209537181 = null; //Variable for return #1
        View v;
        v = super.newView(context, cursor, parent);
        v.setTag(new ChildViewCache(v));
        varB4EAC82CA7396A68D541C85D26508E83_1209537181 = v;
        addTaint(context.getTaint());
        addTaint(cursor.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1209537181.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1209537181;
        // ---------- Original Method ----------
        //View v = super.newView(context, cursor, parent);
        //v.setTag(new ChildViewCache(v));
        //return v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.128 -0400", hash_original_method = "9ABFACDD3FE80D43883DC10EAA51920C", hash_generated_method = "895BC2F4B2A201F70E63584F072BD2B2")
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
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
                boolean varB9DE4693D5C635CA8EC30AA4FD17DA9F_1444475350 = (TextUtils.isEmpty(text2));
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
        addTaint(view.getTaint());
        addTaint(context.getTaint());
        addTaint(cursor.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.129 -0400", hash_original_method = "21562F430356DF0ADAE2AB54659D8C55", hash_generated_method = "5C3D12526F65B1B2CED6D4C4B0C3CEB6")
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Object tag;
        tag = v.getTag();
        {
            mSearchView.onQueryRefine((CharSequence) tag);
        } //End block
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        //Object tag = v.getTag();
        //if (tag instanceof CharSequence) {
            //mSearchView.onQueryRefine((CharSequence) tag);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.130 -0400", hash_original_method = "9779DF5ADEE23E8777317BAD132048A5", hash_generated_method = "C3B214F0727B03CBDBB10B2D8DA398B9")
    private CharSequence formatUrl(CharSequence url) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_971410123 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_971410123 = text;
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_971410123.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_971410123;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.130 -0400", hash_original_method = "8F61D57F1A865E44B5C7D5D6842EB2D0", hash_generated_method = "6C0CA07F924E1DF35322397132EF6D8B")
    private void setViewText(TextView v, CharSequence text) {
        v.setText(text);
        {
            boolean var6C86A511CD0D2845B6E0259573F6A612_2017676890 = (TextUtils.isEmpty(text));
            {
                v.setVisibility(View.GONE);
            } //End block
            {
                v.setVisibility(View.VISIBLE);
            } //End block
        } //End collapsed parenthetic
        addTaint(v.getTaint());
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //v.setText(text);
        //if (TextUtils.isEmpty(text)) {
            //v.setVisibility(View.GONE);
        //} else {
            //v.setVisibility(View.VISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.141 -0400", hash_original_method = "11EBBD91023FF77979C98F4482283D5C", hash_generated_method = "DA8E1A1F48F55CD957E979D4386DA251")
    private Drawable getIcon1(Cursor cursor) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_521297824 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_722303903 = null; //Variable for return #2
        Drawable varB4EAC82CA7396A68D541C85D26508E83_819281539 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_521297824 = null;
        } //End block
        String value;
        value = cursor.getString(mIconName1Col);
        Drawable drawable;
        drawable = getDrawableFromResourceValue(value);
        {
            varB4EAC82CA7396A68D541C85D26508E83_722303903 = drawable;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_819281539 = getDefaultIcon1(cursor);
        addTaint(cursor.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_40520693; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_40520693 = varB4EAC82CA7396A68D541C85D26508E83_521297824;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_40520693 = varB4EAC82CA7396A68D541C85D26508E83_722303903;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_40520693 = varB4EAC82CA7396A68D541C85D26508E83_819281539;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_40520693.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_40520693;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.141 -0400", hash_original_method = "E54FBD6C00322E8129D2706226F8DB3F", hash_generated_method = "3D4046997CC5ECF71B1F4DFE60296DB5")
    private Drawable getIcon2(Cursor cursor) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_980537942 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_2053562775 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_980537942 = null;
        } //End block
        String value;
        value = cursor.getString(mIconName2Col);
        varB4EAC82CA7396A68D541C85D26508E83_2053562775 = getDrawableFromResourceValue(value);
        addTaint(cursor.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_1491990199; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1491990199 = varB4EAC82CA7396A68D541C85D26508E83_980537942;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1491990199 = varB4EAC82CA7396A68D541C85D26508E83_2053562775;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1491990199.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1491990199;
        // ---------- Original Method ----------
        //if (mIconName2Col == INVALID_INDEX) {
            //return null;
        //}
        //String value = cursor.getString(mIconName2Col);
        //return getDrawableFromResourceValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.143 -0400", hash_original_method = "DC13C6A1012A85758DE954F51DF05728", hash_generated_method = "9D85F41AC2B492F8E8C048A9E3029074")
    private void setViewDrawable(ImageView v, Drawable drawable, int nullVisibility) {
        v.setImageDrawable(drawable);
        {
            v.setVisibility(nullVisibility);
        } //End block
        {
            v.setVisibility(View.VISIBLE);
            drawable.setVisible(false, false);
            drawable.setVisible(true, false);
        } //End block
        addTaint(v.getTaint());
        addTaint(drawable.getTaint());
        addTaint(nullVisibility);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.152 -0400", hash_original_method = "EEAFA1105ED04DD7E614744D210BB1BA", hash_generated_method = "C19C928C393A8FDC3BB7C13F0FCF6982")
    @Override
    public CharSequence convertToString(Cursor cursor) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1877675415 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_884375514 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1229467924 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1750016105 = null; //Variable for return #4
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1293406171 = null; //Variable for return #5
        {
            varB4EAC82CA7396A68D541C85D26508E83_1877675415 = null;
        } //End block
        String query;
        query = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_QUERY);
        {
            varB4EAC82CA7396A68D541C85D26508E83_884375514 = query;
        } //End block
        {
            boolean varE8FE5C36D8FE1523056BAB9AB236D1EA_193327008 = (mSearchable.shouldRewriteQueryFromData());
            {
                String data;
                data = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_INTENT_DATA);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1229467924 = data;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var29845B1F9A9491B3FE6CECDC2E20A3FE_586589935 = (mSearchable.shouldRewriteQueryFromText());
            {
                String text1;
                text1 = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_TEXT_1);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1750016105 = text1;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1293406171 = null;
        addTaint(cursor.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1036094844; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1036094844 = varB4EAC82CA7396A68D541C85D26508E83_1877675415;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1036094844 = varB4EAC82CA7396A68D541C85D26508E83_884375514;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1036094844 = varB4EAC82CA7396A68D541C85D26508E83_1229467924;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1036094844 = varB4EAC82CA7396A68D541C85D26508E83_1750016105;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1036094844 = varB4EAC82CA7396A68D541C85D26508E83_1293406171;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1036094844.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1036094844;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.157 -0400", hash_original_method = "EC9A6ABF4CBFA211B4EDA728AA0B1D68", hash_generated_method = "2EE50D0E78D030FA29F1AF9A7824012E")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_1057853332 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1026116891 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1057853332 = super.getView(position, convertView, parent);
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
            varB4EAC82CA7396A68D541C85D26508E83_1026116891 = v;
        } //End block
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1592875099; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1592875099 = varB4EAC82CA7396A68D541C85D26508E83_1057853332;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1592875099 = varB4EAC82CA7396A68D541C85D26508E83_1026116891;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1592875099.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1592875099;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.163 -0400", hash_original_method = "2062B3ECC79D4C838F6E4FC0FEE6243A", hash_generated_method = "8ACCCC554006A3EB0239F8C9273C4811")
    private Drawable getDrawableFromResourceValue(String drawableId) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1260639808 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_2044795601 = null; //Variable for return #2
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1179172739 = null; //Variable for return #3
        Drawable varB4EAC82CA7396A68D541C85D26508E83_331167627 = null; //Variable for return #4
        Drawable varB4EAC82CA7396A68D541C85D26508E83_758439640 = null; //Variable for return #5
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1287855339 = null; //Variable for return #6
        {
            boolean var28BB864B60CF8C657D6DC33CCB43E344_1658818798 = (drawableId == null || drawableId.length() == 0 || "0".equals(drawableId));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1260639808 = null;
            } //End block
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
            {
                varB4EAC82CA7396A68D541C85D26508E83_2044795601 = drawable;
            } //End block
            drawable = mProviderContext.getResources().getDrawable(resourceId);
            storeInIconCache(drawableUri, drawable);
            varB4EAC82CA7396A68D541C85D26508E83_1179172739 = drawable;
        } //End block
        catch (NumberFormatException nfe)
        {
            Drawable drawable;
            drawable = checkIconCache(drawableId);
            {
                varB4EAC82CA7396A68D541C85D26508E83_331167627 = drawable;
            } //End block
            Uri uri;
            uri = Uri.parse(drawableId);
            drawable = getDrawable(uri);
            storeInIconCache(drawableId, drawable);
            varB4EAC82CA7396A68D541C85D26508E83_758439640 = drawable;
        } //End block
        catch (Resources.NotFoundException nfe)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1287855339 = null;
        } //End block
        addTaint(drawableId.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_608577908; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_608577908 = varB4EAC82CA7396A68D541C85D26508E83_1260639808;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_608577908 = varB4EAC82CA7396A68D541C85D26508E83_2044795601;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_608577908 = varB4EAC82CA7396A68D541C85D26508E83_1179172739;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_608577908 = varB4EAC82CA7396A68D541C85D26508E83_331167627;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_608577908 = varB4EAC82CA7396A68D541C85D26508E83_758439640;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_608577908 = varB4EAC82CA7396A68D541C85D26508E83_1287855339;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_608577908.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_608577908;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.165 -0400", hash_original_method = "3801EEB25227B54F215AA02CEF91B89D", hash_generated_method = "09E7B69F3175047C1A832BE11DFC52CE")
    private Drawable getDrawable(Uri uri) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1102328311 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_150055908 = null; //Variable for return #2
        Drawable varB4EAC82CA7396A68D541C85D26508E83_2113047119 = null; //Variable for return #3
        try 
        {
            String scheme;
            scheme = uri.getScheme();
            {
                boolean varF1920ADB7A324A214864F4BBBDD05F45_1764139233 = (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(scheme));
                {
                    OpenResourceIdResult r;
                    r = mProviderContext.getContentResolver().getResourceId(uri);
                    try 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1102328311 = r.r.getDrawable(r.id);
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
                        varB4EAC82CA7396A68D541C85D26508E83_150055908 = Drawable.createFromStream(stream, null);
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
        {
            varB4EAC82CA7396A68D541C85D26508E83_2113047119 = null;
        } //End block
        addTaint(uri.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_148315064; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_148315064 = varB4EAC82CA7396A68D541C85D26508E83_1102328311;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_148315064 = varB4EAC82CA7396A68D541C85D26508E83_150055908;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_148315064 = varB4EAC82CA7396A68D541C85D26508E83_2113047119;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_148315064.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_148315064;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.172 -0400", hash_original_method = "9553535B4A93F8E44A1EFE31D535ED8E", hash_generated_method = "8FA9E2727926D93858B8CFFD4B80A45D")
    private Drawable checkIconCache(String resourceUri) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_184243589 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1524537450 = null; //Variable for return #2
        Drawable.ConstantState cached;
        cached = mOutsideDrawablesCache.get(resourceUri);
        {
            varB4EAC82CA7396A68D541C85D26508E83_184243589 = null;
        } //End block
        Log.d(LOG_TAG, "Found icon in cache: " + resourceUri);
        varB4EAC82CA7396A68D541C85D26508E83_1524537450 = cached.newDrawable();
        addTaint(resourceUri.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_1239349446; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1239349446 = varB4EAC82CA7396A68D541C85D26508E83_184243589;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1239349446 = varB4EAC82CA7396A68D541C85D26508E83_1524537450;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1239349446.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1239349446;
        // ---------- Original Method ----------
        //Drawable.ConstantState cached = mOutsideDrawablesCache.get(resourceUri);
        //if (cached == null) {
            //return null;
        //}
        //if (DBG) Log.d(LOG_TAG, "Found icon in cache: " + resourceUri);
        //return cached.newDrawable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.173 -0400", hash_original_method = "7BF5C76588E6E73B227833C6CD1AD962", hash_generated_method = "498CEB28618E44C78E4C28702419267A")
    private void storeInIconCache(String resourceUri, Drawable drawable) {
        {
            mOutsideDrawablesCache.put(resourceUri, drawable.getConstantState());
        } //End block
        addTaint(resourceUri.getTaint());
        addTaint(drawable.getTaint());
        // ---------- Original Method ----------
        //if (drawable != null) {
            //mOutsideDrawablesCache.put(resourceUri, drawable.getConstantState());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.176 -0400", hash_original_method = "24C6C5F14DA2AC5DBA34633E0C5BC43B", hash_generated_method = "A9DC03D8CEEF8445EEC9B7507E60D922")
    private Drawable getDefaultIcon1(Cursor cursor) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1178611507 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1018730573 = null; //Variable for return #2
        Drawable drawable;
        drawable = getActivityIconWithCache(mSearchable.getSearchActivity());
        {
            varB4EAC82CA7396A68D541C85D26508E83_1178611507 = drawable;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1018730573 = mContext.getPackageManager().getDefaultActivityIcon();
        addTaint(cursor.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_205686889; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_205686889 = varB4EAC82CA7396A68D541C85D26508E83_1178611507;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_205686889 = varB4EAC82CA7396A68D541C85D26508E83_1018730573;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_205686889.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_205686889;
        // ---------- Original Method ----------
        //Drawable drawable = getActivityIconWithCache(mSearchable.getSearchActivity());
        //if (drawable != null) {
            //return drawable;
        //}
        //return mContext.getPackageManager().getDefaultActivityIcon();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.181 -0400", hash_original_method = "1ABDDD143C3A87EFB8B7D38CA2C4068F", hash_generated_method = "05752FF03ACC97783C8B07F21A94C604")
    private Drawable getActivityIconWithCache(ComponentName component) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1358731189 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1073189134 = null; //Variable for return #2
        String componentIconKey;
        componentIconKey = component.flattenToShortString();
        {
            boolean var5A3FED2D0F34D844AB05B6B3BADFCD1F_1476477788 = (mOutsideDrawablesCache.containsKey(componentIconKey));
            {
                Drawable.ConstantState cached;
                cached = mOutsideDrawablesCache.get(componentIconKey);
                varB4EAC82CA7396A68D541C85D26508E83_1358731189 = cached == null ? null : cached.newDrawable(mProviderContext.getResources());
            } //End block
        } //End collapsed parenthetic
        Drawable drawable;
        drawable = getActivityIcon(component);
        Drawable.ConstantState toCache;
        toCache = null;
        toCache = drawable.getConstantState();
        mOutsideDrawablesCache.put(componentIconKey, toCache);
        varB4EAC82CA7396A68D541C85D26508E83_1073189134 = drawable;
        addTaint(component.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_164720394; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_164720394 = varB4EAC82CA7396A68D541C85D26508E83_1358731189;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_164720394 = varB4EAC82CA7396A68D541C85D26508E83_1073189134;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_164720394.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_164720394;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.183 -0400", hash_original_method = "62EED478ECA0AB495E91A21A2EB22E87", hash_generated_method = "B931C70851C020604A2F20073C7610B4")
    private Drawable getActivityIcon(ComponentName component) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1070666077 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_789230984 = null; //Variable for return #2
        Drawable varB4EAC82CA7396A68D541C85D26508E83_159076626 = null; //Variable for return #3
        Drawable varB4EAC82CA7396A68D541C85D26508E83_301799175 = null; //Variable for return #4
        PackageManager pm;
        pm = mContext.getPackageManager();
        ActivityInfo activityInfo;
        try 
        {
            activityInfo = pm.getActivityInfo(component, PackageManager.GET_META_DATA);
        } //End block
        catch (NameNotFoundException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1070666077 = null;
        } //End block
        int iconId;
        iconId = activityInfo.getIconResource();
        varB4EAC82CA7396A68D541C85D26508E83_789230984 = null;
        String pkg;
        pkg = component.getPackageName();
        Drawable drawable;
        drawable = pm.getDrawable(pkg, iconId, activityInfo.applicationInfo);
        {
            varB4EAC82CA7396A68D541C85D26508E83_159076626 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_301799175 = drawable;
        addTaint(component.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_1687882989; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1687882989 = varB4EAC82CA7396A68D541C85D26508E83_1070666077;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1687882989 = varB4EAC82CA7396A68D541C85D26508E83_789230984;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1687882989 = varB4EAC82CA7396A68D541C85D26508E83_159076626;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1687882989 = varB4EAC82CA7396A68D541C85D26508E83_301799175;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1687882989.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1687882989;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.184 -0400", hash_original_field = "205BE263C74C715DC52CF9A7EA2D73ED", hash_generated_field = "3275A8779DDA322EA97597C856F45009")

        public TextView mText1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.184 -0400", hash_original_field = "1772A2F42FB317DE654726988EC76A3E", hash_generated_field = "E7E5E0130CDA035A703BB3365C609752")

        public TextView mText2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.184 -0400", hash_original_field = "C673825E43818CD99105CCE1AF6F70BF", hash_generated_field = "B10EF113E51700A15611B304B30E7778")

        public ImageView mIcon1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.184 -0400", hash_original_field = "401AE428E1A1CA95FD335942DA31956C", hash_generated_field = "055F53A680C450108241A4F35FFAA884")

        public ImageView mIcon2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.184 -0400", hash_original_field = "424E64D4026EF571F7811E0460C74F68", hash_generated_field = "A8BC95870909A5381D4C019B25F5D8B2")

        public ImageView mIconRefine;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.197 -0400", hash_original_method = "0CE27F5D43D07582A33280C2CC2EDB09", hash_generated_method = "A23527F4592F77FB480D002A2CC11E38")
        public  ChildViewCache(View v) {
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.197 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "B7C4E93D97D072890A37A56076D870F8")

    private static boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.197 -0400", hash_original_field = "6B8D978304A97E85580800EE57FC5F42", hash_generated_field = "609DD6EF7D91E3E172BAB72FDDF3DC52")

    private static String LOG_TAG = "SuggestionsAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.197 -0400", hash_original_field = "DFECEA9C77B80DBC48160A07ACDBDEB4", hash_generated_field = "5D61AC336E10A2E16D45DCA3A83492C4")

    private static int QUERY_LIMIT = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.197 -0400", hash_original_field = "EB7B121651A66593BC5AD08A505BE0A7", hash_generated_field = "B9B6358D09CAF7F7F0DB9CB30C3BF3FB")

    static int REFINE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.197 -0400", hash_original_field = "7E8458192869CFB509A110D384FF690D", hash_generated_field = "6B4A7ED1BBAF063CB2E5E3A4248AAEB3")

    static int REFINE_BY_ENTRY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.197 -0400", hash_original_field = "4C7A7BFA9F30302A906B93D55A815A86", hash_generated_field = "04D1849D0689738627F9B3DE382B8B80")

    static int REFINE_ALL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.197 -0400", hash_original_field = "8C5E8C33309913A25C19F3D2DD557C14", hash_generated_field = "E9E380BE3F181D063151FCDDDCAFFEBF")

    static int INVALID_INDEX = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.197 -0400", hash_original_field = "C4DCE6A318023772AC49B35520D8998B", hash_generated_field = "6556736ADA17679B39279E13D50C8F9B")

    private static long DELETE_KEY_POST_DELAY = 500L;
}

