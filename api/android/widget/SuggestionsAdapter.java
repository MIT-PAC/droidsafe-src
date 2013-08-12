package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.WeakHashMap;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentResolver.OpenResourceIdResult;
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
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.android.internal.R;






class SuggestionsAdapter extends ResourceCursorAdapter implements OnClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.623 -0400", hash_original_field = "32BBEFAC8E5B50979F727CF657FBCDC5", hash_generated_field = "EC37B561700692089320F9D5E535EAC6")

    private SearchManager mSearchManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.623 -0400", hash_original_field = "D1972F87341AF3F5EA90C2B878C0DF14", hash_generated_field = "1366187FE3CF01EF5FC13B6B4154C3DB")

    private SearchView mSearchView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.623 -0400", hash_original_field = "43A23F0BB5F798E421F2CC49BC43D947", hash_generated_field = "6F1511307A7DE5E4BDCE1D082D25D113")

    private SearchableInfo mSearchable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.623 -0400", hash_original_field = "6126F3ADE7D1E4549FE0617BECDD3490", hash_generated_field = "7C7A305D33D1BC28D819A6E4A2AAAF6C")

    private Context mProviderContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.623 -0400", hash_original_field = "14D278A9ED4C8ACF824369307E3457F8", hash_generated_field = "B85E917372D3BED3B3CE8F4DA3D3A6D3")

    private WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.623 -0400", hash_original_field = "D72871D5CE2EB17105099280224B0CCD", hash_generated_field = "0FB4858B613824FE6FDA94A379EBC4D0")

    private boolean mClosed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.623 -0400", hash_original_field = "47B6CCCA247AD0969BBB9DFE3215D674", hash_generated_field = "EE7267ACB8B58771C9C5C8A0A163549B")

    private int mQueryRefinement = REFINE_BY_ENTRY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.623 -0400", hash_original_field = "572AE80BBC94E324C0BFEBD467E07E42", hash_generated_field = "0BE8AC4A70015275FE70EEC0CAC1F0EC")

    private ColorStateList mUrlColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.623 -0400", hash_original_field = "5E58DD57932DBAE40306F966514F2E48", hash_generated_field = "B162451730ABFB26D08AF54099E233CC")

    private int mText1Col = INVALID_INDEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.623 -0400", hash_original_field = "75C325501E7825234D0F714A4256FF6C", hash_generated_field = "745DF2DCD7F688EC03809FDC06531CFD")

    private int mText2Col = INVALID_INDEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.623 -0400", hash_original_field = "EBA70A48EF4356CBB3A99AAD4D731AB6", hash_generated_field = "C018328754CF1F9AD85EF4F02F2ABCC4")

    private int mText2UrlCol = INVALID_INDEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.623 -0400", hash_original_field = "ACF51633A3F89F63F9253117F8735E9E", hash_generated_field = "ABAB9A496D404B9E527D4F1BABD73E1F")

    private int mIconName1Col = INVALID_INDEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.623 -0400", hash_original_field = "74BEF9EF815025303F456B54D93D06B1", hash_generated_field = "A3074C22725E90C5CD06EEE589A84779")

    private int mIconName2Col = INVALID_INDEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.623 -0400", hash_original_field = "E9D1C3E619DB3C340A682F18A7C6A32F", hash_generated_field = "8627CEDD9E8AF7896BE8D1B2E6FCBF94")

    private int mFlagsCol = INVALID_INDEX;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.626 -0400", hash_original_method = "190CAF11C7DD896719D5F8C797EB7D95", hash_generated_method = "D44C093364E74DECD59A8508BBF78903")
    public  SuggestionsAdapter(Context context, SearchView searchView,
            SearchableInfo searchable,
            WeakHashMap<String, Drawable.ConstantState> outsideDrawablesCache) {
        super(context,
                com.android.internal.R.layout.search_dropdown_item_icons_2line,
                null,   
                true);
        addTaint(context.getTaint());
        mSearchManager = (SearchManager) mContext.getSystemService(Context.SEARCH_SERVICE);
        mSearchView = searchView;
        mSearchable = searchable;
        Context activityContext = mSearchable.getActivityContext(mContext);
        mProviderContext = mSearchable.getProviderContext(mContext, activityContext);
        mOutsideDrawablesCache = outsideDrawablesCache;
        getFilter().setDelayer(new Filter.Delayer() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.625 -0400", hash_original_field = "4C620C4F670D4AEB734E374E4D2C5DE7", hash_generated_field = "3C2C3FA0C1C7472676EEF8CAC895BC8D")
        private int mPreviousLength = 0;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.625 -0400", hash_original_method = "724CD13B980D98DDBE94BB34EF222B8A", hash_generated_method = "D6AEE588AF9C6B39714307D0F1931BED")
        public long getPostingDelay(CharSequence constraint) {
            if(constraint == null)            
            {
            long varCFCD208495D565EF66E7DFF9F98764DA_1724800214 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_504623135 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_504623135;
            }
            long delay = constraint.length() < mPreviousLength ? DELETE_KEY_POST_DELAY : 0;
            mPreviousLength = constraint.length();
            long var7243F8BE75253AFBADF7477867021F8B_687499252 = (delay);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1358228413 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1358228413;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.627 -0400", hash_original_method = "7E34E1FAECF41C65A10194A4E061AD6D", hash_generated_method = "C864B094F1586B649248412EF85B9AC7")
    public void setQueryRefinement(int refineWhat) {
        mQueryRefinement = refineWhat;
        // ---------- Original Method ----------
        //mQueryRefinement = refineWhat;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.627 -0400", hash_original_method = "986E9EFF340372ED6B6AF1389D87F9A0", hash_generated_method = "3E4C2F4208ABE95635CF218198A0A391")
    public int getQueryRefinement() {
        int var69EE6C3CFA8048276879EF4C552B5C72_532771262 = (mQueryRefinement);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970894352 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970894352;
        // ---------- Original Method ----------
        //return mQueryRefinement;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.627 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "B7BB2D26A8946C091326E223903E9D70")
    @Override
    public boolean hasStableIds() {
        boolean var68934A3E9455FA72420237EB05902327_1094242138 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1739440662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1739440662;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.628 -0400", hash_original_method = "94A214A70A9BD5FB24F7DC72C91FA8E3", hash_generated_method = "AE3C4D494D604C8973C45A9D1D407B25")
    @Override
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        addTaint(constraint.getTaint());
        if(DBG)        
        Log.d(LOG_TAG, "runQueryOnBackgroundThread(" + constraint + ")");
        String query = (constraint == null) ? "" : constraint.toString();
        Cursor cursor = null;
        if(mSearchView.getVisibility() != View.VISIBLE
                || mSearchView.getWindowVisibility() != View.VISIBLE)        
        {
Cursor var540C13E9E156B687226421B24F2DF178_522873859 =             null;
            var540C13E9E156B687226421B24F2DF178_522873859.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_522873859;
        } //End block
        try 
        {
            cursor = mSearchManager.getSuggestions(mSearchable, query, QUERY_LIMIT);
            if(cursor != null)            
            {
                cursor.getCount();
Cursor varADA3C208DF1628BA935498FB38A6BBD3_496676645 =                 cursor;
                varADA3C208DF1628BA935498FB38A6BBD3_496676645.addTaint(taint);
                return varADA3C208DF1628BA935498FB38A6BBD3_496676645;
            } //End block
        } //End block
        catch (RuntimeException e)
        {
        } //End block
Cursor var540C13E9E156B687226421B24F2DF178_1162165732 =         null;
        var540C13E9E156B687226421B24F2DF178_1162165732.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1162165732;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.629 -0400", hash_original_method = "31DDF4DC630B78B5374FE58E89B45EA8", hash_generated_method = "84E96BE0F6D572B14F268E095F8D12A9")
    public void close() {
        if(DBG)        
        Log.d(LOG_TAG, "close()");
        changeCursor(null);
        mClosed = true;
        // ---------- Original Method ----------
        //if (DBG) Log.d(LOG_TAG, "close()");
        //changeCursor(null);
        //mClosed = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.629 -0400", hash_original_method = "6C6F9D84444AF89C1AA3B4F24466FCA3", hash_generated_method = "FE95B0C6BC1CB5BC7E2447F40C752D99")
    @Override
    public void notifyDataSetChanged() {
        if(DBG)        
        Log.d(LOG_TAG, "notifyDataSetChanged");
        super.notifyDataSetChanged();
        updateSpinnerState(getCursor());
        // ---------- Original Method ----------
        //if (DBG) Log.d(LOG_TAG, "notifyDataSetChanged");
        //super.notifyDataSetChanged();
        //updateSpinnerState(getCursor());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.629 -0400", hash_original_method = "C9146AC3C36F793606A0389850806FAD", hash_generated_method = "2D7CDFF2AB20E7F22E207372BF47260D")
    @Override
    public void notifyDataSetInvalidated() {
        if(DBG)        
        Log.d(LOG_TAG, "notifyDataSetInvalidated");
        super.notifyDataSetInvalidated();
        updateSpinnerState(getCursor());
        // ---------- Original Method ----------
        //if (DBG) Log.d(LOG_TAG, "notifyDataSetInvalidated");
        //super.notifyDataSetInvalidated();
        //updateSpinnerState(getCursor());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.630 -0400", hash_original_method = "1E3B20B61BE1D7016BA8A5BF351CC500", hash_generated_method = "3B81606B76B9DF50C7642E7AC9A946F0")
    private void updateSpinnerState(Cursor cursor) {
        addTaint(cursor.getTaint());
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if(DBG)        
        {
            Log.d(LOG_TAG, "updateSpinnerState - extra = "
                + (extras != null
                        ? extras.getBoolean(SearchManager.CURSOR_EXTRA_KEY_IN_PROGRESS)
                        : null));
        } //End block
        if(extras != null
                && extras.getBoolean(SearchManager.CURSOR_EXTRA_KEY_IN_PROGRESS))        
        {
            return;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.631 -0400", hash_original_method = "148392FC8CA03B9EFECB202A68AE28AE", hash_generated_method = "303BEF85D00482426F58596670309579")
    @Override
    public void changeCursor(Cursor c) {
        if(DBG)        
        Log.d(LOG_TAG, "changeCursor(" + c + ")");
        if(mClosed)        
        {
            if(c != null)            
            c.close();
            return;
        } //End block
        try 
        {
            super.changeCursor(c);
            if(c != null)            
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
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.631 -0400", hash_original_method = "FF2C15D5C77CB986FFC483C5693D319F", hash_generated_method = "FCFA79A3C84277EAA64E31D7C4039F9E")
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(cursor.getTaint());
        addTaint(context.getTaint());
        View v = super.newView(context, cursor, parent);
        v.setTag(new ChildViewCache(v));
View var6DC76BC51820DD65E8396280E884AA78_1947243978 =         v;
        var6DC76BC51820DD65E8396280E884AA78_1947243978.addTaint(taint);
        return var6DC76BC51820DD65E8396280E884AA78_1947243978;
        // ---------- Original Method ----------
        //View v = super.newView(context, cursor, parent);
        //v.setTag(new ChildViewCache(v));
        //return v;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.632 -0400", hash_original_method = "9ABFACDD3FE80D43883DC10EAA51920C", hash_generated_method = "0A7BE312F39E680EDC31CD4427555A05")
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        addTaint(cursor.getTaint());
        addTaint(context.getTaint());
        addTaint(view.getTaint());
        ChildViewCache views = (ChildViewCache) view.getTag();
        int flags = 0;
        if(mFlagsCol != INVALID_INDEX)        
        {
            flags = cursor.getInt(mFlagsCol);
        } //End block
        if(views.mText1 != null)        
        {
            String text1 = getStringOrNull(cursor, mText1Col);
            setViewText(views.mText1, text1);
        } //End block
        if(views.mText2 != null)        
        {
            CharSequence text2 = getStringOrNull(cursor, mText2UrlCol);
            if(text2 != null)            
            {
                text2 = formatUrl(text2);
            } //End block
            else
            {
                text2 = getStringOrNull(cursor, mText2Col);
            } //End block
            if(TextUtils.isEmpty(text2))            
            {
                if(views.mText1 != null)                
                {
                    views.mText1.setSingleLine(false);
                    views.mText1.setMaxLines(2);
                } //End block
            } //End block
            else
            {
                if(views.mText1 != null)                
                {
                    views.mText1.setSingleLine(true);
                    views.mText1.setMaxLines(1);
                } //End block
            } //End block
            setViewText(views.mText2, text2);
        } //End block
        if(views.mIcon1 != null)        
        {
            setViewDrawable(views.mIcon1, getIcon1(cursor), View.INVISIBLE);
        } //End block
        if(views.mIcon2 != null)        
        {
            setViewDrawable(views.mIcon2, getIcon2(cursor), View.GONE);
        } //End block
        if(mQueryRefinement == REFINE_ALL
                || (mQueryRefinement == REFINE_BY_ENTRY
                        && (flags & SearchManager.FLAG_QUERY_REFINEMENT) != 0))        
        {
            views.mIconRefine.setVisibility(View.VISIBLE);
            views.mIconRefine.setTag(views.mText1.getText());
            views.mIconRefine.setOnClickListener(this);
        } //End block
        else
        {
            views.mIconRefine.setVisibility(View.GONE);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.633 -0400", hash_original_method = "21562F430356DF0ADAE2AB54659D8C55", hash_generated_method = "24C6BF93E21392757D9A5CFF397D7472")
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
        Object tag = v.getTag();
        if(tag instanceof CharSequence)        
        {
            mSearchView.onQueryRefine((CharSequence) tag);
        } //End block
        // ---------- Original Method ----------
        //Object tag = v.getTag();
        //if (tag instanceof CharSequence) {
            //mSearchView.onQueryRefine((CharSequence) tag);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.633 -0400", hash_original_method = "9779DF5ADEE23E8777317BAD132048A5", hash_generated_method = "44C12C6B9D22C40D71BBE5AB51539801")
    private CharSequence formatUrl(CharSequence url) {
        addTaint(url.getTaint());
        if(mUrlColor == null)        
        {
            TypedValue colorValue = new TypedValue();
            mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, colorValue, true);
            mUrlColor = mContext.getResources().getColorStateList(colorValue.resourceId);
        } //End block
        SpannableString text = new SpannableString(url);
        text.setSpan(new TextAppearanceSpan(null, 0, 0, mUrlColor, null),
                0, url.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
CharSequence var79CC641C1148018540A26F7ADC424893_438515588 =         text;
        var79CC641C1148018540A26F7ADC424893_438515588.addTaint(taint);
        return var79CC641C1148018540A26F7ADC424893_438515588;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.634 -0400", hash_original_method = "8F61D57F1A865E44B5C7D5D6842EB2D0", hash_generated_method = "1EE7B4E83A027311122972C4C17378C9")
    private void setViewText(TextView v, CharSequence text) {
        addTaint(text.getTaint());
        addTaint(v.getTaint());
        v.setText(text);
        if(TextUtils.isEmpty(text))        
        {
            v.setVisibility(View.GONE);
        } //End block
        else
        {
            v.setVisibility(View.VISIBLE);
        } //End block
        // ---------- Original Method ----------
        //v.setText(text);
        //if (TextUtils.isEmpty(text)) {
            //v.setVisibility(View.GONE);
        //} else {
            //v.setVisibility(View.VISIBLE);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.634 -0400", hash_original_method = "11EBBD91023FF77979C98F4482283D5C", hash_generated_method = "A7F528BF7B3761CAEF90AE8EB1EC7364")
    private Drawable getIcon1(Cursor cursor) {
        addTaint(cursor.getTaint());
        if(mIconName1Col == INVALID_INDEX)        
        {
Drawable var540C13E9E156B687226421B24F2DF178_72207003 =             null;
            var540C13E9E156B687226421B24F2DF178_72207003.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_72207003;
        } //End block
        String value = cursor.getString(mIconName1Col);
        Drawable drawable = getDrawableFromResourceValue(value);
        if(drawable != null)        
        {
Drawable varA22A26D75522826F9AEFA195DDDFD365_1056709547 =             drawable;
            varA22A26D75522826F9AEFA195DDDFD365_1056709547.addTaint(taint);
            return varA22A26D75522826F9AEFA195DDDFD365_1056709547;
        } //End block
Drawable var9AD4BC204A3D1826DA00D930D2EBEF08_1158395991 =         getDefaultIcon1(cursor);
        var9AD4BC204A3D1826DA00D930D2EBEF08_1158395991.addTaint(taint);
        return var9AD4BC204A3D1826DA00D930D2EBEF08_1158395991;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.634 -0400", hash_original_method = "E54FBD6C00322E8129D2706226F8DB3F", hash_generated_method = "073B93826FE270553F638BB650873F49")
    private Drawable getIcon2(Cursor cursor) {
        addTaint(cursor.getTaint());
        if(mIconName2Col == INVALID_INDEX)        
        {
Drawable var540C13E9E156B687226421B24F2DF178_655868295 =             null;
            var540C13E9E156B687226421B24F2DF178_655868295.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_655868295;
        } //End block
        String value = cursor.getString(mIconName2Col);
Drawable var21E893F1882DA73BDFBFEC7A588465D9_1599072099 =         getDrawableFromResourceValue(value);
        var21E893F1882DA73BDFBFEC7A588465D9_1599072099.addTaint(taint);
        return var21E893F1882DA73BDFBFEC7A588465D9_1599072099;
        // ---------- Original Method ----------
        //if (mIconName2Col == INVALID_INDEX) {
            //return null;
        //}
        //String value = cursor.getString(mIconName2Col);
        //return getDrawableFromResourceValue(value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.635 -0400", hash_original_method = "DC13C6A1012A85758DE954F51DF05728", hash_generated_method = "91260607F5AAE82FFA64605A4EF8FACC")
    private void setViewDrawable(ImageView v, Drawable drawable, int nullVisibility) {
        addTaint(nullVisibility);
        addTaint(drawable.getTaint());
        addTaint(v.getTaint());
        v.setImageDrawable(drawable);
        if(drawable == null)        
        {
            v.setVisibility(nullVisibility);
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.635 -0400", hash_original_method = "EEAFA1105ED04DD7E614744D210BB1BA", hash_generated_method = "542CBACFDCB98EE9BDAF7601D8636850")
    @Override
    public CharSequence convertToString(Cursor cursor) {
        addTaint(cursor.getTaint());
        if(cursor == null)        
        {
CharSequence var540C13E9E156B687226421B24F2DF178_602601581 =             null;
            var540C13E9E156B687226421B24F2DF178_602601581.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_602601581;
        } //End block
        String query = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_QUERY);
        if(query != null)        
        {
CharSequence varA8A0683638E4CE91D85122D8CD8F3BAC_1779533265 =             query;
            varA8A0683638E4CE91D85122D8CD8F3BAC_1779533265.addTaint(taint);
            return varA8A0683638E4CE91D85122D8CD8F3BAC_1779533265;
        } //End block
        if(mSearchable.shouldRewriteQueryFromData())        
        {
            String data = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_INTENT_DATA);
            if(data != null)            
            {
CharSequence var0C8B2C9585EB05DD9CD70726CF8CBC07_2146729957 =                 data;
                var0C8B2C9585EB05DD9CD70726CF8CBC07_2146729957.addTaint(taint);
                return var0C8B2C9585EB05DD9CD70726CF8CBC07_2146729957;
            } //End block
        } //End block
        if(mSearchable.shouldRewriteQueryFromText())        
        {
            String text1 = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_TEXT_1);
            if(text1 != null)            
            {
CharSequence var92708E91138455D7FA3ABE9A0C00859C_492193526 =                 text1;
                var92708E91138455D7FA3ABE9A0C00859C_492193526.addTaint(taint);
                return var92708E91138455D7FA3ABE9A0C00859C_492193526;
            } //End block
        } //End block
CharSequence var540C13E9E156B687226421B24F2DF178_463148663 =         null;
        var540C13E9E156B687226421B24F2DF178_463148663.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_463148663;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.636 -0400", hash_original_method = "EC9A6ABF4CBFA211B4EDA728AA0B1D68", hash_generated_method = "072AFB88AE2FB94ED35483DB1CFBE37F")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(position);
        try 
        {
View var40DAE67EE1EF47D285D200B6C4BB0B69_1239361051 =             super.getView(position, convertView, parent);
            var40DAE67EE1EF47D285D200B6C4BB0B69_1239361051.addTaint(taint);
            return var40DAE67EE1EF47D285D200B6C4BB0B69_1239361051;
        } //End block
        catch (RuntimeException e)
        {
            View v = newView(mContext, mCursor, parent);
            if(v != null)            
            {
                ChildViewCache views = (ChildViewCache) v.getTag();
                TextView tv = views.mText1;
                tv.setText(e.toString());
            } //End block
View var6DC76BC51820DD65E8396280E884AA78_1003677203 =             v;
            var6DC76BC51820DD65E8396280E884AA78_1003677203.addTaint(taint);
            return var6DC76BC51820DD65E8396280E884AA78_1003677203;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.637 -0400", hash_original_method = "2062B3ECC79D4C838F6E4FC0FEE6243A", hash_generated_method = "33F8B54B0BC6C5CFE9FBF59E33AB8C39")
    private Drawable getDrawableFromResourceValue(String drawableId) {
        addTaint(drawableId.getTaint());
        if(drawableId == null || drawableId.length() == 0 || "0".equals(drawableId))        
        {
Drawable var540C13E9E156B687226421B24F2DF178_1260539036 =             null;
            var540C13E9E156B687226421B24F2DF178_1260539036.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1260539036;
        } //End block
        try 
        {
            int resourceId = Integer.parseInt(drawableId);
            String drawableUri = ContentResolver.SCHEME_ANDROID_RESOURCE
                    + "://" + mProviderContext.getPackageName() + "/" + resourceId;
            Drawable drawable = checkIconCache(drawableUri);
            if(drawable != null)            
            {
Drawable varA22A26D75522826F9AEFA195DDDFD365_1901568503 =                 drawable;
                varA22A26D75522826F9AEFA195DDDFD365_1901568503.addTaint(taint);
                return varA22A26D75522826F9AEFA195DDDFD365_1901568503;
            } //End block
            drawable = mProviderContext.getResources().getDrawable(resourceId);
            storeInIconCache(drawableUri, drawable);
Drawable varA22A26D75522826F9AEFA195DDDFD365_1360525305 =             drawable;
            varA22A26D75522826F9AEFA195DDDFD365_1360525305.addTaint(taint);
            return varA22A26D75522826F9AEFA195DDDFD365_1360525305;
        } //End block
        catch (NumberFormatException nfe)
        {
            Drawable drawable = checkIconCache(drawableId);
            if(drawable != null)            
            {
Drawable varA22A26D75522826F9AEFA195DDDFD365_2051079005 =                 drawable;
                varA22A26D75522826F9AEFA195DDDFD365_2051079005.addTaint(taint);
                return varA22A26D75522826F9AEFA195DDDFD365_2051079005;
            } //End block
            Uri uri = Uri.parse(drawableId);
            drawable = getDrawable(uri);
            storeInIconCache(drawableId, drawable);
Drawable varA22A26D75522826F9AEFA195DDDFD365_1917741064 =             drawable;
            varA22A26D75522826F9AEFA195DDDFD365_1917741064.addTaint(taint);
            return varA22A26D75522826F9AEFA195DDDFD365_1917741064;
        } //End block
        catch (Resources.NotFoundException nfe)
        {
Drawable var540C13E9E156B687226421B24F2DF178_93646596 =             null;
            var540C13E9E156B687226421B24F2DF178_93646596.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_93646596;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.638 -0400", hash_original_method = "3801EEB25227B54F215AA02CEF91B89D", hash_generated_method = "43AFDAFA31F66E6FD51C75FEA88CE600")
    private Drawable getDrawable(Uri uri) {
        addTaint(uri.getTaint());
        try 
        {
            String scheme = uri.getScheme();
            if(ContentResolver.SCHEME_ANDROID_RESOURCE.equals(scheme))            
            {
                OpenResourceIdResult r = mProviderContext.getContentResolver().getResourceId(uri);
                try 
                {
Drawable var904041F6B8957BF138F5DE81B3D0AB54_1531180186 =                     r.r.getDrawable(r.id);
                    var904041F6B8957BF138F5DE81B3D0AB54_1531180186.addTaint(taint);
                    return var904041F6B8957BF138F5DE81B3D0AB54_1531180186;
                } //End block
                catch (Resources.NotFoundException ex)
                {
                    FileNotFoundException varE8810E522D8B98FEF67E48EC052E3409_1063137687 = new FileNotFoundException("Resource does not exist: " + uri);
                    varE8810E522D8B98FEF67E48EC052E3409_1063137687.addTaint(taint);
                    throw varE8810E522D8B98FEF67E48EC052E3409_1063137687;
                } //End block
            } //End block
            else
            {
                InputStream stream = mProviderContext.getContentResolver().openInputStream(uri);
                if(stream == null)                
                {
                    FileNotFoundException varDE4D719CE1671073F3A4D227BFEB8CF1_220456421 = new FileNotFoundException("Failed to open " + uri);
                    varDE4D719CE1671073F3A4D227BFEB8CF1_220456421.addTaint(taint);
                    throw varDE4D719CE1671073F3A4D227BFEB8CF1_220456421;
                } //End block
                try 
                {
Drawable varACE85D619589350B701D976031D7200E_939706785 =                     Drawable.createFromStream(stream, null);
                    varACE85D619589350B701D976031D7200E_939706785.addTaint(taint);
                    return varACE85D619589350B701D976031D7200E_939706785;
                } //End block
                finally 
                {
                    try 
                    {
                        stream.close();
                    } //End block
                    catch (IOException ex)
                    {
                    } //End block
                } //End block
            } //End block
        } //End block
        catch (FileNotFoundException fnfe)
        {
Drawable var540C13E9E156B687226421B24F2DF178_1758696560 =             null;
            var540C13E9E156B687226421B24F2DF178_1758696560.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1758696560;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.638 -0400", hash_original_method = "9553535B4A93F8E44A1EFE31D535ED8E", hash_generated_method = "30F19B5A74605EA0325036D7B034966A")
    private Drawable checkIconCache(String resourceUri) {
        addTaint(resourceUri.getTaint());
        Drawable.ConstantState cached = mOutsideDrawablesCache.get(resourceUri);
        if(cached == null)        
        {
Drawable var540C13E9E156B687226421B24F2DF178_1952620009 =             null;
            var540C13E9E156B687226421B24F2DF178_1952620009.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1952620009;
        } //End block
        if(DBG)        
        Log.d(LOG_TAG, "Found icon in cache: " + resourceUri);
Drawable varC166530EF056087EC0119B98D4606244_978754328 =         cached.newDrawable();
        varC166530EF056087EC0119B98D4606244_978754328.addTaint(taint);
        return varC166530EF056087EC0119B98D4606244_978754328;
        // ---------- Original Method ----------
        //Drawable.ConstantState cached = mOutsideDrawablesCache.get(resourceUri);
        //if (cached == null) {
            //return null;
        //}
        //if (DBG) Log.d(LOG_TAG, "Found icon in cache: " + resourceUri);
        //return cached.newDrawable();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.638 -0400", hash_original_method = "7BF5C76588E6E73B227833C6CD1AD962", hash_generated_method = "3ED05289173759696DA651B530D3F928")
    private void storeInIconCache(String resourceUri, Drawable drawable) {
        addTaint(drawable.getTaint());
        addTaint(resourceUri.getTaint());
        if(drawable != null)        
        {
            mOutsideDrawablesCache.put(resourceUri, drawable.getConstantState());
        } //End block
        // ---------- Original Method ----------
        //if (drawable != null) {
            //mOutsideDrawablesCache.put(resourceUri, drawable.getConstantState());
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.638 -0400", hash_original_method = "24C6C5F14DA2AC5DBA34633E0C5BC43B", hash_generated_method = "C88AF065E02EBC81CF0F9883F03D79B3")
    private Drawable getDefaultIcon1(Cursor cursor) {
        addTaint(cursor.getTaint());
        Drawable drawable = getActivityIconWithCache(mSearchable.getSearchActivity());
        if(drawable != null)        
        {
Drawable varA22A26D75522826F9AEFA195DDDFD365_1942962753 =             drawable;
            varA22A26D75522826F9AEFA195DDDFD365_1942962753.addTaint(taint);
            return varA22A26D75522826F9AEFA195DDDFD365_1942962753;
        } //End block
Drawable varBD2C8D7E3D6418B04EE42992C4465182_1054890541 =         mContext.getPackageManager().getDefaultActivityIcon();
        varBD2C8D7E3D6418B04EE42992C4465182_1054890541.addTaint(taint);
        return varBD2C8D7E3D6418B04EE42992C4465182_1054890541;
        // ---------- Original Method ----------
        //Drawable drawable = getActivityIconWithCache(mSearchable.getSearchActivity());
        //if (drawable != null) {
            //return drawable;
        //}
        //return mContext.getPackageManager().getDefaultActivityIcon();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.638 -0400", hash_original_method = "1ABDDD143C3A87EFB8B7D38CA2C4068F", hash_generated_method = "DAD1DA3171B3FB2CEBEE4E4D6F15EC1B")
    private Drawable getActivityIconWithCache(ComponentName component) {
        addTaint(component.getTaint());
        String componentIconKey = component.flattenToShortString();
        if(mOutsideDrawablesCache.containsKey(componentIconKey))        
        {
            Drawable.ConstantState cached = mOutsideDrawablesCache.get(componentIconKey);
Drawable var62EA6A16E3DF534870B2EB7B647793F5_818880969 =             cached == null ? null : cached.newDrawable(mProviderContext.getResources());
            var62EA6A16E3DF534870B2EB7B647793F5_818880969.addTaint(taint);
            return var62EA6A16E3DF534870B2EB7B647793F5_818880969;
        } //End block
        Drawable drawable = getActivityIcon(component);
        Drawable.ConstantState toCache = drawable == null ? null : drawable.getConstantState();
        mOutsideDrawablesCache.put(componentIconKey, toCache);
Drawable varA22A26D75522826F9AEFA195DDDFD365_953351979 =         drawable;
        varA22A26D75522826F9AEFA195DDDFD365_953351979.addTaint(taint);
        return varA22A26D75522826F9AEFA195DDDFD365_953351979;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.639 -0400", hash_original_method = "62EED478ECA0AB495E91A21A2EB22E87", hash_generated_method = "2FD0535C7ACC7E6D34D39D9BA8351953")
    private Drawable getActivityIcon(ComponentName component) {
        addTaint(component.getTaint());
        PackageManager pm = mContext.getPackageManager();
        ActivityInfo activityInfo;
        try 
        {
            activityInfo = pm.getActivityInfo(component, PackageManager.GET_META_DATA);
        } //End block
        catch (NameNotFoundException ex)
        {
Drawable var540C13E9E156B687226421B24F2DF178_18350292 =             null;
            var540C13E9E156B687226421B24F2DF178_18350292.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_18350292;
        } //End block
        int iconId = activityInfo.getIconResource();
        if(iconId == 0)        
        {
Drawable var540C13E9E156B687226421B24F2DF178_1948618411 =         null;
        var540C13E9E156B687226421B24F2DF178_1948618411.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1948618411;
        }
        String pkg = component.getPackageName();
        Drawable drawable = pm.getDrawable(pkg, iconId, activityInfo.applicationInfo);
        if(drawable == null)        
        {
Drawable var540C13E9E156B687226421B24F2DF178_511242779 =             null;
            var540C13E9E156B687226421B24F2DF178_511242779.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_511242779;
        } //End block
Drawable varA22A26D75522826F9AEFA195DDDFD365_1183784229 =         drawable;
        varA22A26D75522826F9AEFA195DDDFD365_1183784229.addTaint(taint);
        return varA22A26D75522826F9AEFA195DDDFD365_1183784229;
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

    
    @DSModeled(DSC.SAFE)
    public static String getColumnString(Cursor cursor, String columnName) {
        int col = cursor.getColumnIndex(columnName);
        return getStringOrNull(cursor, col);
    }

    
    @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.639 -0400", hash_original_field = "205BE263C74C715DC52CF9A7EA2D73ED", hash_generated_field = "3275A8779DDA322EA97597C856F45009")

        public TextView mText1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.639 -0400", hash_original_field = "1772A2F42FB317DE654726988EC76A3E", hash_generated_field = "E7E5E0130CDA035A703BB3365C609752")

        public TextView mText2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.639 -0400", hash_original_field = "C673825E43818CD99105CCE1AF6F70BF", hash_generated_field = "B10EF113E51700A15611B304B30E7778")

        public ImageView mIcon1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.639 -0400", hash_original_field = "401AE428E1A1CA95FD335942DA31956C", hash_generated_field = "055F53A680C450108241A4F35FFAA884")

        public ImageView mIcon2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.640 -0400", hash_original_field = "424E64D4026EF571F7811E0460C74F68", hash_generated_field = "A8BC95870909A5381D4C019B25F5D8B2")

        public ImageView mIconRefine;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.640 -0400", hash_original_method = "0CE27F5D43D07582A33280C2CC2EDB09", hash_generated_method = "A23527F4592F77FB480D002A2CC11E38")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.640 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.640 -0400", hash_original_field = "6B8D978304A97E85580800EE57FC5F42", hash_generated_field = "10677C9028A9E03475AECA5E3EA8B569")

    private static final String LOG_TAG = "SuggestionsAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.640 -0400", hash_original_field = "DFECEA9C77B80DBC48160A07ACDBDEB4", hash_generated_field = "719CAAA89185A96380841381EE84A3E5")

    private static final int QUERY_LIMIT = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.640 -0400", hash_original_field = "EB7B121651A66593BC5AD08A505BE0A7", hash_generated_field = "98E9087104FBAF95AD5B62C304A0CCFF")

    static final int REFINE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.640 -0400", hash_original_field = "7E8458192869CFB509A110D384FF690D", hash_generated_field = "837D31B49612E7145EBEC07CF04BC9EF")

    static final int REFINE_BY_ENTRY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.640 -0400", hash_original_field = "4C7A7BFA9F30302A906B93D55A815A86", hash_generated_field = "8DB1B3241AF2F750ED09F16EC1479E52")

    static final int REFINE_ALL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.640 -0400", hash_original_field = "8C5E8C33309913A25C19F3D2DD557C14", hash_generated_field = "5DFAE43769080A8126AF66611D827CF3")

    static final int INVALID_INDEX = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.640 -0400", hash_original_field = "C4DCE6A318023772AC49B35520D8998B", hash_generated_field = "62DEDC9529CE21BA5D13EE75A6ACE45D")

    private static final long DELETE_KEY_POST_DELAY = 500L;
}

