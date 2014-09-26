package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.NinePatch;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;

public abstract class Drawable {

    /**
     * Return the appropriate opacity value for two source opacities.  If
     * either is UNKNOWN, that is returned; else, if either is TRANSLUCENT,
     * that is returned; else, if either is TRANSPARENT, that is returned;
     * else, OPAQUE is returned.
     *
     * <p>This is to help in implementing {@link #getOpacity}.
     *
     * @param op1 One opacity value.
     * @param op2 Another opacity value.
     *
     * @return int The combined opacity value.
     *
     * @see #getOpacity
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.973 -0500", hash_original_method = "916D14DF9AF3A81E437ADC0DC2203CFE", hash_generated_method = "BC2213D8D42D8210AD9C5ABE45796385")
    
public static int resolveOpacity(int op1, int op2) {
        if (op1 == op2) {
            return op1;
        }
        if (op1 == PixelFormat.UNKNOWN || op2 == PixelFormat.UNKNOWN) {
            return PixelFormat.UNKNOWN;
        }
        if (op1 == PixelFormat.TRANSLUCENT || op2 == PixelFormat.TRANSLUCENT) {
            return PixelFormat.TRANSLUCENT;
        }
        if (op1 == PixelFormat.TRANSPARENT || op2 == PixelFormat.TRANSPARENT) {
            return PixelFormat.TRANSPARENT;
        }
        return PixelFormat.OPAQUE;
    }

    /**
     * Create a drawable from an inputstream
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.996 -0500", hash_original_method = "F698992CDA7CE4CFA6270F08869E33EB", hash_generated_method = "EA31CB41043D98187A4334DCA5BDDCB4")
    
public static Drawable createFromStream(InputStream is, String srcName) {
        return createFromResourceStream(null, null, is, srcName, null);
    }

    /**
     * Create a drawable from an inputstream, using the given resources and
     * value to determine density information.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.998 -0500", hash_original_method = "6539199B7E5EF78E3B150794D858A2C9", hash_generated_method = "D8B91DF7BE5D083150AB363B8A4B7E47")
    
public static Drawable createFromResourceStream(Resources res, TypedValue value,
            InputStream is, String srcName) {
        return createFromResourceStream(res, value, is, srcName, null);
    }

    /**
     * Create a drawable from an inputstream, using the given resources and
     * value to determine density information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.001 -0500", hash_original_method = "686309EFC5AB81BA579C045870002714", hash_generated_method = "4FBC1FAC8606194523B26BC548CD4BEE")
    
public static Drawable createFromResourceStream(Resources res, TypedValue value,
            InputStream is, String srcName, BitmapFactory.Options opts) {

        if (is == null) {
            return null;
        }

        /*  ugh. The decodeStream contract is that we have already allocated
            the pad rect, but if the bitmap does not had a ninepatch chunk,
            then the pad will be ignored. If we could change this to lazily
            alloc/assign the rect, we could avoid the GC churn of making new
            Rects only to drop them on the floor.
        */
        Rect pad = new Rect();
        
