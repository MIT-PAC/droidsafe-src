package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContentProviderOperation implements Parcelable {
    private int mType;
    private Uri mUri;
    private String mSelection;
    private String[] mSelectionArgs;
    private ContentValues mValues;
    private Integer mExpectedCount;
    private ContentValues mValuesBackReferences;
    private Map<Integer, Integer> mSelectionArgsBackReferences;
    private boolean mYieldAllowed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.418 -0400", hash_original_method = "E83648833C15023B0A37354984B5CA31", hash_generated_method = "B0C9B2BDAF1263DC7B00C354C29A1D50")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.420 -0400", hash_original_method = "9004240102FD3717D6F1BEB293484741", hash_generated_method = "4E2BA7B520A23813D0C1CEED753FD6CF")
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
            int count;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.447 -0400", hash_original_method = "D97604A456AD6CF9916FB862EEBD56CF", hash_generated_method = "CDD39A146CD6D4F68B1DA825C11001CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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
                Iterator<Map.Entry<Integer, Integer>> varF9A47AC3D36EE6FD092FA741211D4924_316614731 = (mSelectionArgsBackReferences.entrySet()).iterator();
                varF9A47AC3D36EE6FD092FA741211D4924_316614731.hasNext();
                Map.Entry<Integer, Integer> entry = varF9A47AC3D36EE6FD092FA741211D4924_316614731.next();
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

    
        public static Builder newInsert(Uri uri) {
        return new Builder(TYPE_INSERT, uri);
    }

    
        public static Builder newUpdate(Uri uri) {
        return new Builder(TYPE_UPDATE, uri);
    }

    
        public static Builder newDelete(Uri uri) {
        return new Builder(TYPE_DELETE, uri);
    }

    
        public static Builder newAssertQuery(Uri uri) {
        return new Builder(TYPE_ASSERT, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.454 -0400", hash_original_method = "225259AA593B6A59F476A2C569F1B075", hash_generated_method = "CA157FF276D4C63A050BB248CD0D94B8")
    @DSModeled(DSC.SPEC)
    public Uri getUri() {
        return (Uri)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.455 -0400", hash_original_method = "0D76D2BF4F9E314AF3AEB01067FC98E0", hash_generated_method = "55A9C109CAE5C4219B0B6D2E331B74ED")
    @DSModeled(DSC.SAFE)
    public boolean isYieldAllowed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mYieldAllowed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.455 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "66DFEA4B0062EB4492784966BCFD516E")
    @DSModeled(DSC.SAFE)
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.455 -0400", hash_original_method = "94452D9A7E20FFB1CE97B24DC927192A", hash_generated_method = "7C3F3B5C5FD969C67E5A182750F505DF")
    @DSModeled(DSC.SAFE)
    public boolean isWriteOperation() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mType == TYPE_DELETE || mType == TYPE_INSERT || mType == TYPE_UPDATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.456 -0400", hash_original_method = "BBB0424C7EB706D24B64E8DBE01BF66B", hash_generated_method = "4496ABD880FB6B82989A4DAD221AA372")
    @DSModeled(DSC.SAFE)
    public boolean isReadOperation() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mType == TYPE_ASSERT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.523 -0400", hash_original_method = "2009EEC78D1FCDD51A500D4742040E7C", hash_generated_method = "BE0ED3C58458215743EFF7D613DCD881")
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
            ContentProviderResult var5716CD9436284F5B25FDEAD6A726C271_574282632 = (new ContentProviderResult(newUri));
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
                ArrayList<String> projectionList;
                projectionList = new ArrayList<String>();
                {
                    Iterator<Map.Entry<String, Object>> var94CAE6D127D9B49254CA403A57DB3B0A_221065913 = (values.valueSet()).iterator();
                    var94CAE6D127D9B49254CA403A57DB3B0A_221065913.hasNext();
                    Map.Entry<String, Object> entry = var94CAE6D127D9B49254CA403A57DB3B0A_221065913.next();
                    {
                        projectionList.add(entry.getKey());
                    } //End block
                } //End collapsed parenthetic
                projection = projectionList.toArray(new String[projectionList.size()]);
            } //End block
            Cursor cursor;
            cursor = provider.query(mUri, projection, mSelection, selectionArgs, null);
            try 
            {
                numRows = cursor.getCount();
                {
                    {
                        boolean var4B88A4E0CCE1DD5CDA31BC6F14F1DD3B_649459057 = (cursor.moveToNext());
                        {
                            {
                                int i;
                                i = 0;
                                {
                                    String cursorValue;
                                    cursorValue = cursor.getString(i);
                                    String expectedValue;
                                    expectedValue = values.getAsString(projection[i]);
                                    {
                                        boolean var315C9A13C4CF5F1A59783370621A4A5F_887501928 = (!TextUtils.equals(cursorValue, expectedValue));
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
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("bad type, " + mType);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new OperationApplicationException("wrong number of rows: " + numRows);
        } //End block
        ContentProviderResult varA22B6C75C418C02533B23F7B4802A693_1506585666 = (new ContentProviderResult(numRows));
        return (ContentProviderResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.558 -0400", hash_original_method = "A962F701648C4B4117BD0A815ABD46EE", hash_generated_method = "DDA17F1641D02E075DDA6E6F0F5177B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentValues resolveValueBackReferences(
            ContentProviderResult[] backRefs, int numBackRefs) {
        dsTaint.addTaint(backRefs[0].dsTaint);
        dsTaint.addTaint(numBackRefs);
        ContentValues values;
        {
            values = new ContentValues();
        } //End block
        {
            values = new ContentValues(mValues);
        } //End block
        {
            Iterator<Map.Entry<String, Object>> varEAD7F71FAB82DBE4DFEC649FA82C88FE_1324164089 = (mValuesBackReferences.valueSet()).iterator();
            varEAD7F71FAB82DBE4DFEC649FA82C88FE_1324164089.hasNext();
            Map.Entry<String, Object> entry = varEAD7F71FAB82DBE4DFEC649FA82C88FE_1324164089.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.579 -0400", hash_original_method = "AA4B64F522D451BE6AD1A7AFC7A63956", hash_generated_method = "087520F19927599370FF52A064C801FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] resolveSelectionArgsBackReferences(
            ContentProviderResult[] backRefs, int numBackRefs) {
        dsTaint.addTaint(backRefs[0].dsTaint);
        dsTaint.addTaint(numBackRefs);
        String[] newArgs;
        newArgs = new String[mSelectionArgs.length];
        System.arraycopy(mSelectionArgs, 0, newArgs, 0, mSelectionArgs.length);
        {
            Iterator<Map.Entry<Integer, Integer>> varE4ACC7EC0785CAFCE8884A18E88D0ADD_1524719660 = (mSelectionArgsBackReferences.entrySet()).iterator();
            varE4ACC7EC0785CAFCE8884A18E88D0ADD_1524719660.hasNext();
            Map.Entry<Integer, Integer> selectionArgBackRef = varE4ACC7EC0785CAFCE8884A18E88D0ADD_1524719660.next();
            {
                Integer selectionArgIndex;
                selectionArgIndex = selectionArgBackRef.getKey();
                int backRefIndex;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.580 -0400", hash_original_method = "78718167AF18105CAC703FAFB09E4964", hash_generated_method = "AB13F94C1BEBF0171BCD0C98065525BC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.581 -0400", hash_original_method = "4E134EAC713EA4116B151015A8D49950", hash_generated_method = "301AC26D8FBD7F7F86307C6A42C975B9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.581 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static class Builder {
        private int mType;
        private Uri mUri;
        private String mSelection;
        private String[] mSelectionArgs;
        private ContentValues mValues;
        private Integer mExpectedCount;
        private ContentValues mValuesBackReferences;
        private Map<Integer, Integer> mSelectionArgsBackReferences;
        private boolean mYieldAllowed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.581 -0400", hash_original_method = "E4683F1EC70220B8EE12920060472DE0", hash_generated_method = "FDD04916EB521A156A23EE0B8871CBD0")
        @DSModeled(DSC.SPEC)
        private Builder(int type, Uri uri) {
            dsTaint.addTaint(type);
            dsTaint.addTaint(uri.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("uri must not be null");
            } //End block
            // ---------- Original Method ----------
            //if (uri == null) {
                //throw new IllegalArgumentException("uri must not be null");
            //}
            //mType = type;
            //mUri = uri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.584 -0400", hash_original_method = "52DF5CD1F3EDB944F65D1FF1857828C4", hash_generated_method = "80FBA8C1C74BB70A0B4CC716826661C6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ContentProviderOperation build() {
            {
                {
                    boolean varE217E6379D20B25A0EC064610B0EEA97_627632999 = ((mValues == null || mValues.size() == 0)
                        && (mValuesBackReferences == null || mValuesBackReferences.size() == 0));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Empty values");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var35BFBE8564F87B211AE46E433A8E370B_642348163 = ((mValues == null || mValues.size() == 0)
                        && (mValuesBackReferences == null || mValuesBackReferences.size() == 0)
                        && (mExpectedCount == null));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Empty values");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            ContentProviderOperation varADF48C10DE1F13285BDAE9DBC22DA0CB_586560212 = (new ContentProviderOperation(this));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.585 -0400", hash_original_method = "48DEB08B58C335127E8366C72D237182", hash_generated_method = "D6AAC6F58BC6876F7B116201956D6886")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder withValueBackReferences(ContentValues backReferences) {
            dsTaint.addTaint(backReferences.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.585 -0400", hash_original_method = "9B7E0512DF416F22106A40FEC0A8A4AE", hash_generated_method = "13277E7EBBA5657FB54684E37614ED8E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder withValueBackReference(String key, int previousResult) {
            dsTaint.addTaint(previousResult);
            dsTaint.addTaint(key);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.586 -0400", hash_original_method = "0B4CE4049FC576DCE44E5153CA371A5B", hash_generated_method = "F00D23872631DBD8926E4351621C49C2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder withSelectionBackReference(int selectionArgIndex, int previousResult) {
            dsTaint.addTaint(previousResult);
            dsTaint.addTaint(selectionArgIndex);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("only updates, deletes, and asserts "
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.594 -0400", hash_original_method = "F7B8F8808C4F5F5C0301B85A5CF2FD8A", hash_generated_method = "036C9DADD4C75E897AE081CAC2D12723")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder withValues(ContentValues values) {
            dsTaint.addTaint(values.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.595 -0400", hash_original_method = "E35FC6F92508151B3604E11EFF6133FA", hash_generated_method = "5174A88A0F3B734EE0FCDAD70613FB28")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder withValue(String key, Object value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("only inserts and updates can have values");
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
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bad value type: " + value.getClass().getName());
            } //End block
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.595 -0400", hash_original_method = "26D13871C486DC34FECD72252582D17D", hash_generated_method = "DE61E107DA56C7EEAF3DA9E720E90B29")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder withSelection(String selection, String[] selectionArgs) {
            dsTaint.addTaint(selectionArgs[0]);
            dsTaint.addTaint(selection);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.596 -0400", hash_original_method = "70A8F698538BA5C44D08715766038CFE", hash_generated_method = "4F376B23665626312E4E0E6B0A5872FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.596 -0400", hash_original_method = "1D016C05C5C9EB70F24159159C761C5E", hash_generated_method = "F252A04E107D2286FEA5A330FD0A12F4")
        @DSModeled(DSC.SAFE)
        public Builder withYieldAllowed(boolean yieldAllowed) {
            dsTaint.addTaint(yieldAllowed);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mYieldAllowed = yieldAllowed;
            //return this;
        }

        
    }


    
    public final static int TYPE_INSERT = 1;
    public final static int TYPE_UPDATE = 2;
    public final static int TYPE_DELETE = 3;
    public final static int TYPE_ASSERT = 4;
    private final static String TAG = "ContentProviderOperation";
    public static final Creator<ContentProviderOperation> CREATOR = new Creator<ContentProviderOperation>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.597 -0400", hash_original_method = "51820FE0219C3C2B0FA218CF2A0EC3F5", hash_generated_method = "EFE6FB5147174B2BCCE00E3D729EA34A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ContentProviderOperation createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            ContentProviderOperation var9A4C85FC7798F452627A3142BD1AA5B9_607073239 = (new ContentProviderOperation(source));
            return (ContentProviderOperation)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ContentProviderOperation(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.597 -0400", hash_original_method = "2D91FDE6EFE31D278C02C8E00CD99BE3", hash_generated_method = "F23D542C457920F47982174E62BF9422")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ContentProviderOperation[] newArray(int size) {
            dsTaint.addTaint(size);
            ContentProviderOperation[] var4CCD9E614EEE13FAE561033FB67A51E2_1923966552 = (new ContentProviderOperation[size]);
            return (ContentProviderOperation[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ContentProviderOperation[size];
        }

        
}; //Transformed anonymous class
}

