/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/**
 * Base class providing the adapter to populate pages inside of
 * a {@link ViewPager}.  You will most likely want to use a more
 * specific implementation of this, such as
 * {@link android.support.v4.app.FragmentPagerAdapter} or
 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
 *
 * <p>When you implement a PagerAdapter, you must override the following methods
 * at minimum:</p>
 * <ul>
 * <li>{@link #instantiateItem(ViewGroup, int)}</li>
 * <li>{@link #destroyItem(ViewGroup, int, Object)}</li>
 * <li>{@link #getCount()}</li>
 * <li>{@link #isViewFromObject(View, Object)}</li>
 * </ul>
 *
 * <p>PagerAdapter is more general than the adapters used for
 * {@link android.widget.AdapterView AdapterViews}. Instead of providing a
 * View recycling mechanism directly ViewPager uses callbacks to indicate the
 * steps taken during an update. A PagerAdapter may implement a form of View
 * recycling if desired or use a more sophisticated method of managing page
 * Views such as Fragment transactions where each page is represented by its
 * own Fragment.</p>
 *
 * <p>ViewPager associates each page with a key Object instead of working with
 * Views directly. This key is used to track and uniquely identify a given page
 * independent of its position in the adapter. A call to the PagerAdapter method
 * {@link #startUpdate(ViewGroup)} indicates that the contents of the ViewPager
 * are about to change. One or more calls to {@link #instantiateItem(ViewGroup, int)}
 * and/or {@link #destroyItem(ViewGroup, int, Object)} will follow, and the end
 * of an update will be signaled by a call to {@link #finishUpdate(ViewGroup)}.
 * By the time {@link #finishUpdate(ViewGroup) finishUpdate} returns the views
 * associated with the key objects returned by
 * {@link #instantiateItem(ViewGroup, int) instantiateItem} should be added to
 * the parent ViewGroup passed to these methods and the views associated with
 * the keys passed to {@link #destroyItem(ViewGroup, int, Object) destroyItem}
 * should be removed. The method {@link #isViewFromObject(View, Object)} identifies
 * whether a page View is associated with a given key object.</p>
 *
 * <p>A very simple PagerAdapter may choose to use the page Views themselves
 * as key objects, returning them from {@link #instantiateItem(ViewGroup, int)}
 * after creation and adding them to the parent ViewGroup. A matching
 * {@link #destroyItem(ViewGroup, int, Object)} implementation would remove the
 * View from the parent ViewGroup and {@link #isViewFromObject(View, Object)}
 * could be implemented as <code>return view == object;</code>.</p>
 *
 * <p>PagerAdapter supports data set changes. Data set changes must occur on the
 * main thread and must end with a call to {@link #notifyDataSetChanged()} similar
 * to AdapterView adapters derived from {@link android.widget.BaseAdapter}. A data
 * set change may involve pages being added, removed, or changing position. The
 * ViewPager will keep the current page active provided the adapter implements
 * the method {@link #getItemPosition(Object)}.</p>
 */
