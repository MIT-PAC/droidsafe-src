package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.SpinnerAdapter;

public abstract class ActionBar {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.384 -0500", hash_original_field = "9ECF20DEBE80BDF521AC23C2EC8ABFE5", hash_generated_field = "F325EF02C9FC2C1CC6B930C3BC286C7F")

    public static final int NAVIGATION_MODE_STANDARD = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.387 -0500", hash_original_field = "F6000119E46C49B0CEE16787E9CEE4E0", hash_generated_field = "FA4862B760D228A8469E7FF77A649E27")

    public static final int NAVIGATION_MODE_LIST = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.389 -0500", hash_original_field = "5040A5624EC90AA3825FEA487302247A", hash_generated_field = "FC5DE487CCB5A0CFA5AAFFADCBED57AE")

    public static final int NAVIGATION_MODE_TABS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.391 -0500", hash_original_field = "6CCC68040D055E4D581AB277505DE3F6", hash_generated_field = "FB67EE86B0F3ED8D655401C61DEB80C4")

    public static final int DISPLAY_USE_LOGO = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.393 -0500", hash_original_field = "E99B7992EDC4B42039FAE253C1D2CE19", hash_generated_field = "A8BE794CF21F9DB76A32D4D71CFF08D5")

    public static final int DISPLAY_SHOW_HOME = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.396 -0500", hash_original_field = "F2BEA53B8BDB0A3A6FC7C9F02265BFC5", hash_generated_field = "97D567A384C38093D4C9BEBF75BACF25")

    public static final int DISPLAY_HOME_AS_UP = 0x4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.399 -0500", hash_original_field = "5513770E61366DDB8FED74938B5ECDD1", hash_generated_field = "497402E055CEA6270B77283114307D15")

    public static final int DISPLAY_SHOW_TITLE = 0x8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.401 -0500", hash_original_field = "51837755F4DDAA552E1C8941966BA65D", hash_generated_field = "989902DA33165C818CD245DC87485645")

    public static final int DISPLAY_SHOW_CUSTOM = 0x10;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.183 -0400", hash_original_method = "6A41438E0ABBC5F08FB907D4E02D20B4", hash_generated_method = "6A41438E0ABBC5F08FB907D4E02D20B4")
    public ActionBar ()
    {
        //Synthesized constructor
    }

