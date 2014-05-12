package android.provider;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.MiniThumbFile;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Log;

public final class MediaStore {

    /**
     * Uri for querying the state of the media scanner.
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.901 -0500", hash_original_method = "2AB61FF2E7140B128AA8E0CB2E9AAED9", hash_generated_method = "4ED1F31638B10772A3D991934AC9340B")
    
public static Uri getMediaScannerUri() {
        return Uri.parse(CONTENT_AUTHORITY_SLASH + "none/media_scanner");
    }

    /**
     * Get the media provider's version.
     * Applications that import data from the media provider into their own caches
     * can use this to detect that the media provider changed, and reimport data
     * as needed. No other assumptions should be made about the meaning of the version.
     * @param context Context to use for performing the query.
     * @return A version string, or null if the version could not be determined.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.908 -0500", hash_original_method = "AE38216E99DAE811D25BA0107413939D", hash_generated_method = "A5E3282E23260DB91E9A5D82657E9B69")
    
public static String getVersion(Context context) {
        Cursor c = context.getContentResolver().query(
                Uri.parse(CONTENT_AUTHORITY_SLASH + "none/version"),
                null, null, null, null);
        if (c != null) {
            try {
                if (c.moveToFirst()) {
                    return c.getString(0);
                }
            } finally {
                c.close();
            }
        }
        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.367 -0500", hash_original_field = "504782FD0E09BF98DA916EB9A1FAC803", hash_generated_field = "2728F4DF8F6CC34C57214DE271030F14")

    private final static String TAG = "MediaStore";
    
    public static final class Files {

        /**
         * Get the content:// style URI for the files table on the
         * given volume.
         *
         * @param volumeName the name of the volume to get the URI for
         * @return the URI to the files table on the given volume
         */
        @DSSource({DSSourceKind.FILE_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.433 -0500", hash_original_method = "409759DEA77E6C649AE2EA692A3554B8", hash_generated_method = "A280A2BA0F4395634F272135FE1EBA34")
        
public static Uri getContentUri(String volumeName) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                    "/file");
        }

        /**
         * Get the content:// style URI for a single row in the files table on the
         * given volume.
         *
         * @param volumeName the name of the volume to get the URI for
         * @param rowId the file to get the URI for
         * @return the URI to the files table on the given volume
         */
        @DSSource({DSSourceKind.FILE_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.436 -0500", hash_original_method = "093C2982E064F68E36812413D73335AF", hash_generated_method = "F02C710E69F22870280DA8940CF6B34E")
        
public static final Uri getContentUri(String volumeName,
                long rowId) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                    + "/file/" + rowId);
        }

        /**
         * For use only by the MTP implementation.
         * @hide
         */
        @DSSource({DSSourceKind.FILE_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.438 -0500", hash_original_method = "2FA8FCD7E4B4B360F21FD1B576A95B66", hash_generated_method = "0F65AACC551D6280680A5F4F5034162B")
        
public static Uri getMtpObjectsUri(String volumeName) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                    "/object");
        }

        /**
         * For use only by the MTP implementation.
         * @hide
         */
        @DSSource({DSSourceKind.FILE_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.441 -0500", hash_original_method = "4D06DA2298DFF5AAAB3A88C1D51AE35B", hash_generated_method = "79359F0971EFBA5ABE8627030F660389")
        
public static final Uri getMtpObjectsUri(String volumeName,
                long fileId) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                    + "/object/" + fileId);
        }

        /**
         * Used to implement the MTP GetObjectReferences and SetObjectReferences commands.
         * @hide
         */
        @DSSource({DSSourceKind.FILE_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.443 -0500", hash_original_method = "156D6BD07D5B040A2C58E7948D6F92A6", hash_generated_method = "53A9AF6975906E0F395058EF2299221C")
        
public static final Uri getMtpReferencesUri(String volumeName,
                long fileId) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                    + "/object/" + fileId + "/references");
        }
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.452 -0400", hash_original_method = "92603C48FC2D95D83FC45AFBA8CE46C5", hash_generated_method = "92603C48FC2D95D83FC45AFBA8CE46C5")
        public Files ()
        {
            //Synthesized constructor
        }
        
        public interface FileColumns extends MediaColumns {
            
            public static final String STORAGE_ID = "storage_id";
            
            public static final String FORMAT = "format";
            
            public static final String PARENT = "parent";
            
            public static final String MIME_TYPE = "mime_type";
            
            public static final String TITLE = "title";
            
            public static final String MEDIA_TYPE = "media_type";
            
            public static final int MEDIA_TYPE_NONE = 0;
            
            public static final int MEDIA_TYPE_IMAGE = 1;
            
            public static final int MEDIA_TYPE_AUDIO = 2;
            
            public static final int MEDIA_TYPE_VIDEO = 3;
            