        // Special stuff for compatibility mode: if the target density is not
        // the same as the display density, but the resource -is- the same as
        // the display density, then don't scale it down to the target density.
        // This allows us to load the system's density-correct resources into
        // an application in compatibility mode, without scaling those down
        // to the compatibility density only to have them scaled back up when
        // drawn to the screen.
        if (opts == null) opts = new BitmapFactory.Options();
        opts.inScreenDensity = DisplayMetrics.DENSITY_DEVICE;
        Bitmap  bm = BitmapFactory.decodeResourceStream(res, value, is, pad, opts);
        if (bm != null) {
            byte[] np = bm.getNinePatchChunk();
            if (np == null || !NinePatch.isNinePatchChunk(np)) {
                np = null;
                pad = null;
            }
            return drawableFromBitmap(res, bm, np, pad, srcName);
        }
        return null;
    }

    /**
     * Create a drawable from an XML document. For more information on how to
     * create resources in XML, see
     * <a href="{@docRoot}guide/topics/resources/drawable-resource.html">Drawable Resources</a>.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.003 -0500", hash_original_method = "86675DFFF0A0A811727E3034212032EE", hash_generated_method = "1C83BEE8B00F8FC24EADC94BA921020F")
    
public static Drawable createFromXml(Resources r, XmlPullParser parser)
            throws XmlPullParserException, IOException {
        AttributeSet attrs = Xml.asAttributeSet(parser);

        int type;
        while ((type=parser.next()) != XmlPullParser.START_TAG &&
                type != XmlPullParser.END_DOCUMENT) {
            // Empty loop
        }

        if (type != XmlPullParser.START_TAG) {
            throw new XmlPullParserException("No start tag found");
        }

        Drawable drawable = createFromXmlInner(r, parser, attrs);

        if (drawable == null) {
            throw new RuntimeException("Unknown initial tag: " + parser.getName());
        }

        return drawable;
    }

    /**
     * Create from inside an XML document.  Called on a parser positioned at
     * a tag in an XML document, tries to create a Drawable from that tag.
     * Returns null if the tag is not a valid drawable.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.007 -0500", hash_original_method = "C057D9F248A8C0B51C535F2391A8C186", hash_generated_method = "6B82F8D4DE15B03E277728092A3B670F")
    
public static Drawable createFromXmlInner(Resources r, XmlPullParser parser, AttributeSet attrs)
    throws XmlPullParserException, IOException {
        Drawable drawable;

        final String name = parser.getName();

        if (name.equals("selector")) {
            drawable = new StateListDrawable();
        } else if (name.equals("level-list")) {
            drawable = new LevelListDrawable();
        /* Probably not doing this.
        } else if (name.equals("mipmap")) {
            drawable = new MipmapDrawable();
        */
        } else if (name.equals("layer-list")) {
            drawable = new LayerDrawable();
        } else if (name.equals("transition")) {
            drawable = new TransitionDrawable();
        } else if (name.equals("color")) {
            drawable = new ColorDrawable();
        } else if (name.equals("shape")) {
            drawable = new GradientDrawable();
        } else if (name.equals("scale")) {
            drawable = new ScaleDrawable();
        } else if (name.equals("clip")) {
            drawable = new ClipDrawable();
        } else if (name.equals("rotate")) {
            drawable = new RotateDrawable();
        } else if (name.equals("animated-rotate")) {
            drawable = new AnimatedRotateDrawable();            
        } else if (name.equals("animation-list")) {
            drawable = new AnimationDrawable();
        } else if (name.equals("inset")) {
            drawable = new InsetDrawable();
        } else if (name.equals("bitmap")) {
            drawable = new BitmapDrawable(r);
            if (r != null) {
               ((BitmapDrawable) drawable).setTargetDensity(r.getDisplayMetrics());
            }
        } else if (name.equals("nine-patch")) {
            drawable = new NinePatchDrawable();
            if (r != null) {
                ((NinePatchDrawable) drawable).setTargetDensity(r.getDisplayMetrics());
             }
        } else {
            throw new XmlPullParserException(parser.getPositionDescription() +
                    ": invalid drawable tag " + name);
        }

        drawable.inflate(r, parser, attrs);
        return drawable;
    }

    /**
     * Create a drawable from file path name.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.010 -0500", hash_original_method = "BFC9B5CBB4F35E84FED6A1D240D75B82", hash_generated_method = "0731BFA5FCCFB319677220F34322AFEB")
    
public static Drawable createFromPath(String pathName) {
        if (pathName == null) {
            return null;
        }

        Bitmap bm = BitmapFactory.decodeFile(pathName);
        if (bm != null) {
            return drawableFromBitmap(null, bm, null, null, pathName);
        }

        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.029 -0500", hash_original_method = "1F43455DFCC8536E753114D2CECC415D", hash_generated_method = "23FBC035CFAA577048942BA8AA2CFFE6")
    
private static Drawable drawableFromBitmap(Resources res, Bitmap bm, byte[] np,
            Rect pad, String srcName) {

        if (np != null) {
            return new NinePatchDrawable(res, bm, np, pad, srcName);
        }

        return new BitmapDrawable(res, bm);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.886 -0500", hash_original_field = "49FEDF0128F276B332757795ADDC466F", hash_generated_field = "CB60BBB38B09F6F2A3773B2329AD705D")

    private static final Rect ZERO_BOUNDS_RECT = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.888 -0500", hash_original_field = "CFC560F37067E026FD0B768F137AF7B3", hash_generated_field = "5E6D3F09C1210458D0C754595BB30DAC")

    private int[] mStateSet = StateSet.WILD_CARD;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.890 -0500", hash_original_field = "9308AE6FD010F418842CB5F45F406B14", hash_generated_field = "D66D669C7CB840BE2CC0AE88CB04AECF")

    private int mLevel = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.892 -0500", hash_original_field = "814E9C7E8401D913B76AC320DD93E9AB", hash_generated_field = "D35ACD87C9C873D3BC15F23EE9468A4E")

    private int mChangingConfigurations = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.894 -0500", hash_original_field = "4FE34DDC31AF98ADEB9A735E5D6ACAF4", hash_generated_field = "294018A0A81D2A146053DB5D50BCF6B8")

    private Rect mBounds = ZERO_BOUNDS_RECT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.896 -0500", hash_original_field = "E1963A3F1FA1D0D2DEF8D51EC2AA7744", hash_generated_field = "9948EC0F011800FDF4A6CE610A87E55B")

    private WeakReference<Callback> mCallback = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.899 -0500", hash_original_field = "F432315EED22193741AC6586770A18F0", hash_generated_field = "B5A582F9AADED234805D7CA1D8129D36")

    private boolean mVisible = true;

    private boolean mAutoMirrored = false;

    @DSVerified    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.573 -0400", hash_original_method = "31C0F11C44C8FA6382C02786623A036E", hash_generated_method = "31C0F11C44C8FA6382C02786623A036E")
    public Drawable ()
    {
        //Synthesized constructor
    }

    /**
     * Draw in its bounds (set via setBounds) respecting optional effects such
     * as alpha (set via setAlpha) and color filter (set via setColorFilter).
     *
     * @param canvas The canvas to draw into
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.901 -0500", hash_original_method = "E7E2918BC47750A7683807E138C9FCF4", hash_generated_method = "DC73F3A81D382705FEE7B6D1EB5964B5")
    @DSVerified
    
public abstract void draw(Canvas canvas);

    /**
     * Specify a bounding rectangle for the Drawable. This is where the drawable
     * will draw when its draw() method is called.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.903 -0500", hash_original_method = "16D67C97CF930C94423B2F0ABE9E2FB8", hash_generated_method = "5DAE90321A04C30BBDBF694E00F0AABC")
    @DSVerified
    
public void setBounds(int left, int top, int right, int bottom) {
        Rect oldBounds = mBounds;

        if (oldBounds == ZERO_BOUNDS_RECT) {
            oldBounds = mBounds = new Rect();
        }

        if (oldBounds.left != left || oldBounds.top != top ||
                oldBounds.right != right || oldBounds.bottom != bottom) {
            mBounds.set(left, top, right, bottom);
            onBoundsChange(mBounds);
        }
    }

    /**
     * Specify a bounding rectangle for the Drawable. This is where the drawable
     * will draw when its draw() method is called.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.905 -0500", hash_original_method = "343A23DF727C21562F2BBDB7DAA5F811", hash_generated_method = "6874DBC0AAB6A4D64EC3FDE9608CF73D")
    @DSVerified
    
public void setBounds(Rect bounds) {
        setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    /**
     * Return a copy of the drawable's bounds in the specified Rect (allocated
     * by the caller). The bounds specify where this will draw when its draw()
     * method is called.
     *
     * @param bounds Rect to receive the drawable's bounds (allocated by the
     *               caller).
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.907 -0500", hash_original_method = "2860BC8F60A9356A6AA851AD0EDF9049", hash_generated_method = "A26616E82DFC109B2FAD7A3295CBE031")
    @DSVerified
    
public final void copyBounds(Rect bounds) {
        bounds.set(mBounds);
    }

    /**
     * Return a copy of the drawable's bounds in a new Rect. This returns the
     * same values as getBounds(), but the returned object is guaranteed to not
     * be changed later by the drawable (i.e. it retains no reference to this
     * rect). If the caller already has a Rect allocated, call copyBounds(rect).
     *
     * @return A copy of the drawable's bounds
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.909 -0500", hash_original_method = "A623AF26CC98262C126F58F99B918C3F", hash_generated_method = "8398153568D8B0C1C8AE601AF1652DDD")
    @DSVerified
    
public final Rect copyBounds() {
        return new Rect(mBounds);
    }

    /**
     * Return the drawable's bounds Rect. Note: for efficiency, the returned
     * object may be the same object stored in the drawable (though this is not
     * guaranteed), so if a persistent copy of the bounds is needed, call
     * copyBounds(rect) instead.
     * You should also not change the object returned by this method as it may
     * be the same object stored in the drawable.
     *
     * @return The bounds of the drawable (which may change later, so caller
     *         beware). DO NOT ALTER the returned object as it may change the
     *         stored bounds of this drawable.
     *
     * @see #copyBounds()
     * @see #copyBounds(android.graphics.Rect) 
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.912 -0500", hash_original_method = "F9C4E095C08A855B9547E5FC046C50BF", hash_generated_method = "BB0D4C947EFB311B6298FBD3B2491C35")
    @DSVerified
    
public final Rect getBounds() {
        if (mBounds == ZERO_BOUNDS_RECT) {
            mBounds = new Rect();
        }

        return mBounds;
    }

    /**
     * Set a mask of the configuration parameters for which this drawable
     * may change, requiring that it be re-created.
     *
     * @param configs A mask of the changing configuration parameters, as
     * defined by {@link android.content.res.Configuration}.
     *
     * @see android.content.res.Configuration
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.913 -0500", hash_original_method = "E7340D87AE9D08581CEC5A0FAA0552EE", hash_generated_method = "9F4E013A3B7A5088FF0C842FD0E94E98")
    @DSVerified
    
public void setChangingConfigurations(int configs) {
        mChangingConfigurations = configs;
    }

    /**
     * Return a mask of the configuration parameters for which this drawable
     * may change, requiring that it be re-created.  The default implementation
     * returns whatever was provided through
     * {@link #setChangingConfigurations(int)} or 0 by default.  Subclasses
     * may extend this to or in the changing configurations of any other
     * drawables they hold.
     *
     * @return Returns a mask of the changing configuration parameters, as
     * defined by {@link android.content.res.Configuration}.
     *
     * @see android.content.res.Configuration
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.917 -0500", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "1EFD981CB6D64D2240E5805425A8136B")
    @DSVerified
    
public int getChangingConfigurations() {
        return mChangingConfigurations;
    }

    /**
     * Set to true to have the drawable dither its colors when drawn to a device
     * with fewer than 8-bits per color component. This can improve the look on
     * those devices, but can also slow down the drawing a little.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.919 -0500", hash_original_method = "A73E6D639014FDB13967AD6B494837C8", hash_generated_method = "885C8677A0ED029E797386D2040088D8")
    @DSVerified
    
public void setDither(boolean dither) {}

    /**
     * Set to true to have the drawable filter its bitmap when scaled or rotated
     * (for drawables that use bitmaps). If the drawable does not use bitmaps,
     * this call is ignored. This can improve the look when scaled or rotated,
     * but also slows down the drawing.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.921 -0500", hash_original_method = "D611F7535670B80ECD8BF210909C26D1", hash_generated_method = "72A4AA63A3BDB8FE50798AE60EFC3156")
    @DSVerified    
public void setFilterBitmap(boolean filter) {}

    /**
     * Bind a {@link Callback} object to this Drawable.  Required for clients
     * that want to support animated drawables.
     *
     * @param cb The client's Callback implementation.
     * 
     * @see #getCallback() 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.929 -0500", hash_original_method = "59192F5DE8ED3EA14FF77E774B104DE3", hash_generated_method = "9D534FF0B37B231BD318684E95A472AF")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public final void setCallback(Callback cb) {
        mCallback = new WeakReference<Callback>(cb);
        cb.invalidateDrawable(this);
        cb.scheduleDrawable(this, null, DSUtils.FAKE_INT);
        cb.unscheduleDrawable(this, null);
    }

    /**
     * Return the current {@link Callback} implementation attached to this
     * Drawable.
     * 
     * @return A {@link Callback} instance or null if no callback was set.
     * 
     * @see #setCallback(android.graphics.drawable.Drawable.Callback) 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.931 -0500", hash_original_method = "F8C083250821C64B63A1F88F9B7D8469", hash_generated_method = "C7FEA9973BA1AD1942101573B248B21D")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public Callback getCallback() {
        if (mCallback != null) {
            return mCallback.get();
        }
        return null;
    }
    
    /**
     * Use the current {@link Callback} implementation to have this Drawable
     * redrawn.  Does nothing if there is no Callback attached to the
     * Drawable.
     *
     * @see Callback#invalidateDrawable
     * @see #getCallback() 
     * @see #setCallback(android.graphics.drawable.Drawable.Callback) 
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.933 -0500", hash_original_method = "9D9FDBFF51AC2DBEF3B6FA3B8569CCD5", hash_generated_method = "6067FFF2C9B2415C286F1561F4B86863")
    @DSVerified
public void invalidateSelf() {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    /**
     * Use the current {@link Callback} implementation to have this Drawable
     * scheduled.  Does nothing if there is no Callback attached to the
     * Drawable.
     *
     * @param what The action being scheduled.
     * @param when The time (in milliseconds) to run.
     *
     * @see Callback#scheduleDrawable
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.935 -0500", hash_original_method = "4BA44AAA8396AA668795CA7F4E916174", hash_generated_method = "645CD8E13DFF195E2A50EF26B04B7799")
    @DSVerified    
public void scheduleSelf(Runnable what, long when) {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, what, when);
        }
        if (what != null)
            what.run();
    }

    /**
     * Use the current {@link Callback} implementation to have this Drawable
     * unscheduled.  Does nothing if there is no Callback attached to the
     * Drawable.
     *
     * @param what The runnable that you no longer want called.
     *
     * @see Callback#unscheduleDrawable
     */
    @DSVerified    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.937 -0500", hash_original_method = "40D05A483A091B37888582EA72925B1D", hash_generated_method = "B2509450AF14B422766505826ABCA424")
    
