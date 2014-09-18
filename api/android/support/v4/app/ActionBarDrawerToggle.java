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


package android.support.v4.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;

/**
 * This class provides a handy way to tie together the functionality of
 * {@link DrawerLayout} and the framework <code>ActionBar</code> to implement the recommended
 * design for navigation drawers.
 *
 * <p>To use <code>ActionBarDrawerToggle</code>, create one in your Activity and call through
 * to the following methods corresponding to your Activity callbacks:</p>
 *
 * <ul>
 * <li>{@link Activity#onConfigurationChanged(android.content.res.Configuration) onConfigurationChanged}</li>
 * <li>{@link Activity#onOptionsItemSelected(android.view.MenuItem) onOptionsItemSelected}</li>
 * </ul>
 *
 * <p>Call {@link #syncState()} from your <code>Activity</code>'s
 * {@link Activity#onPostCreate(android.os.Bundle) onPostCreate} to synchronize the indicator
 * with the state of the linked DrawerLayout after <code>onRestoreInstanceState</code>
 * has occurred.</p>
 *
 * <p><code>ActionBarDrawerToggle</code> can be used directly as a
 * {@link DrawerLayout.DrawerListener}, or if you are already providing your own listener,
 * call through to each of the listener methods from your own.</p>
 */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /**
     * Allows an implementing Activity to return an {@link ActionBarDrawerToggle.Delegate} to use
     * with ActionBarDrawerToggle.
     */
    public interface DelegateProvider {

        /**
         * @return Delegate to use for ActionBarDrawableToggles, or null if the Activity
         *         does not wish to override the default behavior.
         */
        Delegate getDrawerToggleDelegate();
    }

    public interface Delegate {
        /**
         * @return Up indicator drawable as defined in the Activity's theme, or null if one is not
         *         defined.
         */
        Drawable getThemeUpIndicator();

        /**
         * Set the Action Bar's up indicator drawable and content description.
         *
         * @param upDrawable     - Drawable to set as up indicator
         * @param contentDescRes - Content description to set
         */
        void setActionBarUpIndicator(Drawable upDrawable, int contentDescRes);

        /**
         * Set the Action Bar's up indicator content description.
         *
         * @param contentDescRes - Content description to set
         */
        void setActionBarDescription(int contentDescRes);
    }

    private interface ActionBarDrawerToggleImpl {
        Drawable getThemeUpIndicator(Activity activity);
        Object setActionBarUpIndicator(Object info, Activity activity,
                Drawable themeImage, int contentDescRes);
        Object setActionBarDescription(Object info, Activity activity, int contentDescRes);
    }

    private static class ActionBarDrawerToggleImplBase implements ActionBarDrawerToggleImpl {
        @Override
        public Drawable getThemeUpIndicator(Activity activity) {
            return null;
        }

        @Override
        public Object setActionBarUpIndicator(Object info, Activity activity,
                Drawable themeImage, int contentDescRes) {
            // No action bar to set.
            return info;
        }

        @Override
        public Object setActionBarDescription(Object info, Activity activity, int contentDescRes) {
            // No action bar to set
            return info;
        }
    }

    private static class ActionBarDrawerToggleImplHC implements ActionBarDrawerToggleImpl {
        @Override
        public Drawable getThemeUpIndicator(Activity activity) {
            return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(activity);
        }

        @Override
        public Object setActionBarUpIndicator(Object info, Activity activity,
                Drawable themeImage, int contentDescRes) {
            return ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(info, activity,
                    themeImage, contentDescRes);
        }

        @Override
        public Object setActionBarDescription(Object info, Activity activity, int contentDescRes) {
            return ActionBarDrawerToggleHoneycomb.setActionBarDescription(info, activity,
                    contentDescRes);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.011 -0400", hash_original_field = "B1E05DA9C0B3267881234761F35BD45F", hash_generated_field = "1947D028D473DD83F77FF25317C6AC36")


    private static  ActionBarDrawerToggleImpl IMPL;

    static {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 11) {
            IMPL = new ActionBarDrawerToggleImplHC();
        } else {
            IMPL = new ActionBarDrawerToggleImplBase();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.028 -0400", hash_original_field = "651704DE753CE94762E43A45BC531521", hash_generated_field = "3B473CFDE5FF8C1CAEA257D23ED0A447")

    private static final float TOGGLE_DRAWABLE_OFFSET = 1 / 3f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.037 -0400", hash_original_field = "201F33C828CB9360D2B9DAE98531E3BE", hash_generated_field = "6F4A02881764ECF93BE6B6D88D39DAF8")

    private static final int ID_HOME = 0x0102002c;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.047 -0400", hash_original_field = "3895D7E6DB5042DA7856DC78E391C7B9", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")


    private  Activity mActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.056 -0400", hash_original_field = "07AA41DDB06792E11D2F341513D1A63D", hash_generated_field = "0DF99808E094AF85B200A9B5C5B07AE4")

    private  Delegate mActivityImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.065 -0400", hash_original_field = "D2EBD89C73260AB799E0B396A47CD579", hash_generated_field = "6896E4AFD20A1B2A1A04F9BC477CE269")

    private  DrawerLayout mDrawerLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.079 -0400", hash_original_field = "308917CE705C104E7A6DFE94AFD736D0", hash_generated_field = "13625B53BAEEAAFAB4AACC063A1B1B1D")

    private boolean mDrawerIndicatorEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.091 -0400", hash_original_field = "C3248EDB6CDCDC3E6E2E80772639C1FE", hash_generated_field = "FBF530CA62FFC67F072CA02CB0CD2A98")


    private Drawable mThemeImage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.101 -0400", hash_original_field = "786E4E213392CA199F578746A541D47C", hash_generated_field = "3DDBFDF1A727ED49E22E59E412581D69")

    private Drawable mDrawerImage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.113 -0400", hash_original_field = "EC4A379F496FF762D557B2E535E9830B", hash_generated_field = "2B7554A048AD3AC7E4766518ABAD1E2F")

    private SlideDrawable mSlider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.121 -0400", hash_original_field = "206F4C301E13544C05D35A966617CF92", hash_generated_field = "F1451EF24209623E075CEE6C868B5074")

    private  int mDrawerImageResource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.128 -0400", hash_original_field = "A384E8509594544705F79607711C447B", hash_generated_field = "8A8153A9E75C2F6A1C76263A7F24D253")

    private  int mOpenDrawerContentDescRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.139 -0400", hash_original_field = "6662F8F35C39347516C54D3027AAC8D9", hash_generated_field = "C2847167F7A7DF016BABA56D6AC51C55")

    private  int mCloseDrawerContentDescRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.149 -0400", hash_original_field = "B10CB30F27EFAE2B851C46D7201A9C5F", hash_generated_field = "5C56AE7305E210DA44B07FC3B9C6EEA2")


    private Object mSetIndicatorInfo;

    /**
     * Construct a new ActionBarDrawerToggle.
     *
     * <p>The given {@link Activity} will be linked to the specified {@link DrawerLayout}.
     * The provided drawer indicator drawable will animate slightly off-screen as the drawer
     * is opened, indicating that in the open state the drawer will move off-screen when pressed
     * and in the closed state the drawer will move on-screen when pressed.</p>
     *
     * <p>String resources must be provided to describe the open/close drawer actions for
     * accessibility services.</p>
     *
     * @param activity The Activity hosting the drawer
     * @param drawerLayout The DrawerLayout to link to the given Activity's ActionBar
     * @param drawerImageRes A Drawable resource to use as the drawer indicator
     * @param openDrawerContentDescRes A String resource to describe the "open drawer" action
     *                                 for accessibility
     * @param closeDrawerContentDescRes A String resource to describe the "close drawer" action
     *                                  for accessibility
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.166 -0400", hash_original_method = "1812869234787BA49B4300F56CDD7E62", hash_generated_method = "55BCC7D82B52E237A202E6679C9C0273")
                
public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout,
            int drawerImageRes, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
        mActivity = activity;

        // Allow the Activity to provide an impl
        if (activity instanceof DelegateProvider) {
            mActivityImpl = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            mActivityImpl = null;
        }

        mDrawerLayout = drawerLayout;
        mDrawerImageResource = drawerImageRes;
        mOpenDrawerContentDescRes = openDrawerContentDescRes;
        mCloseDrawerContentDescRes = closeDrawerContentDescRes;

        mThemeImage = getThemeUpIndicator();
        mDrawerImage = activity.getResources().getDrawable(drawerImageRes);
        mSlider = new SlideDrawable(mDrawerImage);
        mSlider.setOffset(TOGGLE_DRAWABLE_OFFSET);
    }

    /**
     * Synchronize the state of the drawer indicator/affordance with the linked DrawerLayout.
     *
     * <p>This should be called from your <code>Activity</code>'s
     * {@link Activity#onPostCreate(android.os.Bundle) onPostCreate} method to synchronize after
     * the DrawerLayout's instance state has been restored, and any other time when the state
     * may have diverged in such a way that the ActionBarDrawerToggle was not notified.
     * (For example, if you stop forwarding appropriate drawer events for a period of time.)</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.176 -0400", hash_original_method = "925D87B60FB18100ACD88BE41DF08165", hash_generated_method = "BE04B474BF198682EF3757043DAF9944")
                
public void syncState() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mSlider.setPosition(1);
        } else {
            mSlider.setPosition(0);
        }

        if (mDrawerIndicatorEnabled) {
            setActionBarUpIndicator(mSlider, mDrawerLayout.isDrawerOpen(GravityCompat.START) ?
                    mCloseDrawerContentDescRes : mOpenDrawerContentDescRes);
        }
    }

    /**
     * Enable or disable the drawer indicator. The indicator defaults to enabled.
     *
     * <p>When the indicator is disabled, the <code>ActionBar</code> will revert to displaying
     * the home-as-up indicator provided by the <code>Activity</code>'s theme in the
     * <code>android.R.attr.homeAsUpIndicator</code> attribute instead of the animated
     * drawer glyph.</p>
     *
     * @param enable true to enable, false to disable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.187 -0400", hash_original_method = "8DF8797335CE78DB0FB6CD917AFE4B5A", hash_generated_method = "2131AC43DCF690E8F47AE6A677CEEC6E")
                
public void setDrawerIndicatorEnabled(boolean enable) {
        if (enable != mDrawerIndicatorEnabled) {
            if (enable) {
                setActionBarUpIndicator(mSlider, mDrawerLayout.isDrawerOpen(GravityCompat.START) ?
                        mCloseDrawerContentDescRes : mOpenDrawerContentDescRes);
            } else {
                setActionBarUpIndicator(mThemeImage, 0);
            }
            mDrawerIndicatorEnabled = enable;
        }
    }

    /**
     * @return true if the enhanced drawer indicator is enabled, false otherwise
     * @see #setDrawerIndicatorEnabled(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.194 -0400", hash_original_method = "7C4770F9C54054552DEFD1107D276854", hash_generated_method = "232D0B72388DD38D848DADE1002EB0D2")
                
public boolean isDrawerIndicatorEnabled() {
        return mDrawerIndicatorEnabled;
    }

    /**
     * This method should always be called by your <code>Activity</code>'s
     * {@link Activity#onConfigurationChanged(android.content.res.Configuration) onConfigurationChanged}
     * method.
     *
     * @param newConfig The new configuration
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.202 -0400", hash_original_method = "55ECAFE0046581AC45518A9BB26E12FA", hash_generated_method = "272901F33E613592079EFC3E3546077E")
                
public void onConfigurationChanged(Configuration newConfig) {
        // Reload drawables that can change with configuration
        mThemeImage = getThemeUpIndicator();
        mDrawerImage = mActivity.getResources().getDrawable(mDrawerImageResource);
        syncState();
    }

    /**
     * This method should be called by your <code>Activity</code>'s
     * {@link Activity#onOptionsItemSelected(android.view.MenuItem) onOptionsItemSelected} method.
     * If it returns true, your <code>onOptionsItemSelected</code> method should return true and
     * skip further processing.
     *
     * @param item the MenuItem instance representing the selected menu item
     * @return true if the event was handled and further processing should not occur
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.212 -0400", hash_original_method = "19A245F02D92F2FD2258C090B0C9788F", hash_generated_method = "5DB73891F4928E48913ECAC99316D3C5")
                
public boolean onOptionsItemSelected(MenuItem item) {
        if (item != null && item.getItemId() == ID_HOME && mDrawerIndicatorEnabled) {
            if (mDrawerLayout.isDrawerVisible(GravityCompat.START)) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
            } else {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
            return true;
        }
        return false;
    }

    /**
     * {@link DrawerLayout.DrawerListener} callback method. If you do not use your
     * ActionBarDrawerToggle instance directly as your DrawerLayout's listener, you should call
     * through to this method from your own listener object.
     *
     * @param drawerView The child view that was moved
     * @param slideOffset The new offset of this drawer within its range, from 0-1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.221 -0400", hash_original_method = "D1D263AC5E5D2A557BB570BCD198E93E", hash_generated_method = "FA5199665AD0A33483056C95BFFADBC4")
                
@Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        float glyphOffset = mSlider.getPosition();
        if (slideOffset > 0.5f) {
            glyphOffset = Math.max(glyphOffset, Math.max(0.f, slideOffset - 0.5f) * 2);
        } else {
            glyphOffset = Math.min(glyphOffset, slideOffset * 2);
        }
        mSlider.setPosition(glyphOffset);
    }

    /**
     * {@link DrawerLayout.DrawerListener} callback method. If you do not use your
     * ActionBarDrawerToggle instance directly as your DrawerLayout's listener, you should call
     * through to this method from your own listener object.
     *
     * @param drawerView Drawer view that is now open
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.229 -0400", hash_original_method = "FF0C2A2B254D560E335AF8580E0901CF", hash_generated_method = "D9C5934FF90EE4DBADC36AAA2786B983")
                
@Override
    public void onDrawerOpened(View drawerView) {
        mSlider.setPosition(1);
        if (mDrawerIndicatorEnabled) {
            setActionBarDescription(mCloseDrawerContentDescRes);
        }
    }

    /**
     * {@link DrawerLayout.DrawerListener} callback method. If you do not use your
     * ActionBarDrawerToggle instance directly as your DrawerLayout's listener, you should call
     * through to this method from your own listener object.
     *
     * @param drawerView Drawer view that is now closed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.238 -0400", hash_original_method = "75A34173E93846776B69589B664F15EF", hash_generated_method = "D250AB88C814B1741180EB1FE6522EAC")
                
@Override
    public void onDrawerClosed(View drawerView) {
        mSlider.setPosition(0);
        if (mDrawerIndicatorEnabled) {
            setActionBarDescription(mOpenDrawerContentDescRes);
        }
    }

    /**
     * {@link DrawerLayout.DrawerListener} callback method. If you do not use your
     * ActionBarDrawerToggle instance directly as your DrawerLayout's listener, you should call
     * through to this method from your own listener object.
     * 
     * @param newState The new drawer motion state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.245 -0400", hash_original_method = "DC5390A82B0A943C7A3BF0DA55FE173F", hash_generated_method = "634B8405B399F3463A611691184BFB58")
                
@Override
    public void onDrawerStateChanged(int newState) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.252 -0400", hash_original_method = "9268C3F8728CF207561358E9A6DDC1DF", hash_generated_method = "9268C3F8728CF207561358E9A6DDC1DF")
                
Drawable getThemeUpIndicator() {
        if (mActivityImpl != null) {
            return mActivityImpl.getThemeUpIndicator();
        }
        return IMPL.getThemeUpIndicator(mActivity);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.295 -0400", hash_original_method = "9E16714F60063FF6396099FF22689690", hash_generated_method = "9E16714F60063FF6396099FF22689690")
                
void setActionBarUpIndicator(Drawable upDrawable, int contentDescRes) {
        if (mActivityImpl != null) {
            mActivityImpl.setActionBarUpIndicator(upDrawable, contentDescRes);
            return;
        }
        mSetIndicatorInfo = IMPL
                .setActionBarUpIndicator(mSetIndicatorInfo, mActivity, upDrawable, contentDescRes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:53.307 -0400", hash_original_method = "B571390A648B25B2E34394867315D38B", hash_generated_method = "B571390A648B25B2E34394867315D38B")
                
void setActionBarDescription(int contentDescRes) {
        if (mActivityImpl != null) {
            mActivityImpl.setActionBarDescription(contentDescRes);
            return;
        }
        mSetIndicatorInfo = IMPL
                .setActionBarDescription(mSetIndicatorInfo, mActivity, contentDescRes);
    }

    private class SlideDrawable extends InsetDrawable implements Drawable.Callback {
        private final boolean mHasMirroring = Build.VERSION.SDK_INT > 18;
        private final Rect mTmpRect = new Rect();

        private float mPosition;
        private float mOffset;

        private SlideDrawable(Drawable wrapped) {
            super(wrapped, 0);
        }

        /**
         * Sets the current position along the offset.
         *
         * @param position a value between 0 and 1
         */
        public void setPosition(float position) {
            mPosition = position;
            invalidateSelf();
        }

        public float getPosition() {
            return mPosition;
        }

        /**
         * Specifies the maximum offset when the position is at 1.
         *
         * @param offset maximum offset as a fraction of the drawable width,
         *            positive to shift left or negative to shift right.
         * @see #setPosition(float)
         */
        public void setOffset(float offset) {
            mOffset = offset;
            invalidateSelf();
        }

        @Override
        public void draw(Canvas canvas) {
            copyBounds(mTmpRect);
            canvas.save();

            // Layout direction must be obtained from the activity.
            final boolean isLayoutRTL = ViewCompat.getLayoutDirection(
                    mActivity.getWindow().getDecorView()) == ViewCompat.LAYOUT_DIRECTION_RTL;
            final int flipRtl = isLayoutRTL ? -1 : 1;
            final int width = mTmpRect.width();
            canvas.translate(-mOffset * width * mPosition * flipRtl, 0);

            // Force auto-mirroring if it's not supported by the platform.
            if (isLayoutRTL && !mHasMirroring) {
                canvas.translate(width, 0);
                canvas.scale(-1, 1);
            }

            super.draw(canvas);
            canvas.restore();
        }
    }
}
