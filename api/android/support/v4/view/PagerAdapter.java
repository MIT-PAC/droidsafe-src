package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class PagerAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:18.993 -0500", hash_original_field = "1EA0BEAFF9F7078ED69A70F9ED831835", hash_generated_field = "1095B2C860AD558A4F53332EBAEFA10E")

    public static final int POSITION_UNCHANGED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:18.997 -0500", hash_original_field = "34756FE893A708186B4DB42146240D49", hash_generated_field = "A46559075D518D4933C3AFA6B991A88C")

    public static final int POSITION_NONE = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:18.991 -0500", hash_original_field = "5BCAC4B0C0091010077ED48536EE976D", hash_generated_field = "2C795F8AF9A73C2DD35A795A42FEB9E0")

    private DataSetObservable mObservable = new DataSetObservable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.317 -0400", hash_original_method = "FE6E138A162115EAC1384653A4B660CF", hash_generated_method = "FE6E138A162115EAC1384653A4B660CF")
    public PagerAdapter ()
    {
        //Synthesized constructor
    }

    /**
     * Return the number of views available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:18.999 -0500", hash_original_method = "8A22A1FE2F5B57814AD6F31483E8A082", hash_generated_method = "4A7C62328463406AEE3D11A837EF3867")
    
public abstract int getCount();

    /**
     * Called when a change in the shown pages is going to start being made.
     * @param container The containing View which is displaying this adapter's
     * page views.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.001 -0500", hash_original_method = "DCAE5C6F617B7B7CD0D6B0A4179A4B48", hash_generated_method = "B8BC9AC1396C809BA11C5CCA8C517F60")
    
public void startUpdate(ViewGroup container) {
        startUpdate((View) container);
    }

    /**
     * Create the page for the given position.  The adapter is responsible
     * for adding the view to the container given here, although it only
     * must ensure this is done by the time it returns from
     * {@link #finishUpdate(ViewGroup)}.
     *
     * @param container The containing View in which the page will be shown.
     * @param position The page position to be instantiated.
     * @return Returns an Object representing the new page.  This does not
     * need to be a View, but can be some other container of the page.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.003 -0500", hash_original_method = "118A1191E1E4E1B1DC4CA223C52ECD6D", hash_generated_method = "E0A1796F249814B17AEF02BE6A78CC6B")
    
public Object instantiateItem(ViewGroup container, int position) {
        return instantiateItem((View) container, position);
    }

    /**
     * Remove a page for the given position.  The adapter is responsible
     * for removing the view from its container, although it only must ensure
     * this is done by the time it returns from {@link #finishUpdate(ViewGroup)}.
     *
     * @param container The containing View from which the page will be removed.
     * @param position The page position to be removed.
     * @param object The same object that was returned by
     * {@link #instantiateItem(View, int)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.006 -0500", hash_original_method = "81B6B479C89D1904C5A685A128836D6A", hash_generated_method = "F114DE55F7DC7836AF2B5B1FA6EF3009")
    
public void destroyItem(ViewGroup container, int position, Object object) {
        destroyItem((View) container, position, object);
    }

    /**
     * Called to inform the adapter of which item is currently considered to
     * be the "primary", that is the one show to the user as the current page.
     *
     * @param container The containing View from which the page will be removed.
     * @param position The page position that is now the primary.
     * @param object The same object that was returned by
     * {@link #instantiateItem(View, int)}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.008 -0500", hash_original_method = "C728F6B9404F59904D353F9FF4128613", hash_generated_method = "0A9C3454FFC508F4A61064B56139A4CD")
    
public void setPrimaryItem(ViewGroup container, int position, Object object) {
        setPrimaryItem((View) container, position, object);
    }

    /**
     * Called when the a change in the shown pages has been completed.  At this
     * point you must ensure that all of the pages have actually been added or
     * removed from the container as appropriate.
     * @param container The containing View which is displaying this adapter's
     * page views.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.010 -0500", hash_original_method = "D14DC4EE203F14C8F1345C8D2F18FF46", hash_generated_method = "6E7C525ADF3B0D6ABC6003DDAB9CC2E2")
    
public void finishUpdate(ViewGroup container) {
        finishUpdate((View) container);
    }

    /**
     * Called when a change in the shown pages is going to start being made.
     * @param container The containing View which is displaying this adapter's
     * page views.
     *
     * @deprecated Use {@link #startUpdate(ViewGroup)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.012 -0500", hash_original_method = "FA1E5F7C2B2EB1EE6744E074AA1F10AB", hash_generated_method = "A06B43F4CD23E238EE09245FF88DEAA6")
    
public void startUpdate(View container) {
    }

    /**
     * Create the page for the given position.  The adapter is responsible
     * for adding the view to the container given here, although it only
     * must ensure this is done by the time it returns from
     * {@link #finishUpdate(ViewGroup)}.
     *
     * @param container The containing View in which the page will be shown.
     * @param position The page position to be instantiated.
     * @return Returns an Object representing the new page.  This does not
     * need to be a View, but can be some other container of the page.
     *
     * @deprecated Use {@link #instantiateItem(ViewGroup, int)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.014 -0500", hash_original_method = "30C4B19C489FA29440838961A72E4BC8", hash_generated_method = "2586F89636F81C98715925A123B6DF28")
    
public Object instantiateItem(View container, int position) {
        throw new UnsupportedOperationException(
                "Required method instantiateItem was not overridden");
    }

    /**
     * Remove a page for the given position.  The adapter is responsible
     * for removing the view from its container, although it only must ensure
     * this is done by the time it returns from {@link #finishUpdate(View)}.
     *
     * @param container The containing View from which the page will be removed.
     * @param position The page position to be removed.
     * @param object The same object that was returned by
     * {@link #instantiateItem(View, int)}.
     *
     * @deprecated Use {@link #destroyItem(ViewGroup, int, Object)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.016 -0500", hash_original_method = "0E7A719DFB33F3F65D1661AAD48E8CDE", hash_generated_method = "23A2966650893BDAF2FF72298F5A9B1A")
    
public void destroyItem(View container, int position, Object object) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    /**
     * Called to inform the adapter of which item is currently considered to
     * be the "primary", that is the one show to the user as the current page.
     *
     * @param container The containing View from which the page will be removed.
     * @param position The page position that is now the primary.
     * @param object The same object that was returned by
     * {@link #instantiateItem(View, int)}.
     *
     * @deprecated Use {@link #setPrimaryItem(ViewGroup, int, Object)}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.019 -0500", hash_original_method = "BBAFE0B2C7FC305268C2EE6C04F35275", hash_generated_method = "FE60A5E3D3F273237677B3C0FB3A8DB5")
    
public void setPrimaryItem(View container, int position, Object object) {
    }

    /**
     * Called when the a change in the shown pages has been completed.  At this
     * point you must ensure that all of the pages have actually been added or
     * removed from the container as appropriate.
     * @param container The containing View which is displaying this adapter's
     * page views.
     *
     * @deprecated Use {@link #setPrimaryItem(ViewGroup, int, Object)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.021 -0500", hash_original_method = "140CF544DAB4E9753AD13C5C6F7AF228", hash_generated_method = "308372D6C1DED60A11945E3E60F9BEB7")
    
public void finishUpdate(View container) {
    }

    /**
     * Determines whether a page View is associated with a specific key object
     * as returned by {@link #instantiateItem(ViewGroup, int)}. This method is
     * required for a PagerAdapter to function properly.
     *
     * @param view Page View to check for association with <code>object</code>
     * @param object Object to check for association with <code>view</code>
     * @return true if <code>view</code> is associated with the key object <code>object</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.023 -0500", hash_original_method = "DAA6FA5171544E03AFB8179636AFB377", hash_generated_method = "5C6A67F058B407F9CA962AC1DC62EE22")
    
public abstract boolean isViewFromObject(View view, Object object);

    /**
     * Save any instance state associated with this adapter and its pages that should be
     * restored if the current UI state needs to be reconstructed.
     *
     * @return Saved state for this adapter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.025 -0500", hash_original_method = "9C10790C9B509FF6855ECD7BB4443BBC", hash_generated_method = "91C2053613060471C9409FE37D8C4973")
    
public Parcelable saveState() {
        return null;
    }

    /**
     * Restore any instance state associated with this adapter and its pages
     * that was previously saved by {@link #saveState()}.
     *
     * @param state State previously saved by a call to {@link #saveState()}
     * @param loader A ClassLoader that should be used to instantiate any restored objects
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.027 -0500", hash_original_method = "17638DDA6DE27E971DE60A544D06348C", hash_generated_method = "30D01C6D420DFBDFF4FA00D98C8B4AF6")
    
public void restoreState(Parcelable state, ClassLoader loader) {
    }

    /**
     * Called when the host view is attempting to determine if an item's position
     * has changed. Returns {@link #POSITION_UNCHANGED} if the position of the given
     * item has not changed or {@link #POSITION_NONE} if the item is no longer present
     * in the adapter.
     *
     * <p>The default implementation assumes that items will never
     * change position and always returns {@link #POSITION_UNCHANGED}.
     *
     * @param object Object representing an item, previously returned by a call to
     *               {@link #instantiateItem(View, int)}.
     * @return object's new position index from [0, {@link #getCount()}),
     *         {@link #POSITION_UNCHANGED} if the object's position has not changed,
     *         or {@link #POSITION_NONE} if the item is no longer present.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.029 -0500", hash_original_method = "A005A760A98AF47FB8E2DAD0B5F81664", hash_generated_method = "01A7DA51C41C27400438FC1069B22549")
    
public int getItemPosition(Object object) {
        return POSITION_UNCHANGED;
    }

    /**
     * This method should be called by the application if the data backing this adapter has changed
     * and associated views should update.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.032 -0500", hash_original_method = "8C7965DA0630180F14A7491670F343AF", hash_generated_method = "99C6BC5246F9821C4D87E4D81C75A171")
    
public void notifyDataSetChanged() {
        mObservable.notifyChanged();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.033 -0500", hash_original_method = "F0925616C6F47A4BCFCB9E7C14C25F57", hash_generated_method = "F0925616C6F47A4BCFCB9E7C14C25F57")
    
void registerDataSetObserver(DataSetObserver observer) {
        mObservable.registerObserver(observer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.035 -0500", hash_original_method = "F847CF5B5DF735E7D60F86704B1D73CD", hash_generated_method = "F847CF5B5DF735E7D60F86704B1D73CD")
    
void unregisterDataSetObserver(DataSetObserver observer) {
        mObservable.unregisterObserver(observer);
    }

    /**
     * This method may be called by the ViewPager to obtain a title string
     * to describe the specified page. This method may return null
     * indicating no title for this page. The default implementation returns
     * null.
     *
     * @param position The position of the title requested
     * @return A title for the requested page
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.037 -0500", hash_original_method = "D33F5CC8812E682744289E753AD4C997", hash_generated_method = "479873DFF9A60410744CFFB89F78C5F6")
    
public CharSequence getPageTitle(int position) {
        return null;
    }
}

