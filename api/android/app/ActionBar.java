package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.SpinnerAdapter;

public abstract class ActionBar {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.183 -0400", hash_original_method = "6A41438E0ABBC5F08FB907D4E02D20B4", hash_generated_method = "6A41438E0ABBC5F08FB907D4E02D20B4")
    public ActionBar ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract void setCustomView(View view);

    
    @DSModeled(DSC.SAFE)
    public abstract void setCustomView(View view, LayoutParams layoutParams);

    
    @DSModeled(DSC.SAFE)
    public abstract void setCustomView(int resId);

    
    @DSModeled(DSC.SAFE)
    public abstract void setIcon(int resId);

    
    @DSModeled(DSC.SAFE)
    public abstract void setIcon(Drawable icon);

    
    @DSModeled(DSC.SAFE)
    public abstract void setLogo(int resId);

    
    @DSModeled(DSC.SAFE)
    public abstract void setLogo(Drawable logo);

    
    @DSModeled(DSC.SAFE)
    public abstract void setListNavigationCallbacks(SpinnerAdapter adapter,
            OnNavigationListener callback);

    
    @DSModeled(DSC.SAFE)
    public abstract void setSelectedNavigationItem(int position);

    
    @DSModeled(DSC.SAFE)
    public abstract int getSelectedNavigationIndex();

    
    @DSModeled(DSC.SAFE)
    public abstract int getNavigationItemCount();

    
    @DSModeled(DSC.SAFE)
    public abstract void setTitle(CharSequence title);

    
    @DSModeled(DSC.SAFE)
    public abstract void setTitle(int resId);

    
    @DSModeled(DSC.SAFE)
    public abstract void setSubtitle(CharSequence subtitle);

    
    @DSModeled(DSC.SAFE)
    public abstract void setSubtitle(int resId);

    
    @DSModeled(DSC.SAFE)
    public abstract void setDisplayOptions(int options);

    
    @DSModeled(DSC.SAFE)
    public abstract void setDisplayOptions(int options, int mask);

    
    @DSModeled(DSC.SAFE)
    public abstract void setDisplayUseLogoEnabled(boolean useLogo);

    
    @DSModeled(DSC.SAFE)
    public abstract void setDisplayShowHomeEnabled(boolean showHome);

    
    @DSModeled(DSC.SAFE)
    public abstract void setDisplayHomeAsUpEnabled(boolean showHomeAsUp);

    
    @DSModeled(DSC.SAFE)
    public abstract void setDisplayShowTitleEnabled(boolean showTitle);

    
    @DSModeled(DSC.SAFE)
    public abstract void setDisplayShowCustomEnabled(boolean showCustom);

    
    @DSModeled(DSC.SAFE)
    public abstract void setBackgroundDrawable(Drawable d);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.198 -0400", hash_original_method = "1C087D5A46FF67AB400586D7FD9EC5DB", hash_generated_method = "184ECC6E3A17064DE6557B26863E8FD7")
    public void setStackedBackgroundDrawable(Drawable d) {
        addTaint(d.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.200 -0400", hash_original_method = "195D6A86B8711735C7C3591D31E1AD73", hash_generated_method = "F99303F8EA7438E1CAFBF97E7B14E49B")
    public void setSplitBackgroundDrawable(Drawable d) {
        addTaint(d.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract View getCustomView();

    
    @DSModeled(DSC.SAFE)
    public abstract CharSequence getTitle();

    
    @DSModeled(DSC.SAFE)
    public abstract CharSequence getSubtitle();

    
    @DSModeled(DSC.SAFE)
    public abstract int getNavigationMode();

    
    @DSModeled(DSC.SAFE)
    public abstract void setNavigationMode(int mode);

    
    @DSModeled(DSC.SAFE)
    public abstract int getDisplayOptions();

    
    @DSModeled(DSC.SAFE)
    public abstract Tab newTab();

    
    @DSModeled(DSC.SAFE)
    public abstract void addTab(Tab tab);

    
    @DSModeled(DSC.SAFE)
    public abstract void addTab(Tab tab, boolean setSelected);

    
    @DSModeled(DSC.SAFE)
    public abstract void addTab(Tab tab, int position);

    
    @DSModeled(DSC.SAFE)
    public abstract void addTab(Tab tab, int position, boolean setSelected);

    
    @DSModeled(DSC.SAFE)
    public abstract void removeTab(Tab tab);

    
    @DSModeled(DSC.SAFE)
    public abstract void removeTabAt(int position);

    
    @DSModeled(DSC.SAFE)
    public abstract void removeAllTabs();

    
    @DSModeled(DSC.SAFE)
    public abstract void selectTab(Tab tab);

    
    @DSModeled(DSC.SAFE)
    public abstract Tab getSelectedTab();

    
    @DSModeled(DSC.SAFE)
    public abstract Tab getTabAt(int index);

    
    @DSModeled(DSC.SAFE)
    public abstract int getTabCount();

    
    @DSModeled(DSC.SAFE)
    public abstract int getHeight();

    
    @DSModeled(DSC.SAFE)
    public abstract void show();

    
    @DSModeled(DSC.SAFE)
    public abstract void hide();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isShowing();

    
    @DSModeled(DSC.SAFE)
    public abstract void addOnMenuVisibilityListener(OnMenuVisibilityListener listener);

    
    @DSModeled(DSC.SAFE)
    public abstract void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.220 -0400", hash_original_method = "B663ADC8583DEAC97152A4FAD7E4AA4D", hash_generated_method = "6820886889E9AAC2524F4C6D5D9C8B77")
    public void setHomeButtonEnabled(boolean enabled) {
        addTaint(enabled);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.221 -0400", hash_original_method = "1844047509BF7744FF58A8E07C1F4469", hash_generated_method = "2EA58731650D703EA4A04B19695CDE27")
    public Context getThemedContext() {
Context var540C13E9E156B687226421B24F2DF178_1562418328 =         null;
        var540C13E9E156B687226421B24F2DF178_1562418328.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1562418328;
        // ---------- Original Method ----------
        //return null;
    }

    
    public static abstract class Tab {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.222 -0400", hash_original_method = "FF0150C0A74BE2A44D0E92299D724EF7", hash_generated_method = "FF0150C0A74BE2A44D0E92299D724EF7")
        public Tab ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        public abstract int getPosition();

        
        @DSModeled(DSC.SAFE)
        public abstract Drawable getIcon();

        
        @DSModeled(DSC.SAFE)
        public abstract CharSequence getText();

        
        @DSModeled(DSC.SAFE)
        public abstract Tab setIcon(Drawable icon);

        
        @DSModeled(DSC.SAFE)
        public abstract Tab setIcon(int resId);

        
        @DSModeled(DSC.SAFE)
        public abstract Tab setText(CharSequence text);

        
        @DSModeled(DSC.SAFE)
        public abstract Tab setText(int resId);

        
        @DSModeled(DSC.SAFE)
        public abstract Tab setCustomView(View view);

        
        @DSModeled(DSC.SAFE)
        public abstract Tab setCustomView(int layoutResId);

        
        @DSModeled(DSC.SAFE)
        public abstract View getCustomView();

        
        @DSModeled(DSC.SAFE)
        public abstract Tab setTag(Object obj);

        
        @DSModeled(DSC.SAFE)
        public abstract Object getTag();

        
        @DSModeled(DSC.SAFE)
        public abstract Tab setTabListener(TabListener listener);

        
        @DSModeled(DSC.SAFE)
        public abstract void select();

        
        @DSModeled(DSC.SAFE)
        public abstract Tab setContentDescription(int resId);

        
        @DSModeled(DSC.SAFE)
        public abstract Tab setContentDescription(CharSequence contentDesc);

        
        @DSModeled(DSC.SAFE)
        public abstract CharSequence getContentDescription();

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.242 -0400", hash_original_field = "78D008574FF4877A72651C9D9100850E", hash_generated_field = "74326D0EB2E635FB68B20B0C678CCDFD")

        public static final int INVALID_POSITION = -1;
    }


    
    public static class LayoutParams extends MarginLayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.243 -0400", hash_original_field = "CF0F2AF9EE62920A17A205053A2F0423", hash_generated_field = "FAEF7A7065C713E6BE770418AEAE4491")

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
        }) public int gravity = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.245 -0400", hash_original_method = "0C5088422FF05FC2926C96FAD09DECC3", hash_generated_method = "49AE37E83C3378BD18C3595DA84C3148")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            addTaint(attrs.getTaint());
            addTaint(c.getTaint());
            TypedArray a = c.obtainStyledAttributes(attrs,
                    com.android.internal.R.styleable.ActionBar_LayoutParams);
            gravity = a.getInt(
                    com.android.internal.R.styleable.ActionBar_LayoutParams_layout_gravity, -1);
            a.recycle();
            // ---------- Original Method ----------
            //TypedArray a = c.obtainStyledAttributes(attrs,
                    //com.android.internal.R.styleable.ActionBar_LayoutParams);
            //gravity = a.getInt(
                    //com.android.internal.R.styleable.ActionBar_LayoutParams_layout_gravity, -1);
            //a.recycle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.248 -0400", hash_original_method = "FA26D9655708BB18453CC96635B719BA", hash_generated_method = "0259064E1CFB8B6C49E2B67E07E7A2E1")
        public  LayoutParams(int width, int height) {
            super(width, height);
            addTaint(height);
            addTaint(width);
            this.gravity = Gravity.CENTER_VERTICAL | Gravity.LEFT;
            // ---------- Original Method ----------
            //this.gravity = Gravity.CENTER_VERTICAL | Gravity.LEFT;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.251 -0400", hash_original_method = "DAE5F643078D3DA273ACC6BEF5E44EF2", hash_generated_method = "27498D82F6D69AD0E938F26B275A02B5")
        public  LayoutParams(int width, int height, int gravity) {
            super(width, height);
            addTaint(height);
            addTaint(width);
            this.gravity = gravity;
            // ---------- Original Method ----------
            //this.gravity = gravity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.253 -0400", hash_original_method = "1E229B236918B70DF8824536A68F9903", hash_generated_method = "DBB79DA2A636AB74506B8B42DC4CEFF1")
        public  LayoutParams(int gravity) {
            this(WRAP_CONTENT, MATCH_PARENT, gravity);
            addTaint(gravity);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.257 -0400", hash_original_method = "C6FB589792A8182ED7F972345F7679A3", hash_generated_method = "8E39C66623B5358AA844FC9426251CA5")
        public  LayoutParams(LayoutParams source) {
            super(source);
            this.gravity = source.gravity;
            // ---------- Original Method ----------
            //this.gravity = source.gravity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.260 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "37A5DBEF9177864A03971A9D81D7D3EE")
        public  LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.263 -0400", hash_original_field = "C8CF8EFF14A0BFBFE7B9B51B073ECA90", hash_generated_field = "F325EF02C9FC2C1CC6B930C3BC286C7F")

    public static final int NAVIGATION_MODE_STANDARD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.264 -0400", hash_original_field = "5E92C466DE1E83203D02EE7FB88C1830", hash_generated_field = "FA4862B760D228A8469E7FF77A649E27")

    public static final int NAVIGATION_MODE_LIST = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.265 -0400", hash_original_field = "D6FEA3F972D36355A7E7FF75B6AF174C", hash_generated_field = "FC5DE487CCB5A0CFA5AAFFADCBED57AE")

    public static final int NAVIGATION_MODE_TABS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.267 -0400", hash_original_field = "32127B75605A28CF4F311D2F92040186", hash_generated_field = "FB67EE86B0F3ED8D655401C61DEB80C4")

    public static final int DISPLAY_USE_LOGO = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.267 -0400", hash_original_field = "0F8D149D7FADAB5CB3787E6B784D6CFF", hash_generated_field = "A8BE794CF21F9DB76A32D4D71CFF08D5")

    public static final int DISPLAY_SHOW_HOME = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.268 -0400", hash_original_field = "001E5A19FC43222FF3D87C76DDFB33AE", hash_generated_field = "97D567A384C38093D4C9BEBF75BACF25")

    public static final int DISPLAY_HOME_AS_UP = 0x4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.269 -0400", hash_original_field = "68DDDCA461F2B0C4119A12C69CCD441F", hash_generated_field = "497402E055CEA6270B77283114307D15")

    public static final int DISPLAY_SHOW_TITLE = 0x8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.270 -0400", hash_original_field = "7F66E71855DA2CD321B8FDE1799BF718", hash_generated_field = "989902DA33165C818CD245DC87485645")

    public static final int DISPLAY_SHOW_CUSTOM = 0x10;
}

