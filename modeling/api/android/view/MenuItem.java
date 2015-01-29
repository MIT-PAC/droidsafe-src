package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;

public interface MenuItem {
    
    public static final int SHOW_AS_ACTION_NEVER = 0;
    
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    
    public interface OnMenuItemClickListener {

        @DSVerified("Callback modeled")
        @DSSpec(DSCat.ABSTRACT_METHOD)

        public boolean onMenuItemClick(MenuItem item);
    }
    
    public interface OnActionExpandListener {

        @DSVerified("Callback modeled")
        @DSSpec(DSCat.ABSTRACT_METHOD)

        public boolean onMenuItemActionExpand(MenuItem item);

        @DSVerified("Callback modeled")
        @DSSpec(DSCat.ABSTRACT_METHOD)

        public boolean onMenuItemActionCollapse(MenuItem item);
    }

    @DSVerified
    @DSSafe(DSCat.GUI)
    public int getItemId();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getGroupId();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getOrder();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setTitle(CharSequence title);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setTitle(int title);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public CharSequence getTitle();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setTitleCondensed(CharSequence title);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public CharSequence getTitleCondensed();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setIcon(Drawable icon);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setIcon(int iconRes);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Drawable getIcon();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setIntent(Intent intent);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Intent getIntent();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setShortcut(char numericChar, char alphaChar);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setNumericShortcut(char numericChar);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public char getNumericShortcut();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setAlphabeticShortcut(char alphaChar);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public char getAlphabeticShortcut();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setCheckable(boolean checkable);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isCheckable();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setChecked(boolean checked);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isChecked();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setVisible(boolean visible);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isVisible();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setEnabled(boolean enabled);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isEnabled();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public boolean hasSubMenu();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public SubMenu getSubMenu();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItemClickListener);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public ContextMenuInfo getMenuInfo();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public void setShowAsAction(int actionEnum);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setShowAsActionFlags(int actionEnum);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setActionView(View view);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setActionView(int resId);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public View getActionView();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setActionProvider(ActionProvider actionProvider);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public ActionProvider getActionProvider();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public boolean expandActionView();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public boolean collapseActionView();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public boolean isActionViewExpanded();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener);
}
