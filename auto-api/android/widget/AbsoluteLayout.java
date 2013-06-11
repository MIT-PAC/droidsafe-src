package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews.RemoteView;

public class AbsoluteLayout extends ViewGroup {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.417 -0400", hash_original_method = "5954FDB18E14B0E14B8E157FD227CC59", hash_generated_method = "2C4990570709A02C9000EC649F3FFD87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsoluteLayout(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.417 -0400", hash_original_method = "B433FCC2495B1A37134076C038FD96A0", hash_generated_method = "48216C1A58CF91D4305D953CDEB8BEEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsoluteLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.417 -0400", hash_original_method = "153087F001B91B4A777A0B839E669EB1", hash_generated_method = "011307EC4C89AA306DADFBF1C39C211B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsoluteLayout(Context context, AttributeSet attrs,
            int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.418 -0400", hash_original_method = "54761EA789A74CBDB221271FE56469B7", hash_generated_method = "8B55483A539D2E4859C97CA141F2BE2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        int count;
        count = getChildCount();
        int maxHeight;
        maxHeight = 0;
        int maxWidth;
        maxWidth = 0;
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_2035706376 = (child.getVisibility() != GONE);
                    {
                        int childRight;
                        int childBottom;
                        AbsoluteLayout.LayoutParams lp;
                        lp = (AbsoluteLayout.LayoutParams) child.getLayoutParams();
                        childRight = lp.x + child.getMeasuredWidth();
                        childBottom = lp.y + child.getMeasuredHeight();
                        maxWidth = Math.max(maxWidth, childRight);
                        maxHeight = Math.max(maxHeight, childBottom);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        maxWidth += mPaddingLeft + mPaddingRight;
        maxHeight += mPaddingTop + mPaddingBottom;
        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());
        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, 0),
                resolveSizeAndState(maxHeight, heightMeasureSpec, 0));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.418 -0400", hash_original_method = "383A977BED79B1C96577C54DB1D6FA6E", hash_generated_method = "365A1F189DB1BBD9C5CB7D62689162C2")
    @DSModeled(DSC.SAFE)
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.418 -0400", hash_original_method = "CB6E73396546FC793F7584A7D119E869", hash_generated_method = "23315E32F5DED2776E4B56DDFE0B996F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onLayout(boolean changed, int l, int t,
            int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        dsTaint.addTaint(changed);
        int count;
        count = getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_535012283 = (child.getVisibility() != GONE);
                    {
                        AbsoluteLayout.LayoutParams lp;
                        lp = (AbsoluteLayout.LayoutParams) child.getLayoutParams();
                        int childLeft;
                        childLeft = mPaddingLeft + lp.x;
                        int childTop;
                        childTop = mPaddingTop + lp.y;
                        child.layout(childLeft, childTop,
                        childLeft + child.getMeasuredWidth(),
                        childTop + child.getMeasuredHeight());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int count = getChildCount();
        //for (int i = 0; i < count; i++) {
            //View child = getChildAt(i);
            //if (child.getVisibility() != GONE) {
                //AbsoluteLayout.LayoutParams lp =
                        //(AbsoluteLayout.LayoutParams) child.getLayoutParams();
                //int childLeft = mPaddingLeft + lp.x;
                //int childTop = mPaddingTop + lp.y;
                //child.layout(childLeft, childTop,
                        //childLeft + child.getMeasuredWidth(),
                        //childTop + child.getMeasuredHeight());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.418 -0400", hash_original_method = "D0490D2D5B80C9DD3F55B366503982A5", hash_generated_method = "86C4EEC3162AF5BD2DADE86CE21BD3D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        ViewGroup.LayoutParams var1BCF832ACAC59342E37B3C572768D93F_844914172 = (new AbsoluteLayout.LayoutParams(getContext(), attrs));
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AbsoluteLayout.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.418 -0400", hash_original_method = "E121C7CF679CE7DED988221EA3AFEDE0", hash_generated_method = "45F1F3FABB23F1CD126687F84C7159ED")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return p instanceof AbsoluteLayout.LayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.418 -0400", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "29644007F7CFEED57C9F56BE3742304B")
    @DSModeled(DSC.SAFE)
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.418 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "1239C6C76A60BF63BE5F6B305C415611")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean shouldDelayChildPressedState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public int x;
        public int y;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.418 -0400", hash_original_method = "82F5809A27EA13ABE8A026DC04B05568", hash_generated_method = "C2D4F6B5CCD4B93D65E2A14EC4C03A66")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int width, int height, int x, int y) {
            super(width, height);
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            dsTaint.addTaint(y);
            dsTaint.addTaint(x);
            // ---------- Original Method ----------
            //this.x = x;
            //this.y = y;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.419 -0400", hash_original_method = "4740233E31DF015F5CE2A2D25007B918", hash_generated_method = "1B7677006369E88DF073121DF30CE20A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(attrs.dsTaint);
            TypedArray a;
            a = c.obtainStyledAttributes(attrs,
                    com.android.internal.R.styleable.AbsoluteLayout_Layout);
            x = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.AbsoluteLayout_Layout_layout_x, 0);
            y = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.AbsoluteLayout_Layout_layout_y, 0);
            a.recycle();
            // ---------- Original Method ----------
            //TypedArray a = c.obtainStyledAttributes(attrs,
                    //com.android.internal.R.styleable.AbsoluteLayout_Layout);
            //x = a.getDimensionPixelOffset(
                    //com.android.internal.R.styleable.AbsoluteLayout_Layout_layout_x, 0);
            //y = a.getDimensionPixelOffset(
                    //com.android.internal.R.styleable.AbsoluteLayout_Layout_layout_y, 0);
            //a.recycle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.419 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "56865DF2AAA17BD60F7856200319F1B6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            dsTaint.addTaint(source.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.419 -0400", hash_original_method = "E94865805207BE74BD20D805DD96D818", hash_generated_method = "B0171844B4C7A0F83B002EAA7C93F548")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String debug(String output) {
            dsTaint.addTaint(output);
            String var0F7A2FDAD0FCF3B38C07054D278C6CDD_1751105720 = (output + "Absolute.LayoutParams={width="
                    + sizeToString(width) + ", height=" + sizeToString(height)
                    + " x=" + x + " y=" + y + "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return output + "Absolute.LayoutParams={width="
                    //+ sizeToString(width) + ", height=" + sizeToString(height)
                    //+ " x=" + x + " y=" + y + "}";
        }

        
    }


    
}


