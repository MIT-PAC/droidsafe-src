package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.R;
import com.android.internal.util.Predicate;
import com.google.android.collect.Lists;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.RemoteViews.RemoteView;
import java.util.ArrayList;

public class ListView extends AbsListView {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "A0E111006ED777C10D75AA1677A2639C", hash_generated_field = "4BC24FD3C886BCFFDF832386DEC27D09")

    private ArrayList<FixedViewInfo> mHeaderViewInfos = Lists.newArrayList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "CC679F55490278048131235E90055B39", hash_generated_field = "FD730016C2B4D9973A08935CB5CEEF24")

    private ArrayList<FixedViewInfo> mFooterViewInfos = Lists.newArrayList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "F2EB92D46BFACFA75ABCA33DC6179915", hash_generated_field = "3837E71D24376BABDBC6EE7CD182AABB")

    Drawable mDivider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "FDC96C666CAD9FBF2EF59762861622A0", hash_generated_field = "E9BA9D611B13DC4B2EC5075D3CBC28DA")

    int mDividerHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "2E33162EDD274C7EDD1E1156F95BB8C5", hash_generated_field = "61CEC74004B40DBE67743F5C54E8DAE8")

    Drawable mOverScrollHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "CCC4EEA4F20C4786C3E2B61E4655BBA7", hash_generated_field = "FAAE7751E5086898A7D9334FDB1CBF58")

    Drawable mOverScrollFooter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "8BEFBF97EB4D2DF9EC8AA6449CB3CA5E", hash_generated_field = "D67B6F8B88187DB827FEE4CD95C0CD84")

    private boolean mIsCacheColorOpaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "339C469036C2CC68131B6FFE99D261C1", hash_generated_field = "F64CA3AD07E4A441F83FB08509D5EA54")

    private boolean mDividerIsOpaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "4D65FD0E015FCBFA86076C532AFC8520", hash_generated_field = "E4D279F003B799932AE6A47EC9C65A6F")

    private boolean mHeaderDividersEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "7D3333BFE992E9D671CB18E1CC4F46F2", hash_generated_field = "D61311FF24E9C122770C1CC46CD91809")

    private boolean mFooterDividersEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "CD24990D52A8F3E7E5EB9907AF3F4BCB", hash_generated_field = "1E6DAAB899E2A1039D680325576FF2F4")

    private boolean mAreAllItemsSelectable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "C81EE07A80353C16F692D53C68A2708C", hash_generated_field = "B872CC30C5370C029EE2A26D5DBEB2D2")

    private boolean mItemsCanFocus = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "E00CE94A319056CF4CFCE4FD6B48FD75", hash_generated_field = "4B2413695EEECE37901862E70E0ADF71")

    private Paint mDividerPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "622C7E912E416442D6067E781BEF934A", hash_generated_field = "024149CFE1D444C692150EFEE0AEF359")

    private ArrowScrollFocusResult mArrowScrollFocusResult = new ArrowScrollFocusResult();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.120 -0400", hash_original_field = "D85788A92B1851B4DB4DD47891274715", hash_generated_field = "21847DEAFE51D735E62E529ABB2AD8CB")

    private FocusSelector mFocusSelector;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.121 -0400", hash_original_method = "90B4B4BF6E484BC26800C5A789F4708D", hash_generated_method = "2C921861B94DD394D15F8C9171AE49D3")
    public  ListView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.130 -0400", hash_original_method = "5C8040E9D31754EC73AE53985C54C1B3", hash_generated_method = "02B7F18DF6EB6DE61176AB28E53B2B54")
    public  ListView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.listViewStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.130 -0400", hash_original_method = "1588C0DF1CDF9192487B09246AC39E9C", hash_generated_method = "BC124FB1DCCB1630C66BC78A786F981F")
    public  ListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ListView, defStyle, 0);
        CharSequence[] entries;
        entries = a.getTextArray(
                com.android.internal.R.styleable.ListView_entries);
        {
            setAdapter(new ArrayAdapter<CharSequence>(context,
                    com.android.internal.R.layout.simple_list_item_1, entries));
        } //End block
        Drawable d;
        d = a.getDrawable(com.android.internal.R.styleable.ListView_divider);
        {
            setDivider(d);
        } //End block
        Drawable osHeader;
        osHeader = a.getDrawable(
                com.android.internal.R.styleable.ListView_overScrollHeader);
        {
            setOverscrollHeader(osHeader);
        } //End block
        Drawable osFooter;
        osFooter = a.getDrawable(
                com.android.internal.R.styleable.ListView_overScrollFooter);
        {
            setOverscrollFooter(osFooter);
        } //End block
        int dividerHeight;
        dividerHeight = a.getDimensionPixelSize(
                com.android.internal.R.styleable.ListView_dividerHeight, 0);
        {
            setDividerHeight(dividerHeight);
        } //End block
        mHeaderDividersEnabled = a.getBoolean(R.styleable.ListView_headerDividersEnabled, true);
        mFooterDividersEnabled = a.getBoolean(R.styleable.ListView_footerDividersEnabled, true);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.131 -0400", hash_original_method = "13CC3D3BB67006B8B223FEAA5CEB8AD3", hash_generated_method = "0A69313E2B53B5E0607EE3540A8C6225")
    public int getMaxScrollAmount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2048550712 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2048550712;
        // ---------- Original Method ----------
        //return (int) (MAX_SCROLL_FACTOR * (mBottom - mTop));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.132 -0400", hash_original_method = "C98C1C3289511C3CD05158CF07015375", hash_generated_method = "E998D977EC499A170B87198863DA545E")
    private void adjustViewsUpOrDown() {
        int childCount;
        childCount = getChildCount();
        int delta;
        {
            View child;
            {
                child = getChildAt(0);
                delta = child.getTop() - mListPadding.top;
                {
                    delta -= mDividerHeight;
                } //End block
                {
                    delta = 0;
                } //End block
            } //End block
            {
                child = getChildAt(childCount - 1);
                delta = child.getBottom() - (getHeight() - mListPadding.bottom);
                {
                    delta += mDividerHeight;
                } //End block
                {
                    delta = 0;
                } //End block
            } //End block
            {
                offsetChildrenTopAndBottom(-delta);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.146 -0400", hash_original_method = "52D3689EBA08A028E74C350405FC2CA4", hash_generated_method = "23286197BA937E2B8C1E124B275A113E")
    public void addHeaderView(View v, Object data, boolean isSelectable) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Cannot add header view to list -- setAdapter has already been called.");
        } //End block
        FixedViewInfo info;
        info = new FixedViewInfo();
        info.view = v;
        info.data = data;
        info.isSelectable = isSelectable;
        mHeaderViewInfos.add(info);
        {
            mDataSetObserver.onChanged();
        } //End block
        addTaint(v.getTaint());
        addTaint(data.getTaint());
        addTaint(isSelectable);
        // ---------- Original Method ----------
        //if (mAdapter != null && ! (mAdapter instanceof HeaderViewListAdapter)) {
            //throw new IllegalStateException(
                    //"Cannot add header view to list -- setAdapter has already been called.");
        //}
        //FixedViewInfo info = new FixedViewInfo();
        //info.view = v;
        //info.data = data;
        //info.isSelectable = isSelectable;
        //mHeaderViewInfos.add(info);
        //if (mAdapter != null && mDataSetObserver != null) {
            //mDataSetObserver.onChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.147 -0400", hash_original_method = "9CDB9BC1941825D09F579B09BA5203C8", hash_generated_method = "B3C619852BB06367E2DDB2F57BC57E55")
    public void addHeaderView(View v) {
        addHeaderView(v, null, true);
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        //addHeaderView(v, null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.148 -0400", hash_original_method = "9A198FE2F7DAA22CDFAB063EB95C8DFA", hash_generated_method = "30215897D3CAB7FA9E3E1C306DDF4F1F")
    @Override
    public int getHeaderViewsCount() {
        int var51EB21BA6322BC21883B38109F793DB7_177181415 = (mHeaderViewInfos.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_189715336 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_189715336;
        // ---------- Original Method ----------
        //return mHeaderViewInfos.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.166 -0400", hash_original_method = "8EF6528E21853FD53F2FB8406F9F06D5", hash_generated_method = "60774621DD5AE93A332EDC53AA670FC8")
    public boolean removeHeaderView(View v) {
        {
            boolean varFC339A57DD06D9F6F47BBD3A88B06E10_1773386514 = (mHeaderViewInfos.size() > 0);
            {
                boolean result;
                result = false;
                {
                    boolean var9BFD45A2F2990893F8C6EA8C90DB82AA_1423626127 = (mAdapter != null && ((HeaderViewListAdapter) mAdapter).removeHeader(v));
                    {
                        {
                            mDataSetObserver.onChanged();
                        } //End block
                        result = true;
                    } //End block
                } //End collapsed parenthetic
                removeFixedViewInfo(v, mHeaderViewInfos);
            } //End block
        } //End collapsed parenthetic
        addTaint(v.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1876404979 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1876404979;
        // ---------- Original Method ----------
        //if (mHeaderViewInfos.size() > 0) {
            //boolean result = false;
            //if (mAdapter != null && ((HeaderViewListAdapter) mAdapter).removeHeader(v)) {
                //if (mDataSetObserver != null) {
                    //mDataSetObserver.onChanged();
                //}
                //result = true;
            //}
            //removeFixedViewInfo(v, mHeaderViewInfos);
            //return result;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.167 -0400", hash_original_method = "56A07A9A1AC012F692F90759B155683C", hash_generated_method = "A9604C13F02A1D8C894791AC5684D03E")
    private void removeFixedViewInfo(View v, ArrayList<FixedViewInfo> where) {
        int len;
        len = where.size();
        {
            int i;
            i = 0;
            {
                FixedViewInfo info;
                info = where.get(i);
                {
                    where.remove(i);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(v.getTaint());
        addTaint(where.getTaint());
        // ---------- Original Method ----------
        //int len = where.size();
        //for (int i = 0; i < len; ++i) {
            //FixedViewInfo info = where.get(i);
            //if (info.view == v) {
                //where.remove(i);
                //break;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.168 -0400", hash_original_method = "854663FFCE0B2EEEA12F571F4E080752", hash_generated_method = "1C7FBA8A7069FCC36AFB5B3D2CBA2263")
    public void addFooterView(View v, Object data, boolean isSelectable) {
        FixedViewInfo info;
        info = new FixedViewInfo();
        info.view = v;
        info.data = data;
        info.isSelectable = isSelectable;
        mFooterViewInfos.add(info);
        {
            mDataSetObserver.onChanged();
        } //End block
        addTaint(v.getTaint());
        addTaint(data.getTaint());
        addTaint(isSelectable);
        // ---------- Original Method ----------
        //FixedViewInfo info = new FixedViewInfo();
        //info.view = v;
        //info.data = data;
        //info.isSelectable = isSelectable;
        //mFooterViewInfos.add(info);
        //if (mAdapter != null && mDataSetObserver != null) {
            //mDataSetObserver.onChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.168 -0400", hash_original_method = "06A7CBCF71002E57CE516EE24D5E8CDC", hash_generated_method = "57122EE7C6CF8ED4F3458E8ADE0651DA")
    public void addFooterView(View v) {
        addFooterView(v, null, true);
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        //addFooterView(v, null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.169 -0400", hash_original_method = "83BE551B6778E6D258871D9949AEF538", hash_generated_method = "7A95B851B55F8988FD1A220587020272")
    @Override
    public int getFooterViewsCount() {
        int var05D2A206262A11BE7E645CDC53B4074D_1586523043 = (mFooterViewInfos.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1204634276 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1204634276;
        // ---------- Original Method ----------
        //return mFooterViewInfos.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.169 -0400", hash_original_method = "D2E29F254410117CE819574854BB79EC", hash_generated_method = "625FA13AF0D444EECE767CE8A6ECE0B4")
    public boolean removeFooterView(View v) {
        {
            boolean var16785181560AF1EBB84626B752BB868A_1494948861 = (mFooterViewInfos.size() > 0);
            {
                boolean result;
                result = false;
                {
                    boolean var9C4812C55FB91AE0FCF1729C742654B1_1886275335 = (mAdapter != null && ((HeaderViewListAdapter) mAdapter).removeFooter(v));
                    {
                        {
                            mDataSetObserver.onChanged();
                        } //End block
                        result = true;
                    } //End block
                } //End collapsed parenthetic
                removeFixedViewInfo(v, mFooterViewInfos);
            } //End block
        } //End collapsed parenthetic
        addTaint(v.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_241336578 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_241336578;
        // ---------- Original Method ----------
        //if (mFooterViewInfos.size() > 0) {
            //boolean result = false;
            //if (mAdapter != null && ((HeaderViewListAdapter) mAdapter).removeFooter(v)) {
                //if (mDataSetObserver != null) {
                    //mDataSetObserver.onChanged();
                //}
                //result = true;
            //}
            //removeFixedViewInfo(v, mFooterViewInfos);
            //return result;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.175 -0400", hash_original_method = "0E1A05724C497F45D7FB6AC34C501814", hash_generated_method = "E96CE601717169E62C3F968A2F3438BE")
    @Override
    public ListAdapter getAdapter() {
        ListAdapter varB4EAC82CA7396A68D541C85D26508E83_1224950681 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1224950681 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_1224950681.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1224950681;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.176 -0400", hash_original_method = "8AB2C6958FD7CEC3A8A71FE59763D6A4", hash_generated_method = "D18E7401555F2345B6B780E77B86E39C")
    @android.view.RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        super.setRemoteViewsAdapter(intent);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //super.setRemoteViewsAdapter(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.196 -0400", hash_original_method = "41402E7D77C488BF4C279E76F34BC4E2", hash_generated_method = "D8C9D4637C577306D479FAD7D332E0CB")
    @Override
    public void setAdapter(ListAdapter adapter) {
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        } //End block
        resetList();
        mRecycler.clear();
        {
            boolean var424DAEFA84C4CC446223C4E25F5F060B_510197223 = (mHeaderViewInfos.size() > 0|| mFooterViewInfos.size() > 0);
            {
                mAdapter = new HeaderViewListAdapter(mHeaderViewInfos, mFooterViewInfos, adapter);
            } //End block
            {
                mAdapter = adapter;
            } //End block
        } //End collapsed parenthetic
        mOldSelectedPosition = INVALID_POSITION;
        mOldSelectedRowId = INVALID_ROW_ID;
        super.setAdapter(adapter);
        {
            mAreAllItemsSelectable = mAdapter.areAllItemsEnabled();
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
            checkFocus();
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            mRecycler.setViewTypeCount(mAdapter.getViewTypeCount());
            int position;
            {
                position = lookForSelectablePosition(mItemCount - 1, false);
            } //End block
            {
                position = lookForSelectablePosition(0, true);
            } //End block
            setSelectedPositionInt(position);
            setNextSelectedPositionInt(position);
            {
                checkSelectionChanged();
            } //End block
        } //End block
        {
            mAreAllItemsSelectable = true;
            checkFocus();
            checkSelectionChanged();
        } //End block
        requestLayout();
        addTaint(adapter.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.197 -0400", hash_original_method = "2C61A8961B533B2EFAE2B5516136BD48", hash_generated_method = "2F9780A9A993D3382CEE1B6821096FDF")
    @Override
     void resetList() {
        clearRecycledState(mHeaderViewInfos);
        clearRecycledState(mFooterViewInfos);
        super.resetList();
        mLayoutMode = LAYOUT_NORMAL;
        // ---------- Original Method ----------
        //clearRecycledState(mHeaderViewInfos);
        //clearRecycledState(mFooterViewInfos);
        //super.resetList();
        //mLayoutMode = LAYOUT_NORMAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.198 -0400", hash_original_method = "917FCC60A4286C5138F872CFDA18A6AE", hash_generated_method = "A76A6F3FFDA1FE61E0961BCB357817DA")
    private void clearRecycledState(ArrayList<FixedViewInfo> infos) {
        {
            int count;
            count = infos.size();
            {
                int i;
                i = 0;
                {
                    View child;
                    child = infos.get(i).view;
                    LayoutParams p;
                    p = (LayoutParams) child.getLayoutParams();
                    {
                        p.recycledHeaderFooter = false;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(infos.getTaint());
        // ---------- Original Method ----------
        //if (infos != null) {
            //final int count = infos.size();
            //for (int i = 0; i < count; i++) {
                //final View child = infos.get(i).view;
                //final LayoutParams p = (LayoutParams) child.getLayoutParams();
                //if (p != null) {
                    //p.recycledHeaderFooter = false;
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.205 -0400", hash_original_method = "AE08170EA161B6A1BF0E53E679181532", hash_generated_method = "D0429FCB2EC4ADC34FA74A00B1020CCD")
    private boolean showingTopFadingEdge() {
        int listTop;
        listTop = mScrollY + mListPadding.top;
        boolean varCCBED360491DE804AB67732329ABF3EB_637558703 = ((mFirstPosition > 0) || (getChildAt(0).getTop() > listTop));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_993681518 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_993681518;
        // ---------- Original Method ----------
        //final int listTop = mScrollY + mListPadding.top;
        //return (mFirstPosition > 0) || (getChildAt(0).getTop() > listTop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.206 -0400", hash_original_method = "471206817827115E6FDE8330BC3BFE06", hash_generated_method = "CF2323210AB40D5F1D6866F42E6D353F")
    private boolean showingBottomFadingEdge() {
        int childCount;
        childCount = getChildCount();
        int bottomOfBottomChild;
        bottomOfBottomChild = getChildAt(childCount - 1).getBottom();
        int lastVisiblePosition;
        lastVisiblePosition = mFirstPosition + childCount - 1;
        int listBottom;
        listBottom = mScrollY + getHeight() - mListPadding.bottom;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224660554 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_224660554;
        // ---------- Original Method ----------
        //final int childCount = getChildCount();
        //final int bottomOfBottomChild = getChildAt(childCount - 1).getBottom();
        //final int lastVisiblePosition = mFirstPosition + childCount - 1;
        //final int listBottom = mScrollY + getHeight() - mListPadding.bottom;
        //return (lastVisiblePosition < mItemCount - 1)
                         //|| (bottomOfBottomChild < listBottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.287 -0400", hash_original_method = "0248A9BC20DE00C469CC3A8962885EF5", hash_generated_method = "496F8CDCD3D57567BD1F65173710C56A")
    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rect, boolean immediate) {
        int rectTopWithinChild;
        rectTopWithinChild = rect.top;
        rect.offset(child.getLeft(), child.getTop());
        rect.offset(-child.getScrollX(), -child.getScrollY());
        int height;
        height = getHeight();
        int listUnfadedTop;
        listUnfadedTop = getScrollY();
        int listUnfadedBottom;
        listUnfadedBottom = listUnfadedTop + height;
        int fadingEdge;
        fadingEdge = getVerticalFadingEdgeLength();
        {
            boolean var60D2B66A5E3C386C88687929883234E5_479047623 = (showingTopFadingEdge());
            {
                {
                    listUnfadedTop += fadingEdge;
                } //End block
            } //End block
        } //End collapsed parenthetic
        int childCount;
        childCount = getChildCount();
        int bottomOfBottomChild;
        bottomOfBottomChild = getChildAt(childCount - 1).getBottom();
        {
            boolean varEC085D03DEF6DF005C7F3192FEB447ED_154290554 = (showingBottomFadingEdge());
            {
                {
                    listUnfadedBottom -= fadingEdge;
                } //End block
            } //End block
        } //End collapsed parenthetic
        int scrollYDelta;
        scrollYDelta = 0;
        {
            {
                boolean var1852437954D6FC93B41EE304F855C339_1060349577 = (rect.height() > height);
                {
                    scrollYDelta += (rect.top - listUnfadedTop);
                } //End block
                {
                    scrollYDelta += (rect.bottom - listUnfadedBottom);
                } //End block
            } //End collapsed parenthetic
            int distanceToBottom;
            distanceToBottom = bottomOfBottomChild - listUnfadedBottom;
            scrollYDelta = Math.min(scrollYDelta, distanceToBottom);
        } //End block
        {
            {
                boolean var1852437954D6FC93B41EE304F855C339_516705993 = (rect.height() > height);
                {
                    scrollYDelta -= (listUnfadedBottom - rect.bottom);
                } //End block
                {
                    scrollYDelta -= (listUnfadedTop - rect.top);
                } //End block
            } //End collapsed parenthetic
            int top;
            top = getChildAt(0).getTop();
            int deltaToTop;
            deltaToTop = top - listUnfadedTop;
            scrollYDelta = Math.max(scrollYDelta, deltaToTop);
        } //End block
        boolean scroll;
        scroll = scrollYDelta != 0;
        {
            scrollListItemsBy(-scrollYDelta);
            positionSelector(INVALID_POSITION, child);
            mSelectedTop = child.getTop();
            invalidate();
        } //End block
        addTaint(child.getTaint());
        addTaint(rect.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_799923625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_799923625;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.288 -0400", hash_original_method = "E78CA340B6692592484560299AF7A587", hash_generated_method = "6791FC1B573FB49E98403CAC661E0FAE")
    @Override
     void fillGap(boolean down) {
        int count;
        count = getChildCount();
        {
            int paddingTop;
            paddingTop = 0;
            {
                paddingTop = getListPaddingTop();
            } //End block
            int startOffset;
            startOffset = getChildAt(count - 1).getBottom() + mDividerHeight;
            startOffset = paddingTop;
            fillDown(mFirstPosition + count, startOffset);
            correctTooHigh(getChildCount());
        } //End block
        {
            int paddingBottom;
            paddingBottom = 0;
            {
                paddingBottom = getListPaddingBottom();
            } //End block
            int startOffset;
            startOffset = getChildAt(0).getTop() - mDividerHeight;
            startOffset = getHeight() - paddingBottom;
            fillUp(mFirstPosition - 1, startOffset);
            correctTooLow(getChildCount());
        } //End block
        addTaint(down);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.293 -0400", hash_original_method = "A51DD6537C0400974E1B605AE841C465", hash_generated_method = "F8ED3BB650619A2E14A5A2E6577DFE76")
    private View fillDown(int pos, int nextTop) {
        View varB4EAC82CA7396A68D541C85D26508E83_886780483 = null; //Variable for return #1
        View selectedView;
        selectedView = null;
        int end;
        end = (mBottom - mTop);
        {
            end -= mListPadding.bottom;
        } //End block
        {
            boolean selected;
            selected = pos == mSelectedPosition;
            View child;
            child = makeAndAddView(pos, nextTop, true, mListPadding.left, selected);
            nextTop = child.getBottom() + mDividerHeight;
            {
                selectedView = child;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_886780483 = selectedView;
        addTaint(pos);
        addTaint(nextTop);
        varB4EAC82CA7396A68D541C85D26508E83_886780483.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_886780483;
        // ---------- Original Method ----------
        //View selectedView = null;
        //int end = (mBottom - mTop);
        //if ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK) {
            //end -= mListPadding.bottom;
        //}
        //while (nextTop < end && pos < mItemCount) {
            //boolean selected = pos == mSelectedPosition;
            //View child = makeAndAddView(pos, nextTop, true, mListPadding.left, selected);
            //nextTop = child.getBottom() + mDividerHeight;
            //if (selected) {
                //selectedView = child;
            //}
            //pos++;
        //}
        //return selectedView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.294 -0400", hash_original_method = "05C528C2066045A21E9535AE6FF4CD3D", hash_generated_method = "C67A8E74C4FE18A5A8B40622D1B56C04")
    private View fillUp(int pos, int nextBottom) {
        View varB4EAC82CA7396A68D541C85D26508E83_128620567 = null; //Variable for return #1
        View selectedView;
        selectedView = null;
        int end;
        end = 0;
        {
            end = mListPadding.top;
        } //End block
        {
            boolean selected;
            selected = pos == mSelectedPosition;
            View child;
            child = makeAndAddView(pos, nextBottom, false, mListPadding.left, selected);
            nextBottom = child.getTop() - mDividerHeight;
            {
                selectedView = child;
            } //End block
        } //End block
        mFirstPosition = pos + 1;
        varB4EAC82CA7396A68D541C85D26508E83_128620567 = selectedView;
        addTaint(pos);
        addTaint(nextBottom);
        varB4EAC82CA7396A68D541C85D26508E83_128620567.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_128620567;
        // ---------- Original Method ----------
        //View selectedView = null;
        //int end = 0;
        //if ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK) {
            //end = mListPadding.top;
        //}
        //while (nextBottom > end && pos >= 0) {
            //boolean selected = pos == mSelectedPosition;
            //View child = makeAndAddView(pos, nextBottom, false, mListPadding.left, selected);
            //nextBottom = child.getTop() - mDividerHeight;
            //if (selected) {
                //selectedView = child;
            //}
            //pos--;
        //}
        //mFirstPosition = pos + 1;
        //return selectedView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.294 -0400", hash_original_method = "E858B13EC4F52DD7B2125F2E9BA15919", hash_generated_method = "4FE3E486916292E57D797D3757FE2418")
    private View fillFromTop(int nextTop) {
        View varB4EAC82CA7396A68D541C85D26508E83_548325740 = null; //Variable for return #1
        mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
        mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
        {
            mFirstPosition = 0;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_548325740 = fillDown(mFirstPosition, nextTop);
        addTaint(nextTop);
        varB4EAC82CA7396A68D541C85D26508E83_548325740.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_548325740;
        // ---------- Original Method ----------
        //mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
        //mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
        //if (mFirstPosition < 0) {
            //mFirstPosition = 0;
        //}
        //return fillDown(mFirstPosition, nextTop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.295 -0400", hash_original_method = "BB6F12E082A75859BCEF500D953CB8EE", hash_generated_method = "D3E7337CE8E28724325EF0D3C3534B9D")
    private View fillFromMiddle(int childrenTop, int childrenBottom) {
        View varB4EAC82CA7396A68D541C85D26508E83_831760867 = null; //Variable for return #1
        int height;
        height = childrenBottom - childrenTop;
        int position;
        position = reconcileSelectedPosition();
        View sel;
        sel = makeAndAddView(position, childrenTop, true,
                mListPadding.left, true);
        mFirstPosition = position;
        int selHeight;
        selHeight = sel.getMeasuredHeight();
        {
            sel.offsetTopAndBottom((height - selHeight) / 2);
        } //End block
        fillAboveAndBelow(sel, position);
        {
            correctTooHigh(getChildCount());
        } //End block
        {
            correctTooLow(getChildCount());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_831760867 = sel;
        addTaint(childrenTop);
        addTaint(childrenBottom);
        varB4EAC82CA7396A68D541C85D26508E83_831760867.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_831760867;
        // ---------- Original Method ----------
        //int height = childrenBottom - childrenTop;
        //int position = reconcileSelectedPosition();
        //View sel = makeAndAddView(position, childrenTop, true,
                //mListPadding.left, true);
        //mFirstPosition = position;
        //int selHeight = sel.getMeasuredHeight();
        //if (selHeight <= height) {
            //sel.offsetTopAndBottom((height - selHeight) / 2);
        //}
        //fillAboveAndBelow(sel, position);
        //if (!mStackFromBottom) {
            //correctTooHigh(getChildCount());
        //} else {
            //correctTooLow(getChildCount());
        //}
        //return sel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.302 -0400", hash_original_method = "E7EAC0AC74052E989A5F3C8A8979A51D", hash_generated_method = "5A4D5D03FA92D82EF74469EAA348ABDE")
    private void fillAboveAndBelow(View sel, int position) {
        int dividerHeight;
        dividerHeight = mDividerHeight;
        {
            fillUp(position - 1, sel.getTop() - dividerHeight);
            adjustViewsUpOrDown();
            fillDown(position + 1, sel.getBottom() + dividerHeight);
        } //End block
        {
            fillDown(position + 1, sel.getBottom() + dividerHeight);
            adjustViewsUpOrDown();
            fillUp(position - 1, sel.getTop() - dividerHeight);
        } //End block
        addTaint(sel.getTaint());
        addTaint(position);
        // ---------- Original Method ----------
        //final int dividerHeight = mDividerHeight;
        //if (!mStackFromBottom) {
            //fillUp(position - 1, sel.getTop() - dividerHeight);
            //adjustViewsUpOrDown();
            //fillDown(position + 1, sel.getBottom() + dividerHeight);
        //} else {
            //fillDown(position + 1, sel.getBottom() + dividerHeight);
            //adjustViewsUpOrDown();
            //fillUp(position - 1, sel.getTop() - dividerHeight);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.306 -0400", hash_original_method = "439BAC8174DEF92DB2EFE731B080B752", hash_generated_method = "B165F5BFC8989C82FD88CD1F7DA82336")
    private View fillFromSelection(int selectedTop, int childrenTop, int childrenBottom) {
        View varB4EAC82CA7396A68D541C85D26508E83_497091238 = null; //Variable for return #1
        int fadingEdgeLength;
        fadingEdgeLength = getVerticalFadingEdgeLength();
        int selectedPosition;
        selectedPosition = mSelectedPosition;
        View sel;
        int topSelectionPixel;
        topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength,
                selectedPosition);
        int bottomSelectionPixel;
        bottomSelectionPixel = getBottomSelectionPixel(childrenBottom, fadingEdgeLength,
                selectedPosition);
        sel = makeAndAddView(selectedPosition, selectedTop, true, mListPadding.left, true);
        {
            boolean varBFC41726DC719E4AF23B91CEB6FCBE3E_1623180993 = (sel.getBottom() > bottomSelectionPixel);
            {
                int spaceAbove;
                spaceAbove = sel.getTop() - topSelectionPixel;
                int spaceBelow;
                spaceBelow = sel.getBottom() - bottomSelectionPixel;
                int offset;
                offset = Math.min(spaceAbove, spaceBelow);
                sel.offsetTopAndBottom(-offset);
            } //End block
            {
                boolean var14C65EDD6D5526A3271EC007E995AA33_1953927836 = (sel.getTop() < topSelectionPixel);
                {
                    int spaceAbove;
                    spaceAbove = topSelectionPixel - sel.getTop();
                    int spaceBelow;
                    spaceBelow = bottomSelectionPixel - sel.getBottom();
                    int offset;
                    offset = Math.min(spaceAbove, spaceBelow);
                    sel.offsetTopAndBottom(offset);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        fillAboveAndBelow(sel, selectedPosition);
        {
            correctTooHigh(getChildCount());
        } //End block
        {
            correctTooLow(getChildCount());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_497091238 = sel;
        addTaint(selectedTop);
        addTaint(childrenTop);
        addTaint(childrenBottom);
        varB4EAC82CA7396A68D541C85D26508E83_497091238.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_497091238;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.309 -0400", hash_original_method = "DDE472821830C07DE1368C905BA02EE1", hash_generated_method = "43D2572DA9D18854D6FB2180C9A9BFA7")
    private int getBottomSelectionPixel(int childrenBottom, int fadingEdgeLength,
            int selectedPosition) {
        int bottomSelectionPixel;
        bottomSelectionPixel = childrenBottom;
        {
            bottomSelectionPixel -= fadingEdgeLength;
        } //End block
        addTaint(childrenBottom);
        addTaint(fadingEdgeLength);
        addTaint(selectedPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_119326637 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_119326637;
        // ---------- Original Method ----------
        //int bottomSelectionPixel = childrenBottom;
        //if (selectedPosition != mItemCount - 1) {
            //bottomSelectionPixel -= fadingEdgeLength;
        //}
        //return bottomSelectionPixel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.310 -0400", hash_original_method = "173BB2BFF18272B67A930A02164FEB0F", hash_generated_method = "49E0F7F41028254D2C2DFAC491A928D5")
    private int getTopSelectionPixel(int childrenTop, int fadingEdgeLength, int selectedPosition) {
        int topSelectionPixel;
        topSelectionPixel = childrenTop;
        {
            topSelectionPixel += fadingEdgeLength;
        } //End block
        addTaint(childrenTop);
        addTaint(fadingEdgeLength);
        addTaint(selectedPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22871462 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22871462;
        // ---------- Original Method ----------
        //int topSelectionPixel = childrenTop;
        //if (selectedPosition > 0) {
            //topSelectionPixel += fadingEdgeLength;
        //}
        //return topSelectionPixel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.310 -0400", hash_original_method = "19B54E9E42F50C19B80602093C26BC32", hash_generated_method = "7A5836635E40602F9283C444E4C38BE2")
    @android.view.RemotableViewMethod
    public void smoothScrollToPosition(int position) {
        super.smoothScrollToPosition(position);
        addTaint(position);
        // ---------- Original Method ----------
        //super.smoothScrollToPosition(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.310 -0400", hash_original_method = "9A2E566018459C8A4F9FE2F49DBB98B8", hash_generated_method = "DF8A45AA7313754A97BDE7860400CCDD")
    @android.view.RemotableViewMethod
    public void smoothScrollByOffset(int offset) {
        super.smoothScrollByOffset(offset);
        addTaint(offset);
        // ---------- Original Method ----------
        //super.smoothScrollByOffset(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.320 -0400", hash_original_method = "A6BE2578E6D412634113B39CFD73986F", hash_generated_method = "ED2FE7DF3F485FE3CEB5F7F6EA5167A2")
    private View moveSelection(View oldSel, View newSel, int delta, int childrenTop,
            int childrenBottom) {
        View varB4EAC82CA7396A68D541C85D26508E83_953934252 = null; //Variable for return #1
        int fadingEdgeLength;
        fadingEdgeLength = getVerticalFadingEdgeLength();
        int selectedPosition;
        selectedPosition = mSelectedPosition;
        View sel;
        int topSelectionPixel;
        topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength,
                selectedPosition);
        int bottomSelectionPixel;
        bottomSelectionPixel = getBottomSelectionPixel(childrenTop, fadingEdgeLength,
                selectedPosition);
        {
            oldSel = makeAndAddView(selectedPosition - 1, oldSel.getTop(), true,
                    mListPadding.left, false);
            int dividerHeight;
            dividerHeight = mDividerHeight;
            sel = makeAndAddView(selectedPosition, oldSel.getBottom() + dividerHeight, true,
                    mListPadding.left, true);
            {
                boolean var809044946283DBF63F29397A5670A6D0_555365717 = (sel.getBottom() > bottomSelectionPixel);
                {
                    int spaceAbove;
                    spaceAbove = sel.getTop() - topSelectionPixel;
                    int spaceBelow;
                    spaceBelow = sel.getBottom() - bottomSelectionPixel;
                    int halfVerticalSpace;
                    halfVerticalSpace = (childrenBottom - childrenTop) / 2;
                    int offset;
                    offset = Math.min(spaceAbove, spaceBelow);
                    offset = Math.min(offset, halfVerticalSpace);
                    oldSel.offsetTopAndBottom(-offset);
                    sel.offsetTopAndBottom(-offset);
                } //End block
            } //End collapsed parenthetic
            {
                fillUp(mSelectedPosition - 2, sel.getTop() - dividerHeight);
                adjustViewsUpOrDown();
                fillDown(mSelectedPosition + 1, sel.getBottom() + dividerHeight);
            } //End block
            {
                fillDown(mSelectedPosition + 1, sel.getBottom() + dividerHeight);
                adjustViewsUpOrDown();
                fillUp(mSelectedPosition - 2, sel.getTop() - dividerHeight);
            } //End block
        } //End block
        {
            {
                sel = makeAndAddView(selectedPosition, newSel.getTop(), true, mListPadding.left,
                        true);
            } //End block
            {
                sel = makeAndAddView(selectedPosition, oldSel.getTop(), false, mListPadding.left,
                        true);
            } //End block
            {
                boolean var14C65EDD6D5526A3271EC007E995AA33_396607814 = (sel.getTop() < topSelectionPixel);
                {
                    int spaceAbove;
                    spaceAbove = topSelectionPixel - sel.getTop();
                    int spaceBelow;
                    spaceBelow = bottomSelectionPixel - sel.getBottom();
                    int halfVerticalSpace;
                    halfVerticalSpace = (childrenBottom - childrenTop) / 2;
                    int offset;
                    offset = Math.min(spaceAbove, spaceBelow);
                    offset = Math.min(offset, halfVerticalSpace);
                    sel.offsetTopAndBottom(offset);
                } //End block
            } //End collapsed parenthetic
            fillAboveAndBelow(sel, selectedPosition);
        } //End block
        {
            int oldTop;
            oldTop = oldSel.getTop();
            sel = makeAndAddView(selectedPosition, oldTop, true, mListPadding.left, true);
            {
                int newBottom;
                newBottom = sel.getBottom();
                {
                    sel.offsetTopAndBottom(childrenTop - sel.getTop());
                } //End block
            } //End block
            fillAboveAndBelow(sel, selectedPosition);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_953934252 = sel;
        addTaint(oldSel.getTaint());
        addTaint(newSel.getTaint());
        addTaint(delta);
        addTaint(childrenTop);
        addTaint(childrenBottom);
        varB4EAC82CA7396A68D541C85D26508E83_953934252.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_953934252;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.322 -0400", hash_original_method = "CB33E140CB7C8CB590395A9B1EF6CC8D", hash_generated_method = "54EB14840820C2B555FFA1EB6627734D")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1929415215 = (getChildCount() > 0);
            {
                View focusedChild;
                focusedChild = getFocusedChild();
                {
                    int childPosition;
                    childPosition = mFirstPosition + indexOfChild(focusedChild);
                    int childBottom;
                    childBottom = focusedChild.getBottom();
                    int offset;
                    offset = Math.max(0, childBottom - (h - mPaddingTop));
                    int top;
                    top = focusedChild.getTop() - offset;
                    {
                        mFocusSelector = new FocusSelector();
                    } //End block
                    post(mFocusSelector.setup(childPosition, top));
                } //End block
            } //End block
        } //End collapsed parenthetic
        super.onSizeChanged(w, h, oldw, oldh);
        addTaint(w);
        addTaint(h);
        addTaint(oldw);
        addTaint(oldh);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //View focusedChild = getFocusedChild();
            //if (focusedChild != null) {
                //final int childPosition = mFirstPosition + indexOfChild(focusedChild);
                //final int childBottom = focusedChild.getBottom();
                //final int offset = Math.max(0, childBottom - (h - mPaddingTop));
                //final int top = focusedChild.getTop() - offset;
                //if (mFocusSelector == null) {
                    //mFocusSelector = new FocusSelector();
                //}
                //post(mFocusSelector.setup(childPosition, top));
            //}
        //}
        //super.onSizeChanged(w, h, oldw, oldh);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.333 -0400", hash_original_method = "593EBCA8FD80357C209889704061F804", hash_generated_method = "E6DF7E643F4E52885EEEFFF3F6E7343C")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize;
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize;
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int childWidth;
        childWidth = 0;
        int childHeight;
        childHeight = 0;
        int childState;
        childState = 0;
        mItemCount = mAdapter == null ? 0 : mAdapter.getCount();
        {
            View child;
            child = obtainView(0, mIsScrap);
            measureScrapChild(child, 0, widthMeasureSpec);
            childWidth = child.getMeasuredWidth();
            childHeight = child.getMeasuredHeight();
            childState = combineMeasuredStates(childState, child.getMeasuredState());
            {
                boolean varEB7649CB6D51B846BFB1D35E91D4E330_186856041 = (recycleOnMeasure() && mRecycler.shouldRecycleViewType(
                    ((LayoutParams) child.getLayoutParams()).viewType));
                {
                    mRecycler.addScrapView(child, -1);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            widthSize = mListPadding.left + mListPadding.right + childWidth +
                    getVerticalScrollbarWidth();
        } //End block
        {
            widthSize |= (childState&MEASURED_STATE_MASK);
        } //End block
        {
            heightSize = mListPadding.top + mListPadding.bottom + childHeight +
                    getVerticalFadingEdgeLength() * 2;
        } //End block
        {
            heightSize = measureHeightOfChildren(widthMeasureSpec, 0, NO_POSITION, heightSize, -1);
        } //End block
        setMeasuredDimension(widthSize , heightSize);
        mWidthMeasureSpec = widthMeasureSpec;
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.334 -0400", hash_original_method = "F21C4EE74005F045F306FF7685001DDA", hash_generated_method = "D11163DE4F2609941AABE65442786448")
    private void measureScrapChild(View child, int position, int widthMeasureSpec) {
        LayoutParams p;
        p = (LayoutParams) child.getLayoutParams();
        {
            p = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0);
            child.setLayoutParams(p);
        } //End block
        p.viewType = mAdapter.getItemViewType(position);
        p.forceAdd = true;
        int childWidthSpec;
        childWidthSpec = ViewGroup.getChildMeasureSpec(widthMeasureSpec,
                mListPadding.left + mListPadding.right, p.width);
        int lpHeight;
        lpHeight = p.height;
        int childHeightSpec;
        {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
        } //End block
        {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        } //End block
        child.measure(childWidthSpec, childHeightSpec);
        addTaint(child.getTaint());
        addTaint(position);
        addTaint(widthMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.335 -0400", hash_original_method = "8F0B08D4426D8F4F23EF014B56CDCFE6", hash_generated_method = "EDBA4B1E20BE995DDFAF34029FCD4D6E")
    @ViewDebug.ExportedProperty(category = "list")
    protected boolean recycleOnMeasure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1767955801 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1767955801;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.336 -0400", hash_original_method = "4E8DF0CF85AB0B6CF8E1C94B60E67D20", hash_generated_method = "E03FD9C3F80377F83493A40412AB4771")
    final int measureHeightOfChildren(int widthMeasureSpec, int startPosition, int endPosition,
            final int maxHeight, int disallowPartialChildPosition) {
        ListAdapter adapter;
        adapter = mAdapter;
        int returnedHeight;
        returnedHeight = mListPadding.top + mListPadding.bottom;
        int dividerHeight;
        dividerHeight = mDividerHeight;
        dividerHeight = 0;
        int prevHeightWithoutPartialChild;
        prevHeightWithoutPartialChild = 0;
        int i;
        View child;
        endPosition = (endPosition == NO_POSITION) ? adapter.getCount() - 1 : endPosition;
        AbsListView.RecycleBin recycleBin;
        recycleBin = mRecycler;
        boolean recyle;
        recyle = recycleOnMeasure();
        boolean[] isScrap;
        isScrap = mIsScrap;
        {
            i = startPosition;
            {
                child = obtainView(i, isScrap);
                measureScrapChild(child, i, widthMeasureSpec);
                {
                    returnedHeight += dividerHeight;
                } //End block
                {
                    boolean var533FFAA3904216431C0F5E425FC7EAF1_109393785 = (recyle && recycleBin.shouldRecycleViewType(
                    ((LayoutParams) child.getLayoutParams()).viewType));
                    {
                        recycleBin.addScrapView(child, -1);
                    } //End block
                } //End collapsed parenthetic
                returnedHeight += child.getMeasuredHeight();
                {
                    prevHeightWithoutPartialChild = returnedHeight;
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(widthMeasureSpec);
        addTaint(startPosition);
        addTaint(endPosition);
        addTaint(maxHeight);
        addTaint(disallowPartialChildPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811812416 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811812416;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.336 -0400", hash_original_method = "79128C90442A789B94FF9502F8C045C1", hash_generated_method = "65DD4BFC7258C245296D49CC0CE385E5")
    @Override
     int findMotionRow(int y) {
        int childCount;
        childCount = getChildCount();
        {
            {
                {
                    int i;
                    i = 0;
                    {
                        View v;
                        v = getChildAt(i);
                        {
                            boolean var737FD9EF3BFA62490E57511E301591D9_522811468 = (y <= v.getBottom());
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    int i;
                    i = childCount - 1;
                    {
                        View v;
                        v = getChildAt(i);
                        {
                            boolean varE7C2FBE8C17E6A36CCD2B0AC678BC146_198032599 = (y >= v.getTop());
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1196557533 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1196557533;
        // ---------- Original Method ----------
        //int childCount = getChildCount();
        //if (childCount > 0) {
            //if (!mStackFromBottom) {
                //for (int i = 0; i < childCount; i++) {
                    //View v = getChildAt(i);
                    //if (y <= v.getBottom()) {
                        //return mFirstPosition + i;
                    //}
                //}
            //} else {
                //for (int i = childCount - 1; i >= 0; i--) {
                    //View v = getChildAt(i);
                    //if (y >= v.getTop()) {
                        //return mFirstPosition + i;
                    //}
                //}
            //}
        //}
        //return INVALID_POSITION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.347 -0400", hash_original_method = "C0E9548D6FEBBB39DCAB5DD502EC06AD", hash_generated_method = "4A399657557C43C6FDA2868AD7795EC2")
    private View fillSpecific(int position, int top) {
        View varB4EAC82CA7396A68D541C85D26508E83_900034698 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_730725526 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_1030140450 = null; //Variable for return #3
        boolean tempIsSelected;
        tempIsSelected = position == mSelectedPosition;
        View temp;
        temp = makeAndAddView(position, top, true, mListPadding.left, tempIsSelected);
        mFirstPosition = position;
        View above;
        View below;
        int dividerHeight;
        dividerHeight = mDividerHeight;
        {
            above = fillUp(position - 1, temp.getTop() - dividerHeight);
            adjustViewsUpOrDown();
            below = fillDown(position + 1, temp.getBottom() + dividerHeight);
            int childCount;
            childCount = getChildCount();
            {
                correctTooHigh(childCount);
            } //End block
        } //End block
        {
            below = fillDown(position + 1, temp.getBottom() + dividerHeight);
            adjustViewsUpOrDown();
            above = fillUp(position - 1, temp.getTop() - dividerHeight);
            int childCount;
            childCount = getChildCount();
            {
                correctTooLow(childCount);
            } //End block
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_900034698 = temp;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_730725526 = above;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1030140450 = below;
        } //End block
        addTaint(position);
        addTaint(top);
        View varA7E53CE21691AB073D9660D615818899_284754400; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_284754400 = varB4EAC82CA7396A68D541C85D26508E83_900034698;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_284754400 = varB4EAC82CA7396A68D541C85D26508E83_730725526;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_284754400 = varB4EAC82CA7396A68D541C85D26508E83_1030140450;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_284754400.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_284754400;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.347 -0400", hash_original_method = "C65533A90B04CD548C8B98EAAB2119A6", hash_generated_method = "D14AE80B2538EAE4A63E1E4615B55316")
    private void correctTooHigh(int childCount) {
        int lastPosition;
        lastPosition = mFirstPosition + childCount - 1;
        {
            View lastChild;
            lastChild = getChildAt(childCount - 1);
            int lastBottom;
            lastBottom = lastChild.getBottom();
            int end;
            end = (mBottom - mTop) - mListPadding.bottom;
            int bottomOffset;
            bottomOffset = end - lastBottom;
            View firstChild;
            firstChild = getChildAt(0);
            int firstTop;
            firstTop = firstChild.getTop();
            {
                {
                    bottomOffset = Math.min(bottomOffset, mListPadding.top - firstTop);
                } //End block
                offsetChildrenTopAndBottom(bottomOffset);
                {
                    fillUp(mFirstPosition - 1, firstChild.getTop() - mDividerHeight);
                    adjustViewsUpOrDown();
                } //End block
            } //End block
        } //End block
        addTaint(childCount);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.348 -0400", hash_original_method = "D798F76D04F235C59E38C4C924A6B5C2", hash_generated_method = "BD8D720D60DEBBDECC60A5C52CA23119")
    private void correctTooLow(int childCount) {
        {
            View firstChild;
            firstChild = getChildAt(0);
            int firstTop;
            firstTop = firstChild.getTop();
            int start;
            start = mListPadding.top;
            int end;
            end = (mBottom - mTop) - mListPadding.bottom;
            int topOffset;
            topOffset = firstTop - start;
            View lastChild;
            lastChild = getChildAt(childCount - 1);
            int lastBottom;
            lastBottom = lastChild.getBottom();
            int lastPosition;
            lastPosition = mFirstPosition + childCount - 1;
            {
                {
                    {
                        topOffset = Math.min(topOffset, lastBottom - end);
                    } //End block
                    offsetChildrenTopAndBottom(-topOffset);
                    {
                        fillDown(lastPosition + 1, lastChild.getBottom() + mDividerHeight);
                        adjustViewsUpOrDown();
                    } //End block
                } //End block
                {
                    adjustViewsUpOrDown();
                } //End block
            } //End block
        } //End block
        addTaint(childCount);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.362 -0400", hash_original_method = "9877500E639FE4AE4AB75D2F74BF2E4E", hash_generated_method = "C3ED21E0753A0508709A1033203AAE27")
    @Override
    protected void layoutChildren() {
        boolean blockLayoutRequests;
        blockLayoutRequests = mBlockLayoutRequests;
        {
            mBlockLayoutRequests = true;
        } //End block
        try 
        {
            super.layoutChildren();
            invalidate();
            {
                resetList();
                invokeOnItemScrollListener();
            } //End block
            int childrenTop;
            childrenTop = mListPadding.top;
            int childrenBottom;
            childrenBottom = mBottom - mTop - mListPadding.bottom;
            int childCount;
            childCount = getChildCount();
            int index;
            index = 0;
            int delta;
            delta = 0;
            View sel;
            View oldSel;
            oldSel = null;
            View oldFirst;
            oldFirst = null;
            View newSel;
            newSel = null;
            View focusLayoutRestoreView;
            focusLayoutRestoreView = null;
            //Begin case LAYOUT_SET_SELECTION 
            index = mNextSelectedPosition - mFirstPosition;
            //End case LAYOUT_SET_SELECTION 
            //Begin case LAYOUT_SET_SELECTION 
            {
                newSel = getChildAt(index);
            } //End block
            //End case LAYOUT_SET_SELECTION 
            //Begin case LAYOUT_MOVE_SELECTION default 
            index = mSelectedPosition - mFirstPosition;
            //End case LAYOUT_MOVE_SELECTION default 
            //Begin case LAYOUT_MOVE_SELECTION default 
            {
                oldSel = getChildAt(index);
            } //End block
            //End case LAYOUT_MOVE_SELECTION default 
            //Begin case LAYOUT_MOVE_SELECTION default 
            oldFirst = getChildAt(0);
            //End case LAYOUT_MOVE_SELECTION default 
            //Begin case LAYOUT_MOVE_SELECTION default 
            {
                delta = mNextSelectedPosition - mSelectedPosition;
            } //End block
            //End case LAYOUT_MOVE_SELECTION default 
            //Begin case LAYOUT_MOVE_SELECTION default 
            newSel = getChildAt(index + delta);
            //End case LAYOUT_MOVE_SELECTION default 
            boolean dataChanged;
            dataChanged = mDataChanged;
            {
                handleDataChanged();
            } //End block
            {
                resetList();
                invokeOnItemScrollListener();
            } //End block
            {
                boolean varA298A0CB79AEDD2E132E7DADF2F1B74D_1449383548 = (mItemCount != mAdapter.getCount());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The content of the adapter has changed but "
                        + "ListView did not receive a notification. Make sure the content of "
                        + "your adapter is not modified from a background thread, but only "
                        + "from the UI thread. [in ListView(" + getId() + ", " + getClass() 
                        + ") with Adapter(" + mAdapter.getClass() + ")]");
                } //End block
            } //End collapsed parenthetic
            setSelectedPositionInt(mNextSelectedPosition);
            int firstPosition;
            firstPosition = mFirstPosition;
            RecycleBin recycleBin;
            recycleBin = mRecycler;
            View focusLayoutRestoreDirectChild;
            focusLayoutRestoreDirectChild = null;
            {
                {
                    int i;
                    i = 0;
                    {
                        recycleBin.addScrapView(getChildAt(i), firstPosition+i);
                        {
                            ViewDebug.trace(getChildAt(i),
                                ViewDebug.RecyclerTraceType.MOVE_TO_SCRAP_HEAP, index, i);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                recycleBin.fillActiveViews(childCount, firstPosition);
            } //End block
            View focusedChild;
            focusedChild = getFocusedChild();
            {
                {
                    boolean varE616BE978FFFDD1A37C1939042B395B1_2115473123 = (!dataChanged || isDirectChildHeaderOrFooter(focusedChild));
                    {
                        focusLayoutRestoreDirectChild = focusedChild;
                        focusLayoutRestoreView = findFocus();
                        {
                            focusLayoutRestoreView.onStartTemporaryDetach();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                requestFocus();
            } //End block
            detachAllViewsFromParent();
            //Begin case LAYOUT_SET_SELECTION 
            {
                sel = fillFromSelection(newSel.getTop(), childrenTop, childrenBottom);
            } //End block
            {
                sel = fillFromMiddle(childrenTop, childrenBottom);
            } //End block
            //End case LAYOUT_SET_SELECTION 
            //Begin case LAYOUT_SYNC 
            sel = fillSpecific(mSyncPosition, mSpecificTop);
            //End case LAYOUT_SYNC 
            //Begin case LAYOUT_FORCE_BOTTOM 
            sel = fillUp(mItemCount - 1, childrenBottom);
            //End case LAYOUT_FORCE_BOTTOM 
            //Begin case LAYOUT_FORCE_BOTTOM 
            adjustViewsUpOrDown();
            //End case LAYOUT_FORCE_BOTTOM 
            //Begin case LAYOUT_FORCE_TOP 
            mFirstPosition = 0;
            //End case LAYOUT_FORCE_TOP 
            //Begin case LAYOUT_FORCE_TOP 
            sel = fillFromTop(childrenTop);
            //End case LAYOUT_FORCE_TOP 
            //Begin case LAYOUT_FORCE_TOP 
            adjustViewsUpOrDown();
            //End case LAYOUT_FORCE_TOP 
            //Begin case LAYOUT_SPECIFIC 
            sel = fillSpecific(reconcileSelectedPosition(), mSpecificTop);
            //End case LAYOUT_SPECIFIC 
            //Begin case LAYOUT_MOVE_SELECTION 
            sel = moveSelection(oldSel, newSel, delta, childrenTop, childrenBottom);
            //End case LAYOUT_MOVE_SELECTION 
            //Begin case default 
            {
                {
                    int position;
                    position = lookForSelectablePosition(0, true);
                    setSelectedPositionInt(position);
                    sel = fillFromTop(childrenTop);
                } //End block
                {
                    int position;
                    position = lookForSelectablePosition(mItemCount - 1, false);
                    setSelectedPositionInt(position);
                    sel = fillUp(mItemCount - 1, childrenBottom);
                } //End block
            } //End block
            {
                {
                    sel = fillSpecific(mSelectedPosition,
                                oldSel == null ? childrenTop : oldSel.getTop());
                } //End block
                {
                    sel = fillSpecific(mFirstPosition,
                                oldFirst == null ? childrenTop : oldFirst.getTop());
                } //End block
                {
                    sel = fillSpecific(0, childrenTop);
                } //End block
            } //End block
            //End case default 
            recycleBin.scrapActiveViews();
            {
                {
                    boolean var9085EE91A28170DA4ACA96D9BF477D88_1929741063 = (mItemsCanFocus && hasFocus() && !sel.hasFocus());
                    {
                        boolean focusWasTaken;
                        focusWasTaken = (sel == focusLayoutRestoreDirectChild &&
                            focusLayoutRestoreView.requestFocus()) || sel.requestFocus();
                        {
                            View focused;
                            focused = getFocusedChild();
                            {
                                focused.clearFocus();
                            } //End block
                            positionSelector(INVALID_POSITION, sel);
                        } //End block
                        {
                            sel.setSelected(false);
                            mSelectorRect.setEmpty();
                        } //End block
                    } //End block
                    {
                        positionSelector(INVALID_POSITION, sel);
                    } //End block
                } //End collapsed parenthetic
                mSelectedTop = sel.getTop();
            } //End block
            {
                {
                    View child;
                    child = getChildAt(mMotionPosition - mFirstPosition);
                    positionSelector(mMotionPosition, child);
                } //End block
                {
                    mSelectedTop = 0;
                    mSelectorRect.setEmpty();
                } //End block
                {
                    boolean var3353F8886B6D2D3385EBD44764EEC6B6_171475424 = (hasFocus() && focusLayoutRestoreView != null);
                    {
                        focusLayoutRestoreView.requestFocus();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var371628C1F86A56F688D98D9EF6B87E07_48942081 = (focusLayoutRestoreView != null
                    && focusLayoutRestoreView.getWindowToken() != null);
                {
                    focusLayoutRestoreView.onFinishTemporaryDetach();
                } //End block
            } //End collapsed parenthetic
            mLayoutMode = LAYOUT_NORMAL;
            mDataChanged = false;
            mNeedSync = false;
            setNextSelectedPositionInt(mSelectedPosition);
            updateScrollIndicators();
            {
                checkSelectionChanged();
            } //End block
            invokeOnItemScrollListener();
        } //End block
        finally 
        {
            {
                mBlockLayoutRequests = false;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.372 -0400", hash_original_method = "1975AA11D0AB4A92B498BEF09326AA69", hash_generated_method = "3B29F839F2C4D887DBB68A0409A277EB")
    private boolean isDirectChildHeaderOrFooter(View child) {
        ArrayList<FixedViewInfo> headers;
        headers = mHeaderViewInfos;
        int numHeaders;
        numHeaders = headers.size();
        {
            int i;
            i = 0;
            {
                {
                    boolean var2E97F2DD1ECC5E322C5090F5951EC49E_1470283753 = (child == headers.get(i).view);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        ArrayList<FixedViewInfo> footers;
        footers = mFooterViewInfos;
        int numFooters;
        numFooters = footers.size();
        {
            int i;
            i = 0;
            {
                {
                    boolean varA845DE916470E49791E6F275395553FA_1725324937 = (child == footers.get(i).view);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(child.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_665998343 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_665998343;
        // ---------- Original Method ----------
        //final ArrayList<FixedViewInfo> headers = mHeaderViewInfos;
        //final int numHeaders = headers.size();
        //for (int i = 0; i < numHeaders; i++) {
            //if (child == headers.get(i).view) {
                //return true;
            //}
        //}
        //final ArrayList<FixedViewInfo> footers = mFooterViewInfos;
        //final int numFooters = footers.size();
        //for (int i = 0; i < numFooters; i++) {
            //if (child == footers.get(i).view) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.379 -0400", hash_original_method = "EAF848DCFCD435D3CED323F008D83518", hash_generated_method = "6E48387E04A1822B0C14B3EE4FD8D2D5")
    private View makeAndAddView(int position, int y, boolean flow, int childrenLeft,
            boolean selected) {
        View varB4EAC82CA7396A68D541C85D26508E83_825447843 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_504712705 = null; //Variable for return #2
        View child;
        {
            child = mRecycler.getActiveView(position);
            {
                {
                    ViewDebug.trace(child, ViewDebug.RecyclerTraceType.RECYCLE_FROM_ACTIVE_HEAP,
                            position, getChildCount());
                } //End block
                setupChild(child, position, y, flow, childrenLeft, selected, true);
                varB4EAC82CA7396A68D541C85D26508E83_825447843 = child;
            } //End block
        } //End block
        child = obtainView(position, mIsScrap);
        setupChild(child, position, y, flow, childrenLeft, selected, mIsScrap[0]);
        varB4EAC82CA7396A68D541C85D26508E83_504712705 = child;
        addTaint(position);
        addTaint(y);
        addTaint(flow);
        addTaint(childrenLeft);
        addTaint(selected);
        View varA7E53CE21691AB073D9660D615818899_1433582436; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1433582436 = varB4EAC82CA7396A68D541C85D26508E83_825447843;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1433582436 = varB4EAC82CA7396A68D541C85D26508E83_504712705;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1433582436.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1433582436;
        // ---------- Original Method ----------
        //View child;
        //if (!mDataChanged) {
            //child = mRecycler.getActiveView(position);
            //if (child != null) {
                //if (ViewDebug.TRACE_RECYCLER) {
                    //ViewDebug.trace(child, ViewDebug.RecyclerTraceType.RECYCLE_FROM_ACTIVE_HEAP,
                            //position, getChildCount());
                //}
                //setupChild(child, position, y, flow, childrenLeft, selected, true);
                //return child;
            //}
        //}
        //child = obtainView(position, mIsScrap);
        //setupChild(child, position, y, flow, childrenLeft, selected, mIsScrap[0]);
        //return child;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.384 -0400", hash_original_method = "06B6C56B5992091F7319E58A5C4AE35A", hash_generated_method = "E50CB4541A2408C42C7A3AA3909C524F")
    private void setupChild(View child, int position, int y, boolean flowDown, int childrenLeft,
            boolean selected, boolean recycled) {
        boolean isSelected;
        isSelected = selected && shouldShowSelector();
        boolean updateChildSelected;
        updateChildSelected = isSelected != child.isSelected();
        int mode;
        mode = mTouchMode;
        boolean isPressed;
        isPressed = mode > TOUCH_MODE_DOWN && mode < TOUCH_MODE_SCROLL &&
                mMotionPosition == position;
        boolean updateChildPressed;
        updateChildPressed = isPressed != child.isPressed();
        boolean needToMeasure;
        needToMeasure = !recycled || updateChildSelected || child.isLayoutRequested();
        AbsListView.LayoutParams p;
        p = (AbsListView.LayoutParams) child.getLayoutParams();
        {
            p = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0);
        } //End block
        p.viewType = mAdapter.getItemViewType(position);
        {
            attachViewToParent(child, flowDown ? -1 : 0, p);
        } //End block
        {
            p.forceAdd = false;
            {
                p.recycledHeaderFooter = true;
            } //End block
            addViewInLayout(child, flowDown ? -1 : 0, p, true);
        } //End block
        {
            child.setSelected(isSelected);
        } //End block
        {
            child.setPressed(isPressed);
        } //End block
        {
            {
                ((Checkable) child).setChecked(mCheckStates.get(position));
            } //End block
            {
                boolean var6B8ECFCCB35D70022AE775423EF95EFF_678460453 = (getContext().getApplicationInfo().targetSdkVersion
                    >= android.os.Build.VERSION_CODES.HONEYCOMB);
                {
                    child.setActivated(mCheckStates.get(position));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int childWidthSpec;
            childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                    mListPadding.left + mListPadding.right, p.width);
            int lpHeight;
            lpHeight = p.height;
            int childHeightSpec;
            {
                childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
            } //End block
            {
                childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            } //End block
            child.measure(childWidthSpec, childHeightSpec);
        } //End block
        {
            cleanupLayoutState(child);
        } //End block
        int w;
        w = child.getMeasuredWidth();
        int h;
        h = child.getMeasuredHeight();
        int childTop;
        childTop = y;
        childTop = y - h;
        {
            int childRight;
            childRight = childrenLeft + w;
            int childBottom;
            childBottom = childTop + h;
            child.layout(childrenLeft, childTop, childRight, childBottom);
        } //End block
        {
            child.offsetLeftAndRight(childrenLeft - child.getLeft());
            child.offsetTopAndBottom(childTop - child.getTop());
        } //End block
        {
            boolean varFE983D8157D9C3BB7AF96BB07D8A50F7_1467444929 = (mCachingStarted && !child.isDrawingCacheEnabled());
            {
                child.setDrawingCacheEnabled(true);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCA9C9DB394586E5C1281E2A995FFCD63_889110743 = (recycled && (((AbsListView.LayoutParams)child.getLayoutParams()).scrappedFromPosition)
                != position);
            {
                child.jumpDrawablesToCurrentState();
            } //End block
        } //End collapsed parenthetic
        addTaint(child.getTaint());
        addTaint(position);
        addTaint(y);
        addTaint(flowDown);
        addTaint(childrenLeft);
        addTaint(selected);
        addTaint(recycled);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.384 -0400", hash_original_method = "F40AC428F4D570BD34339564A5B5BB04", hash_generated_method = "D773B9B5C9D852872B7361E1DCE8335D")
    @Override
    protected boolean canAnimate() {
        boolean varDA480D2F8FF037BACA5DB54A8FBF9642_449568672 = (super.canAnimate() && mItemCount > 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1314773085 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1314773085;
        // ---------- Original Method ----------
        //return super.canAnimate() && mItemCount > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.393 -0400", hash_original_method = "94D2F20BDBA41376781BE37B36941A8A", hash_generated_method = "9CCC25E7FAB162595C36123BA6715042")
    @Override
    public void setSelection(int position) {
        setSelectionFromTop(position, 0);
        addTaint(position);
        // ---------- Original Method ----------
        //setSelectionFromTop(position, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.393 -0400", hash_original_method = "04FF3361CA0379851E7CD86AE0D8A950", hash_generated_method = "0F496BF614C56D4F863AE2222E67A123")
    public void setSelectionFromTop(int position, int y) {
        {
            boolean var3DA6B9D2A4DFFBF2A8164819B7AFE9DF_1245384639 = (!isInTouchMode());
            {
                position = lookForSelectablePosition(position, true);
                {
                    setNextSelectedPositionInt(position);
                } //End block
            } //End block
            {
                mResurrectToPosition = position;
            } //End block
        } //End collapsed parenthetic
        {
            mLayoutMode = LAYOUT_SPECIFIC;
            mSpecificTop = mListPadding.top + y;
            {
                mSyncPosition = position;
                mSyncRowId = mAdapter.getItemId(position);
            } //End block
            requestLayout();
        } //End block
        addTaint(position);
        addTaint(y);
        // ---------- Original Method ----------
        //if (mAdapter == null) {
            //return;
        //}
        //if (!isInTouchMode()) {
            //position = lookForSelectablePosition(position, true);
            //if (position >= 0) {
                //setNextSelectedPositionInt(position);
            //}
        //} else {
            //mResurrectToPosition = position;
        //}
        //if (position >= 0) {
            //mLayoutMode = LAYOUT_SPECIFIC;
            //mSpecificTop = mListPadding.top + y;
            //if (mNeedSync) {
                //mSyncPosition = position;
                //mSyncRowId = mAdapter.getItemId(position);
            //}
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.394 -0400", hash_original_method = "813C2C2B521DC76439D7A0687ADC333C", hash_generated_method = "DED801A417D86767F07D3825342BB8BE")
    @Override
     void setSelectionInt(int position) {
        setNextSelectedPositionInt(position);
        boolean awakeScrollbars;
        awakeScrollbars = false;
        int selectedPosition;
        selectedPosition = mSelectedPosition;
        {
            {
                awakeScrollbars = true;
            } //End block
            {
                awakeScrollbars = true;
            } //End block
        } //End block
        layoutChildren();
        {
            awakenScrollBars();
        } //End block
        addTaint(position);
        // ---------- Original Method ----------
        //setNextSelectedPositionInt(position);
        //boolean awakeScrollbars = false;
        //final int selectedPosition = mSelectedPosition;
        //if (selectedPosition >= 0) {
            //if (position == selectedPosition - 1) {
                //awakeScrollbars = true;
            //} else if (position == selectedPosition + 1) {
                //awakeScrollbars = true;
            //}
        //}
        //layoutChildren();
        //if (awakeScrollbars) {
            //awakenScrollBars();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.395 -0400", hash_original_method = "F611253C286EB5F8129DFD60BE22D44F", hash_generated_method = "EA605C29888A46573395FA4123C51976")
    @Override
     int lookForSelectablePosition(int position, boolean lookDown) {
        ListAdapter adapter;
        adapter = mAdapter;
        {
            boolean var35A1F64E67CC6E0C06A8BA9582F2435F_506433544 = (adapter == null || isInTouchMode());
        } //End collapsed parenthetic
        int count;
        count = adapter.getCount();
        {
            {
                position = Math.max(0, position);
                {
                    boolean varF9E3A5AB0092C9F908FE41D43CDE1F43_630585241 = (position < count && !adapter.isEnabled(position));
                } //End collapsed parenthetic
            } //End block
            {
                position = Math.min(position, count - 1);
                {
                    boolean var86CF05D4F4C580D8A474D386CDE84CF9_787705361 = (position >= 0 && !adapter.isEnabled(position));
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(position);
        addTaint(lookDown);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2099068017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2099068017;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.395 -0400", hash_original_method = "BA94B118F7B33B042A8A5EE913A2CAC9", hash_generated_method = "6856869DC1BFBD01AB458454BA7C82EC")
    public void setSelectionAfterHeaderView() {
        int count;
        count = mHeaderViewInfos.size();
        {
            mNextSelectedPosition = 0;
        } //End block
        {
            setSelection(count);
        } //End block
        {
            mNextSelectedPosition = count;
            mLayoutMode = LAYOUT_SET_SELECTION;
        } //End block
        // ---------- Original Method ----------
        //final int count = mHeaderViewInfos.size();
        //if (count > 0) {
            //mNextSelectedPosition = 0;
            //return;
        //}
        //if (mAdapter != null) {
            //setSelection(count);
        //} else {
            //mNextSelectedPosition = count;
            //mLayoutMode = LAYOUT_SET_SELECTION;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.395 -0400", hash_original_method = "C6695FE09C5666FBD7C0ECDD7FFCA6CE", hash_generated_method = "AC8B3F247986FE0268F2E6B9FA2DE1B1")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        boolean handled;
        handled = super.dispatchKeyEvent(event);
        {
            View focused;
            focused = getFocusedChild();
            {
                boolean varD6F50D5E6BAAF6A4042506AB741CE740_1948567248 = (focused != null && event.getAction() == KeyEvent.ACTION_DOWN);
                {
                    handled = onKeyDown(event.getKeyCode(), event);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1676545354 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1676545354;
        // ---------- Original Method ----------
        //boolean handled = super.dispatchKeyEvent(event);
        //if (!handled) {
            //View focused = getFocusedChild();
            //if (focused != null && event.getAction() == KeyEvent.ACTION_DOWN) {
                //handled = onKeyDown(event.getKeyCode(), event);
            //}
        //}
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.398 -0400", hash_original_method = "82498D99AFEB0700B1F959E9E9927B59", hash_generated_method = "5116D17E7AD1FB6A20428A78C83359C1")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean var7B6BE27715D36B6032CB7DA2718D4FF1_1753976496 = (commonKey(keyCode, 1, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1456690970 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1456690970;
        // ---------- Original Method ----------
        //return commonKey(keyCode, 1, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.401 -0400", hash_original_method = "C105EC1B6481173F2A66D1C47882507B", hash_generated_method = "9F2BE6B2FEA3C9699708872B6E076DD3")
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean varACEC8A58158104BC4BBB2FE543212B03_338446134 = (commonKey(keyCode, repeatCount, event));
        addTaint(keyCode);
        addTaint(repeatCount);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_807723025 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_807723025;
        // ---------- Original Method ----------
        //return commonKey(keyCode, repeatCount, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.401 -0400", hash_original_method = "FFB4A1626C41573790F9B17FF23F8A09", hash_generated_method = "DDDA283747AF3B580241A1A2062C6D06")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean var7B6BE27715D36B6032CB7DA2718D4FF1_1170093585 = (commonKey(keyCode, 1, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_141571217 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_141571217;
        // ---------- Original Method ----------
        //return commonKey(keyCode, 1, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.410 -0400", hash_original_method = "1DD47D400FE7B21B7ADCD2D234FB64A7", hash_generated_method = "B1025BE3D519A4EF4F6ED9468C213B89")
    private boolean commonKey(int keyCode, int count, KeyEvent event) {
        {
            layoutChildren();
        } //End block
        boolean handled;
        handled = false;
        int action;
        action = event.getAction();
        {
            //Begin case KeyEvent.KEYCODE_DPAD_UP 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1840975174 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded();
                    {
                        {
                            {
                                boolean varA5B62ED4C691B4536F3BE2ACFD937D16_665915778 = (arrowScroll(FOCUS_UP));
                                {
                                    handled = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End block
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_1560684792 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_DPAD_UP 
            //Begin case KeyEvent.KEYCODE_DPAD_DOWN 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1292606982 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded();
                    {
                        {
                            {
                                boolean varAA5CCD5687C9D983EE1C69076A1EA7F2_1730723023 = (arrowScroll(FOCUS_DOWN));
                                {
                                    handled = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End block
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_1901150554 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_DPAD_DOWN 
            //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1504827219 = (event.hasNoModifiers());
                {
                    handled = handleHorizontalFocusWithinListItem(View.FOCUS_LEFT);
                } //End block
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_DPAD_LEFT 
            //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_237849213 = (event.hasNoModifiers());
                {
                    handled = handleHorizontalFocusWithinListItem(View.FOCUS_RIGHT);
                } //End block
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_DPAD_RIGHT 
            //Begin case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_840678708 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded();
                    {
                        boolean var0998D8B15B32EB34977168615D32B617_877803729 = (!handled
                            && event.getRepeatCount() == 0 && getChildCount() > 0);
                        {
                            keyPressed();
                            handled = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
            //Begin case KeyEvent.KEYCODE_SPACE 
            {
                boolean varC5267D5BFE7A3E261BDE80A07A8ECCFA_1281083501 = (mPopup == null || !mPopup.isShowing());
                {
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_1541666829 = (event.hasNoModifiers());
                        {
                            handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_DOWN);
                        } //End block
                        {
                            boolean varC6F58190DE4A31A0CF9704EF99A62451_1146767583 = (event.hasModifiers(KeyEvent.META_SHIFT_ON));
                            {
                                handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_UP);
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    handled = true;
                } //End block
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_SPACE 
            //Begin case KeyEvent.KEYCODE_PAGE_UP 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1962864388 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_UP);
                } //End block
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_1555659696 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_PAGE_UP 
            //Begin case KeyEvent.KEYCODE_PAGE_DOWN 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1257325448 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_DOWN);
                } //End block
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_653747125 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_PAGE_DOWN 
            //Begin case KeyEvent.KEYCODE_MOVE_HOME 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_134658267 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                } //End block
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_MOVE_HOME 
            //Begin case KeyEvent.KEYCODE_MOVE_END 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_106312047 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                } //End block
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_MOVE_END 
            //Begin case KeyEvent.KEYCODE_TAB 
            {
                {
                    boolean varC77C0C11194BD87DFEE086A32DCE5C18_1413336825 = (event.hasNoModifiers());
                    {
                        handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_DOWN);
                    } //End block
                    {
                        boolean var7B1040B2192949CFC257B6EE7F25C319_2013697466 = (event.hasModifiers(KeyEvent.META_SHIFT_ON));
                        {
                            handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_UP);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            //End case KeyEvent.KEYCODE_TAB 
        } //End block
        {
            boolean varF6449376E291BB335EF050093EE80110_1691383607 = (sendToTextFilter(keyCode, count, event));
        } //End collapsed parenthetic
        //Begin case KeyEvent.ACTION_DOWN 
        boolean var8C6E6C19273FC56B5C56CC7DEF63ED7B_798481281 = (super.onKeyDown(keyCode, event));
        //End case KeyEvent.ACTION_DOWN 
        //Begin case KeyEvent.ACTION_UP 
        boolean varEDD771EBF66425AD21882AB08CD0EE48_309718860 = (super.onKeyUp(keyCode, event));
        //End case KeyEvent.ACTION_UP 
        //Begin case KeyEvent.ACTION_MULTIPLE 
        boolean varC0357E39557DD275ECAF43C782C78502_516382429 = (super.onKeyMultiple(keyCode, count, event));
        //End case KeyEvent.ACTION_MULTIPLE 
        addTaint(keyCode);
        addTaint(count);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1806169226 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1806169226;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.419 -0400", hash_original_method = "CFFD02C88D512DC860E9CC0FE1096C45", hash_generated_method = "698BAC2AB28628A55D13BD2BCEBBEB24")
     boolean pageScroll(int direction) {
        int nextPage;
        nextPage = -1;
        boolean down;
        down = false;
        {
            nextPage = Math.max(0, mSelectedPosition - getChildCount() - 1);
        } //End block
        {
            nextPage = Math.min(mItemCount - 1, mSelectedPosition + getChildCount() - 1);
            down = true;
        } //End block
        {
            int position;
            position = lookForSelectablePosition(nextPage, down);
            {
                mLayoutMode = LAYOUT_SPECIFIC;
                mSpecificTop = mPaddingTop + getVerticalFadingEdgeLength();
                {
                    boolean varA164A5303752DF647D9BF6996D101837_333168564 = (down && position > mItemCount - getChildCount());
                    {
                        mLayoutMode = LAYOUT_FORCE_BOTTOM;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var110612621C7A8EA496F1D2C158694581_76929102 = (!down && position < getChildCount());
                    {
                        mLayoutMode = LAYOUT_FORCE_TOP;
                    } //End block
                } //End collapsed parenthetic
                setSelectionInt(position);
                invokeOnItemScrollListener();
                {
                    boolean var23B792A36C4A2414CF3FD466E934AAC2_102418751 = (!awakenScrollBars());
                    {
                        invalidate();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_732467766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_732467766;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.421 -0400", hash_original_method = "8893A9BFD4970E039D8D32407D02C15E", hash_generated_method = "28BA4354295CF8FA7157D7D50E5DAECC")
     boolean fullScroll(int direction) {
        boolean moved;
        moved = false;
        {
            {
                int position;
                position = lookForSelectablePosition(0, true);
                {
                    mLayoutMode = LAYOUT_FORCE_TOP;
                    setSelectionInt(position);
                    invokeOnItemScrollListener();
                } //End block
                moved = true;
            } //End block
        } //End block
        {
            {
                int position;
                position = lookForSelectablePosition(mItemCount - 1, true);
                {
                    mLayoutMode = LAYOUT_FORCE_BOTTOM;
                    setSelectionInt(position);
                    invokeOnItemScrollListener();
                } //End block
                moved = true;
            } //End block
        } //End block
        {
            boolean var5B952B5E17217FEE8BC4BB0979561FA3_377425860 = (moved && !awakenScrollBars());
            {
                awakenScrollBars();
                invalidate();
            } //End block
        } //End collapsed parenthetic
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_49226992 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_49226992;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.422 -0400", hash_original_method = "27083050B4DD915BDC5D45A692A1DFB7", hash_generated_method = "D4D48A761B8F315556E098AE40EF3B36")
    private boolean handleHorizontalFocusWithinListItem(int direction) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of"
                    + " {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
        } //End block
        int numChildren;
        numChildren = getChildCount();
        {
            View selectedView;
            selectedView = getSelectedView();
            {
                boolean var5A370CFD3CE8F716DF439EFB07635CD0_91144636 = (selectedView != null && selectedView.hasFocus() &&
                    selectedView instanceof ViewGroup);
                {
                    View currentFocus;
                    currentFocus = selectedView.findFocus();
                    View nextFocus;
                    nextFocus = FocusFinder.getInstance().findNextFocus(
                        (ViewGroup) selectedView, currentFocus, direction);
                    {
                        currentFocus.getFocusedRect(mTempRect);
                        offsetDescendantRectToMyCoords(currentFocus, mTempRect);
                        offsetRectIntoDescendantCoords(nextFocus, mTempRect);
                        {
                            boolean var76D8898CFBC448597F15A4BC0E876792_1460333637 = (nextFocus.requestFocus(direction, mTempRect));
                        } //End collapsed parenthetic
                    } //End block
                    View globalNextFocus;
                    globalNextFocus = FocusFinder.getInstance().findNextFocus(
                        (ViewGroup) getRootView(), currentFocus, direction);
                    {
                        boolean varB2F32E25506228F03370ADE074F28912_1267095569 = (isViewAncestorOf(globalNextFocus, this));
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_529214010 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_529214010;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.422 -0400", hash_original_method = "6B5D7DFA7F5B692B993CC3912D59B646", hash_generated_method = "F5EE501F2C19115988195622EC69553D")
     boolean arrowScroll(int direction) {
        try 
        {
            mInLayout = true;
            boolean handled;
            handled = arrowScrollImpl(direction);
            {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
            } //End block
        } //End block
        finally 
        {
            mInLayout = false;
        } //End block
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_809609391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_809609391;
        // ---------- Original Method ----------
        //try {
            //mInLayout = true;
            //final boolean handled = arrowScrollImpl(direction);
            //if (handled) {
                //playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
            //}
            //return handled;
        //} finally {
            //mInLayout = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.449 -0400", hash_original_method = "5F8F1549FF6A2936584D81A340335636", hash_generated_method = "0303A467E30BF245C6F206624DD47D0E")
    private boolean arrowScrollImpl(int direction) {
        {
            boolean var4229DDB8D3BBE3C4FC615E86EF9AD4FF_1653284144 = (getChildCount() <= 0);
        } //End collapsed parenthetic
        View selectedView;
        selectedView = getSelectedView();
        int selectedPos;
        selectedPos = mSelectedPosition;
        int nextSelectedPosition;
        nextSelectedPosition = lookForSelectablePositionOnScreen(direction);
        int amountToScroll;
        amountToScroll = amountToScroll(direction, nextSelectedPosition);
        ArrowScrollFocusResult focusResult;
        focusResult = arrowScrollFocused(direction);
        focusResult = null;
        {
            nextSelectedPosition = focusResult.getSelectedPosition();
            amountToScroll = focusResult.getAmountToScroll();
        } //End block
        boolean needToRedraw;
        needToRedraw = focusResult != null;
        {
            handleNewSelectionChange(selectedView, direction, nextSelectedPosition, focusResult != null);
            setSelectedPositionInt(nextSelectedPosition);
            setNextSelectedPositionInt(nextSelectedPosition);
            selectedView = getSelectedView();
            selectedPos = nextSelectedPosition;
            {
                View focused;
                focused = getFocusedChild();
                {
                    focused.clearFocus();
                } //End block
            } //End block
            needToRedraw = true;
            checkSelectionChanged();
        } //End block
        {
            scrollListItemsBy((direction == View.FOCUS_UP) ? amountToScroll : -amountToScroll);
            needToRedraw = true;
        } //End block
        {
            boolean varB8E5D6C0579FB6C2780425B3D1ABD141_727100713 = (mItemsCanFocus && (focusResult == null)
                && selectedView != null && selectedView.hasFocus());
            {
                View focused;
                focused = selectedView.findFocus();
                {
                    boolean var3BB0A88B4E6FC6416F98323008226B4B_1726090010 = (!isViewAncestorOf(focused, this) || distanceToView(focused) > 0);
                    {
                        focused.clearFocus();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var089D086D835620A272CDDA708424B586_1829004456 = (nextSelectedPosition == INVALID_POSITION && selectedView != null
                && !isViewAncestorOf(selectedView, this));
            {
                selectedView = null;
                hideSelector();
                mResurrectToPosition = INVALID_POSITION;
            } //End block
        } //End collapsed parenthetic
        {
            {
                positionSelector(selectedPos, selectedView);
                mSelectedTop = selectedView.getTop();
            } //End block
            {
                boolean varC828E793AFDA5CD988FA9008B6EB3B30_1798016029 = (!awakenScrollBars());
                {
                    invalidate();
                } //End block
            } //End collapsed parenthetic
            invokeOnItemScrollListener();
        } //End block
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1533687560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1533687560;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.453 -0400", hash_original_method = "5F7DFDAF299194D301FC447E78E3FD87", hash_generated_method = "2FC40E240F1C6C5A7BFBCC75F8701F97")
    private void handleNewSelectionChange(View selectedView, int direction, int newSelectedPosition,
            boolean newFocusAssigned) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("newSelectedPosition needs to be valid");
        } //End block
        View topView;
        View bottomView;
        int topViewIndex, bottomViewIndex;
        boolean topSelected;
        topSelected = false;
        int selectedIndex;
        selectedIndex = mSelectedPosition - mFirstPosition;
        int nextSelectedIndex;
        nextSelectedIndex = newSelectedPosition - mFirstPosition;
        {
            topViewIndex = nextSelectedIndex;
            bottomViewIndex = selectedIndex;
            topView = getChildAt(topViewIndex);
            bottomView = selectedView;
            topSelected = true;
        } //End block
        {
            topViewIndex = selectedIndex;
            bottomViewIndex = nextSelectedIndex;
            topView = selectedView;
            bottomView = getChildAt(bottomViewIndex);
        } //End block
        int numChildren;
        numChildren = getChildCount();
        {
            topView.setSelected(!newFocusAssigned && topSelected);
            measureAndAdjustDown(topView, topViewIndex, numChildren);
        } //End block
        {
            bottomView.setSelected(!newFocusAssigned && !topSelected);
            measureAndAdjustDown(bottomView, bottomViewIndex, numChildren);
        } //End block
        addTaint(selectedView.getTaint());
        addTaint(direction);
        addTaint(newSelectedPosition);
        addTaint(newFocusAssigned);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.454 -0400", hash_original_method = "D9B7EDD91437C9CF7E31BD236F25B8F3", hash_generated_method = "C3070D45B962ECA7155093511538FE7D")
    private void measureAndAdjustDown(View child, int childIndex, int numChildren) {
        int oldHeight;
        oldHeight = child.getHeight();
        measureItem(child);
        {
            boolean var7B22EF90C45277911AB272B76E96E5DA_2136838755 = (child.getMeasuredHeight() != oldHeight);
            {
                relayoutMeasuredItem(child);
                int heightDelta;
                heightDelta = child.getMeasuredHeight() - oldHeight;
                {
                    int i;
                    i = childIndex + 1;
                    {
                        getChildAt(i).offsetTopAndBottom(heightDelta);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(child.getTaint());
        addTaint(childIndex);
        addTaint(numChildren);
        // ---------- Original Method ----------
        //int oldHeight = child.getHeight();
        //measureItem(child);
        //if (child.getMeasuredHeight() != oldHeight) {
            //relayoutMeasuredItem(child);
            //final int heightDelta = child.getMeasuredHeight() - oldHeight;
            //for (int i = childIndex + 1; i < numChildren; i++) {
                //getChildAt(i).offsetTopAndBottom(heightDelta);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.460 -0400", hash_original_method = "195C1D433E8B0F15028E4D73EB2D6DE2", hash_generated_method = "A47274493E5C76AA1D436CBAEFBB9138")
    private void measureItem(View child) {
        ViewGroup.LayoutParams p;
        p = child.getLayoutParams();
        {
            p = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        } //End block
        int childWidthSpec;
        childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                mListPadding.left + mListPadding.right, p.width);
        int lpHeight;
        lpHeight = p.height;
        int childHeightSpec;
        {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
        } //End block
        {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        } //End block
        child.measure(childWidthSpec, childHeightSpec);
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //ViewGroup.LayoutParams p = child.getLayoutParams();
        //if (p == null) {
            //p = new ViewGroup.LayoutParams(
                    //ViewGroup.LayoutParams.MATCH_PARENT,
                    //ViewGroup.LayoutParams.WRAP_CONTENT);
        //}
        //int childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                //mListPadding.left + mListPadding.right, p.width);
        //int lpHeight = p.height;
        //int childHeightSpec;
        //if (lpHeight > 0) {
            //childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
        //} else {
            //childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        //}
        //child.measure(childWidthSpec, childHeightSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.467 -0400", hash_original_method = "69D49227DB6AC5D384C2E3A710CB930F", hash_generated_method = "A0B3AC1C1E5CCEF2777353CC8A15AE4C")
    private void relayoutMeasuredItem(View child) {
        int w;
        w = child.getMeasuredWidth();
        int h;
        h = child.getMeasuredHeight();
        int childLeft;
        childLeft = mListPadding.left;
        int childRight;
        childRight = childLeft + w;
        int childTop;
        childTop = child.getTop();
        int childBottom;
        childBottom = childTop + h;
        child.layout(childLeft, childTop, childRight, childBottom);
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //final int w = child.getMeasuredWidth();
        //final int h = child.getMeasuredHeight();
        //final int childLeft = mListPadding.left;
        //final int childRight = childLeft + w;
        //final int childTop = child.getTop();
        //final int childBottom = childTop + h;
        //child.layout(childLeft, childTop, childRight, childBottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.467 -0400", hash_original_method = "42F2E28C8994E7757E02659DFEBDEFA8", hash_generated_method = "20120BAB1073AA8DFC7B96DCF8335B90")
    private int getArrowScrollPreviewLength() {
        int var32C3DF276D4CC5AB85EAD318AE4B92AE_116317792 = (Math.max(MIN_SCROLL_PREVIEW_PIXELS, getVerticalFadingEdgeLength()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_178734777 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_178734777;
        // ---------- Original Method ----------
        //return Math.max(MIN_SCROLL_PREVIEW_PIXELS, getVerticalFadingEdgeLength());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.470 -0400", hash_original_method = "0CBCA538A833739B1FF13F8466C4BF4D", hash_generated_method = "DFAAE4DF82BB97E93AAE7A67FD5109A3")
    private int amountToScroll(int direction, int nextSelectedPosition) {
        int listBottom;
        listBottom = getHeight() - mListPadding.bottom;
        int listTop;
        listTop = mListPadding.top;
        int numChildren;
        numChildren = getChildCount();
        {
            int indexToMakeVisible;
            indexToMakeVisible = numChildren - 1;
            {
                indexToMakeVisible = nextSelectedPosition - mFirstPosition;
            } //End block
            int positionToMakeVisible;
            positionToMakeVisible = mFirstPosition + indexToMakeVisible;
            View viewToMakeVisible;
            viewToMakeVisible = getChildAt(indexToMakeVisible);
            int goalBottom;
            goalBottom = listBottom;
            {
                goalBottom -= getArrowScrollPreviewLength();
            } //End block
            {
                boolean var5F736F6450B740E6E9E57C387C57D4DD_650995533 = (viewToMakeVisible.getBottom() <= goalBottom);
            } //End collapsed parenthetic
            {
                boolean var8324A997C3E5144DDD35F3BF25EFB670_724062035 = (nextSelectedPosition != INVALID_POSITION
                    && (goalBottom - viewToMakeVisible.getTop()) >= getMaxScrollAmount());
            } //End collapsed parenthetic
            int amountToScroll;
            amountToScroll = (viewToMakeVisible.getBottom() - goalBottom);
            {
                int max;
                max = getChildAt(numChildren - 1).getBottom() - listBottom;
                amountToScroll = Math.min(amountToScroll, max);
            } //End block
            int var1934DA7AFCB63592141CB73FE3F03962_37949533 = (Math.min(amountToScroll, getMaxScrollAmount()));
        } //End block
        {
            int indexToMakeVisible;
            indexToMakeVisible = 0;
            {
                indexToMakeVisible = nextSelectedPosition - mFirstPosition;
            } //End block
            int positionToMakeVisible;
            positionToMakeVisible = mFirstPosition + indexToMakeVisible;
            View viewToMakeVisible;
            viewToMakeVisible = getChildAt(indexToMakeVisible);
            int goalTop;
            goalTop = listTop;
            {
                goalTop += getArrowScrollPreviewLength();
            } //End block
            {
                boolean var40E2B917BF16844A067981F2A72A29CC_1130755374 = (viewToMakeVisible.getTop() >= goalTop);
            } //End collapsed parenthetic
            {
                boolean varC22CD0C0296052301FAE425C57E08A6B_370343907 = (nextSelectedPosition != INVALID_POSITION &&
                    (viewToMakeVisible.getBottom() - goalTop) >= getMaxScrollAmount());
            } //End collapsed parenthetic
            int amountToScroll;
            amountToScroll = (goalTop - viewToMakeVisible.getTop());
            {
                int max;
                max = listTop - getChildAt(0).getTop();
                amountToScroll = Math.min(amountToScroll,  max);
            } //End block
            int var1934DA7AFCB63592141CB73FE3F03962_2041261168 = (Math.min(amountToScroll, getMaxScrollAmount()));
        } //End block
        addTaint(direction);
        addTaint(nextSelectedPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_91317226 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_91317226;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.472 -0400", hash_original_method = "760C70065AEFE7BC7EE2B10D159765ED", hash_generated_method = "DF2C679F197FADE202D6BF65D9768270")
    private int lookForSelectablePositionOnScreen(int direction) {
        int firstPosition;
        firstPosition = mFirstPosition;
        {
            int startPos;
            startPos = mSelectedPosition + 1;
            startPos = firstPosition;
            {
                boolean varFD8F153F7B9B0445D1C8B98618EA7E23_631443234 = (startPos >= mAdapter.getCount());
            } //End collapsed parenthetic
            {
                startPos = firstPosition;
            } //End block
            int lastVisiblePos;
            lastVisiblePos = getLastVisiblePosition();
            ListAdapter adapter;
            adapter = getAdapter();
            {
                int pos;
                pos = startPos;
                {
                    {
                        boolean var705701EB8E699AA442E2F4E862DC96E7_1626291695 = (adapter.isEnabled(pos)
                        && getChildAt(pos - firstPosition).getVisibility() == View.VISIBLE);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int last;
            last = firstPosition + getChildCount() - 1;
            int startPos;
            startPos = mSelectedPosition - 1;
            startPos = firstPosition + getChildCount() - 1;
            {
                boolean var52FACA214769BF23A240C7E957876F70_1281770329 = (startPos < 0 || startPos >= mAdapter.getCount());
            } //End collapsed parenthetic
            {
                startPos = last;
            } //End block
            ListAdapter adapter;
            adapter = getAdapter();
            {
                int pos;
                pos = startPos;
                {
                    {
                        boolean var705701EB8E699AA442E2F4E862DC96E7_1190568392 = (adapter.isEnabled(pos)
                        && getChildAt(pos - firstPosition).getVisibility() == View.VISIBLE);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(direction);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852103430 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852103430;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.476 -0400", hash_original_method = "2622F1B1638C7BCDD9C32B9CBE54AF85", hash_generated_method = "30F2F19FF82784E6FAA88252183A950A")
    private ArrowScrollFocusResult arrowScrollFocused(final int direction) {
        ArrowScrollFocusResult varB4EAC82CA7396A68D541C85D26508E83_330588785 = null; //Variable for return #1
        ArrowScrollFocusResult varB4EAC82CA7396A68D541C85D26508E83_1023639026 = null; //Variable for return #2
        ArrowScrollFocusResult varB4EAC82CA7396A68D541C85D26508E83_453102419 = null; //Variable for return #3
        ArrowScrollFocusResult varB4EAC82CA7396A68D541C85D26508E83_1268786302 = null; //Variable for return #4
        View selectedView;
        selectedView = getSelectedView();
        View newFocus;
        {
            boolean varA1513A08695E8074CF4C05D652884B2C_1878928569 = (selectedView != null && selectedView.hasFocus());
            {
                View oldFocus;
                oldFocus = selectedView.findFocus();
                newFocus = FocusFinder.getInstance().findNextFocus(this, oldFocus, direction);
            } //End block
            {
                {
                    boolean topFadingEdgeShowing;
                    topFadingEdgeShowing = (mFirstPosition > 0);
                    int listTop;
                    listTop = mListPadding.top +
                        (topFadingEdgeShowing ? getArrowScrollPreviewLength() : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
                    int ySearchPoint;
                    boolean var0C9DFED1B79DF626EEB83B6645BDE791_679020683 = ((selectedView != null && selectedView.getTop() > listTop));
                    ySearchPoint = selectedView.getTop();
                    ySearchPoint = listTop;
                    mTempRect.set(0, ySearchPoint, 0, ySearchPoint);
                } //End block
                {
                    boolean bottomFadingEdgeShowing;
                    bottomFadingEdgeShowing = (mFirstPosition + getChildCount() - 1) < mItemCount;
                    int listBottom;
                    listBottom = getHeight() - mListPadding.bottom -
                        (bottomFadingEdgeShowing ? getArrowScrollPreviewLength() : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
                    int ySearchPoint;
                    boolean var535C017266C0FE7A092B0CC38B96CB22_148788228 = ((selectedView != null && selectedView.getBottom() < listBottom));
                    ySearchPoint = selectedView.getBottom();
                    ySearchPoint = listBottom;
                    mTempRect.set(0, ySearchPoint, 0, ySearchPoint);
                } //End block
                newFocus = FocusFinder.getInstance().findNextFocusFromRect(this, mTempRect, direction);
            } //End block
        } //End collapsed parenthetic
        {
            int positionOfNewFocus;
            positionOfNewFocus = positionOfNewFocus(newFocus);
            {
                int selectablePosition;
                selectablePosition = lookForSelectablePositionOnScreen(direction);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_330588785 = null;
                } //End block
            } //End block
            int focusScroll;
            focusScroll = amountToScrollToNewFocus(direction, newFocus, positionOfNewFocus);
            int maxScrollAmount;
            maxScrollAmount = getMaxScrollAmount();
            {
                newFocus.requestFocus(direction);
                mArrowScrollFocusResult.populate(positionOfNewFocus, focusScroll);
                varB4EAC82CA7396A68D541C85D26508E83_1023639026 = mArrowScrollFocusResult;
            } //End block
            {
                boolean varEB2D69BE3268364AC7D3855A8FF1F45F_1036629162 = (distanceToView(newFocus) < maxScrollAmount);
                {
                    newFocus.requestFocus(direction);
                    mArrowScrollFocusResult.populate(positionOfNewFocus, maxScrollAmount);
                    varB4EAC82CA7396A68D541C85D26508E83_453102419 = mArrowScrollFocusResult;
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1268786302 = null;
        addTaint(direction);
        ArrowScrollFocusResult varA7E53CE21691AB073D9660D615818899_2048401574; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2048401574 = varB4EAC82CA7396A68D541C85D26508E83_330588785;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2048401574 = varB4EAC82CA7396A68D541C85D26508E83_1023639026;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2048401574 = varB4EAC82CA7396A68D541C85D26508E83_453102419;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2048401574 = varB4EAC82CA7396A68D541C85D26508E83_1268786302;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2048401574.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2048401574;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.484 -0400", hash_original_method = "E7A74EC59726801D8AE9EB276549022E", hash_generated_method = "44E68C331F5912242FDF386B153D5B61")
    private int positionOfNewFocus(View newFocus) {
        int numChildren;
        numChildren = getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean var743CF1855186FF404A0881633A428604_473673695 = (isViewAncestorOf(newFocus, child));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("newFocus is not a child of any of the"
                + " children of the list!");
        addTaint(newFocus.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491374175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491374175;
        // ---------- Original Method ----------
        //final int numChildren = getChildCount();
        //for (int i = 0; i < numChildren; i++) {
            //final View child = getChildAt(i);
            //if (isViewAncestorOf(newFocus, child)) {
                //return mFirstPosition + i;
            //}
        //}
        //throw new IllegalArgumentException("newFocus is not a child of any of the"
                //+ " children of the list!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.484 -0400", hash_original_method = "3B08BDE00067F884387760F12D698F42", hash_generated_method = "488236EEFBECA39A9376B13825E7C0E8")
    private boolean isViewAncestorOf(View child, View parent) {
        ViewParent theParent;
        theParent = child.getParent();
        boolean var31AD4BA23C577C9A637BA02E579FD0B2_1042920045 = ((theParent instanceof ViewGroup) && isViewAncestorOf((View) theParent, parent));
        addTaint(child.getTaint());
        addTaint(parent.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_952604048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_952604048;
        // ---------- Original Method ----------
        //if (child == parent) {
            //return true;
        //}
        //final ViewParent theParent = child.getParent();
        //return (theParent instanceof ViewGroup) && isViewAncestorOf((View) theParent, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.485 -0400", hash_original_method = "972857949DC34A723A630B605759B3EF", hash_generated_method = "0CE842270572F641369BA343FB1106F4")
    private int amountToScrollToNewFocus(int direction, View newFocus, int positionOfNewFocus) {
        int amountToScroll;
        amountToScroll = 0;
        newFocus.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(newFocus, mTempRect);
        {
            {
                amountToScroll = mListPadding.top - mTempRect.top;
                {
                    amountToScroll += getArrowScrollPreviewLength();
                } //End block
            } //End block
        } //End block
        {
            int listBottom;
            listBottom = getHeight() - mListPadding.bottom;
            {
                amountToScroll = mTempRect.bottom - listBottom;
                {
                    amountToScroll += getArrowScrollPreviewLength();
                } //End block
            } //End block
        } //End block
        addTaint(direction);
        addTaint(newFocus.getTaint());
        addTaint(positionOfNewFocus);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389032141 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389032141;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.490 -0400", hash_original_method = "2468FB71A40A0019FA8D57CEA81AC8A6", hash_generated_method = "9375E15A2019AE92254FB7EDB92D4EE3")
    private int distanceToView(View descendant) {
        int distance;
        distance = 0;
        descendant.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(descendant, mTempRect);
        int listBottom;
        listBottom = mBottom - mTop - mListPadding.bottom;
        {
            distance = mListPadding.top - mTempRect.bottom;
        } //End block
        {
            distance = mTempRect.top - listBottom;
        } //End block
        addTaint(descendant.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428436152 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428436152;
        // ---------- Original Method ----------
        //int distance = 0;
        //descendant.getDrawingRect(mTempRect);
        //offsetDescendantRectToMyCoords(descendant, mTempRect);
        //final int listBottom = mBottom - mTop - mListPadding.bottom;
        //if (mTempRect.bottom < mListPadding.top) {
            //distance = mListPadding.top - mTempRect.bottom;
        //} else if (mTempRect.top > listBottom) {
            //distance = mTempRect.top - listBottom;
        //}
        //return distance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.495 -0400", hash_original_method = "FAA0316A71F66D005638E2A277415AFB", hash_generated_method = "4723E778C61D3FE69D600AAD5FCBBDF9")
    private void scrollListItemsBy(int amount) {
        offsetChildrenTopAndBottom(amount);
        int listBottom;
        listBottom = getHeight() - mListPadding.bottom;
        int listTop;
        listTop = mListPadding.top;
        AbsListView.RecycleBin recycleBin;
        recycleBin = mRecycler;
        {
            int numChildren;
            numChildren = getChildCount();
            View last;
            last = getChildAt(numChildren - 1);
            {
                boolean var5F1380678D3DF277A8634CE4F78FA5E2_810100387 = (last.getBottom() < listBottom);
                {
                    int lastVisiblePosition;
                    lastVisiblePosition = mFirstPosition + numChildren - 1;
                    {
                        last = addViewBelow(last, lastVisiblePosition);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean var5F1380678D3DF277A8634CE4F78FA5E2_298475579 = (last.getBottom() < listBottom);
                {
                    offsetChildrenTopAndBottom(listBottom - last.getBottom());
                } //End block
            } //End collapsed parenthetic
            View first;
            first = getChildAt(0);
            {
                boolean var5DEAA936426734BA7061F416FF8C6D22_1225971941 = (first.getBottom() < listTop);
                {
                    AbsListView.LayoutParams layoutParams;
                    layoutParams = (LayoutParams) first.getLayoutParams();
                    {
                        boolean var2ED08FF5DD3428B26AE67127DC8E5467_1589376731 = (recycleBin.shouldRecycleViewType(layoutParams.viewType));
                        {
                            detachViewFromParent(first);
                            recycleBin.addScrapView(first, mFirstPosition);
                        } //End block
                        {
                            removeViewInLayout(first);
                        } //End block
                    } //End collapsed parenthetic
                    first = getChildAt(0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            View first;
            first = getChildAt(0);
            {
                boolean var4D6C61E96E1628FDB98784EB678A415B_1293078632 = ((first.getTop() > listTop) && (mFirstPosition > 0));
                {
                    first = addViewAbove(first, mFirstPosition);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varEA4423DF7697B0235733DDAA9E5B11E5_2031953398 = (first.getTop() > listTop);
                {
                    offsetChildrenTopAndBottom(listTop - first.getTop());
                } //End block
            } //End collapsed parenthetic
            int lastIndex;
            lastIndex = getChildCount() - 1;
            View last;
            last = getChildAt(lastIndex);
            {
                boolean var6CFFE8EA59E4FF6F1E1615BCEB3548F9_1329704182 = (last.getTop() > listBottom);
                {
                    AbsListView.LayoutParams layoutParams;
                    layoutParams = (LayoutParams) last.getLayoutParams();
                    {
                        boolean var2ED08FF5DD3428B26AE67127DC8E5467_1152002357 = (recycleBin.shouldRecycleViewType(layoutParams.viewType));
                        {
                            detachViewFromParent(last);
                            recycleBin.addScrapView(last, mFirstPosition+lastIndex);
                        } //End block
                        {
                            removeViewInLayout(last);
                        } //End block
                    } //End collapsed parenthetic
                    last = getChildAt(--lastIndex);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(amount);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.499 -0400", hash_original_method = "9F36487536DE2965CEF1C4C9236F1DF4", hash_generated_method = "39D2653BA40F51116806DA1E4CED710C")
    private View addViewAbove(View theView, int position) {
        View varB4EAC82CA7396A68D541C85D26508E83_899987793 = null; //Variable for return #1
        int abovePosition;
        abovePosition = position - 1;
        View view;
        view = obtainView(abovePosition, mIsScrap);
        int edgeOfNewChild;
        edgeOfNewChild = theView.getTop() - mDividerHeight;
        setupChild(view, abovePosition, edgeOfNewChild, false, mListPadding.left,
                false, mIsScrap[0]);
        varB4EAC82CA7396A68D541C85D26508E83_899987793 = view;
        addTaint(theView.getTaint());
        addTaint(position);
        varB4EAC82CA7396A68D541C85D26508E83_899987793.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_899987793;
        // ---------- Original Method ----------
        //int abovePosition = position - 1;
        //View view = obtainView(abovePosition, mIsScrap);
        //int edgeOfNewChild = theView.getTop() - mDividerHeight;
        //setupChild(view, abovePosition, edgeOfNewChild, false, mListPadding.left,
                //false, mIsScrap[0]);
        //return view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.502 -0400", hash_original_method = "D4F2FE3018B44C78CF4E93EBC6FE5FC7", hash_generated_method = "C11E9717E514A33F0DF3070CEA7D4829")
    private View addViewBelow(View theView, int position) {
        View varB4EAC82CA7396A68D541C85D26508E83_1686420685 = null; //Variable for return #1
        int belowPosition;
        belowPosition = position + 1;
        View view;
        view = obtainView(belowPosition, mIsScrap);
        int edgeOfNewChild;
        edgeOfNewChild = theView.getBottom() + mDividerHeight;
        setupChild(view, belowPosition, edgeOfNewChild, true, mListPadding.left,
                false, mIsScrap[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1686420685 = view;
        addTaint(theView.getTaint());
        addTaint(position);
        varB4EAC82CA7396A68D541C85D26508E83_1686420685.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1686420685;
        // ---------- Original Method ----------
        //int belowPosition = position + 1;
        //View view = obtainView(belowPosition, mIsScrap);
        //int edgeOfNewChild = theView.getBottom() + mDividerHeight;
        //setupChild(view, belowPosition, edgeOfNewChild, true, mListPadding.left,
                //false, mIsScrap[0]);
        //return view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.503 -0400", hash_original_method = "B028681B6F4AF7B56D2E022B96A1F853", hash_generated_method = "FAC3768DB5C6CA1E40D91C9DDCFC4DB7")
    public void setItemsCanFocus(boolean itemsCanFocus) {
        mItemsCanFocus = itemsCanFocus;
        {
            setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        } //End block
        // ---------- Original Method ----------
        //mItemsCanFocus = itemsCanFocus;
        //if (!itemsCanFocus) {
            //setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.503 -0400", hash_original_method = "1C95AE1007B5CDC38C9B3E3B2904F365", hash_generated_method = "83BA386F7869C058A79F5ECDC560F65B")
    public boolean getItemsCanFocus() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_579519175 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_579519175;
        // ---------- Original Method ----------
        //return mItemsCanFocus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.503 -0400", hash_original_method = "719E5FD40BAA2B7205DD0269FBFE398A", hash_generated_method = "DBB4D9B6ECAA96E7DC02A9E7AC127766")
    @Override
    public boolean isOpaque() {
        boolean retValue;
        retValue = (mCachingActive && mIsCacheColorOpaque && mDividerIsOpaque &&
                hasOpaqueScrollbars()) || super.isOpaque();
        {
            int listTop;
            listTop = mListPadding.top;
            listTop = mPaddingTop;
            View first;
            first = getChildAt(0);
            {
                boolean var37967F45E1391B4313D5330FBE659A90_1711284705 = (first == null || first.getTop() > listTop);
            } //End collapsed parenthetic
            int listBottom;
            listBottom = getHeight() -
                    (mListPadding != null ? mListPadding.bottom : mPaddingBottom);//DSFIXME:  CODE0008: Nested ternary operator in expression
            View last;
            last = getChildAt(getChildCount() - 1);
            {
                boolean varA905B41E3DA83EC3F86F88778ACFCAD2_2125859352 = (last == null || last.getBottom() < listBottom);
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1397117667 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1397117667;
        // ---------- Original Method ----------
        //boolean retValue = (mCachingActive && mIsCacheColorOpaque && mDividerIsOpaque &&
                //hasOpaqueScrollbars()) || super.isOpaque();
        //if (retValue) {
            //final int listTop = mListPadding != null ? mListPadding.top : mPaddingTop;
            //View first = getChildAt(0);
            //if (first == null || first.getTop() > listTop) {
                //return false;
            //}
            //final int listBottom = getHeight() -
                    //(mListPadding != null ? mListPadding.bottom : mPaddingBottom);
            //View last = getChildAt(getChildCount() - 1);
            //if (last == null || last.getBottom() < listBottom) {
                //return false;
            //}
        //}
        //return retValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.513 -0400", hash_original_method = "465D449366429949FD8ADA654918A0E2", hash_generated_method = "812FFA0E47FA36AA943C82074F462D0D")
    @Override
    public void setCacheColorHint(int color) {
        boolean opaque;
        opaque = (color >>> 24) == 0xFF;
        mIsCacheColorOpaque = opaque;
        {
            {
                mDividerPaint = new Paint();
            } //End block
            mDividerPaint.setColor(color);
        } //End block
        super.setCacheColorHint(color);
        addTaint(color);
        // ---------- Original Method ----------
        //final boolean opaque = (color >>> 24) == 0xFF;
        //mIsCacheColorOpaque = opaque;
        //if (opaque) {
            //if (mDividerPaint == null) {
                //mDividerPaint = new Paint();
            //}
            //mDividerPaint.setColor(color);
        //}
        //super.setCacheColorHint(color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.513 -0400", hash_original_method = "9A5C934D25A361940ECD1D897C78B567", hash_generated_method = "44AD31054B48B3DF3FDD14F5A9BE97D7")
     void drawOverscrollHeader(Canvas canvas, Drawable drawable, Rect bounds) {
        int height;
        height = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(bounds);
        int span;
        span = bounds.bottom - bounds.top;
        {
            bounds.top = bounds.bottom - height;
        } //End block
        drawable.setBounds(bounds);
        drawable.draw(canvas);
        canvas.restore();
        addTaint(canvas.getTaint());
        addTaint(drawable.getTaint());
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        //final int height = drawable.getMinimumHeight();
        //canvas.save();
        //canvas.clipRect(bounds);
        //final int span = bounds.bottom - bounds.top;
        //if (span < height) {
            //bounds.top = bounds.bottom - height;
        //}
        //drawable.setBounds(bounds);
        //drawable.draw(canvas);
        //canvas.restore();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.514 -0400", hash_original_method = "3C862E16BE3AA71DC427E03E79AFA46F", hash_generated_method = "D827737DF836874EA18E1D76B2CE8BCB")
     void drawOverscrollFooter(Canvas canvas, Drawable drawable, Rect bounds) {
        int height;
        height = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(bounds);
        int span;
        span = bounds.bottom - bounds.top;
        {
            bounds.bottom = bounds.top + height;
        } //End block
        drawable.setBounds(bounds);
        drawable.draw(canvas);
        canvas.restore();
        addTaint(canvas.getTaint());
        addTaint(drawable.getTaint());
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        //final int height = drawable.getMinimumHeight();
        //canvas.save();
        //canvas.clipRect(bounds);
        //final int span = bounds.bottom - bounds.top;
        //if (span < height) {
            //bounds.bottom = bounds.top + height;
        //}
        //drawable.setBounds(bounds);
        //drawable.draw(canvas);
        //canvas.restore();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.527 -0400", hash_original_method = "2FA3D064F2DBB643D61459E2FE6AA64C", hash_generated_method = "F8CCA1F3C5B8324FA1D250E8170EE17C")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        {
            mCachingActive = true;
        } //End block
        int dividerHeight;
        dividerHeight = mDividerHeight;
        Drawable overscrollHeader;
        overscrollHeader = mOverScrollHeader;
        Drawable overscrollFooter;
        overscrollFooter = mOverScrollFooter;
        boolean drawOverscrollHeader;
        drawOverscrollHeader = overscrollHeader != null;
        boolean drawOverscrollFooter;
        drawOverscrollFooter = overscrollFooter != null;
        boolean drawDividers;
        drawDividers = dividerHeight > 0 && mDivider != null;
        {
            Rect bounds;
            bounds = mTempRect;
            bounds.left = mPaddingLeft;
            bounds.right = mRight - mLeft - mPaddingRight;
            int count;
            count = getChildCount();
            int headerCount;
            headerCount = mHeaderViewInfos.size();
            int itemCount;
            itemCount = mItemCount;
            int footerLimit;
            footerLimit = itemCount - mFooterViewInfos.size() - 1;
            boolean headerDividers;
            headerDividers = mHeaderDividersEnabled;
            boolean footerDividers;
            footerDividers = mFooterDividersEnabled;
            int first;
            first = mFirstPosition;
            boolean areAllItemsSelectable;
            areAllItemsSelectable = mAreAllItemsSelectable;
            ListAdapter adapter;
            adapter = mAdapter;
            boolean fillForMissingDividers;
            fillForMissingDividers = isOpaque() && !super.isOpaque();
            {
                mDividerPaint = new Paint();
                mDividerPaint.setColor(getCacheColorHint());
            } //End block
            Paint paint;
            paint = mDividerPaint;
            int effectivePaddingTop;
            effectivePaddingTop = 0;
            int effectivePaddingBottom;
            effectivePaddingBottom = 0;
            {
                effectivePaddingTop = mListPadding.top;
                effectivePaddingBottom = mListPadding.bottom;
            } //End block
            int listBottom;
            listBottom = mBottom - mTop - effectivePaddingBottom + mScrollY;
            {
                int bottom;
                bottom = 0;
                int scrollY;
                scrollY = mScrollY;
                {
                    {
                        bounds.bottom = 0;
                        bounds.top = scrollY;
                        drawOverscrollHeader(canvas, overscrollHeader, bounds);
                    } //End block
                    {
                        bounds.bottom = 0;
                        bounds.top = -dividerHeight;
                        drawDivider(canvas, bounds, -1);
                    } //End block
                } //End block
                {
                    int i;
                    i = 0;
                    {
                        {
                            View child;
                            child = getChildAt(i);
                            bottom = child.getBottom();
                            {
                                {
                                    boolean var6726FD4BAAAC9954E951547807371C28_760541676 = ((areAllItemsSelectable ||
                                    (adapter.isEnabled(first + i) && (i == count - 1 ||
                                            adapter.isEnabled(first + i + 1)))));
                                    {
                                        bounds.top = bottom;
                                        bounds.bottom = bottom + dividerHeight;
                                        drawDivider(canvas, bounds, i);
                                    } //End block
                                    {
                                        bounds.top = bottom;
                                        bounds.bottom = bottom + dividerHeight;
                                        canvas.drawRect(bounds, paint);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                int overFooterBottom;
                overFooterBottom = mBottom + mScrollY;
                {
                    bounds.top = bottom;
                    bounds.bottom = overFooterBottom;
                    drawOverscrollFooter(canvas, overscrollFooter, bounds);
                } //End block
            } //End block
            {
                int top;
                int scrollY;
                scrollY = mScrollY;
                {
                    bounds.top = scrollY;
                    bounds.bottom = getChildAt(0).getTop();
                    drawOverscrollHeader(canvas, overscrollHeader, bounds);
                } //End block
                int start;
                start = 1;
                start = 0;
                {
                    int i;
                    i = start;
                    {
                        {
                            View child;
                            child = getChildAt(i);
                            top = child.getTop();
                            {
                                {
                                    boolean var6726FD4BAAAC9954E951547807371C28_2144755444 = ((areAllItemsSelectable ||
                                    (adapter.isEnabled(first + i) && (i == count - 1 ||
                                            adapter.isEnabled(first + i + 1)))));
                                    {
                                        bounds.top = top - dividerHeight;
                                        bounds.bottom = top;
                                        drawDivider(canvas, bounds, i - 1);
                                    } //End block
                                    {
                                        bounds.top = top - dividerHeight;
                                        bounds.bottom = top;
                                        canvas.drawRect(bounds, paint);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        int absListBottom;
                        absListBottom = mBottom;
                        bounds.top = absListBottom;
                        bounds.bottom = absListBottom + scrollY;
                        drawOverscrollFooter(canvas, overscrollFooter, bounds);
                    } //End block
                    {
                        bounds.top = listBottom;
                        bounds.bottom = listBottom + dividerHeight;
                        drawDivider(canvas, bounds, -1);
                    } //End block
                } //End block
            } //End block
        } //End block
        super.dispatchDraw(canvas);
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.527 -0400", hash_original_method = "4EC2B6750B1C7732AC3B627095EC138F", hash_generated_method = "861FF943076E810EB6D16C4CC5D0CC34")
    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean more;
        more = super.drawChild(canvas, child, drawingTime);
        {
            mCachingActive = false;
        } //End block
        addTaint(canvas.getTaint());
        addTaint(child.getTaint());
        addTaint(drawingTime);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1498768249 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1498768249;
        // ---------- Original Method ----------
        //boolean more = super.drawChild(canvas, child, drawingTime);
        //if (mCachingActive && child.mCachingFailed) {
            //mCachingActive = false;
        //}
        //return more;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.528 -0400", hash_original_method = "AB3CC143C94AF212348DFB5018C60850", hash_generated_method = "58FAB2E691272B46AD9D9AAD33073A18")
     void drawDivider(Canvas canvas, Rect bounds, int childIndex) {
        Drawable divider;
        divider = mDivider;
        divider.setBounds(bounds);
        divider.draw(canvas);
        addTaint(canvas.getTaint());
        addTaint(bounds.getTaint());
        addTaint(childIndex);
        // ---------- Original Method ----------
        //final Drawable divider = mDivider;
        //divider.setBounds(bounds);
        //divider.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.529 -0400", hash_original_method = "7B5403D1FD6AC98A776FCB41ADD8E487", hash_generated_method = "55B1A5D258671DB57C59A79DBDBE418B")
    public Drawable getDivider() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_648992163 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_648992163 = mDivider;
        varB4EAC82CA7396A68D541C85D26508E83_648992163.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_648992163;
        // ---------- Original Method ----------
        //return mDivider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.534 -0400", hash_original_method = "7913B276C2BDCD5302E597BC9A4CB654", hash_generated_method = "E21C76FA96F5BFD5336B757BD1BC5673")
    public void setDivider(Drawable divider) {
        {
            mDividerHeight = divider.getIntrinsicHeight();
        } //End block
        {
            mDividerHeight = 0;
        } //End block
        mDivider = divider;
        mDividerIsOpaque = divider == null || divider.getOpacity() == PixelFormat.OPAQUE;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //if (divider != null) {
            //mDividerHeight = divider.getIntrinsicHeight();
        //} else {
            //mDividerHeight = 0;
        //}
        //mDivider = divider;
        //mDividerIsOpaque = divider == null || divider.getOpacity() == PixelFormat.OPAQUE;
        //requestLayout();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.534 -0400", hash_original_method = "229663AAAB1BC0B50485AD0B5CC199F3", hash_generated_method = "90B9227572269FB6D2558E888D2F0B61")
    public int getDividerHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129907725 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129907725;
        // ---------- Original Method ----------
        //return mDividerHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.534 -0400", hash_original_method = "D3D08555D2F9E637F163A09E680CBA08", hash_generated_method = "F0AE68FA46B0ADDC93935BBE3F16E6B1")
    public void setDividerHeight(int height) {
        mDividerHeight = height;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mDividerHeight = height;
        //requestLayout();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.536 -0400", hash_original_method = "97442AC2339A7874BFA41866E47D7310", hash_generated_method = "82E939478FD38F6F96EFD8736EAC5DA4")
    public void setHeaderDividersEnabled(boolean headerDividersEnabled) {
        mHeaderDividersEnabled = headerDividersEnabled;
        invalidate();
        // ---------- Original Method ----------
        //mHeaderDividersEnabled = headerDividersEnabled;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.536 -0400", hash_original_method = "74ACE2244DDEB7C7F913E5E0F875653E", hash_generated_method = "647057629C534B13B55E9BA37BB1D9B8")
    public void setFooterDividersEnabled(boolean footerDividersEnabled) {
        mFooterDividersEnabled = footerDividersEnabled;
        invalidate();
        // ---------- Original Method ----------
        //mFooterDividersEnabled = footerDividersEnabled;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.536 -0400", hash_original_method = "953E541E16240F0325506F6534EE33B4", hash_generated_method = "64DCB2C7DA1E915EE3294305D1356011")
    public void setOverscrollHeader(Drawable header) {
        mOverScrollHeader = header;
        {
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //mOverScrollHeader = header;
        //if (mScrollY < 0) {
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.537 -0400", hash_original_method = "95FFBAE371294243FE9AD2355C3622A4", hash_generated_method = "AC1064BFEDF7DF4E95D6198AEE13E2A1")
    public Drawable getOverscrollHeader() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1801307982 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1801307982 = mOverScrollHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1801307982.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1801307982;
        // ---------- Original Method ----------
        //return mOverScrollHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.537 -0400", hash_original_method = "E2CA032ECDDC156C9CE8335D95975846", hash_generated_method = "1A6AF223BC637FBFCF894AE4D3360007")
    public void setOverscrollFooter(Drawable footer) {
        mOverScrollFooter = footer;
        invalidate();
        // ---------- Original Method ----------
        //mOverScrollFooter = footer;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.537 -0400", hash_original_method = "C43851852530BF4773181DC349AD3704", hash_generated_method = "82B12C77987CC0301813DBDB962EB41C")
    public Drawable getOverscrollFooter() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1513642352 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1513642352 = mOverScrollFooter;
        varB4EAC82CA7396A68D541C85D26508E83_1513642352.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1513642352;
        // ---------- Original Method ----------
        //return mOverScrollFooter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.544 -0400", hash_original_method = "A140BD3D04197A195532B0C2217798E2", hash_generated_method = "681E5A8D82441717336452315CE20560")
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        ListAdapter adapter;
        adapter = mAdapter;
        int closetChildIndex;
        closetChildIndex = -1;
        int closestChildTop;
        closestChildTop = 0;
        {
            previouslyFocusedRect.offset(mScrollX, mScrollY);
            {
                boolean var834FA86141DD35F45E58D6AC3B8AC266_2080471149 = (adapter.getCount() < getChildCount() + mFirstPosition);
                {
                    mLayoutMode = LAYOUT_NORMAL;
                    layoutChildren();
                } //End block
            } //End collapsed parenthetic
            Rect otherRect;
            otherRect = mTempRect;
            int minDistance;
            minDistance = Integer.MAX_VALUE;
            int childCount;
            childCount = getChildCount();
            int firstPosition;
            firstPosition = mFirstPosition;
            {
                int i;
                i = 0;
                {
                    {
                        boolean varF0493CBC36FEE8A37314533655677361_53646500 = (!adapter.isEnabled(firstPosition + i));
                    } //End collapsed parenthetic
                    View other;
                    other = getChildAt(i);
                    other.getDrawingRect(otherRect);
                    offsetDescendantRectToMyCoords(other, otherRect);
                    int distance;
                    distance = getDistance(previouslyFocusedRect, otherRect, direction);
                    {
                        minDistance = distance;
                        closetChildIndex = i;
                        closestChildTop = other.getTop();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            setSelectionFromTop(closetChildIndex + mFirstPosition, closestChildTop);
        } //End block
        {
            requestLayout();
        } //End block
        addTaint(gainFocus);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.546 -0400", hash_original_method = "33666A5E6A3C0638CD57027CC0FE1CC1", hash_generated_method = "6D61022DD5DE44775F7DF83DD1D92A65")
    @Override
    protected void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFinishInflate();
        int count;
        count = getChildCount();
        {
            {
                int i;
                i = 0;
                {
                    addHeaderView(getChildAt(i));
                } //End block
            } //End collapsed parenthetic
            removeAllViews();
        } //End block
        // ---------- Original Method ----------
        //super.onFinishInflate();
        //int count = getChildCount();
        //if (count > 0) {
            //for (int i = 0; i < count; ++i) {
                //addHeaderView(getChildAt(i));
            //}
            //removeAllViews();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.547 -0400", hash_original_method = "55B474F0526D1B513F7B1BB91F273A6A", hash_generated_method = "48D0A099AF27950691D86180E59B0959")
    @Override
    protected View findViewTraversal(int id) {
        View varB4EAC82CA7396A68D541C85D26508E83_1226766608 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_264583012 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_1164161667 = null; //Variable for return #3
        View v;
        v = super.findViewTraversal(id);
        {
            v = findViewInHeadersOrFooters(mHeaderViewInfos, id);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1226766608 = v;
            } //End block
            v = findViewInHeadersOrFooters(mFooterViewInfos, id);
            {
                varB4EAC82CA7396A68D541C85D26508E83_264583012 = v;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1164161667 = v;
        addTaint(id);
        View varA7E53CE21691AB073D9660D615818899_166298198; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_166298198 = varB4EAC82CA7396A68D541C85D26508E83_1226766608;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_166298198 = varB4EAC82CA7396A68D541C85D26508E83_264583012;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_166298198 = varB4EAC82CA7396A68D541C85D26508E83_1164161667;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_166298198.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_166298198;
        // ---------- Original Method ----------
        //View v;
        //v = super.findViewTraversal(id);
        //if (v == null) {
            //v = findViewInHeadersOrFooters(mHeaderViewInfos, id);
            //if (v != null) {
                //return v;
            //}
            //v = findViewInHeadersOrFooters(mFooterViewInfos, id);
            //if (v != null) {
                //return v;
            //}
        //}
        //return v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.551 -0400", hash_original_method = "CE5790FF46C8EC9157EF966632ADD833", hash_generated_method = "30DC9D0865687939EF50E5BC1E30542F")
     View findViewInHeadersOrFooters(ArrayList<FixedViewInfo> where, int id) {
        View varB4EAC82CA7396A68D541C85D26508E83_781344007 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1618493016 = null; //Variable for return #2
        {
            int len;
            len = where.size();
            View v;
            {
                int i;
                i = 0;
                {
                    v = where.get(i).view;
                    {
                        boolean var3F751ABEC959446BA6608C20A1A0BA91_658191502 = (!v.isRootNamespace());
                        {
                            v = v.findViewById(id);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_781344007 = v;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1618493016 = null;
        addTaint(where.getTaint());
        addTaint(id);
        View varA7E53CE21691AB073D9660D615818899_703924341; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_703924341 = varB4EAC82CA7396A68D541C85D26508E83_781344007;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_703924341 = varB4EAC82CA7396A68D541C85D26508E83_1618493016;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_703924341.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_703924341;
        // ---------- Original Method ----------
        //if (where != null) {
            //int len = where.size();
            //View v;
            //for (int i = 0; i < len; i++) {
                //v = where.get(i).view;
                //if (!v.isRootNamespace()) {
                    //v = v.findViewById(id);
                    //if (v != null) {
                        //return v;
                    //}
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.555 -0400", hash_original_method = "3E2A521CFE9847E9FDB3AEC6F88A76DD", hash_generated_method = "4A20179066D0FBBCDCB5923186DB95F1")
    @Override
    protected View findViewWithTagTraversal(Object tag) {
        View varB4EAC82CA7396A68D541C85D26508E83_1366467199 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_354415360 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_121727724 = null; //Variable for return #3
        View v;
        v = super.findViewWithTagTraversal(tag);
        {
            v = findViewWithTagInHeadersOrFooters(mHeaderViewInfos, tag);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1366467199 = v;
            } //End block
            v = findViewWithTagInHeadersOrFooters(mFooterViewInfos, tag);
            {
                varB4EAC82CA7396A68D541C85D26508E83_354415360 = v;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_121727724 = v;
        addTaint(tag.getTaint());
        View varA7E53CE21691AB073D9660D615818899_881859880; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_881859880 = varB4EAC82CA7396A68D541C85D26508E83_1366467199;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_881859880 = varB4EAC82CA7396A68D541C85D26508E83_354415360;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_881859880 = varB4EAC82CA7396A68D541C85D26508E83_121727724;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_881859880.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_881859880;
        // ---------- Original Method ----------
        //View v;
        //v = super.findViewWithTagTraversal(tag);
        //if (v == null) {
            //v = findViewWithTagInHeadersOrFooters(mHeaderViewInfos, tag);
            //if (v != null) {
                //return v;
            //}
            //v = findViewWithTagInHeadersOrFooters(mFooterViewInfos, tag);
            //if (v != null) {
                //return v;
            //}
        //}
        //return v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.562 -0400", hash_original_method = "FB5700AACE78A96EA34C4186153EA1D8", hash_generated_method = "6C746E138D69425703113EA4D9610631")
     View findViewWithTagInHeadersOrFooters(ArrayList<FixedViewInfo> where, Object tag) {
        View varB4EAC82CA7396A68D541C85D26508E83_993758521 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1162639720 = null; //Variable for return #2
        {
            int len;
            len = where.size();
            View v;
            {
                int i;
                i = 0;
                {
                    v = where.get(i).view;
                    {
                        boolean var3F751ABEC959446BA6608C20A1A0BA91_2132323283 = (!v.isRootNamespace());
                        {
                            v = v.findViewWithTag(tag);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_993758521 = v;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1162639720 = null;
        addTaint(where.getTaint());
        addTaint(tag.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1360463592; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1360463592 = varB4EAC82CA7396A68D541C85D26508E83_993758521;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1360463592 = varB4EAC82CA7396A68D541C85D26508E83_1162639720;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1360463592.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1360463592;
        // ---------- Original Method ----------
        //if (where != null) {
            //int len = where.size();
            //View v;
            //for (int i = 0; i < len; i++) {
                //v = where.get(i).view;
                //if (!v.isRootNamespace()) {
                    //v = v.findViewWithTag(tag);
                    //if (v != null) {
                        //return v;
                    //}
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.571 -0400", hash_original_method = "C4FCF9CDE386456E06D0A36ACE84F436", hash_generated_method = "0642B748150264676B546AB947026A5D")
    @Override
    protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip) {
        View varB4EAC82CA7396A68D541C85D26508E83_1318510161 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1961272939 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_11270109 = null; //Variable for return #3
        View v;
        v = super.findViewByPredicateTraversal(predicate, childToSkip);
        {
            v = findViewByPredicateInHeadersOrFooters(mHeaderViewInfos, predicate, childToSkip);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1318510161 = v;
            } //End block
            v = findViewByPredicateInHeadersOrFooters(mFooterViewInfos, predicate, childToSkip);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1961272939 = v;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_11270109 = v;
        addTaint(predicate.getTaint());
        addTaint(childToSkip.getTaint());
        View varA7E53CE21691AB073D9660D615818899_895469989; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_895469989 = varB4EAC82CA7396A68D541C85D26508E83_1318510161;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_895469989 = varB4EAC82CA7396A68D541C85D26508E83_1961272939;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_895469989 = varB4EAC82CA7396A68D541C85D26508E83_11270109;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_895469989.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_895469989;
        // ---------- Original Method ----------
        //View v;
        //v = super.findViewByPredicateTraversal(predicate, childToSkip);
        //if (v == null) {
            //v = findViewByPredicateInHeadersOrFooters(mHeaderViewInfos, predicate, childToSkip);
            //if (v != null) {
                //return v;
            //}
            //v = findViewByPredicateInHeadersOrFooters(mFooterViewInfos, predicate, childToSkip);
            //if (v != null) {
                //return v;
            //}
        //}
        //return v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.572 -0400", hash_original_method = "D1F1A1145A67766E94BF084DFEF4A6A9", hash_generated_method = "7A97228AA1EEF26823B14ACE53F1601B")
     View findViewByPredicateInHeadersOrFooters(ArrayList<FixedViewInfo> where,
            Predicate<View> predicate, View childToSkip) {
        View varB4EAC82CA7396A68D541C85D26508E83_1337899444 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_334395128 = null; //Variable for return #2
        {
            int len;
            len = where.size();
            View v;
            {
                int i;
                i = 0;
                {
                    v = where.get(i).view;
                    {
                        boolean varE559F145C9972D4F93FC59CF981B09D2_1617741390 = (v != childToSkip && !v.isRootNamespace());
                        {
                            v = v.findViewByPredicate(predicate);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1337899444 = v;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_334395128 = null;
        addTaint(where.getTaint());
        addTaint(predicate.getTaint());
        addTaint(childToSkip.getTaint());
        View varA7E53CE21691AB073D9660D615818899_914041541; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_914041541 = varB4EAC82CA7396A68D541C85D26508E83_1337899444;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_914041541 = varB4EAC82CA7396A68D541C85D26508E83_334395128;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_914041541.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_914041541;
        // ---------- Original Method ----------
        //if (where != null) {
            //int len = where.size();
            //View v;
            //for (int i = 0; i < len; i++) {
                //v = where.get(i).view;
                //if (v != childToSkip && !v.isRootNamespace()) {
                    //v = v.findViewByPredicate(predicate);
                    //if (v != null) {
                        //return v;
                    //}
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.581 -0400", hash_original_method = "7376DB3A956D54D1A994EA4B9B95B8AF", hash_generated_method = "B40BCD5CC78C7778F1BB88A8C061596D")
    @Deprecated
    public long[] getCheckItemIds() {
        {
            boolean var92A5B2B773F784D23AACADEC549061AE_1628189913 = (mAdapter != null && mAdapter.hasStableIds());
            {
                long[] varEA0F92157511B761BCA87A37A949584F_493642328 = (getCheckedItemIds());
            } //End block
        } //End collapsed parenthetic
        {
            SparseBooleanArray states;
            states = mCheckStates;
            int count;
            count = states.size();
            long[] ids;
            ids = new long[count];
            ListAdapter adapter;
            adapter = mAdapter;
            int checkedCount;
            checkedCount = 0;
            {
                int i;
                i = 0;
                {
                    {
                        boolean var06DB0322BE5DDF244F3C57344F69D711_1243819249 = (states.valueAt(i));
                        {
                            ids[checkedCount++] = adapter.getItemId(states.keyAt(i));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                long[] result;
                result = new long[checkedCount];
                System.arraycopy(ids, 0, result, 0, checkedCount);
            } //End block
        } //End block
        long[] var6C93D8E1F6D98EBFFE119BBCCB99BC4A_1604074841 = (new long[0]);
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1074679353 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1074679353;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public class FixedViewInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.581 -0400", hash_original_field = "1BDA80F2BE4D3658E0BAA43FBE7AE8C1", hash_generated_field = "F4E21118122450D7DE8C5B004AEA690D")

        public View view;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.581 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "FC3B89DB1B4BAEFF0C8DFDD10399B12A")

        public Object data;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.581 -0400", hash_original_field = "ADD60A1158B4B8A77E92EC580F3040CE", hash_generated_field = "51BB0A155CFD263D81C29BB4668379B4")

        public boolean isSelectable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.581 -0400", hash_original_method = "67C6F15893AD18CF0EAE06202C68D9E8", hash_generated_method = "67C6F15893AD18CF0EAE06202C68D9E8")
        public FixedViewInfo ()
        {
            //Synthesized constructor
        }


    }


    
    private class FocusSelector implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.581 -0400", hash_original_field = "2A02BDE12D932CD9DCA97106D487F8F5", hash_generated_field = "D614AE7D1AAE0276EA05A974DCBF0210")

        private int mPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.581 -0400", hash_original_field = "1C2A16FEE0F2317B52A14EA25A87B83E", hash_generated_field = "9F00838B177601A91ACC5BEF0B2B59E5")

        private int mPositionTop;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.581 -0400", hash_original_method = "34C9C9AFBDE05AECFED95C79C10A76BA", hash_generated_method = "34C9C9AFBDE05AECFED95C79C10A76BA")
        public FocusSelector ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.582 -0400", hash_original_method = "5C0213FE7A42F47411000D870177F1B7", hash_generated_method = "C18F159BE82B3AF99EBB97B7A78B8D00")
        public FocusSelector setup(int position, int top) {
            FocusSelector varB4EAC82CA7396A68D541C85D26508E83_1390090877 = null; //Variable for return #1
            mPosition = position;
            mPositionTop = top;
            varB4EAC82CA7396A68D541C85D26508E83_1390090877 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1390090877.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1390090877;
            // ---------- Original Method ----------
            //mPosition = position;
            //mPositionTop = top;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.582 -0400", hash_original_method = "1C9CFC3992CD17CE1A3B73D68C8C6081", hash_generated_method = "59BBD0E54B7536BB80D52C5363FBE175")
        public void run() {
            setSelectionFromTop(mPosition, mPositionTop);
            // ---------- Original Method ----------
            //setSelectionFromTop(mPosition, mPositionTop);
        }

        
    }


    
    static private class ArrowScrollFocusResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.582 -0400", hash_original_field = "390A3127D73EBF1C2FE439B9B7D711F9", hash_generated_field = "51E21A7A6543942D242B4E74F7651C70")

        private int mSelectedPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.582 -0400", hash_original_field = "9FA5FDE7E622E7E96DFD95286E06FD92", hash_generated_field = "A1DDFEC53FF7E81352EF3B979C9E665D")

        private int mAmountToScroll;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.582 -0400", hash_original_method = "F12FA46FC2E286992F273AF0197118D3", hash_generated_method = "F12FA46FC2E286992F273AF0197118D3")
        public ArrowScrollFocusResult ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.586 -0400", hash_original_method = "E4C7C1A71AB7D603722F7CE31ED09575", hash_generated_method = "C8559F673D941812E13F3F631D0BAA1F")
         void populate(int selectedPosition, int amountToScroll) {
            mSelectedPosition = selectedPosition;
            mAmountToScroll = amountToScroll;
            // ---------- Original Method ----------
            //mSelectedPosition = selectedPosition;
            //mAmountToScroll = amountToScroll;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.586 -0400", hash_original_method = "57FF42983620727F309A47A5C295AFEC", hash_generated_method = "B5D8FF9F3B6AEA2CE66907B230336C21")
        public int getSelectedPosition() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119393076 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119393076;
            // ---------- Original Method ----------
            //return mSelectedPosition;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.586 -0400", hash_original_method = "547539826ED165E8A574C9320A564E9F", hash_generated_method = "3764BD57C504A26D2E08A6FFF9160831")
        public int getAmountToScroll() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559727270 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559727270;
            // ---------- Original Method ----------
            //return mAmountToScroll;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.586 -0400", hash_original_field = "E1DEA0BEB2F8CF12C7B6244C21F007E5", hash_generated_field = "C3B344AB4D67603D7DE83E3840EE5CC5")

    static int NO_POSITION = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.586 -0400", hash_original_field = "3559B51D9CE8D7099F97AA2C846ABFFB", hash_generated_field = "115054D5D3AA5A09F628FF22BEE34AB8")

    private static float MAX_SCROLL_FACTOR = 0.33f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.586 -0400", hash_original_field = "DA0484B66F107DB9B9104112BC0055B2", hash_generated_field = "27069A35235411347BBE52A339B44792")

    private static int MIN_SCROLL_PREVIEW_PIXELS = 2;
}

