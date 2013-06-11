package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;

public class ContextThemeWrapper extends ContextWrapper {
    private Context mBase;
    private int mThemeResource;
    private Resources.Theme mTheme;
    private LayoutInflater mInflater;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.880 -0400", hash_original_method = "2CB22459058FC77C2233290E776C217F", hash_generated_method = "1A3837B4327DA47CE76C42D729BBC1A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContextThemeWrapper() {
        super(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.880 -0400", hash_original_method = "41565ED1870D25D8F04F2364AB693A1C", hash_generated_method = "6E47BA1DFD940C415063F74E438C6FEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContextThemeWrapper(Context base, int themeres) {
        super(base);
        dsTaint.addTaint(base.dsTaint);
        dsTaint.addTaint(themeres);
        // ---------- Original Method ----------
        //mBase = base;
        //mThemeResource = themeres;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.880 -0400", hash_original_method = "78AA434171DBBE0A89D0F8DC1618D34C", hash_generated_method = "59B1AC7AA1BB276FBC1AB54D2AD30A1D")
    @DSModeled(DSC.SAFE)
    @Override
    protected void attachBaseContext(Context newBase) {
        dsTaint.addTaint(newBase.dsTaint);
        super.attachBaseContext(newBase);
        // ---------- Original Method ----------
        //super.attachBaseContext(newBase);
        //mBase = newBase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.881 -0400", hash_original_method = "E97E7D3D0BCD16FFD8F18C9341C10283", hash_generated_method = "E2628C01938DD755B556197D99140ACC")
    @DSModeled(DSC.SAFE)
    @Override
    public void setTheme(int resid) {
        dsTaint.addTaint(resid);
        initializeTheme();
        // ---------- Original Method ----------
        //mThemeResource = resid;
        //initializeTheme();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.881 -0400", hash_original_method = "AE4733E1C9FA88CFC00EFC04FF1EA93F", hash_generated_method = "F0B043051679BE8D95920D442C212F43")
    @DSModeled(DSC.SAFE)
    @Override
    public int getThemeResId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mThemeResource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.881 -0400", hash_original_method = "21593966DDD7C797D13E86548D9AA1B9", hash_generated_method = "91CE23D5C5CD7B292F021A0E0537FF57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Resources.Theme getTheme() {
        mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                getApplicationInfo().targetSdkVersion);
        initializeTheme();
        return (Resources.Theme)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mTheme != null) {
            //return mTheme;
        //}
        //mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                //getApplicationInfo().targetSdkVersion);
        //initializeTheme();
        //return mTheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.881 -0400", hash_original_method = "3DDCB0207132CDAFA0BFC718C36A2A86", hash_generated_method = "C5FEEA75809AC9B79A85C9FE8AE269D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object getSystemService(String name) {
        dsTaint.addTaint(name);
        {
            boolean var28A5A9D11D394EF62378796E9CC200BC_1695672111 = (LAYOUT_INFLATER_SERVICE.equals(name));
            {
                {
                    mInflater = LayoutInflater.from(mBase).cloneInContext(this);
                } //End block
            } //End block
        } //End collapsed parenthetic
        Object var775837DC306FA3421E42286960084F37_628215453 = (mBase.getSystemService(name));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (LAYOUT_INFLATER_SERVICE.equals(name)) {
            //if (mInflater == null) {
                //mInflater = LayoutInflater.from(mBase).cloneInContext(this);
            //}
            //return mInflater;
        //}
        //return mBase.getSystemService(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.881 -0400", hash_original_method = "8FCBAFBE19793DC1F6F481E8EF635F38", hash_generated_method = "65496B5FE695E4415645104212C00B94")
    @DSModeled(DSC.SAFE)
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(resid);
        dsTaint.addTaint(theme.dsTaint);
        dsTaint.addTaint(first);
        theme.applyStyle(resid, true);
        // ---------- Original Method ----------
        //theme.applyStyle(resid, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.881 -0400", hash_original_method = "274E46830CAE6261C7392F8B8EF11DA4", hash_generated_method = "355741689DA25DD30AF88A521320E5D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initializeTheme() {
        final boolean first;
        first = mTheme == null;
        {
            mTheme = getResources().newTheme();
            Resources.Theme theme;
            theme = mBase.getTheme();
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


