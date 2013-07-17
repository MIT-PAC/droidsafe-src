package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class ActionMode {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.413 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "EE550655758D5D3DEE98B11CF176B67D")

    private Object mTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.413 -0400", hash_original_method = "D3C302D61DC5B7843982EAB33028FB58", hash_generated_method = "D3C302D61DC5B7843982EAB33028FB58")
    public ActionMode ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.414 -0400", hash_original_method = "256DC994AF5E64F19A2C820A8209C31D", hash_generated_method = "744E4F063BB0F5116D0A7B37E397A74C")
    public void setTag(Object tag) {
        mTag = tag;
        // ---------- Original Method ----------
        //mTag = tag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.414 -0400", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "C709082383A3AA30DE6A1337CB118FD0")
    public Object getTag() {
Object varD6A25044F8E609F6CD67330C1523D33D_2083384432 =         mTag;
        varD6A25044F8E609F6CD67330C1523D33D_2083384432.addTaint(taint);
        return varD6A25044F8E609F6CD67330C1523D33D_2083384432;
        // ---------- Original Method ----------
        //return mTag;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void setTitle(CharSequence title);

    
    @DSModeled(DSC.SAFE)
    public abstract void setTitle(int resId);

    
    @DSModeled(DSC.SAFE)
    public abstract void setSubtitle(CharSequence subtitle);

    
    @DSModeled(DSC.SAFE)
    public abstract void setSubtitle(int resId);

    
    @DSModeled(DSC.SAFE)
    public abstract void setCustomView(View view);

    
    @DSModeled(DSC.SAFE)
    public abstract void invalidate();

    
    @DSModeled(DSC.SAFE)
    public abstract void finish();

    
    @DSModeled(DSC.SAFE)
    public abstract Menu getMenu();

    
    @DSModeled(DSC.SAFE)
    public abstract CharSequence getTitle();

    
    @DSModeled(DSC.SAFE)
    public abstract CharSequence getSubtitle();

    
    @DSModeled(DSC.SAFE)
    public abstract View getCustomView();

    
    @DSModeled(DSC.SAFE)
    public abstract MenuInflater getMenuInflater();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.414 -0400", hash_original_method = "57D435E5DB9DAA5D06EB98D67411AC43", hash_generated_method = "6546395DC165CF5BEA2F074A5C4C79AB")
    public boolean isUiFocusable() {
        boolean varB326B5062B2F0E69046810717534CB09_1618027070 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_471785591 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_471785591;
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

