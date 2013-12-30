package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.MediaFile.MediaFileType;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore.Images;
import android.util.Log;





public class ThumbnailUtils {

    /**
     * This method first examines if the thumbnail embedded in EXIF is bigger than our target
     * size. If not, then it'll create a thumbnail from original image. Due to efficiency
     * consideration, we want to let MediaThumbRequest avoid calling this method twice for
     * both kinds, so it only requests for MICRO_KIND and set saveImage to true.
     *
     * This method always returns a "square thumbnail" for MICRO_KIND thumbnail.
     *
     * @param filePath the path of image file
     * @param kind could be MINI_KIND or MICRO_KIND
     * @return Bitmap, or null on failures
     *
     * @hide This method is only used by media framework and media provider internally.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.755 -0500", hash_original_method = "8C4FBB07B0C99590FAA381B302C95C66", hash_generated_method = "742DE2C5038A96164760FF4738F32B6E")
    
public static Bitmap createImageThumbnail(String filePath, int kind) {
        boolean wantMini = (kind == Images.Thumbnails.MINI_KIND);
        int targetSize = wantMini
                ? TARGET_SIZE_MINI_THUMBNAIL
                : TARGET_SIZE_MICRO_THUMBNAIL;
        int maxPixels = wantMini
                ? MAX_NUM_PIXELS_THUMBNAIL
                : MAX_NUM_PIXELS_MICRO_THUMBNAIL;
        SizedThumbnailBitmap sizedThumbnailBitmap = new SizedThumbnailBitmap();
        Bitmap bitmap = null;
        MediaFileType fileType = MediaFile.getFileType(filePath);
        if (fileType != null && fileType.fileType == MediaFile.FILE_TYPE_JPEG) {
            createThumbnailFromEXIF(filePath, targetSize, maxPixels, sizedThumbnailBitmap);
            bitmap = sizedThumbnailBitmap.mBitmap;
        }

        if (bitmap == null) {
            try {
                FileDescriptor fd = new FileInputStream(filePath).getFD();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFileDescriptor(fd, null, options);
                if (options.mCancel || options.outWidth == -1
                        || options.outHeight == -1) {
                    return null;
                }
                options.inSampleSize = computeSampleSize(
                        options, targetSize, maxPixels);
                options.inJustDecodeBounds = false;

                options.inDither = false;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                bitmap = BitmapFactory.decodeFileDescriptor(fd, null, options);
            } catch (IOException ex) {
                Log.e(TAG, "", ex);
            } catch (OutOfMemoryError oom) {
                Log.e(TAG, "Unable to decode file " + filePath + ". OutOfMemoryError.", oom);
            }
        }

        if (kind == Images.Thumbnails.MICRO_KIND) {
            // now we make it a "square thumbnail" for MICRO_KIND thumbnail
            bitmap = extractThumbnail(bitmap,
                    TARGET_SIZE_MICRO_THUMBNAIL,
                    TARGET_SIZE_MICRO_THUMBNAIL, OPTIONS_RECYCLE_INPUT);
        }
        return bitmap;
    }

    /**
     * Create a video thumbnail for a video. May return null if the video is
     * corrupt or the format is not supported.
     *
     * @param filePath the path of video file
     * @param kind could be MINI_KIND or MICRO_KIND
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.758 -0500", hash_original_method = "3C5DBD92A3A305187D743DC871D6AE55", hash_generated_method = "0279A15AEFC098387B9E2647C88FBC69")
    
public static Bitmap createVideoThumbnail(String filePath, int kind) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            retriever.setDataSource(filePath);
            bitmap = retriever.getFrameAtTime(-1);
        } catch (IllegalArgumentException ex) {
            // Assume this is a corrupt video file
        } catch (RuntimeException ex) {
            // Assume this is a corrupt video file.
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {
                // Ignore failures while cleaning up.
            }
        }

        if (bitmap == null) return null;

        if (kind == Images.Thumbnails.MINI_KIND) {
            // Scale down the bitmap if it's too large.
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int max = Math.max(width, height);
            if (max > 512) {
                float scale = 512f / max;
                int w = Math.round(scale * width);
                int h = Math.round(scale * height);
                bitmap = Bitmap.createScaledBitmap(bitmap, w, h, true);
            }
        } else if (kind == Images.Thumbnails.MICRO_KIND) {
            bitmap = extractThumbnail(bitmap,
                    TARGET_SIZE_MICRO_THUMBNAIL,
                    TARGET_SIZE_MICRO_THUMBNAIL,
                    OPTIONS_RECYCLE_INPUT);
        }
        return bitmap;
    }

    /**
     * Creates a centered bitmap of the desired size.
     *
     * @param source original bitmap source
     * @param width targeted width
     * @param height targeted height
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.761 -0500", hash_original_method = "04F11977515FDB4F5E012AC13A40882D", hash_generated_method = "1BAB2227279275269EDB0E4C6BD99FA5")
    
public static Bitmap extractThumbnail(
            Bitmap source, int width, int height) {
        return extractThumbnail(source, width, height, OPTIONS_NONE);
    }

    /**
     * Creates a centered bitmap of the desired size.
     *
     * @param source original bitmap source
     * @param width targeted width
     * @param height targeted height
     * @param options options used during thumbnail extraction
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.763 -0500", hash_original_method = "F8E32D9ECB9A19E8EE9CCF27EE20F097", hash_generated_method = "BDAA0031048EE5BC279C6822D8F87545")
    
public static Bitmap extractThumbnail(
            Bitmap source, int width, int height, int options) {
        if (source == null) {
            return null;
        }

        float scale;
        if (source.getWidth() < source.getHeight()) {
            scale = width / (float) source.getWidth();
        } else {
            scale = height / (float) source.getHeight();
        }
        Matrix matrix = new Matrix();
        matrix.setScale(scale, scale);
        Bitmap thumbnail = transform(matrix, source, width, height,
                OPTIONS_SCALE_UP | options);
        return thumbnail;
    }

    /*
     * Compute the sample size as a function of minSideLength
     * and maxNumOfPixels.
     * minSideLength is used to specify that minimal width or height of a
     * bitmap.
     * maxNumOfPixels is used to specify the maximal size in pixels that is
     * tolerable in terms of memory usage.
     *
     * The function returns a sample size based on the constraints.
     * Both size and minSideLength can be passed in as IImage.UNCONSTRAINED,
     * which indicates no care of the corresponding constraint.
     * The functions prefers returning a sample size that
     * generates a smaller bitmap, unless minSideLength = IImage.UNCONSTRAINED.
     *
     * Also, the function rounds up the sample size to a power of 2 or multiple
     * of 8 because BitmapFactory only honors sample size this way.
     * For example, BitmapFactory downsamples an image by 2 even though the
     * request is 3. So we round up the sample size to avoid OOM.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.767 -0500", hash_original_method = "DEEF6A1C5EDDA6C20572575D59F5EB46", hash_generated_method = "7333F215F1457DAD418689DCC5F34ED8")
    
private static int computeSampleSize(BitmapFactory.Options options,
            int minSideLength, int maxNumOfPixels) {
        int initialSize = computeInitialSampleSize(options, minSideLength,
                maxNumOfPixels);

        int roundedSize;
        if (initialSize <= 8 ) {
            roundedSize = 1;
            while (roundedSize < initialSize) {
                roundedSize <<= 1;
            }
        } else {
            roundedSize = (initialSize + 7) / 8 * 8;
        }

        return roundedSize;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.770 -0500", hash_original_method = "01AADA97E0B42FE20256DE5884700C34", hash_generated_method = "EAE4E039AB6A26002019F8FBD5C974FB")
    
private static int computeInitialSampleSize(BitmapFactory.Options options,
            int minSideLength, int maxNumOfPixels) {
        double w = options.outWidth;
        double h = options.outHeight;

        int lowerBound = (maxNumOfPixels == UNCONSTRAINED) ? 1 :
                (int) Math.ceil(Math.sqrt(w * h / maxNumOfPixels));
        int upperBound = (minSideLength == UNCONSTRAINED) ? 128 :
                (int) Math.min(Math.floor(w / minSideLength),
                Math.floor(h / minSideLength));

        if (upperBound < lowerBound) {
            // return the larger one when there is no overlapping zone.
            return lowerBound;
        }

        if ((maxNumOfPixels == UNCONSTRAINED) &&
                (minSideLength == UNCONSTRAINED)) {
            return 1;
        } else if (minSideLength == UNCONSTRAINED) {
            return lowerBound;
        } else {
            return upperBound;
        }
    }

    /**
     * Make a bitmap from a given Uri, minimal side length, and maximum number of pixels.
     * The image data will be read from specified pfd if it's not null, otherwise
     * a new input stream will be created using specified ContentResolver.
     *
     * Clients are allowed to pass their own BitmapFactory.Options used for bitmap decoding. A
     * new BitmapFactory.Options will be created if options is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.773 -0500", hash_original_method = "03AA0E6A46D7F727B5D81615ADC51108", hash_generated_method = "8DC11397EA3F6F6EF3CD12372C47ADB5")
    
private static Bitmap makeBitmap(int minSideLength, int maxNumOfPixels,
            Uri uri, ContentResolver cr, ParcelFileDescriptor pfd,
            BitmapFactory.Options options) {
        Bitmap b = null;
        try {
            if (pfd == null) pfd = makeInputStream(uri, cr);
            if (pfd == null) return null;
            if (options == null) options = new BitmapFactory.Options();

            FileDescriptor fd = pfd.getFileDescriptor();
            options.inSampleSize = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fd, null, options);
            if (options.mCancel || options.outWidth == -1
                    || options.outHeight == -1) {
                return null;
            }
            options.inSampleSize = computeSampleSize(
                    options, minSideLength, maxNumOfPixels);
            options.inJustDecodeBounds = false;

            options.inDither = false;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            b = BitmapFactory.decodeFileDescriptor(fd, null, options);
        } catch (OutOfMemoryError ex) {
            Log.e(TAG, "Got oom exception ", ex);
            return null;
        } finally {
            closeSilently(pfd);
        }
        return b;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.775 -0500", hash_original_method = "FC6A0FA20365F95F496B2895DCD18765", hash_generated_method = "82AD175BB4105E5CA8A5D91AE5A316FB")
    
private static void closeSilently(ParcelFileDescriptor c) {
      if (c == null) return;
      try {
          c.close();
      } catch (Throwable t) {
          // do nothing
      }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.778 -0500", hash_original_method = "A019EC2B740FA4F119FA9C0508A1F44E", hash_generated_method = "FF8D83046215CF42BE9DE9ADBC6660C4")
    
private static ParcelFileDescriptor makeInputStream(
            Uri uri, ContentResolver cr) {
        try {
            return cr.openFileDescriptor(uri, "r");
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * Transform source Bitmap to targeted width and height.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.782 -0500", hash_original_method = "0F38C1B7EF4D27E0FE011F71A1226373", hash_generated_method = "EE9A0886C5343FE0EEB4CA45AB817FDB")
    
private static Bitmap transform(Matrix scaler,
            Bitmap source,
            int targetWidth,
            int targetHeight,
            int options) {
        boolean scaleUp = (options & OPTIONS_SCALE_UP) != 0;
        boolean recycle = (options & OPTIONS_RECYCLE_INPUT) != 0;

        int deltaX = source.getWidth() - targetWidth;
        int deltaY = source.getHeight() - targetHeight;
        if (!scaleUp && (deltaX < 0 || deltaY < 0)) {
            /*
            * In this case the bitmap is smaller, at least in one dimension,
            * than the target.  Transform it by placing as much of the image
            * as possible into the target and leaving the top/bottom or
            * left/right (or both) black.
            */
            Bitmap b2 = Bitmap.createBitmap(targetWidth, targetHeight,
            Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(b2);

            int deltaXHalf = Math.max(0, deltaX / 2);
            int deltaYHalf = Math.max(0, deltaY / 2);
            Rect src = new Rect(
            deltaXHalf,
            deltaYHalf,
            deltaXHalf + Math.min(targetWidth, source.getWidth()),
            deltaYHalf + Math.min(targetHeight, source.getHeight()));
            int dstX = (targetWidth  - src.width())  / 2;
            int dstY = (targetHeight - src.height()) / 2;
            Rect dst = new Rect(
                    dstX,
                    dstY,
                    targetWidth - dstX,
                    targetHeight - dstY);
            c.drawBitmap(source, src, dst, null);
            if (recycle) {
                source.recycle();
            }
            c.setBitmap(null);
            return b2;
        }
        float bitmapWidthF = source.getWidth();
        float bitmapHeightF = source.getHeight();

