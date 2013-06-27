package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class ActionMode {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.705 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "EE550655758D5D3DEE98B11CF176B67D")

    private Object mTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.705 -0400", hash_original_method = "D3C302D61DC5B7843982EAB33028FB58", hash_generated_method = "D3C302D61DC5B7843982EAB33028FB58")
    public ActionMode ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.705 -0400", hash_original_method = "256DC994AF5E64F19A2C820A8209C31D", hash_generated_method = "744E4F063BB0F5116D0A7B37E397A74C")
    public void setTag(Object tag) {
        mTag = tag;
        // ---------- Original Method ----------
        //mTag = tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.707 -0400", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "DC24036B5CC5F2E022A2F0407B6E9CD8")
    public Object getTag() {
        Object varB4EAC82CA7396A68D541C85D26508E83_475806134 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_475806134 = mTag;
        varB4EAC82CA7396A68D541C85D26508E83_475806134.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_475806134;
        // ---------- Original Method ----------
        //return mTag;
    }

    
    public abstract void setTitle(CharSequence title);

    
    public abstract void setTitle(int resId);

    
    public abstract void setSubtitle(CharSequence subtitle);

    
    public abstract void setSubtitle(int resId);

    
    public abstract void setCustomView(View view);

    
    public abstract void invalidate();

    
    public abstract void finish();

    
    public abstract Menu getMenu();

    
    public abstract CharSequence getTitle();

    
    public abstract CharSequence getSubtitle();

    
    public abstract View getCustomView();

    
    public abstract MenuInflater getMenuInflater();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.724 -0400", hash_original_method = "57D435E5DB9DAA5D06EB98D67411AC43", hash_generated_method = "9D9ACAF39934BC4B26D8614F5DFD7822")
    public boolean isUiFocusable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1998817247 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1998817247;
        // ---------- Original Method ----------
        //return true;
    }

    
    public interface Callback {
        
        public boolean onCreateActionMode(ActionMode mode, Menu menu);

        
        public boolean onPrepareActionMode(ActionMode mode, Menu menu);

        
        public boolean onActionItemClicked(ActionMode mode, MenuItem item);

        
        public void onDestroyActionMode(ActionMode mode);
    }
    
}

