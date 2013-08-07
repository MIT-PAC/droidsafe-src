package android.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.ComponentName;
import android.content.Intent;

public interface Menu {

    
    static final int USER_MASK = 0x0000ffff;
    
    static final int USER_SHIFT = 0;

    
    static final int CATEGORY_MASK = 0xffff0000;
    
    static final int CATEGORY_SHIFT = 16;

    
    static final int NONE = 0;

    
    static final int FIRST = 1;

    
    

    
    static final int CATEGORY_CONTAINER = 0x00010000;

    
    static final int CATEGORY_SYSTEM = 0x00020000;

    
    static final int CATEGORY_SECONDARY = 0x00030000;

    
    static final int CATEGORY_ALTERNATIVE = 0x00040000;

    
    static final int FLAG_APPEND_TO_GROUP = 0x0001;

    
    static final int FLAG_PERFORM_NO_CLOSE = 0x0001;

    
    static final int FLAG_ALWAYS_PERFORM_CLOSE = 0x0002;
    
    
    public MenuItem add(CharSequence title);
    
    
    public MenuItem add(int titleRes);

    
    public MenuItem add(int groupId, int itemId, int order, CharSequence title);

    
    public MenuItem add(int groupId, int itemId, int order, int titleRes);

    
    SubMenu addSubMenu(final CharSequence title);

    
    SubMenu addSubMenu(final int titleRes);

    
    SubMenu addSubMenu(final int groupId, final int itemId, int order, final CharSequence title);

    
    SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes);

    
    public int addIntentOptions(int groupId, int itemId, int order,
                                ComponentName caller, Intent[] specifics,
                                Intent intent, int flags, MenuItem[] outSpecificItems);

    
    public void removeItem(int id);

    
    public void removeGroup(int groupId);

    
    public void clear();

    
    public void setGroupCheckable(int group, boolean checkable, boolean exclusive);

    
    public void setGroupVisible(int group, boolean visible);
    
    
    public void setGroupEnabled(int group, boolean enabled);
    
    
    public boolean hasVisibleItems();

    
    public MenuItem findItem(int id);

    
    public int size();

    
    public MenuItem getItem(int index);
    
    
    public void close();
    
    
    public boolean performShortcut(int keyCode, KeyEvent event, int flags);

    
    boolean isShortcutKey(int keyCode, KeyEvent event);
    
    
    public boolean performIdentifierAction(int id, int flags);


    
    public void setQwertyMode(boolean isQwerty);
}
