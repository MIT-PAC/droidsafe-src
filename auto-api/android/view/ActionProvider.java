package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;

public abstract class ActionProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.712 -0400", hash_original_field = "1D7EBD76CDEE89061E0336D81ED19A26", hash_generated_field = "B0B6D637F5D44582200E582C4D2D6000")

    private SubUiVisibilityListener mSubUiVisibilityListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.713 -0400", hash_original_method = "AD51B37569819E728EA786F52DA39151", hash_generated_method = "ADC7AE31EFA88C8C25C78BAD2499B1B4")
    public  ActionProvider(Context context) {
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    public abstract View onCreateActionView();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.714 -0400", hash_original_method = "366B075407E0A5F04994070AE9F78DED", hash_generated_method = "38A945B62C667CAA45D2263EB532960B")
    public boolean onPerformDefaultAction() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1252628930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1252628930;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.714 -0400", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "3DC303B04337F864E306186E7212FEA6")
    public boolean hasSubMenu() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_714053811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_714053811;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.714 -0400", hash_original_method = "F59137EC2C0A4379BE18A71AFD20A9D8", hash_generated_method = "9DA1EF53C8D5BEB9087131E3E0114121")
    public void onPrepareSubMenu(SubMenu subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(subMenu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.715 -0400", hash_original_method = "486EC9DD7EB4D66CD412B7154F65545B", hash_generated_method = "972DCC1B0CA57CC0464475AEC8873372")
    public void subUiVisibilityChanged(boolean isVisible) {
        {
            mSubUiVisibilityListener.onSubUiVisibilityChanged(isVisible);
        } //End block
        addTaint(isVisible);
        // ---------- Original Method ----------
        //if (mSubUiVisibilityListener != null) {
            //mSubUiVisibilityListener.onSubUiVisibilityChanged(isVisible);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.715 -0400", hash_original_method = "D36B582FBFECE681E89AD6546A9F8E0B", hash_generated_method = "B1FA1AA5736D11F90BC907F84A60ABD9")
    public void setSubUiVisibilityListener(SubUiVisibilityListener listener) {
        mSubUiVisibilityListener = listener;
        // ---------- Original Method ----------
        //mSubUiVisibilityListener = listener;
    }

    
    public interface SubUiVisibilityListener {
        public void onSubUiVisibilityChanged(boolean isVisible);
    }
    
}

