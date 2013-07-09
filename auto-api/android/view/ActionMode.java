package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class ActionMode {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.821 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "EE550655758D5D3DEE98B11CF176B67D")

    private Object mTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.821 -0400", hash_original_method = "D3C302D61DC5B7843982EAB33028FB58", hash_generated_method = "D3C302D61DC5B7843982EAB33028FB58")
    public ActionMode ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.822 -0400", hash_original_method = "256DC994AF5E64F19A2C820A8209C31D", hash_generated_method = "744E4F063BB0F5116D0A7B37E397A74C")
    public void setTag(Object tag) {
        mTag = tag;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.822 -0400", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "59867257D53E6D32AD48D3B15800DDCF")
    public Object getTag() {
        Object varB4EAC82CA7396A68D541C85D26508E83_573798272 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_573798272 = mTag;
        varB4EAC82CA7396A68D541C85D26508E83_573798272.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_573798272;
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.824 -0400", hash_original_method = "57D435E5DB9DAA5D06EB98D67411AC43", hash_generated_method = "6D7798C71C07DE2B4AFDC1A861B4C09C")
    public boolean isUiFocusable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1371759618 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1371759618;
        
        
    }

    
    public interface Callback {
        
        public boolean onCreateActionMode(ActionMode mode, Menu menu);

        
        public boolean onPrepareActionMode(ActionMode mode, Menu menu);

        
        public boolean onActionItemClicked(ActionMode mode, MenuItem item);

        
        public void onDestroyActionMode(ActionMode mode);
    }
    
}

