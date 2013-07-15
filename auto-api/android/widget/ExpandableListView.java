package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.728 -0400", hash_original_field = "9D9CB65A7ACD5364D5BD2C2074539F97", hash_generated_field = "FE34358DF167C9E1E63AC77E2A37F15F")

    private ExpandableListConnector mConnector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.728 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "50CBA9C919B713B047967190E3A8BC96")

    private ExpandableListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.728 -0400", hash_original_field = "21E4A6CBA83A7D1A045AB60F401E050C", hash_generated_field = "434428F0996A50D31944C2878AAD16A1")

    private int mIndicatorLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.728 -0400", hash_original_field = "696FD1D58397810B77F74F2BB7C838CC", hash_generated_field = "BB8094FC75AC0BA3C9B8F4CF1268604E")

    private int mIndicatorRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.728 -0400", hash_original_field = "6553D34484AA381248E6660E092C9248", hash_generated_field = "0DA79C52D420D6028700BB7C8910FEFD")

    private int mChildIndicatorLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.728 -0400", hash_original_field = "46254F0FFBB9507CB142007692BE03D2", hash_generated_field = "1C9E41A7B8CB0E401BC23B70CC97D1BF")

    private int mChildIndicatorRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.728 -0400", hash_original_field = "93B59BC53CE83D0C1D131C27CCD5E0FE", hash_generated_field = "B1733A25DCAA61D2D46C3759966CDFC8")

    private Drawable mGroupIndicator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.728 -0400", hash_original_field = "EA3A97EB957D2B535965A8F9394A3C67", hash_generated_field = "7B54373951293DFF2C9D6CDE6C045E25")

    private Drawable mChildIndicator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.728 -0400", hash_original_field = "775A4636C7BBE6BD4213CA024DF15162", hash_generated_field = "AA0C5E1AC01E1496ECE888E4E17EB749")

    private Drawable mChildDivider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.728 -0400", hash_original_field = "A47273C03EF7EF0D223E5C73104CA917", hash_generated_field = "75F1B505E97CBF26CFCC7667594E8799")

    private final Rect mIndicatorRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.728 -0400", hash_original_field = "81B64BAE1B345C313F31814519B81C53", hash_generated_field = "4AE25EFC7015417499591D568114EEE0")

    private OnGroupCollapseListener mOnGroupCollapseListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.728 -0400", hash_original_field = "06FC0365C8C3B182ADF873DF28C92969", hash_generated_field = "10562726C639BB35125692F5C4D1ABBF")

    private OnGroupExpandListener mOnGroupExpandListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.728 -0400", hash_original_field = "52BB6DA8F591AD0BFC953519D4DCA2DF", hash_generated_field = "90010A4046DD0FEDC5C052D5BA45FC4D")

    private OnGroupClickListener mOnGroupClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.728 -0400", hash_original_field = "63F867210F34C2D96BF7D95C89A19622", hash_generated_field = "A18EFBC744D484264D8A553D85190EB1")

    private OnChildClickListener mOnChildClickListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.729 -0400", hash_original_method = "883D95D0AB13C2DE7BE0B98484A4295B", hash_generated_method = "2EA684AF9274DBB09C0F16AA97A8F6A3")
    public  ExpandableListView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.729 -0400", hash_original_method = "4019A5446CFBA13B5DEBC7A85D6066EA", hash_generated_method = "FE1954688E9C341CD12595BFDCA677AF")
    public  ExpandableListView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.expandableListViewStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.730 -0400", hash_original_method = "9ABBDB13FF145C988C5879C289ADA198", hash_generated_method = "55C2511260DCEBDD7BBBD7B7BE00FC31")
    public  ExpandableListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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
        {
            mIndicatorRight = mIndicatorLeft + mGroupIndicator.getIntrinsicWidth();
        } 
        mChildIndicatorLeft = a.getDimensionPixelSize(
                com.android.internal.R.styleable.ExpandableListView_childIndicatorLeft, CHILD_INDICATOR_INHERIT);
        mChildIndicatorRight = a.getDimensionPixelSize(
                com.android.internal.R.styleable.ExpandableListView_childIndicatorRight, CHILD_INDICATOR_INHERIT);
        mChildDivider = a.getDrawable(com.android.internal.R.styleable.ExpandableListView_childDivider);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.731 -0400", hash_original_method = "7A23721B5E073FBA7FD49FF2A748467D", hash_generated_method = "3B546B3A792A0207616E5AEE15E95CAA")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int saveCount = 0;
        final boolean clipToPadding = (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK;
        {
            saveCount = canvas.save();
            final int scrollX = mScrollX;
            final int scrollY = mScrollY;
            canvas.clipRect(scrollX + mPaddingLeft, scrollY + mPaddingTop,
                    scrollX + mRight - mLeft - mPaddingRight,
                    scrollY + mBottom - mTop - mPaddingBottom);
        } 
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
        {
            int i = 0;
            int childFlPos = mFirstPosition - headerViewsCount;
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
                    } 
                    {
                        indicatorRect.left = mIndicatorLeft;
                        indicatorRect.right = mIndicatorRight;
                    } 
                    indicatorRect.left += mPaddingLeft;
                    indicatorRect.right += mPaddingLeft;
                    lastItemType = pos.position.type;
                } 
                {
                    {
                        indicatorRect.top = t;
                        indicatorRect.bottom = b;
                    } 
                    {
                        indicatorRect.top = t;
                        indicatorRect.bottom = b;
                    } 
                    indicator = getIndicator(pos);
                    {
                        indicator.setBounds(indicatorRect);
                        indicator.draw(canvas);
                    } 
                } 
                pos.recycle();
            } 
        } 
        {
            canvas.restoreToCount(saveCount);
        } 
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.732 -0400", hash_original_method = "D5F058A591B90F6E54D4D617313791EB", hash_generated_method = "825E9D7F276F84E6B01096959C93C80B")
    private Drawable getIndicator(PositionMetadata pos) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_510313484 = null; 
        Drawable indicator;
        {
            indicator = mGroupIndicator;
            {
                boolean var8D3297736FE853BD77AF38D0B2E570D5_1485142327 = (indicator != null && indicator.isStateful());
                {
                    boolean isEmpty = (pos.groupMetadata == null) ||
                        (pos.groupMetadata.lastChildFlPos == pos.groupMetadata.flPos);
                    final int stateSetIndex = (pos.isExpanded() ? 1 : 0) | 
                    (isEmpty ? 2 : 0);
                    indicator.setState(GROUP_STATE_SETS[stateSetIndex]);
                } 
            } 
        } 
        {
            indicator = mChildIndicator;
            {
                boolean var8D3297736FE853BD77AF38D0B2E570D5_731572671 = (indicator != null && indicator.isStateful());
                {
                    int stateSet[];
                    stateSet = CHILD_LAST_STATE_SET;
                    stateSet = EMPTY_STATE_SET;
                    indicator.setState(stateSet);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_510313484 = indicator;
        addTaint(pos.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_510313484.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_510313484;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.733 -0400", hash_original_method = "4C83D9B2FEDBCDF12BA1F2A0723CD37C", hash_generated_method = "D780E95EAAAAB38AA0BB5A1E722724BB")
    public void setChildDivider(Drawable childDivider) {
        mChildDivider = childDivider;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.733 -0400", hash_original_method = "1C2A86D3B4CD7E5098111C8F9235F268", hash_generated_method = "C0B9D69BAF4971E0C060F7D825F12BFB")
    @Override
     void drawDivider(Canvas canvas, Rect bounds, int childIndex) {
        int flatListPosition = childIndex + mFirstPosition;
        {
            final int adjustedPosition = getFlatPositionForConnector(flatListPosition);
            PositionMetadata pos = mConnector.getUnflattenedPos(adjustedPosition);
            {
                boolean var3815EBF3D278F71CEF6C80EF489C3488_1917133677 = ((pos.position.type == ExpandableListPosition.CHILD) || (pos.isExpanded() &&
                    pos.groupMetadata.lastChildFlPos != pos.groupMetadata.flPos));
                {
                    final Drawable divider = mChildDivider;
                    divider.setBounds(bounds);
                    divider.draw(canvas);
                    pos.recycle();
                } 
            } 
            pos.recycle();
        } 
        super.drawDivider(canvas, bounds, flatListPosition);
        addTaint(canvas.getTaint());
        addTaint(bounds.getTaint());
        addTaint(childIndex);
        
        
        
            
            
            
                    
                
                
                
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.734 -0400", hash_original_method = "A4E4696C244BB97A42B35DBC06E7550F", hash_generated_method = "6754494DC679ADCFF252F8F805CAC44B")
    @Override
    public void setAdapter(ListAdapter adapter) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                "For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of " +
                "setAdapter(ListAdapter)");
        addTaint(adapter.getTaint());
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.734 -0400", hash_original_method = "1C0E40F01B81CC446BCB9E503587C60C", hash_generated_method = "06463B92DC85E9BF7E579843B546B2A6")
    @Override
    public ListAdapter getAdapter() {
        ListAdapter varB4EAC82CA7396A68D541C85D26508E83_368607584 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_368607584 = super.getAdapter();
        varB4EAC82CA7396A68D541C85D26508E83_368607584.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_368607584;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.734 -0400", hash_original_method = "B7F875362109C546409DA14CD03B0627", hash_generated_method = "D09C54A72E72DA868011D4626C78AEFE")
    @Override
    public void setOnItemClickListener(OnItemClickListener l) {
        super.setOnItemClickListener(l);
        addTaint(l.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.735 -0400", hash_original_method = "86A402EAE8E162910BEF1CBB540CA500", hash_generated_method = "1B6C2A593780D4A33DC3EF5298FD5A30")
    public void setAdapter(ExpandableListAdapter adapter) {
        mAdapter = adapter;
        {
            mConnector = new ExpandableListConnector(adapter);
        } 
        {
            mConnector = null;
        } 
        super.setAdapter(mConnector);
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.735 -0400", hash_original_method = "0DEBB462BC2A68BA86FC192DC719C116", hash_generated_method = "F45584527677D2FE780D97831515C3B6")
    public ExpandableListAdapter getExpandableListAdapter() {
        ExpandableListAdapter varB4EAC82CA7396A68D541C85D26508E83_786853573 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_786853573 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_786853573.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_786853573;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.736 -0400", hash_original_method = "A9D0233B5C169CC66750AD88D31A38E9", hash_generated_method = "16CB3C7BAD2562A946278749C05701E2")
    private boolean isHeaderOrFooterPosition(int position) {
        final int footerViewsStart = mItemCount - getFooterViewsCount();
        boolean varB5AE644EE3D805AA9F6DB1D339ED6635_1290814527 = ((position < getHeaderViewsCount() || position >= footerViewsStart));
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1484924027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1484924027;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.736 -0400", hash_original_method = "8FB53CC37B504290AC6948A7A815A683", hash_generated_method = "CDFA1A53AECF64809A27159299D0A08A")
    private int getFlatPositionForConnector(int flatListPosition) {
        int varE9C32C9572990701B6BAF07537D8834F_137280223 = (flatListPosition - getHeaderViewsCount());
        addTaint(flatListPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311505871 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311505871;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.736 -0400", hash_original_method = "D8821ADD18913687E76F2B3166416BE8", hash_generated_method = "5C35A83BB47AC60B7D5C42EA448A52FE")
    private int getAbsoluteFlatPosition(int flatListPosition) {
        int varD2D8EDD83D5BE6348EBC4248326A4A5B_1053861571 = (flatListPosition + getHeaderViewsCount());
        addTaint(flatListPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529424541 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529424541;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.736 -0400", hash_original_method = "351E469927E1B73D6D643A520D2ADA68", hash_generated_method = "ACB540F05E931D082E8344B136F42DEF")
    @Override
    public boolean performItemClick(View v, int position, long id) {
        {
            boolean var37B5E5C58011B39505D3618135B6EE5B_803101227 = (isHeaderOrFooterPosition(position));
            {
                boolean var91F020B48E96B24C861AEA82AC2FA0EA_1853840255 = (super.performItemClick(v, position, id));
            } 
        } 
        final int adjustedPosition = getFlatPositionForConnector(position);
        boolean var4C23AE60DB98858DB93D2D17185BD632_71085990 = (handleItemClick(v, adjustedPosition, id));
        addTaint(v.getTaint());
        addTaint(position);
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_658042823 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_658042823;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.737 -0400", hash_original_method = "6AFB7BBE8B57133AA9AA93690C5E22BA", hash_generated_method = "F5FB7BF33D68AC486F763683C145A2AF")
     boolean handleItemClick(View v, int position, long id) {
        final PositionMetadata posMetadata = mConnector.getUnflattenedPos(position);
        id = getChildOrGroupId(posMetadata.position);
        boolean returnValue;
        {
            {
                {
                    boolean var158618FBFFB709B0E6894F20E3362E16_1505516749 = (mOnGroupClickListener.onGroupClick(this, v,
                        posMetadata.position.groupPos, id));
                    {
                        posMetadata.recycle();
                    } 
                } 
            } 
            {
                boolean varFFE3360DB01E9A6262E0A072169C4E53_2044011922 = (posMetadata.isExpanded());
                {
                    mConnector.collapseGroup(posMetadata);
                    playSoundEffect(SoundEffectConstants.CLICK);
                    {
                        mOnGroupCollapseListener.onGroupCollapse(posMetadata.position.groupPos);
                    } 
                } 
                {
                    mConnector.expandGroup(posMetadata);
                    playSoundEffect(SoundEffectConstants.CLICK);
                    {
                        mOnGroupExpandListener.onGroupExpand(posMetadata.position.groupPos);
                    } 
                    final int groupPos = posMetadata.position.groupPos;
                    final int groupFlatPos = posMetadata.position.flatListPos;
                    final int shiftedGroupPosition = groupFlatPos + getHeaderViewsCount();
                    smoothScrollToPosition(shiftedGroupPosition + mAdapter.getChildrenCount(groupPos),
                        shiftedGroupPosition);
                } 
            } 
            returnValue = true;
        } 
        {
            {
                playSoundEffect(SoundEffectConstants.CLICK);
                boolean var7B6CA2590F067B319E2DCADB7F136527_1353679449 = (mOnChildClickListener.onChildClick(this, v, posMetadata.position.groupPos,
                        posMetadata.position.childPos, id));
            } 
            returnValue = false;
        } 
        posMetadata.recycle();
        addTaint(v.getTaint());
        addTaint(position);
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1402609326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1402609326;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.738 -0400", hash_original_method = "98581B0D5B3DDD77A367749C65B03049", hash_generated_method = "C20BE7A795B35BEB8C6F90671654CF56")
    public boolean expandGroup(int groupPos) {
        boolean var158906FF83ADD7763E372E8503097DFF_203271965 = (expandGroup(groupPos, false));
        addTaint(groupPos);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_321350499 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_321350499;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.738 -0400", hash_original_method = "0C4613B5CED32082A0135BD7DC8647D8", hash_generated_method = "EAADF810FA4F7603D6B75884FEC2A36C")
    public boolean expandGroup(int groupPos, boolean animate) {
        PositionMetadata pm = mConnector.getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1));
        boolean retValue = mConnector.expandGroup(pm);
        {
            mOnGroupExpandListener.onGroupExpand(groupPos);
        } 
        {
            final int groupFlatPos = pm.position.flatListPos;
            final int shiftedGroupPosition = groupFlatPos + getHeaderViewsCount();
            smoothScrollToPosition(shiftedGroupPosition + mAdapter.getChildrenCount(groupPos),
                    shiftedGroupPosition);
        } 
        pm.recycle();
        addTaint(groupPos);
        addTaint(animate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1126640382 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1126640382;
        
        
                
        
        
            
        
        
            
            
            
                    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.738 -0400", hash_original_method = "32E02BBD4C2448429B8A9BB97BA3197B", hash_generated_method = "6D855520F3A37BB369B0AEAB5D74A4A1")
    public boolean collapseGroup(int groupPos) {
        boolean retValue = mConnector.collapseGroup(groupPos);
        {
            mOnGroupCollapseListener.onGroupCollapse(groupPos);
        } 
        addTaint(groupPos);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1425276982 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1425276982;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.739 -0400", hash_original_method = "A0CC4D2398D57CD6BE21425007A2E39D", hash_generated_method = "5DEE1C397DA6B056AD55AB7266513406")
    public void setOnGroupCollapseListener(
            OnGroupCollapseListener onGroupCollapseListener) {
        mOnGroupCollapseListener = onGroupCollapseListener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.739 -0400", hash_original_method = "10BB1A471420C27FBFE382BB84A3E76C", hash_generated_method = "41083F8181E5FCFCB921D2750728C23A")
    public void setOnGroupExpandListener(
            OnGroupExpandListener onGroupExpandListener) {
        mOnGroupExpandListener = onGroupExpandListener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.739 -0400", hash_original_method = "C8C3684AA79EC58EA45C462FF87BD202", hash_generated_method = "60F0AD7A476021E95B7ED081EF3A3ED1")
    public void setOnGroupClickListener(OnGroupClickListener onGroupClickListener) {
        mOnGroupClickListener = onGroupClickListener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.739 -0400", hash_original_method = "26EE7772CEF1895E61E52189D15F9720", hash_generated_method = "41F25A2ADE7B9E9231F61EB2282E9FF4")
    public void setOnChildClickListener(OnChildClickListener onChildClickListener) {
        mOnChildClickListener = onChildClickListener;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.740 -0400", hash_original_method = "6797E267DF9CCDAD7E03E9610CE356DD", hash_generated_method = "B0AEBCEDC80E9C5152BADC4470410F34")
    public long getExpandableListPosition(int flatListPosition) {
        {
            boolean varAC46EC688D3DC3F88FC89B09088E4D69_117874140 = (isHeaderOrFooterPosition(flatListPosition));
        } 
        final int adjustedPosition = getFlatPositionForConnector(flatListPosition);
        PositionMetadata pm = mConnector.getUnflattenedPos(adjustedPosition);
        long packedPos = pm.position.getPackedPosition();
        pm.recycle();
        addTaint(flatListPosition);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_67494516 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_67494516;
        
        
            
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.740 -0400", hash_original_method = "C3C2613158D48075F4D80761E996AC8D", hash_generated_method = "F6627C52D4B9C287BAFA827396ED8577")
    public int getFlatListPosition(long packedPosition) {
        PositionMetadata pm = mConnector.getFlattenedPos(ExpandableListPosition
                .obtainPosition(packedPosition));
        final int flatListPosition = pm.position.flatListPos;
        pm.recycle();
        int var4BF775BF016C7D3B749D646E4615FCE3_1854267449 = (getAbsoluteFlatPosition(flatListPosition));
        addTaint(packedPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_165467746 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_165467746;
        
        
                
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.740 -0400", hash_original_method = "249AE284AF367E3E33266910F561E468", hash_generated_method = "627AF54CA1C97227168CC9FE09E01314")
    public long getSelectedPosition() {
        final int selectedPos = getSelectedItemPosition();
        long varA93AAACA6E31AFE99DAE4E2E735CF124_1600474335 = (getExpandableListPosition(selectedPos));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1546120959 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1546120959;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.741 -0400", hash_original_method = "0F549A577DA8ED79E79C3134155D319B", hash_generated_method = "FC53C84B34007666142A9E3C0CD176F3")
    public long getSelectedId() {
        long packedPos = getSelectedPosition();
        int groupPos = getPackedPositionGroup(packedPos);
        {
            boolean var2C84455863B32CE893D64B61CD7E9447_601226253 = (getPackedPositionType(packedPos) == PACKED_POSITION_TYPE_GROUP);
            {
                long var554AC649873DD7DDC319BC4A4CB37B8C_209746579 = (mAdapter.getGroupId(groupPos));
            } 
            {
                long var41EED02771CC59A8F0A0BD62927C27EF_897218867 = (mAdapter.getChildId(groupPos, getPackedPositionChild(packedPos)));
            } 
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1489171740 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1489171740;
        
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.741 -0400", hash_original_method = "89C81106BDF582AFAD7189203633A87D", hash_generated_method = "CE669013EB150DF7BB23E86B602E6E81")
    public void setSelectedGroup(int groupPosition) {
        ExpandableListPosition elGroupPos = ExpandableListPosition
                .obtainGroupPosition(groupPosition);
        PositionMetadata pm = mConnector.getFlattenedPos(elGroupPos);
        elGroupPos.recycle();
        final int absoluteFlatPosition = getAbsoluteFlatPosition(pm.position.flatListPos);
        super.setSelection(absoluteFlatPosition);
        pm.recycle();
        addTaint(groupPosition);
        
        
                
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.742 -0400", hash_original_method = "1A768FE324BC96140FFAB346485D606B", hash_generated_method = "DA999828FA5ACFD58FEA849ACBDEDA87")
    public boolean setSelectedChild(int groupPosition, int childPosition, boolean shouldExpandGroup) {
        ExpandableListPosition elChildPos = ExpandableListPosition.obtainChildPosition(
                groupPosition, childPosition);
        PositionMetadata flatChildPos = mConnector.getFlattenedPos(elChildPos);
        {
            expandGroup(groupPosition);
            flatChildPos = mConnector.getFlattenedPos(elChildPos);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Could not find child");
            } 
        } 
        int absoluteFlatPosition = getAbsoluteFlatPosition(flatChildPos.position.flatListPos);
        super.setSelection(absoluteFlatPosition);
        elChildPos.recycle();
        flatChildPos.recycle();
        addTaint(groupPosition);
        addTaint(childPosition);
        addTaint(shouldExpandGroup);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1670819537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1670819537;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.742 -0400", hash_original_method = "1725653D4BF466A5CF5EF618E531911D", hash_generated_method = "B979AF2479DB1444F26B2F9110903A44")
    public boolean isGroupExpanded(int groupPosition) {
        boolean var2B505F8E08E38627F154F490260D9B41_1566578405 = (mConnector.isGroupExpanded(groupPosition));
        addTaint(groupPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1253048769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1253048769;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.745 -0400", hash_original_method = "E91ADE02598601B56CDD6CB9CE298E24", hash_generated_method = "BA41E80F4155F23F13E1C5C1778FB044")
    @Override
     ContextMenuInfo createContextMenuInfo(View view, int flatListPosition, long id) {
        ContextMenuInfo varB4EAC82CA7396A68D541C85D26508E83_1462760730 = null; 
        ContextMenuInfo varB4EAC82CA7396A68D541C85D26508E83_2013517519 = null; 
        {
            boolean varAC46EC688D3DC3F88FC89B09088E4D69_1483856256 = (isHeaderOrFooterPosition(flatListPosition));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1462760730 = new AdapterContextMenuInfo(view, flatListPosition, id);
            } 
        } 
        final int adjustedPosition = getFlatPositionForConnector(flatListPosition);
        PositionMetadata pm = mConnector.getUnflattenedPos(adjustedPosition);
        ExpandableListPosition pos = pm.position;
        pm.recycle();
        id = getChildOrGroupId(pos);
        long packedPosition = pos.getPackedPosition();
        pos.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_2013517519 = new ExpandableListContextMenuInfo(view, packedPosition, id);
        addTaint(view.getTaint());
        addTaint(flatListPosition);
        addTaint(id);
        ContextMenuInfo varA7E53CE21691AB073D9660D615818899_1883205301; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1883205301 = varB4EAC82CA7396A68D541C85D26508E83_1462760730;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1883205301 = varB4EAC82CA7396A68D541C85D26508E83_2013517519;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1883205301.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1883205301;
        
        
            
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.746 -0400", hash_original_method = "FEE5EC0BA8444C3E23B9BF5AFE8AF9D9", hash_generated_method = "B4AD6E2A63EC045AFCB0501D86513030")
    private long getChildOrGroupId(ExpandableListPosition position) {
        {
            long var47BF608F180062BFB18AD6587640E282_1019434380 = (mAdapter.getChildId(position.groupPos, position.childPos));
        } 
        {
            long varB0F15D6830B934D417ABA88161FCAC14_660117264 = (mAdapter.getGroupId(position.groupPos));
        } 
        addTaint(position.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_113137155 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_113137155;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.746 -0400", hash_original_method = "ED7EE4CBDCF7577D87176969D6DCB802", hash_generated_method = "B85C53B974C3327A3C4829D04B8BCB3A")
    public void setChildIndicator(Drawable childIndicator) {
        mChildIndicator = childIndicator;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.746 -0400", hash_original_method = "CC0F573BF0E3363C1E0D2AF3089F451E", hash_generated_method = "BF1DA63FE85099FCB939914C41345D98")
    public void setChildIndicatorBounds(int left, int right) {
        mChildIndicatorLeft = left;
        mChildIndicatorRight = right;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.747 -0400", hash_original_method = "23AAB419B9D32765056529A2DC5EA53F", hash_generated_method = "C8D599F5BF162E37723314F5794B673D")
    public void setGroupIndicator(Drawable groupIndicator) {
        mGroupIndicator = groupIndicator;
        {
            mIndicatorRight = mIndicatorLeft + mGroupIndicator.getIntrinsicWidth();
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.747 -0400", hash_original_method = "442AEE74CE0C61614A47372E9A48F50C", hash_generated_method = "50DE4AE5539179C099ACC4C3916E6A2E")
    public void setIndicatorBounds(int left, int right) {
        mIndicatorLeft = left;
        mIndicatorRight = right;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.748 -0400", hash_original_method = "D1B709DD85334DB90D0ABC47C1E74159", hash_generated_method = "1A4E9570D4049A9E6A52E6D2BCC68104")
    @Override
    public Parcelable onSaveInstanceState() {
        
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1463915484 = null; 
        Parcelable superState = super.onSaveInstanceState();
        varB4EAC82CA7396A68D541C85D26508E83_1463915484 = new SavedState(superState,
                mConnector != null ? mConnector.getExpandedGroupMetadataList() : null);
        varB4EAC82CA7396A68D541C85D26508E83_1463915484.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1463915484;
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.748 -0400", hash_original_method = "FA4E85B1CE7B753D6AFB9648E78FCCBA", hash_generated_method = "249926CB251C1DD27DFD172506BA2AB2")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        
        {
            super.onRestoreInstanceState(state);
        } 
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        {
            mConnector.setExpandedGroupMetadataList(ss.expandedGroupMetadataList);
        } 
        addTaint(state.getTaint());
        
        
            
            
        
        
        
        
            
        
    }

    
    public static class ExpandableListContextMenuInfo implements ContextMenu.ContextMenuInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.748 -0400", hash_original_field = "5A24EF215C56029F60B6A6CBF69F7CB4", hash_generated_field = "7EF03B9C3ED3327C63848AE59101E3FF")

        public View targetView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.748 -0400", hash_original_field = "22DE58B447B0BDE95E0774E781D1997A", hash_generated_field = "1098F2F73CC2A84B7C54D09679B48A6B")

        public long packedPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.748 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "ED8148F95ABDB86AF6D25639B34D9053")

        public long id;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.749 -0400", hash_original_method = "ACA0779BC3809F87388EA7D4891DD0AD", hash_generated_method = "E417EDDE9B3378E8ED841ABA648E1429")
        public  ExpandableListContextMenuInfo(View targetView, long packedPosition, long id) {
            this.targetView = targetView;
            this.packedPosition = packedPosition;
            this.id = id;
            
            
            
            
        }

        
    }


    
    static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.749 -0400", hash_original_field = "A30E56CBC2E3E5E04CE4548A2228E8CD", hash_generated_field = "882BE828140B4D6DD36411E2A468D4C2")

        ArrayList<ExpandableListConnector.GroupMetadata> expandedGroupMetadataList;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.749 -0400", hash_original_method = "9176098383EC9C7D58FDF70E89009D8B", hash_generated_method = "A2CB4459C0731B26AE77E14A87B7484B")
          SavedState(
                Parcelable superState,
                ArrayList<ExpandableListConnector.GroupMetadata> expandedGroupMetadataList) {
            super(superState);
            this.expandedGroupMetadataList = expandedGroupMetadataList;
            addTaint(superState.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.749 -0400", hash_original_method = "D29B1E3F2DF62BC80E56BCC4A8E9B099", hash_generated_method = "810AD6E69FA17AF524DB883B14BD4681")
        private  SavedState(Parcel in) {
            super(in);
            expandedGroupMetadataList = new ArrayList<ExpandableListConnector.GroupMetadata>();
            in.readList(expandedGroupMetadataList, ExpandableListConnector.class.getClassLoader());
            addTaint(in.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_method = "AB17BDA53DFB838896B21BA39777EED2", hash_generated_method = "3B45A759199AF77417CEE11C97C2B39E")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeList(expandedGroupMetadataList);
            addTaint(out.getTaint());
            addTaint(flags);
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        
        public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
        
        
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "242821CF1ABF1844C4BC15ECE15757EF", hash_generated_field = "274C21CE7A488F023B0625CA14D88100")

    public static final int PACKED_POSITION_TYPE_GROUP = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "4647183AAF3067E45E4413EB352955FD", hash_generated_field = "4E8C2D4B8B85562458F6C9D66E9E5F03")

    public static final int PACKED_POSITION_TYPE_CHILD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "836A72C8D0B2C4BDD110D4A8D4B98FF0", hash_generated_field = "9D25CF38FF287DAEF83DC57742BD5076")

    public static final int PACKED_POSITION_TYPE_NULL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "A93E3272B54A681BF898F71505AFCDFD", hash_generated_field = "0F2426D399D5691403E0EDA0F36FC6D0")

    public static final long PACKED_POSITION_VALUE_NULL = 0x00000000FFFFFFFFL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "671D9DA189882292C60E64C7DE6900B0", hash_generated_field = "E0FE034FEC282B7F93FFDE72DD2D3219")

    private static final long PACKED_POSITION_MASK_CHILD = 0x00000000FFFFFFFFL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "50484953A19245A47994B7DFB6218114", hash_generated_field = "59A0E712737FBD265DD87ACDCF16737F")

    private static final long PACKED_POSITION_MASK_GROUP = 0x7FFFFFFF00000000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "5FF81EBFEC587DD0EFA59E4639766E6E", hash_generated_field = "D79EFEF9C5FBC1BE7E88BE0E06E0FE4F")

    private static final long PACKED_POSITION_MASK_TYPE = 0x8000000000000000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "BD7FBC5EBBF4EC6DDBE000E8C0EA5A9A", hash_generated_field = "146C19D5B48298B5D734EB44D6768C65")

    private static final long PACKED_POSITION_SHIFT_GROUP = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "8D37E6B05284308A662B0FA2C9CBDA90", hash_generated_field = "14EAC7043F6ABDA410932DEEB6AE5C03")

    private static final long PACKED_POSITION_SHIFT_TYPE = 63;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "A9810A0E73EEB228C0BBBB8F5A2615B6", hash_generated_field = "4D6BC17B5B26166659D5AAD4B1990380")

    private static final long PACKED_POSITION_INT_MASK_CHILD = 0xFFFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "D670C4805F296EFE0CBBB2EC73C933E5", hash_generated_field = "79D45339991F29158AC8A1EBA08E588B")

    private static final long PACKED_POSITION_INT_MASK_GROUP = 0x7FFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "BE2544869DA8A75AE7EFE2A7B61DDD92", hash_generated_field = "93B5880BE1196224A189BBB86B50C2C6")

    public static final int CHILD_INDICATOR_INHERIT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "CB463ABBECF48224567601DF0FF4A6B6", hash_generated_field = "75129B8EA8BF65CAF94DB4FCF5C9C901")

    private static final int[] EMPTY_STATE_SET = {};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "A28AAD2DD7B26DD90CD4C60189E820F8", hash_generated_field = "04B3A62702CD159E93BDFF5FC821FAC4")

    private static final int[] GROUP_EXPANDED_STATE_SET = {R.attr.state_expanded};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "5A8581724A8F592C0D697B9F79381455", hash_generated_field = "CC56A355FBA84512C5E8B1AC68745D92")

    private static final int[] GROUP_EMPTY_STATE_SET = {R.attr.state_empty};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "7AF1D69687F060B82D53944D686A33C0", hash_generated_field = "F510BC18DB870FE705F7C0AC3E6EFD03")

    private static final int[] GROUP_EXPANDED_EMPTY_STATE_SET = {R.attr.state_expanded, R.attr.state_empty};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "231A8B8A4C049B49E330C3B59AC8F1A9", hash_generated_field = "0EC7D4AE41B38F6100D07DD4FBC50240")

    private static final int[][] GROUP_STATE_SETS = {
         EMPTY_STATE_SET, 
         GROUP_EXPANDED_STATE_SET, 
         GROUP_EMPTY_STATE_SET, 
         GROUP_EXPANDED_EMPTY_STATE_SET 
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.750 -0400", hash_original_field = "09432A261A9FE2F4E740C2716E05B569", hash_generated_field = "02D8778C96FFA9BD5271481EC4FB608F")

    private static final int[] CHILD_LAST_STATE_SET = {R.attr.state_last};
}

