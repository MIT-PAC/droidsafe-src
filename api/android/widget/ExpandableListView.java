package android.widget;

// Droidsafe Imports
import java.util.ArrayList;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.ExpandableListConnector.PositionMetadata;

import com.android.internal.R;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ExpandableListView extends ListView {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.490 -0400", hash_original_field = "9D9CB65A7ACD5364D5BD2C2074539F97", hash_generated_field = "FE34358DF167C9E1E63AC77E2A37F15F")

    private ExpandableListConnector mConnector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.490 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "50CBA9C919B713B047967190E3A8BC96")

    private ExpandableListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.490 -0400", hash_original_field = "21E4A6CBA83A7D1A045AB60F401E050C", hash_generated_field = "434428F0996A50D31944C2878AAD16A1")

    private int mIndicatorLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.490 -0400", hash_original_field = "696FD1D58397810B77F74F2BB7C838CC", hash_generated_field = "BB8094FC75AC0BA3C9B8F4CF1268604E")

    private int mIndicatorRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.490 -0400", hash_original_field = "6553D34484AA381248E6660E092C9248", hash_generated_field = "0DA79C52D420D6028700BB7C8910FEFD")

    private int mChildIndicatorLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.490 -0400", hash_original_field = "46254F0FFBB9507CB142007692BE03D2", hash_generated_field = "1C9E41A7B8CB0E401BC23B70CC97D1BF")

    private int mChildIndicatorRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.490 -0400", hash_original_field = "93B59BC53CE83D0C1D131C27CCD5E0FE", hash_generated_field = "B1733A25DCAA61D2D46C3759966CDFC8")

    private Drawable mGroupIndicator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.490 -0400", hash_original_field = "EA3A97EB957D2B535965A8F9394A3C67", hash_generated_field = "7B54373951293DFF2C9D6CDE6C045E25")

    private Drawable mChildIndicator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.490 -0400", hash_original_field = "775A4636C7BBE6BD4213CA024DF15162", hash_generated_field = "AA0C5E1AC01E1496ECE888E4E17EB749")

    private Drawable mChildDivider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.490 -0400", hash_original_field = "A47273C03EF7EF0D223E5C73104CA917", hash_generated_field = "75F1B505E97CBF26CFCC7667594E8799")

    private final Rect mIndicatorRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.490 -0400", hash_original_field = "81B64BAE1B345C313F31814519B81C53", hash_generated_field = "4AE25EFC7015417499591D568114EEE0")

    private OnGroupCollapseListener mOnGroupCollapseListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.490 -0400", hash_original_field = "06FC0365C8C3B182ADF873DF28C92969", hash_generated_field = "10562726C639BB35125692F5C4D1ABBF")

    private OnGroupExpandListener mOnGroupExpandListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.491 -0400", hash_original_field = "52BB6DA8F591AD0BFC953519D4DCA2DF", hash_generated_field = "90010A4046DD0FEDC5C052D5BA45FC4D")

    private OnGroupClickListener mOnGroupClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.491 -0400", hash_original_field = "63F867210F34C2D96BF7D95C89A19622", hash_generated_field = "A18EFBC744D484264D8A553D85190EB1")

    private OnChildClickListener mOnChildClickListener;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.491 -0400", hash_original_method = "883D95D0AB13C2DE7BE0B98484A4295B", hash_generated_method = "2EA684AF9274DBB09C0F16AA97A8F6A3")
    public  ExpandableListView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.491 -0400", hash_original_method = "4019A5446CFBA13B5DEBC7A85D6066EA", hash_generated_method = "487DBE2E3E701FFF6FE203167B0C6C61")
    public  ExpandableListView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.expandableListViewStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.493 -0400", hash_original_method = "9ABBDB13FF145C988C5879C289ADA198", hash_generated_method = "CAAB07915670D00EA4B1196F7DD6D4A6")
    public  ExpandableListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ExpandableListView, defStyle,
                    0);
        mGroupIndicator = a
                .getDrawable(com.android.internal.R.styleable.ExpandableListView_groupIndicator);
        mChildIndicator = a
                .getDrawable(com.android.internal.R.styleable.ExpandableListView_childIndicator);
        mIndicatorLeft = a
                .getDimensionPixelSize(com.android.internal.R.styleable.ExpandableListView_indicatorLeft, 0);
        mIndicatorRight = a
                .getDimensionPixelSize(com.android.internal.R.styleable.ExpandableListView_indicatorRight, 0);
        if(mIndicatorRight == 0 && mGroupIndicator != null)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.496 -0400", hash_original_method = "7A23721B5E073FBA7FD49FF2A748467D", hash_generated_method = "9973091E9A034A5D8A77EE1DBE1BA53F")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        addTaint(canvas.getTaint());
        super.dispatchDraw(canvas);
        if((mChildIndicator == null) && (mGroupIndicator == null))        
        {
            return;
        } //End block
        int saveCount = 0;
        final boolean clipToPadding = (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK;
        if(clipToPadding)        
        {
            saveCount = canvas.save();
            final int scrollX = mScrollX;
            final int scrollY = mScrollY;
            canvas.clipRect(scrollX + mPaddingLeft, scrollY + mPaddingTop,
                    scrollX + mRight - mLeft - mPaddingRight,
                    scrollY + mBottom - mTop - mPaddingBottom);
        } //End block
        final int headerViewsCount = getHeaderViewsCount();
        final int lastChildFlPos = mItemCount - getFooterViewsCount() - headerViewsCount - 1;
        final int myB = mBottom;
        PositionMetadata pos;
        View item;
        Drawable indicator;
        int t;
        int b;
        int lastItemType = ~(ExpandableListPosition.CHILD | ExpandableListPosition.GROUP);
        final Rect indicatorRect = mIndicatorRect;
        final int childCount = getChildCount();
for(int i = 0, childFlPos = mFirstPosition - headerViewsCount;i < childCount;i++,childFlPos++)
        {
            if(childFlPos < 0)            
            {
                continue;
            } //End block
            else
            if(childFlPos > lastChildFlPos)            
            {
                break;
            } //End block
            item = getChildAt(i);
            t = item.getTop();
            b = item.getBottom();
            if((b < 0) || (t > myB))            
            continue;
            pos = mConnector.getUnflattenedPos(childFlPos);
            if(pos.position.type != lastItemType)            
            {
                if(pos.position.type == ExpandableListPosition.CHILD)                
                {
                    indicatorRect.left = (mChildIndicatorLeft == CHILD_INDICATOR_INHERIT) ?
                            mIndicatorLeft : mChildIndicatorLeft;
                    indicatorRect.right = (mChildIndicatorRight == CHILD_INDICATOR_INHERIT) ?
                            mIndicatorRight : mChildIndicatorRight;
                } //End block
                else
                {
                    indicatorRect.left = mIndicatorLeft;
                    indicatorRect.right = mIndicatorRight;
                } //End block
                indicatorRect.left += mPaddingLeft;
                indicatorRect.right += mPaddingLeft;
                lastItemType = pos.position.type;
            } //End block
            if(indicatorRect.left != indicatorRect.right)            
            {
                if(mStackFromBottom)                
                {
                    indicatorRect.top = t;
                    indicatorRect.bottom = b;
                } //End block
                else
                {
                    indicatorRect.top = t;
                    indicatorRect.bottom = b;
                } //End block
                indicator = getIndicator(pos);
                if(indicator != null)                
                {
                    indicator.setBounds(indicatorRect);
                    indicator.draw(canvas);
                } //End block
            } //End block
            pos.recycle();
        } //End block
        if(clipToPadding)        
        {
            canvas.restoreToCount(saveCount);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.498 -0400", hash_original_method = "D5F058A591B90F6E54D4D617313791EB", hash_generated_method = "610C1668F743DEAA4C486876FA99DCC4")
    private Drawable getIndicator(PositionMetadata pos) {
        addTaint(pos.getTaint());
        Drawable indicator;
        if(pos.position.type == ExpandableListPosition.GROUP)        
        {
            indicator = mGroupIndicator;
            if(indicator != null && indicator.isStateful())            
            {
                boolean isEmpty = (pos.groupMetadata == null) ||
                        (pos.groupMetadata.lastChildFlPos == pos.groupMetadata.flPos);
                final int stateSetIndex = (pos.isExpanded() ? 1 : 0) | 
                    (isEmpty ? 2 : 0);
                indicator.setState(GROUP_STATE_SETS[stateSetIndex]);
            } //End block
        } //End block
        else
        {
            indicator = mChildIndicator;
            if(indicator != null && indicator.isStateful())            
            {
                final int stateSet[] = pos.position.flatListPos == pos.groupMetadata.lastChildFlPos
                        ? CHILD_LAST_STATE_SET
                        : EMPTY_STATE_SET;
                indicator.setState(stateSet);
            } //End block
        } //End block
Drawable var971308062B2F7B7C459D4E8FB7EC2C6A_2119577965 =         indicator;
        var971308062B2F7B7C459D4E8FB7EC2C6A_2119577965.addTaint(taint);
        return var971308062B2F7B7C459D4E8FB7EC2C6A_2119577965;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.498 -0400", hash_original_method = "4C83D9B2FEDBCDF12BA1F2A0723CD37C", hash_generated_method = "D780E95EAAAAB38AA0BB5A1E722724BB")
    public void setChildDivider(Drawable childDivider) {
        mChildDivider = childDivider;
        // ---------- Original Method ----------
        //mChildDivider = childDivider;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.498 -0400", hash_original_method = "1C2A86D3B4CD7E5098111C8F9235F268", hash_generated_method = "F599D954146BAE986B6EC234924B5536")
    @Override
     void drawDivider(Canvas canvas, Rect bounds, int childIndex) {
        addTaint(childIndex);
        addTaint(bounds.getTaint());
        addTaint(canvas.getTaint());
        int flatListPosition = childIndex + mFirstPosition;
        if(flatListPosition >= 0)        
        {
            final int adjustedPosition = getFlatPositionForConnector(flatListPosition);
            PositionMetadata pos = mConnector.getUnflattenedPos(adjustedPosition);
            if((pos.position.type == ExpandableListPosition.CHILD) || (pos.isExpanded() &&
                    pos.groupMetadata.lastChildFlPos != pos.groupMetadata.flPos))            
            {
                final Drawable divider = mChildDivider;
                divider.setBounds(bounds);
                divider.draw(canvas);
                pos.recycle();
                return;
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.499 -0400", hash_original_method = "A4E4696C244BB97A42B35DBC06E7550F", hash_generated_method = "509E8C83E398716ED8D8ECB27DA58A6B")
    @Override
    public void setAdapter(ListAdapter adapter) {
        addTaint(adapter.getTaint());
        RuntimeException var224D70F17D360E688837585AA9A40C13_616218599 = new RuntimeException(
                "For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of " +
                "setAdapter(ListAdapter)");
        var224D70F17D360E688837585AA9A40C13_616218599.addTaint(taint);
        throw var224D70F17D360E688837585AA9A40C13_616218599;
        // ---------- Original Method ----------
        //throw new RuntimeException(
                //"For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of " +
                //"setAdapter(ListAdapter)");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.499 -0400", hash_original_method = "1C0E40F01B81CC446BCB9E503587C60C", hash_generated_method = "165CC6537DB8745770DFCCE93DF6F7FD")
    @Override
    public ListAdapter getAdapter() {
ListAdapter varAA65D8278002ADFD88451394EA4A61D4_1024701013 =         super.getAdapter();
        varAA65D8278002ADFD88451394EA4A61D4_1024701013.addTaint(taint);
        return varAA65D8278002ADFD88451394EA4A61D4_1024701013;
        // ---------- Original Method ----------
        //return super.getAdapter();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.499 -0400", hash_original_method = "B7F875362109C546409DA14CD03B0627", hash_generated_method = "57950970811BB7CBD21BBF83A3425EC2")
    @Override
    public void setOnItemClickListener(OnItemClickListener l) {
        addTaint(l.getTaint());
        super.setOnItemClickListener(l);
        // ---------- Original Method ----------
        //super.setOnItemClickListener(l);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.500 -0400", hash_original_method = "86A402EAE8E162910BEF1CBB540CA500", hash_generated_method = "2CD710785175611872F5A7F72F6981EE")
    public void setAdapter(ExpandableListAdapter adapter) {
        mAdapter = adapter;
        if(adapter != null)        
        {
            mConnector = new ExpandableListConnector(adapter);
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.500 -0400", hash_original_method = "0DEBB462BC2A68BA86FC192DC719C116", hash_generated_method = "C0F83D41BC3A0241CD8FCAF378B4A303")
    public ExpandableListAdapter getExpandableListAdapter() {
ExpandableListAdapter varD72668EDE5E63ADF9340F3D8A19FD205_459577770 =         mAdapter;
        varD72668EDE5E63ADF9340F3D8A19FD205_459577770.addTaint(taint);
        return varD72668EDE5E63ADF9340F3D8A19FD205_459577770;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.501 -0400", hash_original_method = "A9D0233B5C169CC66750AD88D31A38E9", hash_generated_method = "F96CE6C85C444F7E1EFF067C454C8380")
    private boolean isHeaderOrFooterPosition(int position) {
        addTaint(position);
        final int footerViewsStart = mItemCount - getFooterViewsCount();
        boolean var7276818B028FE13B0AAE189005383A9D_776015697 = ((position < getHeaderViewsCount() || position >= footerViewsStart));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_281456491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_281456491;
        // ---------- Original Method ----------
        //final int footerViewsStart = mItemCount - getFooterViewsCount();
        //return (position < getHeaderViewsCount() || position >= footerViewsStart);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.501 -0400", hash_original_method = "8FB53CC37B504290AC6948A7A815A683", hash_generated_method = "990A2CC506EF5A76BF28C4AE27229175")
    private int getFlatPositionForConnector(int flatListPosition) {
        addTaint(flatListPosition);
        int var6A21DB79F9B2563E830398C83EF352C0_729312285 = (flatListPosition - getHeaderViewsCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671253558 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671253558;
        // ---------- Original Method ----------
        //return flatListPosition - getHeaderViewsCount();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.501 -0400", hash_original_method = "D8821ADD18913687E76F2B3166416BE8", hash_generated_method = "2F97073096076724328AF199A0B418BE")
    private int getAbsoluteFlatPosition(int flatListPosition) {
        addTaint(flatListPosition);
        int var3FA92EFBCA515063E3D2353A10F1F4EE_566685381 = (flatListPosition + getHeaderViewsCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876984540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876984540;
        // ---------- Original Method ----------
        //return flatListPosition + getHeaderViewsCount();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.501 -0400", hash_original_method = "351E469927E1B73D6D643A520D2ADA68", hash_generated_method = "88B93FAE4F0BD0189092DA8670DC662C")
    @Override
    public boolean performItemClick(View v, int position, long id) {
        addTaint(id);
        addTaint(position);
        addTaint(v.getTaint());
        if(isHeaderOrFooterPosition(position))        
        {
            boolean varB4A4C7A3578A552682F8B412CD517728_869498830 = (super.performItemClick(v, position, id));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1548147431 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1548147431;
        } //End block
        final int adjustedPosition = getFlatPositionForConnector(position);
        boolean varE849F1F0B0FCD72F2623DB1387C28B3B_30429986 = (handleItemClick(v, adjustedPosition, id));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1886446077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1886446077;
        // ---------- Original Method ----------
        //if (isHeaderOrFooterPosition(position)) {
            //return super.performItemClick(v, position, id);
        //}
        //final int adjustedPosition = getFlatPositionForConnector(position);
        //return handleItemClick(v, adjustedPosition, id);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.502 -0400", hash_original_method = "6AFB7BBE8B57133AA9AA93690C5E22BA", hash_generated_method = "934BF6880DFB824ED2BE6AA507604E32")
     boolean handleItemClick(View v, int position, long id) {
        addTaint(id);
        addTaint(position);
        addTaint(v.getTaint());
        final PositionMetadata posMetadata = mConnector.getUnflattenedPos(position);
        id = getChildOrGroupId(posMetadata.position);
        boolean returnValue;
        if(posMetadata.position.type == ExpandableListPosition.GROUP)        
        {
            if(mOnGroupClickListener != null)            
            {
                if(mOnGroupClickListener.onGroupClick(this, v,
                        posMetadata.position.groupPos, id))                
                {
                    posMetadata.recycle();
                    boolean varB326B5062B2F0E69046810717534CB09_1065786129 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1809158582 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1809158582;
                } //End block
            } //End block
            if(posMetadata.isExpanded())            
            {
                mConnector.collapseGroup(posMetadata);
                playSoundEffect(SoundEffectConstants.CLICK);
                if(mOnGroupCollapseListener != null)                
                {
                    mOnGroupCollapseListener.onGroupCollapse(posMetadata.position.groupPos);
                } //End block
            } //End block
            else
            {
                mConnector.expandGroup(posMetadata);
                playSoundEffect(SoundEffectConstants.CLICK);
                if(mOnGroupExpandListener != null)                
                {
                    mOnGroupExpandListener.onGroupExpand(posMetadata.position.groupPos);
                } //End block
                final int groupPos = posMetadata.position.groupPos;
                final int groupFlatPos = posMetadata.position.flatListPos;
                final int shiftedGroupPosition = groupFlatPos + getHeaderViewsCount();
                smoothScrollToPosition(shiftedGroupPosition + mAdapter.getChildrenCount(groupPos),
                        shiftedGroupPosition);
            } //End block
            returnValue = true;
        } //End block
        else
        {
            if(mOnChildClickListener != null)            
            {
                playSoundEffect(SoundEffectConstants.CLICK);
                boolean var2F972DE12E25A186A490BAB7AB7FA8EC_585937722 = (mOnChildClickListener.onChildClick(this, v, posMetadata.position.groupPos,
                        posMetadata.position.childPos, id));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_834940504 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_834940504;
            } //End block
            returnValue = false;
        } //End block
        posMetadata.recycle();
        boolean varA7E53CE21691AB073D9660D615818899_1447751527 = (returnValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1707969154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1707969154;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.508 -0400", hash_original_method = "98581B0D5B3DDD77A367749C65B03049", hash_generated_method = "DB490351397E96D1D7EFFE9121214C2A")
    public boolean expandGroup(int groupPos) {
        addTaint(groupPos);
        boolean var5EF0BF70E71B80878ACFE596B4C29BF8_1830443577 = (expandGroup(groupPos, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_516817473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_516817473;
        // ---------- Original Method ----------
        //return expandGroup(groupPos, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.508 -0400", hash_original_method = "0C4613B5CED32082A0135BD7DC8647D8", hash_generated_method = "077900B39CA6ADB72F5DEC1E634822E3")
    public boolean expandGroup(int groupPos, boolean animate) {
        addTaint(animate);
        addTaint(groupPos);
        PositionMetadata pm = mConnector.getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1));
        boolean retValue = mConnector.expandGroup(pm);
        if(mOnGroupExpandListener != null)        
        {
            mOnGroupExpandListener.onGroupExpand(groupPos);
        } //End block
        if(animate)        
        {
            final int groupFlatPos = pm.position.flatListPos;
            final int shiftedGroupPosition = groupFlatPos + getHeaderViewsCount();
            smoothScrollToPosition(shiftedGroupPosition + mAdapter.getChildrenCount(groupPos),
                    shiftedGroupPosition);
        } //End block
        pm.recycle();
        boolean var9C7BD17E8EB1C3D0F843684A79A18570_1940467010 = (retValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_900391975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_900391975;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.511 -0400", hash_original_method = "32E02BBD4C2448429B8A9BB97BA3197B", hash_generated_method = "470F41C99059A4D18BFEEF82F9FA41DB")
    public boolean collapseGroup(int groupPos) {
        addTaint(groupPos);
        boolean retValue = mConnector.collapseGroup(groupPos);
        if(mOnGroupCollapseListener != null)        
        {
            mOnGroupCollapseListener.onGroupCollapse(groupPos);
        } //End block
        boolean var9C7BD17E8EB1C3D0F843684A79A18570_1374893920 = (retValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1771907866 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1771907866;
        // ---------- Original Method ----------
        //boolean retValue = mConnector.collapseGroup(groupPos);
        //if (mOnGroupCollapseListener != null) {
            //mOnGroupCollapseListener.onGroupCollapse(groupPos);
        //}
        //return retValue;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.512 -0400", hash_original_method = "A0CC4D2398D57CD6BE21425007A2E39D", hash_generated_method = "5DEE1C397DA6B056AD55AB7266513406")
    public void setOnGroupCollapseListener(
            OnGroupCollapseListener onGroupCollapseListener) {
        mOnGroupCollapseListener = onGroupCollapseListener;
        // ---------- Original Method ----------
        //mOnGroupCollapseListener = onGroupCollapseListener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.512 -0400", hash_original_method = "10BB1A471420C27FBFE382BB84A3E76C", hash_generated_method = "41083F8181E5FCFCB921D2750728C23A")
    public void setOnGroupExpandListener(
            OnGroupExpandListener onGroupExpandListener) {
        mOnGroupExpandListener = onGroupExpandListener;
        // ---------- Original Method ----------
        //mOnGroupExpandListener = onGroupExpandListener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.513 -0400", hash_original_method = "C8C3684AA79EC58EA45C462FF87BD202", hash_generated_method = "60F0AD7A476021E95B7ED081EF3A3ED1")
    public void setOnGroupClickListener(OnGroupClickListener onGroupClickListener) {
        mOnGroupClickListener = onGroupClickListener;
        // ---------- Original Method ----------
        //mOnGroupClickListener = onGroupClickListener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.513 -0400", hash_original_method = "26EE7772CEF1895E61E52189D15F9720", hash_generated_method = "41F25A2ADE7B9E9231F61EB2282E9FF4")
    public void setOnChildClickListener(OnChildClickListener onChildClickListener) {
        mOnChildClickListener = onChildClickListener;
        // ---------- Original Method ----------
        //mOnChildClickListener = onChildClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.514 -0400", hash_original_method = "6797E267DF9CCDAD7E03E9610CE356DD", hash_generated_method = "C58765043AD5FDA432D92B99CBB944CA")
    public long getExpandableListPosition(int flatListPosition) {
        addTaint(flatListPosition);
        if(isHeaderOrFooterPosition(flatListPosition))        
        {
            long varDE33DEB6BEBA1EA319054A2291DA62CC_662208603 = (PACKED_POSITION_VALUE_NULL);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_177985546 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_177985546;
        } //End block
        final int adjustedPosition = getFlatPositionForConnector(flatListPosition);
        PositionMetadata pm = mConnector.getUnflattenedPos(adjustedPosition);
        long packedPos = pm.position.getPackedPosition();
        pm.recycle();
        long var39F3EB67F5FEC9B90A5D367FBA83B527_1329501382 = (packedPos);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1583873863 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1583873863;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.514 -0400", hash_original_method = "C3C2613158D48075F4D80761E996AC8D", hash_generated_method = "2B818F0630139D12DB23D172870D7183")
    public int getFlatListPosition(long packedPosition) {
        addTaint(packedPosition);
        PositionMetadata pm = mConnector.getFlattenedPos(ExpandableListPosition
                .obtainPosition(packedPosition));
        final int flatListPosition = pm.position.flatListPos;
        pm.recycle();
        int var86834EF76076A3A8C15E8D23AACAFAEC_750102501 = (getAbsoluteFlatPosition(flatListPosition));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_469479665 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_469479665;
        // ---------- Original Method ----------
        //PositionMetadata pm = mConnector.getFlattenedPos(ExpandableListPosition
                //.obtainPosition(packedPosition));
        //final int flatListPosition = pm.position.flatListPos;
        //pm.recycle();
        //return getAbsoluteFlatPosition(flatListPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.514 -0400", hash_original_method = "249AE284AF367E3E33266910F561E468", hash_generated_method = "8ABCF9E013AFC906B1482B28681AAB30")
    public long getSelectedPosition() {
        final int selectedPos = getSelectedItemPosition();
        long var21EB9647570F899CFA903105BC8572D3_442825889 = (getExpandableListPosition(selectedPos));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_465452585 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_465452585;
        // ---------- Original Method ----------
        //final int selectedPos = getSelectedItemPosition();
        //return getExpandableListPosition(selectedPos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.515 -0400", hash_original_method = "0F549A577DA8ED79E79C3134155D319B", hash_generated_method = "905A4F8A7C0D038B1ED1B38A84FF7C69")
    public long getSelectedId() {
        long packedPos = getSelectedPosition();
        if(packedPos == PACKED_POSITION_VALUE_NULL)        
        {
        long var6BB61E3B7BCE0931DA574D19D1D82C88_114467988 = (-1);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1469906007 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1469906007;
        }
        int groupPos = getPackedPositionGroup(packedPos);
        if(getPackedPositionType(packedPos) == PACKED_POSITION_TYPE_GROUP)        
        {
            long var4BAA205F3E14C0F0DCAFC60A5F8E2396_1337012144 = (mAdapter.getGroupId(groupPos));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_285073231 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_285073231;
        } //End block
        else
        {
            long varE7D4DFA3647C12BFD920AA13B97BC935_1966858077 = (mAdapter.getChildId(groupPos, getPackedPositionChild(packedPos)));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_565519725 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_565519725;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.515 -0400", hash_original_method = "89C81106BDF582AFAD7189203633A87D", hash_generated_method = "DEA524E565B06A120FD67D68A3E121EA")
    public void setSelectedGroup(int groupPosition) {
        addTaint(groupPosition);
        ExpandableListPosition elGroupPos = ExpandableListPosition
                .obtainGroupPosition(groupPosition);
        PositionMetadata pm = mConnector.getFlattenedPos(elGroupPos);
        elGroupPos.recycle();
        final int absoluteFlatPosition = getAbsoluteFlatPosition(pm.position.flatListPos);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.516 -0400", hash_original_method = "1A768FE324BC96140FFAB346485D606B", hash_generated_method = "49E1EED6F80CB7EE374658BD8667401C")
    public boolean setSelectedChild(int groupPosition, int childPosition, boolean shouldExpandGroup) {
        addTaint(shouldExpandGroup);
        addTaint(childPosition);
        addTaint(groupPosition);
        ExpandableListPosition elChildPos = ExpandableListPosition.obtainChildPosition(
                groupPosition, childPosition);
        PositionMetadata flatChildPos = mConnector.getFlattenedPos(elChildPos);
        if(flatChildPos == null)        
        {
            if(!shouldExpandGroup)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1840289893 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1901326868 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1901326868;
            }
            expandGroup(groupPosition);
            flatChildPos = mConnector.getFlattenedPos(elChildPos);
            if(flatChildPos == null)            
            {
                IllegalStateException varDC336CCF78D6046B39036714474778EE_953501232 = new IllegalStateException("Could not find child");
                varDC336CCF78D6046B39036714474778EE_953501232.addTaint(taint);
                throw varDC336CCF78D6046B39036714474778EE_953501232;
            } //End block
        } //End block
        int absoluteFlatPosition = getAbsoluteFlatPosition(flatChildPos.position.flatListPos);
        super.setSelection(absoluteFlatPosition);
        elChildPos.recycle();
        flatChildPos.recycle();
        boolean varB326B5062B2F0E69046810717534CB09_712511379 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213612966 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213612966;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.516 -0400", hash_original_method = "1725653D4BF466A5CF5EF618E531911D", hash_generated_method = "96588C770627C22045EC63AB2027B7A9")
    public boolean isGroupExpanded(int groupPosition) {
        addTaint(groupPosition);
        boolean var77B83D4097659AEFE712F5F5B53CA1B5_1041494611 = (mConnector.isGroupExpanded(groupPosition));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1875598524 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1875598524;
        // ---------- Original Method ----------
        //return mConnector.isGroupExpanded(groupPosition);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getPackedPositionType(long packedPosition) {
        if (packedPosition == PACKED_POSITION_VALUE_NULL) {
            return PACKED_POSITION_TYPE_NULL;
        }
        return (packedPosition & PACKED_POSITION_MASK_TYPE) == PACKED_POSITION_MASK_TYPE
                ? PACKED_POSITION_TYPE_CHILD
                : PACKED_POSITION_TYPE_GROUP;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getPackedPositionGroup(long packedPosition) {
        if (packedPosition == PACKED_POSITION_VALUE_NULL) return -1;
        return (int) ((packedPosition & PACKED_POSITION_MASK_GROUP) >> PACKED_POSITION_SHIFT_GROUP);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getPackedPositionChild(long packedPosition) {
        if (packedPosition == PACKED_POSITION_VALUE_NULL) return -1;
        if ((packedPosition & PACKED_POSITION_MASK_TYPE) != PACKED_POSITION_MASK_TYPE) return -1;
        return (int) (packedPosition & PACKED_POSITION_MASK_CHILD);
    }

    
    @DSModeled(DSC.SAFE)
    public static long getPackedPositionForChild(int groupPosition, int childPosition) {
        return (((long)PACKED_POSITION_TYPE_CHILD) << PACKED_POSITION_SHIFT_TYPE)
                | ((((long)groupPosition) & PACKED_POSITION_INT_MASK_GROUP)
                        << PACKED_POSITION_SHIFT_GROUP)
                | (childPosition & PACKED_POSITION_INT_MASK_CHILD);
    }

    
    @DSModeled(DSC.SAFE)
    public static long getPackedPositionForGroup(int groupPosition) {
        return ((((long)groupPosition) & PACKED_POSITION_INT_MASK_GROUP)
                        << PACKED_POSITION_SHIFT_GROUP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.518 -0400", hash_original_method = "E91ADE02598601B56CDD6CB9CE298E24", hash_generated_method = "079A795C1249E84BFB58C49110DCDB7A")
    @Override
     ContextMenuInfo createContextMenuInfo(View view, int flatListPosition, long id) {
        addTaint(id);
        addTaint(flatListPosition);
        addTaint(view.getTaint());
        if(isHeaderOrFooterPosition(flatListPosition))        
        {
ContextMenuInfo var05D8ECAD324A73CCF3DE760733C4769E_908135139 =             new AdapterContextMenuInfo(view, flatListPosition, id);
            var05D8ECAD324A73CCF3DE760733C4769E_908135139.addTaint(taint);
            return var05D8ECAD324A73CCF3DE760733C4769E_908135139;
        } //End block
        final int adjustedPosition = getFlatPositionForConnector(flatListPosition);
        PositionMetadata pm = mConnector.getUnflattenedPos(adjustedPosition);
        ExpandableListPosition pos = pm.position;
        pm.recycle();
        id = getChildOrGroupId(pos);
        long packedPosition = pos.getPackedPosition();
        pos.recycle();
ContextMenuInfo varAD01B31C4FD33D13A307745D9F704A68_2037856201 =         new ExpandableListContextMenuInfo(view, packedPosition, id);
        varAD01B31C4FD33D13A307745D9F704A68_2037856201.addTaint(taint);
        return varAD01B31C4FD33D13A307745D9F704A68_2037856201;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.518 -0400", hash_original_method = "FEE5EC0BA8444C3E23B9BF5AFE8AF9D9", hash_generated_method = "1E9986FCC8888D06CD160B9FF40FC3C4")
    private long getChildOrGroupId(ExpandableListPosition position) {
        addTaint(position.getTaint());
        if(position.type == ExpandableListPosition.CHILD)        
        {
            long varAFEA7CB9B974749403D2F8182FA89B57_882534160 = (mAdapter.getChildId(position.groupPos, position.childPos));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_715046763 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_715046763;
        } //End block
        else
        {
            long varC17F0746ED83436446DB788321CC57CD_1287412480 = (mAdapter.getGroupId(position.groupPos));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1746244625 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1746244625;
        } //End block
        // ---------- Original Method ----------
        //if (position.type == ExpandableListPosition.CHILD) {
            //return mAdapter.getChildId(position.groupPos, position.childPos);
        //} else {
            //return mAdapter.getGroupId(position.groupPos);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.519 -0400", hash_original_method = "ED7EE4CBDCF7577D87176969D6DCB802", hash_generated_method = "B85C53B974C3327A3C4829D04B8BCB3A")
    public void setChildIndicator(Drawable childIndicator) {
        mChildIndicator = childIndicator;
        // ---------- Original Method ----------
        //mChildIndicator = childIndicator;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.519 -0400", hash_original_method = "CC0F573BF0E3363C1E0D2AF3089F451E", hash_generated_method = "BF1DA63FE85099FCB939914C41345D98")
    public void setChildIndicatorBounds(int left, int right) {
        mChildIndicatorLeft = left;
        mChildIndicatorRight = right;
        // ---------- Original Method ----------
        //mChildIndicatorLeft = left;
        //mChildIndicatorRight = right;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.519 -0400", hash_original_method = "23AAB419B9D32765056529A2DC5EA53F", hash_generated_method = "088D52B692DBDFDB6B95F263B1CBF1EE")
    public void setGroupIndicator(Drawable groupIndicator) {
        mGroupIndicator = groupIndicator;
        if(mIndicatorRight == 0 && mGroupIndicator != null)        
        {
            mIndicatorRight = mIndicatorLeft + mGroupIndicator.getIntrinsicWidth();
        } //End block
        // ---------- Original Method ----------
        //mGroupIndicator = groupIndicator;
        //if (mIndicatorRight == 0 && mGroupIndicator != null) {
            //mIndicatorRight = mIndicatorLeft + mGroupIndicator.getIntrinsicWidth();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.519 -0400", hash_original_method = "442AEE74CE0C61614A47372E9A48F50C", hash_generated_method = "50DE4AE5539179C099ACC4C3916E6A2E")
    public void setIndicatorBounds(int left, int right) {
        mIndicatorLeft = left;
        mIndicatorRight = right;
        // ---------- Original Method ----------
        //mIndicatorLeft = left;
        //mIndicatorRight = right;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.519 -0400", hash_original_method = "D1B709DD85334DB90D0ABC47C1E74159", hash_generated_method = "10936BC7CC945251B33B8D957C224DE9")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState = super.onSaveInstanceState();
Parcelable varF3C1361E263DF410FF171DFF16AA2606_949496709 =         new SavedState(superState,
                mConnector != null ? mConnector.getExpandedGroupMetadataList() : null);
        varF3C1361E263DF410FF171DFF16AA2606_949496709.addTaint(taint);
        return varF3C1361E263DF410FF171DFF16AA2606_949496709;
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //return new SavedState(superState,
                //mConnector != null ? mConnector.getExpandedGroupMetadataList() : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.520 -0400", hash_original_method = "FA4E85B1CE7B753D6AFB9648E78FCCBA", hash_generated_method = "53049994821723480344EB330A636432")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        if(!(state instanceof SavedState))        
        {
            super.onRestoreInstanceState(state);
            return;
        } //End block
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        if(mConnector != null && ss.expandedGroupMetadataList != null)        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.520 -0400", hash_original_field = "5A24EF215C56029F60B6A6CBF69F7CB4", hash_generated_field = "7EF03B9C3ED3327C63848AE59101E3FF")

        public View targetView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.520 -0400", hash_original_field = "22DE58B447B0BDE95E0774E781D1997A", hash_generated_field = "1098F2F73CC2A84B7C54D09679B48A6B")

        public long packedPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.520 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "ED8148F95ABDB86AF6D25639B34D9053")

        public long id;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.520 -0400", hash_original_method = "ACA0779BC3809F87388EA7D4891DD0AD", hash_generated_method = "E417EDDE9B3378E8ED841ABA648E1429")
        public  ExpandableListContextMenuInfo(View targetView, long packedPosition, long id) {
            this.targetView = targetView;
            this.packedPosition = packedPosition;
            this.id = id;
            // ---------- Original Method ----------
            //this.targetView = targetView;
            //this.packedPosition = packedPosition;
            //this.id = id;
        }

        
    }


    
    static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.520 -0400", hash_original_field = "A30E56CBC2E3E5E04CE4548A2228E8CD", hash_generated_field = "882BE828140B4D6DD36411E2A468D4C2")

        ArrayList<ExpandableListConnector.GroupMetadata> expandedGroupMetadataList;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.520 -0400", hash_original_method = "9176098383EC9C7D58FDF70E89009D8B", hash_generated_method = "CA1C5F03FE80508CD688A14F8561B1E0")
          SavedState(
                Parcelable superState,
                ArrayList<ExpandableListConnector.GroupMetadata> expandedGroupMetadataList) {
            super(superState);
            addTaint(superState.getTaint());
            this.expandedGroupMetadataList = expandedGroupMetadataList;
            // ---------- Original Method ----------
            //this.expandedGroupMetadataList = expandedGroupMetadataList;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.520 -0400", hash_original_method = "D29B1E3F2DF62BC80E56BCC4A8E9B099", hash_generated_method = "D43AAB2C77889FFAA82FF5428751E6BE")
        private  SavedState(Parcel in) {
            super(in);
            addTaint(in.getTaint());
            expandedGroupMetadataList = new ArrayList<ExpandableListConnector.GroupMetadata>();
            in.readList(expandedGroupMetadataList, ExpandableListConnector.class.getClassLoader());
            // ---------- Original Method ----------
            //expandedGroupMetadataList = new ArrayList<ExpandableListConnector.GroupMetadata>();
            //in.readList(expandedGroupMetadataList, ExpandableListConnector.class.getClassLoader());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_method = "AB17BDA53DFB838896B21BA39777EED2", hash_generated_method = "9CA1CD760CB88646719BBADF36AFE073")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            addTaint(flags);
            addTaint(out.getTaint());
            super.writeToParcel(out, flags);
            out.writeList(expandedGroupMetadataList);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeList(expandedGroupMetadataList);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        // orphaned legacy method
        public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
        
        // orphaned legacy method
        public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "242821CF1ABF1844C4BC15ECE15757EF", hash_generated_field = "274C21CE7A488F023B0625CA14D88100")

    public static final int PACKED_POSITION_TYPE_GROUP = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "4647183AAF3067E45E4413EB352955FD", hash_generated_field = "4E8C2D4B8B85562458F6C9D66E9E5F03")

    public static final int PACKED_POSITION_TYPE_CHILD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "836A72C8D0B2C4BDD110D4A8D4B98FF0", hash_generated_field = "9D25CF38FF287DAEF83DC57742BD5076")

    public static final int PACKED_POSITION_TYPE_NULL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "A93E3272B54A681BF898F71505AFCDFD", hash_generated_field = "0F2426D399D5691403E0EDA0F36FC6D0")

    public static final long PACKED_POSITION_VALUE_NULL = 0x00000000FFFFFFFFL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "671D9DA189882292C60E64C7DE6900B0", hash_generated_field = "E0FE034FEC282B7F93FFDE72DD2D3219")

    private static final long PACKED_POSITION_MASK_CHILD = 0x00000000FFFFFFFFL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "50484953A19245A47994B7DFB6218114", hash_generated_field = "59A0E712737FBD265DD87ACDCF16737F")

    private static final long PACKED_POSITION_MASK_GROUP = 0x7FFFFFFF00000000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "5FF81EBFEC587DD0EFA59E4639766E6E", hash_generated_field = "D79EFEF9C5FBC1BE7E88BE0E06E0FE4F")

    private static final long PACKED_POSITION_MASK_TYPE = 0x8000000000000000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "BD7FBC5EBBF4EC6DDBE000E8C0EA5A9A", hash_generated_field = "146C19D5B48298B5D734EB44D6768C65")

    private static final long PACKED_POSITION_SHIFT_GROUP = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "8D37E6B05284308A662B0FA2C9CBDA90", hash_generated_field = "14EAC7043F6ABDA410932DEEB6AE5C03")

    private static final long PACKED_POSITION_SHIFT_TYPE = 63;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "A9810A0E73EEB228C0BBBB8F5A2615B6", hash_generated_field = "4D6BC17B5B26166659D5AAD4B1990380")

    private static final long PACKED_POSITION_INT_MASK_CHILD = 0xFFFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "D670C4805F296EFE0CBBB2EC73C933E5", hash_generated_field = "79D45339991F29158AC8A1EBA08E588B")

    private static final long PACKED_POSITION_INT_MASK_GROUP = 0x7FFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "BE2544869DA8A75AE7EFE2A7B61DDD92", hash_generated_field = "93B5880BE1196224A189BBB86B50C2C6")

    public static final int CHILD_INDICATOR_INHERIT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "CB463ABBECF48224567601DF0FF4A6B6", hash_generated_field = "75129B8EA8BF65CAF94DB4FCF5C9C901")

    private static final int[] EMPTY_STATE_SET = {};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "A28AAD2DD7B26DD90CD4C60189E820F8", hash_generated_field = "04B3A62702CD159E93BDFF5FC821FAC4")

    private static final int[] GROUP_EXPANDED_STATE_SET = {R.attr.state_expanded};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "5A8581724A8F592C0D697B9F79381455", hash_generated_field = "CC56A355FBA84512C5E8B1AC68745D92")

    private static final int[] GROUP_EMPTY_STATE_SET = {R.attr.state_empty};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "7AF1D69687F060B82D53944D686A33C0", hash_generated_field = "F510BC18DB870FE705F7C0AC3E6EFD03")

    private static final int[] GROUP_EXPANDED_EMPTY_STATE_SET = {R.attr.state_expanded, R.attr.state_empty};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "231A8B8A4C049B49E330C3B59AC8F1A9", hash_generated_field = "0EC7D4AE41B38F6100D07DD4FBC50240")

    private static final int[][] GROUP_STATE_SETS = {
         EMPTY_STATE_SET, 
         GROUP_EXPANDED_STATE_SET, 
         GROUP_EMPTY_STATE_SET, 
         GROUP_EXPANDED_EMPTY_STATE_SET 
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.521 -0400", hash_original_field = "09432A261A9FE2F4E740C2716E05B569", hash_generated_field = "02D8778C96FFA9BD5271481EC4FB608F")

    private static final int[] CHILD_LAST_STATE_SET = {R.attr.state_last};
}

