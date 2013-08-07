package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.ViewConfiguration;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.content.Context;
import android.view.ViewGroup;
import android.graphics.Canvas;
import android.os.Parcel;
import android.view.KeyEvent;
import android.util.AttributeSet;
import com.android.internal.view.menu.MenuBuilder.ItemInvoker;
import android.view.LayoutInflater;
import android.content.res.Resources;
import android.content.res.TypedArray;
public final class IconMenuView extends ViewGroup implements ItemInvoker, MenuView, Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.390 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.390 -0400", hash_original_field = "6187B9752CDF84EFB9BFFEE96D4434D9", hash_generated_field = "50554ED84AE3E1341AD54F95D6B009DB")

    private int mRowHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.390 -0400", hash_original_field = "A4E6CBF181BDA61881904DC96B92F7D9", hash_generated_field = "650E719F09633C12CA34BCF96EEB93B0")

    private int mMaxRows;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.390 -0400", hash_original_field = "0FFA0622B0631C3E765DE6810D1D5BEE", hash_generated_field = "46A54E1F46C2CF0E99FFE4A07B201C3C")

    private int mMaxItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.390 -0400", hash_original_field = "6C71E92FAEC3499AE41CD4D68DEBFC64", hash_generated_field = "E3370894FBF58595A825ABC6392F2E9C")

    private int mMaxItemsPerRow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.391 -0400", hash_original_field = "2E6E7BF0C75A8D6CB00CD62920171309", hash_generated_field = "5BECA744E87C2676B6BE51FCF525C90A")

    private int mNumActualItemsShown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.391 -0400", hash_original_field = "D1C57CA8D9EE82361687910CA556F92E", hash_generated_field = "D7CDB73D56B1FF7FB1D63B445AB69458")

    private Drawable mHorizontalDivider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.391 -0400", hash_original_field = "D0A02D6417303B83C29DF85F1D173E6D", hash_generated_field = "A8BD0BECC46C1883ACBCF485960920C1")

    private int mHorizontalDividerHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.391 -0400", hash_original_field = "C723017E92BDC1C2602B8DA336A11F74", hash_generated_field = "E2B426EDEB1C06BF2014E5EE12659A45")

    private ArrayList<Rect> mHorizontalDividerRects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.391 -0400", hash_original_field = "D10B6CDFB61D08A536A72BA7035CC288", hash_generated_field = "3E931C1B709E0879CDF4EE780CA07667")

    private Drawable mVerticalDivider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.391 -0400", hash_original_field = "69CFC2A92916644A97F85536C8215C79", hash_generated_field = "FA36B621555F5ED10B3BD7E0F2FD56B3")

    private int mVerticalDividerWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.391 -0400", hash_original_field = "4D57033A379B0ACC0A21FE94C5B53090", hash_generated_field = "099B64162C8861F77DD0B4032F760474")

    private ArrayList<Rect> mVerticalDividerRects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.392 -0400", hash_original_field = "A2F62220C357B9C6BEE2B48A8DC0D543", hash_generated_field = "1B0CBAB88E1806B1A7E7DF8079220B45")

    private Drawable mMoreIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.392 -0400", hash_original_field = "405AB9FB390190D3FBA2635107451DC7", hash_generated_field = "C07C5B821A27F5B0EF8F9331080AA617")

    private Drawable mItemBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.392 -0400", hash_original_field = "4F367D4A038DAB863661E94112DDED08", hash_generated_field = "BE32B37325C289EA5DB8A350DE8A52C6")

    private int mAnimations;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.392 -0400", hash_original_field = "9EC71D9FF24C0CB7C331BC383BEFCD4F", hash_generated_field = "644DB22A4B894D1F9DD7B58C689FC774")

    private boolean mHasStaleChildren;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.392 -0400", hash_original_field = "D8243B63FCF14029C7411C8A470FD356", hash_generated_field = "F5265FF74CD47F66D8D48620B0E6ACE9")

    private boolean mMenuBeingLongpressed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.392 -0400", hash_original_field = "51D0D46FB35F70E5FE16F3B48B47640A", hash_generated_field = "FE86A1AA9D0FF671D15D1A92F24F43E1")

    private boolean mLastChildrenCaptionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.392 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "37BC8D98B8D07DED50A86180790A9B9D")

    private int[] mLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.392 -0400", hash_original_field = "8149BDA6F624F79E5EF371C2EC01A891", hash_generated_field = "1D36D7537B85426DBB34EFBD58FDFF59")

    private int mLayoutNumRows;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.394 -0400", hash_original_method = "0D98049E3DCF0B0B79B4780ADF666819", hash_generated_method = "5DBFD5F66F92F86CE4137C0321A38F64")
    public  IconMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.IconMenuView, 0, 0);
