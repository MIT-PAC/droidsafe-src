package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews.RemoteView;

public class AbsoluteLayout extends ViewGroup {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.088 -0400", hash_original_method = "5954FDB18E14B0E14B8E157FD227CC59", hash_generated_method = "E9256161F155797D82CE2E81FDE34300")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsoluteLayout(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.088 -0400", hash_original_method = "B433FCC2495B1A37134076C038FD96A0", hash_generated_method = "47375E101C126C41697E7790327731EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsoluteLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.089 -0400", hash_original_method = "153087F001B91B4A777A0B839E669EB1", hash_generated_method = "7519C8E3912906374350548637505DF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsoluteLayout(Context context, AttributeSet attrs,
            int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.089 -0400", hash_original_method = "54761EA789A74CBDB221271FE56469B7", hash_generated_method = "3F673142EDFD60DB77AF8BA29424FCF4")
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
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_1579214330 = (child.getVisibility() != GONE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.089 -0400", hash_original_method = "383A977BED79B1C96577C54DB1D6FA6E", hash_generated_method = "D6805BB45B904D949B9EA14628F1E45C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.LayoutParams varF768AEE1E64A1567E233639B151CFD3F_98423711 = (new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0, 0));
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.090 -0400", hash_original_method = "CB6E73396546FC793F7584A7D119E869", hash_generated_method = "9DC644A9DEC4106447174778A800DA65")
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
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_249814623 = (child.getVisibility() != GONE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.090 -0400", hash_original_method = "D0490D2D5B80C9DD3F55B366503982A5", hash_generated_method = "375BCF7036E668EDD5B5CF4794471695")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        ViewGroup.LayoutParams var1BCF832ACAC59342E37B3C572768D93F_694967798 = (new AbsoluteLayout.LayoutParams(getContext(), attrs));
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AbsoluteLayout.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.090 -0400", hash_original_method = "E121C7CF679CE7DED988221EA3AFEDE0", hash_generated_method = "C50651CC9E336FFD80C667F4D958E594")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return p instanceof AbsoluteLayout.LayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.090 -0400", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "8B18DB8E1D2E92C42FF4ACAE9857DC4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        ViewGroup.LayoutParams varAE4B968C4C0301DC2CC83C8A9F56D84B_141411890 = (new LayoutParams(p));
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.090 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "B6A28B76ECD4015FD614215B915AB786")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.091 -0400", hash_original_method = "82F5809A27EA13ABE8A026DC04B05568", hash_generated_method = "7D39DA85190BDA1578ADD5CD623370D5")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.091 -0400", hash_original_method = "4740233E31DF015F5CE2A2D25007B918", hash_generated_method = "AAB3F9A98796531CAB1E8B733E871313")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.091 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "1B8A923CB2D1359AEB1E56B11A4FD570")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            dsTaint.addTaint(source.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.091 -0400", hash_original_method = "E94865805207BE74BD20D805DD96D818", hash_generated_method = "809C33E077C466C03AF644F019706858")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String debug(String output) {
            dsTaint.addTaint(output);
            String var0F7A2FDAD0FCF3B38C07054D278C6CDD_1638227842 = (output + "Absolute.LayoutParams={width="
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

