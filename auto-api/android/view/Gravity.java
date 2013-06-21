package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Rect;

public class Gravity {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.723 -0400", hash_original_method = "17768DC35D79B74B46A6C9FA8BF860CC", hash_generated_method = "17768DC35D79B74B46A6C9FA8BF860CC")
        public Gravity ()
    {
    }


        public static void apply(int gravity, int w, int h, Rect container, Rect outRect) {
        apply(gravity, w, h, container, 0, 0, outRect);
    }

    
        public static void apply(int gravity, int w, int h, Rect container,
            Rect outRect, int layoutDirection) {
        int absGravity = getAbsoluteGravity(gravity, layoutDirection);
        apply(absGravity, w, h, container, 0, 0, outRect);
    }

    
        public static void apply(int gravity, int w, int h, Rect container,
            int xAdj, int yAdj, Rect outRect) {
        switch (gravity&((AXIS_PULL_BEFORE|AXIS_PULL_AFTER)<<AXIS_X_SHIFT)) {
            case 0:
                outRect.left = container.left
                        + ((container.right - container.left - w)/2) + xAdj;
                outRect.right = outRect.left + w;
                if ((gravity&(AXIS_CLIP<<AXIS_X_SHIFT))
                        == (AXIS_CLIP<<AXIS_X_SHIFT)) {
                    if (outRect.left < container.left) {
                        outRect.left = container.left;
                    }
                    if (outRect.right > container.right) {
                        outRect.right = container.right;
                    }
                }
                break;
            case AXIS_PULL_BEFORE<<AXIS_X_SHIFT:
                outRect.left = container.left + xAdj;
                outRect.right = outRect.left + w;
                if ((gravity&(AXIS_CLIP<<AXIS_X_SHIFT))
                        == (AXIS_CLIP<<AXIS_X_SHIFT)) {
                    if (outRect.right > container.right) {
                        outRect.right = container.right;
                    }
                }
                break;
            case AXIS_PULL_AFTER<<AXIS_X_SHIFT:
                outRect.right = container.right - xAdj;
                outRect.left = outRect.right - w;
                if ((gravity&(AXIS_CLIP<<AXIS_X_SHIFT))
                        == (AXIS_CLIP<<AXIS_X_SHIFT)) {
                    if (outRect.left < container.left) {
                        outRect.left = container.left;
                    }
                }
                break;
            default:
                outRect.left = container.left + xAdj;
                outRect.right = container.right + xAdj;
                break;
        }
        switch (gravity&((AXIS_PULL_BEFORE|AXIS_PULL_AFTER)<<AXIS_Y_SHIFT)) {
            case 0:
                outRect.top = container.top
                        + ((container.bottom - container.top - h)/2) + yAdj;
                outRect.bottom = outRect.top + h;
                if ((gravity&(AXIS_CLIP<<AXIS_Y_SHIFT))
                        == (AXIS_CLIP<<AXIS_Y_SHIFT)) {
                    if (outRect.top < container.top) {
                        outRect.top = container.top;
                    }
                    if (outRect.bottom > container.bottom) {
                        outRect.bottom = container.bottom;
                    }
                }
                break;
            case AXIS_PULL_BEFORE<<AXIS_Y_SHIFT:
                outRect.top = container.top + yAdj;
                outRect.bottom = outRect.top + h;
                if ((gravity&(AXIS_CLIP<<AXIS_Y_SHIFT))
                        == (AXIS_CLIP<<AXIS_Y_SHIFT)) {
                    if (outRect.bottom > container.bottom) {
                        outRect.bottom = container.bottom;
                    }
                }
                break;
            case AXIS_PULL_AFTER<<AXIS_Y_SHIFT:
                outRect.bottom = container.bottom - yAdj;
                outRect.top = outRect.bottom - h;
                if ((gravity&(AXIS_CLIP<<AXIS_Y_SHIFT))
                        == (AXIS_CLIP<<AXIS_Y_SHIFT)) {
                    if (outRect.top < container.top) {
                        outRect.top = container.top;
                    }
                }
                break;
            default:
                outRect.top = container.top + yAdj;
                outRect.bottom = container.bottom + yAdj;
                break;
        }
    }

    
        public static void applyDisplay(int gravity, Rect display, Rect inoutObj) {
        if ((gravity&DISPLAY_CLIP_VERTICAL) != 0) {
            if (inoutObj.top < display.top) inoutObj.top = display.top;
            if (inoutObj.bottom > display.bottom) inoutObj.bottom = display.bottom;
        } else {
            int off = 0;
            if (inoutObj.top < display.top) off = display.top-inoutObj.top;
            else if (inoutObj.bottom > display.bottom) off = display.bottom-inoutObj.bottom;
            if (off != 0) {
                if (inoutObj.height() > (display.bottom-display.top)) {
                    inoutObj.top = display.top;
                    inoutObj.bottom = display.bottom;
                } else {
                    inoutObj.top += off;
                    inoutObj.bottom += off;
                }
            }
        }
        if ((gravity&DISPLAY_CLIP_HORIZONTAL) != 0) {
            if (inoutObj.left < display.left) inoutObj.left = display.left;
            if (inoutObj.right > display.right) inoutObj.right = display.right;
        } else {
            int off = 0;
            if (inoutObj.left < display.left) off = display.left-inoutObj.left;
            else if (inoutObj.right > display.right) off = display.right-inoutObj.right;
            if (off != 0) {
                if (inoutObj.width() > (display.right-display.left)) {
                    inoutObj.left = display.left;
                    inoutObj.right = display.right;
                } else {
                    inoutObj.left += off;
                    inoutObj.right += off;
                }
            }
        }
    }

    
        public static boolean isVertical(int gravity) {
        return gravity > 0 && (gravity & VERTICAL_GRAVITY_MASK) != 0;
    }

    
        public static boolean isHorizontal(int gravity) {
        return gravity > 0 && (gravity & RELATIVE_HORIZONTAL_GRAVITY_MASK) != 0;
    }

    
        public static int getAbsoluteGravity(int gravity, int layoutDirection) {
        int result = gravity;
        if ((result & RELATIVE_LAYOUT_DIRECTION) > 0) {
            if ((result & Gravity.START) == Gravity.START) {
                result &= ~START;
                if (layoutDirection == View.LAYOUT_DIRECTION_RTL) {
                    result |= RIGHT;
                } else {
                    result |= LEFT;
                }
            } else if ((result & Gravity.END) == Gravity.END) {
                result &= ~END;
                if (layoutDirection == View.LAYOUT_DIRECTION_RTL) {
                    result |= LEFT;
                } else {
                    result |= RIGHT;
                }
            }
            result &= ~RELATIVE_LAYOUT_DIRECTION;
        }
        return result;
    }

    
    public static final int NO_GRAVITY = 0x0000;
    public static final int AXIS_SPECIFIED = 0x0001;
    public static final int AXIS_PULL_BEFORE = 0x0002;
    public static final int AXIS_PULL_AFTER = 0x0004;
    public static final int AXIS_CLIP = 0x0008;
    public static final int AXIS_X_SHIFT = 0;
    public static final int AXIS_Y_SHIFT = 4;
    public static final int TOP = (AXIS_PULL_BEFORE|AXIS_SPECIFIED)<<AXIS_Y_SHIFT;
    public static final int BOTTOM = (AXIS_PULL_AFTER|AXIS_SPECIFIED)<<AXIS_Y_SHIFT;
    public static final int LEFT = (AXIS_PULL_BEFORE|AXIS_SPECIFIED)<<AXIS_X_SHIFT;
    public static final int RIGHT = (AXIS_PULL_AFTER|AXIS_SPECIFIED)<<AXIS_X_SHIFT;
    public static final int CENTER_VERTICAL = AXIS_SPECIFIED<<AXIS_Y_SHIFT;
    public static final int FILL_VERTICAL = TOP|BOTTOM;
    public static final int CENTER_HORIZONTAL = AXIS_SPECIFIED<<AXIS_X_SHIFT;
    public static final int FILL_HORIZONTAL = LEFT|RIGHT;
    public static final int CENTER = CENTER_VERTICAL|CENTER_HORIZONTAL;
    public static final int FILL = FILL_VERTICAL|FILL_HORIZONTAL;
    public static final int CLIP_VERTICAL = AXIS_CLIP<<AXIS_Y_SHIFT;
    public static final int CLIP_HORIZONTAL = AXIS_CLIP<<AXIS_X_SHIFT;
    public static final int RELATIVE_LAYOUT_DIRECTION = 0x00800000;
    public static final int HORIZONTAL_GRAVITY_MASK = (AXIS_SPECIFIED |
            AXIS_PULL_BEFORE | AXIS_PULL_AFTER) << AXIS_X_SHIFT;
    public static final int VERTICAL_GRAVITY_MASK = (AXIS_SPECIFIED |
            AXIS_PULL_BEFORE | AXIS_PULL_AFTER) << AXIS_Y_SHIFT;
    public static final int DISPLAY_CLIP_VERTICAL = 0x10000000;
    public static final int DISPLAY_CLIP_HORIZONTAL = 0x01000000;
    public static final int START = RELATIVE_LAYOUT_DIRECTION | LEFT;
    public static final int END = RELATIVE_LAYOUT_DIRECTION | RIGHT;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = START | END;
}

