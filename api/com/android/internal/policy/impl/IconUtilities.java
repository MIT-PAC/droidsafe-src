package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Rect;
import android.graphics.ColorMatrixColorFilter;
import android.view.ContextThemeWrapper;
import android.util.Log;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.text.TextPaint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.PaintDrawable;
import android.util.DisplayMetrics;
import android.content.res.Resources;
import android.graphics.TableMaskFilter;
import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.graphics.drawable.Drawable;
import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.BlurMaskFilter;
import android.graphics.ColorMatrix;
import android.graphics.drawable.StateListDrawable;
import android.text.StaticLayout;
import android.text.Layout.Alignment;
import android.graphics.Typeface;
final class IconUtilities {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.054 -0400", hash_original_field = "7FEA2E52EA2025576CADC32A985C7411", hash_generated_field = "A6AEE1100E30124E34564FA19507C183")

    private int mIconWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.055 -0400", hash_original_field = "91695EBCE70624FF133CA04C06351B7F", hash_generated_field = "07705B2DCE1925A6A993F1924D8167EB")

    private int mIconHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.055 -0400", hash_original_field = "44356B3897BCFF3B2F5ACF9E094B7605", hash_generated_field = "4745F88192F1C9B967EAC9ED3A83C83E")

    private int mIconTextureWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.056 -0400", hash_original_field = "9B8E04DD050F1E7652D754803F5E6B31", hash_generated_field = "1673C920F02DB8AB7136E0DC97B5A6E6")

    private int mIconTextureHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.056 -0400", hash_original_field = "1F593C5E1FA9C53F92379484654564D2", hash_generated_field = "90B0608AB53F75A0AC388611FFB8AF86")

    private final Paint mPaint = new Paint();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.056 -0400", hash_original_field = "F90F90C965B9FD5FDD46F2970A0095BD", hash_generated_field = "D9349472EC3288F3A54283C1CC774090")

    private final Paint mBlurPaint = new Paint();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.056 -0400", hash_original_field = "245A315955A601BBF9C81F78C0063010", hash_generated_field = "947296C0629BDB176F0CCEB271F88CBD")

    private final Paint mGlowColorPressedPaint = new Paint();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.057 -0400", hash_original_field = "A68F27F2811496213BA42C842B81B98A", hash_generated_field = "74516CAD51FCA92025E1CCC90F50CFDA")

    private final Paint mGlowColorFocusedPaint = new Paint();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.057 -0400", hash_original_field = "9FFBBF1A237727D2E7C8411D7925FBFC", hash_generated_field = "8B2E31DC71421C99D9717DC4633665EA")

    private final Rect mOldBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.057 -0400", hash_original_field = "B3962E7B3AD995E1F77F1F550AD57179", hash_generated_field = "836481C9D2441E0FBFB4B8E9FC9C569A")

    private final Canvas mCanvas = new Canvas();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.057 -0400", hash_original_field = "46173670FA3604779A1C1CD98CB30E8E", hash_generated_field = "D677A4323A370A58C33D323A072CFE1B")

    private DisplayMetrics mDisplayMetrics;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.057 -0400", hash_original_field = "114D5B325952FED2A2BE511F2E5C25BD", hash_generated_field = "48FC94FDDF211D992AD2EB6825C0D8A6")

