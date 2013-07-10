package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.AdapterView;

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
