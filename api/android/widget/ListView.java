package android.widget;

// Droidsafe Imports
import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.android.internal.util.Predicate;
import com.google.android.collect.Lists;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ListView extends AbsListView {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.789 -0400", hash_original_field = "A0E111006ED777C10D75AA1677A2639C", hash_generated_field = "4BC24FD3C886BCFFDF832386DEC27D09")

    private ArrayList<FixedViewInfo> mHeaderViewInfos = Lists.newArrayList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.789 -0400", hash_original_field = "CC679F55490278048131235E90055B39", hash_generated_field = "FD730016C2B4D9973A08935CB5CEEF24")

    private ArrayList<FixedViewInfo> mFooterViewInfos = Lists.newArrayList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.789 -0400", hash_original_field = "F2EB92D46BFACFA75ABCA33DC6179915", hash_generated_field = "3837E71D24376BABDBC6EE7CD182AABB")

    Drawable mDivider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.789 -0400", hash_original_field = "FDC96C666CAD9FBF2EF59762861622A0", hash_generated_field = "E9BA9D611B13DC4B2EC5075D3CBC28DA")

    int mDividerHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.790 -0400", hash_original_field = "2E33162EDD274C7EDD1E1156F95BB8C5", hash_generated_field = "61CEC74004B40DBE67743F5C54E8DAE8")

    Drawable mOverScrollHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.790 -0400", hash_original_field = "CCC4EEA4F20C4786C3E2B61E4655BBA7", hash_generated_field = "FAAE7751E5086898A7D9334FDB1CBF58")

    Drawable mOverScrollFooter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.790 -0400", hash_original_field = "8BEFBF97EB4D2DF9EC8AA6449CB3CA5E", hash_generated_field = "D67B6F8B88187DB827FEE4CD95C0CD84")

    private boolean mIsCacheColorOpaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.790 -0400", hash_original_field = "339C469036C2CC68131B6FFE99D261C1", hash_generated_field = "F64CA3AD07E4A441F83FB08509D5EA54")

    private boolean mDividerIsOpaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.790 -0400", hash_original_field = "4D65FD0E015FCBFA86076C532AFC8520", hash_generated_field = "E4D279F003B799932AE6A47EC9C65A6F")

    private boolean mHeaderDividersEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.790 -0400", hash_original_field = "7D3333BFE992E9D671CB18E1CC4F46F2", hash_generated_field = "D61311FF24E9C122770C1CC46CD91809")

    private boolean mFooterDividersEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.790 -0400", hash_original_field = "CD24990D52A8F3E7E5EB9907AF3F4BCB", hash_generated_field = "1E6DAAB899E2A1039D680325576FF2F4")

    private boolean mAreAllItemsSelectable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.790 -0400", hash_original_field = "C81EE07A80353C16F692D53C68A2708C", hash_generated_field = "B872CC30C5370C029EE2A26D5DBEB2D2")

    private boolean mItemsCanFocus = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.790 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.790 -0400", hash_original_field = "E00CE94A319056CF4CFCE4FD6B48FD75", hash_generated_field = "4B2413695EEECE37901862E70E0ADF71")

    private Paint mDividerPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.790 -0400", hash_original_field = "622C7E912E416442D6067E781BEF934A", hash_generated_field = "4260816BC1A1EC85165CC5FE8DD47CE4")

    private final ArrowScrollFocusResult mArrowScrollFocusResult = new ArrowScrollFocusResult();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.790 -0400", hash_original_field = "D85788A92B1851B4DB4DD47891274715", hash_generated_field = "21847DEAFE51D735E62E529ABB2AD8CB")

    private FocusSelector mFocusSelector;
    
    @DSModeled(DSC.SAFE)
	public ListView(Context context) {
		super(context);
	}

    
    public ListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

    
    public ListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.792 -0400", hash_original_method = "13CC3D3BB67006B8B223FEAA5CEB8AD3", hash_generated_method = "0305660DAF08B045FB9A5DDC42147F46")
    public int getMaxScrollAmount() {
        int var4EE17CA5D467EC005F38F5E52038081E_735658019 = ((int) (MAX_SCROLL_FACTOR * (mBottom - mTop)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625436384 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625436384;
        // ---------- Original Method ----------
        //return (int) (MAX_SCROLL_FACTOR * (mBottom - mTop));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.793 -0400", hash_original_method = "C98C1C3289511C3CD05158CF07015375", hash_generated_method = "7112BDF592048000D75E8AED37A15826")
    private void adjustViewsUpOrDown() {
        final int childCount = getChildCount();
        int delta;
        if(childCount > 0)        
        {
            View child;
            if(!mStackFromBottom)            
            {
                child = getChildAt(0);
                delta = child.getTop() - mListPadding.top;
                if(mFirstPosition != 0)                
                {
                    delta -= mDividerHeight;
                } //End block
                if(delta < 0)                
                {
                    delta = 0;
                } //End block
            } //End block
            else
            {
                child = getChildAt(childCount - 1);
                delta = child.getBottom() - (getHeight() - mListPadding.bottom);
                if(mFirstPosition + childCount < mItemCount)                
                {
                    delta += mDividerHeight;
                } //End block
                if(delta > 0)                
                {
                    delta = 0;
                } //End block
            } //End block
            if(delta != 0)            
            {
                offsetChildrenTopAndBottom(-delta);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.793 -0400", hash_original_method = "52D3689EBA08A028E74C350405FC2CA4", hash_generated_method = "BD2D4564C54C43AA3780E0B40012EBEF")
    public void addHeaderView(View v, Object data, boolean isSelectable) {
        addTaint(isSelectable);
        addTaint(data.getTaint());
        addTaint(v.getTaint());
        if(mAdapter != null && ! (mAdapter instanceof HeaderViewListAdapter))        
        {
            IllegalStateException var0A6A243406D00A1B59119CC56A071C4A_88228427 = new IllegalStateException(
                    "Cannot add header view to list -- setAdapter has already been called.");
            var0A6A243406D00A1B59119CC56A071C4A_88228427.addTaint(taint);
            throw var0A6A243406D00A1B59119CC56A071C4A_88228427;
        } //End block
        FixedViewInfo info = new FixedViewInfo();
        info.view = v;
        info.data = data;
        info.isSelectable = isSelectable;
        mHeaderViewInfos.add(info);
        if(mAdapter != null && mDataSetObserver != null)        
        {
            mDataSetObserver.onChanged();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.794 -0400", hash_original_method = "9CDB9BC1941825D09F579B09BA5203C8", hash_generated_method = "00EDF1BB88116AF4022300CF4F346F48")
    public void addHeaderView(View v) {
        addTaint(v.getTaint());
        addHeaderView(v, null, true);
        // ---------- Original Method ----------
        //addHeaderView(v, null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.794 -0400", hash_original_method = "9A198FE2F7DAA22CDFAB063EB95C8DFA", hash_generated_method = "5EB9B974D648CED0F71FE6239B739AEA")
    @Override
    public int getHeaderViewsCount() {
        int varEC0BB00903232C4A08E22EDBBBDDB3B9_40842340 = (mHeaderViewInfos.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1880833230 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1880833230;
        // ---------- Original Method ----------
        //return mHeaderViewInfos.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.794 -0400", hash_original_method = "8EF6528E21853FD53F2FB8406F9F06D5", hash_generated_method = "5B3E22D85A39086DAA0FDEA3BAA70CE8")
    public boolean removeHeaderView(View v) {
        addTaint(v.getTaint());
        if(mHeaderViewInfos.size() > 0)        
        {
            boolean result = false;
            if(mAdapter != null && ((HeaderViewListAdapter) mAdapter).removeHeader(v))            
            {
                if(mDataSetObserver != null)                
                {
                    mDataSetObserver.onChanged();
                } //End block
                result = true;
            } //End block
            removeFixedViewInfo(v, mHeaderViewInfos);
            boolean varB4A88417B3D0170D754C647C30B7216A_525243625 = (result);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1799637823 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1799637823;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1371185719 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1276205431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1276205431;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.795 -0400", hash_original_method = "56A07A9A1AC012F692F90759B155683C", hash_generated_method = "92489FA13AF108F3C26735DF137D0826")
    private void removeFixedViewInfo(View v, ArrayList<FixedViewInfo> where) {
        addTaint(where.getTaint());
        addTaint(v.getTaint());
        int len = where.size();
for(int i = 0;i < len;++i)
        {
            FixedViewInfo info = where.get(i);
            if(info.view == v)            
            {
                where.remove(i);
                break;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.797 -0400", hash_original_method = "854663FFCE0B2EEEA12F571F4E080752", hash_generated_method = "96C588D5F6EF42CBFF42816BF1B3FE4B")
    public void addFooterView(View v, Object data, boolean isSelectable) {
        addTaint(isSelectable);
        addTaint(data.getTaint());
        addTaint(v.getTaint());
        FixedViewInfo info = new FixedViewInfo();
        info.view = v;
        info.data = data;
        info.isSelectable = isSelectable;
        mFooterViewInfos.add(info);
        if(mAdapter != null && mDataSetObserver != null)        
        {
            mDataSetObserver.onChanged();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.798 -0400", hash_original_method = "06A7CBCF71002E57CE516EE24D5E8CDC", hash_generated_method = "13D5E8C7B2A36B2C4D081811F170AF52")
    public void addFooterView(View v) {
        addTaint(v.getTaint());
        addFooterView(v, null, true);
        // ---------- Original Method ----------
        //addFooterView(v, null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.798 -0400", hash_original_method = "83BE551B6778E6D258871D9949AEF538", hash_generated_method = "83F9A15B4554A9EE1FBAB91FB2DFACE2")
    @Override
    public int getFooterViewsCount() {
        int var290018E65E5025ADA8657290793A446E_1884681492 = (mFooterViewInfos.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83952803 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83952803;
        // ---------- Original Method ----------
        //return mFooterViewInfos.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.798 -0400", hash_original_method = "D2E29F254410117CE819574854BB79EC", hash_generated_method = "D4405C824B0336D0BDAB4C8A2F47F908")
    public boolean removeFooterView(View v) {
        addTaint(v.getTaint());
        if(mFooterViewInfos.size() > 0)        
        {
            boolean result = false;
            if(mAdapter != null && ((HeaderViewListAdapter) mAdapter).removeFooter(v))            
            {
                if(mDataSetObserver != null)                
                {
                    mDataSetObserver.onChanged();
                } //End block
                result = true;
            } //End block
            removeFixedViewInfo(v, mFooterViewInfos);
            boolean varB4A88417B3D0170D754C647C30B7216A_1154322681 = (result);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_252582622 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_252582622;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1870963293 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1437297237 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1437297237;
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

    
    @DSModeled(DSC.SAFE)
    @Override
	public ListAdapter getAdapter() {
		// TODO Auto-generated method stub
		return null;
	}

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.799 -0400", hash_original_method = "8AB2C6958FD7CEC3A8A71FE59763D6A4", hash_generated_method = "F411B04A9F1D200E30F181818B8C9DCB")
    @android.view.RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        addTaint(intent.getTaint());
        super.setRemoteViewsAdapter(intent);
        // ---------- Original Method ----------
        //super.setRemoteViewsAdapter(intent);
    }

    
    @Override
	@DSModeled(DSC.SAFE)
	public void setAdapter(ListAdapter adapter) {
		super.setAdapter(adapter); // Taint in AbsListView
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.800 -0400", hash_original_method = "2C61A8961B533B2EFAE2B5516136BD48", hash_generated_method = "2F9780A9A993D3382CEE1B6821096FDF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.800 -0400", hash_original_method = "917FCC60A4286C5138F872CFDA18A6AE", hash_generated_method = "C8BE139D056F3BFFA831CB7964D4DBA7")
    private void clearRecycledState(ArrayList<FixedViewInfo> infos) {
        addTaint(infos.getTaint());
        if(infos != null)        
        {
            final int count = infos.size();
for(int i = 0;i < count;i++)
            {
                final View child = infos.get(i).view;
                final LayoutParams p = (LayoutParams) child.getLayoutParams();
                if(p != null)                
                {
                    p.recycledHeaderFooter = false;
                } //End block
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.802 -0400", hash_original_method = "AE08170EA161B6A1BF0E53E679181532", hash_generated_method = "6F1B803CE86DAB5B468AFCA2405F0507")
    private boolean showingTopFadingEdge() {
        final int listTop = mScrollY + mListPadding.top;
        boolean var4DA969C76BF1BCFCD23104B889449DA5_838636657 = ((mFirstPosition > 0) || (getChildAt(0).getTop() > listTop));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_699441760 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_699441760;
        // ---------- Original Method ----------
        //final int listTop = mScrollY + mListPadding.top;
        //return (mFirstPosition > 0) || (getChildAt(0).getTop() > listTop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.802 -0400", hash_original_method = "471206817827115E6FDE8330BC3BFE06", hash_generated_method = "D1987106F8474A49D2DB4A83B8EB4C56")
    private boolean showingBottomFadingEdge() {
        final int childCount = getChildCount();
        final int bottomOfBottomChild = getChildAt(childCount - 1).getBottom();
        final int lastVisiblePosition = mFirstPosition + childCount - 1;
        final int listBottom = mScrollY + getHeight() - mListPadding.bottom;
        boolean var7149932C4E3B6C7FFFFA20645C2EF6B2_920235826 = ((lastVisiblePosition < mItemCount - 1)
                         || (bottomOfBottomChild < listBottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_443765961 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_443765961;
        // ---------- Original Method ----------
        //final int childCount = getChildCount();
        //final int bottomOfBottomChild = getChildAt(childCount - 1).getBottom();
        //final int lastVisiblePosition = mFirstPosition + childCount - 1;
        //final int listBottom = mScrollY + getHeight() - mListPadding.bottom;
        //return (lastVisiblePosition < mItemCount - 1)
                         //|| (bottomOfBottomChild < listBottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.803 -0400", hash_original_method = "0248A9BC20DE00C469CC3A8962885EF5", hash_generated_method = "579350D4FB2DB9EDD80AD94302609BE5")
    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rect, boolean immediate) {
        addTaint(immediate);
        addTaint(rect.getTaint());
        addTaint(child.getTaint());
        int rectTopWithinChild = rect.top;
        rect.offset(child.getLeft(), child.getTop());
        rect.offset(-child.getScrollX(), -child.getScrollY());
        final int height = getHeight();
        int listUnfadedTop = getScrollY();
        int listUnfadedBottom = listUnfadedTop + height;
        final int fadingEdge = getVerticalFadingEdgeLength();
        if(showingTopFadingEdge())        
        {
            if((mSelectedPosition > 0) || (rectTopWithinChild > fadingEdge))            
            {
                listUnfadedTop += fadingEdge;
            } //End block
        } //End block
        int childCount = getChildCount();
        int bottomOfBottomChild = getChildAt(childCount - 1).getBottom();
        if(showingBottomFadingEdge())        
        {
            if((mSelectedPosition < mItemCount - 1)
                    || (rect.bottom < (bottomOfBottomChild - fadingEdge)))            
            {
                listUnfadedBottom -= fadingEdge;
            } //End block
        } //End block
        int scrollYDelta = 0;
        if(rect.bottom > listUnfadedBottom && rect.top > listUnfadedTop)        
        {
            if(rect.height() > height)            
            {
                scrollYDelta += (rect.top - listUnfadedTop);
            } //End block
            else
            {
                scrollYDelta += (rect.bottom - listUnfadedBottom);
            } //End block
            int distanceToBottom = bottomOfBottomChild - listUnfadedBottom;
            scrollYDelta = Math.min(scrollYDelta, distanceToBottom);
        } //End block
        else
        if(rect.top < listUnfadedTop && rect.bottom < listUnfadedBottom)        
        {
            if(rect.height() > height)            
            {
                scrollYDelta -= (listUnfadedBottom - rect.bottom);
            } //End block
            else
            {
                scrollYDelta -= (listUnfadedTop - rect.top);
            } //End block
            int top = getChildAt(0).getTop();
            int deltaToTop = top - listUnfadedTop;
            scrollYDelta = Math.max(scrollYDelta, deltaToTop);
        } //End block
        final boolean scroll = scrollYDelta != 0;
        if(scroll)        
        {
            scrollListItemsBy(-scrollYDelta);
            positionSelector(INVALID_POSITION, child);
            mSelectedTop = child.getTop();
            invalidate();
        } //End block
        boolean var089B0CDD8835D09CB1CABF38B3CE9C09_1899986944 = (scroll);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_147648568 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_147648568;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @Override
	void fillGap(boolean down) {
		// TODO Auto-generated method stub
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.806 -0400", hash_original_method = "A51DD6537C0400974E1B605AE841C465", hash_generated_method = "1E31C79576A50D00FEC445FCF1B57D04")
    private View fillDown(int pos, int nextTop) {
        addTaint(nextTop);
        addTaint(pos);
        View selectedView = null;
        int end = (mBottom - mTop);
        if((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK)        
        {
            end -= mListPadding.bottom;
        } //End block
        while
(nextTop < end && pos < mItemCount)        
        {
            boolean selected = pos == mSelectedPosition;
            View child = makeAndAddView(pos, nextTop, true, mListPadding.left, selected);
            nextTop = child.getBottom() + mDividerHeight;
            if(selected)            
            {
                selectedView = child;
            } //End block
            pos++;
        } //End block
View var11299FD0AF79690829705998589379E5_857346683 =         selectedView;
        var11299FD0AF79690829705998589379E5_857346683.addTaint(taint);
        return var11299FD0AF79690829705998589379E5_857346683;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.806 -0400", hash_original_method = "05C528C2066045A21E9535AE6FF4CD3D", hash_generated_method = "875C23A9D9381FAAE0C7CD65AE0D4833")
    private View fillUp(int pos, int nextBottom) {
        addTaint(nextBottom);
        addTaint(pos);
        View selectedView = null;
        int end = 0;
        if((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK)        
        {
            end = mListPadding.top;
        } //End block
        while
(nextBottom > end && pos >= 0)        
        {
            boolean selected = pos == mSelectedPosition;
            View child = makeAndAddView(pos, nextBottom, false, mListPadding.left, selected);
            nextBottom = child.getTop() - mDividerHeight;
            if(selected)            
            {
                selectedView = child;
            } //End block
            pos--;
        } //End block
        mFirstPosition = pos + 1;
View var11299FD0AF79690829705998589379E5_1434411576 =         selectedView;
        var11299FD0AF79690829705998589379E5_1434411576.addTaint(taint);
        return var11299FD0AF79690829705998589379E5_1434411576;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.807 -0400", hash_original_method = "E858B13EC4F52DD7B2125F2E9BA15919", hash_generated_method = "5649626A9D201DE540FD49B312AB8F5A")
    private View fillFromTop(int nextTop) {
        addTaint(nextTop);
        mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
        mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
        if(mFirstPosition < 0)        
        {
            mFirstPosition = 0;
        } //End block
View var49BCC10837EDABC5CED602D8E493B0B0_1283168042 =         fillDown(mFirstPosition, nextTop);
        var49BCC10837EDABC5CED602D8E493B0B0_1283168042.addTaint(taint);
        return var49BCC10837EDABC5CED602D8E493B0B0_1283168042;
        // ---------- Original Method ----------
        //mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
        //mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
        //if (mFirstPosition < 0) {
            //mFirstPosition = 0;
        //}
        //return fillDown(mFirstPosition, nextTop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.807 -0400", hash_original_method = "BB6F12E082A75859BCEF500D953CB8EE", hash_generated_method = "32A0F94A50512C3808E5E0099691346F")
    private View fillFromMiddle(int childrenTop, int childrenBottom) {
        addTaint(childrenBottom);
        addTaint(childrenTop);
        int height = childrenBottom - childrenTop;
        int position = reconcileSelectedPosition();
        View sel = makeAndAddView(position, childrenTop, true,
                mListPadding.left, true);
        mFirstPosition = position;
        int selHeight = sel.getMeasuredHeight();
        if(selHeight <= height)        
        {
            sel.offsetTopAndBottom((height - selHeight) / 2);
        } //End block
        fillAboveAndBelow(sel, position);
        if(!mStackFromBottom)        
        {
            correctTooHigh(getChildCount());
        } //End block
        else
        {
            correctTooLow(getChildCount());
        } //End block
View var7B839F21D0245BE275F8017F44DD4441_616211852 =         sel;
        var7B839F21D0245BE275F8017F44DD4441_616211852.addTaint(taint);
        return var7B839F21D0245BE275F8017F44DD4441_616211852;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.808 -0400", hash_original_method = "E7EAC0AC74052E989A5F3C8A8979A51D", hash_generated_method = "DA777558296DD331F576264928C289B5")
    private void fillAboveAndBelow(View sel, int position) {
        addTaint(position);
        addTaint(sel.getTaint());
        final int dividerHeight = mDividerHeight;
        if(!mStackFromBottom)        
        {
            fillUp(position - 1, sel.getTop() - dividerHeight);
            adjustViewsUpOrDown();
            fillDown(position + 1, sel.getBottom() + dividerHeight);
        } //End block
        else
        {
            fillDown(position + 1, sel.getBottom() + dividerHeight);
            adjustViewsUpOrDown();
            fillUp(position - 1, sel.getTop() - dividerHeight);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.809 -0400", hash_original_method = "439BAC8174DEF92DB2EFE731B080B752", hash_generated_method = "DA759F8410B1B8932A1C17C001BCD597")
    private View fillFromSelection(int selectedTop, int childrenTop, int childrenBottom) {
        addTaint(childrenBottom);
        addTaint(childrenTop);
        addTaint(selectedTop);
        int fadingEdgeLength = getVerticalFadingEdgeLength();
        final int selectedPosition = mSelectedPosition;
        View sel;
        final int topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength,
                selectedPosition);
        final int bottomSelectionPixel = getBottomSelectionPixel(childrenBottom, fadingEdgeLength,
                selectedPosition);
        sel = makeAndAddView(selectedPosition, selectedTop, true, mListPadding.left, true);
        if(sel.getBottom() > bottomSelectionPixel)        
        {
            final int spaceAbove = sel.getTop() - topSelectionPixel;
            final int spaceBelow = sel.getBottom() - bottomSelectionPixel;
            final int offset = Math.min(spaceAbove, spaceBelow);
            sel.offsetTopAndBottom(-offset);
        } //End block
        else
        if(sel.getTop() < topSelectionPixel)        
        {
            final int spaceAbove = topSelectionPixel - sel.getTop();
            final int spaceBelow = bottomSelectionPixel - sel.getBottom();
            final int offset = Math.min(spaceAbove, spaceBelow);
            sel.offsetTopAndBottom(offset);
        } //End block
        fillAboveAndBelow(sel, selectedPosition);
        if(!mStackFromBottom)        
        {
            correctTooHigh(getChildCount());
        } //End block
        else
        {
            correctTooLow(getChildCount());
        } //End block
View var7B839F21D0245BE275F8017F44DD4441_105294303 =         sel;
        var7B839F21D0245BE275F8017F44DD4441_105294303.addTaint(taint);
        return var7B839F21D0245BE275F8017F44DD4441_105294303;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.809 -0400", hash_original_method = "DDE472821830C07DE1368C905BA02EE1", hash_generated_method = "77469CF66D365F755D9690EAC3342076")
    private int getBottomSelectionPixel(int childrenBottom, int fadingEdgeLength,
            int selectedPosition) {
        addTaint(selectedPosition);
        addTaint(fadingEdgeLength);
        addTaint(childrenBottom);
        int bottomSelectionPixel = childrenBottom;
        if(selectedPosition != mItemCount - 1)        
        {
            bottomSelectionPixel -= fadingEdgeLength;
        } //End block
        int var8C1BAEE08BF7BBE553C84235F7A5E3D8_1592961234 = (bottomSelectionPixel);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261453350 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261453350;
        // ---------- Original Method ----------
        //int bottomSelectionPixel = childrenBottom;
        //if (selectedPosition != mItemCount - 1) {
            //bottomSelectionPixel -= fadingEdgeLength;
        //}
        //return bottomSelectionPixel;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.810 -0400", hash_original_method = "173BB2BFF18272B67A930A02164FEB0F", hash_generated_method = "4A3F0DF102140F428B559D0139602AC0")
    private int getTopSelectionPixel(int childrenTop, int fadingEdgeLength, int selectedPosition) {
        addTaint(selectedPosition);
        addTaint(fadingEdgeLength);
        addTaint(childrenTop);
        int topSelectionPixel = childrenTop;
        if(selectedPosition > 0)        
        {
            topSelectionPixel += fadingEdgeLength;
        } //End block
        int var9B1B38FE46FCA5DD3FBB400FF9DA31B9_1389161176 = (topSelectionPixel);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534864062 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534864062;
        // ---------- Original Method ----------
        //int topSelectionPixel = childrenTop;
        //if (selectedPosition > 0) {
            //topSelectionPixel += fadingEdgeLength;
        //}
        //return topSelectionPixel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.810 -0400", hash_original_method = "19B54E9E42F50C19B80602093C26BC32", hash_generated_method = "13D89CD9CDD5D76B097C78A9C6F471D8")
    @android.view.RemotableViewMethod
    public void smoothScrollToPosition(int position) {
        addTaint(position);
        super.smoothScrollToPosition(position);
        // ---------- Original Method ----------
        //super.smoothScrollToPosition(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.810 -0400", hash_original_method = "9A2E566018459C8A4F9FE2F49DBB98B8", hash_generated_method = "3F9C88E5F8435EC02B22E53B890AC667")
    @android.view.RemotableViewMethod
    public void smoothScrollByOffset(int offset) {
        addTaint(offset);
        super.smoothScrollByOffset(offset);
        // ---------- Original Method ----------
        //super.smoothScrollByOffset(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.811 -0400", hash_original_method = "A6BE2578E6D412634113B39CFD73986F", hash_generated_method = "443DBDED6FD9DB0E95618400D85F9119")
    private View moveSelection(View oldSel, View newSel, int delta, int childrenTop,
            int childrenBottom) {
        addTaint(childrenBottom);
        addTaint(childrenTop);
        addTaint(delta);
        addTaint(newSel.getTaint());
        addTaint(oldSel.getTaint());
        int fadingEdgeLength = getVerticalFadingEdgeLength();
        final int selectedPosition = mSelectedPosition;
        View sel;
        final int topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength,
                selectedPosition);
        final int bottomSelectionPixel = getBottomSelectionPixel(childrenTop, fadingEdgeLength,
                selectedPosition);
        if(delta > 0)        
        {
            oldSel = makeAndAddView(selectedPosition - 1, oldSel.getTop(), true,
                    mListPadding.left, false);
            final int dividerHeight = mDividerHeight;
            sel = makeAndAddView(selectedPosition, oldSel.getBottom() + dividerHeight, true,
                    mListPadding.left, true);
            if(sel.getBottom() > bottomSelectionPixel)            
            {
                int spaceAbove = sel.getTop() - topSelectionPixel;
                int spaceBelow = sel.getBottom() - bottomSelectionPixel;
                int halfVerticalSpace = (childrenBottom - childrenTop) / 2;
                int offset = Math.min(spaceAbove, spaceBelow);
                offset = Math.min(offset, halfVerticalSpace);
                oldSel.offsetTopAndBottom(-offset);
                sel.offsetTopAndBottom(-offset);
            } //End block
            if(!mStackFromBottom)            
            {
                fillUp(mSelectedPosition - 2, sel.getTop() - dividerHeight);
                adjustViewsUpOrDown();
                fillDown(mSelectedPosition + 1, sel.getBottom() + dividerHeight);
            } //End block
            else
            {
                fillDown(mSelectedPosition + 1, sel.getBottom() + dividerHeight);
                adjustViewsUpOrDown();
                fillUp(mSelectedPosition - 2, sel.getTop() - dividerHeight);
            } //End block
        } //End block
        else
        if(delta < 0)        
        {
            if(newSel != null)            
            {
                sel = makeAndAddView(selectedPosition, newSel.getTop(), true, mListPadding.left,
                        true);
            } //End block
            else
            {
                sel = makeAndAddView(selectedPosition, oldSel.getTop(), false, mListPadding.left,
                        true);
            } //End block
            if(sel.getTop() < topSelectionPixel)            
            {
                int spaceAbove = topSelectionPixel - sel.getTop();
                int spaceBelow = bottomSelectionPixel - sel.getBottom();
                int halfVerticalSpace = (childrenBottom - childrenTop) / 2;
                int offset = Math.min(spaceAbove, spaceBelow);
                offset = Math.min(offset, halfVerticalSpace);
                sel.offsetTopAndBottom(offset);
            } //End block
            fillAboveAndBelow(sel, selectedPosition);
        } //End block
        else
        {
            int oldTop = oldSel.getTop();
            sel = makeAndAddView(selectedPosition, oldTop, true, mListPadding.left, true);
            if(oldTop < childrenTop)            
            {
                int newBottom = sel.getBottom();
                if(newBottom < childrenTop + 20)                
                {
                    sel.offsetTopAndBottom(childrenTop - sel.getTop());
                } //End block
            } //End block
            fillAboveAndBelow(sel, selectedPosition);
        } //End block
View var7B839F21D0245BE275F8017F44DD4441_2105560574 =         sel;
        var7B839F21D0245BE275F8017F44DD4441_2105560574.addTaint(taint);
        return var7B839F21D0245BE275F8017F44DD4441_2105560574;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.813 -0400", hash_original_method = "593EBCA8FD80357C209889704061F804", hash_generated_method = "B8DA920440FA5BB861F180564A15F2CF")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int childWidth = 0;
        int childHeight = 0;
        int childState = 0;
        mItemCount = mAdapter == null ? 0 : mAdapter.getCount();
        if(mItemCount > 0 && (widthMode == MeasureSpec.UNSPECIFIED ||
                heightMode == MeasureSpec.UNSPECIFIED))        
        {
            final View child = obtainView(0, mIsScrap);
            measureScrapChild(child, 0, widthMeasureSpec);
            childWidth = child.getMeasuredWidth();
            childHeight = child.getMeasuredHeight();
            childState = combineMeasuredStates(childState, child.getMeasuredState());
            if(recycleOnMeasure() && mRecycler.shouldRecycleViewType(
                    ((LayoutParams) child.getLayoutParams()).viewType))            
            {
                mRecycler.addScrapView(child, -1);
            } //End block
        } //End block
        if(widthMode == MeasureSpec.UNSPECIFIED)        
        {
            widthSize = mListPadding.left + mListPadding.right + childWidth +
                    getVerticalScrollbarWidth();
        } //End block
        else
        {
            widthSize |= (childState&MEASURED_STATE_MASK);
        } //End block
        if(heightMode == MeasureSpec.UNSPECIFIED)        
        {
            heightSize = mListPadding.top + mListPadding.bottom + childHeight +
                    getVerticalFadingEdgeLength() * 2;
        } //End block
        if(heightMode == MeasureSpec.AT_MOST)        
        {
            heightSize = measureHeightOfChildren(widthMeasureSpec, 0, NO_POSITION, heightSize, -1);
        } //End block
        setMeasuredDimension(widthSize , heightSize);
        mWidthMeasureSpec = widthMeasureSpec;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.813 -0400", hash_original_method = "F21C4EE74005F045F306FF7685001DDA", hash_generated_method = "3C0EE008E1D73146D8628C5B4D2DE17F")
    private void measureScrapChild(View child, int position, int widthMeasureSpec) {
        addTaint(widthMeasureSpec);
        addTaint(position);
        addTaint(child.getTaint());
        LayoutParams p = (LayoutParams) child.getLayoutParams();
        if(p == null)        
        {
            p = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0);
            child.setLayoutParams(p);
        } //End block
        p.viewType = mAdapter.getItemViewType(position);
        p.forceAdd = true;
        int childWidthSpec = ViewGroup.getChildMeasureSpec(widthMeasureSpec,
                mListPadding.left + mListPadding.right, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        if(lpHeight > 0)        
        {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
        } //End block
        else
        {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        } //End block
        child.measure(childWidthSpec, childHeightSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.814 -0400", hash_original_method = "8F0B08D4426D8F4F23EF014B56CDCFE6", hash_generated_method = "CE7526583AB1C45144C0995D1CC723A0")
    @ViewDebug.ExportedProperty(category = "list")
    protected boolean recycleOnMeasure() {
        boolean varB326B5062B2F0E69046810717534CB09_1930166749 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2005669108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2005669108;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.815 -0400", hash_original_method = "4E8DF0CF85AB0B6CF8E1C94B60E67D20", hash_generated_method = "BF739C65212130D83776F2F07EAAA2E3")
    final int measureHeightOfChildren(int widthMeasureSpec, int startPosition, int endPosition,
            final int maxHeight, int disallowPartialChildPosition) {
        addTaint(disallowPartialChildPosition);
        addTaint(maxHeight);
        addTaint(endPosition);
        addTaint(startPosition);
        addTaint(widthMeasureSpec);
        final ListAdapter adapter = mAdapter;
        if(adapter == null)        
        {
            int varC3F9E15EFF6DDCC872EC948A3E70A2FD_1000537843 = (mListPadding.top + mListPadding.bottom);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1366966203 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1366966203;
        } //End block
        int returnedHeight = mListPadding.top + mListPadding.bottom;
        final int dividerHeight = ((mDividerHeight > 0) && mDivider != null) ? mDividerHeight : 0;
        int prevHeightWithoutPartialChild = 0;
        int i;
        View child;
        endPosition = (endPosition == NO_POSITION) ? adapter.getCount() - 1 : endPosition;
        final AbsListView.RecycleBin recycleBin = mRecycler;
        final boolean recyle = recycleOnMeasure();
        final boolean[] isScrap = mIsScrap;
for(i = startPosition;i <= endPosition;++i)
        {
            child = obtainView(i, isScrap);
            measureScrapChild(child, i, widthMeasureSpec);
            if(i > 0)            
            {
                returnedHeight += dividerHeight;
            } //End block
            if(recyle && recycleBin.shouldRecycleViewType(
                    ((LayoutParams) child.getLayoutParams()).viewType))            
            {
                recycleBin.addScrapView(child, -1);
            } //End block
            returnedHeight += child.getMeasuredHeight();
            if(returnedHeight >= maxHeight)            
            {
                int var3BBA0C6F2D07B89EE65DE483F50451B5_1917871500 = ((disallowPartialChildPosition >= 0) 
                            && (i > disallowPartialChildPosition) 
                            && (prevHeightWithoutPartialChild > 0) 
                            && (returnedHeight != maxHeight) 
                        ? prevHeightWithoutPartialChild
                        : maxHeight);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352005626 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352005626;
            } //End block
            if((disallowPartialChildPosition >= 0) && (i >= disallowPartialChildPosition))            
            {
                prevHeightWithoutPartialChild = returnedHeight;
            } //End block
        } //End block
        int var78DD425B2CF1217B45AA8B8C89F126CC_577685184 = (returnedHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1588389094 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1588389094;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @Override
	int findMotionRow(int y) {
		// TODO Auto-generated method stub
		return 0;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.816 -0400", hash_original_method = "C0E9548D6FEBBB39DCAB5DD502EC06AD", hash_generated_method = "8D343E9E6B47B935DDC53FE78557B23C")
    private View fillSpecific(int position, int top) {
        addTaint(top);
        addTaint(position);
        boolean tempIsSelected = position == mSelectedPosition;
        View temp = makeAndAddView(position, top, true, mListPadding.left, tempIsSelected);
        mFirstPosition = position;
        View above;
        View below;
        final int dividerHeight = mDividerHeight;
        if(!mStackFromBottom)        
        {
            above = fillUp(position - 1, temp.getTop() - dividerHeight);
            adjustViewsUpOrDown();
            below = fillDown(position + 1, temp.getBottom() + dividerHeight);
            int childCount = getChildCount();
            if(childCount > 0)            
            {
                correctTooHigh(childCount);
            } //End block
        } //End block
        else
        {
            below = fillDown(position + 1, temp.getBottom() + dividerHeight);
            adjustViewsUpOrDown();
            above = fillUp(position - 1, temp.getTop() - dividerHeight);
            int childCount = getChildCount();
            if(childCount > 0)            
            {
                correctTooLow(childCount);
            } //End block
        } //End block
        if(tempIsSelected)        
        {
View var85AF0530723FAED0F9065F029B9D6041_1157617292 =             temp;
            var85AF0530723FAED0F9065F029B9D6041_1157617292.addTaint(taint);
            return var85AF0530723FAED0F9065F029B9D6041_1157617292;
        } //End block
        else
        if(above != null)        
        {
View varCD3155DFCED4EB61161BED1FF630FDBA_868033904 =             above;
            varCD3155DFCED4EB61161BED1FF630FDBA_868033904.addTaint(taint);
            return varCD3155DFCED4EB61161BED1FF630FDBA_868033904;
        } //End block
        else
        {
View var2F0E8DD6CEEAC90C0D2F6260FE322E29_1566154336 =             below;
            var2F0E8DD6CEEAC90C0D2F6260FE322E29_1566154336.addTaint(taint);
            return var2F0E8DD6CEEAC90C0D2F6260FE322E29_1566154336;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.822 -0400", hash_original_method = "C65533A90B04CD548C8B98EAAB2119A6", hash_generated_method = "20688108FB0B1FFEC7FB217E2924D328")
    private void correctTooHigh(int childCount) {
        addTaint(childCount);
        int lastPosition = mFirstPosition + childCount - 1;
        if(lastPosition == mItemCount - 1 && childCount > 0)        
        {
            final View lastChild = getChildAt(childCount - 1);
            final int lastBottom = lastChild.getBottom();
            final int end = (mBottom - mTop) - mListPadding.bottom;
            int bottomOffset = end - lastBottom;
            View firstChild = getChildAt(0);
            final int firstTop = firstChild.getTop();
            if(bottomOffset > 0 && (mFirstPosition > 0 || firstTop < mListPadding.top))            
            {
                if(mFirstPosition == 0)                
                {
                    bottomOffset = Math.min(bottomOffset, mListPadding.top - firstTop);
                } //End block
                offsetChildrenTopAndBottom(bottomOffset);
                if(mFirstPosition > 0)                
                {
                    fillUp(mFirstPosition - 1, firstChild.getTop() - mDividerHeight);
                    adjustViewsUpOrDown();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.825 -0400", hash_original_method = "D798F76D04F235C59E38C4C924A6B5C2", hash_generated_method = "DA36E94E6AF9C9A080E9724738B4AC9D")
    private void correctTooLow(int childCount) {
        addTaint(childCount);
        if(mFirstPosition == 0 && childCount > 0)        
        {
            final View firstChild = getChildAt(0);
            final int firstTop = firstChild.getTop();
            final int start = mListPadding.top;
            final int end = (mBottom - mTop) - mListPadding.bottom;
            int topOffset = firstTop - start;
            View lastChild = getChildAt(childCount - 1);
            final int lastBottom = lastChild.getBottom();
            int lastPosition = mFirstPosition + childCount - 1;
            if(topOffset > 0)            
            {
                if(lastPosition < mItemCount - 1 || lastBottom > end)                
                {
                    if(lastPosition == mItemCount - 1)                    
                    {
                        topOffset = Math.min(topOffset, lastBottom - end);
                    } //End block
                    offsetChildrenTopAndBottom(-topOffset);
                    if(lastPosition < mItemCount - 1)                    
                    {
                        fillDown(lastPosition + 1, lastChild.getBottom() + mDividerHeight);
                        adjustViewsUpOrDown();
                    } //End block
                } //End block
                else
                if(lastPosition == mItemCount - 1)                
                {
                    adjustViewsUpOrDown();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.827 -0400", hash_original_method = "9877500E639FE4AE4AB75D2F74BF2E4E", hash_generated_method = "D1161EFC7C77C29FD6FA22D62BD5C4E3")
    @Override
    protected void layoutChildren() {
        final boolean blockLayoutRequests = mBlockLayoutRequests;
        if(!blockLayoutRequests)        
        {
            mBlockLayoutRequests = true;
        } //End block
        else
        {
            return;
        } //End block
        try 
        {
            super.layoutChildren();
            invalidate();
            if(mAdapter == null)            
            {
                resetList();
                invokeOnItemScrollListener();
                return;
            } //End block
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
switch(mLayoutMode){
            case LAYOUT_SET_SELECTION:
            index = mNextSelectedPosition - mFirstPosition;
            if(index >= 0 && index < childCount)            
            {
                newSel = getChildAt(index);
            } //End block
            break;
            case LAYOUT_FORCE_TOP:
            case LAYOUT_FORCE_BOTTOM:
            case LAYOUT_SPECIFIC:
            case LAYOUT_SYNC:
            break;
            case LAYOUT_MOVE_SELECTION:
            default:
            index = mSelectedPosition - mFirstPosition;
            if(index >= 0 && index < childCount)            
            {
                oldSel = getChildAt(index);
            } //End block
            oldFirst = getChildAt(0);
            if(mNextSelectedPosition >= 0)            
            {
                delta = mNextSelectedPosition - mSelectedPosition;
            } //End block
            newSel = getChildAt(index + delta);
}            boolean dataChanged = mDataChanged;
            if(dataChanged)            
            {
                handleDataChanged();
            } //End block
            if(mItemCount == 0)            
            {
                resetList();
                invokeOnItemScrollListener();
                return;
            } //End block
            else
            if(mItemCount != mAdapter.getCount())            
            {
                IllegalStateException var40705235D1AA60EA3FEFE3C7B451A3CF_728378442 = new IllegalStateException("The content of the adapter has changed but "
                        + "ListView did not receive a notification. Make sure the content of "
                        + "your adapter is not modified from a background thread, but only "
                        + "from the UI thread. [in ListView(" + getId() + ", " + getClass() 
                        + ") with Adapter(" + mAdapter.getClass() + ")]");
                var40705235D1AA60EA3FEFE3C7B451A3CF_728378442.addTaint(taint);
                throw var40705235D1AA60EA3FEFE3C7B451A3CF_728378442;
            } //End block
            setSelectedPositionInt(mNextSelectedPosition);
            final int firstPosition = mFirstPosition;
            final RecycleBin recycleBin = mRecycler;
            View focusLayoutRestoreDirectChild = null;
            if(dataChanged)            
            {
for(int i = 0;i < childCount;i++)
                {
                    recycleBin.addScrapView(getChildAt(i), firstPosition+i);
                    if(ViewDebug.TRACE_RECYCLER)                    
                    {
                        ViewDebug.trace(getChildAt(i),
                                ViewDebug.RecyclerTraceType.MOVE_TO_SCRAP_HEAP, index, i);
                    } //End block
                } //End block
            } //End block
            else
            {
                recycleBin.fillActiveViews(childCount, firstPosition);
            } //End block
            final View focusedChild = getFocusedChild();
            if(focusedChild != null)            
            {
                if(!dataChanged || isDirectChildHeaderOrFooter(focusedChild))                
                {
                    focusLayoutRestoreDirectChild = focusedChild;
                    focusLayoutRestoreView = findFocus();
                    if(focusLayoutRestoreView != null)                    
                    {
                        focusLayoutRestoreView.onStartTemporaryDetach();
                    } //End block
                } //End block
                requestFocus();
            } //End block
            detachAllViewsFromParent();
switch(mLayoutMode){
            case LAYOUT_SET_SELECTION:
            if(newSel != null)            
            {
                sel = fillFromSelection(newSel.getTop(), childrenTop, childrenBottom);
            } //End block
            else
            {
                sel = fillFromMiddle(childrenTop, childrenBottom);
            } //End block
            break;
            case LAYOUT_SYNC:
            sel = fillSpecific(mSyncPosition, mSpecificTop);
            break;
            case LAYOUT_FORCE_BOTTOM:
            sel = fillUp(mItemCount - 1, childrenBottom);
            adjustViewsUpOrDown();
            break;
            case LAYOUT_FORCE_TOP:
            mFirstPosition = 0;
            sel = fillFromTop(childrenTop);
            adjustViewsUpOrDown();
            break;
            case LAYOUT_SPECIFIC:
            sel = fillSpecific(reconcileSelectedPosition(), mSpecificTop);
            break;
            case LAYOUT_MOVE_SELECTION:
            sel = moveSelection(oldSel, newSel, delta, childrenTop, childrenBottom);
            break;
            default:
            if(childCount == 0)            
            {
                if(!mStackFromBottom)                
                {
                    final int position = lookForSelectablePosition(0, true);
                    setSelectedPositionInt(position);
                    sel = fillFromTop(childrenTop);
                } //End block
                else
                {
                    final int position = lookForSelectablePosition(mItemCount - 1, false);
                    setSelectedPositionInt(position);
                    sel = fillUp(mItemCount - 1, childrenBottom);
                } //End block
            } //End block
            else
            {
                if(mSelectedPosition >= 0 && mSelectedPosition < mItemCount)                
                {
                    sel = fillSpecific(mSelectedPosition,
                                oldSel == null ? childrenTop : oldSel.getTop());
                } //End block
                else
                if(mFirstPosition < mItemCount)                
                {
                    sel = fillSpecific(mFirstPosition,
                                oldFirst == null ? childrenTop : oldFirst.getTop());
                } //End block
                else
                {
                    sel = fillSpecific(0, childrenTop);
                } //End block
            } //End block
            break;
}            recycleBin.scrapActiveViews();
            if(sel != null)            
            {
                if(mItemsCanFocus && hasFocus() && !sel.hasFocus())                
                {
                    final boolean focusWasTaken = (sel == focusLayoutRestoreDirectChild &&
                            focusLayoutRestoreView.requestFocus()) || sel.requestFocus();
                    if(!focusWasTaken)                    
                    {
                        final View focused = getFocusedChild();
                        if(focused != null)                        
                        {
                            focused.clearFocus();
                        } //End block
                        positionSelector(INVALID_POSITION, sel);
                    } //End block
                    else
                    {
                        sel.setSelected(false);
                        mSelectorRect.setEmpty();
                    } //End block
                } //End block
                else
                {
                    positionSelector(INVALID_POSITION, sel);
                } //End block
                mSelectedTop = sel.getTop();
            } //End block
            else
            {
                if(mTouchMode > TOUCH_MODE_DOWN && mTouchMode < TOUCH_MODE_SCROLL)                
                {
                    View child = getChildAt(mMotionPosition - mFirstPosition);
                    if(child != null)                    
                    positionSelector(mMotionPosition, child);
                } //End block
                else
                {
                    mSelectedTop = 0;
                    mSelectorRect.setEmpty();
                } //End block
                if(hasFocus() && focusLayoutRestoreView != null)                
                {
                    focusLayoutRestoreView.requestFocus();
                } //End block
            } //End block
            if(focusLayoutRestoreView != null
                    && focusLayoutRestoreView.getWindowToken() != null)            
            {
                focusLayoutRestoreView.onFinishTemporaryDetach();
            } //End block
            mLayoutMode = LAYOUT_NORMAL;
            mDataChanged = false;
            mNeedSync = false;
            setNextSelectedPositionInt(mSelectedPosition);
            updateScrollIndicators();
            if(mItemCount > 0)            
            {
                checkSelectionChanged();
            } //End block
            invokeOnItemScrollListener();
        } //End block
        finally 
        {
            if(!blockLayoutRequests)            
            {
                mBlockLayoutRequests = false;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.857 -0400", hash_original_method = "1975AA11D0AB4A92B498BEF09326AA69", hash_generated_method = "52018862E4166761BBAEEDB486BD607D")
    private boolean isDirectChildHeaderOrFooter(View child) {
        addTaint(child.getTaint());
        final ArrayList<FixedViewInfo> headers = mHeaderViewInfos;
        final int numHeaders = headers.size();
for(int i = 0;i < numHeaders;i++)
        {
            if(child == headers.get(i).view)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_4614366 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1125575195 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1125575195;
            } //End block
        } //End block
        final ArrayList<FixedViewInfo> footers = mFooterViewInfos;
        final int numFooters = footers.size();
for(int i = 0;i < numFooters;i++)
        {
            if(child == footers.get(i).view)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_813158149 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_634132138 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_634132138;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1899594566 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1683448197 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1683448197;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.858 -0400", hash_original_method = "EAF848DCFCD435D3CED323F008D83518", hash_generated_method = "FE4E1728E0281E159FBCB870A472B92E")
    private View makeAndAddView(int position, int y, boolean flow, int childrenLeft,
            boolean selected) {
        addTaint(selected);
        addTaint(childrenLeft);
        addTaint(flow);
        addTaint(y);
        addTaint(position);
        View child;
        if(!mDataChanged)        
        {
            child = mRecycler.getActiveView(position);
            if(child != null)            
            {
                if(ViewDebug.TRACE_RECYCLER)                
                {
                    ViewDebug.trace(child, ViewDebug.RecyclerTraceType.RECYCLE_FROM_ACTIVE_HEAP,
                            position, getChildCount());
                } //End block
                setupChild(child, position, y, flow, childrenLeft, selected, true);
View var73902FD3E151130B4329B76EF04D2A54_1212448112 =                 child;
                var73902FD3E151130B4329B76EF04D2A54_1212448112.addTaint(taint);
                return var73902FD3E151130B4329B76EF04D2A54_1212448112;
            } //End block
        } //End block
        child = obtainView(position, mIsScrap);
        setupChild(child, position, y, flow, childrenLeft, selected, mIsScrap[0]);
View var73902FD3E151130B4329B76EF04D2A54_353880466 =         child;
        var73902FD3E151130B4329B76EF04D2A54_353880466.addTaint(taint);
        return var73902FD3E151130B4329B76EF04D2A54_353880466;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.860 -0400", hash_original_method = "06B6C56B5992091F7319E58A5C4AE35A", hash_generated_method = "60C1F803415A37BE3DE69EB30DC7959E")
    private void setupChild(View child, int position, int y, boolean flowDown, int childrenLeft,
            boolean selected, boolean recycled) {
        addTaint(recycled);
        addTaint(selected);
        addTaint(childrenLeft);
        addTaint(flowDown);
        addTaint(y);
        addTaint(position);
        addTaint(child.getTaint());
        final boolean isSelected = selected && shouldShowSelector();
        final boolean updateChildSelected = isSelected != child.isSelected();
        final int mode = mTouchMode;
        final boolean isPressed = mode > TOUCH_MODE_DOWN && mode < TOUCH_MODE_SCROLL &&
                mMotionPosition == position;
        final boolean updateChildPressed = isPressed != child.isPressed();
        final boolean needToMeasure = !recycled || updateChildSelected || child.isLayoutRequested();
        AbsListView.LayoutParams p = (AbsListView.LayoutParams) child.getLayoutParams();
        if(p == null)        
        {
            p = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0);
        } //End block
        p.viewType = mAdapter.getItemViewType(position);
        if((recycled && !p.forceAdd) || (p.recycledHeaderFooter &&
                p.viewType == AdapterView.ITEM_VIEW_TYPE_HEADER_OR_FOOTER))        
        {
            attachViewToParent(child, flowDown ? -1 : 0, p);
        } //End block
        else
        {
            p.forceAdd = false;
            if(p.viewType == AdapterView.ITEM_VIEW_TYPE_HEADER_OR_FOOTER)            
            {
                p.recycledHeaderFooter = true;
            } //End block
            addViewInLayout(child, flowDown ? -1 : 0, p, true);
        } //End block
        if(updateChildSelected)        
        {
            child.setSelected(isSelected);
        } //End block
        if(updateChildPressed)        
        {
            child.setPressed(isPressed);
        } //End block
        if(mChoiceMode != CHOICE_MODE_NONE && mCheckStates != null)        
        {
            if(child instanceof Checkable)            
            {
                ((Checkable) child).setChecked(mCheckStates.get(position));
            } //End block
            else
            if(getContext().getApplicationInfo().targetSdkVersion
                    >= android.os.Build.VERSION_CODES.HONEYCOMB)            
            {
                child.setActivated(mCheckStates.get(position));
            } //End block
        } //End block
        if(needToMeasure)        
        {
            int childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                    mListPadding.left + mListPadding.right, p.width);
            int lpHeight = p.height;
            int childHeightSpec;
            if(lpHeight > 0)            
            {
                childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
            } //End block
            else
            {
                childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            } //End block
            child.measure(childWidthSpec, childHeightSpec);
        } //End block
        else
        {
            cleanupLayoutState(child);
        } //End block
        final int w = child.getMeasuredWidth();
        final int h = child.getMeasuredHeight();
        final int childTop = flowDown ? y : y - h;
        if(needToMeasure)        
        {
            final int childRight = childrenLeft + w;
            final int childBottom = childTop + h;
            child.layout(childrenLeft, childTop, childRight, childBottom);
        } //End block
        else
        {
            child.offsetLeftAndRight(childrenLeft - child.getLeft());
            child.offsetTopAndBottom(childTop - child.getTop());
        } //End block
        if(mCachingStarted && !child.isDrawingCacheEnabled())        
        {
            child.setDrawingCacheEnabled(true);
        } //End block
        if(recycled && (((AbsListView.LayoutParams)child.getLayoutParams()).scrappedFromPosition)
                != position)        
        {
            child.jumpDrawablesToCurrentState();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.861 -0400", hash_original_method = "F40AC428F4D570BD34339564A5B5BB04", hash_generated_method = "AD162E0C0446DDE51F84A5A8E5920B51")
    @Override
    protected boolean canAnimate() {
        boolean varF7CAFEF190EA84220A90E3FE54FABF95_595723815 = (super.canAnimate() && mItemCount > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_155371920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_155371920;
        // ---------- Original Method ----------
        //return super.canAnimate() && mItemCount > 0;
    }

    
    @Override
	public void setSelection(int position) {
		// TODO Auto-generated method stub
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.862 -0400", hash_original_method = "04FF3361CA0379851E7CD86AE0D8A950", hash_generated_method = "62489A60A8A82CB9C780468B58560FC2")
    public void setSelectionFromTop(int position, int y) {
        addTaint(y);
        addTaint(position);
        if(mAdapter == null)        
        {
            return;
        } //End block
        if(!isInTouchMode())        
        {
            position = lookForSelectablePosition(position, true);
            if(position >= 0)            
            {
                setNextSelectedPositionInt(position);
            } //End block
        } //End block
        else
        {
            mResurrectToPosition = position;
        } //End block
        if(position >= 0)        
        {
            mLayoutMode = LAYOUT_SPECIFIC;
            mSpecificTop = mListPadding.top + y;
            if(mNeedSync)            
            {
                mSyncPosition = position;
                mSyncRowId = mAdapter.getItemId(position);
            } //End block
            requestLayout();
        } //End block
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

    
    @Override
	void setSelectionInt(int position) {
		// TODO Auto-generated method stub
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.863 -0400", hash_original_method = "F611253C286EB5F8129DFD60BE22D44F", hash_generated_method = "324E0D58C0FE20FC3609B2FEA3AC7D87")
    @Override
     int lookForSelectablePosition(int position, boolean lookDown) {
        addTaint(lookDown);
        addTaint(position);
        final ListAdapter adapter = mAdapter;
        if(adapter == null || isInTouchMode())        
        {
            int var296D6C732A05FBA51C5854FA7933FE23_1033080173 = (INVALID_POSITION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076932696 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076932696;
        } //End block
        final int count = adapter.getCount();
        if(!mAreAllItemsSelectable)        
        {
            if(lookDown)            
            {
                position = Math.max(0, position);
                while
(position < count && !adapter.isEnabled(position))                
                {
                    position++;
                } //End block
            } //End block
            else
            {
                position = Math.min(position, count - 1);
                while
(position >= 0 && !adapter.isEnabled(position))                
                {
                    position--;
                } //End block
            } //End block
            if(position < 0 || position >= count)            
            {
                int var296D6C732A05FBA51C5854FA7933FE23_1963683827 = (INVALID_POSITION);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_971720532 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_971720532;
            } //End block
            int var4757FE07FD492A8BE0EA6A760D683D6E_171438600 = (position);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_318851571 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_318851571;
        } //End block
        else
        {
            if(position < 0 || position >= count)            
            {
                int var296D6C732A05FBA51C5854FA7933FE23_601866712 = (INVALID_POSITION);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208178690 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208178690;
            } //End block
            int var4757FE07FD492A8BE0EA6A760D683D6E_269270694 = (position);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_892463083 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_892463083;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.863 -0400", hash_original_method = "BA94B118F7B33B042A8A5EE913A2CAC9", hash_generated_method = "51DF4E2DEA64FF3CE0B20552D5CBA167")
    public void setSelectionAfterHeaderView() {
        final int count = mHeaderViewInfos.size();
        if(count > 0)        
        {
            mNextSelectedPosition = 0;
            return;
        } //End block
        if(mAdapter != null)        
        {
            setSelection(count);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.864 -0400", hash_original_method = "C6695FE09C5666FBD7C0ECDD7FFCA6CE", hash_generated_method = "27C90FFF6BAC9BA205B199CE889DD4F4")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        boolean handled = super.dispatchKeyEvent(event);
        if(!handled)        
        {
            View focused = getFocusedChild();
            if(focused != null && event.getAction() == KeyEvent.ACTION_DOWN)            
            {
                handled = onKeyDown(event.getKeyCode(), event);
            } //End block
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_940632953 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1775863795 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1775863795;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.864 -0400", hash_original_method = "82498D99AFEB0700B1F959E9E9927B59", hash_generated_method = "F773CE9CFF4AEE2B65C80A2EC383B2CB")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var7EF652CB3ACE03C95ABA8817CA740A6C_174839297 = (commonKey(keyCode, 1, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_296965626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_296965626;
        // ---------- Original Method ----------
        //return commonKey(keyCode, 1, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.864 -0400", hash_original_method = "C105EC1B6481173F2A66D1C47882507B", hash_generated_method = "54B0AC7A784C5724E6559263B059C0F6")
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(repeatCount);
        addTaint(keyCode);
        boolean var7E22E05ED0529C3D32A81C1D21110D89_1296547045 = (commonKey(keyCode, repeatCount, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_339016472 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_339016472;
        // ---------- Original Method ----------
        //return commonKey(keyCode, repeatCount, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.865 -0400", hash_original_method = "FFB4A1626C41573790F9B17FF23F8A09", hash_generated_method = "CA10489C764F918FE322FB726CF73385")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var7EF652CB3ACE03C95ABA8817CA740A6C_1506042844 = (commonKey(keyCode, 1, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_439465084 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_439465084;
        // ---------- Original Method ----------
        //return commonKey(keyCode, 1, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.866 -0400", hash_original_method = "1DD47D400FE7B21B7ADCD2D234FB64A7", hash_generated_method = "AC53DCB86587197E0C0C7C9360160BE6")
    private boolean commonKey(int keyCode, int count, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(count);
        addTaint(keyCode);
        if(mAdapter == null || !mIsAttached)        
        {
            boolean var68934A3E9455FA72420237EB05902327_538397661 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_431450383 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_431450383;
        } //End block
        if(mDataChanged)        
        {
            layoutChildren();
        } //End block
        boolean handled = false;
        int action = event.getAction();
        if(action != KeyEvent.ACTION_UP)        
        {
switch(keyCode){
            case KeyEvent.KEYCODE_DPAD_UP:
            if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded();
                if(!handled)                
                {
                    while
(count-- > 0)                    
                    {
                        if(arrowScroll(FOCUS_UP))                        
                        {
                            handled = true;
                        } //End block
                        else
                        {
                            break;
                        } //End block
                    } //End block
                } //End block
            } //End block
            else
            if(event.hasModifiers(KeyEvent.META_ALT_ON))            
            {
                handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
            } //End block
            break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
            if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded();
                if(!handled)                
                {
                    while
(count-- > 0)                    
                    {
                        if(arrowScroll(FOCUS_DOWN))                        
                        {
                            handled = true;
                        } //End block
                        else
                        {
                            break;
                        } //End block
                    } //End block
                } //End block
            } //End block
            else
            if(event.hasModifiers(KeyEvent.META_ALT_ON))            
            {
                handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
            } //End block
            break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
            if(event.hasNoModifiers())            
            {
                handled = handleHorizontalFocusWithinListItem(View.FOCUS_LEFT);
            } //End block
            break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            if(event.hasNoModifiers())            
            {
                handled = handleHorizontalFocusWithinListItem(View.FOCUS_RIGHT);
            } //End block
            break;
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_ENTER:
            if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded();
                if(!handled
                            && event.getRepeatCount() == 0 && getChildCount() > 0)                
                {
                    keyPressed();
                    handled = true;
                } //End block
            } //End block
            break;
            case KeyEvent.KEYCODE_SPACE:
            if(mPopup == null || !mPopup.isShowing())            
            {
                if(event.hasNoModifiers())                
                {
                    handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_DOWN);
                } //End block
                else
                if(event.hasModifiers(KeyEvent.META_SHIFT_ON))                
                {
                    handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_UP);
                } //End block
                handled = true;
            } //End block
            break;
            case KeyEvent.KEYCODE_PAGE_UP:
            if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_UP);
            } //End block
            else
            if(event.hasModifiers(KeyEvent.META_ALT_ON))            
            {
                handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
            } //End block
            break;
            case KeyEvent.KEYCODE_PAGE_DOWN:
            if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_DOWN);
            } //End block
            else
            if(event.hasModifiers(KeyEvent.META_ALT_ON))            
            {
                handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
            } //End block
            break;
            case KeyEvent.KEYCODE_MOVE_HOME:
            if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
            } //End block
            break;
            case KeyEvent.KEYCODE_MOVE_END:
            if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
            } //End block
            break;
            case KeyEvent.KEYCODE_TAB:
            if(false)            
            {
                if(event.hasNoModifiers())                
                {
                    handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_DOWN);
                } //End block
                else
                if(event.hasModifiers(KeyEvent.META_SHIFT_ON))                
                {
                    handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_UP);
                } //End block
            } //End block
            break;
}
        } //End block
        if(handled)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_783741542 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_533972500 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_533972500;
        } //End block
        if(sendToTextFilter(keyCode, count, event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1213454676 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1489722874 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1489722874;
        } //End block
switch(action){
        case KeyEvent.ACTION_DOWN:
        boolean var947F0C250323B9F4475E02588E9A9740_604611783 = (super.onKeyDown(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1857827257 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1857827257;
        case KeyEvent.ACTION_UP:
        boolean varAD33E8F21A74B923C1A24761EAF2F4A9_1749876420 = (super.onKeyUp(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1074974473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1074974473;
        case KeyEvent.ACTION_MULTIPLE:
        boolean varAE6EFDECB7172A439AD0AFF79E9160E9_993283692 = (super.onKeyMultiple(keyCode, count, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_229889355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_229889355;
        default:
        boolean var68934A3E9455FA72420237EB05902327_1879623587 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1717900533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1717900533;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.867 -0400", hash_original_method = "CFFD02C88D512DC860E9CC0FE1096C45", hash_generated_method = "31788C9A3C624E171DF8C0BF80A0F355")
     boolean pageScroll(int direction) {
        addTaint(direction);
        int nextPage = -1;
        boolean down = false;
        if(direction == FOCUS_UP)        
        {
            nextPage = Math.max(0, mSelectedPosition - getChildCount() - 1);
        } //End block
        else
        if(direction == FOCUS_DOWN)        
        {
            nextPage = Math.min(mItemCount - 1, mSelectedPosition + getChildCount() - 1);
            down = true;
        } //End block
        if(nextPage >= 0)        
        {
            int position = lookForSelectablePosition(nextPage, down);
            if(position >= 0)            
            {
                mLayoutMode = LAYOUT_SPECIFIC;
                mSpecificTop = mPaddingTop + getVerticalFadingEdgeLength();
                if(down && position > mItemCount - getChildCount())                
                {
                    mLayoutMode = LAYOUT_FORCE_BOTTOM;
                } //End block
                if(!down && position < getChildCount())                
                {
                    mLayoutMode = LAYOUT_FORCE_TOP;
                } //End block
                setSelectionInt(position);
                invokeOnItemScrollListener();
                if(!awakenScrollBars())                
                {
                    invalidate();
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_1163786414 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1415720463 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1415720463;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2035813461 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1783382197 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1783382197;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.867 -0400", hash_original_method = "8893A9BFD4970E039D8D32407D02C15E", hash_generated_method = "5A25FFCA51B6BD01419CACD9D312BEA2")
     boolean fullScroll(int direction) {
        addTaint(direction);
        boolean moved = false;
        if(direction == FOCUS_UP)        
        {
            if(mSelectedPosition != 0)            
            {
                int position = lookForSelectablePosition(0, true);
                if(position >= 0)                
                {
                    mLayoutMode = LAYOUT_FORCE_TOP;
                    setSelectionInt(position);
                    invokeOnItemScrollListener();
                } //End block
                moved = true;
            } //End block
        } //End block
        else
        if(direction == FOCUS_DOWN)        
        {
            if(mSelectedPosition < mItemCount - 1)            
            {
                int position = lookForSelectablePosition(mItemCount - 1, true);
                if(position >= 0)                
                {
                    mLayoutMode = LAYOUT_FORCE_BOTTOM;
                    setSelectionInt(position);
                    invokeOnItemScrollListener();
                } //End block
                moved = true;
            } //End block
        } //End block
        if(moved && !awakenScrollBars())        
        {
            awakenScrollBars();
            invalidate();
        } //End block
        boolean var11DFD868D93BC2B0E4CE0BEE5756F8B1_1010686761 = (moved);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1089111250 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1089111250;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.868 -0400", hash_original_method = "27083050B4DD915BDC5D45A692A1DFB7", hash_generated_method = "834AC391686E44915B7132CC1CB0AE21")
    private boolean handleHorizontalFocusWithinListItem(int direction) {
        addTaint(direction);
        if(direction != View.FOCUS_LEFT && direction != View.FOCUS_RIGHT)        
        {
            IllegalArgumentException varE1317B62CA27FC26F337686C4E0B9779_762871706 = new IllegalArgumentException("direction must be one of"
                    + " {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
            varE1317B62CA27FC26F337686C4E0B9779_762871706.addTaint(taint);
            throw varE1317B62CA27FC26F337686C4E0B9779_762871706;
        } //End block
        final int numChildren = getChildCount();
        if(mItemsCanFocus && numChildren > 0 && mSelectedPosition != INVALID_POSITION)        
        {
            final View selectedView = getSelectedView();
            if(selectedView != null && selectedView.hasFocus() &&
                    selectedView instanceof ViewGroup)            
            {
                final View currentFocus = selectedView.findFocus();
                final View nextFocus = FocusFinder.getInstance().findNextFocus(
                        (ViewGroup) selectedView, currentFocus, direction);
                if(nextFocus != null)                
                {
                    currentFocus.getFocusedRect(mTempRect);
                    offsetDescendantRectToMyCoords(currentFocus, mTempRect);
                    offsetRectIntoDescendantCoords(nextFocus, mTempRect);
                    if(nextFocus.requestFocus(direction, mTempRect))                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_1658423054 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_618281709 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_618281709;
                    } //End block
                } //End block
                final View globalNextFocus = FocusFinder.getInstance().findNextFocus(
                        (ViewGroup) getRootView(), currentFocus, direction);
                if(globalNextFocus != null)                
                {
                    boolean varE53DF464013DD00C28000ABFB442631E_1708323411 = (isViewAncestorOf(globalNextFocus, this));
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1563959843 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1563959843;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_922057161 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_279530259 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_279530259;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.868 -0400", hash_original_method = "6B5D7DFA7F5B692B993CC3912D59B646", hash_generated_method = "A86849958A384587CE37EDAFF31C03B7")
     boolean arrowScroll(int direction) {
        addTaint(direction);
        try 
        {
            mInLayout = true;
            final boolean handled = arrowScrollImpl(direction);
            if(handled)            
            {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
            } //End block
            boolean var98F0599AF776A1FE4101C199A40EEB8F_2106778898 = (handled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_64827210 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_64827210;
        } //End block
        finally 
        {
            mInLayout = false;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.869 -0400", hash_original_method = "5F8F1549FF6A2936584D81A340335636", hash_generated_method = "F86FB177F690171E6F9AA92D6F328BC6")
    private boolean arrowScrollImpl(int direction) {
        addTaint(direction);
        if(getChildCount() <= 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_628393837 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_837101478 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_837101478;
        } //End block
        View selectedView = getSelectedView();
        int selectedPos = mSelectedPosition;
        int nextSelectedPosition = lookForSelectablePositionOnScreen(direction);
        int amountToScroll = amountToScroll(direction, nextSelectedPosition);
        final ArrowScrollFocusResult focusResult = mItemsCanFocus ? arrowScrollFocused(direction) : null;
        if(focusResult != null)        
        {
            nextSelectedPosition = focusResult.getSelectedPosition();
            amountToScroll = focusResult.getAmountToScroll();
        } //End block
        boolean needToRedraw = focusResult != null;
        if(nextSelectedPosition != INVALID_POSITION)        
        {
            handleNewSelectionChange(selectedView, direction, nextSelectedPosition, focusResult != null);
            setSelectedPositionInt(nextSelectedPosition);
            setNextSelectedPositionInt(nextSelectedPosition);
            selectedView = getSelectedView();
            selectedPos = nextSelectedPosition;
            if(mItemsCanFocus && focusResult == null)            
            {
                final View focused = getFocusedChild();
                if(focused != null)                
                {
                    focused.clearFocus();
                } //End block
            } //End block
            needToRedraw = true;
            checkSelectionChanged();
        } //End block
        if(amountToScroll > 0)        
        {
            scrollListItemsBy((direction == View.FOCUS_UP) ? amountToScroll : -amountToScroll);
            needToRedraw = true;
        } //End block
        if(mItemsCanFocus && (focusResult == null)
                && selectedView != null && selectedView.hasFocus())        
        {
            final View focused = selectedView.findFocus();
            if(!isViewAncestorOf(focused, this) || distanceToView(focused) > 0)            
            {
                focused.clearFocus();
            } //End block
        } //End block
        if(nextSelectedPosition == INVALID_POSITION && selectedView != null
                && !isViewAncestorOf(selectedView, this))        
        {
            selectedView = null;
            hideSelector();
            mResurrectToPosition = INVALID_POSITION;
        } //End block
        if(needToRedraw)        
        {
            if(selectedView != null)            
            {
                positionSelector(selectedPos, selectedView);
                mSelectedTop = selectedView.getTop();
            } //End block
            if(!awakenScrollBars())            
            {
                invalidate();
            } //End block
            invokeOnItemScrollListener();
            boolean varB326B5062B2F0E69046810717534CB09_1490833298 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1744823282 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1744823282;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_544405894 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_755185022 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_755185022;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.870 -0400", hash_original_method = "5F7DFDAF299194D301FC447E78E3FD87", hash_generated_method = "F629289F4355D8342BF8D789B83F955D")
    private void handleNewSelectionChange(View selectedView, int direction, int newSelectedPosition,
            boolean newFocusAssigned) {
        addTaint(newFocusAssigned);
        addTaint(newSelectedPosition);
        addTaint(direction);
        addTaint(selectedView.getTaint());
        if(newSelectedPosition == INVALID_POSITION)        
        {
            IllegalArgumentException varD54A1F5EDCBDB9774526D7EAFBD09FD3_199067410 = new IllegalArgumentException("newSelectedPosition needs to be valid");
            varD54A1F5EDCBDB9774526D7EAFBD09FD3_199067410.addTaint(taint);
            throw varD54A1F5EDCBDB9774526D7EAFBD09FD3_199067410;
        } //End block
        View topView;
        View bottomView;
        int topViewIndex;
        int bottomViewIndex;
        boolean topSelected = false;
        final int selectedIndex = mSelectedPosition - mFirstPosition;
        final int nextSelectedIndex = newSelectedPosition - mFirstPosition;
        if(direction == View.FOCUS_UP)        
        {
            topViewIndex = nextSelectedIndex;
            bottomViewIndex = selectedIndex;
            topView = getChildAt(topViewIndex);
            bottomView = selectedView;
            topSelected = true;
        } //End block
        else
        {
            topViewIndex = selectedIndex;
            bottomViewIndex = nextSelectedIndex;
            topView = selectedView;
            bottomView = getChildAt(bottomViewIndex);
        } //End block
        final int numChildren = getChildCount();
        if(topView != null)        
        {
            topView.setSelected(!newFocusAssigned && topSelected);
            measureAndAdjustDown(topView, topViewIndex, numChildren);
        } //End block
        if(bottomView != null)        
        {
            bottomView.setSelected(!newFocusAssigned && !topSelected);
            measureAndAdjustDown(bottomView, bottomViewIndex, numChildren);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.871 -0400", hash_original_method = "D9B7EDD91437C9CF7E31BD236F25B8F3", hash_generated_method = "7CEBAC0690635E6C270DB0C881ED501B")
    private void measureAndAdjustDown(View child, int childIndex, int numChildren) {
        addTaint(numChildren);
        addTaint(childIndex);
        addTaint(child.getTaint());
        int oldHeight = child.getHeight();
        measureItem(child);
        if(child.getMeasuredHeight() != oldHeight)        
        {
            relayoutMeasuredItem(child);
            final int heightDelta = child.getMeasuredHeight() - oldHeight;
for(int i = childIndex + 1;i < numChildren;i++)
            {
                getChildAt(i).offsetTopAndBottom(heightDelta);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.872 -0400", hash_original_method = "195C1D433E8B0F15028E4D73EB2D6DE2", hash_generated_method = "E11E2719C09245CCF5541CB7E942CDE2")
    private void measureItem(View child) {
        addTaint(child.getTaint());
        ViewGroup.LayoutParams p = child.getLayoutParams();
        if(p == null)        
        {
            p = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        } //End block
        int childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                mListPadding.left + mListPadding.right, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        if(lpHeight > 0)        
        {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
        } //End block
        else
        {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        } //End block
        child.measure(childWidthSpec, childHeightSpec);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.874 -0400", hash_original_method = "69D49227DB6AC5D384C2E3A710CB930F", hash_generated_method = "9F1883B014D47B5135E775774459E1AC")
    private void relayoutMeasuredItem(View child) {
        addTaint(child.getTaint());
        final int w = child.getMeasuredWidth();
        final int h = child.getMeasuredHeight();
        final int childLeft = mListPadding.left;
        final int childRight = childLeft + w;
        final int childTop = child.getTop();
        final int childBottom = childTop + h;
        child.layout(childLeft, childTop, childRight, childBottom);
        // ---------- Original Method ----------
        //final int w = child.getMeasuredWidth();
        //final int h = child.getMeasuredHeight();
        //final int childLeft = mListPadding.left;
        //final int childRight = childLeft + w;
        //final int childTop = child.getTop();
        //final int childBottom = childTop + h;
        //child.layout(childLeft, childTop, childRight, childBottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.874 -0400", hash_original_method = "42F2E28C8994E7757E02659DFEBDEFA8", hash_generated_method = "D5B9383789D2E0B03BA3E420DA303247")
    private int getArrowScrollPreviewLength() {
        int varAD56225AA1B19152C19AAD1A2935A935_2002650137 = (Math.max(MIN_SCROLL_PREVIEW_PIXELS, getVerticalFadingEdgeLength()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1197582767 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1197582767;
        // ---------- Original Method ----------
        //return Math.max(MIN_SCROLL_PREVIEW_PIXELS, getVerticalFadingEdgeLength());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.875 -0400", hash_original_method = "0CBCA538A833739B1FF13F8466C4BF4D", hash_generated_method = "507F3028D9A82A78C6B5FD8437354716")
    private int amountToScroll(int direction, int nextSelectedPosition) {
        addTaint(nextSelectedPosition);
        addTaint(direction);
        final int listBottom = getHeight() - mListPadding.bottom;
        final int listTop = mListPadding.top;
        final int numChildren = getChildCount();
        if(direction == View.FOCUS_DOWN)        
        {
            int indexToMakeVisible = numChildren - 1;
            if(nextSelectedPosition != INVALID_POSITION)            
            {
                indexToMakeVisible = nextSelectedPosition - mFirstPosition;
            } //End block
            final int positionToMakeVisible = mFirstPosition + indexToMakeVisible;
            final View viewToMakeVisible = getChildAt(indexToMakeVisible);
            int goalBottom = listBottom;
            if(positionToMakeVisible < mItemCount - 1)            
            {
                goalBottom -= getArrowScrollPreviewLength();
            } //End block
            if(viewToMakeVisible.getBottom() <= goalBottom)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1192419051 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439620062 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439620062;
            } //End block
            if(nextSelectedPosition != INVALID_POSITION
                    && (goalBottom - viewToMakeVisible.getTop()) >= getMaxScrollAmount())            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1746030372 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222399160 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222399160;
            } //End block
            int amountToScroll = (viewToMakeVisible.getBottom() - goalBottom);
            if((mFirstPosition + numChildren) == mItemCount)            
            {
                final int max = getChildAt(numChildren - 1).getBottom() - listBottom;
                amountToScroll = Math.min(amountToScroll, max);
            } //End block
            int var5DC62E2363FF84D8BE4A5D44EA1AEEB9_1571006954 = (Math.min(amountToScroll, getMaxScrollAmount()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_726704157 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_726704157;
        } //End block
        else
        {
            int indexToMakeVisible = 0;
            if(nextSelectedPosition != INVALID_POSITION)            
            {
                indexToMakeVisible = nextSelectedPosition - mFirstPosition;
            } //End block
            final int positionToMakeVisible = mFirstPosition + indexToMakeVisible;
            final View viewToMakeVisible = getChildAt(indexToMakeVisible);
            int goalTop = listTop;
            if(positionToMakeVisible > 0)            
            {
                goalTop += getArrowScrollPreviewLength();
            } //End block
            if(viewToMakeVisible.getTop() >= goalTop)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1041578229 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_888167525 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_888167525;
            } //End block
            if(nextSelectedPosition != INVALID_POSITION &&
                    (viewToMakeVisible.getBottom() - goalTop) >= getMaxScrollAmount())            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1470030865 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822823989 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822823989;
            } //End block
            int amountToScroll = (goalTop - viewToMakeVisible.getTop());
            if(mFirstPosition == 0)            
            {
                final int max = listTop - getChildAt(0).getTop();
                amountToScroll = Math.min(amountToScroll,  max);
            } //End block
            int var5DC62E2363FF84D8BE4A5D44EA1AEEB9_1886085663 = (Math.min(amountToScroll, getMaxScrollAmount()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1047457271 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1047457271;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.876 -0400", hash_original_method = "760C70065AEFE7BC7EE2B10D159765ED", hash_generated_method = "F7B46E1477B2FE51E3B6A538D14D2774")
    private int lookForSelectablePositionOnScreen(int direction) {
        addTaint(direction);
        final int firstPosition = mFirstPosition;
        if(direction == View.FOCUS_DOWN)        
        {
            int startPos = (mSelectedPosition != INVALID_POSITION) ?
                    mSelectedPosition + 1 :
                    firstPosition;
            if(startPos >= mAdapter.getCount())            
            {
                int var296D6C732A05FBA51C5854FA7933FE23_649018469 = (INVALID_POSITION);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193139628 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193139628;
            } //End block
            if(startPos < firstPosition)            
            {
                startPos = firstPosition;
            } //End block
            final int lastVisiblePos = getLastVisiblePosition();
            final ListAdapter adapter = getAdapter();
for(int pos = startPos;pos <= lastVisiblePos;pos++)
            {
                if(adapter.isEnabled(pos)
                        && getChildAt(pos - firstPosition).getVisibility() == View.VISIBLE)                
                {
                    int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_628001682 = (pos);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139514771 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139514771;
                } //End block
            } //End block
        } //End block
        else
        {
            int last = firstPosition + getChildCount() - 1;
            int startPos = (mSelectedPosition != INVALID_POSITION) ?
                    mSelectedPosition - 1 :
                    firstPosition + getChildCount() - 1;
            if(startPos < 0 || startPos >= mAdapter.getCount())            
            {
                int var296D6C732A05FBA51C5854FA7933FE23_271645487 = (INVALID_POSITION);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8602009 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8602009;
            } //End block
            if(startPos > last)            
            {
                startPos = last;
            } //End block
            final ListAdapter adapter = getAdapter();
for(int pos = startPos;pos >= firstPosition;pos--)
            {
                if(adapter.isEnabled(pos)
                        && getChildAt(pos - firstPosition).getVisibility() == View.VISIBLE)                
                {
                    int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_323118582 = (pos);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681059976 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681059976;
                } //End block
            } //End block
        } //End block
        int var296D6C732A05FBA51C5854FA7933FE23_796683090 = (INVALID_POSITION);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712156281 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712156281;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.877 -0400", hash_original_method = "2622F1B1638C7BCDD9C32B9CBE54AF85", hash_generated_method = "1D7B03CF50D17D317D53BA73EBF70C7D")
    private ArrowScrollFocusResult arrowScrollFocused(final int direction) {
        addTaint(direction);
        final View selectedView = getSelectedView();
        View newFocus;
        if(selectedView != null && selectedView.hasFocus())        
        {
            View oldFocus = selectedView.findFocus();
            newFocus = FocusFinder.getInstance().findNextFocus(this, oldFocus, direction);
        } //End block
        else
        {
            if(direction == View.FOCUS_DOWN)            
            {
                final boolean topFadingEdgeShowing = (mFirstPosition > 0);
                final int listTop = mListPadding.top +
                        (topFadingEdgeShowing ? getArrowScrollPreviewLength() : 0);
                final int ySearchPoint = (selectedView != null && selectedView.getTop() > listTop) ?
                                selectedView.getTop() :
                                listTop;
                mTempRect.set(0, ySearchPoint, 0, ySearchPoint);
            } //End block
            else
            {
                final boolean bottomFadingEdgeShowing = (mFirstPosition + getChildCount() - 1) < mItemCount;
                final int listBottom = getHeight() - mListPadding.bottom -
                        (bottomFadingEdgeShowing ? getArrowScrollPreviewLength() : 0);
                final int ySearchPoint = (selectedView != null && selectedView.getBottom() < listBottom) ?
                                selectedView.getBottom() :
                                listBottom;
                mTempRect.set(0, ySearchPoint, 0, ySearchPoint);
            } //End block
            newFocus = FocusFinder.getInstance().findNextFocusFromRect(this, mTempRect, direction);
        } //End block
        if(newFocus != null)        
        {
            final int positionOfNewFocus = positionOfNewFocus(newFocus);
            if(mSelectedPosition != INVALID_POSITION && positionOfNewFocus != mSelectedPosition)            
            {
                final int selectablePosition = lookForSelectablePositionOnScreen(direction);
                if(selectablePosition != INVALID_POSITION &&
                        ((direction == View.FOCUS_DOWN && selectablePosition < positionOfNewFocus) ||
                        (direction == View.FOCUS_UP && selectablePosition > positionOfNewFocus)))                
                {
ArrowScrollFocusResult var540C13E9E156B687226421B24F2DF178_1055084775 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1055084775.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1055084775;
                } //End block
            } //End block
            int focusScroll = amountToScrollToNewFocus(direction, newFocus, positionOfNewFocus);
            final int maxScrollAmount = getMaxScrollAmount();
            if(focusScroll < maxScrollAmount)            
            {
                newFocus.requestFocus(direction);
                mArrowScrollFocusResult.populate(positionOfNewFocus, focusScroll);
ArrowScrollFocusResult var90691FE567703B4DA70BFB71F556DA31_1981006642 =                 mArrowScrollFocusResult;
                var90691FE567703B4DA70BFB71F556DA31_1981006642.addTaint(taint);
                return var90691FE567703B4DA70BFB71F556DA31_1981006642;
            } //End block
            else
            if(distanceToView(newFocus) < maxScrollAmount)            
            {
                newFocus.requestFocus(direction);
                mArrowScrollFocusResult.populate(positionOfNewFocus, maxScrollAmount);
ArrowScrollFocusResult var90691FE567703B4DA70BFB71F556DA31_1763393083 =                 mArrowScrollFocusResult;
                var90691FE567703B4DA70BFB71F556DA31_1763393083.addTaint(taint);
                return var90691FE567703B4DA70BFB71F556DA31_1763393083;
            } //End block
        } //End block
ArrowScrollFocusResult var540C13E9E156B687226421B24F2DF178_639034557 =         null;
        var540C13E9E156B687226421B24F2DF178_639034557.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_639034557;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.877 -0400", hash_original_method = "E7A74EC59726801D8AE9EB276549022E", hash_generated_method = "36EA29BCC4885C80FE1D9EC14045F1B7")
    private int positionOfNewFocus(View newFocus) {
        addTaint(newFocus.getTaint());
        final int numChildren = getChildCount();
for(int i = 0;i < numChildren;i++)
        {
            final View child = getChildAt(i);
            if(isViewAncestorOf(newFocus, child))            
            {
                int varB4D2F09D0AD5244C9E57B5AF8AB759AE_1988289304 = (mFirstPosition + i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_170440823 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_170440823;
            } //End block
        } //End block
        IllegalArgumentException var37CFDD446F9DC6A382F9FAD4C6DED131_1694165150 = new IllegalArgumentException("newFocus is not a child of any of the"
                + " children of the list!");
        var37CFDD446F9DC6A382F9FAD4C6DED131_1694165150.addTaint(taint);
        throw var37CFDD446F9DC6A382F9FAD4C6DED131_1694165150;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.877 -0400", hash_original_method = "3B08BDE00067F884387760F12D698F42", hash_generated_method = "374DB56D69E963E5E926AFFE789CF27D")
    private boolean isViewAncestorOf(View child, View parent) {
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        if(child == parent)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1433718855 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_344680017 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_344680017;
        } //End block
        final ViewParent theParent = child.getParent();
        boolean var550C4491B68DF99EE6326514438B8937_318171566 = ((theParent instanceof ViewGroup) && isViewAncestorOf((View) theParent, parent));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_106739985 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_106739985;
        // ---------- Original Method ----------
        //if (child == parent) {
            //return true;
        //}
        //final ViewParent theParent = child.getParent();
        //return (theParent instanceof ViewGroup) && isViewAncestorOf((View) theParent, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.878 -0400", hash_original_method = "972857949DC34A723A630B605759B3EF", hash_generated_method = "EB05BAD0130AA20CB10512EA5429B210")
    private int amountToScrollToNewFocus(int direction, View newFocus, int positionOfNewFocus) {
        addTaint(positionOfNewFocus);
        addTaint(newFocus.getTaint());
        addTaint(direction);
        int amountToScroll = 0;
        newFocus.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(newFocus, mTempRect);
        if(direction == View.FOCUS_UP)        
        {
            if(mTempRect.top < mListPadding.top)            
            {
                amountToScroll = mListPadding.top - mTempRect.top;
                if(positionOfNewFocus > 0)                
                {
                    amountToScroll += getArrowScrollPreviewLength();
                } //End block
            } //End block
        } //End block
        else
        {
            final int listBottom = getHeight() - mListPadding.bottom;
            if(mTempRect.bottom > listBottom)            
            {
                amountToScroll = mTempRect.bottom - listBottom;
                if(positionOfNewFocus < mItemCount - 1)                
                {
                    amountToScroll += getArrowScrollPreviewLength();
                } //End block
            } //End block
        } //End block
        int var5C2A74643717878417A83FC0EE5AC7C1_760675328 = (amountToScroll);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2015638472 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2015638472;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.878 -0400", hash_original_method = "2468FB71A40A0019FA8D57CEA81AC8A6", hash_generated_method = "23E1713096C1520AB0CAD7566079FBCB")
    private int distanceToView(View descendant) {
        addTaint(descendant.getTaint());
        int distance = 0;
        descendant.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(descendant, mTempRect);
        final int listBottom = mBottom - mTop - mListPadding.bottom;
        if(mTempRect.bottom < mListPadding.top)        
        {
            distance = mListPadding.top - mTempRect.bottom;
        } //End block
        else
        if(mTempRect.top > listBottom)        
        {
            distance = mTempRect.top - listBottom;
        } //End block
        int varA74EC9C5B6882F79E32A8FBD8DA90C1B_1121770594 = (distance);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_503628697 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_503628697;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.884 -0400", hash_original_method = "FAA0316A71F66D005638E2A277415AFB", hash_generated_method = "920557013EB3758BED6A1A7ABA41790A")
    private void scrollListItemsBy(int amount) {
        addTaint(amount);
        offsetChildrenTopAndBottom(amount);
        final int listBottom = getHeight() - mListPadding.bottom;
        final int listTop = mListPadding.top;
        final AbsListView.RecycleBin recycleBin = mRecycler;
        if(amount < 0)        
        {
            int numChildren = getChildCount();
            View last = getChildAt(numChildren - 1);
            while
(last.getBottom() < listBottom)            
            {
                final int lastVisiblePosition = mFirstPosition + numChildren - 1;
                if(lastVisiblePosition < mItemCount - 1)                
                {
                    last = addViewBelow(last, lastVisiblePosition);
                    numChildren++;
                } //End block
                else
                {
                    break;
                } //End block
            } //End block
            if(last.getBottom() < listBottom)            
            {
                offsetChildrenTopAndBottom(listBottom - last.getBottom());
            } //End block
            View first = getChildAt(0);
            while
(first.getBottom() < listTop)            
            {
                AbsListView.LayoutParams layoutParams = (LayoutParams) first.getLayoutParams();
                if(recycleBin.shouldRecycleViewType(layoutParams.viewType))                
                {
                    detachViewFromParent(first);
                    recycleBin.addScrapView(first, mFirstPosition);
                } //End block
                else
                {
                    removeViewInLayout(first);
                } //End block
                first = getChildAt(0);
                mFirstPosition++;
            } //End block
        } //End block
        else
        {
            View first = getChildAt(0);
            while
((first.getTop() > listTop) && (mFirstPosition > 0))            
            {
                first = addViewAbove(first, mFirstPosition);
                mFirstPosition--;
            } //End block
            if(first.getTop() > listTop)            
            {
                offsetChildrenTopAndBottom(listTop - first.getTop());
            } //End block
            int lastIndex = getChildCount() - 1;
            View last = getChildAt(lastIndex);
            while
(last.getTop() > listBottom)            
            {
                AbsListView.LayoutParams layoutParams = (LayoutParams) last.getLayoutParams();
                if(recycleBin.shouldRecycleViewType(layoutParams.viewType))                
                {
                    detachViewFromParent(last);
                    recycleBin.addScrapView(last, mFirstPosition+lastIndex);
                } //End block
                else
                {
                    removeViewInLayout(last);
                } //End block
                last = getChildAt(--lastIndex);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.885 -0400", hash_original_method = "9F36487536DE2965CEF1C4C9236F1DF4", hash_generated_method = "930E892139750C17C22596B4905CE9F5")
    private View addViewAbove(View theView, int position) {
        addTaint(position);
        addTaint(theView.getTaint());
        int abovePosition = position - 1;
        View view = obtainView(abovePosition, mIsScrap);
        int edgeOfNewChild = theView.getTop() - mDividerHeight;
        setupChild(view, abovePosition, edgeOfNewChild, false, mListPadding.left,
                false, mIsScrap[0]);
View var057D265746AE9672AFE5F9FF6338071D_1950886542 =         view;
        var057D265746AE9672AFE5F9FF6338071D_1950886542.addTaint(taint);
        return var057D265746AE9672AFE5F9FF6338071D_1950886542;
        // ---------- Original Method ----------
        //int abovePosition = position - 1;
        //View view = obtainView(abovePosition, mIsScrap);
        //int edgeOfNewChild = theView.getTop() - mDividerHeight;
        //setupChild(view, abovePosition, edgeOfNewChild, false, mListPadding.left,
                //false, mIsScrap[0]);
        //return view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.887 -0400", hash_original_method = "D4F2FE3018B44C78CF4E93EBC6FE5FC7", hash_generated_method = "CB4B5A85484A21C933A2EAA8DD5B9AB1")
    private View addViewBelow(View theView, int position) {
        addTaint(position);
        addTaint(theView.getTaint());
        int belowPosition = position + 1;
        View view = obtainView(belowPosition, mIsScrap);
        int edgeOfNewChild = theView.getBottom() + mDividerHeight;
        setupChild(view, belowPosition, edgeOfNewChild, true, mListPadding.left,
                false, mIsScrap[0]);
View var057D265746AE9672AFE5F9FF6338071D_107649302 =         view;
        var057D265746AE9672AFE5F9FF6338071D_107649302.addTaint(taint);
        return var057D265746AE9672AFE5F9FF6338071D_107649302;
        // ---------- Original Method ----------
        //int belowPosition = position + 1;
        //View view = obtainView(belowPosition, mIsScrap);
        //int edgeOfNewChild = theView.getBottom() + mDividerHeight;
        //setupChild(view, belowPosition, edgeOfNewChild, true, mListPadding.left,
                //false, mIsScrap[0]);
        //return view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.887 -0400", hash_original_method = "B028681B6F4AF7B56D2E022B96A1F853", hash_generated_method = "41CAA68B587321EC0E9AD83ED5D75DA2")
    public void setItemsCanFocus(boolean itemsCanFocus) {
        mItemsCanFocus = itemsCanFocus;
        if(!itemsCanFocus)        
        {
            setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        } //End block
        // ---------- Original Method ----------
        //mItemsCanFocus = itemsCanFocus;
        //if (!itemsCanFocus) {
            //setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.887 -0400", hash_original_method = "1C95AE1007B5CDC38C9B3E3B2904F365", hash_generated_method = "23B664D23150C65FA123BC5DA3B11C19")
    public boolean getItemsCanFocus() {
        boolean var642A643EA2045959727F6503CC4951B2_506959256 = (mItemsCanFocus);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_90960947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_90960947;
        // ---------- Original Method ----------
        //return mItemsCanFocus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.888 -0400", hash_original_method = "719E5FD40BAA2B7205DD0269FBFE398A", hash_generated_method = "DD9CDB46231EE00DD2B7D18D5F512E90")
    @Override
    public boolean isOpaque() {
        boolean retValue = (mCachingActive && mIsCacheColorOpaque && mDividerIsOpaque &&
                hasOpaqueScrollbars()) || super.isOpaque();
        if(retValue)        
        {
            final int listTop = mListPadding != null ? mListPadding.top : mPaddingTop;
            View first = getChildAt(0);
            if(first == null || first.getTop() > listTop)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1668754611 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064180859 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064180859;
            } //End block
            final int listBottom = getHeight() -
                    (mListPadding != null ? mListPadding.bottom : mPaddingBottom);
            View last = getChildAt(getChildCount() - 1);
            if(last == null || last.getBottom() < listBottom)            
            {
                boolean var68934A3E9455FA72420237EB05902327_2116276151 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_631578458 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_631578458;
            } //End block
        } //End block
        boolean var9C7BD17E8EB1C3D0F843684A79A18570_1981116674 = (retValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_225898073 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_225898073;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.888 -0400", hash_original_method = "465D449366429949FD8ADA654918A0E2", hash_generated_method = "0A8E19F67391E97BA56EB26E708F368D")
    @Override
    public void setCacheColorHint(int color) {
        addTaint(color);
        final boolean opaque = (color >>> 24) == 0xFF;
        mIsCacheColorOpaque = opaque;
        if(opaque)        
        {
            if(mDividerPaint == null)            
            {
                mDividerPaint = new Paint();
            } //End block
            mDividerPaint.setColor(color);
        } //End block
        super.setCacheColorHint(color);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.888 -0400", hash_original_method = "9A5C934D25A361940ECD1D897C78B567", hash_generated_method = "A7DDCFC9F24D3F0DB313AECBA656A920")
     void drawOverscrollHeader(Canvas canvas, Drawable drawable, Rect bounds) {
        addTaint(bounds.getTaint());
        addTaint(drawable.getTaint());
        addTaint(canvas.getTaint());
        final int height = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(bounds);
        final int span = bounds.bottom - bounds.top;
        if(span < height)        
        {
            bounds.top = bounds.bottom - height;
        } //End block
        drawable.setBounds(bounds);
        drawable.draw(canvas);
        canvas.restore();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.889 -0400", hash_original_method = "3C862E16BE3AA71DC427E03E79AFA46F", hash_generated_method = "28CD536DA5F0C21F90144399F7F34E64")
     void drawOverscrollFooter(Canvas canvas, Drawable drawable, Rect bounds) {
        addTaint(bounds.getTaint());
        addTaint(drawable.getTaint());
        addTaint(canvas.getTaint());
        final int height = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(bounds);
        final int span = bounds.bottom - bounds.top;
        if(span < height)        
        {
            bounds.bottom = bounds.top + height;
        } //End block
        drawable.setBounds(bounds);
        drawable.draw(canvas);
        canvas.restore();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.891 -0400", hash_original_method = "2FA3D064F2DBB643D61459E2FE6AA64C", hash_generated_method = "BA47560E2916C9FBD121ACE71BA0D052")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        addTaint(canvas.getTaint());
        if(mCachingStarted)        
        {
            mCachingActive = true;
        } //End block
        final int dividerHeight = mDividerHeight;
        final Drawable overscrollHeader = mOverScrollHeader;
        final Drawable overscrollFooter = mOverScrollFooter;
        final boolean drawOverscrollHeader = overscrollHeader != null;
        final boolean drawOverscrollFooter = overscrollFooter != null;
        final boolean drawDividers = dividerHeight > 0 && mDivider != null;
        if(drawDividers || drawOverscrollHeader || drawOverscrollFooter)        
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
            if(fillForMissingDividers && mDividerPaint == null && mIsCacheColorOpaque)            
            {
                mDividerPaint = new Paint();
                mDividerPaint.setColor(getCacheColorHint());
            } //End block
            final Paint paint = mDividerPaint;
            int effectivePaddingTop = 0;
            int effectivePaddingBottom = 0;
            if((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK)            
            {
                effectivePaddingTop = mListPadding.top;
                effectivePaddingBottom = mListPadding.bottom;
            } //End block
            final int listBottom = mBottom - mTop - effectivePaddingBottom + mScrollY;
            if(!mStackFromBottom)            
            {
                int bottom = 0;
                final int scrollY = mScrollY;
                if(count > 0 && scrollY < 0)                
                {
                    if(drawOverscrollHeader)                    
                    {
                        bounds.bottom = 0;
                        bounds.top = scrollY;
                        drawOverscrollHeader(canvas, overscrollHeader, bounds);
                    } //End block
                    else
                    if(drawDividers)                    
                    {
                        bounds.bottom = 0;
                        bounds.top = -dividerHeight;
                        drawDivider(canvas, bounds, -1);
                    } //End block
                } //End block
for(int i = 0;i < count;i++)
                {
                    if((headerDividers || first + i >= headerCount) &&
                            (footerDividers || first + i < footerLimit))                    
                    {
                        View child = getChildAt(i);
                        bottom = child.getBottom();
                        if(drawDividers &&
                                (bottom < listBottom && !(drawOverscrollFooter && i == count - 1)))                        
                        {
                            if((areAllItemsSelectable ||
                                    (adapter.isEnabled(first + i) && (i == count - 1 ||
                                            adapter.isEnabled(first + i + 1)))))                            
                            {
                                bounds.top = bottom;
                                bounds.bottom = bottom + dividerHeight;
                                drawDivider(canvas, bounds, i);
                            } //End block
                            else
                            if(fillForMissingDividers)                            
                            {
                                bounds.top = bottom;
                                bounds.bottom = bottom + dividerHeight;
                                canvas.drawRect(bounds, paint);
                            } //End block
                        } //End block
                    } //End block
                } //End block
                final int overFooterBottom = mBottom + mScrollY;
                if(drawOverscrollFooter && first + count == itemCount &&
                        overFooterBottom > bottom)                
                {
                    bounds.top = bottom;
                    bounds.bottom = overFooterBottom;
                    drawOverscrollFooter(canvas, overscrollFooter, bounds);
                } //End block
            } //End block
            else
            {
                int top;
                final int scrollY = mScrollY;
                if(count > 0 && drawOverscrollHeader)                
                {
                    bounds.top = scrollY;
                    bounds.bottom = getChildAt(0).getTop();
                    drawOverscrollHeader(canvas, overscrollHeader, bounds);
                } //End block
                final int start = drawOverscrollHeader ? 1 : 0;
for(int i = start;i < count;i++)
                {
                    if((headerDividers || first + i >= headerCount) &&
                            (footerDividers || first + i < footerLimit))                    
                    {
                        View child = getChildAt(i);
                        top = child.getTop();
                        if(top > effectivePaddingTop)                        
                        {
                            if((areAllItemsSelectable ||
                                    (adapter.isEnabled(first + i) && (i == count - 1 ||
                                            adapter.isEnabled(first + i + 1)))))                            
                            {
                                bounds.top = top - dividerHeight;
                                bounds.bottom = top;
                                drawDivider(canvas, bounds, i - 1);
                            } //End block
                            else
                            if(fillForMissingDividers)                            
                            {
                                bounds.top = top - dividerHeight;
                                bounds.bottom = top;
                                canvas.drawRect(bounds, paint);
                            } //End block
                        } //End block
                    } //End block
                } //End block
                if(count > 0 && scrollY > 0)                
                {
                    if(drawOverscrollFooter)                    
                    {
                        final int absListBottom = mBottom;
                        bounds.top = absListBottom;
                        bounds.bottom = absListBottom + scrollY;
                        drawOverscrollFooter(canvas, overscrollFooter, bounds);
                    } //End block
                    else
                    if(drawDividers)                    
                    {
                        bounds.top = listBottom;
                        bounds.bottom = listBottom + dividerHeight;
                        drawDivider(canvas, bounds, -1);
                    } //End block
                } //End block
            } //End block
        } //End block
        super.dispatchDraw(canvas);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.892 -0400", hash_original_method = "4EC2B6750B1C7732AC3B627095EC138F", hash_generated_method = "7DCBCDEB8599BBA4890D1A5A67444142")
    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        addTaint(drawingTime);
        addTaint(child.getTaint());
        addTaint(canvas.getTaint());
        boolean more = super.drawChild(canvas, child, drawingTime);
        if(mCachingActive && child.mCachingFailed)        
        {
            mCachingActive = false;
        } //End block
        boolean varADDEC426932E71323700AFA1911F8F1C_1735063605 = (more);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1513321944 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1513321944;
        // ---------- Original Method ----------
        //boolean more = super.drawChild(canvas, child, drawingTime);
        //if (mCachingActive && child.mCachingFailed) {
            //mCachingActive = false;
        //}
        //return more;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.892 -0400", hash_original_method = "AB3CC143C94AF212348DFB5018C60850", hash_generated_method = "9EF09420C78971E55051D58820578518")
     void drawDivider(Canvas canvas, Rect bounds, int childIndex) {
        addTaint(childIndex);
        addTaint(bounds.getTaint());
        addTaint(canvas.getTaint());
        final Drawable divider = mDivider;
        divider.setBounds(bounds);
        divider.draw(canvas);
        // ---------- Original Method ----------
        //final Drawable divider = mDivider;
        //divider.setBounds(bounds);
        //divider.draw(canvas);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.893 -0400", hash_original_method = "7B5403D1FD6AC98A776FCB41ADD8E487", hash_generated_method = "0A408B358D67EA13962507553E131A6E")
    public Drawable getDivider() {
Drawable varC94E7FA16E865D35556FD1F36A53CFEC_1753044177 =         mDivider;
        varC94E7FA16E865D35556FD1F36A53CFEC_1753044177.addTaint(taint);
        return varC94E7FA16E865D35556FD1F36A53CFEC_1753044177;
        // ---------- Original Method ----------
        //return mDivider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.893 -0400", hash_original_method = "7913B276C2BDCD5302E597BC9A4CB654", hash_generated_method = "3410C436A098F8427C8FD9D2D1021B64")
    public void setDivider(Drawable divider) {
        if(divider != null)        
        {
            mDividerHeight = divider.getIntrinsicHeight();
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.893 -0400", hash_original_method = "229663AAAB1BC0B50485AD0B5CC199F3", hash_generated_method = "A7A7E5E5216F72F3995EB6AFF146FC6D")
    public int getDividerHeight() {
        int varFDC96C666CAD9FBF2EF59762861622A0_1526485463 = (mDividerHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283390400 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283390400;
        // ---------- Original Method ----------
        //return mDividerHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.894 -0400", hash_original_method = "D3D08555D2F9E637F163A09E680CBA08", hash_generated_method = "F0AE68FA46B0ADDC93935BBE3F16E6B1")
    public void setDividerHeight(int height) {
        mDividerHeight = height;
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mDividerHeight = height;
        //requestLayout();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.894 -0400", hash_original_method = "97442AC2339A7874BFA41866E47D7310", hash_generated_method = "82E939478FD38F6F96EFD8736EAC5DA4")
    public void setHeaderDividersEnabled(boolean headerDividersEnabled) {
        mHeaderDividersEnabled = headerDividersEnabled;
        invalidate();
        // ---------- Original Method ----------
        //mHeaderDividersEnabled = headerDividersEnabled;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.894 -0400", hash_original_method = "74ACE2244DDEB7C7F913E5E0F875653E", hash_generated_method = "647057629C534B13B55E9BA37BB1D9B8")
    public void setFooterDividersEnabled(boolean footerDividersEnabled) {
        mFooterDividersEnabled = footerDividersEnabled;
        invalidate();
        // ---------- Original Method ----------
        //mFooterDividersEnabled = footerDividersEnabled;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.894 -0400", hash_original_method = "953E541E16240F0325506F6534EE33B4", hash_generated_method = "7B62E91D6752DA4A0A9FF771478738C0")
    public void setOverscrollHeader(Drawable header) {
        mOverScrollHeader = header;
        if(mScrollY < 0)        
        {
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //mOverScrollHeader = header;
        //if (mScrollY < 0) {
            //invalidate();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.895 -0400", hash_original_method = "95FFBAE371294243FE9AD2355C3622A4", hash_generated_method = "E05E073F7DAF04A98A292D56813D99D8")
    public Drawable getOverscrollHeader() {
Drawable var3EDDCCD11A5D7800CFAAD65B3B0FA85D_1604722867 =         mOverScrollHeader;
        var3EDDCCD11A5D7800CFAAD65B3B0FA85D_1604722867.addTaint(taint);
        return var3EDDCCD11A5D7800CFAAD65B3B0FA85D_1604722867;
        // ---------- Original Method ----------
        //return mOverScrollHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.895 -0400", hash_original_method = "E2CA032ECDDC156C9CE8335D95975846", hash_generated_method = "1A6AF223BC637FBFCF894AE4D3360007")
    public void setOverscrollFooter(Drawable footer) {
        mOverScrollFooter = footer;
        invalidate();
        // ---------- Original Method ----------
        //mOverScrollFooter = footer;
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.895 -0400", hash_original_method = "C43851852530BF4773181DC349AD3704", hash_generated_method = "2978E5E7C8D104D31907B051C86B08CE")
    public Drawable getOverscrollFooter() {
Drawable var86C29A05F5B4A7263764607C52A1A025_1714534506 =         mOverScrollFooter;
        var86C29A05F5B4A7263764607C52A1A025_1714534506.addTaint(taint);
        return var86C29A05F5B4A7263764607C52A1A025_1714534506;
        // ---------- Original Method ----------
        //return mOverScrollFooter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.896 -0400", hash_original_method = "A140BD3D04197A195532B0C2217798E2", hash_generated_method = "52A0BB96BC8CB73D8C540593F42DA97A")
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        addTaint(gainFocus);
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        final ListAdapter adapter = mAdapter;
        int closetChildIndex = -1;
        int closestChildTop = 0;
        if(adapter != null && gainFocus && previouslyFocusedRect != null)        
        {
            previouslyFocusedRect.offset(mScrollX, mScrollY);
            if(adapter.getCount() < getChildCount() + mFirstPosition)            
            {
                mLayoutMode = LAYOUT_NORMAL;
                layoutChildren();
            } //End block
            Rect otherRect = mTempRect;
            int minDistance = Integer.MAX_VALUE;
            final int childCount = getChildCount();
            final int firstPosition = mFirstPosition;
for(int i = 0;i < childCount;i++)
            {
                if(!adapter.isEnabled(firstPosition + i))                
                {
                    continue;
                } //End block
                View other = getChildAt(i);
                other.getDrawingRect(otherRect);
                offsetDescendantRectToMyCoords(other, otherRect);
                int distance = getDistance(previouslyFocusedRect, otherRect, direction);
                if(distance < minDistance)                
                {
                    minDistance = distance;
                    closetChildIndex = i;
                    closestChildTop = other.getTop();
                } //End block
            } //End block
        } //End block
        if(closetChildIndex >= 0)        
        {
            setSelectionFromTop(closetChildIndex + mFirstPosition, closestChildTop);
        } //End block
        else
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.896 -0400", hash_original_method = "33666A5E6A3C0638CD57027CC0FE1CC1", hash_generated_method = "2A47C631287CF242A9F1673DDF7F576E")
    @Override
    protected void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFinishInflate();
        int count = getChildCount();
        if(count > 0)        
        {
for(int i = 0;i < count;++i)
            {
                addHeaderView(getChildAt(i));
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.897 -0400", hash_original_method = "55B474F0526D1B513F7B1BB91F273A6A", hash_generated_method = "C1D558ECAAE6FD55186C3E55DD7BEDA1")
    @Override
    protected View findViewTraversal(int id) {
        addTaint(id);
        View v;
        v = super.findViewTraversal(id);
        if(v == null)        
        {
            v = findViewInHeadersOrFooters(mHeaderViewInfos, id);
            if(v != null)            
            {
View var6DC76BC51820DD65E8396280E884AA78_672600315 =                 v;
                var6DC76BC51820DD65E8396280E884AA78_672600315.addTaint(taint);
                return var6DC76BC51820DD65E8396280E884AA78_672600315;
            } //End block
            v = findViewInHeadersOrFooters(mFooterViewInfos, id);
            if(v != null)            
            {
View var6DC76BC51820DD65E8396280E884AA78_2051330013 =                 v;
                var6DC76BC51820DD65E8396280E884AA78_2051330013.addTaint(taint);
                return var6DC76BC51820DD65E8396280E884AA78_2051330013;
            } //End block
        } //End block
View var6DC76BC51820DD65E8396280E884AA78_1070689548 =         v;
        var6DC76BC51820DD65E8396280E884AA78_1070689548.addTaint(taint);
        return var6DC76BC51820DD65E8396280E884AA78_1070689548;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.897 -0400", hash_original_method = "CE5790FF46C8EC9157EF966632ADD833", hash_generated_method = "561187DE45630E13663B823D011D6181")
     View findViewInHeadersOrFooters(ArrayList<FixedViewInfo> where, int id) {
        addTaint(id);
        addTaint(where.getTaint());
        if(where != null)        
        {
            int len = where.size();
            View v;
for(int i = 0;i < len;i++)
            {
                v = where.get(i).view;
                if(!v.isRootNamespace())                
                {
                    v = v.findViewById(id);
                    if(v != null)                    
                    {
View var6DC76BC51820DD65E8396280E884AA78_108280035 =                         v;
                        var6DC76BC51820DD65E8396280E884AA78_108280035.addTaint(taint);
                        return var6DC76BC51820DD65E8396280E884AA78_108280035;
                    } //End block
                } //End block
            } //End block
        } //End block
View var540C13E9E156B687226421B24F2DF178_630695988 =         null;
        var540C13E9E156B687226421B24F2DF178_630695988.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_630695988;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.898 -0400", hash_original_method = "3E2A521CFE9847E9FDB3AEC6F88A76DD", hash_generated_method = "43E05D6359114E236F7847CF49034B0E")
    @Override
    protected View findViewWithTagTraversal(Object tag) {
        addTaint(tag.getTaint());
        View v;
        v = super.findViewWithTagTraversal(tag);
        if(v == null)        
        {
            v = findViewWithTagInHeadersOrFooters(mHeaderViewInfos, tag);
            if(v != null)            
            {
View var6DC76BC51820DD65E8396280E884AA78_527351276 =                 v;
                var6DC76BC51820DD65E8396280E884AA78_527351276.addTaint(taint);
                return var6DC76BC51820DD65E8396280E884AA78_527351276;
            } //End block
            v = findViewWithTagInHeadersOrFooters(mFooterViewInfos, tag);
            if(v != null)            
            {
View var6DC76BC51820DD65E8396280E884AA78_289827006 =                 v;
                var6DC76BC51820DD65E8396280E884AA78_289827006.addTaint(taint);
                return var6DC76BC51820DD65E8396280E884AA78_289827006;
            } //End block
        } //End block
View var6DC76BC51820DD65E8396280E884AA78_26212532 =         v;
        var6DC76BC51820DD65E8396280E884AA78_26212532.addTaint(taint);
        return var6DC76BC51820DD65E8396280E884AA78_26212532;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.898 -0400", hash_original_method = "FB5700AACE78A96EA34C4186153EA1D8", hash_generated_method = "DE32A691AE267D4D5B6FF2A7C5BEBC1A")
     View findViewWithTagInHeadersOrFooters(ArrayList<FixedViewInfo> where, Object tag) {
        addTaint(tag.getTaint());
        addTaint(where.getTaint());
        if(where != null)        
        {
            int len = where.size();
            View v;
for(int i = 0;i < len;i++)
            {
                v = where.get(i).view;
                if(!v.isRootNamespace())                
                {
                    v = v.findViewWithTag(tag);
                    if(v != null)                    
                    {
View var6DC76BC51820DD65E8396280E884AA78_876615096 =                         v;
                        var6DC76BC51820DD65E8396280E884AA78_876615096.addTaint(taint);
                        return var6DC76BC51820DD65E8396280E884AA78_876615096;
                    } //End block
                } //End block
            } //End block
        } //End block
View var540C13E9E156B687226421B24F2DF178_1583119715 =         null;
        var540C13E9E156B687226421B24F2DF178_1583119715.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1583119715;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.899 -0400", hash_original_method = "C4FCF9CDE386456E06D0A36ACE84F436", hash_generated_method = "53B6CC08613F03ADDB101F3F2E6B2E7E")
    @Override
    protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip) {
        addTaint(childToSkip.getTaint());
        addTaint(predicate.getTaint());
        View v;
        v = super.findViewByPredicateTraversal(predicate, childToSkip);
        if(v == null)        
        {
            v = findViewByPredicateInHeadersOrFooters(mHeaderViewInfos, predicate, childToSkip);
            if(v != null)            
            {
View var6DC76BC51820DD65E8396280E884AA78_1720932259 =                 v;
                var6DC76BC51820DD65E8396280E884AA78_1720932259.addTaint(taint);
                return var6DC76BC51820DD65E8396280E884AA78_1720932259;
            } //End block
            v = findViewByPredicateInHeadersOrFooters(mFooterViewInfos, predicate, childToSkip);
            if(v != null)            
            {
View var6DC76BC51820DD65E8396280E884AA78_619394809 =                 v;
                var6DC76BC51820DD65E8396280E884AA78_619394809.addTaint(taint);
                return var6DC76BC51820DD65E8396280E884AA78_619394809;
            } //End block
        } //End block
View var6DC76BC51820DD65E8396280E884AA78_449346031 =         v;
        var6DC76BC51820DD65E8396280E884AA78_449346031.addTaint(taint);
        return var6DC76BC51820DD65E8396280E884AA78_449346031;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.899 -0400", hash_original_method = "D1F1A1145A67766E94BF084DFEF4A6A9", hash_generated_method = "73F018FE3EABDB1D819F7B8DAE744A0E")
     View findViewByPredicateInHeadersOrFooters(ArrayList<FixedViewInfo> where,
            Predicate<View> predicate, View childToSkip) {
        addTaint(childToSkip.getTaint());
        addTaint(predicate.getTaint());
        addTaint(where.getTaint());
        if(where != null)        
        {
            int len = where.size();
            View v;
for(int i = 0;i < len;i++)
            {
                v = where.get(i).view;
                if(v != childToSkip && !v.isRootNamespace())                
                {
                    v = v.findViewByPredicate(predicate);
                    if(v != null)                    
                    {
View var6DC76BC51820DD65E8396280E884AA78_1950047966 =                         v;
                        var6DC76BC51820DD65E8396280E884AA78_1950047966.addTaint(taint);
                        return var6DC76BC51820DD65E8396280E884AA78_1950047966;
                    } //End block
                } //End block
            } //End block
        } //End block
View var540C13E9E156B687226421B24F2DF178_1822751402 =         null;
        var540C13E9E156B687226421B24F2DF178_1822751402.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1822751402;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.900 -0400", hash_original_method = "7376DB3A956D54D1A994EA4B9B95B8AF", hash_generated_method = "85FE4E40E821C5F17D640B7884050B9F")
    @Deprecated
    public long[] getCheckItemIds() {
        if(mAdapter != null && mAdapter.hasStableIds())        
        {
            long[] var1E3A0112CB229F0294554F1D98D5B119_1305152334 = (getCheckedItemIds());
                        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_569667970 = {getTaintLong()};
            return var3908C7C3AF5171CEE1F112DAE77A5C4D_569667970;
        } //End block
        if(mChoiceMode != CHOICE_MODE_NONE && mCheckStates != null && mAdapter != null)        
        {
            final SparseBooleanArray states = mCheckStates;
            final int count = states.size();
            final long[] ids = new long[count];
            final ListAdapter adapter = mAdapter;
            int checkedCount = 0;
for(int i = 0;i < count;i++)
            {
                if(states.valueAt(i))                
                {
                    ids[checkedCount++] = adapter.getItemId(states.keyAt(i));
                } //End block
            } //End block
            if(checkedCount == count)            
            {
                long[] varBF516925BB37A8544C8EE19A24E15C05_551456933 = (ids);
                                long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_671476800 = {getTaintLong()};
                return var3908C7C3AF5171CEE1F112DAE77A5C4D_671476800;
            } //End block
            else
            {
                final long[] result = new long[checkedCount];
                System.arraycopy(ids, 0, result, 0, checkedCount);
                long[] varB4A88417B3D0170D754C647C30B7216A_855670640 = (result);
                                long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1114119190 = {getTaintLong()};
                return var3908C7C3AF5171CEE1F112DAE77A5C4D_1114119190;
            } //End block
        } //End block
        long[] var349254FC737BA061D0B4F7515D9FED58_1822407804 = (new long[0]);
                long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1390783772 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1390783772;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public class FixedViewInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.900 -0400", hash_original_field = "1BDA80F2BE4D3658E0BAA43FBE7AE8C1", hash_generated_field = "F4E21118122450D7DE8C5B004AEA690D")

        public View view;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.900 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "FC3B89DB1B4BAEFF0C8DFDD10399B12A")

        public Object data;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.900 -0400", hash_original_field = "ADD60A1158B4B8A77E92EC580F3040CE", hash_generated_field = "51BB0A155CFD263D81C29BB4668379B4")

        public boolean isSelectable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.900 -0400", hash_original_method = "67C6F15893AD18CF0EAE06202C68D9E8", hash_generated_method = "67C6F15893AD18CF0EAE06202C68D9E8")
        public FixedViewInfo ()
        {
            //Synthesized constructor
        }


    }


    
    private class FocusSelector implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.900 -0400", hash_original_field = "2A02BDE12D932CD9DCA97106D487F8F5", hash_generated_field = "D614AE7D1AAE0276EA05A974DCBF0210")

        private int mPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.900 -0400", hash_original_field = "1C2A16FEE0F2317B52A14EA25A87B83E", hash_generated_field = "9F00838B177601A91ACC5BEF0B2B59E5")

        private int mPositionTop;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.900 -0400", hash_original_method = "34C9C9AFBDE05AECFED95C79C10A76BA", hash_generated_method = "34C9C9AFBDE05AECFED95C79C10A76BA")
        public FocusSelector ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.901 -0400", hash_original_method = "5C0213FE7A42F47411000D870177F1B7", hash_generated_method = "4118D5E5A7AEC8B364BE84A7A380D07D")
        public FocusSelector setup(int position, int top) {
            mPosition = position;
            mPositionTop = top;
FocusSelector var72A74007B2BE62B849F475C7BDA4658B_1598667972 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1598667972.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1598667972;
            // ---------- Original Method ----------
            //mPosition = position;
            //mPositionTop = top;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.901 -0400", hash_original_method = "1C9CFC3992CD17CE1A3B73D68C8C6081", hash_generated_method = "59BBD0E54B7536BB80D52C5363FBE175")
        public void run() {
            setSelectionFromTop(mPosition, mPositionTop);
            // ---------- Original Method ----------
            //setSelectionFromTop(mPosition, mPositionTop);
        }

        
    }


    
    static private class ArrowScrollFocusResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.901 -0400", hash_original_field = "390A3127D73EBF1C2FE439B9B7D711F9", hash_generated_field = "51E21A7A6543942D242B4E74F7651C70")

        private int mSelectedPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.901 -0400", hash_original_field = "9FA5FDE7E622E7E96DFD95286E06FD92", hash_generated_field = "A1DDFEC53FF7E81352EF3B979C9E665D")

        private int mAmountToScroll;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.901 -0400", hash_original_method = "F12FA46FC2E286992F273AF0197118D3", hash_generated_method = "F12FA46FC2E286992F273AF0197118D3")
        public ArrowScrollFocusResult ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.902 -0400", hash_original_method = "E4C7C1A71AB7D603722F7CE31ED09575", hash_generated_method = "C8559F673D941812E13F3F631D0BAA1F")
         void populate(int selectedPosition, int amountToScroll) {
            mSelectedPosition = selectedPosition;
            mAmountToScroll = amountToScroll;
            // ---------- Original Method ----------
            //mSelectedPosition = selectedPosition;
            //mAmountToScroll = amountToScroll;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.902 -0400", hash_original_method = "57FF42983620727F309A47A5C295AFEC", hash_generated_method = "C0D3122797E4BC50ABB056A73028F9CB")
        public int getSelectedPosition() {
            int var390A3127D73EBF1C2FE439B9B7D711F9_1293289418 = (mSelectedPosition);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186802789 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186802789;
            // ---------- Original Method ----------
            //return mSelectedPosition;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.902 -0400", hash_original_method = "547539826ED165E8A574C9320A564E9F", hash_generated_method = "666657EBCFF79A34270258AEBBA78569")
        public int getAmountToScroll() {
            int var9FA5FDE7E622E7E96DFD95286E06FD92_882685043 = (mAmountToScroll);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1250357534 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1250357534;
            // ---------- Original Method ----------
            //return mAmountToScroll;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.903 -0400", hash_original_field = "E1DEA0BEB2F8CF12C7B6244C21F007E5", hash_generated_field = "AA54EBB1B05B810D7997E2317D48B2F5")

    static final int NO_POSITION = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.903 -0400", hash_original_field = "3559B51D9CE8D7099F97AA2C846ABFFB", hash_generated_field = "F481F11D6BAC4699C15393640CE5DB57")

    private static final float MAX_SCROLL_FACTOR = 0.33f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.903 -0400", hash_original_field = "DA0484B66F107DB9B9104112BC0055B2", hash_generated_field = "992BEAE71211E256B201562C8AAD0326")

    private static final int MIN_SCROLL_PREVIEW_PIXELS = 2;
    // orphaned legacy method
    @Override
	public void updateViewLayout(View view,
			android.view.ViewGroup.LayoutParams params) {
		// TODO Auto-generated method stub
		
	}
    
}

