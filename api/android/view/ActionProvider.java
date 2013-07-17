package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;

public abstract class ActionProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.418 -0400", hash_original_field = "1D7EBD76CDEE89061E0336D81ED19A26", hash_generated_field = "B0B6D637F5D44582200E582C4D2D6000")

    private SubUiVisibilityListener mSubUiVisibilityListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.418 -0400", hash_original_method = "AD51B37569819E728EA786F52DA39151", hash_generated_method = "ADC7AE31EFA88C8C25C78BAD2499B1B4")
    public  ActionProvider(Context context) {
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    public abstract View onCreateActionView();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.419 -0400", hash_original_method = "366B075407E0A5F04994070AE9F78DED", hash_generated_method = "FC5221624D4E38ACDEC8FA22133E4607")
    public boolean onPerformDefaultAction() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean var68934A3E9455FA72420237EB05902327_1627406843 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1397858963 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1397858963;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.419 -0400", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "FA591FFE1E16E1E33498947FA14362FB")
    public boolean hasSubMenu() {
        boolean var68934A3E9455FA72420237EB05902327_775738400 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147445543 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147445543;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.419 -0400", hash_original_method = "F59137EC2C0A4379BE18A71AFD20A9D8", hash_generated_method = "9DA1EF53C8D5BEB9087131E3E0114121")
    public void onPrepareSubMenu(SubMenu subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(subMenu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.419 -0400", hash_original_method = "486EC9DD7EB4D66CD412B7154F65545B", hash_generated_method = "4965DF89D75A45720F4555BC74EC6B5D")
    public void subUiVisibilityChanged(boolean isVisible) {
        addTaint(isVisible);
        if(mSubUiVisibilityListener != null)        
        {
            mSubUiVisibilityListener.onSubUiVisibilityChanged(isVisible);
        } //End block
        // ---------- Original Method ----------
        //if (mSubUiVisibilityListener != null) {
            //mSubUiVisibilityListener.onSubUiVisibilityChanged(isVisible);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.419 -0400", hash_original_method = "D36B582FBFECE681E89AD6546A9F8E0B", hash_generated_method = "B1FA1AA5736D11F90BC907F84A60ABD9")
    public void setSubUiVisibilityListener(SubUiVisibilityListener listener) {
        mSubUiVisibilityListener = listener;
        // ---------- Original Method ----------
        //mSubUiVisibilityListener = listener;
    }

    
    public interface SubUiVisibilityListener {
        public void onSubUiVisibilityChanged(boolean isVisible);
    }
    
}

