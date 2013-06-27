package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class ContentValues implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.275 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "6A0C6DC1A4312984791FEB326F38FF7D")

    private HashMap<String, Object> mValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.283 -0400", hash_original_method = "5E7EA6E1821501C5972B7C7CC639145B", hash_generated_method = "83FF0F0E418B834B6E273F883D6E85A7")
    public  ContentValues() {
        mValues = new HashMap<String, Object>(8);
        // ---------- Original Method ----------
        //mValues = new HashMap<String, Object>(8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.289 -0400", hash_original_method = "8E588067C2537376173067FE549DA446", hash_generated_method = "D0D5812EE2DB379AB6C6BB1E1BD6130B")
    public  ContentValues(int size) {
        mValues = new HashMap<String, Object>(size, 1.0f);
        // ---------- Original Method ----------
        //mValues = new HashMap<String, Object>(size, 1.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.290 -0400", hash_original_method = "6386ACC7AEA70584EF32F8CAA1BD0C6A", hash_generated_method = "937E374A693CA953B17BC90DBC99F429")
    public  ContentValues(ContentValues from) {
        mValues = new HashMap<String, Object>(from.mValues);
        // ---------- Original Method ----------
        //mValues = new HashMap<String, Object>(from.mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.295 -0400", hash_original_method = "79B820032F5D7F722A5DF12324BC548A", hash_generated_method = "4656658A43EB411DAEBB7511F1FF62E0")
    private  ContentValues(HashMap<String, Object> values) {
        mValues = values;
        // ---------- Original Method ----------
        //mValues = values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.301 -0400", hash_original_method = "B119129681FC05E44686163A6A753063", hash_generated_method = "9F1745A0688A23484108F2A4D324C72B")
    @Override
    public boolean equals(Object object) {
        boolean varCE35AA2414ECA57986478B874E61D0DF_425291568 = (mValues.equals(((ContentValues) object).mValues));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144803856 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144803856;
        // ---------- Original Method ----------
        //if (!(object instanceof ContentValues)) {
            //return false;
        //}
        //return mValues.equals(((ContentValues) object).mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.303 -0400", hash_original_method = "61C7B1D258FDF4A8DE4F58009B844658", hash_generated_method = "3A8B812550BCF5ED0F470B1128CC2924")
    @Override
    public int hashCode() {
        int var77745914D15D7334241B586923DBF077_1226099309 = (mValues.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561412067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561412067;
        // ---------- Original Method ----------
        //return mValues.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.304 -0400", hash_original_method = "65B11A528910ED48D0A8C0B3A81DCA11", hash_generated_method = "FFDE44D3C135CAFF4A6DE717045A95E3")
    public void put(String key, String value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.320 -0400", hash_original_method = "0A271D2A4C7890E9466C28EF447DC416", hash_generated_method = "099F371E5982224B8F5A57FB0CB4C64B")
    public void putAll(ContentValues other) {
        mValues.putAll(other.mValues);
        addTaint(other.getTaint());
        // ---------- Original Method ----------
        //mValues.putAll(other.mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.326 -0400", hash_original_method = "46309CD6AABC048E549ED8D367B97222", hash_generated_method = "96CE4398F113DBDBCF489AB04A374A0E")
    public void put(String key, Byte value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.327 -0400", hash_original_method = "19B45CF10C6274AA18ED4281EBB4A7D5", hash_generated_method = "B06761064F041D5518BA05B1A354C3E0")
    public void put(String key, Short value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.328 -0400", hash_original_method = "519D763DA29CBC7E3659F73066396076", hash_generated_method = "0D282950C16144FA7AE139FC3CD977A6")
    public void put(String key, Integer value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.328 -0400", hash_original_method = "68C6754D41E6DE24B60EFC88A41FDF20", hash_generated_method = "723629AC11F90CB682A1C44AE2C18F27")
    public void put(String key, Long value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.346 -0400", hash_original_method = "66DA1C106B1B7F2AFB03D110B785A501", hash_generated_method = "F260B9CBF1708B15E23BE2DA370F7333")
    public void put(String key, Float value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.347 -0400", hash_original_method = "1050A4E9D6DF2BBB4B07F9E50B35502F", hash_generated_method = "4340EC558A269DB428BB90004BC7FCBC")
    public void put(String key, Double value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.348 -0400", hash_original_method = "C35988B4D54806692C616FB01B8C7793", hash_generated_method = "E5237FAD277E35EABFB89C762EB1CBCC")
    public void put(String key, Boolean value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.352 -0400", hash_original_method = "79D16814F7AC00D5B324C095EC421557", hash_generated_method = "7AFB955903E6251F42E85E3D9EAA52EE")
    public void put(String key, byte[] value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.353 -0400", hash_original_method = "8F0D800F5C28B5CCC219C4767FE49E89", hash_generated_method = "9CB265BB83C56865423C3F7F1A5369D9")
    public void putNull(String key) {
        mValues.put(key, null);
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.354 -0400", hash_original_method = "C7AE6CE1280D5E080A32F66907E851BD", hash_generated_method = "A1119C52DA83BF3D49F5D6CB09FACA61")
    public int size() {
        int varF779B1E04A2732336D06BD8C9C52B50E_266302721 = (mValues.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244336466 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244336466;
        // ---------- Original Method ----------
        //return mValues.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.354 -0400", hash_original_method = "377B4DB42071C90137241E64BA4CBF0D", hash_generated_method = "F88441A1360D065BE9CBBA2C79A39443")
    public void remove(String key) {
        mValues.remove(key);
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //mValues.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.372 -0400", hash_original_method = "08286611C689211C8F9484889D0FA29C", hash_generated_method = "BF85B5F668E6CB7B60B49325EA514CB6")
    public void clear() {
        mValues.clear();
        // ---------- Original Method ----------
        //mValues.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.373 -0400", hash_original_method = "26760966C3F3EED5AADC7592B64BFAAE", hash_generated_method = "BCDABDE9BEBB79CD82E317E2D165EA7A")
    public boolean containsKey(String key) {
        boolean var1A922EEE95FE1D978384090336DB26E0_489207550 = (mValues.containsKey(key));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_417556304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_417556304;
        // ---------- Original Method ----------
        //return mValues.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.374 -0400", hash_original_method = "F0AF95EE9AB5B022FDA3C4DAA44F68C1", hash_generated_method = "BC48CB5076826B391DD15B3617CA6B30")
    public Object get(String key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1813041249 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1813041249 = mValues.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1813041249.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1813041249;
        // ---------- Original Method ----------
        //return mValues.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.379 -0400", hash_original_method = "FD6B0B33BC77B5F3D2D2C6DE92834A83", hash_generated_method = "54BE5EFC1214F79F6949E9F4681FCE86")
    public String getAsString(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_1192015466 = null; //Variable for return #1
        Object value;
        value = mValues.get(key);
        varB4EAC82CA7396A68D541C85D26508E83_1192015466 = value != null ? value.toString() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1192015466.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1192015466;
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //return value != null ? value.toString() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.390 -0400", hash_original_method = "50D64D5E49DC2F013CFC471F23AA3A1E", hash_generated_method = "C69EEBFD7494D0F0F78C87442B56E927")
    public Long getAsLong(String key) {
        Long varB4EAC82CA7396A68D541C85D26508E83_2004377446 = null; //Variable for return #1
        Long varB4EAC82CA7396A68D541C85D26508E83_75525992 = null; //Variable for return #2
        Long varB4EAC82CA7396A68D541C85D26508E83_1553314045 = null; //Variable for return #3
        Long varB4EAC82CA7396A68D541C85D26508E83_1918656911 = null; //Variable for return #4
        Object value;
        value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2004377446 = value != null ? ((Number) value).longValue() : null;
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_75525992 = Long.valueOf(value.toString());
                } //End block
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1553314045 = null;
                } //End block
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1918656911 = null;
            } //End block
        } //End block
        addTaint(key.getTaint());
        Long varA7E53CE21691AB073D9660D615818899_730385824; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_730385824 = varB4EAC82CA7396A68D541C85D26508E83_2004377446;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_730385824 = varB4EAC82CA7396A68D541C85D26508E83_75525992;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_730385824 = varB4EAC82CA7396A68D541C85D26508E83_1553314045;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_730385824 = varB4EAC82CA7396A68D541C85D26508E83_1918656911;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_730385824.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_730385824;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.418 -0400", hash_original_method = "C11C55EBF0D230069C8558AD456DF6B2", hash_generated_method = "9C66A73B8B2CBFBBD7DF4ECA69AFF702")
    public Integer getAsInteger(String key) {
        Integer varB4EAC82CA7396A68D541C85D26508E83_1320126096 = null; //Variable for return #1
        Integer varB4EAC82CA7396A68D541C85D26508E83_1321280009 = null; //Variable for return #2
        Integer varB4EAC82CA7396A68D541C85D26508E83_2047075267 = null; //Variable for return #3
        Integer varB4EAC82CA7396A68D541C85D26508E83_1714723615 = null; //Variable for return #4
        Object value;
        value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1320126096 = value != null ? ((Number) value).intValue() : null;
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1321280009 = Integer.valueOf(value.toString());
                } //End block
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2047075267 = null;
                } //End block
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1714723615 = null;
            } //End block
        } //End block
        addTaint(key.getTaint());
        Integer varA7E53CE21691AB073D9660D615818899_695690274; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_695690274 = varB4EAC82CA7396A68D541C85D26508E83_1320126096;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_695690274 = varB4EAC82CA7396A68D541C85D26508E83_1321280009;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_695690274 = varB4EAC82CA7396A68D541C85D26508E83_2047075267;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_695690274 = varB4EAC82CA7396A68D541C85D26508E83_1714723615;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_695690274.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_695690274;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.435 -0400", hash_original_method = "20021B08C31B81AF996FD4C57E428DFB", hash_generated_method = "B796A33DB7ADE4B616FB769F0255DD00")
    public Short getAsShort(String key) {
        Short varB4EAC82CA7396A68D541C85D26508E83_1237810839 = null; //Variable for return #1
        Short varB4EAC82CA7396A68D541C85D26508E83_748808485 = null; //Variable for return #2
        Short varB4EAC82CA7396A68D541C85D26508E83_1614644052 = null; //Variable for return #3
        Short varB4EAC82CA7396A68D541C85D26508E83_1767027644 = null; //Variable for return #4
        Object value;
        value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1237810839 = value != null ? ((Number) value).shortValue() : null;
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_748808485 = Short.valueOf(value.toString());
                } //End block
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1614644052 = null;
                } //End block
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1767027644 = null;
            } //End block
        } //End block
        addTaint(key.getTaint());
        Short varA7E53CE21691AB073D9660D615818899_495639298; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_495639298 = varB4EAC82CA7396A68D541C85D26508E83_1237810839;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_495639298 = varB4EAC82CA7396A68D541C85D26508E83_748808485;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_495639298 = varB4EAC82CA7396A68D541C85D26508E83_1614644052;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_495639298 = varB4EAC82CA7396A68D541C85D26508E83_1767027644;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_495639298.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_495639298;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.437 -0400", hash_original_method = "10A45AB5E2B4A25109E88A986B8ABD1E", hash_generated_method = "7ECAAEDB483F1986B9DEE69F3FDD6686")
    public Byte getAsByte(String key) {
        Byte varB4EAC82CA7396A68D541C85D26508E83_43370639 = null; //Variable for return #1
        Byte varB4EAC82CA7396A68D541C85D26508E83_1832816192 = null; //Variable for return #2
        Byte varB4EAC82CA7396A68D541C85D26508E83_1585644694 = null; //Variable for return #3
        Byte varB4EAC82CA7396A68D541C85D26508E83_708730579 = null; //Variable for return #4
        Object value;
        value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_43370639 = value != null ? ((Number) value).byteValue() : null;
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1832816192 = Byte.valueOf(value.toString());
                } //End block
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1585644694 = null;
                } //End block
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_708730579 = null;
            } //End block
        } //End block
        addTaint(key.getTaint());
        Byte varA7E53CE21691AB073D9660D615818899_986538891; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_986538891 = varB4EAC82CA7396A68D541C85D26508E83_43370639;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_986538891 = varB4EAC82CA7396A68D541C85D26508E83_1832816192;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_986538891 = varB4EAC82CA7396A68D541C85D26508E83_1585644694;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_986538891 = varB4EAC82CA7396A68D541C85D26508E83_708730579;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_986538891.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_986538891;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.472 -0400", hash_original_method = "43D54EF438725B45BE89593CD2466062", hash_generated_method = "6ED45BB0290E498EFBE7D5F686818EEE")
    public Double getAsDouble(String key) {
        Double varB4EAC82CA7396A68D541C85D26508E83_924329230 = null; //Variable for return #1
        Double varB4EAC82CA7396A68D541C85D26508E83_794642124 = null; //Variable for return #2
        Double varB4EAC82CA7396A68D541C85D26508E83_2134343944 = null; //Variable for return #3
        Double varB4EAC82CA7396A68D541C85D26508E83_1665937240 = null; //Variable for return #4
        Object value;
        value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_924329230 = value != null ? ((Number) value).doubleValue() : null;
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_794642124 = Double.valueOf(value.toString());
                } //End block
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2134343944 = null;
                } //End block
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1665937240 = null;
            } //End block
        } //End block
        addTaint(key.getTaint());
        Double varA7E53CE21691AB073D9660D615818899_1573591819; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1573591819 = varB4EAC82CA7396A68D541C85D26508E83_924329230;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1573591819 = varB4EAC82CA7396A68D541C85D26508E83_794642124;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1573591819 = varB4EAC82CA7396A68D541C85D26508E83_2134343944;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1573591819 = varB4EAC82CA7396A68D541C85D26508E83_1665937240;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1573591819.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1573591819;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.495 -0400", hash_original_method = "72E58B472E78C1EB7239E330F6CA9313", hash_generated_method = "A2E8C258A29AD254FC519095135DCE91")
    public Float getAsFloat(String key) {
        Float varB4EAC82CA7396A68D541C85D26508E83_1825110115 = null; //Variable for return #1
        Float varB4EAC82CA7396A68D541C85D26508E83_861792651 = null; //Variable for return #2
        Float varB4EAC82CA7396A68D541C85D26508E83_52494739 = null; //Variable for return #3
        Float varB4EAC82CA7396A68D541C85D26508E83_2014141539 = null; //Variable for return #4
        Object value;
        value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1825110115 = value != null ? ((Number) value).floatValue() : null;
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_861792651 = Float.valueOf(value.toString());
                } //End block
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_52494739 = null;
                } //End block
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_2014141539 = null;
            } //End block
        } //End block
        addTaint(key.getTaint());
        Float varA7E53CE21691AB073D9660D615818899_766096347; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_766096347 = varB4EAC82CA7396A68D541C85D26508E83_1825110115;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_766096347 = varB4EAC82CA7396A68D541C85D26508E83_861792651;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_766096347 = varB4EAC82CA7396A68D541C85D26508E83_52494739;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_766096347 = varB4EAC82CA7396A68D541C85D26508E83_2014141539;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_766096347.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_766096347;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.498 -0400", hash_original_method = "26BA447DF201321FA24067450431D916", hash_generated_method = "75311C541A1D461C99B3D21D9611C98B")
    public Boolean getAsBoolean(String key) {
        Boolean varB4EAC82CA7396A68D541C85D26508E83_965618907 = null; //Variable for return #1
        Boolean varB4EAC82CA7396A68D541C85D26508E83_1475564760 = null; //Variable for return #2
        Boolean varB4EAC82CA7396A68D541C85D26508E83_136165080 = null; //Variable for return #3
        Boolean varB4EAC82CA7396A68D541C85D26508E83_2129972699 = null; //Variable for return #4
        Object value;
        value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_965618907 = (Boolean) value;
        } //End block
        catch (ClassCastException e)
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1475564760 = Boolean.valueOf(value.toString());
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_136165080 = ((Number) value).intValue() != 0;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_2129972699 = null;
            } //End block
        } //End block
        addTaint(key.getTaint());
        Boolean varA7E53CE21691AB073D9660D615818899_616028903; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_616028903 = varB4EAC82CA7396A68D541C85D26508E83_965618907;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_616028903 = varB4EAC82CA7396A68D541C85D26508E83_1475564760;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_616028903 = varB4EAC82CA7396A68D541C85D26508E83_136165080;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_616028903 = varB4EAC82CA7396A68D541C85D26508E83_2129972699;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_616028903.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_616028903;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.499 -0400", hash_original_method = "A780551E0EA49FF2BF74805BA852B981", hash_generated_method = "5B413D69756A182A7063DE8DF8EB082C")
    public byte[] getAsByteArray(String key) {
        Object value;
        value = mValues.get(key);
        addTaint(key.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_379632589 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_379632589;
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //if (value instanceof byte[]) {
            //return (byte[]) value;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.518 -0400", hash_original_method = "CB190561C8A3BAECAF3D6E789BEEE6E0", hash_generated_method = "23352EB1B64F99E798180D849536BA54")
    public Set<Map.Entry<String, Object>> valueSet() {
        Set<Map.Entry<String, Object>> varB4EAC82CA7396A68D541C85D26508E83_1459073363 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1459073363 = mValues.entrySet();
        varB4EAC82CA7396A68D541C85D26508E83_1459073363.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1459073363;
        // ---------- Original Method ----------
        //return mValues.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.519 -0400", hash_original_method = "424C133E0D7FEE4B423B7AD7977A2226", hash_generated_method = "CF4F57E8D83A7CE14BBFE0D9BAFBAAD9")
    public Set<String> keySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_54249909 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_54249909 = mValues.keySet();
        varB4EAC82CA7396A68D541C85D26508E83_54249909.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_54249909;
        // ---------- Original Method ----------
        //return mValues.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.520 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "CC119052A32415429E9263A8C49D0721")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499281093 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499281093;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.534 -0400", hash_original_method = "2C0F18C86DFE76C8F92DFC9EBC596E26", hash_generated_method = "F91DDDA7A9D6CFB65CC75136F15628C6")
    @SuppressWarnings("deprecation")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeMap(mValues);
        addTaint(parcel.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //parcel.writeMap(mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.536 -0400", hash_original_method = "F9E2AE250F36F443A2E1239B6C3C3E6F", hash_generated_method = "05FDD8C042F741DFE9E4F4535D06C748")
    @Deprecated
    public void putStringArrayList(String key, ArrayList<String> value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.543 -0400", hash_original_method = "F231C09776862BE2F464FBA056529E22", hash_generated_method = "77CD91E838AC6B6AB769CE2D875FEC76")
    @SuppressWarnings("unchecked")
    @Deprecated
    public ArrayList<String> getStringArrayList(String key) {
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_449324848 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_449324848 = (ArrayList<String>) mValues.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_449324848.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_449324848;
        // ---------- Original Method ----------
        //return (ArrayList<String>) mValues.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.856 -0400", hash_original_method = "7B4B42E004B10F53CC96D4FD27076B59", hash_generated_method = "4E6E932C5A5B2984999EE37FDF0F3A2A")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1053013242 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder();
        {
            Iterator<String> varC858E3D8CE741BE1E06DE4187B96D0A0_517774057 = (mValues.keySet()).iterator();
            varC858E3D8CE741BE1E06DE4187B96D0A0_517774057.hasNext();
            String name = varC858E3D8CE741BE1E06DE4187B96D0A0_517774057.next();
            {
                String value;
                value = getAsString(name);
                {
                    boolean var44E9D3A0138A31D1E5A269420690E988_1671593998 = (sb.length() > 0);
                    sb.append(" ");
                } //End collapsed parenthetic
                sb.append(name + "=" + value);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1053013242 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1053013242.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1053013242;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //for (String name : mValues.keySet()) {
            //String value = getAsString(name);
            //if (sb.length() > 0) sb.append(" ");
            //sb.append(name + "=" + value);
        //}
        //return sb.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.866 -0400", hash_original_field = "152549EAC6853488AFD777EF8FF3AD43", hash_generated_field = "AB3063BFEEBD1A5014F8E7157F8C6CDE")

    public static final String TAG = "ContentValues";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.867 -0400", hash_original_field = "4984E8C692C60517E25A1E921D4F008F", hash_generated_field = "507973BFDDF20607CD005815DB6B91C3")

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
}

