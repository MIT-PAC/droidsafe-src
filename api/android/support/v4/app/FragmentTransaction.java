package android.support.v4.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class FragmentTransaction {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.034 -0400", hash_original_method = "B5A603083BF658FD0649843C639EBB28", hash_generated_method = "B5A603083BF658FD0649843C639EBB28")
    public FragmentTransaction ()
    {
        
    }


    public abstract FragmentTransaction add(Fragment fragment, String tag);

    
    public abstract FragmentTransaction add(int containerViewId, Fragment fragment);

    
    public abstract FragmentTransaction add(int containerViewId, Fragment fragment, String tag);

    
    public abstract FragmentTransaction replace(int containerViewId, Fragment fragment);

    
    public abstract FragmentTransaction replace(int containerViewId, Fragment fragment, String tag);

    
    public abstract FragmentTransaction remove(Fragment fragment);

    
    public abstract FragmentTransaction hide(Fragment fragment);

    
    public abstract FragmentTransaction show(Fragment fragment);

    
    public abstract FragmentTransaction detach(Fragment fragment);

    
    public abstract FragmentTransaction attach(Fragment fragment);

    
    public abstract boolean isEmpty();

    
    public abstract FragmentTransaction setCustomAnimations(int enter, int exit);

    
    public abstract FragmentTransaction setCustomAnimations(int enter, int exit,
            int popEnter, int popExit);

    
    public abstract FragmentTransaction setTransition(int transit);

    
    public abstract FragmentTransaction setTransitionStyle(int styleRes);

    
    public abstract FragmentTransaction addToBackStack(String name);

    
    public abstract boolean isAddToBackStackAllowed();

    
    public abstract FragmentTransaction disallowAddToBackStack();

    
    public abstract FragmentTransaction setBreadCrumbTitle(int res);

    
    public abstract FragmentTransaction setBreadCrumbTitle(CharSequence text);

    
    public abstract FragmentTransaction setBreadCrumbShortTitle(int res);

    
    public abstract FragmentTransaction setBreadCrumbShortTitle(CharSequence text);

    
    public abstract int commit();

    
    public abstract int commitAllowingStateLoss();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.040 -0400", hash_original_field = "76031B87C5C17E48305AB47AA6EC5934", hash_generated_field = "C9662C300B2D516C85FAB581ACAF2A52")

    public static final int TRANSIT_ENTER_MASK = 0x1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.040 -0400", hash_original_field = "6C637231E64F0FFC8871EE69F8321A66", hash_generated_field = "A72E1F06E1555392D809AEF4A965F352")

    public static final int TRANSIT_EXIT_MASK = 0x2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.040 -0400", hash_original_field = "23C84F31848AE79C099EF811F09E5F49", hash_generated_field = "9ACB817E03C47A72C47C37A2C5683F21")

    public static final int TRANSIT_UNSET = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.040 -0400", hash_original_field = "0598691C6C7EA81B152880ED1F912EC2", hash_generated_field = "EF2961DC6894FA7D7471614F61D3D6BC")

    public static final int TRANSIT_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.040 -0400", hash_original_field = "F7B084872C367AAE68C24F60A82E45FF", hash_generated_field = "C5A33F89EF516834A73A284CE0B078D5")

    public static final int TRANSIT_FRAGMENT_OPEN = 1 | TRANSIT_ENTER_MASK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.040 -0400", hash_original_field = "2DEFF67E3926C52F4DA526B44C616C26", hash_generated_field = "455513A4D43A55D718ACC2308400FB55")

    public static final int TRANSIT_FRAGMENT_CLOSE = 2 | TRANSIT_EXIT_MASK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.040 -0400", hash_original_field = "981769013AEEB1C127BB71CAB4735594", hash_generated_field = "868E6BD30F40AB0A52D8F001A899D46B")

    public static final int TRANSIT_FRAGMENT_FADE = 3 | TRANSIT_ENTER_MASK;
}

