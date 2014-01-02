package android.support.v4.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;




class NoSaveStateFrameLayout extends FrameLayout {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:37.041 -0500", hash_original_method = "45D681996876077CE8F6D1AB53B953F4", hash_generated_method = "BDD516827EA173934CE50CA60ABABD79")
    
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:37.045 -0500", hash_original_method = "3889CE5B7CA4679ACCB4D7B5EA6FB087", hash_generated_method = "DF955BECD4F08BC950719D74FE4A3E8B")
    
public NoSaveStateFrameLayout(Context context) {
        super(context);
    }
    
    /**
     * Override to prevent freezing of any child views.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:37.047 -0500", hash_original_method = "0F3E63187E008FDE1692E75AF7E8484F", hash_generated_method = "1BDE1F94F0E2664277F773022732A7F6")
    
@Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    /**
     * Override to prevent thawing of any child views.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:37.049 -0500", hash_original_method = "3B9D7DC916535DA1F64238687579C1A4", hash_generated_method = "C22EB0BEA05DE70A2CBD1DE4B70D044B")
    
@Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    
}

