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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.823 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "6A0C6DC1A4312984791FEB326F38FF7D")

    private HashMap<String, Object> mValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.850 -0400", hash_original_method = "5E7EA6E1821501C5972B7C7CC639145B", hash_generated_method = "83FF0F0E418B834B6E273F883D6E85A7")
    public  ContentValues() {
        mValues = new HashMap<String, Object>(8);
        // ---------- Original Method ----------
        //mValues = new HashMap<String, Object>(8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.864 -0400", hash_original_method = "8E588067C2537376173067FE549DA446", hash_generated_method = "D0D5812EE2DB379AB6C6BB1E1BD6130B")
    public  ContentValues(int size) {
        mValues = new HashMap<String, Object>(size, 1.0f);
        // ---------- Original Method ----------
        //mValues = new HashMap<String, Object>(size, 1.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.866 -0400", hash_original_method = "6386ACC7AEA70584EF32F8CAA1BD0C6A", hash_generated_method = "937E374A693CA953B17BC90DBC99F429")
    public  ContentValues(ContentValues from) {
        mValues = new HashMap<String, Object>(from.mValues);
        // ---------- Original Method ----------
        //mValues = new HashMap<String, Object>(from.mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.868 -0400", hash_original_method = "79B820032F5D7F722A5DF12324BC548A", hash_generated_method = "4656658A43EB411DAEBB7511F1FF62E0")
    private  ContentValues(HashMap<String, Object> values) {
        mValues = values;
        // ---------- Original Method ----------
        //mValues = values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.869 -0400", hash_original_method = "B119129681FC05E44686163A6A753063", hash_generated_method = "D347A3E35B9220027A9DF8000FF2DCB1")
    @Override
    public boolean equals(Object object) {
        boolean varCE35AA2414ECA57986478B874E61D0DF_1352637846 = (mValues.equals(((ContentValues) object).mValues));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1156014805 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1156014805;
        // ---------- Original Method ----------
        //if (!(object instanceof ContentValues)) {
            //return false;
        //}
        //return mValues.equals(((ContentValues) object).mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.870 -0400", hash_original_method = "61C7B1D258FDF4A8DE4F58009B844658", hash_generated_method = "4AD9A1EDAB1576118A96089DBE392B03")
    @Override
    public int hashCode() {
        int var77745914D15D7334241B586923DBF077_1451225293 = (mValues.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1931797319 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1931797319;
        // ---------- Original Method ----------
        //return mValues.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.888 -0400", hash_original_method = "65B11A528910ED48D0A8C0B3A81DCA11", hash_generated_method = "FFDE44D3C135CAFF4A6DE717045A95E3")
    public void put(String key, String value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.889 -0400", hash_original_method = "0A271D2A4C7890E9466C28EF447DC416", hash_generated_method = "099F371E5982224B8F5A57FB0CB4C64B")
    public void putAll(ContentValues other) {
        mValues.putAll(other.mValues);
        addTaint(other.getTaint());
        // ---------- Original Method ----------
        //mValues.putAll(other.mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.893 -0400", hash_original_method = "46309CD6AABC048E549ED8D367B97222", hash_generated_method = "96CE4398F113DBDBCF489AB04A374A0E")
    public void put(String key, Byte value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.893 -0400", hash_original_method = "19B45CF10C6274AA18ED4281EBB4A7D5", hash_generated_method = "B06761064F041D5518BA05B1A354C3E0")
    public void put(String key, Short value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.898 -0400", hash_original_method = "519D763DA29CBC7E3659F73066396076", hash_generated_method = "0D282950C16144FA7AE139FC3CD977A6")
    public void put(String key, Integer value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.899 -0400", hash_original_method = "68C6754D41E6DE24B60EFC88A41FDF20", hash_generated_method = "723629AC11F90CB682A1C44AE2C18F27")
    public void put(String key, Long value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.919 -0400", hash_original_method = "66DA1C106B1B7F2AFB03D110B785A501", hash_generated_method = "F260B9CBF1708B15E23BE2DA370F7333")
    public void put(String key, Float value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.920 -0400", hash_original_method = "1050A4E9D6DF2BBB4B07F9E50B35502F", hash_generated_method = "4340EC558A269DB428BB90004BC7FCBC")
    public void put(String key, Double value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.943 -0400", hash_original_method = "C35988B4D54806692C616FB01B8C7793", hash_generated_method = "E5237FAD277E35EABFB89C762EB1CBCC")
    public void put(String key, Boolean value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.944 -0400", hash_original_method = "79D16814F7AC00D5B324C095EC421557", hash_generated_method = "7AFB955903E6251F42E85E3D9EAA52EE")
    public void put(String key, byte[] value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.945 -0400", hash_original_method = "8F0D800F5C28B5CCC219C4767FE49E89", hash_generated_method = "9CB265BB83C56865423C3F7F1A5369D9")
    public void putNull(String key) {
        mValues.put(key, null);
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.969 -0400", hash_original_method = "C7AE6CE1280D5E080A32F66907E851BD", hash_generated_method = "E93CF7C47260712F36B7F0083224348D")
    public int size() {
        int varF779B1E04A2732336D06BD8C9C52B50E_1504872890 = (mValues.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098110312 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098110312;
        // ---------- Original Method ----------
        //return mValues.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.981 -0400", hash_original_method = "377B4DB42071C90137241E64BA4CBF0D", hash_generated_method = "F88441A1360D065BE9CBBA2C79A39443")
    public void remove(String key) {
        mValues.remove(key);
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //mValues.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.990 -0400", hash_original_method = "08286611C689211C8F9484889D0FA29C", hash_generated_method = "BF85B5F668E6CB7B60B49325EA514CB6")
    public void clear() {
        mValues.clear();
        // ---------- Original Method ----------
        //mValues.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.991 -0400", hash_original_method = "26760966C3F3EED5AADC7592B64BFAAE", hash_generated_method = "0360055B48EDFD9E66015E127EEC7C0F")
    public boolean containsKey(String key) {
        boolean var1A922EEE95FE1D978384090336DB26E0_882448852 = (mValues.containsKey(key));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_584806891 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_584806891;
        // ---------- Original Method ----------
        //return mValues.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.001 -0400", hash_original_method = "F0AF95EE9AB5B022FDA3C4DAA44F68C1", hash_generated_method = "90B6702D12B27674F6F3C662FBF68C59")
    public Object get(String key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1460020798 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1460020798 = mValues.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1460020798.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1460020798;
        // ---------- Original Method ----------
        //return mValues.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.002 -0400", hash_original_method = "FD6B0B33BC77B5F3D2D2C6DE92834A83", hash_generated_method = "6C429DE3F4D11212A5DDB6A6A6670415")
    public String getAsString(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_845906935 = null; //Variable for return #1
        Object value;
        value = mValues.get(key);
        varB4EAC82CA7396A68D541C85D26508E83_845906935 = value != null ? value.toString() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_845906935.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_845906935;
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //return value != null ? value.toString() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.022 -0400", hash_original_method = "50D64D5E49DC2F013CFC471F23AA3A1E", hash_generated_method = "7A404E2E9A9E7360DD12A26730548804")
    public Long getAsLong(String key) {
        Long varB4EAC82CA7396A68D541C85D26508E83_781319854 = null; //Variable for return #1
        Long varB4EAC82CA7396A68D541C85D26508E83_17554557 = null; //Variable for return #2
        Long varB4EAC82CA7396A68D541C85D26508E83_1423736007 = null; //Variable for return #3
        Long varB4EAC82CA7396A68D541C85D26508E83_1599374131 = null; //Variable for return #4
        Object value;
        value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_781319854 = value != null ? ((Number) value).longValue() : null;
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_17554557 = Long.valueOf(value.toString());
                } //End block
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1423736007 = null;
                } //End block
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1599374131 = null;
            } //End block
        } //End block
        addTaint(key.getTaint());
        Long varA7E53CE21691AB073D9660D615818899_1931405027; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1931405027 = varB4EAC82CA7396A68D541C85D26508E83_781319854;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1931405027 = varB4EAC82CA7396A68D541C85D26508E83_17554557;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1931405027 = varB4EAC82CA7396A68D541C85D26508E83_1423736007;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1931405027 = varB4EAC82CA7396A68D541C85D26508E83_1599374131;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1931405027.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1931405027;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.030 -0400", hash_original_method = "C11C55EBF0D230069C8558AD456DF6B2", hash_generated_method = "B99FC90A0139A14C85D3DD7F6F3C2C79")
    public Integer getAsInteger(String key) {
        Integer varB4EAC82CA7396A68D541C85D26508E83_206147067 = null; //Variable for return #1
        Integer varB4EAC82CA7396A68D541C85D26508E83_38226442 = null; //Variable for return #2
        Integer varB4EAC82CA7396A68D541C85D26508E83_1252651848 = null; //Variable for return #3
        Integer varB4EAC82CA7396A68D541C85D26508E83_1066778778 = null; //Variable for return #4
        Object value;
        value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_206147067 = value != null ? ((Number) value).intValue() : null;
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_38226442 = Integer.valueOf(value.toString());
                } //End block
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1252651848 = null;
                } //End block
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1066778778 = null;
            } //End block
        } //End block
        addTaint(key.getTaint());
        Integer varA7E53CE21691AB073D9660D615818899_1671623131; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1671623131 = varB4EAC82CA7396A68D541C85D26508E83_206147067;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1671623131 = varB4EAC82CA7396A68D541C85D26508E83_38226442;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1671623131 = varB4EAC82CA7396A68D541C85D26508E83_1252651848;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1671623131 = varB4EAC82CA7396A68D541C85D26508E83_1066778778;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1671623131.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1671623131;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.047 -0400", hash_original_method = "20021B08C31B81AF996FD4C57E428DFB", hash_generated_method = "6D330F5E64BE425A26A07DEBC80D5A69")
    public Short getAsShort(String key) {
        Short varB4EAC82CA7396A68D541C85D26508E83_1335141049 = null; //Variable for return #1
        Short varB4EAC82CA7396A68D541C85D26508E83_1699035750 = null; //Variable for return #2
        Short varB4EAC82CA7396A68D541C85D26508E83_481749855 = null; //Variable for return #3
        Short varB4EAC82CA7396A68D541C85D26508E83_1830063857 = null; //Variable for return #4
        Object value;
        value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1335141049 = value != null ? ((Number) value).shortValue() : null;
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1699035750 = Short.valueOf(value.toString());
                } //End block
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_481749855 = null;
                } //End block
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1830063857 = null;
            } //End block
        } //End block
        addTaint(key.getTaint());
        Short varA7E53CE21691AB073D9660D615818899_1426448988; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1426448988 = varB4EAC82CA7396A68D541C85D26508E83_1335141049;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1426448988 = varB4EAC82CA7396A68D541C85D26508E83_1699035750;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1426448988 = varB4EAC82CA7396A68D541C85D26508E83_481749855;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1426448988 = varB4EAC82CA7396A68D541C85D26508E83_1830063857;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1426448988.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1426448988;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.060 -0400", hash_original_method = "10A45AB5E2B4A25109E88A986B8ABD1E", hash_generated_method = "57CF636B54E96EB95533773677D77429")
    public Byte getAsByte(String key) {
        Byte varB4EAC82CA7396A68D541C85D26508E83_131532001 = null; //Variable for return #1
        Byte varB4EAC82CA7396A68D541C85D26508E83_797103683 = null; //Variable for return #2
        Byte varB4EAC82CA7396A68D541C85D26508E83_1239299303 = null; //Variable for return #3
        Byte varB4EAC82CA7396A68D541C85D26508E83_1825155858 = null; //Variable for return #4
        Object value;
        value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_131532001 = value != null ? ((Number) value).byteValue() : null;
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_797103683 = Byte.valueOf(value.toString());
                } //End block
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1239299303 = null;
                } //End block
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1825155858 = null;
            } //End block
        } //End block
        addTaint(key.getTaint());
        Byte varA7E53CE21691AB073D9660D615818899_1411752423; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1411752423 = varB4EAC82CA7396A68D541C85D26508E83_131532001;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1411752423 = varB4EAC82CA7396A68D541C85D26508E83_797103683;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1411752423 = varB4EAC82CA7396A68D541C85D26508E83_1239299303;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1411752423 = varB4EAC82CA7396A68D541C85D26508E83_1825155858;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1411752423.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1411752423;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.101 -0400", hash_original_method = "43D54EF438725B45BE89593CD2466062", hash_generated_method = "8EBD4A597BEC9A188075BA23BD139653")
    public Double getAsDouble(String key) {
        Double varB4EAC82CA7396A68D541C85D26508E83_1198433772 = null; //Variable for return #1
        Double varB4EAC82CA7396A68D541C85D26508E83_1128395646 = null; //Variable for return #2
        Double varB4EAC82CA7396A68D541C85D26508E83_886076148 = null; //Variable for return #3
        Double varB4EAC82CA7396A68D541C85D26508E83_606465361 = null; //Variable for return #4
        Object value;
        value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1198433772 = value != null ? ((Number) value).doubleValue() : null;
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1128395646 = Double.valueOf(value.toString());
                } //End block
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_886076148 = null;
                } //End block
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_606465361 = null;
            } //End block
        } //End block
        addTaint(key.getTaint());
        Double varA7E53CE21691AB073D9660D615818899_1077726957; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1077726957 = varB4EAC82CA7396A68D541C85D26508E83_1198433772;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1077726957 = varB4EAC82CA7396A68D541C85D26508E83_1128395646;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1077726957 = varB4EAC82CA7396A68D541C85D26508E83_886076148;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1077726957 = varB4EAC82CA7396A68D541C85D26508E83_606465361;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1077726957.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1077726957;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.111 -0400", hash_original_method = "72E58B472E78C1EB7239E330F6CA9313", hash_generated_method = "5425999DC9450D13961268D552191B80")
    public Float getAsFloat(String key) {
        Float varB4EAC82CA7396A68D541C85D26508E83_1751293163 = null; //Variable for return #1
        Float varB4EAC82CA7396A68D541C85D26508E83_1414870000 = null; //Variable for return #2
        Float varB4EAC82CA7396A68D541C85D26508E83_1624069317 = null; //Variable for return #3
        Float varB4EAC82CA7396A68D541C85D26508E83_255883148 = null; //Variable for return #4
        Object value;
        value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1751293163 = value != null ? ((Number) value).floatValue() : null;
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1414870000 = Float.valueOf(value.toString());
                } //End block
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1624069317 = null;
                } //End block
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_255883148 = null;
            } //End block
        } //End block
        addTaint(key.getTaint());
        Float varA7E53CE21691AB073D9660D615818899_1419105124; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1419105124 = varB4EAC82CA7396A68D541C85D26508E83_1751293163;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1419105124 = varB4EAC82CA7396A68D541C85D26508E83_1414870000;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1419105124 = varB4EAC82CA7396A68D541C85D26508E83_1624069317;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1419105124 = varB4EAC82CA7396A68D541C85D26508E83_255883148;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1419105124.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1419105124;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.124 -0400", hash_original_method = "26BA447DF201321FA24067450431D916", hash_generated_method = "EBAE8B10CE6282322EDAEE731B114D6B")
    public Boolean getAsBoolean(String key) {
        Boolean varB4EAC82CA7396A68D541C85D26508E83_855863047 = null; //Variable for return #1
        Boolean varB4EAC82CA7396A68D541C85D26508E83_1683653664 = null; //Variable for return #2
        Boolean varB4EAC82CA7396A68D541C85D26508E83_1110385226 = null; //Variable for return #3
        Boolean varB4EAC82CA7396A68D541C85D26508E83_1580851411 = null; //Variable for return #4
        Object value;
        value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_855863047 = (Boolean) value;
        } //End block
        catch (ClassCastException e)
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1683653664 = Boolean.valueOf(value.toString());
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1110385226 = ((Number) value).intValue() != 0;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1580851411 = null;
            } //End block
        } //End block
        addTaint(key.getTaint());
        Boolean varA7E53CE21691AB073D9660D615818899_1326711163; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1326711163 = varB4EAC82CA7396A68D541C85D26508E83_855863047;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1326711163 = varB4EAC82CA7396A68D541C85D26508E83_1683653664;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1326711163 = varB4EAC82CA7396A68D541C85D26508E83_1110385226;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1326711163 = varB4EAC82CA7396A68D541C85D26508E83_1580851411;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1326711163.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1326711163;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.127 -0400", hash_original_method = "A780551E0EA49FF2BF74805BA852B981", hash_generated_method = "113D8027B88690D88EE24AE3D2154794")
    public byte[] getAsByteArray(String key) {
        Object value;
        value = mValues.get(key);
        addTaint(key.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_534177234 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_534177234;
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //if (value instanceof byte[]) {
            //return (byte[]) value;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.143 -0400", hash_original_method = "CB190561C8A3BAECAF3D6E789BEEE6E0", hash_generated_method = "7D977ABE6012FFA15730E637F1815B83")
    public Set<Map.Entry<String, Object>> valueSet() {
        Set<Map.Entry<String, Object>> varB4EAC82CA7396A68D541C85D26508E83_1809099050 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1809099050 = mValues.entrySet();
        varB4EAC82CA7396A68D541C85D26508E83_1809099050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1809099050;
        // ---------- Original Method ----------
        //return mValues.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.148 -0400", hash_original_method = "424C133E0D7FEE4B423B7AD7977A2226", hash_generated_method = "0BFF0AB7C529CC09D38D0939DB7D6993")
    public Set<String> keySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_300204213 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_300204213 = mValues.keySet();
        varB4EAC82CA7396A68D541C85D26508E83_300204213.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_300204213;
        // ---------- Original Method ----------
        //return mValues.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.155 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "782231366D8C5A1A1F33FA542A465F83")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_411578278 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_411578278;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.175 -0400", hash_original_method = "2C0F18C86DFE76C8F92DFC9EBC596E26", hash_generated_method = "F91DDDA7A9D6CFB65CC75136F15628C6")
    @SuppressWarnings("deprecation")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeMap(mValues);
        addTaint(parcel.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //parcel.writeMap(mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.177 -0400", hash_original_method = "F9E2AE250F36F443A2E1239B6C3C3E6F", hash_generated_method = "05FDD8C042F741DFE9E4F4535D06C748")
    @Deprecated
    public void putStringArrayList(String key, ArrayList<String> value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.187 -0400", hash_original_method = "F231C09776862BE2F464FBA056529E22", hash_generated_method = "1C18B2C3D4EC281F2ACF0F44E261D155")
    @SuppressWarnings("unchecked")
    @Deprecated
    public ArrayList<String> getStringArrayList(String key) {
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_1888412128 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1888412128 = (ArrayList<String>) mValues.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1888412128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1888412128;
        // ---------- Original Method ----------
        //return (ArrayList<String>) mValues.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.314 -0400", hash_original_method = "7B4B42E004B10F53CC96D4FD27076B59", hash_generated_method = "BAAA1244E0A7CDA4821430F0C9DDC00D")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_46862979 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder();
        {
            Iterator<String> varC858E3D8CE741BE1E06DE4187B96D0A0_1507034880 = (mValues.keySet()).iterator();
            varC858E3D8CE741BE1E06DE4187B96D0A0_1507034880.hasNext();
            String name = varC858E3D8CE741BE1E06DE4187B96D0A0_1507034880.next();
            {
                String value;
                value = getAsString(name);
                {
                    boolean var44E9D3A0138A31D1E5A269420690E988_1986511378 = (sb.length() > 0);
                    sb.append(" ");
                } //End collapsed parenthetic
                sb.append(name + "=" + value);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_46862979 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_46862979.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_46862979;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //for (String name : mValues.keySet()) {
            //String value = getAsString(name);
            //if (sb.length() > 0) sb.append(" ");
            //sb.append(name + "=" + value);
        //}
        //return sb.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.314 -0400", hash_original_field = "152549EAC6853488AFD777EF8FF3AD43", hash_generated_field = "AB3063BFEEBD1A5014F8E7157F8C6CDE")

    public static final String TAG = "ContentValues";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.315 -0400", hash_original_field = "4984E8C692C60517E25A1E921D4F008F", hash_generated_field = "507973BFDDF20607CD005815DB6B91C3")

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

