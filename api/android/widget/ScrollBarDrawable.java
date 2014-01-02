package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;





public class ScrollBarDrawable extends Drawable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.987 -0500", hash_original_field = "F250FDEF6F931394B7B0D1A7051F1F13", hash_generated_field = "E04A3D9DD9EF3A7F912E815C6BFCA25E")

    private Drawable mVerticalTrack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.989 -0500", hash_original_field = "D4827401AA8FF56A554510AE9DD4C81F", hash_generated_field = "14177887DA33DECB5E35DF1A209CFD6B")

    private Drawable mHorizontalTrack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.991 -0500", hash_original_field = "3BE7064F8F7E5DF75344CDA36FE1489A", hash_generated_field = "D4785478D95BE31369EF8D658342B38B")

    private Drawable mVerticalThumb;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.993 -0500", hash_original_field = "96DE54F5D4C4C6F6AE14F40DD5A16D8B", hash_generated_field = "A6C9AC87745812562596B1EB0E194CD2")

    private Drawable mHorizontalThumb;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.995 -0500", hash_original_field = "3C5543D695ECE2801D93699E7A4AA0BD", hash_generated_field = "EB6C39DC231EAF3B33208BD8796BA2F1")

    private int mRange;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.997 -0500", hash_original_field = "824ACE8F55518F51C4ECB112DA3987C7", hash_generated_field = "F358652CEEA6BACE7E593752AA27CBE6")

    private int mOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.999 -0500", hash_original_field = "00197C3D6FC618C567597C5882EE4E64", hash_generated_field = "D7D4E6D21EA2FE73F01CE81D6CC81FA1")

    private int mExtent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.001 -0500", hash_original_field = "AD5BC26F1486924EA9EA9B5D19F29CAE", hash_generated_field = "69CBC6FC9EE367E3A738852DD60DDD6D")

    private boolean mVertical;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.004 -0500", hash_original_field = "02A77CD68B3127079E3AC2A189D2BB69", hash_generated_field = "F1F17F4E3280622D0A9B77B123769A5C")

    private boolean mChanged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.006 -0500", hash_original_field = "350EF13BC5FB53BF967C874EEDC6E8DE", hash_generated_field = "4F6E0C8B4F81EFED7C3C83FC67B47487")

    private boolean mRangeChanged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.008 -0500", hash_original_field = "18B323F06848CA309C3A1F305DBA0D21", hash_generated_field = "9DBB084DD0568D939B76BF72796B166A")

    private final Rect mTempBounds = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.010 -0500", hash_original_field = "EF6FE704732387F77954254AE3D1DC73", hash_generated_field = "73D3FAACDDA42D621076D0307124BA72")

    private boolean mAlwaysDrawHorizontalTrack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.012 -0500", hash_original_field = "CB03100CD33F329B07EFFD9D53BA9FB5", hash_generated_field = "BDCE388B565752F7D96B5F7F9F3DDA9A")

    private boolean mAlwaysDrawVerticalTrack;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.014 -0500", hash_original_method = "F6C29E547BD302257DEE1C67DCEB3680", hash_generated_method = "DA32E396AC9BDA3E856F588C4EBBA3FE")
    
