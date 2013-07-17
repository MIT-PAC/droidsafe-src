package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class ContentValues implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.353 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "6A0C6DC1A4312984791FEB326F38FF7D")

    private HashMap<String, Object> mValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.354 -0400", hash_original_method = "5E7EA6E1821501C5972B7C7CC639145B", hash_generated_method = "83FF0F0E418B834B6E273F883D6E85A7")
    public  ContentValues() {
        mValues = new HashMap<String, Object>(8);
        // ---------- Original Method ----------
        //mValues = new HashMap<String, Object>(8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.354 -0400", hash_original_method = "8E588067C2537376173067FE549DA446", hash_generated_method = "D0D5812EE2DB379AB6C6BB1E1BD6130B")
    public  ContentValues(int size) {
        mValues = new HashMap<String, Object>(size, 1.0f);
        // ---------- Original Method ----------
        //mValues = new HashMap<String, Object>(size, 1.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.355 -0400", hash_original_method = "6386ACC7AEA70584EF32F8CAA1BD0C6A", hash_generated_method = "937E374A693CA953B17BC90DBC99F429")
    public  ContentValues(ContentValues from) {
        mValues = new HashMap<String, Object>(from.mValues);
        // ---------- Original Method ----------
        //mValues = new HashMap<String, Object>(from.mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.355 -0400", hash_original_method = "79B820032F5D7F722A5DF12324BC548A", hash_generated_method = "4656658A43EB411DAEBB7511F1FF62E0")
    private  ContentValues(HashMap<String, Object> values) {
        mValues = values;
        // ---------- Original Method ----------
        //mValues = values;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.356 -0400", hash_original_method = "B119129681FC05E44686163A6A753063", hash_generated_method = "84025BAD1691735AC20DB72EF88B6017")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(!(object instanceof ContentValues))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1774905309 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1529931319 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1529931319;
        } //End block
        boolean varD1ABE6B2DE2F574B36B13C6E5380A6A3_979831682 = (mValues.equals(((ContentValues) object).mValues));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_6910624 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_6910624;
        // ---------- Original Method ----------
        //if (!(object instanceof ContentValues)) {
            //return false;
        //}
        //return mValues.equals(((ContentValues) object).mValues);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.357 -0400", hash_original_method = "61C7B1D258FDF4A8DE4F58009B844658", hash_generated_method = "8DEDADB29C6F45EDDF6635C5D679F4FE")
    @Override
    public int hashCode() {
        int varF3BF52998EF64E4010813C8000E0071B_80391264 = (mValues.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1723972755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1723972755;
        // ---------- Original Method ----------
        //return mValues.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.357 -0400", hash_original_method = "65B11A528910ED48D0A8C0B3A81DCA11", hash_generated_method = "A311EC41908D74965B9A3783F21F60CA")
    public void put(String key, String value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.358 -0400", hash_original_method = "0A271D2A4C7890E9466C28EF447DC416", hash_generated_method = "B346E26643B9DD026AF820D04972636E")
    public void putAll(ContentValues other) {
        addTaint(other.getTaint());
        mValues.putAll(other.mValues);
        // ---------- Original Method ----------
        //mValues.putAll(other.mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.359 -0400", hash_original_method = "46309CD6AABC048E549ED8D367B97222", hash_generated_method = "6EF8D9F05335EFB7C22B6E2916EC2637")
    public void put(String key, Byte value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.359 -0400", hash_original_method = "19B45CF10C6274AA18ED4281EBB4A7D5", hash_generated_method = "A09C309C71E6FA7C97065C98B5076ACF")
    public void put(String key, Short value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.360 -0400", hash_original_method = "519D763DA29CBC7E3659F73066396076", hash_generated_method = "60EAE28D24A02E493501B3D3CE7A6252")
    public void put(String key, Integer value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.360 -0400", hash_original_method = "68C6754D41E6DE24B60EFC88A41FDF20", hash_generated_method = "AFE481AE7E8725D3621FBEE7B63ABDD0")
    public void put(String key, Long value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.361 -0400", hash_original_method = "66DA1C106B1B7F2AFB03D110B785A501", hash_generated_method = "B60C142835577C98617D6A91FDCE3B23")
    public void put(String key, Float value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.361 -0400", hash_original_method = "1050A4E9D6DF2BBB4B07F9E50B35502F", hash_generated_method = "82E4505D1677DDDD49ACE1A8FD854F33")
    public void put(String key, Double value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.362 -0400", hash_original_method = "C35988B4D54806692C616FB01B8C7793", hash_generated_method = "15F5BA25AA3D7B32E890DE55AAC81AE2")
    public void put(String key, Boolean value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.363 -0400", hash_original_method = "79D16814F7AC00D5B324C095EC421557", hash_generated_method = "FDEC73EBF4CCF90C899EC0CF616C23A2")
    public void put(String key, byte[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.363 -0400", hash_original_method = "8F0D800F5C28B5CCC219C4767FE49E89", hash_generated_method = "43E6BE0B90F8E540D4D84F700611417D")
    public void putNull(String key) {
        addTaint(key.getTaint());
        mValues.put(key, null);
        // ---------- Original Method ----------
        //mValues.put(key, null);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.364 -0400", hash_original_method = "C7AE6CE1280D5E080A32F66907E851BD", hash_generated_method = "AED507150AEA2F091E1BD190503AFE27")
    public int size() {
        int var6EC976456B1A0FB390548E70FCD4762F_1317236072 = (mValues.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304584522 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304584522;
        // ---------- Original Method ----------
        //return mValues.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.364 -0400", hash_original_method = "377B4DB42071C90137241E64BA4CBF0D", hash_generated_method = "65BC75D41DE250604F7F5F0BE339EFB6")
    public void remove(String key) {
        addTaint(key.getTaint());
        mValues.remove(key);
        // ---------- Original Method ----------
        //mValues.remove(key);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.365 -0400", hash_original_method = "08286611C689211C8F9484889D0FA29C", hash_generated_method = "BF85B5F668E6CB7B60B49325EA514CB6")
    public void clear() {
        mValues.clear();
        // ---------- Original Method ----------
        //mValues.clear();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.365 -0400", hash_original_method = "26760966C3F3EED5AADC7592B64BFAAE", hash_generated_method = "8F2B4640D0170D9F1A5F5DC9BC4A6080")
    public boolean containsKey(String key) {
        addTaint(key.getTaint());
        boolean varAF86F73DAD4DC50A54095891459D83B8_1208453815 = (mValues.containsKey(key));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_291174535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_291174535;
        // ---------- Original Method ----------
        //return mValues.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.366 -0400", hash_original_method = "F0AF95EE9AB5B022FDA3C4DAA44F68C1", hash_generated_method = "BFAFAB82F51D4CDACC791CB75E2D043F")
    public Object get(String key) {
        addTaint(key.getTaint());
Object varA876F1864284E1684A5A68837AB4BB72_2086853917 =         mValues.get(key);
        varA876F1864284E1684A5A68837AB4BB72_2086853917.addTaint(taint);
        return varA876F1864284E1684A5A68837AB4BB72_2086853917;
        // ---------- Original Method ----------
        //return mValues.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.367 -0400", hash_original_method = "FD6B0B33BC77B5F3D2D2C6DE92834A83", hash_generated_method = "3040EF3645128215FDBECC3D8E959B9C")
    public String getAsString(String key) {
        addTaint(key.getTaint());
        Object value = mValues.get(key);
String var569675D405C8FA1F566AE9E18776E3B0_940920092 =         value != null ? value.toString() : null;
        var569675D405C8FA1F566AE9E18776E3B0_940920092.addTaint(taint);
        return var569675D405C8FA1F566AE9E18776E3B0_940920092;
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //return value != null ? value.toString() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.368 -0400", hash_original_method = "50D64D5E49DC2F013CFC471F23AA3A1E", hash_generated_method = "1CF8FB9DB8CB7D09A536B0ABCD540C5A")
    public Long getAsLong(String key) {
        addTaint(key.getTaint());
        Object value = mValues.get(key);
        try 
        {
Long varE070FF873ED6BFF662724406728411AB_1944325553 =             value != null ? ((Number) value).longValue() : null;
            varE070FF873ED6BFF662724406728411AB_1944325553.addTaint(taint);
            return varE070FF873ED6BFF662724406728411AB_1944325553;
        } //End block
        catch (ClassCastException e)
        {
            if(value instanceof CharSequence)            
            {
                try 
                {
Long var4041DEE684C9090B54EFB9FCE4E7EF49_1297771190 =                     Long.valueOf(value.toString());
                    var4041DEE684C9090B54EFB9FCE4E7EF49_1297771190.addTaint(taint);
                    return var4041DEE684C9090B54EFB9FCE4E7EF49_1297771190;
                } //End block
                catch (NumberFormatException e2)
                {
Long var540C13E9E156B687226421B24F2DF178_181297092 =                     null;
                    var540C13E9E156B687226421B24F2DF178_181297092.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_181297092;
                } //End block
            } //End block
            else
            {
Long var540C13E9E156B687226421B24F2DF178_213419843 =                 null;
                var540C13E9E156B687226421B24F2DF178_213419843.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_213419843;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //try {
            //return value != null ? ((Number) value).longValue() : null;
        //} catch (ClassCastException e) {
            //if (value instanceof CharSequence) {
                //try {
                    //return Long.valueOf(value.toString());
                //} catch (NumberFormatException e2) {
                    //Log.e(TAG, "Cannot parse Long value for " + value + " at key " + key);
                    //return null;
                //}
            //} else {
                //Log.e(TAG, "Cannot cast value for " + key + " to a Long: " + value, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.369 -0400", hash_original_method = "C11C55EBF0D230069C8558AD456DF6B2", hash_generated_method = "0D9892DEEA29253B4C2768B87B7D3E20")
    public Integer getAsInteger(String key) {
        addTaint(key.getTaint());
        Object value = mValues.get(key);
        try 
        {
Integer varF7D870985F2A9E52CFB9814B542FDA52_1637011173 =             value != null ? ((Number) value).intValue() : null;
            varF7D870985F2A9E52CFB9814B542FDA52_1637011173.addTaint(taint);
            return varF7D870985F2A9E52CFB9814B542FDA52_1637011173;
        } //End block
        catch (ClassCastException e)
        {
            if(value instanceof CharSequence)            
            {
                try 
                {
Integer var841E32EB4046F9DABA7D54DDDFBF0990_2145754882 =                     Integer.valueOf(value.toString());
                    var841E32EB4046F9DABA7D54DDDFBF0990_2145754882.addTaint(taint);
                    return var841E32EB4046F9DABA7D54DDDFBF0990_2145754882;
                } //End block
                catch (NumberFormatException e2)
                {
Integer var540C13E9E156B687226421B24F2DF178_1661358088 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1661358088.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1661358088;
                } //End block
            } //End block
            else
            {
Integer var540C13E9E156B687226421B24F2DF178_814815596 =                 null;
                var540C13E9E156B687226421B24F2DF178_814815596.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_814815596;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //try {
            //return value != null ? ((Number) value).intValue() : null;
        //} catch (ClassCastException e) {
            //if (value instanceof CharSequence) {
                //try {
                    //return Integer.valueOf(value.toString());
                //} catch (NumberFormatException e2) {
                    //Log.e(TAG, "Cannot parse Integer value for " + value + " at key " + key);
                    //return null;
                //}
            //} else {
                //Log.e(TAG, "Cannot cast value for " + key + " to a Integer: " + value, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.372 -0400", hash_original_method = "20021B08C31B81AF996FD4C57E428DFB", hash_generated_method = "FE309F1F2DB174AA20E038E9219D3ACD")
    public Short getAsShort(String key) {
        addTaint(key.getTaint());
        Object value = mValues.get(key);
        try 
        {
Short var00FEFC66F419C7CBA511D742DCB4EA6B_812846173 =             value != null ? ((Number) value).shortValue() : null;
            var00FEFC66F419C7CBA511D742DCB4EA6B_812846173.addTaint(taint);
            return var00FEFC66F419C7CBA511D742DCB4EA6B_812846173;
        } //End block
        catch (ClassCastException e)
        {
            if(value instanceof CharSequence)            
            {
                try 
                {
Short varC9BDB92B3DC132B36A0946FE69F884E3_613393707 =                     Short.valueOf(value.toString());
                    varC9BDB92B3DC132B36A0946FE69F884E3_613393707.addTaint(taint);
                    return varC9BDB92B3DC132B36A0946FE69F884E3_613393707;
                } //End block
                catch (NumberFormatException e2)
                {
Short var540C13E9E156B687226421B24F2DF178_1386543736 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1386543736.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1386543736;
                } //End block
            } //End block
            else
            {
Short var540C13E9E156B687226421B24F2DF178_1935513971 =                 null;
                var540C13E9E156B687226421B24F2DF178_1935513971.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1935513971;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //try {
            //return value != null ? ((Number) value).shortValue() : null;
        //} catch (ClassCastException e) {
            //if (value instanceof CharSequence) {
                //try {
                    //return Short.valueOf(value.toString());
                //} catch (NumberFormatException e2) {
                    //Log.e(TAG, "Cannot parse Short value for " + value + " at key " + key);
                    //return null;
                //}
            //} else {
                //Log.e(TAG, "Cannot cast value for " + key + " to a Short: " + value, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.375 -0400", hash_original_method = "10A45AB5E2B4A25109E88A986B8ABD1E", hash_generated_method = "F1F0F8915F39CD08B515CC184D2D8E5B")
    public Byte getAsByte(String key) {
        addTaint(key.getTaint());
        Object value = mValues.get(key);
        try 
        {
Byte var63E48D7444A8CFEA81823A6B7ABB069D_866707814 =             value != null ? ((Number) value).byteValue() : null;
            var63E48D7444A8CFEA81823A6B7ABB069D_866707814.addTaint(taint);
            return var63E48D7444A8CFEA81823A6B7ABB069D_866707814;
        } //End block
        catch (ClassCastException e)
        {
            if(value instanceof CharSequence)            
            {
                try 
                {
Byte var53CA7E4E1B9CD43074AB552CEE6C01D9_427070122 =                     Byte.valueOf(value.toString());
                    var53CA7E4E1B9CD43074AB552CEE6C01D9_427070122.addTaint(taint);
                    return var53CA7E4E1B9CD43074AB552CEE6C01D9_427070122;
                } //End block
                catch (NumberFormatException e2)
                {
Byte var540C13E9E156B687226421B24F2DF178_2123490063 =                     null;
                    var540C13E9E156B687226421B24F2DF178_2123490063.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_2123490063;
                } //End block
            } //End block
            else
            {
Byte var540C13E9E156B687226421B24F2DF178_871551507 =                 null;
                var540C13E9E156B687226421B24F2DF178_871551507.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_871551507;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //try {
            //return value != null ? ((Number) value).byteValue() : null;
        //} catch (ClassCastException e) {
            //if (value instanceof CharSequence) {
                //try {
                    //return Byte.valueOf(value.toString());
                //} catch (NumberFormatException e2) {
                    //Log.e(TAG, "Cannot parse Byte value for " + value + " at key " + key);
                    //return null;
                //}
            //} else {
                //Log.e(TAG, "Cannot cast value for " + key + " to a Byte: " + value, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.376 -0400", hash_original_method = "43D54EF438725B45BE89593CD2466062", hash_generated_method = "ACA9BC0BE2789194A3D88EBDC637EA38")
    public Double getAsDouble(String key) {
        addTaint(key.getTaint());
        Object value = mValues.get(key);
        try 
        {
Double var1A79262D5F32C5022B824EE035D0D8E3_439021427 =             value != null ? ((Number) value).doubleValue() : null;
            var1A79262D5F32C5022B824EE035D0D8E3_439021427.addTaint(taint);
            return var1A79262D5F32C5022B824EE035D0D8E3_439021427;
        } //End block
        catch (ClassCastException e)
        {
            if(value instanceof CharSequence)            
            {
                try 
                {
Double var0F071233D251D59732312F5334A07D0C_592081697 =                     Double.valueOf(value.toString());
                    var0F071233D251D59732312F5334A07D0C_592081697.addTaint(taint);
                    return var0F071233D251D59732312F5334A07D0C_592081697;
                } //End block
                catch (NumberFormatException e2)
                {
Double var540C13E9E156B687226421B24F2DF178_1497449825 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1497449825.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1497449825;
                } //End block
            } //End block
            else
            {
Double var540C13E9E156B687226421B24F2DF178_1029660714 =                 null;
                var540C13E9E156B687226421B24F2DF178_1029660714.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1029660714;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //try {
            //return value != null ? ((Number) value).doubleValue() : null;
        //} catch (ClassCastException e) {
            //if (value instanceof CharSequence) {
                //try {
                    //return Double.valueOf(value.toString());
                //} catch (NumberFormatException e2) {
                    //Log.e(TAG, "Cannot parse Double value for " + value + " at key " + key);
                    //return null;
                //}
            //} else {
                //Log.e(TAG, "Cannot cast value for " + key + " to a Double: " + value, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.378 -0400", hash_original_method = "72E58B472E78C1EB7239E330F6CA9313", hash_generated_method = "2E152B8058D1A4F03A3A84DE398758EC")
    public Float getAsFloat(String key) {
        addTaint(key.getTaint());
        Object value = mValues.get(key);
        try 
        {
Float var0AE22C6A6A41AA2583D5BD40D152E7BD_621596642 =             value != null ? ((Number) value).floatValue() : null;
            var0AE22C6A6A41AA2583D5BD40D152E7BD_621596642.addTaint(taint);
            return var0AE22C6A6A41AA2583D5BD40D152E7BD_621596642;
        } //End block
        catch (ClassCastException e)
        {
            if(value instanceof CharSequence)            
            {
                try 
                {
Float var51286E08BA12F88A1F9B407991DD7C1F_1902885253 =                     Float.valueOf(value.toString());
                    var51286E08BA12F88A1F9B407991DD7C1F_1902885253.addTaint(taint);
                    return var51286E08BA12F88A1F9B407991DD7C1F_1902885253;
                } //End block
                catch (NumberFormatException e2)
                {
Float var540C13E9E156B687226421B24F2DF178_1717656092 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1717656092.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1717656092;
                } //End block
            } //End block
            else
            {
Float var540C13E9E156B687226421B24F2DF178_1671523687 =                 null;
                var540C13E9E156B687226421B24F2DF178_1671523687.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1671523687;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //try {
            //return value != null ? ((Number) value).floatValue() : null;
        //} catch (ClassCastException e) {
            //if (value instanceof CharSequence) {
                //try {
                    //return Float.valueOf(value.toString());
                //} catch (NumberFormatException e2) {
                    //Log.e(TAG, "Cannot parse Float value for " + value + " at key " + key);
                    //return null;
                //}
            //} else {
                //Log.e(TAG, "Cannot cast value for " + key + " to a Float: " + value, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.379 -0400", hash_original_method = "26BA447DF201321FA24067450431D916", hash_generated_method = "6C0912758B25F4B3FAFB6E04FC64AF82")
    public Boolean getAsBoolean(String key) {
        addTaint(key.getTaint());
        Object value = mValues.get(key);
        try 
        {
Boolean var4E52AA663CAF2568B9B784936CBB168C_1091311161 =             (Boolean) value;
            var4E52AA663CAF2568B9B784936CBB168C_1091311161.addTaint(taint);
            return var4E52AA663CAF2568B9B784936CBB168C_1091311161;
        } //End block
        catch (ClassCastException e)
        {
            if(value instanceof CharSequence)            
            {
Boolean var99E9185F3BCBE7B5EA3201EE8E71826D_1859396626 =                 Boolean.valueOf(value.toString());
                var99E9185F3BCBE7B5EA3201EE8E71826D_1859396626.addTaint(taint);
                return var99E9185F3BCBE7B5EA3201EE8E71826D_1859396626;
            } //End block
            else
            if(value instanceof Number)            
            {
Boolean varD1F7F32EE4FF71B758DBDD5009523655_1498490956 =                 ((Number) value).intValue() != 0;
                varD1F7F32EE4FF71B758DBDD5009523655_1498490956.addTaint(taint);
                return varD1F7F32EE4FF71B758DBDD5009523655_1498490956;
            } //End block
            else
            {
Boolean var540C13E9E156B687226421B24F2DF178_519103041 =                 null;
                var540C13E9E156B687226421B24F2DF178_519103041.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_519103041;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //try {
            //return (Boolean) value;
        //} catch (ClassCastException e) {
            //if (value instanceof CharSequence) {
                //return Boolean.valueOf(value.toString());
            //} else if (value instanceof Number) {
                //return ((Number) value).intValue() != 0;
            //} else {
                //Log.e(TAG, "Cannot cast value for " + key + " to a Boolean: " + value, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.380 -0400", hash_original_method = "A780551E0EA49FF2BF74805BA852B981", hash_generated_method = "13EEF246624A4C1CA3ECCEB29102FE52")
    public byte[] getAsByteArray(String key) {
        addTaint(key.getTaint());
        Object value = mValues.get(key);
        if(value instanceof byte[])        
        {
            byte[] var80878A6C3D4EF9BCAD0DC4FE999679F3_303205463 = ((byte[]) value);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1354324142 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1354324142;
        } //End block
        else
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_967006502 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1713783594 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1713783594;
        } //End block
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //if (value instanceof byte[]) {
            //return (byte[]) value;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.381 -0400", hash_original_method = "CB190561C8A3BAECAF3D6E789BEEE6E0", hash_generated_method = "63AEA9EB0CD9B30F29CCC711253670AD")
    public Set<Map.Entry<String, Object>> valueSet() {
Set<Map.Entry<String, Object>> var2356B3E490A7637662D7C9F72E2A4B6E_1605312915 =         mValues.entrySet();
        var2356B3E490A7637662D7C9F72E2A4B6E_1605312915.addTaint(taint);
        return var2356B3E490A7637662D7C9F72E2A4B6E_1605312915;
        // ---------- Original Method ----------
        //return mValues.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.382 -0400", hash_original_method = "424C133E0D7FEE4B423B7AD7977A2226", hash_generated_method = "B6E7B466AB7EDA7882D48EB428892712")
    public Set<String> keySet() {
Set<String> var3563EE38FE64D76F70F52DD9D1FB041A_613255004 =         mValues.keySet();
        var3563EE38FE64D76F70F52DD9D1FB041A_613255004.addTaint(taint);
        return var3563EE38FE64D76F70F52DD9D1FB041A_613255004;
        // ---------- Original Method ----------
        //return mValues.keySet();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.382 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1EA08948E5A22724C8639A4877ED3E9C")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1457189461 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1936347900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1936347900;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.383 -0400", hash_original_method = "2C0F18C86DFE76C8F92DFC9EBC596E26", hash_generated_method = "ADB5402C00ACED0EB9EE1CBE16D051AD")
    @SuppressWarnings("deprecation")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
        parcel.writeMap(mValues);
        // ---------- Original Method ----------
        //parcel.writeMap(mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.384 -0400", hash_original_method = "F9E2AE250F36F443A2E1239B6C3C3E6F", hash_generated_method = "2B3868940708E58F37C04CA237293755")
    @Deprecated
    public void putStringArrayList(String key, ArrayList<String> value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.385 -0400", hash_original_method = "F231C09776862BE2F464FBA056529E22", hash_generated_method = "B66E12E5AAE439C893D33DD68374F443")
    @SuppressWarnings("unchecked")
    @Deprecated
    public ArrayList<String> getStringArrayList(String key) {
        addTaint(key.getTaint());
ArrayList<String> varEA5289862F960A8FC777CD59A190A353_1659658204 =         (ArrayList<String>) mValues.get(key);
        varEA5289862F960A8FC777CD59A190A353_1659658204.addTaint(taint);
        return varEA5289862F960A8FC777CD59A190A353_1659658204;
        // ---------- Original Method ----------
        //return (ArrayList<String>) mValues.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.385 -0400", hash_original_method = "7B4B42E004B10F53CC96D4FD27076B59", hash_generated_method = "E6D6006C1599658C27A79DC9FDA22603")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
for(String name : mValues.keySet())
        {
            String value = getAsString(name);
            if(sb.length() > 0)            
            sb.append(" ");
            sb.append(name + "=" + value);
        } //End block
String var2460B846747F8B22185AD8BE722266A5_2112658735 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_2112658735.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_2112658735;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //for (String name : mValues.keySet()) {
            //String value = getAsString(name);
            //if (sb.length() > 0) sb.append(" ");
            //sb.append(name + "=" + value);
        //}
        //return sb.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.385 -0400", hash_original_field = "152549EAC6853488AFD777EF8FF3AD43", hash_generated_field = "AB3063BFEEBD1A5014F8E7157F8C6CDE")

    public static final String TAG = "ContentValues";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.386 -0400", hash_original_field = "4984E8C692C60517E25A1E921D4F008F", hash_generated_field = "507973BFDDF20607CD005815DB6B91C3")

    public static final Parcelable.Creator<ContentValues> CREATOR =
            new Parcelable.Creator<ContentValues>() {
        @SuppressWarnings({"deprecation", "unchecked"})
        public ContentValues createFromParcel(Parcel in) {
            
            HashMap<String, Object> values = in.readHashMap(null);
            return new ContentValues(values);
        }

        public ContentValues[] newArray(int size) {
            return new ContentValues[size];
        }
    };
    // orphaned legacy method
    @SuppressWarnings({"deprecation", "unchecked"})
        public ContentValues createFromParcel(Parcel in) {
            
            HashMap<String, Object> values = in.readHashMap(null);
            return new ContentValues(values);
        }
    
    // orphaned legacy method
    public ContentValues[] newArray(int size) {
            return new ContentValues[size];
        }
    
}

