package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.ContentUris;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class MediaStore {
    private final static String TAG = "MediaStore";
    public static final String AUTHORITY = "media";
    private static final String CONTENT_AUTHORITY_SLASH = "content://" + AUTHORITY + "/";
    public static final String ACTION_MTP_SESSION_END = "android.provider.action.MTP_SESSION_END";
    @Deprecated
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String INTENT_ACTION_MUSIC_PLAYER = "android.intent.action.MUSIC_PLAYER";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String INTENT_ACTION_MEDIA_SEARCH = "android.intent.action.MEDIA_SEARCH";
    public static final String INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH =
            "android.media.action.MEDIA_PLAY_FROM_SEARCH";
    public static final String EXTRA_MEDIA_ARTIST = "android.intent.extra.artist";
    public static final String EXTRA_MEDIA_ALBUM = "android.intent.extra.album";
    public static final String EXTRA_MEDIA_TITLE = "android.intent.extra.title";
    public static final String EXTRA_MEDIA_FOCUS = "android.intent.extra.focus";
    public static final String EXTRA_SCREEN_ORIENTATION = "android.intent.extra.screenOrientation";
    public static final String EXTRA_FULL_SCREEN = "android.intent.extra.fullScreen";
    public static final String EXTRA_SHOW_ACTION_ICONS = "android.intent.extra.showActionIcons";
    public static final String EXTRA_FINISH_ON_COMPLETION = "android.intent.extra.finishOnCompletion";
    public static final String INTENT_ACTION_STILL_IMAGE_CAMERA = "android.media.action.STILL_IMAGE_CAMERA";
    public static final String INTENT_ACTION_VIDEO_CAMERA = "android.media.action.VIDEO_CAMERA";
    public final static String ACTION_IMAGE_CAPTURE = "android.media.action.IMAGE_CAPTURE";
    public final static String ACTION_VIDEO_CAPTURE = "android.media.action.VIDEO_CAPTURE";
    public final static String EXTRA_VIDEO_QUALITY = "android.intent.extra.videoQuality";
    public final static String EXTRA_SIZE_LIMIT = "android.intent.extra.sizeLimit";
    public final static String EXTRA_DURATION_LIMIT = "android.intent.extra.durationLimit";
    public final static String EXTRA_OUTPUT = "output";
    public static final String UNKNOWN_STRING = "<unknown>";
    public static final String MEDIA_SCANNER_VOLUME = "volume";
    public static final String MEDIA_IGNORE_FILENAME = ".nomedia";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.236 -0400", hash_original_method = "2AB61FF2E7140B128AA8E0CB2E9AAED9", hash_generated_method = "4ED1F31638B10772A3D991934AC9340B")
    public static Uri getMediaScannerUri() {
        return Uri.parse(CONTENT_AUTHORITY_SLASH + "none/media_scanner");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.236 -0400", hash_original_method = "AE38216E99DAE811D25BA0107413939D", hash_generated_method = "A5E3282E23260DB91E9A5D82657E9B69")
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

    
    public static final class Files {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.236 -0400", hash_original_method = "409759DEA77E6C649AE2EA692A3554B8", hash_generated_method = "A280A2BA0F4395634F272135FE1EBA34")
        public static Uri getContentUri(String volumeName) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                    "/file");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.236 -0400", hash_original_method = "093C2982E064F68E36812413D73335AF", hash_generated_method = "F02C710E69F22870280DA8940CF6B34E")
        public static final Uri getContentUri(String volumeName,
                long rowId) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                    + "/file/" + rowId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.237 -0400", hash_original_method = "2FA8FCD7E4B4B360F21FD1B576A95B66", hash_generated_method = "0F65AACC551D6280680A5F4F5034162B")
        public static Uri getMtpObjectsUri(String volumeName) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                    "/object");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.237 -0400", hash_original_method = "4D06DA2298DFF5AAAB3A88C1D51AE35B", hash_generated_method = "79359F0971EFBA5ABE8627030F660389")
        public static final Uri getMtpObjectsUri(String volumeName,
                long fileId) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                    + "/object/" + fileId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.237 -0400", hash_original_method = "156D6BD07D5B040A2C58E7948D6F92A6", hash_generated_method = "53A9AF6975906E0F395058EF2299221C")
        public static final Uri getMtpReferencesUri(String volumeName,
                long fileId) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                    + "/object/" + fileId + "/references");
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
        private static final int MINI_KIND = 1;
        private static final int FULL_SCREEN_KIND = 2;
        private static final int MICRO_KIND = 3;
        private static final String[] PROJECTION = new String[] {_ID, MediaColumns.DATA};
        static final int DEFAULT_GROUP_ID = 0;
        private static final Object sThumbBufLock = new Object();
        private static byte[] sThumbBuf;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.237 -0400", hash_original_method = "55184BD5503D496525DD695550EB0913", hash_generated_method = "4A503CB3F3D7E6D2923157E41CC0CD05")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.237 -0400", hash_original_method = "F29A79C31A2CA4FED1ACCEFFCCC8C171", hash_generated_method = "ED094E0A84AEB6D086FD82573B890E67")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.238 -0400", hash_original_method = "BF0AC792D5E1630C97F13B7A4FE7C203", hash_generated_method = "7CEE463CDBBACE0E9E675264A3DBE1DB")
        static Bitmap getThumbnail(ContentResolver cr, long origId, long groupId, int kind,
                BitmapFactory.Options options, Uri baseUri, boolean isVideo) {
            Bitmap bitmap = null;
            String filePath = null;
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
                if (c == null) return null;
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
                thumbFile.deactivate();
                thumbFile = null;
            }
            return bitmap;
        }

        
    }


    
    public static final class Images {
        
        public static final class Media implements ImageColumns {
            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/image";
            public static final String DEFAULT_SORT_ORDER = ImageColumns.BUCKET_DISPLAY_NAME;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.238 -0400", hash_original_method = "D33973CFD3614E757CA6971FCFC77D62", hash_generated_method = "522FA5EC19DCD037B3DD1291CCDDFA1F")
            public static final Cursor query(ContentResolver cr, Uri uri, String[] projection) {
                return cr.query(uri, projection, null, null, DEFAULT_SORT_ORDER);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.238 -0400", hash_original_method = "53C3E712D0BE7622019DC7632C44AEC5", hash_generated_method = "9710B946F5D5EAAE3323EA0EEB6309D5")
            public static final Cursor query(ContentResolver cr, Uri uri, String[] projection,
                    String where, String orderBy) {
                return cr.query(uri, projection, where,
                                             null, orderBy == null ? DEFAULT_SORT_ORDER : orderBy);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.238 -0400", hash_original_method = "021F54ACE26AA0D28BD6812D454BB821", hash_generated_method = "C0CA4DFB37E599E4AFBBDA5E7B4ACF4F")
            public static final Cursor query(ContentResolver cr, Uri uri, String[] projection,
                    String selection, String [] selectionArgs, String orderBy) {
                return cr.query(uri, projection, selection,
                        selectionArgs, orderBy == null ? DEFAULT_SORT_ORDER : orderBy);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.238 -0400", hash_original_method = "5ACE4CC33982008EF7E75DDF8CDA73C1", hash_generated_method = "DEAC5D332371380082BED66FBEC35502")
            public static final Bitmap getBitmap(ContentResolver cr, Uri url) throws FileNotFoundException, IOException {
                InputStream input = cr.openInputStream(url);
                Bitmap bitmap = BitmapFactory.decodeStream(input);
                input.close();
                return bitmap;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.238 -0400", hash_original_method = "7EDFE27F4065D73B827ECCB92823E704", hash_generated_method = "71B4792ED023A7A55E3D2FB8D28DDA5A")
            public static final String insertImage(ContentResolver cr, String imagePath,
                    String name, String description) throws FileNotFoundException {
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.238 -0400", hash_original_method = "DAAD784C0B233997846E8495A2862A0E", hash_generated_method = "F1DEE40462B70F537EA07A426FE2FAF5")
            private static final Bitmap StoreThumbnail(
                    ContentResolver cr,
                    Bitmap source,
                    long id,
                    float width, float height,
                    int kind) {
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.239 -0400", hash_original_method = "69A0DD4660ADD7C5594E4FDC51D65483", hash_generated_method = "9AFB573DEDE92C18FAF137FED01B9DF5")
            public static final String insertImage(ContentResolver cr, Bitmap source,
                                                   String title, String description) {
                ContentValues values = new ContentValues();
                values.put(Images.Media.TITLE, title);
                values.put(Images.Media.DESCRIPTION, description);
                values.put(Images.Media.MIME_TYPE, "image/jpeg");
                Uri url = null;
                String stringUrl = null;
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
                        Bitmap miniThumb = Images.Thumbnails.getThumbnail(cr, id,
                                Images.Thumbnails.MINI_KIND, null);
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.239 -0400", hash_original_method = "D25E6866BAFE283BBBEC1A86738374B0", hash_generated_method = "E0194B654B4D913F989AC78CE4F389A6")
            public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/images/media");
            }

            
        }


        
        public static class Thumbnails implements BaseColumns {
            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            public static final String DEFAULT_SORT_ORDER = "image_id ASC";
            public static final String DATA = "_data";
            public static final String IMAGE_ID = "image_id";
            public static final String KIND = "kind";
            public static final int MINI_KIND = 1;
            public static final int FULL_SCREEN_KIND = 2;
            public static final int MICRO_KIND = 3;
            public static final String THUMB_DATA = "thumb_data";
            public static final String WIDTH = "width";
            public static final String HEIGHT = "height";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.239 -0400", hash_original_method = "D33973CFD3614E757CA6971FCFC77D62", hash_generated_method = "522FA5EC19DCD037B3DD1291CCDDFA1F")
            public static final Cursor query(ContentResolver cr, Uri uri, String[] projection) {
                return cr.query(uri, projection, null, null, DEFAULT_SORT_ORDER);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.239 -0400", hash_original_method = "D2C6FBB7BEB4CEA6BEF0854A82D35C79", hash_generated_method = "3EC21CDA307390D0BBE9F235AE4A64E3")
            public static final Cursor queryMiniThumbnails(ContentResolver cr, Uri uri, int kind,
                    String[] projection) {
                return cr.query(uri, projection, "kind = " + kind, null, DEFAULT_SORT_ORDER);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.239 -0400", hash_original_method = "BE9254821AC284A8AB44D13688ACA7DE", hash_generated_method = "E5ADCA2D02DCA0BD2BD1E6467DD1DEF8")
            public static final Cursor queryMiniThumbnail(ContentResolver cr, long origId, int kind,
                    String[] projection) {
                return cr.query(EXTERNAL_CONTENT_URI, projection,
                        IMAGE_ID + " = " + origId + " AND " + KIND + " = " +
                        kind, null, null);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.239 -0400", hash_original_method = "1F04B09633BC6FD3251DA0AD2BE516F3", hash_generated_method = "983E9B9D79C85DB2DD69AA68A9F3DB51")
            public static void cancelThumbnailRequest(ContentResolver cr, long origId) {
                InternalThumbnails.cancelThumbnailRequest(cr, origId, EXTERNAL_CONTENT_URI,
                        InternalThumbnails.DEFAULT_GROUP_ID);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.239 -0400", hash_original_method = "069003E9CCA7A32718F8DD9AFC8DF3AC", hash_generated_method = "A2CA56D487630ADB7C82FA26BA7E1D58")
            public static Bitmap getThumbnail(ContentResolver cr, long origId, int kind,
                    BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(cr, origId,
                        InternalThumbnails.DEFAULT_GROUP_ID, kind, options,
                        EXTERNAL_CONTENT_URI, false);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.239 -0400", hash_original_method = "9AAEF167BAB79AB4F88321224520B47D", hash_generated_method = "D1446C5613D089036ABDE6782BA7A84D")
            public static void cancelThumbnailRequest(ContentResolver cr, long origId, long groupId) {
                InternalThumbnails.cancelThumbnailRequest(cr, origId, EXTERNAL_CONTENT_URI, groupId);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.239 -0400", hash_original_method = "5AD0BFBA0AD49773CFC5CC711D3149F0", hash_generated_method = "0DB0B69D293B44BF86D28E74E32FBB26")
            public static Bitmap getThumbnail(ContentResolver cr, long origId, long groupId,
                    int kind, BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(cr, origId, groupId, kind, options,
                        EXTERNAL_CONTENT_URI, false);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.240 -0400", hash_original_method = "30E2B09E332E4F02ED1ADF0B393967EF", hash_generated_method = "7C81AAFED814529EAF49F67E334DB91E")
            public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/images/thumbnails");
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.240 -0400", hash_original_method = "95C694273499781A6977EEA3A6EB256B", hash_generated_method = "06FEAF8EB5F54B4546F35CF7FA4F6D2E")
        public static String keyFor(String name) {
            if (name != null)  {
                boolean sortfirst = false;
                if (name.equals(UNKNOWN_STRING)) {
                    return "\001";
                }
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

        
        public static final class Media implements AudioColumns {
            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/audio";
            public static final String DEFAULT_SORT_ORDER = TITLE_KEY;
            public static final String RECORD_SOUND_ACTION =
                    "android.provider.MediaStore.RECORD_SOUND";
            public static final String EXTRA_MAX_BYTES =
                    "android.provider.MediaStore.extra.MAX_BYTES";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.240 -0400", hash_original_method = "7BC2F03DF14329F6FE08C0A58CBF1643", hash_generated_method = "A992774CE618273FBFB6557783752FC3")
            public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/media");
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.240 -0400", hash_original_method = "3C6A6D60A779BAAF3BF8B77D7DFF40A3", hash_generated_method = "7B99D09EDD1ACB797F0D5DF0AB7533A2")
            public static Uri getContentUriForPath(String path) {
                return (path.startsWith(Environment.getExternalStorageDirectory().getPath()) ?
                        EXTERNAL_CONTENT_URI : INTERNAL_CONTENT_URI);
            }

            
        }


        
        public static final class Genres implements BaseColumns, GenresColumns {
            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/genre";
            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/genre";
            public static final String DEFAULT_SORT_ORDER = NAME;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.240 -0400", hash_original_method = "1CF6BD090DABA01652B1DE33E8033EFA", hash_generated_method = "89E9B7287F9A9CFB4DB23910AE63589F")
            public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/genres");
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.240 -0400", hash_original_method = "41F194A6497C33D9B998B598C479E322", hash_generated_method = "C4F80A0D540BD4402723086A758E6E80")
            public static Uri getContentUriForAudioId(String volumeName, int audioId) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/media/" + audioId + "/genres");
            }

            
            public static final class Members implements AudioColumns {
                public static final String CONTENT_DIRECTORY = "members";
                public static final String DEFAULT_SORT_ORDER = TITLE_KEY;
                public static final String AUDIO_ID = "audio_id";
                public static final String GENRE_ID = "genre_id";
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.241 -0400", hash_original_method = "55CF68002905D503AB205A6C04930549", hash_generated_method = "31826974FF95BF68DC8C7EDB78615960")
                public static final Uri getContentUri(String volumeName,
                        long genreId) {
                    return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                            + "/audio/genres/" + genreId + "/members");
                }

                
            }


            
        }


        
        public static final class Playlists implements BaseColumns, PlaylistsColumns {
            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/playlist";
            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/playlist";
            public static final String DEFAULT_SORT_ORDER = NAME;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.241 -0400", hash_original_method = "645770BE430EC26F3820C55E3B33E2DF", hash_generated_method = "381C3C055A0109C1EF249AEA5FF2E149")
            public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/playlists");
            }

            
            public static final class Members implements AudioColumns {
                public static final String _ID = "_id";
                public static final String CONTENT_DIRECTORY = "members";
                public static final String AUDIO_ID = "audio_id";
                public static final String PLAYLIST_ID = "playlist_id";
                public static final String PLAY_ORDER = "play_order";
                public static final String DEFAULT_SORT_ORDER = PLAY_ORDER;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.241 -0400", hash_original_method = "96BDCFD6E7CB52F7223465A2D6EE9A74", hash_generated_method = "9010678E8195591DFDC953DE2DED9116")
                public static final Uri getContentUri(String volumeName,
                        long playlistId) {
                    return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                            + "/audio/playlists/" + playlistId + "/members");
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.241 -0400", hash_original_method = "9DA25B025FE28EC3AC4ACBCE0C1BFD50", hash_generated_method = "5034B493CD7750526DFD99DE63E751DD")
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

                
            }


            
        }


        
        public static final class Artists implements BaseColumns, ArtistColumns {
            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/artists";
            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/artist";
            public static final String DEFAULT_SORT_ORDER = ARTIST_KEY;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.241 -0400", hash_original_method = "FD66489C6245EC419D305AD593BAF7F8", hash_generated_method = "1694B6CD5E48801661ACBEE648621070")
            public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/artists");
            }

            
            public static final class Albums implements AlbumColumns {
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.241 -0400", hash_original_method = "C95690BA5A28FE2CD2430F02E3EC9539", hash_generated_method = "A56894B0FDB584F61C28239BC0137602")
                public static final Uri getContentUri(String volumeName,
                        long artistId) {
                    return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                            + "/audio/artists/" + artistId + "/albums");
                }

                
            }


            
        }


        
        public static final class Albums implements BaseColumns, AlbumColumns {
            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/albums";
            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/album";
            public static final String DEFAULT_SORT_ORDER = ALBUM_KEY;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.242 -0400", hash_original_method = "4BBBF90040E52C1783C62EF76D7CBADD", hash_generated_method = "6BE0A51081C5362D4920B43F3116DAF1")
            public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/albums");
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
        public static final String DEFAULT_SORT_ORDER = MediaColumns.DISPLAY_NAME;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.242 -0400", hash_original_method = "D33973CFD3614E757CA6971FCFC77D62", hash_generated_method = "522FA5EC19DCD037B3DD1291CCDDFA1F")
        public static final Cursor query(ContentResolver cr, Uri uri, String[] projection) {
            return cr.query(uri, projection, null, null, DEFAULT_SORT_ORDER);
        }

        
        public static final class Media implements VideoColumns {
            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/video";
            public static final String DEFAULT_SORT_ORDER = TITLE;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.242 -0400", hash_original_method = "62F44913137B8C4A13A1C32E412D06B5", hash_generated_method = "C4FC987BE0CBD99859AFF3DB34B45299")
            public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/video/media");
            }

            
        }


        
        public static class Thumbnails implements BaseColumns {
            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            public static final String DEFAULT_SORT_ORDER = "video_id ASC";
            public static final String DATA = "_data";
            public static final String VIDEO_ID = "video_id";
            public static final String KIND = "kind";
            public static final int MINI_KIND = 1;
            public static final int FULL_SCREEN_KIND = 2;
            public static final int MICRO_KIND = 3;
            public static final String WIDTH = "width";
            public static final String HEIGHT = "height";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.242 -0400", hash_original_method = "1F04B09633BC6FD3251DA0AD2BE516F3", hash_generated_method = "983E9B9D79C85DB2DD69AA68A9F3DB51")
            public static void cancelThumbnailRequest(ContentResolver cr, long origId) {
                InternalThumbnails.cancelThumbnailRequest(cr, origId, EXTERNAL_CONTENT_URI,
                        InternalThumbnails.DEFAULT_GROUP_ID);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.242 -0400", hash_original_method = "172FCB0110A1F99EBF930D5E744C7BE9", hash_generated_method = "6465FE82FEED7285B8536C3A4981C6CB")
            public static Bitmap getThumbnail(ContentResolver cr, long origId, int kind,
                    BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(cr, origId,
                        InternalThumbnails.DEFAULT_GROUP_ID, kind, options,
                        EXTERNAL_CONTENT_URI, true);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.242 -0400", hash_original_method = "0DF93B55084418555A720C042FA08001", hash_generated_method = "3D9177C741CFED1C5A49D925F38B9A2D")
            public static Bitmap getThumbnail(ContentResolver cr, long origId, long groupId,
                    int kind, BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(cr, origId, groupId, kind, options,
                        EXTERNAL_CONTENT_URI, true);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.243 -0400", hash_original_method = "9AAEF167BAB79AB4F88321224520B47D", hash_generated_method = "D1446C5613D089036ABDE6782BA7A84D")
            public static void cancelThumbnailRequest(ContentResolver cr, long origId, long groupId) {
                InternalThumbnails.cancelThumbnailRequest(cr, origId, EXTERNAL_CONTENT_URI, groupId);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.243 -0400", hash_original_method = "15FBBC3EA73486A6D659DC0927D4EC42", hash_generated_method = "BAAF5B7DAD7F5A3186DA6B6DBF384D60")
            public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/video/thumbnails");
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
    
}


