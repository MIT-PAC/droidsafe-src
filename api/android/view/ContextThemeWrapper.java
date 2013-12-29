package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.ContextImpl;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;





public class ContextThemeWrapper extends ContextWrapper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:08.510 -0500", hash_original_field = "45A1FAFEC6ED7EF70B481175C79188A0", hash_generated_field = "D02AE2F3F4DE111CB9F997E29A53A060")

    private Context mBase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:08.511 -0500", hash_original_field = "161AF02869E770259B20B21155478DDE", hash_generated_field = "711AE5DF944659E06F58697BBCB3BF0C")

    private int mThemeResource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:08.512 -0500", hash_original_field = "FE80D7E6E1A3E40CD8C770E45A00F5D5", hash_generated_field = "816C159D6BCE886092ECEFD2959C8CB8")

    private Resources.Theme mTheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:08.512 -0500", hash_original_field = "B03B4DAE3F576B7166425BEE37B96C5E", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    
    @DSModeled(DSC.SPEC)
    public ContextThemeWrapper() {
        super(new ContextImpl());
    }

    
    @DSModeled(DSC.SPEC)
    public ContextThemeWrapper(Context base, int themeres) {
        super(base);
        addTaint(themeres);
        /*
        mBase = base;
        mThemeResource = themeres;
        */
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:08.516 -0500", hash_original_method = "78AA434171DBBE0A89D0F8DC1618D34C", hash_generated_method = "A3E53F65C4B9CCA66AC69BAB2FC338EC")
    @Override
protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        mBase = newBase;
    }

    
    @DSModeled(DSC.SPEC)
    @Override public void setTheme(int resid) {
    }

    
    @DSModeled(DSC.BAN)
    @Override
    public int getThemeResId() {
        return -1;
    }

    
    @DSModeled(DSC.SPEC)
    @Override public Resources.Theme getTheme() {
        return null;
    }

    
    @Override 
    @DSModeled(DSC.SAFE)
    public Object getSystemService(String name) {
        return super.getSystemService(name);
    }
    
    /**
     * Called by {@link #setTheme} and {@link #getTheme} to apply a theme
     * resource to the current Theme object.  Can override to change the
     * default (simple) behavior.  This method will not be called in multiple
     * threads simultaneously.
     *
     * @param theme The Theme object being modified.
     * @param resid The theme style resource being applied to <var>theme</var>.
     * @param first Set to true if this is the first time a style is being
     *              applied to <var>theme</var>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:08.520 -0500", hash_original_method = "8FCBAFBE19793DC1F6F481E8EF635F38", hash_generated_method = "4ADD98AE789941368E56BFC983506800")
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        theme.applyStyle(resid, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:08.521 -0500", hash_original_method = "274E46830CAE6261C7392F8B8EF11DA4", hash_generated_method = "0D45EC997A7E9836F3D441BCF2050F00")
    private void initializeTheme() {
        final boolean first = mTheme == null;
        if (first) {
            mTheme = getResources().newTheme();
            Resources.Theme theme = mBase.getTheme();
            if (theme != null) {
                mTheme.setTo(theme);
            }
        }
        onApplyThemeResource(mTheme, mThemeResource, first);
    }
    
}