        float bitmapAspect = bitmapWidthF / bitmapHeightF;
        float viewAspect   = (float) targetWidth / targetHeight;

        if (bitmapAspect > viewAspect) {
            float scale = targetHeight / bitmapHeightF;
            if (scale < .9F || scale > 1F) {
                scaler.setScale(scale, scale);
            } else {
                scaler = null;
            }
        } else {
            float scale = targetWidth / bitmapWidthF;
            if (scale < .9F || scale > 1F) {
                scaler.setScale(scale, scale);
            } else {
                scaler = null;
            }
        }

        Bitmap b1;
        if (scaler != null) {
            // this is used for minithumb and crop, so we want to filter here.
            b1 = Bitmap.createBitmap(source, 0, 0,
            source.getWidth(), source.getHeight(), scaler, true);
        } else {
            b1 = source;
        }

        if (recycle && b1 != source) {
            source.recycle();
        }

        int dx1 = Math.max(0, b1.getWidth() - targetWidth);
        int dy1 = Math.max(0, b1.getHeight() - targetHeight);

        Bitmap b2 = Bitmap.createBitmap(
                b1,
                dx1 / 2,
                dy1 / 2,
                targetWidth,
                targetHeight);

        if (b2 != b1) {
            if (recycle || b1 != source) {
                b1.recycle();
            }
        }

