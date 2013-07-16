package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class Touch {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.054 -0400", hash_original_method = "FF7FAE7578041B972B60FFE115691062", hash_generated_method = "F8174DCCCAA12EC7CD4BEF28AD13D4D4")
    private  Touch() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
    public static void scrollTo(TextView widget, Layout layout, int x, int y) {
        final int horizontalPadding = widget.getTotalPaddingLeft() + widget.getTotalPaddingRight();
        final int availableWidth = widget.getWidth() - horizontalPadding;
        final int top = layout.getLineForVertical(y);
        Alignment a = layout.getParagraphAlignment(top);
        boolean ltr = layout.getParagraphDirection(top) > 0;
        int left, right;
        if (widget.getHorizontallyScrolling()) {
            final int verticalPadding = widget.getTotalPaddingTop() + widget.getTotalPaddingBottom();
            final int bottom = layout.getLineForVertical(y + widget.getHeight() - verticalPadding);
            left = Integer.MAX_VALUE;
            right = 0;
            for (int i = top; i <= bottom; i++) {
                left = (int) Math.min(left, layout.getLineLeft(i));
                right = (int) Math.max(right, layout.getLineRight(i));
            }
        } else {
            left = 0;
            right = availableWidth;
        }
        final int actualWidth = right - left;
        if (actualWidth < availableWidth) {
            if (a == Alignment.ALIGN_CENTER) {
                x = left - ((availableWidth - actualWidth) / 2);
            } else if ((ltr && (a == Alignment.ALIGN_OPPOSITE)) || (a == Alignment.ALIGN_RIGHT)) {
                x = left - (availableWidth - actualWidth);
            } else {
                x = left;
            }
        } else {
            x = Math.min(x, right - availableWidth);
            x = Math.max(x, left);
        }
        widget.scrollTo(x, y);
    }

    
        @DSModeled(DSC.SAFE)
    public static boolean onTouchEvent(TextView widget, Spannable buffer,
                                       MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        DragState[] ds;
        switch (event.getActionMasked()) {
        case MotionEvent.ACTION_DOWN:
            ds = buffer.getSpans(0, buffer.length(), DragState.class);
            for (int i = 0; i < ds.length; i++) {
                buffer.removeSpan(ds[i]);
            }
            buffer.setSpan(new DragState(event.getX(), event.getY(),
                            widget.getScrollX(), widget.getScrollY()),
                    0, 0, Spannable.SPAN_MARK_MARK);
            return true;
        case MotionEvent.ACTION_UP:
            ds = buffer.getSpans(0, buffer.length(), DragState.class);
            for (int i = 0; i < ds.length; i++) {
                buffer.removeSpan(ds[i]);
            }
            if (ds.length > 0 && ds[0].mUsed) {
                return true;
            } else {
                return false;
            }
        case MotionEvent.ACTION_MOVE:
            ds = buffer.getSpans(0, buffer.length(), DragState.class);
            if (ds.length > 0) {
                if (ds[0].mFarEnough == false) {
                    int slop = ViewConfiguration.get(widget.getContext()).getScaledTouchSlop();
                    if (Math.abs(event.getX() - ds[0].mX) >= slop ||
                        Math.abs(event.getY() - ds[0].mY) >= slop) {
                        ds[0].mFarEnough = true;
                    }
                }
                if (ds[0].mFarEnough) {
                    ds[0].mUsed = true;
                    boolean cap = (event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0
                            || MetaKeyKeyListener.getMetaState(buffer,
                                    MetaKeyKeyListener.META_SHIFT_ON) == 1
                            || MetaKeyKeyListener.getMetaState(buffer,
                                    MetaKeyKeyListener.META_SELECTING) != 0;
                    float dx;
                    float dy;
                    if (cap) {
                        dx = event.getX() - ds[0].mX;
                        dy = event.getY() - ds[0].mY;
                    } else {
                        dx = ds[0].mX - event.getX();
                        dy = ds[0].mY - event.getY();
                    }
                    ds[0].mX = event.getX();
                    ds[0].mY = event.getY();
                    int nx = widget.getScrollX() + (int) dx;
                    int ny = widget.getScrollY() + (int) dy;
                    int padding = widget.getTotalPaddingTop() + widget.getTotalPaddingBottom();
                    Layout layout = widget.getLayout();
                    ny = Math.min(ny, layout.getHeight() - (widget.getHeight() - padding));
                    ny = Math.max(ny, 0);
                    int oldX = widget.getScrollX();
                    int oldY = widget.getScrollY();
                    scrollTo(widget, layout, nx, ny);
                    if (oldX != widget.getScrollX() || oldY != widget.getScrollY()) {
                        widget.cancelLongPress();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    
        @DSModeled(DSC.SAFE)
    public static int getInitialScrollX(TextView widget, Spannable buffer) {
        DragState[] ds = buffer.getSpans(0, buffer.length(), DragState.class);
        return ds.length > 0 ? ds[0].mScrollX : -1;
    }

    
        @DSModeled(DSC.SAFE)
    public static int getInitialScrollY(TextView widget, Spannable buffer) {
        DragState[] ds = buffer.getSpans(0, buffer.length(), DragState.class);
        return ds.length > 0 ? ds[0].mScrollY : -1;
    }

    
    private static class DragState implements NoCopySpan {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.057 -0400", hash_original_field = "E47D03BC59EE2C8B3B45870BE85294FB", hash_generated_field = "73D3ED258D648D8615BEDE47CCF51A6E")

        public float mX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.057 -0400", hash_original_field = "29DA5B2B864236A2CCB25B548E8F5F0A", hash_generated_field = "82E0FF02E5426368A20A882CAD772A45")

        public float mY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.057 -0400", hash_original_field = "9DC8F9676E14E93147EBEA37CE364B55", hash_generated_field = "334399BC6C2646CA411F73DCD7584319")

        public int mScrollX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.057 -0400", hash_original_field = "4ABBFD585ECE4FE40BECD8E0C30C4E5E", hash_generated_field = "B0FBEC94797846D4137FCD20C30BEBBA")

        public int mScrollY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.057 -0400", hash_original_field = "BCD7DD5134D20B94D94876D8FC803368", hash_generated_field = "015AF77BCBA0A7F3F5707D8E3E4CDCC7")

        public boolean mFarEnough;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.057 -0400", hash_original_field = "AAD20ABC61C3391785C71250A035D871", hash_generated_field = "B49B60FA806B53FF031F3B4A7FA9E23E")

        public boolean mUsed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.058 -0400", hash_original_method = "08E421E9322E778CECBC733D54E45544", hash_generated_method = "66FA1179FCC318BE27520D77EFA0DCE6")
        public  DragState(float x, float y, int scrollX, int scrollY) {
            mX = x;
            mY = y;
            mScrollX = scrollX;
            mScrollY = scrollY;
            // ---------- Original Method ----------
            //mX = x;
            //mY = y;
            //mScrollX = scrollX;
            //mScrollY = scrollY;
        }

        
    }


    
}

