package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class ActionMode {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.515 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "EE550655758D5D3DEE98B11CF176B67D")

    private Object mTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.515 -0400", hash_original_method = "D3C302D61DC5B7843982EAB33028FB58", hash_generated_method = "D3C302D61DC5B7843982EAB33028FB58")
    public ActionMode ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.516 -0400", hash_original_method = "256DC994AF5E64F19A2C820A8209C31D", hash_generated_method = "744E4F063BB0F5116D0A7B37E397A74C")
    public void setTag(Object tag) {
        mTag = tag;
        // ---------- Original Method ----------
        //mTag = tag;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.516 -0400", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "5CA5AC6691BCAE1696499C2244C3616C")
    public Object getTag() {
Object varD6A25044F8E609F6CD67330C1523D33D_294801190 =         mTag;
        varD6A25044F8E609F6CD67330C1523D33D_294801190.addTaint(taint);
        return varD6A25044F8E609F6CD67330C1523D33D_294801190;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.518 -0400", hash_original_method = "57D435E5DB9DAA5D06EB98D67411AC43", hash_generated_method = "729DCC380280E701CCCCB6DA14243985")
    public boolean isUiFocusable() {
        boolean varB326B5062B2F0E69046810717534CB09_672298648 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_472655400 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_472655400;
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

