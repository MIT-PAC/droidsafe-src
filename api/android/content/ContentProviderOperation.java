package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class ContentProviderOperation implements Parcelable {

    /**
     * Create a {@link Builder} suitable for building an insert {@link ContentProviderOperation}.
     * @param uri The {@link Uri} that is the target of the insert.
     * @return a {@link Builder}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.124 -0500", hash_original_method = "659152B169A2C44F2069F1FBAB7EA425", hash_generated_method = "8E84DD8A649E9BFE8BB57FD3211E375E")
    
public static Builder newInsert(Uri uri) {
        return new Builder(TYPE_INSERT, uri);
    }

    /**
     * Create a {@link Builder} suitable for building an update {@link ContentProviderOperation}.
     * @param uri The {@link Uri} that is the target of the update.
     * @return a {@link Builder}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.126 -0500", hash_original_method = "097853FC9EACA1E091D66FAF08F5EA14", hash_generated_method = "180AD0F65CDA32AC36FC95AF3B1A04B0")
    
public static Builder newUpdate(Uri uri) {
        return new Builder(TYPE_UPDATE, uri);
    }

    /**
     * Create a {@link Builder} suitable for building a delete {@link ContentProviderOperation}.
     * @param uri The {@link Uri} that is the target of the delete.
     * @return a {@link Builder}
     */
    @DSSpec(DSCat.CONTENT)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.128 -0500", hash_original_method = "0693BC23F33A94F2A72DA35D1DD7A47F", hash_generated_method = "1A8C4FF33BF0D211678913E79B9F602D")
    
public static Builder newDelete(Uri uri) {
        return new Builder(TYPE_DELETE, uri);
    }

    /**
     * Create a {@link Builder} suitable for building a
     * {@link ContentProviderOperation} to assert a set of values as provided
     * through {@link Builder#withValues(ContentValues)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.131 -0500", hash_original_method = "2FE81C83AAA3592BACCD9712E1EDEBCE", hash_generated_method = "D090396712FE1D19CF55E07572224F10")
    
public static Builder newAssertQuery(Uri uri) {
        return new Builder(TYPE_ASSERT, uri);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.084 -0500", hash_original_field = "6DF4C3FD642D82A8AE829BF3FA4D5AA9", hash_generated_field = "F2B415C2E3F102CA367609812B6543AF")

    public final static int TYPE_INSERT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.086 -0500", hash_original_field = "CADE643C50E62F53447A627BA981975D", hash_generated_field = "1442E5D78729E4303598C2A50D596315")

    public final static int TYPE_UPDATE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.088 -0500", hash_original_field = "9FE04D3DC64B071FF51219C483A9F40F", hash_generated_field = "3AD3AA9BCB51C5A9F57D5C35E47FAB8E")

    public final static int TYPE_DELETE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.091 -0500", hash_original_field = "5CC66BAF21E0BEFDBF8905EF6236B6BF", hash_generated_field = "20A63CA4A4C078199A85B846D689891A")

    public final static int TYPE_ASSERT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.112 -0500", hash_original_field = "B6FF751B1A864DBACF90708D709FB527", hash_generated_field = "24245924956604414829F296110ED079")

    private final static String TAG = "ContentProviderOperation";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.077 -0400", hash_original_field = "8924CBDB7EE2EFEBC660CED8A0C59192", hash_generated_field = "9AC0BB3876B129B46AD7C4638D0FA4D8")

    public static final Creator<ContentProviderOperation> CREATOR =
            new Creator<ContentProviderOperation>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.160 -0500", hash_original_method = "51820FE0219C3C2B0FA218CF2A0EC3F5", hash_generated_method = "3CCA4777945F471406B35B4E567FB781")
        
public ContentProviderOperation createFromParcel(Parcel source) {
            return new ContentProviderOperation(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.163 -0500", hash_original_method = "2D91FDE6EFE31D278C02C8E00CD99BE3", hash_generated_method = "3E28980894FBC61FA0686987F0766A5A")
        
public ContentProviderOperation[] newArray(int size) {
            return new ContentProviderOperation[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.093 -0500", hash_original_field = "B93BF1EFA6B57CC598632E54B97CD147", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private  int mType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.095 -0500", hash_original_field = "49226456B4CE4E55A779249DE3DC63D4", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

    private  Uri mUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.097 -0500", hash_original_field = "A4B52CC7E044C58A043A90E441AE3148", hash_generated_field = "B8B15EC2943749CD20950EAD77AF5EC7")

    private  String mSelection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.099 -0500", hash_original_field = "471921CCB7416C473522085BE246B845", hash_generated_field = "5541CF5102D1C94942E84E1E2C6A7EFF")

    private  String[] mSelectionArgs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.102 -0500", hash_original_field = "4BBDD741F50F220390CF4FB3A7A2B7BA", hash_generated_field = "2CDA41B4D101B2B770760EBED9C98242")

    private  ContentValues mValues;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.104 -0500", hash_original_field = "5E4AC50B6AC39BA5027EE3451EBFD01B", hash_generated_field = "0366D826BB05344215E0357A75CDC773")

    private  Integer mExpectedCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.106 -0500", hash_original_field = "83C7A2D17BA93120F470A978BC5B28E5", hash_generated_field = "5CDBA65FCD489D4F2D0BCD78A8638FD5")

    private  ContentValues mValuesBackReferences;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.108 -0500", hash_original_field = "4E43E986D5E30A38AE95B83ADE6530C8", hash_generated_field = "F3EB1F15BD72236CAC0D0000DA6E4595")

    private  Map<Integer, Integer> mSelectionArgsBackReferences;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.110 -0500", hash_original_field = "67BEFB92A3D8A221613D78CFD285198E", hash_generated_field = "878B9839823FAA28C7AD4A475721F913")

    private  boolean mYieldAllowed;

    /**
     * Creates a {@link ContentProviderOperation} by copying the contents of a
     * {@link Builder}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.115 -0500", hash_original_method = "E83648833C15023B0A37354984B5CA31", hash_generated_method = "699E81295A753AC2AE7F67B6041EA712")
    
private ContentProviderOperation(Builder builder) {
        mType = builder.mType;
        mUri = builder.mUri;
        mValues = builder.mValues;
        mSelection = builder.mSelection;
        mSelectionArgs = builder.mSelectionArgs;
        mExpectedCount = builder.mExpectedCount;
        mSelectionArgsBackReferences = builder.mSelectionArgsBackReferences;
        mValuesBackReferences = builder.mValuesBackReferences;
        mYieldAllowed = builder.mYieldAllowed;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.119 -0500", hash_original_method = "9004240102FD3717D6F1BEB293484741", hash_generated_method = "5183199B690BF8BA82CA8926897337E3")
    
private ContentProviderOperation(Parcel source) {
        mType = source.readInt();
        mUri = Uri.CREATOR.createFromParcel(source);
        mValues = source.readInt() != 0 ? ContentValues.CREATOR.createFromParcel(source) : null;
        mSelection = source.readInt() != 0 ? source.readString() : null;
        mSelectionArgs = source.readInt() != 0 ? source.readStringArray() : null;
        mExpectedCount = source.readInt() != 0 ? source.readInt() : null;
        mValuesBackReferences = source.readInt() != 0
                ? ContentValues.CREATOR.createFromParcel(source)
                : null;
        mSelectionArgsBackReferences = source.readInt() != 0
                ? new HashMap<Integer, Integer>()
                : null;
        if (mSelectionArgsBackReferences != null) {
            final int count = source.readInt();
            for (int i = 0; i < count; i++) {
                mSelectionArgsBackReferences.put(source.readInt(), source.readInt());
            }
        }
        mYieldAllowed = source.readInt() != 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.121 -0500", hash_original_method = "D97604A456AD6CF9916FB862EEBD56CF", hash_generated_method = "31930ED2A7929556DEA3FE3762994A93")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mType);
        Uri.writeToParcel(dest, mUri);
        if (mValues != null) {
            dest.writeInt(1);
            mValues.writeToParcel(dest, 0);
        } else {
            dest.writeInt(0);
        }
        if (mSelection != null) {
            dest.writeInt(1);
            dest.writeString(mSelection);
        } else {
            dest.writeInt(0);
        }
        if (mSelectionArgs != null) {
            dest.writeInt(1);
            dest.writeStringArray(mSelectionArgs);
        } else {
            dest.writeInt(0);
        }
        if (mExpectedCount != null) {
            dest.writeInt(1);
            dest.writeInt(mExpectedCount);
        } else {
            dest.writeInt(0);
        }
        if (mValuesBackReferences != null) {
            dest.writeInt(1);
            mValuesBackReferences.writeToParcel(dest, 0);
        } else {
            dest.writeInt(0);
        }
        if (mSelectionArgsBackReferences != null) {
            dest.writeInt(1);
            dest.writeInt(mSelectionArgsBackReferences.size());
            for (Map.Entry<Integer, Integer> entry : mSelectionArgsBackReferences.entrySet()) {
                dest.writeInt(entry.getKey());
                dest.writeInt(entry.getValue());
            }
        } else {
            dest.writeInt(0);
        }
        dest.writeInt(mYieldAllowed ? 1 : 0);
    }

    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.133 -0500", hash_original_method = "225259AA593B6A59F476A2C569F1B075", hash_generated_method = "A1B996311564AA1668AF8C1FC49818A0")
    
public Uri getUri() {
        return mUri;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.135 -0500", hash_original_method = "0D76D2BF4F9E314AF3AEB01067FC98E0", hash_generated_method = "BF080622E882D89879B5F81C610D2A05")
    
public boolean isYieldAllowed() {
        return mYieldAllowed;
    }

    /** @hide exposed for unit tests */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.137 -0500", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "32498FCDA3AC1E9A676800B51A331335")
    
public int getType() {
        return mType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.140 -0500", hash_original_method = "94452D9A7E20FFB1CE97B24DC927192A", hash_generated_method = "E8336FA6E03BBC6F6A64980723FF7046")
    
public boolean isWriteOperation() {
        return toTaintBoolean(mType);
        //return mType == TYPE_DELETE || mType == TYPE_INSERT || mType == TYPE_UPDATE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.142 -0500", hash_original_method = "BBB0424C7EB706D24B64E8DBE01BF66B", hash_generated_method = "0EAAFFB0E8BF0C7108D52276EEB9E86C")
    
public boolean isReadOperation() {
        return toTaintBoolean(mType + TYPE_ASSERT);
    }
    
    public static class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.168 -0500", hash_original_field = "B93BF1EFA6B57CC598632E54B97CD147", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

        private  int mType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.170 -0500", hash_original_field = "49226456B4CE4E55A779249DE3DC63D4", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

        private  Uri mUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.172 -0500", hash_original_field = "A4B52CC7E044C58A043A90E441AE3148", hash_generated_field = "B8B15EC2943749CD20950EAD77AF5EC7")

        private String mSelection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.175 -0500", hash_original_field = "471921CCB7416C473522085BE246B845", hash_generated_field = "5541CF5102D1C94942E84E1E2C6A7EFF")

        private String[] mSelectionArgs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.177 -0500", hash_original_field = "4BBDD741F50F220390CF4FB3A7A2B7BA", hash_generated_field = "2CDA41B4D101B2B770760EBED9C98242")

        private ContentValues mValues;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.179 -0500", hash_original_field = "5E4AC50B6AC39BA5027EE3451EBFD01B", hash_generated_field = "0366D826BB05344215E0357A75CDC773")

        private Integer mExpectedCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.181 -0500", hash_original_field = "83C7A2D17BA93120F470A978BC5B28E5", hash_generated_field = "5CDBA65FCD489D4F2D0BCD78A8638FD5")

        private ContentValues mValuesBackReferences;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.183 -0500", hash_original_field = "4E43E986D5E30A38AE95B83ADE6530C8", hash_generated_field = "F3EB1F15BD72236CAC0D0000DA6E4595")

        private Map<Integer, Integer> mSelectionArgsBackReferences;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.185 -0500", hash_original_field = "67BEFB92A3D8A221613D78CFD285198E", hash_generated_field = "878B9839823FAA28C7AD4A475721F913")

        private boolean mYieldAllowed;

        /** Create a {@link Builder} of a given type. The uri must not be null. */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.188 -0500", hash_original_method = "E4683F1EC70220B8EE12920060472DE0", hash_generated_method = "E7D3BD97D7A274DC2B07355C00558C30")
        
private Builder(int type, Uri uri) {
            if (uri == null) {
                throw new IllegalArgumentException("uri must not be null");
            }
            mType = type;
            mUri = uri;
        }

        /** Create a ContentProviderOperation from this {@link Builder}. */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.191 -0500", hash_original_method = "52DF5CD1F3EDB944F65D1FF1857828C4", hash_generated_method = "81B910F5CAF6435070D9D9A1339D1692")
        
public ContentProviderOperation build() {
            if (mType == TYPE_UPDATE) {
                if ((mValues == null || mValues.size() == 0)
                        && (mValuesBackReferences == null || mValuesBackReferences.size() == 0)) {
                    throw new IllegalArgumentException("Empty values");
                }
            }
            if (mType == TYPE_ASSERT) {
                if ((mValues == null || mValues.size() == 0)
                        && (mValuesBackReferences == null || mValuesBackReferences.size() == 0)
                        && (mExpectedCount == null)) {
                    throw new IllegalArgumentException("Empty values");
                }
            }
            return new ContentProviderOperation(this);
        }

        /**
         * Add a {@link ContentValues} of back references. The key is the name of the column
         * and the value is an integer that is the index of the previous result whose
         * value should be used for the column. The value is added as a {@link String}.
         * A column value from the back references takes precedence over a value specified in
         * {@link #withValues}.
         * This can only be used with builders of type insert, update, or assert.
         * @return this builder, to allow for chaining.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.194 -0500", hash_original_method = "48DEB08B58C335127E8366C72D237182", hash_generated_method = "0AAECA83E53308B49B4A6B178E36F51F")
        
public Builder withValueBackReferences(ContentValues backReferences) {
            if (mType != TYPE_INSERT && mType != TYPE_UPDATE && mType != TYPE_ASSERT) {
                throw new IllegalArgumentException(
                        "only inserts, updates, and asserts can have value back-references");
            }
            mValuesBackReferences = backReferences;
            return this;
        }

        /**
         * Add a ContentValues back reference.
         * A column value from the back references takes precedence over a value specified in
         * {@link #withValues}.
         * This can only be used with builders of type insert, update, or assert.
         * @return this builder, to allow for chaining.
         */
        @DSSafe(DSCat.UTIL_FUNCTION)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.196 -0500", hash_original_method = "9B7E0512DF416F22106A40FEC0A8A4AE", hash_generated_method = "653D96A28F937E3E6B4FA8723303C2A2")
        
public Builder withValueBackReference(String key, int previousResult) {
            if (mType != TYPE_INSERT && mType != TYPE_UPDATE && mType != TYPE_ASSERT) {
                throw new IllegalArgumentException(
                        "only inserts, updates, and asserts can have value back-references");
            }
            if (mValuesBackReferences == null) {
                mValuesBackReferences = new ContentValues();
            }
            mValuesBackReferences.put(key, previousResult);
            return this;
        }

        /**
         * Add a back references as a selection arg. Any value at that index of the selection arg
         * that was specified by {@link #withSelection} will be overwritten.
         * This can only be used with builders of type update, delete, or assert.
         * @return this builder, to allow for chaining.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.198 -0500", hash_original_method = "0B4CE4049FC576DCE44E5153CA371A5B", hash_generated_method = "EC6004CAEE9E9575574F2A8604A06310")
        
public Builder withSelectionBackReference(int selectionArgIndex, int previousResult) {
            if (mType != TYPE_UPDATE && mType != TYPE_DELETE && mType != TYPE_ASSERT) {
                throw new IllegalArgumentException("only updates, deletes, and asserts "
                        + "can have selection back-references");
            }
            if (mSelectionArgsBackReferences == null) {
                mSelectionArgsBackReferences = new HashMap<Integer, Integer>();
            }
            mSelectionArgsBackReferences.put(selectionArgIndex, previousResult);
            return this;
        }

        /**
         * The ContentValues to use. This may be null. These values may be overwritten by
         * the corresponding value specified by {@link #withValueBackReference} or by
         * future calls to {@link #withValues} or {@link #withValue}.
         * This can only be used with builders of type insert, update, or assert.
         * @return this builder, to allow for chaining.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.200 -0500", hash_original_method = "F7B8F8808C4F5F5C0301B85A5CF2FD8A", hash_generated_method = "9216C39586B40369FB8E511EFAE5F47F")
        
public Builder withValues(ContentValues values) {
            if (mType != TYPE_INSERT && mType != TYPE_UPDATE && mType != TYPE_ASSERT) {
                throw new IllegalArgumentException(
                        "only inserts, updates, and asserts can have values");
            }
            if (mValues == null) {
                mValues = new ContentValues();
            }
            mValues.putAll(values);
            return this;
        }

        /**
         * A value to insert or update. This value may be overwritten by
         * the corresponding value specified by {@link #withValueBackReference}.
         * This can only be used with builders of type insert, update, or assert.
         * @param key the name of this value
         * @param value the value itself. the type must be acceptable for insertion by
         * {@link ContentValues#put}
         * @return this builder, to allow for chaining.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.203 -0500", hash_original_method = "E35FC6F92508151B3604E11EFF6133FA", hash_generated_method = "CB9122B9DB56EA843D0490A3498D606A")
        
public Builder withValue(String key, Object value) {
            if (mType != TYPE_INSERT && mType != TYPE_UPDATE && mType != TYPE_ASSERT) {
                throw new IllegalArgumentException("only inserts and updates can have values");
            }
            if (mValues == null) {
                mValues = new ContentValues();
            }
            if (value == null) {
                mValues.putNull(key);
            } else if (value instanceof String) {
                mValues.put(key, (String) value);
            } else if (value instanceof Byte) {
                mValues.put(key, (Byte) value);
            } else if (value instanceof Short) {
                mValues.put(key, (Short) value);
            } else if (value instanceof Integer) {
                mValues.put(key, (Integer) value);
            } else if (value instanceof Long) {
                mValues.put(key, (Long) value);
            } else if (value instanceof Float) {
                mValues.put(key, (Float) value);
            } else if (value instanceof Double) {
                mValues.put(key, (Double) value);
            } else if (value instanceof Boolean) {
                mValues.put(key, (Boolean) value);
            } else if (value instanceof byte[]) {
                mValues.put(key, (byte[]) value);
            } else {
                throw new IllegalArgumentException("bad value type: " + value.getClass().getName());
            }
            return this;
        }

        /**
         * The selection and arguments to use. An occurrence of '?' in the selection will be
         * replaced with the corresponding occurence of the selection argument. Any of the
         * selection arguments may be overwritten by a selection argument back reference as
         * specified by {@link #withSelectionBackReference}.
         * This can only be used with builders of type update, delete, or assert.
         * @return this builder, to allow for chaining.
         */
        @DSSafe(DSCat.UTIL_FUNCTION)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.206 -0500", hash_original_method = "26D13871C486DC34FECD72252582D17D", hash_generated_method = "6DD5C939ADB84FC524E396FD7DB9EC38")
        
public Builder withSelection(String selection, String[] selectionArgs) {
            if (mType != TYPE_UPDATE && mType != TYPE_DELETE && mType != TYPE_ASSERT) {
                throw new IllegalArgumentException(
                        "only updates, deletes, and asserts can have selections");
            }
            mSelection = selection;
            if (selectionArgs == null) {
                mSelectionArgs = null;
            } else {
                mSelectionArgs = new String[selectionArgs.length];
                System.arraycopy(selectionArgs, 0, mSelectionArgs, 0, selectionArgs.length);
            }
            return this;
        }

        /**
         * If set then if the number of rows affected by this operation do not match
         * this count {@link OperationApplicationException} will be throw.
         * This can only be used with builders of type update, delete, or assert.
         * @return this builder, to allow for chaining.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.209 -0500", hash_original_method = "70A8F698538BA5C44D08715766038CFE", hash_generated_method = "456F4FCC58385CB0B9961642789BC86C")
        
public Builder withExpectedCount(int count) {
            if (mType != TYPE_UPDATE && mType != TYPE_DELETE && mType != TYPE_ASSERT) {
                throw new IllegalArgumentException(
                        "only updates, deletes, and asserts can have expected counts");
            }
            mExpectedCount = count;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.211 -0500", hash_original_method = "1D016C05C5C9EB70F24159159C761C5E", hash_generated_method = "0382E1C7110DC218B8CC1F126CBE7E4E")
        
public Builder withYieldAllowed(boolean yieldAllowed) {
            mYieldAllowed = yieldAllowed;
            return this;
        }
        
    }

    /**
     * Applies this operation using the given provider. The backRefs array is used to resolve any
     * back references that were requested using
     * {@link Builder#withValueBackReferences(ContentValues)} and
     * {@link Builder#withSelectionBackReference}.
     * @param provider the {@link ContentProvider} on which this batch is applied
     * @param backRefs a {@link ContentProviderResult} array that will be consulted
     * to resolve any requested back references.
     * @param numBackRefs the number of valid results on the backRefs array.
     * @return a {@link ContentProviderResult} that contains either the {@link Uri} of the inserted
     * row if this was an insert otherwise the number of rows affected.
     * @throws OperationApplicationException thrown if either the insert fails or
     * if the number of rows affected didn't match the expected count
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.145 -0500", hash_original_method = "2009EEC78D1FCDD51A500D4742040E7C", hash_generated_method = "C3DC8B45984359AE4D4E99DAEB3740CA")
    
public ContentProviderResult apply(ContentProvider provider, ContentProviderResult[] backRefs,
            int numBackRefs) throws OperationApplicationException {
        ContentValues values = resolveValueBackReferences(backRefs, numBackRefs);
        String[] selectionArgs =
                resolveSelectionArgsBackReferences(backRefs, numBackRefs);

        if (mType == TYPE_INSERT) {
            Uri newUri = provider.insert(mUri, values);
            if (newUri == null) {
                throw new OperationApplicationException("insert failed");
            }
            return new ContentProviderResult(newUri);
        }

        int numRows;
        if (mType == TYPE_DELETE) {
            numRows = provider.delete(mUri, mSelection, selectionArgs);
        } else if (mType == TYPE_UPDATE) {
            numRows = provider.update(mUri, values, mSelection, selectionArgs);
        } else if (mType == TYPE_ASSERT) {
            // Assert that all rows match expected values
            String[] projection =  null;
            if (values != null) {
                // Build projection map from expected values
                final ArrayList<String> projectionList = new ArrayList<String>();
                for (Map.Entry<String, Object> entry : values.valueSet()) {
                    projectionList.add(entry.getKey());
                }
                projection = projectionList.toArray(new String[projectionList.size()]);
            }
            final Cursor cursor = provider.query(mUri, projection, mSelection, selectionArgs, null);
            try {
                numRows = cursor.getCount();
                if (projection != null) {
                    while (cursor.moveToNext()) {
                        for (int i = 0; i < projection.length; i++) {
                            final String cursorValue = cursor.getString(i);
                            final String expectedValue = values.getAsString(projection[i]);
                            if (!TextUtils.equals(cursorValue, expectedValue)) {
                                // Throw exception when expected values don't match
                                Log.e(TAG, this.toString());
                                throw new OperationApplicationException("Found value " + cursorValue
                                        + " when expected " + expectedValue + " for column "
                                        + projection[i]);
                            }
                        }
                    }
                }
            } finally {
                cursor.close();
            }
        } else {
            Log.e(TAG, this.toString());
            throw new IllegalStateException("bad type, " + mType);
        }

        if (mExpectedCount != null && mExpectedCount != numRows) {
            Log.e(TAG, this.toString());
            throw new OperationApplicationException("wrong number of rows: " + numRows);
        }

        return new ContentProviderResult(numRows);
    }

    /**
     * The ContentValues back references are represented as a ContentValues object where the
     * key refers to a column and the value is an index of the back reference whose
     * valued should be associated with the column.
     * <p>
     * This is intended to be a private method but it is exposed for
     * unit testing purposes
     * @param backRefs an array of previous results
     * @param numBackRefs the number of valid previous results in backRefs
     * @return the ContentValues that should be used in this operation application after
     * expansion of back references. This can be called if either mValues or mValuesBackReferences
     * is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.148 -0500", hash_original_method = "A962F701648C4B4117BD0A815ABD46EE", hash_generated_method = "C5959FD7F403B73D5FB2665135675C08")
    
public ContentValues resolveValueBackReferences(
            ContentProviderResult[] backRefs, int numBackRefs) {
        if (mValuesBackReferences == null) {
            return mValues;
        }
        final ContentValues values;
        if (mValues == null) {
            values = new ContentValues();
        } else {
            values = new ContentValues(mValues);
        }
        for (Map.Entry<String, Object> entry : mValuesBackReferences.valueSet()) {
            String key = entry.getKey();
            Integer backRefIndex = mValuesBackReferences.getAsInteger(key);
            if (backRefIndex == null) {
                Log.e(TAG, this.toString());
                throw new IllegalArgumentException("values backref " + key + " is not an integer");
            }
            values.put(key, backRefToValue(backRefs, numBackRefs, backRefIndex));
        }
        return values;
    }

    /**
     * The Selection Arguments back references are represented as a Map of Integer->Integer where
     * the key is an index into the selection argument array (see {@link Builder#withSelection})
     * and the value is the index of the previous result that should be used for that selection
     * argument array slot.
     * <p>
     * This is intended to be a private method but it is exposed for
     * unit testing purposes
     * @param backRefs an array of previous results
     * @param numBackRefs the number of valid previous results in backRefs
     * @return the ContentValues that should be used in this operation application after
     * expansion of back references. This can be called if either mValues or mValuesBackReferences
     * is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.150 -0500", hash_original_method = "AA4B64F522D451BE6AD1A7AFC7A63956", hash_generated_method = "BC6D104CE1BC1E4AD54F1CA4AC2521B9")
    
public String[] resolveSelectionArgsBackReferences(
            ContentProviderResult[] backRefs, int numBackRefs) {
        if (mSelectionArgsBackReferences == null) {
            return mSelectionArgs;
        }
        String[] newArgs = new String[mSelectionArgs.length];
        System.arraycopy(mSelectionArgs, 0, newArgs, 0, mSelectionArgs.length);
        for (Map.Entry<Integer, Integer> selectionArgBackRef
                : mSelectionArgsBackReferences.entrySet()) {
            final Integer selectionArgIndex = selectionArgBackRef.getKey();
            final int backRefIndex = selectionArgBackRef.getValue();
            newArgs[selectionArgIndex] =
                    String.valueOf(backRefToValue(backRefs, numBackRefs, backRefIndex));
        }
        return newArgs;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.153 -0500", hash_original_method = "78718167AF18105CAC703FAFB09E4964", hash_generated_method = "CC96DE0BF8ECF143BC34143AD18E9175")
    
@Override
    public String toString() {
        return "mType: " + mType + ", mUri: " + mUri +
                ", mSelection: " + mSelection +
                ", mExpectedCount: " + mExpectedCount +
                ", mYieldAllowed: " + mYieldAllowed +
                ", mValues: " + mValues +
                ", mValuesBackReferences: " + mValuesBackReferences +
                ", mSelectionArgsBackReferences: " + mSelectionArgsBackReferences;
    }

    /**
     * Return the string representation of the requested back reference.
     * @param backRefs an array of results
     * @param numBackRefs the number of items in the backRefs array that are valid
     * @param backRefIndex which backRef to be used
     * @throws ArrayIndexOutOfBoundsException thrown if the backRefIndex is larger than
     * the numBackRefs
     * @return the string representation of the requested back reference.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.155 -0500", hash_original_method = "4E134EAC713EA4116B151015A8D49950", hash_generated_method = "1A2047A58DB966745764F4E01AEDCBEC")
    
private long backRefToValue(ContentProviderResult[] backRefs, int numBackRefs,
            Integer backRefIndex) {
        if (backRefIndex >= numBackRefs) {
            Log.e(TAG, this.toString());
            throw new ArrayIndexOutOfBoundsException("asked for back ref " + backRefIndex
                    + " but there are only " + numBackRefs + " back refs");
        }
        ContentProviderResult backRef = backRefs[backRefIndex];
        long backRefValue;
        if (backRef.uri != null) {
            backRefValue = ContentUris.parseId(backRef.uri);
        } else {
            backRefValue = backRef.count;
        }
        return backRefValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:40.157 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    // orphaned legacy method
    public ContentProviderOperation createFromParcel(Parcel source) {
            return new ContentProviderOperation(source);
        }
    
    // orphaned legacy method
    public ContentProviderOperation[] newArray(int size) {
            return new ContentProviderOperation[size];
        }
    
}

