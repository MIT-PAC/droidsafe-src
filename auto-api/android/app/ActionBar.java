package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.192 -0400", hash_original_method = "6A41438E0ABBC5F08FB907D4E02D20B4", hash_generated_method = "6A41438E0ABBC5F08FB907D4E02D20B4")
    public ActionBar ()
    {
        //Synthesized constructor
    }


    public abstract void setCustomView(View view);

    
    public abstract void setCustomView(View view, LayoutParams layoutParams);

    
    public abstract void setCustomView(int resId);

    
    public abstract void setIcon(int resId);

    
    public abstract void setIcon(Drawable icon);

    
    public abstract void setLogo(int resId);

    
    public abstract void setLogo(Drawable logo);

    
    public abstract void setListNavigationCallbacks(SpinnerAdapter adapter,
            OnNavigationListener callback);

    
    public abstract void setSelectedNavigationItem(int position);

    
    public abstract int getSelectedNavigationIndex();

    
    public abstract int getNavigationItemCount();

    
    public abstract void setTitle(CharSequence title);

    
    public abstract void setTitle(int resId);

    
    public abstract void setSubtitle(CharSequence subtitle);

    
    public abstract void setSubtitle(int resId);

    
    public abstract void setDisplayOptions(int options);

    
    public abstract void setDisplayOptions(int options, int mask);

    
    public abstract void setDisplayUseLogoEnabled(boolean useLogo);

    
    public abstract void setDisplayShowHomeEnabled(boolean showHome);

    
    public abstract void setDisplayHomeAsUpEnabled(boolean showHomeAsUp);

    
    public abstract void setDisplayShowTitleEnabled(boolean showTitle);

    
    public abstract void setDisplayShowCustomEnabled(boolean showCustom);

    
    public abstract void setBackgroundDrawable(Drawable d);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.201 -0400", hash_original_method = "1C087D5A46FF67AB400586D7FD9EC5DB", hash_generated_method = "184ECC6E3A17064DE6557B26863E8FD7")
    public void setStackedBackgroundDrawable(Drawable d) {
        addTaint(d.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.201 -0400", hash_original_method = "195D6A86B8711735C7C3591D31E1AD73", hash_generated_method = "F99303F8EA7438E1CAFBF97E7B14E49B")
    public void setSplitBackgroundDrawable(Drawable d) {
        addTaint(d.getTaint());
        // ---------- Original Method ----------
    }

    
    public abstract View getCustomView();

    
    public abstract CharSequence getTitle();

    
    public abstract CharSequence getSubtitle();

    
    public abstract int getNavigationMode();

    
    public abstract void setNavigationMode(int mode);

    
    public abstract int getDisplayOptions();

    
    public abstract Tab newTab();

    
    public abstract void addTab(Tab tab);

    
    public abstract void addTab(Tab tab, boolean setSelected);

    
    public abstract void addTab(Tab tab, int position);

    
    public abstract void addTab(Tab tab, int position, boolean setSelected);

    
    public abstract void removeTab(Tab tab);

    
    public abstract void removeTabAt(int position);

    
    public abstract void removeAllTabs();

    
    public abstract void selectTab(Tab tab);

    
    public abstract Tab getSelectedTab();

    
    public abstract Tab getTabAt(int index);

    
    public abstract int getTabCount();

    
    public abstract int getHeight();

    
    public abstract void show();

    
    public abstract void hide();

    
    public abstract boolean isShowing();

    
    public abstract void addOnMenuVisibilityListener(OnMenuVisibilityListener listener);

    
    public abstract void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.210 -0400", hash_original_method = "B663ADC8583DEAC97152A4FAD7E4AA4D", hash_generated_method = "6820886889E9AAC2524F4C6D5D9C8B77")
    public void setHomeButtonEnabled(boolean enabled) {
        addTaint(enabled);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.211 -0400", hash_original_method = "1844047509BF7744FF58A8E07C1F4469", hash_generated_method = "155CC78B045B1065C82EC2BEFE1F4BF9")
    public Context getThemedContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_1114896093 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1114896093 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1114896093.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1114896093;
        // ---------- Original Method ----------
        //return null;
    }

    
    public static abstract class Tab {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.211 -0400", hash_original_method = "FF0150C0A74BE2A44D0E92299D724EF7", hash_generated_method = "FF0150C0A74BE2A44D0E92299D724EF7")
        public Tab ()
        {
            //Synthesized constructor
        }


        public abstract int getPosition();

        
        public abstract Drawable getIcon();

        
        public abstract CharSequence getText();

        
        public abstract Tab setIcon(Drawable icon);

        
        public abstract Tab setIcon(int resId);

        
        public abstract Tab setText(CharSequence text);

        
        public abstract Tab setText(int resId);

        
        public abstract Tab setCustomView(View view);

        
        public abstract Tab setCustomView(int layoutResId);

        
        public abstract View getCustomView();

        
        public abstract Tab setTag(Object obj);

        
        public abstract Object getTag();

        
        public abstract Tab setTabListener(TabListener listener);

        
        public abstract void select();

        
        public abstract Tab setContentDescription(int resId);

        
        public abstract Tab setContentDescription(CharSequence contentDesc);

        
        public abstract CharSequence getContentDescription();

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.218 -0400", hash_original_field = "78D008574FF4877A72651C9D9100850E", hash_generated_field = "74326D0EB2E635FB68B20B0C678CCDFD")

        public static final int INVALID_POSITION = -1;
    }


    
    public static class LayoutParams extends MarginLayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.219 -0400", hash_original_field = "CF0F2AF9EE62920A17A205053A2F0423", hash_generated_field = "FAEF7A7065C713E6BE770418AEAE4491")

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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.219 -0400", hash_original_method = "0C5088422FF05FC2926C96FAD09DECC3", hash_generated_method = "CE34EB6609BEAA0F3BCE9942BE5B1391")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a = c.obtainStyledAttributes(attrs,
                    com.android.internal.R.styleable.ActionBar_LayoutParams);
            gravity = a.getInt(
                    com.android.internal.R.styleable.ActionBar_LayoutParams_layout_gravity, -1);
            a.recycle();
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            // ---------- Original Method ----------
            //TypedArray a = c.obtainStyledAttributes(attrs,
                    //com.android.internal.R.styleable.ActionBar_LayoutParams);
            //gravity = a.getInt(
                    //com.android.internal.R.styleable.ActionBar_LayoutParams_layout_gravity, -1);
            //a.recycle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.220 -0400", hash_original_method = "FA26D9655708BB18453CC96635B719BA", hash_generated_method = "7E3AC877C7B6F6ABAE193363622C8993")
        public  LayoutParams(int width, int height) {
            super(width, height);
            this.gravity = Gravity.CENTER_VERTICAL | Gravity.LEFT;
            addTaint(width);
            addTaint(height);
            // ---------- Original Method ----------
            //this.gravity = Gravity.CENTER_VERTICAL | Gravity.LEFT;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.221 -0400", hash_original_method = "DAE5F643078D3DA273ACC6BEF5E44EF2", hash_generated_method = "C357A3787BC69F6F5D2217C4533A3061")
        public  LayoutParams(int width, int height, int gravity) {
            super(width, height);
            this.gravity = gravity;
            addTaint(width);
            addTaint(height);
            // ---------- Original Method ----------
            //this.gravity = gravity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.222 -0400", hash_original_method = "1E229B236918B70DF8824536A68F9903", hash_generated_method = "DBB79DA2A636AB74506B8B42DC4CEFF1")
        public  LayoutParams(int gravity) {
            this(WRAP_CONTENT, MATCH_PARENT, gravity);
            addTaint(gravity);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.222 -0400", hash_original_method = "C6FB589792A8182ED7F972345F7679A3", hash_generated_method = "8E39C66623B5358AA844FC9426251CA5")
        public  LayoutParams(LayoutParams source) {
            super(source);
            this.gravity = source.gravity;
            // ---------- Original Method ----------
            //this.gravity = source.gravity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.223 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "37A5DBEF9177864A03971A9D81D7D3EE")
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.223 -0400", hash_original_field = "C8CF8EFF14A0BFBFE7B9B51B073ECA90", hash_generated_field = "F325EF02C9FC2C1CC6B930C3BC286C7F")

    public static final int NAVIGATION_MODE_STANDARD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.224 -0400", hash_original_field = "5E92C466DE1E83203D02EE7FB88C1830", hash_generated_field = "FA4862B760D228A8469E7FF77A649E27")

    public static final int NAVIGATION_MODE_LIST = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.224 -0400", hash_original_field = "D6FEA3F972D36355A7E7FF75B6AF174C", hash_generated_field = "FC5DE487CCB5A0CFA5AAFFADCBED57AE")

    public static final int NAVIGATION_MODE_TABS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.225 -0400", hash_original_field = "32127B75605A28CF4F311D2F92040186", hash_generated_field = "FB67EE86B0F3ED8D655401C61DEB80C4")

    public static final int DISPLAY_USE_LOGO = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.225 -0400", hash_original_field = "0F8D149D7FADAB5CB3787E6B784D6CFF", hash_generated_field = "A8BE794CF21F9DB76A32D4D71CFF08D5")

    public static final int DISPLAY_SHOW_HOME = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.225 -0400", hash_original_field = "001E5A19FC43222FF3D87C76DDFB33AE", hash_generated_field = "97D567A384C38093D4C9BEBF75BACF25")

    public static final int DISPLAY_HOME_AS_UP = 0x4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.225 -0400", hash_original_field = "68DDDCA461F2B0C4119A12C69CCD441F", hash_generated_field = "497402E055CEA6270B77283114307D15")

    public static final int DISPLAY_SHOW_TITLE = 0x8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.226 -0400", hash_original_field = "7F66E71855DA2CD321B8FDE1799BF718", hash_generated_field = "989902DA33165C818CD245DC87485645")

    public static final int DISPLAY_SHOW_CUSTOM = 0x10;
}

