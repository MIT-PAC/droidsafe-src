/*
 * Copyright (C) 2010 The Android Open Source Project
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

package android.support.v7.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * Represents a contextual mode of the user interface. Action modes can be used to provide
 * alternative interaction modes and replace parts of the normal UI until finished. Examples of good
 * action modes include text selection and contextual actions.
 *
 * <p class="note"><strong>Note:</strong> This class is included in the <a
 * href="{@docRoot}tools/extras/support-library.html">support library</a> for compatibility
 * with API level 7 and higher. If you're developing your app for API level 11 and higher
 * <em>only</em>, you should instead use the framework {@link android.view.ActionMode} class.</p>
 *
 * <div class="special reference">
 *
 * <h3>Developer Guides</h3>
 *
 * <p>For information about how to provide contextual actions with {@code
 * ActionMode}, read the <a href="{@docRoot}guide/topics/ui/menus.html#context-menu">Menus</a>
 * developer guide.</p>
 *
 * </div>
 */
public abstract class ActionMode {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.536 -0400", hash_original_field = "87CC02BABEBC2A0BC6D4C7D0ADFF58E9", hash_generated_field = "EE550655758D5D3DEE98B11CF176B67D")

    private Object mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.538 -0400", hash_original_field = "86AEF5FEAC52676783690A5AE8D86D69", hash_generated_field = "BDA1BD10AD1CF9534B51825444097561")

    private boolean mTitleOptionalHint;

