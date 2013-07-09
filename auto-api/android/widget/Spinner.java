package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.annotation.Widget;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

public class Spinner extends AbsSpinner implements OnClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.019 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "2B2C8DD5949DF96120E12CE686443E54")

    private SpinnerPopup mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.019 -0400", hash_original_field = "DB8AEAB3B92BDCB9C1750435FF08F347", hash_generated_field = "C1900A4CF75F2ED95144B24FDA148887")

    private DropDownAdapter mTempAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.019 -0400", hash_original_field = "56AD5481B6A7DF9BE8EA5BE42BC8A2A2", hash_generated_field = "9F13B49ED3B4F15DF1C39EF57B2A0772")

    int mDropDownWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.020 -0400", hash_original_field = "1DE05384A4316AFED99BFDA3AA41DEF9", hash_generated_field = "ACF14A395FB2702990553CD0EFA1BDCC")

    private int mGravity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.020 -0400", hash_original_field = "D8AB3D4F1D71BCDC94E13C76C2E7EAF9", hash_generated_field = "7967DE792AA6967947AC34B6AC2CC5E6")

    private boolean mDisableChildrenWhenDisabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.020 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.020 -0400", hash_original_method = "B5C06F1AC4F38C2FF014EC091685338D", hash_generated_method = "FE480488CFAF338D190465CF15135132")
    public  Spinner(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.020 -0400", hash_original_method = "6645D47A83FEF1D160E35889A652939D", hash_generated_method = "0D03D4C496A1494E34A485DD66255BCF")
    public  Spinner(Context context, int mode) {
        this(context, null, com.android.internal.R.attr.spinnerStyle, mode);
        addTaint(context.getTaint());
        addTaint(mode);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.021 -0400", hash_original_method = "B198D16CD1474762E3B97C016462CA6F", hash_generated_method = "98E558EE3E07124E17F8FA31D1D4AFB1")
    public  Spinner(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.spinnerStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.021 -0400", hash_original_method = "78C6FE6C5EEF3610339F87F7F649A015", hash_generated_method = "DAC30882A8EB10DA8D36BFB5483AEA1B")
    public  Spinner(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, MODE_THEME);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.022 -0400", hash_original_method = "290E4CD98FA983594AD8D129D824FCAE", hash_generated_method = "A3D99166615A72AAD847603B7D50C59B")
    public  Spinner(Context context, AttributeSet attrs, int defStyle, int mode) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.Spinner, defStyle, 0);
        {
            mode = a.getInt(com.android.internal.R.styleable.Spinner_spinnerMode, MODE_DIALOG);
        } 
        
        {
            mPopup = new DialogPopup();
        } 
        
        
        {
            DropdownPopup popup = new DropdownPopup(context, attrs, defStyle);
            mDropDownWidth = a.getLayoutDimension(
                    com.android.internal.R.styleable.Spinner_dropDownWidth,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            popup.setBackgroundDrawable(a.getDrawable(
                    com.android.internal.R.styleable.Spinner_popupBackground));
            final int verticalOffset = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.Spinner_dropDownVerticalOffset, 0);
            {
                popup.setVerticalOffset(verticalOffset);
            } 
            final int horizontalOffset = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.Spinner_dropDownHorizontalOffset, 0);
            {
                popup.setHorizontalOffset(horizontalOffset);
            } 
            mPopup = popup;
        } 
        
        mGravity = a.getInt(com.android.internal.R.styleable.Spinner_gravity, Gravity.CENTER);
        mPopup.setPromptText(a.getString(com.android.internal.R.styleable.Spinner_prompt));
        mDisableChildrenWhenDisabled = a.getBoolean(
                com.android.internal.R.styleable.Spinner_disableChildrenWhenDisabled, false);
        a.recycle();
        {
            mPopup.setAdapter(mTempAdapter);
            mTempAdapter = null;
        } 
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        addTaint(mode);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.022 -0400", hash_original_method = "E89DC933CAA3948ECC7191CDEBCA4F7F", hash_generated_method = "F80382B2D32924F06F8A7485E9990B23")
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        {
            final int count = getChildCount();
            {
                int i = 0;
                {
                    getChildAt(i).setEnabled(enabled);
                } 
            } 
        } 
        addTaint(enabled);
        
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.023 -0400", hash_original_method = "2D67806CEC3CAAEAC987F460E7189BA9", hash_generated_method = "581B3A8CC2ADFBD090B1DE0FBFA07032")
    public void setGravity(int gravity) {
        {
            {
                gravity |= Gravity.LEFT;
            } 
            mGravity = gravity;
            requestLayout();
        } 
        
        
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.023 -0400", hash_original_method = "60241601236C86A9296272064A15234D", hash_generated_method = "B3BAD5DA17A85B926BCB91F9E8FEBA88")
    @Override
    public void setAdapter(SpinnerAdapter adapter) {
        super.setAdapter(adapter);
        {
            mPopup.setAdapter(new DropDownAdapter(adapter));
        } 
        {
            mTempAdapter = new DropDownAdapter(adapter);
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.024 -0400", hash_original_method = "50D7CC7A93B993E2A6FF522D575BAEB5", hash_generated_method = "6964ADA34485D627599A55C8528B9EBF")
    @Override
    public int getBaseline() {
        View child = null;
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1683678508 = (getChildCount() > 0);
            {
                child = getChildAt(0);
            } 
            {
                boolean var64E96C628F62864AA686A96BEDED1403_970513004 = (mAdapter != null && mAdapter.getCount() > 0);
                {
                    child = makeAndAddView(0);
                    mRecycler.put(0, child);
                    removeAllViewsInLayout();
                } 
            } 
        } 
        {
            final int childBaseline = child.getBaseline();
            {
                Object var54BA034BC30EE04F32CE30794275A01A_190803871 = (child.getTop() + childBaseline);
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_835479921 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_835479921;
        
        
        
            
        
            
            
            
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.025 -0400", hash_original_method = "B6F13EE08FDC85FB02DBBB6CA125C601", hash_generated_method = "0C30FBBDFCA2AD243A8F903B6A958ECF")
    @Override
    protected void onDetachedFromWindow() {
        
        super.onDetachedFromWindow();
        {
            boolean varD929D8531D595F5EA0B4A8A252DF969D_769413526 = (mPopup != null && mPopup.isShowing());
            {
                mPopup.dismiss();
            } 
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.025 -0400", hash_original_method = "AE9F9278138E36A1F7A0C4102CD0DE5F", hash_generated_method = "7F5AC0D830F3AD8737EF0FF5E2239EB7")
    @Override
    public void setOnItemClickListener(OnItemClickListener l) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
        addTaint(l.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.025 -0400", hash_original_method = "EC8AF316641014792672178145DBD315", hash_generated_method = "416704A145E70894D30E4CA6A7A6C81B")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        {
            boolean var5BB94CDAE497737B2AF326771BF24CAC_864453443 = (mPopup != null && MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST);
            {
                final int measuredWidth = getMeasuredWidth();
                setMeasuredDimension(Math.min(Math.max(measuredWidth,
                    measureContentWidth(getAdapter(), getBackground())),
                    MeasureSpec.getSize(widthMeasureSpec)),
                    getMeasuredHeight());
            } 
        } 
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
        
            
            
                    
                    
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.026 -0400", hash_original_method = "2F25E46AB3A307ED9F0C91E6C81BDCD4", hash_generated_method = "65ACF9A64D756E5637EB155848E3E853")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        
        super.onLayout(changed, l, t, r, b);
        mInLayout = true;
        layout(0, false);
        mInLayout = false;
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.026 -0400", hash_original_method = "26F25590D97768D2F385154C131B8E76", hash_generated_method = "F2452DD13F7AA99A68282B2F902E35F4")
    @Override
     void layout(int delta, boolean animate) {
        int childrenLeft = mSpinnerPadding.left;
        int childrenWidth = mRight - mLeft - mSpinnerPadding.left - mSpinnerPadding.right;
        {
            handleDataChanged();
        } 
        {
            resetList();
        } 
        {
            setSelectedPositionInt(mNextSelectedPosition);
        } 
        recycleAllViews();
        removeAllViewsInLayout();
        mFirstPosition = mSelectedPosition;
        View sel = makeAndAddView(mSelectedPosition);
        int width = sel.getMeasuredWidth();
        int selectedOffset = childrenLeft;
        
        selectedOffset = childrenLeft + (childrenWidth / 2) - (width / 2);
        
        
        selectedOffset = childrenLeft + childrenWidth - width;
        
        sel.offsetLeftAndRight(selectedOffset);
        mRecycler.clear();
        invalidate();
        checkSelectionChanged();
        mDataChanged = false;
        mNeedSync = false;
        setNextSelectedPositionInt(mSelectedPosition);
        addTaint(delta);
        addTaint(animate);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.027 -0400", hash_original_method = "16A0D15DF35F8329F5BE73262CE9B509", hash_generated_method = "73D00A02A356E9DE576090E0CD5E9D92")
    private View makeAndAddView(int position) {
        View varB4EAC82CA7396A68D541C85D26508E83_314745667 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1533942955 = null; 
        View child;
        {
            child = mRecycler.get(position);
            {
                setUpChild(child);
                varB4EAC82CA7396A68D541C85D26508E83_314745667 = child;
            } 
        } 
        child = mAdapter.getView(position, null, this);
        setUpChild(child);
        varB4EAC82CA7396A68D541C85D26508E83_1533942955 = child;
        addTaint(position);
        View varA7E53CE21691AB073D9660D615818899_663316521; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_663316521 = varB4EAC82CA7396A68D541C85D26508E83_314745667;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_663316521 = varB4EAC82CA7396A68D541C85D26508E83_1533942955;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_663316521.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_663316521;
        
        
        
            
            
                
                
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.027 -0400", hash_original_method = "EA422D8BE64CA8F3FB87FB3D4E23C7FB", hash_generated_method = "FF2739BD3FA84FB161776F31DE4F3C45")
    private void setUpChild(View child) {
        ViewGroup.LayoutParams lp = child.getLayoutParams();
        {
            lp = generateDefaultLayoutParams();
        } 
        addViewInLayout(child, 0, lp);
        child.setSelected(hasFocus());
        {
            child.setEnabled(isEnabled());
        } 
        int childHeightSpec = ViewGroup.getChildMeasureSpec(mHeightMeasureSpec,
                mSpinnerPadding.top + mSpinnerPadding.bottom, lp.height);
        int childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                mSpinnerPadding.left + mSpinnerPadding.right, lp.width);
        child.measure(childWidthSpec, childHeightSpec);
        int childLeft;
        int childRight;
        int childTop = mSpinnerPadding.top
                + ((getMeasuredHeight() - mSpinnerPadding.bottom -
                        mSpinnerPadding.top - child.getMeasuredHeight()) / 2);
        int childBottom = childTop + child.getMeasuredHeight();
        int width = child.getMeasuredWidth();
        childLeft = 0;
        childRight = childLeft + width;
        child.layout(childLeft, childTop, childRight, childBottom);
        addTaint(child.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.028 -0400", hash_original_method = "DE0583C7611D1F2BE10915793A501A4C", hash_generated_method = "580B82D55C29167D983995D3E127DA9D")
    @Override
    public boolean performClick() {
        boolean handled = super.performClick();
        {
            handled = true;
            {
                boolean varE54135B8CA552C10B65F25C1BE9A982D_1980950837 = (!mPopup.isShowing());
                {
                    mPopup.show();
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_562686196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_562686196;
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.028 -0400", hash_original_method = "21A8DBFD7E0EEAC4158875C988469F50", hash_generated_method = "4747EBD4AE52098FE6F53157784D7F32")
    public void onClick(DialogInterface dialog, int which) {
        
        setSelection(which);
        dialog.dismiss();
        addTaint(dialog.getTaint());
        addTaint(which);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.029 -0400", hash_original_method = "82831FCEC8FF5E5499EA6A36B12A66DA", hash_generated_method = "5244C7309714851D8F9FA9A60609AE32")
    public void setPrompt(CharSequence prompt) {
        mPopup.setPromptText(prompt);
        addTaint(prompt.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.029 -0400", hash_original_method = "21AEC72317B46CB2881CC90C11A2AA6E", hash_generated_method = "282CDD662BB137828E37FF9AB97BDF04")
    public void setPromptId(int promptId) {
        setPrompt(getContext().getText(promptId));
        addTaint(promptId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.029 -0400", hash_original_method = "07472705288FF1B8FBB0DCE1C944E4ED", hash_generated_method = "DD42600F7F98DFE51A2108F954A14892")
    public CharSequence getPrompt() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1525183191 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1525183191 = mPopup.getHintText();
        varB4EAC82CA7396A68D541C85D26508E83_1525183191.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1525183191;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.030 -0400", hash_original_method = "EB37E42D6ACA63E84337B27962C39033", hash_generated_method = "EABE73FE1641CB16629164BC4A333AE6")
     int measureContentWidth(SpinnerAdapter adapter, Drawable background) {
        int width = 0;
        View itemView = null;
        int itemType = 0;
        final int widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        int start = Math.max(0, getSelectedItemPosition());
        final int end = Math.min(adapter.getCount(), start + MAX_ITEMS_MEASURED);
        final int count = end - start;
        start = Math.max(0, start - (MAX_ITEMS_MEASURED - count));
        {
            int i = start;
            {
                final int positionType = adapter.getItemViewType(i);
                {
                    itemType = positionType;
                    itemView = null;
                } 
                itemView = adapter.getView(i, itemView, this);
                {
                    boolean var4600A482EC7CE1FD745D42F74A7EF908_758194397 = (itemView.getLayoutParams() == null);
                    {
                        itemView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                    } 
                } 
                itemView.measure(widthMeasureSpec, heightMeasureSpec);
                width = Math.max(width, itemView.getMeasuredWidth());
            } 
        } 
        {
            background.getPadding(mTempRect);
            width += mTempRect.left + mTempRect.right;
        } 
        addTaint(adapter.getTaint());
        addTaint(background.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1309386781 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1309386781;
        
        
    }

    
    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.030 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "3308AF23407F136C8CF926C7FBD8DC1B")

        private SpinnerAdapter mAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.030 -0400", hash_original_field = "B8EAD9E776B81483E5E8A661601F6AA8", hash_generated_field = "EBBA0833135A672B66F462D046DC0A24")

        private ListAdapter mListAdapter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.031 -0400", hash_original_method = "FD9BEBCCABA72AC6ECD15A9F9D903ED1", hash_generated_method = "4F13D325278085D7E9669A4AB3B420B2")
        public  DropDownAdapter(SpinnerAdapter adapter) {
            this.mAdapter = adapter;
            {
                this.mListAdapter = (ListAdapter) adapter;
            } 
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.031 -0400", hash_original_method = "7176E9532C0349D7016ABE3301806E2C", hash_generated_method = "9650429CF32F12097DF1E3704AAF5764")
        public int getCount() {
            {
                Object var067BB5993A461EDA4265964116724952_1995570417 = (mAdapter.getCount());
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286350266 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286350266;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.032 -0400", hash_original_method = "E5529375AE985E64AC9FCAEB196D1278", hash_generated_method = "B710389260043CD5E4A22AC6F7AD6C6C")
        public Object getItem(int position) {
            Object varB4EAC82CA7396A68D541C85D26508E83_112956438 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_112956438 = mAdapter == null ? null : mAdapter.getItem(position);
            addTaint(position);
            varB4EAC82CA7396A68D541C85D26508E83_112956438.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_112956438;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.032 -0400", hash_original_method = "516B3E26F5C00C4BD8BAF28DFF38500C", hash_generated_method = "4F6B854406906442DD1E1FC6B36C5C4D")
        public long getItemId(int position) {
            {
                Object varE791D48808E44BBA8A766C8461C5A401_1465381140 = (mAdapter.getItemId(position));
            } 
            addTaint(position);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_2039813133 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2039813133;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.033 -0400", hash_original_method = "A9F8983A232A0A246637701F010ACE34", hash_generated_method = "5B9EEF8C1D171F61DA1A97B289653EFA")
        public View getView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_152849354 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_152849354 = getDropDownView(position, convertView, parent);
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_152849354.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_152849354;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.034 -0400", hash_original_method = "F097CA4C24B6E5261C3C9C12681A60CA", hash_generated_method = "1AE9C7EA182BB3AD0184F7644C1ABC1C")
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_820483694 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_820483694 = mAdapter == null ? null :
                    mAdapter.getDropDownView(position, convertView, parent);
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_820483694.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_820483694;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.034 -0400", hash_original_method = "EE546908428E55FCCB0B2F98C659D31B", hash_generated_method = "296B90677902BF18B68759CB9E2A8D21")
        public boolean hasStableIds() {
            boolean var92A5B2B773F784D23AACADEC549061AE_2119439627 = (mAdapter != null && mAdapter.hasStableIds());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1702022356 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1702022356;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.035 -0400", hash_original_method = "809D44C02719E33F590103DE7F6576A1", hash_generated_method = "394F8D6D1C3E11D04B82C1A93DEB883B")
        public void registerDataSetObserver(DataSetObserver observer) {
            
            {
                mAdapter.registerDataSetObserver(observer);
            } 
            addTaint(observer.getTaint());
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.035 -0400", hash_original_method = "3A9A7C936FBCE4451B499589F8C4C5C5", hash_generated_method = "CA1E1CE41BA81DA1B5FFC90A490DA640")
        public void unregisterDataSetObserver(DataSetObserver observer) {
            {
                mAdapter.unregisterDataSetObserver(observer);
            } 
            addTaint(observer.getTaint());
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.036 -0400", hash_original_method = "C6F9771E1B3DE27F3DC1DA3F2DDBE42B", hash_generated_method = "A1BD40A8E056D343FBB4A01545C2ABF3")
        public boolean areAllItemsEnabled() {
            final ListAdapter adapter = mListAdapter;
            {
                boolean var985642AB936091C75C15CA5EE89CD4ED_1645793744 = (adapter.areAllItemsEnabled());
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_550253533 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_550253533;
            
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.036 -0400", hash_original_method = "5A692D7025642F2703B563EEC7270EF6", hash_generated_method = "4865419B5AEBC0174D5CC57451B6D883")
        public boolean isEnabled(int position) {
            final ListAdapter adapter = mListAdapter;
            {
                boolean var1B060CF70AEECE4FB915FA202647B0B7_1939692925 = (adapter.isEnabled(position));
            } 
            addTaint(position);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_187101746 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_187101746;
            
            
            
                
            
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.036 -0400", hash_original_method = "EE97D094FF23924861F9B1BB9874462B", hash_generated_method = "B2F2EA46DA0C1CBF006E4BA01977F35C")
        public int getItemViewType(int position) {
            addTaint(position);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408436595 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408436595;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.037 -0400", hash_original_method = "A6079B88B18082AA3C7D7E460D2C3B87", hash_generated_method = "8FF926DC591392497859751E9DDBEAC9")
        public int getViewTypeCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_39054723 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_39054723;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.037 -0400", hash_original_method = "837A179B327E763126CB6909C28E4F2B", hash_generated_method = "453A775E69135174E02AA4E0C5E51D2E")
        public boolean isEmpty() {
            boolean var1E308F1B2924DF35832B0C6653D5399D_379711625 = (getCount() == 0);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1198904125 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1198904125;
            
            
        }

        
    }


    
    private class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.037 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "8A66D18866E05C57D866195195114C43")

        private AlertDialog mPopup;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.037 -0400", hash_original_field = "B8EAD9E776B81483E5E8A661601F6AA8", hash_generated_field = "EBBA0833135A672B66F462D046DC0A24")

        private ListAdapter mListAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.037 -0400", hash_original_field = "902D3ABF16579BBC81B141476B035DD1", hash_generated_field = "D9DA4C057AA02B144FF3C40EB2E94890")

        private CharSequence mPrompt;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.037 -0400", hash_original_method = "CE7B674B2EA3FB97987A0C722722E738", hash_generated_method = "CE7B674B2EA3FB97987A0C722722E738")
        public DialogPopup ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.038 -0400", hash_original_method = "FC11027C394F91EA6C471943F011BB6E", hash_generated_method = "DAF71925B3E5CA09CBFAAD2BB2738DDA")
        public void dismiss() {
            mPopup.dismiss();
            mPopup = null;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.038 -0400", hash_original_method = "BD26E62421B18C78E84EB8F1A09EE4AA", hash_generated_method = "2302D4140FE70C67EE3303CE341C499F")
        public boolean isShowing() {
            {
                Object var064AFD47A2F0375BD3A49E11623DCB44_735895748 = (mPopup.isShowing());
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_75289355 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_75289355;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.038 -0400", hash_original_method = "8403FBCA2C28723FD059691B00D88CE1", hash_generated_method = "2A0FFE64737AEA0CAA4489A819F70A16")
        public void setAdapter(ListAdapter adapter) {
            mListAdapter = adapter;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.039 -0400", hash_original_method = "9624F776B01A0F54225A1B393847DC0B", hash_generated_method = "BB0F0F2687998277E739EA69AA391DAB")
        public void setPromptText(CharSequence hintText) {
            mPrompt = hintText;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.039 -0400", hash_original_method = "2D362FF1EB68D3106D16676724B21A20", hash_generated_method = "D053CBD0446D1C77B69FA8A756AF78DF")
        public CharSequence getHintText() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_887867464 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_887867464 = mPrompt;
            varB4EAC82CA7396A68D541C85D26508E83_887867464.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_887867464;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.039 -0400", hash_original_method = "FCDD379DF322C9BE95870CB90106F42A", hash_generated_method = "1D2E06C43FFA1A9D5161DAFD9B75C3C7")
        public void show() {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            {
                builder.setTitle(mPrompt);
            } 
            mPopup = builder.setSingleChoiceItems(mListAdapter,
                    getSelectedItemPosition(), this).show();
            
            
            
                
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.040 -0400", hash_original_method = "611F98047F020130E79D369CDAEB53F1", hash_generated_method = "20A80883BB81CEF2BE9AA01C09089F02")
        public void onClick(DialogInterface dialog, int which) {
            
            setSelection(which);
            dismiss();
            addTaint(dialog.getTaint());
            addTaint(which);
            
            
            
        }

        
    }


    
    private class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.040 -0400", hash_original_field = "E1CABE1E2EB0E02B938A46A1B7A0EBFD", hash_generated_field = "1FDB4027FDC409C38C96D7C7129240A3")

        private CharSequence mHintText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.040 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "90F29768206AB431EA361CD94838716F")

        private ListAdapter mAdapter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.040 -0400", hash_original_method = "9F2E5A3A347BB64B0E4347185558EFBB", hash_generated_method = "A92F472DF40C9FA254C2E1F1242AA364")
        public  DropdownPopup(Context context, AttributeSet attrs, int defStyleRes) {
            super(context, attrs, 0, defStyleRes);
            setAnchorView(Spinner.this);
            setModal(true);
            setPromptPosition(POSITION_PROMPT_ABOVE);
            setOnItemClickListener(new OnItemClickListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.040 -0400", hash_original_method = "BF22134BB65D55D48C7DDDF1370D6ED2", hash_generated_method = "2159CDD10341E819E3C4AB7B64FB1945")
                public void onItemClick(AdapterView parent, View v, int position, long id) {
                    
                    Spinner.this.setSelection(position);
                    dismiss();
                    addTaint(parent.getTaint());
                    addTaint(v.getTaint());
                    addTaint(position);
                    addTaint(id);
                    
                    
                    
                }
});
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            addTaint(defStyleRes);
            
            
            
            
            
                
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.041 -0400", hash_original_method = "3FC404C9DE24A7B182849EFCFBFDCEFF", hash_generated_method = "3B91B048A8013001F176DA62B9199C4B")
        @Override
        public void setAdapter(ListAdapter adapter) {
            super.setAdapter(adapter);
            mAdapter = adapter;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.041 -0400", hash_original_method = "708F2EB27A8EC2C1F7F8C9DF82B35D6E", hash_generated_method = "27011EE29443B22D7CFDB17904BD3DFF")
        public CharSequence getHintText() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_733183051 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_733183051 = mHintText;
            varB4EAC82CA7396A68D541C85D26508E83_733183051.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_733183051;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.042 -0400", hash_original_method = "5C072498C5CF07F19C35B82F77A3E1EC", hash_generated_method = "16E5231AF70EBF4E19AB1B172E7CB522")
        public void setPromptText(CharSequence hintText) {
            mHintText = hintText;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.042 -0400", hash_original_method = "831D1D82273C571177D94CDCC1E5A7C8", hash_generated_method = "1E1E27CFD5D66153CD35E43345C9E665")
        @Override
        public void show() {
            final int spinnerPaddingLeft = Spinner.this.getPaddingLeft();
            {
                final int spinnerWidth = Spinner.this.getWidth();
                final int spinnerPaddingRight = Spinner.this.getPaddingRight();
                setContentWidth(Math.max(
                        measureContentWidth((SpinnerAdapter) mAdapter, getBackground()),
                        spinnerWidth - spinnerPaddingLeft - spinnerPaddingRight));
            } 
            {
                final int spinnerWidth = Spinner.this.getWidth();
                final int spinnerPaddingRight = Spinner.this.getPaddingRight();
                setContentWidth(spinnerWidth - spinnerPaddingLeft - spinnerPaddingRight);
            } 
            {
                setContentWidth(mDropDownWidth);
            } 
            final Drawable background = getBackground();
            int bgOffset = 0;
            {
                background.getPadding(mTempRect);
                bgOffset = -mTempRect.left;
            } 
            setHorizontalOffset(bgOffset + spinnerPaddingLeft);
            setInputMethodMode(ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
            super.show();
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            setSelection(Spinner.this.getSelectedItemPosition());
            
            
        }

        
    }


    
    private interface SpinnerPopup {
        public void setAdapter(ListAdapter adapter);
        
        
        public void show();
        
        
        public void dismiss();
        
        
        public boolean isShowing();
        
        
        public void setPromptText(CharSequence hintText);
        public CharSequence getHintText();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.042 -0400", hash_original_field = "90FDE6788399EEB8CFA584A2AD13CBE5", hash_generated_field = "24196829F47AA90801DC8C1D4AB09CA2")

    private static final String TAG = "Spinner";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.042 -0400", hash_original_field = "78512CB4B8E7A1ED8A337810241ABF54", hash_generated_field = "66E10B160A98D63911CB4E37185B80B0")

    private static final int MAX_ITEMS_MEASURED = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.042 -0400", hash_original_field = "347C2CAB737F0CAF3BCAEC15CF42EBD2", hash_generated_field = "03A8B0FB324BD4C85C18EC4F45126C80")

    public static final int MODE_DIALOG = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.042 -0400", hash_original_field = "CB25F0D23E25C135EA3A64B2382813EF", hash_generated_field = "77CCFBFBDA82C84B44434E6E2C506BCB")

    public static final int MODE_DROPDOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:15.042 -0400", hash_original_field = "6ED8E1287CB86C092F8B2D91FE966865", hash_generated_field = "ABE6A4AE1BB7B3ECDF9A30C989D50FCE")

    private static final int MODE_THEME = -1;
}

