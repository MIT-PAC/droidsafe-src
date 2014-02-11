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
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public ContextMenu setHeaderTitle(int titleRes);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
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
    
    public static class DroidSafeContextMenu implements ContextMenu {

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public MenuItem add(CharSequence title) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public MenuItem add(int titleRes) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public MenuItem add(int groupId, int itemId, int order,
                CharSequence title) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public MenuItem add(int groupId, int itemId, int order, int titleRes) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public SubMenu addSubMenu(CharSequence title) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public SubMenu addSubMenu(int titleRes) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public SubMenu addSubMenu(int groupId, int itemId, int order,
                CharSequence title) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public
        SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public int addIntentOptions(int groupId, int itemId, int order,
                ComponentName caller, Intent[] specifics, Intent intent,
                int flags, MenuItem[] outSafeificItems) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public void removeItem(int id) {
            // TODO Auto-generated method stub
            
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public void removeGroup(int groupId) {
            // TODO Auto-generated method stub
            
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public void clear() {
            // TODO Auto-generated method stub
            
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public void setGroupCheckable(int group, boolean checkable,
                boolean exclusive) {
            // TODO Auto-generated method stub
            
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public void setGroupVisible(int group, boolean visible) {
            // TODO Auto-generated method stub
            
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public void setGroupEnabled(int group, boolean enabled) {
            // TODO Auto-generated method stub
            
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public boolean hasVisibleItems() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public MenuItem findItem(int id) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public int size() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public MenuItem getItem(int index) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public void close() {
            // TODO Auto-generated method stub
            
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public
        boolean isShortcutKey(int keyCode, KeyEvent event) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public boolean performIdentifierAction(int id, int flags) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public void setQwertyMode(boolean isQwerty) {
            // TODO Auto-generated method stub
            
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public ContextMenu setHeaderTitle(int titleRes) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public ContextMenu setHeaderTitle(CharSequence title) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public ContextMenu setHeaderIcon(int iconRes) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public ContextMenu setHeaderIcon(Drawable icon) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public ContextMenu setHeaderView(View view) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.ABSTRACT_METHOD)
        public void clearHeader() {
            // TODO Auto-generated method stub
            
        }
        
    }
}