    /**
     * Set the action bar into custom navigation mode, supplying a view
     * for custom navigation.
     *
     * Custom navigation views appear between the application icon and
     * any action buttons and may use any space available there. Common
     * use cases for custom navigation views might include an auto-suggesting
     * address bar for a browser or other navigation mechanisms that do not
     * translate well to provided navigation modes.
     *
     * @param view Custom navigation view to place in the ActionBar.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.404 -0500", hash_original_method = "75E78D59B0AC673EC9AC299DFF89779E", hash_generated_method = "3F5163B75632712B25ECCBFB0D907DF2")
    
public abstract void setCustomView(View view);

    /**
     * Set the action bar into custom navigation mode, supplying a view
     * for custom navigation.
     * 
     * <p>Custom navigation views appear between the application icon and
     * any action buttons and may use any space available there. Common
     * use cases for custom navigation views might include an auto-suggesting
     * address bar for a browser or other navigation mechanisms that do not
     * translate well to provided navigation modes.</p>
     *
     * <p>The display option {@link #DISPLAY_SHOW_CUSTOM} must be set for
     * the custom view to be displayed.</p>
     * 
     * @param view Custom navigation view to place in the ActionBar.
     * @param layoutParams How this custom view should layout in the bar.
     *
     * @see #setDisplayOptions(int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.406 -0500", hash_original_method = "EF7641A562FAF17F1E00E507622C7DB6", hash_generated_method = "13A94D1DC7914EDAFA673E9C95EFF45B")
    
public abstract void setCustomView(View view, LayoutParams layoutParams);

    /**
     * Set the action bar into custom navigation mode, supplying a view
     * for custom navigation.
     *
     * <p>Custom navigation views appear between the application icon and
     * any action buttons and may use any space available there. Common
     * use cases for custom navigation views might include an auto-suggesting
     * address bar for a browser or other navigation mechanisms that do not
     * translate well to provided navigation modes.</p>
     *
     * <p>The display option {@link #DISPLAY_SHOW_CUSTOM} must be set for
     * the custom view to be displayed.</p>
     *
     * @param resId Resource ID of a layout to inflate into the ActionBar.
     *
     * @see #setDisplayOptions(int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.408 -0500", hash_original_method = "999E7EA647DC5CDCE165BB3550A1876B", hash_generated_method = "8D83D7ECFE5BFE8CE20DCD09F260507E")
    
public abstract void setCustomView(int resId);

    /**
     * Set the icon to display in the 'home' section of the action bar.
     * The action bar will use an icon specified by its style or the
     * activity icon by default.
     *
     * Whether the home section shows an icon or logo is controlled
     * by the display option {@link #DISPLAY_USE_LOGO}.
     *
     * @param resId Resource ID of a drawable to show as an icon.
     *
     * @see #setDisplayUseLogoEnabled(boolean)
     * @see #setDisplayShowHomeEnabled(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.410 -0500", hash_original_method = "D5841849BE036FF3F1F40CFD74834BCD", hash_generated_method = "9B84DF91226E155C39700B10BA87FFEC")
    
public abstract void setIcon(int resId);

    /**
     * Set the icon to display in the 'home' section of the action bar.
     * The action bar will use an icon specified by its style or the
     * activity icon by default.
     *
     * Whether the home section shows an icon or logo is controlled
     * by the display option {@link #DISPLAY_USE_LOGO}.
     *
     * @param icon Drawable to show as an icon.
     *
     * @see #setDisplayUseLogoEnabled(boolean)
     * @see #setDisplayShowHomeEnabled(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.412 -0500", hash_original_method = "35A832EA5C8D9B7F663DFDAB4318C3C9", hash_generated_method = "C10704A9BD17EABD169C029D6E0CFC14")
    
public abstract void setIcon(Drawable icon);

    /**
     * Set the logo to display in the 'home' section of the action bar.
     * The action bar will use a logo specified by its style or the
     * activity logo by default.
     *
     * Whether the home section shows an icon or logo is controlled
     * by the display option {@link #DISPLAY_USE_LOGO}.
     *
     * @param resId Resource ID of a drawable to show as a logo.
     *
     * @see #setDisplayUseLogoEnabled(boolean)
     * @see #setDisplayShowHomeEnabled(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.414 -0500", hash_original_method = "5A992973B4AAA4EB2D556E7E5F18426D", hash_generated_method = "881666F584146A15F2EE0382D036BCBF")
    
public abstract void setLogo(int resId);

    /**
     * Set the logo to display in the 'home' section of the action bar.
     * The action bar will use a logo specified by its style or the
     * activity logo by default.
     *
     * Whether the home section shows an icon or logo is controlled
     * by the display option {@link #DISPLAY_USE_LOGO}.
     *
     * @param logo Drawable to show as a logo.
     *
     * @see #setDisplayUseLogoEnabled(boolean)
     * @see #setDisplayShowHomeEnabled(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.417 -0500", hash_original_method = "BE00F1051402F4FF45BA44110672D20A", hash_generated_method = "21350EAFAC6A708CF0CE0CF27202DF64")
    
public abstract void setLogo(Drawable logo);

    /**
     * Set the adapter and navigation callback for list navigation mode.
     *
     * The supplied adapter will provide views for the expanded list as well as
     * the currently selected item. (These may be displayed differently.)
     *
     * The supplied OnNavigationListener will alert the application when the user
     * changes the current list selection.
     *
     * @param adapter An adapter that will provide views both to display
     *                the current navigation selection and populate views
     *                within the dropdown navigation menu.
     * @param callback An OnNavigationListener that will receive events when the user
     *                 selects a navigation item.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.419 -0500", hash_original_method = "7CD20F9935B068DC4D83EB0E38CE3DB0", hash_generated_method = "73A34B2384C3F7FCF4EDF1C71012973C")
    
public abstract void setListNavigationCallbacks(SpinnerAdapter adapter,
            OnNavigationListener callback);

    /**
     * Set the selected navigation item in list or tabbed navigation modes.
     *
     * @param position Position of the item to select.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.421 -0500", hash_original_method = "F47386DE67C5DFD0E213E99D0661E7BB", hash_generated_method = "3471E6F45C0E8573058AF378E401E50A")
    
public abstract void setSelectedNavigationItem(int position);

    /**
     * Get the position of the selected navigation item in list or tabbed navigation modes.
     *
     * @return Position of the selected item.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.423 -0500", hash_original_method = "C0E6FA1AFA7AE41BF9B97C29729F20D0", hash_generated_method = "00D90446EA18E66EB837C1437F8C6062")
    
public abstract int getSelectedNavigationIndex();

    /**
     * Get the number of navigation items present in the current navigation mode.
     *
     * @return Number of navigation items.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.426 -0500", hash_original_method = "C2369EE9673B505598D2B50AEEA08DA1", hash_generated_method = "11C9E9D4744DA40AD5123CD2C68C0468")
    
public abstract int getNavigationItemCount();

    /**
     * Set the action bar's title. This will only be displayed if
     * {@link #DISPLAY_SHOW_TITLE} is set.
     *
     * @param title Title to set
     *
     * @see #setTitle(int)
     * @see #setDisplayOptions(int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.428 -0500", hash_original_method = "410835EEA321510B785087E900780AFB", hash_generated_method = "F61FA778C52CF90209781407DFEFC387")
    
public abstract void setTitle(CharSequence title);

    /**
     * Set the action bar's title. This will only be displayed if
     * {@link #DISPLAY_SHOW_TITLE} is set.
     *
     * @param resId Resource ID of title string to set
     *
     * @see #setTitle(CharSequence)
     * @see #setDisplayOptions(int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.430 -0500", hash_original_method = "516EEAF41A54C2F23324189E2ED4731D", hash_generated_method = "D271218F7CA96C8DBB89D368B635F8B6")
    
public abstract void setTitle(int resId);

    /**
     * Set the action bar's subtitle. This will only be displayed if
     * {@link #DISPLAY_SHOW_TITLE} is set. Set to null to disable the
     * subtitle entirely.
     *
     * @param subtitle Subtitle to set
     *
     * @see #setSubtitle(int)
     * @see #setDisplayOptions(int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.432 -0500", hash_original_method = "D00074A941BED700B112E60CA2B4BBFA", hash_generated_method = "0BA816A36095386377AF796A7E9F4E55")
    
public abstract void setSubtitle(CharSequence subtitle);

    /**
     * Set the action bar's subtitle. This will only be displayed if
     * {@link #DISPLAY_SHOW_TITLE} is set.
     *
     * @param resId Resource ID of subtitle string to set
     *
     * @see #setSubtitle(CharSequence)
     * @see #setDisplayOptions(int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.434 -0500", hash_original_method = "08B7103B21D83BEA0EC09BF9CF437884", hash_generated_method = "8D1000593E31D74C218814097C6E4287")
    
public abstract void setSubtitle(int resId);

    /**
     * Set display options. This changes all display option bits at once. To change
     * a limited subset of display options, see {@link #setDisplayOptions(int, int)}.
     * 
     * @param options A combination of the bits defined by the DISPLAY_ constants
     *                defined in ActionBar.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.436 -0500", hash_original_method = "DC25C0C2454CF89FEB28819F3CD4A618", hash_generated_method = "32E10E28682C89DBD204A57E27C0F50A")
    
public abstract void setDisplayOptions(int options);
    
    /**
     * Set selected display options. Only the options specified by mask will be changed.
     * To change all display option bits at once, see {@link #setDisplayOptions(int)}.
     * 
     * <p>Example: setDisplayOptions(0, DISPLAY_SHOW_HOME) will disable the
     * {@link #DISPLAY_SHOW_HOME} option.
     * setDisplayOptions(DISPLAY_SHOW_HOME, DISPLAY_SHOW_HOME | DISPLAY_USE_LOGO)
     * will enable {@link #DISPLAY_SHOW_HOME} and disable {@link #DISPLAY_USE_LOGO}.
     * 
     * @param options A combination of the bits defined by the DISPLAY_ constants
     *                defined in ActionBar.
     * @param mask A bit mask declaring which display options should be changed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.438 -0500", hash_original_method = "54BB4F56FD463FEFE8CE5E75AA3087ED", hash_generated_method = "EFAC8DBB210CD389D0492B0D3B9D2A8D")
    
public abstract void setDisplayOptions(int options, int mask);

    /**
     * Set whether to display the activity logo rather than the activity icon.
     * A logo is often a wider, more detailed image.
     *
     * <p>To set several display options at once, see the setDisplayOptions methods.
     *
     * @param useLogo true to use the activity logo, false to use the activity icon.
     *
     * @see #setDisplayOptions(int)
     * @see #setDisplayOptions(int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.440 -0500", hash_original_method = "4C4DD6013B7ED50AD623552F47D031D0", hash_generated_method = "95095A12BEBBCF8E28A9C126FACFB785")
    
public abstract void setDisplayUseLogoEnabled(boolean useLogo);

    /**
     * Set whether to include the application home affordance in the action bar.
     * Home is presented as either an activity icon or logo.
     *
     * <p>To set several display options at once, see the setDisplayOptions methods.
     *
     * @param showHome true to show home, false otherwise.
     *
     * @see #setDisplayOptions(int)
     * @see #setDisplayOptions(int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.442 -0500", hash_original_method = "67FDE018A82DDA318E8EE4B546D7CB49", hash_generated_method = "2F416A95FDEA228ED1ECF0E15AD7F883")
    
public abstract void setDisplayShowHomeEnabled(boolean showHome);

    /**
     * Set whether home should be displayed as an "up" affordance.
     * Set this to true if selecting "home" returns up by a single level in your UI
     * rather than back to the top level or front page.
     *
     * <p>To set several display options at once, see the setDisplayOptions methods.
     *
     * @param showHomeAsUp true to show the user that selecting home will return one
     *                     level up rather than to the top level of the app.
     *
     * @see #setDisplayOptions(int)
     * @see #setDisplayOptions(int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.445 -0500", hash_original_method = "7FAA9B7D5A3C48CB59C455373282F80B", hash_generated_method = "D8C2F66495A46EB792CD4E99FF78D108")
    
public abstract void setDisplayHomeAsUpEnabled(boolean showHomeAsUp);

    /**
     * Set whether an activity title/subtitle should be displayed.
     *
     * <p>To set several display options at once, see the setDisplayOptions methods.
     *
     * @param showTitle true to display a title/subtitle if present.
     *
     * @see #setDisplayOptions(int)
     * @see #setDisplayOptions(int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.448 -0500", hash_original_method = "49E430E7E7BED000E9B7460A01465313", hash_generated_method = "81FE3D3DE6CADA929EEB146B298466EC")
    
public abstract void setDisplayShowTitleEnabled(boolean showTitle);

    /**
     * Set whether a custom view should be displayed, if set.
     *
     * <p>To set several display options at once, see the setDisplayOptions methods.
     *
     * @param showCustom true if the currently set custom view should be displayed, false otherwise.
     *
     * @see #setDisplayOptions(int)
     * @see #setDisplayOptions(int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.450 -0500", hash_original_method = "269EA1D00FA879831CA8ABD7F34B123A", hash_generated_method = "412AE0EBC3B8DE455F71664A2962597E")
    
public abstract void setDisplayShowCustomEnabled(boolean showCustom);

    /**
     * Set the ActionBar's background. This will be used for the primary
     * action bar.
     * 
     * @param d Background drawable
     * @see #setStackedBackgroundDrawable(Drawable)
     * @see #setSplitBackgroundDrawable(Drawable)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.452 -0500", hash_original_method = "5E39AC2966371F154D9FDAA58AC06B08", hash_generated_method = "4AD725E2636D2CB7C4C3544F4D568010")
    
public abstract void setBackgroundDrawable(Drawable d);

    /**
     * Set the ActionBar's stacked background. This will appear
     * in the second row/stacked bar on some devices and configurations.
     *
     * @param d Background drawable for the stacked row
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.454 -0500", hash_original_method = "1C087D5A46FF67AB400586D7FD9EC5DB", hash_generated_method = "FD8BDE63083DE44785779942FF8E47A4")
    
public void setStackedBackgroundDrawable(Drawable d) { }

    /**
     * Set the ActionBar's split background. This will appear in
     * the split action bar containing menu-provided action buttons
     * on some devices and configurations.
     * <p>You can enable split action bar with {@link android.R.attr#uiOptions}
     *
     * @param d Background drawable for the split bar
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.456 -0500", hash_original_method = "195D6A86B8711735C7C3591D31E1AD73", hash_generated_method = "B27F4574AF521C2990817845AE4C0044")
    
public void setSplitBackgroundDrawable(Drawable d) { }

    /**
     * @return The current custom view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.458 -0500", hash_original_method = "9FFDC35B3B54894B02C81A484E99C0EB", hash_generated_method = "E95F0DF95C54D06CFADD71C2C35C4CFF")
    
public abstract View getCustomView();

    /**
     * Returns the current ActionBar title in standard mode.
     * Returns null if {@link #getNavigationMode()} would not return
     * {@link #NAVIGATION_MODE_STANDARD}. 
     *
     * @return The current ActionBar title or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.460 -0500", hash_original_method = "2A829968551EA225833AD910559E3639", hash_generated_method = "9F704A6DC6184A7C8579171531B62A23")
    
public abstract CharSequence getTitle();
    
    /**
     * Returns the current ActionBar subtitle in standard mode.
     * Returns null if {@link #getNavigationMode()} would not return
     * {@link #NAVIGATION_MODE_STANDARD}. 
     *
     * @return The current ActionBar subtitle or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.462 -0500", hash_original_method = "FEEA0E87B97F8601D44AFB1E29DE7E64", hash_generated_method = "19C700D07F867A34AFE71438482B9BA4")
    
public abstract CharSequence getSubtitle();
    
    /**
     * Returns the current navigation mode. The result will be one of:
     * <ul>
     * <li>{@link #NAVIGATION_MODE_STANDARD}</li>
     * <li>{@link #NAVIGATION_MODE_LIST}</li>
     * <li>{@link #NAVIGATION_MODE_TABS}</li>
     * </ul>
     *
     * @return The current navigation mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.464 -0500", hash_original_method = "ACB37E7EC2E721AFDF9AA7215747F6DA", hash_generated_method = "2D7B6AE05BF1372B2AC884E876E49A38")
    
public abstract int getNavigationMode();

    /**
     * Set the current navigation mode.
     *
     * @param mode The new mode to set.
     * @see #NAVIGATION_MODE_STANDARD
     * @see #NAVIGATION_MODE_LIST
     * @see #NAVIGATION_MODE_TABS
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.467 -0500", hash_original_method = "CFE23BA81B0518E7BEE1626B5D4AAF21", hash_generated_method = "E0630E478C8C9F8B96B2CCC765061630")
    
public abstract void setNavigationMode(int mode);

    /**
     * @return The current set of display options. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.469 -0500", hash_original_method = "DC42952D4250534A529685F0B3612EF4", hash_generated_method = "09C94D136A7B8F34CEC7158FF11FBFB9")
    
public abstract int getDisplayOptions();

    /**
     * Create and return a new {@link Tab}.
     * This tab will not be included in the action bar until it is added.
     *
     * <p>Very often tabs will be used to switch between {@link Fragment}
     * objects.  Here is a typical implementation of such tabs:</p>
     *
     * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentTabs.java
     *      complete}
     *
     * @return A new Tab
     *
     * @see #addTab(Tab)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.471 -0500", hash_original_method = "51C98EBC6BDC06DC18A9E8866F8861BE", hash_generated_method = "77BC4009C0921A6DD138D75CE9B4F570")
    
public abstract Tab newTab();

    /**
     * Add a tab for use in tabbed navigation mode. The tab will be added at the end of the list.
     * If this is the first tab to be added it will become the selected tab.
     *
     * @param tab Tab to add
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.473 -0500", hash_original_method = "F35837BFD462C7A7235BE31AC89CD388", hash_generated_method = "1D41BFDABA8B02F7036FA50765FEE2A8")
    
public abstract void addTab(Tab tab);

    /**
     * Add a tab for use in tabbed navigation mode. The tab will be added at the end of the list.
     *
     * @param tab Tab to add
     * @param setSelected True if the added tab should become the selected tab.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.475 -0500", hash_original_method = "03FC6188C407C53B36E1AA9A9F9825F2", hash_generated_method = "5FF911FFD1B0D60370BF6E496075568D")
    
public abstract void addTab(Tab tab, boolean setSelected);

    /**
     * Add a tab for use in tabbed navigation mode. The tab will be inserted at
     * <code>position</code>. If this is the first tab to be added it will become
     * the selected tab.
     *
     * @param tab The tab to add
     * @param position The new position of the tab
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.477 -0500", hash_original_method = "47C47A74736C3C5C240A9F4C3A39B5CE", hash_generated_method = "8EB5E4A4A37440645A9B6B3F04B330D8")
    
public abstract void addTab(Tab tab, int position);

    /**
     * Add a tab for use in tabbed navigation mode. The tab will be insterted at
     * <code>position</code>.
     *
     * @param tab The tab to add
     * @param position The new position of the tab
     * @param setSelected True if the added tab should become the selected tab.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.480 -0500", hash_original_method = "34411259FEC1851A84A2B0BB888392BC", hash_generated_method = "17E2AF636265D00586ABDBCD9E6F1A01")
    
public abstract void addTab(Tab tab, int position, boolean setSelected);

    /**
     * Remove a tab from the action bar. If the removed tab was selected it will be deselected
     * and another tab will be selected if present.
     *
     * @param tab The tab to remove
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.482 -0500", hash_original_method = "78DFB6C71B097A76354778D904DE23B5", hash_generated_method = "A3040C95E8ECCD8BC9626485201FCB55")
    
public abstract void removeTab(Tab tab);

    /**
     * Remove a tab from the action bar. If the removed tab was selected it will be deselected
     * and another tab will be selected if present.
     *
     * @param position Position of the tab to remove
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.484 -0500", hash_original_method = "E327FF6F67A521379771DBC3C0AB5518", hash_generated_method = "0CD5E8639F3CED0CE9AD51388C611140")
    
public abstract void removeTabAt(int position);

    /**
     * Remove all tabs from the action bar and deselect the current tab.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.486 -0500", hash_original_method = "3E6FB1B2AAEBF277582ECBA93E338A01", hash_generated_method = "60C495E9572BF468AF1438E7B40F1DF7")
    
public abstract void removeAllTabs();

    /**
     * Select the specified tab. If it is not a child of this action bar it will be added.
     *
     * <p>Note: If you want to select by index, use {@link #setSelectedNavigationItem(int)}.</p>
     *
     * @param tab Tab to select
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.488 -0500", hash_original_method = "8E1718C184C4AE74F7681BC46810D8A1", hash_generated_method = "864B0E6D1BA47570A4BDD6DB476B1A5E")
    
public abstract void selectTab(Tab tab);

    /**
     * Returns the currently selected tab if in tabbed navigation mode and there is at least
     * one tab present.
     *
     * @return The currently selected tab or null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.491 -0500", hash_original_method = "A19EA3EC6CDD4397ADA691B5AA1BE15C", hash_generated_method = "EA91820B23E8955D5FCC6D32B0F38CA0")
    
public abstract Tab getSelectedTab();

    /**
     * Returns the tab at the specified index.
     *
     * @param index Index value in the range 0-get
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.493 -0500", hash_original_method = "BA61A5523E54D07D2733C87EE6788833", hash_generated_method = "A56D134BE99160073AFB06CA543C4F9D")
    
public abstract Tab getTabAt(int index);

    /**
     * Returns the number of tabs currently registered with the action bar.
     * @return Tab count
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.495 -0500", hash_original_method = "E7B97750ADDF2C358CEEFC6FBEBBBE3C", hash_generated_method = "66954A658D61CD03E32EF234828E97B2")
    
public abstract int getTabCount();
    
    public static abstract class Tab {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.520 -0500", hash_original_field = "08744EB4FDECE919536D545565C93AB6", hash_generated_field = "74326D0EB2E635FB68B20B0C678CCDFD")

        public static final int INVALID_POSITION = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.222 -0400", hash_original_method = "FF0150C0A74BE2A44D0E92299D724EF7", hash_generated_method = "FF0150C0A74BE2A44D0E92299D724EF7")
        public Tab ()
        {
            //Synthesized constructor
        }

        /**
         * Return the current position of this tab in the action bar.
         *
         * @return Current position, or {@link #INVALID_POSITION} if this tab is not currently in
         *         the action bar.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.523 -0500", hash_original_method = "1032B0D3D5C66E60E2A3A63CB594BFA8", hash_generated_method = "CF5E5CEC83EF085B5BB2AD3D5AD67AC3")
        
public abstract int getPosition();

        /**
         * Return the icon associated with this tab.
         *
         * @return The tab's icon
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.525 -0500", hash_original_method = "AA755DAC91171C2AAB945E5302395478", hash_generated_method = "EE654C6C97D0C1CE3EE9E0223ED50ADD")
        
public abstract Drawable getIcon();

        /**
         * Return the text of this tab.
         *
         * @return The tab's text
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.527 -0500", hash_original_method = "F253B5A800FFE39B36B9B816BB348763", hash_generated_method = "748527C2FC98E6C1FD97D7948B23BF56")
        
public abstract CharSequence getText();

        /**
         * Set the icon displayed on this tab.
         *
         * @param icon The drawable to use as an icon
         * @return The current instance for call chaining
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.529 -0500", hash_original_method = "E8AFA2038251D9B0B35E245A2565BA76", hash_generated_method = "808BCB88E7B4F2EC6E7C52D3570FADC1")
        
public abstract Tab setIcon(Drawable icon);

        /**
         * Set the icon displayed on this tab.
         *
         * @param resId Resource ID referring to the drawable to use as an icon
         * @return The current instance for call chaining
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.532 -0500", hash_original_method = "5FAECBEB3500A66E340DF5C35C1841FA", hash_generated_method = "DB9881E0701266930758E261EB916EEE")
        
public abstract Tab setIcon(int resId);

        /**
         * Set the text displayed on this tab. Text may be truncated if there is not
         * room to display the entire string.
         *
         * @param text The text to display
         * @return The current instance for call chaining
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.534 -0500", hash_original_method = "56B880BE557997F448D87FB315E25B61", hash_generated_method = "CFE1BDF79ADD846F99A9701B183E7B39")
        
public abstract Tab setText(CharSequence text);

        /**
         * Set the text displayed on this tab. Text may be truncated if there is not
         * room to display the entire string.
         *
         * @param resId A resource ID referring to the text that should be displayed
         * @return The current instance for call chaining
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.537 -0500", hash_original_method = "6CB07A6D8843581E2F665C6A64E6CCA2", hash_generated_method = "857DA4535C8702C0ACCC1A8A8654B0B4")
        
public abstract Tab setText(int resId);

        /**
         * Set a custom view to be used for this tab. This overrides values set by
         * {@link #setText(CharSequence)} and {@link #setIcon(Drawable)}.
         *
         * @param view Custom view to be used as a tab.
         * @return The current instance for call chaining
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.539 -0500", hash_original_method = "39AE317657E7B98AB293621E792021E1", hash_generated_method = "BFEBB834525D1EBAFFEBFB81DFA3AC40")
        
public abstract Tab setCustomView(View view);

        /**
         * Set a custom view to be used for this tab. This overrides values set by
         * {@link #setText(CharSequence)} and {@link #setIcon(Drawable)}.
         *
         * @param layoutResId A layout resource to inflate and use as a custom tab view
         * @return The current instance for call chaining
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.541 -0500", hash_original_method = "8AEB326D541CDE96271BCA7915A2107E", hash_generated_method = "1E7C132462316B3FE2FB8E8F6929818A")
        
public abstract Tab setCustomView(int layoutResId);

        /**
         * Retrieve a previously set custom view for this tab.
         *
         * @return The custom view set by {@link #setCustomView(View)}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.544 -0500", hash_original_method = "9FFDC35B3B54894B02C81A484E99C0EB", hash_generated_method = "E95F0DF95C54D06CFADD71C2C35C4CFF")
        
public abstract View getCustomView();

        /**
         * Give this Tab an arbitrary object to hold for later use.
         *
         * @param obj Object to store
         * @return The current instance for call chaining
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.547 -0500", hash_original_method = "9035833ACE14324EA71AA8A2BC268CBA", hash_generated_method = "48A9E60BD69D02A3D5AF8D2A2EAFA813")
        
public abstract Tab setTag(Object obj);

        /**
         * @return This Tab's tag object.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.549 -0500", hash_original_method = "372656DAE5C62DE63E43C2A798E8C7AA", hash_generated_method = "7A1D8381ADB85B0BE76468A2A89479DA")
        
public abstract Object getTag();

        /**
         * Set the {@link TabListener} that will handle switching to and from this tab.
         * All tabs must have a TabListener set before being added to the ActionBar.
         *
         * @param listener Listener to handle tab selection events
         * @return The current instance for call chaining
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.551 -0500", hash_original_method = "5D8F5F34E08D679B9FB0738EDB6A8B4F", hash_generated_method = "6342A7E7790606A2EF9E9DEBFF331B3F")
        
public abstract Tab setTabListener(TabListener listener);

        /**
         * Select this tab. Only valid if the tab has been added to the action bar.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.553 -0500", hash_original_method = "B841EEC3EA2CD8CBEDD47C93BABBE626", hash_generated_method = "F855EF34835F491A4362292827870193")
        
public abstract void select();

        /**
         * Set a description of this tab's content for use in accessibility support.
         * If no content description is provided the title will be used.
         *
         * @param resId A resource ID referring to the description text
         * @return The current instance for call chaining
         * @see #setContentDescription(CharSequence)
         * @see #getContentDescription()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.556 -0500", hash_original_method = "F439BD2E2A6C572030392531F2A16D56", hash_generated_method = "0899D4BCD97D809FD70515EAD57A2FEF")
        
public abstract Tab setContentDescription(int resId);

        /**
         * Set a description of this tab's content for use in accessibility support.
         * If no content description is provided the title will be used.
         *
         * @param contentDesc Description of this tab's content
         * @return The current instance for call chaining
         * @see #setContentDescription(int)
         * @see #getContentDescription()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.558 -0500", hash_original_method = "DBCCC7D66DB1486A5C57D23468F5754D", hash_generated_method = "42A8F18295FE86948945EAAC5C495361")
        
public abstract Tab setContentDescription(CharSequence contentDesc);

        /**
         * Gets a brief description of this tab's content for use in accessibility support.
         *
         * @return Description of this tab's content
         * @see #setContentDescription(CharSequence)
         * @see #setContentDescription(int)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.561 -0500", hash_original_method = "4533B3AAEA48E34A49C34F9827D7AAAB", hash_generated_method = "653CC6252AE9AEA258147C383AE5560F")
        
public abstract CharSequence getContentDescription();
    }
    
    public static class LayoutParams extends MarginLayoutParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.569 -0500", hash_original_field = "017EB0E7305475871AC6C45F0E01F5D9", hash_generated_field = "FAEF7A7065C713E6BE770418AEAE4491")

        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from =  -1,                       to = "NONE"),
            @ViewDebug.IntToString(from = Gravity.NO_GRAVITY,        to = "NONE"),
            @ViewDebug.IntToString(from = Gravity.TOP,               to = "TOP"),
            @ViewDebug.IntToString(from = Gravity.BOTTOM,            to = "BOTTOM"),
            @ViewDebug.IntToString(from = Gravity.LEFT,              to = "LEFT"),
            @ViewDebug.IntToString(from = Gravity.RIGHT,             to = "RIGHT"),
            @ViewDebug.IntToString(from = Gravity.CENTER_VERTICAL,   to = "CENTER_VERTICAL"),
            @ViewDebug.IntToString(from = Gravity.FILL_VERTICAL,     to = "FILL_VERTICAL"),
            @ViewDebug.IntToString(from = Gravity.CENTER_HORIZONTAL, to = "CENTER_HORIZONTAL"),
            @ViewDebug.IntToString(from = Gravity.FILL_HORIZONTAL,   to = "FILL_HORIZONTAL"),
            @ViewDebug.IntToString(from = Gravity.CENTER,            to = "CENTER"),
            @ViewDebug.IntToString(from = Gravity.FILL,              to = "FILL")
        })
        public int gravity = -1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.571 -0500", hash_original_method = "0C5088422FF05FC2926C96FAD09DECC3", hash_generated_method = "B33C0A3410ADF109BCB7358E5444EFC1")
        
public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);

            TypedArray a = c.obtainStyledAttributes(attrs,
                    com.android.internal.R.styleable.ActionBar_LayoutParams);
            gravity = a.getInt(
                    com.android.internal.R.styleable.ActionBar_LayoutParams_layout_gravity, -1);
            a.recycle();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.574 -0500", hash_original_method = "FA26D9655708BB18453CC96635B719BA", hash_generated_method = "44704B84EA29B0184A7C2CB2CEEA13AD")
        
public LayoutParams(int width, int height) {
            super(width, height);
            this.gravity = Gravity.CENTER_VERTICAL | Gravity.LEFT;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.577 -0500", hash_original_method = "DAE5F643078D3DA273ACC6BEF5E44EF2", hash_generated_method = "310A384600384362731FCC25D2DE3D0C")
        
public LayoutParams(int width, int height, int gravity) {
            super(width, height);
            this.gravity = gravity;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.580 -0500", hash_original_method = "1E229B236918B70DF8824536A68F9903", hash_generated_method = "2C368BFE2C649632890C49B1044250B4")
        
public LayoutParams(int gravity) {
            this(WRAP_CONTENT, MATCH_PARENT, gravity);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.582 -0500", hash_original_method = "C6FB589792A8182ED7F972345F7679A3", hash_generated_method = "B6031CB387F4B59E8A655B3D336FFECF")
        
public LayoutParams(LayoutParams source) {
            super(source);

            this.gravity = source.gravity;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.585 -0500", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "35FAB65EFD30EE5BC910187CB4DA6F67")
        
public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }
        
    }
    
    public interface OnNavigationListener {
        
        public boolean onNavigationItemSelected(int itemPosition, long itemId);
    }
    
    public interface OnMenuVisibilityListener {
        
        public void onMenuVisibilityChanged(boolean isVisible);
    }
    
    public interface TabListener {
        
        public void onTabSelected(Tab tab, FragmentTransaction ft);
        
        public void onTabUnselected(Tab tab, FragmentTransaction ft);
        
        public void onTabReselected(Tab tab, FragmentTransaction ft);
    }

    /**
     * Retrieve the current height of the ActionBar.
     *
     * @return The ActionBar's height
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.497 -0500", hash_original_method = "E09BF3A531DEFF54888EDA3B98EB9CFF", hash_generated_method = "D9FDFCA8B4CC6ACB03F0DDFF5E50C85D")
    
public abstract int getHeight();

    /**
     * Show the ActionBar if it is not currently showing.
     * If the window hosting the ActionBar does not have the feature
     * {@link Window#FEATURE_ACTION_BAR_OVERLAY} it will resize application
     * content to fit the new space available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.500 -0500", hash_original_method = "9067AC917FFB66A9E8FF84EA37A89CBE", hash_generated_method = "EBADF991BFA81CD6C874A387FE71E812")
    
public abstract void show();

    /**
     * Hide the ActionBar if it is currently showing.
     * If the window hosting the ActionBar does not have the feature
     * {@link Window#FEATURE_ACTION_BAR_OVERLAY} it will resize application
     * content to fit the new space available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.502 -0500", hash_original_method = "58365D1B8E35BD4BC81D336D692C97A2", hash_generated_method = "FE02920A742EFECAD317D7ABD9850091")
    
public abstract void hide();

    /**
     * @return <code>true</code> if the ActionBar is showing, <code>false</code> otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.504 -0500", hash_original_method = "C3BB9B135A4D4EFD4770D69B00362F45", hash_generated_method = "A6E9391606A75F587F3B11B70522971A")
    
public abstract boolean isShowing();

    /**
     * Add a listener that will respond to menu visibility change events.
     *
     * @param listener The new listener to add
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.506 -0500", hash_original_method = "A0EB2307D2177DB0E375516C4E84E1C6", hash_generated_method = "D3A3CFD9A6434CECAC6147D58A8092FB")
    
public abstract void addOnMenuVisibilityListener(OnMenuVisibilityListener listener);

    /**
     * Remove a menu visibility listener. This listener will no longer receive menu
     * visibility change events.
     *
     * @param listener A listener to remove that was previously added
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.508 -0500", hash_original_method = "FDBC01A5C6DC51A4F9497DFD457C5294", hash_generated_method = "B0AE552A748D3952BEE93437941C9F36")
    
public abstract void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener);

    /**
     * Enable or disable the "home" button in the corner of the action bar. (Note that this
     * is the application home/up affordance on the action bar, not the systemwide home
     * button.)
     *
     * <p>This defaults to true for packages targeting &lt; API 14. For packages targeting
     * API 14 or greater, the application should call this method to enable interaction
     * with the home/up affordance.
     *
     * <p>Setting the {@link #DISPLAY_HOME_AS_UP} display option will automatically enable
     * the home button.
     *
     * @param enabled true to enable the home button, false to disable the home button.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.511 -0500", hash_original_method = "B663ADC8583DEAC97152A4FAD7E4AA4D", hash_generated_method = "624E1920DC02D43F6969E9B91FAA838A")
    
public void setHomeButtonEnabled(boolean enabled) { }

    /**
     * Returns a {@link Context} with an appropriate theme for creating views that
     * will appear in the action bar. If you are inflating or instantiating custom views
     * that will appear in an action bar, you should use the Context returned by this method.
     * (This includes adapters used for list navigation mode.)
     * This will ensure that views contrast properly against the action bar.
     *
     * @return A themed Context for creating views
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.513 -0500", hash_original_method = "1844047509BF7744FF58A8E07C1F4469", hash_generated_method = "11CB943795DCD9E1EF76C82D67A0983E")
    
public Context getThemedContext() { return null; }
}

