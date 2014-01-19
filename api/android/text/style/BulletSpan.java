package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.Spanned;
import android.text.TextUtils;

public class BulletSpan implements LeadingMarginSpan, ParcelableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.423 -0500", hash_original_field = "B799CBAF58FA5A7B8039F0E1B5D4CA4E", hash_generated_field = "AE2FB42565AB6A2C235F3647E11BA323")

    private static final int BULLET_RADIUS = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.426 -0500", hash_original_field = "92D278066E13152546B8DDAAE07866FA", hash_generated_field = "F4B31C45F9E1D3EC191C9041DEBF8AA4")

    private static Path sBulletPath = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.428 -0500", hash_original_field = "84D7470E23353D85E20BDB35BEA19F37", hash_generated_field = "9CDB5553168DBC9FCCC1E43A7348D62B")

    public static final int STANDARD_GAP_WIDTH = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.415 -0500", hash_original_field = "208F835751CC44FE8F3993640D996D68", hash_generated_field = "CF0863D60EF1715AF0282F6FEF7CAEA5")

    private  int mGapWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.418 -0500", hash_original_field = "D0644B5EB02BB6ACC1D066E747207165", hash_generated_field = "B31953859FB6A7EDF8C33055E9345363")

    private  boolean mWantColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.420 -0500", hash_original_field = "CF1046E2EF6F9B2B63BE18A3B2BC71FD", hash_generated_field = "118704B52DA650C4DCD23A9FC0B970FC")

    private  int mColor;

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.431 -0500", hash_original_method = "F333B1FCD15ED8238A329F687C815603", hash_generated_method = "782F157293EC096F1BCE24A863E1DB3B")
    
public BulletSpan() {
        mGapWidth = STANDARD_GAP_WIDTH;
        mWantColor = false;
        mColor = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.434 -0500", hash_original_method = "5B0962B90C33EFC1A7FAF035AC11CB4A", hash_generated_method = "DCC0611E75A468F49B036F8245862D40")
    
public BulletSpan(int gapWidth) {
        mGapWidth = gapWidth;
        mWantColor = false;
        mColor = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.437 -0500", hash_original_method = "49E46CCFEED0864DEF606DCF0C6D9BFC", hash_generated_method = "F75D2CB2B47217F24599E10DDB054883")
    
public BulletSpan(int gapWidth, int color) {
        mGapWidth = gapWidth;
        mWantColor = true;
        mColor = color;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.440 -0500", hash_original_method = "2310754227525D5B1AC7AB495FD8FC46", hash_generated_method = "AA101CE43FD01E3C9FBCE775A384975A")
    
public BulletSpan(Parcel src) {
        mGapWidth = src.readInt();
        mWantColor = src.readInt() != 0;
        mColor = src.readInt();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.443 -0500", hash_original_method = "487ABDFFC7C87077FB337ABC7D22F575", hash_generated_method = "72B6C1A2A06ABE6402112AB29A8EF749")
    
public int getSpanTypeId() {
        return TextUtils.BULLET_SPAN;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.445 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.448 -0500", hash_original_method = "D1CA1ADAD215DD7AD321DC70F751BAEF", hash_generated_method = "F602A517B3A0569348EEBA59C9862646")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mGapWidth);
        dest.writeInt(mWantColor ? 1 : 0);
        dest.writeInt(mColor);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.450 -0500", hash_original_method = "77C9B4F0913BD5D8F7E0CF3C61E7D063", hash_generated_method = "BB904BCEA193FDE2FC14A293DCAFC599")
    
public int getLeadingMargin(boolean first) {
        return 2 * BULLET_RADIUS + mGapWidth;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.453 -0500", hash_original_method = "BA5CC5CF550A22429CB3793943786FE7", hash_generated_method = "159993227D47817CC7721762EDC7B41E")
    
public void drawLeadingMargin(Canvas c, Paint p, int x, int dir,
                                  int top, int baseline, int bottom,
                                  CharSequence text, int start, int end,
                                  boolean first, Layout l) {
        if (((Spanned) text).getSpanStart(this) == start) {
            Paint.Style style = p.getStyle();
            int oldcolor = 0;

            if (mWantColor) {
                oldcolor = p.getColor();
                p.setColor(mColor);
            }

            p.setStyle(Paint.Style.FILL);

            if (c.isHardwareAccelerated()) {
                if (sBulletPath == null) {
                    sBulletPath = new Path();
                    // Bullet is slightly better to avoid aliasing artifacts on mdpi devices.
                    sBulletPath.addCircle(0.0f, 0.0f, 1.2f * BULLET_RADIUS, Direction.CW);
                }

                c.save();
                c.translate(x + dir * BULLET_RADIUS, (top + bottom) / 2.0f);
                c.drawPath(sBulletPath, p);
                c.restore();
            } else {
                c.drawCircle(x + dir * BULLET_RADIUS, (top + bottom) / 2.0f, BULLET_RADIUS, p);
            }

            if (mWantColor) {
                p.setColor(oldcolor);
            }

            p.setStyle(style);
        }
    }
}

