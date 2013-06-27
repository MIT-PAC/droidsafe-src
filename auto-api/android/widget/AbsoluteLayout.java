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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.386 -0400", hash_original_method = "5954FDB18E14B0E14B8E157FD227CC59", hash_generated_method = "5C18E90C9C6B6CE06AED6E1461B0424B")
    public  AbsoluteLayout(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.386 -0400", hash_original_method = "B433FCC2495B1A37134076C038FD96A0", hash_generated_method = "62C023732B4165832774F568D54801DB")
    public  AbsoluteLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.387 -0400", hash_original_method = "153087F001B91B4A777A0B839E669EB1", hash_generated_method = "99ECD7A38B9A049F57EAEB6C06D9F691")
    public  AbsoluteLayout(Context context, AttributeSet attrs,
            int defStyle) {
        super(context, attrs, defStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.389 -0400", hash_original_method = "54761EA789A74CBDB221271FE56469B7", hash_generated_method = "07A9587F9D9FE725AC18E39F7FF3A9B6")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_489842310 = (child.getVisibility() != GONE);
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
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.389 -0400", hash_original_method = "383A977BED79B1C96577C54DB1D6FA6E", hash_generated_method = "A2011E16274A4677DE361976390311EF")
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_198136091 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_198136091 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0, 0);
        varB4EAC82CA7396A68D541C85D26508E83_198136091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_198136091;
        // ---------- Original Method ----------
        //return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.392 -0400", hash_original_method = "CB6E73396546FC793F7584A7D119E869", hash_generated_method = "CCB529D5887A8C043F8B27A142FCD595")
    @Override
    protected void onLayout(boolean changed, int l, int t,
            int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int count;
        count = getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_1154788609 = (child.getVisibility() != GONE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.393 -0400", hash_original_method = "D0490D2D5B80C9DD3F55B366503982A5", hash_generated_method = "6DC1E873DA97AA1692662251227AC05C")
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1605437470 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1605437470 = new AbsoluteLayout.LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1605437470.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1605437470;
        // ---------- Original Method ----------
        //return new AbsoluteLayout.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.397 -0400", hash_original_method = "E121C7CF679CE7DED988221EA3AFEDE0", hash_generated_method = "F41B28116244A03D65876E2D96553AF3")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_73729162 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_73729162;
        // ---------- Original Method ----------
        //return p instanceof AbsoluteLayout.LayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.399 -0400", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "1EA8DF7DFD758DF6583C19177DDAC7A4")
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1791598531 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1791598531 = new LayoutParams(p);
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1791598531.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1791598531;
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.399 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "9963011F6FCFA7DC21CBFFF738C6B260")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92364238 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_92364238;
        // ---------- Original Method ----------
        //return false;
    }

    
    public static class LayoutParams extends ViewGroup.LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.399 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "DC9CDA960147F3D22D20E612AF25CB17")

        public int x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.399 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "2B3105BD07A59FEFE1F1918C5EDA2B54")

        public int y;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.403 -0400", hash_original_method = "82F5809A27EA13ABE8A026DC04B05568", hash_generated_method = "1C24BDF8FC1F34745C6C472B9EA05B59")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.404 -0400", hash_original_method = "4740233E31DF015F5CE2A2D25007B918", hash_generated_method = "5199C843BFA3C49A69275983F5FBACEA")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a;
            a = c.obtainStyledAttributes(attrs,
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.404 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "37A5DBEF9177864A03971A9D81D7D3EE")
        public  LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.418 -0400", hash_original_method = "E94865805207BE74BD20D805DD96D818", hash_generated_method = "5F4F762ECD7A67B6F0DAB3861148EC9B")
        @Override
        public String debug(String output) {
            String varB4EAC82CA7396A68D541C85D26508E83_3318495 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_3318495 = output + "Absolute.LayoutParams={width="
                    + sizeToString(width) + ", height=" + sizeToString(height)
                    + " x=" + x + " y=" + y + "}";
            addTaint(output.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_3318495.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_3318495;
            // ---------- Original Method ----------
            //return output + "Absolute.LayoutParams={width="
                    //+ sizeToString(width) + ", height=" + sizeToString(height)
                    //+ " x=" + x + " y=" + y + "}";
        }

        
    }


    
}

