package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import com.android.internal.os.IDropBoxManagerService;

public class DropBoxManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.339 -0500", hash_original_field = "D9B79A0164BB0C0D43E8BE0E50A07175", hash_generated_field = "7F88B1F6C3AA23682B73D2063D96AD46")

    private static final String TAG = "DropBoxManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.343 -0500", hash_original_field = "DEEF993D34CD370CC60DFD894A869C66", hash_generated_field = "4342C6618E9F33B619CAED2246633D02")

    public static final int IS_EMPTY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.346 -0500", hash_original_field = "AA2789A4A3E70D0EFE2E695516CCB611", hash_generated_field = "26AE776D9F0D1E8967689D8BDE25B1E4")

    public static final int IS_TEXT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.348 -0500", hash_original_field = "CAC9CC5411262E33D125EFD3EF4EEF00", hash_generated_field = "0467C01D2B434424775E1AEC77EA10FE")

    public static final int IS_GZIPPED = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.350 -0500", hash_original_field = "040DCB4C99D0BA1206DE938DF7F9A853", hash_generated_field = "48D79452E0CE2C4C0A373F8DD88D3A93")

    private static final int HAS_BYTE_ARRAY = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.353 -0500", hash_original_field = "827C230EC3BF90168B2033A65704689D", hash_generated_field = "C96D94412FCD56314FB7038C746F0C74")

    public static final String ACTION_DROPBOX_ENTRY_ADDED =
        "android.intent.action.DROPBOX_ENTRY_ADDED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.355 -0500", hash_original_field = "970450E13346796A53A85829B5008AC6", hash_generated_field = "DA52E65CF9683E9971D90CD0BBF2BACB")

    public static final String EXTRA_TAG = "tag";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.358 -0500", hash_original_field = "D910661ED5A65576B5BFD7269C64298B", hash_generated_field = "BF72FAE2E20FCDE1DA6F95CAA1981EAC")

    public static final String EXTRA_TIME = "time";
    
    public static class Entry implements Parcelable, Closeable {
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.039 -0400", hash_original_field = "A8DC184895BB5B5BEE6BB5E9D72AA17F", hash_generated_field = "329A53A95C2F0B54BB6DBA5A539F5907")

        public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.403 -0500", hash_original_method = "A391752DBE5FDE90AB459A0FCBEFF4D2", hash_generated_method = "3F9FC880A62633725193C63B42998327")
            
public Entry[] newArray(int size) { return new Entry[size]; }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.406 -0500", hash_original_method = "946DD766314338FFDBA7B29D274BE59A", hash_generated_method = "4066987818FA603CCE0C5DC4EDFC22BF")
            
public Entry createFromParcel(Parcel in) {
                String tag = in.readString();
                long millis = in.readLong();
                int flags = in.readInt();
                if ((flags & HAS_BYTE_ARRAY) != 0) {
                    return new Entry(tag, millis, in.createByteArray(), flags & ~HAS_BYTE_ARRAY);
                } else {
                    return new Entry(tag, millis, in.readFileDescriptor(), flags);
                }
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.361 -0500", hash_original_field = "05B32B05746742D3A5261C827E7D8852", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private  String mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.363 -0500", hash_original_field = "0571E75BFD18E7506EEB52F2B46715AC", hash_generated_field = "753DEC84E9370E35F2BD26C6679E5DA4")

        private  long mTimeMillis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.366 -0500", hash_original_field = "5D97F7C0534662C5183D05D4FFD1A145", hash_generated_field = "04254C7D5555806109D3DE22B9918A82")

        private  byte[] mData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.369 -0500", hash_original_field = "E57966AB286B8F6F75FB7E135DD8912B", hash_generated_field = "2EB80060CD9954C0E91A29E7A228F077")

        private  ParcelFileDescriptor mFileDescriptor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.371 -0500", hash_original_field = "4E5A87EA4636A8ACF68875B877F3A7B8", hash_generated_field = "43F71E9173849705E01112D0229448B4")

        private  int mFlags;

        /** Create a new empty Entry with no contents. */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.373 -0500", hash_original_method = "59D4C7A828654550E9A00289F418A41B", hash_generated_method = "A1ADB842CDB3D89617B61CB662BF8B7B")
        
public Entry(String tag, long millis) {
            if (tag == null) throw new NullPointerException("tag == null");

            mTag = tag;
            mTimeMillis = millis;
            mData = null;
            mFileDescriptor = null;
            mFlags = IS_EMPTY;
        }

        /** Create a new Entry with plain text contents. */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.376 -0500", hash_original_method = "3040DA05407F13E8561F02C468A7DEB4", hash_generated_method = "96B96B503A807A17EFBA37C423574278")
        
public Entry(String tag, long millis, String text) {
            if (tag == null) throw new NullPointerException("tag == null");
            if (text == null) throw new NullPointerException("text == null");

            mTag = tag;
            mTimeMillis = millis;
            mData = text.getBytes();
            mFileDescriptor = null;
            mFlags = IS_TEXT;
        }

        /**
         * Create a new Entry with byte array contents.
         * The data array must not be modified after creating this entry.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.379 -0500", hash_original_method = "182B4976A5D069A0C2E90B74F50A592D", hash_generated_method = "C5D0979BD3404C0F59668145B60A0893")
        
public Entry(String tag, long millis, byte[] data, int flags) {
            if (tag == null) throw new NullPointerException("tag == null");
            if (((flags & IS_EMPTY) != 0) != (data == null)) {
                throw new IllegalArgumentException("Bad flags: " + flags);
            }

            mTag = tag;
            mTimeMillis = millis;
            mData = data;
            mFileDescriptor = null;
            mFlags = flags;
        }

        /**
         * Create a new Entry with streaming data contents.
         * Takes ownership of the ParcelFileDescriptor.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.382 -0500", hash_original_method = "98F6B6C49553AC4D3032798198FC694A", hash_generated_method = "E0D85ABA1500C693E45FDA4B5393020F")
        
public Entry(String tag, long millis, ParcelFileDescriptor data, int flags) {
            if (tag == null) throw new NullPointerException("tag == null");
            if (((flags & IS_EMPTY) != 0) != (data == null)) {
                throw new IllegalArgumentException("Bad flags: " + flags);
            }

            mTag = tag;
            mTimeMillis = millis;
            mData = null;
            mFileDescriptor = data;
            mFlags = flags;
        }

        /**
         * Create a new Entry with the contents read from a file.
         * The file will be read when the entry's contents are requested.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.385 -0500", hash_original_method = "102E401D4541F654441520BE506818C4", hash_generated_method = "897BA93736BAF4043F4A43BFE77F6801")
        
public Entry(String tag, long millis, File data, int flags) throws IOException {
            if (tag == null) throw new NullPointerException("tag == null");
            if ((flags & IS_EMPTY) != 0) throw new IllegalArgumentException("Bad flags: " + flags);

            mTag = tag;
            mTimeMillis = millis;
            mData = null;
            mFileDescriptor = ParcelFileDescriptor.open(data, ParcelFileDescriptor.MODE_READ_ONLY);
            mFlags = flags;
        }

        /** Close the input stream associated with this entry. */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.387 -0500", hash_original_method = "377836285D1E96A0220618E9638425CD", hash_generated_method = "B1898091EE92D272834555453BD42E12")
        
public void close() {
            try { if (mFileDescriptor != null) mFileDescriptor.close(); } catch (IOException e) { }
        }

        /** @return the tag originally attached to the entry. */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.389 -0500", hash_original_method = "ED26754F6A82B43F30EAE698B7941323", hash_generated_method = "0B538D6B7E10340EACEB66882A3752E4")
        
public String getTag() { return mTag; }

        /** @return time when the entry was originally created. */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.392 -0500", hash_original_method = "6C399926D10F83AEDA9A5ADCC6A5D3A1", hash_generated_method = "4EEBC7115EF2483FED0898219C32EC53")
        
public long getTimeMillis() { return mTimeMillis; }

        /** @return flags describing the content returned by {@link #getInputStream()}. */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.394 -0500", hash_original_method = "DEBA147F1626153ABBF4AEA4FEEBC80F", hash_generated_method = "A232C7C0C5207087EB20025BE13ADFF2")
        
public int getFlags() { return mFlags & ~IS_GZIPPED; }  // getInputStream() decompresses.

        /**
         * @param maxBytes of string to return (will truncate at this length).
         * @return the uncompressed text contents of the entry, null if the entry is not text.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.397 -0500", hash_original_method = "5115D4296A1E9A49B9B7627B57AD3F2E", hash_generated_method = "0AE4E31616817EE423844A6965610297")
        
public String getText(int maxBytes) {
            if ((mFlags & IS_TEXT) == 0) return null;
            if (mData != null) return new String(mData, 0, Math.min(maxBytes, mData.length));

            InputStream is = null;
            try {
                is = getInputStream();
                if (is == null) return null;
                byte[] buf = new byte[maxBytes];
                int readBytes = 0;
                int n = 0;
                while (n >= 0 && (readBytes += n) < maxBytes) {
                    n = is.read(buf, readBytes, maxBytes - readBytes);
                }
                return new String(buf, 0, readBytes);
            } catch (IOException e) {
                return null;
            } finally {
                try { if (is != null) is.close(); } catch (IOException e) {}
            }
        }

        /** @return the uncompressed contents of the entry, or null if the contents were lost */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.399 -0500", hash_original_method = "1138A2AC2CDA63F5FD2C1DAD635BB1B0", hash_generated_method = "4C74AC11C608A83FA2239CD66FDB48B6")
        
public InputStream getInputStream() throws IOException {
            InputStream is;
            if (mData != null) {
                is = new ByteArrayInputStream(mData);
            } else if (mFileDescriptor != null) {
                is = new ParcelFileDescriptor.AutoCloseInputStream(mFileDescriptor);
            } else {
                return null;
            }
            return (mFlags & IS_GZIPPED) != 0 ? new GZIPInputStream(is) : is;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.411 -0500", hash_original_method = "CE12D992AD97C7CB4D92B660FD5831CC", hash_generated_method = "66BFD16BA58041EE15EE07E040489680")
        
public int describeContents() {
            return mFileDescriptor != null ? Parcelable.CONTENTS_FILE_DESCRIPTOR : 0;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.413 -0500", hash_original_method = "651672D7808B55AEFC112D3455309C97", hash_generated_method = "E49A12FEBDA90A9B384C764C321BA52B")
        
public void writeToParcel(Parcel out, int flags) {
            out.writeString(mTag);
            out.writeLong(mTimeMillis);
            if (mFileDescriptor != null) {
                out.writeInt(mFlags & ~HAS_BYTE_ARRAY);  // Clear bit just to be safe
                mFileDescriptor.writeToParcel(out, flags);
            } else {
                out.writeInt(mFlags | HAS_BYTE_ARRAY);
                out.writeByteArray(mData);
            }
        }
        // orphaned legacy method
        public Entry createFromParcel(Parcel in) {
                String tag = in.readString();
                long millis = in.readLong();
                int flags = in.readInt();
                if ((flags & HAS_BYTE_ARRAY) != 0) {
                    return new Entry(tag, millis, in.createByteArray(), flags & ~HAS_BYTE_ARRAY);
                } else {
                    return new Entry(tag, millis, in.readFileDescriptor(), flags);
                }
            }
        
        // orphaned legacy method
        public Entry[] newArray(int size) { return new Entry[size]; }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.341 -0500", hash_original_field = "66CB97C4BDD5BC95418A2AD4B0FF67EE", hash_generated_field = "FF673E933014905FBCDFD4D8541297A4")

    private  IDropBoxManagerService mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.032 -0400", hash_original_method = "04B0A4DBB2EAE135AA112A8CAA9647B1", hash_generated_method = "56807A840D421C3846696C198899DDB8")
    public  DropBoxManager(IDropBoxManagerService service) {
        mService = service;
        addTaint(service.getTaint());
        // ---------- Original Method ----------
        //mService = service;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.033 -0400", hash_original_method = "E688A3A6CCC118BEDB51FAABD6872F4D", hash_generated_method = "1D2825C63C164429C45D67692FE8B561")
    public DropBoxManager() {
        mService = null;
        // ---------- Original Method ----------
        //mService = null;
    }

    /**
     * Stores human-readable text.  The data may be discarded eventually (or even
     * immediately) if space is limited, or ignored entirely if the tag has been
     * blocked (see {@link #isTagEnabled}).
     *
     * @param tag describing the type of entry being stored
     * @param data value to store
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.423 -0500", hash_original_method = "B6329499D071F8AC982F0B19B7FB97DF", hash_generated_method = "22BEA5D439C7F6C8877A2F60763310E7")
    
public void addText(String tag, String data) {
        try { mService.add(new Entry(tag, 0, data)); } catch (RemoteException e) {}
    }

    /**
     * Stores binary data, which may be ignored or discarded as with {@link #addText}.
     *
     * @param tag describing the type of entry being stored
     * @param data value to store
     * @param flags describing the data
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.426 -0500", hash_original_method = "7BD48A32860AA6BD88FDC639FDB6D7D8", hash_generated_method = "816B8F2A0763E5731CF9279A7CDEC9C7")
    
public void addData(String tag, byte[] data, int flags) {
        if (data == null) throw new NullPointerException("data == null");
        try { mService.add(new Entry(tag, 0, data, flags)); } catch (RemoteException e) {}
    }

    /**
     * Stores the contents of a file, which may be ignored or discarded as with
     * {@link #addText}.
     *
     * @param tag describing the type of entry being stored
     * @param file to read from
     * @param flags describing the data
     * @throws IOException if the file can't be opened
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.429 -0500", hash_original_method = "BF97B72EB64F4DB129C9C48237659777", hash_generated_method = "FA73C886BED1C418635F13184FE537E3")
    
public void addFile(String tag, File file, int flags) throws IOException {
        if (file == null) throw new NullPointerException("file == null");
        Entry entry = new Entry(tag, 0, file, flags);
        try {
            mService.add(entry);
        } catch (RemoteException e) {
            // ignore
        } finally {
            entry.close();
        }
    }

    /**
     * Checks any blacklists (set in system settings) to see whether a certain
     * tag is allowed.  Entries with disabled tags will be dropped immediately,
     * so you can save the work of actually constructing and sending the data.
     *
     * @param tag that would be used in {@link #addText} or {@link #addFile}
     * @return whether events with that tag would be accepted
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.431 -0500", hash_original_method = "0FE06F2CE6966672337D3755F0FF0CD0", hash_generated_method = "8B784C203CC3281453FD048DD2F4F71B")
    
public boolean isTagEnabled(String tag) {
        try { return mService.isTagEnabled(tag); } catch (RemoteException e) { return false; }
    }

    /**
     * Gets the next entry from the drop box <em>after</em> the specified time.
     * Requires <code>android.permission.READ_LOGS</code>.  You must always call
     * {@link Entry#close()} on the return value!
     *
     * @param tag of entry to look for, null for all tags
     * @param msec time of the last entry seen
     * @return the next entry, or null if there are no more entries
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.433 -0500", hash_original_method = "A691D94F864449A091C30E093C0F46CD", hash_generated_method = "B801D28E7D11A86E5711BAC5D5D99291")
    
public Entry getNextEntry(String tag, long msec) {
        try { return mService.getNextEntry(tag, msec); } catch (RemoteException e) { return null; }
    }
}

