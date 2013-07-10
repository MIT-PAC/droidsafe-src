package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "A0E111006ED777C10D75AA1677A2639C", hash_generated_field = "4BC24FD3C886BCFFDF832386DEC27D09")

    private ArrayList<FixedViewInfo> mHeaderViewInfos = Lists.newArrayList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "CC679F55490278048131235E90055B39", hash_generated_field = "FD730016C2B4D9973A08935CB5CEEF24")

    private ArrayList<FixedViewInfo> mFooterViewInfos = Lists.newArrayList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "F2EB92D46BFACFA75ABCA33DC6179915", hash_generated_field = "3837E71D24376BABDBC6EE7CD182AABB")

    Drawable mDivider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "FDC96C666CAD9FBF2EF59762861622A0", hash_generated_field = "E9BA9D611B13DC4B2EC5075D3CBC28DA")

    int mDividerHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "2E33162EDD274C7EDD1E1156F95BB8C5", hash_generated_field = "61CEC74004B40DBE67743F5C54E8DAE8")

    Drawable mOverScrollHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "CCC4EEA4F20C4786C3E2B61E4655BBA7", hash_generated_field = "FAAE7751E5086898A7D9334FDB1CBF58")

    Drawable mOverScrollFooter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "8BEFBF97EB4D2DF9EC8AA6449CB3CA5E", hash_generated_field = "D67B6F8B88187DB827FEE4CD95C0CD84")

    private boolean mIsCacheColorOpaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "339C469036C2CC68131B6FFE99D261C1", hash_generated_field = "F64CA3AD07E4A441F83FB08509D5EA54")

    private boolean mDividerIsOpaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "4D65FD0E015FCBFA86076C532AFC8520", hash_generated_field = "E4D279F003B799932AE6A47EC9C65A6F")

    private boolean mHeaderDividersEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "7D3333BFE992E9D671CB18E1CC4F46F2", hash_generated_field = "D61311FF24E9C122770C1CC46CD91809")

    private boolean mFooterDividersEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "CD24990D52A8F3E7E5EB9907AF3F4BCB", hash_generated_field = "1E6DAAB899E2A1039D680325576FF2F4")

    private boolean mAreAllItemsSelectable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "C81EE07A80353C16F692D53C68A2708C", hash_generated_field = "B872CC30C5370C029EE2A26D5DBEB2D2")

    private boolean mItemsCanFocus = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "E00CE94A319056CF4CFCE4FD6B48FD75", hash_generated_field = "4B2413695EEECE37901862E70E0ADF71")

    private Paint mDividerPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "622C7E912E416442D6067E781BEF934A", hash_generated_field = "4260816BC1A1EC85165CC5FE8DD47CE4")

    private final ArrowScrollFocusResult mArrowScrollFocusResult = new ArrowScrollFocusResult();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.778 -0400", hash_original_field = "D85788A92B1851B4DB4DD47891274715", hash_generated_field = "21847DEAFE51D735E62E529ABB2AD8CB")

    private FocusSelector mFocusSelector;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.780 -0400", hash_original_method = "90B4B4BF6E484BC26800C5A789F4708D", hash_generated_method = "2C921861B94DD394D15F8C9171AE49D3")
    public  ListView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.781 -0400", hash_original_method = "5C8040E9D31754EC73AE53985C54C1B3", hash_generated_method = "02B7F18DF6EB6DE61176AB28E53B2B54")
    public  ListView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.listViewStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.781 -0400", hash_original_method = "1588C0DF1CDF9192487B09246AC39E9C", hash_generated_method = "5B9B16ED7DF461196FDEF6D1AC1FA2CF")
    public  ListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ListView, defStyle, 0);
        CharSequence[] entries = a.getTextArray(
                com.android.internal.R.styleable.ListView_entries);
        {
            setAdapter(new ArrayAdapter<CharSequence>(context,
                    com.android.internal.R.layout.simple_list_item_1, entries));
        } 
        final Drawable d = a.getDrawable(com.android.internal.R.styleable.ListView_divider);
        {
            setDivider(d);
        } 
        final Drawable osHeader = a.getDrawable(
                com.android.internal.R.styleable.ListView_overScrollHeader);
        {
            setOverscrollHeader(osHeader);
        } 
        final Drawable osFooter = a.getDrawable(
                com.android.internal.R.styleable.ListView_overScrollFooter);
        {
            setOverscrollFooter(osFooter);
        } 
        final int dividerHeight = a.getDimensionPixelSize(
                com.android.internal.R.styleable.ListView_dividerHeight, 0);
        {
            setDividerHeight(dividerHeight);
        } 
        mHeaderDividersEnabled = a.getBoolean(R.styleable.ListView_headerDividersEnabled, true);
        mFooterDividersEnabled = a.getBoolean(R.styleable.ListView_footerDividersEnabled, true);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.782 -0400", hash_original_method = "13CC3D3BB67006B8B223FEAA5CEB8AD3", hash_generated_method = "3CF3F49D60F4B45E722D19D6D2FB466A")
    public int getMaxScrollAmount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189051536 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189051536;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.782 -0400", hash_original_method = "C98C1C3289511C3CD05158CF07015375", hash_generated_method = "BD518CF24EABEE5E621BEDE2A640C757")
    private void adjustViewsUpOrDown() {
        final int childCount = getChildCount();
        int delta;
        {
            View child;
            {
                child = getChildAt(0);
                delta = child.getTop() - mListPadding.top;
                {
                    delta -= mDividerHeight;
                } 
                {
                    delta = 0;
                } 
            } 
            {
                child = getChildAt(childCount - 1);
                delta = child.getBottom() - (getHeight() - mListPadding.bottom);
                {
                    delta += mDividerHeight;
                } 
                {
                    delta = 0;
                } 
            } 
            {
                offsetChildrenTopAndBottom(-delta);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.783 -0400", hash_original_method = "52D3689EBA08A028E74C350405FC2CA4", hash_generated_method = "B5B2EA6912950833008F428FE86A96D0")
    public void addHeaderView(View v, Object data, boolean isSelectable) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Cannot add header view to list -- setAdapter has already been called.");
        } 
        FixedViewInfo info = new FixedViewInfo();
        info.view = v;
        info.data = data;
        info.isSelectable = isSelectable;
        mHeaderViewInfos.add(info);
        {
            mDataSetObserver.onChanged();
        } 
        addTaint(v.getTaint());
        addTaint(data.getTaint());
        addTaint(isSelectable);
        
        
            
                    
        
        
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.784 -0400", hash_original_method = "9CDB9BC1941825D09F579B09BA5203C8", hash_generated_method = "B3C619852BB06367E2DDB2F57BC57E55")
    public void addHeaderView(View v) {
        addHeaderView(v, null, true);
        addTaint(v.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.784 -0400", hash_original_method = "9A198FE2F7DAA22CDFAB063EB95C8DFA", hash_generated_method = "FE319AA0B68F71CDF7DD168A4656E9C5")
    @Override
    public int getHeaderViewsCount() {
        int var51EB21BA6322BC21883B38109F793DB7_1116159344 = (mHeaderViewInfos.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834644582 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834644582;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.784 -0400", hash_original_method = "8EF6528E21853FD53F2FB8406F9F06D5", hash_generated_method = "21D488646AED16434256AEFDE0816D66")
    public boolean removeHeaderView(View v) {
        {
            boolean varFC339A57DD06D9F6F47BBD3A88B06E10_1002793137 = (mHeaderViewInfos.size() > 0);
            {
                boolean result = false;
                {
                    boolean var9BFD45A2F2990893F8C6EA8C90DB82AA_976332789 = (mAdapter != null && ((HeaderViewListAdapter) mAdapter).removeHeader(v));
                    {
                        {
                            mDataSetObserver.onChanged();
                        } 
                        result = true;
                    } 
                } 
                removeFixedViewInfo(v, mHeaderViewInfos);
            } 
        } 
        addTaint(v.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2122301625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2122301625;
        
        
            
            
                
                    
                
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.785 -0400", hash_original_method = "56A07A9A1AC012F692F90759B155683C", hash_generated_method = "EF03D6BF85D11A1CBFE5866002B5292E")
    private void removeFixedViewInfo(View v, ArrayList<FixedViewInfo> where) {
        int len = where.size();
        {
            int i = 0;
            {
                FixedViewInfo info = where.get(i);
                {
                    where.remove(i);
                } 
            } 
        } 
        addTaint(v.getTaint());
        addTaint(where.getTaint());
        
        
        
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.785 -0400", hash_original_method = "854663FFCE0B2EEEA12F571F4E080752", hash_generated_method = "0F75479093397FF9BC9E601B198F489C")
    public void addFooterView(View v, Object data, boolean isSelectable) {
        FixedViewInfo info = new FixedViewInfo();
        info.view = v;
        info.data = data;
        info.isSelectable = isSelectable;
        mFooterViewInfos.add(info);
        {
            mDataSetObserver.onChanged();
        } 
        addTaint(v.getTaint());
        addTaint(data.getTaint());
        addTaint(isSelectable);
        
        
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.785 -0400", hash_original_method = "06A7CBCF71002E57CE516EE24D5E8CDC", hash_generated_method = "57122EE7C6CF8ED4F3458E8ADE0651DA")
    public void addFooterView(View v) {
        addFooterView(v, null, true);
        addTaint(v.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.786 -0400", hash_original_method = "83BE551B6778E6D258871D9949AEF538", hash_generated_method = "E788333A30E117BD5FDC7E0DE2F3C97D")
    @Override
    public int getFooterViewsCount() {
        int var05D2A206262A11BE7E645CDC53B4074D_2057367279 = (mFooterViewInfos.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1192271175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1192271175;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.786 -0400", hash_original_method = "D2E29F254410117CE819574854BB79EC", hash_generated_method = "AC8B8205DEEBEB879DD935A52ECA78A7")
    public boolean removeFooterView(View v) {
        {
            boolean var16785181560AF1EBB84626B752BB868A_1347955236 = (mFooterViewInfos.size() > 0);
            {
                boolean result = false;
                {
                    boolean var9C4812C55FB91AE0FCF1729C742654B1_1200841514 = (mAdapter != null && ((HeaderViewListAdapter) mAdapter).removeFooter(v));
                    {
                        {
                            mDataSetObserver.onChanged();
                        } 
                        result = true;
                    } 
                } 
                removeFixedViewInfo(v, mFooterViewInfos);
            } 
        } 
        addTaint(v.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_658222083 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_658222083;
        
        
            
            
                
                    
                
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.787 -0400", hash_original_method = "0E1A05724C497F45D7FB6AC34C501814", hash_generated_method = "0F64E60BC75D57C9F92E589C0A1C27F8")
    @Override
    public ListAdapter getAdapter() {
        ListAdapter varB4EAC82CA7396A68D541C85D26508E83_460061048 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_460061048 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_460061048.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_460061048;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.787 -0400", hash_original_method = "8AB2C6958FD7CEC3A8A71FE59763D6A4", hash_generated_method = "D18E7401555F2345B6B780E77B86E39C")
    @android.view.RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        super.setRemoteViewsAdapter(intent);
        addTaint(intent.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.788 -0400", hash_original_method = "41402E7D77C488BF4C279E76F34BC4E2", hash_generated_method = "F0BF0DD7B771339635B4263FD6083A1F")
    @Override
    public void setAdapter(ListAdapter adapter) {
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        } 
        resetList();
        mRecycler.clear();
        {
            boolean var424DAEFA84C4CC446223C4E25F5F060B_2102552364 = (mHeaderViewInfos.size() > 0|| mFooterViewInfos.size() > 0);
            {
                mAdapter = new HeaderViewListAdapter(mHeaderViewInfos, mFooterViewInfos, adapter);
            } 
            {
                mAdapter = adapter;
            } 
        } 
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
            } 
            {
                position = lookForSelectablePosition(0, true);
            } 
            setSelectedPositionInt(position);
            setNextSelectedPositionInt(position);
            {
                checkSelectionChanged();
            } 
        } 
        {
            mAreAllItemsSelectable = true;
            checkFocus();
            checkSelectionChanged();
        } 
        requestLayout();
        addTaint(adapter.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.788 -0400", hash_original_method = "2C61A8961B533B2EFAE2B5516136BD48", hash_generated_method = "2F9780A9A993D3382CEE1B6821096FDF")
    @Override
     void resetList() {
        clearRecycledState(mHeaderViewInfos);
        clearRecycledState(mFooterViewInfos);
        super.resetList();
        mLayoutMode = LAYOUT_NORMAL;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.789 -0400", hash_original_method = "917FCC60A4286C5138F872CFDA18A6AE", hash_generated_method = "217F8D19047724045459B1AE3307433E")
    private void clearRecycledState(ArrayList<FixedViewInfo> infos) {
        {
            final int count = infos.size();
            {
                int i = 0;
                {
                    final View child = infos.get(i).view;
                    final LayoutParams p = (LayoutParams) child.getLayoutParams();
                    {
                        p.recycledHeaderFooter = false;
                    } 
                } 
            } 
        } 
        addTaint(infos.getTaint());
        
        
            
            
                
                
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.789 -0400", hash_original_method = "AE08170EA161B6A1BF0E53E679181532", hash_generated_method = "B4F2B394735C8463F5FBEF250C6E3433")
    private boolean showingTopFadingEdge() {
        final int listTop = mScrollY + mListPadding.top;
        boolean varCCBED360491DE804AB67732329ABF3EB_841880018 = ((mFirstPosition > 0) || (getChildAt(0).getTop() > listTop));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2062313576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2062313576;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.789 -0400", hash_original_method = "471206817827115E6FDE8330BC3BFE06", hash_generated_method = "117B5ED7534E3703444D9A43D30BE380")
    private boolean showingBottomFadingEdge() {
        final int childCount = getChildCount();
        final int bottomOfBottomChild = getChildAt(childCount - 1).getBottom();
        final int lastVisiblePosition = mFirstPosition + childCount - 1;
        final int listBottom = mScrollY + getHeight() - mListPadding.bottom;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1429589384 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1429589384;
        
        
        
        
        
        
                         
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.790 -0400", hash_original_method = "0248A9BC20DE00C469CC3A8962885EF5", hash_generated_method = "AE19B9C45B7AA0BF8BA7F233D482CC10")
    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rect, boolean immediate) {
        int rectTopWithinChild = rect.top;
        rect.offset(child.getLeft(), child.getTop());
        rect.offset(-child.getScrollX(), -child.getScrollY());
        final int height = getHeight();
        int listUnfadedTop = getScrollY();
        int listUnfadedBottom = listUnfadedTop + height;
        final int fadingEdge = getVerticalFadingEdgeLength();
        {
            boolean var60D2B66A5E3C386C88687929883234E5_451634025 = (showingTopFadingEdge());
            {
                {
                    listUnfadedTop += fadingEdge;
                } 
            } 
        } 
        int childCount = getChildCount();
        int bottomOfBottomChild = getChildAt(childCount - 1).getBottom();
        {
            boolean varEC085D03DEF6DF005C7F3192FEB447ED_1146939011 = (showingBottomFadingEdge());
            {
                {
                    listUnfadedBottom -= fadingEdge;
                } 
            } 
        } 
        int scrollYDelta = 0;
        {
            {
                boolean var1852437954D6FC93B41EE304F855C339_1609752229 = (rect.height() > height);
                {
                    scrollYDelta += (rect.top - listUnfadedTop);
                } 
                {
                    scrollYDelta += (rect.bottom - listUnfadedBottom);
                } 
            } 
            int distanceToBottom = bottomOfBottomChild - listUnfadedBottom;
            scrollYDelta = Math.min(scrollYDelta, distanceToBottom);
        } 
        {
            {
                boolean var1852437954D6FC93B41EE304F855C339_980930045 = (rect.height() > height);
                {
                    scrollYDelta -= (listUnfadedBottom - rect.bottom);
                } 
                {
                    scrollYDelta -= (listUnfadedTop - rect.top);
                } 
            } 
            int top = getChildAt(0).getTop();
            int deltaToTop = top - listUnfadedTop;
            scrollYDelta = Math.max(scrollYDelta, deltaToTop);
        } 
        final boolean scroll = scrollYDelta != 0;
        {
            scrollListItemsBy(-scrollYDelta);
            positionSelector(INVALID_POSITION, child);
            mSelectedTop = child.getTop();
            invalidate();
        } 
        addTaint(child.getTaint());
        addTaint(rect.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_853982770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_853982770;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.791 -0400", hash_original_method = "E78CA340B6692592484560299AF7A587", hash_generated_method = "DFFF739FA1BB821558ED2FC0E0B49032")
    @Override
     void fillGap(boolean down) {
        final int count = getChildCount();
        {
            int paddingTop = 0;
            {
                paddingTop = getListPaddingTop();
            } 
            int startOffset;
            startOffset = getChildAt(count - 1).getBottom() + mDividerHeight;
            startOffset = paddingTop;
            fillDown(mFirstPosition + count, startOffset);
            correctTooHigh(getChildCount());
        } 
        {
            int paddingBottom = 0;
            {
                paddingBottom = getListPaddingBottom();
            } 
            int startOffset;
            startOffset = getChildAt(0).getTop() - mDividerHeight;
            startOffset = getHeight() - paddingBottom;
            fillUp(mFirstPosition - 1, startOffset);
            correctTooLow(getChildCount());
        } 
        addTaint(down);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.791 -0400", hash_original_method = "A51DD6537C0400974E1B605AE841C465", hash_generated_method = "DDED8A1876E5F89FF8C73386BF146DAE")
    private View fillDown(int pos, int nextTop) {
        View varB4EAC82CA7396A68D541C85D26508E83_384401145 = null; 
        View selectedView = null;
        int end = (mBottom - mTop);
        {
            end -= mListPadding.bottom;
        } 
        {
            boolean selected = pos == mSelectedPosition;
            View child = makeAndAddView(pos, nextTop, true, mListPadding.left, selected);
            nextTop = child.getBottom() + mDividerHeight;
            {
                selectedView = child;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_384401145 = selectedView;
        addTaint(pos);
        addTaint(nextTop);
        varB4EAC82CA7396A68D541C85D26508E83_384401145.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_384401145;
        
        
        
        
            
        
        
            
            
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.792 -0400", hash_original_method = "05C528C2066045A21E9535AE6FF4CD3D", hash_generated_method = "DD65F53D8D07238E73440DBC8C6F5E61")
    private View fillUp(int pos, int nextBottom) {
        View varB4EAC82CA7396A68D541C85D26508E83_1824039069 = null; 
        View selectedView = null;
        int end = 0;
        {
            end = mListPadding.top;
        } 
        {
            boolean selected = pos == mSelectedPosition;
            View child = makeAndAddView(pos, nextBottom, false, mListPadding.left, selected);
            nextBottom = child.getTop() - mDividerHeight;
            {
                selectedView = child;
            } 
        } 
        mFirstPosition = pos + 1;
        varB4EAC82CA7396A68D541C85D26508E83_1824039069 = selectedView;
        addTaint(pos);
        addTaint(nextBottom);
        varB4EAC82CA7396A68D541C85D26508E83_1824039069.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1824039069;
        
        
        
        
            
        
        
            
            
            
            
                
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.793 -0400", hash_original_method = "E858B13EC4F52DD7B2125F2E9BA15919", hash_generated_method = "EBB8B5F1AFD1FA042680D7D97262C2B0")
    private View fillFromTop(int nextTop) {
        View varB4EAC82CA7396A68D541C85D26508E83_472884933 = null; 
        mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
        mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
        {
            mFirstPosition = 0;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_472884933 = fillDown(mFirstPosition, nextTop);
        addTaint(nextTop);
        varB4EAC82CA7396A68D541C85D26508E83_472884933.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_472884933;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.795 -0400", hash_original_method = "BB6F12E082A75859BCEF500D953CB8EE", hash_generated_method = "F93D90D1FCDAEDE004AEAD14BE77E2B8")
    private View fillFromMiddle(int childrenTop, int childrenBottom) {
        View varB4EAC82CA7396A68D541C85D26508E83_1700440136 = null; 
        int height = childrenBottom - childrenTop;
        int position = reconcileSelectedPosition();
        View sel = makeAndAddView(position, childrenTop, true,
                mListPadding.left, true);
        mFirstPosition = position;
        int selHeight = sel.getMeasuredHeight();
        {
            sel.offsetTopAndBottom((height - selHeight) / 2);
        } 
        fillAboveAndBelow(sel, position);
        {
            correctTooHigh(getChildCount());
        } 
        {
            correctTooLow(getChildCount());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1700440136 = sel;
        addTaint(childrenTop);
        addTaint(childrenBottom);
        varB4EAC82CA7396A68D541C85D26508E83_1700440136.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1700440136;
        
        
        
        
                
        
        
        
            
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.796 -0400", hash_original_method = "E7EAC0AC74052E989A5F3C8A8979A51D", hash_generated_method = "C39D4BDCD4D9CAA59400188C834AD762")
    private void fillAboveAndBelow(View sel, int position) {
        final int dividerHeight = mDividerHeight;
        {
            fillUp(position - 1, sel.getTop() - dividerHeight);
            adjustViewsUpOrDown();
            fillDown(position + 1, sel.getBottom() + dividerHeight);
        } 
        {
            fillDown(position + 1, sel.getBottom() + dividerHeight);
            adjustViewsUpOrDown();
            fillUp(position - 1, sel.getTop() - dividerHeight);
        } 
        addTaint(sel.getTaint());
        addTaint(position);
        
        
        
            
            
            
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.797 -0400", hash_original_method = "439BAC8174DEF92DB2EFE731B080B752", hash_generated_method = "32F805F0D17A234D1C9CDC2488C6C09E")
    private View fillFromSelection(int selectedTop, int childrenTop, int childrenBottom) {
        View varB4EAC82CA7396A68D541C85D26508E83_1472228123 = null; 
        int fadingEdgeLength = getVerticalFadingEdgeLength();
        final int selectedPosition = mSelectedPosition;
        View sel;
        final int topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength,
                selectedPosition);
        final int bottomSelectionPixel = getBottomSelectionPixel(childrenBottom, fadingEdgeLength,
                selectedPosition);
        sel = makeAndAddView(selectedPosition, selectedTop, true, mListPadding.left, true);
        {
            boolean varBFC41726DC719E4AF23B91CEB6FCBE3E_1077859937 = (sel.getBottom() > bottomSelectionPixel);
            {
                final int spaceAbove = sel.getTop() - topSelectionPixel;
                final int spaceBelow = sel.getBottom() - bottomSelectionPixel;
                final int offset = Math.min(spaceAbove, spaceBelow);
                sel.offsetTopAndBottom(-offset);
            } 
            {
                boolean var14C65EDD6D5526A3271EC007E995AA33_10765741 = (sel.getTop() < topSelectionPixel);
                {
                    final int spaceAbove = topSelectionPixel - sel.getTop();
                    final int spaceBelow = bottomSelectionPixel - sel.getBottom();
                    final int offset = Math.min(spaceAbove, spaceBelow);
                    sel.offsetTopAndBottom(offset);
                } 
            } 
        } 
        fillAboveAndBelow(sel, selectedPosition);
        {
            correctTooHigh(getChildCount());
        } 
        {
            correctTooLow(getChildCount());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1472228123 = sel;
        addTaint(selectedTop);
        addTaint(childrenTop);
        addTaint(childrenBottom);
        varB4EAC82CA7396A68D541C85D26508E83_1472228123.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1472228123;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.797 -0400", hash_original_method = "DDE472821830C07DE1368C905BA02EE1", hash_generated_method = "2D28A5BF7469A209BF5B1C701EC93A80")
    private int getBottomSelectionPixel(int childrenBottom, int fadingEdgeLength,
            int selectedPosition) {
        int bottomSelectionPixel = childrenBottom;
        {
            bottomSelectionPixel -= fadingEdgeLength;
        } 
        addTaint(childrenBottom);
        addTaint(fadingEdgeLength);
        addTaint(selectedPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327223146 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327223146;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.798 -0400", hash_original_method = "173BB2BFF18272B67A930A02164FEB0F", hash_generated_method = "508AFA0953F52D5A847393D726374314")
    private int getTopSelectionPixel(int childrenTop, int fadingEdgeLength, int selectedPosition) {
        int topSelectionPixel = childrenTop;
        {
            topSelectionPixel += fadingEdgeLength;
        } 
        addTaint(childrenTop);
        addTaint(fadingEdgeLength);
        addTaint(selectedPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89766784 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89766784;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.798 -0400", hash_original_method = "19B54E9E42F50C19B80602093C26BC32", hash_generated_method = "7A5836635E40602F9283C444E4C38BE2")
    @android.view.RemotableViewMethod
    public void smoothScrollToPosition(int position) {
        super.smoothScrollToPosition(position);
        addTaint(position);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.798 -0400", hash_original_method = "9A2E566018459C8A4F9FE2F49DBB98B8", hash_generated_method = "DF8A45AA7313754A97BDE7860400CCDD")
    @android.view.RemotableViewMethod
    public void smoothScrollByOffset(int offset) {
        super.smoothScrollByOffset(offset);
        addTaint(offset);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.800 -0400", hash_original_method = "A6BE2578E6D412634113B39CFD73986F", hash_generated_method = "97802297375C36224FE7C5214AE1DA56")
    private View moveSelection(View oldSel, View newSel, int delta, int childrenTop,
            int childrenBottom) {
        View varB4EAC82CA7396A68D541C85D26508E83_486136645 = null; 
        int fadingEdgeLength = getVerticalFadingEdgeLength();
        final int selectedPosition = mSelectedPosition;
        View sel;
        final int topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength,
                selectedPosition);
        final int bottomSelectionPixel = getBottomSelectionPixel(childrenTop, fadingEdgeLength,
                selectedPosition);
        {
            oldSel = makeAndAddView(selectedPosition - 1, oldSel.getTop(), true,
                    mListPadding.left, false);
            final int dividerHeight = mDividerHeight;
            sel = makeAndAddView(selectedPosition, oldSel.getBottom() + dividerHeight, true,
                    mListPadding.left, true);
            {
                boolean var809044946283DBF63F29397A5670A6D0_1064131080 = (sel.getBottom() > bottomSelectionPixel);
                {
                    int spaceAbove = sel.getTop() - topSelectionPixel;
                    int spaceBelow = sel.getBottom() - bottomSelectionPixel;
                    int halfVerticalSpace = (childrenBottom - childrenTop) / 2;
                    int offset = Math.min(spaceAbove, spaceBelow);
                    offset = Math.min(offset, halfVerticalSpace);
                    oldSel.offsetTopAndBottom(-offset);
                    sel.offsetTopAndBottom(-offset);
                } 
            } 
            {
                fillUp(mSelectedPosition - 2, sel.getTop() - dividerHeight);
                adjustViewsUpOrDown();
                fillDown(mSelectedPosition + 1, sel.getBottom() + dividerHeight);
            } 
            {
                fillDown(mSelectedPosition + 1, sel.getBottom() + dividerHeight);
                adjustViewsUpOrDown();
                fillUp(mSelectedPosition - 2, sel.getTop() - dividerHeight);
            } 
        } 
        {
            {
                sel = makeAndAddView(selectedPosition, newSel.getTop(), true, mListPadding.left,
                        true);
            } 
            {
                sel = makeAndAddView(selectedPosition, oldSel.getTop(), false, mListPadding.left,
                        true);
            } 
            {
                boolean var14C65EDD6D5526A3271EC007E995AA33_1440670262 = (sel.getTop() < topSelectionPixel);
                {
                    int spaceAbove = topSelectionPixel - sel.getTop();
                    int spaceBelow = bottomSelectionPixel - sel.getBottom();
                    int halfVerticalSpace = (childrenBottom - childrenTop) / 2;
                    int offset = Math.min(spaceAbove, spaceBelow);
                    offset = Math.min(offset, halfVerticalSpace);
                    sel.offsetTopAndBottom(offset);
                } 
            } 
            fillAboveAndBelow(sel, selectedPosition);
        } 
        {
            int oldTop = oldSel.getTop();
            sel = makeAndAddView(selectedPosition, oldTop, true, mListPadding.left, true);
            {
                int newBottom = sel.getBottom();
                {
                    sel.offsetTopAndBottom(childrenTop - sel.getTop());
                } 
            } 
            fillAboveAndBelow(sel, selectedPosition);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_486136645 = sel;
        addTaint(oldSel.getTaint());
        addTaint(newSel.getTaint());
        addTaint(delta);
        addTaint(childrenTop);
        addTaint(childrenBottom);
        varB4EAC82CA7396A68D541C85D26508E83_486136645.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_486136645;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.801 -0400", hash_original_method = "CB33E140CB7C8CB590395A9B1EF6CC8D", hash_generated_method = "50B1984D9BE0E4B5658A1A77A5873336")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_138245172 = (getChildCount() > 0);
            {
                View focusedChild = getFocusedChild();
                {
                    final int childPosition = mFirstPosition + indexOfChild(focusedChild);
                    final int childBottom = focusedChild.getBottom();
                    final int offset = Math.max(0, childBottom - (h - mPaddingTop));
                    final int top = focusedChild.getTop() - offset;
                    {
                        mFocusSelector = new FocusSelector();
                    } 
                    post(mFocusSelector.setup(childPosition, top));
                } 
            } 
        } 
        super.onSizeChanged(w, h, oldw, oldh);
        addTaint(w);
        addTaint(h);
        addTaint(oldw);
        addTaint(oldh);
        
        
            
            
                
                
                
                
                
                    
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.801 -0400", hash_original_method = "593EBCA8FD80357C209889704061F804", hash_generated_method = "A0A3715E15A50C526B1E392D8D19A35C")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int childWidth = 0;
        int childHeight = 0;
        int childState = 0;
        mItemCount = mAdapter == null ? 0 : mAdapter.getCount();
        {
            final View child = obtainView(0, mIsScrap);
            measureScrapChild(child, 0, widthMeasureSpec);
            childWidth = child.getMeasuredWidth();
            childHeight = child.getMeasuredHeight();
            childState = combineMeasuredStates(childState, child.getMeasuredState());
            {
                boolean varEB7649CB6D51B846BFB1D35E91D4E330_1945781644 = (recycleOnMeasure() && mRecycler.shouldRecycleViewType(
                    ((LayoutParams) child.getLayoutParams()).viewType));
                {
                    mRecycler.addScrapView(child, -1);
                } 
            } 
        } 
        {
            widthSize = mListPadding.left + mListPadding.right + childWidth +
                    getVerticalScrollbarWidth();
        } 
        {
            widthSize |= (childState&MEASURED_STATE_MASK);
        } 
        {
            heightSize = mListPadding.top + mListPadding.bottom + childHeight +
                    getVerticalFadingEdgeLength() * 2;
        } 
        {
            heightSize = measureHeightOfChildren(widthMeasureSpec, 0, NO_POSITION, heightSize, -1);
        } 
        setMeasuredDimension(widthSize , heightSize);
        mWidthMeasureSpec = widthMeasureSpec;
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.802 -0400", hash_original_method = "F21C4EE74005F045F306FF7685001DDA", hash_generated_method = "3CDC383F9C83154A97ACC5C6DB6664FF")
    private void measureScrapChild(View child, int position, int widthMeasureSpec) {
        LayoutParams p = (LayoutParams) child.getLayoutParams();
        {
            p = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0);
            child.setLayoutParams(p);
        } 
        p.viewType = mAdapter.getItemViewType(position);
        p.forceAdd = true;
        int childWidthSpec = ViewGroup.getChildMeasureSpec(widthMeasureSpec,
                mListPadding.left + mListPadding.right, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
        } 
        {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        } 
        child.measure(childWidthSpec, childHeightSpec);
        addTaint(child.getTaint());
        addTaint(position);
        addTaint(widthMeasureSpec);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.802 -0400", hash_original_method = "8F0B08D4426D8F4F23EF014B56CDCFE6", hash_generated_method = "DF35629C3225553DD3A0DE2A865E349A")
    @ViewDebug.ExportedProperty(category = "list")
    protected boolean recycleOnMeasure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1509951536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1509951536;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.803 -0400", hash_original_method = "4E8DF0CF85AB0B6CF8E1C94B60E67D20", hash_generated_method = "C8F082ADE45F6A77CCC1324E06E451BD")
    final int measureHeightOfChildren(int widthMeasureSpec, int startPosition, int endPosition,
            final int maxHeight, int disallowPartialChildPosition) {
        final ListAdapter adapter = mAdapter;
        int returnedHeight = mListPadding.top + mListPadding.bottom;
        int dividerHeight;
        dividerHeight = mDividerHeight;
        dividerHeight = 0;
        int prevHeightWithoutPartialChild = 0;
        int i;
        View child;
        endPosition = (endPosition == NO_POSITION) ? adapter.getCount() - 1 : endPosition;
        final AbsListView.RecycleBin recycleBin = mRecycler;
        final boolean recyle = recycleOnMeasure();
        final boolean[] isScrap = mIsScrap;
        {
            i = startPosition;
            {
                child = obtainView(i, isScrap);
                measureScrapChild(child, i, widthMeasureSpec);
                {
                    returnedHeight += dividerHeight;
                } 
                {
                    boolean var533FFAA3904216431C0F5E425FC7EAF1_970462153 = (recyle && recycleBin.shouldRecycleViewType(
                    ((LayoutParams) child.getLayoutParams()).viewType));
                    {
                        recycleBin.addScrapView(child, -1);
                    } 
                } 
                returnedHeight += child.getMeasuredHeight();
                {
                    prevHeightWithoutPartialChild = returnedHeight;
                } 
            } 
        } 
        addTaint(widthMeasureSpec);
        addTaint(startPosition);
        addTaint(endPosition);
        addTaint(maxHeight);
        addTaint(disallowPartialChildPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628825531 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628825531;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.804 -0400", hash_original_method = "79128C90442A789B94FF9502F8C045C1", hash_generated_method = "0A43A7C89C71314FF571776E5768B745")
    @Override
     int findMotionRow(int y) {
        int childCount = getChildCount();
        {
            {
                {
                    int i = 0;
                    {
                        View v = getChildAt(i);
                        {
                            boolean var737FD9EF3BFA62490E57511E301591D9_487676256 = (y <= v.getBottom());
                        } 
                    } 
                } 
            } 
            {
                {
                    int i = childCount - 1;
                    {
                        View v = getChildAt(i);
                        {
                            boolean varE7C2FBE8C17E6A36CCD2B0AC678BC146_49651382 = (y >= v.getTop());
                        } 
                    } 
                } 
            } 
        } 
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302627379 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302627379;
        
        
        
            
                
                    
                    
                        
                    
                
            
                
                    
                    
                        
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.807 -0400", hash_original_method = "C0E9548D6FEBBB39DCAB5DD502EC06AD", hash_generated_method = "926D60332DCB530AE6F5C948CDC30E7E")
    private View fillSpecific(int position, int top) {
        View varB4EAC82CA7396A68D541C85D26508E83_2007089579 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1286854766 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1414449592 = null; 
        boolean tempIsSelected = position == mSelectedPosition;
        View temp = makeAndAddView(position, top, true, mListPadding.left, tempIsSelected);
        mFirstPosition = position;
        View above;
        View below;
        final int dividerHeight = mDividerHeight;
        {
            above = fillUp(position - 1, temp.getTop() - dividerHeight);
            adjustViewsUpOrDown();
            below = fillDown(position + 1, temp.getBottom() + dividerHeight);
            int childCount = getChildCount();
            {
                correctTooHigh(childCount);
            } 
        } 
        {
            below = fillDown(position + 1, temp.getBottom() + dividerHeight);
            adjustViewsUpOrDown();
            above = fillUp(position - 1, temp.getTop() - dividerHeight);
            int childCount = getChildCount();
            {
                correctTooLow(childCount);
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2007089579 = temp;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1286854766 = above;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1414449592 = below;
        } 
        addTaint(position);
        addTaint(top);
        View varA7E53CE21691AB073D9660D615818899_1525217960; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1525217960 = varB4EAC82CA7396A68D541C85D26508E83_2007089579;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1525217960 = varB4EAC82CA7396A68D541C85D26508E83_1286854766;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1525217960 = varB4EAC82CA7396A68D541C85D26508E83_1414449592;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1525217960.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1525217960;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.807 -0400", hash_original_method = "C65533A90B04CD548C8B98EAAB2119A6", hash_generated_method = "0F87A21E383C73D1A2EBFFB329EDD8B3")
    private void correctTooHigh(int childCount) {
        int lastPosition = mFirstPosition + childCount - 1;
        {
            final View lastChild = getChildAt(childCount - 1);
            final int lastBottom = lastChild.getBottom();
            final int end = (mBottom - mTop) - mListPadding.bottom;
            int bottomOffset = end - lastBottom;
            View firstChild = getChildAt(0);
            final int firstTop = firstChild.getTop();
            {
                {
                    bottomOffset = Math.min(bottomOffset, mListPadding.top - firstTop);
                } 
                offsetChildrenTopAndBottom(bottomOffset);
                {
                    fillUp(mFirstPosition - 1, firstChild.getTop() - mDividerHeight);
                    adjustViewsUpOrDown();
                } 
            } 
        } 
        addTaint(childCount);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.808 -0400", hash_original_method = "D798F76D04F235C59E38C4C924A6B5C2", hash_generated_method = "1EE7D87ECF91DC1FD3961250E19ECF1C")
    private void correctTooLow(int childCount) {
        {
            final View firstChild = getChildAt(0);
            final int firstTop = firstChild.getTop();
            final int start = mListPadding.top;
            final int end = (mBottom - mTop) - mListPadding.bottom;
            int topOffset = firstTop - start;
            View lastChild = getChildAt(childCount - 1);
            final int lastBottom = lastChild.getBottom();
            int lastPosition = mFirstPosition + childCount - 1;
            {
                {
                    {
                        topOffset = Math.min(topOffset, lastBottom - end);
                    } 
                    offsetChildrenTopAndBottom(-topOffset);
                    {
                        fillDown(lastPosition + 1, lastChild.getBottom() + mDividerHeight);
                        adjustViewsUpOrDown();
                    } 
                } 
                {
                    adjustViewsUpOrDown();
                } 
            } 
        } 
        addTaint(childCount);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.810 -0400", hash_original_method = "9877500E639FE4AE4AB75D2F74BF2E4E", hash_generated_method = "3E8D58C15FD4198374FAD61AD01A1B47")
    @Override
    protected void layoutChildren() {
        final boolean blockLayoutRequests = mBlockLayoutRequests;
        {
            mBlockLayoutRequests = true;
        } 
        try 
        {
            super.layoutChildren();
            invalidate();
            {
                resetList();
                invokeOnItemScrollListener();
            } 
            int childrenTop = mListPadding.top;
            int childrenBottom = mBottom - mTop - mListPadding.bottom;
            int childCount = getChildCount();
            int index = 0;
            int delta = 0;
            View sel;
            View oldSel = null;
            View oldFirst = null;
            View newSel = null;
            View focusLayoutRestoreView = null;
            
            index = mNextSelectedPosition - mFirstPosition;
            
            
            {
                newSel = getChildAt(index);
            } 
            
            
            index = mSelectedPosition - mFirstPosition;
            
            
            {
                oldSel = getChildAt(index);
            } 
            
            
            oldFirst = getChildAt(0);
            
            
            {
                delta = mNextSelectedPosition - mSelectedPosition;
            } 
            
            
            newSel = getChildAt(index + delta);
            
            boolean dataChanged = mDataChanged;
            {
                handleDataChanged();
            } 
            {
                resetList();
                invokeOnItemScrollListener();
            } 
            {
                boolean varA298A0CB79AEDD2E132E7DADF2F1B74D_1759227267 = (mItemCount != mAdapter.getCount());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The content of the adapter has changed but "
                        + "ListView did not receive a notification. Make sure the content of "
                        + "your adapter is not modified from a background thread, but only "
                        + "from the UI thread. [in ListView(" + getId() + ", " + getClass() 
                        + ") with Adapter(" + mAdapter.getClass() + ")]");
                } 
            } 
            setSelectedPositionInt(mNextSelectedPosition);
            final int firstPosition = mFirstPosition;
            final RecycleBin recycleBin = mRecycler;
            View focusLayoutRestoreDirectChild = null;
            {
                {
                    int i = 0;
                    {
                        recycleBin.addScrapView(getChildAt(i), firstPosition+i);
                        {
                            ViewDebug.trace(getChildAt(i),
                                ViewDebug.RecyclerTraceType.MOVE_TO_SCRAP_HEAP, index, i);
                        } 
                    } 
                } 
            } 
            {
                recycleBin.fillActiveViews(childCount, firstPosition);
            } 
            final View focusedChild = getFocusedChild();
            {
                {
                    boolean varE616BE978FFFDD1A37C1939042B395B1_776259908 = (!dataChanged || isDirectChildHeaderOrFooter(focusedChild));
                    {
                        focusLayoutRestoreDirectChild = focusedChild;
                        focusLayoutRestoreView = findFocus();
                        {
                            focusLayoutRestoreView.onStartTemporaryDetach();
                        } 
                    } 
                } 
                requestFocus();
            } 
            detachAllViewsFromParent();
            
            {
                sel = fillFromSelection(newSel.getTop(), childrenTop, childrenBottom);
            } 
            {
                sel = fillFromMiddle(childrenTop, childrenBottom);
            } 
            
            
            sel = fillSpecific(mSyncPosition, mSpecificTop);
            
            
            sel = fillUp(mItemCount - 1, childrenBottom);
            
            
            adjustViewsUpOrDown();
            
            
            mFirstPosition = 0;
            
            
            sel = fillFromTop(childrenTop);
            
            
            adjustViewsUpOrDown();
            
            
            sel = fillSpecific(reconcileSelectedPosition(), mSpecificTop);
            
            
            sel = moveSelection(oldSel, newSel, delta, childrenTop, childrenBottom);
            
            
            {
                {
                    final int position = lookForSelectablePosition(0, true);
                    setSelectedPositionInt(position);
                    sel = fillFromTop(childrenTop);
                } 
                {
                    final int position = lookForSelectablePosition(mItemCount - 1, false);
                    setSelectedPositionInt(position);
                    sel = fillUp(mItemCount - 1, childrenBottom);
                } 
            } 
            {
                {
                    sel = fillSpecific(mSelectedPosition,
                                oldSel == null ? childrenTop : oldSel.getTop());
                } 
                {
                    sel = fillSpecific(mFirstPosition,
                                oldFirst == null ? childrenTop : oldFirst.getTop());
                } 
                {
                    sel = fillSpecific(0, childrenTop);
                } 
            } 
            
            recycleBin.scrapActiveViews();
            {
                {
                    boolean var9085EE91A28170DA4ACA96D9BF477D88_1374682633 = (mItemsCanFocus && hasFocus() && !sel.hasFocus());
                    {
                        final boolean focusWasTaken = (sel == focusLayoutRestoreDirectChild &&
                            focusLayoutRestoreView.requestFocus()) || sel.requestFocus();
                        {
                            final View focused = getFocusedChild();
                            {
                                focused.clearFocus();
                            } 
                            positionSelector(INVALID_POSITION, sel);
                        } 
                        {
                            sel.setSelected(false);
                            mSelectorRect.setEmpty();
                        } 
                    } 
                    {
                        positionSelector(INVALID_POSITION, sel);
                    } 
                } 
                mSelectedTop = sel.getTop();
            } 
            {
                {
                    View child = getChildAt(mMotionPosition - mFirstPosition);
                    positionSelector(mMotionPosition, child);
                } 
                {
                    mSelectedTop = 0;
                    mSelectorRect.setEmpty();
                } 
                {
                    boolean var3353F8886B6D2D3385EBD44764EEC6B6_1307004075 = (hasFocus() && focusLayoutRestoreView != null);
                    {
                        focusLayoutRestoreView.requestFocus();
                    } 
                } 
            } 
            {
                boolean var371628C1F86A56F688D98D9EF6B87E07_470539318 = (focusLayoutRestoreView != null
                    && focusLayoutRestoreView.getWindowToken() != null);
                {
                    focusLayoutRestoreView.onFinishTemporaryDetach();
                } 
            } 
            mLayoutMode = LAYOUT_NORMAL;
            mDataChanged = false;
            mNeedSync = false;
            setNextSelectedPositionInt(mSelectedPosition);
            updateScrollIndicators();
            {
                checkSelectionChanged();
            } 
            invokeOnItemScrollListener();
        } 
        finally 
        {
            {
                mBlockLayoutRequests = false;
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.811 -0400", hash_original_method = "1975AA11D0AB4A92B498BEF09326AA69", hash_generated_method = "373D8E0B79AFC43BB871FEBD3A808F4F")
    private boolean isDirectChildHeaderOrFooter(View child) {
        final ArrayList<FixedViewInfo> headers = mHeaderViewInfos;
        final int numHeaders = headers.size();
        {
            int i = 0;
            {
                {
                    boolean var2E97F2DD1ECC5E322C5090F5951EC49E_324010044 = (child == headers.get(i).view);
                } 
            } 
        } 
        final ArrayList<FixedViewInfo> footers = mFooterViewInfos;
        final int numFooters = footers.size();
        {
            int i = 0;
            {
                {
                    boolean varA845DE916470E49791E6F275395553FA_1451213655 = (child == footers.get(i).view);
                } 
            } 
        } 
        addTaint(child.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_848183733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_848183733;
        
        
        
        
            
                
            
        
        
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.812 -0400", hash_original_method = "EAF848DCFCD435D3CED323F008D83518", hash_generated_method = "69CDE047F77A391A40A19CE95BDFB0F9")
    private View makeAndAddView(int position, int y, boolean flow, int childrenLeft,
            boolean selected) {
        View varB4EAC82CA7396A68D541C85D26508E83_1725787318 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1614121102 = null; 
        View child;
        {
            child = mRecycler.getActiveView(position);
            {
                {
                    ViewDebug.trace(child, ViewDebug.RecyclerTraceType.RECYCLE_FROM_ACTIVE_HEAP,
                            position, getChildCount());
                } 
                setupChild(child, position, y, flow, childrenLeft, selected, true);
                varB4EAC82CA7396A68D541C85D26508E83_1725787318 = child;
            } 
        } 
        child = obtainView(position, mIsScrap);
        setupChild(child, position, y, flow, childrenLeft, selected, mIsScrap[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1614121102 = child;
        addTaint(position);
        addTaint(y);
        addTaint(flow);
        addTaint(childrenLeft);
        addTaint(selected);
        View varA7E53CE21691AB073D9660D615818899_1827180248; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1827180248 = varB4EAC82CA7396A68D541C85D26508E83_1725787318;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1827180248 = varB4EAC82CA7396A68D541C85D26508E83_1614121102;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1827180248.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1827180248;
        
        
        
            
            
                
                    
                            
                
                
                
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.813 -0400", hash_original_method = "06B6C56B5992091F7319E58A5C4AE35A", hash_generated_method = "4398E52D966C0BEB6E5738D38E7865A6")
    private void setupChild(View child, int position, int y, boolean flowDown, int childrenLeft,
            boolean selected, boolean recycled) {
        final boolean isSelected = selected && shouldShowSelector();
        final boolean updateChildSelected = isSelected != child.isSelected();
        final int mode = mTouchMode;
        final boolean isPressed = mode > TOUCH_MODE_DOWN && mode < TOUCH_MODE_SCROLL &&
                mMotionPosition == position;
        final boolean updateChildPressed = isPressed != child.isPressed();
        final boolean needToMeasure = !recycled || updateChildSelected || child.isLayoutRequested();
        AbsListView.LayoutParams p = (AbsListView.LayoutParams) child.getLayoutParams();
        {
            p = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0);
        } 
        p.viewType = mAdapter.getItemViewType(position);
        {
            attachViewToParent(child, flowDown ? -1 : 0, p);
        } 
        {
            p.forceAdd = false;
            {
                p.recycledHeaderFooter = true;
            } 
            addViewInLayout(child, flowDown ? -1 : 0, p, true);
        } 
        {
            child.setSelected(isSelected);
        } 
        {
            child.setPressed(isPressed);
        } 
        {
            {
                ((Checkable) child).setChecked(mCheckStates.get(position));
            } 
            {
                boolean var6B8ECFCCB35D70022AE775423EF95EFF_53560774 = (getContext().getApplicationInfo().targetSdkVersion
                    >= android.os.Build.VERSION_CODES.HONEYCOMB);
                {
                    child.setActivated(mCheckStates.get(position));
                } 
            } 
        } 
        {
            int childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                    mListPadding.left + mListPadding.right, p.width);
            int lpHeight = p.height;
            int childHeightSpec;
            {
                childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
            } 
            {
                childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            } 
            child.measure(childWidthSpec, childHeightSpec);
        } 
        {
            cleanupLayoutState(child);
        } 
        final int w = child.getMeasuredWidth();
        final int h = child.getMeasuredHeight();
        int childTop;
        childTop = y;
        childTop = y - h;
        {
            final int childRight = childrenLeft + w;
            final int childBottom = childTop + h;
            child.layout(childrenLeft, childTop, childRight, childBottom);
        } 
        {
            child.offsetLeftAndRight(childrenLeft - child.getLeft());
            child.offsetTopAndBottom(childTop - child.getTop());
        } 
        {
            boolean varFE983D8157D9C3BB7AF96BB07D8A50F7_1573654817 = (mCachingStarted && !child.isDrawingCacheEnabled());
            {
                child.setDrawingCacheEnabled(true);
            } 
        } 
        {
            boolean varCA9C9DB394586E5C1281E2A995FFCD63_1284928706 = (recycled && (((AbsListView.LayoutParams)child.getLayoutParams()).scrappedFromPosition)
                != position);
            {
                child.jumpDrawablesToCurrentState();
            } 
        } 
        addTaint(child.getTaint());
        addTaint(position);
        addTaint(y);
        addTaint(flowDown);
        addTaint(childrenLeft);
        addTaint(selected);
        addTaint(recycled);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.814 -0400", hash_original_method = "F40AC428F4D570BD34339564A5B5BB04", hash_generated_method = "401FB53D02CAB159C4B69E1F0CF7489E")
    @Override
    protected boolean canAnimate() {
        boolean varDA480D2F8FF037BACA5DB54A8FBF9642_316913993 = (super.canAnimate() && mItemCount > 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_361374062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_361374062;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.814 -0400", hash_original_method = "94D2F20BDBA41376781BE37B36941A8A", hash_generated_method = "9CCC25E7FAB162595C36123BA6715042")
    @Override
    public void setSelection(int position) {
        setSelectionFromTop(position, 0);
        addTaint(position);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.815 -0400", hash_original_method = "04FF3361CA0379851E7CD86AE0D8A950", hash_generated_method = "7D13410CC4EA2EC1A47B8D20A5EE98A5")
    public void setSelectionFromTop(int position, int y) {
        {
            boolean var3DA6B9D2A4DFFBF2A8164819B7AFE9DF_1727625140 = (!isInTouchMode());
            {
                position = lookForSelectablePosition(position, true);
                {
                    setNextSelectedPositionInt(position);
                } 
            } 
            {
                mResurrectToPosition = position;
            } 
        } 
        {
            mLayoutMode = LAYOUT_SPECIFIC;
            mSpecificTop = mListPadding.top + y;
            {
                mSyncPosition = position;
                mSyncRowId = mAdapter.getItemId(position);
            } 
            requestLayout();
        } 
        addTaint(position);
        addTaint(y);
        
        
            
        
        
            
            
                
            
        
            
        
        
            
            
            
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.816 -0400", hash_original_method = "813C2C2B521DC76439D7A0687ADC333C", hash_generated_method = "8D20C2049B53AE0A3BBEA467A0214321")
    @Override
     void setSelectionInt(int position) {
        setNextSelectedPositionInt(position);
        boolean awakeScrollbars = false;
        final int selectedPosition = mSelectedPosition;
        {
            {
                awakeScrollbars = true;
            } 
            {
                awakeScrollbars = true;
            } 
        } 
        layoutChildren();
        {
            awakenScrollBars();
        } 
        addTaint(position);
        
        
        
        
        
            
                
            
                
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.817 -0400", hash_original_method = "F611253C286EB5F8129DFD60BE22D44F", hash_generated_method = "0723EC6B5F9E98C46C893AC362BC88D1")
    @Override
     int lookForSelectablePosition(int position, boolean lookDown) {
        final ListAdapter adapter = mAdapter;
        {
            boolean var35A1F64E67CC6E0C06A8BA9582F2435F_263633560 = (adapter == null || isInTouchMode());
        } 
        final int count = adapter.getCount();
        {
            {
                position = Math.max(0, position);
                {
                    boolean varF9E3A5AB0092C9F908FE41D43CDE1F43_2094288828 = (position < count && !adapter.isEnabled(position));
                } 
            } 
            {
                position = Math.min(position, count - 1);
                {
                    boolean var86CF05D4F4C580D8A474D386CDE84CF9_1439053223 = (position >= 0 && !adapter.isEnabled(position));
                } 
            } 
        } 
        addTaint(position);
        addTaint(lookDown);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288552530 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288552530;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.817 -0400", hash_original_method = "BA94B118F7B33B042A8A5EE913A2CAC9", hash_generated_method = "6AEDFBADAC1F4E06CD91AA06D2CFB18D")
    public void setSelectionAfterHeaderView() {
        final int count = mHeaderViewInfos.size();
        {
            mNextSelectedPosition = 0;
        } 
        {
            setSelection(count);
        } 
        {
            mNextSelectedPosition = count;
            mLayoutMode = LAYOUT_SET_SELECTION;
        } 
        
        
        
            
            
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.818 -0400", hash_original_method = "C6695FE09C5666FBD7C0ECDD7FFCA6CE", hash_generated_method = "B61D7181F05EF497EBAD2E85BDD6B9A4")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        boolean handled = super.dispatchKeyEvent(event);
        {
            View focused = getFocusedChild();
            {
                boolean varD6F50D5E6BAAF6A4042506AB741CE740_291826686 = (focused != null && event.getAction() == KeyEvent.ACTION_DOWN);
                {
                    handled = onKeyDown(event.getKeyCode(), event);
                } 
            } 
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1234614146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1234614146;
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.818 -0400", hash_original_method = "82498D99AFEB0700B1F959E9E9927B59", hash_generated_method = "B584E50E29D740F5402ED1120E5B5BF3")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        boolean var7B6BE27715D36B6032CB7DA2718D4FF1_646847029 = (commonKey(keyCode, 1, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1089232868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1089232868;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.819 -0400", hash_original_method = "C105EC1B6481173F2A66D1C47882507B", hash_generated_method = "5695F975275B9E26CF4307AA1C1B7410")
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        
        boolean varACEC8A58158104BC4BBB2FE543212B03_575888846 = (commonKey(keyCode, repeatCount, event));
        addTaint(keyCode);
        addTaint(repeatCount);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1986515072 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1986515072;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.819 -0400", hash_original_method = "FFB4A1626C41573790F9B17FF23F8A09", hash_generated_method = "A17D0B9B0692F243CF3211D17DF453FE")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        
        boolean var7B6BE27715D36B6032CB7DA2718D4FF1_80306532 = (commonKey(keyCode, 1, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1135787016 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1135787016;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.820 -0400", hash_original_method = "1DD47D400FE7B21B7ADCD2D234FB64A7", hash_generated_method = "261150CAA1C427403698D3FCC2E8BF28")
    private boolean commonKey(int keyCode, int count, KeyEvent event) {
        {
            layoutChildren();
        } 
        boolean handled = false;
        int action = event.getAction();
        {
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1780168487 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded();
                    {
                        {
                            {
                                boolean varA5B62ED4C691B4536F3BE2ACFD937D16_2097769862 = (arrowScroll(FOCUS_UP));
                                {
                                    handled = true;
                                } 
                            } 
                        } 
                    } 
                } 
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_498883063 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                    } 
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1261415891 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded();
                    {
                        {
                            {
                                boolean varAA5CCD5687C9D983EE1C69076A1EA7F2_1245663580 = (arrowScroll(FOCUS_DOWN));
                                {
                                    handled = true;
                                } 
                            } 
                        } 
                    } 
                } 
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_1271699282 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                    } 
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1480625556 = (event.hasNoModifiers());
                {
                    handled = handleHorizontalFocusWithinListItem(View.FOCUS_LEFT);
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1255548554 = (event.hasNoModifiers());
                {
                    handled = handleHorizontalFocusWithinListItem(View.FOCUS_RIGHT);
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1206542277 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded();
                    {
                        boolean var0998D8B15B32EB34977168615D32B617_400558849 = (!handled
                            && event.getRepeatCount() == 0 && getChildCount() > 0);
                        {
                            keyPressed();
                            handled = true;
                        } 
                    } 
                } 
            } 
            
            
            {
                boolean varC5267D5BFE7A3E261BDE80A07A8ECCFA_1378256699 = (mPopup == null || !mPopup.isShowing());
                {
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_276530045 = (event.hasNoModifiers());
                        {
                            handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_DOWN);
                        } 
                        {
                            boolean varC6F58190DE4A31A0CF9704EF99A62451_108405809 = (event.hasModifiers(KeyEvent.META_SHIFT_ON));
                            {
                                handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_UP);
                            } 
                        } 
                    } 
                    handled = true;
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1580564556 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_UP);
                } 
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_2042828481 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                    } 
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1605782483 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_DOWN);
                } 
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_227875906 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                    } 
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_498373774 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                } 
            } 
            
            
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1519084962 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                } 
            } 
            
            
            {
                {
                    boolean varC77C0C11194BD87DFEE086A32DCE5C18_1418702150 = (event.hasNoModifiers());
                    {
                        handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_DOWN);
                    } 
                    {
                        boolean var7B1040B2192949CFC257B6EE7F25C319_722295157 = (event.hasModifiers(KeyEvent.META_SHIFT_ON));
                        {
                            handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_UP);
                        } 
                    } 
                } 
            } 
            
        } 
        {
            boolean varF6449376E291BB335EF050093EE80110_873554764 = (sendToTextFilter(keyCode, count, event));
        } 
        
        boolean var8C6E6C19273FC56B5C56CC7DEF63ED7B_1643316079 = (super.onKeyDown(keyCode, event));
        
        
        boolean varEDD771EBF66425AD21882AB08CD0EE48_1714616134 = (super.onKeyUp(keyCode, event));
        
        
        boolean varC0357E39557DD275ECAF43C782C78502_1161898404 = (super.onKeyMultiple(keyCode, count, event));
        
        addTaint(keyCode);
        addTaint(count);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_146004417 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_146004417;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.844 -0400", hash_original_method = "CFFD02C88D512DC860E9CC0FE1096C45", hash_generated_method = "28BB665534D7E8D191A8402DE38C56F4")
     boolean pageScroll(int direction) {
        int nextPage = -1;
        boolean down = false;
        {
            nextPage = Math.max(0, mSelectedPosition - getChildCount() - 1);
        } 
        {
            nextPage = Math.min(mItemCount - 1, mSelectedPosition + getChildCount() - 1);
            down = true;
        } 
        {
            int position = lookForSelectablePosition(nextPage, down);
            {
                mLayoutMode = LAYOUT_SPECIFIC;
                mSpecificTop = mPaddingTop + getVerticalFadingEdgeLength();
                {
                    boolean varA164A5303752DF647D9BF6996D101837_1186721245 = (down && position > mItemCount - getChildCount());
                    {
                        mLayoutMode = LAYOUT_FORCE_BOTTOM;
                    } 
                } 
                {
                    boolean var110612621C7A8EA496F1D2C158694581_407673340 = (!down && position < getChildCount());
                    {
                        mLayoutMode = LAYOUT_FORCE_TOP;
                    } 
                } 
                setSelectionInt(position);
                invokeOnItemScrollListener();
                {
                    boolean var23B792A36C4A2414CF3FD466E934AAC2_1787934957 = (!awakenScrollBars());
                    {
                        invalidate();
                    } 
                } 
            } 
        } 
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_803217564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_803217564;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.845 -0400", hash_original_method = "8893A9BFD4970E039D8D32407D02C15E", hash_generated_method = "2455C62D7E31574FBDC027459BA0004D")
     boolean fullScroll(int direction) {
        boolean moved = false;
        {
            {
                int position = lookForSelectablePosition(0, true);
                {
                    mLayoutMode = LAYOUT_FORCE_TOP;
                    setSelectionInt(position);
                    invokeOnItemScrollListener();
                } 
                moved = true;
            } 
        } 
        {
            {
                int position = lookForSelectablePosition(mItemCount - 1, true);
                {
                    mLayoutMode = LAYOUT_FORCE_BOTTOM;
                    setSelectionInt(position);
                    invokeOnItemScrollListener();
                } 
                moved = true;
            } 
        } 
        {
            boolean var5B952B5E17217FEE8BC4BB0979561FA3_394182065 = (moved && !awakenScrollBars());
            {
                awakenScrollBars();
                invalidate();
            } 
        } 
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1280601717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1280601717;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.845 -0400", hash_original_method = "27083050B4DD915BDC5D45A692A1DFB7", hash_generated_method = "E850021B2C5911BF235F0DC21E6BCFB5")
    private boolean handleHorizontalFocusWithinListItem(int direction) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of"
                    + " {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
        } 
        final int numChildren = getChildCount();
        {
            final View selectedView = getSelectedView();
            {
                boolean var5A370CFD3CE8F716DF439EFB07635CD0_904943657 = (selectedView != null && selectedView.hasFocus() &&
                    selectedView instanceof ViewGroup);
                {
                    final View currentFocus = selectedView.findFocus();
                    final View nextFocus = FocusFinder.getInstance().findNextFocus(
                        (ViewGroup) selectedView, currentFocus, direction);
                    {
                        currentFocus.getFocusedRect(mTempRect);
                        offsetDescendantRectToMyCoords(currentFocus, mTempRect);
                        offsetRectIntoDescendantCoords(nextFocus, mTempRect);
                        {
                            boolean var76D8898CFBC448597F15A4BC0E876792_176015803 = (nextFocus.requestFocus(direction, mTempRect));
                        } 
                    } 
                    final View globalNextFocus = FocusFinder.getInstance().findNextFocus(
                        (ViewGroup) getRootView(), currentFocus, direction);
                    {
                        boolean varB2F32E25506228F03370ADE074F28912_1413500687 = (isViewAncestorOf(globalNextFocus, this));
                    } 
                } 
            } 
        } 
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2071445912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2071445912;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.846 -0400", hash_original_method = "6B5D7DFA7F5B692B993CC3912D59B646", hash_generated_method = "2DD44FD1767559B777F1FD6CFC789291")
     boolean arrowScroll(int direction) {
        try 
        {
            mInLayout = true;
            final boolean handled = arrowScrollImpl(direction);
            {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
            } 
        } 
        finally 
        {
            mInLayout = false;
        } 
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_329358840 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_329358840;
        
        
            
            
            
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.847 -0400", hash_original_method = "5F8F1549FF6A2936584D81A340335636", hash_generated_method = "766FB827449512B950B096D11E0F6D39")
    private boolean arrowScrollImpl(int direction) {
        {
            boolean var4229DDB8D3BBE3C4FC615E86EF9AD4FF_1552933994 = (getChildCount() <= 0);
        } 
        View selectedView = getSelectedView();
        int selectedPos = mSelectedPosition;
        int nextSelectedPosition = lookForSelectablePositionOnScreen(direction);
        int amountToScroll = amountToScroll(direction, nextSelectedPosition);
        ArrowScrollFocusResult focusResult;
        focusResult = arrowScrollFocused(direction);
        focusResult = null;
        {
            nextSelectedPosition = focusResult.getSelectedPosition();
            amountToScroll = focusResult.getAmountToScroll();
        } 
        boolean needToRedraw = focusResult != null;
        {
            handleNewSelectionChange(selectedView, direction, nextSelectedPosition, focusResult != null);
            setSelectedPositionInt(nextSelectedPosition);
            setNextSelectedPositionInt(nextSelectedPosition);
            selectedView = getSelectedView();
            selectedPos = nextSelectedPosition;
            {
                final View focused = getFocusedChild();
                {
                    focused.clearFocus();
                } 
            } 
            needToRedraw = true;
            checkSelectionChanged();
        } 
        {
            scrollListItemsBy((direction == View.FOCUS_UP) ? amountToScroll : -amountToScroll);
            needToRedraw = true;
        } 
        {
            boolean varB8E5D6C0579FB6C2780425B3D1ABD141_895876163 = (mItemsCanFocus && (focusResult == null)
                && selectedView != null && selectedView.hasFocus());
            {
                final View focused = selectedView.findFocus();
                {
                    boolean var3BB0A88B4E6FC6416F98323008226B4B_2020869388 = (!isViewAncestorOf(focused, this) || distanceToView(focused) > 0);
                    {
                        focused.clearFocus();
                    } 
                } 
            } 
        } 
        {
            boolean var089D086D835620A272CDDA708424B586_430894259 = (nextSelectedPosition == INVALID_POSITION && selectedView != null
                && !isViewAncestorOf(selectedView, this));
            {
                selectedView = null;
                hideSelector();
                mResurrectToPosition = INVALID_POSITION;
            } 
        } 
        {
            {
                positionSelector(selectedPos, selectedView);
                mSelectedTop = selectedView.getTop();
            } 
            {
                boolean varC828E793AFDA5CD988FA9008B6EB3B30_1005097105 = (!awakenScrollBars());
                {
                    invalidate();
                } 
            } 
            invokeOnItemScrollListener();
        } 
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_610515893 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_610515893;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.848 -0400", hash_original_method = "5F7DFDAF299194D301FC447E78E3FD87", hash_generated_method = "2E39DEF1E20B19EDCDFC5989D9F445F2")
    private void handleNewSelectionChange(View selectedView, int direction, int newSelectedPosition,
            boolean newFocusAssigned) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("newSelectedPosition needs to be valid");
        } 
        View topView;
        View bottomView;
        int topViewIndex;
        int bottomViewIndex;
        boolean topSelected = false;
        final int selectedIndex = mSelectedPosition - mFirstPosition;
        final int nextSelectedIndex = newSelectedPosition - mFirstPosition;
        {
            topViewIndex = nextSelectedIndex;
            bottomViewIndex = selectedIndex;
            topView = getChildAt(topViewIndex);
            bottomView = selectedView;
            topSelected = true;
        } 
        {
            topViewIndex = selectedIndex;
            bottomViewIndex = nextSelectedIndex;
            topView = selectedView;
            bottomView = getChildAt(bottomViewIndex);
        } 
        final int numChildren = getChildCount();
        {
            topView.setSelected(!newFocusAssigned && topSelected);
            measureAndAdjustDown(topView, topViewIndex, numChildren);
        } 
        {
            bottomView.setSelected(!newFocusAssigned && !topSelected);
            measureAndAdjustDown(bottomView, bottomViewIndex, numChildren);
        } 
        addTaint(selectedView.getTaint());
        addTaint(direction);
        addTaint(newSelectedPosition);
        addTaint(newFocusAssigned);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.848 -0400", hash_original_method = "D9B7EDD91437C9CF7E31BD236F25B8F3", hash_generated_method = "35BE28E24D81E48469B2E9843DCBC44A")
    private void measureAndAdjustDown(View child, int childIndex, int numChildren) {
        int oldHeight = child.getHeight();
        measureItem(child);
        {
            boolean var7B22EF90C45277911AB272B76E96E5DA_1307244056 = (child.getMeasuredHeight() != oldHeight);
            {
                relayoutMeasuredItem(child);
                final int heightDelta = child.getMeasuredHeight() - oldHeight;
                {
                    int i = childIndex + 1;
                    {
                        getChildAt(i).offsetTopAndBottom(heightDelta);
                    } 
                } 
            } 
        } 
        addTaint(child.getTaint());
        addTaint(childIndex);
        addTaint(numChildren);
        
        
        
        
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.849 -0400", hash_original_method = "195C1D433E8B0F15028E4D73EB2D6DE2", hash_generated_method = "C9124A1003320F8BEE42C4E2248A7567")
    private void measureItem(View child) {
        ViewGroup.LayoutParams p = child.getLayoutParams();
        {
            p = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        } 
        int childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                mListPadding.left + mListPadding.right, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
        } 
        {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        } 
        child.measure(childWidthSpec, childHeightSpec);
        addTaint(child.getTaint());
        
        
        
            
                    
                    
        
        
                
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.849 -0400", hash_original_method = "69D49227DB6AC5D384C2E3A710CB930F", hash_generated_method = "A242E2253F7246D4BB361F519DA592A1")
    private void relayoutMeasuredItem(View child) {
        final int w = child.getMeasuredWidth();
        final int h = child.getMeasuredHeight();
        final int childLeft = mListPadding.left;
        final int childRight = childLeft + w;
        final int childTop = child.getTop();
        final int childBottom = childTop + h;
        child.layout(childLeft, childTop, childRight, childBottom);
        addTaint(child.getTaint());
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.850 -0400", hash_original_method = "42F2E28C8994E7757E02659DFEBDEFA8", hash_generated_method = "1D2DA485CCE5564309AF774C460F88A9")
    private int getArrowScrollPreviewLength() {
        int var32C3DF276D4CC5AB85EAD318AE4B92AE_1712019377 = (Math.max(MIN_SCROLL_PREVIEW_PIXELS, getVerticalFadingEdgeLength()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1431860849 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1431860849;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.850 -0400", hash_original_method = "0CBCA538A833739B1FF13F8466C4BF4D", hash_generated_method = "95212575DC6D38A460ED6DBA74820136")
    private int amountToScroll(int direction, int nextSelectedPosition) {
        final int listBottom = getHeight() - mListPadding.bottom;
        final int listTop = mListPadding.top;
        final int numChildren = getChildCount();
        {
            int indexToMakeVisible = numChildren - 1;
            {
                indexToMakeVisible = nextSelectedPosition - mFirstPosition;
            } 
            final int positionToMakeVisible = mFirstPosition + indexToMakeVisible;
            final View viewToMakeVisible = getChildAt(indexToMakeVisible);
            int goalBottom = listBottom;
            {
                goalBottom -= getArrowScrollPreviewLength();
            } 
            {
                boolean var5F736F6450B740E6E9E57C387C57D4DD_972211009 = (viewToMakeVisible.getBottom() <= goalBottom);
            } 
            {
                boolean var8324A997C3E5144DDD35F3BF25EFB670_2018620025 = (nextSelectedPosition != INVALID_POSITION
                    && (goalBottom - viewToMakeVisible.getTop()) >= getMaxScrollAmount());
            } 
            int amountToScroll = (viewToMakeVisible.getBottom() - goalBottom);
            {
                final int max = getChildAt(numChildren - 1).getBottom() - listBottom;
                amountToScroll = Math.min(amountToScroll, max);
            } 
            int var1934DA7AFCB63592141CB73FE3F03962_2093483639 = (Math.min(amountToScroll, getMaxScrollAmount()));
        } 
        {
            int indexToMakeVisible = 0;
            {
                indexToMakeVisible = nextSelectedPosition - mFirstPosition;
            } 
            final int positionToMakeVisible = mFirstPosition + indexToMakeVisible;
            final View viewToMakeVisible = getChildAt(indexToMakeVisible);
            int goalTop = listTop;
            {
                goalTop += getArrowScrollPreviewLength();
            } 
            {
                boolean var40E2B917BF16844A067981F2A72A29CC_47951189 = (viewToMakeVisible.getTop() >= goalTop);
            } 
            {
                boolean varC22CD0C0296052301FAE425C57E08A6B_488342399 = (nextSelectedPosition != INVALID_POSITION &&
                    (viewToMakeVisible.getBottom() - goalTop) >= getMaxScrollAmount());
            } 
            int amountToScroll = (goalTop - viewToMakeVisible.getTop());
            {
                final int max = listTop - getChildAt(0).getTop();
                amountToScroll = Math.min(amountToScroll,  max);
            } 
            int var1934DA7AFCB63592141CB73FE3F03962_882647036 = (Math.min(amountToScroll, getMaxScrollAmount()));
        } 
        addTaint(direction);
        addTaint(nextSelectedPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883894406 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883894406;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.851 -0400", hash_original_method = "760C70065AEFE7BC7EE2B10D159765ED", hash_generated_method = "A85237CA51D463586440FC224F8161B5")
    private int lookForSelectablePositionOnScreen(int direction) {
        final int firstPosition = mFirstPosition;
        {
            int startPos;
            startPos = mSelectedPosition + 1;
            startPos = firstPosition;
            {
                boolean varFD8F153F7B9B0445D1C8B98618EA7E23_111739473 = (startPos >= mAdapter.getCount());
            } 
            {
                startPos = firstPosition;
            } 
            final int lastVisiblePos = getLastVisiblePosition();
            final ListAdapter adapter = getAdapter();
            {
                int pos = startPos;
                {
                    {
                        boolean var705701EB8E699AA442E2F4E862DC96E7_452984560 = (adapter.isEnabled(pos)
                        && getChildAt(pos - firstPosition).getVisibility() == View.VISIBLE);
                    } 
                } 
            } 
        } 
        {
            int last = firstPosition + getChildCount() - 1;
            int startPos;
            startPos = mSelectedPosition - 1;
            startPos = firstPosition + getChildCount() - 1;
            {
                boolean var52FACA214769BF23A240C7E957876F70_1156740420 = (startPos < 0 || startPos >= mAdapter.getCount());
            } 
            {
                startPos = last;
            } 
            final ListAdapter adapter = getAdapter();
            {
                int pos = startPos;
                {
                    {
                        boolean var705701EB8E699AA442E2F4E862DC96E7_79441180 = (adapter.isEnabled(pos)
                        && getChildAt(pos - firstPosition).getVisibility() == View.VISIBLE);
                    } 
                } 
            } 
        } 
        addTaint(direction);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669294976 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669294976;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.852 -0400", hash_original_method = "2622F1B1638C7BCDD9C32B9CBE54AF85", hash_generated_method = "79B80B8E0B60194820EC759B14E209D3")
    private ArrowScrollFocusResult arrowScrollFocused(final int direction) {
        ArrowScrollFocusResult varB4EAC82CA7396A68D541C85D26508E83_1856497274 = null; 
        ArrowScrollFocusResult varB4EAC82CA7396A68D541C85D26508E83_63960373 = null; 
        ArrowScrollFocusResult varB4EAC82CA7396A68D541C85D26508E83_1356835846 = null; 
        ArrowScrollFocusResult varB4EAC82CA7396A68D541C85D26508E83_1803409667 = null; 
        final View selectedView = getSelectedView();
        View newFocus;
        {
            boolean varA1513A08695E8074CF4C05D652884B2C_1281840245 = (selectedView != null && selectedView.hasFocus());
            {
                View oldFocus = selectedView.findFocus();
                newFocus = FocusFinder.getInstance().findNextFocus(this, oldFocus, direction);
            } 
            {
                {
                    final boolean topFadingEdgeShowing = (mFirstPosition > 0);
                    final int listTop = mListPadding.top +
                        (topFadingEdgeShowing ? getArrowScrollPreviewLength() : 0);
                    int ySearchPoint;
                    boolean var0C9DFED1B79DF626EEB83B6645BDE791_644892634 = ((selectedView != null && selectedView.getTop() > listTop));
                    ySearchPoint = selectedView.getTop();
                    ySearchPoint = listTop;
                    mTempRect.set(0, ySearchPoint, 0, ySearchPoint);
                } 
                {
                    final boolean bottomFadingEdgeShowing = (mFirstPosition + getChildCount() - 1) < mItemCount;
                    final int listBottom = getHeight() - mListPadding.bottom -
                        (bottomFadingEdgeShowing ? getArrowScrollPreviewLength() : 0);
                    int ySearchPoint;
                    boolean var535C017266C0FE7A092B0CC38B96CB22_98566618 = ((selectedView != null && selectedView.getBottom() < listBottom));
                    ySearchPoint = selectedView.getBottom();
                    ySearchPoint = listBottom;
                    mTempRect.set(0, ySearchPoint, 0, ySearchPoint);
                } 
                newFocus = FocusFinder.getInstance().findNextFocusFromRect(this, mTempRect, direction);
            } 
        } 
        {
            final int positionOfNewFocus = positionOfNewFocus(newFocus);
            {
                final int selectablePosition = lookForSelectablePositionOnScreen(direction);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1856497274 = null;
                } 
            } 
            int focusScroll = amountToScrollToNewFocus(direction, newFocus, positionOfNewFocus);
            final int maxScrollAmount = getMaxScrollAmount();
            {
                newFocus.requestFocus(direction);
                mArrowScrollFocusResult.populate(positionOfNewFocus, focusScroll);
                varB4EAC82CA7396A68D541C85D26508E83_63960373 = mArrowScrollFocusResult;
            } 
            {
                boolean varEB2D69BE3268364AC7D3855A8FF1F45F_1159243409 = (distanceToView(newFocus) < maxScrollAmount);
                {
                    newFocus.requestFocus(direction);
                    mArrowScrollFocusResult.populate(positionOfNewFocus, maxScrollAmount);
                    varB4EAC82CA7396A68D541C85D26508E83_1356835846 = mArrowScrollFocusResult;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1803409667 = null;
        addTaint(direction);
        ArrowScrollFocusResult varA7E53CE21691AB073D9660D615818899_1912236591; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1912236591 = varB4EAC82CA7396A68D541C85D26508E83_1856497274;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1912236591 = varB4EAC82CA7396A68D541C85D26508E83_63960373;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1912236591 = varB4EAC82CA7396A68D541C85D26508E83_1356835846;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1912236591 = varB4EAC82CA7396A68D541C85D26508E83_1803409667;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1912236591.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1912236591;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.853 -0400", hash_original_method = "E7A74EC59726801D8AE9EB276549022E", hash_generated_method = "A987A6799B966E97339F401246BA8BF3")
    private int positionOfNewFocus(View newFocus) {
        final int numChildren = getChildCount();
        {
            int i = 0;
            {
                final View child = getChildAt(i);
                {
                    boolean var743CF1855186FF404A0881633A428604_2037006732 = (isViewAncestorOf(newFocus, child));
                } 
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("newFocus is not a child of any of the"
                + " children of the list!");
        addTaint(newFocus.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192323216 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192323216;
        
        
        
            
            
                
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.853 -0400", hash_original_method = "3B08BDE00067F884387760F12D698F42", hash_generated_method = "8D74C8E8B6F9B853F537B0E853906136")
    private boolean isViewAncestorOf(View child, View parent) {
        final ViewParent theParent = child.getParent();
        boolean var31AD4BA23C577C9A637BA02E579FD0B2_1670884262 = ((theParent instanceof ViewGroup) && isViewAncestorOf((View) theParent, parent));
        addTaint(child.getTaint());
        addTaint(parent.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1443707069 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1443707069;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.854 -0400", hash_original_method = "972857949DC34A723A630B605759B3EF", hash_generated_method = "09844E627D41D05B570D430DDCC17811")
    private int amountToScrollToNewFocus(int direction, View newFocus, int positionOfNewFocus) {
        int amountToScroll = 0;
        newFocus.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(newFocus, mTempRect);
        {
            {
                amountToScroll = mListPadding.top - mTempRect.top;
                {
                    amountToScroll += getArrowScrollPreviewLength();
                } 
            } 
        } 
        {
            final int listBottom = getHeight() - mListPadding.bottom;
            {
                amountToScroll = mTempRect.bottom - listBottom;
                {
                    amountToScroll += getArrowScrollPreviewLength();
                } 
            } 
        } 
        addTaint(direction);
        addTaint(newFocus.getTaint());
        addTaint(positionOfNewFocus);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798281624 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798281624;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.854 -0400", hash_original_method = "2468FB71A40A0019FA8D57CEA81AC8A6", hash_generated_method = "4BE850BF5E013D20465F8C49D1D34F1A")
    private int distanceToView(View descendant) {
        int distance = 0;
        descendant.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(descendant, mTempRect);
        final int listBottom = mBottom - mTop - mListPadding.bottom;
        {
            distance = mListPadding.top - mTempRect.bottom;
        } 
        {
            distance = mTempRect.top - listBottom;
        } 
        addTaint(descendant.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_173898284 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_173898284;
        
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.855 -0400", hash_original_method = "FAA0316A71F66D005638E2A277415AFB", hash_generated_method = "3414EA07E49DE2E6AD74497643D2FCFF")
    private void scrollListItemsBy(int amount) {
        offsetChildrenTopAndBottom(amount);
        final int listBottom = getHeight() - mListPadding.bottom;
        final int listTop = mListPadding.top;
        final AbsListView.RecycleBin recycleBin = mRecycler;
        {
            int numChildren = getChildCount();
            View last = getChildAt(numChildren - 1);
            {
                boolean var5F1380678D3DF277A8634CE4F78FA5E2_1186781983 = (last.getBottom() < listBottom);
                {
                    final int lastVisiblePosition = mFirstPosition + numChildren - 1;
                    {
                        last = addViewBelow(last, lastVisiblePosition);
                    } 
                } 
            } 
            {
                boolean var5F1380678D3DF277A8634CE4F78FA5E2_821369134 = (last.getBottom() < listBottom);
                {
                    offsetChildrenTopAndBottom(listBottom - last.getBottom());
                } 
            } 
            View first = getChildAt(0);
            {
                boolean var5DEAA936426734BA7061F416FF8C6D22_1342962509 = (first.getBottom() < listTop);
                {
                    AbsListView.LayoutParams layoutParams = (LayoutParams) first.getLayoutParams();
                    {
                        boolean var2ED08FF5DD3428B26AE67127DC8E5467_1921315123 = (recycleBin.shouldRecycleViewType(layoutParams.viewType));
                        {
                            detachViewFromParent(first);
                            recycleBin.addScrapView(first, mFirstPosition);
                        } 
                        {
                            removeViewInLayout(first);
                        } 
                    } 
                    first = getChildAt(0);
                } 
            } 
        } 
        {
            View first = getChildAt(0);
            {
                boolean var4D6C61E96E1628FDB98784EB678A415B_1495556760 = ((first.getTop() > listTop) && (mFirstPosition > 0));
                {
                    first = addViewAbove(first, mFirstPosition);
                } 
            } 
            {
                boolean varEA4423DF7697B0235733DDAA9E5B11E5_1064857567 = (first.getTop() > listTop);
                {
                    offsetChildrenTopAndBottom(listTop - first.getTop());
                } 
            } 
            int lastIndex = getChildCount() - 1;
            View last = getChildAt(lastIndex);
            {
                boolean var6CFFE8EA59E4FF6F1E1615BCEB3548F9_2100699227 = (last.getTop() > listBottom);
                {
                    AbsListView.LayoutParams layoutParams = (LayoutParams) last.getLayoutParams();
                    {
                        boolean var2ED08FF5DD3428B26AE67127DC8E5467_1557912134 = (recycleBin.shouldRecycleViewType(layoutParams.viewType));
                        {
                            detachViewFromParent(last);
                            recycleBin.addScrapView(last, mFirstPosition+lastIndex);
                        } 
                        {
                            removeViewInLayout(last);
                        } 
                    } 
                    last = getChildAt(--lastIndex);
                } 
            } 
        } 
        addTaint(amount);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.856 -0400", hash_original_method = "9F36487536DE2965CEF1C4C9236F1DF4", hash_generated_method = "0EB715DED414D914C7C2454BFA196A24")
    private View addViewAbove(View theView, int position) {
        View varB4EAC82CA7396A68D541C85D26508E83_647086213 = null; 
        int abovePosition = position - 1;
        View view = obtainView(abovePosition, mIsScrap);
        int edgeOfNewChild = theView.getTop() - mDividerHeight;
        setupChild(view, abovePosition, edgeOfNewChild, false, mListPadding.left,
                false, mIsScrap[0]);
        varB4EAC82CA7396A68D541C85D26508E83_647086213 = view;
        addTaint(theView.getTaint());
        addTaint(position);
        varB4EAC82CA7396A68D541C85D26508E83_647086213.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_647086213;
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.857 -0400", hash_original_method = "D4F2FE3018B44C78CF4E93EBC6FE5FC7", hash_generated_method = "D389D5F0B7D7653785238B74AC7E1011")
    private View addViewBelow(View theView, int position) {
        View varB4EAC82CA7396A68D541C85D26508E83_2070786793 = null; 
        int belowPosition = position + 1;
        View view = obtainView(belowPosition, mIsScrap);
        int edgeOfNewChild = theView.getBottom() + mDividerHeight;
        setupChild(view, belowPosition, edgeOfNewChild, true, mListPadding.left,
                false, mIsScrap[0]);
        varB4EAC82CA7396A68D541C85D26508E83_2070786793 = view;
        addTaint(theView.getTaint());
        addTaint(position);
        varB4EAC82CA7396A68D541C85D26508E83_2070786793.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2070786793;
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.857 -0400", hash_original_method = "B028681B6F4AF7B56D2E022B96A1F853", hash_generated_method = "FAC3768DB5C6CA1E40D91C9DDCFC4DB7")
    public void setItemsCanFocus(boolean itemsCanFocus) {
        mItemsCanFocus = itemsCanFocus;
        {
            setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.858 -0400", hash_original_method = "1C95AE1007B5CDC38C9B3E3B2904F365", hash_generated_method = "372C094C18BF32613A1AB51DC62BEB7E")
    public boolean getItemsCanFocus() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1191962720 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1191962720;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.859 -0400", hash_original_method = "719E5FD40BAA2B7205DD0269FBFE398A", hash_generated_method = "22FDBE4E2D8E978CEF1D6C5BE31D2215")
    @Override
    public boolean isOpaque() {
        boolean retValue = (mCachingActive && mIsCacheColorOpaque && mDividerIsOpaque &&
                hasOpaqueScrollbars()) || super.isOpaque();
        {
            int listTop;
            listTop = mListPadding.top;
            listTop = mPaddingTop;
            View first = getChildAt(0);
            {
                boolean var37967F45E1391B4313D5330FBE659A90_811472591 = (first == null || first.getTop() > listTop);
            } 
            final int listBottom = getHeight() -
                    (mListPadding != null ? mListPadding.bottom : mPaddingBottom);
            View last = getChildAt(getChildCount() - 1);
            {
                boolean varA905B41E3DA83EC3F86F88778ACFCAD2_1662165011 = (last == null || last.getBottom() < listBottom);
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1227889962 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1227889962;
        
        
                
        
            
            
            
                
            
            
                    
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.860 -0400", hash_original_method = "465D449366429949FD8ADA654918A0E2", hash_generated_method = "267075DE114AC7A2BE686DA7039F517D")
    @Override
    public void setCacheColorHint(int color) {
        final boolean opaque = (color >>> 24) == 0xFF;
        mIsCacheColorOpaque = opaque;
        {
            {
                mDividerPaint = new Paint();
            } 
            mDividerPaint.setColor(color);
        } 
        super.setCacheColorHint(color);
        addTaint(color);
        
        
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.860 -0400", hash_original_method = "9A5C934D25A361940ECD1D897C78B567", hash_generated_method = "93D739F6558B5DD097D191F2B17C193E")
     void drawOverscrollHeader(Canvas canvas, Drawable drawable, Rect bounds) {
        final int height = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(bounds);
        final int span = bounds.bottom - bounds.top;
        {
            bounds.top = bounds.bottom - height;
        } 
        drawable.setBounds(bounds);
        drawable.draw(canvas);
        canvas.restore();
        addTaint(canvas.getTaint());
        addTaint(drawable.getTaint());
        addTaint(bounds.getTaint());
        
        
        
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.861 -0400", hash_original_method = "3C862E16BE3AA71DC427E03E79AFA46F", hash_generated_method = "289BA3068CB5BC540868373DE02D5012")
     void drawOverscrollFooter(Canvas canvas, Drawable drawable, Rect bounds) {
        final int height = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(bounds);
        final int span = bounds.bottom - bounds.top;
        {
            bounds.bottom = bounds.top + height;
        } 
        drawable.setBounds(bounds);
        drawable.draw(canvas);
        canvas.restore();
        addTaint(canvas.getTaint());
        addTaint(drawable.getTaint());
        addTaint(bounds.getTaint());
        
        
        
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.862 -0400", hash_original_method = "2FA3D064F2DBB643D61459E2FE6AA64C", hash_generated_method = "E3A65CCD7E2F366B36E9679C37E11C94")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        {
            mCachingActive = true;
        } 
        final int dividerHeight = mDividerHeight;
        final Drawable overscrollHeader = mOverScrollHeader;
        final Drawable overscrollFooter = mOverScrollFooter;
        final boolean drawOverscrollHeader = overscrollHeader != null;
        final boolean drawOverscrollFooter = overscrollFooter != null;
        final boolean drawDividers = dividerHeight > 0 && mDivider != null;
        {
            final Rect bounds = mTempRect;
            bounds.left = mPaddingLeft;
            bounds.right = mRight - mLeft - mPaddingRight;
            final int count = getChildCount();
            final int headerCount = mHeaderViewInfos.size();
            final int itemCount = mItemCount;
            final int footerLimit = itemCount - mFooterViewInfos.size() - 1;
            final boolean headerDividers = mHeaderDividersEnabled;
            final boolean footerDividers = mFooterDividersEnabled;
            final int first = mFirstPosition;
            final boolean areAllItemsSelectable = mAreAllItemsSelectable;
            final ListAdapter adapter = mAdapter;
            final boolean fillForMissingDividers = isOpaque() && !super.isOpaque();
            {
                mDividerPaint = new Paint();
                mDividerPaint.setColor(getCacheColorHint());
            } 
            final Paint paint = mDividerPaint;
            int effectivePaddingTop = 0;
            int effectivePaddingBottom = 0;
            {
                effectivePaddingTop = mListPadding.top;
                effectivePaddingBottom = mListPadding.bottom;
            } 
            final int listBottom = mBottom - mTop - effectivePaddingBottom + mScrollY;
            {
                int bottom = 0;
                final int scrollY = mScrollY;
                {
                    {
                        bounds.bottom = 0;
                        bounds.top = scrollY;
                        drawOverscrollHeader(canvas, overscrollHeader, bounds);
                    } 
                    {
                        bounds.bottom = 0;
                        bounds.top = -dividerHeight;
                        drawDivider(canvas, bounds, -1);
                    } 
                } 
                {
                    int i = 0;
                    {
                        {
                            View child = getChildAt(i);
                            bottom = child.getBottom();
                            {
                                {
                                    boolean var6726FD4BAAAC9954E951547807371C28_835158031 = ((areAllItemsSelectable ||
                                    (adapter.isEnabled(first + i) && (i == count - 1 ||
                                            adapter.isEnabled(first + i + 1)))));
                                    {
                                        bounds.top = bottom;
                                        bounds.bottom = bottom + dividerHeight;
                                        drawDivider(canvas, bounds, i);
                                    } 
                                    {
                                        bounds.top = bottom;
                                        bounds.bottom = bottom + dividerHeight;
                                        canvas.drawRect(bounds, paint);
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                final int overFooterBottom = mBottom + mScrollY;
                {
                    bounds.top = bottom;
                    bounds.bottom = overFooterBottom;
                    drawOverscrollFooter(canvas, overscrollFooter, bounds);
                } 
            } 
            {
                int top;
                final int scrollY = mScrollY;
                {
                    bounds.top = scrollY;
                    bounds.bottom = getChildAt(0).getTop();
                    drawOverscrollHeader(canvas, overscrollHeader, bounds);
                } 
                int start;
                start = 1;
                start = 0;
                {
                    int i = start;
                    {
                        {
                            View child = getChildAt(i);
                            top = child.getTop();
                            {
                                {
                                    boolean var6726FD4BAAAC9954E951547807371C28_876362000 = ((areAllItemsSelectable ||
                                    (adapter.isEnabled(first + i) && (i == count - 1 ||
                                            adapter.isEnabled(first + i + 1)))));
                                    {
                                        bounds.top = top - dividerHeight;
                                        bounds.bottom = top;
                                        drawDivider(canvas, bounds, i - 1);
                                    } 
                                    {
                                        bounds.top = top - dividerHeight;
                                        bounds.bottom = top;
                                        canvas.drawRect(bounds, paint);
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                {
                    {
                        final int absListBottom = mBottom;
                        bounds.top = absListBottom;
                        bounds.bottom = absListBottom + scrollY;
                        drawOverscrollFooter(canvas, overscrollFooter, bounds);
                    } 
                    {
                        bounds.top = listBottom;
                        bounds.bottom = listBottom + dividerHeight;
                        drawDivider(canvas, bounds, -1);
                    } 
                } 
            } 
        } 
        super.dispatchDraw(canvas);
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.863 -0400", hash_original_method = "4EC2B6750B1C7732AC3B627095EC138F", hash_generated_method = "667445FD6E779838B6F9F3677DEEB56C")
    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean more = super.drawChild(canvas, child, drawingTime);
        {
            mCachingActive = false;
        } 
        addTaint(canvas.getTaint());
        addTaint(child.getTaint());
        addTaint(drawingTime);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1639323324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1639323324;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.863 -0400", hash_original_method = "AB3CC143C94AF212348DFB5018C60850", hash_generated_method = "AAD049C1FA6D7046E133AF2FA9FE1510")
     void drawDivider(Canvas canvas, Rect bounds, int childIndex) {
        final Drawable divider = mDivider;
        divider.setBounds(bounds);
        divider.draw(canvas);
        addTaint(canvas.getTaint());
        addTaint(bounds.getTaint());
        addTaint(childIndex);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.863 -0400", hash_original_method = "7B5403D1FD6AC98A776FCB41ADD8E487", hash_generated_method = "9C43ED72DE1C8700BF739B322EC9CDD4")
    public Drawable getDivider() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_964630050 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_964630050 = mDivider;
        varB4EAC82CA7396A68D541C85D26508E83_964630050.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_964630050;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.864 -0400", hash_original_method = "7913B276C2BDCD5302E597BC9A4CB654", hash_generated_method = "E21C76FA96F5BFD5336B757BD1BC5673")
    public void setDivider(Drawable divider) {
        {
            mDividerHeight = divider.getIntrinsicHeight();
        } 
        {
            mDividerHeight = 0;
        } 
        mDivider = divider;
        mDividerIsOpaque = divider == null || divider.getOpacity() == PixelFormat.OPAQUE;
        requestLayout();
        invalidate();
        
        
            
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.864 -0400", hash_original_method = "229663AAAB1BC0B50485AD0B5CC199F3", hash_generated_method = "974639243288C5A4EBE688764EF123DC")
    public int getDividerHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_393073895 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_393073895;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.864 -0400", hash_original_method = "D3D08555D2F9E637F163A09E680CBA08", hash_generated_method = "F0AE68FA46B0ADDC93935BBE3F16E6B1")
    public void setDividerHeight(int height) {
        mDividerHeight = height;
        requestLayout();
        invalidate();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.865 -0400", hash_original_method = "97442AC2339A7874BFA41866E47D7310", hash_generated_method = "82E939478FD38F6F96EFD8736EAC5DA4")
    public void setHeaderDividersEnabled(boolean headerDividersEnabled) {
        mHeaderDividersEnabled = headerDividersEnabled;
        invalidate();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.865 -0400", hash_original_method = "74ACE2244DDEB7C7F913E5E0F875653E", hash_generated_method = "647057629C534B13B55E9BA37BB1D9B8")
    public void setFooterDividersEnabled(boolean footerDividersEnabled) {
        mFooterDividersEnabled = footerDividersEnabled;
        invalidate();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.865 -0400", hash_original_method = "953E541E16240F0325506F6534EE33B4", hash_generated_method = "64DCB2C7DA1E915EE3294305D1356011")
    public void setOverscrollHeader(Drawable header) {
        mOverScrollHeader = header;
        {
            invalidate();
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.865 -0400", hash_original_method = "95FFBAE371294243FE9AD2355C3622A4", hash_generated_method = "6AC453A732CB727D110887B94B85260B")
    public Drawable getOverscrollHeader() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1404137343 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1404137343 = mOverScrollHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1404137343.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1404137343;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.866 -0400", hash_original_method = "E2CA032ECDDC156C9CE8335D95975846", hash_generated_method = "1A6AF223BC637FBFCF894AE4D3360007")
    public void setOverscrollFooter(Drawable footer) {
        mOverScrollFooter = footer;
        invalidate();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.866 -0400", hash_original_method = "C43851852530BF4773181DC349AD3704", hash_generated_method = "0A0D9F8D6EA1BA50C7E8DD344FC68849")
    public Drawable getOverscrollFooter() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_291807148 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_291807148 = mOverScrollFooter;
        varB4EAC82CA7396A68D541C85D26508E83_291807148.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_291807148;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.867 -0400", hash_original_method = "A140BD3D04197A195532B0C2217798E2", hash_generated_method = "73861AEB88F705FCE3084BEAFC3A6F6D")
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        final ListAdapter adapter = mAdapter;
        int closetChildIndex = -1;
        int closestChildTop = 0;
        {
            previouslyFocusedRect.offset(mScrollX, mScrollY);
            {
                boolean var834FA86141DD35F45E58D6AC3B8AC266_1425676209 = (adapter.getCount() < getChildCount() + mFirstPosition);
                {
                    mLayoutMode = LAYOUT_NORMAL;
                    layoutChildren();
                } 
            } 
            Rect otherRect = mTempRect;
            int minDistance = Integer.MAX_VALUE;
            final int childCount = getChildCount();
            final int firstPosition = mFirstPosition;
            {
                int i = 0;
                {
                    {
                        boolean varF0493CBC36FEE8A37314533655677361_2101636385 = (!adapter.isEnabled(firstPosition + i));
                    } 
                    View other = getChildAt(i);
                    other.getDrawingRect(otherRect);
                    offsetDescendantRectToMyCoords(other, otherRect);
                    int distance = getDistance(previouslyFocusedRect, otherRect, direction);
                    {
                        minDistance = distance;
                        closetChildIndex = i;
                        closestChildTop = other.getTop();
                    } 
                } 
            } 
        } 
        {
            setSelectionFromTop(closetChildIndex + mFirstPosition, closestChildTop);
        } 
        {
            requestLayout();
        } 
        addTaint(gainFocus);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.868 -0400", hash_original_method = "33666A5E6A3C0638CD57027CC0FE1CC1", hash_generated_method = "74A45A99786652B597F90D1A5C9C0E2B")
    @Override
    protected void onFinishInflate() {
        
        super.onFinishInflate();
        int count = getChildCount();
        {
            {
                int i = 0;
                {
                    addHeaderView(getChildAt(i));
                } 
            } 
            removeAllViews();
        } 
        
        
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.870 -0400", hash_original_method = "55B474F0526D1B513F7B1BB91F273A6A", hash_generated_method = "C37DD715D35E86F632E333BDCCB29DCA")
    @Override
    protected View findViewTraversal(int id) {
        View varB4EAC82CA7396A68D541C85D26508E83_95026756 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_447811369 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_717489768 = null; 
        View v;
        v = super.findViewTraversal(id);
        {
            v = findViewInHeadersOrFooters(mHeaderViewInfos, id);
            {
                varB4EAC82CA7396A68D541C85D26508E83_95026756 = v;
            } 
            v = findViewInHeadersOrFooters(mFooterViewInfos, id);
            {
                varB4EAC82CA7396A68D541C85D26508E83_447811369 = v;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_717489768 = v;
        addTaint(id);
        View varA7E53CE21691AB073D9660D615818899_117349329; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_117349329 = varB4EAC82CA7396A68D541C85D26508E83_95026756;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_117349329 = varB4EAC82CA7396A68D541C85D26508E83_447811369;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_117349329 = varB4EAC82CA7396A68D541C85D26508E83_717489768;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_117349329.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_117349329;
        
        
        
        
            
            
                
            
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.871 -0400", hash_original_method = "CE5790FF46C8EC9157EF966632ADD833", hash_generated_method = "A277C839DBEFF9CEA252CF2FD61A9B0D")
     View findViewInHeadersOrFooters(ArrayList<FixedViewInfo> where, int id) {
        View varB4EAC82CA7396A68D541C85D26508E83_1834871228 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_170886614 = null; 
        {
            int len = where.size();
            View v;
            {
                int i = 0;
                {
                    v = where.get(i).view;
                    {
                        boolean var3F751ABEC959446BA6608C20A1A0BA91_1997512147 = (!v.isRootNamespace());
                        {
                            v = v.findViewById(id);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1834871228 = v;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_170886614 = null;
        addTaint(where.getTaint());
        addTaint(id);
        View varA7E53CE21691AB073D9660D615818899_603094409; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_603094409 = varB4EAC82CA7396A68D541C85D26508E83_1834871228;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_603094409 = varB4EAC82CA7396A68D541C85D26508E83_170886614;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_603094409.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_603094409;
        
        
            
            
            
                
                
                    
                    
                        
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.873 -0400", hash_original_method = "3E2A521CFE9847E9FDB3AEC6F88A76DD", hash_generated_method = "E3493C9B6EE9E2C07247C602FCF8FD1B")
    @Override
    protected View findViewWithTagTraversal(Object tag) {
        View varB4EAC82CA7396A68D541C85D26508E83_1820557242 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1677491334 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1579614294 = null; 
        View v;
        v = super.findViewWithTagTraversal(tag);
        {
            v = findViewWithTagInHeadersOrFooters(mHeaderViewInfos, tag);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1820557242 = v;
            } 
            v = findViewWithTagInHeadersOrFooters(mFooterViewInfos, tag);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1677491334 = v;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1579614294 = v;
        addTaint(tag.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1018573338; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1018573338 = varB4EAC82CA7396A68D541C85D26508E83_1820557242;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1018573338 = varB4EAC82CA7396A68D541C85D26508E83_1677491334;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1018573338 = varB4EAC82CA7396A68D541C85D26508E83_1579614294;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1018573338.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1018573338;
        
        
        
        
            
            
                
            
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.874 -0400", hash_original_method = "FB5700AACE78A96EA34C4186153EA1D8", hash_generated_method = "43920CFA82C71BF529EF72A638859FBD")
     View findViewWithTagInHeadersOrFooters(ArrayList<FixedViewInfo> where, Object tag) {
        View varB4EAC82CA7396A68D541C85D26508E83_468554330 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_698015905 = null; 
        {
            int len = where.size();
            View v;
            {
                int i = 0;
                {
                    v = where.get(i).view;
                    {
                        boolean var3F751ABEC959446BA6608C20A1A0BA91_1783468749 = (!v.isRootNamespace());
                        {
                            v = v.findViewWithTag(tag);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_468554330 = v;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_698015905 = null;
        addTaint(where.getTaint());
        addTaint(tag.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1095584575; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1095584575 = varB4EAC82CA7396A68D541C85D26508E83_468554330;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1095584575 = varB4EAC82CA7396A68D541C85D26508E83_698015905;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1095584575.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1095584575;
        
        
            
            
            
                
                
                    
                    
                        
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.875 -0400", hash_original_method = "C4FCF9CDE386456E06D0A36ACE84F436", hash_generated_method = "EE5D0E36A183B86D4A8C5AB9DD032470")
    @Override
    protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip) {
        View varB4EAC82CA7396A68D541C85D26508E83_226592670 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_928004501 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_62319283 = null; 
        View v;
        v = super.findViewByPredicateTraversal(predicate, childToSkip);
        {
            v = findViewByPredicateInHeadersOrFooters(mHeaderViewInfos, predicate, childToSkip);
            {
                varB4EAC82CA7396A68D541C85D26508E83_226592670 = v;
            } 
            v = findViewByPredicateInHeadersOrFooters(mFooterViewInfos, predicate, childToSkip);
            {
                varB4EAC82CA7396A68D541C85D26508E83_928004501 = v;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_62319283 = v;
        addTaint(predicate.getTaint());
        addTaint(childToSkip.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1809080313; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1809080313 = varB4EAC82CA7396A68D541C85D26508E83_226592670;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1809080313 = varB4EAC82CA7396A68D541C85D26508E83_928004501;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1809080313 = varB4EAC82CA7396A68D541C85D26508E83_62319283;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1809080313.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1809080313;
        
        
        
        
            
            
                
            
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.876 -0400", hash_original_method = "D1F1A1145A67766E94BF084DFEF4A6A9", hash_generated_method = "F54F49F01DA7249E34CB86CC1E9BE06C")
     View findViewByPredicateInHeadersOrFooters(ArrayList<FixedViewInfo> where,
            Predicate<View> predicate, View childToSkip) {
        View varB4EAC82CA7396A68D541C85D26508E83_732042853 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1018818320 = null; 
        {
            int len = where.size();
            View v;
            {
                int i = 0;
                {
                    v = where.get(i).view;
                    {
                        boolean varE559F145C9972D4F93FC59CF981B09D2_258902953 = (v != childToSkip && !v.isRootNamespace());
                        {
                            v = v.findViewByPredicate(predicate);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_732042853 = v;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1018818320 = null;
        addTaint(where.getTaint());
        addTaint(predicate.getTaint());
        addTaint(childToSkip.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1106389101; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1106389101 = varB4EAC82CA7396A68D541C85D26508E83_732042853;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1106389101 = varB4EAC82CA7396A68D541C85D26508E83_1018818320;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1106389101.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1106389101;
        
        
            
            
            
                
                
                    
                    
                        
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.877 -0400", hash_original_method = "7376DB3A956D54D1A994EA4B9B95B8AF", hash_generated_method = "70657CBFC67563BF27355E7A56962600")
    @Deprecated
    public long[] getCheckItemIds() {
        {
            boolean var92A5B2B773F784D23AACADEC549061AE_1922817066 = (mAdapter != null && mAdapter.hasStableIds());
            {
                long[] varEA0F92157511B761BCA87A37A949584F_1644339564 = (getCheckedItemIds());
            } 
        } 
        {
            final SparseBooleanArray states = mCheckStates;
            final int count = states.size();
            final long[] ids = new long[count];
            final ListAdapter adapter = mAdapter;
            int checkedCount = 0;
            {
                int i = 0;
                {
                    {
                        boolean var06DB0322BE5DDF244F3C57344F69D711_1778430980 = (states.valueAt(i));
                        {
                            ids[checkedCount++] = adapter.getItemId(states.keyAt(i));
                        } 
                    } 
                } 
            } 
            {
                final long[] result = new long[checkedCount];
                System.arraycopy(ids, 0, result, 0, checkedCount);
            } 
        } 
        long[] var6C93D8E1F6D98EBFFE119BBCCB99BC4A_499283886 = (new long[0]);
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1502593111 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1502593111;
        
        
    }

    
    public class FixedViewInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.877 -0400", hash_original_field = "1BDA80F2BE4D3658E0BAA43FBE7AE8C1", hash_generated_field = "F4E21118122450D7DE8C5B004AEA690D")

        public View view;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.877 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "FC3B89DB1B4BAEFF0C8DFDD10399B12A")

        public Object data;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.877 -0400", hash_original_field = "ADD60A1158B4B8A77E92EC580F3040CE", hash_generated_field = "51BB0A155CFD263D81C29BB4668379B4")

        public boolean isSelectable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.877 -0400", hash_original_method = "67C6F15893AD18CF0EAE06202C68D9E8", hash_generated_method = "67C6F15893AD18CF0EAE06202C68D9E8")
        public FixedViewInfo ()
        {
            
        }


    }


    
    private class FocusSelector implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.877 -0400", hash_original_field = "2A02BDE12D932CD9DCA97106D487F8F5", hash_generated_field = "D614AE7D1AAE0276EA05A974DCBF0210")

        private int mPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.878 -0400", hash_original_field = "1C2A16FEE0F2317B52A14EA25A87B83E", hash_generated_field = "9F00838B177601A91ACC5BEF0B2B59E5")

        private int mPositionTop;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.878 -0400", hash_original_method = "34C9C9AFBDE05AECFED95C79C10A76BA", hash_generated_method = "34C9C9AFBDE05AECFED95C79C10A76BA")
        public FocusSelector ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.878 -0400", hash_original_method = "5C0213FE7A42F47411000D870177F1B7", hash_generated_method = "01B8DE9D2C6011459D6FE19DE607EEA5")
        public FocusSelector setup(int position, int top) {
            FocusSelector varB4EAC82CA7396A68D541C85D26508E83_991590032 = null; 
            mPosition = position;
            mPositionTop = top;
            varB4EAC82CA7396A68D541C85D26508E83_991590032 = this;
            varB4EAC82CA7396A68D541C85D26508E83_991590032.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_991590032;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.879 -0400", hash_original_method = "1C9CFC3992CD17CE1A3B73D68C8C6081", hash_generated_method = "59BBD0E54B7536BB80D52C5363FBE175")
        public void run() {
            setSelectionFromTop(mPosition, mPositionTop);
            
            
        }

        
    }


    
    static private class ArrowScrollFocusResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.879 -0400", hash_original_field = "390A3127D73EBF1C2FE439B9B7D711F9", hash_generated_field = "51E21A7A6543942D242B4E74F7651C70")

        private int mSelectedPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.879 -0400", hash_original_field = "9FA5FDE7E622E7E96DFD95286E06FD92", hash_generated_field = "A1DDFEC53FF7E81352EF3B979C9E665D")

        private int mAmountToScroll;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.879 -0400", hash_original_method = "F12FA46FC2E286992F273AF0197118D3", hash_generated_method = "F12FA46FC2E286992F273AF0197118D3")
        public ArrowScrollFocusResult ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.880 -0400", hash_original_method = "E4C7C1A71AB7D603722F7CE31ED09575", hash_generated_method = "C8559F673D941812E13F3F631D0BAA1F")
         void populate(int selectedPosition, int amountToScroll) {
            mSelectedPosition = selectedPosition;
            mAmountToScroll = amountToScroll;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.880 -0400", hash_original_method = "57FF42983620727F309A47A5C295AFEC", hash_generated_method = "4019BC35734FAA56CCF868F19DC63BFD")
        public int getSelectedPosition() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_250008231 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_250008231;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.881 -0400", hash_original_method = "547539826ED165E8A574C9320A564E9F", hash_generated_method = "F77C73ECD9A85DB844AE7745BD810036")
        public int getAmountToScroll() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843107900 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843107900;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.881 -0400", hash_original_field = "E1DEA0BEB2F8CF12C7B6244C21F007E5", hash_generated_field = "AA54EBB1B05B810D7997E2317D48B2F5")

    static final int NO_POSITION = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.881 -0400", hash_original_field = "3559B51D9CE8D7099F97AA2C846ABFFB", hash_generated_field = "F481F11D6BAC4699C15393640CE5DB57")

    private static final float MAX_SCROLL_FACTOR = 0.33f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.881 -0400", hash_original_field = "DA0484B66F107DB9B9104112BC0055B2", hash_generated_field = "992BEAE71211E256B201562C8AAD0326")

    private static final int MIN_SCROLL_PREVIEW_PIXELS = 2;
}