public ScrollBarDrawable() {
    }

    /**
     * Indicate whether the horizontal scrollbar track should always be drawn regardless of the
     * extent. Defaults to false.
     *
     * @param alwaysDrawTrack Set to true if the track should always be drawn
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.016 -0500", hash_original_method = "338EA256BE1472C967D04B115E1F5FA4", hash_generated_method = "F372F57B6A26AFE154BA2019A0122F4D")
    
public void setAlwaysDrawHorizontalTrack(boolean alwaysDrawTrack) {
        mAlwaysDrawHorizontalTrack = alwaysDrawTrack;
    }

    /**
     * Indicate whether the vertical scrollbar track should always be drawn regardless of the
     * extent. Defaults to false.
     *
     * @param alwaysDrawTrack Set to true if the track should always be drawn
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.018 -0500", hash_original_method = "901AC7B8EB84A9D2458B7938E8E4C73B", hash_generated_method = "C3E07E0A70CACA997440517D50656B74")
    
public void setAlwaysDrawVerticalTrack(boolean alwaysDrawTrack) {
        mAlwaysDrawVerticalTrack = alwaysDrawTrack;
    }

    /**
     * Indicates whether the vertical scrollbar track should always be drawn regardless of the
     * extent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.022 -0500", hash_original_method = "0A81522E62255950E42918FC464ECE8D", hash_generated_method = "3C038F9E1BEFE1BCD1973B3116667F56")
    
public boolean getAlwaysDrawVerticalTrack() {
        return mAlwaysDrawVerticalTrack;
    }

    /**
     * Indicates whether the horizontal scrollbar track should always be drawn regardless of the
     * extent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.024 -0500", hash_original_method = "58B8563B0AE3601908934E7BD6ECE0D9", hash_generated_method = "9A7E6921EC93CAEDE62AE6D58C2DBE77")
    
public boolean getAlwaysDrawHorizontalTrack() {
        return mAlwaysDrawHorizontalTrack;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.026 -0500", hash_original_method = "0CC6554F6E9383DBFFA4FCF818E81542", hash_generated_method = "9C1504D70A4E3FE51E8565438DE963CB")
    
public void setParameters(int range, int offset, int extent, boolean vertical) {
        if (mVertical != vertical) {
            mChanged = true;
        }

        if (mRange != range || mOffset != offset || mExtent != extent) {
            mRangeChanged = true;
        }

        mRange = range;
        mOffset = offset;
        mExtent = extent;
        mVertical = vertical;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.029 -0500", hash_original_method = "1E3ED238DD8B93FF3896611B5226DF40", hash_generated_method = "AFD6E5DA5221848CE680BB3CCA77D9A8")
    
@Override
    public void draw(Canvas canvas) {
        final boolean vertical = mVertical;
        final int extent = mExtent;
        final int range = mRange;

        boolean drawTrack = true;
        boolean drawThumb = true;
        if (extent <= 0 || range <= extent) {
            drawTrack = vertical ? mAlwaysDrawVerticalTrack : mAlwaysDrawHorizontalTrack;
            drawThumb = false;
        }

        Rect r = getBounds();
        if (canvas.quickReject(r.left, r.top, r.right, r.bottom, Canvas.EdgeType.AA)) {
            return;
        }
        if (drawTrack) {
            drawTrack(canvas, r, vertical);
        }

        if (drawThumb) {
            int size = vertical ? r.height() : r.width();
            int thickness = vertical ? r.width() : r.height();
            int length = Math.round((float) size * extent / range);
            int offset = Math.round((float) (size - length) * mOffset / (range - extent));

            // avoid the tiny thumb
            int minLength = thickness * 2;
            if (length < minLength) {
                length = minLength;
            }
            // avoid the too-big thumb
            if (offset + length > size) {
                offset = size - length;
            }

            drawThumb(canvas, r, offset, length, vertical);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.032 -0500", hash_original_method = "44DF7C7CE3C6FB97927067DC59DBEDA2", hash_generated_method = "C6CDEDDC33BB525445D0868139831646")
    
@Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        mChanged = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.034 -0500", hash_original_method = "FBC32EDDC9C94F2A507C4B078AFDC706", hash_generated_method = "EEB5DD15C5782AFC473AE1C2DF07EBA7")
    
protected void drawTrack(Canvas canvas, Rect bounds, boolean vertical) {
        Drawable track;
        if (vertical) {
            track = mVerticalTrack;
        } else {
            track = mHorizontalTrack;
        }
        if (track != null) {
            if (mChanged) {
                track.setBounds(bounds);
            }
            track.draw(canvas);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.036 -0500", hash_original_method = "272AE2AAF08C3293C4192CBFA02ABB41", hash_generated_method = "A7B79D9C304AEB87A945C02D3CF20404")
    
protected void drawThumb(Canvas canvas, Rect bounds, int offset, int length, boolean vertical) {
        final Rect thumbRect = mTempBounds;
        final boolean changed = mRangeChanged || mChanged;
        if (changed) {
            if (vertical) {
                thumbRect.set(bounds.left,  bounds.top + offset,
                        bounds.right, bounds.top + offset + length);
            } else {
                thumbRect.set(bounds.left + offset, bounds.top,
                        bounds.left + offset + length, bounds.bottom);
            }
        }

        if (vertical) {
            final Drawable thumb = mVerticalThumb;
            if (changed) thumb.setBounds(thumbRect);
            thumb.draw(canvas);
        } else {
            final Drawable thumb = mHorizontalThumb;
            if (changed) thumb.setBounds(thumbRect);
            thumb.draw(canvas);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.038 -0500", hash_original_method = "CF1FA0D3674C65E82EB702858CBA2EA8", hash_generated_method = "0124AE21D262DF3862CDF8B1E4DF0B71")
    
public void setVerticalThumbDrawable(Drawable thumb) {
        if (thumb != null) {
            mVerticalThumb = thumb;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.040 -0500", hash_original_method = "95A534FB494475ED343603B1A863AD99", hash_generated_method = "2991C286EB1673E7BCA6A573B72F00BD")
    
public void setVerticalTrackDrawable(Drawable track) {
        mVerticalTrack = track;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.043 -0500", hash_original_method = "D314A45F62304CCC7D305EC252A7898A", hash_generated_method = "E540396E14D47427EBD03E8A8F033A80")
    
public void setHorizontalThumbDrawable(Drawable thumb) {
        if (thumb != null) {
            mHorizontalThumb = thumb;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.045 -0500", hash_original_method = "AA2EFF46594CC873B99869053CAE3587", hash_generated_method = "C253F90FC5759ED0628F20CA7BB83421")
    
public void setHorizontalTrackDrawable(Drawable track) {
        mHorizontalTrack = track;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.047 -0500", hash_original_method = "7E286D23B763C72717353421EFF3C480", hash_generated_method = "C37A85BF592FDB6C4CABAE6C2AAECD4B")
    
public int getSize(boolean vertical) {
        if (vertical) {
            return (mVerticalTrack != null ?
                    mVerticalTrack : mVerticalThumb).getIntrinsicWidth();
        } else {
            return (mHorizontalTrack != null ?
                    mHorizontalTrack : mHorizontalThumb).getIntrinsicHeight();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.049 -0500", hash_original_method = "B18AEA250E30640B8B376B842AF0FDF6", hash_generated_method = "9C481F467A2EF23FB08CBADDD2BBFB85")
    
@Override
    public void setAlpha(int alpha) {
        if (mVerticalTrack != null) {
            mVerticalTrack.setAlpha(alpha);
        }
        mVerticalThumb.setAlpha(alpha);
        if (mHorizontalTrack != null) {
            mHorizontalTrack.setAlpha(alpha);
        }
        mHorizontalThumb.setAlpha(alpha);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.053 -0500", hash_original_method = "CBF97912C9C8F01704D565D3AA800300", hash_generated_method = "45BC8FD7D0A6109AB30554FD8DB0B0B3")
    
@Override
    public void setColorFilter(ColorFilter cf) {
        if (mVerticalTrack != null) {
            mVerticalTrack.setColorFilter(cf);
        }
        mVerticalThumb.setColorFilter(cf);
        if (mHorizontalTrack != null) {
            mHorizontalTrack.setColorFilter(cf);
        }
        mHorizontalThumb.setColorFilter(cf);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.055 -0500", hash_original_method = "AB3D570DA2A917C408AB4F7D8FCD7103", hash_generated_method = "92E82009FE448BF0B4121CF0FFF496C7")
    
@Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.057 -0500", hash_original_method = "C5352C5923C905107C68A18CC8B889AA", hash_generated_method = "3310EB48D785A16D741899E3B2B65D2C")
    
@Override
    public String toString() {
        return "ScrollBarDrawable: range=" + mRange + " offset=" + mOffset +
               " extent=" + mExtent + (mVertical ? " V" : " H");
    }

    
}

