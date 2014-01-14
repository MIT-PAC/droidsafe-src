package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.res.CompatibilityInfo.Translator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.SurfaceTexture;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Surface implements Parcelable {
    
    private static void nativeClassInit() {
    }
    
    public static void freezeDisplay(int display) {
    }
    
    public static void unfreezeDisplay(int display) {
    }
    
    public static void setOrientation(int display, int orientation, int flags) {
    }

    /**
     * set the orientation of the given display.
     * @param display
     * @param orientation
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.611 -0500", hash_original_method = "CA3B1E412921E586689C048FD004B792", hash_generated_method = "D40867BC55FB737722C212D1BD5D85B0")
    
public static void setOrientation(int display, int orientation) {
        setOrientation(display, orientation, 0);
    }
    
    public static Bitmap screenshot(int width, int height) {
    	return BitmapFactory.decodeByteArray(new byte[0], 0, width * height);
    }
    
    public static Bitmap screenshot(int width, int height, int minLayer, int maxLayer) {
    	return BitmapFactory.decodeByteArray(new byte[0], 0, width * height);
    }
    
    public static void openTransaction() {
    }
    
    public static void closeTransaction() {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.439 -0500", hash_original_field = "3E83BDCB6CEB6B91DAF9848C410877B8", hash_generated_field = "E865BFAE544CB63FF109B25F41991E5B")

    private static final String LOG_TAG = "Surface";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.441 -0500", hash_original_field = "D11571F270B31B271F3F924AE91458E0", hash_generated_field = "85F04C43536B1AE4A9BF96CF26488180")

    private static final boolean DEBUG_RELEASE = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.444 -0500", hash_original_field = "ECFC65FB24C12835D6E2D635258B5A60", hash_generated_field = "D3D30099A50791E5BBCDD89F15ECA592")

    public static final int ROTATION_0       = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.447 -0500", hash_original_field = "295C0BC4A2ABF7493C3580EFE6B8922B", hash_generated_field = "F2A2C6EEDF86C1E16C9FCE94434DC53A")

    public static final int ROTATION_90      = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.449 -0500", hash_original_field = "7763F7C08AFF96FAD8C2012F300D8683", hash_generated_field = "E18D27FB35F9722D54432B8305BC4C14")

    public static final int ROTATION_180     = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.452 -0500", hash_original_field = "9DFC391892DE0EF7EF1A75DB195031D2", hash_generated_field = "F81154964A7735929776F4BD9D5367B7")

    public static final int ROTATION_270     = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.494 -0500", hash_original_field = "CC8E8B23CFBF46E6BB1ED236604F2279", hash_generated_field = "1B646F34581AE9A38B9D7528F7E82375")

    /* flags used in constructor (keep in sync with ISurfaceComposer.h) */

    /** Surface is created hidden @hide */
    public static final int HIDDEN              = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.497 -0500", hash_original_field = "158E2C63824CCC4A9228D687A644A200", hash_generated_field = "0DBFC41D21E0536C69753FAF5773D22D")

    public static final int SECURE              = 0x00000080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.499 -0500", hash_original_field = "39701732A3BD8DFC3F2657D462A9D449", hash_generated_field = "B4E5B4B144F4C46C4721120F7AEB539C")

    public static final int NON_PREMULTIPLIED   = 0x00000100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.502 -0500", hash_original_field = "683DB956AFF99FCAECD0AD1D6C5CA4E5", hash_generated_field = "787D10C57614CA43DFEEABE50199B538")

    public static final int OPAQUE              = 0x00000400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.504 -0500", hash_original_field = "0D02736C2073B6A180B208F984E186E2", hash_generated_field = "4144F4EBFF817C8C47FA9745FCD5529D")

    public static final int PROTECTED_APP       = 0x00000800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.507 -0500", hash_original_field = "57B29765DE6C9E12B3B6C7A277225B22", hash_generated_field = "4903ED7CA3A87D516237C30FB0326B52")

    /** Creates a normal surface. This is the default. @hide */
    public static final int FX_SURFACE_NORMAL   = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.511 -0500", hash_original_field = "51E50AE1A4EA51C9ED668E145ADE84E6", hash_generated_field = "B41A8A674D59D1BA27FDF13A7BE1EE34")

    @Deprecated
    public static final int FX_SURFACE_BLUR     = 0x00010000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.513 -0500", hash_original_field = "A09FD23611A4EC8A941D6803D48ECB3C", hash_generated_field = "CC10EA1184AB37BE19F2FD9D27FD26D7")

    public static final int FX_SURFACE_DIM     = 0x00020000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.516 -0500", hash_original_field = "850AA5860920C095F321AFDDE63FABE5", hash_generated_field = "1EAE9F8197E9996FAEB8F7CC6BCA9F6A")

    public static final int FX_SURFACE_SCREENSHOT   = 0x00030000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.518 -0500", hash_original_field = "85A1953DFF46327AB76ACE7E7855BC02", hash_generated_field = "9FFCE6C9349CD57B4435EDF8BDD8A3F7")

    public static final int FX_SURFACE_MASK     = 0x000F0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.521 -0500", hash_original_field = "B4D4132B09EA747FE6DF3ACDC302C6E1", hash_generated_field = "D5926B412B163E90AC7C1A09A1576E7A")
    
    /** Hide the surface. Equivalent to calling hide(). @hide */
    public static final int SURFACE_HIDDEN    = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.523 -0500", hash_original_field = "FC20D7CFF167643C4947E0106BE7A706", hash_generated_field = "329C5A7EAF9BA2418EB85688C52E41C0")

    public static final int SURFACE_FROZEN     = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.526 -0500", hash_original_field = "BBF766E114AD2231657A9674E37EE2BB", hash_generated_field = "3B67C17B3862342915009A6C0F5CA9F5")

    public static final int SURFACE_DITHER    = 0x04;
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "8D1981611D47C7C4E4F15592707A3675", hash_generated_field = "B681B4338E63E9BDE475C3E1E59180D7")

    public static final Parcelable.Creator<Surface> CREATOR
            = new Parcelable.Creator<Surface>()
    {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.677 -0500", hash_original_method = "B8797068538D7B2F1963613F92E62B32", hash_generated_method = "A1A216CB81EED147F47FB283741B3A02")
        
public Surface createFromParcel(Parcel source) {
            try {
                return new Surface(source);
            } catch (Exception e) {
                Log.e(LOG_TAG, "Exception creating surface from parcel", e);
            }
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.679 -0500", hash_original_method = "38FBCD3B929BD371241F41AD88A154ED", hash_generated_method = "6EECC287C210EB1830879953D597246F")
        
public Surface[] newArray(int size) {
            return new Surface[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.528 -0500", hash_original_field = "D2C19D23BCFA602EF5D6331515EAA331", hash_generated_field = "2EECDAF2890B3E663F5C16C67DEDCF63")

    // server or system processes. When this class is parceled we defer to the
    // mSurfaceControl to do the parceling. Otherwise we parcel the
    // mNativeSurface.
    private int mSurfaceControl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.530 -0500", hash_original_field = "3E99E735C999ACA3C490084B9670350A", hash_generated_field = "A0D4D8EA840808F4949CA72E7B280524")

    private int mSaveCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.532 -0500", hash_original_field = "D8DB47E921EE865182E76421C432A14B", hash_generated_field = "8D4942A1FCE89D15FDC57EFABEDBC717")

    private Canvas mCanvas;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.534 -0500", hash_original_field = "C16EA170EA30FE750BCD74950445B3FF", hash_generated_field = "135E03AE60E04B6C9A1CE3A6EC7E0070")

    private int mNativeSurface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.537 -0500", hash_original_field = "062F334796BB3C14A6D2B9BD87851352", hash_generated_field = "81B134DE4CE27806029BB8F16BA06618")

    private int mSurfaceGenerationId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.539 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.541 -0500", hash_original_field = "FCC141B6EB958D5F2A1FF46D7FE98DB0", hash_generated_field = "128E4171312D35F248A8231C51A1125B")

    // the canvas to perform the appropriate density transformation.
    private Translator mCompatibilityTranslator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.543 -0500", hash_original_field = "30B5E55C81A78A81A696F5C57D175430", hash_generated_field = "FB164687418BBA4F0FB890E3B87C551B")

    // non compatibility mode.
    private Matrix mCompatibleMatrix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.545 -0500", hash_original_field = "5899EFB334D82C3E1B70A05D99D2EB90", hash_generated_field = "3D60FB93273F748E494C53BEB8064D29")

    private Exception mCreationStack;

    /**
     * Create Surface from a {@link SurfaceTexture}.
     *
     * Images drawn to the Surface will be made available to the {@link
     * SurfaceTexture}, which can attach them an OpenGL ES texture via {@link
     * SurfaceTexture#updateTexImage}.
     *
     * @param surfaceTexture The {@link SurfaceTexture} that is updated by this
     * Surface.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.455 -0500", hash_original_method = "3C6D5ED7C9D2AD52254061DCBE40C6B7", hash_generated_method = "E3F38C17C8BAB036D606EBDC97BCADA7")
    
public Surface(SurfaceTexture surfaceTexture) {
        if (DEBUG_RELEASE) {
            mCreationStack = new Exception();
        }
        mCanvas = new CompatibleCanvas();
        initFromSurfaceTexture(surfaceTexture);
    }

    /** create a surface @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.553 -0500", hash_original_method = "63DD348776A9AD7A69FD5A5406A9D749", hash_generated_method = "1CDB78F6F20A3763102BAAC283222D6C")
    
public Surface(SurfaceSession s,
            int pid, int display, int w, int h, int format, int flags)
        throws OutOfResourcesException {
        if (DEBUG_RELEASE) {
            mCreationStack = new Exception();
        }
        mCanvas = new CompatibleCanvas();
        init(s,pid,null,display,w,h,format,flags);
    }

    /** create a surface with a name @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.556 -0500", hash_original_method = "77F92398B62C28FF78E552B775B6A70A", hash_generated_method = "3CE714F184A955A0C21885AE16BD2C8A")
    
public Surface(SurfaceSession s,
            int pid, String name, int display, int w, int h, int format, int flags)
        throws OutOfResourcesException {
        if (DEBUG_RELEASE) {
            mCreationStack = new Exception();
        }
        mCanvas = new CompatibleCanvas();
        init(s,pid,name,display,w,h,format,flags);
        mName = name;
    }

    /**
     * Create an empty surface, which will later be filled in by
     * readFromParcel().
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.558 -0500", hash_original_method = "CA741F0DB07B20B1C302E68F5EF5136C", hash_generated_method = "C48BCEC0AB24F9C8AB381CE696E70EFA")
    
public Surface() {
        if (DEBUG_RELEASE) {
            mCreationStack = new Exception();
        }
        mCanvas = new CompatibleCanvas();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.561 -0500", hash_original_method = "6ECF42DC85BE770B3A0C34165723456A", hash_generated_method = "B18B70B7EB02FE5150EB18DF91E4CF68")
    
private Surface(Parcel source) throws OutOfResourcesException {
        init(source);
    }

    /**
     * Does this object hold a valid surface?  Returns true if it holds
     * a physical surface, so lockCanvas() will succeed.  Otherwise
     * returns false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.458 -0500", hash_original_method = "F1240C06AF1BA9E648B2E780B8155F1C", hash_generated_method = "F25A5C2CD89FC9EEA36613EED4E803A6")
    
    public boolean isValid(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    /** Release the local reference to the server-side surface.  
     * Always call release() when you're done with a Surface. This will
     * make the surface invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.462 -0500", hash_original_method = "1E8C38EACEA1E94FE658824D01FD2A18", hash_generated_method = "278A7E53643DE73F8A80E1A85A107DD5")
    
    public void release(){
    	//Formerly a native method
    }

    /** draw into a surface */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.465 -0500", hash_original_method = "F02785EB89A3C576418753FA8D7724E3", hash_generated_method = "D05FA6BA1BF2FAD8E887D4C5FE8C9DAF")
    
public Canvas lockCanvas(Rect dirty) throws OutOfResourcesException, IllegalArgumentException {
        /*
         * the dirty rectangle may be expanded to the surface's size, if for
         * instance it has been resized or if the bits were lost, since the last
         * call.
         */
        return lockCanvasNative(dirty);
    }

    /** unlock the surface and asks a page flip */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.469 -0500", hash_original_method = "1664CDF216B0331D581B002047F21426", hash_generated_method = "BBECBC9C9331443995A0AB76563E077B")
    
    public void unlockCanvasAndPost(Canvas canvas){
    	//Formerly a native method
    	addTaint(canvas.getTaint());
    }

    /** 
     * unlock the surface. the screen won't be updated until
     * post() or postAll() is called
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.472 -0500", hash_original_method = "9F24053A4EC94DBA8AA05836E657F81D", hash_generated_method = "D4C120861F559D2401C5E583DE1491F6")
    
    public void unlockCanvas(Canvas canvas){
    	//Formerly a native method
    	addTaint(canvas.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.475 -0500", hash_original_method = "FD610F755B3A8168C37DFBCC26EDD5A5", hash_generated_method = "54AB5DF9C4117B8784EF6101A4996B57")
    
@Override
    public String toString() {
        return "Surface(name=" + mName + ", identity=" + getIdentity() + ")";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.477 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.480 -0500", hash_original_method = "A2AACDDA330848E1D1B1D4F055379C04", hash_generated_method = "A44A121498C18C4DA191B72E1EB33CE9")
    
    public void readFromParcel(Parcel source){
    	//Formerly a native method
    	addTaint(source.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.484 -0500", hash_original_method = "C84F8D8C205C1B394ACE8E5A5C73E3F6", hash_generated_method = "724785F321190F7EF48F70BF293EEE68")
    
    public void writeToParcel(Parcel dest, int flags){
    	//Formerly a native method
    	addTaint(dest.getTaint());
    	addTaint(flags);
    }

    /**
     * Copy another surface to this one.  This surface now holds a reference
     * to the same data as the original surface, and is -not- the owner.
     * This is for use by the window manager when returning a window surface
     * back from a client, converting it from the representation being managed
     * by the window manager to the representation the client uses to draw
     * in to it.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.565 -0500", hash_original_method = "1CEDD42C8B2FBCD0475C0CDDE7D9C910", hash_generated_method = "D1F9A3C528664A4811E23CEB5B4F8B3B")
    
    public void copyFrom(Surface o){
    	//Formerly a native method
    	addTaint(o.getTaint());
    }

    /**
     * Transfer the native state from 'o' to this surface, releasing it
     * from 'o'.  This is for use in the client side for drawing into a
     * surface; not guaranteed to work on the window manager side.
     * This is for use by the client to move the underlying surface from
     * one Surface object to another, in particular in SurfaceFlinger.
     * @hide.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.569 -0500", hash_original_method = "16EE9E8EF08EFD3BA0284B735E7BCC13", hash_generated_method = "252211F4AF72D0C8A67752AE95853AA0")
    
    public void transferFrom(Surface o){
    	//Formerly a native method
    	addTaint(o.getTaint());
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.571 -0500", hash_original_method = "4CE5C8D563EAB7D0D818407349F1750B", hash_generated_method = "CB5C5102ADE60B37D98C7F6F69F9726C")
    
public int getGenerationId() {
        return mSurfaceGenerationId;
    }

    /**
     * Sets the translator used to scale canvas's width/height in compatibility
     * mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.589 -0500", hash_original_method = "CB1C97A8279A76B0FD2F8557CCA1DF81", hash_generated_method = "CB1C97A8279A76B0FD2F8557CCA1DF81")
    
void setCompatibilityTranslator(Translator translator) {
        if (translator != null) {
            float appScale = translator.applicationScale;
            mCompatibleMatrix = new Matrix();
            mCompatibleMatrix.setScale(appScale, appScale);
        }
    }
    
    public static class OutOfResourcesException extends Exception {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.487 -0500", hash_original_method = "61F4EF1E830289140B20E24C64AAB8C1", hash_generated_method = "61E15EE14C5CBDE674C8414A5D82F699")
        
public OutOfResourcesException() {
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.490 -0500", hash_original_method = "939C993D5367F7A0F0B43DA6997565C5", hash_generated_method = "8B56E09EC06DA5D20A9DD318E0B09E28")
        
public OutOfResourcesException(String name) {
            super(name);
        }
        
    }
    
    private class CompatibleCanvas extends Canvas {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.573 -0500", hash_original_field = "8524719924A3573CC4E02450270F3A29", hash_generated_field = "379D1DE57EE71D7AC75E059FE9ADC328")

        private Matrix mOrigMatrix = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.070 -0400", hash_original_method = "9F84EE428B625E49141923C25C0021D6", hash_generated_method = "9F84EE428B625E49141923C25C0021D6")
        public CompatibleCanvas ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.576 -0500", hash_original_method = "4436A903F00C274285C5C4A8B9E9A836", hash_generated_method = "7E4FCA6940233D2ACFDD830B11A7EB5E")
        
@Override
        public int getWidth() {
            int w = super.getWidth();
            if (mCompatibilityTranslator != null) {
                w = (int)(w * mCompatibilityTranslator.applicationInvertedScale + .5f);
            }
            return w;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.578 -0500", hash_original_method = "F355CB2C14EBD84D4AE7E0F5ECAE6C3D", hash_generated_method = "1F36206BE99414248829BD77B2AE6B44")
        
@Override
        public int getHeight() {
            int h = super.getHeight();
            if (mCompatibilityTranslator != null) {
                h = (int)(h * mCompatibilityTranslator.applicationInvertedScale + .5f);
            }
            return h;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.582 -0500", hash_original_method = "50EBC9F34A364763AC7C9602053D9FF8", hash_generated_method = "E13F6E0B43D4925111FCC2FA8313E7C6")
        
@Override
        public void setMatrix(Matrix matrix) {
            if (mCompatibleMatrix == null || mOrigMatrix == null || mOrigMatrix.equals(matrix)) {
                // don't scale the matrix if it's not compatibility mode, or
                // the matrix was obtained from getMatrix.
                super.setMatrix(matrix);
            } else {
                Matrix m = new Matrix(mCompatibleMatrix);
                m.preConcat(matrix);
                super.setMatrix(m);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.585 -0500", hash_original_method = "8FC81697AA41EC8DD4975B897D7BBDC3", hash_generated_method = "15EF46FE97BFF34531F2CBDF0368D300")
        
@Override
        public void getMatrix(Matrix m) {
            super.getMatrix(m);
            if (mOrigMatrix == null) {
                mOrigMatrix = new Matrix(); 
            }
            mOrigMatrix.set(m);
        }
        
    }
    
    /** Free all server-side state associated with this surface and
     * release this object's reference. @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.593 -0500", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "3AAE24EA40D9BE7257B5CCB9F51428C3")
    
    public void destroy(){
    	//Formerly a native method
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.826 -0400", hash_original_method = "187F763AA53C0F8EE9F854FE8C7B0DA2", hash_generated_method = "0FF923E44844D20FE339E44DC3CFAC90")
    private Canvas lockCanvasNative(Rect dirty) {
    	return new Canvas();
    }
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.630 -0500", hash_original_method = "428DEA65454197BAB1AB2F833BF39B55", hash_generated_method = "3973914188D9E8A75AE1D0CAB388FB31")
    
    public void setLayer(int zorder){
    	//Formerly a native method
    	addTaint(zorder);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.632 -0500", hash_original_method = "7F99A19F828A289B6FD343EC8CB65512", hash_generated_method = "F7A531A9713D9363D5D964629569CBF2")
    
public void setPosition(int x, int y) { setPosition((float)x, (float)y); }
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.636 -0500", hash_original_method = "D556E449F3DAE9E225E5655A6439B288", hash_generated_method = "5B49816C9A76A1146C5474049DD5AD0E")
    
    public void setPosition(float x, float y){
    	//Formerly a native method
    	addTaint(x);
    	addTaint(y);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.640 -0500", hash_original_method = "7F2FB86FF01FCE5B1880FA85C66C3806", hash_generated_method = "C4CAC27FACC8D46B58ED0F7EA9D28646")
    
    public void setSize(int w, int h){
    	//Formerly a native method
    	addTaint(w);
    	addTaint(h);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.643 -0500", hash_original_method = "58365D1B8E35BD4BC81D336D692C97A2", hash_generated_method = "3EB437883B4F4B01DF9F3286EBB5C3B2")
    
    public void hide(){
    	//Formerly a native method
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.647 -0500", hash_original_method = "9067AC917FFB66A9E8FF84EA37A89CBE", hash_generated_method = "F58456660563C088D74545665C95A327")
    
    public void show(){
    	//Formerly a native method
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.651 -0500", hash_original_method = "8BC3F7928D017996CA20E3AD22A58A3C", hash_generated_method = "45E31633C18F4BE22F3BCE924F3F1CBC")
    
    public void setTransparentRegionHint(Region region){
    	//Formerly a native method
    	addTaint(region.getTaint());
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.655 -0500", hash_original_method = "021CC1A8FCE5777EEDC941EBD3709765", hash_generated_method = "C6ADA6909290E34EC9B200156B8B755B")
    
    public void setAlpha(float alpha){
    	//Formerly a native method
    	addTaint(alpha);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.659 -0500", hash_original_method = "C221BDABC27AE9327206947389DE8DAC", hash_generated_method = "7DD4E0A546DD083805A228D1E4AB950C")
    
    public void setMatrix(float dsdx, float dtdx, float dsdy, float dtdy){
    	//Formerly a native method
    	addTaint(dsdx);
    	addTaint(dtdx);
    	addTaint(dsdy);
    	addTaint(dtdy);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.663 -0500", hash_original_method = "1F5223037E46C5C80D7D4FC991D282C9", hash_generated_method = "0638877C857D5E886913232BCF19C0F3")
    
    public void freeze(){
    	//Formerly a native method
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.666 -0500", hash_original_method = "510610C10E363AFDA52A6703982BC316", hash_generated_method = "8BF42B09015A42FA6227720408581AF9")
    
    public void unfreeze(){
    	//Formerly a native method
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.669 -0500", hash_original_method = "B3E5D6D54C5D692662BF006C8E303D59", hash_generated_method = "B8DCA82526DC465F8759B65384435F94")
    
    public void setFreezeTint(int tint){
    	//Formerly a native method
    	addTaint(tint);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.673 -0500", hash_original_method = "C7085AACC0EA197CCDBEBDC91CFFCA9E", hash_generated_method = "F413B4B81653EEC8936D451A1C78ED50")
    
    public void setFlags(int flags, int mask){
    	//Formerly a native method
    	addTaint(flags);
    	addTaint(mask);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.684 -0500", hash_original_method = "1BAE2B05EDDA8E2427743FE96FA46E82", hash_generated_method = "38D56802FE40307751E55D69AFDE7EA9")
    
@Override
    protected void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            if (mNativeSurface != 0 || mSurfaceControl != 0) {
                if (DEBUG_RELEASE) {
                    Log.w(LOG_TAG, "Surface.finalize() has work. You should have called release() (" 
                            + mNativeSurface + ", " + mSurfaceControl + ")", mCreationStack);
                } else {
                    Log.w(LOG_TAG, "Surface.finalize() has work. You should have called release() (" 
                            + mNativeSurface + ", " + mSurfaceControl + ")");
                }
            }
            release();            
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.689 -0500", hash_original_method = "6CC4E2A6788D537FAA561FF2F1482110", hash_generated_method = "D5E13DCCED37C3B2152A231367A45D50")
    
    private void init(SurfaceSession s,
                int pid, String name, int display, int w, int h, int format, int flags)
                throws OutOfResourcesException{
    	//Formerly a native method
    	addTaint(s.getTaint());
    	addTaint(pid);
    	addTaint(name.getTaint());
    	addTaint(display);
    	addTaint(w);
    	addTaint(h);
    	addTaint(format);
    	addTaint(flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.693 -0500", hash_original_method = "F10A64920BEF86A35D10AFBE49D37C12", hash_generated_method = "4B2B3F5E9DC41B18919C903B236F7CD8")
    
    private void init(Parcel source){
    	//Formerly a native method
    	addTaint(source.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.696 -0500", hash_original_method = "EBFCAC1A806E7105045857BE7B671E13", hash_generated_method = "78A2DEAE5432D736544DB5B6C5BD3BC8")
    
    private void initFromSurfaceTexture(SurfaceTexture surfaceTexture){
    	//Formerly a native method
    	addTaint(surfaceTexture.getTaint());
    }

    static { nativeClassInit(); }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:28.700 -0500", hash_original_method = "A65BCA62207C2D99277C23D442CBFDBD", hash_generated_method = "9B9FAD3CC8573BEA4ECFF053EBBDD166")
    
    private int getIdentity(){
    	//Formerly a native method
    	return getTaintInt();
    }

    // orphaned legacy method
    public Surface createFromParcel(Parcel source) {
            try {
                return new Surface(source);
            } catch (Exception e) {
                Log.e(LOG_TAG, "Exception creating surface from parcel", e);
            }
            return null;
        }
    
    // orphaned legacy method
    public Surface[] newArray(int size) {
            return new Surface[size];
        }
    
}