public abstract class PagerAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.667 -0400", hash_original_field = "1EA0BEAFF9F7078ED69A70F9ED831835", hash_generated_field = "1095B2C860AD558A4F53332EBAEFA10E")

    public static final int POSITION_UNCHANGED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.671 -0400", hash_original_field = "34756FE893A708186B4DB42146240D49", hash_generated_field = "A46559075D518D4933C3AFA6B991A88C")

    public static final int POSITION_NONE = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.663 -0400", hash_original_field = "5BCAC4B0C0091010077ED48536EE976D", hash_generated_field = "2C795F8AF9A73C2DD35A795A42FEB9E0")

    private DataSetObservable mObservable = new DataSetObservable();

    /**
     * Return the number of views available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.674 -0400", hash_original_method = "8A22A1FE2F5B57814AD6F31483E8A082", hash_generated_method = "4A7C62328463406AEE3D11A837EF3867")
    
public abstract int getCount();

    /**
     * Called when a change in the shown pages is going to start being made.
     * @param container The containing View which is displaying this adapter's
     * page views.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.678 -0400", hash_original_method = "DCAE5C6F617B7B7CD0D6B0A4179A4B48", hash_generated_method = "B8BC9AC1396C809BA11C5CCA8C517F60")
    
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.682 -0400", hash_original_method = "118A1191E1E4E1B1DC4CA223C52ECD6D", hash_generated_method = "E0A1796F249814B17AEF02BE6A78CC6B")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.685 -0400", hash_original_method = "81B6B479C89D1904C5A685A128836D6A", hash_generated_method = "F114DE55F7DC7836AF2B5B1FA6EF3009")
    
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.690 -0400", hash_original_method = "C728F6B9404F59904D353F9FF4128613", hash_generated_method = "0A9C3454FFC508F4A61064B56139A4CD")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.693 -0400", hash_original_method = "D14DC4EE203F14C8F1345C8D2F18FF46", hash_generated_method = "6E7C525ADF3B0D6ABC6003DDAB9CC2E2")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.697 -0400", hash_original_method = "FA1E5F7C2B2EB1EE6744E074AA1F10AB", hash_generated_method = "A06B43F4CD23E238EE09245FF88DEAA6")
    
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.701 -0400", hash_original_method = "30C4B19C489FA29440838961A72E4BC8", hash_generated_method = "2586F89636F81C98715925A123B6DF28")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.706 -0400", hash_original_method = "0E7A719DFB33F3F65D1661AAD48E8CDE", hash_generated_method = "23A2966650893BDAF2FF72298F5A9B1A")
    
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.709 -0400", hash_original_method = "BBAFE0B2C7FC305268C2EE6C04F35275", hash_generated_method = "FE60A5E3D3F273237677B3C0FB3A8DB5")
    
public void setPrimaryItem(View container, int position, Object object) {
    }

    /**
     * Called when the a change in the shown pages has been completed.  At this
     * point you must ensure that all of the pages have actually been added or
     * removed from the container as appropriate.
     * @param container The containing View which is displaying this adapter's
     * page views.
     *
     * @deprecated Use {@link #finishUpdate(ViewGroup)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.713 -0400", hash_original_method = "140CF544DAB4E9753AD13C5C6F7AF228", hash_generated_method = "308372D6C1DED60A11945E3E60F9BEB7")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.717 -0400", hash_original_method = "DAA6FA5171544E03AFB8179636AFB377", hash_generated_method = "5C6A67F058B407F9CA962AC1DC62EE22")
    
public abstract boolean isViewFromObject(View view, Object object);

    /**
     * Save any instance state associated with this adapter and its pages that should be
     * restored if the current UI state needs to be reconstructed.
     *
     * @return Saved state for this adapter
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.720 -0400", hash_original_method = "9C10790C9B509FF6855ECD7BB4443BBC", hash_generated_method = "91C2053613060471C9409FE37D8C4973")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.724 -0400", hash_original_method = "17638DDA6DE27E971DE60A544D06348C", hash_generated_method = "30D01C6D420DFBDFF4FA00D98C8B4AF6")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.727 -0400", hash_original_method = "A005A760A98AF47FB8E2DAD0B5F81664", hash_generated_method = "01A7DA51C41C27400438FC1069B22549")
    
public int getItemPosition(Object object) {
        return POSITION_UNCHANGED;
    }

    /**
     * This method should be called by the application if the data backing this adapter has changed
     * and associated views should update.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.730 -0400", hash_original_method = "8C7965DA0630180F14A7491670F343AF", hash_generated_method = "99C6BC5246F9821C4D87E4D81C75A171")
    
public void notifyDataSetChanged() {
        mObservable.notifyChanged();
    }

    /**
     * Register an observer to receive callbacks related to the adapter's data changing.
     *
     * @param observer The {@link android.database.DataSetObserver} which will receive callbacks.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.734 -0400", hash_original_method = "F0925616C6F47A4BCFCB9E7C14C25F57", hash_generated_method = "ED53D07D14C010A3795D1986C4E94E69")
    
public void registerDataSetObserver(DataSetObserver observer) {
        mObservable.registerObserver(observer);
    }

    /**
     * Unregister an observer from callbacks related to the adapter's data changing.
     *
     * @param observer The {@link android.database.DataSetObserver} which will be unregistered.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.737 -0400", hash_original_method = "F847CF5B5DF735E7D60F86704B1D73CD", hash_generated_method = "C57A6AEE370CA4E86D7E3631610F1BBF")
    
public void unregisterDataSetObserver(DataSetObserver observer) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.741 -0400", hash_original_method = "D33F5CC8812E682744289E753AD4C997", hash_generated_method = "479873DFF9A60410744CFFB89F78C5F6")
    
public CharSequence getPageTitle(int position) {
        return null;
    }

    /**
     * Returns the proportional width of a given page as a percentage of the
     * ViewPager's measured width from (0.f-1.f]
     *
     * @param position The position of the page requested
     * @return Proportional width for the given page position
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.745 -0400", hash_original_method = "321C1C552BE4B49CDE18355BF7083B2B", hash_generated_method = "8B6985830BDA9EE5A9AC452E03971627")
    
public float getPageWidth(int position) {
        return 1.f;
    }
}
