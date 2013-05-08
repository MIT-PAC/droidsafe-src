package android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.LayoutAnimationController;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public abstract class ViewGroup extends View implements ViewParent, ViewManager {
	

	@DSModeled(DSC.SAFE)
	public ViewGroup(Context context, AttributeSet attrs, int defStyle) {
		super(context); // Taint tracked in super class, View.
    }
	
	@Override
	public void removeView(View view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestLayout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLayoutRequested() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void requestTransparentRegion(View child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void invalidateChild(View child, Rect r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ViewParent invalidateChildInParent(int[] location, Rect r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewParent getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void requestChildFocus(View child, View focused) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recomputeViewAttributes(View child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearChildFocus(View child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getChildVisibleRect(View child, Rect r, Point offset) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View focusSearch(View v, int direction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bringChildToFront(View child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusableViewAvailable(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean showContextMenuForChild(View originalView) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createContextMenu(ContextMenu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActionMode startActionModeForChild(View originalView,
			Callback callback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void childDrawableStateChanged(View child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
			boolean immediate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean requestSendAccessibilityEvent(View child,
			AccessibilityEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	
    public static class LayoutParams {
        /**
         * Special value for the height or width requested by a View.
         * FILL_PARENT means that the view wants to be as big as its parent,
         * minus the parent's padding, if any. This value is deprecated
         * starting in API Level 8 and replaced by {@link #MATCH_PARENT}.
         */
        @SuppressWarnings({"UnusedDeclaration"})
        @Deprecated
        public static final int FILL_PARENT = -1;

        /**
         * Special value for the height or width requested by a View.
         * MATCH_PARENT means that the view wants to be as big as its parent,
         * minus the parent's padding, if any. Introduced in API Level 8.
         */
        public static final int MATCH_PARENT = -1;

        /**
         * Special value for the height or width requested by a View.
         * WRAP_CONTENT means that the view wants to be just large enough to fit
         * its own internal content, taking its own padding into account.
         */
        public static final int WRAP_CONTENT = -2;

        /**
         * Information about how wide the view wants to be. Can be one of the
         * constants FILL_PARENT (replaced by MATCH_PARENT ,
         * in API Level 8) or WRAP_CONTENT. or an exact size.
         */
        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from = MATCH_PARENT, to = "MATCH_PARENT"),
            @ViewDebug.IntToString(from = WRAP_CONTENT, to = "WRAP_CONTENT")
        })
        public int width;

        /**
         * Information about how tall the view wants to be. Can be one of the
         * constants FILL_PARENT (replaced by MATCH_PARENT ,
         * in API Level 8) or WRAP_CONTENT. or an exact size.
         */
        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from = MATCH_PARENT, to = "MATCH_PARENT"),
            @ViewDebug.IntToString(from = WRAP_CONTENT, to = "WRAP_CONTENT")
        })
        public int height;

        /**
         * Used to animate layouts.
         */
        public LayoutAnimationController.AnimationParameters layoutAnimationParameters;

        /**
         * Creates a new set of layout parameters. The values are extracted from
         * the supplied attributes set and context. The XML attributes mapped
         * to this set of layout parameters are:
         *
         * <ul>
         *   <li><code>layout_width</code>: the width, either an exact value,
         *   {@link #WRAP_CONTENT}, or {@link #FILL_PARENT} (replaced by
         *   {@link #MATCH_PARENT} in API Level 8)</li>
         *   <li><code>layout_height</code>: the height, either an exact value,
         *   {@link #WRAP_CONTENT}, or {@link #FILL_PARENT} (replaced by
         *   {@link #MATCH_PARENT} in API Level 8)</li>
         * </ul>
         *
         * @param c the application environment
         * @param attrs the set of attributes from which to extract the layout
         *              parameters' values
         */
        public LayoutParams(Context c, AttributeSet attrs) {
        	/*
            TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.ViewGroup_Layout);
            setBaseAttributes(a,
                    R.styleable.ViewGroup_Layout_layout_width,
                    R.styleable.ViewGroup_Layout_layout_height);
            a.recycle();
            */
        }

        /**
         * Creates a new set of layout parameters with the specified width
         * and height.
         *
         * @param width the width, either {@link #WRAP_CONTENT},
         *        {@link #FILL_PARENT} (replaced by {@link #MATCH_PARENT} in
         *        API Level 8), or a fixed size in pixels
         * @param height the height, either {@link #WRAP_CONTENT},
         *        {@link #FILL_PARENT} (replaced by {@link #MATCH_PARENT} in
         *        API Level 8), or a fixed size in pixels
         */
        public LayoutParams(int width, int height) {
            this.width = width;
            this.height = height;
        }

        /**
         * Copy constructor. Clones the width and height values of the source.
         *
         * @param source The layout params to copy from.
         */
        public LayoutParams(LayoutParams source) {
            this.width = source.width;
            this.height = source.height;
        }

        /**
         * Used internally by MarginLayoutParams.
         * @hide
         */
        LayoutParams() {
        }

        /**
         * Extracts the layout parameters from the supplied attributes.
         *
         * @param a the style attributes to extract the parameters from
         * @param widthAttr the identifier of the width attribute
         * @param heightAttr the identifier of the height attribute
         */
        protected void setBaseAttributes(TypedArray a, int widthAttr, int heightAttr) {
        	/*
            width = a.getLayoutDimension(widthAttr, "layout_width");
            height = a.getLayoutDimension(heightAttr, "layout_height");
            */
        }

        /**
         * Resolve layout parameters depending on the layout direction. Subclasses that care about
         * layoutDirection changes should override this method. The default implementation does
         * nothing.
         *
         * @param layoutDirection the direction of the layout
         *
         * {@link View#LAYOUT_DIRECTION_LTR}
         * {@link View#LAYOUT_DIRECTION_RTL}
         *
         * @hide
         */
        protected void resolveWithDirection(int layoutDirection) {
        }

        /**
         * Returns a String representation of this set of layout parameters.
         *
         * @param output the String to prepend to the internal representation
         * @return a String with the following format: output +
         *         "ViewGroup.LayoutParams={ width=WIDTH, height=HEIGHT }"
         *
         * @hide
         */
        public String debug(String output) {
            return output + "ViewGroup.LayoutParams={ width="
                    + sizeToString(width) + ", height=" + sizeToString(height) + " }";
        }

        /**
         * Converts the specified size to a readable String.
         *
         * @param size the size to convert
         * @return a String instance representing the supplied size
         *
         * @hide
         */
        protected static String sizeToString(int size) {
            if (size == WRAP_CONTENT) {
                return "wrap-content";
            }
            if (size == MATCH_PARENT) {
                return "match-parent";
            }
            return String.valueOf(size);
        }
    }

}
