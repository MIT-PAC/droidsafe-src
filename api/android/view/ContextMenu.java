package android.view;

// Droidsafe Imports
import android.graphics.drawable.Drawable;

public interface ContextMenu extends Menu {
    
    public ContextMenu setHeaderTitle(int titleRes);

    
    public ContextMenu setHeaderTitle(CharSequence title);
    
    
    public ContextMenu setHeaderIcon(int iconRes);

    
    public ContextMenu setHeaderIcon(Drawable icon);
    
    
    public ContextMenu setHeaderView(View view);
    
    
    public void clearHeader();
    
    
    public interface ContextMenuInfo {
    }
}
