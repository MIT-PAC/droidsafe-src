/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v13.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Parcelable;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Implementation of {@link android.support.v4.view.PagerAdapter} that
 * represents each page as a {@link android.app.Fragment} that is persistently
 * kept in the fragment manager as long as the user can return to the page.
 *
 * <p>This version of the pager is best for use when there are a handful of
 * typically more static fragments to be paged through, such as a set of tabs.
 * The fragment of each page the user visits will be kept in memory, though its
 * view hierarchy may be destroyed when not visible.  This can result in using
 * a significant amount of memory since fragment instances can hold on to an
 * arbitrary amount of state.  For larger sets of pages, consider
 * {@link FragmentStatePagerAdapter}.
 *
 * <p>When using FragmentPagerAdapter the host ViewPager must have a
 * valid ID set.</p>
 *
 * <p>Subclasses only need to implement {@link #getItem(int)}
 * and {@link #getCount()} to have a working adapter.
 *
 * <p>Here is an example implementation of a pager containing fragments of
 * lists:
 *
 * {@sample development/samples/Support13Demos/src/com/example/android/supportv13/app/FragmentPagerSupport.java
 *      complete}
 *
 * <p>The <code>R.layout.fragment_pager</code> resource of the top-level fragment is:
 *
 * {@sample development/samples/Support13Demos/res/layout/fragment_pager.xml
 *      complete}
 *
 * <p>The <code>R.layout.fragment_pager_list</code> resource containing each
 * individual fragment's layout is:
 *
 * {@sample development/samples/Support13Demos/res/layout/fragment_pager_list.xml
 *      complete}
 */
public abstract class FragmentPagerAdapter extends PagerAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.654 -0500", hash_original_field = "EEFCF03736638EEB326A8DCA25421DBC", hash_generated_field = "C72FFFE22C1245A655FF987EDEF7F7D6")

    private static final String TAG = "FragmentPagerAdapter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.662 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.766 -0500", hash_original_method = "53715FCC84E9A2EED36E7FF73581CB24", hash_generated_method = "B1E95B207FDA8A90D14F3EC05E6D753B")
    
private static String makeFragmentName(int viewId, int index) {
        return "android:switcher:" + viewId + ":" + index;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.668 -0500", hash_original_field = "0C27EED22F6A82BBBA86D53215B0BF17", hash_generated_field = "F8BD8E8005099844A113591459546070")

    private  FragmentManager mFragmentManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.672 -0500", hash_original_field = "27F3AB6E6051E5201188AA916E2866AC", hash_generated_field = "45681C0640ABED8BB32E7E47A23478AF")

    private FragmentTransaction mCurTransaction = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.679 -0500", hash_original_field = "B76431ECCE6EF00430DFE1A892C233F1", hash_generated_field = "3FD1F349465E20607A1ACB2506873721")

    private Fragment mCurrentPrimaryItem = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.684 -0500", hash_original_method = "0907AC653AA851CA26FCA5C2C0476634", hash_generated_method = "ABB82874FFE5A7CC950EC2328BD1AC79")
    
public FragmentPagerAdapter(FragmentManager fm) {
        mFragmentManager = fm;
    }

    /**
     * Return the Fragment associated with a specified position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.689 -0500", hash_original_method = "0C9300C8E0F0C0E8B44008DC047CEFF9", hash_generated_method = "918C6D014DB9AA643E9330669120C48C")
    
public abstract Fragment getItem(int position);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.696 -0500", hash_original_method = "40E78EFA38F0994EA71F26DADE781C52", hash_generated_method = "C451CD9BEC048C5D65EB3785ED5E5CC8")
    
@Override
    public void startUpdate(ViewGroup container) {
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.717 -0500", hash_original_method = "C5BEC84FC44A083F94D2A2057A09146B", hash_generated_method = "7B310DBF09726B34DC0C59368E19B45C")
    
@Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (mCurTransaction == null) {
            mCurTransaction = mFragmentManager.beginTransaction();
        }

        // Do we already have this fragment?
        String name = makeFragmentName(container.getId(), position);
        Fragment fragment = mFragmentManager.findFragmentByTag(name);
        if (fragment != null) {
            if (DEBUG) Log.v(TAG, "Attaching item #" + position + ": f=" + fragment);
            mCurTransaction.attach(fragment);
        } else {
            fragment = getItem(position);
            if (DEBUG) Log.v(TAG, "Adding item #" + position + ": f=" + fragment);
            mCurTransaction.add(container.getId(), fragment,
                    makeFragmentName(container.getId(), position));
        }
        if (fragment != mCurrentPrimaryItem) {
            FragmentCompat.setMenuVisibility(fragment, false);
            FragmentCompat.setUserVisibleHint(fragment, false);
        }

        return fragment;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.726 -0500", hash_original_method = "D2CA36ECE3C50A13099231C6B31A7BDC", hash_generated_method = "1268423803CAF7AD7B23C066AB18B42B")
    
@Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (mCurTransaction == null) {
            mCurTransaction = mFragmentManager.beginTransaction();
        }
        if (DEBUG) Log.v(TAG, "Detaching item #" + position + ": f=" + object
                + " v=" + ((Fragment)object).getView());
        mCurTransaction.detach((Fragment)object);
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.732 -0500", hash_original_method = "93AE6CC274420470809FED9A227E2A87", hash_generated_method = "FD2E1D525231FF98AEB0140CD4A36D7A")
    
@Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        Fragment fragment = (Fragment)object;
        if (fragment != mCurrentPrimaryItem) {
            if (mCurrentPrimaryItem != null) {
                FragmentCompat.setMenuVisibility(mCurrentPrimaryItem, false);
                FragmentCompat.setUserVisibleHint(mCurrentPrimaryItem, false);
            }
            if (fragment != null) {
                FragmentCompat.setMenuVisibility(fragment, true);
                FragmentCompat.setUserVisibleHint(fragment, true);
            }
            mCurrentPrimaryItem = fragment;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.739 -0500", hash_original_method = "82B7432FA4441721C4132291867EEFCE", hash_generated_method = "CE61AFE2F603793B40738C76BEDE2639")
    
@Override
    public void finishUpdate(ViewGroup container) {
        if (mCurTransaction != null) {
            mCurTransaction.commitAllowingStateLoss();
            mCurTransaction = null;
            mFragmentManager.executePendingTransactions();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.744 -0500", hash_original_method = "326A6E6DDD52502D387B1D32B8739E1F", hash_generated_method = "AF3559343D13818878146CEE853F63B6")
    
@Override
    public boolean isViewFromObject(View view, Object object) {
        return ((Fragment)object).getView() == view;
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.754 -0500", hash_original_method = "9C10790C9B509FF6855ECD7BB4443BBC", hash_generated_method = "C0F3FD7EB0D4B4DDD2361F02930CFABF")
    
@Override
    public Parcelable saveState() {
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:54.761 -0500", hash_original_method = "17638DDA6DE27E971DE60A544D06348C", hash_generated_method = "CA86982BBD297ECE9BC8A03BE9E0BFBA")
    
@Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }
}
