package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;

public abstract class ActionProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.524 -0400", hash_original_field = "1D7EBD76CDEE89061E0336D81ED19A26", hash_generated_field = "B0B6D637F5D44582200E582C4D2D6000")

    private SubUiVisibilityListener mSubUiVisibilityListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.524 -0400", hash_original_method = "AD51B37569819E728EA786F52DA39151", hash_generated_method = "ADC7AE31EFA88C8C25C78BAD2499B1B4")
    public  ActionProvider(Context context) {
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    public abstract View onCreateActionView();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.525 -0400", hash_original_method = "366B075407E0A5F04994070AE9F78DED", hash_generated_method = "0B7F6CE153D0265F6FF86C99F8775CA0")
    public boolean onPerformDefaultAction() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean var68934A3E9455FA72420237EB05902327_615143940 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2067455194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2067455194;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.525 -0400", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "02513533376B071608CC094B3AE8411C")
    public boolean hasSubMenu() {
        boolean var68934A3E9455FA72420237EB05902327_1138493322 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_34482301 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_34482301;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.525 -0400", hash_original_method = "F59137EC2C0A4379BE18A71AFD20A9D8", hash_generated_method = "9DA1EF53C8D5BEB9087131E3E0114121")
    public void onPrepareSubMenu(SubMenu subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(subMenu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.526 -0400", hash_original_method = "486EC9DD7EB4D66CD412B7154F65545B", hash_generated_method = "4965DF89D75A45720F4555BC74EC6B5D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.526 -0400", hash_original_method = "D36B582FBFECE681E89AD6546A9F8E0B", hash_generated_method = "B1FA1AA5736D11F90BC907F84A60ABD9")
    public void setSubUiVisibilityListener(SubUiVisibilityListener listener) {
        mSubUiVisibilityListener = listener;
        // ---------- Original Method ----------
        //mSubUiVisibilityListener = listener;
    }

    
    public interface SubUiVisibilityListener {
        public void onSubUiVisibilityChanged(boolean isVisible);
    }
    
}

