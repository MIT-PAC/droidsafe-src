package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.143 -0400", hash_original_field = "32BBEFAC8E5B50979F727CF657FBCDC5", hash_generated_field = "EC37B561700692089320F9D5E535EAC6")

    private SearchManager mSearchManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.143 -0400", hash_original_field = "D1972F87341AF3F5EA90C2B878C0DF14", hash_generated_field = "1366187FE3CF01EF5FC13B6B4154C3DB")

    private SearchView mSearchView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.143 -0400", hash_original_field = "43A23F0BB5F798E421F2CC49BC43D947", hash_generated_field = "6F1511307A7DE5E4BDCE1D082D25D113")

    private SearchableInfo mSearchable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.143 -0400", hash_original_field = "6126F3ADE7D1E4549FE0617BECDD3490", hash_generated_field = "7C7A305D33D1BC28D819A6E4A2AAAF6C")

    private Context mProviderContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.143 -0400", hash_original_field = "14D278A9ED4C8ACF824369307E3457F8", hash_generated_field = "B85E917372D3BED3B3CE8F4DA3D3A6D3")

    private WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.143 -0400", hash_original_field = "D72871D5CE2EB17105099280224B0CCD", hash_generated_field = "0FB4858B613824FE6FDA94A379EBC4D0")

    private boolean mClosed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.143 -0400", hash_original_field = "47B6CCCA247AD0969BBB9DFE3215D674", hash_generated_field = "EE7267ACB8B58771C9C5C8A0A163549B")

    private int mQueryRefinement = REFINE_BY_ENTRY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.143 -0400", hash_original_field = "572AE80BBC94E324C0BFEBD467E07E42", hash_generated_field = "0BE8AC4A70015275FE70EEC0CAC1F0EC")

    private ColorStateList mUrlColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.143 -0400", hash_original_field = "5E58DD57932DBAE40306F966514F2E48", hash_generated_field = "B162451730ABFB26D08AF54099E233CC")

    private int mText1Col = INVALID_INDEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.143 -0400", hash_original_field = "75C325501E7825234D0F714A4256FF6C", hash_generated_field = "745DF2DCD7F688EC03809FDC06531CFD")

    private int mText2Col = INVALID_INDEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.143 -0400", hash_original_field = "EBA70A48EF4356CBB3A99AAD4D731AB6", hash_generated_field = "C018328754CF1F9AD85EF4F02F2ABCC4")

    private int mText2UrlCol = INVALID_INDEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.143 -0400", hash_original_field = "ACF51633A3F89F63F9253117F8735E9E", hash_generated_field = "ABAB9A496D404B9E527D4F1BABD73E1F")

    private int mIconName1Col = INVALID_INDEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.143 -0400", hash_original_field = "74BEF9EF815025303F456B54D93D06B1", hash_generated_field = "A3074C22725E90C5CD06EEE589A84779")

    private int mIconName2Col = INVALID_INDEX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.143 -0400", hash_original_field = "E9D1C3E619DB3C340A682F18A7C6A32F", hash_generated_field = "8627CEDD9E8AF7896BE8D1B2E6FCBF94")

    private int mFlagsCol = INVALID_INDEX;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.144 -0400", hash_original_method = "190CAF11C7DD896719D5F8C797EB7D95", hash_generated_method = "1E38FBA04CFFF309A3FC52095DA372D7")
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
        Context activityContext = mSearchable.getActivityContext(mContext);
        mProviderContext = mSearchable.getProviderContext(mContext, activityContext);
        mOutsideDrawablesCache = outsideDrawablesCache;
        getFilter().setDelayer(new Filter.Delayer() {            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.144 -0400", hash_original_field = "4C620C4F670D4AEB734E374E4D2C5DE7", hash_generated_field = "3C2C3FA0C1C7472676EEF8CAC895BC8D")
            private int mPreviousLength = 0;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.144 -0400", hash_original_method = "724CD13B980D98DDBE94BB34EF222B8A", hash_generated_method = "A357BBC9EFB94D3E9681D889ACC1AA91")
            public long getPostingDelay(CharSequence constraint) {
                long delay;
                boolean var86130193B74E4EA7B26601F90461C8D2_176569151 = (constraint.length() < mPreviousLength);
                delay = DELETE_KEY_POST_DELAY;
                delay = 0;
                mPreviousLength = constraint.length();
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2121881651 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_2121881651;
                
                
                
                
                
            }
});
        addTaint(context.getTaint());
        
        
        
        
        
        
        
        
            
            
                
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.144 -0400", hash_original_method = "7E34E1FAECF41C65A10194A4E061AD6D", hash_generated_method = "C864B094F1586B649248412EF85B9AC7")
    public void setQueryRefinement(int refineWhat) {
        mQueryRefinement = refineWhat;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.145 -0400", hash_original_method = "986E9EFF340372ED6B6AF1389D87F9A0", hash_generated_method = "59BC632D7521BCBAFC94EECA9EE35518")
    public int getQueryRefinement() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192588840 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192588840;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.145 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "31165B2940BE98D6586BAB70D0DD67B7")
    @Override
    public boolean hasStableIds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1228732105 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1228732105;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.146 -0400", hash_original_method = "94A214A70A9BD5FB24F7DC72C91FA8E3", hash_generated_method = "A43335D972CB308454C34D6A752C13A7")
    @Override
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_2111649664 = null; 
        Cursor varB4EAC82CA7396A68D541C85D26508E83_2085865254 = null; 
        Cursor varB4EAC82CA7396A68D541C85D26508E83_369680945 = null; 
        Log.d(LOG_TAG, "runQueryOnBackgroundThread(" + constraint + ")");
        String query;
        query = "";
        query = constraint.toString();
        Cursor cursor = null;
        {
            boolean var1FD321E2413C37BB7BF6265879DF7132_1088619453 = (mSearchView.getVisibility() != View.VISIBLE
                || mSearchView.getWindowVisibility() != View.VISIBLE);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2111649664 = null;
            } 
        } 
        try 
        {
            cursor = mSearchManager.getSuggestions(mSearchable, query, QUERY_LIMIT);
            {
                cursor.getCount();
                varB4EAC82CA7396A68D541C85D26508E83_2085865254 = cursor;
            } 
        } 
        catch (RuntimeException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_369680945 = null;
        addTaint(constraint.getTaint());
        Cursor varA7E53CE21691AB073D9660D615818899_1949496635; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1949496635 = varB4EAC82CA7396A68D541C85D26508E83_2111649664;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1949496635 = varB4EAC82CA7396A68D541C85D26508E83_2085865254;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1949496635 = varB4EAC82CA7396A68D541C85D26508E83_369680945;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1949496635.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1949496635;
        
        
        
        
        
                
            
        
        
            
            
                
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.147 -0400", hash_original_method = "31DDF4DC630B78B5374FE58E89B45EA8", hash_generated_method = "C7D7BD489C69CF8812EDED66E65A8F4C")
    public void close() {
        Log.d(LOG_TAG, "close()");
        changeCursor(null);
        mClosed = true;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.147 -0400", hash_original_method = "6C6F9D84444AF89C1AA3B4F24466FCA3", hash_generated_method = "8B9EEDC1009B20B2D1E17A6FA08ADD72")
    @Override
    public void notifyDataSetChanged() {
        Log.d(LOG_TAG, "notifyDataSetChanged");
        super.notifyDataSetChanged();
        updateSpinnerState(getCursor());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.148 -0400", hash_original_method = "C9146AC3C36F793606A0389850806FAD", hash_generated_method = "6B93AEE0079E5CB1BBCFFD1FCD57FEA0")
    @Override
    public void notifyDataSetInvalidated() {
        Log.d(LOG_TAG, "notifyDataSetInvalidated");
        super.notifyDataSetInvalidated();
        updateSpinnerState(getCursor());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.148 -0400", hash_original_method = "1E3B20B61BE1D7016BA8A5BF351CC500", hash_generated_method = "2CC389BD65C5AB933DB3396B46C09F5D")
    private void updateSpinnerState(Cursor cursor) {
        Bundle extras;
        extras = cursor.getExtras();
        extras = null;
        {
            Log.d(LOG_TAG, "updateSpinnerState - extra = "
                + (extras != null
                        ? extras.getBoolean(SearchManager.CURSOR_EXTRA_KEY_IN_PROGRESS)
                        : null));
        } 
        {
            boolean var50462C069FC0D18F392466D196957EC9_1167030327 = (extras != null
                && extras.getBoolean(SearchManager.CURSOR_EXTRA_KEY_IN_PROGRESS));
        } 
        addTaint(cursor.getTaint());
        
        
        
            
                
                        
                        
        
        
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.149 -0400", hash_original_method = "148392FC8CA03B9EFECB202A68AE28AE", hash_generated_method = "13DB8FA6532C059DCDAD7D2B0364B6D8")
    @Override
    public void changeCursor(Cursor c) {
        Log.d(LOG_TAG, "changeCursor(" + c + ")");
        {
            c.close();
        } 
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
            } 
        } 
        catch (Exception e)
        { }
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.149 -0400", hash_original_method = "FF2C15D5C77CB986FFC483C5693D319F", hash_generated_method = "BCD61EEB5FBC9A266C2CA4779555AD83")
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_767418046 = null; 
        View v = super.newView(context, cursor, parent);
        v.setTag(new ChildViewCache(v));
        varB4EAC82CA7396A68D541C85D26508E83_767418046 = v;
        addTaint(context.getTaint());
        addTaint(cursor.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_767418046.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_767418046;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.150 -0400", hash_original_method = "9ABFACDD3FE80D43883DC10EAA51920C", hash_generated_method = "5D693FE87D35D13DAC95C7F01BF8F322")
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ChildViewCache views = (ChildViewCache) view.getTag();
        int flags = 0;
        {
            flags = cursor.getInt(mFlagsCol);
        } 
        {
            String text1 = getStringOrNull(cursor, mText1Col);
            setViewText(views.mText1, text1);
        } 
        {
            CharSequence text2 = getStringOrNull(cursor, mText2UrlCol);
            {
                text2 = formatUrl(text2);
            } 
            {
                text2 = getStringOrNull(cursor, mText2Col);
            } 
            {
                boolean varB9DE4693D5C635CA8EC30AA4FD17DA9F_116100174 = (TextUtils.isEmpty(text2));
                {
                    {
                        views.mText1.setSingleLine(false);
                        views.mText1.setMaxLines(2);
                    } 
                } 
                {
                    {
                        views.mText1.setSingleLine(true);
                        views.mText1.setMaxLines(1);
                    } 
                } 
            } 
            setViewText(views.mText2, text2);
        } 
        {
            setViewDrawable(views.mIcon1, getIcon1(cursor), View.INVISIBLE);
        } 
        {
            setViewDrawable(views.mIcon2, getIcon2(cursor), View.GONE);
        } 
        {
            views.mIconRefine.setVisibility(View.VISIBLE);
            views.mIconRefine.setTag(views.mText1.getText());
            views.mIconRefine.setOnClickListener(this);
        } 
        {
            views.mIconRefine.setVisibility(View.GONE);
        } 
        addTaint(view.getTaint());
        addTaint(context.getTaint());
        addTaint(cursor.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.150 -0400", hash_original_method = "21562F430356DF0ADAE2AB54659D8C55", hash_generated_method = "3F35649B722ADA0A948D4A742B0BD9B1")
    public void onClick(View v) {
        
        Object tag = v.getTag();
        {
            mSearchView.onQueryRefine((CharSequence) tag);
        } 
        addTaint(v.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.151 -0400", hash_original_method = "9779DF5ADEE23E8777317BAD132048A5", hash_generated_method = "9041F272FCBA20855D1CF5B7A987BE5E")
    private CharSequence formatUrl(CharSequence url) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1406257448 = null; 
        {
            TypedValue colorValue = new TypedValue();
            mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, colorValue, true);
            mUrlColor = mContext.getResources().getColorStateList(colorValue.resourceId);
        } 
        SpannableString text = new SpannableString(url);
        text.setSpan(new TextAppearanceSpan(null, 0, 0, mUrlColor, null),
                0, url.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        varB4EAC82CA7396A68D541C85D26508E83_1406257448 = text;
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1406257448.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1406257448;
        
        
            
            
            
        
        
        
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.151 -0400", hash_original_method = "8F61D57F1A865E44B5C7D5D6842EB2D0", hash_generated_method = "116CF76F26AB33429D01727449C59DBB")
    private void setViewText(TextView v, CharSequence text) {
        v.setText(text);
        {
            boolean var6C86A511CD0D2845B6E0259573F6A612_1766828480 = (TextUtils.isEmpty(text));
            {
                v.setVisibility(View.GONE);
            } 
            {
                v.setVisibility(View.VISIBLE);
            } 
        } 
        addTaint(v.getTaint());
        addTaint(text.getTaint());
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.152 -0400", hash_original_method = "11EBBD91023FF77979C98F4482283D5C", hash_generated_method = "7A1F0CF494DF9886D8F249A60E586129")
    private Drawable getIcon1(Cursor cursor) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_373680985 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_39307229 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1348921753 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_373680985 = null;
        } 
        String value = cursor.getString(mIconName1Col);
        Drawable drawable = getDrawableFromResourceValue(value);
        {
            varB4EAC82CA7396A68D541C85D26508E83_39307229 = drawable;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1348921753 = getDefaultIcon1(cursor);
        addTaint(cursor.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_1163567551; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1163567551 = varB4EAC82CA7396A68D541C85D26508E83_373680985;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1163567551 = varB4EAC82CA7396A68D541C85D26508E83_39307229;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1163567551 = varB4EAC82CA7396A68D541C85D26508E83_1348921753;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1163567551.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1163567551;
        
        
            
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.153 -0400", hash_original_method = "E54FBD6C00322E8129D2706226F8DB3F", hash_generated_method = "55ABB29D3F0E6FBB09B39DE07ADC414F")
    private Drawable getIcon2(Cursor cursor) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_527369927 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1169494897 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_527369927 = null;
        } 
        String value = cursor.getString(mIconName2Col);
        varB4EAC82CA7396A68D541C85D26508E83_1169494897 = getDrawableFromResourceValue(value);
        addTaint(cursor.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_973368988; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_973368988 = varB4EAC82CA7396A68D541C85D26508E83_527369927;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_973368988 = varB4EAC82CA7396A68D541C85D26508E83_1169494897;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_973368988.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_973368988;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.153 -0400", hash_original_method = "DC13C6A1012A85758DE954F51DF05728", hash_generated_method = "9D85F41AC2B492F8E8C048A9E3029074")
    private void setViewDrawable(ImageView v, Drawable drawable, int nullVisibility) {
        v.setImageDrawable(drawable);
        {
            v.setVisibility(nullVisibility);
        } 
        {
            v.setVisibility(View.VISIBLE);
            drawable.setVisible(false, false);
            drawable.setVisible(true, false);
        } 
        addTaint(v.getTaint());
        addTaint(drawable.getTaint());
        addTaint(nullVisibility);
        
        
        
            
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.154 -0400", hash_original_method = "EEAFA1105ED04DD7E614744D210BB1BA", hash_generated_method = "E3BE558B46DCB899E82688C2D66CA1ED")
    @Override
    public CharSequence convertToString(Cursor cursor) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1659813062 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_831210557 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_665887122 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1882843960 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1352337354 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1659813062 = null;
        } 
        String query = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_QUERY);
        {
            varB4EAC82CA7396A68D541C85D26508E83_831210557 = query;
        } 
        {
            boolean varE8FE5C36D8FE1523056BAB9AB236D1EA_1287283854 = (mSearchable.shouldRewriteQueryFromData());
            {
                String data = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_INTENT_DATA);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_665887122 = data;
                } 
            } 
        } 
        {
            boolean var29845B1F9A9491B3FE6CECDC2E20A3FE_48218834 = (mSearchable.shouldRewriteQueryFromText());
            {
                String text1 = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_TEXT_1);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1882843960 = text1;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1352337354 = null;
        addTaint(cursor.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1353174011; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1353174011 = varB4EAC82CA7396A68D541C85D26508E83_1659813062;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1353174011 = varB4EAC82CA7396A68D541C85D26508E83_831210557;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1353174011 = varB4EAC82CA7396A68D541C85D26508E83_665887122;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1353174011 = varB4EAC82CA7396A68D541C85D26508E83_1882843960;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1353174011 = varB4EAC82CA7396A68D541C85D26508E83_1352337354;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1353174011.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1353174011;
        
        
            
        
        
        
            
        
        
            
            
                
            
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.155 -0400", hash_original_method = "EC9A6ABF4CBFA211B4EDA728AA0B1D68", hash_generated_method = "5E7FF96EE0BB90A8714050597FB98ACD")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_2100652972 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_256203736 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2100652972 = super.getView(position, convertView, parent);
        } 
        catch (RuntimeException e)
        {
            View v = newView(mContext, mCursor, parent);
            {
                ChildViewCache views = (ChildViewCache) v.getTag();
                TextView tv = views.mText1;
                tv.setText(e.toString());
            } 
            varB4EAC82CA7396A68D541C85D26508E83_256203736 = v;
        } 
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        View varA7E53CE21691AB073D9660D615818899_45019080; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_45019080 = varB4EAC82CA7396A68D541C85D26508E83_2100652972;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_45019080 = varB4EAC82CA7396A68D541C85D26508E83_256203736;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_45019080.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_45019080;
        
        
            
        
            
            
            
                
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.157 -0400", hash_original_method = "2062B3ECC79D4C838F6E4FC0FEE6243A", hash_generated_method = "992BA7410A15C8ADD1FEF9026F64EA1A")
    private Drawable getDrawableFromResourceValue(String drawableId) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1943472222 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_172320186 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1044845214 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1707851178 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_578201372 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_44965849 = null; 
        {
            boolean var28BB864B60CF8C657D6DC33CCB43E344_141677341 = (drawableId == null || drawableId.length() == 0 || "0".equals(drawableId));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1943472222 = null;
            } 
        } 
        try 
        {
            int resourceId = Integer.parseInt(drawableId);
            String drawableUri = ContentResolver.SCHEME_ANDROID_RESOURCE
                    + "://" + mProviderContext.getPackageName() + "/" + resourceId;
            Drawable drawable = checkIconCache(drawableUri);
            {
                varB4EAC82CA7396A68D541C85D26508E83_172320186 = drawable;
            } 
            drawable = mProviderContext.getResources().getDrawable(resourceId);
            storeInIconCache(drawableUri, drawable);
            varB4EAC82CA7396A68D541C85D26508E83_1044845214 = drawable;
        } 
        catch (NumberFormatException nfe)
        {
            Drawable drawable = checkIconCache(drawableId);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1707851178 = drawable;
            } 
            Uri uri = Uri.parse(drawableId);
            drawable = getDrawable(uri);
            storeInIconCache(drawableId, drawable);
            varB4EAC82CA7396A68D541C85D26508E83_578201372 = drawable;
        } 
        catch (Resources.NotFoundException nfe)
        {
            varB4EAC82CA7396A68D541C85D26508E83_44965849 = null;
        } 
        addTaint(drawableId.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_2135728044; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2135728044 = varB4EAC82CA7396A68D541C85D26508E83_1943472222;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2135728044 = varB4EAC82CA7396A68D541C85D26508E83_172320186;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_2135728044 = varB4EAC82CA7396A68D541C85D26508E83_1044845214;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_2135728044 = varB4EAC82CA7396A68D541C85D26508E83_1707851178;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_2135728044 = varB4EAC82CA7396A68D541C85D26508E83_578201372;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2135728044 = varB4EAC82CA7396A68D541C85D26508E83_44965849;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2135728044.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2135728044;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.159 -0400", hash_original_method = "3801EEB25227B54F215AA02CEF91B89D", hash_generated_method = "8D832724488DCF3F96159B7B06D65744")
    private Drawable getDrawable(Uri uri) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_204283167 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1185299870 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1799891153 = null; 
        try 
        {
            String scheme = uri.getScheme();
            {
                boolean varF1920ADB7A324A214864F4BBBDD05F45_779449844 = (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(scheme));
                {
                    OpenResourceIdResult r = mProviderContext.getContentResolver().getResourceId(uri);
                    try 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_204283167 = r.r.getDrawable(r.id);
                    } 
                    catch (Resources.NotFoundException ex)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Resource does not exist: " + uri);
                    } 
                } 
                {
                    InputStream stream = mProviderContext.getContentResolver().openInputStream(uri);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Failed to open " + uri);
                    } 
                    try 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1185299870 = Drawable.createFromStream(stream, null);
                    } 
                    finally 
                    {
                        try 
                        {
                            stream.close();
                        } 
                        catch (IOException ex)
                        { }
                    } 
                } 
            } 
        } 
        catch (FileNotFoundException fnfe)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1799891153 = null;
        } 
        addTaint(uri.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_572615660; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_572615660 = varB4EAC82CA7396A68D541C85D26508E83_204283167;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_572615660 = varB4EAC82CA7396A68D541C85D26508E83_1185299870;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_572615660 = varB4EAC82CA7396A68D541C85D26508E83_1799891153;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_572615660.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_572615660;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.160 -0400", hash_original_method = "9553535B4A93F8E44A1EFE31D535ED8E", hash_generated_method = "890445DA3B460BDD26B5A154E6216441")
    private Drawable checkIconCache(String resourceUri) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1104704724 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_12541546 = null; 
        Drawable.ConstantState cached = mOutsideDrawablesCache.get(resourceUri);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1104704724 = null;
        } 
        Log.d(LOG_TAG, "Found icon in cache: " + resourceUri);
        varB4EAC82CA7396A68D541C85D26508E83_12541546 = cached.newDrawable();
        addTaint(resourceUri.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_1933024904; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1933024904 = varB4EAC82CA7396A68D541C85D26508E83_1104704724;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1933024904 = varB4EAC82CA7396A68D541C85D26508E83_12541546;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1933024904.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1933024904;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.161 -0400", hash_original_method = "7BF5C76588E6E73B227833C6CD1AD962", hash_generated_method = "498CEB28618E44C78E4C28702419267A")
    private void storeInIconCache(String resourceUri, Drawable drawable) {
        {
            mOutsideDrawablesCache.put(resourceUri, drawable.getConstantState());
        } 
        addTaint(resourceUri.getTaint());
        addTaint(drawable.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.161 -0400", hash_original_method = "24C6C5F14DA2AC5DBA34633E0C5BC43B", hash_generated_method = "CD233370925F4E7DDF973027C506AA9F")
    private Drawable getDefaultIcon1(Cursor cursor) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1767196459 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1869762838 = null; 
        Drawable drawable = getActivityIconWithCache(mSearchable.getSearchActivity());
        {
            varB4EAC82CA7396A68D541C85D26508E83_1767196459 = drawable;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1869762838 = mContext.getPackageManager().getDefaultActivityIcon();
        addTaint(cursor.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_1265933194; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1265933194 = varB4EAC82CA7396A68D541C85D26508E83_1767196459;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1265933194 = varB4EAC82CA7396A68D541C85D26508E83_1869762838;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1265933194.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1265933194;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.162 -0400", hash_original_method = "1ABDDD143C3A87EFB8B7D38CA2C4068F", hash_generated_method = "6B543F517C0D23C96327315D4535EEDF")
    private Drawable getActivityIconWithCache(ComponentName component) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_981377096 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_333643595 = null; 
        String componentIconKey = component.flattenToShortString();
        {
            boolean var5A3FED2D0F34D844AB05B6B3BADFCD1F_251542924 = (mOutsideDrawablesCache.containsKey(componentIconKey));
            {
                Drawable.ConstantState cached = mOutsideDrawablesCache.get(componentIconKey);
                varB4EAC82CA7396A68D541C85D26508E83_981377096 = cached == null ? null : cached.newDrawable(mProviderContext.getResources());
            } 
        } 
        Drawable drawable = getActivityIcon(component);
        Drawable.ConstantState toCache;
        toCache = null;
        toCache = drawable.getConstantState();
        mOutsideDrawablesCache.put(componentIconKey, toCache);
        varB4EAC82CA7396A68D541C85D26508E83_333643595 = drawable;
        addTaint(component.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_1978890620; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1978890620 = varB4EAC82CA7396A68D541C85D26508E83_981377096;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1978890620 = varB4EAC82CA7396A68D541C85D26508E83_333643595;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1978890620.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1978890620;
        
        
        
            
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.163 -0400", hash_original_method = "62EED478ECA0AB495E91A21A2EB22E87", hash_generated_method = "53D1FB0283BBEC3E3DE3476B26ABE31D")
    private Drawable getActivityIcon(ComponentName component) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_385434468 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1120282568 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1431439062 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_635193383 = null; 
        PackageManager pm = mContext.getPackageManager();
        ActivityInfo activityInfo = null;
        try 
        {
            activityInfo = pm.getActivityInfo(component, PackageManager.GET_META_DATA);
        } 
        catch (NameNotFoundException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_385434468 = null;
        } 
        int iconId = activityInfo.getIconResource();
        varB4EAC82CA7396A68D541C85D26508E83_1120282568 = null;
        String pkg = component.getPackageName();
        Drawable drawable = pm.getDrawable(pkg, iconId, activityInfo.applicationInfo);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1431439062 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_635193383 = drawable;
        addTaint(component.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_989232212; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_989232212 = varB4EAC82CA7396A68D541C85D26508E83_385434468;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_989232212 = varB4EAC82CA7396A68D541C85D26508E83_1120282568;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_989232212 = varB4EAC82CA7396A68D541C85D26508E83_1431439062;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_989232212 = varB4EAC82CA7396A68D541C85D26508E83_635193383;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_989232212.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_989232212;
        
        
        
        
            
        
            
            
        
        
        
        
        
        
            
                    
            
        
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.164 -0400", hash_original_field = "205BE263C74C715DC52CF9A7EA2D73ED", hash_generated_field = "3275A8779DDA322EA97597C856F45009")

        public TextView mText1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.164 -0400", hash_original_field = "1772A2F42FB317DE654726988EC76A3E", hash_generated_field = "E7E5E0130CDA035A703BB3365C609752")

        public TextView mText2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.164 -0400", hash_original_field = "C673825E43818CD99105CCE1AF6F70BF", hash_generated_field = "B10EF113E51700A15611B304B30E7778")

        public ImageView mIcon1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.164 -0400", hash_original_field = "401AE428E1A1CA95FD335942DA31956C", hash_generated_field = "055F53A680C450108241A4F35FFAA884")

        public ImageView mIcon2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.164 -0400", hash_original_field = "424E64D4026EF571F7811E0460C74F68", hash_generated_field = "A8BC95870909A5381D4C019B25F5D8B2")

        public ImageView mIconRefine;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.165 -0400", hash_original_method = "0CE27F5D43D07582A33280C2CC2EDB09", hash_generated_method = "A23527F4592F77FB480D002A2CC11E38")
        public  ChildViewCache(View v) {
            mText1 = (TextView) v.findViewById(com.android.internal.R.id.text1);
            mText2 = (TextView) v.findViewById(com.android.internal.R.id.text2);
            mIcon1 = (ImageView) v.findViewById(com.android.internal.R.id.icon1);
            mIcon2 = (ImageView) v.findViewById(com.android.internal.R.id.icon2);
            mIconRefine = (ImageView) v.findViewById(com.android.internal.R.id.edit_query);
            
            
            
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.165 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.165 -0400", hash_original_field = "6B8D978304A97E85580800EE57FC5F42", hash_generated_field = "10677C9028A9E03475AECA5E3EA8B569")

    private static final String LOG_TAG = "SuggestionsAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.165 -0400", hash_original_field = "DFECEA9C77B80DBC48160A07ACDBDEB4", hash_generated_field = "719CAAA89185A96380841381EE84A3E5")

    private static final int QUERY_LIMIT = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.165 -0400", hash_original_field = "EB7B121651A66593BC5AD08A505BE0A7", hash_generated_field = "98E9087104FBAF95AD5B62C304A0CCFF")

    static final int REFINE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.165 -0400", hash_original_field = "7E8458192869CFB509A110D384FF690D", hash_generated_field = "837D31B49612E7145EBEC07CF04BC9EF")

    static final int REFINE_BY_ENTRY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.165 -0400", hash_original_field = "4C7A7BFA9F30302A906B93D55A815A86", hash_generated_field = "8DB1B3241AF2F750ED09F16EC1479E52")

    static final int REFINE_ALL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.165 -0400", hash_original_field = "8C5E8C33309913A25C19F3D2DD557C14", hash_generated_field = "5DFAE43769080A8126AF66611D827CF3")

    static final int INVALID_INDEX = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.165 -0400", hash_original_field = "C4DCE6A318023772AC49B35520D8998B", hash_generated_field = "62DEDC9529CE21BA5D13EE75A6ACE45D")

    private static final long DELETE_KEY_POST_DELAY = 500L;
}

