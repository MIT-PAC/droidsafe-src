package android.view;

import droidsafe.annotations.*;
import droidsafe.helpers.DSTaintObject;

import android.content.ClipData;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Interpolator;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.util.LocaleUtil;
import android.util.Log;
import android.util.Pool;
import android.util.Poolable;
import android.util.PoolableManager;
import android.util.Pools;
import android.util.Property;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityEventSource;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.ScrollBarDrawable;

import static android.os.Build.VERSION_CODES.*;

import com.android.internal.R;
import com.android.internal.util.Predicate;
import com.android.internal.view.menu.MenuBuilder;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

@DSModeled
public class View implements Drawable.Callback, Drawable.Callback2, KeyEvent.Callback,
        AccessibilityEventSource {
	
		private DSTaintObject dsTaint = new DSTaintObject();
		
		protected Context mContext;
		
		static {
			
		}
		
		@DSModeled(value = DSC.SAFE)
		public View(Context context) {
			dsTaint.addTaint(context);
	        mContext = context;
	    }
		
		public interface OnClickListener {
			void onClick(View v);
		}
	
	    @DSModeled /* to set up the event handler, call the listener, but also
		  save the listener for use in perform click
	     */
	    public void setOnClickListener(OnClickListener l) {
	    	l.onClick(this);
	    }

		@Override
		public void sendAccessibilityEvent(int paramInt) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void sendAccessibilityEventUnchecked(
				AccessibilityEvent paramAccessibilityEvent) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onKeyMultiple(int paramInt1, int paramInt2,
				KeyEvent paramKeyEvent) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void invalidateDrawable(Drawable paramDrawable) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void scheduleDrawable(Drawable paramDrawable,
				Runnable paramRunnable, long paramLong) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void unscheduleDrawable(Drawable paramDrawable,
				Runnable paramRunnable) {
			// TODO Auto-generated method stub
			
		}
		
		 /**
	     * Register a callback to be invoked when the context menu for this view is
	     * being built. If this view is not long clickable, it becomes long clickable.
	     *
	     * @param l The callback that will run
	     *
	     */
	    public void setOnCreateContextMenuListener(OnCreateContextMenuListener l) {
	    }
	    
	    @DSModeled(DSC.SAFE)
	    public void setVisibility(int visibility) {
	    	dsTaint.addTaint(visibility);
	    }

	    @DSModeled(DSC.SAFE)
	    public int getId() {
	        return dsTaint.getTaintInt();
	    }
	    
	    @DSModeled(DSC.SAFE)
	    public void setId(int id) {
	        dsTaint.addTaint(id);
	    }

	    @DSModeled(DSC.SAFE)
	    public Object getTag() {
	        return dsTaint.getTaint();
	    }

	    @DSModeled(DSC.SAFE)
	    public void setTag(final Object tag) {
	        dsTaint.addTaint(tag);
	    }

	    @DSModeled(DSC.SAFE)
	    public boolean showContextMenu() {
	        return dsTaint.getTaintBoolean();
	    }
	    
	    //DSModel: only adding so can compile, need to model
	    public ActionMode startActionMode(ActionMode.Callback callback) {
	        return null;
	    }
		
		 /**
	     * Interface definition for a callback to be invoked when the context menu
	     * for this view is being built.
	     */
	    public interface OnCreateContextMenuListener {
	        /**
	         * Called when the context menu for this view is being built. It is not
	         * safe to hold onto the menu after this method returns.
	         *
	         * @param menu The context menu that is being built
	         * @param v The view for which the context menu is being built
	         * @param menuInfo Extra information about the item for which the
	         *            context menu should be shown. This information will vary
	         *            depending on the class of v.
	         */
	        void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo);
	    }

	    public int getResolvedLayoutDirection(android.graphics.drawable.Drawable d) {
	    	return -1;
	    }

	    /**
	     * Used to mark a View that has no ID.
	     */
	    public final int NO_ID = -1;

	    /**
	     * This view does not want keystrokes. Use with TAKES_FOCUS_MASK when
	     * calling setFlags.
	     */
	    private final int NOT_FOCUSABLE = 0x00000000;

	    /**
	     * This view wants keystrokes. Use with TAKES_FOCUS_MASK when calling
	     * setFlags.
	     */
	    private final int FOCUSABLE = 0x00000001;

	    /**
	     * Mask for use with setFlags indicating bits used for focus.
	     */
	    private final int FOCUSABLE_MASK = 0x00000001;

	    /**
	     * This view will adjust its padding to fit sytem windows (e.g. status bar)
	     */
	    private final int FITS_SYSTEM_WINDOWS = 0x00000002;

	    /**
	     * This view is visible.
	     * Use with {@link #setVisibility} and <a href="#attr_android:visibility">{@code
	     * android:visibility}.
	     */
	    public final int VISIBLE = 0x00000000;

	    /**
	     * This view is invisible, but it still takes up space for layout purposes.
	     * Use with {@link #setVisibility} and <a href="#attr_android:visibility">{@code
	     * android:visibility}.
	     */
	    public static final int INVISIBLE = 0x00000004;

	    /**
	     * This view is invisible, and it doesn't take any space for layout
	     * purposes. Use with {@link #setVisibility} and <a href="#attr_android:visibility">{@code
	     * android:visibility}.
	     */
	    public final int GONE = 0x00000008;

	    /**
	     * Mask for use with setFlags indicating bits used for visibility.
	     * {@hide}
	     */
	    static final int VISIBILITY_MASK = 0x0000000C;

	    private final int[] VISIBILITY_FLAGS = {VISIBLE, INVISIBLE, GONE};

	    /**
	     * This view is enabled. Intrepretation varies by subclass.
	     * Use with ENABLED_MASK when calling setFlags.
	     * {@hide}
	     */
	    static final int ENABLED = 0x00000000;

	    /**
	     * This view is disabled. Intrepretation varies by subclass.
	     * Use with ENABLED_MASK when calling setFlags.
	     * {@hide}
	     */
	    static final int DISABLED = 0x00000020;

	   /**
	    * Mask for use with setFlags indicating bits used for indicating whether
	    * this view is enabled
	    * {@hide}
	    */
	    static final int ENABLED_MASK = 0x00000020;

	    /**
	     * This view won't draw. {@link #onDraw(android.graphics.Canvas)} won't be
	     * called and further optimizations will be performed. It is okay to have
	     * this flag set and a background. Use with DRAW_MASK when calling setFlags.
	     * {@hide}
	     */
	    static final int WILL_NOT_DRAW = 0x00000080;

	    /**
	     * Mask for use with setFlags indicating bits used for indicating whether
	     * this view is will draw
	     * {@hide}
	     */
	    static final int DRAW_MASK = 0x00000080;

	    /**
	     * <p>This view doesn't show scrollbars.</p>
	     * {@hide}
	     */
	    static final int SCROLLBARS_NONE = 0x00000000;

	    /**
	     * <p>This view shows horizontal scrollbars.</p>
	     * {@hide}
	     */
	    static final int SCROLLBARS_HORIZONTAL = 0x00000100;

	    /**
	     * <p>This view shows vertical scrollbars.</p>
	     * {@hide}
	     */
	    static final int SCROLLBARS_VERTICAL = 0x00000200;

	    /**
	     * <p>Mask for use with setFlags indicating bits used for indicating which
	     * scrollbars are enabled.</p>
	     * {@hide}
	     */
	    static final int SCROLLBARS_MASK = 0x00000300;

	    /**
	     * Indicates that the view should filter touches when its window is obscured.
	     * Refer to the class comments for more information about this security feature.
	     * {@hide}
	     */
	    static final int FILTER_TOUCHES_WHEN_OBSCURED = 0x00000400;

	    // note flag value 0x00000800 is now available for next flags...

	    /**
	     * <p>This view doesn't show fading edges.</p>
	     * {@hide}
	     */
	    static final int FADING_EDGE_NONE = 0x00000000;

	    /**
	     * <p>This view shows horizontal fading edges.</p>
	     * {@hide}
	     */
	    static final int FADING_EDGE_HORIZONTAL = 0x00001000;

	    /**
	     * <p>This view shows vertical fading edges.</p>
	     * {@hide}
	     */
	    static final int FADING_EDGE_VERTICAL = 0x00002000;

	    /**
	     * <p>Mask for use with setFlags indicating bits used for indicating which
	     * fading edges are enabled.</p>
	     * {@hide}
	     */
	    static final int FADING_EDGE_MASK = 0x00003000;

	    /**
	     * <p>Indicates this view can be clicked. When clickable, a View reacts
	     * to clicks by notifying the OnClickListener.<p>
	     * {@hide}
	     */
	    static final int CLICKABLE = 0x00004000;

	    /**
	     * <p>Indicates this view is caching its drawing into a bitmap.</p>
	     * {@hide}
	     */
	    static final int DRAWING_CACHE_ENABLED = 0x00008000;

	    /**
	     * <p>Indicates that no icicle should be saved for this view.<p>
	     * {@hide}
	     */
	    static final int SAVE_DISABLED = 0x000010000;

	    /**
	     * <p>Mask for use with setFlags indicating bits used for the saveEnabled
	     * property.</p>
	     * {@hide}
	     */
	    static final int SAVE_DISABLED_MASK = 0x000010000;

	    /**
	     * <p>Indicates that no drawing cache should ever be created for this view.<p>
	     * {@hide}
	     */
	    static final int WILL_NOT_CACHE_DRAWING = 0x000020000;

	    /**
	     * <p>Indicates this view can take / keep focus when int touch mode.</p>
	     * {@hide}
	     */
	    static final int FOCUSABLE_IN_TOUCH_MODE = 0x00040000;

	    /**
	     * <p>Enables low quality mode for the drawing cache.</p>
	     */
	    public final int DRAWING_CACHE_QUALITY_LOW = 0x00080000;

	    /**
	     * <p>Enables high quality mode for the drawing cache.</p>
	     */
	    public final int DRAWING_CACHE_QUALITY_HIGH = 0x00100000;

	    /**
	     * <p>Enables automatic quality mode for the drawing cache.</p>
	     */
	    public final int DRAWING_CACHE_QUALITY_AUTO = 0x00000000;

	    private final int[] DRAWING_CACHE_QUALITY_FLAGS = {
	            DRAWING_CACHE_QUALITY_AUTO, DRAWING_CACHE_QUALITY_LOW, DRAWING_CACHE_QUALITY_HIGH
	    };

	    /**
	     * <p>Mask for use with setFlags indicating bits used for the cache
	     * quality property.</p>
	     * {@hide}
	     */
	    static final int DRAWING_CACHE_QUALITY_MASK = 0x00180000;

	    /**
	     * <p>
	     * Indicates this view can be long clicked. When long clickable, a View
	     * reacts to long clicks by notifying the OnLongClickListener or showing a
	     * context menu.
	     * </p>
	     * {@hide}
	     */
	    static final int LONG_CLICKABLE = 0x00200000;

	    /**
	     * <p>Indicates that this view gets its drawable states from its direct parent
	     * and ignores its original internal states.</p>
	     *
	     * @hide
	     */
	    static final int DUPLICATE_PARENT_STATE = 0x00400000;

	    /**
	     * The scrollbar style to display the scrollbars inside the content area,
	     * without increasing the padding. The scrollbars will be overlaid with
	     * translucency on the view's content.
	     */
	    public final int SCROLLBARS_INSIDE_OVERLAY = 0;

	    /**
	     * The scrollbar style to display the scrollbars inside the padded area,
	     * increasing the padding of the view. The scrollbars will not overlap the
	     * content area of the view.
	     */
	    public final int SCROLLBARS_INSIDE_INSET = 0x01000000;

	    /**
	     * The scrollbar style to display the scrollbars at the edge of the view,
	     * without increasing the padding. The scrollbars will be overlaid with
	     * translucency.
	     */
	    public final int SCROLLBARS_OUTSIDE_OVERLAY = 0x02000000;

	    /**
	     * The scrollbar style to display the scrollbars at the edge of the view,
	     * increasing the padding of the view. The scrollbars will only overlap the
	     * background, if any.
	     */
	    public final int SCROLLBARS_OUTSIDE_INSET = 0x03000000;

	    /**
	     * Mask to check if the scrollbar style is overlay or inset.
	     * {@hide}
	     */
	    static final int SCROLLBARS_INSET_MASK = 0x01000000;

	    /**
	     * Mask to check if the scrollbar style is inside or outside.
	     * {@hide}
	     */
	    static final int SCROLLBARS_OUTSIDE_MASK = 0x02000000;

	    /**
	     * Mask for scrollbar style.
	     * {@hide}
	     */
	    static final int SCROLLBARS_STYLE_MASK = 0x03000000;

	    /**
	     * View flag indicating that the screen should remain on while the
	     * window containing this view is visible to the user.  This effectively
	     * takes care of automatically setting the WindowManager's
	     * {@link WindowManager.LayoutParams#FLAG_KEEP_SCREEN_ON}.
	     */
	    public final int KEEP_SCREEN_ON = 0x04000000;

	    /**
	     * View flag indicating whether this view should have sound effects enabled
	     * for events such as clicking and touching.
	     */
	    public final int SOUND_EFFECTS_ENABLED = 0x08000000;

	    /**
	     * View flag indicating whether this view should have haptic feedback
	     * enabled for events such as long presses.
	     */
	    public final int HAPTIC_FEEDBACK_ENABLED = 0x10000000;

	    /**
	     * <p>Indicates that the view hierarchy should stop saving state when
	     * it reaches this view.  If state saving is initiated immediately at
	     * the view, it will be allowed.
	     * {@hide}
	     */
	    static final int PARENT_SAVE_DISABLED = 0x20000000;

	    /**
	     * <p>Mask for use with setFlags indicating bits used for PARENT_SAVE_DISABLED.</p>
	     * {@hide}
	     */
	    static final int PARENT_SAVE_DISABLED_MASK = 0x20000000;

	    /**
	     * Horizontal direction of this view is from Left to Right.
	     * Use with {@link #setLayoutDirection}.
	     * {@hide}
	     */
	    public final int LAYOUT_DIRECTION_LTR = 0x00000000;

	    /**
	     * Horizontal direction of this view is from Right to Left.
	     * Use with {@link #setLayoutDirection}.
	     * {@hide}
	     */
	    public final int LAYOUT_DIRECTION_RTL = 0x40000000;

	    /**
	     * Horizontal direction of this view is inherited from its parent.
	     * Use with {@link #setLayoutDirection}.
	     * {@hide}
	     */
	    public final int LAYOUT_DIRECTION_INHERIT = 0x80000000;

	    /**
	     * Horizontal direction of this view is from deduced from the default language
	     * script for the locale. Use with {@link #setLayoutDirection}.
	     * {@hide}
	     */
	    public final int LAYOUT_DIRECTION_LOCALE = 0xC0000000;

	    /**
	     * Mask for use with setFlags indicating bits used for horizontalDirection.
	     * {@hide}
	     */
	    static final int LAYOUT_DIRECTION_MASK = 0xC0000000;

	    /*
	     * Array of horizontal direction flags for mapping attribute "horizontalDirection" to correct
	     * flag value.
	     * {@hide}
	     */
	    private final int[] LAYOUT_DIRECTION_FLAGS = {LAYOUT_DIRECTION_LTR,
	        LAYOUT_DIRECTION_RTL, LAYOUT_DIRECTION_INHERIT, LAYOUT_DIRECTION_LOCALE};

	    /**
	     * Default horizontalDirection.
	     * {@hide}
	     */
	    private final int LAYOUT_DIRECTION_DEFAULT = LAYOUT_DIRECTION_INHERIT;

	    /**
	     * View flag indicating whether {@link #addFocusables(ArrayList, int, int)}
	     * should add all focusable Views regardless if they are focusable in touch mode.
	     */
	    public final int FOCUSABLES_ALL = 0x00000000;

	    /**
	     * View flag indicating whether {@link #addFocusables(ArrayList, int, int)}
	     * should add only Views focusable in touch mode.
	     */
	    public final int FOCUSABLES_TOUCH_MODE = 0x00000001;

	    /**
	     * Use with {@link #focusSearch(int)}. Move focus to the previous selectable
	     * item.
	     */
	    public final int FOCUS_BACKWARD = 0x00000001;

	    /**
	     * Use with {@link #focusSearch(int)}. Move focus to the next selectable
	     * item.
	     */
	    public final int FOCUS_FORWARD = 0x00000002;

	    /**
	     * Use with {@link #focusSearch(int)}. Move focus to the left.
	     */
	    public final int FOCUS_LEFT = 0x00000011;

	    /**
	     * Use with {@link #focusSearch(int)}. Move focus up.
	     */
	    public final int FOCUS_UP = 0x00000021;

	    /**
	     * Use with {@link #focusSearch(int)}. Move focus to the right.
	     */
	    public final int FOCUS_RIGHT = 0x00000042;

	    /**
	     * Use with {@link #focusSearch(int)}. Move focus down.
	     */
	    public final int FOCUS_DOWN = 0x00000082;

	    /**
	     * Bits of {@link #getMeasuredWidthAndState()} and
	     * {@link #getMeasuredWidthAndState()} that provide the actual measured size.
	     */
	    public final int MEASURED_SIZE_MASK = 0x00ffffff;

	    /**
	     * Bits of {@link #getMeasuredWidthAndState()} and
	     * {@link #getMeasuredWidthAndState()} that provide the additional state bits.
	     */
	    public final int MEASURED_STATE_MASK = 0xff000000;

	    /**
	     * Bit shift of {@link #MEASURED_STATE_MASK} to get to the height bits
	     * for functions that combine both width and height into a single int,
	     * such as {@link #getMeasuredState()} and the childState argument of
	     * {@link #resolveSizeAndState(int, int, int)}.
	     */
	    public final int MEASURED_HEIGHT_STATE_SHIFT = 16;

	    /**
	     * Bit of {@link #getMeasuredWidthAndState()} and
	     * {@link #getMeasuredWidthAndState()} that indicates the measured size
	     * is smaller that the space the view would like to have.
	     */
	    public final int MEASURED_STATE_TOO_SMALL = 0x01000000;

	    /**
	     * Base View state sets
	     */
	    
	    @DSModeled(DSC.SAFE)
	    public void invalidate() {
	        invalidate(true);
	    }
	    
	    @DSModeled(DSC.SAFE)
	    void invalidate(boolean invalidateCache) {
	    	/*
	    	 * DSFIXME:  This method stubbed out for now, nothing is dealing with mParent
	    	 * currently.  If mParent is to be modeled, uncomment out the appropriate
	    	 * portions so that it can be modeled. 
	    	 */
	    	/*
	        if (ViewDebug.TRACE_HIERARCHY) {
	            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE);
	        }

	        if (skipInvalidate()) {
	            return;
	        }
	        if ((mPrivateFlags & (DRAWN | HAS_BOUNDS)) == (DRAWN | HAS_BOUNDS) ||
	                (invalidateCache && (mPrivateFlags & DRAWING_CACHE_VALID) == DRAWING_CACHE_VALID) ||
	                (mPrivateFlags & INVALIDATED) != INVALIDATED || isOpaque() != mLastIsOpaque) {
	            mLastIsOpaque = isOpaque();
	            mPrivateFlags &= ~DRAWN;
	            mPrivateFlags |= DIRTY;
	            if (invalidateCache) {
	                mPrivateFlags |= INVALIDATED;
	                mPrivateFlags &= ~DRAWING_CACHE_VALID;
	            }
	            final AttachInfo ai = mAttachInfo;
	            final ViewParent p = mParent;
	            //noinspection PointlessBooleanExpression,ConstantConditions
	            if (!HardwareRenderer.RENDER_DIRTY_REGIONS) {
	                if (p != null && ai != null && ai.mHardwareAccelerated) {
	                    // fast-track for GL-enabled applications; just invalidate the whole hierarchy
	                    // with a null dirty rect, which tells the ViewAncestor to redraw everything
	                    p.invalidateChild(this, null);
	                    return;
	                }
	            }

	            if (p != null && ai != null) {
	                final Rect r = ai.mTmpInvalRect;
	                r.set(0, 0, mRight - mLeft, mBottom - mTop);
	                // Don't call invalidate -- we don't want to internally scroll
	                // our own bounds
	                p.invalidateChild(this, r);
	            }
	        }
	        */
	    }
	    
	    @DSModeled(DSC.SAFE)
	    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
	    }
}