            public static final int MEDIA_TYPE_PLAYLIST = 4;
        }
        
    }
    
    private static class InternalThumbnails implements BaseColumns {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.475 -0500", hash_original_method = "55184BD5503D496525DD695550EB0913", hash_generated_method = "4A503CB3F3D7E6D2923157E41CC0CD05")
        
private static Bitmap getMiniThumbFromFile(Cursor c, Uri baseUri, ContentResolver cr, BitmapFactory.Options options) {
            Bitmap bitmap = null;
            Uri thumbUri = null;
            try {
                long thumbId = c.getLong(0);
                String filePath = c.getString(1);
                thumbUri = ContentUris.withAppendedId(baseUri, thumbId);
                ParcelFileDescriptor pfdInput = cr.openFileDescriptor(thumbUri, "r");
                bitmap = BitmapFactory.decodeFileDescriptor(
                        pfdInput.getFileDescriptor(), null, options);
                pfdInput.close();
            } catch (FileNotFoundException ex) {
                Log.e(TAG, "couldn't open thumbnail " + thumbUri + "; " + ex);
            } catch (IOException ex) {
                Log.e(TAG, "couldn't open thumbnail " + thumbUri + "; " + ex);
            } catch (OutOfMemoryError ex) {
                Log.e(TAG, "failed to allocate memory for thumbnail "
                        + thumbUri + "; " + ex);
            }
            return bitmap;
        }

        /**
         * This method cancels the thumbnail request so clients waiting for getThumbnail will be
         * interrupted and return immediately. Only the original process which made the getThumbnail
         * requests can cancel their own requests.
         *
         * @param cr ContentResolver
         * @param origId original image or video id. use -1 to cancel all requests.
         * @param groupId the same groupId used in getThumbnail
         * @param baseUri the base URI of requested thumbnails
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.477 -0500", hash_original_method = "F29A79C31A2CA4FED1ACCEFFCCC8C171", hash_generated_method = "ED094E0A84AEB6D086FD82573B890E67")
        
static void cancelThumbnailRequest(ContentResolver cr, long origId, Uri baseUri,
                long groupId) {
            Uri cancelUri = baseUri.buildUpon().appendQueryParameter("cancel", "1")
                    .appendQueryParameter("orig_id", String.valueOf(origId))
                    .appendQueryParameter("group_id", String.valueOf(groupId)).build();
            Cursor c = null;
            try {
                c = cr.query(cancelUri, PROJECTION, null, null, null);
            }
            finally {
                if (c != null) c.close();
            }
        }
        /**
         * This method ensure thumbnails associated with origId are generated and decode the byte
         * stream from database (MICRO_KIND) or file (MINI_KIND).
         *
         * Special optimization has been done to avoid further IPC communication for MICRO_KIND
         * thumbnails.
         *
         * @param cr ContentResolver
         * @param origId original image or video id
         * @param kind could be MINI_KIND or MICRO_KIND
         * @param options this is only used for MINI_KIND when decoding the Bitmap
         * @param baseUri the base URI of requested thumbnails
         * @param groupId the id of group to which this request belongs
         * @return Bitmap bitmap of specified thumbnail kind
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.482 -0500", hash_original_method = "BF0AC792D5E1630C97F13B7A4FE7C203", hash_generated_method = "DD44E1F24FCA640B73CF7DDB7DDEF9A9")
            
static Bitmap getThumbnail(ContentResolver cr, long origId, long groupId, int kind,
                BitmapFactory.Options options, Uri baseUri, boolean isVideo) {
            Bitmap bitmap = null;
            String filePath = null;
            // Log.v(TAG, "getThumbnail: origId="+origId+", kind="+kind+", isVideo="+isVideo);
            // If the magic is non-zero, we simply return thumbnail if it does exist.
            // querying MediaProvider and simply return thumbnail.
            MiniThumbFile thumbFile = new MiniThumbFile(isVideo ? Video.Media.EXTERNAL_CONTENT_URI
                    : Images.Media.EXTERNAL_CONTENT_URI);
            Cursor c = null;
            try {
                long magic = thumbFile.getMagic(origId);
                if (magic != 0) {
                    if (kind == MICRO_KIND) {
                        synchronized (sThumbBufLock) {
                            if (sThumbBuf == null) {
                                sThumbBuf = new byte[MiniThumbFile.BYTES_PER_MINTHUMB];
                            }
                            if (thumbFile.getMiniThumbFromFile(origId, sThumbBuf) != null) {
                                bitmap = BitmapFactory.decodeByteArray(sThumbBuf, 0, sThumbBuf.length);
                                if (bitmap == null) {
                                    Log.w(TAG, "couldn't decode byte array.");
                                }
                            }
                        }
                        return bitmap;
                    } else if (kind == MINI_KIND) {
                        String column = isVideo ? "video_id=" : "image_id=";
                        c = cr.query(baseUri, PROJECTION, column + origId, null, null);
                        if (c != null && c.moveToFirst()) {
                            bitmap = getMiniThumbFromFile(c, baseUri, cr, options);
                            if (bitmap != null) {
                                return bitmap;
                            }
                        }
                    }
                }

                Uri blockingUri = baseUri.buildUpon().appendQueryParameter("blocking", "1")
                        .appendQueryParameter("orig_id", String.valueOf(origId))
                        .appendQueryParameter("group_id", String.valueOf(groupId)).build();
                if (c != null) c.close();
                c = cr.query(blockingUri, PROJECTION, null, null, null);
                // This happens when original image/video doesn't exist.
                if (c == null) return null;

                // Assuming thumbnail has been generated, at least original image exists.
                if (kind == MICRO_KIND) {
                    synchronized (sThumbBufLock) {
                        if (sThumbBuf == null) {
                            sThumbBuf = new byte[MiniThumbFile.BYTES_PER_MINTHUMB];
                        }
                        if (thumbFile.getMiniThumbFromFile(origId, sThumbBuf) != null) {
                            bitmap = BitmapFactory.decodeByteArray(sThumbBuf, 0, sThumbBuf.length);
                            if (bitmap == null) {
                                Log.w(TAG, "couldn't decode byte array.");
                            }
                        }
                    }
                } else if (kind == MINI_KIND) {
                    if (c.moveToFirst()) {
                        bitmap = getMiniThumbFromFile(c, baseUri, cr, options);
                    }
                } else {
                    throw new IllegalArgumentException("Unsupported kind: " + kind);
                }

                // We probably run out of space, so create the thumbnail in memory.
                if (bitmap == null) {
                    Log.v(TAG, "Create the thumbnail in memory: origId=" + origId
                            + ", kind=" + kind + ", isVideo="+isVideo);
                    Uri uri = Uri.parse(
                            baseUri.buildUpon().appendPath(String.valueOf(origId))
                                    .toString().replaceFirst("thumbnails", "media"));
                    if (filePath == null) {
                        if (c != null) c.close();
                        c = cr.query(uri, PROJECTION, null, null, null);
                        if (c == null || !c.moveToFirst()) {
                            return null;
                        }
                        filePath = c.getString(1);
                    }
                    if (isVideo) {
                        bitmap = ThumbnailUtils.createVideoThumbnail(filePath, kind);
                    } else {
                        bitmap = ThumbnailUtils.createImageThumbnail(filePath, kind);
                    }
                }
            } catch (SQLiteException ex) {
                Log.w(TAG, ex);
            } finally {
                if (c != null) c.close();
                // To avoid file descriptor leak in application process.
                thumbFile.deactivate();
                thumbFile = null;
            }
            return bitmap;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.456 -0500", hash_original_field = "9F5E3E6762DD29258CAFD54043B629BD", hash_generated_field = "F1B2DCDB4D650E7562CCD24C7413239D")

        private static final int MINI_KIND = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.459 -0500", hash_original_field = "884ECD205446BA7FAADFFE34D03FE08B", hash_generated_field = "528D339F12DE56917828F7FCAF7982C0")

        private static final int FULL_SCREEN_KIND = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.461 -0500", hash_original_field = "E74DC664648224BDEE25E164A4C02ADD", hash_generated_field = "90F2A2712808066B51263DD7FB1B1780")

        private static final int MICRO_KIND = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.464 -0500", hash_original_field = "86529439729A0F3B72E641F65E4C97BF", hash_generated_field = "29B2B6BAF49B801FB32E186C3BC159CD")

        private static final String[] PROJECTION = new String[] {_ID, MediaColumns.DATA};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.466 -0500", hash_original_field = "A693A71BF3C116046E9EE35F94C4CDEF", hash_generated_field = "BF5200770C239590998D8302DE616555")

        static final int DEFAULT_GROUP_ID = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.469 -0500", hash_original_field = "9A2E729A19D6C18D99DAE1FD0CC65473", hash_generated_field = "EFA5E9100500815C37703B7F5AF9081E")

        private static final Object sThumbBufLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.472 -0500", hash_original_field = "DCD592AB9367D7D2F8240C488393C3B5", hash_generated_field = "4E95DEC378A5C2690E58198734A359AE")

        private static byte[] sThumbBuf;
        
        @DSComment("Private Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.453 -0400", hash_original_method = "B538DEE370A2D5B0ED2152EA1CB2C251", hash_generated_method = "B538DEE370A2D5B0ED2152EA1CB2C251")
        public InternalThumbnails ()
        {
            //Synthesized constructor
        }
    }
    
    public static final class Images {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.454 -0400", hash_original_method = "A3CD75F6AB055CA56651293CB087C6D5", hash_generated_method = "A3CD75F6AB055CA56651293CB087C6D5")
        public Images ()
        {
            //Synthesized constructor
        }

        public static final class Media implements ImageColumns {
            @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.497 -0500", hash_original_method = "D33973CFD3614E757CA6971FCFC77D62", hash_generated_method = "522FA5EC19DCD037B3DD1291CCDDFA1F")
            
public static final Cursor query(ContentResolver cr, Uri uri, String[] projection) {
                return cr.query(uri, projection, null, null, DEFAULT_SORT_ORDER);
            }

            @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.501 -0500", hash_original_method = "53C3E712D0BE7622019DC7632C44AEC5", hash_generated_method = "9710B946F5D5EAAE3323EA0EEB6309D5")
            
public static final Cursor query(ContentResolver cr, Uri uri, String[] projection,
                    String where, String orderBy) {
                return cr.query(uri, projection, where,
                                             null, orderBy == null ? DEFAULT_SORT_ORDER : orderBy);
            }

            @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.504 -0500", hash_original_method = "021F54ACE26AA0D28BD6812D454BB821", hash_generated_method = "C0CA4DFB37E599E4AFBBDA5E7B4ACF4F")
            
public static final Cursor query(ContentResolver cr, Uri uri, String[] projection,
                    String selection, String [] selectionArgs, String orderBy) {
                return cr.query(uri, projection, selection,
                        selectionArgs, orderBy == null ? DEFAULT_SORT_ORDER : orderBy);
            }

            /**
             * Retrieves an image for the given url as a {@link Bitmap}.
             *
             * @param cr The content resolver to use
             * @param url The url of the image
             * @throws FileNotFoundException
             * @throws IOException
             */
            @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.507 -0500", hash_original_method = "5ACE4CC33982008EF7E75DDF8CDA73C1", hash_generated_method = "DEAC5D332371380082BED66FBEC35502")
            
public static final Bitmap getBitmap(ContentResolver cr, Uri url)
                    throws FileNotFoundException, IOException {
                InputStream input = cr.openInputStream(url);
                Bitmap bitmap = BitmapFactory.decodeStream(input);
                input.close();
                return bitmap;
            }

            /**
             * Insert an image and create a thumbnail for it.
             *
             * @param cr The content resolver to use
             * @param imagePath The path to the image to insert
             * @param name The name of the image
             * @param description The description of the image
             * @return The URL to the newly created image
             * @throws FileNotFoundException
             */
            @DSComment("Insert an image and create a thumbnail")
            @DSSpec(DSCat.IO)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.510 -0500", hash_original_method = "7EDFE27F4065D73B827ECCB92823E704", hash_generated_method = "F4811B325135D139327C3CD84EF94612")
            
public static final String insertImage(ContentResolver cr, String imagePath,
                    String name, String description) throws FileNotFoundException {
                // Check if file exists with a FileInputStream
                FileInputStream stream = new FileInputStream(imagePath);
                try {
                    Bitmap bm = BitmapFactory.decodeFile(imagePath);
                    String ret = insertImage(cr, bm, name, description);
                    bm.recycle();
                    return ret;
                } finally {
                    try {
                        stream.close();
                    } catch (IOException e) {
                    }
                }
            }

            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.513 -0500", hash_original_method = "DAAD784C0B233997846E8495A2862A0E", hash_generated_method = "E66F09C3C1BA3D7840ECBDFEBEF632EB")
            
private static final Bitmap StoreThumbnail(
                    ContentResolver cr,
                    Bitmap source,
                    long id,
                    float width, float height,
                    int kind) {
                // create the matrix to scale it
                Matrix matrix = new Matrix();

                float scaleX = width / source.getWidth();
                float scaleY = height / source.getHeight();

                matrix.setScale(scaleX, scaleY);

                Bitmap thumb = Bitmap.createBitmap(source, 0, 0,
                                                   source.getWidth(),
                                                   source.getHeight(), matrix,
                                                   true);

                ContentValues values = new ContentValues(4);
                values.put(Images.Thumbnails.KIND,     kind);
                values.put(Images.Thumbnails.IMAGE_ID, (int)id);
                values.put(Images.Thumbnails.HEIGHT,   thumb.getHeight());
                values.put(Images.Thumbnails.WIDTH,    thumb.getWidth());

                Uri url = cr.insert(Images.Thumbnails.EXTERNAL_CONTENT_URI, values);

                try {
                    OutputStream thumbOut = cr.openOutputStream(url);

                    thumb.compress(Bitmap.CompressFormat.JPEG, 100, thumbOut);
                    thumbOut.close();
                    return thumb;
                }
                catch (FileNotFoundException ex) {
                    return null;
                }
                catch (IOException ex) {
                    return null;
                }
            }

            /**
             * Insert an image and create a thumbnail for it.
             *
             * @param cr The content resolver to use
             * @param source The stream to use for the image
             * @param title The name of the image
             * @param description The description of the image
             * @return The URL to the newly created image, or <code>null</code> if the image failed to be stored
             *              for any reason.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.517 -0500", hash_original_method = "69A0DD4660ADD7C5594E4FDC51D65483", hash_generated_method = "A734C04153E78B8243BB6411677AF49A")
            
public static final String insertImage(ContentResolver cr, Bitmap source,
                                                   String title, String description) {
                ContentValues values = new ContentValues();
                values.put(Images.Media.TITLE, title);
                values.put(Images.Media.DESCRIPTION, description);
                values.put(Images.Media.MIME_TYPE, "image/jpeg");

                Uri url = null;
                String stringUrl = null;    /* value to be returned */

                try {
                    url = cr.insert(EXTERNAL_CONTENT_URI, values);

                    if (source != null) {
                        OutputStream imageOut = cr.openOutputStream(url);
                        try {
                            source.compress(Bitmap.CompressFormat.JPEG, 50, imageOut);
                        } finally {
                            imageOut.close();
                        }

                        long id = ContentUris.parseId(url);
                        // Wait until MINI_KIND thumbnail is generated.
                        Bitmap miniThumb = Images.Thumbnails.getThumbnail(cr, id,
                                Images.Thumbnails.MINI_KIND, null);
                        // This is for backward compatibility.
                        Bitmap microThumb = StoreThumbnail(cr, miniThumb, id, 50F, 50F,
                                Images.Thumbnails.MICRO_KIND);
                    } else {
                        Log.e(TAG, "Failed to create thumbnail, removing original");
                        cr.delete(url, null, null);
                        url = null;
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Failed to insert image", e);
                    if (url != null) {
                        cr.delete(url, null, null);
                        url = null;
                    }
                }

                if (url != null) {
                    stringUrl = url.toString();
                }

                return stringUrl;
            }

            /**
             * Get the content:// style URI for the image media table on the
             * given volume.
             *
             * @param volumeName the name of the volume to get the URI for
             * @return the URI to the image media table on the given volume
             */
            @DSSource({DSSourceKind.FILE_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.520 -0500", hash_original_method = "D25E6866BAFE283BBBEC1A86738374B0", hash_generated_method = "E0194B654B4D913F989AC78CE4F389A6")
            
public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/images/media");
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.818 -0500", hash_original_field = "B269D74210F6643EC8FFDC9943F2FBBA", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.821 -0500", hash_original_field = "03E6D4DE406DF4FB8653B600C7452025", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.528 -0500", hash_original_field = "66EB1425844869CC93ED41492A36AC8A", hash_generated_field = "D7278D58DCCF3AFCDABD397E23995D1D")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/image";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.531 -0500", hash_original_field = "653EB65FF0BA3C50B158A90CD33BF9D4", hash_generated_field = "D1EC0DF370F9CCDEE096DFD36593C492")

            public static final String DEFAULT_SORT_ORDER = ImageColumns.BUCKET_DISPLAY_NAME;
            
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.454 -0400", hash_original_method = "AABF7D5402BFD519F4DA876621C956DE", hash_generated_method = "AABF7D5402BFD519F4DA876621C956DE")
            public Media ()
            {
                //Synthesized constructor
            }
        }
        
        public static class Thumbnails implements BaseColumns {
            @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.538 -0500", hash_original_method = "D33973CFD3614E757CA6971FCFC77D62", hash_generated_method = "522FA5EC19DCD037B3DD1291CCDDFA1F")
            
public static final Cursor query(ContentResolver cr, Uri uri, String[] projection) {
                return cr.query(uri, projection, null, null, DEFAULT_SORT_ORDER);
            }

            @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.541 -0500", hash_original_method = "D2C6FBB7BEB4CEA6BEF0854A82D35C79", hash_generated_method = "3EC21CDA307390D0BBE9F235AE4A64E3")
            
public static final Cursor queryMiniThumbnails(ContentResolver cr, Uri uri, int kind,
                    String[] projection) {
                return cr.query(uri, projection, "kind = " + kind, null, DEFAULT_SORT_ORDER);
            }

            @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.544 -0500", hash_original_method = "BE9254821AC284A8AB44D13688ACA7DE", hash_generated_method = "E5ADCA2D02DCA0BD2BD1E6467DD1DEF8")
            
public static final Cursor queryMiniThumbnail(ContentResolver cr, long origId, int kind,
                    String[] projection) {
                return cr.query(EXTERNAL_CONTENT_URI, projection,
                        IMAGE_ID + " = " + origId + " AND " + KIND + " = " +
                        kind, null, null);
            }
            /**
             * This method cancels the thumbnail request so clients waiting for getThumbnail will be
             * interrupted and return immediately. Only the original process which made the getThumbnail
             * requests can cancel their own requests.
             *
             * @param cr ContentResolver
             * @param origId original video id
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.832 -0500", hash_original_method = "1F04B09633BC6FD3251DA0AD2BE516F3", hash_generated_method = "983E9B9D79C85DB2DD69AA68A9F3DB51")
            
public static void cancelThumbnailRequest(ContentResolver cr, long origId) {
                InternalThumbnails.cancelThumbnailRequest(cr, origId, EXTERNAL_CONTENT_URI,
                        InternalThumbnails.DEFAULT_GROUP_ID);
            }

            /**
             * This method checks if the thumbnails of the specified image (origId) has been created.
             * It will be blocked until the thumbnails are generated.
             *
             * @param cr ContentResolver used to dispatch queries to MediaProvider.
             * @param origId Original image id associated with thumbnail of interest.
             * @param kind The type of thumbnail to fetch. Should be either MINI_KIND or MICRO_KIND.
             * @param options this is only used for MINI_KIND when decoding the Bitmap
             * @return A Bitmap instance. It could be null if the original image
             *         associated with origId doesn't exist or memory is not enough.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.549 -0500", hash_original_method = "069003E9CCA7A32718F8DD9AFC8DF3AC", hash_generated_method = "A2CA56D487630ADB7C82FA26BA7E1D58")
            @DSSafe(DSCat.SAFE_OTHERS)  
            @DSSource({DSSourceKind.IMAGE})
public static Bitmap getThumbnail(ContentResolver cr, long origId, int kind,
                    BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(cr, origId,
                        InternalThumbnails.DEFAULT_GROUP_ID, kind, options,
                        EXTERNAL_CONTENT_URI, false);
            }

            /**
             * This method cancels the thumbnail request so clients waiting for getThumbnail will be
             * interrupted and return immediately. Only the original process which made the getThumbnail
             * requests can cancel their own requests.
             *
             * @param cr ContentResolver
             * @param origId original video id
             * @param groupId the same groupId used in getThumbnail.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.840 -0500", hash_original_method = "9AAEF167BAB79AB4F88321224520B47D", hash_generated_method = "D1446C5613D089036ABDE6782BA7A84D")
            
public static void cancelThumbnailRequest(ContentResolver cr, long origId, long groupId) {
                InternalThumbnails.cancelThumbnailRequest(cr, origId, EXTERNAL_CONTENT_URI, groupId);
            }

            /**
             * This method checks if the thumbnails of the specified image (origId) has been created.
             * It will be blocked until the thumbnails are generated.
             *
             * @param cr ContentResolver used to dispatch queries to MediaProvider.
             * @param origId Original image id associated with thumbnail of interest.
             * @param groupId the id of group to which this request belongs
             * @param kind The type of thumbnail to fetch. Should be either MINI_KIND or MICRO_KIND.
             * @param options this is only used for MINI_KIND when decoding the Bitmap
             * @return A Bitmap instance. It could be null if the original image
             *         associated with origId doesn't exist or memory is not enough.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.555 -0500", hash_original_method = "5AD0BFBA0AD49773CFC5CC711D3149F0", hash_generated_method = "0DB0B69D293B44BF86D28E74E32FBB26")
            
               @DSSafe(DSCat.SAFE_OTHERS)
               @DSSource({DSSourceKind.IMAGE})
public static Bitmap getThumbnail(ContentResolver cr, long origId, long groupId,
                    int kind, BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(cr, origId, groupId, kind, options,
                        EXTERNAL_CONTENT_URI, false);
            }

            /**
             * Get the content:// style URI for the image media table on the
             * given volume.
             *
             * @param volumeName the name of the volume to get the URI for
             * @return the URI to the image media table on the given volume
             */
            @DSSource({DSSourceKind.FILE_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.557 -0500", hash_original_method = "30E2B09E332E4F02ED1ADF0B393967EF", hash_generated_method = "7C81AAFED814529EAF49F67E334DB91E")
            
public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/images/thumbnails");
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.845 -0500", hash_original_field = "B269D74210F6643EC8FFDC9943F2FBBA", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.848 -0500", hash_original_field = "03E6D4DE406DF4FB8653B600C7452025", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.565 -0500", hash_original_field = "59315B23C674A066EB8A6BCDD73D4C2E", hash_generated_field = "201F7D4B8AAD2124C6E2FB0F7E0E0501")

            public static final String DEFAULT_SORT_ORDER = "image_id ASC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.853 -0500", hash_original_field = "26E58B2737B6B9BE3C45DCC90071CE18", hash_generated_field = "A66DA404DB529637DF4981C792367756")

            public static final String DATA = "_data";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.570 -0500", hash_original_field = "CCFE7AD193B1077478601BFAD7F2B5AD", hash_generated_field = "4C4192B03F8FCBB7BDBCB8BE2736E4B7")

            public static final String IMAGE_ID = "image_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.859 -0500", hash_original_field = "689313FD747CBABD81EDBCAEF84DD0DE", hash_generated_field = "C4772988085372FF3551CC4315A50E0B")

            public static final String KIND = "kind";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.861 -0500", hash_original_field = "9F5E3E6762DD29258CAFD54043B629BD", hash_generated_field = "99CE8D50C31FD4187F2F339D8B9B48C7")

            public static final int MINI_KIND = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.864 -0500", hash_original_field = "884ECD205446BA7FAADFFE34D03FE08B", hash_generated_field = "8C0560965409D5FE4F991B1D52B6B6A8")

            public static final int FULL_SCREEN_KIND = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.867 -0500", hash_original_field = "E74DC664648224BDEE25E164A4C02ADD", hash_generated_field = "623F298E957ADDE8E0DCD7F12E785698")

            public static final int MICRO_KIND = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.585 -0500", hash_original_field = "45C5658A932D745086DAD64AB749CB53", hash_generated_field = "2779A363AF0116D23A35D20CEC14443A")

            public static final String THUMB_DATA = "thumb_data";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.870 -0500", hash_original_field = "35FFDC6AA2ACA6BB8E3DDCA7833AD47B", hash_generated_field = "FE9CB65DA5AC820EB66328B1E325F141")

            public static final String WIDTH = "width";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.873 -0500", hash_original_field = "98F89B8C3667067141A5ECF88D1ECD7E", hash_generated_field = "A6B1CAF6BB48877DB47F660C1A4B4504")

            public static final String HEIGHT = "height";
            
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.456 -0400", hash_original_method = "CEC4957051438E94FE667AB7B98C828F", hash_generated_method = "CEC4957051438E94FE667AB7B98C828F")
            public Thumbnails ()
            {
                //Synthesized constructor
            }
        }
        
        public interface ImageColumns extends MediaColumns {
            
            public static final String DESCRIPTION = "description";
            
            public static final String PICASA_ID = "picasa_id";
            
            public static final String IS_PRIVATE = "isprivate";
            
            public static final String LATITUDE = "latitude";
            
            public static final String LONGITUDE = "longitude";
            
            public static final String DATE_TAKEN = "datetaken";
            
            public static final String ORIENTATION = "orientation";
            
            public static final String MINI_THUMB_MAGIC = "mini_thumb_magic";
            
            public static final String BUCKET_ID = "bucket_id";
            
            public static final String BUCKET_DISPLAY_NAME = "bucket_display_name";
        }
        
    }
    
    public static final class Audio {

        /**
         * Converts a name to a "key" that can be used for grouping, sorting
         * and searching.
         * The rules that govern this conversion are:
         * - remove 'special' characters like ()[]'!?.,
         * - remove leading/trailing spaces
         * - convert everything to lowercase
         * - remove leading "the ", "an " and "a "
         * - remove trailing ", the|an|a"
         * - remove accents. This step leaves us with CollationKey data,
         *   which is not human readable
         *
         * @param name The artist or album name to convert
         * @return The "key" for the given name.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.616 -0500", hash_original_method = "95C694273499781A6977EEA3A6EB256B", hash_generated_method = "DD118F7DB3B777EDEDF07C7206EE0C52")
        
public static String keyFor(String name) {
            if (name != null)  {
                boolean sortfirst = false;
                if (name.equals(UNKNOWN_STRING)) {
                    return "\001";
                }
                // Check if the first character is \001. We use this to
                // force sorting of certain special files, like the silent ringtone.
                if (name.startsWith("\001")) {
                    sortfirst = true;
                }
                name = name.trim().toLowerCase();
                if (name.startsWith("the ")) {
                    name = name.substring(4);
                }
                if (name.startsWith("an ")) {
                    name = name.substring(3);
                }
                if (name.startsWith("a ")) {
                    name = name.substring(2);
                }
                if (name.endsWith(", the") || name.endsWith(",the") ||
                    name.endsWith(", an") || name.endsWith(",an") ||
                    name.endsWith(", a") || name.endsWith(",a")) {
                    name = name.substring(0, name.lastIndexOf(','));
                }
                name = name.replaceAll("[\\[\\]\\(\\)\"'.,?!]", "").trim();
                if (name.length() > 0) {
                    // Insert a separator between the characters to avoid
                    // matches on a partial character. If we ever change
                    // to start-of-word-only matches, this can be removed.
                    StringBuilder b = new StringBuilder();
                    b.append('.');
                    int nl = name.length();
                    for (int i = 0; i < nl; i++) {
                        b.append(name.charAt(i));
                        b.append('.');
                    }
                    name = b.toString();
                    String key = DatabaseUtils.getCollationKey(name);
                    if (sortfirst) {
                        key = "\001" + key;
                    }
                    return key;
               } else {
                    return "";
                }
            }
            return null;
        }
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.457 -0400", hash_original_method = "553D011F7A7937C6B31A2ECF0083B637", hash_generated_method = "553D011F7A7937C6B31A2ECF0083B637")
        public Audio ()
        {
            //Synthesized constructor
        }
        
        public static final class Media implements AudioColumns {
            /**
             * Get the content:// style URI for the audio media table on the
             * given volume.
             *
             * @param volumeName the name of the volume to get the URI for
             * @return the URI to the audio media table on the given volume
             */
            @DSSource({DSSourceKind.FILE_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.619 -0500", hash_original_method = "7BC2F03DF14329F6FE08C0A58CBF1643", hash_generated_method = "A992774CE618273FBFB6557783752FC3")
            
public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/media");
            }

            @DSSource({DSSourceKind.FILE_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.622 -0500", hash_original_method = "3C6A6D60A779BAAF3BF8B77D7DFF40A3", hash_generated_method = "7B99D09EDD1ACB797F0D5DF0AB7533A2")
            
public static Uri getContentUriForPath(String path) {
                return (path.startsWith(Environment.getExternalStorageDirectory().getPath()) ?
                        EXTERNAL_CONTENT_URI : INTERNAL_CONTENT_URI);
            }
            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.458 -0400", hash_original_field = "B4CA71E6A6DABB62CF00BA6BA06DF1F6", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.459 -0400", hash_original_field = "6BB27CAB940C3235D66FE1017AB8E95E", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.630 -0500", hash_original_field = "4EA651CA8308CB03976C9B6A67EB0B11", hash_generated_field = "5DFF3EF904D1B5DFDB7238BA1EF13627")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/audio";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.633 -0500", hash_original_field = "66FCF672A5DAB7FFEC981248C791B49E", hash_generated_field = "9CA0957FE990E6612A17A5ADC5B5AF40")

            public static final String DEFAULT_SORT_ORDER = TITLE_KEY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.635 -0500", hash_original_field = "62D639623316D76E23286097564CF8C3", hash_generated_field = "98FCF6EE0488D8931189FA8705E80FB7")

            public static final String RECORD_SOUND_ACTION =
                    "android.provider.MediaStore.RECORD_SOUND";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.638 -0500", hash_original_field = "DDE8B5F3413A5E6DD52D1C5BEEFC87A4", hash_generated_field = "16C267F4F82A95E267906C622A2EEAA6")

             public static final String EXTRA_MAX_BYTES =
                    "android.provider.MediaStore.extra.MAX_BYTES";
            
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.458 -0400", hash_original_method = "AABF7D5402BFD519F4DA876621C956DE", hash_generated_method = "AABF7D5402BFD519F4DA876621C956DE")
            public Media ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Genres implements BaseColumns, GenresColumns {
            /**
             * Get the content:// style URI for the audio genres table on the
             * given volume.
             *
             * @param volumeName the name of the volume to get the URI for
             * @return the URI to the audio genres table on the given volume
             */
            @DSSource({DSSourceKind.FILE_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.646 -0500", hash_original_method = "1CF6BD090DABA01652B1DE33E8033EFA", hash_generated_method = "89E9B7287F9A9CFB4DB23910AE63589F")
            
public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/genres");
            }

            /**
             * Get the content:// style URI for querying the genres of an audio file.
             *
             * @param volumeName the name of the volume to get the URI for
             * @param audioId the ID of the audio file for which to retrieve the genres
             * @return the URI to for querying the genres for the audio file
             * with the given the volume and audioID
             */
            @DSSource({DSSourceKind.FILE_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.649 -0500", hash_original_method = "41F194A6497C33D9B998B598C479E322", hash_generated_method = "C4F80A0D540BD4402723086A758E6E80")
            
public static Uri getContentUriForAudioId(String volumeName, int audioId) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/media/" + audioId + "/genres");
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.653 -0500", hash_original_field = "B269D74210F6643EC8FFDC9943F2FBBA", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            
            public static final class Members implements AudioColumns {

                @DSSource({DSSourceKind.FILE_INFORMATION})
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.667 -0500", hash_original_method = "55CF68002905D503AB205A6C04930549", hash_generated_method = "31826974FF95BF68DC8C7EDB78615960")
                
public static final Uri getContentUri(String volumeName,
                        long genreId) {
                    return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                            + "/audio/genres/" + genreId + "/members");
                }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.717 -0500", hash_original_field = "12B70289C724F477A1EBFEC95AF65186", hash_generated_field = "DB7ADB2B4AB00C495BEDDDD281A9FEA3")

                public static final String CONTENT_DIRECTORY = "members";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.673 -0500", hash_original_field = "66FCF672A5DAB7FFEC981248C791B49E", hash_generated_field = "9CA0957FE990E6612A17A5ADC5B5AF40")

                public static final String DEFAULT_SORT_ORDER = TITLE_KEY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.719 -0500", hash_original_field = "EB1249F314E7481F0D13A1CB51BE5427", hash_generated_field = "382D7EB918B49C78EB06492C73BC97FB")

                public static final String AUDIO_ID = "audio_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.678 -0500", hash_original_field = "D1D43ECD689962B225F042DEAB33B54C", hash_generated_field = "39198E92E9A65D017CA1639585E0DF84")

                public static final String GENRE_ID = "genre_id";
                
                @DSSafe(DSCat.SAFE_OTHERS)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.459 -0400", hash_original_method = "A4C48D9C87FE7EE1DA0DC145BA44FFAF", hash_generated_method = "A4C48D9C87FE7EE1DA0DC145BA44FFAF")
                public Members ()
                {
                    //Synthesized constructor
                }
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.655 -0500", hash_original_field = "03E6D4DE406DF4FB8653B600C7452025", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.658 -0500", hash_original_field = "99570A574CD0BD8C548E0B76CC151CA6", hash_generated_field = "E1B6CFD623C2263B7E469FD88BCF8D69")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/genre";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.660 -0500", hash_original_field = "4A9E4D38A1CE6E613862592F303585E1", hash_generated_field = "2B7DC59AF9446FD67FDE51146B04B78B")

            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/genre";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.663 -0500", hash_original_field = "B9322FDDB9BC287B4AE15C2E93599F56", hash_generated_field = "A2FB1268F0AAE758649FA6BFE2C4E5D6")

            public static final String DEFAULT_SORT_ORDER = NAME;
            
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.459 -0400", hash_original_method = "5A301F51AFE295226C0A121512898093", hash_generated_method = "5A301F51AFE295226C0A121512898093")
            public Genres ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Playlists implements BaseColumns, PlaylistsColumns {
            /**
             * Get the content:// style URI for the audio playlists table on the
             * given volume.
             *
             * @param volumeName the name of the volume to get the URI for
             * @return the URI to the audio playlists table on the given volume
             */
            @DSSource({DSSourceKind.FILE_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.691 -0500", hash_original_method = "645770BE430EC26F3820C55E3B33E2DF", hash_generated_method = "381C3C055A0109C1EF249AEA5FF2E149")
            
public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/playlists");
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.694 -0500", hash_original_field = "B269D74210F6643EC8FFDC9943F2FBBA", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            
            public static final class Members implements AudioColumns {
                @DSComment("URI moving around")
                @DSSpec(DSCat.URI_EXCHANGE)
                @DSSource({DSSourceKind.FILE_INFORMATION})
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.707 -0500", hash_original_method = "96BDCFD6E7CB52F7223465A2D6EE9A74", hash_generated_method = "9010678E8195591DFDC953DE2DED9116")
                
public static final Uri getContentUri(String volumeName,
                        long playlistId) {
                    return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                            + "/audio/playlists/" + playlistId + "/members");
                }

                /**
                 * Convenience method to move a playlist item to a new location
                 * @param res The content resolver to use
                 * @param playlistId The numeric id of the playlist
                 * @param from The position of the item to move
                 * @param to The position to move the item to
                 * @return true on success
                 */
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.711 -0500", hash_original_method = "9DA25B025FE28EC3AC4ACBCE0C1BFD50", hash_generated_method = "5034B493CD7750526DFD99DE63E751DD")
                
public static final boolean moveItem(ContentResolver res,
                        long playlistId, int from, int to) {
                    Uri uri = MediaStore.Audio.Playlists.Members.getContentUri("external",
                            playlistId)
                            .buildUpon()
                            .appendEncodedPath(String.valueOf(from))
                            .appendQueryParameter("move", "true")
                            .build();
                    ContentValues values = new ContentValues();
                    values.put(MediaStore.Audio.Playlists.Members.PLAY_ORDER, to);
                    return res.update(uri, values, null, null) != 0;
                }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.714 -0500", hash_original_field = "6FDF2F856E52A2C35AACBF9AF8171666", hash_generated_field = "B34A1444880FA153E0220CFB867105F7")

                public static final String _ID = "_id";
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.460 -0400", hash_original_field = "D46E914A8CFDE411714424962678DE60", hash_generated_field = "DB7ADB2B4AB00C495BEDDDD281A9FEA3")

                public static final String CONTENT_DIRECTORY = "members";
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.460 -0400", hash_original_field = "F48A44710BB263A5D7C9A6B38C638850", hash_generated_field = "382D7EB918B49C78EB06492C73BC97FB")

                public static final String AUDIO_ID = "audio_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.722 -0500", hash_original_field = "F0E9652E6A8F2A9B512AC414635A271A", hash_generated_field = "8B99B390580EC4D8EC34CC087D44092D")

                public static final String PLAYLIST_ID = "playlist_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.725 -0500", hash_original_field = "B81BBB54CABAF8860C30C750F0F7D510", hash_generated_field = "6C3FE81A0BACA3DA560AAD1D806E9D96")

                public static final String PLAY_ORDER = "play_order";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.728 -0500", hash_original_field = "1A395B2B3E39F0502BFB37B1FE80463F", hash_generated_field = "A8F59651FB55C4C2E1DD16A17470594E")

                public static final String DEFAULT_SORT_ORDER = PLAY_ORDER;
                
                @DSSafe(DSCat.SAFE_OTHERS)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.460 -0400", hash_original_method = "A4C48D9C87FE7EE1DA0DC145BA44FFAF", hash_generated_method = "A4C48D9C87FE7EE1DA0DC145BA44FFAF")
                public Members ()
                {
                    //Synthesized constructor
                }
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.696 -0500", hash_original_field = "03E6D4DE406DF4FB8653B600C7452025", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.699 -0500", hash_original_field = "10AF5E531059B1A35852762E8D6D4D79", hash_generated_field = "7886ED7A80A0EA66150F49DF90C591DC")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/playlist";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.702 -0500", hash_original_field = "2CA7C2803EE9B9461AA42F66D7395D6B", hash_generated_field = "A3425404F8D772BE71E2B6C9EAD1785A")

            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/playlist";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.704 -0500", hash_original_field = "B9322FDDB9BC287B4AE15C2E93599F56", hash_generated_field = "A2FB1268F0AAE758649FA6BFE2C4E5D6")

            public static final String DEFAULT_SORT_ORDER = NAME;
            
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.460 -0400", hash_original_method = "74E3D69F5F937E9AFBC239AC6178742A", hash_generated_method = "74E3D69F5F937E9AFBC239AC6178742A")
            public Playlists ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Artists implements BaseColumns, ArtistColumns {
            /**
             * Get the content:// style URI for the artists table on the
             * given volume.
             *
             * @param volumeName the name of the volume to get the URI for
             * @return the URI to the audio artists table on the given volume
             */
            @DSSource({DSSourceKind.FILE_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.741 -0500", hash_original_method = "FD66489C6245EC419D305AD593BAF7F8", hash_generated_method = "1694B6CD5E48801661ACBEE648621070")
            
public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/artists");
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.744 -0500", hash_original_field = "B269D74210F6643EC8FFDC9943F2FBBA", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            
            public static final class Albums implements AlbumColumns {
                @DSSource({DSSourceKind.FILE_INFORMATION})
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.759 -0500", hash_original_method = "C95690BA5A28FE2CD2430F02E3EC9539", hash_generated_method = "A56894B0FDB584F61C28239BC0137602")
                
public static final Uri getContentUri(String volumeName,
                        long artistId) {
                    return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                            + "/audio/artists/" + artistId + "/albums");
                }
                
                @DSSafe(DSCat.SAFE_OTHERS)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.461 -0400", hash_original_method = "7EBF89799AE4644EBE85B32B12FD367D", hash_generated_method = "7EBF89799AE4644EBE85B32B12FD367D")
                public Albums ()
                {
                    //Synthesized constructor
                }
                
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.746 -0500", hash_original_field = "03E6D4DE406DF4FB8653B600C7452025", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.749 -0500", hash_original_field = "259A9405C4A2E5E58BFDBE37B431071D", hash_generated_field = "4D2C185FD5D3770BBB496266841B2798")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/artists";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.752 -0500", hash_original_field = "CE15CCFB76C653750012B3224ACD5556", hash_generated_field = "98400472C82334F395927F8E1AEF2AEB")

            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/artist";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.754 -0500", hash_original_field = "CAADB616D47CBFBD69FFC5FC8CD1C507", hash_generated_field = "332893369A4BBA52F86F1E98B47F7C33")

            public static final String DEFAULT_SORT_ORDER = ARTIST_KEY;
            
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.461 -0400", hash_original_method = "5A569BA5E9300E73D18EF84988BF2B4D", hash_generated_method = "5A569BA5E9300E73D18EF84988BF2B4D")
            public Artists ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Albums implements BaseColumns, AlbumColumns {
            /**
             * Get the content:// style URI for the albums table on the
             * given volume.
             *
             * @param volumeName the name of the volume to get the URI for
             * @return the URI to the audio albums table on the given volume
             */
            @DSSource({DSSourceKind.FILE_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.773 -0500", hash_original_method = "4BBBF90040E52C1783C62EF76D7CBADD", hash_generated_method = "6BE0A51081C5362D4920B43F3116DAF1")
            
public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/albums");
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.776 -0500", hash_original_field = "B269D74210F6643EC8FFDC9943F2FBBA", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.778 -0500", hash_original_field = "03E6D4DE406DF4FB8653B600C7452025", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.781 -0500", hash_original_field = "7595D5D03EE52CA7561E7FC7C5E61D82", hash_generated_field = "5B57B84C208FF887BC56BE52F5F242A8")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/albums";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.784 -0500", hash_original_field = "DA98EE0205C37ADF83E515BE0A59FB7A", hash_generated_field = "AD71577E74C0A9EDD832620AE0172EC4")

            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/album";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.787 -0500", hash_original_field = "CEB694F4023D516A269F7537A8E53A8B", hash_generated_field = "379F25D8A8F63DE3CF34DAC50E06B398")

            public static final String DEFAULT_SORT_ORDER = ALBUM_KEY;
            
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.461 -0400", hash_original_method = "7EBF89799AE4644EBE85B32B12FD367D", hash_generated_method = "7EBF89799AE4644EBE85B32B12FD367D")
            public Albums ()
            {
                //Synthesized constructor
            }
        }
        
        public interface AudioColumns extends MediaColumns {
            
            public static final String TITLE_KEY = "title_key";
            
            public static final String DURATION = "duration";
            
            public static final String BOOKMARK = "bookmark";
            
            public static final String ARTIST_ID = "artist_id";
            
            public static final String ARTIST = "artist";
            
            public static final String ALBUM_ARTIST = "album_artist";
            
            public static final String COMPILATION = "compilation";
            
            public static final String ARTIST_KEY = "artist_key";
            
            public static final String COMPOSER = "composer";
            
            public static final String ALBUM_ID = "album_id";
            
            public static final String ALBUM = "album";
            
            public static final String ALBUM_KEY = "album_key";
            
            public static final String TRACK = "track";
            
            public static final String YEAR = "year";
            
            public static final String IS_MUSIC = "is_music";
            
            public static final String IS_PODCAST = "is_podcast";
            
            public static final String IS_RINGTONE = "is_ringtone";
            
            public static final String IS_ALARM = "is_alarm";
            
            public static final String IS_NOTIFICATION = "is_notification";
            
            public static final String GENRE = "genre";
        }
        
        public interface GenresColumns {
            
            public static final String NAME = "name";
        }
        
        public interface PlaylistsColumns {
            
            public static final String NAME = "name";
            
            public static final String DATA = "_data";
            
            public static final String DATE_ADDED = "date_added";
            
            public static final String DATE_MODIFIED = "date_modified";
        }
        
        public interface ArtistColumns {
            
            public static final String ARTIST = "artist";
            
            public static final String ARTIST_KEY = "artist_key";
            
            public static final String NUMBER_OF_ALBUMS = "number_of_albums";
            
            public static final String NUMBER_OF_TRACKS = "number_of_tracks";
        }
        
        public interface AlbumColumns {
            
            public static final String ALBUM_ID = "album_id";
            
            public static final String ALBUM = "album";
            
            public static final String ARTIST = "artist";
            
            public static final String NUMBER_OF_SONGS = "numsongs";
            
            public static final String NUMBER_OF_SONGS_FOR_ARTIST = "numsongs_by_artist";
            
            public static final String FIRST_YEAR = "minyear";
            
            public static final String LAST_YEAR = "maxyear";
            
            public static final String ALBUM_KEY = "album_key";
            
            public static final String ALBUM_ART = "album_art";
        }
        
    }
    
    public static final class Video {

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.803 -0500", hash_original_method = "D33973CFD3614E757CA6971FCFC77D62", hash_generated_method = "522FA5EC19DCD037B3DD1291CCDDFA1F")
        
public static final Cursor query(ContentResolver cr, Uri uri, String[] projection) {
            return cr.query(uri, projection, null, null, DEFAULT_SORT_ORDER);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.799 -0500", hash_original_field = "1EB73F7AF49C3C1C8871210B895EF301", hash_generated_field = "A72EF801920E6D0FBCC298B3F48750D9")

        public static final String DEFAULT_SORT_ORDER = MediaColumns.DISPLAY_NAME;
        
        public static final class Media implements VideoColumns {
            /**
             * Get the content:// style URI for the video media table on the
             * given volume.
             *
             * @param volumeName the name of the volume to get the URI for
             * @return the URI to the video media table on the given volume
             */
            @DSSource({DSSourceKind.FILE_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.815 -0500", hash_original_method = "62F44913137B8C4A13A1C32E412D06B5", hash_generated_method = "C4FC987BE0CBD99859AFF3DB34B45299")
            
public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/video/media");
            }
            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.462 -0400", hash_original_field = "B4CA71E6A6DABB62CF00BA6BA06DF1F6", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.462 -0400", hash_original_field = "6BB27CAB940C3235D66FE1017AB8E95E", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.824 -0500", hash_original_field = "B9E172789E21354B46BE117D61A0F5B7", hash_generated_field = "D9F9D24ED20803B056D0DA2161C944E7")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/video";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.827 -0500", hash_original_field = "3CDD8B08D6F00022AAC8D91F270CB6BA", hash_generated_field = "F1AD81D67BCA33411A74FB57B6D6FE7D")

            public static final String DEFAULT_SORT_ORDER = TITLE;
            
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.462 -0400", hash_original_method = "AABF7D5402BFD519F4DA876621C956DE", hash_generated_method = "AABF7D5402BFD519F4DA876621C956DE")
            public Media ()
            {
                //Synthesized constructor
            }
        }
        
        public static class Thumbnails implements BaseColumns {

            public static void cancelThumbnailRequest(ContentResolver cr, long origId) {
                InternalThumbnails.cancelThumbnailRequest(cr, origId, EXTERNAL_CONTENT_URI,
                        InternalThumbnails.DEFAULT_GROUP_ID);
            }

            /**
             * This method checks if the thumbnails of the specified image (origId) has been created.
             * It will be blocked until the thumbnails are generated.
             *
             * @param cr ContentResolver used to dispatch queries to MediaProvider.
             * @param origId Original image id associated with thumbnail of interest.
             * @param kind The type of thumbnail to fetch. Should be either MINI_KIND or MICRO_KIND.
             * @param options this is only used for MINI_KIND when decoding the Bitmap
             * @return A Bitmap instance. It could be null if the original image
             *         associated with origId doesn't exist or memory is not enough.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.835 -0500", hash_original_method = "172FCB0110A1F99EBF930D5E744C7BE9", hash_generated_method = "6465FE82FEED7285B8536C3A4981C6CB")
            
public static Bitmap getThumbnail(ContentResolver cr, long origId, int kind,
                    BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(cr, origId,
                        InternalThumbnails.DEFAULT_GROUP_ID, kind, options,
                        EXTERNAL_CONTENT_URI, true);
            }

            /**
             * This method checks if the thumbnails of the specified image (origId) has been created.
             * It will be blocked until the thumbnails are generated.
             *
             * @param cr ContentResolver used to dispatch queries to MediaProvider.
             * @param origId Original image id associated with thumbnail of interest.
             * @param groupId the id of group to which this request belongs
             * @param kind The type of thumbnail to fetch. Should be either MINI_KIND or MICRO_KIND
             * @param options this is only used for MINI_KIND when decoding the Bitmap
             * @return A Bitmap instance. It could be null if the original image associated with
             *         origId doesn't exist or memory is not enough.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.837 -0500", hash_original_method = "0DF93B55084418555A720C042FA08001", hash_generated_method = "3D9177C741CFED1C5A49D925F38B9A2D")
            
public static Bitmap getThumbnail(ContentResolver cr, long origId, long groupId,
                    int kind, BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(cr, origId, groupId, kind, options,
                        EXTERNAL_CONTENT_URI, true);
            }
            
            public static void cancelThumbnailRequest(ContentResolver cr, long origId, long groupId) {
                InternalThumbnails.cancelThumbnailRequest(cr, origId, EXTERNAL_CONTENT_URI, groupId);
            }

            /**
             * Get the content:// style URI for the image media table on the
             * given volume.
             *
             * @param volumeName the name of the volume to get the URI for
             * @return the URI to the image media table on the given volume
             */
            @DSSource({DSSourceKind.FILE_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.842 -0500", hash_original_method = "15FBBC3EA73486A6D659DC0927D4EC42", hash_generated_method = "BAAF5B7DAD7F5A3186DA6B6DBF384D60")
            
public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/video/thumbnails");
            }
            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.463 -0400", hash_original_field = "B4CA71E6A6DABB62CF00BA6BA06DF1F6", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.463 -0400", hash_original_field = "6BB27CAB940C3235D66FE1017AB8E95E", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.851 -0500", hash_original_field = "17D6CDD6D3DDA4E2D99740C4575AD78C", hash_generated_field = "A5388A3303EC2C70E303BC1733345832")

            public static final String DEFAULT_SORT_ORDER = "video_id ASC";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.463 -0400", hash_original_field = "1DA2383FC2FFA0E5D2654EA151089BF3", hash_generated_field = "A66DA404DB529637DF4981C792367756")

            public static final String DATA = "_data";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.856 -0500", hash_original_field = "089AFB43908C7E62C6CC5494CBDBBA87", hash_generated_field = "C16F73320C40AC771DE6456ABC479D42")

            public static final String VIDEO_ID = "video_id";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.463 -0400", hash_original_field = "5C4A1F77A7D94E0CAF07EEC33B2F1286", hash_generated_field = "C4772988085372FF3551CC4315A50E0B")

            public static final String KIND = "kind";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.463 -0400", hash_original_field = "86BB24EA9B9FBBBCF2150F37EF9B1916", hash_generated_field = "99CE8D50C31FD4187F2F339D8B9B48C7")

            public static final int MINI_KIND = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.463 -0400", hash_original_field = "F0B1111C9C9BC310F2F7201792E2DF93", hash_generated_field = "8C0560965409D5FE4F991B1D52B6B6A8")

            public static final int FULL_SCREEN_KIND = 2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.463 -0400", hash_original_field = "9AB923142D918EADF946D75CF9101595", hash_generated_field = "623F298E957ADDE8E0DCD7F12E785698")

            public static final int MICRO_KIND = 3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.463 -0400", hash_original_field = "CE07B77F3FD4244A5F7485F0D4C17B45", hash_generated_field = "FE9CB65DA5AC820EB66328B1E325F141")

            public static final String WIDTH = "width";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.463 -0400", hash_original_field = "58A8FFDB42E31B05F5E0AA01DBD77A10", hash_generated_field = "A6B1CAF6BB48877DB47F660C1A4B4504")

            public static final String HEIGHT = "height";
            
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.462 -0400", hash_original_method = "CEC4957051438E94FE667AB7B98C828F", hash_generated_method = "CEC4957051438E94FE667AB7B98C828F")
            public Thumbnails ()
            {
                //Synthesized constructor
            }
        }
        
        public interface VideoColumns extends MediaColumns {
            
            public static final String DURATION = "duration";
            
            public static final String ARTIST = "artist";
            
            public static final String ALBUM = "album";
            
            public static final String RESOLUTION = "resolution";
            
            public static final String DESCRIPTION = "description";
            
            public static final String IS_PRIVATE = "isprivate";
            
            public static final String TAGS = "tags";
            
            public static final String CATEGORY = "category";
            
            public static final String LANGUAGE = "language";
            
            public static final String LATITUDE = "latitude";
            
            public static final String LONGITUDE = "longitude";
            
            public static final String DATE_TAKEN = "datetaken";
            
            public static final String MINI_THUMB_MAGIC = "mini_thumb_magic";
            
            public static final String BUCKET_ID = "bucket_id";
            
            public static final String BUCKET_DISPLAY_NAME = "bucket_display_name";
            
            public static final String BOOKMARK = "bookmark";
        }
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.461 -0400", hash_original_method = "8FC1394ED845BB72BFE890B41D7CAD7E", hash_generated_method = "8FC1394ED845BB72BFE890B41D7CAD7E")
        public Video ()
        {
            //Synthesized constructor
        }
    }
    
    public interface MediaColumns extends BaseColumns {
        
        public static final String DATA = "_data";
        
        public static final String SIZE = "_size";
        
        public static final String DISPLAY_NAME = "_display_name";
        
        public static final String TITLE = "title";
        
        public static final String DATE_ADDED = "date_added";
        
        public static final String DATE_MODIFIED = "date_modified";
        
        public static final String MIME_TYPE = "mime_type";
        
        public static final String MEDIA_SCANNER_NEW_OBJECT_ID = "media_scanner_new_object_id";
        
        public static final String IS_DRM = "is_drm";
        
        public static final String WIDTH = "width";
        
        public static final String HEIGHT = "height";
     }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.369 -0500", hash_original_field = "AA55383DC3F7BD6C287AFC306AD5D7E5", hash_generated_field = "A7DFC8694D3D0E7657229CD0FFF5B630")

    public static final String AUTHORITY = "media";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.371 -0500", hash_original_field = "412777ED2A77CB0564FBC452E4AAD65B", hash_generated_field = "027422C86865920C2F404F289EE08DA8")

    private static final String CONTENT_AUTHORITY_SLASH = "content://" + AUTHORITY + "/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.374 -0500", hash_original_field = "E664179887E4517F77CF655287E8095A", hash_generated_field = "4AC3ACCC87E038F10B80832F5408B1BC")

    public static final String ACTION_MTP_SESSION_END = "android.provider.action.MTP_SESSION_END";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.376 -0500", hash_original_field = "5B22B5E1BFC2F8D5369583F17FF8F0A4", hash_generated_field = "E09B7FA4C274836F20284B58798CF9B5")

    @Deprecated
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String INTENT_ACTION_MUSIC_PLAYER = "android.intent.action.MUSIC_PLAYER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.379 -0500", hash_original_field = "B0408390CCF36707200DE5ED25E94B26", hash_generated_field = "14E225D86AD9F750F07ABB2CC0A1F78B")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String INTENT_ACTION_MEDIA_SEARCH = "android.intent.action.MEDIA_SEARCH";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.381 -0500", hash_original_field = "7681931D5A3E0EE88B61CCC40138C85D", hash_generated_field = "BCF79BCDD2A8D0223693A47E87B3FB87")

    public static final String INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH =
            "android.media.action.MEDIA_PLAY_FROM_SEARCH";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.384 -0500", hash_original_field = "7D8824DD566953523D2921AFEFA075D9", hash_generated_field = "8C6545564FADA5903D0948466EC12557")

    public static final String EXTRA_MEDIA_ARTIST = "android.intent.extra.artist";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.386 -0500", hash_original_field = "E2071BB55A52B4A66D17B0898785EBBE", hash_generated_field = "C980456F9DD94096B28012B67800926D")

    public static final String EXTRA_MEDIA_ALBUM = "android.intent.extra.album";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.389 -0500", hash_original_field = "5B12FCA8413B287F57860981C644CD49", hash_generated_field = "4792CF25AC338288960AFE12B613D6A2")

    public static final String EXTRA_MEDIA_TITLE = "android.intent.extra.title";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.391 -0500", hash_original_field = "36AD670B64F17C8D437C451E9C9BE563", hash_generated_field = "72D132B1C5F6D2B7078ED4AB0F036952")

    public static final String EXTRA_MEDIA_FOCUS = "android.intent.extra.focus";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.393 -0500", hash_original_field = "60C54FB7B0D37705C410D2C01C5CCF5F", hash_generated_field = "EFE407D2F32BF5ADCB7717684CF92CC6")

    public static final String EXTRA_SCREEN_ORIENTATION = "android.intent.extra.screenOrientation";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.396 -0500", hash_original_field = "23686E0D9CD1F1134D25623F6B44A2AE", hash_generated_field = "A5DBF907AD5A6EC1A25F8010D89A1B12")

    public static final String EXTRA_FULL_SCREEN = "android.intent.extra.fullScreen";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.398 -0500", hash_original_field = "F8CE050322FF94463A2908BE6900C6F6", hash_generated_field = "8B2470F342CF29E36A8468DA20BB144A")

    public static final String EXTRA_SHOW_ACTION_ICONS = "android.intent.extra.showActionIcons";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.401 -0500", hash_original_field = "A2B81E8140C808448BBC5AD42D62712C", hash_generated_field = "832680E96220C6307238C134A8AAF73F")

    public static final String EXTRA_FINISH_ON_COMPLETION = "android.intent.extra.finishOnCompletion";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.404 -0500", hash_original_field = "005DB39AA53559438B779DD7A31BE29E", hash_generated_field = "860A7DFD760F4321420148084D173747")

    public static final String INTENT_ACTION_STILL_IMAGE_CAMERA = "android.media.action.STILL_IMAGE_CAMERA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.406 -0500", hash_original_field = "7F602566C0A40EECC0128C4D6352B937", hash_generated_field = "733F786611D450A0A68A4EF7B2D3BFFF")

    public static final String INTENT_ACTION_VIDEO_CAMERA = "android.media.action.VIDEO_CAMERA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.408 -0500", hash_original_field = "560626CDBD2EC12987FA365D132E6448", hash_generated_field = "EB213F3388033EA8ACC753E0170748C0")

    public final static String ACTION_IMAGE_CAPTURE = "android.media.action.IMAGE_CAPTURE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.411 -0500", hash_original_field = "C4104E4511F4E51C03AF41FBE15E823E", hash_generated_field = "5914F06B7133898D3EB0FE683B022154")

    public final static String ACTION_VIDEO_CAPTURE = "android.media.action.VIDEO_CAPTURE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.413 -0500", hash_original_field = "4485B1821D74550A825AF203EB142D13", hash_generated_field = "FE0F2F344BEEED50C4B9B25035AD566A")

    public final static String EXTRA_VIDEO_QUALITY = "android.intent.extra.videoQuality";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.415 -0500", hash_original_field = "7D09085F51B12016B0605341C9B5454B", hash_generated_field = "58265C65BBD1D2C4DE9D186B226EF361")

    public final static String EXTRA_SIZE_LIMIT = "android.intent.extra.sizeLimit";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.418 -0500", hash_original_field = "5295C47350E8A8749A93A0632B0B9AFA", hash_generated_field = "4885F3925500336C9B74AD82F9F8B38E")

    public final static String EXTRA_DURATION_LIMIT = "android.intent.extra.durationLimit";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.420 -0500", hash_original_field = "A9889A9CAE97527910A4CB0807E86331", hash_generated_field = "A7FA8BD777FCC1FECD1E96853C582359")

    public final static String EXTRA_OUTPUT = "output";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.422 -0500", hash_original_field = "0334075654C0FF27461392EE3D4E51B1", hash_generated_field = "389D1922445E3024CFD51027EC75BBD6")

    public static final String UNKNOWN_STRING = "<unknown>";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.904 -0500", hash_original_field = "697C2FF740F7916B4A3CC1739473AFBC", hash_generated_field = "7D2FACD66491E00572801F8C8B9C6463")

    public static final String MEDIA_SCANNER_VOLUME = "volume";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:57.906 -0500", hash_original_field = "52165A87631EC54F837B3EC3AB856A4B", hash_generated_field = "6FCA486A7CA08615D278EDF15EB8B907")

    public static final String MEDIA_IGNORE_FILENAME = ".nomedia";
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.452 -0400", hash_original_method = "463B9D094169FDB0633EE291129364D2", hash_generated_method = "463B9D094169FDB0633EE291129364D2")
    public MediaStore ()
    {
        //Synthesized constructor
    }
}

