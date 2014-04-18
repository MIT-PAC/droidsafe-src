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
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setTitle(CharSequence title);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setTitle(int title);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public CharSequence getTitle();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setTitleCondensed(CharSequence title);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public CharSequence getTitleCondensed();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setIcon(Drawable icon);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setIcon(int iconRes);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Drawable getIcon();
    
    @DSVerified
    @DSSpec(DSCat.INTENT_EXCHANGE)
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
    @DSSpec(DSCat.ABSTRACT_METHOD)
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
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setVisible(boolean visible);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isVisible();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setEnabled(boolean enabled);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isEnabled();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean hasSubMenu();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public SubMenu getSubMenu();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItemClickListener);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public ContextMenuInfo getMenuInfo();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setShowAsAction(int actionEnum);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setShowAsActionFlags(int actionEnum);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setActionView(View view);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setActionView(int resId);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public View getActionView();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setActionProvider(ActionProvider actionProvider);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public ActionProvider getActionProvider();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean expandActionView();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean collapseActionView();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isActionViewExpanded();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener);
}