    private int mColorIndex = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.059 -0400", hash_original_method = "CEC887487F5F6C8660BC44043B4A566E", hash_generated_method = "8EBE6629429A358EE1CDA0F11C399888")
    public  IconUtilities(Context context) {
        addTaint(context.getTaint());
        final Resources resources = context.getResources();
        DisplayMetrics metrics = mDisplayMetrics = resources.getDisplayMetrics();
        final float density = metrics.density;
        final float blurPx = 5 * density;
mIconWidth=mIconHeight=(int) resources.getDimension(android.R.dimen.app_icon_size)mIconTextureWidth=mIconTextureHeight=mIconWidth+(int) (blurPx*2)mBlurPaint.setMaskFilter(new BlurMaskFilter(blurPx, BlurMaskFilter.Blur.NORMAL))        TypedValue value = new TypedValue();
mGlowColorPressedPaint.setColor(context.getTheme().resolveAttribute(android.R.attr.colorPressedHighlight, value, true)?value.data:value.data)mGlowColorPressedPaint.setMaskFilter(TableMaskFilter.CreateClipTable(0, 30))mGlowColorFocusedPaint.setColor(context.getTheme().resolveAttribute(android.R.attr.colorFocusedHighlight, value, true)?value.data:value.data)mGlowColorFocusedPaint.setMaskFilter(TableMaskFilter.CreateClipTable(0, 30))        ColorMatrix cm = new ColorMatrix();
cm.setSaturation(0.2f)mCanvas.setDrawFilter(new PaintFlagsDrawFilter(Paint.DITHER_FLAG, Paint.FILTER_BITMAP_FLAG))
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.060 -0400", hash_original_method = "BAFD943617F92E2D1C0F9522F52A4C7F", hash_generated_method = "6687C3DF70F3A169092B418B023069A9")
    public Drawable createIconDrawable(Drawable src) {
        addTaint(src.getTaint());
        Bitmap scaled = createIconBitmap(src);
        StateListDrawable result = new StateListDrawable();
result.addState(new int, new BitmapDrawable(createSelectedBitmap(scaled, false)))result.addState(new int, new BitmapDrawable(createSelectedBitmap(scaled, true)))result.addState(new int, new BitmapDrawable(scaled))result.setBounds(0, 0, mIconTextureWidth, mIconTextureHeight)Drawable varDC838461EE2FA0CA4C9BBB70A15456B0_620907350 = result        varDC838461EE2FA0CA4C9BBB70A15456B0_620907350.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_620907350;
        // ---------- Original Method ----------
        //Bitmap scaled = createIconBitmap(src);
        //StateListDrawable result = new StateListDrawable();
        //result.addState(new int[] { android.R.attr.state_focused },
                //new BitmapDrawable(createSelectedBitmap(scaled, false)));
        //result.addState(new int[] { android.R.attr.state_pressed },
                //new BitmapDrawable(createSelectedBitmap(scaled, true)));
        //result.addState(new int[0], new BitmapDrawable(scaled));
        //result.setBounds(0, 0, mIconTextureWidth, mIconTextureHeight);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.062 -0400", hash_original_method = "04851D332C6BA4DB6F96BD5628CB0B77", hash_generated_method = "75E4C04FE5EF5C54E37DDE7A36F954E2")
    private Bitmap createIconBitmap(Drawable icon) {
        addTaint(icon.getTaint());
        int width = mIconWidth;
        int height = mIconHeight;
        if(icon instanceof PaintDrawable)        
        {
            PaintDrawable painter = (PaintDrawable) icon;
painter.setIntrinsicWidth(width)painter.setIntrinsicHeight(height)
        } //End block
        else
        if(icon instanceof BitmapDrawable)        
        {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) icon;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if(bitmap.getDensity()==Bitmap.DENSITY_NONE)            
            {
bitmapDrawable.setTargetDensity(mDisplayMetrics)
            } //End block
        } //End block
        int sourceWidth = icon.getIntrinsicWidth();
        int sourceHeight = icon.getIntrinsicHeight();
        if(sourceWidth>0&&sourceWidth>0)        
        {
            if(width<sourceWidth||height<sourceHeight)            
            {
                final float ratio = (float) sourceWidth / sourceHeight;
                if(sourceWidth>sourceHeight)                
                {
height=(int) (width/ratio)
                } //End block
                else
                if(sourceHeight>sourceWidth)                
                {
width=(int) (height*ratio)
                } //End block
            } //End block
            else
            if(sourceWidth<width&&sourceHeight<height)            
            {
width=sourceWidthheight=sourceHeight
            } //End block
        } //End block
        int textureWidth = mIconTextureWidth;
        int textureHeight = mIconTextureHeight;
        final Bitmap bitmap = Bitmap.createBitmap(textureWidth, textureHeight,
                Bitmap.Config.ARGB_8888);
        final Canvas canvas = mCanvas;
canvas.setBitmap(bitmap)        final int left = (textureWidth-width) / 2;
        final int top = (textureHeight-height) / 2;
        if(false)        
        {
canvas.drawColor(sColors[mColorIndex])            if(++mColorIndex>=sColors.length)            
mColorIndex=0
            Paint debugPaint = new Paint();
debugPaint.setColor(0xffcccc00)canvas.drawRect(left, top, left+width, top+height, debugPaint)
        } //End block
mOldBounds.set(icon.getBounds())icon.setBounds(left, top, left+width, top+height)icon.draw(canvas)icon.setBounds(mOldBounds)Bitmap var3752488A34EC2C4FECF5AE64DF03DAEB_2128890970 = bitmap        var3752488A34EC2C4FECF5AE64DF03DAEB_2128890970.addTaint(taint);
        return var3752488A34EC2C4FECF5AE64DF03DAEB_2128890970;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.065 -0400", hash_original_method = "280FB8CB85CD44A1C2DF0B97E7F06554", hash_generated_method = "2F512FED77FC3ACEF5F93F395CD37783")
    private Bitmap createSelectedBitmap(Bitmap src, boolean pressed) {
        addTaint(pressed);
        addTaint(src.getTaint());
        final Bitmap result = Bitmap.createBitmap(mIconTextureWidth, mIconTextureHeight,
                Bitmap.Config.ARGB_8888);
        final Canvas dest = new Canvas(result);
dest.drawColor(0, PorterDuff.Mode.CLEAR)        int[] xy = new int[2];
        Bitmap mask = src.extractAlpha(mBlurPaint, xy);
dest.drawBitmap(mask, xy[0], xy[1], pressed?mGlowColorPressedPaint:mGlowColorPressedPaint)mask.recycle()dest.drawBitmap(src, 0, 0, mPaint)dest.setBitmap(null)Bitmap varDC838461EE2FA0CA4C9BBB70A15456B0_129306268 = result        varDC838461EE2FA0CA4C9BBB70A15456B0_129306268.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_129306268;
        // ---------- Original Method ----------
        //final Bitmap result = Bitmap.createBitmap(mIconTextureWidth, mIconTextureHeight,
                //Bitmap.Config.ARGB_8888);
        //final Canvas dest = new Canvas(result);
        //dest.drawColor(0, PorterDuff.Mode.CLEAR);
        //int[] xy = new int[2];
        //Bitmap mask = src.extractAlpha(mBlurPaint, xy);
        //dest.drawBitmap(mask, xy[0], xy[1],
                //pressed ? mGlowColorPressedPaint : mGlowColorFocusedPaint);
        //mask.recycle();
        //dest.drawBitmap(src, 0, 0, mPaint);
        //dest.setBitmap(null);
        //return result;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.066 -0400", hash_original_field = "45D0021F57F5E6E002E61602151645ED", hash_generated_field = "C06C65091ECD3D3BD4AD4FFC1EBDE829")

    private static final String TAG = "IconUtilities";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.066 -0400", hash_original_field = "165019454D1B6C488EC5961FDDDEC6FA", hash_generated_field = "BFBA68A1D33EBD73FB42129AFF00C836")

    private static final int sColors[] = {0xffff0000, 0xff00ff00, 0xff0000ff, };
}

