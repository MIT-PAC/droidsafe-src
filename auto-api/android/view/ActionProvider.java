package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;

public abstract class ActionProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.828 -0400", hash_original_field = "1D7EBD76CDEE89061E0336D81ED19A26", hash_generated_field = "B0B6D637F5D44582200E582C4D2D6000")

    private SubUiVisibilityListener mSubUiVisibilityListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.828 -0400", hash_original_method = "AD51B37569819E728EA786F52DA39151", hash_generated_method = "ADC7AE31EFA88C8C25C78BAD2499B1B4")
    public  ActionProvider(Context context) {
        addTaint(context.getTaint());
        
    }

    
    public abstract View onCreateActionView();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.829 -0400", hash_original_method = "366B075407E0A5F04994070AE9F78DED", hash_generated_method = "4CFF31EF69139F12CE4DD1F81134A843")
    public boolean onPerformDefaultAction() {
        
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_326567797 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_326567797;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.829 -0400", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "865C06D73B73CD0152D89AC0283D0EBC")
    public boolean hasSubMenu() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1437987241 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1437987241;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.829 -0400", hash_original_method = "F59137EC2C0A4379BE18A71AFD20A9D8", hash_generated_method = "9DA1EF53C8D5BEB9087131E3E0114121")
    public void onPrepareSubMenu(SubMenu subMenu) {
        
        addTaint(subMenu.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.830 -0400", hash_original_method = "486EC9DD7EB4D66CD412B7154F65545B", hash_generated_method = "972DCC1B0CA57CC0464475AEC8873372")
    public void subUiVisibilityChanged(boolean isVisible) {
        {
            mSubUiVisibilityListener.onSubUiVisibilityChanged(isVisible);
        } 
        addTaint(isVisible);
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.830 -0400", hash_original_method = "D36B582FBFECE681E89AD6546A9F8E0B", hash_generated_method = "B1FA1AA5736D11F90BC907F84A60ABD9")
    public void setSubUiVisibilityListener(SubUiVisibilityListener listener) {
        mSubUiVisibilityListener = listener;
        
        
    }

    
    public interface SubUiVisibilityListener {
        public void onSubUiVisibilityChanged(boolean isVisible);
    }
    
}

