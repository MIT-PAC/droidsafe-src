package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.412 -0400", hash_original_method = "463B9D094169FDB0633EE291129364D2", hash_generated_method = "463B9D094169FDB0633EE291129364D2")
    public MediaStore ()
    {
        //Synthesized constructor
    }


        public static Uri getMediaScannerUri() {
        return Uri.parse(CONTENT_AUTHORITY_SLASH + "none/media_scanner");
    }

    
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.413 -0400", hash_original_method = "92603C48FC2D95D83FC45AFBA8CE46C5", hash_generated_method = "92603C48FC2D95D83FC45AFBA8CE46C5")
        public Files ()
        {
            //Synthesized constructor
        }


                public static Uri getContentUri(String volumeName) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                    "/file");
        }

        
                public static final Uri getContentUri(String volumeName,
                long rowId) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                    + "/file/" + rowId);
        }

        
                public static Uri getMtpObjectsUri(String volumeName) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                    "/object");
        }

        
                public static final Uri getMtpObjectsUri(String volumeName,
                long fileId) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                    + "/object/" + fileId);
        }

        
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.413 -0400", hash_original_method = "B538DEE370A2D5B0ED2152EA1CB2C251", hash_generated_method = "B538DEE370A2D5B0ED2152EA1CB2C251")
        public InternalThumbnails ()
        {
            //Synthesized constructor
        }


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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.414 -0400", hash_original_field = "86BB24EA9B9FBBBCF2150F37EF9B1916", hash_generated_field = "F1B2DCDB4D650E7562CCD24C7413239D")

        private static final int MINI_KIND = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.414 -0400", hash_original_field = "F0B1111C9C9BC310F2F7201792E2DF93", hash_generated_field = "528D339F12DE56917828F7FCAF7982C0")

        private static final int FULL_SCREEN_KIND = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.414 -0400", hash_original_field = "9AB923142D918EADF946D75CF9101595", hash_generated_field = "90F2A2712808066B51263DD7FB1B1780")

        private static final int MICRO_KIND = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.414 -0400", hash_original_field = "4DEBAF48445726B7090832553F36809E", hash_generated_field = "29B2B6BAF49B801FB32E186C3BC159CD")

        private static final String[] PROJECTION = new String[] {_ID, MediaColumns.DATA};
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.414 -0400", hash_original_field = "92A2B399CC7E44930E4A8E45F6984AE5", hash_generated_field = "BF5200770C239590998D8302DE616555")

        static final int DEFAULT_GROUP_ID = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.414 -0400", hash_original_field = "742A3DD9A153311B6B50FEEF370CBE85", hash_generated_field = "EFA5E9100500815C37703B7F5AF9081E")

        private static final Object sThumbBufLock = new Object();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.414 -0400", hash_original_field = "76D3B5D860F60F5C905AB52729B04F05", hash_generated_field = "4E95DEC378A5C2690E58198734A359AE")

        private static byte[] sThumbBuf;
    }


    
    public static final class Images {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.414 -0400", hash_original_method = "A3CD75F6AB055CA56651293CB087C6D5", hash_generated_method = "A3CD75F6AB055CA56651293CB087C6D5")
        public Images ()
        {
            //Synthesized constructor
        }


        public static final class Media implements ImageColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.414 -0400", hash_original_method = "AABF7D5402BFD519F4DA876621C956DE", hash_generated_method = "AABF7D5402BFD519F4DA876621C956DE")
            public Media ()
            {
                //Synthesized constructor
            }


                        public static final Cursor query(ContentResolver cr, Uri uri, String[] projection) {
                return cr.query(uri, projection, null, null, DEFAULT_SORT_ORDER);
            }

            
                        public static final Cursor query(ContentResolver cr, Uri uri, String[] projection,
                    String where, String orderBy) {
                return cr.query(uri, projection, where,
                                             null, orderBy == null ? DEFAULT_SORT_ORDER : orderBy);
            }

            
                        public static final Cursor query(ContentResolver cr, Uri uri, String[] projection,
                    String selection, String [] selectionArgs, String orderBy) {
                return cr.query(uri, projection, selection,
                        selectionArgs, orderBy == null ? DEFAULT_SORT_ORDER : orderBy);
            }

            
                        public static final Bitmap getBitmap(ContentResolver cr, Uri url) throws FileNotFoundException, IOException {
                InputStream input = cr.openInputStream(url);
                Bitmap bitmap = BitmapFactory.decodeStream(input);
                input.close();
                return bitmap;
            }

            
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

            
                        public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/images/media");
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.415 -0400", hash_original_field = "B4CA71E6A6DABB62CF00BA6BA06DF1F6", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.415 -0400", hash_original_field = "6BB27CAB940C3235D66FE1017AB8E95E", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.415 -0400", hash_original_field = "C0199BC5A4DF9BD7520B391EB4963FCA", hash_generated_field = "D7278D58DCCF3AFCDABD397E23995D1D")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/image";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.415 -0400", hash_original_field = "939A3643F974445C4F2248C9A8078B83", hash_generated_field = "D1EC0DF370F9CCDEE096DFD36593C492")

            public static final String DEFAULT_SORT_ORDER = ImageColumns.BUCKET_DISPLAY_NAME;
        }


        
        public static class Thumbnails implements BaseColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.416 -0400", hash_original_method = "CEC4957051438E94FE667AB7B98C828F", hash_generated_method = "CEC4957051438E94FE667AB7B98C828F")
            public Thumbnails ()
            {
                //Synthesized constructor
            }


                        public static final Cursor query(ContentResolver cr, Uri uri, String[] projection) {
                return cr.query(uri, projection, null, null, DEFAULT_SORT_ORDER);
            }

            
                        public static final Cursor queryMiniThumbnails(ContentResolver cr, Uri uri, int kind,
                    String[] projection) {
                return cr.query(uri, projection, "kind = " + kind, null, DEFAULT_SORT_ORDER);
            }

            
                        public static final Cursor queryMiniThumbnail(ContentResolver cr, long origId, int kind,
                    String[] projection) {
                return cr.query(EXTERNAL_CONTENT_URI, projection,
                        IMAGE_ID + " = " + origId + " AND " + KIND + " = " +
                        kind, null, null);
            }

            
                        public static void cancelThumbnailRequest(ContentResolver cr, long origId) {
                InternalThumbnails.cancelThumbnailRequest(cr, origId, EXTERNAL_CONTENT_URI,
                        InternalThumbnails.DEFAULT_GROUP_ID);
            }

            
                        public static Bitmap getThumbnail(ContentResolver cr, long origId, int kind,
                    BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(cr, origId,
                        InternalThumbnails.DEFAULT_GROUP_ID, kind, options,
                        EXTERNAL_CONTENT_URI, false);
            }

            
                        public static void cancelThumbnailRequest(ContentResolver cr, long origId, long groupId) {
                InternalThumbnails.cancelThumbnailRequest(cr, origId, EXTERNAL_CONTENT_URI, groupId);
            }

            
                        public static Bitmap getThumbnail(ContentResolver cr, long origId, long groupId,
                    int kind, BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(cr, origId, groupId, kind, options,
                        EXTERNAL_CONTENT_URI, false);
            }

            
                        public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/images/thumbnails");
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.416 -0400", hash_original_field = "B4CA71E6A6DABB62CF00BA6BA06DF1F6", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.416 -0400", hash_original_field = "6BB27CAB940C3235D66FE1017AB8E95E", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.416 -0400", hash_original_field = "DA2DA563BEF05D1D2333009DF76B4BAB", hash_generated_field = "201F7D4B8AAD2124C6E2FB0F7E0E0501")

            public static final String DEFAULT_SORT_ORDER = "image_id ASC";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.416 -0400", hash_original_field = "1DA2383FC2FFA0E5D2654EA151089BF3", hash_generated_field = "A66DA404DB529637DF4981C792367756")

            public static final String DATA = "_data";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.416 -0400", hash_original_field = "044F6187080038BC94F83783D30BF85A", hash_generated_field = "4C4192B03F8FCBB7BDBCB8BE2736E4B7")

            public static final String IMAGE_ID = "image_id";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.416 -0400", hash_original_field = "5C4A1F77A7D94E0CAF07EEC33B2F1286", hash_generated_field = "C4772988085372FF3551CC4315A50E0B")

            public static final String KIND = "kind";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.416 -0400", hash_original_field = "86BB24EA9B9FBBBCF2150F37EF9B1916", hash_generated_field = "99CE8D50C31FD4187F2F339D8B9B48C7")

            public static final int MINI_KIND = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.417 -0400", hash_original_field = "F0B1111C9C9BC310F2F7201792E2DF93", hash_generated_field = "8C0560965409D5FE4F991B1D52B6B6A8")

            public static final int FULL_SCREEN_KIND = 2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.417 -0400", hash_original_field = "9AB923142D918EADF946D75CF9101595", hash_generated_field = "623F298E957ADDE8E0DCD7F12E785698")

            public static final int MICRO_KIND = 3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.417 -0400", hash_original_field = "83284FE5FE0753306FD4EBC19524D50E", hash_generated_field = "2779A363AF0116D23A35D20CEC14443A")

            public static final String THUMB_DATA = "thumb_data";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.417 -0400", hash_original_field = "CE07B77F3FD4244A5F7485F0D4C17B45", hash_generated_field = "FE9CB65DA5AC820EB66328B1E325F141")

            public static final String WIDTH = "width";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.417 -0400", hash_original_field = "58A8FFDB42E31B05F5E0AA01DBD77A10", hash_generated_field = "A6B1CAF6BB48877DB47F660C1A4B4504")

            public static final String HEIGHT = "height";
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.417 -0400", hash_original_method = "553D011F7A7937C6B31A2ECF0083B637", hash_generated_method = "553D011F7A7937C6B31A2ECF0083B637")
        public Audio ()
        {
            //Synthesized constructor
        }


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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.417 -0400", hash_original_method = "AABF7D5402BFD519F4DA876621C956DE", hash_generated_method = "AABF7D5402BFD519F4DA876621C956DE")
            public Media ()
            {
                //Synthesized constructor
            }


                        public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/media");
            }

            
                        public static Uri getContentUriForPath(String path) {
                return (path.startsWith(Environment.getExternalStorageDirectory().getPath()) ?
                        EXTERNAL_CONTENT_URI : INTERNAL_CONTENT_URI);
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.417 -0400", hash_original_field = "B4CA71E6A6DABB62CF00BA6BA06DF1F6", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.417 -0400", hash_original_field = "6BB27CAB940C3235D66FE1017AB8E95E", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.417 -0400", hash_original_field = "790974CF03A7A2442F98A04BEB043705", hash_generated_field = "5DFF3EF904D1B5DFDB7238BA1EF13627")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/audio";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.417 -0400", hash_original_field = "AB13DAE5B15ED75CB9A148DE80A5C576", hash_generated_field = "9CA0957FE990E6612A17A5ADC5B5AF40")

            public static final String DEFAULT_SORT_ORDER = TITLE_KEY;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.418 -0400", hash_original_field = "24B146D7FE1D328C2E5E05032C389317", hash_generated_field = "98FCF6EE0488D8931189FA8705E80FB7")

            public static final String RECORD_SOUND_ACTION =
                    "android.provider.MediaStore.RECORD_SOUND";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.418 -0400", hash_original_field = "BEAEC5678AF195F54B9032A918AFD461", hash_generated_field = "16C267F4F82A95E267906C622A2EEAA6")

            public static final String EXTRA_MAX_BYTES =
                    "android.provider.MediaStore.extra.MAX_BYTES";
        }


        
        public static final class Genres implements BaseColumns, GenresColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.418 -0400", hash_original_method = "5A301F51AFE295226C0A121512898093", hash_generated_method = "5A301F51AFE295226C0A121512898093")
            public Genres ()
            {
                //Synthesized constructor
            }


                        public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/genres");
            }

            
                        public static Uri getContentUriForAudioId(String volumeName, int audioId) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/media/" + audioId + "/genres");
            }

            
            public static final class Members implements AudioColumns {
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.418 -0400", hash_original_method = "A4C48D9C87FE7EE1DA0DC145BA44FFAF", hash_generated_method = "A4C48D9C87FE7EE1DA0DC145BA44FFAF")
                public Members ()
                {
                    //Synthesized constructor
                }


                                public static final Uri getContentUri(String volumeName,
                        long genreId) {
                    return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                            + "/audio/genres/" + genreId + "/members");
                }

                
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.418 -0400", hash_original_field = "D46E914A8CFDE411714424962678DE60", hash_generated_field = "DB7ADB2B4AB00C495BEDDDD281A9FEA3")

                public static final String CONTENT_DIRECTORY = "members";
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.418 -0400", hash_original_field = "AB13DAE5B15ED75CB9A148DE80A5C576", hash_generated_field = "9CA0957FE990E6612A17A5ADC5B5AF40")

                public static final String DEFAULT_SORT_ORDER = TITLE_KEY;
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.418 -0400", hash_original_field = "F48A44710BB263A5D7C9A6B38C638850", hash_generated_field = "382D7EB918B49C78EB06492C73BC97FB")

                public static final String AUDIO_ID = "audio_id";
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.418 -0400", hash_original_field = "EC4403C5CAFB8C8E406078FA89B6559D", hash_generated_field = "39198E92E9A65D017CA1639585E0DF84")

                public static final String GENRE_ID = "genre_id";
            }


            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.418 -0400", hash_original_field = "B4CA71E6A6DABB62CF00BA6BA06DF1F6", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.418 -0400", hash_original_field = "6BB27CAB940C3235D66FE1017AB8E95E", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.418 -0400", hash_original_field = "A0D60D946B18B4F268B6018989EE4B99", hash_generated_field = "E1B6CFD623C2263B7E469FD88BCF8D69")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/genre";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.418 -0400", hash_original_field = "7062B818241D9D146326FB2D3C4D4BE7", hash_generated_field = "2B7DC59AF9446FD67FDE51146B04B78B")

            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/genre";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.418 -0400", hash_original_field = "DF4A7F1A332196E8DE5F535A48CC15E8", hash_generated_field = "A2FB1268F0AAE758649FA6BFE2C4E5D6")

            public static final String DEFAULT_SORT_ORDER = NAME;
        }


        
        public static final class Playlists implements BaseColumns, PlaylistsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.418 -0400", hash_original_method = "74E3D69F5F937E9AFBC239AC6178742A", hash_generated_method = "74E3D69F5F937E9AFBC239AC6178742A")
            public Playlists ()
            {
                //Synthesized constructor
            }


                        public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/playlists");
            }

            
            public static final class Members implements AudioColumns {
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.419 -0400", hash_original_method = "A4C48D9C87FE7EE1DA0DC145BA44FFAF", hash_generated_method = "A4C48D9C87FE7EE1DA0DC145BA44FFAF")
                public Members ()
                {
                    //Synthesized constructor
                }


                                public static final Uri getContentUri(String volumeName,
                        long playlistId) {
                    return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                            + "/audio/playlists/" + playlistId + "/members");
                }

                
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

                
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.419 -0400", hash_original_field = "1D76A1C4932B9BE76F07C85A41B71D02", hash_generated_field = "B34A1444880FA153E0220CFB867105F7")

                public static final String _ID = "_id";
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.419 -0400", hash_original_field = "D46E914A8CFDE411714424962678DE60", hash_generated_field = "DB7ADB2B4AB00C495BEDDDD281A9FEA3")

                public static final String CONTENT_DIRECTORY = "members";
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.419 -0400", hash_original_field = "F48A44710BB263A5D7C9A6B38C638850", hash_generated_field = "382D7EB918B49C78EB06492C73BC97FB")

                public static final String AUDIO_ID = "audio_id";
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.419 -0400", hash_original_field = "9181E709002D2BA8E125631575B558A1", hash_generated_field = "8B99B390580EC4D8EC34CC087D44092D")

                public static final String PLAYLIST_ID = "playlist_id";
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.419 -0400", hash_original_field = "E6B58ACA1379DD2A910CED94E5CCA2F5", hash_generated_field = "6C3FE81A0BACA3DA560AAD1D806E9D96")

                public static final String PLAY_ORDER = "play_order";
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.419 -0400", hash_original_field = "49E240684255848107C13083258B8240", hash_generated_field = "A8F59651FB55C4C2E1DD16A17470594E")

                public static final String DEFAULT_SORT_ORDER = PLAY_ORDER;
            }


            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.419 -0400", hash_original_field = "B4CA71E6A6DABB62CF00BA6BA06DF1F6", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.419 -0400", hash_original_field = "6BB27CAB940C3235D66FE1017AB8E95E", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.419 -0400", hash_original_field = "FA421BBB49A245517B454B7D5164E557", hash_generated_field = "7886ED7A80A0EA66150F49DF90C591DC")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/playlist";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.419 -0400", hash_original_field = "FEAA5A714B717E16B55D875B600AAAC5", hash_generated_field = "A3425404F8D772BE71E2B6C9EAD1785A")

            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/playlist";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.419 -0400", hash_original_field = "DF4A7F1A332196E8DE5F535A48CC15E8", hash_generated_field = "A2FB1268F0AAE758649FA6BFE2C4E5D6")

            public static final String DEFAULT_SORT_ORDER = NAME;
        }


        
        public static final class Artists implements BaseColumns, ArtistColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.419 -0400", hash_original_method = "5A569BA5E9300E73D18EF84988BF2B4D", hash_generated_method = "5A569BA5E9300E73D18EF84988BF2B4D")
            public Artists ()
            {
                //Synthesized constructor
            }


                        public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/artists");
            }

            
            public static final class Albums implements AlbumColumns {
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.420 -0400", hash_original_method = "7EBF89799AE4644EBE85B32B12FD367D", hash_generated_method = "7EBF89799AE4644EBE85B32B12FD367D")
                public Albums ()
                {
                    //Synthesized constructor
                }


                                public static final Uri getContentUri(String volumeName,
                        long artistId) {
                    return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName
                            + "/audio/artists/" + artistId + "/albums");
                }

                
            }


            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.420 -0400", hash_original_field = "B4CA71E6A6DABB62CF00BA6BA06DF1F6", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.420 -0400", hash_original_field = "6BB27CAB940C3235D66FE1017AB8E95E", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.420 -0400", hash_original_field = "0E595BB54891C827453B49DE1ED8919A", hash_generated_field = "4D2C185FD5D3770BBB496266841B2798")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/artists";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.420 -0400", hash_original_field = "71FCADE44973F58BD05B795F8E708B03", hash_generated_field = "98400472C82334F395927F8E1AEF2AEB")

            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/artist";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.420 -0400", hash_original_field = "853E24A760A5E967308572644AC40856", hash_generated_field = "332893369A4BBA52F86F1E98B47F7C33")

            public static final String DEFAULT_SORT_ORDER = ARTIST_KEY;
        }


        
        public static final class Albums implements BaseColumns, AlbumColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.420 -0400", hash_original_method = "7EBF89799AE4644EBE85B32B12FD367D", hash_generated_method = "7EBF89799AE4644EBE85B32B12FD367D")
            public Albums ()
            {
                //Synthesized constructor
            }


                        public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/audio/albums");
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.420 -0400", hash_original_field = "B4CA71E6A6DABB62CF00BA6BA06DF1F6", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.420 -0400", hash_original_field = "6BB27CAB940C3235D66FE1017AB8E95E", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.420 -0400", hash_original_field = "6E244DA9008EB36DFDAD749717F23FBA", hash_generated_field = "5B57B84C208FF887BC56BE52F5F242A8")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/albums";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.420 -0400", hash_original_field = "14B70FEC6D53B0C92EAAC8795D30A159", hash_generated_field = "AD71577E74C0A9EDD832620AE0172EC4")

            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/album";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.420 -0400", hash_original_field = "E5E6826E5577AAD65C81D3D2F681757F", hash_generated_field = "379F25D8A8F63DE3CF34DAC50E06B398")

            public static final String DEFAULT_SORT_ORDER = ALBUM_KEY;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.420 -0400", hash_original_method = "8FC1394ED845BB72BFE890B41D7CAD7E", hash_generated_method = "8FC1394ED845BB72BFE890B41D7CAD7E")
        public Video ()
        {
            //Synthesized constructor
        }


                public static final Cursor query(ContentResolver cr, Uri uri, String[] projection) {
            return cr.query(uri, projection, null, null, DEFAULT_SORT_ORDER);
        }

        
        public static final class Media implements VideoColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.421 -0400", hash_original_method = "AABF7D5402BFD519F4DA876621C956DE", hash_generated_method = "AABF7D5402BFD519F4DA876621C956DE")
            public Media ()
            {
                //Synthesized constructor
            }


                        public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/video/media");
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.421 -0400", hash_original_field = "B4CA71E6A6DABB62CF00BA6BA06DF1F6", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.421 -0400", hash_original_field = "6BB27CAB940C3235D66FE1017AB8E95E", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.421 -0400", hash_original_field = "406C33AF4AF6B66DE577C80910936503", hash_generated_field = "D9F9D24ED20803B056D0DA2161C944E7")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/video";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.421 -0400", hash_original_field = "5BAEEEFEE52A23EB50FF8B763BB44595", hash_generated_field = "F1AD81D67BCA33411A74FB57B6D6FE7D")

            public static final String DEFAULT_SORT_ORDER = TITLE;
        }


        
        public static class Thumbnails implements BaseColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.421 -0400", hash_original_method = "CEC4957051438E94FE667AB7B98C828F", hash_generated_method = "CEC4957051438E94FE667AB7B98C828F")
            public Thumbnails ()
            {
                //Synthesized constructor
            }


                        public static void cancelThumbnailRequest(ContentResolver cr, long origId) {
                InternalThumbnails.cancelThumbnailRequest(cr, origId, EXTERNAL_CONTENT_URI,
                        InternalThumbnails.DEFAULT_GROUP_ID);
            }

            
                        public static Bitmap getThumbnail(ContentResolver cr, long origId, int kind,
                    BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(cr, origId,
                        InternalThumbnails.DEFAULT_GROUP_ID, kind, options,
                        EXTERNAL_CONTENT_URI, true);
            }

            
                        public static Bitmap getThumbnail(ContentResolver cr, long origId, long groupId,
                    int kind, BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(cr, origId, groupId, kind, options,
                        EXTERNAL_CONTENT_URI, true);
            }

            
                        public static void cancelThumbnailRequest(ContentResolver cr, long origId, long groupId) {
                InternalThumbnails.cancelThumbnailRequest(cr, origId, EXTERNAL_CONTENT_URI, groupId);
            }

            
                        public static Uri getContentUri(String volumeName) {
                return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName +
                        "/video/thumbnails");
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.421 -0400", hash_original_field = "B4CA71E6A6DABB62CF00BA6BA06DF1F6", hash_generated_field = "B03D2FDF8E9CE307F35F0543471D4078")

            public static final Uri INTERNAL_CONTENT_URI =
                    getContentUri("internal");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.421 -0400", hash_original_field = "6BB27CAB940C3235D66FE1017AB8E95E", hash_generated_field = "FBB5C806FDA043F5F0D49E4B0E043B06")

            public static final Uri EXTERNAL_CONTENT_URI =
                    getContentUri("external");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.421 -0400", hash_original_field = "B7FCADEE7F0EC02CA6F285CA094C35EF", hash_generated_field = "A5388A3303EC2C70E303BC1733345832")

            public static final String DEFAULT_SORT_ORDER = "video_id ASC";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "1DA2383FC2FFA0E5D2654EA151089BF3", hash_generated_field = "A66DA404DB529637DF4981C792367756")

            public static final String DATA = "_data";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "E293470BEBEDD4BB46B4AD98A800F424", hash_generated_field = "C16F73320C40AC771DE6456ABC479D42")

            public static final String VIDEO_ID = "video_id";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "5C4A1F77A7D94E0CAF07EEC33B2F1286", hash_generated_field = "C4772988085372FF3551CC4315A50E0B")

            public static final String KIND = "kind";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "86BB24EA9B9FBBBCF2150F37EF9B1916", hash_generated_field = "99CE8D50C31FD4187F2F339D8B9B48C7")

            public static final int MINI_KIND = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "F0B1111C9C9BC310F2F7201792E2DF93", hash_generated_field = "8C0560965409D5FE4F991B1D52B6B6A8")

            public static final int FULL_SCREEN_KIND = 2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "9AB923142D918EADF946D75CF9101595", hash_generated_field = "623F298E957ADDE8E0DCD7F12E785698")

            public static final int MICRO_KIND = 3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "CE07B77F3FD4244A5F7485F0D4C17B45", hash_generated_field = "FE9CB65DA5AC820EB66328B1E325F141")

            public static final String WIDTH = "width";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "58A8FFDB42E31B05F5E0AA01DBD77A10", hash_generated_field = "A6B1CAF6BB48877DB47F660C1A4B4504")

            public static final String HEIGHT = "height";
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
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "E0A47896DEB3EFCAA0754EC9CF7029B0", hash_generated_field = "A72EF801920E6D0FBCC298B3F48750D9")

        public static final String DEFAULT_SORT_ORDER = MediaColumns.DISPLAY_NAME;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "C8002D2138131AF4063F90C8D5E799E9", hash_generated_field = "2728F4DF8F6CC34C57214DE271030F14")

    private final static String TAG = "MediaStore";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "DEE8B069CA82B2649B001D40126EC1E6", hash_generated_field = "A7DFC8694D3D0E7657229CD0FFF5B630")

    public static final String AUTHORITY = "media";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "986BBAE6D3E285B3AEE548565E838BB1", hash_generated_field = "027422C86865920C2F404F289EE08DA8")

    private static final String CONTENT_AUTHORITY_SLASH = "content://" + AUTHORITY + "/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "D0495468C95E05AA50AC20A66C056AA9", hash_generated_field = "4AC3ACCC87E038F10B80832F5408B1BC")

    public static final String ACTION_MTP_SESSION_END = "android.provider.action.MTP_SESSION_END";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "928C91FEA98EEAA58A48D210083D3F9A", hash_generated_field = "E09B7FA4C274836F20284B58798CF9B5")

    @Deprecated
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String INTENT_ACTION_MUSIC_PLAYER = "android.intent.action.MUSIC_PLAYER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "8B0F7E457FFF9F2F29066B28191F6C50", hash_generated_field = "14E225D86AD9F750F07ABB2CC0A1F78B")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String INTENT_ACTION_MEDIA_SEARCH = "android.intent.action.MEDIA_SEARCH";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "50276D3F81AC9A9022B5EBBB75A410CD", hash_generated_field = "BCF79BCDD2A8D0223693A47E87B3FB87")

    public static final String INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH =
            "android.media.action.MEDIA_PLAY_FROM_SEARCH";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "5D04B864959661DF078FA09360DC451B", hash_generated_field = "8C6545564FADA5903D0948466EC12557")

    public static final String EXTRA_MEDIA_ARTIST = "android.intent.extra.artist";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "27E1E7EE4D2BEF605C6F2D89F8D02BAA", hash_generated_field = "C980456F9DD94096B28012B67800926D")

    public static final String EXTRA_MEDIA_ALBUM = "android.intent.extra.album";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.422 -0400", hash_original_field = "58F3D469A06C1604FCF3035819394099", hash_generated_field = "4792CF25AC338288960AFE12B613D6A2")

    public static final String EXTRA_MEDIA_TITLE = "android.intent.extra.title";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "3CB914AB0F7A8D4324FD372342599B09", hash_generated_field = "72D132B1C5F6D2B7078ED4AB0F036952")

    public static final String EXTRA_MEDIA_FOCUS = "android.intent.extra.focus";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "B21783E1062C0672256FF81218DF12D0", hash_generated_field = "EFE407D2F32BF5ADCB7717684CF92CC6")

    public static final String EXTRA_SCREEN_ORIENTATION = "android.intent.extra.screenOrientation";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "DAE10EA90A9539BD465CA188CD9EE282", hash_generated_field = "A5DBF907AD5A6EC1A25F8010D89A1B12")

    public static final String EXTRA_FULL_SCREEN = "android.intent.extra.fullScreen";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "3D93C2C0F299114A7BDD15BB5105E69E", hash_generated_field = "8B2470F342CF29E36A8468DA20BB144A")

    public static final String EXTRA_SHOW_ACTION_ICONS = "android.intent.extra.showActionIcons";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "2226B7DA19085C227A76D6B589B3B116", hash_generated_field = "832680E96220C6307238C134A8AAF73F")

    public static final String EXTRA_FINISH_ON_COMPLETION = "android.intent.extra.finishOnCompletion";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "6F9604608D02C9AA1EF828AA3AAD46B1", hash_generated_field = "860A7DFD760F4321420148084D173747")

    public static final String INTENT_ACTION_STILL_IMAGE_CAMERA = "android.media.action.STILL_IMAGE_CAMERA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "149F172BB5932F0ECAF0612E37EB7FA9", hash_generated_field = "733F786611D450A0A68A4EF7B2D3BFFF")

    public static final String INTENT_ACTION_VIDEO_CAMERA = "android.media.action.VIDEO_CAMERA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "1EB0708295D1D32B4371EA2394CA9DC4", hash_generated_field = "EB213F3388033EA8ACC753E0170748C0")

    public final static String ACTION_IMAGE_CAPTURE = "android.media.action.IMAGE_CAPTURE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "A5FD1F86CE92B39EBA46E298D4A3C51A", hash_generated_field = "5914F06B7133898D3EB0FE683B022154")

    public final static String ACTION_VIDEO_CAPTURE = "android.media.action.VIDEO_CAPTURE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "06956D925F6F7484F3B6C33AED08F331", hash_generated_field = "FE0F2F344BEEED50C4B9B25035AD566A")

    public final static String EXTRA_VIDEO_QUALITY = "android.intent.extra.videoQuality";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "3A64C7585A64AF9CF4FF3F4BA32A601E", hash_generated_field = "58265C65BBD1D2C4DE9D186B226EF361")

    public final static String EXTRA_SIZE_LIMIT = "android.intent.extra.sizeLimit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "DFBB96F667A37C434E2350A86CD8A6F6", hash_generated_field = "4885F3925500336C9B74AD82F9F8B38E")

    public final static String EXTRA_DURATION_LIMIT = "android.intent.extra.durationLimit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "06585FC0D3A19A51DA603CAC4D3D4F3F", hash_generated_field = "A7FA8BD777FCC1FECD1E96853C582359")

    public final static String EXTRA_OUTPUT = "output";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "F67AB1895B6F18E04CF94889A61746ED", hash_generated_field = "389D1922445E3024CFD51027EC75BBD6")

    public static final String UNKNOWN_STRING = "<unknown>";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "E66073E28FD82D757F62F3E6EA13E896", hash_generated_field = "7D2FACD66491E00572801F8C8B9C6463")

    public static final String MEDIA_SCANNER_VOLUME = "volume";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.423 -0400", hash_original_field = "3F855865F9729329F0756F4990B9397D", hash_generated_field = "6FCA486A7CA08615D278EDF15EB8B907")

    public static final String MEDIA_IGNORE_FILENAME = ".nomedia";
}

