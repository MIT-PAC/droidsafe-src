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

package android.support.v7.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.view.CollapsibleActionView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;

import java.lang.reflect.Method;

/**
 * @hide
 */
public class MenuItemWrapperICS extends BaseMenuWrapper<android.view.MenuItem> implements SupportMenuItem {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.871 -0400", hash_original_field = "5818A4725A15D4D90AFDA79104EEE5B5", hash_generated_field = "FA4B8A5CCEEDC960D43C5A6BD2C2C7C4")

    static final String LOG_TAG = "MenuItemWrapper";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.874 -0400", hash_original_field = "67D9A707D42013246D5F575A188F1FED", hash_generated_field = "FD5296B3715A1F5C47C0E2EB23158778")


    private  boolean mEmulateProviderVisibilityOverride;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.876 -0400", hash_original_field = "9F3E9C50359B26276D21DC0ECBC47052", hash_generated_field = "1F23495C802B4434629A95DB851C3F84")

    private boolean mLastRequestVisible;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.878 -0400", hash_original_field = "A6B60FF5CDB96FA99748D5DD110B95EA", hash_generated_field = "6C81DEE750F3EC524A89084DF5680840")

    private Method mSetExclusiveCheckableMethod;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.880 -0400", hash_original_method = "CB7B4EB3A3B051DB9AE94E5FDE4BB029", hash_generated_method = "CB7B4EB3A3B051DB9AE94E5FDE4BB029")
    
MenuItemWrapperICS(android.view.MenuItem object, boolean emulateProviderVisibilityOverride) {
        super(object);
        mLastRequestVisible = object.isVisible();
        mEmulateProviderVisibilityOverride = emulateProviderVisibilityOverride;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.882 -0400", hash_original_method = "93FE8A4CA99EA04726581F5499589FD4", hash_generated_method = "93FE8A4CA99EA04726581F5499589FD4")
    
MenuItemWrapperICS(android.view.MenuItem object) {
        this(object, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.884 -0400", hash_original_method = "D7FD468112C6CDB45907471968ED6DDE", hash_generated_method = "A3715838890FD76C308A371E289B2F56")
    
@Override
    public int getItemId() {
        return mWrappedObject.getItemId();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.886 -0400", hash_original_method = "259403D85C6B513FA3BC323BDB01657F", hash_generated_method = "53302933341E0B08F1422D59B79622FC")
    
@Override
    public int getGroupId() {
        return mWrappedObject.getGroupId();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.890 -0400", hash_original_method = "EA05504952D99F97F346179191A0FA1D", hash_generated_method = "DF33BE1E7ED919AFDD50CF850D179F0D")
    
@Override
    public int getOrder() {
        return mWrappedObject.getOrder();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.892 -0400", hash_original_method = "36221A506C4318BAE4A45BF1C70A65E7", hash_generated_method = "D7566B8A0AB3DB3311CD3CCA211FE8B3")
    
@Override
    public MenuItem setTitle(CharSequence title) {
        mWrappedObject.setTitle(title);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.895 -0400", hash_original_method = "9186FE02CA2CE8E590B41D624B78A4C6", hash_generated_method = "D1F23393C8A55B7A8E2C7A5DB865B80F")
    
@Override
    public MenuItem setTitle(int title) {
        mWrappedObject.setTitle(title);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.897 -0400", hash_original_method = "9EE6D2DDA3272B8060633454B2464840", hash_generated_method = "8BB2563A2B07C0D3BCAC1558BFFD5FC0")
    
@Override
    public CharSequence getTitle() {
        return mWrappedObject.getTitle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.899 -0400", hash_original_method = "18688A7C7E6DD00BB9927049CBDBC592", hash_generated_method = "99CA33821A31EB8474B5B597D4FC3B89")
    
@Override
    public MenuItem setTitleCondensed(CharSequence title) {
        mWrappedObject.setTitleCondensed(title);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.902 -0400", hash_original_method = "1C389E80873C9610B59555218E09C345", hash_generated_method = "B026002A98EC29B73DE4661EC8F728EF")
    
@Override
    public CharSequence getTitleCondensed() {
        return mWrappedObject.getTitleCondensed();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.904 -0400", hash_original_method = "E2302E338A4875A813026ABE62186D17", hash_generated_method = "C5D3EBC354F78650DF2233C408BED5CE")
    
@Override
    public MenuItem setIcon(Drawable icon) {
        mWrappedObject.setIcon(icon);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.906 -0400", hash_original_method = "45B137DF67E66713CCAF4DEFB0CFE6D1", hash_generated_method = "490E21A8C6072388497D3B82496B9824")
    
@Override
    public MenuItem setIcon(int iconRes) {
        mWrappedObject.setIcon(iconRes);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.908 -0400", hash_original_method = "4719C6903C03EC872B5FD4595188F02D", hash_generated_method = "189495E1566A3CEA8F056FEF4F390257")
    
@Override
    public Drawable getIcon() {
        return mWrappedObject.getIcon();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.911 -0400", hash_original_method = "BC9153903FB590EE23335EF428AC3A63", hash_generated_method = "4FA2550AC9E671C58AEF62C10733F0FE")
    
@Override
    public MenuItem setIntent(Intent intent) {
        mWrappedObject.setIntent(intent);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.913 -0400", hash_original_method = "CA71F58F3DDF532BF7D440E8AE05D786", hash_generated_method = "5A21B0F60B842789D8A8CBA48B84A163")
    
@Override
    public Intent getIntent() {
        return mWrappedObject.getIntent();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.916 -0400", hash_original_method = "5F716842B81C1A62397607089B15451C", hash_generated_method = "03848808203BA27F9AFEC0A6AD484DEE")
    
@Override
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        mWrappedObject.setShortcut(numericChar, alphaChar);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.918 -0400", hash_original_method = "04580B87FEA1171BB15A8475D1FE332E", hash_generated_method = "B9097A9595FDB160A24E3FC58D4B839A")
    
@Override
    public MenuItem setNumericShortcut(char numericChar) {
        mWrappedObject.setNumericShortcut(numericChar);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.921 -0400", hash_original_method = "9D90DBAD54A0BBB38360722714DEDA8E", hash_generated_method = "F7BE166F0D05AA4437F685F4C44AAB64")
    
@Override
    public char getNumericShortcut() {
        return mWrappedObject.getNumericShortcut();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.923 -0400", hash_original_method = "7AC46414D8A1EB2FE9743003F8B04A3E", hash_generated_method = "61CD4E2F795D8E8867D47E61B761C7A1")
    
@Override
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        mWrappedObject.setAlphabeticShortcut(alphaChar);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.925 -0400", hash_original_method = "5896604105F6724778ECAD3907349C79", hash_generated_method = "54761CEF393A7886EE426E767A49FCC9")
    
@Override
    public char getAlphabeticShortcut() {
        return mWrappedObject.getAlphabeticShortcut();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.927 -0400", hash_original_method = "B47D4ACB9C0DB16F83E3C9A7A5007EA5", hash_generated_method = "8E66481048DA8129B80E17341DB1EE7B")
    
@Override
    public MenuItem setCheckable(boolean checkable) {
        mWrappedObject.setCheckable(checkable);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.929 -0400", hash_original_method = "7449E9F77DCE67DB0A29C1BEDB6DE390", hash_generated_method = "919106B4DAFD6E3FA7DF231544FDC6C2")
    
@Override
    public boolean isCheckable() {
        return mWrappedObject.isCheckable();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.931 -0400", hash_original_method = "8974DF4933D4B16E9D20C74A536FA2FD", hash_generated_method = "442525C3DB9E3236C2EDD74514261F07")
    
@Override
    public MenuItem setChecked(boolean checked) {
        mWrappedObject.setChecked(checked);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.935 -0400", hash_original_method = "907DCEBA15549665EA672F916E7F7FA1", hash_generated_method = "368A34D6427D95348B5EBF77DED5784C")
    
@Override
    public boolean isChecked() {
        return mWrappedObject.isChecked();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.938 -0400", hash_original_method = "7294EB0F702AFBEA4B2D672BAEA2E1D4", hash_generated_method = "2E201EF2A0DAE6C72A433AE4EF66B9C0")
    
@Override
    public MenuItem setVisible(boolean visible) {
        if (mEmulateProviderVisibilityOverride) {
            mLastRequestVisible = visible;
            // If we need to be visible, we need to check whether the ActionProvider overrides it
            if (checkActionProviderOverrideVisibility()) {
                return this;
            }
        }
        return wrappedSetVisible(visible);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.940 -0400", hash_original_method = "92D8A63E9DDF627A069FB5728D7CA07C", hash_generated_method = "BF378AAD0F3D973575B667ACC81348A7")
    
@Override
    public boolean isVisible() {
        return mWrappedObject.isVisible();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.943 -0400", hash_original_method = "8B612C081D85C719035DF8F863331C19", hash_generated_method = "D7ED2BF24C341B9CAA5FD1AF6B706181")
    
@Override
    public MenuItem setEnabled(boolean enabled) {
        mWrappedObject.setEnabled(enabled);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.945 -0400", hash_original_method = "C52A642F74F4ED444D5C6B5F5E1C1D6B", hash_generated_method = "5835DBE415B8CE2CC254C5C1B301010D")
    
@Override
    public boolean isEnabled() {
        return mWrappedObject.isEnabled();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.948 -0400", hash_original_method = "B458F3D3453FC14899D04C7CC74AB585", hash_generated_method = "C45AA10B8BEEC19972837F81763EA7B0")
    
@Override
    public boolean hasSubMenu() {
        return mWrappedObject.hasSubMenu();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.950 -0400", hash_original_method = "0FD1C439FD89EA8DC4B29C46338C90DB", hash_generated_method = "6A461C428372EEC0113662E4D4510839")
    
@Override
    public SubMenu getSubMenu() {
        return getSubMenuWrapper(mWrappedObject.getSubMenu());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.953 -0400", hash_original_method = "1673AA676766F2C4FADE5F85802808B2", hash_generated_method = "F745207A0DAD194A114960B9BE4C8D51")
    
@Override
    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        mWrappedObject.setOnMenuItemClickListener(menuItemClickListener != null ?
                new OnMenuItemClickListenerWrapper(menuItemClickListener) : null);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.956 -0400", hash_original_method = "10BB317C7DD33A9C28F953AF2922BBD4", hash_generated_method = "2D49FDEB66E12425C023850343530010")
    
@Override
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return mWrappedObject.getMenuInfo();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.958 -0400", hash_original_method = "2954F05E74ACD652FF5E9A3BBCE6EADE", hash_generated_method = "1F14C842C45B355FF780160173097BA8")
    
@Override
    public void setShowAsAction(int actionEnum) {
        mWrappedObject.setShowAsAction(actionEnum);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.961 -0400", hash_original_method = "56E1E9130E0B0D8A25FCAF2EE4408F26", hash_generated_method = "7411E34E8E1BF3DA98B3BD7AE7CA810C")
    
@Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        mWrappedObject.setShowAsActionFlags(actionEnum);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.964 -0400", hash_original_method = "C604C64DEEA9AD4C8F11BA0938A4FEB3", hash_generated_method = "C079DF15B4BC4EA4C6C216BA455A918A")
    
@Override
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        mWrappedObject.setActionView(view);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.967 -0400", hash_original_method = "07A15372F4248C872810B24E593D951C", hash_generated_method = "C88AFEE2757302A1E2BF20C0694AEBA8")
    
@Override
    public MenuItem setActionView(int resId) {
        // Make framework menu item inflate the view
        mWrappedObject.setActionView(resId);

        View actionView = mWrappedObject.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            // If the inflated Action View is support-collapsible, wrap it
            mWrappedObject.setActionView(new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.969 -0400", hash_original_method = "0B0476AAE67E3ACD3A521B8FBDEFF050", hash_generated_method = "0F7150871FFF5F083437A311EDE39090")
    
@Override
    public View getActionView() {
        View actionView = mWrappedObject.getActionView();
        if (actionView instanceof CollapsibleActionViewWrapper) {
            return ((CollapsibleActionViewWrapper) actionView).getWrappedView();
        }
        return actionView;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.972 -0400", hash_original_method = "8F041A8F89673408251EC75F2E4DECC4", hash_generated_method = "2547809C42DC19198ED6504CC9EB8E67")
    
@Override
    public MenuItem setActionProvider(android.view.ActionProvider provider) {
        mWrappedObject.setActionProvider(provider);
        if (provider != null && mEmulateProviderVisibilityOverride) {
            checkActionProviderOverrideVisibility();
        }
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.975 -0400", hash_original_method = "CE77781B974FC68F8BF601E3F62C43FF", hash_generated_method = "2AEEB45805BF2D0FA966FEFA0439DF3F")
    
@Override
    public android.view.ActionProvider getActionProvider() {
        return mWrappedObject.getActionProvider();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.978 -0400", hash_original_method = "89D881B6F3AB8D5F210CC2255AC59F7B", hash_generated_method = "DEF40126B4DAA8C406B4A1298049DD2D")
    
@Override
    public boolean expandActionView() {
        return mWrappedObject.expandActionView();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.980 -0400", hash_original_method = "C5F9D4F717ACDCA8466296AB88C0DEDE", hash_generated_method = "4EC324A16704276426EDFE569403B4A4")
    
@Override
    public boolean collapseActionView() {
        return mWrappedObject.collapseActionView();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.983 -0400", hash_original_method = "E8176D455FEBE9C9677E10D379B9938A", hash_generated_method = "DA6D46903BF1B2E66ACF55668CB138AF")
    
@Override
    public boolean isActionViewExpanded() {
        return mWrappedObject.isActionViewExpanded();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.986 -0400", hash_original_method = "812F53AD7F341A1186A2C52329057CEC", hash_generated_method = "E8CE7C23703803E111CAD09CFF4B333C")
    
@Override
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener listener) {
        mWrappedObject.setOnActionExpandListener(listener);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.990 -0400", hash_original_method = "E2F112D6E275A8A2254AC975B93844B0", hash_generated_method = "E118AC054651130A351FC94FE3AFA84C")
    
@Override
    public SupportMenuItem setSupportOnActionExpandListener(
            MenuItemCompat.OnActionExpandListener listener) {
        mWrappedObject.setOnActionExpandListener(listener != null ?
                new OnActionExpandListenerWrapper(listener) : null);
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.992 -0400", hash_original_method = "AB380BC985C8B484BB0C20BFA5515E69", hash_generated_method = "1030544DA70D84F06BD336CD093E9605")
    
@Override
    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        mWrappedObject.setActionProvider(actionProvider != null ?
                createActionProviderWrapper(actionProvider) : null);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.995 -0400", hash_original_method = "212E0915AA92F8E469974C594E2A86DC", hash_generated_method = "B5C376BEF3B8CCAFBC920394C66CB4EC")
    
@Override
    public ActionProvider getSupportActionProvider() {
        ActionProviderWrapper providerWrapper =
                (ActionProviderWrapper) mWrappedObject.getActionProvider();
        return providerWrapper != null ? providerWrapper.mInner : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.998 -0400", hash_original_method = "D822D820FB7A2CE2CB5C78D76B9FE372", hash_generated_method = "260C8E11D0ACA84B4CDBA5ED27A29ABB")
    
public void setExclusiveCheckable(boolean checkable) {
        try {
            if (mSetExclusiveCheckableMethod == null) {
                mSetExclusiveCheckableMethod = mWrappedObject.getClass()
                        .getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            mSetExclusiveCheckableMethod.invoke(mWrappedObject, checkable);
        } catch (Exception e) {
            Log.w(LOG_TAG, "Error while calling setExclusiveCheckable", e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.001 -0400", hash_original_method = "62F414370120652C6528EABFB6D5022A", hash_generated_method = "62F414370120652C6528EABFB6D5022A")
    
ActionProviderWrapper createActionProviderWrapper(ActionProvider provider) {
        return new ActionProviderWrapper(provider);
    }

    /**
     * @return true if the ActionProvider has overriden the visibility
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.004 -0400", hash_original_method = "6681F0186FE1FCA6C550954954A6B716", hash_generated_method = "25668D3B9B2602686705441E08F2D263")
    
final boolean checkActionProviderOverrideVisibility() {
        if (mLastRequestVisible) {
            ActionProvider provider = getSupportActionProvider();
            if (provider != null && provider.overridesItemVisibility() && !provider.isVisible()) {
                wrappedSetVisible(false);
                return true;
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.006 -0400", hash_original_method = "3CBD805F91237DD53C3626BB73493E7A", hash_generated_method = "D0335F68798F71011E9E001D73832277")
    
final MenuItem wrappedSetVisible(boolean visible) {
        return mWrappedObject.setVisible(visible);
    }

    private class OnMenuItemClickListenerWrapper extends BaseWrapper<OnMenuItemClickListener>
            implements android.view.MenuItem.OnMenuItemClickListener {

        OnMenuItemClickListenerWrapper(OnMenuItemClickListener object) {
            super(object);
        }

        @Override
        public boolean onMenuItemClick(android.view.MenuItem item) {
            return mWrappedObject.onMenuItemClick(getMenuItemWrapper(item));
        }
    }

    private class OnActionExpandListenerWrapper extends BaseWrapper<MenuItemCompat.OnActionExpandListener>
            implements android.view.MenuItem.OnActionExpandListener {

        OnActionExpandListenerWrapper(MenuItemCompat.OnActionExpandListener object) {
            super(object);
        }

        @Override
        public boolean onMenuItemActionExpand(android.view.MenuItem item) {
            return mWrappedObject.onMenuItemActionExpand(getMenuItemWrapper(item));
        }

        @Override
        public boolean onMenuItemActionCollapse(android.view.MenuItem item) {
            return mWrappedObject.onMenuItemActionCollapse(getMenuItemWrapper(item));
        }
    }

    class ActionProviderWrapper extends android.view.ActionProvider {
        final ActionProvider mInner;

        public ActionProviderWrapper(ActionProvider inner) {
            super(inner.getContext());
            mInner = inner;

            if (mEmulateProviderVisibilityOverride) {
                mInner.setVisibilityListener(new ActionProvider.VisibilityListener() {
                    @Override
                    public void onActionProviderVisibilityChanged(boolean isVisible) {
                        if (mInner.overridesItemVisibility() && mLastRequestVisible) {
                            wrappedSetVisible(isVisible);
                        }
                    }
                });
            }
        }

        @Override
        public View onCreateActionView() {
            if (mEmulateProviderVisibilityOverride) {
                // This is a convenient place to hook in and check if we need to override the
                // visibility after being created.
                checkActionProviderOverrideVisibility();
            }
            return mInner.onCreateActionView();
        }

        @Override
        public boolean onPerformDefaultAction() {
            return mInner.onPerformDefaultAction();
        }

        @Override
        public boolean hasSubMenu() {
            return mInner.hasSubMenu();
        }

        @Override
        public void onPrepareSubMenu(android.view.SubMenu subMenu) {
            mInner.onPrepareSubMenu(getSubMenuWrapper(subMenu));
        }
    }

    static class CollapsibleActionViewWrapper extends FrameLayout
            implements android.view.CollapsibleActionView {
        final CollapsibleActionView mWrappedView;

        CollapsibleActionViewWrapper(View actionView) {
            super(actionView.getContext());
            mWrappedView = (CollapsibleActionView) actionView;
            addView(actionView);
        }

        @Override
        public void onActionViewExpanded() {
            mWrappedView.onActionViewExpanded();
        }

        @Override
        public void onActionViewCollapsed() {
            mWrappedView.onActionViewCollapsed();
        }

        View getWrappedView() {
            return (View) mWrappedView;
        }
    }
}