mRowHeight=a.getDimensionPixelSize(com.android.internal.R.styleable.IconMenuView_rowHeight, 64)mMaxRows=a.getInt(com.android.internal.R.styleable.IconMenuView_maxRows, 2)mMaxItems=a.getInt(com.android.internal.R.styleable.IconMenuView_maxItems, 6)mMaxItemsPerRow=a.getInt(com.android.internal.R.styleable.IconMenuView_maxItemsPerRow, 3)mMoreIcon=a.getDrawable(com.android.internal.R.styleable.IconMenuView_moreIcon)a.recycle()a=context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.MenuView, 0, 0)mItemBackground=a.getDrawable(com.android.internal.R.styleable.MenuView_itemBackground)mHorizontalDivider=a.getDrawable(com.android.internal.R.styleable.MenuView_horizontalDivider)mHorizontalDividerRects=new ArrayList<Rect>()mVerticalDivider=a.getDrawable(com.android.internal.R.styleable.MenuView_verticalDivider)mVerticalDividerRects=new ArrayList<Rect>()mAnimations=a.getResourceId(com.android.internal.R.styleable.MenuView_windowAnimationStyle, 0)a.recycle()        if(mHorizontalDivider!=null)        
        {
mHorizontalDividerHeight=mHorizontalDivider.getIntrinsicHeight()            if(mHorizontalDividerHeight==-1)            
mHorizontalDividerHeight=1
        } //End block
        if(mVerticalDivider!=null)        
        {
mVerticalDividerWidth=mVerticalDivider.getIntrinsicWidth()            if(mVerticalDividerWidth==-1)            
mVerticalDividerWidth=1
        } //End block
