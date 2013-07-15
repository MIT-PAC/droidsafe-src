package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

class NoSaveStateFrameLayout extends FrameLayout {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.213 -0400", hash_original_method = "3889CE5B7CA4679ACCB4D7B5EA6FB087", hash_generated_method = "D83F9BEABB74D6FEF2671DFB68B81652")
    public  NoSaveStateFrameLayout(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
    static ViewGroup wrap(View child) {
        NoSaveStateFrameLayout wrapper = new NoSaveStateFrameLayout(child.getContext());
        ViewGroup.LayoutParams childParams = child.getLayoutParams();
        if (childParams != null) {
            wrapper.setLayoutParams(childParams);
        }
        NoSaveStateFrameLayout.LayoutParams lp = new NoSaveStateFrameLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        child.setLayoutParams(lp);
        wrapper.addView(child);
        return wrapper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.213 -0400", hash_original_method = "0F3E63187E008FDE1692E75AF7E8484F", hash_generated_method = "DCFE5437586B2B72B2033C20A5FC2846")
    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        addTaint(container.getTaint());
        dispatchFreezeSelfOnly(container);
        // ---------- Original Method ----------
        //dispatchFreezeSelfOnly(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.214 -0400", hash_original_method = "3B9D7DC916535DA1F64238687579C1A4", hash_generated_method = "049C55C9929D94261AAC15AFD146322A")
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        addTaint(container.getTaint());
        dispatchThawSelfOnly(container);
        // ---------- Original Method ----------
        //dispatchThawSelfOnly(container);
    }

    
}

