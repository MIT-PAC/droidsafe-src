package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityEvent;

public interface ViewParent {
    
    public void requestLayout();

    
    public boolean isLayoutRequested();

    
    public void requestTransparentRegion(View child);

    
    public void invalidateChild(View child, Rect r);

    
    public ViewParent invalidateChildInParent(int[] location, Rect r);

    
    public ViewParent getParent();

    
    public void requestChildFocus(View child, View focused);

    
    public void recomputeViewAttributes(View child);
    
    
    public void clearChildFocus(View child);

    
    public boolean getChildVisibleRect(View child, Rect r, android.graphics.Point offset);

    
    public View focusSearch(View v, int direction);

    
    public void bringChildToFront(View child);

    
    public void focusableViewAvailable(View v);

    
    public boolean showContextMenuForChild(View originalView);

    
    public void createContextMenu(ContextMenu menu);

    
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback);

    
    public void childDrawableStateChanged(View child);
    
    
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept);
    
    
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate);

    
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event);
}
