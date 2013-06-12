package android.content;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.HashMap;
// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;
import java.util.Map;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public class ContentProviderOperation implements Parcelable {
    public final static int TYPE_INSERT = 1;
    public final static int TYPE_UPDATE = 2;
    public final static int TYPE_DELETE = 3;
    public final static int TYPE_ASSERT = 4;
    private final int mType;
    private final Uri mUri;
    private final String mSelection;
    private final String[] mSelectionArgs;
    private final ContentValues mValues;
    private final Integer mExpectedCount;
    private final ContentValues mValuesBackReferences;
    private final Map<Integer, Integer> mSelectionArgsBackReferences;
    private final boolean mYieldAllowed;
    private final static String TAG = "ContentProviderOperation";
    public static final Creator<ContentProviderOperation> CREATOR = new Creator<ContentProviderOperation>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.378 -0400", hash_original_method = "51820FE0219C3C2B0FA218CF2A0EC3F5", hash_generated_method = "CB759FCC1ED90997B9658ACA6733A319")
        @DSModeled(DSC.SAFE)
        public ContentProviderOperation createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (ContentProviderOperation)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ContentProviderOperation(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.378 -0400", hash_original_method = "2D91FDE6EFE31D278C02C8E00CD99BE3", hash_generated_method = "5F97A5FEAA8753B9A109C1C99FF58677")
        @DSModeled(DSC.SAFE)
        public ContentProviderOperation[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ContentProviderOperation[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ContentProviderOperation[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.379 -0400", hash_original_method = "E83648833C15023B0A37354984B5CA31", hash_generated_method = "60C5AA4909A90ECA2862B7DBD10C4E1C")
    @DSModeled(DSC.SAFE)
    private ContentProviderOperation(Builder builder) {
        dsTaint.addTaint(builder.dsTaint);
        mType = builder.mType;
        mUri = builder.mUri;
        mValues = builder.mValues;
        mSelection = builder.mSelection;
        mSelectionArgs = builder.mSelectionArgs;
        mExpectedCount = builder.mExpectedCount;
        mSelectionArgsBackReferences = builder.mSelectionArgsBackReferences;
        mValuesBackReferences = builder.mValuesBackReferences;
        mYieldAllowed = builder.mYieldAllowed;
        // ---------- Original Method ----------
        //mType = builder.mType;
        //mUri = builder.mUri;
        //mValues = builder.mValues;
        //mSelection = builder.mSelection;
        //mSelectionArgs = builder.mSelectionArgs;
        //mExpectedCount = builder.mExpectedCount;
        //mSelectionArgsBackReferences = builder.mSelectionArgsBackReferences;
        //mValuesBackReferences = builder.mValuesBackReferences;
        //mYieldAllowed = builder.mYieldAllowed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.379 -0400", hash_original_method = "9004240102FD3717D6F1BEB293484741", hash_generated_method = "E9A6A873E9FE4ECD68DC386742E9C8A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ContentProviderOperation(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
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
        {
            final int count;
            count = source.readInt();
            {
                int i;
                i = 0;
                {
                    mSelectionArgsBackReferences.put(source.readInt(), source.readInt());
                } //End block
            } //End collapsed parenthetic
        } //End block
        mYieldAllowed = source.readInt() != 0;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.380 -0400", hash_original_method = "D97604A456AD6CF9916FB862EEBD56CF", hash_generated_method = "115D42CB79CAE1F513E353734AD2F54D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeInt(mType);
        Uri.writeToParcel(dest, mUri);
        {
            dest.writeInt(1);
            mValues.writeToParcel(dest, 0);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        {
            dest.writeInt(1);
            dest.writeString(mSelection);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        {
            dest.writeInt(1);
            dest.writeStringArray(mSelectionArgs);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        {
            dest.writeInt(1);
            dest.writeInt(mExpectedCount);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        {
            dest.writeInt(1);
            mValuesBackReferences.writeToParcel(dest, 0);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        {
            dest.writeInt(1);
            dest.writeInt(mSelectionArgsBackReferences.size());
            {
                Iterator<Map.Entry<Integer, Integer>> seatecAstronomy42 = mSelectionArgsBackReferences.entrySet().iterator();
                seatecAstronomy42.hasNext();
                Map.Entry<Integer, Integer> entry = seatecAstronomy42.next();
                {
                    dest.writeInt(entry.getKey());
                    dest.writeInt(entry.getValue());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            dest.writeInt(0);
        } //End block
        dest.writeInt(mYieldAllowed ? 1 : 0);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.380 -0400", hash_original_method = "659152B169A2C44F2069F1FBAB7EA425", hash_generated_method = "8E84DD8A649E9BFE8BB57FD3211E375E")
    public static Builder newInsert(Uri uri) {
        return new Builder(TYPE_INSERT, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.380 -0400", hash_original_method = "097853FC9EACA1E091D66FAF08F5EA14", hash_generated_method = "180AD0F65CDA32AC36FC95AF3B1A04B0")
    public static Builder newUpdate(Uri uri) {
        return new Builder(TYPE_UPDATE, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.381 -0400", hash_original_method = "0693BC23F33A94F2A72DA35D1DD7A47F", hash_generated_method = "1A8C4FF33BF0D211678913E79B9F602D")
    public static Builder newDelete(Uri uri) {
        return new Builder(TYPE_DELETE, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.381 -0400", hash_original_method = "2FE81C83AAA3592BACCD9712E1EDEBCE", hash_generated_method = "D090396712FE1D19CF55E07572224F10")
    public static Builder newAssertQuery(Uri uri) {
        return new Builder(TYPE_ASSERT, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.381 -0400", hash_original_method = "225259AA593B6A59F476A2C569F1B075", hash_generated_method = "94C4A5FE659081F708F6FF00E69FFC4B")
    @DSModeled(DSC.SPEC)
    public Uri getUri() {
        return (Uri)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.381 -0400", hash_original_method = "0D76D2BF4F9E314AF3AEB01067FC98E0", hash_generated_method = "4EB5C44D47D9473593DF6D916FF6C044")
    @DSModeled(DSC.SAFE)
    public boolean isYieldAllowed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mYieldAllowed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.382 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "E6C0F4DA24DEB386955E797B464A5714")
    @DSModeled(DSC.SAFE)
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.382 -0400", hash_original_method = "94452D9A7E20FFB1CE97B24DC927192A", hash_generated_method = "1DCEDD0BE2D5215287963BCF14919F4B")
    @DSModeled(DSC.SAFE)
    public boolean isWriteOperation() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mType == TYPE_DELETE || mType == TYPE_INSERT || mType == TYPE_UPDATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.382 -0400", hash_original_method = "BBB0424C7EB706D24B64E8DBE01BF66B", hash_generated_method = "292B0AB3CECCFD2BC9EF096501ED192A")
    @DSModeled(DSC.SAFE)
    public boolean isReadOperation() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mType == TYPE_ASSERT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.383 -0400", hash_original_method = "2009EEC78D1FCDD51A500D4742040E7C", hash_generated_method = "898FE6C74FB4EBEADF4D87E179E6156B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentProviderResult apply(ContentProvider provider, ContentProviderResult[] backRefs,
            int numBackRefs) throws OperationApplicationException {
        dsTaint.addTaint(backRefs[0].dsTaint);
        dsTaint.addTaint(numBackRefs);
        dsTaint.addTaint(provider.dsTaint);
        ContentValues values;
        values = resolveValueBackReferences(backRefs, numBackRefs);
        String[] selectionArgs;
        selectionArgs = resolveSelectionArgsBackReferences(backRefs, numBackRefs);
        {
            Uri newUri;
            newUri = provider.insert(mUri, values);
            {
            	if (DroidSafeAndroidRuntime.control) throw new OperationApplicationException("insert failed");
            } //End block
        } //End block
        int numRows;
        {
            numRows = provider.delete(mUri, mSelection, selectionArgs);
        } //End block
        {
            numRows = provider.update(mUri, values, mSelection, selectionArgs);
        } //End block
        {
            String[] projection;
            projection = null;
            {
                final ArrayList<String> projectionList;
                projectionList = new ArrayList<String>();
                {
                    Iterator<Map.Entry<String, Object>> seatecAstronomy42 = values.valueSet().iterator();
                    seatecAstronomy42.hasNext();
                    Map.Entry<String, Object> entry = seatecAstronomy42.next();
                    {
                        projectionList.add(entry.getKey());
                    } //End block
                } //End collapsed parenthetic
                projection = projectionList.toArray(new String[projectionList.size()]);
            } //End block
            final Cursor cursor;
            cursor = provider.query(mUri, projection, mSelection, selectionArgs, null);
            try 
            {
                numRows = cursor.getCount();
                {
                    {
                        boolean var4B88A4E0CCE1DD5CDA31BC6F14F1DD3B_926663190 = (cursor.moveToNext());
                        {
                            {
                                int i;
                                i = 0;
                                {
                                    final String cursorValue;
                                    cursorValue = cursor.getString(i);
                                    final String expectedValue;
                                    expectedValue = values.getAsString(projection[i]);
                                    {
                                        boolean var315C9A13C4CF5F1A59783370621A4A5F_1263709643 = (!TextUtils.equals(cursorValue, expectedValue));
                                        {
                                        	if (DroidSafeAndroidRuntime.control) throw new OperationApplicationException("Found value " + cursorValue
                                        + " when expected " + expectedValue + " for column "
                                        + projection[i]);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            finally 
            {
                cursor.close();
            } //End block
        } //End block
        {
        	if (DroidSafeAndroidRuntime.control)throw new IllegalStateException("bad type, " + mType);
        } //End block
        {
        	if (DroidSafeAndroidRuntime.control)throw new OperationApplicationException("wrong number of rows: " + numRows);
        } //End block
        return (ContentProviderResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.383 -0400", hash_original_method = "A962F701648C4B4117BD0A815ABD46EE", hash_generated_method = "7A03BA376D0038F5155AC6BC0512E77B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentValues resolveValueBackReferences(
            ContentProviderResult[] backRefs, int numBackRefs) {
        dsTaint.addTaint(backRefs[0].dsTaint);
        dsTaint.addTaint(numBackRefs);
        final ContentValues values;
        {
            values = new ContentValues();
        } //End block
       
        {
            Iterator<Map.Entry<String, Object>> seatecAstronomy42 = mValuesBackReferences.valueSet().iterator();
            seatecAstronomy42.hasNext();
            Map.Entry<String, Object> entry = seatecAstronomy42.next();
            {
                String key;
                key = entry.getKey();
                Integer backRefIndex;
                backRefIndex = mValuesBackReferences.getAsInteger(key);
                {
                	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("values backref " + key + " is not an integer");
                } //End block
                values.put(key, backRefToValue(backRefs, numBackRefs, backRefIndex));
            } //End block
        } //End collapsed parenthetic
        return (ContentValues)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mValuesBackReferences == null) {
            //return mValues;
        //}
        //final ContentValues values;
        //if (mValues == null) {
            //values = new ContentValues();
        //} else {
            //values = new ContentValues(mValues);
        //}
        //for (Map.Entry<String, Object> entry : mValuesBackReferences.valueSet()) {
            //String key = entry.getKey();
            //Integer backRefIndex = mValuesBackReferences.getAsInteger(key);
            //if (backRefIndex == null) {
                //Log.e(TAG, this.toString());
                //throw new IllegalArgumentException("values backref " + key + " is not an integer");
            //}
            //values.put(key, backRefToValue(backRefs, numBackRefs, backRefIndex));
        //}
        //return values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.384 -0400", hash_original_method = "AA4B64F522D451BE6AD1A7AFC7A63956", hash_generated_method = "7F04C0C78AB1C0760539DBB211ACF581")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] resolveSelectionArgsBackReferences(
            ContentProviderResult[] backRefs, int numBackRefs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(backRefs[0].dsTaint);
        dsTaint.addTaint(numBackRefs);
        String[] newArgs;
        newArgs = new String[mSelectionArgs.length];
        System.arraycopy(mSelectionArgs, 0, newArgs, 0, mSelectionArgs.length);
        {
            Iterator<Map.Entry<Integer, Integer>> seatecAstronomy42 = mSelectionArgsBackReferences.entrySet().iterator();
            seatecAstronomy42.hasNext();
            Map.Entry<Integer, Integer> selectionArgBackRef = seatecAstronomy42.next();
            {
                final Integer selectionArgIndex;
                selectionArgIndex = selectionArgBackRef.getKey();
                final int backRefIndex;
                backRefIndex = selectionArgBackRef.getValue();
                newArgs[selectionArgIndex] =
                    String.valueOf(backRefToValue(backRefs, numBackRefs, backRefIndex));
            } //End block
        } //End collapsed parenthetic
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //if (mSelectionArgsBackReferences == null) {
            //return mSelectionArgs;
        //}
        //String[] newArgs = new String[mSelectionArgs.length];
        //System.arraycopy(mSelectionArgs, 0, newArgs, 0, mSelectionArgs.length);
        //for (Map.Entry<Integer, Integer> selectionArgBackRef
                //: mSelectionArgsBackReferences.entrySet()) {
            //final Integer selectionArgIndex = selectionArgBackRef.getKey();
            //final int backRefIndex = selectionArgBackRef.getValue();
            //newArgs[selectionArgIndex] =
                    //String.valueOf(backRefToValue(backRefs, numBackRefs, backRefIndex));
        //}
        //return newArgs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.384 -0400", hash_original_method = "78718167AF18105CAC703FAFB09E4964", hash_generated_method = "D1F25520D63543B3A2C4117DBD2D3015")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "mType: " + mType + ", mUri: " + mUri +
                //", mSelection: " + mSelection +
                //", mExpectedCount: " + mExpectedCount +
                //", mYieldAllowed: " + mYieldAllowed +
                //", mValues: " + mValues +
                //", mValuesBackReferences: " + mValuesBackReferences +
                //", mSelectionArgsBackReferences: " + mSelectionArgsBackReferences;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.385 -0400", hash_original_method = "4E134EAC713EA4116B151015A8D49950", hash_generated_method = "3F37FB5925DD3FBA1DAB9DF251AE5C2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long backRefToValue(ContentProviderResult[] backRefs, int numBackRefs,
            Integer backRefIndex) {
        dsTaint.addTaint(backRefs[0].dsTaint);
        dsTaint.addTaint(numBackRefs);
        dsTaint.addTaint(backRefIndex.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException("asked for back ref " + backRefIndex
                    + " but there are only " + numBackRefs + " back refs");
        } //End block
        ContentProviderResult backRef;
        backRef = backRefs[backRefIndex];
        long backRefValue;
        {
            backRefValue = ContentUris.parseId(backRef.uri);
        } //End block
        {
            backRefValue = backRef.count;
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (backRefIndex >= numBackRefs) {
            //Log.e(TAG, this.toString());
            //throw new ArrayIndexOutOfBoundsException("asked for back ref " + backRefIndex
                    //+ " but there are only " + numBackRefs + " back refs");
        //}
        //ContentProviderResult backRef = backRefs[backRefIndex];
        //long backRefValue;
        //if (backRef.uri != null) {
            //backRefValue = ContentUris.parseId(backRef.uri);
        //} else {
            //backRefValue = backRef.count;
        //}
        //return backRefValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.385 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static class Builder {
        private final int mType;
        private final Uri mUri;
        private String mSelection;
        private String[] mSelectionArgs;
        private ContentValues mValues;
        private Integer mExpectedCount;
        private ContentValues mValuesBackReferences;
        private Map<Integer, Integer> mSelectionArgsBackReferences;
        private boolean mYieldAllowed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.385 -0400", hash_original_method = "E4683F1EC70220B8EE12920060472DE0", hash_generated_method = "AFB73698DFD8CBFCA5A208B51C86BC40")
        @DSModeled(DSC.SPEC)
        private Builder(int type, Uri uri) {
            dsTaint.addTaint(type);
            dsTaint.addTaint(uri.dsTaint);
            {
                throw new IllegalArgumentException("uri must not be null");
            } //End block
            // ---------- Original Method ----------
            //if (uri == null) {
                //throw new IllegalArgumentException("uri must not be null");
            //}
            //mType = type;
            //mUri = uri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.386 -0400", hash_original_method = "52DF5CD1F3EDB944F65D1FF1857828C4", hash_generated_method = "B4B354B7D49E050F9C3306EF69D35D04")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ContentProviderOperation build() {
            {
                {
                    boolean varE217E6379D20B25A0EC064610B0EEA97_173084012 = ((mValues == null || mValues.size() == 0)
                        && (mValuesBackReferences == null || mValuesBackReferences.size() == 0));
                    {
                    	if (DroidSafeAndroidRuntime.control)throw new IllegalArgumentException("Empty values");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var35BFBE8564F87B211AE46E433A8E370B_1950760476 = ((mValues == null || mValues.size() == 0)
                        && (mValuesBackReferences == null || mValuesBackReferences.size() == 0)
                        && (mExpectedCount == null));
                    {
                    	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Empty values");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            return (ContentProviderOperation)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mType == TYPE_UPDATE) {
                //if ((mValues == null || mValues.size() == 0)
                        //&& (mValuesBackReferences == null || mValuesBackReferences.size() == 0)) {
                    //throw new IllegalArgumentException("Empty values");
                //}
            //}
            //if (mType == TYPE_ASSERT) {
                //if ((mValues == null || mValues.size() == 0)
                        //&& (mValuesBackReferences == null || mValuesBackReferences.size() == 0)
                        //&& (mExpectedCount == null)) {
                    //throw new IllegalArgumentException("Empty values");
                //}
            //}
            //return new ContentProviderOperation(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.386 -0400", hash_original_method = "48DEB08B58C335127E8366C72D237182", hash_generated_method = "EB8D625D926EA66CB5128C65B8ED4475")
        @DSModeled(DSC.SAFE)
        public Builder withValueBackReferences(ContentValues backReferences) {
            dsTaint.addTaint(backReferences.dsTaint);
            {
            	if (DroidSafeAndroidRuntime.control)throw new IllegalArgumentException(
                        "only inserts, updates, and asserts can have value back-references");
            } //End block
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mType != TYPE_INSERT && mType != TYPE_UPDATE && mType != TYPE_ASSERT) {
                //throw new IllegalArgumentException(
                        //"only inserts, updates, and asserts can have value back-references");
            //}
            //mValuesBackReferences = backReferences;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.386 -0400", hash_original_method = "9B7E0512DF416F22106A40FEC0A8A4AE", hash_generated_method = "446CA20BD7F8385C693CFEDD040F4E2F")
        @DSModeled(DSC.SAFE)
        public Builder withValueBackReference(String key, int previousResult) {
            dsTaint.addTaint(previousResult);
            dsTaint.addTaint(key);
            {
            	if (DroidSafeAndroidRuntime.control)throw new IllegalArgumentException(
                        "only inserts, updates, and asserts can have value back-references");
            } //End block
            {
                mValuesBackReferences = new ContentValues();
            } //End block
            mValuesBackReferences.put(key, previousResult);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mType != TYPE_INSERT && mType != TYPE_UPDATE && mType != TYPE_ASSERT) {
                //throw new IllegalArgumentException(
                        //"only inserts, updates, and asserts can have value back-references");
            //}
            //if (mValuesBackReferences == null) {
                //mValuesBackReferences = new ContentValues();
            //}
            //mValuesBackReferences.put(key, previousResult);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.387 -0400", hash_original_method = "0B4CE4049FC576DCE44E5153CA371A5B", hash_generated_method = "E1AFCF2BA7C3EBB45FE2B3C1AA5DF032")
        @DSModeled(DSC.SAFE)
        public Builder withSelectionBackReference(int selectionArgIndex, int previousResult) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(previousResult);
            dsTaint.addTaint(selectionArgIndex);
            {
            	if (DroidSafeAndroidRuntime.control)throw new IllegalArgumentException("only updates, deletes, and asserts "
                        + "can have selection back-references");
            } //End block
            {
                mSelectionArgsBackReferences = new HashMap<Integer, Integer>();
            } //End block
            mSelectionArgsBackReferences.put(selectionArgIndex, previousResult);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mType != TYPE_UPDATE && mType != TYPE_DELETE && mType != TYPE_ASSERT) {
                //throw new IllegalArgumentException("only updates, deletes, and asserts "
                        //+ "can have selection back-references");
            //}
            //if (mSelectionArgsBackReferences == null) {
                //mSelectionArgsBackReferences = new HashMap<Integer, Integer>();
            //}
            //mSelectionArgsBackReferences.put(selectionArgIndex, previousResult);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.387 -0400", hash_original_method = "F7B8F8808C4F5F5C0301B85A5CF2FD8A", hash_generated_method = "A47235E81F4F0CD8F44BFAD64255CA91")
        @DSModeled(DSC.SAFE)
        public Builder withValues(ContentValues values) {
            dsTaint.addTaint(values.dsTaint);
            {
            	if (DroidSafeAndroidRuntime.control)throw new IllegalArgumentException(
                        "only inserts, updates, and asserts can have values");
            } //End block
            {
                mValues = new ContentValues();
            } //End block
            mValues.putAll(values);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mType != TYPE_INSERT && mType != TYPE_UPDATE && mType != TYPE_ASSERT) {
                //throw new IllegalArgumentException(
                        //"only inserts, updates, and asserts can have values");
            //}
            //if (mValues == null) {
                //mValues = new ContentValues();
            //}
            //mValues.putAll(values);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.388 -0400", hash_original_method = "E35FC6F92508151B3604E11EFF6133FA", hash_generated_method = "DA794DBDDABF34372166AAEFC0E2C137")
        @DSModeled(DSC.SAFE)
        public Builder withValue(String key, Object value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key);
            {
            	if (DroidSafeAndroidRuntime.control)throw new IllegalArgumentException("only inserts and updates can have values");
            } //End block
            {
                mValues = new ContentValues();
            } //End block
            {
                mValues.putNull(key);
            } //End block
            {
                mValues.put(key, (String) value);
            } //End block
            {
                mValues.put(key, (Byte) value);
            } //End block
            {
                mValues.put(key, (Short) value);
            } //End block
            {
                mValues.put(key, (Integer) value);
            } //End block
            {
                mValues.put(key, (Long) value);
            } //End block
            {
                mValues.put(key, (Float) value);
            } //End block
            {
                mValues.put(key, (Double) value);
            } //End block
            {
                mValues.put(key, (Boolean) value);
            } //End block
            {
                mValues.put(key, (byte[]) value);
            } //End block
            {
            	if (DroidSafeAndroidRuntime.control)throw new IllegalArgumentException("bad value type: " + value.getClass().getName());
            } //End block
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.388 -0400", hash_original_method = "26D13871C486DC34FECD72252582D17D", hash_generated_method = "3A41F5BB50B74530ED29538F6E244228")
        @DSModeled(DSC.SAFE)
        public Builder withSelection(String selection, String[] selectionArgs) {
            dsTaint.addTaint(selectionArgs);
            dsTaint.addTaint(selection);
            {
            	if (DroidSafeAndroidRuntime.control)throw new IllegalArgumentException(
                        "only updates, deletes, and asserts can have selections");
            } //End block
            {
                mSelectionArgs = null;
            } //End block
            {
                mSelectionArgs = new String[selectionArgs.length];
                System.arraycopy(selectionArgs, 0, mSelectionArgs, 0, selectionArgs.length);
            } //End block
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mType != TYPE_UPDATE && mType != TYPE_DELETE && mType != TYPE_ASSERT) {
                //throw new IllegalArgumentException(
                        //"only updates, deletes, and asserts can have selections");
            //}
            //mSelection = selection;
            //if (selectionArgs == null) {
                //mSelectionArgs = null;
            //} else {
                //mSelectionArgs = new String[selectionArgs.length];
                //System.arraycopy(selectionArgs, 0, mSelectionArgs, 0, selectionArgs.length);
            //}
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.388 -0400", hash_original_method = "70A8F698538BA5C44D08715766038CFE", hash_generated_method = "B833D71E244B6BC3331013454D7E34A7")
        @DSModeled(DSC.SAFE)
        public Builder withExpectedCount(int count) {
            dsTaint.addTaint(count);
            {
            	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "only updates, deletes, and asserts can have expected counts");
            } //End block
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mType != TYPE_UPDATE && mType != TYPE_DELETE && mType != TYPE_ASSERT) {
                //throw new IllegalArgumentException(
                        //"only updates, deletes, and asserts can have expected counts");
            //}
            //mExpectedCount = count;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.388 -0400", hash_original_method = "1D016C05C5C9EB70F24159159C761C5E", hash_generated_method = "4234D7B929BE0498DAA8F273BCE62AB7")
        @DSModeled(DSC.SAFE)
        public Builder withYieldAllowed(boolean yieldAllowed) {
            dsTaint.addTaint(yieldAllowed);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mYieldAllowed = yieldAllowed;
            //return this;
        }

        
    }


    
}


