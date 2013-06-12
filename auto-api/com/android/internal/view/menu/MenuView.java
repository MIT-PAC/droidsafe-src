package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.view.menu.MenuItemImpl;
import android.graphics.drawable.Drawable;

public interface MenuView {
    
    public void initialize(MenuBuilder menu);

    
    public int getWindowAnimations();
    
    
    public interface ItemView {
        
        public void initialize(MenuItemImpl itemData, int menuType);
        
        
        public MenuItemImpl getItemData();
        
        
        public void setTitle(CharSequence title);

        
        public void setEnabled(boolean enabled);
        
        
        public void setCheckable(boolean checkable);
        
        
        public void setChecked(boolean checked);

        
        public void setShortcut(boolean showShortcut, char shortcutKey);
        
        
        public void setIcon(Drawable icon);
        
        
        public boolean prefersCondensedTitle();

        
        public boolean showsIcon();
    }
}