        return b2;
    }

    /**
     * Creates a bitmap by either downsampling from the thumbnail in EXIF or the full image.
     * The functions returns a SizedThumbnailBitmap,
     * which contains a downsampled bitmap and the thumbnail data in EXIF if exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.799 -0500", hash_original_method = "11FD3E760075BCE4140D633304A572D7", hash_generated_method = "0F5A696F05C8305BB05A333E367CFFFF")
    
private static void createThumbnailFromEXIF(String filePath, int targetSize,
            int maxPixels, SizedThumbnailBitmap sizedThumbBitmap) {
        if (filePath == null) return;

        ExifInterface exif = null;
        byte [] thumbData = null;
        try {
            exif = new ExifInterface(filePath);
            if (exif != null) {
                thumbData = exif.getThumbnail();
            }
        } catch (IOException ex) {
            Log.w(TAG, ex);
        }

        BitmapFactory.Options fullOptions = new BitmapFactory.Options();
        BitmapFactory.Options exifOptions = new BitmapFactory.Options();
        int exifThumbWidth = 0;
        int fullThumbWidth = 0;

        // Compute exifThumbWidth.
        if (thumbData != null) {
            exifOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(thumbData, 0, thumbData.length, exifOptions);
            exifOptions.inSampleSize = computeSampleSize(exifOptions, targetSize, maxPixels);
            exifThumbWidth = exifOptions.outWidth / exifOptions.inSampleSize;
        }

        // Compute fullThumbWidth.
        fullOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, fullOptions);
        fullOptions.inSampleSize = computeSampleSize(fullOptions, targetSize, maxPixels);
        fullThumbWidth = fullOptions.outWidth / fullOptions.inSampleSize;

        // Choose the larger thumbnail as the returning sizedThumbBitmap.
        if (thumbData != null && exifThumbWidth >= fullThumbWidth) {
            int width = exifOptions.outWidth;
            int height = exifOptions.outHeight;
            exifOptions.inJustDecodeBounds = false;
            sizedThumbBitmap.mBitmap = BitmapFactory.decodeByteArray(thumbData, 0,
                    thumbData.length, exifOptions);
            if (sizedThumbBitmap.mBitmap != null) {
                sizedThumbBitmap.mThumbnailData = thumbData;
                sizedThumbBitmap.mThumbnailWidth = width;
                sizedThumbBitmap.mThumbnailHeight = height;
            }
        } else {
            fullOptions.inJustDecodeBounds = false;
            sizedThumbBitmap.mBitmap = BitmapFactory.decodeFile(filePath, fullOptions);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.730 -0500", hash_original_field = "9F89762DCCDF0C177AB5C7A4C4A847A1", hash_generated_field = "CC8569C5C144996C2C1B9BCC3DFD2CE0")

    private static final String TAG = "ThumbnailUtils";

    
    private static class SizedThumbnailBitmap {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.786 -0500", hash_original_field = "3F520D35D42F7D83BD963CE4801140CC", hash_generated_field = "06D73110F79B9622C1F4FE2AF624C5A7")

        public byte[] mThumbnailData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.788 -0500", hash_original_field = "46C0A7FFF0FFB93D952536F8E8BA5C29", hash_generated_field = "02D2A96543D882460FFE49C81D348540")

        public Bitmap mBitmap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.790 -0500", hash_original_field = "0FB7F1854426C7C20C8F54251DD6BEFE", hash_generated_field = "8575EFE206E28950AED9B1BF9FBF19F8")

        public int mThumbnailWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.793 -0500", hash_original_field = "E573642589D0DD78940B992E22C021AE", hash_generated_field = "4F468E46E529F4DA7191944F9D5425C8")

        public int mThumbnailHeight;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.264 -0400", hash_original_method = "00296400B022DD946E1008D4AF6645F7", hash_generated_method = "00296400B022DD946E1008D4AF6645F7")
        public SizedThumbnailBitmap ()
        {
            //Synthesized constructor
        }


    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.732 -0500", hash_original_field = "B1B7B3AC5A1A6668790640899EDF81EB", hash_generated_field = "C3D7D5D0952213F1807F9BD3033D397E")

    private static final int MAX_NUM_PIXELS_THUMBNAIL = 512 * 384;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.736 -0500", hash_original_field = "F1C3F39A12D0591068973AAF2728C422", hash_generated_field = "8D0D85131F24C37479F7BB0CEAB0AA09")

    private static final int MAX_NUM_PIXELS_MICRO_THUMBNAIL = 128 * 128;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.738 -0500", hash_original_field = "9F1702CE263DF047CE828843E3575400", hash_generated_field = "2E7FC5F2B51AC632D5BA82D9BABD08C3")

    private static final int UNCONSTRAINED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.741 -0500", hash_original_field = "AD62A5AA71562A959A0A65D9D3888950", hash_generated_field = "D39ACE695185D8A29676FC1684ACB673")

    private static final int OPTIONS_NONE = 0x0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.743 -0500", hash_original_field = "9DE19AECD17B684A7AD0E9E540B53136", hash_generated_field = "BD2B9DB83546A985E6E0920D9F0029F2")

    private static final int OPTIONS_SCALE_UP = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.746 -0500", hash_original_field = "08D00C21AF4FE99CF6B783902EA899BD", hash_generated_field = "8F87E3121A64D60592B5131A7EC030B4")

    public static final int OPTIONS_RECYCLE_INPUT = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.748 -0500", hash_original_field = "3BF51E36A4C9EF6900D271E3B961C807", hash_generated_field = "9F7F30C69C85E52290E33BE9CC22AE05")

    public static final int TARGET_SIZE_MINI_THUMBNAIL = 320;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:32.751 -0500", hash_original_field = "90E679535D0AA77047A63D38E72A5BBD", hash_generated_field = "0D8371A6E6E061CDEF380A55CF66637C")

    public static final int TARGET_SIZE_MICRO_THUMBNAIL = 96;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.260 -0400", hash_original_method = "569A57C095D8F73163C7FEBA6E020B38", hash_generated_method = "569A57C095D8F73163C7FEBA6E020B38")
    public ThumbnailUtils ()
    {
        //Synthesized constructor
    }
}

