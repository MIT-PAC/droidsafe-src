package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;





public class Touch {

    /**
     * Scrolls the specified widget to the specified coordinates, except
     * constrains the X scrolling position to the horizontal regions of
     * the text that will be visible after scrolling to the specified
     * Y position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.240 -0500", hash_original_method = "0A63E049EA1E17346730D259CF4DA78F", hash_generated_method = "3923F6F8F48610B9EE0B46389A341951")
    
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
                // align_opposite does NOT mean align_right, we need the paragraph
                // direction to resolve it to left or right
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

    /**
     * Handles touch events for dragging.  You may want to do other actions
     * like moving the cursor on touch as well.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.246 -0500", hash_original_method = "7FDDE82DCC606FA9E5D06171C4D7A283", hash_generated_method = "2DCD092639F2BFD0DFB3E894AE55E7E2")
    
public static boolean onTouchEvent(TextView widget, Spannable buffer,
                                       MotionEvent event) {
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
                        // if we're selecting, we want the scroll to go in
                        // the direction of the drag
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

                    // If we actually scrolled, then cancel the up action.
                    if (oldX != widget.getScrollX() || oldY != widget.getScrollY()) {
                        widget.cancelLongPress();
                    }

                    return true;
                }
            }
        }

        return false;
    }

    /**
     * @param widget The text view.
     * @param buffer The text buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.249 -0500", hash_original_method = "21A6B0AF92D8F3153406023AEF6A8E5C", hash_generated_method = "38BBC942F6E38D4DAD65AAA76E1BB6FD")
    
public static int getInitialScrollX(TextView widget, Spannable buffer) {
        DragState[] ds = buffer.getSpans(0, buffer.length(), DragState.class);
        return ds.length > 0 ? ds[0].mScrollX : -1;
    }

    /**
     * @param widget The text view.
     * @param buffer The text buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.252 -0500", hash_original_method = "B84AB2EF8D3990EF6883032B7F14AD49", hash_generated_method = "2A017FF43FB8FC7FA2D6AFC9762F0C6F")
    
public static int getInitialScrollY(TextView widget, Spannable buffer) {
        DragState[] ds = buffer.getSpans(0, buffer.length(), DragState.class);
        return ds.length > 0 ? ds[0].mScrollY : -1;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.236 -0500", hash_original_method = "FF7FAE7578041B972B60FFE115691062", hash_generated_method = "D97CEA10EC28BE39D0E9D5E928FAA2FF")
    
private Touch() { }

    
    private static class DragState implements NoCopySpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.256 -0500", hash_original_field = "8174733DF249E326666A04F4BE58CCC8", hash_generated_field = "73D3ED258D648D8615BEDE47CCF51A6E")

        public float mX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.259 -0500", hash_original_field = "5EA984BC6FFFB7EE5487B162E48C8CE7", hash_generated_field = "82E0FF02E5426368A20A882CAD772A45")

        public float mY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.262 -0500", hash_original_field = "E9A45ED540F0B589A497E7AFE99EBA3D", hash_generated_field = "334399BC6C2646CA411F73DCD7584319")

        public int mScrollX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.264 -0500", hash_original_field = "EC6AD52CC705AA3985B25CDB13E68426", hash_generated_field = "B0FBEC94797846D4137FCD20C30BEBBA")

        public int mScrollY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.267 -0500", hash_original_field = "0AC0A684082022F1AD7A3A10AC56DE1D", hash_generated_field = "015AF77BCBA0A7F3F5707D8E3E4CDCC7")

        public boolean mFarEnough;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.271 -0500", hash_original_field = "A11366C6A1103779F891579A3BB65D95", hash_generated_field = "B49B60FA806B53FF031F3B4A7FA9E23E")

        public boolean mUsed;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.274 -0500", hash_original_method = "08E421E9322E778CECBC733D54E45544", hash_generated_method = "CBDDFCF144597B69D6952C3A10B53A3D")
        
public DragState(float x, float y, int scrollX, int scrollY) {
            mX = x;
            mY = y;
            mScrollX = scrollX;
            mScrollY = scrollY;
        }

        
    }


    
}

