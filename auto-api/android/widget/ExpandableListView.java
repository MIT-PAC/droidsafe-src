package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ExpandableListConnector.PositionMetadata;
import java.util.ArrayList;

public class ExpandableListView extends ListView {
    private ExpandableListConnector mConnector;
    private ExpandableListAdapter mAdapter;
    private int mIndicatorLeft;
    private int mIndicatorRight;
    private int mChildIndicatorLeft;
    private int mChildIndicatorRight;
    private Drawable mGroupIndicator;
    private Drawable mChildIndicator;
    private Drawable mChildDivider;
    private Rect mIndicatorRect = new Rect();
    private OnGroupCollapseListener mOnGroupCollapseListener;
    private OnGroupExpandListener mOnGroupExpandListener;
    private OnGroupClickListener mOnGroupClickListener;
    private OnChildClickListener mOnChildClickListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.565 -0400", hash_original_method = "883D95D0AB13C2DE7BE0B98484A4295B", hash_generated_method = "C095DC5F741B574808A859EE79AE5E8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExpandableListView(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.565 -0400", hash_original_method = "4019A5446CFBA13B5DEBC7A85D6066EA", hash_generated_method = "EAF8B7750AA587F3AEFFAC9E254D3DAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExpandableListView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.expandableListViewStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.566 -0400", hash_original_method = "9ABBDB13FF145C988C5879C289ADA198", hash_generated_method = "383B58283A134266019B8F3682FF6F6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExpandableListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ExpandableListView, defStyle,
                    0);
        mGroupIndicator = a
                .getDrawable(com.android.internal.R.styleable.ExpandableListView_groupIndicator);
        mChildIndicator = a
                .getDrawable(com.android.internal.R.styleable.ExpandableListView_childIndicator);
        mIndicatorLeft = a
                .getDimensionPixelSize(com.android.internal.R.styleable.ExpandableListView_indicatorLeft, 0);
        mIndicatorRight = a
                .getDimensionPixelSize(com.android.internal.R.styleable.ExpandableListView_indicatorRight, 0);
        {
            mIndicatorRight = mIndicatorLeft + mGroupIndicator.getIntrinsicWidth();
        } //End block
        mChildIndicatorLeft = a.getDimensionPixelSize(
                com.android.internal.R.styleable.ExpandableListView_childIndicatorLeft, CHILD_INDICATOR_INHERIT);
        mChildIndicatorRight = a.getDimensionPixelSize(
                com.android.internal.R.styleable.ExpandableListView_childIndicatorRight, CHILD_INDICATOR_INHERIT);
        mChildDivider = a.getDrawable(com.android.internal.R.styleable.ExpandableListView_childDivider);
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.566 -0400", hash_original_method = "7A23721B5E073FBA7FD49FF2A748467D", hash_generated_method = "A2789659E0AAB0FCA21D6C066F886423")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchDraw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        super.dispatchDraw(canvas);
        int saveCount;
        saveCount = 0;
        boolean clipToPadding;
        clipToPadding = (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK;
        {
            saveCount = canvas.save();
            int scrollX;
            scrollX = mScrollX;
            int scrollY;
            scrollY = mScrollY;
            canvas.clipRect(scrollX + mPaddingLeft, scrollY + mPaddingTop,
                    scrollX + mRight - mLeft - mPaddingRight,
                    scrollY + mBottom - mTop - mPaddingBottom);
        } //End block
        int headerViewsCount;
        headerViewsCount = getHeaderViewsCount();
        int lastChildFlPos;
        lastChildFlPos = mItemCount - getFooterViewsCount() - headerViewsCount - 1;
        int myB;
        myB = mBottom;
        PositionMetadata pos;
        View item;
        Drawable indicator;
        int t, b;
        int lastItemType;
        lastItemType = ~(ExpandableListPosition.CHILD | ExpandableListPosition.GROUP);
        Rect indicatorRect;
        indicatorRect = mIndicatorRect;
        int childCount;
        childCount = getChildCount();
        {
            int i, childFlPos;
            i = 0;
            childFlPos = mFirstPosition - headerViewsCount;
            {
                item = getChildAt(i);
                t = item.getTop();
                b = item.getBottom();
                pos = mConnector.getUnflattenedPos(childFlPos);
                {
                    {
                        indicatorRect.left = (mChildIndicatorLeft == CHILD_INDICATOR_INHERIT) ?
                            mIndicatorLeft : mChildIndicatorLeft;
                        indicatorRect.right = (mChildIndicatorRight == CHILD_INDICATOR_INHERIT) ?
                            mIndicatorRight : mChildIndicatorRight;
                    } //End block
                    {
                        indicatorRect.left = mIndicatorLeft;
                        indicatorRect.right = mIndicatorRight;
                    } //End block
                    indicatorRect.left += mPaddingLeft;
                    indicatorRect.right += mPaddingLeft;
                    lastItemType = pos.position.type;
                } //End block
                {
                    {
                        indicatorRect.top = t;
                        indicatorRect.bottom = b;
                    } //End block
                    {
                        indicatorRect.top = t;
                        indicatorRect.bottom = b;
                    } //End block
                    indicator = getIndicator(pos);
                    {
                        indicator.setBounds(indicatorRect);
                        indicator.draw(canvas);
                    } //End block
                } //End block
                pos.recycle();
            } //End block
        } //End collapsed parenthetic
        {
            canvas.restoreToCount(saveCount);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.567 -0400", hash_original_method = "D5F058A591B90F6E54D4D617313791EB", hash_generated_method = "E98F07F28B1F2EC47AB036FA415D723F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Drawable getIndicator(PositionMetadata pos) {
        dsTaint.addTaint(pos.dsTaint);
        Drawable indicator;
        {
            indicator = mGroupIndicator;
            {
                boolean var8D3297736FE853BD77AF38D0B2E570D5_261017969 = (indicator != null && indicator.isStateful());
                {
                    boolean isEmpty;
                    isEmpty = (pos.groupMetadata == null) ||
                        (pos.groupMetadata.lastChildFlPos == pos.groupMetadata.flPos);
                    int stateSetIndex;
                    stateSetIndex = (pos.isExpanded() ? 1 : 0) | 
                    (isEmpty ? 2 : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
                    indicator.setState(GROUP_STATE_SETS[stateSetIndex]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            indicator = mChildIndicator;
            {
                boolean var8D3297736FE853BD77AF38D0B2E570D5_831518116 = (indicator != null && indicator.isStateful());
                {
                    int stateSet[];
                    stateSet = CHILD_LAST_STATE_SET;
                    stateSet = EMPTY_STATE_SET;
                    indicator.setState(stateSet);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.567 -0400", hash_original_method = "4C83D9B2FEDBCDF12BA1F2A0723CD37C", hash_generated_method = "1F4AB34676FAD54EAFFE21F18F909DF9")
    @DSModeled(DSC.SAFE)
    public void setChildDivider(Drawable childDivider) {
        dsTaint.addTaint(childDivider.dsTaint);
        // ---------- Original Method ----------
        //mChildDivider = childDivider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.568 -0400", hash_original_method = "1C2A86D3B4CD7E5098111C8F9235F268", hash_generated_method = "B9481DD0DDFCADC32F34E4D70EA1F9F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void drawDivider(Canvas canvas, Rect bounds, int childIndex) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(childIndex);
        int flatListPosition;
        flatListPosition = childIndex + mFirstPosition;
        {
            int adjustedPosition;
            adjustedPosition = getFlatPositionForConnector(flatListPosition);
            PositionMetadata pos;
            pos = mConnector.getUnflattenedPos(adjustedPosition);
            {
                boolean var3815EBF3D278F71CEF6C80EF489C3488_1630739664 = ((pos.position.type == ExpandableListPosition.CHILD) || (pos.isExpanded() &&
                    pos.groupMetadata.lastChildFlPos != pos.groupMetadata.flPos));
                {
                    Drawable divider;
                    divider = mChildDivider;
                    divider.setBounds(bounds);
                    divider.draw(canvas);
                    pos.recycle();
                } //End block
            } //End collapsed parenthetic
            pos.recycle();
        } //End block
        super.drawDivider(canvas, bounds, flatListPosition);
        // ---------- Original Method ----------
        //int flatListPosition = childIndex + mFirstPosition;
        //if (flatListPosition >= 0) {
            //final int adjustedPosition = getFlatPositionForConnector(flatListPosition);
            //PositionMetadata pos = mConnector.getUnflattenedPos(adjustedPosition);
            //if ((pos.position.type == ExpandableListPosition.CHILD) || (pos.isExpanded() &&
                    //pos.groupMetadata.lastChildFlPos != pos.groupMetadata.flPos)) {
                //final Drawable divider = mChildDivider;
                //divider.setBounds(bounds);
                //divider.draw(canvas);
                //pos.recycle();
                //return;
            //}
            //pos.recycle();
        //}
        //super.drawDivider(canvas, bounds, flatListPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.568 -0400", hash_original_method = "A4E4696C244BB97A42B35DBC06E7550F", hash_generated_method = "90E3B32A38AB6BC79771BE75AB195BD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAdapter(ListAdapter adapter) {
        dsTaint.addTaint(adapter.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                "For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of " +
                "setAdapter(ListAdapter)");
        // ---------- Original Method ----------
        //throw new RuntimeException(
                //"For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of " +
                //"setAdapter(ListAdapter)");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.568 -0400", hash_original_method = "1C0E40F01B81CC446BCB9E503587C60C", hash_generated_method = "369D814F9ABB0DDC2077646F3FE94399")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ListAdapter getAdapter() {
        ListAdapter var31AA2E100574363E87975CBC6ED043CA_1001198268 = (super.getAdapter());
        return (ListAdapter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return super.getAdapter();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.568 -0400", hash_original_method = "B7F875362109C546409DA14CD03B0627", hash_generated_method = "384A292C726109BD8E472810B3E0369C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setOnItemClickListener(OnItemClickListener l) {
        dsTaint.addTaint(l.dsTaint);
        super.setOnItemClickListener(l);
        // ---------- Original Method ----------
        //super.setOnItemClickListener(l);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.568 -0400", hash_original_method = "86A402EAE8E162910BEF1CBB540CA500", hash_generated_method = "6ADB225EFB801DC819929B0DC6B5AA32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAdapter(ExpandableListAdapter adapter) {
        dsTaint.addTaint(adapter.dsTaint);
        {
            mConnector = new ExpandableListConnector(adapter);
        } //End block
        {
            mConnector = null;
        } //End block
        super.setAdapter(mConnector);
        // ---------- Original Method ----------
        //mAdapter = adapter;
        //if (adapter != null) {
            //mConnector = new ExpandableListConnector(adapter);
        //} else {
            //mConnector = null;
        //}
        //super.setAdapter(mConnector);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.569 -0400", hash_original_method = "0DEBB462BC2A68BA86FC192DC719C116", hash_generated_method = "A31AD45D2E2C9C876B0C8EE0AD90B3FF")
    @DSModeled(DSC.SAFE)
    public ExpandableListAdapter getExpandableListAdapter() {
        return (ExpandableListAdapter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.569 -0400", hash_original_method = "A9D0233B5C169CC66750AD88D31A38E9", hash_generated_method = "B462D7BF2849D6C15F4D67A5903AD2B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isHeaderOrFooterPosition(int position) {
        dsTaint.addTaint(position);
        int footerViewsStart;
        footerViewsStart = mItemCount - getFooterViewsCount();
        boolean varB5AE644EE3D805AA9F6DB1D339ED6635_649485341 = ((position < getHeaderViewsCount() || position >= footerViewsStart));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int footerViewsStart = mItemCount - getFooterViewsCount();
        //return (position < getHeaderViewsCount() || position >= footerViewsStart);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.569 -0400", hash_original_method = "8FB53CC37B504290AC6948A7A815A683", hash_generated_method = "BB59A7A98E0E2CE7D58E1C66C01F6F08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getFlatPositionForConnector(int flatListPosition) {
        dsTaint.addTaint(flatListPosition);
        int varE9C32C9572990701B6BAF07537D8834F_1828370764 = (flatListPosition - getHeaderViewsCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return flatListPosition - getHeaderViewsCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.569 -0400", hash_original_method = "D8821ADD18913687E76F2B3166416BE8", hash_generated_method = "4BE5F4F1FBAC89855DED3B3484D081E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getAbsoluteFlatPosition(int flatListPosition) {
        dsTaint.addTaint(flatListPosition);
        int varD2D8EDD83D5BE6348EBC4248326A4A5B_44169907 = (flatListPosition + getHeaderViewsCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return flatListPosition + getHeaderViewsCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.570 -0400", hash_original_method = "351E469927E1B73D6D643A520D2ADA68", hash_generated_method = "DF2A57732D62E28D9114CDF9C14409C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean performItemClick(View v, int position, long id) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(position);
        dsTaint.addTaint(v.dsTaint);
        {
            boolean var37B5E5C58011B39505D3618135B6EE5B_1749077299 = (isHeaderOrFooterPosition(position));
            {
                boolean var91F020B48E96B24C861AEA82AC2FA0EA_1838740078 = (super.performItemClick(v, position, id));
            } //End block
        } //End collapsed parenthetic
        int adjustedPosition;
        adjustedPosition = getFlatPositionForConnector(position);
        boolean var4C23AE60DB98858DB93D2D17185BD632_2101066015 = (handleItemClick(v, adjustedPosition, id));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isHeaderOrFooterPosition(position)) {
            //return super.performItemClick(v, position, id);
        //}
        //final int adjustedPosition = getFlatPositionForConnector(position);
        //return handleItemClick(v, adjustedPosition, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.570 -0400", hash_original_method = "6AFB7BBE8B57133AA9AA93690C5E22BA", hash_generated_method = "40D9F83F1B9C7426677B5EFC4BE8768B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean handleItemClick(View v, int position, long id) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(position);
        dsTaint.addTaint(v.dsTaint);
        PositionMetadata posMetadata;
        posMetadata = mConnector.getUnflattenedPos(position);
        id = getChildOrGroupId(posMetadata.position);
        boolean returnValue;
        {
            {
                {
                    boolean var158618FBFFB709B0E6894F20E3362E16_1192214062 = (mOnGroupClickListener.onGroupClick(this, v,
                        posMetadata.position.groupPos, id));
                    {
                        posMetadata.recycle();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varFFE3360DB01E9A6262E0A072169C4E53_1207056120 = (posMetadata.isExpanded());
                {
                    mConnector.collapseGroup(posMetadata);
                    playSoundEffect(SoundEffectConstants.CLICK);
                    {
                        mOnGroupCollapseListener.onGroupCollapse(posMetadata.position.groupPos);
                    } //End block
                } //End block
                {
                    mConnector.expandGroup(posMetadata);
                    playSoundEffect(SoundEffectConstants.CLICK);
                    {
                        mOnGroupExpandListener.onGroupExpand(posMetadata.position.groupPos);
                    } //End block
                    int groupPos;
                    groupPos = posMetadata.position.groupPos;
                    int groupFlatPos;
                    groupFlatPos = posMetadata.position.flatListPos;
                    int shiftedGroupPosition;
                    shiftedGroupPosition = groupFlatPos + getHeaderViewsCount();
                    smoothScrollToPosition(shiftedGroupPosition + mAdapter.getChildrenCount(groupPos),
                        shiftedGroupPosition);
                } //End block
            } //End collapsed parenthetic
            returnValue = true;
        } //End block
        {
            {
                playSoundEffect(SoundEffectConstants.CLICK);
                boolean var7B6CA2590F067B319E2DCADB7F136527_559358029 = (mOnChildClickListener.onChildClick(this, v, posMetadata.position.groupPos,
                        posMetadata.position.childPos, id));
            } //End block
            returnValue = false;
        } //End block
        posMetadata.recycle();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.570 -0400", hash_original_method = "98581B0D5B3DDD77A367749C65B03049", hash_generated_method = "EA952FB292E521B7E1AB9C7DC0D8D37C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean expandGroup(int groupPos) {
        dsTaint.addTaint(groupPos);
        boolean var158906FF83ADD7763E372E8503097DFF_4313153 = (expandGroup(groupPos, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return expandGroup(groupPos, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.572 -0400", hash_original_method = "0C4613B5CED32082A0135BD7DC8647D8", hash_generated_method = "F8C41EB1A7AC679C81521E7B483C9209")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean expandGroup(int groupPos, boolean animate) {
        dsTaint.addTaint(animate);
        dsTaint.addTaint(groupPos);
        PositionMetadata pm;
        pm = mConnector.getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1));
        boolean retValue;
        retValue = mConnector.expandGroup(pm);
        {
            mOnGroupExpandListener.onGroupExpand(groupPos);
        } //End block
        {
            int groupFlatPos;
            groupFlatPos = pm.position.flatListPos;
            int shiftedGroupPosition;
            shiftedGroupPosition = groupFlatPos + getHeaderViewsCount();
            smoothScrollToPosition(shiftedGroupPosition + mAdapter.getChildrenCount(groupPos),
                    shiftedGroupPosition);
        } //End block
        pm.recycle();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //PositionMetadata pm = mConnector.getFlattenedPos(ExpandableListPosition.obtain(
                //ExpandableListPosition.GROUP, groupPos, -1, -1));
        //boolean retValue = mConnector.expandGroup(pm);
        //if (mOnGroupExpandListener != null) {
            //mOnGroupExpandListener.onGroupExpand(groupPos);
        //}
        //if (animate) {
            //final int groupFlatPos = pm.position.flatListPos;
            //final int shiftedGroupPosition = groupFlatPos + getHeaderViewsCount();
            //smoothScrollToPosition(shiftedGroupPosition + mAdapter.getChildrenCount(groupPos),
                    //shiftedGroupPosition);
        //}
        //pm.recycle();
        //return retValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.572 -0400", hash_original_method = "32E02BBD4C2448429B8A9BB97BA3197B", hash_generated_method = "AFE497E861D0B14691110D4DAA0903E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean collapseGroup(int groupPos) {
        dsTaint.addTaint(groupPos);
        boolean retValue;
        retValue = mConnector.collapseGroup(groupPos);
        {
            mOnGroupCollapseListener.onGroupCollapse(groupPos);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean retValue = mConnector.collapseGroup(groupPos);
        //if (mOnGroupCollapseListener != null) {
            //mOnGroupCollapseListener.onGroupCollapse(groupPos);
        //}
        //return retValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.572 -0400", hash_original_method = "A0CC4D2398D57CD6BE21425007A2E39D", hash_generated_method = "D81692F451723E99D36866137521E463")
    @DSModeled(DSC.SAFE)
    public void setOnGroupCollapseListener(
            OnGroupCollapseListener onGroupCollapseListener) {
        dsTaint.addTaint(onGroupCollapseListener.dsTaint);
        // ---------- Original Method ----------
        //mOnGroupCollapseListener = onGroupCollapseListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.573 -0400", hash_original_method = "10BB1A471420C27FBFE382BB84A3E76C", hash_generated_method = "F2E39004A03DAC44745C42B39FFF6D2C")
    @DSModeled(DSC.SAFE)
    public void setOnGroupExpandListener(
            OnGroupExpandListener onGroupExpandListener) {
        dsTaint.addTaint(onGroupExpandListener.dsTaint);
        // ---------- Original Method ----------
        //mOnGroupExpandListener = onGroupExpandListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.573 -0400", hash_original_method = "C8C3684AA79EC58EA45C462FF87BD202", hash_generated_method = "032C42526BFD29411B56ED23582F6B2E")
    @DSModeled(DSC.SAFE)
    public void setOnGroupClickListener(OnGroupClickListener onGroupClickListener) {
        dsTaint.addTaint(onGroupClickListener.dsTaint);
        // ---------- Original Method ----------
        //mOnGroupClickListener = onGroupClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.573 -0400", hash_original_method = "26EE7772CEF1895E61E52189D15F9720", hash_generated_method = "6E8A864EA400319866BFC4FD970CDFFB")
    @DSModeled(DSC.SAFE)
    public void setOnChildClickListener(OnChildClickListener onChildClickListener) {
        dsTaint.addTaint(onChildClickListener.dsTaint);
        // ---------- Original Method ----------
        //mOnChildClickListener = onChildClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.573 -0400", hash_original_method = "6797E267DF9CCDAD7E03E9610CE356DD", hash_generated_method = "D8CCDF241EFD40FDEC4816F28C22C5D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getExpandableListPosition(int flatListPosition) {
        dsTaint.addTaint(flatListPosition);
        {
            boolean varAC46EC688D3DC3F88FC89B09088E4D69_1029332443 = (isHeaderOrFooterPosition(flatListPosition));
        } //End collapsed parenthetic
        int adjustedPosition;
        adjustedPosition = getFlatPositionForConnector(flatListPosition);
        PositionMetadata pm;
        pm = mConnector.getUnflattenedPos(adjustedPosition);
        long packedPos;
        packedPos = pm.position.getPackedPosition();
        pm.recycle();
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (isHeaderOrFooterPosition(flatListPosition)) {
            //return PACKED_POSITION_VALUE_NULL;
        //}
        //final int adjustedPosition = getFlatPositionForConnector(flatListPosition);
        //PositionMetadata pm = mConnector.getUnflattenedPos(adjustedPosition);
        //long packedPos = pm.position.getPackedPosition();
        //pm.recycle();
        //return packedPos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.574 -0400", hash_original_method = "C3C2613158D48075F4D80761E996AC8D", hash_generated_method = "18DB09A4F2F41C9BA800984F8EDFB4A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFlatListPosition(long packedPosition) {
        dsTaint.addTaint(packedPosition);
        PositionMetadata pm;
        pm = mConnector.getFlattenedPos(ExpandableListPosition
                .obtainPosition(packedPosition));
        int flatListPosition;
        flatListPosition = pm.position.flatListPos;
        pm.recycle();
        int var4BF775BF016C7D3B749D646E4615FCE3_329061931 = (getAbsoluteFlatPosition(flatListPosition));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //PositionMetadata pm = mConnector.getFlattenedPos(ExpandableListPosition
                //.obtainPosition(packedPosition));
        //final int flatListPosition = pm.position.flatListPos;
        //pm.recycle();
        //return getAbsoluteFlatPosition(flatListPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.574 -0400", hash_original_method = "249AE284AF367E3E33266910F561E468", hash_generated_method = "51BD5A4A6A955996CD26B6FA8720FBB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getSelectedPosition() {
        int selectedPos;
        selectedPos = getSelectedItemPosition();
        long varA93AAACA6E31AFE99DAE4E2E735CF124_2011635664 = (getExpandableListPosition(selectedPos));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //final int selectedPos = getSelectedItemPosition();
        //return getExpandableListPosition(selectedPos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.574 -0400", hash_original_method = "0F549A577DA8ED79E79C3134155D319B", hash_generated_method = "17D181BE5E07C713C1C8FE4E5299BDC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getSelectedId() {
        long packedPos;
        packedPos = getSelectedPosition();
        int groupPos;
        groupPos = getPackedPositionGroup(packedPos);
        {
            boolean var2C84455863B32CE893D64B61CD7E9447_2083678432 = (getPackedPositionType(packedPos) == PACKED_POSITION_TYPE_GROUP);
            {
                long var554AC649873DD7DDC319BC4A4CB37B8C_1650147615 = (mAdapter.getGroupId(groupPos));
            } //End block
            {
                long var41EED02771CC59A8F0A0BD62927C27EF_499919176 = (mAdapter.getChildId(groupPos, getPackedPositionChild(packedPos)));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //long packedPos = getSelectedPosition();
        //if (packedPos == PACKED_POSITION_VALUE_NULL) return -1;
        //int groupPos = getPackedPositionGroup(packedPos);
        //if (getPackedPositionType(packedPos) == PACKED_POSITION_TYPE_GROUP) {
            //return mAdapter.getGroupId(groupPos);
        //} else {
            //return mAdapter.getChildId(groupPos, getPackedPositionChild(packedPos));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.574 -0400", hash_original_method = "89C81106BDF582AFAD7189203633A87D", hash_generated_method = "588987E703A0BC572F4125DDE3492B63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelectedGroup(int groupPosition) {
        dsTaint.addTaint(groupPosition);
        ExpandableListPosition elGroupPos;
        elGroupPos = ExpandableListPosition
                .obtainGroupPosition(groupPosition);
        PositionMetadata pm;
        pm = mConnector.getFlattenedPos(elGroupPos);
        elGroupPos.recycle();
        int absoluteFlatPosition;
        absoluteFlatPosition = getAbsoluteFlatPosition(pm.position.flatListPos);
        super.setSelection(absoluteFlatPosition);
        pm.recycle();
        // ---------- Original Method ----------
        //ExpandableListPosition elGroupPos = ExpandableListPosition
                //.obtainGroupPosition(groupPosition);
        //PositionMetadata pm = mConnector.getFlattenedPos(elGroupPos);
        //elGroupPos.recycle();
        //final int absoluteFlatPosition = getAbsoluteFlatPosition(pm.position.flatListPos);
        //super.setSelection(absoluteFlatPosition);
        //pm.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.575 -0400", hash_original_method = "1A768FE324BC96140FFAB346485D606B", hash_generated_method = "A8F3BFB3BB7E3A8D9EF76296C8832D17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setSelectedChild(int groupPosition, int childPosition, boolean shouldExpandGroup) {
        dsTaint.addTaint(groupPosition);
        dsTaint.addTaint(shouldExpandGroup);
        dsTaint.addTaint(childPosition);
        ExpandableListPosition elChildPos;
        elChildPos = ExpandableListPosition.obtainChildPosition(
                groupPosition, childPosition);
        PositionMetadata flatChildPos;
        flatChildPos = mConnector.getFlattenedPos(elChildPos);
        {
            expandGroup(groupPosition);
            flatChildPos = mConnector.getFlattenedPos(elChildPos);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Could not find child");
            } //End block
        } //End block
        int absoluteFlatPosition;
        absoluteFlatPosition = getAbsoluteFlatPosition(flatChildPos.position.flatListPos);
        super.setSelection(absoluteFlatPosition);
        elChildPos.recycle();
        flatChildPos.recycle();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.575 -0400", hash_original_method = "1725653D4BF466A5CF5EF618E531911D", hash_generated_method = "41775D7627C66CBE686C47A58EC93D58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isGroupExpanded(int groupPosition) {
        dsTaint.addTaint(groupPosition);
        boolean var2B505F8E08E38627F154F490260D9B41_1064535086 = (mConnector.isGroupExpanded(groupPosition));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mConnector.isGroupExpanded(groupPosition);
    }

    
        public static int getPackedPositionType(long packedPosition) {
        if (packedPosition == PACKED_POSITION_VALUE_NULL) {
            return PACKED_POSITION_TYPE_NULL;
        }
        return (packedPosition & PACKED_POSITION_MASK_TYPE) == PACKED_POSITION_MASK_TYPE
                ? PACKED_POSITION_TYPE_CHILD
                : PACKED_POSITION_TYPE_GROUP;
    }

    
        public static int getPackedPositionGroup(long packedPosition) {
        if (packedPosition == PACKED_POSITION_VALUE_NULL) return -1;
        return (int) ((packedPosition & PACKED_POSITION_MASK_GROUP) >> PACKED_POSITION_SHIFT_GROUP);
    }

    
        public static int getPackedPositionChild(long packedPosition) {
        if (packedPosition == PACKED_POSITION_VALUE_NULL) return -1;
        if ((packedPosition & PACKED_POSITION_MASK_TYPE) != PACKED_POSITION_MASK_TYPE) return -1;
        return (int) (packedPosition & PACKED_POSITION_MASK_CHILD);
    }

    
        public static long getPackedPositionForChild(int groupPosition, int childPosition) {
        return (((long)PACKED_POSITION_TYPE_CHILD) << PACKED_POSITION_SHIFT_TYPE)
                | ((((long)groupPosition) & PACKED_POSITION_INT_MASK_GROUP)
                        << PACKED_POSITION_SHIFT_GROUP)
                | (childPosition & PACKED_POSITION_INT_MASK_CHILD);
    }

    
        public static long getPackedPositionForGroup(int groupPosition) {
        return ((((long)groupPosition) & PACKED_POSITION_INT_MASK_GROUP)
                        << PACKED_POSITION_SHIFT_GROUP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.576 -0400", hash_original_method = "E91ADE02598601B56CDD6CB9CE298E24", hash_generated_method = "12633B6475D52B341082745C07A236BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     ContextMenuInfo createContextMenuInfo(View view, int flatListPosition, long id) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(flatListPosition);
        dsTaint.addTaint(view.dsTaint);
        {
            boolean varAC46EC688D3DC3F88FC89B09088E4D69_1002284644 = (isHeaderOrFooterPosition(flatListPosition));
            {
                ContextMenuInfo varA8417C31CED2E7FFB4382724506D542E_87426114 = (new AdapterContextMenuInfo(view, flatListPosition, id));
            } //End block
        } //End collapsed parenthetic
        int adjustedPosition;
        adjustedPosition = getFlatPositionForConnector(flatListPosition);
        PositionMetadata pm;
        pm = mConnector.getUnflattenedPos(adjustedPosition);
        ExpandableListPosition pos;
        pos = pm.position;
        pm.recycle();
        id = getChildOrGroupId(pos);
        long packedPosition;
        packedPosition = pos.getPackedPosition();
        pos.recycle();
        ContextMenuInfo var4DFC5BAE8D86F8A42EC674968D970679_919369520 = (new ExpandableListContextMenuInfo(view, packedPosition, id));
        return (ContextMenuInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (isHeaderOrFooterPosition(flatListPosition)) {
            //return new AdapterContextMenuInfo(view, flatListPosition, id);
        //}
        //final int adjustedPosition = getFlatPositionForConnector(flatListPosition);
        //PositionMetadata pm = mConnector.getUnflattenedPos(adjustedPosition);
        //ExpandableListPosition pos = pm.position;
        //pm.recycle();
        //id = getChildOrGroupId(pos);
        //long packedPosition = pos.getPackedPosition();
        //pos.recycle();
        //return new ExpandableListContextMenuInfo(view, packedPosition, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.576 -0400", hash_original_method = "FEE5EC0BA8444C3E23B9BF5AFE8AF9D9", hash_generated_method = "743DB9EF615EC742A36AD50A6B1AA06C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long getChildOrGroupId(ExpandableListPosition position) {
        dsTaint.addTaint(position.dsTaint);
        {
            long var47BF608F180062BFB18AD6587640E282_1053172022 = (mAdapter.getChildId(position.groupPos, position.childPos));
        } //End block
        {
            long varB0F15D6830B934D417ABA88161FCAC14_383928935 = (mAdapter.getGroupId(position.groupPos));
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (position.type == ExpandableListPosition.CHILD) {
            //return mAdapter.getChildId(position.groupPos, position.childPos);
        //} else {
            //return mAdapter.getGroupId(position.groupPos);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.577 -0400", hash_original_method = "ED7EE4CBDCF7577D87176969D6DCB802", hash_generated_method = "CF334E3B6248AF7FB61E03B3B5886513")
    @DSModeled(DSC.SAFE)
    public void setChildIndicator(Drawable childIndicator) {
        dsTaint.addTaint(childIndicator.dsTaint);
        // ---------- Original Method ----------
        //mChildIndicator = childIndicator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.577 -0400", hash_original_method = "CC0F573BF0E3363C1E0D2AF3089F451E", hash_generated_method = "85F938B64018842EBEAF3789138D555A")
    @DSModeled(DSC.SAFE)
    public void setChildIndicatorBounds(int left, int right) {
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        // ---------- Original Method ----------
        //mChildIndicatorLeft = left;
        //mChildIndicatorRight = right;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.577 -0400", hash_original_method = "23AAB419B9D32765056529A2DC5EA53F", hash_generated_method = "902A4C0756EC1F90DC437D185F88FC7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGroupIndicator(Drawable groupIndicator) {
        dsTaint.addTaint(groupIndicator.dsTaint);
        {
            mIndicatorRight = mIndicatorLeft + mGroupIndicator.getIntrinsicWidth();
        } //End block
        // ---------- Original Method ----------
        //mGroupIndicator = groupIndicator;
        //if (mIndicatorRight == 0 && mGroupIndicator != null) {
            //mIndicatorRight = mIndicatorLeft + mGroupIndicator.getIntrinsicWidth();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.577 -0400", hash_original_method = "442AEE74CE0C61614A47372E9A48F50C", hash_generated_method = "CCFEEB74595A5A62762AF3DB6B4CA339")
    @DSModeled(DSC.SAFE)
    public void setIndicatorBounds(int left, int right) {
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        // ---------- Original Method ----------
        //mIndicatorLeft = left;
        //mIndicatorRight = right;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.578 -0400", hash_original_method = "D1B709DD85334DB90D0ABC47C1E74159", hash_generated_method = "F60FECC7D2646C130D77E39CB3F4233F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState;
        superState = super.onSaveInstanceState();
        Parcelable var50D715290F589FA60705C1C5FDC8CBB3_1771927894 = (new SavedState(superState,
                mConnector != null ? mConnector.getExpandedGroupMetadataList() : null)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //return new SavedState(superState,
                //mConnector != null ? mConnector.getExpandedGroupMetadataList() : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.578 -0400", hash_original_method = "FA4E85B1CE7B753D6AFB9648E78FCCBA", hash_generated_method = "9AA34B548829655B7B6FD2C91350EC88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state.dsTaint);
        {
            super.onRestoreInstanceState(state);
        } //End block
        SavedState ss;
        ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        {
            mConnector.setExpandedGroupMetadataList(ss.expandedGroupMetadataList);
        } //End block
        // ---------- Original Method ----------
        //if (!(state instanceof SavedState)) {
            //super.onRestoreInstanceState(state);
            //return;
        //}
        //SavedState ss = (SavedState) state;
        //super.onRestoreInstanceState(ss.getSuperState());
        //if (mConnector != null && ss.expandedGroupMetadataList != null) {
            //mConnector.setExpandedGroupMetadataList(ss.expandedGroupMetadataList);
        //}
    }

    
    public static class ExpandableListContextMenuInfo implements ContextMenu.ContextMenuInfo {
        public View targetView;
        public long packedPosition;
        public long id;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.578 -0400", hash_original_method = "ACA0779BC3809F87388EA7D4891DD0AD", hash_generated_method = "C28D399D0DD42AAE59EF21A122DEBFB0")
        @DSModeled(DSC.SAFE)
        public ExpandableListContextMenuInfo(View targetView, long packedPosition, long id) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(targetView.dsTaint);
            dsTaint.addTaint(packedPosition);
            // ---------- Original Method ----------
            //this.targetView = targetView;
            //this.packedPosition = packedPosition;
            //this.id = id;
        }

        
    }


    
    static class SavedState extends BaseSavedState {
        ArrayList<ExpandableListConnector.GroupMetadata> expandedGroupMetadataList;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.579 -0400", hash_original_method = "9176098383EC9C7D58FDF70E89009D8B", hash_generated_method = "C06D4AF2C05F1BBE3CB44430D960E5D5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SavedState(
                Parcelable superState,
                ArrayList<ExpandableListConnector.GroupMetadata> expandedGroupMetadataList) {
            super(superState);
            dsTaint.addTaint(superState.dsTaint);
            dsTaint.addTaint(expandedGroupMetadataList.dsTaint);
            // ---------- Original Method ----------
            //this.expandedGroupMetadataList = expandedGroupMetadataList;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.579 -0400", hash_original_method = "D29B1E3F2DF62BC80E56BCC4A8E9B099", hash_generated_method = "BA1BA6DC2C25A6808968C4499533D7E5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private SavedState(Parcel in) {
            super(in);
            dsTaint.addTaint(in.dsTaint);
            expandedGroupMetadataList = new ArrayList<ExpandableListConnector.GroupMetadata>();
            in.readList(expandedGroupMetadataList, ExpandableListConnector.class.getClassLoader());
            // ---------- Original Method ----------
            //expandedGroupMetadataList = new ArrayList<ExpandableListConnector.GroupMetadata>();
            //in.readList(expandedGroupMetadataList, ExpandableListConnector.class.getClassLoader());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.579 -0400", hash_original_method = "AB17BDA53DFB838896B21BA39777EED2", hash_generated_method = "E6CE7F52B6C4384031F6AE2E0B4932E8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void writeToParcel(Parcel out, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(out.dsTaint);
            super.writeToParcel(out, flags);
            out.writeList(expandedGroupMetadataList);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeList(expandedGroupMetadataList);
        }

        
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.580 -0400", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "3FA7D708D9B7EFB7F40F416CA82942C5")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                SavedState var41ED8F3548F5060881BBE51AB9112A3F_1007807681 = (new SavedState(in));
                return (SavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.580 -0400", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "A9A3FBE641982644B350463AC46BD6A8")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                SavedState[] varB5C72E5BBB181D4CA93D7BAA0B8B5E3D_619520635 = (new SavedState[size]);
                return (SavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState[size];
            }

            
}; //Transformed anonymous class
    }


    
    public interface OnGroupCollapseListener {
        
        void onGroupCollapse(int groupPosition);
    }
    
    public interface OnGroupExpandListener {
        
        void onGroupExpand(int groupPosition);
    }
    
    public interface OnGroupClickListener {
        
        boolean onGroupClick(ExpandableListView parent, View v, int groupPosition,
                long id);
    }
    
    public interface OnChildClickListener {
        
        boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                int childPosition, long id);
    }
    
    public static final int PACKED_POSITION_TYPE_GROUP = 0;
    public static final int PACKED_POSITION_TYPE_CHILD = 1;
    public static final int PACKED_POSITION_TYPE_NULL = 2;
    public static final long PACKED_POSITION_VALUE_NULL = 0x00000000FFFFFFFFL;
    private static final long PACKED_POSITION_MASK_CHILD = 0x00000000FFFFFFFFL;
    private static final long PACKED_POSITION_MASK_GROUP = 0x7FFFFFFF00000000L;
    private static final long PACKED_POSITION_MASK_TYPE  = 0x8000000000000000L;
    private static final long PACKED_POSITION_SHIFT_GROUP = 32;
    private static final long PACKED_POSITION_SHIFT_TYPE  = 63;
    private static final long PACKED_POSITION_INT_MASK_CHILD = 0xFFFFFFFF;
    private static final long PACKED_POSITION_INT_MASK_GROUP = 0x7FFFFFFF;
    public static final int CHILD_INDICATOR_INHERIT = -1;
    private static final int[] EMPTY_STATE_SET = {};
    private static final int[] GROUP_EXPANDED_STATE_SET =
            {R.attr.state_expanded};
    private static final int[] GROUP_EMPTY_STATE_SET =
            {R.attr.state_empty};
    private static final int[] GROUP_EXPANDED_EMPTY_STATE_SET =
            {R.attr.state_expanded, R.attr.state_empty};
    private static final int[][] GROUP_STATE_SETS = {
         EMPTY_STATE_SET, 
         GROUP_EXPANDED_STATE_SET, 
         GROUP_EMPTY_STATE_SET, 
         GROUP_EXPANDED_EMPTY_STATE_SET 
    };
    private static final int[] CHILD_LAST_STATE_SET =
            {R.attr.state_last};
}