mLayout=new intsetWillNotDraw(false)setFocusableInTouchMode(true)setDescendantFocusability(FOCUS_AFTER_DESCENDANTS)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.396 -0400", hash_original_method = "108D75EE7327D908D864A4E8DACF487B", hash_generated_method = "D231AA65F06FEB246CE01E34611920E6")
     int getMaxItems() {
        int var0FFA0622B0631C3E765DE6810D1D5BEE_2052033051 = (mMaxItems);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_513072221 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_513072221;
        // ---------- Original Method ----------
        //return mMaxItems;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.397 -0400", hash_original_method = "C8C0C7A546F219CB7EBA97386ADA6910", hash_generated_method = "87557DDD093AE02D39D2A55A8536D6E3")
    private void layoutItems(int width) {
        addTaint(width);
        int numItems = getChildCount();
        if(numItems==0)        
        {
mLayoutNumRows=0            return;
        } //End block
        int curNumRows = Math.min((int) Math.ceil(numItems / (float) mMaxItemsPerRow), mMaxRows);
for(;curNumRows<=mMaxRows;curNumRows)
        {
layoutItemsUsingGravity(curNumRows, numItems)            if(curNumRows>=numItems)            
            {
                break;
            } //End block
            if(doItemsFit())            
            {
                break;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int numItems = getChildCount();
        //if (numItems == 0) {
            //mLayoutNumRows = 0;
            //return;
        //}
        //int curNumRows =
                //Math.min((int) Math.ceil(numItems / (float) mMaxItemsPerRow), mMaxRows);
        //for (; curNumRows <= mMaxRows; curNumRows++) {
            //layoutItemsUsingGravity(curNumRows, numItems);
            //if (curNumRows >= numItems) {
                //break;
            //}
            //if (doItemsFit()) {
                //break;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.398 -0400", hash_original_method = "15F3DD2CCEEE48DD8745D08C5D9782E0", hash_generated_method = "2618A279661C16998C20643F703101E2")
    private void layoutItemsUsingGravity(int numRows, int numItems) {
        addTaint(numItems);
        addTaint(numRows);
        int numBaseItemsPerRow = numItems / numRows;
        int numLeftoverItems = numItems % numRows;
        int rowsThatGetALeftoverItem = numRows - numLeftoverItems;
        int[] layout = mLayout;
for(int i = 0;i<numRows;i)
        {
layout[i]=numBaseItemsPerRow            if(i>=rowsThatGetALeftoverItem)            
            {
layout[i]
            } //End block
        } //End block
mLayoutNumRows=numRows
        // ---------- Original Method ----------
        //int numBaseItemsPerRow = numItems / numRows;
        //int numLeftoverItems = numItems % numRows;
        //int rowsThatGetALeftoverItem = numRows - numLeftoverItems;
        //int[] layout = mLayout;
        //for (int i = 0; i < numRows; i++) {
            //layout[i] = numBaseItemsPerRow;
            //if (i >= rowsThatGetALeftoverItem) {
                //layout[i]++;
            //}
        //}
        //mLayoutNumRows = numRows;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.400 -0400", hash_original_method = "4CAE73F9E2C20E210A336A18A45A6289", hash_generated_method = "43B321E6BEFF9C4756E2D52BB9B81B97")
    private boolean doItemsFit() {
        int itemPos = 0;
        int[] layout = mLayout;
        int numRows = mLayoutNumRows;
for(int row = 0;row<numRows;row)
        {
            int numItemsOnRow = layout[row];
            if(numItemsOnRow==1)            
            {
itemPos                continue;
            } //End block
for(int itemsOnRowCounter = numItemsOnRow;itemsOnRowCounter>0;itemsOnRowCounter)
            {
                View child = getChildAt(itemPos++);
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if(lp.maxNumItemsOnRow<numItemsOnRow)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_748293422 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406027542 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406027542;
                } //End block
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_2029058804 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1560884392 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1560884392;
        // ---------- Original Method ----------
        //int itemPos = 0;
        //int[] layout = mLayout;
        //int numRows = mLayoutNumRows;
        //for (int row = 0; row < numRows; row++) {
            //int numItemsOnRow = layout[row];
            //if (numItemsOnRow == 1) {
                //itemPos++;
                //continue;
            //}
            //for (int itemsOnRowCounter = numItemsOnRow; itemsOnRowCounter > 0;
                    //itemsOnRowCounter--) {
                //View child = getChildAt(itemPos++);
                //LayoutParams lp = (LayoutParams) child.getLayoutParams();
                //if (lp.maxNumItemsOnRow < numItemsOnRow) {
                    //return false;
                //}
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.402 -0400", hash_original_method = "342FE30B08D1FB3D755218650DF3E588", hash_generated_method = "35774D1FDE443EEC24569A670C85E894")
     Drawable getItemBackgroundDrawable() {
Drawable varD595CE8EFBDF825E0F7A6EB163097DE9_1628221743 = mItemBackground.getConstantState().newDrawable(getContext().getResources())        varD595CE8EFBDF825E0F7A6EB163097DE9_1628221743.addTaint(taint);
        return varD595CE8EFBDF825E0F7A6EB163097DE9_1628221743;
        // ---------- Original Method ----------
        //return mItemBackground.getConstantState().newDrawable(getContext().getResources());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.404 -0400", hash_original_method = "918AFD9207BD2C1E1C4E088E2C1F561D", hash_generated_method = "9F6C9AC19B2836F4AEC6B16893E3F370")
     IconMenuItemView createMoreItemView() {
        Context context = getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        final IconMenuItemView itemView = (IconMenuItemView) inflater.inflate(
                com.android.internal.R.layout.icon_menu_item_layout, null);
        Resources r = context.getResources();
itemView.initialize(r.getText(com.android.internal.R.string.more_item_label), mMoreIcon)itemView.setOnClickListener(new OnClickListener()        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.403 -0400", hash_original_method = "7BFFD8EA2C2E6C533383BC34EACDA8FD", hash_generated_method = "E5FECBA480DE9B0A4AFDEE82EE8ABFF4")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
mMenu.changeMenuMode()
            // ---------- Original Method ----------
            //mMenu.changeMenuMode();
        }
        }
)IconMenuItemView var881FC3AA4A0DDCD288F4D725F4A53FB0_1967699691 = itemView        var881FC3AA4A0DDCD288F4D725F4A53FB0_1967699691.addTaint(taint);
        return var881FC3AA4A0DDCD288F4D725F4A53FB0_1967699691;
        // ---------- Original Method ----------
        //Context context = getContext();
        //LayoutInflater inflater = LayoutInflater.from(context);
        //final IconMenuItemView itemView = (IconMenuItemView) inflater.inflate(
                //com.android.internal.R.layout.icon_menu_item_layout, null);
        //Resources r = context.getResources();
        //itemView.initialize(r.getText(com.android.internal.R.string.more_item_label), mMoreIcon);
        //itemView.setOnClickListener(new OnClickListener() {
            //public void onClick(View v) {
                //mMenu.changeMenuMode();
            //}
        //});
        //return itemView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.404 -0400", hash_original_method = "EDB3B7E883C1486DD9AED3AB15C0E44B", hash_generated_method = "64DE7C333E040109CC9BE0A8C5E99770")
    public void initialize(MenuBuilder menu) {
        addTaint(menu.getTaint());
mMenu=menu
        // ---------- Original Method ----------
        //mMenu = menu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.406 -0400", hash_original_method = "6B975B236D38733D8D97A87E4CBCD8AE", hash_generated_method = "30EC55F8B4F983D64024B4E4653A1DFD")
    private void positionChildren(int menuWidth, int menuHeight) {
        addTaint(menuHeight);
        addTaint(menuWidth);
        if(mHorizontalDivider!=null)        
mHorizontalDividerRects.clear()
        if(mVerticalDivider!=null)        
mVerticalDividerRects.clear()
        final int numRows = mLayoutNumRows;
        final int numRowsMinus1 = numRows - 1;
        final int numItemsForRow[] = mLayout;
        int itemPos = 0;
        View child;
        IconMenuView.LayoutParams childLayoutParams = null;
        float itemLeft;
        float itemTop = 0;
        float itemWidth;
        final float itemHeight = (menuHeight - mHorizontalDividerHeight * (numRows - 1))
                / (float)numRows;
for(int row = 0;row<numRows;row)
        {
itemLeft=0itemWidth=(menuWidth-mVerticalDividerWidth*(numItemsForRow[row]-1))/(float) numItemsForRow[row]for(int itemPosOnRow = 0;itemPosOnRow<numItemsForRow[row];itemPosOnRow)
            {
child=getChildAt(itemPos)child.measure(MeasureSpec.makeMeasureSpec((int) itemWidth, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec((int) itemHeight, MeasureSpec.EXACTLY))childLayoutParams=(IconMenuView.LayoutParams) child.getLayoutParams()childLayoutParams.left=(int) itemLeftchildLayoutParams.right=(int) (itemLeft+itemWidth)childLayoutParams.top=(int) itemTopchildLayoutParams.bottom=(int) (itemTop+itemHeight)itemLeft+=itemWidthitemPos                if(mVerticalDivider!=null)                
                {
mVerticalDividerRects.add(new Rect((int) itemLeft, (int) itemTop, (int) (itemLeft+mVerticalDividerWidth), (int) (itemTop+itemHeight)))
                } //End block
itemLeft+=mVerticalDividerWidth
            } //End block
            if(childLayoutParams!=null)            
            {
childLayoutParams.right=menuWidth
            } //End block
itemTop+=itemHeight            if((mHorizontalDivider!=null)&&(row<numRowsMinus1))            
            {
mHorizontalDividerRects.add(new Rect(0, (int) itemTop, menuWidth, (int) (itemTop+mHorizontalDividerHeight)))itemTop+=mHorizontalDividerHeight
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.410 -0400", hash_original_method = "EDB3F8162AECACC833E5C2CFE32AF75C", hash_generated_method = "099F8E3C7A73B91A081CAA98A52E9C94")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        int measuredWidth = resolveSize(Integer.MAX_VALUE, widthMeasureSpec);
calculateItemFittingMetadata(measuredWidth)layoutItems(measuredWidth)        final int layoutNumRows = mLayoutNumRows;
        final int desiredHeight = (mRowHeight + mHorizontalDividerHeight) *
                layoutNumRows - mHorizontalDividerHeight;
setMeasuredDimension(measuredWidth, resolveSize(desiredHeight, heightMeasureSpec))        if(layoutNumRows>0)        
        {
positionChildren(getMeasuredWidth(), getMeasuredHeight())
        } //End block
        // ---------- Original Method ----------
        //int measuredWidth = resolveSize(Integer.MAX_VALUE, widthMeasureSpec);
        //calculateItemFittingMetadata(measuredWidth);
        //layoutItems(measuredWidth);
        //final int layoutNumRows = mLayoutNumRows;
        //final int desiredHeight = (mRowHeight + mHorizontalDividerHeight) *
                //layoutNumRows - mHorizontalDividerHeight;
        //setMeasuredDimension(measuredWidth,
                //resolveSize(desiredHeight, heightMeasureSpec));
        //if (layoutNumRows > 0) {
            //positionChildren(getMeasuredWidth(), getMeasuredHeight());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.411 -0400", hash_original_method = "DC7318F4A96694F755DACF211BFD8BCE", hash_generated_method = "CE93BC29B5198B752D6F88D929072E5A")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(changed);
        View child;
        IconMenuView.LayoutParams childLayoutParams;
for(int i = getChildCount() - 1;i>=0;i)
        {
child=getChildAt(i)childLayoutParams=(IconMenuView.LayoutParams) child.getLayoutParams()child.layout(childLayoutParams.left, childLayoutParams.top, childLayoutParams.right, childLayoutParams.bottom)
        } //End block
        // ---------- Original Method ----------
        //View child;
        //IconMenuView.LayoutParams childLayoutParams;
        //for (int i = getChildCount() - 1; i >= 0; i--) {
            //child = getChildAt(i);
            //childLayoutParams = (IconMenuView.LayoutParams)child
                    //.getLayoutParams();
            //child.layout(childLayoutParams.left, childLayoutParams.top, childLayoutParams.right,
                    //childLayoutParams.bottom);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.413 -0400", hash_original_method = "D3B7E8035E214B05048CDEAC905E068A", hash_generated_method = "007E989E1C49057B54DF4D553B57FC23")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        Drawable drawable = mHorizontalDivider;
        if(drawable!=null)        
        {
            final ArrayList<Rect> rects = mHorizontalDividerRects;
for(int i = rects.size() - 1;i>=0;i)
            {
drawable.setBounds(rects.get(i))drawable.draw(canvas)
            } //End block
        } //End block
drawable=mVerticalDivider        if(drawable!=null)        
        {
            final ArrayList<Rect> rects = mVerticalDividerRects;
for(int i = rects.size() - 1;i>=0;i)
            {
drawable.setBounds(rects.get(i))drawable.draw(canvas)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Drawable drawable = mHorizontalDivider;
        //if (drawable != null) {
            //final ArrayList<Rect> rects = mHorizontalDividerRects;
            //for (int i = rects.size() - 1; i >= 0; i--) {
                //drawable.setBounds(rects.get(i));
                //drawable.draw(canvas);
            //}
        //}
        //drawable = mVerticalDivider;
        //if (drawable != null) {
            //final ArrayList<Rect> rects = mVerticalDividerRects;
            //for (int i = rects.size() - 1; i >= 0; i--) {
                //drawable.setBounds(rects.get(i));
                //drawable.draw(canvas);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.414 -0400", hash_original_method = "52251A4D38FF83C9B55C46C571A25CAE", hash_generated_method = "44C76FC6BEFE3897E3CE3A8CEEE47D77")
    public boolean invokeItem(MenuItemImpl item) {
        addTaint(item.getTaint());
        boolean var9CE0C397DB4ABF248543C034E9F3CC19_694751622 = (mMenu.performItemAction(item, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_7926551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_7926551;
        // ---------- Original Method ----------
        //return mMenu.performItemAction(item, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.415 -0400", hash_original_method = "26F92B771E79AE804A49D5FEE2186C8A", hash_generated_method = "1E2BDFF88B9152243CF29315B3F7B615")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        addTaint(attrs.getTaint());
LayoutParams var139B5A2FA7D73457CF194F496E9CB16A_1133651934 = new IconMenuView.LayoutParams(getContext(), attrs)        var139B5A2FA7D73457CF194F496E9CB16A_1133651934.addTaint(taint);
        return var139B5A2FA7D73457CF194F496E9CB16A_1133651934;
        // ---------- Original Method ----------
        //return new IconMenuView.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.416 -0400", hash_original_method = "C6170839D0C24530AF40D6B41DC89AE3", hash_generated_method = "5A6D804E53CA54769E4E7B9B1520EA2C")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean varF21AA847B5D67F96A5B6BA8EAA259D55_1386052466 = (p instanceof IconMenuView.LayoutParams);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1532974844 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1532974844;
        // ---------- Original Method ----------
        //return p instanceof IconMenuView.LayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.416 -0400", hash_original_method = "D366EB4474B58C92DE0B49A58CD76C7E", hash_generated_method = "DFB52437EDCD7081C0BDDF954ABCDC85")
     void markStaleChildren() {
        if(!mHasStaleChildren)        
        {
mHasStaleChildren=truerequestLayout()
        } //End block
        // ---------- Original Method ----------
        //if (!mHasStaleChildren) {
            //mHasStaleChildren = true;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.417 -0400", hash_original_method = "2E7382510CFF7F381BDC957C5A430D1D", hash_generated_method = "C5D6BE9B4D0FC6546E164A4CCD00B8E1")
     int getNumActualItemsShown() {
        int var2E6E7BF0C75A8D6CB00CD62920171309_1103469537 = (mNumActualItemsShown);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2074516828 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2074516828;
        // ---------- Original Method ----------
        //return mNumActualItemsShown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.417 -0400", hash_original_method = "D2A195F905DEAD0253E2450B9B916022", hash_generated_method = "D27494188DA273405704BC7337F75A4D")
     void setNumActualItemsShown(int count) {
        addTaint(count);
mNumActualItemsShown=count
        // ---------- Original Method ----------
        //mNumActualItemsShown = count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.418 -0400", hash_original_method = "02CB30F0EA5DFC81374866D1443F8CD5", hash_generated_method = "9690D2E43CABC30E60DC160D7661B468")
    public int getWindowAnimations() {
        int var4F367D4A038DAB863661E94112DDED08_364727421 = (mAnimations);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732981544 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732981544;
        // ---------- Original Method ----------
        //return mAnimations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.419 -0400", hash_original_method = "0A6D0BA513C188E58DB5D6B83033FC1C", hash_generated_method = "4CEA15E0F5AAF35BC0011114C796F151")
    public int[] getLayout() {
        int[] varAF58F50E47532278404C3D8470630FC4_1466935274 = (mLayout);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_906617731 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_906617731;
        // ---------- Original Method ----------
        //return mLayout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.420 -0400", hash_original_method = "0196BB4EF1DF8907F2478175D6EDA5BE", hash_generated_method = "61DBE1B55382E187A03DED1468C4DBF9")
    public int getLayoutNumRows() {
        int var8149BDA6F624F79E5EF371C2EC01A891_51383122 = (mLayoutNumRows);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064326740 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064326740;
        // ---------- Original Method ----------
        //return mLayoutNumRows;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.422 -0400", hash_original_method = "D40C17BF4E36F8FA59B3A091DC2FD968", hash_generated_method = "3369538B013917758DFDECA691318A13")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        if(event.getKeyCode()==KeyEvent.KEYCODE_MENU)        
        {
            if(event.getAction()==KeyEvent.ACTION_DOWN&&event.getRepeatCount()==0)            
            {
removeCallbacks(this)postDelayed(this, ViewConfiguration.getLongPressTimeout())
            } //End block
            else
            if(event.getAction()==KeyEvent.ACTION_UP)            
            {
                if(mMenuBeingLongpressed)                
                {
setCycleShortcutCaptionMode(false)                    boolean varB326B5062B2F0E69046810717534CB09_601498316 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1451890668 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1451890668;
                } //End block
                else
                {
removeCallbacks(this)
                } //End block
            } //End block
        } //End block
        boolean var639DD27D10E8FF69097B1398D445D1B9_115126538 = (super.dispatchKeyEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1169119406 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1169119406;
        // ---------- Original Method ----------
        //if (event.getKeyCode() == KeyEvent.KEYCODE_MENU) {
            //if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                //removeCallbacks(this);
                //postDelayed(this, ViewConfiguration.getLongPressTimeout());
            //} else if (event.getAction() == KeyEvent.ACTION_UP) {
                //if (mMenuBeingLongpressed) {
                    //setCycleShortcutCaptionMode(false);
                    //return true;
                //} else {
                    //removeCallbacks(this);
                //}
            //}
        //}
        //return super.dispatchKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.423 -0400", hash_original_method = "AC8CADB4985D382072198F95CA72CEBB", hash_generated_method = "B6370133BB861E1A219AB04AFDCB7E81")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
super.onAttachedToWindow()requestFocus()
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //requestFocus();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.423 -0400", hash_original_method = "4FCF3D1FDA8CE4D7D0697CE02F867DA9", hash_generated_method = "093B9D0E7B1E2FE1B572270FD24028BE")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
setCycleShortcutCaptionMode(false)super.onDetachedFromWindow()
        // ---------- Original Method ----------
        //setCycleShortcutCaptionMode(false);
        //super.onDetachedFromWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.424 -0400", hash_original_method = "2F4414D7A88BA8DC843C3C24FE02C2AC", hash_generated_method = "5A9707D02883BC2F0487CEDFBB50F37B")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasWindowFocus);
        if(!hasWindowFocus)        
        {
setCycleShortcutCaptionMode(false)
        } //End block
super.onWindowFocusChanged(hasWindowFocus)
        // ---------- Original Method ----------
        //if (!hasWindowFocus) {
            //setCycleShortcutCaptionMode(false);
        //}
        //super.onWindowFocusChanged(hasWindowFocus);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.424 -0400", hash_original_method = "EAA7C0BCFAB219D9AE1C36741A30726F", hash_generated_method = "83982DC6F41968DECD9D007F9C6DECBF")
    private void setCycleShortcutCaptionMode(boolean cycleShortcutAndNormal) {
        addTaint(cycleShortcutAndNormal);
        if(!cycleShortcutAndNormal)        
        {
removeCallbacks(this)setChildrenCaptionMode(false)mMenuBeingLongpressed=false
        } //End block
        else
        {
setChildrenCaptionMode(true)
        } //End block
        // ---------- Original Method ----------
        //if (!cycleShortcutAndNormal) {
            //removeCallbacks(this);
            //setChildrenCaptionMode(false);
            //mMenuBeingLongpressed = false;
        //} else {
            //setChildrenCaptionMode(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.425 -0400", hash_original_method = "89F2C35600300C50A3DBB522D6A4DDE2", hash_generated_method = "0EEFF37D6441F55058D6B1420207DFFB")
    public void run() {
        if(mMenuBeingLongpressed)        
        {
setChildrenCaptionMode(!mLastChildrenCaptionMode)
        } //End block
        else
        {
mMenuBeingLongpressed=truesetCycleShortcutCaptionMode(true)
        } //End block
postDelayed(this, ITEM_CAPTION_CYCLE_DELAY)
        // ---------- Original Method ----------
        //if (mMenuBeingLongpressed) {
            //setChildrenCaptionMode(!mLastChildrenCaptionMode);
        //} else {
            //mMenuBeingLongpressed = true;
            //setCycleShortcutCaptionMode(true);
        //}
        //postDelayed(this, ITEM_CAPTION_CYCLE_DELAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.426 -0400", hash_original_method = "C57B8AA3741F7E114665F300DB39D7AA", hash_generated_method = "45A058622DA327587CF69216C5985EF8")
    private void setChildrenCaptionMode(boolean shortcut) {
        addTaint(shortcut);
mLastChildrenCaptionMode=shortcutfor(int i = getChildCount() - 1;i>=0;i)
        {
((IconMenuItemView) getChildAt(i)).setCaptionMode(shortcut)
        } //End block
        // ---------- Original Method ----------
        //mLastChildrenCaptionMode = shortcut;
        //for (int i = getChildCount() - 1; i >= 0; i--) {
            //((IconMenuItemView) getChildAt(i)).setCaptionMode(shortcut);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.427 -0400", hash_original_method = "18307823C6D4849DA161FBBDECA74E79", hash_generated_method = "5EEDD939B9B036363F39A3A73E01F43E")
    private void calculateItemFittingMetadata(int width) {
        addTaint(width);
        int maxNumItemsPerRow = mMaxItemsPerRow;
        int numItems = getChildCount();
for(int i = 0;i<numItems;i)
        {
            LayoutParams lp = (LayoutParams) getChildAt(i).getLayoutParams();
lp.maxNumItemsOnRow=1for(int curNumItemsPerRow = maxNumItemsPerRow;curNumItemsPerRow>0;curNumItemsPerRow)
            {
                if(lp.desiredWidth<width/curNumItemsPerRow)                
                {
lp.maxNumItemsOnRow=curNumItemsPerRow                    break;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int maxNumItemsPerRow = mMaxItemsPerRow;
        //int numItems = getChildCount();
        //for (int i = 0; i < numItems; i++) {
            //LayoutParams lp = (LayoutParams) getChildAt(i).getLayoutParams();
            //lp.maxNumItemsOnRow = 1;
            //for (int curNumItemsPerRow = maxNumItemsPerRow; curNumItemsPerRow > 0;
                    //curNumItemsPerRow--) {
                //if (lp.desiredWidth < width / curNumItemsPerRow) {
                    //lp.maxNumItemsOnRow = curNumItemsPerRow;
                    //break;
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.428 -0400", hash_original_method = "2D6F044112ADAA2591CF3D217EC1849B", hash_generated_method = "4D94611C2DA304866CD3BB6DA395A6CE")
    @Override
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState = super.onSaveInstanceState();
        View focusedView = getFocusedChild();
for(int i = getChildCount() - 1;i>=0;i)
        {
            if(getChildAt(i)==focusedView)            
            {
Parcelable var3B83710896FC17FC0FD91B0ED9394AB1_1762745835 = new SavedState(superState, i)                var3B83710896FC17FC0FD91B0ED9394AB1_1762745835.addTaint(taint);
                return var3B83710896FC17FC0FD91B0ED9394AB1_1762745835;
            } //End block
        } //End block
Parcelable var9D5002D353A9FA01C2344A44A077E156_1601161263 = new SavedState(superState, -1)        var9D5002D353A9FA01C2344A44A077E156_1601161263.addTaint(taint);
        return var9D5002D353A9FA01C2344A44A077E156_1601161263;
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //View focusedView = getFocusedChild();
        //for (int i = getChildCount() - 1; i >= 0; i--) {
            //if (getChildAt(i) == focusedView) {
                //return new SavedState(superState, i);
            //}
        //}
        //return new SavedState(superState, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.429 -0400", hash_original_method = "49AFBE27B9E568F013D030667BB6BE48", hash_generated_method = "80B8C3A6E35BA8B8DB6B633E8D3B7A28")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        SavedState ss = (SavedState) state;
super.onRestoreInstanceState(ss.getSuperState())        if(ss.focusedPosition>=getChildCount())        
        {
            return;
        } //End block
        View v = getChildAt(ss.focusedPosition);
        if(v!=null)        
        {
v.requestFocus()
        } //End block
        // ---------- Original Method ----------
        //SavedState ss = (SavedState) state;
        //super.onRestoreInstanceState(ss.getSuperState());
        //if (ss.focusedPosition >= getChildCount()) {
            //return;
        //}
        //View v = getChildAt(ss.focusedPosition);
        //if (v != null) {
            //v.requestFocus();
        //}
    }

    
    private static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.429 -0400", hash_original_field = "577A1CB90B2419996687359EE928CA05", hash_generated_field = "65A10FA3F33879E00676D385003DC819")

        int focusedPosition;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.430 -0400", hash_original_method = "6B85E225CE4895DF69D7AD3BA1A1D0E6", hash_generated_method = "0AAD25B3A8F90C7731C270841F253ACC")
        public  SavedState(Parcelable superState, int focusedPosition) {
            super(superState);
            addTaint(focusedPosition);
            addTaint(superState.getTaint());
this.focusedPosition=focusedPosition
            // ---------- Original Method ----------
            //this.focusedPosition = focusedPosition;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.430 -0400", hash_original_method = "62FDA856B6BB84CB97F84F93D2B95AF3", hash_generated_method = "37B913F2DE07C3E62F34EFFBC6172961")
        private  SavedState(Parcel in) {
            super(in);
            addTaint(in.getTaint());
focusedPosition=in.readInt()
            // ---------- Original Method ----------
            //focusedPosition = in.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.431 -0400", hash_original_method = "57263806AFC4195E4D76796955F0C7D6", hash_generated_method = "D3C89F2D6B5DE093B59187C9422A8001")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
super.writeToParcel(dest, flags)dest.writeInt(focusedPosition)
            // ---------- Original Method ----------
            //super.writeToParcel(dest, flags);
            //dest.writeInt(focusedPosition);
        }

        


    
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.431 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "F8DAB7F926CD7972429F7B948D9F5533")

        int left;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.432 -0400", hash_original_field = "B28354B543375BFA94DABAEDA722927F", hash_generated_field = "9620536E5A5D6E12CC93092A5EBB857E")

        int top;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.432 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "49C6BE2EEC7270CFEAEFBD796F2C423B")

        int right;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.432 -0400", hash_original_field = "71F262D796BED1AB30E8A2D5A8DDEE6F", hash_generated_field = "7F74B1869951CB3A6660AA746710A714")

        int bottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.432 -0400", hash_original_field = "70D572D049924762BB47B6983858AAEA", hash_generated_field = "629C51D4291EC18D0013765006B60758")

        int desiredWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.432 -0400", hash_original_field = "1E7EED6F62482813054063E3BB336E53", hash_generated_field = "4E1F2D68D6DD0A64CF2F4943FDD37F07")

        int maxNumItemsOnRow;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.432 -0400", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "7441F800C0B184928DB48A9DD8178D32")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            addTaint(attrs.getTaint());
            addTaint(c.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.433 -0400", hash_original_method = "B179862558DB9232A546423CE2E9C45B", hash_generated_method = "EBA00E8564DFBD29E7FBA11533DD8069")
        public  LayoutParams(int width, int height) {
            super(width, height);
            addTaint(height);
            addTaint(width);
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.433 -0400", hash_original_field = "70C4912CC84E35C210B77181A6CD2856", hash_generated_field = "DF26848AC140D85B5B153A406FE4F0BC")

    private static final int ITEM_CAPTION_CYCLE_DELAY = 1000;
}

