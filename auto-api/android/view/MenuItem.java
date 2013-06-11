package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnCreateContextMenuListener;

public interface MenuItem {
    
    
    public static final int SHOW_AS_ACTION_NEVER = 0;
    
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    
    public static final int SHOW_AS_ACTION_ALWAYS = 2;

    
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;

    
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    
    
    public interface OnMenuItemClickListener {
        
        public boolean onMenuItemClick(MenuItem item);
    }

    
    public interface OnActionExpandListener {
        
        public boolean onMenuItemActionExpand(MenuItem item);

        
        public boolean onMenuItemActionCollapse(MenuItem item);
    }

    
    public int getItemId();

    
    public int getGroupId();

    
    public int getOrder();
    
    
    public MenuItem setTitle(CharSequence title);

    
    
    public MenuItem setTitle(int title);

    
    public CharSequence getTitle();

    
    public MenuItem setTitleCondensed(CharSequence title);

    
    public CharSequence getTitleCondensed();

    
    public MenuItem setIcon(Drawable icon);

    
    public MenuItem setIcon(int iconRes);
    
    
    public Drawable getIcon();
    
    
    public MenuItem setIntent(Intent intent);

    
    public Intent getIntent();

    
    public MenuItem setShortcut(char numericChar, char alphaChar);

    
    public MenuItem setNumericShortcut(char numericChar);

    
    public char getNumericShortcut();

    
    public MenuItem setAlphabeticShortcut(char alphaChar);

    
    public char getAlphabeticShortcut();

    
    public MenuItem setCheckable(boolean checkable);

    
    public boolean isCheckable();

    
    public MenuItem setChecked(boolean checked);

    
    public boolean isChecked();

    
    public MenuItem setVisible(boolean visible);

    
    public boolean isVisible();

    
    public MenuItem setEnabled(boolean enabled);

    
    public boolean isEnabled();

    
    public boolean hasSubMenu();

    
    public SubMenu getSubMenu();

    
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItemClickListener);

    
    public ContextMenuInfo getMenuInfo();
    
    
    public void setShowAsAction(int actionEnum);

    
    public MenuItem setShowAsActionFlags(int actionEnum);

    
    public MenuItem setActionView(View view);

    
    public MenuItem setActionView(int resId);

    
    public View getActionView();

    
    public MenuItem setActionProvider(ActionProvider actionProvider);

    
    public ActionProvider getActionProvider();

    
    public boolean expandActionView();

    
    public boolean collapseActionView();

    
    public boolean isActionViewExpanded();

    
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener);
}

