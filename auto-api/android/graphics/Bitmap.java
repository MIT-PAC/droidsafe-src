package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class Bitmap implements Parcelable {
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.224 -0400", hash_original_field = "F16492AD902BDE58E3AAF1B990115133", hash_generated_field = "44187EAF844F975F9CC351362B5828D9")
	public int mNativeBitmap;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.224 -0400", hash_original_field = "0A6D158B6C8BF0C1A56582199871274D", hash_generated_field = "D26E89192452D152F1B0620ACC981170")
	public byte[] mBuffer;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.224 -0400", hash_original_field = "2D0BC5276619D20C917420C774FF5089", hash_generated_field = "D5ECB585FDF82CD3261AE26CF7CC63CA")
	@SuppressWarnings({ "FieldCanBeLocal", "UnusedDeclaration" })
	private BitmapFinalizer mFinalizer;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.224 -0400", hash_original_field = "E62BED608586C761CD92607B7C2EF1FD", hash_generated_field = "9C32056DAC69AD0374E74408422BBEB9")
	private boolean mIsMutable;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.224 -0400", hash_original_field = "D3261EC38F92DF331844BA8BBC57CDB0", hash_generated_field = "436C2ED570DD3AA7577644DBEE1CE62A")
	private byte[] mNinePatchChunk;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.224 -0400", hash_original_field = "A95631D81A2F2A7712CA1BACF8C3ED06", hash_generated_field = "E5A03441D6069228A477C954385A251B")
	private int mWidth = -1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.224 -0400", hash_original_field = "B3AC750C72790F3A16FDCF47C86F48B7", hash_generated_field = "799F7A00E6DAB63292A42CD8E01B88BC")
	private int mHeight = -1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.224 -0400", hash_original_field = "1212A62D731F217836716E35FA12386C", hash_generated_field = "2C8375875524783DEB30CD6C7E943390")
	private boolean mRecycled;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.224 -0400", hash_original_field = "9F8FEF6E0A2744C399FE0A9EF16A8539", hash_generated_field = "DFE44862C379A23055CB9029F03233AE")
	int mDensity = sDefaultDensity = getDefaultDensity();

	public Bitmap() {

	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.225 -0400", hash_original_method = "99AF26591A06E5269F88FBD6B3710F13", hash_generated_method = "94F9D3E4AA3B3BDFD8611768A1633B28")
	Bitmap(int nativeBitmap, byte[] buffer, boolean isMutable, byte[] ninePatchChunk, int density) {
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("internal error: native bitmap is 0");
		} 
		mBuffer = buffer;
		mNativeBitmap = nativeBitmap;
		mFinalizer = new BitmapFinalizer(nativeBitmap);
		mIsMutable = isMutable;
		mNinePatchChunk = ninePatchChunk;
		{
			mDensity = density;
		} 
			
			
			
		
		
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    public static void setDefaultDensity(int density) {
		sDefaultDensity = density;
	}

	@DSModeled(DSC.SAFE)
    static int getDefaultDensity() {
		if (sDefaultDensity >= 0) {
			return sDefaultDensity;
		}
		sDefaultDensity = DisplayMetrics.DENSITY_DEVICE;
		return sDefaultDensity;
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.226 -0400", hash_original_method = "ED34D3D3464A21C5929C60D84F577074", hash_generated_method = "93728BA52F1239035003DB1D6067C4C8")
	public int getDensity() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1054243371 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1054243371;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.226 -0400", hash_original_method = "9862D9E59C2B168AB35D015A9ED81A18", hash_generated_method = "58D723A4F769D2A3CBAF9A17D68E73B4")
	public void setDensity(int density) {
		mDensity = density;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.226 -0400", hash_original_method = "30CA035C727F2D2385273CE8F87AAA35", hash_generated_method = "84E478FF6E7328C663D71E05433F8696")
	public void setNinePatchChunk(byte[] chunk) {
		mNinePatchChunk = chunk;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.227 -0400", hash_original_method = "F143F03043BA4507E1E78FA3303F668C", hash_generated_method = "C80B2A72009FC42545A99B19062C110C")
	public void recycle() {
		{
			mBuffer = null;
			nativeRecycle(mNativeBitmap);
			mNinePatchChunk = null;
			mRecycled = true;
		} 
			
			
			
			
			
			
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.228 -0400", hash_original_method = "B80D9A696720D276C6AF21D39513741E", hash_generated_method = "704C634CE0AF211E1BE2B64397A63A40")
	public final boolean isRecycled() {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1702925310 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1702925310;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.229 -0400", hash_original_method = "9DF0E31331C580F9A696941C282E8CDA", hash_generated_method = "46FCAE526AA9B619C14E407F714D384B")
	public int getGenerationId() {
		int var212795BBF0B899D6098254B7268EC186_1690779644 = (nativeGenerationId(mNativeBitmap));
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1392596692 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1392596692;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.229 -0400", hash_original_method = "C3E161F555FEE180C4B024634334055B", hash_generated_method = "2AB12235F54ED1E12298F2F9CAA69EE9")
	private void checkRecycled(String errorMessage) {
		{
			if (DroidSafeAndroidRuntime.control)
				throw new IllegalStateException(errorMessage);
		} 
		addTaint(errorMessage.getTaint());
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    private static void checkXYSign(int x, int y) {
		if (x < 0) {
			throw new IllegalArgumentException("x must be >= 0");
		}
		if (y < 0) {
			throw new IllegalArgumentException("y must be >= 0");
		}
	}

	@DSModeled(DSC.SAFE)
    private static void checkWidthHeight(int width, int height) {
		if (width <= 0) {
			throw new IllegalArgumentException("width must be > 0");
		}
		if (height <= 0) {
			throw new IllegalArgumentException("height must be > 0");
		}
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.231 -0400", hash_original_method = "6E96276EBE2927D59F0A224BEB5CF764", hash_generated_method = "57CD6B2F6D105998C3E8704EDC5DA18C")
	public void copyPixelsToBuffer(Buffer dst) {
		int elements = dst.remaining();
		int shift;
		{
			shift = 0;
		} 
		{
			shift = 1;
		} 
		{
			shift = 2;
		} 
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("unsupported Buffer subclass");
		} 
		long bufferSize = (long) elements << shift;
		long pixelSize = getByteCount();
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("Buffer not large enough for pixels");
		} 
		nativeCopyPixelsToBuffer(mNativeBitmap, dst);
		int position = dst.position();
		position += pixelSize >> shift;
		dst.position(position);
		addTaint(dst.getTaint());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.232 -0400", hash_original_method = "DF4D046D4E3EE4FA52893B437F7EAF42", hash_generated_method = "39768A1B4D519E397E48C6A1371991C5")
	public void copyPixelsFromBuffer(Buffer src) {
		checkRecycled("copyPixelsFromBuffer called on recycled bitmap");
		int elements = src.remaining();
		int shift;
		{
			shift = 0;
		} 
		{
			shift = 1;
		} 
		{
			shift = 2;
		} 
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("unsupported Buffer subclass");
		} 
		long bufferBytes = (long) elements << shift;
		long bitmapBytes = getByteCount();
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("Buffer not large enough for pixels");
		} 
		nativeCopyPixelsFromBuffer(mNativeBitmap, src);
		addTaint(src.getTaint());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.233 -0400", hash_original_method = "5A36626FB0A5325F859AD016AE482420", hash_generated_method = "FCC6FC075140162272853DAE77210F9A")
	public Bitmap copy(Config config, boolean isMutable) {
		Bitmap varB4EAC82CA7396A68D541C85D26508E83_1358647877 = null; 
																		
																		
																		
		checkRecycled("Can't copy a recycled bitmap");
		Bitmap b = nativeCopy(mNativeBitmap, config.nativeInt, isMutable);
		{
			b.mDensity = mDensity;
		} 
		varB4EAC82CA7396A68D541C85D26508E83_1358647877 = b;
		addTaint(config.getTaint());
		addTaint(isMutable);
		varB4EAC82CA7396A68D541C85D26508E83_1358647877.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1358647877;
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    public static Bitmap createScaledBitmap(Bitmap src, int dstWidth, int dstHeight, boolean filter) {
		Matrix m;
		synchronized (Bitmap.class) {
			m = sScaleMatrix;
			sScaleMatrix = null;
		}
		if (m == null) {
			m = new Matrix();
		}
		final int width = src.getWidth();
		final int height = src.getHeight();
		final float sx = dstWidth / (float) width;
		final float sy = dstHeight / (float) height;
		m.setScale(sx, sy);
		Bitmap b = Bitmap.createBitmap(src, 0, 0, width, height, m, filter);
		synchronized (Bitmap.class) {
			if (sScaleMatrix == null) {
				sScaleMatrix = m;
			}
		}
		return b;
	}

	@DSModeled(DSC.SAFE)
    public static Bitmap createBitmap(Bitmap src) {
		return createBitmap(src, 0, 0, src.getWidth(), src.getHeight());
	}

	@DSModeled(DSC.SAFE)
    public static Bitmap createBitmap(Bitmap source, int x, int y, int width, int height) {
		return createBitmap(source, x, y, width, height, null, false);
	}

	@DSModeled(DSC.SAFE)
    public static Bitmap createBitmap(Bitmap source, int x, int y, int width, int height, Matrix m, boolean filter) {
		checkXYSign(x, y);
		checkWidthHeight(width, height);
		if (x + width > source.getWidth()) {
			throw new IllegalArgumentException("x + width must be <= bitmap.width()");
		}
		if (y + height > source.getHeight()) {
			throw new IllegalArgumentException("y + height must be <= bitmap.height()");
		}
		if (!source.isMutable() && x == 0 && y == 0 && width == source.getWidth() && height == source.getHeight() && (m == null || m.isIdentity())) {
			return source;
		}
		int neww = width;
		int newh = height;
		Canvas canvas = new Canvas();
		Bitmap bitmap;
		Paint paint;
		Rect srcR = new Rect(x, y, x + width, y + height);
		RectF dstR = new RectF(0, 0, width, height);
		Config newConfig = Config.ARGB_8888;
		final Config config = source.getConfig();
		if (config != null) {
			switch (config) {
			case RGB_565:
				newConfig = Config.RGB_565;
				break;
			case ALPHA_8:
				newConfig = Config.ALPHA_8;
				break;
			case ARGB_4444:
			case ARGB_8888:
			default:
				newConfig = Config.ARGB_8888;
				break;
			}
		}
		if (m == null || m.isIdentity()) {
			bitmap = createBitmap(neww, newh, newConfig, source.hasAlpha());
			paint = null;
		} else {
			final boolean transformed = !m.rectStaysRect();
			RectF deviceR = new RectF();
			m.mapRect(deviceR, dstR);
			neww = Math.round(deviceR.width());
			newh = Math.round(deviceR.height());
			bitmap = createBitmap(neww, newh, transformed ? Config.ARGB_8888 : newConfig, transformed || source.hasAlpha());
			canvas.translate(-deviceR.left, -deviceR.top);
			canvas.concat(m);
			paint = new Paint();
			paint.setFilterBitmap(filter);
			if (transformed) {
				paint.setAntiAlias(true);
			}
		}
		bitmap.mDensity = source.mDensity;
		canvas.setBitmap(bitmap);
		canvas.drawBitmap(source, srcR, dstR, paint);
		canvas.setBitmap(null);
		return bitmap;
	}

	@DSModeled(DSC.SAFE)
    public static Bitmap createBitmap(int width, int height, Config config) {
		return createBitmap(width, height, config, true);
	}

	@DSModeled(DSC.SAFE)
    private static Bitmap createBitmap(int width, int height, Config config, boolean hasAlpha) {
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException("width and height must be > 0");
		}
		Bitmap bm = nativeCreate(null, 0, width, width, height, config.nativeInt, true);
		if (config == Config.ARGB_8888 && !hasAlpha) {
			nativeErase(bm.mNativeBitmap, 0xff000000);
			nativeSetHasAlpha(bm.mNativeBitmap, hasAlpha);
		} else {
		}
		return bm;
	}

	@DSModeled(DSC.SAFE)
    public static Bitmap createBitmap(int colors[], int offset, int stride, int width, int height, Config config) {
		checkWidthHeight(width, height);
		if (Math.abs(stride) < width) {
			throw new IllegalArgumentException("abs(stride) must be >= width");
		}
		int lastScanline = offset + (height - 1) * stride;
		int length = colors.length;
		if (offset < 0 || (offset + width > length) || lastScanline < 0 || (lastScanline + width > length)) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException("width and height must be > 0");
		}
		return nativeCreate(colors, offset, stride, width, height, config.nativeInt, false);
	}

	@DSModeled(DSC.SAFE)
    public static Bitmap createBitmap(int colors[], int width, int height, Config config) {
		return createBitmap(colors, 0, width, width, height, config);
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.236 -0400", hash_original_method = "FE9BA3F148B3AC85DF389A396D130B66", hash_generated_method = "D29547CC4A9856A919F446B7DD017690")
	public byte[] getNinePatchChunk() {
		byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_776031311 = { getTaintByte() };
		return var2F9C81BC6E497382285CD6B7A7E33DE1_776031311;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.238 -0400", hash_original_method = "222D378B2B8943C109AD4B8264ED828B", hash_generated_method = "601D0E39520D39A5A90FA4D2697CECA0")
	public boolean compress(CompressFormat format, int quality, OutputStream stream) {
		checkRecycled("Can't compress a recycled bitmap");
		{
			if (DroidSafeAndroidRuntime.control)
				throw new NullPointerException();
		} 
		{
			if (DroidSafeAndroidRuntime.control)
				throw new IllegalArgumentException("quality must be 0..100");
		} 
		boolean varF801D4584D511A06756607336723DBB1_1471831910 = (nativeCompress(mNativeBitmap, format.nativeInt, quality, stream, new byte[WORKING_COMPRESS_STORAGE]));
		addTaint(format.getTaint());
		addTaint(quality);
		addTaint(stream.getTaint());
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1258015804 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1258015804;
		
		
		
		
		
		
		
		
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.238 -0400", hash_original_method = "AC5E4B63287018AAA83AB6875AD71BA5", hash_generated_method = "C115DEAB5231CDBFBD3DEC8E3A428585")
	public final boolean isMutable() {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1882514071 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1882514071;
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.241 -0400", hash_original_method = "9273E6434E2E49D8D6A7BEF0351E82F0", hash_generated_method = "749874DDF85E622D4191074D87D3A1A6")
	public final int getWidth() {
		{
			Object var14BFC634F145725DC48467A508F60C75_1659227728 = (mWidth = nativeWidth(mNativeBitmap));
		} 
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237550009 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237550009;
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.242 -0400", hash_original_method = "C9C832E0F45CC5A7AD0241E8F16710F4", hash_generated_method = "E01CE3C2500A6AADFCD5A67F41024DD5")
	public final int getHeight() {
		{
			Object varA90DB7D8C83D02A678AC88E3CF32E02C_189163358 = (mHeight = nativeHeight(mNativeBitmap));
		} 
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107993300 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107993300;
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.243 -0400", hash_original_method = "7233800DBE61288AC88E6F84763631F6", hash_generated_method = "FB4649944DE41E65B05D483CE30A39F8")
	public int getScaledWidth(Canvas canvas) {
		int varD244B19BB376C166F704354639F6FD2A_10380987 = (scaleFromDensity(getWidth(), mDensity, canvas.mDensity));
		addTaint(canvas.getTaint());
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599381566 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599381566;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.243 -0400", hash_original_method = "25E674A6C63D1170FDA7E606406CA68F", hash_generated_method = "48D4EBA1C4505BC3B25BAED5F0258B46")
	public int getScaledHeight(Canvas canvas) {
		int var9C7679314AF2CB28ACC9E6D9F7DBE7C8_508315316 = (scaleFromDensity(getHeight(), mDensity, canvas.mDensity));
		addTaint(canvas.getTaint());
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1143005485 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1143005485;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.244 -0400", hash_original_method = "1717C0FEBD5DCA9C8E6AC6E449CF9117", hash_generated_method = "CF2B3DEE19AF83BBC0C4BD2A4E86D294")
	public int getScaledWidth(DisplayMetrics metrics) {
		int var22DDB9F91A59073EC3D37288D06D89F5_1711302095 = (scaleFromDensity(getWidth(), mDensity, metrics.densityDpi));
		addTaint(metrics.getTaint());
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_634412512 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_634412512;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.244 -0400", hash_original_method = "2419686B3EB221BCF5B58D4D017B048F", hash_generated_method = "C4B9B10ABAC64CED3F5E668D7D336ADA")
	public int getScaledHeight(DisplayMetrics metrics) {
		int varBC7E5446A696D0B9C3151FDCC509001B_599065521 = (scaleFromDensity(getHeight(), mDensity, metrics.densityDpi));
		addTaint(metrics.getTaint());
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827951902 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827951902;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.245 -0400", hash_original_method = "8DEB28B38EE84627DD4FE42858F9882C", hash_generated_method = "1FDDCD141FE2A03C7AC0B9D46F1D9298")
	public int getScaledWidth(int targetDensity) {
		int var40BBFFD6794B3ABECF2108DE9A398793_1947837431 = (scaleFromDensity(getWidth(), mDensity, targetDensity));
		addTaint(targetDensity);
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_802494266 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_802494266;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.246 -0400", hash_original_method = "936A1164B3B30000BDF78CB4ABE6FDD9", hash_generated_method = "2E99A527D983C43D31C36939EF7FCAEF")
	public int getScaledHeight(int targetDensity) {
		int varEBBA22F03E55C884FB7BC5702A806353_1285834407 = (scaleFromDensity(getHeight(), mDensity, targetDensity));
		addTaint(targetDensity);
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494638216 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494638216;
		
		
	}

	@DSModeled(DSC.SAFE)
    static public int scaleFromDensity(int size, int sdensity, int tdensity) {
		if (sdensity == DENSITY_NONE || sdensity == tdensity) {
			return size;
		}
		return ((size * tdensity) + (sdensity >> 1)) / sdensity;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.247 -0400", hash_original_method = "12640FDEC394A62871A05E7C4EB570D4", hash_generated_method = "D8FF5D6540BB56F25CCD712157CD240E")
	public final int getRowBytes() {
		int var0267412FC813FD8E20B12B849B0C1F93_1499440245 = (nativeRowBytes(mNativeBitmap));
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1268418958 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1268418958;
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.247 -0400", hash_original_method = "64813EB6D6A92E85FDB72E109CDAF838", hash_generated_method = "33B8AA26539AD8022DB65646E9872EB4")
	public final int getByteCount() {
		int var18558EEEC9B7BD46FC1B51B2AC00445A_257904416 = (getRowBytes() * getHeight());
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64548654 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64548654;
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.249 -0400", hash_original_method = "2965E803C3174189F0506D62E1B543D4", hash_generated_method = "6158B61EF8A2C8E57E3077E0D150646C")
	public final Config getConfig() {
		Config varB4EAC82CA7396A68D541C85D26508E83_110213994 = null; 
																		
																		
																		
		varB4EAC82CA7396A68D541C85D26508E83_110213994 = Config.nativeToConfig(nativeConfig(mNativeBitmap));
		varB4EAC82CA7396A68D541C85D26508E83_110213994.addTaint(getTaint()); 
																			
																			
																			
		return varB4EAC82CA7396A68D541C85D26508E83_110213994;
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.250 -0400", hash_original_method = "A9E6FFBE96B704702B1F2A7EDD472B86", hash_generated_method = "5E51550FE75D3B6E33C5607302A77F16")
	public final boolean hasAlpha() {
		boolean var800F787096C2FAD492BB45AE9E7A91D2_1767919258 = (nativeHasAlpha(mNativeBitmap));
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_959777408 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_959777408;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.251 -0400", hash_original_method = "9BF8F5FAA617B68A4287E64028C24BC4", hash_generated_method = "060ADFF4E1C348B48F39DF28EE5C5091")
	public void setHasAlpha(boolean hasAlpha) {
		nativeSetHasAlpha(mNativeBitmap, hasAlpha);
		addTaint(hasAlpha);
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.252 -0400", hash_original_method = "6CFCC21E4A33E66B4CBA687A2872E721", hash_generated_method = "EA503E321E4D1C4A9FC76BEBC145DA24")
	public void eraseColor(int c) {
		checkRecycled("Can't erase a recycled bitmap");
		{
			boolean var2D2A74E00B0F4ADB63FC14E0244B334F_1108139341 = (!isMutable());
			{
				if (DroidSafeAndroidRuntime.control)
					throw new IllegalStateException("cannot erase immutable bitmaps");
			} 
		} 
		nativeErase(mNativeBitmap, c);
		addTaint(c);
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.253 -0400", hash_original_method = "C5A0202C662F7E6C05A2B74C54AEFFD9", hash_generated_method = "7730450D35F39D78D14ABBE874685E81")
	public int getPixel(int x, int y) {
		checkRecycled("Can't call getPixel() on a recycled bitmap");
		checkPixelAccess(x, y);
		int var8FD6BA845BC7C15EFB43BAC7ED016EA5_1403713040 = (nativeGetPixel(mNativeBitmap, x, y));
		addTaint(x);
		addTaint(y);
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_589940134 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_589940134;
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.254 -0400", hash_original_method = "2EE219697E28A03CE1E0A040D289D28E", hash_generated_method = "DAA2C23B9860580B8248F11EFA967D40")
	public void getPixels(int[] pixels, int offset, int stride, int x, int y, int width, int height) {
		checkRecycled("Can't call getPixels() on a recycled bitmap");
		checkPixelsAccess(x, y, width, height, offset, stride, pixels);
		nativeGetPixels(mNativeBitmap, pixels, offset, stride, x, y, width, height);
		addTaint(pixels[0]);
		addTaint(offset);
		addTaint(stride);
		addTaint(x);
		addTaint(y);
		addTaint(width);
		addTaint(height);
		
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.255 -0400", hash_original_method = "F09D942FEC4FE9E75A7F8BD6FD9F7E4F", hash_generated_method = "F1C6289343EDE31972D0A968D154E7F0")
	private void checkPixelAccess(int x, int y) {
		checkXYSign(x, y);
		{
			boolean var30490CFCBE0CDDF5A434370B1DCE4F74_393122895 = (x >= getWidth());
			{
				if (DroidSafeAndroidRuntime.control)
					throw new IllegalArgumentException("x must be < bitmap.width()");
			} 
		} 
		{
			boolean var176BE51140078B0967F59852B69E3131_508189077 = (y >= getHeight());
			{
				if (DroidSafeAndroidRuntime.control)
					throw new IllegalArgumentException("y must be < bitmap.height()");
			} 
		} 
		addTaint(x);
		addTaint(y);
		
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.256 -0400", hash_original_method = "2B91B7FBA2B0FAF5EF0FAB9CE5B285D1", hash_generated_method = "D452CB99930A89EB534779C744F2ED3B")
	private void checkPixelsAccess(int x, int y, int width, int height, int offset, int stride, int pixels[]) {
		checkXYSign(x, y);
		{
			if (DroidSafeAndroidRuntime.control)
				throw new IllegalArgumentException("width must be >= 0");
		} 
		{
			if (DroidSafeAndroidRuntime.control)
				throw new IllegalArgumentException("height must be >= 0");
		} 
		{
			boolean varD810B239D6120F6BE5AD1443109E34E9_1851283507 = (x + width > getWidth());
			{
				if (DroidSafeAndroidRuntime.control)
					throw new IllegalArgumentException("x + width must be <= bitmap.width()");
			} 
		} 
		{
			boolean var81DF503DAA371D07CDBF07C44BC00011_1472651357 = (y + height > getHeight());
			{
				if (DroidSafeAndroidRuntime.control)
					throw new IllegalArgumentException("y + height must be <= bitmap.height()");
			} 
		} 
		{
			boolean varE73A6561371F12118506FC78AF1B9D6D_1577314047 = (Math.abs(stride) < width);
			{
				if (DroidSafeAndroidRuntime.control)
					throw new IllegalArgumentException("abs(stride) must be >= width");
			} 
		} 
		int lastScanline = offset + (height - 1) * stride;
		int length = pixels.length;
		{
			if (DroidSafeAndroidRuntime.control)
				throw new ArrayIndexOutOfBoundsException();
		} 
		addTaint(x);
		addTaint(y);
		addTaint(width);
		addTaint(height);
		addTaint(offset);
		addTaint(stride);
		addTaint(pixels[0]);
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.257 -0400", hash_original_method = "85459627EEB2B6C6AD7EB511C3D7B6BB", hash_generated_method = "F2B8B391B6B70FC806B0185D6C92AEBD")
	public void setPixel(int x, int y, int color) {
		checkRecycled("Can't call setPixel() on a recycled bitmap");
		{
			boolean var2D2A74E00B0F4ADB63FC14E0244B334F_356558138 = (!isMutable());
			{
				if (DroidSafeAndroidRuntime.control)
					throw new IllegalStateException();
			} 
		} 
		checkPixelAccess(x, y);
		nativeSetPixel(mNativeBitmap, x, y, color);
		addTaint(x);
		addTaint(y);
		addTaint(color);
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.257 -0400", hash_original_method = "ABE133BC8F623C77CA2A0241C4DBE1C8", hash_generated_method = "4CC55937BF219D54890283736012B74E")
	public void setPixels(int[] pixels, int offset, int stride, int x, int y, int width, int height) {
		checkRecycled("Can't call setPixels() on a recycled bitmap");
		{
			boolean var2D2A74E00B0F4ADB63FC14E0244B334F_1318312689 = (!isMutable());
			{
				if (DroidSafeAndroidRuntime.control)
					throw new IllegalStateException();
			} 
		} 
		checkPixelsAccess(x, y, width, height, offset, stride, pixels);
		nativeSetPixels(mNativeBitmap, pixels, offset, stride, x, y, width, height);
		addTaint(pixels[0]);
		addTaint(offset);
		addTaint(stride);
		addTaint(x);
		addTaint(y);
		addTaint(width);
		addTaint(height);
		
		
		
		
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.258 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "9C4558AE77A9FF7F93D0F5638649AAF4")
	public int describeContents() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1523302169 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1523302169;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.259 -0400", hash_original_method = "D2FB921E1DDA261A52B060B1EF7694C1", hash_generated_method = "E65667AC0B876A0D172C31FC0C0A55F1")
	public void writeToParcel(Parcel p, int flags) {
		checkRecycled("Can't parcel a recycled bitmap");
		{
			boolean var5DF242B1AD49EA84F890A63696D1516F_381260874 = (!nativeWriteToParcel(mNativeBitmap, mIsMutable, mDensity, p));
			{
				if (DroidSafeAndroidRuntime.control)
					throw new RuntimeException("native writeToParcel failed");
			} 
		} 
		addTaint(p.getTaint());
		addTaint(flags);
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.261 -0400", hash_original_method = "75D570937564149AAA647C007E5ED089", hash_generated_method = "6D35CE64C0BAA15FC8CEFF8D575C86FE")
	public Bitmap extractAlpha() {
		Bitmap varB4EAC82CA7396A68D541C85D26508E83_1790324847 = null; 
																		
																		
																		
		varB4EAC82CA7396A68D541C85D26508E83_1790324847 = extractAlpha(null, null);
		varB4EAC82CA7396A68D541C85D26508E83_1790324847.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1790324847;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.262 -0400", hash_original_method = "798FC3DD232FCC4B06F4415625A8D213", hash_generated_method = "37FCD7FD328AD0B836AAFAA776EA3AD7")
	public Bitmap extractAlpha(Paint paint, int[] offsetXY) {
		Bitmap varB4EAC82CA7396A68D541C85D26508E83_203314352 = null; 
																		
																		
																		
		checkRecycled("Can't extractAlpha on a recycled bitmap");
		int nativePaint;
		nativePaint = paint.mNativePaint;
		nativePaint = 0;
		Bitmap bm = nativeExtractAlpha(mNativeBitmap, nativePaint, offsetXY);
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("Failed to extractAlpha on Bitmap");
		} 
		bm.mDensity = mDensity;
		varB4EAC82CA7396A68D541C85D26508E83_203314352 = bm;
		addTaint(paint.getTaint());
		addTaint(offsetXY[0]);
		varB4EAC82CA7396A68D541C85D26508E83_203314352.addTaint(getTaint()); 
																			
																			
																			
		return varB4EAC82CA7396A68D541C85D26508E83_203314352;
		
		
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.263 -0400", hash_original_method = "3EA2D759216A517078419525658BBCD0", hash_generated_method = "743A26AD08323FE8682E62774E72E24F")
	public boolean sameAs(Bitmap other) {
		boolean var573FBB3F9978D0C6C4756653011FAC34_1526423670 = (this == other || (other != null && nativeSameAs(mNativeBitmap, other.mNativeBitmap)));
		addTaint(other.getTaint());
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_980139694 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_980139694;
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.263 -0400", hash_original_method = "ABCB940311631CB7A5E91625A11E0A13", hash_generated_method = "EDCD1A3F0894A6577A12906075EDF3F2")
	public void prepareToDraw() {
		nativePrepareToDraw(mNativeBitmap);
		
		
	}

	@DSModeled(DSC.SAFE)
    private static Bitmap nativeCreate(int[] colors, int offset, int stride, int width, int height, int nativeConfig, boolean mutable) {
		return new Bitmap();
	}

	@DSModeled(DSC.SAFE)
    private static Bitmap nativeCopy(int srcBitmap, int nativeConfig, boolean isMutable) {
		return new Bitmap();
	}

	@DSModeled(DSC.SAFE)
    private static void nativeDestructor(int nativeBitmap) {
	}

	@DSModeled(DSC.SAFE)
    private static void nativeRecycle(int nativeBitmap) {
	}

	@DSModeled(DSC.SAFE)
    private static boolean nativeCompress(int nativeBitmap, int format, int quality, OutputStream stream, byte[] tempStorage) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1104407749 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1104407749;
	}

	@DSModeled(DSC.SAFE)
    private static void nativeErase(int nativeBitmap, int color) {
	}

	@DSModeled(DSC.SAFE)
    private static int nativeWidth(int nativeBitmap) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883901434 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883901434;
	}

	@DSModeled(DSC.SAFE)
    private static int nativeHeight(int nativeBitmap) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1185058667 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1185058667;
	}

	@DSModeled(DSC.SAFE)
    private static int nativeRowBytes(int nativeBitmap) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006498156 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006498156;
	}

	@DSModeled(DSC.SAFE)
    private static int nativeConfig(int nativeBitmap) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_639280674 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_639280674;
	}

	@DSModeled(DSC.SAFE)
    private static boolean nativeHasAlpha(int nativeBitmap) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_606515604 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_606515604;
	}

	@DSModeled(DSC.SAFE)
    private static int nativeGetPixel(int nativeBitmap, int x, int y) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039533584 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039533584;
	}

	@DSModeled(DSC.SAFE)
    private static void nativeGetPixels(int nativeBitmap, int[] pixels, int offset, int stride, int x, int y, int width, int height) {
	}

	@DSModeled(DSC.SAFE)
    private static void nativeSetPixel(int nativeBitmap, int x, int y, int color) {
	}

	@DSModeled(DSC.SAFE)
    private static void nativeSetPixels(int nativeBitmap, int[] colors, int offset, int stride, int x, int y, int width, int height) {
	}

	@DSModeled(DSC.SAFE)
    private static void nativeCopyPixelsToBuffer(int nativeBitmap, Buffer dst) {
	}

	@DSModeled(DSC.SAFE)
    private static void nativeCopyPixelsFromBuffer(int nb, Buffer src) {
	}

	@DSModeled(DSC.SAFE)
    private static int nativeGenerationId(int nativeBitmap) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699577780 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699577780;
	}

	@DSModeled(DSC.SAFE)
    private static Bitmap nativeCreateFromParcel(Parcel p) {
		return new Bitmap();
	}

	@DSModeled(DSC.SAFE)
    private static boolean nativeWriteToParcel(int nativeBitmap, boolean isMutable, int density, Parcel p) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_709717476 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_709717476;
	}

	@DSModeled(DSC.SAFE)
    private static Bitmap nativeExtractAlpha(int nativeBitmap, int nativePaint, int[] offsetXY) {
		return new Bitmap();
	}

	@DSModeled(DSC.SAFE)
    private static void nativePrepareToDraw(int nativeBitmap) {
	}

	@DSModeled(DSC.SAFE)
    private static void nativeSetHasAlpha(int nBitmap, boolean hasAlpha) {
	}

	@DSModeled(DSC.SAFE)
    private static boolean nativeSameAs(int nb0, int nb1) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_767903221 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_767903221;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.274 -0400", hash_original_method = "C9F7301125E447423E7DB3CDD9C42E7E", hash_generated_method = "C7F1818930B6B4FF0574BCC1508378DC")
	final int ni() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1951476600 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1951476600;
		
		
	}

	public enum Config {
		ALPHA_8(2), RGB_565(4), @Deprecated
		ARGB_4444(5), ARGB_8888(6);
		final int nativeInt;
		@SuppressWarnings({ "deprecation" })
		private static Config sConfigs[] = { null, null, ALPHA_8, null, RGB_565, ARGB_4444, ARGB_8888 };

		Config(int ni) {
			this.nativeInt = ni;
		}

		static Config nativeToConfig(int ni) {
			return sConfigs[ni];
		}
	}

	public enum CompressFormat {
		JPEG(0), PNG(1), WEBP(2);
		CompressFormat(int nativeInt) {
			this.nativeInt = nativeInt;
		}

		final int nativeInt;
	}

	private static class BitmapFinalizer {
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.275 -0400", hash_original_field = "F16492AD902BDE58E3AAF1B990115133", hash_generated_field = "94EBE634EB926388C6FE9311F8ADAABA")
		private int mNativeBitmap;

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.275 -0400", hash_original_method = "0DDF139B38AD50F56D0AF26AB944EC3E", hash_generated_method = "2ABFC00A38D50D88F77B67505EB4A344")
		BitmapFinalizer(int nativeBitmap) {
			mNativeBitmap = nativeBitmap;
			
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.275 -0400", hash_original_method = "750E0A25CDE7A09F3C919B08C5243F0D", hash_generated_method = "F7615B068DA183F6083E4BBEA97826DB")
		@Override
		public void finalize() {
			try {
				super.finalize();
			} 
			catch (Throwable t) {
			} finally {
				nativeDestructor(mNativeBitmap);
			} 
				
				
				
			
			
			
			
		}

	}

	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.275 -0400", hash_original_field = "C71478846957767201391E31D504F7CF", hash_generated_field = "C25FA99E764685711DDB1FEBC88ADFFB")
	public static final int DENSITY_NONE = 0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.275 -0400", hash_original_field = "5B7CE7C3B907236423F83FB7C4C74DB5", hash_generated_field = "1395EEF7EE47C17BCE3B8566023F33E1")
	private static volatile Matrix sScaleMatrix;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.275 -0400", hash_original_field = "9F8879FC7AE169BC092D1EE3BC2FBD08", hash_generated_field = "9A5692A5868FC9DC94E238F1418014E4")
	private static volatile int sDefaultDensity = -1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.275 -0400", hash_original_field = "295B0C9790BF4CF54082ACBBD1BFA817", hash_generated_field = "835CBF2BDF2BE37014A11526CBB54378")
	private final static int WORKING_COMPRESS_STORAGE = 4096;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.275 -0400", hash_original_field = "BF846A98932B20D726C6F01DDC8F3632", hash_generated_field = "5962E9DA47CF5849E5C813893A51D279")
	public static final Parcelable.Creator<Bitmap> CREATOR = new Parcelable.Creator<Bitmap>() {

		public Bitmap createFromParcel(Parcel p) {
			Bitmap bm = nativeCreateFromParcel(p);
			if (bm == null) {
				throw new RuntimeException("Failed to unparcel Bitmap");
			}
			return bm;
		}

		public Bitmap[] newArray(int size) {
			return new Bitmap[size];
		}
	};
}