    /**
     * Set a tag object associated with this ActionMode.
     *
     * <p>Like the tag available to views, this allows applications to associate arbitrary data with
     * an ActionMode for later reference.
     *
     * @param tag Tag to associate with this ActionMode
     * @see #getTag()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.541 -0400", hash_original_method = "256DC994AF5E64F19A2C820A8209C31D", hash_generated_method = "4B49D6D7D0735F0E1B7D1CA587CE5238")
    
public void setTag(Object tag) {
        mTag = tag;
    }

    /**
     * Retrieve the tag object associated with this ActionMode.
     *
     * <p>Like the tag available to views, this allows applications to associate arbitrary data with
     * an ActionMode for later reference.
     *
     * @return Tag associated with this ActionMode
     * @see #setTag(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.542 -0400", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "1B4659EEE0161BE6922AFBEB646209D7")
    
public Object getTag() {
        return mTag;
    }

    /**
     * Set the title of the action mode. This method will have no visible effect if a custom view
     * has been set.
     *
     * @param title Title string to set
     * @see #setTitle(int)
     * @see #setCustomView(View)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.545 -0400", hash_original_method = "410835EEA321510B785087E900780AFB", hash_generated_method = "F61FA778C52CF90209781407DFEFC387")
    
public abstract void setTitle(CharSequence title);

    /**
     * Set the title of the action mode. This method will have no visible effect if a custom view
     * has been set.
     *
     * @param resId Resource ID of a string to set as the title
     * @see #setTitle(CharSequence)
     * @see #setCustomView(View)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.547 -0400", hash_original_method = "516EEAF41A54C2F23324189E2ED4731D", hash_generated_method = "D271218F7CA96C8DBB89D368B635F8B6")
    
public abstract void setTitle(int resId);

    /**
     * Set the subtitle of the action mode. This method will have no visible effect if a custom view
     * has been set.
     *
     * @param subtitle Subtitle string to set
     * @see #setSubtitle(int)
     * @see #setCustomView(View)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.549 -0400", hash_original_method = "D00074A941BED700B112E60CA2B4BBFA", hash_generated_method = "0BA816A36095386377AF796A7E9F4E55")
    
public abstract void setSubtitle(CharSequence subtitle);

    /**
     * Set the subtitle of the action mode. This method will have no visible effect if a custom view
     * has been set.
     *
     * @param resId Resource ID of a string to set as the subtitle
     * @see #setSubtitle(CharSequence)
     * @see #setCustomView(View)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.551 -0400", hash_original_method = "08B7103B21D83BEA0EC09BF9CF437884", hash_generated_method = "8D1000593E31D74C218814097C6E4287")
    
public abstract void setSubtitle(int resId);

    /**
     * Set whether or not the title/subtitle display for this action mode is optional.
     *
     * <p>In many cases the supplied title for an action mode is merely meant to add context and is
     * not strictly required for the action mode to be useful. If the title is optional, the system
     * may choose to hide the title entirely rather than truncate it due to a lack of available
     * space.</p>
     *
     * <p>Note that this is merely a hint; the underlying implementation may choose to ignore this
     * setting under some circumstances.</p>
     *
     * @param titleOptional true if the title only presents optional information.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.555 -0400", hash_original_method = "DD1D4A9532F512B88C2D38B6FA8A70AF", hash_generated_method = "D42338CE27B053FF8B019CDFA8433B4C")
    
public void setTitleOptionalHint(boolean titleOptional) {
        mTitleOptionalHint = titleOptional;
    }

    /**
     * @return true if this action mode has been given a hint to consider the title/subtitle display
     *         to be optional.
     * @see #setTitleOptionalHint(boolean)
     * @see #isTitleOptional()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.557 -0400", hash_original_method = "5403616DA226046EF3D8CE2964DAD82D", hash_generated_method = "5A4EAB7E841B015808B431A95FE2637A")
    
public boolean getTitleOptionalHint() {
        return mTitleOptionalHint;
    }

    /**
     * @return true if this action mode considers the title and subtitle fields as optional.
     *         Optional titles may not be displayed to the user.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.559 -0400", hash_original_method = "D0B97BBE5E65EB30B32778EBC67BA39A", hash_generated_method = "7BC617DFC6A6130AB051AA5FDF36F8A4")
    
public boolean isTitleOptional() {
        return false;
    }

    /**
     * Set a custom view for this action mode. The custom view will take the place of the title and
     * subtitle. Useful for things like search boxes.
     *
     * @param view Custom view to use in place of the title/subtitle.
     * @see #setTitle(CharSequence)
     * @see #setSubtitle(CharSequence)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.561 -0400", hash_original_method = "75E78D59B0AC673EC9AC299DFF89779E", hash_generated_method = "3F5163B75632712B25ECCBFB0D907DF2")
    
public abstract void setCustomView(View view);

    /**
     * Invalidate the action mode and refresh menu content. The mode's {@link ActionMode.Callback}
     * will have its {@link Callback#onPrepareActionMode(ActionMode, Menu)} method called. If it
     * returns true the menu will be scanned for updated content and any relevant changes will be
     * reflected to the user.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.563 -0400", hash_original_method = "70F593FC630C0533FD7D3758F8C5CFA1", hash_generated_method = "1747FC730FFA208D064087D81614198D")
    
public abstract void invalidate();

    /**
     * Finish and close this action mode. The action mode's {@link ActionMode.Callback} will have
     * its {@link Callback#onDestroyActionMode(ActionMode)} method called.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.565 -0400", hash_original_method = "813B1E67A5651AE12B7ADAA81DD30965", hash_generated_method = "EA335D0833EB6960285108A346A4AFC1")
    
public abstract void finish();

    /**
     * Returns the menu of actions that this action mode presents.
     *
     * @return The action mode's menu.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.567 -0400", hash_original_method = "DCB61573D17CF52C77788C074BA8AC8B", hash_generated_method = "F0C4744A37BE92FD577BF28B66ABAB46")
    
public abstract Menu getMenu();

    /**
     * Returns the current title of this action mode.
     *
     * @return Title text
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.570 -0400", hash_original_method = "2A829968551EA225833AD910559E3639", hash_generated_method = "9F704A6DC6184A7C8579171531B62A23")
    
public abstract CharSequence getTitle();

    /**
     * Returns the current subtitle of this action mode.
     *
     * @return Subtitle text
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.573 -0400", hash_original_method = "FEEA0E87B97F8601D44AFB1E29DE7E64", hash_generated_method = "19C700D07F867A34AFE71438482B9BA4")
    
public abstract CharSequence getSubtitle();

    /**
     * Returns the current custom view for this action mode.
     *
     * @return The current custom view
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.575 -0400", hash_original_method = "9FFDC35B3B54894B02C81A484E99C0EB", hash_generated_method = "E95F0DF95C54D06CFADD71C2C35C4CFF")
    
public abstract View getCustomView();

    /**
     * Returns a {@link MenuInflater} with the ActionMode's context.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.577 -0400", hash_original_method = "232216C9B01BF51DC3B19AC833B1F44A", hash_generated_method = "E76EC25552FE301AA15012E8BEC12C50")
    
public abstract MenuInflater getMenuInflater();

    /**
     * Returns whether the UI presenting this action mode can take focus or not. This is used by
     * internal components within the framework that would otherwise present an action mode UI that
     * requires focus, such as an EditText as a custom view.
     *
     * @return true if the UI used to show this action mode can take focus
     * @hide Internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:50.579 -0400", hash_original_method = "57D435E5DB9DAA5D06EB98D67411AC43", hash_generated_method = "BCCFD0C1F6AE7BD81B649ACADC755607")
    
public boolean isUiFocusable() {
        return true;
    }

    /**
     * Callback interface for action modes. Supplied to
     * {@link android.support.v7.app.ActionBarActivity#startSupportActionMode(Callback)}
     * a Callback configures and handles events raised by a user's interaction with an action mode.
     *
     * <p>An action mode's lifecycle is as follows:
     *
     * <ul><li>{@link Callback#onCreateActionMode(ActionMode,
     * Menu)} once on initial creation</li>
     *
     * <li>{@link Callback#onPrepareActionMode(ActionMode, Menu)}
     * after creation and any time the {@link ActionMode} is invalidated</li>
     *
     * <li>{@link
     * Callback#onActionItemClicked(ActionMode, MenuItem)} any time a contextual action button is
     * clicked</li>
     *
     * <li>{@link Callback#onDestroyActionMode(ActionMode)} when the action mode is
     * closed</li></ul>
     */
    public interface Callback {

        /**
         * Called when action mode is first created. The menu supplied will be used to generate
         * action buttons for the action mode.
         *
         * @param mode ActionMode being created
         * @param menu Menu used to populate action buttons
         * @return true if the action mode should be created, false if entering this mode should be
         *         aborted.
         */
        public boolean onCreateActionMode(ActionMode mode, Menu menu);

        /**
         * Called to refresh an action mode's action menu whenever it is invalidated.
         *
         * @param mode ActionMode being prepared
         * @param menu Menu used to populate action buttons
         * @return true if the menu or action mode was updated, false otherwise.
         */
        public boolean onPrepareActionMode(ActionMode mode, Menu menu);

        /**
         * Called to report a user click on an action button.
         *
         * @param mode The current ActionMode
         * @param item The item that was clicked
         * @return true if this callback handled the event, false if the standard MenuItem
         *         invocation should continue.
         */
        public boolean onActionItemClicked(ActionMode mode, MenuItem item);

        /**
         * Called when an action mode is about to be exited and destroyed.
         *
         * @param mode The current ActionMode being destroyed
         */
        public void onDestroyActionMode(ActionMode mode);
    }
}
