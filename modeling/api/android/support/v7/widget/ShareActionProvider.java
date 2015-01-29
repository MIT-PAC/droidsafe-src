/*
 * Copyright (C) 2013 The Android Open Source Project
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

package android.support.v7.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.ActivityChooserModel;
import android.support.v7.internal.widget.ActivityChooserView;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.support.v7.internal.widget.ActivityChooserModel.OnChooseActivityListener;

/**
 * This is a provider for a share action. It is responsible for creating views
 * that enable data sharing and also to show a sub menu with sharing activities
 * if the hosting item is placed on the overflow menu.
 *
 * <p class="note"><strong>Note:</strong> This class is included in the <a
 * href="{@docRoot}tools/extras/support-library.html">support library</a> for compatibility
 * with API level 7 and higher. If you're developing your app for API level 14 and higher
 * <em>only</em>, you should instead use the framework {@link android.widget.ShareActionProvider}
 * class.</p>
 *
 * <p>
 * Here is how to use the action provider with custom backing file in a {@link MenuItem}:
 * </p>
 * <pre><code>
 *  // In {@link android.app.Activity#onCreateOptionsMenu Activity.onCreateOptionsMenu()}
 *  public boolean onCreateOptionsMenu(Menu menu) {
 *      // Get the menu item.
 *      MenuItem menuItem = menu.findItem(R.id.my_menu_item);
 *      // Get the provider and hold onto it to set/change the share intent.
 *      mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
 *      // Set history different from the default before getting the action
 *      // view since a call to {@link android.support.v4.view.MenuItemCompat#getActionView(android.view.MenuItem) MenuItemCompat.getActionView()} calls
 *      // {@link ActionProvider#onCreateActionView()} which uses the backing file name. Omit this
 *      // line if using the default share history file is desired.
 *      mShareActionProvider.setShareHistoryFileName("custom_share_history.xml");
 *      . . .
 *  }
 *
 *  // Somewhere in the application.
 *  public void doShare(Intent shareIntent) {
 *      // When you want to share set the share intent.
 *      mShareActionProvider.setShareIntent(shareIntent);
 *  }
 * </code></pre>
 * <p>
 * <strong>Note:</strong> While the sample snippet demonstrates how to use this provider
 * in the context of a menu item, the use of the provider is not limited to menu items.
 * </p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 *
 * <p>For information about how to use {@link ShareActionProvider}, see the
 * <a href="{@docRoot}guide/topics/ui/actionbar.html#ActionProvider">Action Bar</a> API guide.</p>
 * </div>
 *
 * @see ActionProvider
 */
public class ShareActionProvider extends ActionProvider {

    /**
     * Listener for the event of selecting a share target.
     */
    public interface OnShareTargetSelectedListener {

        /**
         * Called when a share target has been selected. The client can
         * decide whether to perform some action before the sharing is
         * actually performed.
         * <p>
         * <strong>Note:</strong> Modifying the intent is not permitted and
         *     any changes to the latter will be ignored.
         * </p>
         * <p>
         * <strong>Note:</strong> You should <strong>not</strong> handle the
         *     intent here. This callback aims to notify the client that a
         *     sharing is being performed, so the client can update the UI
         *     if necessary.
         * </p>
         *
         * @param source The source of the notification.
         * @param intent The intent for launching the chosen share target.
         * @return The return result is ignored. Always return false for consistency.
         */
        public boolean onShareTargetSelected(ShareActionProvider source, Intent intent);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.182 -0400", hash_original_field = "34EE3314F9DB54E68585F253DD85D08C", hash_generated_field = "92B8F76AAEC7AF7155BC287F38FE45EA")

    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.189 -0400", hash_original_field = "94E9563AA87AAABA6812D665689E77D3", hash_generated_field = "1CB003B559FB29C1D53091AA377E4BB2")

    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.184 -0400", hash_original_field = "B2541B73A076DEB3E51A9B0DC3991BB2", hash_generated_field = "B8F76B4F7281B5BE96A33CBC1F738330")

    private int mMaxShownActivityCount = DEFAULT_INITIAL_ACTIVITY_COUNT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.186 -0400", hash_original_field = "1E88B09EA16A8C1A1465168EEFD351DC", hash_generated_field = "3718A0AB49E217FA6EE98546A2005E61")

    private final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener =
            new ShareMenuItemOnMenuItemClickListener();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.191 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.194 -0400", hash_original_field = "B0DDE9C45BE36EE89075DF033570DAE9", hash_generated_field = "7409E28971D0B0DB16EF85249AF9A2B4")

