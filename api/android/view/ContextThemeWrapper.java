package android.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.app.ContextImpl;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;





public class ContextThemeWrapper extends ContextWrapper {
    private Context mBase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.606 -0400", hash_original_field = "1A7BE5C50406CFB30A072C422592257E", hash_generated_field = "711AE5DF944659E06F58697BBCB3BF0C")

    private int mThemeResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.606 -0400", hash_original_field = "F33340182B9891501636E62AEA88BE69", hash_generated_field = "816C159D6BCE886092ECEFD2959C8CB8")

    private Resources.Theme mTheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.607 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

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

    
    @DSModeled(DSC.SAFE)
    @Override protected void attachBaseContext(Context newBase) {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.611 -0400", hash_original_method = "8FCBAFBE19793DC1F6F481E8EF635F38", hash_generated_method = "E2663BE27D6C4E8C87CFAFE15029DEFE")
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(first);
        addTaint(resid);
        addTaint(theme.getTaint());
        theme.applyStyle(resid, true);
        // ---------- Original Method ----------
        //theme.applyStyle(resid, true);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.611 -0400", hash_original_method = "274E46830CAE6261C7392F8B8EF11DA4", hash_generated_method = "6F51DC32008736AA454500B75DDF7DAC")
    private void initializeTheme() {
        final boolean first = mTheme == null;
        if(first)        
        {
            mTheme = getResources().newTheme();
            Resources.Theme theme = mBase.getTheme();
            if(theme != null)            
            {
                mTheme.setTo(theme);
            } //End block
        } //End block
        onApplyThemeResource(mTheme, mThemeResource, first);
        // ---------- Original Method ----------
        //final boolean first = mTheme == null;
        //if (first) {
            //mTheme = getResources().newTheme();
            //Resources.Theme theme = mBase.getTheme();
            //if (theme != null) {
                //mTheme.setTo(theme);
            //}
        //}
        //onApplyThemeResource(mTheme, mThemeResource, first);
    }
    
}

