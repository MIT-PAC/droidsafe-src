package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import java.io.InputStream;

public class ImageSpan extends DynamicDrawableSpan {
    private Drawable mDrawable;
    private Uri mContentUri;
    private int mResourceId;
    private Context mContext;
    private String mSource;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.872 -0400", hash_original_method = "185ED0AA6BEAFCFF142A4CFD45E574FC", hash_generated_method = "A7C0F0E19DFF29EEA8AECF78D394F281")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public ImageSpan(Bitmap b) {
        this(null, b, ALIGN_BOTTOM);
        dsTaint.addTaint(b.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.872 -0400", hash_original_method = "34B2A214F0FD529DA939313FB3C3E538", hash_generated_method = "8D8E3063E9E9EF9A204CE79E8239F705")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public ImageSpan(Bitmap b, int verticalAlignment) {
        this(null, b, verticalAlignment);
        dsTaint.addTaint(verticalAlignment);
        dsTaint.addTaint(b.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.872 -0400", hash_original_method = "7AEE11D7D0A74AC540256E446F7A2408", hash_generated_method = "D3A7414F88F9FAC7D23AADAF174A5CD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageSpan(Context context, Bitmap b) {
        this(context, b, ALIGN_BOTTOM);
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.873 -0400", hash_original_method = "3963AA6755EF0F8E669BE02E5FE48B0A", hash_generated_method = "7E2B9796CAA53AA5A00375BE1E9F1854")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageSpan(Context context, Bitmap b, int verticalAlignment) {
        super(verticalAlignment);
        dsTaint.addTaint(verticalAlignment);
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mDrawable = context != null
                ? new BitmapDrawable(context.getResources(), b)
                : new BitmapDrawable(b);
        int width;
        width = mDrawable.getIntrinsicWidth();
        int height;
        height = mDrawable.getIntrinsicHeight();
        mDrawable.setBounds(0, 0, width > 0 ? width : 0, height > 0 ? height : 0);
        // ---------- Original Method ----------
        //mContext = context;
        //mDrawable = context != null
                //? new BitmapDrawable(context.getResources(), b)
                //: new BitmapDrawable(b);
        //int width = mDrawable.getIntrinsicWidth();
        //int height = mDrawable.getIntrinsicHeight();
        //mDrawable.setBounds(0, 0, width > 0 ? width : 0, height > 0 ? height : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.873 -0400", hash_original_method = "0D126CCCA77E2FB90C8091AB4A5A8377", hash_generated_method = "57BCE3C6E6A5480EB70B9F207D566728")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageSpan(Drawable d) {
        this(d, ALIGN_BOTTOM);
        dsTaint.addTaint(d.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.873 -0400", hash_original_method = "A8A2FDBB2FE3A38ECC14673F42D0EA39", hash_generated_method = "64BE549F211F893D45920CE5171BBDAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageSpan(Drawable d, int verticalAlignment) {
        super(verticalAlignment);
        dsTaint.addTaint(verticalAlignment);
        dsTaint.addTaint(d.dsTaint);
        // ---------- Original Method ----------
        //mDrawable = d;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.873 -0400", hash_original_method = "54F6AA82EA4B003ADF5D8246E336A82D", hash_generated_method = "FFB52D8608302D07A8E60E3CE07E412D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageSpan(Drawable d, String source) {
        this(d, source, ALIGN_BOTTOM);
        dsTaint.addTaint(d.dsTaint);
        dsTaint.addTaint(source);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.873 -0400", hash_original_method = "F9636F3F26DA70FC2592614F77D85D71", hash_generated_method = "91C268FF373C1C8D74C2B50DBEAA2C71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageSpan(Drawable d, String source, int verticalAlignment) {
        super(verticalAlignment);
        dsTaint.addTaint(verticalAlignment);
        dsTaint.addTaint(d.dsTaint);
        dsTaint.addTaint(source);
        // ---------- Original Method ----------
        //mDrawable = d;
        //mSource = source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.874 -0400", hash_original_method = "E44302541FD4ECECF2698F7D07EBCA57", hash_generated_method = "52EB37E9349B394036DA667F8B121B1E")
    @DSModeled(DSC.SPEC)
    public ImageSpan(Context context, Uri uri) {
        this(context, uri, ALIGN_BOTTOM);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.874 -0400", hash_original_method = "97E5D1114EAA0CA1A8404960D716AC3A", hash_generated_method = "B0B6DF063EBAB9FF7B736245392A7621")
    @DSModeled(DSC.SPEC)
    public ImageSpan(Context context, Uri uri, int verticalAlignment) {
        super(verticalAlignment);
        dsTaint.addTaint(verticalAlignment);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        mSource = uri.toString();
        // ---------- Original Method ----------
        //mContext = context;
        //mContentUri = uri;
        //mSource = uri.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.874 -0400", hash_original_method = "9E8FB6BDEE77C38D81FCBDDCFBDDF78F", hash_generated_method = "75478E821447A5CD9AB4BBC68CA30166")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageSpan(Context context, int resourceId) {
        this(context, resourceId, ALIGN_BOTTOM);
        dsTaint.addTaint(resourceId);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.874 -0400", hash_original_method = "112063CFBD1BF410C553139A09CB99FD", hash_generated_method = "F85257A12EA8AFFF82EBAE629DED8936")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageSpan(Context context, int resourceId, int verticalAlignment) {
        super(verticalAlignment);
        dsTaint.addTaint(verticalAlignment);
        dsTaint.addTaint(resourceId);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mContext = context;
        //mResourceId = resourceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.875 -0400", hash_original_method = "16DECD9D0B2DB9DD9C51FE274851DFB5", hash_generated_method = "07197BB76568F8958EC49210AA49865B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable getDrawable() {
        Drawable drawable;
        drawable = null;
        {
            drawable = mDrawable;
        } //End block
        {
            Bitmap bitmap;
            bitmap = null;
            try 
            {
                InputStream is;
                is = mContext.getContentResolver().openInputStream(
                        mContentUri);
                bitmap = BitmapFactory.decodeStream(is);
                drawable = new BitmapDrawable(mContext.getResources(), bitmap);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight());
                is.close();
            } //End block
            catch (Exception e)
            { }
        } //End block
        {
            try 
            {
                drawable = mContext.getResources().getDrawable(mResourceId);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight());
            } //End block
            catch (Exception e)
            { }
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.882 -0400", hash_original_method = "6D9DB226EA21C548410845AA7A7E2DD4", hash_generated_method = "8E73B93371D944CBA4BEDEC66F32A596")
    @DSModeled(DSC.SAFE)
    public String getSource() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSource;
    }

    
}

