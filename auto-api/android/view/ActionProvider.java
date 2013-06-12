package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;

public abstract class ActionProvider {
    private SubUiVisibilityListener mSubUiVisibilityListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.816 -0400", hash_original_method = "AD51B37569819E728EA786F52DA39151", hash_generated_method = "45026BCF8DC39012C231C357FFEFB7F7")
    @DSModeled(DSC.SAFE)
    public ActionProvider(Context context) {
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    public abstract View onCreateActionView();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.816 -0400", hash_original_method = "366B075407E0A5F04994070AE9F78DED", hash_generated_method = "F430CDF3DA60102D61ED387DB2D16C0A")
    @DSModeled(DSC.SAFE)
    public boolean onPerformDefaultAction() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.816 -0400", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "1E6C2AA5B9FBCD80A65C77C0B0D662F6")
    @DSModeled(DSC.SAFE)
    public boolean hasSubMenu() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.816 -0400", hash_original_method = "F59137EC2C0A4379BE18A71AFD20A9D8", hash_generated_method = "0B2ECDE24BB3BC268472B315DB05DB3F")
    @DSModeled(DSC.SAFE)
    public void onPrepareSubMenu(SubMenu subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(subMenu.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.816 -0400", hash_original_method = "486EC9DD7EB4D66CD412B7154F65545B", hash_generated_method = "3A2C67DDE558C47B422E14983C2E5B10")
    @DSModeled(DSC.SAFE)
    public void subUiVisibilityChanged(boolean isVisible) {
        dsTaint.addTaint(isVisible);
        {
            mSubUiVisibilityListener.onSubUiVisibilityChanged(isVisible);
        } //End block
        // ---------- Original Method ----------
        //if (mSubUiVisibilityListener != null) {
            //mSubUiVisibilityListener.onSubUiVisibilityChanged(isVisible);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.816 -0400", hash_original_method = "D36B582FBFECE681E89AD6546A9F8E0B", hash_generated_method = "E1EEB31B5EC54C8A901907DBA99FF39C")
    @DSModeled(DSC.SAFE)
    public void setSubUiVisibilityListener(SubUiVisibilityListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mSubUiVisibilityListener = listener;
    }

    
    public interface SubUiVisibilityListener {
        public void onSubUiVisibilityChanged(boolean isVisible);
    }
    
}


