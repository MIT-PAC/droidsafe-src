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


package android.support.v4.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.IntentCompat;
import android.support.v4.view.MenuItemCompat;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

/**
 * Extra helper functionality for sharing data between activities.
 *
 * ShareCompat provides functionality to extend the {@link Intent#ACTION_SEND}/
 * {@link Intent#ACTION_SEND_MULTIPLE} protocol and support retrieving more info
 * about the activity that invoked a social sharing action.
 *
 * {@link IntentBuilder} provides helper functions for constructing a sharing
 * intent that always includes data about the calling activity and app.
 * This lets the called activity provide attribution for the app that shared
 * content. Constructing an intent this way can be done in a method-chaining style.
 * To obtain an IntentBuilder with info about your calling activity, use the static
 * method {@link IntentBuilder#from(Activity)}.
 *
 * {@link IntentReader} provides helper functions for parsing the defined extras
 * within an {@link Intent#ACTION_SEND} or {@link Intent#ACTION_SEND_MULTIPLE} intent
 * used to launch an activity. You can also obtain a Drawable for the caller's
 * application icon and the application's localized label (the app's human-readable name).
 * Social apps that enable sharing content are encouraged to use this information
 * to call out the app that the content was shared from.
 */
public class ShareCompat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.240 -0500", hash_original_field = "2C3DC00FC255371343F870BDC3739C87", hash_generated_field = "F0F1884F3EDE30C05A70864F9C6AA85D")

    public static final String EXTRA_CALLING_PACKAGE =
            "android.support.v4.app.EXTRA_CALLING_PACKAGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.243 -0500", hash_original_field = "4163A49E59265D70A21CA259FC528549", hash_generated_field = "162A2C12919BD466B3B854E7E2E5BA78")

    public static final String EXTRA_CALLING_ACTIVITY =
            "android.support.v4.app.EXTRA_CALLING_ACTIVITY";

    /**
     * Compatibility shims for sharing operations
     */
    interface ShareCompatImpl {
        void configureMenuItem(MenuItem item, IntentBuilder shareIntent);
        String escapeHtml(CharSequence text);
    }

    static class ShareCompatImplBase implements ShareCompatImpl {

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.259 -0500", hash_original_method = "2E6B3ADFD44E0D73A052C11528C54D60", hash_generated_method = "FC21D994471D7907742966DC79B722EE")
        
private static void withinStyle(StringBuilder out, CharSequence text,
                int start, int end) {
            for (int i = start; i < end; i++) {
                char c = text.charAt(i);

                if (c == '<') {
                    out.append("&lt;");
                } else if (c == '>') {
                    out.append("&gt;");
                } else if (c == '&') {
                    out.append("&amp;");
                } else if (c > 0x7E || c < ' ') {
                    out.append("&#" + ((int) c) + ";");
                } else if (c == ' ') {
                    while (i + 1 < end && text.charAt(i + 1) == ' ') {
                        out.append("&nbsp;");
                        i++;
                    }

                    out.append(' ');
                } else {
                    out.append(c);
                }
            }
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.252 -0500", hash_original_method = "C3E2EAA5FDB39D2940E924EA83A92CD9", hash_generated_method = "7B4B3C704833A3B8F9D597BF61650835")
        
public void configureMenuItem(MenuItem item, IntentBuilder shareIntent) {
            item.setIntent(shareIntent.createChooserIntent());
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.255 -0500", hash_original_method = "9806F7FA6AF2B88CA22BBC7126655294", hash_generated_method = "9CFCB3513F06FB61BCE979532A65A44E")
        
public String escapeHtml(CharSequence text) {
            StringBuilder out = new StringBuilder();
            withinStyle(out, text, 0, text.length());
            return out.toString();
        }
    }

    static class ShareCompatImplICS extends ShareCompatImplBase {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.264 -0500", hash_original_method = "720A861674BD19DDF349D0A647948753", hash_generated_method = "C8D137BAA8A811CA4ED9BB083CE1DA02")
        
public void configureMenuItem(MenuItem item, IntentBuilder shareIntent) {
            ShareCompatICS.configureMenuItem(item, shareIntent.getActivity(),
                    shareIntent.getIntent());
            if (shouldAddChooserIntent(item)) {
                item.setIntent(shareIntent.createChooserIntent());
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.266 -0500", hash_original_method = "B41498ADC231C1B6FE6FB180270839F6", hash_generated_method = "B41498ADC231C1B6FE6FB180270839F6")
        
boolean shouldAddChooserIntent(MenuItem item) {
            return !item.hasSubMenu();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.271 -0500", hash_original_field = "64D4298DFDBF8439D20B7BFA9187D2D2", hash_generated_field = "1BF51C8837B8F6C5C574D00A856658A9")

    private static ShareCompatImpl IMPL;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new ShareCompatImplICS();
        } else {
            IMPL = new ShareCompatImplBase();
        }
    }

    /**
     * Retrieve the name of the package that launched calledActivity from a share intent.
     * Apps that provide social sharing functionality can use this to provide attribution
     * for the app that shared the content.
     *
     * <p><em>Note:</em> This data may have been provided voluntarily by the calling
     * application. As such it should not be trusted for accuracy in the context of
     * security or verification.</p>
     *
     * @param calledActivity Current activity that was launched to share content
     * @return Name of the calling package
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.274 -0500", hash_original_method = "067B1B9A930CE55C02EE0415F2995920", hash_generated_method = "49D83731A9820A823FEFC5097F5A4E49")
    
public static String getCallingPackage(Activity calledActivity) {
        String result = calledActivity.getCallingPackage();
        if (result == null) {
            result = calledActivity.getIntent().getStringExtra(EXTRA_CALLING_PACKAGE);
        }
        return result;
    }

    /**
     * Retrieve the ComponentName of the activity that launched calledActivity from a share intent.
     * Apps that provide social sharing functionality can use this to provide attribution
     * for the app that shared the content.
     *
     * <p><em>Note:</em> This data may have been provided voluntarily by the calling
     * application. As such it should not be trusted for accuracy in the context of
     * security or verification.</p>
     *
     * @param calledActivity Current activity that was launched to share content
     * @return ComponentName of the calling activity
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.276 -0500", hash_original_method = "9CF512AFECB6E76B3CEACB77EA9097D5", hash_generated_method = "BE096B8672A35F2E20C5AA7EE0FCD569")
    
public static ComponentName getCallingActivity(Activity calledActivity) {
        ComponentName result = calledActivity.getCallingActivity();
        if (result == null) {
            result = calledActivity.getIntent().getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        }
        return result;
    }

    /**
     * Configure a {@link MenuItem} to act as a sharing action.
     *
     * <p>If the app is running on API level 14 or higher (Android 4.0/Ice Cream Sandwich)
     * this method will configure a ShareActionProvider to provide a more robust UI
     * for selecting the target of the share. History will be tracked for each calling
     * activity in a file named with the prefix ".sharecompat_" in the application's
     * private data directory. If the application wishes to set this MenuItem to show
     * as an action in the Action Bar it should use
     * {@link MenuItemCompat#setShowAsAction(MenuItem, int)} to request that behavior
     * in addition to calling this method.</p>
     *
     * <p>If the app is running on an older platform version this method will configure
     * a standard activity chooser dialog for the menu item.</p>
     *
     * <p>During the calling activity's lifecycle, if data within the share intent must
     * change the app should change that state in one of several ways:</p>
     * <ul>
     * <li>Call {@link ActivityCompat#invalidateOptionsMenu(Activity)}. If the app is running
     * on API level 11 or above and uses the Action Bar its menu will be recreated and rebuilt.
     * If not, the activity will receive a call to {@link Activity#onPrepareOptionsMenu(Menu)}
     * the next time the user presses the menu key to open the options menu panel. The activity
     * can then call configureMenuItem again with a new or altered IntentBuilder to reconfigure
     * the share menu item.</li>
     * <li>Keep a reference to the MenuItem object for the share item once it has been created
     * and call configureMenuItem to update the associated sharing intent as needed.</li>
     * </ul>
     *
     * @param item MenuItem to configure for sharing
     * @param shareIntent IntentBuilder with data about the content to share
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.279 -0500", hash_original_method = "3ED9C7185B1B187DD0596DDF60FB405D", hash_generated_method = "7ABB0685830F178B9CF4ABD68C0D29DB")
    
public static void configureMenuItem(MenuItem item, IntentBuilder shareIntent) {
        IMPL.configureMenuItem(item, shareIntent);
    }

    /**
     * Configure a menu item to act as a sharing action.
     *
     * @param menu Menu containing the item to use for sharing
     * @param menuItemId ID of the share item within menu
     * @param shareIntent IntentBuilder with data about the content to share
     * @see #configureMenuItem(MenuItem, IntentBuilder)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.284 -0500", hash_original_method = "A5392CB50560BE4951F0540F56864AA5", hash_generated_method = "21080C2E0894364C283BDB3C647C8202")
    
public static void configureMenuItem(Menu menu, int menuItemId, IntentBuilder shareIntent) {
        MenuItem item = menu.findItem(menuItemId);
        if (item == null) {
            throw new IllegalArgumentException("Could not find menu item with id " + menuItemId +
                    " in the supplied menu");
        }
        configureMenuItem(item, shareIntent);
    }

    /**
     * IntentBuilder is a helper for constructing {@link Intent#ACTION_SEND} and
     * {@link Intent#ACTION_SEND_MULTIPLE} sharing intents and starting activities
     * to share content. The ComponentName and package name of the calling activity
     * will be included.
     */
    public static class IntentBuilder {

        /**
         * Create a new IntentBuilder for launching a sharing action from launchingActivity.
         *
         * @param launchingActivity Activity that the share will be launched from
         * @return a new IntentBuilder instance
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.318 -0500", hash_original_method = "8764E405A06B9AB75CC3B79289BC588D", hash_generated_method = "0EA7310672001ECE228DEA41774D829A")
        
public static IntentBuilder from(Activity launchingActivity) {
            return new IntentBuilder(launchingActivity);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.288 -0500", hash_original_field = "3895D7E6DB5042DA7856DC78E391C7B9", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")

        private Activity mActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.290 -0500", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.292 -0500", hash_original_field = "BBCC613FDD9F27082CA927AEE4F504A8", hash_generated_field = "C9A7B3C8A894CB38E3F5AAE7F09F414B")

        private CharSequence mChooserTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.297 -0500", hash_original_field = "1CFDE38040C47A6FA3F90DAFF4C3E58E", hash_generated_field = "21ED3C508F73EC28DFF7BE66BD15E9A5")

        private ArrayList<String> mToAddresses;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.302 -0500", hash_original_field = "D422D2DC612E47C87BD40E2658321D82", hash_generated_field = "1FA039FD28E6545C6FC9E4ED5C735249")

        private ArrayList<String> mCcAddresses;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.308 -0500", hash_original_field = "FEB7EB83E9E0D1FB8342CE94EE031170", hash_generated_field = "F7527C0ABC323B033A133BADC1BA7ACD")

        private ArrayList<String> mBccAddresses;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.313 -0500", hash_original_field = "C257DE59BDDDAB6C6845D8752A063867", hash_generated_field = "E38B530386D6624B9CC752A26937D70B")

        private ArrayList<Uri> mStreams;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.323 -0500", hash_original_method = "DF152584278C8F8C835FFB6AA3E923E0", hash_generated_method = "7D58730987C1999A7BF8406449862C3D")
        
private IntentBuilder(Activity launchingActivity) {
            mActivity = launchingActivity;
            mIntent = new Intent().setAction(Intent.ACTION_SEND);
            mIntent.putExtra(EXTRA_CALLING_PACKAGE, launchingActivity.getPackageName());
            mIntent.putExtra(EXTRA_CALLING_ACTIVITY, launchingActivity.getComponentName());
            mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        }

        /**
         * Retrieve the Intent as configured so far by the IntentBuilder. This Intent
         * is suitable for use in a ShareActionProvider or chooser dialog.
         *
         * <p>To create an intent that will launch the activity chooser so that the user
         * may select a target for the share, see {@link #createChooserIntent()}.
         *
         * @return The current Intent being configured by this builder
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.327 -0500", hash_original_method = "CC05494BB54ABC476F91DA83FFC83A1D", hash_generated_method = "E7336E542888521AC6DBD2E3F2182324")
        
public Intent getIntent() {
            if (mToAddresses != null) {
                combineArrayExtra(Intent.EXTRA_EMAIL, mToAddresses);
                mToAddresses = null;
            }
            if (mCcAddresses != null) {
                combineArrayExtra(Intent.EXTRA_CC, mCcAddresses);
                mCcAddresses = null;
            }
            if (mBccAddresses != null) {
                combineArrayExtra(Intent.EXTRA_BCC, mBccAddresses);
                mBccAddresses = null;
            }

            // Check if we need to change the action.
            boolean needsSendMultiple = mStreams != null && mStreams.size() > 1;
            boolean isSendMultiple = mIntent.getAction().equals(Intent.ACTION_SEND_MULTIPLE);

            if (!needsSendMultiple && isSendMultiple) {
                // Change back to a single send action; place the first stream into the
                // intent for single sharing.
                mIntent.setAction(Intent.ACTION_SEND);
                if (mStreams != null && !mStreams.isEmpty()) {
                    mIntent.putExtra(Intent.EXTRA_STREAM, mStreams.get(0));
                } else {
                    mIntent.removeExtra(Intent.EXTRA_STREAM);
                }
                mStreams = null;
            }

            if (needsSendMultiple && !isSendMultiple) {
                // Change to a multiple send action; place the relevant ArrayList into the
                // intent for multiple sharing.
                mIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
                if (mStreams != null && !mStreams.isEmpty()) {
                    mIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, mStreams);
                } else {
                    mIntent.removeExtra(Intent.EXTRA_STREAM);
                }
            }

            return mIntent;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.332 -0500", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "3F17133E8D63AE8C7414DC58966291E3")
        
Activity getActivity() {
            return mActivity;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.336 -0500", hash_original_method = "026504B88DB15C0C017BBB730BD6CA05", hash_generated_method = "778A08B27866B4CE862A5D0FF5D43346")
        
private void combineArrayExtra(String extra, ArrayList<String> add) {
            String[] currentAddresses = mIntent.getStringArrayExtra(extra);
            int currentLength = currentAddresses != null ? currentAddresses.length : 0;
            String[] finalAddresses = new String[currentLength + add.size()];
            add.toArray(finalAddresses);
            if (currentAddresses != null) {
                System.arraycopy(currentAddresses, 0, finalAddresses, add.size(), currentLength);
            }
            mIntent.putExtra(extra, finalAddresses);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.340 -0500", hash_original_method = "BD64BC57794A356441B2316C07AE8DAC", hash_generated_method = "F5F98F5475C7ACF53C7FFB7F5F651574")
        
private void combineArrayExtra(String extra, String[] add) {
            // Add any items still pending
            Intent intent = getIntent();
            String[] old = intent.getStringArrayExtra(extra);
            int oldLength = old != null ? old.length : 0;
            String[] result = new String[oldLength + add.length];
            if (old != null) System.arraycopy(old, 0, result, 0, oldLength);
            System.arraycopy(add, 0, result, oldLength, add.length);
            intent.putExtra(extra, result);
        }

        /**
         * Create an Intent that will launch the standard Android activity chooser,
         * allowing the user to pick what activity/app on the system should handle
         * the share.
         *
         * @return A chooser Intent for the currently configured sharing action
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.343 -0500", hash_original_method = "4A271FB631FE734F0A005F0662E72303", hash_generated_method = "E3F5232E4353DFC203EDE16572F5A3DB")
        
public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), mChooserTitle);
        }

        /**
         * Start a chooser activity for the current share intent.
         *
         * <p>Note that under most circumstances you should use
         * {@link ShareCompat#configureMenuItem(MenuItem, IntentBuilder)
         *  ShareCompat.configureMenuItem()} to add a Share item to the menu while
         * presenting a detail view of the content to be shared instead
         * of invoking this directly.</p>
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.347 -0500", hash_original_method = "EF93D4C25B6364A5474AC09756C110F4", hash_generated_method = "04E386AEC867BCF0DC8FA5C860A02AB4")
        
public void startChooser() {
            mActivity.startActivity(createChooserIntent());
        }

        /**
         * Set the title that will be used for the activity chooser for this share.
         *
         * @param title Title string
         * @return This IntentBuilder for method chaining
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.351 -0500", hash_original_method = "06E956E502A80DA9473ED82266A5A9DE", hash_generated_method = "77D6631FB136B1C27AF9A12D22049C62")
        
public IntentBuilder setChooserTitle(CharSequence title) {
            mChooserTitle = title;
            return this;
        }

        /**
         * Set the title that will be used for the activity chooser for this share.
         *
         * @param resId Resource ID of the title string to use
         * @return This IntentBuilder for method chaining
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.353 -0500", hash_original_method = "03DF458E6ED02C68488BE88E21862CDF", hash_generated_method = "335DF9E156B7786B9ED667D4D450D491")
        
public IntentBuilder setChooserTitle(int resId) {
            return setChooserTitle(mActivity.getText(resId));
        }

        /**
         * Set the type of data being shared
         *
         * @param mimeType mimetype of the shared data
         * @return This IntentBuilder for method chaining
         * @see Intent#setType(String)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.356 -0500", hash_original_method = "FC54C1994B818C86E4DBEFD863458812", hash_generated_method = "BC12A6DF4692F78CF6B71123F8B348AD")
        
public IntentBuilder setType(String mimeType) {
            mIntent.setType(mimeType);
            return this;
        }

        /**
         * Set the literal text data to be sent as part of the share.
         * This may be a styled CharSequence.
         *
         * @param text Text to share
         * @return This IntentBuilder for method chaining
         * @see Intent#EXTRA_TEXT
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.359 -0500", hash_original_method = "C395D7124DB9BC11CF728AC9FB5C05F1", hash_generated_method = "7A3F4859E225E0013766BCAE59DE1892")
        
public IntentBuilder setText(CharSequence text) {
            mIntent.putExtra(Intent.EXTRA_TEXT, text);
            return this;
        }

        /**
         * Set an HTML string to be sent as part of the share.
         * If {@link Intent#EXTRA_TEXT EXTRA_TEXT} has not already been supplied,
         * a styled version of the supplied HTML text will be added as EXTRA_TEXT as
         * parsed by {@link android.text.Html#fromHtml(String) Html.fromHtml}.
         *
         * @param htmlText A string containing HTML markup as a richer version of the text
         *                 provided by EXTRA_TEXT.
         * @return This IntentBuilder for method chaining
         * @see #setText(CharSequence)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.363 -0500", hash_original_method = "0ACA0FC52A261E3EBDD7B86C55B1B747", hash_generated_method = "9BC5156866A9EEC6E69C5534773E4B14")
        
public IntentBuilder setHtmlText(String htmlText) {
            mIntent.putExtra(IntentCompat.EXTRA_HTML_TEXT, htmlText);
            if (!mIntent.hasExtra(Intent.EXTRA_TEXT)) {
                // Supply a default if EXTRA_TEXT isn't set
                setText(Html.fromHtml(htmlText));
            }
            return this;
        }

        /**
         * Set a stream URI to the data that should be shared.
         *
         * <p>This replaces all currently set stream URIs and will produce a single-stream
         * ACTION_SEND intent.</p>
         *
         * @param streamUri URI of the stream to share
         * @return This IntentBuilder for method chaining
         * @see Intent#EXTRA_STREAM
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.366 -0500", hash_original_method = "0CC67542367F5DDA6287793533CA2797", hash_generated_method = "79C491B8A576BDB2E170890B763379BC")
        
public IntentBuilder setStream(Uri streamUri) {
            if (!mIntent.getAction().equals(Intent.ACTION_SEND)) {
                mIntent.setAction(Intent.ACTION_SEND);
            }
            mStreams = null;
            mIntent.putExtra(Intent.EXTRA_STREAM, streamUri);
            return this;
        }

        /**
         * Add a stream URI to the data that should be shared. If this is not the first
         * stream URI added the final intent constructed will become an ACTION_SEND_MULTIPLE
         * intent. Not all apps will handle both ACTION_SEND and ACTION_SEND_MULTIPLE.
         *
         * @param streamUri URI of the stream to share
         * @return This IntentBuilder for method chaining
         * @see Intent#EXTRA_STREAM
         * @see Intent#ACTION_SEND
         * @see Intent#ACTION_SEND_MULTIPLE
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.368 -0500", hash_original_method = "5DA0D5B75B65E8A970BBB6A6FE8B4CFF", hash_generated_method = "AF71E1D2B68F365AE8E8FEFBFBD1C39C")
        
public IntentBuilder addStream(Uri streamUri) {
            Uri currentStream = mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
            if (currentStream == null) {
                return setStream(streamUri);
            }
            if (mStreams == null) {
                mStreams = new ArrayList<Uri>();
            }
            if (currentStream != null) {
                mIntent.removeExtra(Intent.EXTRA_STREAM);
                mStreams.add(currentStream);
            }
            mStreams.add(streamUri);
            return this;
        }

        /**
         * Set an array of email addresses as recipients of this share.
         * This replaces all current "to" recipients that have been set so far.
         *
         * @param addresses Email addresses to send to
         * @return This IntentBuilder for method chaining
         * @see Intent#EXTRA_EMAIL
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.371 -0500", hash_original_method = "FD4DB555E0D921CCC6ACF7E2C37BCAC4", hash_generated_method = "495300A14EA7D81A2E0DC7FF2F25B29C")
        
public IntentBuilder setEmailTo(String[] addresses) {
            if (mToAddresses != null) {
                mToAddresses = null;
            }
            mIntent.putExtra(Intent.EXTRA_EMAIL, addresses);
            return this;
        }

        /**
         * Add an email address to be used in the "to" field of the final Intent.
         *
         * @param address Email address to send to
         * @return This IntentBuilder for method chaining
         * @see Intent#EXTRA_EMAIL
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.373 -0500", hash_original_method = "E206D9565B5E9D24AEF2AF92EC056646", hash_generated_method = "866C843FF78413E201F7C3C47FC093A7")
        
public IntentBuilder addEmailTo(String address) {
            if (mToAddresses == null) {
                mToAddresses = new ArrayList<String>();
            }
            mToAddresses.add(address);
            return this;
        }

        /**
         * Add an array of email addresses to be used in the "to" field of the final Intent.
         *
         * @param addresses Email addresses to send to
         * @return This IntentBuilder for method chaining
         * @see Intent#EXTRA_EMAIL
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.375 -0500", hash_original_method = "7721A9C42CBA5A2892BFCB8DDD6F7399", hash_generated_method = "3D4C47E75BFDCA789FBAD853B32D24C6")
        
public IntentBuilder addEmailTo(String[] addresses) {
            combineArrayExtra(Intent.EXTRA_EMAIL, addresses);
            return this;
        }

        /**
         * Set an array of email addresses to CC on this share.
         * This replaces all current "CC" recipients that have been set so far.
         *
         * @param addresses Email addresses to CC on the share
         * @return This IntentBuilder for method chaining
         * @see Intent#EXTRA_CC
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.377 -0500", hash_original_method = "BE74A7950B78C22222797B86EEED6F25", hash_generated_method = "0A28CCCEE1F31541855A8FACFAEC4787")
        
public IntentBuilder setEmailCc(String[] addresses) {
            mIntent.putExtra(Intent.EXTRA_CC, addresses);
            return this;
        }

        /**
         * Add an email address to be used in the "cc" field of the final Intent.
         *
         * @param address Email address to CC
         * @return This IntentBuilder for method chaining
         * @see Intent#EXTRA_CC
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.379 -0500", hash_original_method = "2EF08D607B211A7E5DCF80D337C959CD", hash_generated_method = "7E7A314AC54E092263614E7E0ACB26F7")
        
public IntentBuilder addEmailCc(String address) {
            if (mCcAddresses == null) {
                mCcAddresses = new ArrayList<String>();
            }
            mCcAddresses.add(address);
            return this;
        }

        /**
         * Add an array of email addresses to be used in the "cc" field of the final Intent.
         *
         * @param addresses Email addresses to CC
         * @return This IntentBuilder for method chaining
         * @see Intent#EXTRA_CC
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.381 -0500", hash_original_method = "18B1AA262CDF43BA34C5BCC06BA146A5", hash_generated_method = "3FA4A5814540BAD4232B0141356A16D0")
        
public IntentBuilder addEmailCc(String[] addresses) {
            combineArrayExtra(Intent.EXTRA_CC, addresses);
            return this;
        }

        /**
         * Set an array of email addresses to BCC on this share.
         * This replaces all current "BCC" recipients that have been set so far.
         *
         * @param addresses Email addresses to BCC on the share
         * @return This IntentBuilder for method chaining
         * @see Intent#EXTRA_BCC
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.383 -0500", hash_original_method = "965E5218675D98D1034B8CE91C4C024C", hash_generated_method = "F7BEB7E3D50CB93B8BDAE3BC78F70027")
        
public IntentBuilder setEmailBcc(String[] addresses) {
            mIntent.putExtra(Intent.EXTRA_BCC, addresses);
            return this;
        }

        /**
         * Add an email address to be used in the "bcc" field of the final Intent.
         *
         * @param address Email address to BCC
         * @return This IntentBuilder for method chaining
         * @see Intent#EXTRA_BCC
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.385 -0500", hash_original_method = "68C0EF4D86815A482951AF12B5153611", hash_generated_method = "323AEFAE26ABE7476606E0579F7DA7AD")
        
public IntentBuilder addEmailBcc(String address) {
            if (mBccAddresses == null) {
                mBccAddresses = new ArrayList<String>();
            }
            mBccAddresses.add(address);
            return this;
        }

        /**
         * Add an array of email addresses to be used in the "bcc" field of the final Intent.
         *
         * @param addresses Email addresses to BCC
         * @return This IntentBuilder for method chaining
         * @see Intent#EXTRA_BCC
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.389 -0500", hash_original_method = "A108079E5E05347E55233C38CDE39CC2", hash_generated_method = "D279473EBF81038F9DC25495EDF87DAE")
        
public IntentBuilder addEmailBcc(String[] addresses) {
            combineArrayExtra(Intent.EXTRA_BCC, addresses);
            return this;
        }

        /**
         * Set a subject heading for this share; useful for sharing via email.
         *
         * @param subject Subject heading for this share
         * @return This IntentBuilder for method chaining
         * @see Intent#EXTRA_SUBJECT
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.392 -0500", hash_original_method = "3E6F6D2B7406A417F246425C88E21422", hash_generated_method = "7F44203E37E4B5C005F052E31D98060A")
        
public IntentBuilder setSubject(String subject) {
            mIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            return this;
        }
    }

    /**
     * IntentReader is a helper for reading the data contained within a sharing (ACTION_SEND)
     * Intent. It provides methods to parse standard elements included with a share
     * in addition to extra metadata about the app that shared the content.
     *
     * <p>Social sharing apps are encouraged to provide attribution for the app that shared
     * the content. IntentReader offers access to the application label, calling activity info,
     * and application icon of the app that shared the content. This data may have been provided
     * voluntarily by the calling app and should always be displayed to the user before submission
     * for manual verification. The user should be offered the option to omit this information
     * from shared posts if desired.</p>
     *
     * <p>Activities that intend to receive sharing intents should configure an intent-filter
     * to accept {@link Intent#ACTION_SEND} intents ("android.intent.action.SEND") and optionally
     * accept {@link Intent#ACTION_SEND_MULTIPLE} ("android.intent.action.SEND_MULTIPLE") if
     * the activity is equipped to handle multiple data streams.</p>
     */
    public static class IntentReader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.449 -0500", hash_original_field = "F5B86136C466178154DDC7E3E0E75FFC", hash_generated_field = "5A3BF8AAA19780B6501556BBCFA31BAF")

        private static final String TAG = "IntentReader";

        /**
         * Get an IntentReader for parsing and interpreting the sharing intent
         * used to start the given activity.
         *
         * @param activity Activity that was started to share content
         * @return IntentReader for parsing sharing data
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.462 -0500", hash_original_method = "7FE0F8B171A704C09229DF43C94B1188", hash_generated_method = "E69BB94CD27351A71CDF48F3BBEB2262")
        
public static IntentReader from(Activity activity) {
            return new IntentReader(activity);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.452 -0500", hash_original_field = "3895D7E6DB5042DA7856DC78E391C7B9", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")

        private Activity mActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.454 -0500", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.455 -0500", hash_original_field = "224D4987D2D5DA4F4FE96381BF0B2BC2", hash_generated_field = "E9DB1E160A758DD2D7A97AC8EAD7032B")

        private String mCallingPackage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.457 -0500", hash_original_field = "49E8E19F35BD51CE2D79E207A03760CD", hash_generated_field = "9F2300B66972EC6EFB2EFE241B7A0E66")

        private ComponentName mCallingActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.459 -0500", hash_original_field = "C257DE59BDDDAB6C6845D8752A063867", hash_generated_field = "E38B530386D6624B9CC752A26937D70B")

        private ArrayList<Uri> mStreams;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.465 -0500", hash_original_method = "33DC5300860410C275910F5653E8BC84", hash_generated_method = "5775B55CB12CC5ED0D780E41080CBFF3")
        
private IntentReader(Activity activity) {
            mActivity = activity;
            mIntent = activity.getIntent();
            mCallingPackage = ShareCompat.getCallingPackage(activity);
            mCallingActivity = ShareCompat.getCallingActivity(activity);
        }

        /**
         * Returns true if the activity this reader was obtained for was
         * started with an {@link Intent#ACTION_SEND} or {@link Intent#ACTION_SEND_MULTIPLE}
         * sharing Intent.
         *
         * @return true if the activity was started with an ACTION_SEND
         *         or ACTION_SEND_MULTIPLE Intent
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.467 -0500", hash_original_method = "01AA9E38E47C737A64F826A2FC6824A5", hash_generated_method = "0C4D62F6F260A46AA1632EA8744B0D5B")
        
public boolean isShareIntent() {
            final String action = mIntent.getAction();
            return Intent.ACTION_SEND.equals(action) || Intent.ACTION_SEND_MULTIPLE.equals(action);
        }

        /**
         * Returns true if the activity this reader was obtained for was started with an
         * {@link Intent#ACTION_SEND} intent and contains a single shared item.
         * The shared content should be obtained using either the {@link #getText()}
         * or {@link #getStream()} methods depending on the type of content shared.
         *
         * @return true if the activity was started with an ACTION_SEND intent
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.469 -0500", hash_original_method = "788469D7483B5EA75544E04461865917", hash_generated_method = "B3D3C4B5BD012A372E5D66882571A4CC")
        
public boolean isSingleShare() {
            return Intent.ACTION_SEND.equals(mIntent.getAction());
        }

        /**
         * Returns true if the activity this reader was obtained for was started with an
         * {@link Intent#ACTION_SEND_MULTIPLE} intent. The Intent may contain more than
         * one stream item.
         *
         * @return true if the activity was started with an ACTION_SEND_MULTIPLE intent
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.472 -0500", hash_original_method = "220CAE272FCF85686BA0D747BFA1F020", hash_generated_method = "836B9C9681444B45A8E43EEFF3D5838D")
        
public boolean isMultipleShare() {
            return Intent.ACTION_SEND_MULTIPLE.equals(mIntent.getAction());
        }

        /**
         * Get the mimetype of the data shared to this activity.
         *
         * @return mimetype of the shared data
         * @see Intent#getType()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.475 -0500", hash_original_method = "D2D116B363ACAF23E5ABAEA8317A2D07", hash_generated_method = "BDC41F8ACB343C6DCD4EF1ED5F3844CC")
        
public String getType() {
            return mIntent.getType();
        }

        /**
         * Get the literal text shared with the target activity.
         *
         * @return Literal shared text or null if none was supplied
         * @see Intent#EXTRA_TEXT
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.476 -0500", hash_original_method = "001799CDC7AD568A5D9791D68F82B19E", hash_generated_method = "612F6C83360DF6BC27D03BD4219E1CCA")
        
public CharSequence getText() {
            return mIntent.getCharSequenceExtra(Intent.EXTRA_TEXT);
        }

        /**
         * Get the styled HTML text shared with the target activity.
         * If no HTML text was supplied but {@link Intent#EXTRA_TEXT} contained
         * styled text, it will be converted to HTML if possible and returned.
         * If the text provided by {@link Intent#EXTRA_TEXT} was not styled text,
         * it will be escaped by {@link android.text.Html#escapeHtml(CharSequence)}
         * and returned. If no text was provided at all, this method will return null.
         *
         * @return Styled text provided by the sender as HTML.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:07.659 -0400", hash_original_method = "8652E338C4A88405737C54A4668CF0A3", hash_generated_method = "213BE65D5163C843D0FBA85791CB83A9")
            
public String getHtmlText() {
            String result = mIntent.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (result == null) {
                CharSequence text = getText();
                if (text instanceof Spanned) {
                    result = Html.toHtml((Spanned) text);
                } else if (text != null) {
                    result = IMPL.escapeHtml(text);
                }
            }
            return result;
        }

        /**
         * Get a URI referring to a data stream shared with the target activity.
         *
         * <p>This call will fail if the share intent contains multiple stream items.
         * If {@link #isMultipleShare()} returns true the application should use
         * {@link #getStream(int)} and {@link #getStreamCount()} to retrieve the
         * included stream items.</p>
         *
         * @return A URI referring to a data stream to be shared or null if one was not supplied
         * @see Intent#EXTRA_STREAM
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.480 -0500", hash_original_method = "6766C6C36607D95201A80937E1C93C5B", hash_generated_method = "599EC9A2C4B8125E3863FC593ED4A47A")
        
public Uri getStream() {
            return mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
        }

        /**
         * Get the URI of a stream item shared with the target activity.
         * Index should be in the range [0-getStreamCount()).
         *
         * @param index Index of text item to retrieve
         * @return Requested stream item URI
         * @see Intent#EXTRA_STREAM
         * @see Intent#ACTION_SEND_MULTIPLE
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.483 -0500", hash_original_method = "CA16C800A8BACDD493D26B5DCB8F6704", hash_generated_method = "09C912CC601590D0148CE20111F1816E")
        
public Uri getStream(int index) {
            if (mStreams == null && isMultipleShare()) {
                mStreams = mIntent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
            }
            if (mStreams != null) {
                return mStreams.get(index);
            }
            if (index == 0) {
                return mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
            }
            throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() +
                    " index requested: " + index);
        }

        /**
         * Return the number of stream items shared. The return value will be 0 or 1 if
         * this was an {@link Intent#ACTION_SEND} intent, or 0 or more if it was an
         * {@link Intent#ACTION_SEND_MULTIPLE} intent.
         *
         * @return Count of text items contained within the Intent
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.486 -0500", hash_original_method = "BC61684682118C8B50538A4E9628C32B", hash_generated_method = "6AD32AA0F1C5BE459432F591E855460F")
        
public int getStreamCount() {
            if (mStreams == null && isMultipleShare()) {
                mStreams = mIntent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
            }
            if (mStreams != null) {
                return mStreams.size();
            }
            return mIntent.hasExtra(Intent.EXTRA_STREAM) ? 1 : 0;
        }

        /**
         * Get an array of Strings, each an email address to share to.
         *
         * @return An array of email addresses or null if none were supplied.
         * @see Intent#EXTRA_EMAIL
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.489 -0500", hash_original_method = "D1879246F5FB4411F3E91A8AEB3C384C", hash_generated_method = "405CB65589FCC7447262038B8BC2E0E9")
        
public String[] getEmailTo() {
            return mIntent.getStringArrayExtra(Intent.EXTRA_EMAIL);
        }

        /**
         * Get an array of Strings, each an email address to CC on this share.
         *
         * @return An array of email addresses or null if none were supplied.
         * @see Intent#EXTRA_CC
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.491 -0500", hash_original_method = "F2F2C05F2171316000FF1516A5D8CD3A", hash_generated_method = "7E7DA9E67BC87F20A9058E179392FD64")
        
public String[] getEmailCc() {
            return mIntent.getStringArrayExtra(Intent.EXTRA_CC);
        }

        /**
         * Get an array of Strings, each an email address to BCC on this share.
         *
         * @return An array of email addresses or null if none were supplied.
         * @see Intent#EXTRA_BCC
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.493 -0500", hash_original_method = "8B48BB50B06FCBCC280D77A42BA7B009", hash_generated_method = "5246431C797BBF02EC3C81FC755DBBD6")
        
public String[] getEmailBcc() {
            return mIntent.getStringArrayExtra(Intent.EXTRA_BCC);
        }

        /**
         * Get a subject heading for this share; useful when sharing via email.
         *
         * @return The subject heading for this share or null if one was not supplied.
         * @see Intent#EXTRA_SUBJECT
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.496 -0500", hash_original_method = "1E0DCEAE4F7F7EF81C98D4CC969955D0", hash_generated_method = "776F9F50EEAF986E86448A2B2776D620")
        
public String getSubject() {
            return mIntent.getStringExtra(Intent.EXTRA_SUBJECT);
        }

        /**
         * Get the name of the package that invoked this sharing intent. If the activity
         * was not started for a result, IntentBuilder will read this from extra metadata placed
         * in the Intent by ShareBuilder.
         *
         * <p><em>Note:</em> This data may have been provided voluntarily by the calling
         * application. As such it should not be trusted for accuracy in the context of
         * security or verification.</p>
         *
         * @return Name of the package that started this activity or null if unknown
         * @see Activity#getCallingPackage()
         * @see ShareCompat#EXTRA_CALLING_PACKAGE
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.498 -0500", hash_original_method = "599A2909147C5ABF7649B275042032E0", hash_generated_method = "03D0C2AD21B86869EC315D42DF586D42")
        
public String getCallingPackage() {
            return mCallingPackage;
        }

        /**
         * Get the {@link ComponentName} of the Activity that invoked this sharing intent.
         * If the target sharing activity was not started for a result, IntentBuilder will read
         * this from extra metadata placed in the intent by ShareBuilder.
         *
         * <p><em>Note:</em> This data may have been provided voluntarily by the calling
         * application. As such it should not be trusted for accuracy in the context of
         * security or verification.</p>
         *
         * @return ComponentName of the calling Activity or null if unknown
         * @see Activity#getCallingActivity()
         * @see ShareCompat#EXTRA_CALLING_ACTIVITY
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.499 -0500", hash_original_method = "7754B7141829C06037743B2AEFCB8100", hash_generated_method = "148394659C8308B7B75EC146E1C66685")
        
public ComponentName getCallingActivity() {
            return mCallingActivity;
        }

        /**
         * Get the icon of the calling activity as a Drawable if data about
         * the calling activity is available.
         *
         * <p><em>Note:</em> This data may have been provided voluntarily by the calling
         * application. As such it should not be trusted for accuracy in the context of
         * security or verification.</p>
         *
         * @return The calling Activity's icon or null if unknown
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.502 -0500", hash_original_method = "DF0726DEBD67610C86B101B05D0C636E", hash_generated_method = "AF44F4D4FEE1F93488A0131EC0CEA1BD")
        
public Drawable getCallingActivityIcon() {
            if (mCallingActivity == null) return null;

            PackageManager pm = mActivity.getPackageManager();
            try {
                return pm.getActivityIcon(mCallingActivity);
            } catch (NameNotFoundException e) {
                Log.e(TAG, "Could not retrieve icon for calling activity", e);
            }
            return null;
        }

        /**
         * Get the icon of the calling application as a Drawable if data
         * about the calling package is available.
         *
         * <p><em>Note:</em> This data may have been provided voluntarily by the calling
         * application. As such it should not be trusted for accuracy in the context of
         * security or verification.</p>
         *
         * @return The calling application's icon or null if unknown
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.505 -0500", hash_original_method = "CF72ECE57DC07F413BA6AAECB91EABC0", hash_generated_method = "B88C632F70F717C7001C38896B64413A")
        
public Drawable getCallingApplicationIcon() {
            if (mCallingPackage == null) return null;

            PackageManager pm = mActivity.getPackageManager();
            try {
                return pm.getApplicationIcon(mCallingPackage);
            } catch (NameNotFoundException e) {
                Log.e(TAG, "Could not retrieve icon for calling application", e);
            }
            return null;
        }

        /**
         * Get the human-readable label (title) of the calling application if
         * data about the calling package is available.
         *
         * <p><em>Note:</em> This data may have been provided voluntarily by the calling
         * application. As such it should not be trusted for accuracy in the context of
         * security or verification.</p>
         *
         * @return The calling application's label or null if unknown
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:02.508 -0500", hash_original_method = "F45DE27FE2614ABFE05276FFE92A1DFC", hash_generated_method = "A364E198E898F6366B9ACD09E5E0DC35")
        
public CharSequence getCallingApplicationLabel() {
            if (mCallingPackage == null) return null;

            PackageManager pm = mActivity.getPackageManager();
            try {
                return pm.getApplicationLabel(pm.getApplicationInfo(mCallingPackage, 0));
            } catch (NameNotFoundException e) {
                Log.e(TAG, "Could not retrieve label for calling application", e);
            }
            return null;
        }
    }

    static class ShareCompatImplJB extends ShareCompatImplICS {
        @DSSafe(DSCat.SAFE_LIST)
        public String escapeHtml(CharSequence html) {
            return ShareCompatJB.escapeHtml(html);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        boolean shouldAddChooserIntent(MenuItem item) {
            return false;
        }
    }}