public void unscheduleSelf(Runnable what) {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, what);
        }
    }

    /**
     * Use the current {@link android.graphics.drawable.Drawable.Callback2} implementation to get
     * the resolved layout direction of this Drawable.
     *
     * @hide
     */
    @DSVerified    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.940 -0500", hash_original_method = "D8B32EDE038D6347583B50AC97BFE4A6", hash_generated_method = "3E4549D53336D87BA990C99D49BE7AC7")
    
public int getResolvedLayoutDirectionSelf() {
        final Callback callback = getCallback();
        if (callback == null || !(callback instanceof Callback2)) {
            return View.LAYOUT_DIRECTION_LTR;
        }
        return ((Callback2) callback).getResolvedLayoutDirection(this);
    }

    /**
     * Specify an alpha value for the drawable. 0 means fully transparent, and
     * 255 means fully opaque.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.942 -0500", hash_original_method = "552C47BA233D82B224568BE44106808F", hash_generated_method = "BA237553E37FDD6A99627044600E8CEA")
    
public abstract void setAlpha(int alpha);

    /**
     * Specify an optional colorFilter for the drawable. Pass null to remove
     * any filters.
    */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.944 -0500", hash_original_method = "BDC70B2F57B8B4271211A6F4E36828D5", hash_generated_method = "4C4D56B62B5030A0B2B533B25B3B132E")
    @DSVerified
    
