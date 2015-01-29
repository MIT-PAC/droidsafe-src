package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityEvent;

public interface ViewParent {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public void requestLayout();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isLayoutRequested();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void requestTransparentRegion(View child);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void invalidateChild(View child, Rect r);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public ViewParent invalidateChildInParent(int[] location, Rect r);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public ViewParent getParent();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void requestChildFocus(View child, View focused);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void recomputeViewAttributes(View child);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void clearChildFocus(View child);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean getChildVisibleRect(View child, Rect r, android.graphics.Point offset);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public View focusSearch(View v, int direction);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void bringChildToFront(View child);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void focusableViewAvailable(View v);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean showContextMenuForChild(View originalView);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void createContextMenu(ContextMenu menu);
    
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void childDrawableStateChanged(View child);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void childHasTransientStateChanged(View view,
            boolean hasTransientState);
}
