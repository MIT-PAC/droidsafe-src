package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class ActionMode {
    private Object mTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.442 -0400", hash_original_method = "75ECA2ECA43912AEE073830CE439ED4F", hash_generated_method = "75ECA2ECA43912AEE073830CE439ED4F")
        public ActionMode ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.442 -0400", hash_original_method = "256DC994AF5E64F19A2C820A8209C31D", hash_generated_method = "95CB5A637731743313B223D3C18C4520")
    @DSModeled(DSC.SAFE)
    public void setTag(Object tag) {
        dsTaint.addTaint(tag.dsTaint);
        // ---------- Original Method ----------
        //mTag = tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.443 -0400", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "514DAD39C59AFB9B018F2C29507FB0B5")
    @DSModeled(DSC.SAFE)
    public Object getTag() {
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.444 -0400", hash_original_method = "57D435E5DB9DAA5D06EB98D67411AC43", hash_generated_method = "C0C30F6664C107742CA48E02BCDEF632")
    @DSModeled(DSC.SAFE)
    public boolean isUiFocusable() {
        return dsTaint.getTaintBoolean();
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

