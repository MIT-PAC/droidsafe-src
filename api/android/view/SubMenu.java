package android.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.graphics.drawable.Drawable;

public interface SubMenu extends Menu {
    
    public SubMenu setHeaderTitle(int titleRes);

    
    public SubMenu setHeaderTitle(CharSequence title);
    
    
    public SubMenu setHeaderIcon(int iconRes);

    
    public SubMenu setHeaderIcon(Drawable icon);
    
    
    public SubMenu setHeaderView(View view);
    
    
    public void clearHeader();
    
    
    public SubMenu setIcon(int iconRes);
    
    
    public SubMenu setIcon(Drawable icon);
    
    
    public MenuItem getItem();
}
