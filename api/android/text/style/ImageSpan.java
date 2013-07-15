package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import java.io.InputStream;

public class ImageSpan extends DynamicDrawableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.207 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "F17AF26B1AE93DE0DD2EED2442B6F076")

    private Drawable mDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.207 -0400", hash_original_field = "E793B03816B1EA3A9EE570ADD1129553", hash_generated_field = "5230A0318FFD99BBF5DCA1BF9243AE7A")

    private Uri mContentUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.207 -0400", hash_original_field = "3B71E056EB528FE6CFFAD85F16931309", hash_generated_field = "C75E6DA122FF842A3C7D587E6E200AF8")

    private int mResourceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.207 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.207 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "5EB2E77F51594E2C1DE90F3545DAFA8A")

    private String mSource;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.207 -0400", hash_original_method = "185ED0AA6BEAFCFF142A4CFD45E574FC", hash_generated_method = "A07A0D560E14AC6BFF5EC27074D850EF")
    @Deprecated
    public  ImageSpan(Bitmap b) {
        this(null, b, ALIGN_BOTTOM);
        addTaint(b.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.208 -0400", hash_original_method = "34B2A214F0FD529DA939313FB3C3E538", hash_generated_method = "77C5DA0FEECDA2D24ADCC808C431CB53")
    @Deprecated
    public  ImageSpan(Bitmap b, int verticalAlignment) {
        this(null, b, verticalAlignment);
        addTaint(verticalAlignment);
        addTaint(b.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.208 -0400", hash_original_method = "7AEE11D7D0A74AC540256E446F7A2408", hash_generated_method = "21FFED3993549E6821DBC1F04761E33C")
    public  ImageSpan(Context context, Bitmap b) {
        this(context, b, ALIGN_BOTTOM);
        addTaint(b.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.209 -0400", hash_original_method = "3963AA6755EF0F8E669BE02E5FE48B0A", hash_generated_method = "2524D1D768DDBFC39A0E22E5122E9AAF")
    public  ImageSpan(Context context, Bitmap b, int verticalAlignment) {
        super(verticalAlignment);
        addTaint(verticalAlignment);
        mContext = context;
        mDrawable = context != null
                ? new BitmapDrawable(context.getResources(), b)
                : new BitmapDrawable(b);
        int width = mDrawable.getIntrinsicWidth();
        int height = mDrawable.getIntrinsicHeight();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.209 -0400", hash_original_method = "0D126CCCA77E2FB90C8091AB4A5A8377", hash_generated_method = "E79200323EF1A04321E241174B1E2BBF")
    public  ImageSpan(Drawable d) {
        this(d, ALIGN_BOTTOM);
        addTaint(d.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.210 -0400", hash_original_method = "A8A2FDBB2FE3A38ECC14673F42D0EA39", hash_generated_method = "7C868265F77939D8B0FFB6275453F966")
    public  ImageSpan(Drawable d, int verticalAlignment) {
        super(verticalAlignment);
        addTaint(verticalAlignment);
        mDrawable = d;
        // ---------- Original Method ----------
        //mDrawable = d;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.210 -0400", hash_original_method = "54F6AA82EA4B003ADF5D8246E336A82D", hash_generated_method = "EC71403A83A3D1C8D727A64C56A569D9")
    public  ImageSpan(Drawable d, String source) {
        this(d, source, ALIGN_BOTTOM);
        addTaint(source.getTaint());
        addTaint(d.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.210 -0400", hash_original_method = "F9636F3F26DA70FC2592614F77D85D71", hash_generated_method = "6C1938C060D454D810FB1DE93CA1BC3A")
    public  ImageSpan(Drawable d, String source, int verticalAlignment) {
        super(verticalAlignment);
        addTaint(verticalAlignment);
        mDrawable = d;
        mSource = source;
        // ---------- Original Method ----------
        //mDrawable = d;
        //mSource = source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.211 -0400", hash_original_method = "E44302541FD4ECECF2698F7D07EBCA57", hash_generated_method = "A513108C546DEDD9250233754F222146")
    public  ImageSpan(Context context, Uri uri) {
        this(context, uri, ALIGN_BOTTOM);
        addTaint(uri.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.211 -0400", hash_original_method = "97E5D1114EAA0CA1A8404960D716AC3A", hash_generated_method = "47CEDD6A5E7BB632352DB482EBDF61E1")
    public  ImageSpan(Context context, Uri uri, int verticalAlignment) {
        super(verticalAlignment);
        addTaint(verticalAlignment);
        mContext = context;
        mContentUri = uri;
        mSource = uri.toString();
        // ---------- Original Method ----------
        //mContext = context;
        //mContentUri = uri;
        //mSource = uri.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.212 -0400", hash_original_method = "9E8FB6BDEE77C38D81FCBDDCFBDDF78F", hash_generated_method = "6F4EC877F52A846BC0321CC5CA9700CA")
    public  ImageSpan(Context context, int resourceId) {
        this(context, resourceId, ALIGN_BOTTOM);
        addTaint(resourceId);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.212 -0400", hash_original_method = "112063CFBD1BF410C553139A09CB99FD", hash_generated_method = "272708C29CD3CFC3BDEC0C73D1EFB411")
    public  ImageSpan(Context context, int resourceId, int verticalAlignment) {
        super(verticalAlignment);
        addTaint(verticalAlignment);
        mContext = context;
        mResourceId = resourceId;
        // ---------- Original Method ----------
        //mContext = context;
        //mResourceId = resourceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.213 -0400", hash_original_method = "16DECD9D0B2DB9DD9C51FE274851DFB5", hash_generated_method = "262718C151030B8F8717951B0E8FD6EB")
    @Override
    public Drawable getDrawable() {
        Drawable drawable = null;
    if(mDrawable != null)        
        {
            drawable = mDrawable;
        } //End block
        else
    if(mContentUri != null)        
        {
            Bitmap bitmap = null;
            try 
            {
                InputStream is = mContext.getContentResolver().openInputStream(
                        mContentUri);
                bitmap = BitmapFactory.decodeStream(is);
                drawable = new BitmapDrawable(mContext.getResources(), bitmap);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight());
                is.close();
            } //End block
            catch (Exception e)
            {
            } //End block
        } //End block
        else
        {
            try 
            {
                drawable = mContext.getResources().getDrawable(mResourceId);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight());
            } //End block
            catch (Exception e)
            {
            } //End block
        } //End block
Drawable varA22A26D75522826F9AEFA195DDDFD365_1091464886 =         drawable;
        varA22A26D75522826F9AEFA195DDDFD365_1091464886.addTaint(taint);
        return varA22A26D75522826F9AEFA195DDDFD365_1091464886;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.213 -0400", hash_original_method = "6D9DB226EA21C548410845AA7A7E2DD4", hash_generated_method = "4CB9D1FDB47A3A1D736DEE61ED737565")
    public String getSource() {
String varFD1075CFFA556ED219E8DC68F6D057EC_789605945 =         mSource;
        varFD1075CFFA556ED219E8DC68F6D057EC_789605945.addTaint(taint);
        return varFD1075CFFA556ED219E8DC68F6D057EC_789605945;
        // ---------- Original Method ----------
        //return mSource;
    }

    
}

