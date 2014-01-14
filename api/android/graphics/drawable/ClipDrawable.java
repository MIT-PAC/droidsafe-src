package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;

public class ClipDrawable extends Drawable implements Drawable.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.831 -0500", hash_original_field = "0020CD8DE9DFD5D0CFED10065302AB91", hash_generated_field = "EACA224B8385161B605A2E64A4D16B8A")

    public static final int HORIZONTAL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.833 -0500", hash_original_field = "7966AE174603303B802964D7ABB3D5E8", hash_generated_field = "D756A470A2986330BFAB916722475532")

    public static final int VERTICAL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.826 -0500", hash_original_field = "3D3DB91A769249811991B5D5FDA4468D", hash_generated_field = "AB4FF940C8217DFA5B7A6EF2CC01064E")

    private ClipState mClipState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.828 -0500", hash_original_field = "C53D3ED3F7CBB30122A6D714A9203A7D", hash_generated_field = "570061BA9CB059462550E9BCCD2A0735")

    private final Rect mTmpRect = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.836 -0500", hash_original_method = "E02759DF2D4F91913B09748266B3DC55", hash_generated_method = "E02759DF2D4F91913B09748266B3DC55")
    
ClipDrawable() {
        this(null, null);
    }

    /**
     * @param orientation Bitwise-or of {@link #HORIZONTAL} and/or {@link #VERTICAL}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.838 -0500", hash_original_method = "5201E74D3B1AF986B1DE2C301B497FD9", hash_generated_method = "CC0C7583D1B4ABD557AEAD7FABEE0988")
    
public ClipDrawable(Drawable drawable, int gravity, int orientation) {
        this(null, null);

        mClipState.mDrawable = drawable;
        mClipState.mGravity = gravity;
        mClipState.mOrientation = orientation;

        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.911 -0500", hash_original_method = "F385B151B35BFC6DCEF1AAF1F3B81836", hash_generated_method = "44062D4CE4654E9F2CE8914AFE438D10")
    
private ClipDrawable(ClipState state, Resources res) {
        mClipState = new ClipState(state, this, res);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.841 -0500", hash_original_method = "35E10192FDDDDD39EA519306C2BA1E53", hash_generated_method = "62D5D8568B081593E7ADD19E7172E16E")
    
@Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs)
            throws XmlPullParserException, IOException {
        super.inflate(r, parser, attrs);

        int type;

        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ClipDrawable);

        int orientation = a.getInt(
                com.android.internal.R.styleable.ClipDrawable_clipOrientation,
                HORIZONTAL);
        int g = a.getInt(com.android.internal.R.styleable.ClipDrawable_gravity, Gravity.LEFT);
        Drawable dr = a.getDrawable(com.android.internal.R.styleable.ClipDrawable_drawable);

        a.recycle();

        final int outerDepth = parser.getDepth();
        while ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }
            dr = Drawable.createFromXmlInner(r, parser, attrs);
        }

        if (dr == null) {
            throw new IllegalArgumentException("No drawable specified for <clip>");
        }

        mClipState.mDrawable = dr;
        mClipState.mOrientation = orientation;
        mClipState.mGravity = g;

        dr.setCallback(this);
    }

    // overrides from Drawable.Callback

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.844 -0500", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "B516B8CE176B97B58ED719463429883C")
    
public void invalidateDrawable(Drawable who) {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.846 -0500", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "D916965E7ED92878F703EBB8407A3435")
    
public void scheduleDrawable(Drawable who, Runnable what, long when) {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.848 -0500", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "1F0141991B8511B6AE50284469FB44D8")
    
public void unscheduleDrawable(Drawable who, Runnable what) {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, what);
        }
    }

    // overrides from Drawable

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.850 -0500", hash_original_method = "67F829CCE512EF7E67F091FC7A5204DA", hash_generated_method = "8A256D9F79B6BAEB843B0FCF12982054")
    
@Override
    public int getChangingConfigurations() {
        return super.getChangingConfigurations()
                | mClipState.mChangingConfigurations
                | mClipState.mDrawable.getChangingConfigurations();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.852 -0500", hash_original_method = "EBC5879EAC2AD881F46A140E8365AA28", hash_generated_method = "3526C46702D16AECD42406C861C9BF3D")
    
@Override
    public boolean getPadding(Rect padding) {
        // XXX need to adjust padding!
        return mClipState.mDrawable.getPadding(padding);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.855 -0500", hash_original_method = "BCB1CA235EA7FE91BD623275B8F06E4E", hash_generated_method = "F0935F9585B83C7BD0CE2361BAD62EDF")
    
@Override
    public boolean setVisible(boolean visible, boolean restart) {
        mClipState.mDrawable.setVisible(visible, restart);
        return super.setVisible(visible, restart);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.858 -0500", hash_original_method = "8A8063C7E15313BD8D8740621EFCD055", hash_generated_method = "7C6ADA654B631B11FD4F0798B18AB8FD")
    
@Override
    public void setAlpha(int alpha) {
        mClipState.mDrawable.setAlpha(alpha);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.860 -0500", hash_original_method = "4805CD50FD09C28529E6873146205090", hash_generated_method = "3D00BC1A221472AD6CD0382F594FE967")
    
@Override
    public void setColorFilter(ColorFilter cf) {
        mClipState.mDrawable.setColorFilter(cf);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.862 -0500", hash_original_method = "D50D875832F26A4F5A2E593F0458B980", hash_generated_method = "72B579365ACCAD695F2BC30D27BC5ABF")
    
@Override
    public int getOpacity() {
        return mClipState.mDrawable.getOpacity();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.864 -0500", hash_original_method = "A8A44DACBEBFA3295CF5300D7DD6141E", hash_generated_method = "7F755E0CE6A7524C17BCC35C8DCF259A")
    
@Override
    public boolean isStateful() {
        return mClipState.mDrawable.isStateful();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.866 -0500", hash_original_method = "F2335EB963F31FC1C9D5098F086ABEDC", hash_generated_method = "031C8D769F4E90F0F4537594C135006F")
    
@Override
    protected boolean onStateChange(int[] state) {
        return mClipState.mDrawable.setState(state);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.868 -0500", hash_original_method = "205025D2BBBB226C56B3B5E3828C12A2", hash_generated_method = "90D3EFBC6B6B68659452493FF9454A37")
    
@Override
    protected boolean onLevelChange(int level) {
        mClipState.mDrawable.setLevel(level);
        invalidateSelf();
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.871 -0500", hash_original_method = "3381996765F462751820E570B6825F64", hash_generated_method = "858A7E1F2E6B49E85D7D613C1237205F")
    
@Override
    protected void onBoundsChange(Rect bounds) {
        mClipState.mDrawable.setBounds(bounds);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.873 -0500", hash_original_method = "0FB9453D484502FB8FF0BB7F530F2AA8", hash_generated_method = "5429E536F73A5F451C04DFC46B73FEAD")
    
@Override
    public void draw(Canvas canvas) {
        
        if (mClipState.mDrawable.getLevel() == 0) {
            return;
        }

        final Rect r = mTmpRect;
        final Rect bounds = getBounds();
        int level = getLevel();
        int w = bounds.width();
        final int iw = 0; //mClipState.mDrawable.getIntrinsicWidth();
        if ((mClipState.mOrientation & HORIZONTAL) != 0) {
            w -= (w - iw) * (10000 - level) / 10000;
        }
        int h = bounds.height();
        final int ih = 0; //mClipState.mDrawable.getIntrinsicHeight();
        if ((mClipState.mOrientation & VERTICAL) != 0) {
            h -= (h - ih) * (10000 - level) / 10000;
        }
        final int layoutDirection = getResolvedLayoutDirectionSelf();
        Gravity.apply(mClipState.mGravity, w, h, bounds, r, layoutDirection);

        if (w > 0 && h > 0) {
            canvas.save();
            canvas.clipRect(r);
            mClipState.mDrawable.draw(canvas);
            canvas.restore();
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.876 -0500", hash_original_method = "042D8C5B60AD594AE3EBCE13D95C97E6", hash_generated_method = "7E230DF2E11C7F8B00C95E2275E9A6D2")
    
@Override
    public int getIntrinsicWidth() {
        return mClipState.mDrawable.getIntrinsicWidth();
    }
    
    final static class ClipState extends ConstantState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.883 -0500", hash_original_field = "38BA53DD394F85639C99ED8E666FF8FB", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.885 -0500", hash_original_field = "9BFAF00848476277D36D9BA586984BA7", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.887 -0500", hash_original_field = "9D3FC5FADE012FDDFCCC496073866451", hash_generated_field = "9D3FC5FADE012FDDFCCC496073866451")

        int mOrientation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.889 -0500", hash_original_field = "E8D24DE70DE8CB945622B4CE486A90EA", hash_generated_field = "E8D24DE70DE8CB945622B4CE486A90EA")

        int mGravity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.892 -0500", hash_original_field = "04605894B57F7B3414AF620BF4AC040E", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.894 -0500", hash_original_field = "09212A3A30B7E6D48DEECC4F4639CCBC", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.897 -0500", hash_original_method = "DA3973DF13E25909CBF5E61AD4C16433", hash_generated_method = "DA3973DF13E25909CBF5E61AD4C16433")
        
ClipState(ClipState orig, ClipDrawable owner, Resources res) {
            if (orig != null) {
                if (res != null) {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable(res);
                } else {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable();
                }
                mDrawable.setCallback(owner);
                mOrientation = orig.mOrientation;
                mGravity = orig.mGravity;
                mCheckedConstantState = mCanConstantState = true;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.899 -0500", hash_original_method = "9DFA0AF157AD09F9E42E54EF8A59DA7F", hash_generated_method = "F671F4935AFA82FA0AF8FCA3110AB0B5")
        
@Override
        public Drawable newDrawable() {
            return new ClipDrawable(this, null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.901 -0500", hash_original_method = "9FB9989AA654F677F07C2F4A3C4B1057", hash_generated_method = "4F8D6307EB694445ACE2CBDC17C8ACD2")
        
@Override
        public Drawable newDrawable(Resources res) {
            return new ClipDrawable(this, res);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.904 -0500", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "3AB30668ED270F2EDF2E0129C706FE4D")
        
@Override
        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.906 -0500", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "8D2A3A495FE794F654E28C73CF35A2A1")
        
boolean canConstantState() {
            if (!mCheckedConstantState) {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            }

            return mCanConstantState;
        }
        
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.878 -0500", hash_original_method = "2200041BC151EB15073098E0A2FD1970", hash_generated_method = "CE5AA58D714843DA41C50DA832F1880F")
    
@Override
    public int getIntrinsicHeight() {
        return mClipState.mDrawable.getIntrinsicHeight();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.881 -0500", hash_original_method = "80C96E88400AA50FF8906D46C3CD5A6C", hash_generated_method = "ABE84AC4D5556ED2F043678472BBDC3E")
    
@Override
    public ConstantState getConstantState() {
        if (mClipState.canConstantState()) {
            mClipState.mChangingConfigurations = getChangingConfigurations();
            return mClipState;
        }
        return null;
    }
}

