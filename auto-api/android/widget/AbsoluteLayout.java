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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.234 -0400", hash_original_method = "5954FDB18E14B0E14B8E157FD227CC59", hash_generated_method = "5C18E90C9C6B6CE06AED6E1461B0424B")
    public  AbsoluteLayout(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.234 -0400", hash_original_method = "B433FCC2495B1A37134076C038FD96A0", hash_generated_method = "62C023732B4165832774F568D54801DB")
    public  AbsoluteLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.234 -0400", hash_original_method = "153087F001B91B4A777A0B839E669EB1", hash_generated_method = "99ECD7A38B9A049F57EAEB6C06D9F691")
    public  AbsoluteLayout(Context context, AttributeSet attrs,
            int defStyle) {
        super(context, attrs, defStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.235 -0400", hash_original_method = "54761EA789A74CBDB221271FE56469B7", hash_generated_method = "C9DB7DED20A167A321529C5525FD97EE")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int count = getChildCount();
        int maxHeight = 0;
        int maxWidth = 0;
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        {
            int i = 0;
            {
                View child = getChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_1831642322 = (child.getVisibility() != GONE);
                    {
                        int childRight;
                        int childBottom;
                        AbsoluteLayout.LayoutParams lp = (AbsoluteLayout.LayoutParams) child.getLayoutParams();
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
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.236 -0400", hash_original_method = "383A977BED79B1C96577C54DB1D6FA6E", hash_generated_method = "11B847F0CC604B551BB57A9040B1E5FC")
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1760676235 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1760676235 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0, 0);
        varB4EAC82CA7396A68D541C85D26508E83_1760676235.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1760676235;
        // ---------- Original Method ----------
        //return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.237 -0400", hash_original_method = "CB6E73396546FC793F7584A7D119E869", hash_generated_method = "5833725950F744D178BE22A9364B3ACD")
    @Override
    protected void onLayout(boolean changed, int l, int t,
            int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int count = getChildCount();
        {
            int i = 0;
            {
                View child = getChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_1951945475 = (child.getVisibility() != GONE);
                    {
                        AbsoluteLayout.LayoutParams lp = (AbsoluteLayout.LayoutParams) child.getLayoutParams();
                        int childLeft = mPaddingLeft + lp.x;
                        int childTop = mPaddingTop + lp.y;
                        child.layout(childLeft, childTop,
                        childLeft + child.getMeasuredWidth(),
                        childTop + child.getMeasuredHeight());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.238 -0400", hash_original_method = "D0490D2D5B80C9DD3F55B366503982A5", hash_generated_method = "D66005CFC26B6BF927F0E870852CB101")
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_2025376024 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2025376024 = new AbsoluteLayout.LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2025376024.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2025376024;
        // ---------- Original Method ----------
        //return new AbsoluteLayout.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.238 -0400", hash_original_method = "E121C7CF679CE7DED988221EA3AFEDE0", hash_generated_method = "6616F43EB52DDEEF019A3683226701A9")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_685177923 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_685177923;
        // ---------- Original Method ----------
        //return p instanceof AbsoluteLayout.LayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.239 -0400", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "4E172290280C05BD031270841983D904")
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_279362838 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_279362838 = new LayoutParams(p);
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_279362838.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_279362838;
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.239 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "498D55670143CDC5597FC71B673ECE80")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984516084 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984516084;
        // ---------- Original Method ----------
        //return false;
    }

    
    public static class LayoutParams extends ViewGroup.LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.239 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "DC9CDA960147F3D22D20E612AF25CB17")

        public int x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.239 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "2B3105BD07A59FEFE1F1918C5EDA2B54")

        public int y;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.239 -0400", hash_original_method = "82F5809A27EA13ABE8A026DC04B05568", hash_generated_method = "1C24BDF8FC1F34745C6C472B9EA05B59")
        public  LayoutParams(int width, int height, int x, int y) {
            super(width, height);
            this.x = x;
            this.y = y;
            addTaint(width);
            addTaint(height);
            // ---------- Original Method ----------
            //this.x = x;
            //this.y = y;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.240 -0400", hash_original_method = "4740233E31DF015F5CE2A2D25007B918", hash_generated_method = "ABB46C5FE76D32B48BF9F7500EE40025")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a = c.obtainStyledAttributes(attrs,
                    com.android.internal.R.styleable.AbsoluteLayout_Layout);
            x = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.AbsoluteLayout_Layout_layout_x, 0);
            y = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.AbsoluteLayout_Layout_layout_y, 0);
            a.recycle();
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            // ---------- Original Method ----------
            //TypedArray a = c.obtainStyledAttributes(attrs,
                    //com.android.internal.R.styleable.AbsoluteLayout_Layout);
            //x = a.getDimensionPixelOffset(
                    //com.android.internal.R.styleable.AbsoluteLayout_Layout_layout_x, 0);
            //y = a.getDimensionPixelOffset(
                    //com.android.internal.R.styleable.AbsoluteLayout_Layout_layout_y, 0);
            //a.recycle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.240 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "37A5DBEF9177864A03971A9D81D7D3EE")
        public  LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.241 -0400", hash_original_method = "E94865805207BE74BD20D805DD96D818", hash_generated_method = "B8AE1D15617E05EA970797D80E566CC7")
        @Override
        public String debug(String output) {
            String varB4EAC82CA7396A68D541C85D26508E83_1526880203 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1526880203 = output + "Absolute.LayoutParams={width="
                    + sizeToString(width) + ", height=" + sizeToString(height)
                    + " x=" + x + " y=" + y + "}";
            addTaint(output.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1526880203.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1526880203;
            // ---------- Original Method ----------
            //return output + "Absolute.LayoutParams={width="
                    //+ sizeToString(width) + ", height=" + sizeToString(height)
                    //+ " x=" + x + " y=" + y + "}";
        }

        
    }


    
}

