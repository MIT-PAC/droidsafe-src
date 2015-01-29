package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;

public interface ContextMenu extends Menu {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public ContextMenu setHeaderTitle(int titleRes);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public ContextMenu setHeaderTitle(CharSequence title);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public ContextMenu setHeaderIcon(int iconRes);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public ContextMenu setHeaderIcon(Drawable icon);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public ContextMenu setHeaderView(View view);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void clearHeader();
    
    public interface ContextMenuInfo {
    }
  
}