    private String mShareHistoryFileName = DEFAULT_SHARE_HISTORY_FILE_NAME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.196 -0400", hash_original_field = "14ABF3424D70483DB072A6166D335E25", hash_generated_field = "8D0302721DF93B0058B1E99D4AC6931D")

    private OnShareTargetSelectedListener mOnShareTargetSelectedListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.198 -0400", hash_original_field = "4E6DF115C423E32576A5D1CB98B81F8F", hash_generated_field = "A3948F7FA69A8ECB6B19574CCCA8D09F")

    private OnChooseActivityListener mOnChooseActivityListener;

    /**
     * Creates a new instance.
     *
     * @param context Context for accessing resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.200 -0400", hash_original_method = "D37DD9362CC0C7C9F17F614AA422CDA5", hash_generated_method = "EB12F0C179FF5049530FB71B65E2D7EF")
        
public ShareActionProvider(Context context) {
        super(context);
        mContext = context;
    }

    /**
     * Sets a listener to be notified when a share target has been selected.
     * The listener can optionally decide to handle the selection and
     * not rely on the default behavior which is to launch the activity.
     * <p>
     * <strong>Note:</strong> If you choose the backing share history file
     *     you will still be notified in this callback.
     * </p>
     * @param listener The listener.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.203 -0400", hash_original_method = "AF132A5C7109C48F5C74FEA83B1BA0C7", hash_generated_method = "B8FE842239AA363CF03B3737C8FA23CD")
        
public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener listener) {
        mOnShareTargetSelectedListener = listener;
        setActivityChooserPolicyIfNeeded();
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.206 -0400", hash_original_method = "1BC9B35CED3034C73A3301B7F5D599F4", hash_generated_method = "4FE3EAC5A4FBA931A0EB238AB5D7D2F5")
        
@Override
    public View onCreateActionView() {
        // Create the view and set its data model.
        ActivityChooserModel dataModel = ActivityChooserModel.get(mContext, mShareHistoryFileName);
        ActivityChooserView activityChooserView = new ActivityChooserView(mContext);
        activityChooserView.setActivityChooserModel(dataModel);

        // Lookup and set the expand action icon.
        TypedValue outTypedValue = new TypedValue();
        mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, outTypedValue, true);
        Drawable drawable = mContext.getResources().getDrawable(outTypedValue.resourceId);
        activityChooserView.setExpandActivityOverflowButtonDrawable(drawable);
        activityChooserView.setProvider(this);

        // Set content description.
        activityChooserView.setDefaultActionButtonContentDescription(
                R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(
                R.string.abc_shareactionprovider_share_with);

        return activityChooserView;
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.208 -0400", hash_original_method = "35CF29CD4DCA84D0FC63AC1A69E282B0", hash_generated_method = "CF1645D2E26EE80D0A742936B16D492A")
        
@Override
    public boolean hasSubMenu() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.211 -0400", hash_original_method = "5458A50E7CC261A43D8FD66D69514BF7", hash_generated_method = "9C9DCF571226F099D8D0DA86C844CB03")
        
@Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        // Clear since the order of items may change.
        subMenu.clear();

        ActivityChooserModel dataModel = ActivityChooserModel.get(mContext, mShareHistoryFileName);
        PackageManager packageManager = mContext.getPackageManager();

        final int expandedActivityCount = dataModel.getActivityCount();
        final int collapsedActivityCount = Math.min(expandedActivityCount, mMaxShownActivityCount);

        // Populate the sub-menu with a sub set of the activities.
        for (int i = 0; i < collapsedActivityCount; i++) {
            ResolveInfo activity = dataModel.getActivity(i);
            subMenu.add(0, i, i, activity.loadLabel(packageManager))
                    .setIcon(activity.loadIcon(packageManager))
                    .setOnMenuItemClickListener(mOnMenuItemClickListener);
        }

        if (collapsedActivityCount < expandedActivityCount) {
            // Add a sub-menu for showing all activities as a list item.
            SubMenu expandedSubMenu = subMenu.addSubMenu(Menu.NONE, collapsedActivityCount,
                    collapsedActivityCount,
                    mContext.getString(R.string.abc_activity_chooser_view_see_all));
            for (int i = 0; i < expandedActivityCount; i++) {
                ResolveInfo activity = dataModel.getActivity(i);
                expandedSubMenu.add(0, i, i, activity.loadLabel(packageManager))
                        .setIcon(activity.loadIcon(packageManager))
                        .setOnMenuItemClickListener(mOnMenuItemClickListener);
            }
        }
    }

    /**
     * Sets the file name of a file for persisting the share history which
     * history will be used for ordering share targets. This file will be used
     * for all view created by {@link #onCreateActionView()}. Defaults to
     * {@link #DEFAULT_SHARE_HISTORY_FILE_NAME}. Set to <code>null</code>
     * if share history should not be persisted between sessions.
     * <p>
     * <strong>Note:</strong> The history file name can be set any time, however
     * only the action views created by {@link #onCreateActionView()} after setting
     * the file name will be backed by the provided file. Therefore, if you want to
     * use different history files for sharing specific types of content, every time
     * you change the history file {@link #setShareHistoryFileName(String)} you must
     * call {@link android.app.Activity#invalidateOptionsMenu()} to recreate the
     * action view. You should <strong>not</strong> call
     * {@link android.app.Activity#invalidateOptionsMenu()} from
     * {@link android.app.Activity#onCreateOptionsMenu(Menu)}."
     * <p>
     * <code>
     * private void doShare(Intent intent) {
     *     if (IMAGE.equals(intent.getMimeType())) {
     *         mShareActionProvider.setHistoryFileName(SHARE_IMAGE_HISTORY_FILE_NAME);
     *     } else if (TEXT.equals(intent.getMimeType())) {
     *         mShareActionProvider.setHistoryFileName(SHARE_TEXT_HISTORY_FILE_NAME);
     *     }
     *     mShareActionProvider.setIntent(intent);
     *     invalidateOptionsMenu();
     * }
     * <code>
     *
     * @param shareHistoryFile The share history file name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.214 -0400", hash_original_method = "55B9AB4A16F0F7764FD2AA524BC9ED0A", hash_generated_method = "03E0DA1D52ECA62A54D2669894C69150")
        
public void setShareHistoryFileName(String shareHistoryFile) {
        mShareHistoryFileName = shareHistoryFile;
        setActivityChooserPolicyIfNeeded();
    }

    /**
     * Sets an intent with information about the share action. Here is a
     * sample for constructing a share intent:
     * <p>
     * <pre>
     * <code>
     *  Intent shareIntent = new Intent(Intent.ACTION_SEND);
     *  shareIntent.setType("image/*");
     *  Uri uri = Uri.fromFile(new File(getFilesDir(), "foo.jpg"));
     *  shareIntent.putExtra(Intent.EXTRA_STREAM, uri.toString());
     * </pre>
     * </code>
     * </p>
     *
     * @param shareIntent The share intent.
     *
     * @see Intent#ACTION_SEND
     * @see Intent#ACTION_SEND_MULTIPLE
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.216 -0400", hash_original_method = "0DAF31F3B630D54C36D98C14F5BC8D8F", hash_generated_method = "CC784081647578CB91B85D7C5DF7179C")
        
public void setShareIntent(Intent shareIntent) {
        ActivityChooserModel dataModel = ActivityChooserModel.get(mContext,
                mShareHistoryFileName);
        dataModel.setIntent(shareIntent);
    }

    /**
     * Reusable listener for handling share item clicks.
     */
    private class ShareMenuItemOnMenuItemClickListener implements OnMenuItemClickListener {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            ActivityChooserModel dataModel = ActivityChooserModel.get(mContext,
                    mShareHistoryFileName);
            final int itemId = item.getItemId();
            Intent launchIntent = dataModel.chooseActivity(itemId);
            if (launchIntent != null) {
                launchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                mContext.startActivity(launchIntent);
            }
            return true;
        }
    }

    /**
     * Set the activity chooser policy of the model backed by the current
     * share history file if needed which is if there is a registered callback.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:52.224 -0400", hash_original_method = "344268FF5DC4DDF2FCAEC43573B8D180", hash_generated_method = "58ADB291D16E488FEC9DB54F6A735676")
        
private void setActivityChooserPolicyIfNeeded() {
        if (mOnShareTargetSelectedListener == null) {
            return;
        }
        if (mOnChooseActivityListener == null) {
            mOnChooseActivityListener = new ShareActivityChooserModelPolicy();
        }
        ActivityChooserModel dataModel = ActivityChooserModel.get(mContext, mShareHistoryFileName);
        dataModel.setOnChooseActivityListener(mOnChooseActivityListener);
    }

    /**
     * Policy that delegates to the {@link OnShareTargetSelectedListener}, if such.
     */
    private class ShareActivityChooserModelPolicy implements OnChooseActivityListener {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onChooseActivity(ActivityChooserModel host, Intent intent) {
            if (mOnShareTargetSelectedListener != null) {
                mOnShareTargetSelectedListener.onShareTargetSelected(
                        ShareActionProvider.this, intent);
            }
            return false;
        }
    }
}