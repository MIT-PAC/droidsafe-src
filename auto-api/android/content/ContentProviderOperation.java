package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.586 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.586 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

    private Uri mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.586 -0400", hash_original_field = "D53310829851F4FC641DE95C4A986129", hash_generated_field = "B8B15EC2943749CD20950EAD77AF5EC7")

    private String mSelection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.586 -0400", hash_original_field = "BAEA1B6F996F3986EF68E88ECD2F5469", hash_generated_field = "5541CF5102D1C94942E84E1E2C6A7EFF")

    private String[] mSelectionArgs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.586 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "2CDA41B4D101B2B770760EBED9C98242")

    private ContentValues mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.586 -0400", hash_original_field = "CCF3A996E025C390C9379F65A4EEC523", hash_generated_field = "0366D826BB05344215E0357A75CDC773")

    private Integer mExpectedCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.586 -0400", hash_original_field = "CF4CD4AE5739BE664E237169162A57FD", hash_generated_field = "5CDBA65FCD489D4F2D0BCD78A8638FD5")

    private ContentValues mValuesBackReferences;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.587 -0400", hash_original_field = "6235C72C3DC414902F946F7E4F463896", hash_generated_field = "F3EB1F15BD72236CAC0D0000DA6E4595")

    private Map<Integer, Integer> mSelectionArgsBackReferences;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.587 -0400", hash_original_field = "B3463DA9E487038FF44897CC868147B7", hash_generated_field = "878B9839823FAA28C7AD4A475721F913")

    private boolean mYieldAllowed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.587 -0400", hash_original_method = "E83648833C15023B0A37354984B5CA31", hash_generated_method = "82CDA661D135A6B2C13B951998951636")
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
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.588 -0400", hash_original_method = "9004240102FD3717D6F1BEB293484741", hash_generated_method = "A0137081A51045A121470D9EB1475728")
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
            final int count = source.readInt();
            {
                int i = 0;
                {
                    mSelectionArgsBackReferences.put(source.readInt(), source.readInt());
                } 
            } 
        } 
        mYieldAllowed = source.readInt() != 0;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.600 -0400", hash_original_method = "D97604A456AD6CF9916FB862EEBD56CF", hash_generated_method = "A653DCA31C8FAF56CA6255BFA6C69CA2")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mType);
        Uri.writeToParcel(dest, mUri);
        {
            dest.writeInt(1);
            mValues.writeToParcel(dest, 0);
        } 
        {
            dest.writeInt(0);
        } 
        {
            dest.writeInt(1);
            dest.writeString(mSelection);
        } 
        {
            dest.writeInt(0);
        } 
        {
            dest.writeInt(1);
            dest.writeStringArray(mSelectionArgs);
        } 
        {
            dest.writeInt(0);
        } 
        {
            dest.writeInt(1);
            dest.writeInt(mExpectedCount);
        } 
        {
            dest.writeInt(0);
        } 
        {
            dest.writeInt(1);
            mValuesBackReferences.writeToParcel(dest, 0);
        } 
        {
            dest.writeInt(0);
        } 
        {
            dest.writeInt(1);
            dest.writeInt(mSelectionArgsBackReferences.size());
            {
                Iterator<Map.Entry<Integer, Integer>> varF9A47AC3D36EE6FD092FA741211D4924_1714260338 = (mSelectionArgsBackReferences.entrySet()).iterator();
                varF9A47AC3D36EE6FD092FA741211D4924_1714260338.hasNext();
                Map.Entry<Integer, Integer> entry = varF9A47AC3D36EE6FD092FA741211D4924_1714260338.next();
                {
                    dest.writeInt(entry.getKey());
                    dest.writeInt(entry.getValue());
                } 
            } 
        } 
        {
            dest.writeInt(0);
        } 
        dest.writeInt(mYieldAllowed ? 1 : 0);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    public static Builder newInsert(Uri uri) {
        return new Builder(TYPE_INSERT, uri);
    }

    
    @DSModeled(DSC.SPEC)
    public static Builder newUpdate(Uri uri) {
        return new Builder(TYPE_UPDATE, uri);
    }

    
    @DSModeled(DSC.SPEC)
    public static Builder newDelete(Uri uri) {
        return new Builder(TYPE_DELETE, uri);
    }

    
    @DSModeled(DSC.SPEC)
    public static Builder newAssertQuery(Uri uri) {
        return new Builder(TYPE_ASSERT, uri);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.602 -0400", hash_original_method = "225259AA593B6A59F476A2C569F1B075", hash_generated_method = "2A847D9111F9E2C1B2CE412DD2B3F8E6")
    public Uri getUri() {
        Uri varB4EAC82CA7396A68D541C85D26508E83_127000116 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_127000116 = mUri;
        varB4EAC82CA7396A68D541C85D26508E83_127000116.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_127000116;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.603 -0400", hash_original_method = "0D76D2BF4F9E314AF3AEB01067FC98E0", hash_generated_method = "CA07F422481CCC7A5F95DB4D522EC080")
    public boolean isYieldAllowed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1560480394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1560480394;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.603 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "54AE9755DB3368EDE672B9634400A9D1")
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_86064863 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_86064863;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.604 -0400", hash_original_method = "94452D9A7E20FFB1CE97B24DC927192A", hash_generated_method = "1188A9817E746FFE394812CA82FB3463")
    public boolean isWriteOperation() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1140999050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1140999050;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.605 -0400", hash_original_method = "BBB0424C7EB706D24B64E8DBE01BF66B", hash_generated_method = "E84FCAB07C814DCBAD34A30B3F2AD26F")
    public boolean isReadOperation() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2107558911 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2107558911;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.637 -0400", hash_original_method = "2009EEC78D1FCDD51A500D4742040E7C", hash_generated_method = "39E387115D2EFA0D4D205D52A2230A01")
    public ContentProviderResult apply(ContentProvider provider, ContentProviderResult[] backRefs,
            int numBackRefs) throws OperationApplicationException {
        ContentProviderResult varB4EAC82CA7396A68D541C85D26508E83_939675982 = null; 
        ContentProviderResult varB4EAC82CA7396A68D541C85D26508E83_728580625 = null; 
        ContentValues values = resolveValueBackReferences(backRefs, numBackRefs);
        String[] selectionArgs = resolveSelectionArgsBackReferences(backRefs, numBackRefs);
        {
            Uri newUri = provider.insert(mUri, values);
            {
                if (DroidSafeAndroidRuntime.control) throw new OperationApplicationException("insert failed");
            } 
            varB4EAC82CA7396A68D541C85D26508E83_939675982 = new ContentProviderResult(newUri);
        } 
        int numRows;
        {
            numRows = provider.delete(mUri, mSelection, selectionArgs);
        } 
        {
            numRows = provider.update(mUri, values, mSelection, selectionArgs);
        } 
        {
            String[] projection = null;
            {
                final ArrayList<String> projectionList = new ArrayList<String>();
                {
                    Iterator<Map.Entry<String, Object>> var94CAE6D127D9B49254CA403A57DB3B0A_253125423 = (values.valueSet()).iterator();
                    var94CAE6D127D9B49254CA403A57DB3B0A_253125423.hasNext();
                    Map.Entry<String, Object> entry = var94CAE6D127D9B49254CA403A57DB3B0A_253125423.next();
                    {
                        projectionList.add(entry.getKey());
                    } 
                } 
                projection = projectionList.toArray(new String[projectionList.size()]);
            } 
            final Cursor cursor = provider.query(mUri, projection, mSelection, selectionArgs, null);
            try 
            {
                numRows = cursor.getCount();
                {
                    {
                        boolean var4B88A4E0CCE1DD5CDA31BC6F14F1DD3B_1348516847 = (cursor.moveToNext());
                        {
                            {
                                int i = 0;
                                {
                                    final String cursorValue = cursor.getString(i);
                                    final String expectedValue = values.getAsString(projection[i]);
                                    {
                                        boolean var315C9A13C4CF5F1A59783370621A4A5F_1891794787 = (!TextUtils.equals(cursorValue, expectedValue));
                                        {
                                            if (DroidSafeAndroidRuntime.control) throw new OperationApplicationException("Found value " + cursorValue
                                        + " when expected " + expectedValue + " for column "
                                        + projection[i]);
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            finally 
            {
                cursor.close();
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("bad type, " + mType);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new OperationApplicationException("wrong number of rows: " + numRows);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_728580625 = new ContentProviderResult(numRows);
        addTaint(provider.getTaint());
        addTaint(backRefs[0].getTaint());
        addTaint(numBackRefs);
        ContentProviderResult varA7E53CE21691AB073D9660D615818899_682268267; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_682268267 = varB4EAC82CA7396A68D541C85D26508E83_939675982;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_682268267 = varB4EAC82CA7396A68D541C85D26508E83_728580625;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_682268267.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_682268267;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.647 -0400", hash_original_method = "A962F701648C4B4117BD0A815ABD46EE", hash_generated_method = "CFEA81B12CB3B8BA8702EB2C4C7745B1")
    public ContentValues resolveValueBackReferences(
            ContentProviderResult[] backRefs, int numBackRefs) {
        ContentValues varB4EAC82CA7396A68D541C85D26508E83_1073830171 = null; 
        ContentValues varB4EAC82CA7396A68D541C85D26508E83_1278761 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1073830171 = mValues;
        } 
        ContentValues values;
        {
            values = new ContentValues();
        } 
        {
            values = new ContentValues(mValues);
        } 
        {
            Iterator<Map.Entry<String, Object>> varEAD7F71FAB82DBE4DFEC649FA82C88FE_609655452 = (mValuesBackReferences.valueSet()).iterator();
            varEAD7F71FAB82DBE4DFEC649FA82C88FE_609655452.hasNext();
            Map.Entry<String, Object> entry = varEAD7F71FAB82DBE4DFEC649FA82C88FE_609655452.next();
            {
                String key = entry.getKey();
                Integer backRefIndex = mValuesBackReferences.getAsInteger(key);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("values backref " + key + " is not an integer");
                } 
                values.put(key, backRefToValue(backRefs, numBackRefs, backRefIndex));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1278761 = values;
        addTaint(backRefs[0].getTaint());
        addTaint(numBackRefs);
        ContentValues varA7E53CE21691AB073D9660D615818899_2089424561; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2089424561 = varB4EAC82CA7396A68D541C85D26508E83_1073830171;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2089424561 = varB4EAC82CA7396A68D541C85D26508E83_1278761;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2089424561.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2089424561;
        
        
            
        
        
        
            
        
            
        
        
            
            
            
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.662 -0400", hash_original_method = "AA4B64F522D451BE6AD1A7AFC7A63956", hash_generated_method = "B33D7C291C6F79F65D62B77EBAE7FFA8")
    public String[] resolveSelectionArgsBackReferences(
            ContentProviderResult[] backRefs, int numBackRefs) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1540593382 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_874115438 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1540593382 = mSelectionArgs;
        } 
        String[] newArgs = new String[mSelectionArgs.length];
        System.arraycopy(mSelectionArgs, 0, newArgs, 0, mSelectionArgs.length);
        {
            Iterator<Map.Entry<Integer, Integer>> varE4ACC7EC0785CAFCE8884A18E88D0ADD_1308352582 = (mSelectionArgsBackReferences.entrySet()).iterator();
            varE4ACC7EC0785CAFCE8884A18E88D0ADD_1308352582.hasNext();
            Map.Entry<Integer, Integer> selectionArgBackRef = varE4ACC7EC0785CAFCE8884A18E88D0ADD_1308352582.next();
            {
                final Integer selectionArgIndex = selectionArgBackRef.getKey();
                final int backRefIndex = selectionArgBackRef.getValue();
                newArgs[selectionArgIndex] =
                    String.valueOf(backRefToValue(backRefs, numBackRefs, backRefIndex));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_874115438 = newArgs;
        addTaint(backRefs[0].getTaint());
        addTaint(numBackRefs);
        String[] varA7E53CE21691AB073D9660D615818899_1377566956; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1377566956 = varB4EAC82CA7396A68D541C85D26508E83_1540593382;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1377566956 = varB4EAC82CA7396A68D541C85D26508E83_874115438;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1377566956.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1377566956;
        
        
            
        
        
        
        
                
            
            
            
                    
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.664 -0400", hash_original_method = "78718167AF18105CAC703FAFB09E4964", hash_generated_method = "A8E2DB1C77A30250B0A242135679826B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1516141636 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1516141636 = "mType: " + mType + ", mUri: " + mUri +
                ", mSelection: " + mSelection +
                ", mExpectedCount: " + mExpectedCount +
                ", mYieldAllowed: " + mYieldAllowed +
                ", mValues: " + mValues +
                ", mValuesBackReferences: " + mValuesBackReferences +
                ", mSelectionArgsBackReferences: " + mSelectionArgsBackReferences;
        varB4EAC82CA7396A68D541C85D26508E83_1516141636.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1516141636;
        
        
                
                
                
                
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.666 -0400", hash_original_method = "4E134EAC713EA4116B151015A8D49950", hash_generated_method = "F3039856D332D7163137AC16D8B995D1")
    private long backRefToValue(ContentProviderResult[] backRefs, int numBackRefs,
            Integer backRefIndex) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException("asked for back ref " + backRefIndex
                    + " but there are only " + numBackRefs + " back refs");
        } 
        ContentProviderResult backRef = backRefs[backRefIndex];
        long backRefValue;
        {
            backRefValue = ContentUris.parseId(backRef.uri);
        } 
        {
            backRefValue = backRef.count;
        } 
        addTaint(backRefs[0].getTaint());
        addTaint(numBackRefs);
        addTaint(backRefIndex.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_800128101 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_800128101;
        
        
            
            
                    
        
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.666 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DDEAD8BC2044D6F1E87F73B17A38B5F2")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_105246934 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_105246934;
        
        
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.667 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

        private int mType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.667 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

        private Uri mUri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.667 -0400", hash_original_field = "D53310829851F4FC641DE95C4A986129", hash_generated_field = "B8B15EC2943749CD20950EAD77AF5EC7")

        private String mSelection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.667 -0400", hash_original_field = "BAEA1B6F996F3986EF68E88ECD2F5469", hash_generated_field = "5541CF5102D1C94942E84E1E2C6A7EFF")

        private String[] mSelectionArgs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.667 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "2CDA41B4D101B2B770760EBED9C98242")

        private ContentValues mValues;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.667 -0400", hash_original_field = "CCF3A996E025C390C9379F65A4EEC523", hash_generated_field = "0366D826BB05344215E0357A75CDC773")

        private Integer mExpectedCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.667 -0400", hash_original_field = "CF4CD4AE5739BE664E237169162A57FD", hash_generated_field = "5CDBA65FCD489D4F2D0BCD78A8638FD5")

        private ContentValues mValuesBackReferences;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.667 -0400", hash_original_field = "6235C72C3DC414902F946F7E4F463896", hash_generated_field = "F3EB1F15BD72236CAC0D0000DA6E4595")

        private Map<Integer, Integer> mSelectionArgsBackReferences;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.667 -0400", hash_original_field = "B3463DA9E487038FF44897CC868147B7", hash_generated_field = "878B9839823FAA28C7AD4A475721F913")

        private boolean mYieldAllowed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.668 -0400", hash_original_method = "E4683F1EC70220B8EE12920060472DE0", hash_generated_method = "A69583727DFF86B9E66EFE8F3D804826")
        private  Builder(int type, Uri uri) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("uri must not be null");
            } 
            mType = type;
            mUri = uri;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.669 -0400", hash_original_method = "52DF5CD1F3EDB944F65D1FF1857828C4", hash_generated_method = "D28C9ED70E1CF5B0399FE120BDEE7D8C")
        public ContentProviderOperation build() {
            ContentProviderOperation varB4EAC82CA7396A68D541C85D26508E83_1917417732 = null; 
            {
                {
                    boolean varE217E6379D20B25A0EC064610B0EEA97_377387195 = ((mValues == null || mValues.size() == 0)
                        && (mValuesBackReferences == null || mValuesBackReferences.size() == 0));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Empty values");
                    } 
                } 
            } 
            {
                {
                    boolean var35BFBE8564F87B211AE46E433A8E370B_971884786 = ((mValues == null || mValues.size() == 0)
                        && (mValuesBackReferences == null || mValuesBackReferences.size() == 0)
                        && (mExpectedCount == null));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Empty values");
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1917417732 = new ContentProviderOperation(this);
            varB4EAC82CA7396A68D541C85D26508E83_1917417732.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1917417732;
            
            
                
                        
                    
                
            
            
                
                        
                        
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.670 -0400", hash_original_method = "48DEB08B58C335127E8366C72D237182", hash_generated_method = "CCE44615B392864321B6ABBA55D1249C")
        public Builder withValueBackReferences(ContentValues backReferences) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_881233282 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "only inserts, updates, and asserts can have value back-references");
            } 
            mValuesBackReferences = backReferences;
            varB4EAC82CA7396A68D541C85D26508E83_881233282 = this;
            varB4EAC82CA7396A68D541C85D26508E83_881233282.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_881233282;
            
            
                
                        
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.672 -0400", hash_original_method = "9B7E0512DF416F22106A40FEC0A8A4AE", hash_generated_method = "AACEFC5BC349AB9CF7F8EC31AE605FA7")
        public Builder withValueBackReference(String key, int previousResult) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1302587174 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "only inserts, updates, and asserts can have value back-references");
            } 
            {
                mValuesBackReferences = new ContentValues();
            } 
            mValuesBackReferences.put(key, previousResult);
            varB4EAC82CA7396A68D541C85D26508E83_1302587174 = this;
            addTaint(key.getTaint());
            addTaint(previousResult);
            varB4EAC82CA7396A68D541C85D26508E83_1302587174.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1302587174;
            
            
                
                        
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.675 -0400", hash_original_method = "0B4CE4049FC576DCE44E5153CA371A5B", hash_generated_method = "74F2B1512DBF032741DED8C4D8329F35")
        public Builder withSelectionBackReference(int selectionArgIndex, int previousResult) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1307122664 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("only updates, deletes, and asserts "
                        + "can have selection back-references");
            } 
            {
                mSelectionArgsBackReferences = new HashMap<Integer, Integer>();
            } 
            mSelectionArgsBackReferences.put(selectionArgIndex, previousResult);
            varB4EAC82CA7396A68D541C85D26508E83_1307122664 = this;
            addTaint(selectionArgIndex);
            addTaint(previousResult);
            varB4EAC82CA7396A68D541C85D26508E83_1307122664.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1307122664;
            
            
                
                        
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.677 -0400", hash_original_method = "F7B8F8808C4F5F5C0301B85A5CF2FD8A", hash_generated_method = "FBF6236BB6261F938B839838123FD392")
        public Builder withValues(ContentValues values) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_377888835 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "only inserts, updates, and asserts can have values");
            } 
            {
                mValues = new ContentValues();
            } 
            mValues.putAll(values);
            varB4EAC82CA7396A68D541C85D26508E83_377888835 = this;
            addTaint(values.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_377888835.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_377888835;
            
            
                
                        
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.679 -0400", hash_original_method = "E35FC6F92508151B3604E11EFF6133FA", hash_generated_method = "97D83DD75591116BE9C58E0BB5D0221E")
        public Builder withValue(String key, Object value) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1639433091 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("only inserts and updates can have values");
            } 
            {
                mValues = new ContentValues();
            } 
            {
                mValues.putNull(key);
            } 
            {
                mValues.put(key, (String) value);
            } 
            {
                mValues.put(key, (Byte) value);
            } 
            {
                mValues.put(key, (Short) value);
            } 
            {
                mValues.put(key, (Integer) value);
            } 
            {
                mValues.put(key, (Long) value);
            } 
            {
                mValues.put(key, (Float) value);
            } 
            {
                mValues.put(key, (Double) value);
            } 
            {
                mValues.put(key, (Boolean) value);
            } 
            {
                mValues.put(key, (byte[]) value);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bad value type: " + value.getClass().getName());
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1639433091 = this;
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1639433091.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1639433091;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.680 -0400", hash_original_method = "26D13871C486DC34FECD72252582D17D", hash_generated_method = "36441FD442694081D149193CCC428FE9")
        public Builder withSelection(String selection, String[] selectionArgs) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1379713028 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "only updates, deletes, and asserts can have selections");
            } 
            mSelection = selection;
            {
                mSelectionArgs = null;
            } 
            {
                mSelectionArgs = new String[selectionArgs.length];
                System.arraycopy(selectionArgs, 0, mSelectionArgs, 0, selectionArgs.length);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1379713028 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1379713028.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1379713028;
            
            
                
                        
            
            
            
                
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.682 -0400", hash_original_method = "70A8F698538BA5C44D08715766038CFE", hash_generated_method = "036E91A3694DDFBECC7D0B3ADB231D30")
        public Builder withExpectedCount(int count) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1194680524 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "only updates, deletes, and asserts can have expected counts");
            } 
            mExpectedCount = count;
            varB4EAC82CA7396A68D541C85D26508E83_1194680524 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1194680524.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1194680524;
            
            
                
                        
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.684 -0400", hash_original_method = "1D016C05C5C9EB70F24159159C761C5E", hash_generated_method = "FCAA3211C6F400F47FC6B55E1AC87F55")
        public Builder withYieldAllowed(boolean yieldAllowed) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_669214649 = null; 
            mYieldAllowed = yieldAllowed;
            varB4EAC82CA7396A68D541C85D26508E83_669214649 = this;
            varB4EAC82CA7396A68D541C85D26508E83_669214649.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_669214649;
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.684 -0400", hash_original_field = "AAAA741D4E0722E60C557E82C50D8506", hash_generated_field = "F2B415C2E3F102CA367609812B6543AF")

    public final static int TYPE_INSERT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.685 -0400", hash_original_field = "E5C8D33490018BF295517C1322D81059", hash_generated_field = "1442E5D78729E4303598C2A50D596315")

    public final static int TYPE_UPDATE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.685 -0400", hash_original_field = "16C185B26F4235C839B6C799AF390AC8", hash_generated_field = "3AD3AA9BCB51C5A9F57D5C35E47FAB8E")

    public final static int TYPE_DELETE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.685 -0400", hash_original_field = "56EF35D33F3E27C0A0F597095F0BC865", hash_generated_field = "20A63CA4A4C078199A85B846D689891A")

    public final static int TYPE_ASSERT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.686 -0400", hash_original_field = "D81EC5BE5702893FA88B99989F310913", hash_generated_field = "24245924956604414829F296110ED079")

    private final static String TAG = "ContentProviderOperation";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.686 -0400", hash_original_field = "8924CBDB7EE2EFEBC660CED8A0C59192", hash_generated_field = "9AC0BB3876B129B46AD7C4638D0FA4D8")

    public static final Creator<ContentProviderOperation> CREATOR =
            new Creator<ContentProviderOperation>() {
        public ContentProviderOperation createFromParcel(Parcel source) {
            return new ContentProviderOperation(source);
        }

        public ContentProviderOperation[] newArray(int size) {
            return new ContentProviderOperation[size];
        }
    };
    
    public ContentProviderOperation createFromParcel(Parcel source) {
            return new ContentProviderOperation(source);
        }
    
    
    public ContentProviderOperation[] newArray(int size) {
            return new ContentProviderOperation[size];
        }
    
}