public abstract void setColorFilter(ColorFilter cf);

    /**
     * Specify a color and porterduff mode to be the colorfilter for this
     * drawable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.946 -0500", hash_original_method = "F0522F608E5F96C5D99BDA1CF055B16B", hash_generated_method = "D53251F3582E26709C3EB88369AE1D1E")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public void setColorFilter(int color, PorterDuff.Mode mode) {
        setColorFilter(new PorterDuffColorFilter(color, mode));
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.948 -0500", hash_original_method = "B358CFD4AAFD748C624F742F21F12081", hash_generated_method = "53A6D5BB937B1FBBD9F855C97CE94E0F")
    
    @DSVerified    
public void clearColorFilter() {
        setColorFilter(null);
    }

    /**
     * Indicates whether this view will change its appearance based on state.
     * Clients can use this to determine whether it is necessary to calculate
     * their state and call setState.
     *
     * @return True if this view changes its appearance based on state, false
     *         otherwise.
     *
     * @see #setState(int[])
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.950 -0500", hash_original_method = "5AE02876CD642F1B59606A09240D1BD0", hash_generated_method = "87BE84D342AB9204B08094A38F81BC23")
    @DSVerified
    
public boolean isStateful() {
        return false;
    }

    /**
     * Specify a set of states for the drawable. These are use-case specific,
     * so see the relevant documentation. As an example, the background for
     * widgets like Button understand the following states:
     * [{@link android.R.attr#state_focused},
     *  {@link android.R.attr#state_pressed}].
     *
     * <p>If the new state you are supplying causes the appearance of the
     * Drawable to change, then it is responsible for calling
     * {@link #invalidateSelf} in order to have itself redrawn, <em>and</em>
     * true will be returned from this function.
     *
     * <p>Note: The Drawable holds a reference on to <var>stateSet</var>
     * until a new state array is given to it, so you must not modify this
     * array during that time.</p>
     *
     * @param stateSet The new set of states to be displayed.
     *
     * @return Returns true if this change in state has caused the appearance
     * of the Drawable to change (hence requiring an invalidate), otherwise
     * returns false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.952 -0500", hash_original_method = "A73F586C823927F65CC09CAB74021FD5", hash_generated_method = "6A58E534712D36D747265B8A87F10A1F")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public boolean setState(final int[] stateSet) {
        if (!Arrays.equals(mStateSet, stateSet)) {
            mStateSet = stateSet;
            return onStateChange(stateSet);
        }
        return false;
    }

    /**
     * Describes the current state, as a union of primitve states, such as
     * {@link android.R.attr#state_focused},
     * {@link android.R.attr#state_selected}, etc.
     * Some drawables may modify their imagery based on the selected state.
     * @return An array of resource Ids describing the current state.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.954 -0500", hash_original_method = "2C3685292135F2FEA5B926C5A0764B84", hash_generated_method = "D1403FC1339289634B9EBC210DF55847")
    
    @DSVerified    
public int[] getState() {
        return mStateSet;
    }

    /**
     * If this Drawable does transition animations between states, ask that
     * it immediately jump to the current state and skip any active animations.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.956 -0500", hash_original_method = "1A9E62CA8A2399C6C2BEF07B26352781", hash_generated_method = "547C7222D80D4C7214DF0DC279408F30")
    
    @DSVerified    
public void jumpToCurrentState() {
    }

    /**
     * @return The current drawable that will be used by this drawable. For simple drawables, this
     *         is just the drawable itself. For drawables that change state like
     *         {@link StateListDrawable} and {@link LevelListDrawable} this will be the child drawable
     *         currently in use.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.958 -0500", hash_original_method = "00D08FCE0657F40CBD93DF1CB810B766", hash_generated_method = "A9832292CF51056A0946F9B8A2FBC09B")
    @DSVerified
    
public Drawable getCurrent() {
        return this;
    }

    /**
     * Specify the level for the drawable.  This allows a drawable to vary its
     * imagery based on a continuous controller, for example to show progress
     * or volume level.
     *
     * <p>If the new level you are supplying causes the appearance of the
     * Drawable to change, then it is responsible for calling
     * {@link #invalidateSelf} in order to have itself redrawn, <em>and</em>
     * true will be returned from this function.
     *
     * @param level The new level, from 0 (minimum) to 10000 (maximum).
     *
     * @return Returns true if this change in level has caused the appearance
     * of the Drawable to change (hence requiring an invalidate), otherwise
     * returns false.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.961 -0500", hash_original_method = "9037BFCAC5FB09B2A9E758C0533961C8", hash_generated_method = "CAC49DCDC50EEE63A7A5AA74566C9A29")
    @DSVerified
    
public final boolean setLevel(int level) {
        if (mLevel != level) {
            mLevel = level;
            return onLevelChange(level);
        }
        return false;
    }

    /**
     * Retrieve the current level.
     *
     * @return int Current level, from 0 (minimum) to 10000 (maximum).
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.964 -0500", hash_original_method = "3688C6710C4CB9729612AA02E692BC0A", hash_generated_method = "920139CD38512EC2764B3D291ADD9FB8")
    @DSVerified
    
public final int getLevel() {
        return mLevel;
    }

    /**
     * Set whether this Drawable is visible.  This generally does not impact
     * the Drawable's behavior, but is a hint that can be used by some
     * Drawables, for example, to decide whether run animations.
     *
     * @param visible Set to true if visible, false if not.
     * @param restart You can supply true here to force the drawable to behave
     *                as if it has just become visible, even if it had last
     *                been set visible.  Used for example to force animations
     *                to restart.
     *
     * @return boolean Returns true if the new visibility is different than
     *         its previous state.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.966 -0500", hash_original_method = "385D529E13116BE326F07B115E2B9363", hash_generated_method = "5E48D3139FE4584E32634293062CC314")
    @DSVerified
    
public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = mVisible != visible;
        if (changed) {
            mVisible = visible;
            invalidateSelf();
        }
        return changed;
    }

    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    public void setAutoMirrored(boolean automirror) {
        mAutoMirrored = automirror;
    }

    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    public boolean isAutoMirrored() {
        return mAutoMirrored;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.968 -0500", hash_original_method = "5E5A2EDE31F4C9B537E19F3E9904B493", hash_generated_method = "D3B6BF17C13DC8D40405CAB7A503ACFE")
    @DSVerified
    
public final boolean isVisible() {
        return mVisible;
    }

    /**
     * Return the opacity/transparency of this Drawable.  The returned value is
     * one of the abstract format constants in
     * {@link android.graphics.PixelFormat}:
     * {@link android.graphics.PixelFormat#UNKNOWN},
     * {@link android.graphics.PixelFormat#TRANSLUCENT},
     * {@link android.graphics.PixelFormat#TRANSPARENT}, or
     * {@link android.graphics.PixelFormat#OPAQUE}.
     *
     * <p>Generally a Drawable should be as conservative as possible with the
     * value it returns.  For example, if it contains multiple child drawables
     * and only shows one of them at a time, if only one of the children is
     * TRANSLUCENT and the others are OPAQUE then TRANSLUCENT should be
     * returned.  You can use the method {@link #resolveOpacity} to perform a
     * standard reduction of two opacities to the appropriate single output.
     *
     * <p>Note that the returned value does <em>not</em> take into account a
     * custom alpha or color filter that has been applied by the client through
     * the {@link #setAlpha} or {@link #setColorFilter} methods.
     *
     * @return int The opacity class of the Drawable.
     *
     * @see android.graphics.PixelFormat
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.970 -0500", hash_original_method = "9662DD8C5FEE80BC1339C77EC72BA687", hash_generated_method = "7B9E49E8EE3D72D401142B9347C6D2DA")
    @DSVerified
    
public abstract int getOpacity();

    /**
     * Returns a Region representing the part of the Drawable that is completely
     * transparent.  This can be used to perform drawing operations, identifying
     * which parts of the target will not change when rendering the Drawable.
     * The default implementation returns null, indicating no transparent
     * region; subclasses can optionally override this to return an actual
     * Region if they want to supply this optimization information, but it is
     * not required that they do so.
     *
     * @return Returns null if the Drawables has no transparent region to
     * report, else a Region holding the parts of the Drawable's bounds that
     * are transparent.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.975 -0500", hash_original_method = "6885EC41EEEA48BF379C9186E23112DE", hash_generated_method = "0957E709FBCC66345B992BB3BA42C3DF")
    @DSVerified
    
public Region getTransparentRegion() {
        return null;
    }

    /**
     * Override this in your subclass to change appearance if you recognize the
     * specified state.
     *
     * @return Returns true if the state change has caused the appearance of
     * the Drawable to change (that is, it needs to be drawn), else false
     * if it looks the same and there is no need to redraw it since its
     * last state.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.977 -0500", hash_original_method = "B7A8462AFC13A6E0F2F8BCB43385BD49", hash_generated_method = "58A509E6CF0FAC6525FCC611ABA223CD")
    @DSVerified
    
protected boolean onStateChange(int[] state) { return false; }
    /** Override this in your subclass to change appearance if you vary based
     *  on level.
     * @return Returns true if the level change has caused the appearance of
     * the Drawable to change (that is, it needs to be drawn), else false
     * if it looks the same and there is no need to redraw it since its
     * last level.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.979 -0500", hash_original_method = "37D330857F7202D119AB7FE43B955D5E", hash_generated_method = "528BB1010E01B65B3B9ADB937C28B112")
    @DSVerified
    
protected boolean onLevelChange(int level) { return false; }
    /**
     * Override this in your subclass to change appearance if you recognize the
     * specified state.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.981 -0500", hash_original_method = "F81B37D492B4B76F5CB4F03B5248220C", hash_generated_method = "43794E13307713CCF0C1A15FC4F2B463")
    @DSVerified
    
protected void onBoundsChange(Rect bounds) {}

    /**
     * Return the intrinsic width of the underlying drawable object.  Returns
     * -1 if it has no intrinsic width, such as with a solid color.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.983 -0500", hash_original_method = "EB5466611B82CCCED48E9C76B5992F82", hash_generated_method = "5707369824F06C6C8C5FEA2B9FD95BE8")
    
public int getIntrinsicWidth() {
        return -1;
    }

    /**
     * Return the intrinsic height of the underlying drawable object. Returns
     * -1 if it has no intrinsic height, such as with a solid color.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.985 -0500", hash_original_method = "4249F2736881F978DCEB3B683D79E5C9", hash_generated_method = "6747FB53BFD3B8723F7B12E72210E2E9")
    
public int getIntrinsicHeight() {
        return -1;
    }

    /**
     * Returns the minimum width suggested by this Drawable. If a View uses this
     * Drawable as a background, it is suggested that the View use at least this
     * value for its width. (There will be some scenarios where this will not be
     * possible.) This value should INCLUDE any padding.
     *
     * @return The minimum width suggested by this Drawable. If this Drawable
     *         doesn't have a suggested minimum width, 0 is returned.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.987 -0500", hash_original_method = "5035EEEA88B512A7AC30F75048C2F85A", hash_generated_method = "183DCB9F3F0F8DF0D0212348E7E9BD2A")
    
public int getMinimumWidth() {
        final int intrinsicWidth = getIntrinsicWidth();
        return intrinsicWidth > 0 ? intrinsicWidth : 0;
    }

    /**
     * Returns the minimum height suggested by this Drawable. If a View uses this
     * Drawable as a background, it is suggested that the View use at least this
     * value for its height. (There will be some scenarios where this will not be
     * possible.) This value should INCLUDE any padding.
     *
     * @return The minimum height suggested by this Drawable. If this Drawable
     *         doesn't have a suggested minimum height, 0 is returned.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.990 -0500", hash_original_method = "FB4CD88D7DE1F0713A1472841A364838", hash_generated_method = "5B123336F6C1DD1678925B456108326F")
    
public int getMinimumHeight() {
        final int intrinsicHeight = getIntrinsicHeight();
        return intrinsicHeight > 0 ? intrinsicHeight : 0;
    }

    /**
     * Return in padding the insets suggested by this Drawable for placing
     * content inside the drawable's bounds. Positive values move toward the
     * center of the Drawable (set Rect.inset). Returns true if this drawable
     * actually has a padding, else false. When false is returned, the padding
     * is always set to 0.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.992 -0500", hash_original_method = "3EEC3E25F33F4D98A0E1482CE3BAC48C", hash_generated_method = "E4E30BC5A2B586C28356FBCCF2EDD2FC")
    
public boolean getPadding(Rect padding) {
        padding.set(0, 0, 0, 0);
        return false;
    }

    /**
     * Make this drawable mutable. This operation cannot be reversed. A mutable
     * drawable is guaranteed to not share its state with any other drawable.
     * This is especially useful when you need to modify properties of drawables
     * loaded from resources. By default, all drawables instances loaded from
     * the same resource share a common state; if you modify the state of one
     * instance, all the other instances will receive the same modification.
     *
     * Calling this method on a mutable Drawable will have no effect.
     *
     * @return This drawable.
     * @see ConstantState
     * @see #getConstantState()
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.994 -0500", hash_original_method = "4655CA169BE542FE87BF20A0D63A5DAC", hash_generated_method = "EA3B8D5BED8B8DA7D11E65B56B105C84")
    
public Drawable mutate() {
        return this;
    }

    /**
     * Inflate this Drawable from an XML resource.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.012 -0500", hash_original_method = "A7AA835959A57BB8EBB74755836F5541", hash_generated_method = "011ED454E37B98397BD93D35F88D7B33")
    @DSVerified
public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs)
            throws XmlPullParserException, IOException {

        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.Drawable);
        inflateWithAttributes(r, parser, a, com.android.internal.R.styleable.Drawable_visible);
        a.recycle();
    }

    /**
     * Inflate a Drawable from an XML resource.
     *
     * @throws XmlPullParserException
     * @throws IOException
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.014 -0500", hash_original_method = "9471DE214DF2BB650CFB53CA22D70654", hash_generated_method = "9471DE214DF2BB650CFB53CA22D70654")
    
void inflateWithAttributes(Resources r, XmlPullParser parser,
            TypedArray attrs, int visibleAttr)
            throws XmlPullParserException, IOException {

        mVisible = attrs.getBoolean(visibleAttr, mVisible);
    }
    
    public static abstract class ConstantState {
        
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.603 -0400", hash_original_method = "1DBA432D049F8FB288727BCBD6197568", hash_generated_method = "1DBA432D049F8FB288727BCBD6197568")
        public ConstantState ()
        {
            //Synthesized constructor
        }
        /**
         * Create a new drawable without supplying resources the caller
         * is running in.  Note that using this means the density-dependent
         * drawables (like bitmaps) will not be able to update their target
         * density correctly. One should use {@link #newDrawable(Resources)}
         * instead to provide a resource.
         */
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.017 -0500", hash_original_method = "8AAC9AC676CAA292B513ED599D29AE60", hash_generated_method = "B86729DCAC25EA47F6FEDC3DE3D49986")
        
