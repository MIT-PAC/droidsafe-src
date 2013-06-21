package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;

public abstract class ActionProvider {
    private SubUiVisibilityListener mSubUiVisibilityListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.445 -0400", hash_original_method = "AD51B37569819E728EA786F52DA39151", hash_generated_method = "6FB4C8FACFE057588253CD56B562C842")
    @DSModeled(DSC.SAFE)
    public ActionProvider(Context context) {
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    public abstract View onCreateActionView();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.445 -0400", hash_original_method = "366B075407E0A5F04994070AE9F78DED", hash_generated_method = "36D15F7CEE8F4540B3DD414D6E261156")
    @DSModeled(DSC.SAFE)
    public boolean onPerformDefaultAction() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.445 -0400", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "20C765D3C01C10AF786EFC952B2BCCA5")
    @DSModeled(DSC.SAFE)
    public boolean hasSubMenu() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.445 -0400", hash_original_method = "F59137EC2C0A4379BE18A71AFD20A9D8", hash_generated_method = "1236574EFE720C2FCE027A711EF072A0")
    @DSModeled(DSC.SAFE)
    public void onPrepareSubMenu(SubMenu subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(subMenu.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.446 -0400", hash_original_method = "486EC9DD7EB4D66CD412B7154F65545B", hash_generated_method = "8C3E52E33E539DB2C51DEE38B1D6522D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.446 -0400", hash_original_method = "D36B582FBFECE681E89AD6546A9F8E0B", hash_generated_method = "0DFD797833E27DD1A93C33B3A739B611")
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

