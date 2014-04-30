package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class FragmentTransaction {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.786 -0500", hash_original_field = "8A2784D472F1E9570825A12575F2B43C", hash_generated_field = "C9662C300B2D516C85FAB581ACAF2A52")

    public static final int TRANSIT_ENTER_MASK = 0x1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.788 -0500", hash_original_field = "A5C220F80B763BF432128B1C92AAF10F", hash_generated_field = "A72E1F06E1555392D809AEF4A965F352")

    public static final int TRANSIT_EXIT_MASK = 0x2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.791 -0500", hash_original_field = "492A5D78F58C28B447FA6AFDF1110BF8", hash_generated_field = "9ACB817E03C47A72C47C37A2C5683F21")

    public static final int TRANSIT_UNSET = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.793 -0500", hash_original_field = "436387360F0AE66EC271E6340B135543", hash_generated_field = "EF2961DC6894FA7D7471614F61D3D6BC")

    public static final int TRANSIT_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.796 -0500", hash_original_field = "57CA1D7C3F06C4CB825FB2E5426D8868", hash_generated_field = "C5A33F89EF516834A73A284CE0B078D5")

    public static final int TRANSIT_FRAGMENT_OPEN = 1 | TRANSIT_ENTER_MASK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.798 -0500", hash_original_field = "F33D55CE525BCB83F4E4BA93F5050E7F", hash_generated_field = "455513A4D43A55D718ACC2308400FB55")

    public static final int TRANSIT_FRAGMENT_CLOSE = 2 | TRANSIT_EXIT_MASK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.801 -0500", hash_original_field = "AB7FD08F59F9423168AFA522A08C660D", hash_generated_field = "868E6BD30F40AB0A52D8F001A899D46B")

    public static final int TRANSIT_FRAGMENT_FADE = 3 | TRANSIT_ENTER_MASK;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.715 -0400", hash_original_method = "B5A603083BF658FD0649843C639EBB28", hash_generated_method = "B5A603083BF658FD0649843C639EBB28")
    public FragmentTransaction ()
    {
        //Synthesized constructor
    }
    /**
     * Calls {@link #add(int, Fragment, String)} with a 0 containerViewId.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.761 -0500", hash_original_method = "F7AC4CA1DFDC81755F39F5A0D9A684FC", hash_generated_method = "70C2E79CF010D20F8CA2B3D5F7F2F820")
    
public abstract FragmentTransaction add(Fragment fragment, String tag);
    
    /**
     * Calls {@link #add(int, Fragment, String)} with a null tag.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.763 -0500", hash_original_method = "CE157581551FA29527EBF8BD8B8E7951", hash_generated_method = "9AE875A561816D375662C13376216FDD")
    
public abstract FragmentTransaction add(int containerViewId, Fragment fragment);
    
    /**
     * Add a fragment to the activity state.  This fragment may optionally
     * also have its view (if {@link Fragment#onCreateView Fragment.onCreateView}
     * returns non-null) into a container view of the activity.
     * 
     * @param containerViewId Optional identifier of the container this fragment is
     * to be placed in.  If 0, it will not be placed in a container.
     * @param fragment The fragment to be added.  This fragment must not already
     * be added to the activity.
     * @param tag Optional tag name for the fragment, to later retrieve the
     * fragment with {@link FragmentManager#findFragmentByTag(String)
     * FragmentManager.findFragmentByTag(String)}.
     * 
     * @return Returns the same FragmentTransaction instance.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.765 -0500", hash_original_method = "23C69331AB94570E0A0B731AF3EDB6F3", hash_generated_method = "C6D7859F8D62F0F6C91C14EC3A92087B")
    
public abstract FragmentTransaction add(int containerViewId, Fragment fragment, String tag);
    
    /**
     * Calls {@link #replace(int, Fragment, String)} with a null tag.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.769 -0500", hash_original_method = "03B4950089589D9E0AB79E68A4AC43E6", hash_generated_method = "006E5DD8C30E5A7FE8604C621FE6E525")
    
public abstract FragmentTransaction replace(int containerViewId, Fragment fragment);
    
    /**
     * Replace an existing fragment that was added to a container.  This is
     * essentially the same as calling {@link #remove(Fragment)} for all
     * currently added fragments that were added with the same containerViewId
     * and then {@link #add(int, Fragment, String)} with the same arguments
     * given here.
     * 
     * @param containerViewId Identifier of the container whose fragment(s) are
     * to be replaced.
     * @param fragment The new fragment to place in the container.
     * @param tag Optional tag name for the fragment, to later retrieve the
     * fragment with {@link FragmentManager#findFragmentByTag(String)
     * FragmentManager.findFragmentByTag(String)}.
     * 
     * @return Returns the same FragmentTransaction instance.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.771 -0500", hash_original_method = "96430312571D18C6A7B66F51BC354307", hash_generated_method = "26B413B0DEDE46B14833E57BDC191D77")
    
public abstract FragmentTransaction replace(int containerViewId, Fragment fragment, String tag);
    
    /**
     * Remove an existing fragment.  If it was added to a container, its view
     * is also removed from that container.
     * 
     * @param fragment The fragment to be removed.
     * 
     * @return Returns the same FragmentTransaction instance.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.773 -0500", hash_original_method = "254F73E9B1E6669A2F02CC36D0752913", hash_generated_method = "7F25DE9881546538B6AAFCFFB188C78C")
    
public abstract FragmentTransaction remove(Fragment fragment);
    
    /**
     * Hides an existing fragment.  This is only relevant for fragments whose
     * views have been added to a container, as this will cause the view to
     * be hidden.
     * 
     * @param fragment The fragment to be hidden.
     * 
     * @return Returns the same FragmentTransaction instance.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.775 -0500", hash_original_method = "D9A1A494923A64A50C6BFA335CCDA649", hash_generated_method = "18F7A4DA41D4975E1AC50E51EA5FA2E6")
    
public abstract FragmentTransaction hide(Fragment fragment);
    
    /**
     * Shows a previously hidden fragment.  This is only relevant for fragments whose
     * views have been added to a container, as this will cause the view to
     * be shown.
     * 
     * @param fragment The fragment to be shown.
     * 
     * @return Returns the same FragmentTransaction instance.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.778 -0500", hash_original_method = "1B736F30D2D091359A20CA07A0397677", hash_generated_method = "21DC04444CD6877791DE1B06D923AF42")
    
public abstract FragmentTransaction show(Fragment fragment);

    /**
     * Detach the given fragment from the UI.  This is the same state as
     * when it is put on the back stack: the fragment is removed from
     * the UI, however its state is still being actively managed by the
     * fragment manager.  When going into this state its view hierarchy
     * is destroyed.
     *
     * @param fragment The fragment to be detached.
     *
     * @return Returns the same FragmentTransaction instance.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.780 -0500", hash_original_method = "1CDB7BE0A739957C26CB1A4DAEA0A3C8", hash_generated_method = "C732A98003F16B452F40FD8EF863BA48")
    
public abstract FragmentTransaction detach(Fragment fragment);

    /**
     * Re-attach a fragment after it had previously been deatched from
     * the UI with {@link #detach(Fragment)}.  This
     * causes its view hierarchy to be re-created, attached to the UI,
     * and displayed.
     *
     * @param fragment The fragment to be attached.
     *
     * @return Returns the same FragmentTransaction instance.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.782 -0500", hash_original_method = "D0BA812C953A880D97F8C9ED57649F69", hash_generated_method = "F46E264924C9175DF0004364A9369E77")
    
public abstract FragmentTransaction attach(Fragment fragment);

    /**
     * @return <code>true</code> if this transaction contains no operations,
     * <code>false</code> otherwise.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.784 -0500", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "047840219A293BF58358C9060BC573A9")
    
public abstract boolean isEmpty();

    /**
     * Set specific animation resources to run for the fragments that are
     * entering and exiting in this transaction. These animations will not be
     * played when popping the back stack.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.803 -0500", hash_original_method = "9DEA3DD7BB557217F1712873E38EE08C", hash_generated_method = "50258C7B6BC5885531B6A648A6430141")
    
public abstract FragmentTransaction setCustomAnimations(int enter, int exit);

    /**
     * Set specific animation resources to run for the fragments that are
     * entering and exiting in this transaction. The <code>popEnter</code>
     * and <code>popExit</code> animations will be played for enter/exit
     * operations specifically when popping the back stack.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.805 -0500", hash_original_method = "7098495B285EEAD1AD79B57FAFCB0E9C", hash_generated_method = "7E00E67177C66E7F7F73331CDF47161C")
    
public abstract FragmentTransaction setCustomAnimations(int enter, int exit,
            int popEnter, int popExit);

    /**
     * Select a standard transition animation for this transaction.  May be
     * one of {@link #TRANSIT_NONE}, {@link #TRANSIT_FRAGMENT_OPEN},
     * or {@link #TRANSIT_FRAGMENT_CLOSE}
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.807 -0500", hash_original_method = "B1D0AA5F3FD228E001A40F7C0CE4FEAF", hash_generated_method = "B9E7C3BA8E42737BB5535E0674C41C9A")
    
public abstract FragmentTransaction setTransition(int transit);

    /**
     * Set a custom style resource that will be used for resolving transit
     * animations.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.809 -0500", hash_original_method = "E8471AF09DD1E972EB26F1A241243710", hash_generated_method = "1F8D810DE83FF35EED51904A960D7FEB")
    
public abstract FragmentTransaction setTransitionStyle(int styleRes);
    
    /**
     * Add this transaction to the back stack.  This means that the transaction
     * will be remembered after it is committed, and will reverse its operation
     * when later popped off the stack.
     *
     * @param name An optional name for this back stack state, or null.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.812 -0500", hash_original_method = "DEFABA50676F268B571842053FA4D98C", hash_generated_method = "8C03DA7BE9F89E5E514D871DDCD371E8")
    
public abstract FragmentTransaction addToBackStack(String name);

    /**
     * Returns true if this FragmentTransaction is allowed to be added to the back
     * stack. If this method would return false, {@link #addToBackStack(String)}
     * will throw {@link IllegalStateException}.
     *
     * @return True if {@link #addToBackStack(String)} is permitted on this transaction.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.814 -0500", hash_original_method = "53804D00C00328AC8F68B0358E12F9F7", hash_generated_method = "EB13167B6B46177C6527BE8E9E976E54")
    
public abstract boolean isAddToBackStackAllowed();

    /**
     * Disallow calls to {@link #addToBackStack(String)}. Any future calls to
     * addToBackStack will throw {@link IllegalStateException}. If addToBackStack
     * has already been called, this method will throw IllegalStateException.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.817 -0500", hash_original_method = "719557C73F8AF07FEFCC2B2CA736E2AA", hash_generated_method = "296D755E0BE5EAA9947D8C03A995B386")
    
public abstract FragmentTransaction disallowAddToBackStack();

    /**
     * Set the full title to show as a bread crumb when this transaction
     * is on the back stack, as used by {@link FragmentBreadCrumbs}.
     *
     * @param res A string resource containing the title.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.819 -0500", hash_original_method = "674D6D1C9A64DC3169B8D3398D9638E7", hash_generated_method = "39C7B75C78A446D289D360C28C87AF2A")
    
public abstract FragmentTransaction setBreadCrumbTitle(int res);

    /**
     * Like {@link #setBreadCrumbTitle(int)} but taking a raw string; this
     * method is <em>not</em> recommended, as the string can not be changed
     * later if the locale changes.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.821 -0500", hash_original_method = "513BC46EF990B8DC74F9A0DE916B0779", hash_generated_method = "C41B1BE928191E88C4AAE28BF2078C45")
    
public abstract FragmentTransaction setBreadCrumbTitle(CharSequence text);

    /**
     * Set the short title to show as a bread crumb when this transaction
     * is on the back stack, as used by {@link FragmentBreadCrumbs}.
     *
     * @param res A string resource containing the title.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.824 -0500", hash_original_method = "04B34F637435B11B7423749B9CAB6A2C", hash_generated_method = "06FC84FF1AAB05DE976BB534400F7446")
    
public abstract FragmentTransaction setBreadCrumbShortTitle(int res);

    /**
     * Like {@link #setBreadCrumbShortTitle(int)} but taking a raw string; this
     * method is <em>not</em> recommended, as the string can not be changed
     * later if the locale changes.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.826 -0500", hash_original_method = "EC96380007AC4B7358B4F7ACCEC3ECA0", hash_generated_method = "1EF3664ADF9DB2DA264168A86B33C365")
    
public abstract FragmentTransaction setBreadCrumbShortTitle(CharSequence text);

    /**
     * Schedules a commit of this transaction.  The commit does
     * not happen immediately; it will be scheduled as work on the main thread
     * to be done the next time that thread is ready.
     *
     * <p class="note">A transaction can only be committed with this method
     * prior to its containing activity saving its state.  If the commit is
     * attempted after that point, an exception will be thrown.  This is
     * because the state after the commit can be lost if the activity needs to
     * be restored from its state.  See {@link #commitAllowingStateLoss()} for
     * situations where it may be okay to lose the commit.</p>
     * 
     * @return Returns the identifier of this transaction's back stack entry,
     * if {@link #addToBackStack(String)} had been called.  Otherwise, returns
     * a negative number.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.828 -0500", hash_original_method = "F74CF41C2E077D1DE3C217B0A3E8C495", hash_generated_method = "7E7995E558FCB03CB4321E10147E3CDF")
    
public abstract int commit();

    /**
     * Like {@link #commit} but allows the commit to be executed after an
     * activity's state is saved.  This is dangerous because the commit can
     * be lost if the activity needs to later be restored from its state, so
     * this should only be used for cases where it is okay for the UI state
     * to change unexpectedly on the user.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:34.830 -0500", hash_original_method = "41F66AB3A45C3BC381255DEDB6DBA940", hash_generated_method = "3B5A72423F8BE1FE8EBE8871B3036BB6")
    
public abstract int commitAllowingStateLoss();
}

