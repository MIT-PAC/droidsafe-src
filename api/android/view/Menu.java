package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
    
    @DSVerified
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem add(CharSequence title);
    
    @DSVerified
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem add(int titleRes);
    
        @DSVerified
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public MenuItem add(int groupId, int itemId, int order, CharSequence title);
    
        @DSVerified
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public MenuItem add(int groupId, int itemId, int order, int titleRes);
    
    
    @DSVerified
    @DSComment("Abstract Method")
    SubMenu addSubMenu(final CharSequence title);
    
    
    @DSVerified
    @DSComment("Abstract Method")
    SubMenu addSubMenu(final int titleRes);
    
    SubMenu addSubMenu(final int groupId, final int itemId, int order, final CharSequence title);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes);
    
    @DSVerified
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int addIntentOptions(int groupId, int itemId, int order,
                                ComponentName caller, Intent[] specifics,
                                Intent intent, int flags, MenuItem[] outSpecificItems);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void removeItem(int id);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void removeGroup(int groupId);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void clear();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setGroupCheckable(int group, boolean checkable, boolean exclusive);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setGroupVisible(int group, boolean visible);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setGroupEnabled(int group, boolean enabled);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean hasVisibleItems();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem findItem(int id);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int size();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem getItem(int index);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void close();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean performShortcut(int keyCode, KeyEvent event, int flags);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean isShortcutKey(int keyCode, KeyEvent event);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean performIdentifierAction(int id, int flags);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setQwertyMode(boolean isQwerty);
}
