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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.854 -0400", hash_original_method = "7FE82729A4350087E8120845457EF2F6", hash_generated_method = "7FE82729A4350087E8120845457EF2F6")
        public ActionBar ()
    {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.874 -0400", hash_original_method = "1C087D5A46FF67AB400586D7FD9EC5DB", hash_generated_method = "2BEDA35FC9EFAA7BBE9B3FEA7DEC2C9F")
    @DSModeled(DSC.SAFE)
    public void setStackedBackgroundDrawable(Drawable d) {
        dsTaint.addTaint(d.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.875 -0400", hash_original_method = "195D6A86B8711735C7C3591D31E1AD73", hash_generated_method = "18DE0040F078A10C2B6F1719D2AF63FB")
    @DSModeled(DSC.SAFE)
    public void setSplitBackgroundDrawable(Drawable d) {
        dsTaint.addTaint(d.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.894 -0400", hash_original_method = "B663ADC8583DEAC97152A4FAD7E4AA4D", hash_generated_method = "1FDE80D9147E1676A9833EC0C0FB44BB")
    @DSModeled(DSC.SAFE)
    public void setHomeButtonEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.895 -0400", hash_original_method = "1844047509BF7744FF58A8E07C1F4469", hash_generated_method = "BFBC4D74B29E21FF81F730EF2746FFD6")
    @DSModeled(DSC.SAFE)
    public Context getThemedContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    public static abstract class Tab {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.895 -0400", hash_original_method = "A6B4107A6F7A34F726190D376901C6BD", hash_generated_method = "A6B4107A6F7A34F726190D376901C6BD")
                public Tab ()
        {
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

        
        public static final int INVALID_POSITION = -1;
    }


    
    public static class LayoutParams extends MarginLayoutParams {
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.905 -0400", hash_original_method = "0C5088422FF05FC2926C96FAD09DECC3", hash_generated_method = "B0D0B07A17CCE02584BFFFD9E7BD0DF9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(attrs.dsTaint);
            TypedArray a;
            a = c.obtainStyledAttributes(attrs,
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.906 -0400", hash_original_method = "FA26D9655708BB18453CC96635B719BA", hash_generated_method = "71BCBA6F396E9966FF0A68FCBFC79989")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int width, int height) {
            super(width, height);
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            this.gravity = Gravity.CENTER_VERTICAL | Gravity.LEFT;
            // ---------- Original Method ----------
            //this.gravity = Gravity.CENTER_VERTICAL | Gravity.LEFT;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.906 -0400", hash_original_method = "DAE5F643078D3DA273ACC6BEF5E44EF2", hash_generated_method = "4572ACE587AE879584DF2A3E9FDE0E61")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int width, int height, int gravity) {
            super(width, height);
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            dsTaint.addTaint(gravity);
            // ---------- Original Method ----------
            //this.gravity = gravity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.907 -0400", hash_original_method = "1E229B236918B70DF8824536A68F9903", hash_generated_method = "95AE97916AD9695AA7146681410D9C9D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int gravity) {
            this(WRAP_CONTENT, MATCH_PARENT, gravity);
            dsTaint.addTaint(gravity);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.908 -0400", hash_original_method = "C6FB589792A8182ED7F972345F7679A3", hash_generated_method = "94927B699C64058A9D9F85C6DCAB4BAD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(LayoutParams source) {
            super(source);
            dsTaint.addTaint(source.dsTaint);
            this.gravity = source.gravity;
            // ---------- Original Method ----------
            //this.gravity = source.gravity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.908 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "1B8A923CB2D1359AEB1E56B11A4FD570")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            dsTaint.addTaint(source.dsTaint);
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
    
    public static final int NAVIGATION_MODE_STANDARD = 0;
    public static final int NAVIGATION_MODE_LIST = 1;
    public static final int NAVIGATION_MODE_TABS = 2;
    public static final int DISPLAY_USE_LOGO = 0x1;
    public static final int DISPLAY_SHOW_HOME = 0x2;
    public static final int DISPLAY_HOME_AS_UP = 0x4;
    public static final int DISPLAY_SHOW_TITLE = 0x8;
    public static final int DISPLAY_SHOW_CUSTOM = 0x10;
}