public abstract Drawable newDrawable();
        /**
         * Create a new Drawable instance from its constant state.  This
         * must be implemented for drawables that change based on the target
         * density of their caller (that is depending on whether it is
         * in compatibility mode).
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.019 -0500", hash_original_method = "5FCE46455F7833ADD9520B3BEB7232AE", hash_generated_method = "BBD7A0387CA646C11FC474D0EB63EDA1")
        
public Drawable newDrawable(Resources res) {
            return newDrawable();
        }
        /**
         * Return a bit mask of configuration changes that will impact
         * this drawable (and thus require completely reloading it).
         */
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.022 -0500", hash_original_method = "45D95E7A5F5F7D451E51E9095BE8F693", hash_generated_method = "8A4BA37C2E536863D0CAC6B3C245CFD2")
        
public abstract int getChangingConfigurations();
        
    }
    
    public static interface Callback {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void invalidateDrawable(Drawable who);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void scheduleDrawable(Drawable who, Runnable what, long when);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void unscheduleDrawable(Drawable who, Runnable what);
    }
    
    public static interface Callback2 extends Callback {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public int getResolvedLayoutDirection(Drawable who);
    }

    /**
     * Return a {@link ConstantState} instance that holds the shared state of this Drawable.
     *q
     * @return The ConstantState associated to that Drawable.
     * @see ConstantState
     * @see Drawable#mutate()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.025 -0500", hash_original_method = "4B02BBF3CC1230B6CEECD73EA01A2039", hash_generated_method = "B467CDA2D00CB54D1C36B84658B0C7F5")
    
public ConstantState getConstantState() {
        return new ConstantState() {
			
			@Override
			@DSComment("Abstract Method")
			@DSSafe(DSCat.SAFE_LIST)
			@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.017 -0500", hash_original_method = "8AAC9AC676CAA292B513ED599D29AE60", hash_generated_method = "B86729DCAC25EA47F6FEDC3DE3D49986")
			public Drawable newDrawable() {
				// TODO Auto-generated method stub
				return new PaintDrawable();
			}
			
			@Override
			@DSComment("Abstract Method")
			@DSSpec(DSCat.ABSTRACT_METHOD)
			@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.022 -0500", hash_original_method = "45D95E7A5F5F7D451E51E9095BE8F693", hash_generated_method = "8A4BA37C2E536863D0CAC6B3C245CFD2")
			public int getChangingConfigurations() {
				// TODO Auto-generated method stub
				return getTaintInt();
			}
		};
    }
}

