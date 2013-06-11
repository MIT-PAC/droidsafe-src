package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class FragmentTransaction {
    public static final int TRANSIT_ENTER_MASK = 0x1000;
    public static final int TRANSIT_EXIT_MASK = 0x2000;
    public static final int TRANSIT_UNSET = -1;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_FRAGMENT_OPEN = 1 | TRANSIT_ENTER_MASK;
    public static final int TRANSIT_FRAGMENT_CLOSE = 2 | TRANSIT_EXIT_MASK;
    public static final int TRANSIT_FRAGMENT_FADE = 3 | TRANSIT_ENTER_MASK;
    
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

    
}


