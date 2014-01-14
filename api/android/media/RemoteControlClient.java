package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;

public class RemoteControlClient {

    /**
     *  Fast routine to go through an array of allowed keys and return whether the key is part
     *  of that array
     * @param key the key value
     * @param validKeys the array of valid keys for a given type
     * @return true if the key is part of the array, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.153 -0500", hash_original_method = "4A0DB7CDD8D20C21F04F248D2D66CAA9", hash_generated_method = "3E21B50F1D5A689AD570BCD1BFAD30C6")
    
private static boolean validTypeForKey(int key, int[] validKeys) {
        try {
            for (int i = 0 ; ; i++) {
                if (key == validKeys[i]) {
                    return true;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.918 -0500", hash_original_field = "E22E47E8FFC08F064AD196F239D78BDD", hash_generated_field = "2BE2B9C77FA549F039F405BEB17D9487")

    private final static String TAG = "RemoteControlClient";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.921 -0500", hash_original_field = "6159E93C4A023E06760DDE1E24E5263F", hash_generated_field = "F4D3F848A6E915802E08F3A2E5F1F53B")

    public final static int PLAYSTATE_STOPPED            = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.923 -0500", hash_original_field = "3DA0DF4889A81BD77048D42D99468104", hash_generated_field = "B88C1E8F7B840BB920E884E441877169")

    public final static int PLAYSTATE_PAUSED             = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.926 -0500", hash_original_field = "2DF25C64E9166AD1D2F31D2B53CDDEDD", hash_generated_field = "88F962CE51D407CF120388E614DE441E")

    public final static int PLAYSTATE_PLAYING            = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.928 -0500", hash_original_field = "7240323EBBBE244E39376B8054F63F3F", hash_generated_field = "3BE856E2C7FB5313A81FB5745940F465")

    public final static int PLAYSTATE_FAST_FORWARDING    = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.931 -0500", hash_original_field = "771BD5A02744EF0A57080CABE0608826", hash_generated_field = "DF462EA5CD01B99AD41758C41F4F8E63")

    public final static int PLAYSTATE_REWINDING          = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.934 -0500", hash_original_field = "2F39FB087F798E8EA3B531A918CAFFC2", hash_generated_field = "35E136D27B02C2075FEAF30610947F93")

    public final static int PLAYSTATE_SKIPPING_FORWARDS  = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.936 -0500", hash_original_field = "DC7388DD65D49A7F42AE8529BF358ACB", hash_generated_field = "66CB7FA527A0829DAAFBA60CE93D1385")

    public final static int PLAYSTATE_SKIPPING_BACKWARDS = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.938 -0500", hash_original_field = "AFAF8BD3E5F9A8DA7CD1E81FEDBE0A57", hash_generated_field = "CF7819B197FB94121B302B9141F6961C")

    public final static int PLAYSTATE_BUFFERING          = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.941 -0500", hash_original_field = "ED059DF863694A37EA8E2C925675994D", hash_generated_field = "6CAACC1CF95FAD80651991CB4C906A4D")

    public final static int PLAYSTATE_ERROR              = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.943 -0500", hash_original_field = "E431013F91395532CC0181AD1D95079B", hash_generated_field = "61319DA85C97420F017C045A9C1729C8")

    public final static int PLAYSTATE_NONE               = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.946 -0500", hash_original_field = "24A7BA8AD75D6BFFF8A3D2AE0E3DD869", hash_generated_field = "D9C2B7C797239CFADF59DF6E95F1B111")

    public final static int FLAG_KEY_MEDIA_PREVIOUS = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.949 -0500", hash_original_field = "3A34DDEF07A947F37D764775E986333F", hash_generated_field = "E60961DC3DFBE2A350F7E65CD95479FA")

    public final static int FLAG_KEY_MEDIA_REWIND = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.951 -0500", hash_original_field = "10D81DEBFDC5B25B467B55D94BAC3B2F", hash_generated_field = "C4AADE8FFD83074B2941C8BB305E5194")

    public final static int FLAG_KEY_MEDIA_PLAY = 1 << 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.954 -0500", hash_original_field = "B2E2A48447193CE2E9EFB7950FA941D0", hash_generated_field = "A50B60387E829EE960A6C24801483960")

    public final static int FLAG_KEY_MEDIA_PLAY_PAUSE = 1 << 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.957 -0500", hash_original_field = "1A8255712733CAE58873BD693566AAEA", hash_generated_field = "3037539F2A50CCC54FEF961DB8032CE3")

    public final static int FLAG_KEY_MEDIA_PAUSE = 1 << 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.959 -0500", hash_original_field = "4C791594D621D22CB5BB863725B8F5EA", hash_generated_field = "EB951276E4926A00C8B2D0185D744968")

    public final static int FLAG_KEY_MEDIA_STOP = 1 << 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.962 -0500", hash_original_field = "A40BF8CFE6CE428B085EFC1E483E947B", hash_generated_field = "727BB4258CAB824CD82070CC756209D0")

    public final static int FLAG_KEY_MEDIA_FAST_FORWARD = 1 << 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.965 -0500", hash_original_field = "D6CE591284C44F4CB225B911AEA655DA", hash_generated_field = "AA28402D84BB64B0BBA8663A9933668C")

    public final static int FLAG_KEY_MEDIA_NEXT = 1 << 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.968 -0500", hash_original_field = "55DA9E39A228781415C37CB6B83DAB88", hash_generated_field = "69F8ECB2680C2648C44FFD84EC8F50D3")

    public final static int FLAGS_KEY_MEDIA_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.970 -0500", hash_original_field = "9EFDE1B76B963D38A60973864F6DC1C8", hash_generated_field = "9E8AFBDC008F82D3058F352782A0E928")

    public final static int FLAG_INFORMATION_REQUEST_METADATA = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.973 -0500", hash_original_field = "B91643F1BD775667646F5B7F888E553F", hash_generated_field = "78AAB419BAA72EC0F3DF7F385ECF46E0")

    public final static int FLAG_INFORMATION_REQUEST_KEY_MEDIA = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.975 -0500", hash_original_field = "EA543F91046F53C1E0C98B15A20C9FAD", hash_generated_field = "3B5B3AE1258E6EDAA51221A3AED72F72")

    public final static int FLAG_INFORMATION_REQUEST_PLAYSTATE = 1 << 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.978 -0500", hash_original_field = "14993273CD22D5F283A9712134CB0E4A", hash_generated_field = "28B78930FAA93C3B508BFC7444D9B284")

    public final static int FLAG_INFORMATION_REQUEST_ALBUM_ART = 1 << 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.986 -0500", hash_original_field = "C601146C90701E3A7B0C92D4A446C090", hash_generated_field = "0FD52E847D577969F790EF01F30CA0E3")

    private static final int[] METADATA_KEYS_TYPE_STRING = {
        MediaMetadataRetriever.METADATA_KEY_ALBUM,
        MediaMetadataRetriever.METADATA_KEY_ALBUMARTIST,
        MediaMetadataRetriever.METADATA_KEY_TITLE,
        MediaMetadataRetriever.METADATA_KEY_ARTIST,
        MediaMetadataRetriever.METADATA_KEY_AUTHOR,
        MediaMetadataRetriever.METADATA_KEY_COMPILATION,
        MediaMetadataRetriever.METADATA_KEY_COMPOSER,
        MediaMetadataRetriever.METADATA_KEY_DATE,
        MediaMetadataRetriever.METADATA_KEY_GENRE,
        MediaMetadataRetriever.METADATA_KEY_TITLE,
        MediaMetadataRetriever.METADATA_KEY_WRITER };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.988 -0500", hash_original_field = "FCB31370F436C268F4C564FBC75B71C1", hash_generated_field = "C58FCF18F5F9EC50B35A59C6AC7F2853")

    private static final int[] METADATA_KEYS_TYPE_LONG = {
        MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER,
        MediaMetadataRetriever.METADATA_KEY_DISC_NUMBER,
        MediaMetadataRetriever.METADATA_KEY_DURATION };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.096 -0500", hash_original_field = "058C0A51BF09FFB24D96AF52AC8E1F71", hash_generated_field = "AACFB6D022148421C2F0C7D1E8331E7D")

    private final static int MSG_REQUEST_PLAYBACK_STATE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.098 -0500", hash_original_field = "62E60A0A32E2FBE0FF2C13EB57A06D0D", hash_generated_field = "04F84EAB3F4DEDCC1CA54ADDFD303582")

    private final static int MSG_REQUEST_METADATA = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.101 -0500", hash_original_field = "2624290044AED7467B5724DCBCEABFCF", hash_generated_field = "D37436C8088C6C0DD8728AB37ADE0846")

    private final static int MSG_REQUEST_TRANSPORTCONTROL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.103 -0500", hash_original_field = "01CE1389D1A3924C43716129ABB42833", hash_generated_field = "8B1638BE5F1799455DA931602163CF68")

    private final static int MSG_REQUEST_ARTWORK = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.106 -0500", hash_original_field = "732479C843AD0CB020B8A5E91D71F508", hash_generated_field = "92F3229CC0658FD8B22E0EDEA145897F")

    private final static int MSG_NEW_INTERNAL_CLIENT_GEN = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.109 -0500", hash_original_field = "2E46A1AF067AAB4AD15EA72C67A52961", hash_generated_field = "29900B94B2A6D2360A16D8FD28735F4E")

    private final static int MSG_NEW_CURRENT_CLIENT_GEN = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.112 -0500", hash_original_field = "093AFE698B5AAA44F7B27A16E3F80F9E", hash_generated_field = "E8EBAAC9849DE665CC38834147B90E01")

    private final static int MSG_PLUG_DISPLAY = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.114 -0500", hash_original_field = "6CAD6F879E7686E071B2F1BE0DF47AE3", hash_generated_field = "9A2D676D79FDA0EEDBD63F1D0F038755")

    private final static int MSG_UNPLUG_DISPLAY = 8;
    
    public class MetadataEditor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.010 -0500", hash_original_field = "798C73B48C1720DC8E87ACAC7237A8A4", hash_generated_field = "483347541B59F8DFA8B12B3C1A84C12D")

        public final static int BITMAP_KEY_ARTWORK = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.013 -0500", hash_original_field = "CF9F190073A64E67C9896B6B34E508C6", hash_generated_field = "B8846CA5BE8D5CB94BBEF3C2B4B1EC50")

        public final static int METADATA_KEY_ARTWORK = BITMAP_KEY_ARTWORK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.993 -0500", hash_original_field = "622108C3E9B8EFAF8ED6C5165A1A6ABC", hash_generated_field = "B4345E59801D3DC5F4E85DD85D29A43C")

        protected boolean mMetadataChanged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.995 -0500", hash_original_field = "C2BC508F235068F2A96D1F238CADD5F5", hash_generated_field = "ECD34150F8B85611F271E6014D9D883D")

        protected boolean mArtworkChanged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.997 -0500", hash_original_field = "8A39F1373D6A94D088EC79F3B656DA96", hash_generated_field = "0EF4A2673652F896972F4DB3B96FB334")

        protected Bitmap mEditorArtwork;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.000 -0500", hash_original_field = "903D0AF6CE9BFD67885C9AFA85CCBD5F", hash_generated_field = "85DB44FBC7E40E567386653DF585C1CB")

        protected Bundle mEditorMetadata;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.002 -0500", hash_original_field = "40BAEC93188E536D15CF2B2337719433", hash_generated_field = "FDEB24494AE0377307265E3205B5F5A1")

        private boolean mApplied = false;

        // only use RemoteControlClient.editMetadata() to get a MetadataEditor instance
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.005 -0500", hash_original_method = "35489133548A4653F80D8552B0E58378", hash_generated_method = "D23F08C438C4A5D443103A3BB522D763")
        
private MetadataEditor() { }
        /**
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.007 -0500", hash_original_method = "3FF219DE1407B1650498BA4CB70E771E", hash_generated_method = "141020EC3D770673B593D9DD4405C05B")
        
public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        /**
         * Adds textual information to be displayed.
         * Note that none of the information added after {@link #apply()} has been called,
         * will be displayed.
         * @param key The identifier of a the metadata field to set. Valid values are
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_ALBUM},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_ALBUMARTIST},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_TITLE},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_ARTIST},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_AUTHOR},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_COMPILATION},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_COMPOSER},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_DATE},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_GENRE},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_TITLE},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_WRITER}.
         * @param value The text for the given key, or {@code null} to signify there is no valid
         *      information for the field.
         * @return Returns a reference to the same MetadataEditor object, so you can chain put
         *      calls together.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.016 -0500", hash_original_method = "DC698BF42DF290A93E2069AFDF9D8834", hash_generated_method = "9D6C1D30EF87D2D281AFDF9C8033C1D2")
        
public synchronized MetadataEditor putString(int key, String value)
                throws IllegalArgumentException {
            if (mApplied) {
                Log.e(TAG, "Can't edit a previously applied MetadataEditor");
                return this;
            }
            if (!validTypeForKey(key, METADATA_KEYS_TYPE_STRING)) {
                throw(new IllegalArgumentException("Invalid type 'String' for key "+ key));
            }
            mEditorMetadata.putString(String.valueOf(key), value);
            mMetadataChanged = true;
            return this;
        }

        /**
         * Adds numerical information to be displayed.
         * Note that none of the information added after {@link #apply()} has been called,
         * will be displayed.
         * @param key the identifier of a the metadata field to set. Valid values are
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_CD_TRACK_NUMBER},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_DISC_NUMBER},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_DURATION} (with a value
         *      expressed in milliseconds),
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_YEAR}.
         * @param value The long value for the given key
         * @return Returns a reference to the same MetadataEditor object, so you can chain put
         *      calls together.
         * @throws IllegalArgumentException
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.018 -0500", hash_original_method = "59EE363FF7F9B37AD6A675925DC53A2A", hash_generated_method = "7524C4B555C421A3B5F0BEC02CB74913")
        
public synchronized MetadataEditor putLong(int key, long value)
                throws IllegalArgumentException {
            if (mApplied) {
                Log.e(TAG, "Can't edit a previously applied MetadataEditor");
                return this;
            }
            if (!validTypeForKey(key, METADATA_KEYS_TYPE_LONG)) {
                throw(new IllegalArgumentException("Invalid type 'long' for key "+ key));
            }
            mEditorMetadata.putLong(String.valueOf(key), value);
            mMetadataChanged = true;
            return this;
        }

        /**
         * Sets the album / artwork picture to be displayed on the remote control.
         * @param key the identifier of the bitmap to set. The only valid value is
         *      {@link #BITMAP_KEY_ARTWORK}
         * @param bitmap The bitmap for the artwork, or null if there isn't any.
         * @return Returns a reference to the same MetadataEditor object, so you can chain put
         *      calls together.
         * @throws IllegalArgumentException
         * @see android.graphics.Bitmap
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.021 -0500", hash_original_method = "392D9C0804150D161643AF9A81D31BAB", hash_generated_method = "9C23E08A2063112ACD30F380EDEEAC8E")
        
public synchronized MetadataEditor putBitmap(int key, Bitmap bitmap)
                throws IllegalArgumentException {
            if (mApplied) {
                Log.e(TAG, "Can't edit a previously applied MetadataEditor");
                return this;
            }
            if (key != BITMAP_KEY_ARTWORK) {
                throw(new IllegalArgumentException("Invalid type 'Bitmap' for key "+ key));
            }
            if ((mArtworkExpectedWidth > 0) && (mArtworkExpectedHeight > 0)) {
                mEditorArtwork = scaleBitmapIfTooBig(bitmap,
                        mArtworkExpectedWidth, mArtworkExpectedHeight);
            } else {
                // no valid resize dimensions, store as is
                mEditorArtwork = bitmap;
            }
            mArtworkChanged = true;
            return this;
        }

        /**
         * Clears all the metadata that has been set since the MetadataEditor instance was
         *     created with {@link RemoteControlClient#editMetadata(boolean)}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.024 -0500", hash_original_method = "0A0B775C77CB462F6342E4F76031A7F3", hash_generated_method = "9AAB45E22978F7BF8C40BB995418B766")
        
public synchronized void clear() {
            if (mApplied) {
                Log.e(TAG, "Can't clear a previously applied MetadataEditor");
                return;
            }
            mEditorMetadata.clear();
            mEditorArtwork = null;
        }

        /**
         * Associates all the metadata that has been set since the MetadataEditor instance was
         *     created with {@link RemoteControlClient#editMetadata(boolean)}, or since
         *     {@link #clear()} was called, with the RemoteControlClient. Once "applied",
         *     this MetadataEditor cannot be reused to edit the RemoteControlClient's metadata.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.027 -0500", hash_original_method = "93FD8866501AA3B03BDE4E693768AF3B", hash_generated_method = "82538244C7B6522AFFEF21087D840549")
        
public synchronized void apply() {
            if (mApplied) {
                Log.e(TAG, "Can't apply a previously applied MetadataEditor");
                return;
            }
            synchronized(mCacheLock) {
                // assign the edited data
                mMetadata = new Bundle(mEditorMetadata);
                if ((mArtwork != null) && (!mArtwork.equals(mEditorArtwork))) {
                    mArtwork.recycle();
                }
                mArtwork = mEditorArtwork;
                mEditorArtwork = null;
                if (mMetadataChanged & mArtworkChanged) {
                    // send to remote control display if conditions are met
                    sendMetadataWithArtwork_syncCacheLock();
                } else if (mMetadataChanged) {
                    // send to remote control display if conditions are met
                    sendMetadata_syncCacheLock();
                } else if (mArtworkChanged) {
                    // send to remote control display if conditions are met
                    sendArtwork_syncCacheLock();
                }
                mApplied = true;
            }
        }
    }
    
    private class EventHandler extends Handler {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.117 -0500", hash_original_method = "E835DA7FA2605C7661321C420AF4C36C", hash_generated_method = "A8646DD88D641F31D499C91D3ED39A40")
        
public EventHandler(RemoteControlClient rcc, Looper looper) {
            super(looper);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.120 -0500", hash_original_method = "7971FD8B56BD97CBBF08B4EAB35A2033", hash_generated_method = "8DE217EF37024822792FC27F1BF52A90")
        
@Override
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case MSG_REQUEST_PLAYBACK_STATE:
                    synchronized (mCacheLock) {
                        sendPlaybackState_syncCacheLock();
                    }
                    break;
                case MSG_REQUEST_METADATA:
                    synchronized (mCacheLock) {
                        sendMetadata_syncCacheLock();
                    }
                    break;
                case MSG_REQUEST_TRANSPORTCONTROL:
                    synchronized (mCacheLock) {
                        sendTransportControlFlags_syncCacheLock();
                    }
                    break;
                case MSG_REQUEST_ARTWORK:
                    synchronized (mCacheLock) {
                        sendArtwork_syncCacheLock();
                    }
                    break;
                case MSG_NEW_INTERNAL_CLIENT_GEN:
                    onNewInternalClientGen((Integer)msg.obj, msg.arg1, msg.arg2);
                    break;
                case MSG_NEW_CURRENT_CLIENT_GEN:
                    onNewCurrentClientGen(msg.arg1);
                    break;
                case MSG_PLUG_DISPLAY:
                    onPlugDisplay((IRemoteControlDisplay)msg.obj);
                    break;
                case MSG_UNPLUG_DISPLAY:
                    onUnplugDisplay((IRemoteControlDisplay)msg.obj);
                    break;
                default:
                    Log.e(TAG, "Unknown event " + msg.what + " in RemoteControlClient handler");
            }
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.041 -0500", hash_original_field = "D67B76FEB675AA6CF283F5022BA1C7D3", hash_generated_field = "84304313B5BE2FAF3B60D13295A73C77")

    private final Object mCacheLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.043 -0500", hash_original_field = "F04F146DFFBE1A936AF53FC8A346992B", hash_generated_field = "4614F38337BAA651A52883AEA4B73289")

    private int mPlaybackState = PLAYSTATE_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.045 -0500", hash_original_field = "38263EE2508C61CD923AB317CAEC020F", hash_generated_field = "1BEC69AD7A22658EBADD97D1E5E40CB0")

    private long mPlaybackStateChangeTimeMs = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.048 -0500", hash_original_field = "ED7F979BA2BA59712A41DB4AADC54B91", hash_generated_field = "BC9C836A2A56878C42A006AD06D23308")

    private Bitmap mArtwork;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.050 -0500", hash_original_field = "FF516E467D09A8E14E3821F122C223B3", hash_generated_field = "24B92185327A5356B945DB6DA2A8A474")

    private final int ARTWORK_DEFAULT_SIZE = 256;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.052 -0500", hash_original_field = "1CE1345DBD3D71CDD2DFC1CBD6D487F4", hash_generated_field = "897D986065A139967AB4500786131D84")

    private final int ARTWORK_INVALID_SIZE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.055 -0500", hash_original_field = "45DC732AB1CD126515BD6C07A428E232", hash_generated_field = "8965B25D9EB40BED14D87C783E89F3C5")

    private int mArtworkExpectedWidth = ARTWORK_DEFAULT_SIZE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.057 -0500", hash_original_field = "C28DC90AAB529B56E6F23D181113EFDD", hash_generated_field = "9A05CBDEF29D4A853B9AD874C4D29310")

    private int mArtworkExpectedHeight = ARTWORK_DEFAULT_SIZE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.059 -0500", hash_original_field = "2F98E79D6B1DD013C7751A7FEB56F3D3", hash_generated_field = "D886D0C4ACF243C5481BBD5AAC40B711")

    private int mTransportControlFlags = FLAGS_KEY_MEDIA_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.061 -0500", hash_original_field = "054167D3EF3FA02F61C449EC8EBE98A2", hash_generated_field = "DA6670A1846875744AFAE7AA4DEC9FDF")

    private Bundle mMetadata = new Bundle();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.064 -0500", hash_original_field = "121007215D74BDEA1A80A488684D35AD", hash_generated_field = "9EB4244C60785911067FC7413E2DE31B")

    private int mCurrentClientGenId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.066 -0500", hash_original_field = "BB478E8A062D1E115C20298ADBCFD276", hash_generated_field = "14D22A774763FE83A163754E1995815C")

    private int mInternalClientGenId = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.068 -0500", hash_original_field = "ABD800CAE01FE6B1027F1A977B19C1C2", hash_generated_field = "0D33962CDFCC7D569FC4E814D31B5DFB")

    private  PendingIntent mRcMediaIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.071 -0500", hash_original_field = "FF3481DE069C9A568B0BD73FBAC6FE4F", hash_generated_field = "6F5BD225EE2017EE2B9E17B1141913F9")

    private IRemoteControlDisplay mRcDisplay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.461 -0400", hash_original_field = "F4A07242D823C860C73942573E9A702C", hash_generated_field = "0B2C69CE4D7E8D199D2B2E2678BA8AC0")

    private IRemoteControlClient mIRCC = new IRemoteControlClient.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.460 -0400", hash_original_method = "F932B544DD1B5B88DDD0055B7C1D8F98", hash_generated_method = "8642A93D514E756D20B21B6324049341")
        public void onInformationRequested(int clientGeneration, int infoFlags,
                int artWidth, int artHeight) {
            
            {
                mEventHandler.removeMessages(MSG_NEW_INTERNAL_CLIENT_GEN);
                mEventHandler.dispatchMessage(
                        mEventHandler.obtainMessage(
                                MSG_NEW_INTERNAL_CLIENT_GEN,
                                artWidth, artHeight,
                                new Integer(clientGeneration)));
                mEventHandler.removeMessages(MSG_REQUEST_PLAYBACK_STATE);
                mEventHandler.removeMessages(MSG_REQUEST_METADATA);
                mEventHandler.removeMessages(MSG_REQUEST_TRANSPORTCONTROL);
                mEventHandler.removeMessages(MSG_REQUEST_ARTWORK);
                mEventHandler.dispatchMessage(
                        mEventHandler.obtainMessage(MSG_REQUEST_PLAYBACK_STATE));
                mEventHandler.dispatchMessage(
                        mEventHandler.obtainMessage(MSG_REQUEST_TRANSPORTCONTROL));
                mEventHandler.dispatchMessage(mEventHandler.obtainMessage(MSG_REQUEST_METADATA));
                mEventHandler.dispatchMessage(mEventHandler.obtainMessage(MSG_REQUEST_ARTWORK));
            } 
            addTaint(clientGeneration);
            addTaint(infoFlags);
            addTaint(artWidth);
            addTaint(artHeight);
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.460 -0400", hash_original_method = "A6F81BEED91E1311AA2FA5D9223AC5BE", hash_generated_method = "E5B81C889298B648C8569F4E46541402")
        public void setCurrentClientGenerationId(int clientGeneration) {
            {
                mEventHandler.removeMessages(MSG_NEW_CURRENT_CLIENT_GEN);
                mEventHandler.dispatchMessage(mEventHandler.obtainMessage(
                        MSG_NEW_CURRENT_CLIENT_GEN, clientGeneration, 0));
            } 
            addTaint(clientGeneration);
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.461 -0400", hash_original_method = "858E8A6EB1AEED0E033B6B24928ADF7F", hash_generated_method = "9B0B6DA7FE58DDEC0A074C40B80AD176")
        public void plugRemoteControlDisplay(IRemoteControlDisplay rcd) {
            {
                mEventHandler.dispatchMessage(mEventHandler.obtainMessage(
                        MSG_PLUG_DISPLAY, rcd));
            } 
            addTaint(rcd.getTaint());
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.461 -0400", hash_original_method = "E2F436516A1B085C4A3368B079EC9835", hash_generated_method = "302035D7C66A014A0FC1946F6AD67D32")
        public void unplugRemoteControlDisplay(IRemoteControlDisplay rcd) {
            {
                mEventHandler.dispatchMessage(mEventHandler.obtainMessage(
                        MSG_UNPLUG_DISPLAY, rcd));
            } 
            addTaint(rcd.getTaint());
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.093 -0500", hash_original_field = "48DBEFEB1D57D7425F34775E3B0822FD", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;

    /**
     * Class constructor.
     * @param mediaButtonIntent The intent that will be sent for the media button events sent
     *     by remote controls.
     *     This intent needs to have been constructed with the {@link Intent#ACTION_MEDIA_BUTTON}
     *     action, and have a component that will handle the intent (set with
     *     {@link Intent#setComponent(ComponentName)}) registered with
     *     {@link AudioManager#registerMediaButtonEventReceiver(ComponentName)}
     *     before this new RemoteControlClient can itself be registered with
     *     {@link AudioManager#registerRemoteControlClient(RemoteControlClient)}.
     * @see AudioManager#registerMediaButtonEventReceiver(ComponentName)
     * @see AudioManager#registerRemoteControlClient(RemoteControlClient)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.980 -0500", hash_original_method = "AD6CCD9D9B436D492F90BC57466F8BB6", hash_generated_method = "28D4AB3908D0D540BF76A156E34290C8")
    
public RemoteControlClient(PendingIntent mediaButtonIntent) {
        mRcMediaIntent = mediaButtonIntent;

        Looper looper;
        if ((looper = Looper.myLooper()) != null) {
            mEventHandler = new EventHandler(this, looper);
        } else if ((looper = Looper.getMainLooper()) != null) {
            mEventHandler = new EventHandler(this, looper);
        } else {
            mEventHandler = null;
            Log.e(TAG, "RemoteControlClient() couldn't find main application thread");
        }
    }

    /**
     * Class constructor for a remote control client whose internal event handling
     * happens on a user-provided Looper.
     * @param mediaButtonIntent The intent that will be sent for the media button events sent
     *     by remote controls.
     *     This intent needs to have been constructed with the {@link Intent#ACTION_MEDIA_BUTTON}
     *     action, and have a component that will handle the intent (set with
     *     {@link Intent#setComponent(ComponentName)}) registered with
     *     {@link AudioManager#registerMediaButtonEventReceiver(ComponentName)}
     *     before this new RemoteControlClient can itself be registered with
     *     {@link AudioManager#registerRemoteControlClient(RemoteControlClient)}.
     * @param looper The Looper running the event loop.
     * @see AudioManager#registerMediaButtonEventReceiver(ComponentName)
     * @see AudioManager#registerRemoteControlClient(RemoteControlClient)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.983 -0500", hash_original_method = "BBCB02942EAA4463B06F3A8D8D85915D", hash_generated_method = "7765B7729477EAF97C8D70200FCA521F")
    
public RemoteControlClient(PendingIntent mediaButtonIntent, Looper looper) {
        mRcMediaIntent = mediaButtonIntent;

        mEventHandler = new EventHandler(this, looper);
    }

    /**
     * Creates a {@link MetadataEditor}.
     * @param startEmpty Set to false if you want the MetadataEditor to contain the metadata that
     *     was previously applied to the RemoteControlClient, or true if it is to be created empty.
     * @return a new MetadataEditor instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.032 -0500", hash_original_method = "848F28E79710FB7B251A1B961691D3AF", hash_generated_method = "E24A254998E2649CDC56B2BA6FD30E1D")
    
public MetadataEditor editMetadata(boolean startEmpty) {
        MetadataEditor editor = new MetadataEditor();
        if (startEmpty) {
            editor.mEditorMetadata = new Bundle();
            editor.mEditorArtwork = null;
            editor.mMetadataChanged = true;
            editor.mArtworkChanged = true;
        } else {
            editor.mEditorMetadata = new Bundle(mMetadata);
            editor.mEditorArtwork = mArtwork;
            editor.mMetadataChanged = false;
            editor.mArtworkChanged = false;
        }
        return editor;
    }

    /**
     * Sets the current playback state.
     * @param state The current playback state, one of the following values:
     *       {@link #PLAYSTATE_STOPPED},
     *       {@link #PLAYSTATE_PAUSED},
     *       {@link #PLAYSTATE_PLAYING},
     *       {@link #PLAYSTATE_FAST_FORWARDING},
     *       {@link #PLAYSTATE_REWINDING},
     *       {@link #PLAYSTATE_SKIPPING_FORWARDS},
     *       {@link #PLAYSTATE_SKIPPING_BACKWARDS},
     *       {@link #PLAYSTATE_BUFFERING},
     *       {@link #PLAYSTATE_ERROR}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.036 -0500", hash_original_method = "1B4A5A7A2B9348E61A1F8DBEDB05B350", hash_generated_method = "A64D9665EAAEA37E6C534597A949D6BF")
    
public void setPlaybackState(int state) {
        synchronized(mCacheLock) {
            if (mPlaybackState != state) {
                // store locally
                mPlaybackState = state;
                // keep track of when the state change occurred
                mPlaybackStateChangeTimeMs = SystemClock.elapsedRealtime();

                // send to remote control display if conditions are met
                sendPlaybackState_syncCacheLock();
            }
        }
    }

    /**
     * Sets the flags for the media transport control buttons that this client supports.
     * @param transportControlFlags A combination of the following flags:
     *      {@link #FLAG_KEY_MEDIA_PREVIOUS},
     *      {@link #FLAG_KEY_MEDIA_REWIND},
     *      {@link #FLAG_KEY_MEDIA_PLAY},
     *      {@link #FLAG_KEY_MEDIA_PLAY_PAUSE},
     *      {@link #FLAG_KEY_MEDIA_PAUSE},
     *      {@link #FLAG_KEY_MEDIA_STOP},
     *      {@link #FLAG_KEY_MEDIA_FAST_FORWARD},
     *      {@link #FLAG_KEY_MEDIA_NEXT}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.038 -0500", hash_original_method = "940D4AD017270A6AD7F6D36A1ADC2473", hash_generated_method = "C8662BF2E806A42D2295DE9872FCC1DD")
    
public void setTransportControlFlags(int transportControlFlags) {
        synchronized(mCacheLock) {
            // store locally
            mTransportControlFlags = transportControlFlags;

            // send to remote control display if conditions are met
            sendTransportControlFlags_syncCacheLock();
        }
    }

    /**
     * @hide
     * Accessor to media button intent description (includes target component)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.073 -0500", hash_original_method = "2C35ADA55DC65E9D8CCC19BDAA7D2B4B", hash_generated_method = "BBC7396E72B1D443036DEB203F92FE1D")
    
public PendingIntent getRcMediaIntent() {
        return mRcMediaIntent;
    }
    /**
     * @hide
     * Accessor to IRemoteControlClient
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.076 -0500", hash_original_method = "6031DEC176ACCB06C28473E7885E0907", hash_generated_method = "007775DBD88021AF731B42BCC3999D7F")
    
public IRemoteControlClient getIRemoteControlClient() {
        return mIRCC;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.125 -0500", hash_original_method = "1D4279FF389DE00E45CE62733E438945", hash_generated_method = "830B72CF19C71F767BA4D41EAA03AAA5")
    
private void detachFromDisplay_syncCacheLock() {
        mRcDisplay = null;
        mArtworkExpectedWidth = ARTWORK_INVALID_SIZE;
        mArtworkExpectedHeight = ARTWORK_INVALID_SIZE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.128 -0500", hash_original_method = "DCEF21D9331BDE9855981A4FAF951191", hash_generated_method = "ECE76AAB9100E6A8BD2D66F177D52D2A")
    
private void sendPlaybackState_syncCacheLock() {
        if ((mCurrentClientGenId == mInternalClientGenId) && (mRcDisplay != null)) {
            try {
                mRcDisplay.setPlaybackState(mInternalClientGenId, mPlaybackState,
                        mPlaybackStateChangeTimeMs);
            } catch (RemoteException e) {
                Log.e(TAG, "Error in setPlaybackState(), dead display "+e);
                detachFromDisplay_syncCacheLock();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.130 -0500", hash_original_method = "414E902B5C775D55BC88776E02F34242", hash_generated_method = "D344328270FA14AE1287ECDC439416FC")
    
private void sendMetadata_syncCacheLock() {
        if ((mCurrentClientGenId == mInternalClientGenId) && (mRcDisplay != null)) {
            try {
                mRcDisplay.setMetadata(mInternalClientGenId, mMetadata);
            } catch (RemoteException e) {
                Log.e(TAG, "Error in sendPlaybackState(), dead display "+e);
                detachFromDisplay_syncCacheLock();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.133 -0500", hash_original_method = "AE3ACB485EA21BE41AFE152A08682540", hash_generated_method = "75492C1532B47397BA7611E987E14482")
    
private void sendTransportControlFlags_syncCacheLock() {
        if ((mCurrentClientGenId == mInternalClientGenId) && (mRcDisplay != null)) {
            try {
                mRcDisplay.setTransportControlFlags(mInternalClientGenId,
                        mTransportControlFlags);
            } catch (RemoteException e) {
                Log.e(TAG, "Error in sendTransportControlFlags(), dead display "+e);
                detachFromDisplay_syncCacheLock();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.135 -0500", hash_original_method = "1072470EEE2F2109E34F0B1C5EF1161C", hash_generated_method = "71A87FC81447387D1B6B38172D61F932")
    
private void sendArtwork_syncCacheLock() {
        if ((mCurrentClientGenId == mInternalClientGenId) && (mRcDisplay != null)) {
            // even though we have already scaled in setArtwork(), when this client needs to
            // send the bitmap, there might be newer and smaller expected dimensions, so we have
            // to check again.
            mArtwork = scaleBitmapIfTooBig(mArtwork, mArtworkExpectedWidth, mArtworkExpectedHeight);
            try {
                mRcDisplay.setArtwork(mInternalClientGenId, mArtwork);
            } catch (RemoteException e) {
                Log.e(TAG, "Error in sendArtwork(), dead display "+e);
                detachFromDisplay_syncCacheLock();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.138 -0500", hash_original_method = "9C956ABC194A8C18AFD74A607E4260C4", hash_generated_method = "F8FE42449DE75AE0CA324E2BF3F91D90")
    
private void sendMetadataWithArtwork_syncCacheLock() {
        if ((mCurrentClientGenId == mInternalClientGenId) && (mRcDisplay != null)) {
            // even though we have already scaled in setArtwork(), when this client needs to
            // send the bitmap, there might be newer and smaller expected dimensions, so we have
            // to check again.
            mArtwork = scaleBitmapIfTooBig(mArtwork, mArtworkExpectedWidth, mArtworkExpectedHeight);
            try {
                mRcDisplay.setAllMetadata(mInternalClientGenId, mMetadata, mArtwork);
            } catch (RemoteException e) {
                Log.e(TAG, "Error in setAllMetadata(), dead display "+e);
                detachFromDisplay_syncCacheLock();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.140 -0500", hash_original_method = "0BE7AE1519A8E1F03CB0A5A1A7C2DA4C", hash_generated_method = "0F716B82594B82E5D1B64294B5DD530B")
    
private void onNewInternalClientGen(Integer clientGeneration, int artWidth, int artHeight) {
        synchronized (mCacheLock) {
            // this remote control client is told it is the "focused" one:
            // it implies that now (mCurrentClientGenId == mInternalClientGenId) is true
            mInternalClientGenId = clientGeneration.intValue();
            if (artWidth > 0) {
                mArtworkExpectedWidth = artWidth;
                mArtworkExpectedHeight = artHeight;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.143 -0500", hash_original_method = "6CA13622614E338BD9C3EB3C00B6EAD4", hash_generated_method = "E8745FF83CA44504DC617ADEC2967446")
    
private void onNewCurrentClientGen(int clientGeneration) {
        synchronized (mCacheLock) {
            mCurrentClientGenId = clientGeneration;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.145 -0500", hash_original_method = "53EC796651633C35ADEE8DE59FBA0A28", hash_generated_method = "09623C29A049D07569F7A52F2E5B6864")
    
private void onPlugDisplay(IRemoteControlDisplay rcd) {
        synchronized(mCacheLock) {
            mRcDisplay = rcd;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.147 -0500", hash_original_method = "C16B385AF67DD61790B8C9E68A3BEA11", hash_generated_method = "F56FB16D03D32FDE8F21B1936FB4420F")
    
private void onUnplugDisplay(IRemoteControlDisplay rcd) {
        synchronized(mCacheLock) {
            if ((mRcDisplay != null) && (mRcDisplay.asBinder().equals(rcd.asBinder()))) {
                mRcDisplay = null;
                mArtworkExpectedWidth = ARTWORK_DEFAULT_SIZE;
                mArtworkExpectedHeight = ARTWORK_DEFAULT_SIZE;
            }
        }
    }

    /**
     * Scale a bitmap to fit the smallest dimension by uniformly scaling the incoming bitmap.
     * If the bitmap fits, then do nothing and return the original.
     *
     * @param bitmap
     * @param maxWidth
     * @param maxHeight
     * @return
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:30.150 -0500", hash_original_method = "1F39DBEB11686CD36B20A5C71DB4136D", hash_generated_method = "02D313198A4E932C9E53E7F4012DB825")
    
private Bitmap scaleBitmapIfTooBig(Bitmap bitmap, int maxWidth, int maxHeight) {
        if (bitmap != null) {
            final int width = bitmap.getWidth();
            final int height = bitmap.getHeight();
            if (width > maxWidth || height > maxHeight) {
                float scale = Math.min((float) maxWidth / width, (float) maxHeight / height);
                int newWidth = Math.round(scale * width);
                int newHeight = Math.round(scale * height);
                Bitmap outBitmap = Bitmap.createBitmap(newWidth, newHeight, bitmap.getConfig());
                Canvas canvas = new Canvas(outBitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(bitmap, null,
                        new RectF(0, 0, outBitmap.getWidth(), outBitmap.getHeight()), paint);
                bitmap = outBitmap;
            }
        }
        return bitmap;
    }
}

