package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class ActionMode {
    private Object mTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.815 -0400", hash_original_method = "256DC994AF5E64F19A2C820A8209C31D", hash_generated_method = "6279C81DAE71B31D2B6F92225A7000F7")
    @DSModeled(DSC.SAFE)
    public void setTag(Object tag) {
        dsTaint.addTaint(tag.dsTaint);
        // ---------- Original Method ----------
        //mTag = tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.815 -0400", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "CE26BE07E2E9DE9DA8CA6A448BC52DBF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.815 -0400", hash_original_method = "57D435E5DB9DAA5D06EB98D67411AC43", hash_generated_method = "EF7139BED4FFD2B337AA25C737678B87")
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


