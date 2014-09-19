/*
 * Copyright (C) 2012 The Android Open Source Project
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

package android.support.v7.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.SpinnerAdapter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

class ActionBarImplICS extends ActionBar {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.742 -0400", hash_original_field = "3895D7E6DB5042DA7856DC78E391C7B9", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")


     Activity mActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.745 -0400", hash_original_field = "1A99E72B6409E38FBCC780D1BAB4898D", hash_generated_field = "1A99E72B6409E38FBCC780D1BAB4898D")

     Callback mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.747 -0400", hash_original_field = "AED285F334BBCD80E9997E08F9D22C91", hash_generated_field = "AED285F334BBCD80E9997E08F9D22C91")

     android.app.ActionBar mActionBar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.750 -0400", hash_original_field = "D2E19D14FDADE5D018AD2F3C77C1F429", hash_generated_field = "D2E19D14FDADE5D018AD2F3C77C1F429")


    FragmentTransaction mActiveTransaction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.754 -0400", hash_original_field = "E5861789EA8B3531B9EAC9EA941B33F2", hash_generated_field = "F9EBE3D353C17D513BCB5354456036B4")


    private ArrayList<WeakReference<OnMenuVisibilityListenerWrapper>> mAddedMenuVisWrappers =
            new ArrayList<WeakReference<OnMenuVisibilityListenerWrapper>>();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.757 -0400", hash_original_method = "E5CDBB13D3559D8F8555E67E3C353270", hash_generated_method = "E3F0264EC64962AD2879E080822D6F25")
    
public ActionBarImplICS(Activity activity, Callback callback) {
        this(activity, callback, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.762 -0400", hash_original_method = "DCCB038E354C59ACDE4FB92F01856CB9", hash_generated_method = "848D63B8EB61839531FB384BFA7CE3E1")
    
ActionBarImplICS(Activity activity, Callback callback, boolean checkHomeAsUpOption) {
        mActivity = activity;
        mCallback = callback;
        mActionBar = activity.getActionBar();

        if (checkHomeAsUpOption) {
            // In v4.1+, if the the 'homeAsUp' display flag was set then the Home Button is enabled.
            // We need to replicate this functionality on ICS.
            if ((getDisplayOptions() & ActionBar.DISPLAY_HOME_AS_UP) != 0) {
                setHomeButtonEnabled(true);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.765 -0400", hash_original_method = "AECEAC10E4E2456C79D087B439EF5B81", hash_generated_method = "A89328F52AA60A23E302E15702606F8B")
    
private OnMenuVisibilityListenerWrapper findAndRemoveMenuVisWrapper(
            OnMenuVisibilityListener compatListener) {
        for (int i = 0; i < mAddedMenuVisWrappers.size(); i++) {
            OnMenuVisibilityListenerWrapper wrapper = mAddedMenuVisWrappers.get(i).get();
            if (wrapper == null) {
                mAddedMenuVisWrappers.remove(i--);
            } else if (wrapper.mWrappedListener == compatListener) {
                mAddedMenuVisWrappers.remove(i);
                return wrapper;
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.768 -0400", hash_original_method = "ED923076085A81A64F1D880B408F7912", hash_generated_method = "1099D2B919D305237691C310622692E1")
    
@Override
    public void setCustomView(View view) {
        mActionBar.setCustomView(view);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.771 -0400", hash_original_method = "C4A73675A3A959B3915F2EC47B3D33E0", hash_generated_method = "EE3F519E9F9237F0AB8CB03A54728A7A")
    
@Override
    public void setCustomView(View view, LayoutParams layoutParams) {
        android.app.ActionBar.LayoutParams lp =
                new android.app.ActionBar.LayoutParams(layoutParams);
        lp.gravity = layoutParams.gravity;

        mActionBar.setCustomView(view, lp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.774 -0400", hash_original_method = "163871649CCC5A60F5E9347CCAFE5D13", hash_generated_method = "487706105DD6673C50E4F13C3FA8FE9E")
    
@Override
    public void setCustomView(int resId) {
        mActionBar.setCustomView(resId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.778 -0400", hash_original_method = "6F38A62260126B3C7E4E9F6C523D4B38", hash_generated_method = "49B05013F03B14E934F2792BC304BE1E")
    
@Override
    public void setIcon(int resId) {
        mActionBar.setIcon(resId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.781 -0400", hash_original_method = "F5EC6E3533FED90C9176331E6B78F1E7", hash_generated_method = "A16D05733200F06B5913861A5AA3C59D")
    
@Override
    public void setIcon(Drawable icon) {
        mActionBar.setIcon(icon);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.783 -0400", hash_original_method = "45BF2310D3107466971E7A5143B02068", hash_generated_method = "D600BC590D0E129C55E952EB353CEE11")
    
@Override
    public void setLogo(int resId) {
        mActionBar.setLogo(resId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.786 -0400", hash_original_method = "6EAB55AA8975D42566A5BADA986A79AE", hash_generated_method = "90DDAF581AB54DCF4808F1120AED9630")
    
@Override
    public void setLogo(Drawable logo) {
        mActionBar.setLogo(logo);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.790 -0400", hash_original_method = "615564F955A5AC3923BC2D4060950076", hash_generated_method = "D5DBCEC8F21874BB2BA04123402260AA")
    
@Override
    public void setListNavigationCallbacks(SpinnerAdapter adapter, OnNavigationListener callback) {
        mActionBar.setListNavigationCallbacks(adapter,
                callback != null ? new OnNavigationListenerWrapper(callback) : null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.792 -0400", hash_original_method = "B587B7539CDF897E2D57D36BF46C2BFB", hash_generated_method = "DEDC9C2C771D10E0C57845BD2192F8F9")
    
@Override
    public void setSelectedNavigationItem(int position) {
        mActionBar.setSelectedNavigationItem(position);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.795 -0400", hash_original_method = "D9CD3AB5625D33601B7975A99A875C87", hash_generated_method = "3D63B4601A6D6956E98DDCEB866D116F")
    
@Override
    public int getSelectedNavigationIndex() {
        return mActionBar.getSelectedNavigationIndex();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.798 -0400", hash_original_method = "5C5F542D33C3131FDFE07A196192F9C7", hash_generated_method = "9BD5F4A629E182BBD3E8C327A1E57449")
    
@Override
    public int getNavigationItemCount() {
        return mActionBar.getNavigationItemCount();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.802 -0400", hash_original_method = "2DEFF47283A8BC80FA6690E02C7E17D2", hash_generated_method = "447434A3E50744218F1312FCE1D54AC3")
    
@Override
    public void setTitle(CharSequence title) {
        mActionBar.setTitle(title);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.805 -0400", hash_original_method = "F2AEFC93E19BFC2EE6D79CAC8D637ED3", hash_generated_method = "D4753FDB1478CAC8F059AFE8D6CADBCE")
    
@Override
    public void setTitle(int resId) {
        mActionBar.setTitle(resId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.808 -0400", hash_original_method = "9D644D6398FF877346FA6C8C686C770A", hash_generated_method = "0C0CC258E0CB716FA9BEC2AC2E8D44FE")
    
@Override
    public void setSubtitle(CharSequence subtitle) {
        mActionBar.setSubtitle(subtitle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.811 -0400", hash_original_method = "083EC752AF6D67DD073632FCAC31E408", hash_generated_method = "A3103C029DAE0C1E4DF3B6908F9DB9DF")
    
@Override
    public void setSubtitle(int resId) {
        mActionBar.setSubtitle(resId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.814 -0400", hash_original_method = "91A8D4DB11374863B7F0E669733A1AAF", hash_generated_method = "7C6915C00D14FFE9094703DC3F714469")
    
@Override
    public void setDisplayOptions(int options) {
        mActionBar.setDisplayOptions(options);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.817 -0400", hash_original_method = "C0F52C3CD09876336D1EE49B3E4A6677", hash_generated_method = "F1B2FEC472005050A09B68C99C5CF4F9")
    
@Override
    public void setDisplayOptions(int options, int mask) {
        mActionBar.setDisplayOptions(options, mask);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.820 -0400", hash_original_method = "22A8ECB22E2B96B9F2B33225DAA79CB9", hash_generated_method = "9310F624140F8455AC439FA6A5780DDD")
    
@Override
    public void setDisplayUseLogoEnabled(boolean useLogo) {
        mActionBar.setDisplayUseLogoEnabled(useLogo);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.823 -0400", hash_original_method = "6ACCC95C0DB269F83DA981C85FCBC1B1", hash_generated_method = "3F4A6311026AD3DCABEA11CD28E17F62")
    
@Override
    public void setDisplayShowHomeEnabled(boolean showHome) {
        mActionBar.setDisplayShowHomeEnabled(showHome);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.826 -0400", hash_original_method = "1DAC5BB439098F90687A0676FB237A56", hash_generated_method = "B02CE03DF1B4213A646BCFB54B54A529")
    
@Override
    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        mActionBar.setDisplayHomeAsUpEnabled(showHomeAsUp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.829 -0400", hash_original_method = "5F62CFAAAD5C2B4D37D255F16DA47C35", hash_generated_method = "02A66FDC91C1B775DC84D3E34C974894")
    
@Override
    public void setDisplayShowTitleEnabled(boolean showTitle) {
        mActionBar.setDisplayShowTitleEnabled(showTitle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.833 -0400", hash_original_method = "054524DB32C6A58AAEEA43E63A8F9711", hash_generated_method = "183C2265B1511DDCD4DCC7AF9CAE3B2F")
    
@Override
    public void setDisplayShowCustomEnabled(boolean showCustom) {
        mActionBar.setDisplayShowCustomEnabled(showCustom);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.836 -0400", hash_original_method = "7C733F2026BB5731DF727D2026F8BC66", hash_generated_method = "DF34BF75BA7510B58E198864513D2C72")
    
@Override
    public void setBackgroundDrawable(Drawable d) {
        mActionBar.setBackgroundDrawable(d);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.839 -0400", hash_original_method = "3B3980C6BDBDDBDB8181F4D70B5BF0D1", hash_generated_method = "B7F665380835B2478AC365500864E09D")
    
@Override
    public View getCustomView() {
        return mActionBar.getCustomView();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.842 -0400", hash_original_method = "670AE556EB20FBE26197DB59B772D5D5", hash_generated_method = "8C993CB7F9299A99B71D85D09929AAC1")
    
@Override
    public CharSequence getTitle() {
        return mActionBar.getTitle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.845 -0400", hash_original_method = "395CAA794D6C3C417FF2EF461B9F1A24", hash_generated_method = "45EC92CA1AF8FEA9F289A223E2401B66")
    
@Override
    public CharSequence getSubtitle() {
        return mActionBar.getSubtitle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.848 -0400", hash_original_method = "DF916A128BCF177B8A4CCE912CDE87E8", hash_generated_method = "F5E72E6E11D80BCB575F3E764A0AED76")
    
@Override
    public int getNavigationMode() {
        return mActionBar.getNavigationMode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.851 -0400", hash_original_method = "CBFED6795234A62490D34938E8B7A5CE", hash_generated_method = "A7AA9B050535A588FF06100A82B5DDD6")
    
@Override
    public void setNavigationMode(int mode) {
        mActionBar.setNavigationMode(mode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.853 -0400", hash_original_method = "E0C435B12AC7CE6DC0C907E4E78C8E06", hash_generated_method = "39EFB7B8BB7B0C001A884CA4B128423F")
    
@Override
    public int getDisplayOptions() {
        return mActionBar.getDisplayOptions();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.857 -0400", hash_original_method = "958F5753293323474D92520B5E979BD8", hash_generated_method = "E8AF3E855C564CC450D166B40121DD02")
    
@Override
    public Tab newTab() {
        final android.app.ActionBar.Tab realTab = mActionBar.newTab();
        final TabWrapper result = new TabWrapper(realTab);
        realTab.setTag(result);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.861 -0400", hash_original_method = "E271ABD256DFBD6FA85A99383B544133", hash_generated_method = "F9EF40E5679F2C6FA6344E4C4BDDB49F")
    
@Override
    public void addTab(Tab tab) {
        mActionBar.addTab(((TabWrapper) tab).mWrappedTab);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.864 -0400", hash_original_method = "CD1362E5FDB672916EA95CB59CBE385A", hash_generated_method = "166DECAD22BD42A9355B05FC506977E9")
    
@Override
    public void addTab(Tab tab, boolean setSelected) {
        mActionBar.addTab(((TabWrapper) tab).mWrappedTab, setSelected);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.867 -0400", hash_original_method = "FF95A7C577111DC27C1E286688EF3B6D", hash_generated_method = "C282FBF71CAC3D4AD9DF645FA9FB990E")
    
@Override
    public void addTab(Tab tab, int position) {
        mActionBar.addTab(((TabWrapper) tab).mWrappedTab, position);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.871 -0400", hash_original_method = "33B7CDD0CD9064BFD52CA9E2F99948F9", hash_generated_method = "BBF76E393A9346DCF519807F076711BC")
    
@Override
    public void addTab(Tab tab, int position, boolean setSelected) {
        mActionBar.addTab(((TabWrapper) tab).mWrappedTab, position, setSelected);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.873 -0400", hash_original_method = "FCC240AE1554F71DBA8AC9A3FB82292E", hash_generated_method = "A07C477D925AB15E85B2F9D74FA5A8C8")
    
@Override
    public void removeTab(Tab tab) {
        mActionBar.removeTab(((TabWrapper) tab).mWrappedTab);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.876 -0400", hash_original_method = "3D73E434B82EFBC00DC28EC2DBB3DBAB", hash_generated_method = "DCAD03C2F8DFDA33FB398BDADA0D8ADA")
    
@Override
    public void removeTabAt(int position) {
        mActionBar.removeTabAt(position);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.879 -0400", hash_original_method = "1FBE5B81537650B93AA094CA90F3160C", hash_generated_method = "951366BA0FBEBD81234DF565173EC82B")
    
@Override
    public void removeAllTabs() {
        mActionBar.removeAllTabs();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.882 -0400", hash_original_method = "EC4E8234CF746DD95532B87A0670B2DB", hash_generated_method = "3010192CB785470BA4C71FE080B87C6B")
    
@Override
    public void selectTab(Tab tab) {
        mActionBar.selectTab(((TabWrapper) tab).mWrappedTab);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.886 -0400", hash_original_method = "D0F0C418E93038D4D3CEFAA700AE1354", hash_generated_method = "08FF879653C1B322A82A2A5FAD32F5EA")
    
@Override
    public Tab getSelectedTab() {
        return (Tab) mActionBar.getSelectedTab().getTag();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.889 -0400", hash_original_method = "C63591E0BA504037E62B99CAE60E50C9", hash_generated_method = "BE7D5979360AF4654B4BB74CC4B76FD8")
    
@Override
    public Tab getTabAt(int index) {
        return (Tab) mActionBar.getTabAt(index).getTag();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.892 -0400", hash_original_method = "435BCB954D4A482DF16D9EB4EA3A56D5", hash_generated_method = "90BF4379A91D236C955A371199F86CCB")
    
@Override
    public int getTabCount() {
        return mActionBar.getTabCount();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.894 -0400", hash_original_method = "D420260D3C2F8DD3A1A41DB51FD4F8EA", hash_generated_method = "C841DA644065B15960523C56D2E3DA28")
    
@Override
    public Context getThemedContext() {
        return mActionBar.getThemedContext();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.897 -0400", hash_original_method = "AAC2162A42FAF972EA2BC1C1D8750EA6", hash_generated_method = "8A17FD319D16A0CDBE9CC2E34E6B0BB0")
    
@Override
    public int getHeight() {
        return mActionBar.getHeight();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.899 -0400", hash_original_method = "B369FBDFEBA5134D8797B44D341BC9BE", hash_generated_method = "8A43F49B4B688F6BB5F6BC51A420BAE6")
    
@Override
    public void show() {
        mActionBar.show();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.902 -0400", hash_original_method = "76461BA9CE3855919A88A4DE3D943533", hash_generated_method = "F5AB283647694AF361BE3B4C4EF6A537")
    
@Override
    public void hide() {
        mActionBar.hide();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.905 -0400", hash_original_method = "F06CC0458DA3074FF2F81FA4141B9B99", hash_generated_method = "FAD1E518F3CB59D8D01FA9FD6BB48FD7")
    
@Override
    public boolean isShowing() {
        return mActionBar.isShowing();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.909 -0400", hash_original_method = "4DD88EFECD8E24AA1C135BA691669D3D", hash_generated_method = "0ADE494F8666DAE3DDE1BD07FD1F8175")
    
@Override
    public void addOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        if (listener != null) {
            OnMenuVisibilityListenerWrapper w = new OnMenuVisibilityListenerWrapper(listener);
            mAddedMenuVisWrappers.add(new WeakReference<OnMenuVisibilityListenerWrapper>(w));
            mActionBar.addOnMenuVisibilityListener(w);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.913 -0400", hash_original_method = "7FCAFA69353DA549AFB77CADBD7CFBA4", hash_generated_method = "8BFC1894514718C3AC97AF46DE93FD46")
    
@Override
    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        OnMenuVisibilityListenerWrapper l = findAndRemoveMenuVisWrapper(listener);
        mActionBar.removeOnMenuVisibilityListener(l);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.916 -0400", hash_original_method = "1C65ED48BADDB1C535B2D923A1B55436", hash_generated_method = "6CCF6055C8AF4BC0454BC6F152D35672")
    
@Override
    public void setHomeButtonEnabled(boolean enabled) {
        mActionBar.setHomeButtonEnabled(enabled);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.918 -0400", hash_original_method = "F43628C46C36B21713B6A781F8E846CB", hash_generated_method = "F43628C46C36B21713B6A781F8E846CB")
    
FragmentTransaction getActiveTransaction() {
        if (mActiveTransaction == null) {
            mActiveTransaction = mCallback.getSupportFragmentManager().beginTransaction()
                    .disallowAddToBackStack();
        }
        return mActiveTransaction;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.921 -0400", hash_original_method = "51586C9C77875E8DDFDEF31DF6184AD9", hash_generated_method = "51586C9C77875E8DDFDEF31DF6184AD9")
    
void commitActiveTransaction() {
        if (mActiveTransaction != null && !mActiveTransaction.isEmpty()) {
            mActiveTransaction.commit();
        }
        mActiveTransaction = null;
    }

    static class OnNavigationListenerWrapper implements android.app.ActionBar.OnNavigationListener {

        private final OnNavigationListener mWrappedListener;

        public OnNavigationListenerWrapper(OnNavigationListener l) {
            mWrappedListener = l;
        }

        @Override
        public boolean onNavigationItemSelected(int itemPosition, long itemId) {
            return mWrappedListener.onNavigationItemSelected(itemPosition, itemId);
        }

    }

    static class OnMenuVisibilityListenerWrapper implements
            android.app.ActionBar.OnMenuVisibilityListener {

        final OnMenuVisibilityListener mWrappedListener;

        public OnMenuVisibilityListenerWrapper(OnMenuVisibilityListener l) {
            mWrappedListener = l;
        }

        @Override
        public void onMenuVisibilityChanged(boolean isVisible) {
            mWrappedListener.onMenuVisibilityChanged(isVisible);
        }

    }

    class TabWrapper extends ActionBar.Tab implements android.app.ActionBar.TabListener {
        final android.app.ActionBar.Tab mWrappedTab;
        private Object mTag;
        private CharSequence mContentDescription;
        private TabListener mTabListener;

        public TabWrapper(android.app.ActionBar.Tab tab) {
            mWrappedTab = tab;
        }

        @Override
        public int getPosition() {
            return mWrappedTab.getPosition();
        }

        @Override
        public Drawable getIcon() {
            return mWrappedTab.getIcon();
        }

        @Override
        public CharSequence getText() {
            return mWrappedTab.getText();
        }

        @Override
        public Tab setIcon(Drawable icon) {
            mWrappedTab.setIcon(icon);
            return this;
        }

        @Override
        public Tab setIcon(int resId) {
            mWrappedTab.setIcon(resId);
            return this;
        }

        @Override
        public Tab setText(CharSequence text) {
            mWrappedTab.setText(text);
            return this;
        }

        @Override
        public Tab setText(int resId) {
            mWrappedTab.setText(resId);
            return this;
        }

        @Override
        public Tab setCustomView(View view) {
            mWrappedTab.setCustomView(view);
            return this;
        }

        @Override
        public Tab setCustomView(int layoutResId) {
            mWrappedTab.setCustomView(layoutResId);
            return this;
        }

        @Override
        public View getCustomView() {
            return mWrappedTab.getCustomView();
        }

        @Override
        public Tab setTag(Object obj) {
            mTag = obj;
            return this;
        }

        @Override
        public Object getTag() {
            return mTag;
        }

        @Override
        public Tab setTabListener(TabListener listener) {
            mTabListener = listener;
            mWrappedTab.setTabListener(listener != null ? this : null);
            return this;
        }

        @Override
        public void select() {
            mWrappedTab.select();
        }

        @Override
        public Tab setContentDescription(int resId) {
            mContentDescription = mActivity.getText(resId);
            return this;
        }

        @Override
        public Tab setContentDescription(CharSequence contentDesc) {
            mContentDescription = contentDesc;
            return this;
        }

        @Override
        public CharSequence getContentDescription() {
            return mContentDescription;
        }

        @Override
        public void onTabSelected(android.app.ActionBar.Tab tab,
                android.app.FragmentTransaction ft) {
            mTabListener.onTabSelected(this, ft != null ? getActiveTransaction() : null);
            commitActiveTransaction();
        }

        @Override
        public void onTabUnselected(android.app.ActionBar.Tab tab,
                android.app.FragmentTransaction ft) {
            mTabListener.onTabUnselected(this, ft != null ? getActiveTransaction() : null);
        }

        @Override
        public void onTabReselected(android.app.ActionBar.Tab tab,
                android.app.FragmentTransaction ft) {
            mTabListener.onTabReselected(this, ft != null ? getActiveTransaction() : null);
            commitActiveTransaction();
        }
    }
}
