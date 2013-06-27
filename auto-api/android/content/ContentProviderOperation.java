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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.766 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.766 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

    private Uri mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.767 -0400", hash_original_field = "D53310829851F4FC641DE95C4A986129", hash_generated_field = "B8B15EC2943749CD20950EAD77AF5EC7")

    private String mSelection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.767 -0400", hash_original_field = "BAEA1B6F996F3986EF68E88ECD2F5469", hash_generated_field = "5541CF5102D1C94942E84E1E2C6A7EFF")

    private String[] mSelectionArgs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.767 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "2CDA41B4D101B2B770760EBED9C98242")

    private ContentValues mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.767 -0400", hash_original_field = "CCF3A996E025C390C9379F65A4EEC523", hash_generated_field = "0366D826BB05344215E0357A75CDC773")

    private Integer mExpectedCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.768 -0400", hash_original_field = "CF4CD4AE5739BE664E237169162A57FD", hash_generated_field = "5CDBA65FCD489D4F2D0BCD78A8638FD5")

    private ContentValues mValuesBackReferences;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.768 -0400", hash_original_field = "6235C72C3DC414902F946F7E4F463896", hash_generated_field = "F3EB1F15BD72236CAC0D0000DA6E4595")

    private Map<Integer, Integer> mSelectionArgsBackReferences;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.768 -0400", hash_original_field = "B3463DA9E487038FF44897CC868147B7", hash_generated_field = "878B9839823FAA28C7AD4A475721F913")

    private boolean mYieldAllowed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.780 -0400", hash_original_method = "E83648833C15023B0A37354984B5CA31", hash_generated_method = "82CDA661D135A6B2C13B951998951636")
    private  ContentProviderOperation(Builder builder) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.801 -0400", hash_original_method = "9004240102FD3717D6F1BEB293484741", hash_generated_method = "8E4A4589423BD4E1866D0D820EFBD612")
    private  ContentProviderOperation(Parcel source) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.927 -0400", hash_original_method = "D97604A456AD6CF9916FB862EEBD56CF", hash_generated_method = "2C7C7B24000009D8342BF823080188F9")
    public void writeToParcel(Parcel dest, int flags) {
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
                Iterator<Map.Entry<Integer, Integer>> varF9A47AC3D36EE6FD092FA741211D4924_265315161 = (mSelectionArgsBackReferences.entrySet()).iterator();
                varF9A47AC3D36EE6FD092FA741211D4924_265315161.hasNext();
                Map.Entry<Integer, Integer> entry = varF9A47AC3D36EE6FD092FA741211D4924_265315161.next();
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
        addTaint(dest.getTaint());
        addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.952 -0400", hash_original_method = "225259AA593B6A59F476A2C569F1B075", hash_generated_method = "42CA61F3FC3AC18C82B487E6E48535FF")
    public Uri getUri() {
        Uri varB4EAC82CA7396A68D541C85D26508E83_1747747742 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1747747742 = mUri;
        varB4EAC82CA7396A68D541C85D26508E83_1747747742.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1747747742;
        // ---------- Original Method ----------
        //return mUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.959 -0400", hash_original_method = "0D76D2BF4F9E314AF3AEB01067FC98E0", hash_generated_method = "3BB28DE17536691F32C96D641FDBCEE0")
    public boolean isYieldAllowed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_178097855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_178097855;
        // ---------- Original Method ----------
        //return mYieldAllowed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.978 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "F4F25EC5C6C9F7762835D65ADD5A0F71")
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1268979842 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1268979842;
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.979 -0400", hash_original_method = "94452D9A7E20FFB1CE97B24DC927192A", hash_generated_method = "E298A67E2B6323AB523B50793931364B")
    public boolean isWriteOperation() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1083120117 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1083120117;
        // ---------- Original Method ----------
        //return mType == TYPE_DELETE || mType == TYPE_INSERT || mType == TYPE_UPDATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.980 -0400", hash_original_method = "BBB0424C7EB706D24B64E8DBE01BF66B", hash_generated_method = "59F7D823FE827382916C3846E6DA6B8E")
    public boolean isReadOperation() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1864893752 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1864893752;
        // ---------- Original Method ----------
        //return mType == TYPE_ASSERT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.294 -0400", hash_original_method = "2009EEC78D1FCDD51A500D4742040E7C", hash_generated_method = "4F1964AEE562626B1063541E57E2CB69")
    public ContentProviderResult apply(ContentProvider provider, ContentProviderResult[] backRefs,
            int numBackRefs) throws OperationApplicationException {
        ContentProviderResult varB4EAC82CA7396A68D541C85D26508E83_1842115219 = null; //Variable for return #1
        ContentProviderResult varB4EAC82CA7396A68D541C85D26508E83_2086079992 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_1842115219 = new ContentProviderResult(newUri);
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
                    Iterator<Map.Entry<String, Object>> var94CAE6D127D9B49254CA403A57DB3B0A_1326888525 = (values.valueSet()).iterator();
                    var94CAE6D127D9B49254CA403A57DB3B0A_1326888525.hasNext();
                    Map.Entry<String, Object> entry = var94CAE6D127D9B49254CA403A57DB3B0A_1326888525.next();
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
                        boolean var4B88A4E0CCE1DD5CDA31BC6F14F1DD3B_1172297113 = (cursor.moveToNext());
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
                                        boolean var315C9A13C4CF5F1A59783370621A4A5F_813596340 = (!TextUtils.equals(cursorValue, expectedValue));
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
        varB4EAC82CA7396A68D541C85D26508E83_2086079992 = new ContentProviderResult(numRows);
        addTaint(provider.getTaint());
        addTaint(backRefs[0].getTaint());
        addTaint(numBackRefs);
        ContentProviderResult varA7E53CE21691AB073D9660D615818899_140961339; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_140961339 = varB4EAC82CA7396A68D541C85D26508E83_1842115219;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_140961339 = varB4EAC82CA7396A68D541C85D26508E83_2086079992;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_140961339.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_140961339;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.570 -0400", hash_original_method = "A962F701648C4B4117BD0A815ABD46EE", hash_generated_method = "15F50D8D362C9708AA39BB79CA15F7AA")
    public ContentValues resolveValueBackReferences(
            ContentProviderResult[] backRefs, int numBackRefs) {
        ContentValues varB4EAC82CA7396A68D541C85D26508E83_2119948193 = null; //Variable for return #1
        ContentValues varB4EAC82CA7396A68D541C85D26508E83_1471733840 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2119948193 = mValues;
        } //End block
        ContentValues values;
        {
            values = new ContentValues();
        } //End block
        {
            values = new ContentValues(mValues);
        } //End block
        {
            Iterator<Map.Entry<String, Object>> varEAD7F71FAB82DBE4DFEC649FA82C88FE_1957825382 = (mValuesBackReferences.valueSet()).iterator();
            varEAD7F71FAB82DBE4DFEC649FA82C88FE_1957825382.hasNext();
            Map.Entry<String, Object> entry = varEAD7F71FAB82DBE4DFEC649FA82C88FE_1957825382.next();
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
        varB4EAC82CA7396A68D541C85D26508E83_1471733840 = values;
        addTaint(backRefs[0].getTaint());
        addTaint(numBackRefs);
        ContentValues varA7E53CE21691AB073D9660D615818899_311612868; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_311612868 = varB4EAC82CA7396A68D541C85D26508E83_2119948193;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_311612868 = varB4EAC82CA7396A68D541C85D26508E83_1471733840;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_311612868.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_311612868;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.860 -0400", hash_original_method = "AA4B64F522D451BE6AD1A7AFC7A63956", hash_generated_method = "D9D7C877670ACEBB5B13B4F5FA2D6313")
    public String[] resolveSelectionArgsBackReferences(
            ContentProviderResult[] backRefs, int numBackRefs) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1488583482 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_1959967994 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1488583482 = mSelectionArgs;
        } //End block
        String[] newArgs;
        newArgs = new String[mSelectionArgs.length];
        System.arraycopy(mSelectionArgs, 0, newArgs, 0, mSelectionArgs.length);
        {
            Iterator<Map.Entry<Integer, Integer>> varE4ACC7EC0785CAFCE8884A18E88D0ADD_2082749883 = (mSelectionArgsBackReferences.entrySet()).iterator();
            varE4ACC7EC0785CAFCE8884A18E88D0ADD_2082749883.hasNext();
            Map.Entry<Integer, Integer> selectionArgBackRef = varE4ACC7EC0785CAFCE8884A18E88D0ADD_2082749883.next();
            {
                Integer selectionArgIndex;
                selectionArgIndex = selectionArgBackRef.getKey();
                int backRefIndex;
                backRefIndex = selectionArgBackRef.getValue();
                newArgs[selectionArgIndex] =
                    String.valueOf(backRefToValue(backRefs, numBackRefs, backRefIndex));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1959967994 = newArgs;
        addTaint(backRefs[0].getTaint());
        addTaint(numBackRefs);
        String[] varA7E53CE21691AB073D9660D615818899_1021361178; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1021361178 = varB4EAC82CA7396A68D541C85D26508E83_1488583482;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1021361178 = varB4EAC82CA7396A68D541C85D26508E83_1959967994;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1021361178.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1021361178;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.862 -0400", hash_original_method = "78718167AF18105CAC703FAFB09E4964", hash_generated_method = "19E77728F55BA2DFD2F1E5783B12E285")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2142176819 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2142176819 = "mType: " + mType + ", mUri: " + mUri +
                ", mSelection: " + mSelection +
                ", mExpectedCount: " + mExpectedCount +
                ", mYieldAllowed: " + mYieldAllowed +
                ", mValues: " + mValues +
                ", mValuesBackReferences: " + mValuesBackReferences +
                ", mSelectionArgsBackReferences: " + mSelectionArgsBackReferences;
        varB4EAC82CA7396A68D541C85D26508E83_2142176819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2142176819;
        // ---------- Original Method ----------
        //return "mType: " + mType + ", mUri: " + mUri +
                //", mSelection: " + mSelection +
                //", mExpectedCount: " + mExpectedCount +
                //", mYieldAllowed: " + mYieldAllowed +
                //", mValues: " + mValues +
                //", mValuesBackReferences: " + mValuesBackReferences +
                //", mSelectionArgsBackReferences: " + mSelectionArgsBackReferences;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.874 -0400", hash_original_method = "4E134EAC713EA4116B151015A8D49950", hash_generated_method = "D38AFE23F2D02C762F1CF9EAF204BCA7")
    private long backRefToValue(ContentProviderResult[] backRefs, int numBackRefs,
            Integer backRefIndex) {
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
        addTaint(backRefs[0].getTaint());
        addTaint(numBackRefs);
        addTaint(backRefIndex.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1679628847 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1679628847;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.875 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F367B4800CE36DAC28845C56C5A63927")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82603331 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82603331;
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.875 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

        private int mType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.875 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

        private Uri mUri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.876 -0400", hash_original_field = "D53310829851F4FC641DE95C4A986129", hash_generated_field = "B8B15EC2943749CD20950EAD77AF5EC7")

        private String mSelection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.876 -0400", hash_original_field = "BAEA1B6F996F3986EF68E88ECD2F5469", hash_generated_field = "5541CF5102D1C94942E84E1E2C6A7EFF")

        private String[] mSelectionArgs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.877 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "2CDA41B4D101B2B770760EBED9C98242")

        private ContentValues mValues;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.877 -0400", hash_original_field = "CCF3A996E025C390C9379F65A4EEC523", hash_generated_field = "0366D826BB05344215E0357A75CDC773")

        private Integer mExpectedCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.877 -0400", hash_original_field = "CF4CD4AE5739BE664E237169162A57FD", hash_generated_field = "5CDBA65FCD489D4F2D0BCD78A8638FD5")

        private ContentValues mValuesBackReferences;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.877 -0400", hash_original_field = "6235C72C3DC414902F946F7E4F463896", hash_generated_field = "F3EB1F15BD72236CAC0D0000DA6E4595")

        private Map<Integer, Integer> mSelectionArgsBackReferences;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.878 -0400", hash_original_field = "B3463DA9E487038FF44897CC868147B7", hash_generated_field = "878B9839823FAA28C7AD4A475721F913")

        private boolean mYieldAllowed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.903 -0400", hash_original_method = "E4683F1EC70220B8EE12920060472DE0", hash_generated_method = "A69583727DFF86B9E66EFE8F3D804826")
        private  Builder(int type, Uri uri) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("uri must not be null");
            } //End block
            mType = type;
            mUri = uri;
            // ---------- Original Method ----------
            //if (uri == null) {
                //throw new IllegalArgumentException("uri must not be null");
            //}
            //mType = type;
            //mUri = uri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.943 -0400", hash_original_method = "52DF5CD1F3EDB944F65D1FF1857828C4", hash_generated_method = "7E4F465A971E7CE5EF5B5D62AB5359BD")
        public ContentProviderOperation build() {
            ContentProviderOperation varB4EAC82CA7396A68D541C85D26508E83_2079507806 = null; //Variable for return #1
            {
                {
                    boolean varE217E6379D20B25A0EC064610B0EEA97_1006219129 = ((mValues == null || mValues.size() == 0)
                        && (mValuesBackReferences == null || mValuesBackReferences.size() == 0));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Empty values");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var35BFBE8564F87B211AE46E433A8E370B_1032317794 = ((mValues == null || mValues.size() == 0)
                        && (mValuesBackReferences == null || mValuesBackReferences.size() == 0)
                        && (mExpectedCount == null));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Empty values");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_2079507806 = new ContentProviderOperation(this);
            varB4EAC82CA7396A68D541C85D26508E83_2079507806.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2079507806;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.945 -0400", hash_original_method = "48DEB08B58C335127E8366C72D237182", hash_generated_method = "CFD659DA7A330FAC8937FD22B9DD1CE0")
        public Builder withValueBackReferences(ContentValues backReferences) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_576893160 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "only inserts, updates, and asserts can have value back-references");
            } //End block
            mValuesBackReferences = backReferences;
            varB4EAC82CA7396A68D541C85D26508E83_576893160 = this;
            varB4EAC82CA7396A68D541C85D26508E83_576893160.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_576893160;
            // ---------- Original Method ----------
            //if (mType != TYPE_INSERT && mType != TYPE_UPDATE && mType != TYPE_ASSERT) {
                //throw new IllegalArgumentException(
                        //"only inserts, updates, and asserts can have value back-references");
            //}
            //mValuesBackReferences = backReferences;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.947 -0400", hash_original_method = "9B7E0512DF416F22106A40FEC0A8A4AE", hash_generated_method = "5B48C3678A8764D7BA1033B18087BEC1")
        public Builder withValueBackReference(String key, int previousResult) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_134199431 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "only inserts, updates, and asserts can have value back-references");
            } //End block
            {
                mValuesBackReferences = new ContentValues();
            } //End block
            mValuesBackReferences.put(key, previousResult);
            varB4EAC82CA7396A68D541C85D26508E83_134199431 = this;
            addTaint(key.getTaint());
            addTaint(previousResult);
            varB4EAC82CA7396A68D541C85D26508E83_134199431.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_134199431;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.954 -0400", hash_original_method = "0B4CE4049FC576DCE44E5153CA371A5B", hash_generated_method = "B4A362078B7FAEEF2D86E06DB2F2BF25")
        public Builder withSelectionBackReference(int selectionArgIndex, int previousResult) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_688585133 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("only updates, deletes, and asserts "
                        + "can have selection back-references");
            } //End block
            {
                mSelectionArgsBackReferences = new HashMap<Integer, Integer>();
            } //End block
            mSelectionArgsBackReferences.put(selectionArgIndex, previousResult);
            varB4EAC82CA7396A68D541C85D26508E83_688585133 = this;
            addTaint(selectionArgIndex);
            addTaint(previousResult);
            varB4EAC82CA7396A68D541C85D26508E83_688585133.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_688585133;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.968 -0400", hash_original_method = "F7B8F8808C4F5F5C0301B85A5CF2FD8A", hash_generated_method = "B864595A8C3040EE0A5F577399B75D5A")
        public Builder withValues(ContentValues values) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_139530959 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "only inserts, updates, and asserts can have values");
            } //End block
            {
                mValues = new ContentValues();
            } //End block
            mValues.putAll(values);
            varB4EAC82CA7396A68D541C85D26508E83_139530959 = this;
            addTaint(values.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_139530959.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_139530959;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.985 -0400", hash_original_method = "E35FC6F92508151B3604E11EFF6133FA", hash_generated_method = "3312952D155CF58E528229367F7A2622")
        public Builder withValue(String key, Object value) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_605569518 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_605569518 = this;
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_605569518.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_605569518;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.008 -0400", hash_original_method = "26D13871C486DC34FECD72252582D17D", hash_generated_method = "9A98A7BC6D233117BDF61CFBA38D3EB8")
        public Builder withSelection(String selection, String[] selectionArgs) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1038276122 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "only updates, deletes, and asserts can have selections");
            } //End block
            mSelection = selection;
            {
                mSelectionArgs = null;
            } //End block
            {
                mSelectionArgs = new String[selectionArgs.length];
                System.arraycopy(selectionArgs, 0, mSelectionArgs, 0, selectionArgs.length);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1038276122 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1038276122.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1038276122;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.027 -0400", hash_original_method = "70A8F698538BA5C44D08715766038CFE", hash_generated_method = "32D0D5B95092A6F51B118F0B785B2532")
        public Builder withExpectedCount(int count) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_440799585 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "only updates, deletes, and asserts can have expected counts");
            } //End block
            mExpectedCount = count;
            varB4EAC82CA7396A68D541C85D26508E83_440799585 = this;
            varB4EAC82CA7396A68D541C85D26508E83_440799585.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_440799585;
            // ---------- Original Method ----------
            //if (mType != TYPE_UPDATE && mType != TYPE_DELETE && mType != TYPE_ASSERT) {
                //throw new IllegalArgumentException(
                        //"only updates, deletes, and asserts can have expected counts");
            //}
            //mExpectedCount = count;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.029 -0400", hash_original_method = "1D016C05C5C9EB70F24159159C761C5E", hash_generated_method = "4B65B093ED11116EE464CF6514B9C364")
        public Builder withYieldAllowed(boolean yieldAllowed) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_46193850 = null; //Variable for return #1
            mYieldAllowed = yieldAllowed;
            varB4EAC82CA7396A68D541C85D26508E83_46193850 = this;
            varB4EAC82CA7396A68D541C85D26508E83_46193850.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_46193850;
            // ---------- Original Method ----------
            //mYieldAllowed = yieldAllowed;
            //return this;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.030 -0400", hash_original_field = "AAAA741D4E0722E60C557E82C50D8506", hash_generated_field = "F2B415C2E3F102CA367609812B6543AF")

    public final static int TYPE_INSERT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.030 -0400", hash_original_field = "E5C8D33490018BF295517C1322D81059", hash_generated_field = "1442E5D78729E4303598C2A50D596315")

    public final static int TYPE_UPDATE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.031 -0400", hash_original_field = "16C185B26F4235C839B6C799AF390AC8", hash_generated_field = "3AD3AA9BCB51C5A9F57D5C35E47FAB8E")

    public final static int TYPE_DELETE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.031 -0400", hash_original_field = "56EF35D33F3E27C0A0F597095F0BC865", hash_generated_field = "20A63CA4A4C078199A85B846D689891A")

    public final static int TYPE_ASSERT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.031 -0400", hash_original_field = "D81EC5BE5702893FA88B99989F310913", hash_generated_field = "E666815924707133A6AA5017F2663F49")

    private static String TAG = "ContentProviderOperation";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.031 -0400", hash_original_field = "8924CBDB7EE2EFEBC660CED8A0C59192", hash_generated_field = "9AC0BB3876B129B46AD7C4638D0FA4D8")

    public static final Creator<ContentProviderOperation> CREATOR =
            new Creator<ContentProviderOperation>() {
        public ContentProviderOperation createFromParcel(Parcel source) {
            return new ContentProviderOperation(source);
        }

        public ContentProviderOperation[] newArray(int size) {
            return new ContentProviderOperation[size];
        }
    };
}

