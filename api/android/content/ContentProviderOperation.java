package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.680 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.680 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

    private Uri mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.680 -0400", hash_original_field = "D53310829851F4FC641DE95C4A986129", hash_generated_field = "B8B15EC2943749CD20950EAD77AF5EC7")

    private String mSelection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.680 -0400", hash_original_field = "BAEA1B6F996F3986EF68E88ECD2F5469", hash_generated_field = "5541CF5102D1C94942E84E1E2C6A7EFF")

    private String[] mSelectionArgs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.680 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "2CDA41B4D101B2B770760EBED9C98242")

    private ContentValues mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.680 -0400", hash_original_field = "CCF3A996E025C390C9379F65A4EEC523", hash_generated_field = "0366D826BB05344215E0357A75CDC773")

    private Integer mExpectedCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.680 -0400", hash_original_field = "CF4CD4AE5739BE664E237169162A57FD", hash_generated_field = "5CDBA65FCD489D4F2D0BCD78A8638FD5")

    private ContentValues mValuesBackReferences;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.681 -0400", hash_original_field = "6235C72C3DC414902F946F7E4F463896", hash_generated_field = "F3EB1F15BD72236CAC0D0000DA6E4595")

    private Map<Integer, Integer> mSelectionArgsBackReferences;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.681 -0400", hash_original_field = "B3463DA9E487038FF44897CC868147B7", hash_generated_field = "878B9839823FAA28C7AD4A475721F913")

    private boolean mYieldAllowed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.683 -0400", hash_original_method = "E83648833C15023B0A37354984B5CA31", hash_generated_method = "82CDA661D135A6B2C13B951998951636")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.685 -0400", hash_original_method = "9004240102FD3717D6F1BEB293484741", hash_generated_method = "915F550161F1009692B244425881A126")
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
    if(mSelectionArgsBackReferences != null)        
        {
            final int count = source.readInt();
for(int i = 0;i < count;i++)
            {
                mSelectionArgsBackReferences.put(source.readInt(), source.readInt());
            } //End block
        } //End block
        mYieldAllowed = source.readInt() != 0;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.686 -0400", hash_original_method = "D97604A456AD6CF9916FB862EEBD56CF", hash_generated_method = "747848DFDECCFD971D865471FA6BE28D")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mType);
        Uri.writeToParcel(dest, mUri);
    if(mValues != null)        
        {
            dest.writeInt(1);
            mValues.writeToParcel(dest, 0);
        } //End block
        else
        {
            dest.writeInt(0);
        } //End block
    if(mSelection != null)        
        {
            dest.writeInt(1);
            dest.writeString(mSelection);
        } //End block
        else
        {
            dest.writeInt(0);
        } //End block
    if(mSelectionArgs != null)        
        {
            dest.writeInt(1);
            dest.writeStringArray(mSelectionArgs);
        } //End block
        else
        {
            dest.writeInt(0);
        } //End block
    if(mExpectedCount != null)        
        {
            dest.writeInt(1);
            dest.writeInt(mExpectedCount);
        } //End block
        else
        {
            dest.writeInt(0);
        } //End block
    if(mValuesBackReferences != null)        
        {
            dest.writeInt(1);
            mValuesBackReferences.writeToParcel(dest, 0);
        } //End block
        else
        {
            dest.writeInt(0);
        } //End block
    if(mSelectionArgsBackReferences != null)        
        {
            dest.writeInt(1);
            dest.writeInt(mSelectionArgsBackReferences.size());
for(Map.Entry<Integer, Integer> entry : mSelectionArgsBackReferences.entrySet())
            {
                dest.writeInt(entry.getKey());
                dest.writeInt(entry.getValue());
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.688 -0400", hash_original_method = "225259AA593B6A59F476A2C569F1B075", hash_generated_method = "E7973766B26F8BB7CE20E4574C5B7EF9")
    public Uri getUri() {
Uri var7D41D50876117CE5D7DFAD684A455037_35770264 =         mUri;
        var7D41D50876117CE5D7DFAD684A455037_35770264.addTaint(taint);
        return var7D41D50876117CE5D7DFAD684A455037_35770264;
        // ---------- Original Method ----------
        //return mUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.688 -0400", hash_original_method = "0D76D2BF4F9E314AF3AEB01067FC98E0", hash_generated_method = "2376DCA5FBA76D217DDFF146773E74C0")
    public boolean isYieldAllowed() {
        boolean varB3463DA9E487038FF44897CC868147B7_1358038527 = (mYieldAllowed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1682999678 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1682999678;
        // ---------- Original Method ----------
        //return mYieldAllowed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.689 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "F91DF4CA456B85E471AC9BB91BEB454F")
    public int getType() {
        int var3462A1A18A0EE070E8953CCF1DD788C0_1426472940 = (mType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_942643579 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_942643579;
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.689 -0400", hash_original_method = "94452D9A7E20FFB1CE97B24DC927192A", hash_generated_method = "484D38DBC138A4C3850C997F93E7FAE5")
    public boolean isWriteOperation() {
        boolean var61CA068672D6005E111FF12D7F442E6F_661351605 = (mType == TYPE_DELETE || mType == TYPE_INSERT || mType == TYPE_UPDATE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1826077262 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1826077262;
        // ---------- Original Method ----------
        //return mType == TYPE_DELETE || mType == TYPE_INSERT || mType == TYPE_UPDATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.689 -0400", hash_original_method = "BBB0424C7EB706D24B64E8DBE01BF66B", hash_generated_method = "176D650D037E30540F03DA693D04927C")
    public boolean isReadOperation() {
        boolean var9CDB60DEFE76685410316EA9CCF1700B_586139720 = (mType == TYPE_ASSERT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_687246233 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_687246233;
        // ---------- Original Method ----------
        //return mType == TYPE_ASSERT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.691 -0400", hash_original_method = "2009EEC78D1FCDD51A500D4742040E7C", hash_generated_method = "F402789FAA322923286EBDB14FA6A479")
    public ContentProviderResult apply(ContentProvider provider, ContentProviderResult[] backRefs,
            int numBackRefs) throws OperationApplicationException {
        addTaint(numBackRefs);
        addTaint(backRefs[0].getTaint());
        addTaint(provider.getTaint());
        ContentValues values = resolveValueBackReferences(backRefs, numBackRefs);
        String[] selectionArgs = resolveSelectionArgsBackReferences(backRefs, numBackRefs);
    if(mType == TYPE_INSERT)        
        {
            Uri newUri = provider.insert(mUri, values);
    if(newUri == null)            
            {
                OperationApplicationException varA6CE2F71154C4F233E0ABAA24AE5D409_1329063451 = new OperationApplicationException("insert failed");
                varA6CE2F71154C4F233E0ABAA24AE5D409_1329063451.addTaint(taint);
                throw varA6CE2F71154C4F233E0ABAA24AE5D409_1329063451;
            } //End block
ContentProviderResult var145C6886DCF804651A2020E0EF51F855_568615068 =             new ContentProviderResult(newUri);
            var145C6886DCF804651A2020E0EF51F855_568615068.addTaint(taint);
            return var145C6886DCF804651A2020E0EF51F855_568615068;
        } //End block
        int numRows;
    if(mType == TYPE_DELETE)        
        {
            numRows = provider.delete(mUri, mSelection, selectionArgs);
        } //End block
        else
    if(mType == TYPE_UPDATE)        
        {
            numRows = provider.update(mUri, values, mSelection, selectionArgs);
        } //End block
        else
    if(mType == TYPE_ASSERT)        
        {
            String[] projection = null;
    if(values != null)            
            {
                final ArrayList<String> projectionList = new ArrayList<String>();
for(Map.Entry<String, Object> entry : values.valueSet())
                {
                    projectionList.add(entry.getKey());
                } //End block
                projection = projectionList.toArray(new String[projectionList.size()]);
            } //End block
            final Cursor cursor = provider.query(mUri, projection, mSelection, selectionArgs, null);
            try 
            {
                numRows = cursor.getCount();
    if(projection != null)                
                {
                    while
(cursor.moveToNext())                    
                    {
for(int i = 0;i < projection.length;i++)
                        {
                            final String cursorValue = cursor.getString(i);
                            final String expectedValue = values.getAsString(projection[i]);
    if(!TextUtils.equals(cursorValue, expectedValue))                            
                            {
                                OperationApplicationException var54CEF03D663D0CBD25594AF1D4317FE4_919775060 = new OperationApplicationException("Found value " + cursorValue
                                        + " when expected " + expectedValue + " for column "
                                        + projection[i]);
                                var54CEF03D663D0CBD25594AF1D4317FE4_919775060.addTaint(taint);
                                throw var54CEF03D663D0CBD25594AF1D4317FE4_919775060;
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
            finally 
            {
                cursor.close();
            } //End block
        } //End block
        else
        {
            IllegalStateException var81D5403BCE7FB12BF76E47AEFD8D3143_400373994 = new IllegalStateException("bad type, " + mType);
            var81D5403BCE7FB12BF76E47AEFD8D3143_400373994.addTaint(taint);
            throw var81D5403BCE7FB12BF76E47AEFD8D3143_400373994;
        } //End block
    if(mExpectedCount != null && mExpectedCount != numRows)        
        {
            OperationApplicationException var57390826D91AE37160B3E86D21E7D909_2036226339 = new OperationApplicationException("wrong number of rows: " + numRows);
            var57390826D91AE37160B3E86D21E7D909_2036226339.addTaint(taint);
            throw var57390826D91AE37160B3E86D21E7D909_2036226339;
        } //End block
ContentProviderResult var6E113893A689DEDF404C7D4BD6D35874_312311582 =         new ContentProviderResult(numRows);
        var6E113893A689DEDF404C7D4BD6D35874_312311582.addTaint(taint);
        return var6E113893A689DEDF404C7D4BD6D35874_312311582;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.693 -0400", hash_original_method = "A962F701648C4B4117BD0A815ABD46EE", hash_generated_method = "784245CC02B8AA7AEE7274E466BC60AF")
    public ContentValues resolveValueBackReferences(
            ContentProviderResult[] backRefs, int numBackRefs) {
        addTaint(numBackRefs);
        addTaint(backRefs[0].getTaint());
    if(mValuesBackReferences == null)        
        {
ContentValues varC2D5F196132EC24FFA86AC8D1AA44E77_1771432796 =             mValues;
            varC2D5F196132EC24FFA86AC8D1AA44E77_1771432796.addTaint(taint);
            return varC2D5F196132EC24FFA86AC8D1AA44E77_1771432796;
        } //End block
        ContentValues values;
    if(mValues == null)        
        {
            values = new ContentValues();
        } //End block
        else
        {
            values = new ContentValues(mValues);
        } //End block
for(Map.Entry<String, Object> entry : mValuesBackReferences.valueSet())
        {
            String key = entry.getKey();
            Integer backRefIndex = mValuesBackReferences.getAsInteger(key);
    if(backRefIndex == null)            
            {
                IllegalArgumentException var6ADC783FA239957ADEC8FF8BF3EB1F69_1140005082 = new IllegalArgumentException("values backref " + key + " is not an integer");
                var6ADC783FA239957ADEC8FF8BF3EB1F69_1140005082.addTaint(taint);
                throw var6ADC783FA239957ADEC8FF8BF3EB1F69_1140005082;
            } //End block
            values.put(key, backRefToValue(backRefs, numBackRefs, backRefIndex));
        } //End block
ContentValues var674B10C763DBAAF9696AD9A3DDAE07B3_1852329485 =         values;
        var674B10C763DBAAF9696AD9A3DDAE07B3_1852329485.addTaint(taint);
        return var674B10C763DBAAF9696AD9A3DDAE07B3_1852329485;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.695 -0400", hash_original_method = "AA4B64F522D451BE6AD1A7AFC7A63956", hash_generated_method = "DE4E76C8470D2C4BCBA7FAE397B3247C")
    public String[] resolveSelectionArgsBackReferences(
            ContentProviderResult[] backRefs, int numBackRefs) {
        addTaint(numBackRefs);
        addTaint(backRefs[0].getTaint());
    if(mSelectionArgsBackReferences == null)        
        {
String[] varDBA0D6591B6C7829463FE09B1460B708_1974131851 =             mSelectionArgs;
            varDBA0D6591B6C7829463FE09B1460B708_1974131851.addTaint(taint);
            return varDBA0D6591B6C7829463FE09B1460B708_1974131851;
        } //End block
        String[] newArgs = new String[mSelectionArgs.length];
        System.arraycopy(mSelectionArgs, 0, newArgs, 0, mSelectionArgs.length);
for(Map.Entry<Integer, Integer> selectionArgBackRef : mSelectionArgsBackReferences.entrySet())
        {
            final Integer selectionArgIndex = selectionArgBackRef.getKey();
            final int backRefIndex = selectionArgBackRef.getValue();
            newArgs[selectionArgIndex] =
                    String.valueOf(backRefToValue(backRefs, numBackRefs, backRefIndex));
        } //End block
String[] var66A41BD6CDACE61B81A29265306FE12C_605118089 =         newArgs;
        var66A41BD6CDACE61B81A29265306FE12C_605118089.addTaint(taint);
        return var66A41BD6CDACE61B81A29265306FE12C_605118089;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.696 -0400", hash_original_method = "78718167AF18105CAC703FAFB09E4964", hash_generated_method = "21DA4F1C045D1B9C72D3B4B21820E2EC")
    @Override
    public String toString() {
String var5437924A98110F3BAD119BEF211F2BFE_587531811 =         "mType: " + mType + ", mUri: " + mUri +
                ", mSelection: " + mSelection +
                ", mExpectedCount: " + mExpectedCount +
                ", mYieldAllowed: " + mYieldAllowed +
                ", mValues: " + mValues +
                ", mValuesBackReferences: " + mValuesBackReferences +
                ", mSelectionArgsBackReferences: " + mSelectionArgsBackReferences;
        var5437924A98110F3BAD119BEF211F2BFE_587531811.addTaint(taint);
        return var5437924A98110F3BAD119BEF211F2BFE_587531811;
        // ---------- Original Method ----------
        //return "mType: " + mType + ", mUri: " + mUri +
                //", mSelection: " + mSelection +
                //", mExpectedCount: " + mExpectedCount +
                //", mYieldAllowed: " + mYieldAllowed +
                //", mValues: " + mValues +
                //", mValuesBackReferences: " + mValuesBackReferences +
                //", mSelectionArgsBackReferences: " + mSelectionArgsBackReferences;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.697 -0400", hash_original_method = "4E134EAC713EA4116B151015A8D49950", hash_generated_method = "D599913D14BCB1A748E1BFFB2C297CBD")
    private long backRefToValue(ContentProviderResult[] backRefs, int numBackRefs,
            Integer backRefIndex) {
        addTaint(backRefIndex.getTaint());
        addTaint(numBackRefs);
        addTaint(backRefs[0].getTaint());
    if(backRefIndex >= numBackRefs)        
        {
            ArrayIndexOutOfBoundsException var95D966B584E4BCAB72C55E07D71D9FD5_512217356 = new ArrayIndexOutOfBoundsException("asked for back ref " + backRefIndex
                    + " but there are only " + numBackRefs + " back refs");
            var95D966B584E4BCAB72C55E07D71D9FD5_512217356.addTaint(taint);
            throw var95D966B584E4BCAB72C55E07D71D9FD5_512217356;
        } //End block
        ContentProviderResult backRef = backRefs[backRefIndex];
        long backRefValue;
    if(backRef.uri != null)        
        {
            backRefValue = ContentUris.parseId(backRef.uri);
        } //End block
        else
        {
            backRefValue = backRef.count;
        } //End block
        long varB83EEB38068B6C7D72340D5BBED97B43_286854221 = (backRefValue);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_78630510 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_78630510;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.698 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E04BBAE0F399B57E334E466EA46C683A")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_462618791 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_23403591 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_23403591;
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.699 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

        private int mType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.699 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

        private Uri mUri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.699 -0400", hash_original_field = "D53310829851F4FC641DE95C4A986129", hash_generated_field = "B8B15EC2943749CD20950EAD77AF5EC7")

        private String mSelection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.699 -0400", hash_original_field = "BAEA1B6F996F3986EF68E88ECD2F5469", hash_generated_field = "5541CF5102D1C94942E84E1E2C6A7EFF")

        private String[] mSelectionArgs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.699 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "2CDA41B4D101B2B770760EBED9C98242")

        private ContentValues mValues;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.699 -0400", hash_original_field = "CCF3A996E025C390C9379F65A4EEC523", hash_generated_field = "0366D826BB05344215E0357A75CDC773")

        private Integer mExpectedCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.699 -0400", hash_original_field = "CF4CD4AE5739BE664E237169162A57FD", hash_generated_field = "5CDBA65FCD489D4F2D0BCD78A8638FD5")

        private ContentValues mValuesBackReferences;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.699 -0400", hash_original_field = "6235C72C3DC414902F946F7E4F463896", hash_generated_field = "F3EB1F15BD72236CAC0D0000DA6E4595")

        private Map<Integer, Integer> mSelectionArgsBackReferences;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.700 -0400", hash_original_field = "B3463DA9E487038FF44897CC868147B7", hash_generated_field = "878B9839823FAA28C7AD4A475721F913")

        private boolean mYieldAllowed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.700 -0400", hash_original_method = "E4683F1EC70220B8EE12920060472DE0", hash_generated_method = "7C8CBC2DF3FFEB974A9F820366CBF279")
        private  Builder(int type, Uri uri) {
    if(uri == null)            
            {
                IllegalArgumentException varA7E51D1A6F179308507624649E54C0ED_1535732781 = new IllegalArgumentException("uri must not be null");
                varA7E51D1A6F179308507624649E54C0ED_1535732781.addTaint(taint);
                throw varA7E51D1A6F179308507624649E54C0ED_1535732781;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.701 -0400", hash_original_method = "52DF5CD1F3EDB944F65D1FF1857828C4", hash_generated_method = "CFF0D8CAE49C492549547C51E00C2476")
        public ContentProviderOperation build() {
    if(mType == TYPE_UPDATE)            
            {
    if((mValues == null || mValues.size() == 0)
                        && (mValuesBackReferences == null || mValuesBackReferences.size() == 0))                
                {
                    IllegalArgumentException varEEE2AB986D839FC34B1428F77875E0E5_1264931924 = new IllegalArgumentException("Empty values");
                    varEEE2AB986D839FC34B1428F77875E0E5_1264931924.addTaint(taint);
                    throw varEEE2AB986D839FC34B1428F77875E0E5_1264931924;
                } //End block
            } //End block
    if(mType == TYPE_ASSERT)            
            {
    if((mValues == null || mValues.size() == 0)
                        && (mValuesBackReferences == null || mValuesBackReferences.size() == 0)
                        && (mExpectedCount == null))                
                {
                    IllegalArgumentException varEEE2AB986D839FC34B1428F77875E0E5_1034149131 = new IllegalArgumentException("Empty values");
                    varEEE2AB986D839FC34B1428F77875E0E5_1034149131.addTaint(taint);
                    throw varEEE2AB986D839FC34B1428F77875E0E5_1034149131;
                } //End block
            } //End block
ContentProviderOperation var8F6B2413C892A7178518BAA0272AF02D_2098917994 =             new ContentProviderOperation(this);
            var8F6B2413C892A7178518BAA0272AF02D_2098917994.addTaint(taint);
            return var8F6B2413C892A7178518BAA0272AF02D_2098917994;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.702 -0400", hash_original_method = "48DEB08B58C335127E8366C72D237182", hash_generated_method = "DCC217832C8560E84666FE7B88A632C2")
        public Builder withValueBackReferences(ContentValues backReferences) {
    if(mType != TYPE_INSERT && mType != TYPE_UPDATE && mType != TYPE_ASSERT)            
            {
                IllegalArgumentException var2562CEF33A43FADE3371034A66954C31_71938602 = new IllegalArgumentException(
                        "only inserts, updates, and asserts can have value back-references");
                var2562CEF33A43FADE3371034A66954C31_71938602.addTaint(taint);
                throw var2562CEF33A43FADE3371034A66954C31_71938602;
            } //End block
            mValuesBackReferences = backReferences;
Builder var72A74007B2BE62B849F475C7BDA4658B_1210393746 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1210393746.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1210393746;
            // ---------- Original Method ----------
            //if (mType != TYPE_INSERT && mType != TYPE_UPDATE && mType != TYPE_ASSERT) {
                //throw new IllegalArgumentException(
                        //"only inserts, updates, and asserts can have value back-references");
            //}
            //mValuesBackReferences = backReferences;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.705 -0400", hash_original_method = "9B7E0512DF416F22106A40FEC0A8A4AE", hash_generated_method = "D85304043A0D33CD9A726D516D5299D4")
        public Builder withValueBackReference(String key, int previousResult) {
            addTaint(previousResult);
            addTaint(key.getTaint());
    if(mType != TYPE_INSERT && mType != TYPE_UPDATE && mType != TYPE_ASSERT)            
            {
                IllegalArgumentException var2562CEF33A43FADE3371034A66954C31_685302938 = new IllegalArgumentException(
                        "only inserts, updates, and asserts can have value back-references");
                var2562CEF33A43FADE3371034A66954C31_685302938.addTaint(taint);
                throw var2562CEF33A43FADE3371034A66954C31_685302938;
            } //End block
    if(mValuesBackReferences == null)            
            {
                mValuesBackReferences = new ContentValues();
            } //End block
            mValuesBackReferences.put(key, previousResult);
Builder var72A74007B2BE62B849F475C7BDA4658B_1412732412 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1412732412.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1412732412;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.710 -0400", hash_original_method = "0B4CE4049FC576DCE44E5153CA371A5B", hash_generated_method = "13B00241541D9F9DA376E176FC5156B7")
        public Builder withSelectionBackReference(int selectionArgIndex, int previousResult) {
            addTaint(previousResult);
            addTaint(selectionArgIndex);
    if(mType != TYPE_UPDATE && mType != TYPE_DELETE && mType != TYPE_ASSERT)            
            {
                IllegalArgumentException varEC8B43E029FD8D0DEA7F827884E738CB_2132852532 = new IllegalArgumentException("only updates, deletes, and asserts "
                        + "can have selection back-references");
                varEC8B43E029FD8D0DEA7F827884E738CB_2132852532.addTaint(taint);
                throw varEC8B43E029FD8D0DEA7F827884E738CB_2132852532;
            } //End block
    if(mSelectionArgsBackReferences == null)            
            {
                mSelectionArgsBackReferences = new HashMap<Integer, Integer>();
            } //End block
            mSelectionArgsBackReferences.put(selectionArgIndex, previousResult);
Builder var72A74007B2BE62B849F475C7BDA4658B_1906632249 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1906632249.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1906632249;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.711 -0400", hash_original_method = "F7B8F8808C4F5F5C0301B85A5CF2FD8A", hash_generated_method = "78B46A796D3B897AFC01D1D093EDD2DE")
        public Builder withValues(ContentValues values) {
            addTaint(values.getTaint());
    if(mType != TYPE_INSERT && mType != TYPE_UPDATE && mType != TYPE_ASSERT)            
            {
                IllegalArgumentException var3501CD791067BFD06BDC0B582F4BFD7C_721663278 = new IllegalArgumentException(
                        "only inserts, updates, and asserts can have values");
                var3501CD791067BFD06BDC0B582F4BFD7C_721663278.addTaint(taint);
                throw var3501CD791067BFD06BDC0B582F4BFD7C_721663278;
            } //End block
    if(mValues == null)            
            {
                mValues = new ContentValues();
            } //End block
            mValues.putAll(values);
Builder var72A74007B2BE62B849F475C7BDA4658B_1428610711 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1428610711.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1428610711;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.712 -0400", hash_original_method = "E35FC6F92508151B3604E11EFF6133FA", hash_generated_method = "53FF01D4008723CB3B1E599D84F1AAE2")
        public Builder withValue(String key, Object value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
    if(mType != TYPE_INSERT && mType != TYPE_UPDATE && mType != TYPE_ASSERT)            
            {
                IllegalArgumentException var62577629427F25FEAFE83CF835F221E0_1064246965 = new IllegalArgumentException("only inserts and updates can have values");
                var62577629427F25FEAFE83CF835F221E0_1064246965.addTaint(taint);
                throw var62577629427F25FEAFE83CF835F221E0_1064246965;
            } //End block
    if(mValues == null)            
            {
                mValues = new ContentValues();
            } //End block
    if(value == null)            
            {
                mValues.putNull(key);
            } //End block
            else
    if(value instanceof String)            
            {
                mValues.put(key, (String) value);
            } //End block
            else
    if(value instanceof Byte)            
            {
                mValues.put(key, (Byte) value);
            } //End block
            else
    if(value instanceof Short)            
            {
                mValues.put(key, (Short) value);
            } //End block
            else
    if(value instanceof Integer)            
            {
                mValues.put(key, (Integer) value);
            } //End block
            else
    if(value instanceof Long)            
            {
                mValues.put(key, (Long) value);
            } //End block
            else
    if(value instanceof Float)            
            {
                mValues.put(key, (Float) value);
            } //End block
            else
    if(value instanceof Double)            
            {
                mValues.put(key, (Double) value);
            } //End block
            else
    if(value instanceof Boolean)            
            {
                mValues.put(key, (Boolean) value);
            } //End block
            else
    if(value instanceof byte[])            
            {
                mValues.put(key, (byte[]) value);
            } //End block
            else
            {
                IllegalArgumentException var893B5BC28B0A8E36B9912B85C9157319_1185796377 = new IllegalArgumentException("bad value type: " + value.getClass().getName());
                var893B5BC28B0A8E36B9912B85C9157319_1185796377.addTaint(taint);
                throw var893B5BC28B0A8E36B9912B85C9157319_1185796377;
            } //End block
Builder var72A74007B2BE62B849F475C7BDA4658B_1162132505 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1162132505.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1162132505;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.715 -0400", hash_original_method = "26D13871C486DC34FECD72252582D17D", hash_generated_method = "809537986350F3BF35506C4577202D63")
        public Builder withSelection(String selection, String[] selectionArgs) {
    if(mType != TYPE_UPDATE && mType != TYPE_DELETE && mType != TYPE_ASSERT)            
            {
                IllegalArgumentException varFA037EB6F12CAD4EEBB241C27677030E_14332710 = new IllegalArgumentException(
                        "only updates, deletes, and asserts can have selections");
                varFA037EB6F12CAD4EEBB241C27677030E_14332710.addTaint(taint);
                throw varFA037EB6F12CAD4EEBB241C27677030E_14332710;
            } //End block
            mSelection = selection;
    if(selectionArgs == null)            
            {
                mSelectionArgs = null;
            } //End block
            else
            {
                mSelectionArgs = new String[selectionArgs.length];
                System.arraycopy(selectionArgs, 0, mSelectionArgs, 0, selectionArgs.length);
            } //End block
Builder var72A74007B2BE62B849F475C7BDA4658B_935693024 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_935693024.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_935693024;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.716 -0400", hash_original_method = "70A8F698538BA5C44D08715766038CFE", hash_generated_method = "61564C2A213C85FBBD9F38B409AF205C")
        public Builder withExpectedCount(int count) {
    if(mType != TYPE_UPDATE && mType != TYPE_DELETE && mType != TYPE_ASSERT)            
            {
                IllegalArgumentException var2F4A6F69802DC485819D2951B829E9EB_1439078733 = new IllegalArgumentException(
                        "only updates, deletes, and asserts can have expected counts");
                var2F4A6F69802DC485819D2951B829E9EB_1439078733.addTaint(taint);
                throw var2F4A6F69802DC485819D2951B829E9EB_1439078733;
            } //End block
            mExpectedCount = count;
Builder var72A74007B2BE62B849F475C7BDA4658B_274090281 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_274090281.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_274090281;
            // ---------- Original Method ----------
            //if (mType != TYPE_UPDATE && mType != TYPE_DELETE && mType != TYPE_ASSERT) {
                //throw new IllegalArgumentException(
                        //"only updates, deletes, and asserts can have expected counts");
            //}
            //mExpectedCount = count;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.717 -0400", hash_original_method = "1D016C05C5C9EB70F24159159C761C5E", hash_generated_method = "29637C43B9B176ECADBF4CDCDB435EEE")
        public Builder withYieldAllowed(boolean yieldAllowed) {
            mYieldAllowed = yieldAllowed;
Builder var72A74007B2BE62B849F475C7BDA4658B_1855849187 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1855849187.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1855849187;
            // ---------- Original Method ----------
            //mYieldAllowed = yieldAllowed;
            //return this;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.717 -0400", hash_original_field = "AAAA741D4E0722E60C557E82C50D8506", hash_generated_field = "F2B415C2E3F102CA367609812B6543AF")

    public final static int TYPE_INSERT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.717 -0400", hash_original_field = "E5C8D33490018BF295517C1322D81059", hash_generated_field = "1442E5D78729E4303598C2A50D596315")

    public final static int TYPE_UPDATE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.718 -0400", hash_original_field = "16C185B26F4235C839B6C799AF390AC8", hash_generated_field = "3AD3AA9BCB51C5A9F57D5C35E47FAB8E")

    public final static int TYPE_DELETE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.718 -0400", hash_original_field = "56EF35D33F3E27C0A0F597095F0BC865", hash_generated_field = "20A63CA4A4C078199A85B846D689891A")

    public final static int TYPE_ASSERT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.718 -0400", hash_original_field = "D81EC5BE5702893FA88B99989F310913", hash_generated_field = "24245924956604414829F296110ED079")

    private final static String TAG = "ContentProviderOperation";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.718 -0400", hash_original_field = "8924CBDB7EE2EFEBC660CED8A0C59192", hash_generated_field = "9AC0BB3876B129B46AD7C4638D0FA4D8")

    public static final Creator<ContentProviderOperation> CREATOR =
            new Creator<ContentProviderOperation>() {
        public ContentProviderOperation createFromParcel(Parcel source) {
            return new ContentProviderOperation(source);
        }

        public ContentProviderOperation[] newArray(int size) {
            return new ContentProviderOperation[size];
        }
    };
    // orphaned legacy method
    public ContentProviderOperation createFromParcel(Parcel source) {
            return new ContentProviderOperation(source);
        }
    
    // orphaned legacy method
    public ContentProviderOperation[] newArray(int size) {
            return new ContentProviderOperation[size];
        }
    
}

