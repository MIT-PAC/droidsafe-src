package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class ContentValues implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.110 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "6A0C6DC1A4312984791FEB326F38FF7D")

    private HashMap<String, Object> mValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.112 -0400", hash_original_method = "5E7EA6E1821501C5972B7C7CC639145B", hash_generated_method = "83FF0F0E418B834B6E273F883D6E85A7")
    public  ContentValues() {
        mValues = new HashMap<String, Object>(8);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.113 -0400", hash_original_method = "8E588067C2537376173067FE549DA446", hash_generated_method = "D0D5812EE2DB379AB6C6BB1E1BD6130B")
    public  ContentValues(int size) {
        mValues = new HashMap<String, Object>(size, 1.0f);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.114 -0400", hash_original_method = "6386ACC7AEA70584EF32F8CAA1BD0C6A", hash_generated_method = "937E374A693CA953B17BC90DBC99F429")
    public  ContentValues(ContentValues from) {
        mValues = new HashMap<String, Object>(from.mValues);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.115 -0400", hash_original_method = "79B820032F5D7F722A5DF12324BC548A", hash_generated_method = "4656658A43EB411DAEBB7511F1FF62E0")
    private  ContentValues(HashMap<String, Object> values) {
        mValues = values;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.116 -0400", hash_original_method = "B119129681FC05E44686163A6A753063", hash_generated_method = "F7262C52D86DBED80D784BA07769D3FC")
    @Override
    public boolean equals(Object object) {
        boolean varCE35AA2414ECA57986478B874E61D0DF_1995777413 = (mValues.equals(((ContentValues) object).mValues));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1892494960 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1892494960;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.117 -0400", hash_original_method = "61C7B1D258FDF4A8DE4F58009B844658", hash_generated_method = "642A6B6429AF1D1C68BF73F7D87693FE")
    @Override
    public int hashCode() {
        int var77745914D15D7334241B586923DBF077_2076468308 = (mValues.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1365656411 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1365656411;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.118 -0400", hash_original_method = "65B11A528910ED48D0A8C0B3A81DCA11", hash_generated_method = "FFDE44D3C135CAFF4A6DE717045A95E3")
    public void put(String key, String value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.119 -0400", hash_original_method = "0A271D2A4C7890E9466C28EF447DC416", hash_generated_method = "099F371E5982224B8F5A57FB0CB4C64B")
    public void putAll(ContentValues other) {
        mValues.putAll(other.mValues);
        addTaint(other.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.120 -0400", hash_original_method = "46309CD6AABC048E549ED8D367B97222", hash_generated_method = "96CE4398F113DBDBCF489AB04A374A0E")
    public void put(String key, Byte value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.121 -0400", hash_original_method = "19B45CF10C6274AA18ED4281EBB4A7D5", hash_generated_method = "B06761064F041D5518BA05B1A354C3E0")
    public void put(String key, Short value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.123 -0400", hash_original_method = "519D763DA29CBC7E3659F73066396076", hash_generated_method = "0D282950C16144FA7AE139FC3CD977A6")
    public void put(String key, Integer value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.126 -0400", hash_original_method = "68C6754D41E6DE24B60EFC88A41FDF20", hash_generated_method = "723629AC11F90CB682A1C44AE2C18F27")
    public void put(String key, Long value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.127 -0400", hash_original_method = "66DA1C106B1B7F2AFB03D110B785A501", hash_generated_method = "F260B9CBF1708B15E23BE2DA370F7333")
    public void put(String key, Float value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.129 -0400", hash_original_method = "1050A4E9D6DF2BBB4B07F9E50B35502F", hash_generated_method = "4340EC558A269DB428BB90004BC7FCBC")
    public void put(String key, Double value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.130 -0400", hash_original_method = "C35988B4D54806692C616FB01B8C7793", hash_generated_method = "E5237FAD277E35EABFB89C762EB1CBCC")
    public void put(String key, Boolean value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.131 -0400", hash_original_method = "79D16814F7AC00D5B324C095EC421557", hash_generated_method = "7AFB955903E6251F42E85E3D9EAA52EE")
    public void put(String key, byte[] value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.132 -0400", hash_original_method = "8F0D800F5C28B5CCC219C4767FE49E89", hash_generated_method = "9CB265BB83C56865423C3F7F1A5369D9")
    public void putNull(String key) {
        mValues.put(key, null);
        addTaint(key.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.134 -0400", hash_original_method = "C7AE6CE1280D5E080A32F66907E851BD", hash_generated_method = "01B9A208E5D762486C1D288442D59015")
    public int size() {
        int varF779B1E04A2732336D06BD8C9C52B50E_279377160 = (mValues.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27653298 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27653298;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.136 -0400", hash_original_method = "377B4DB42071C90137241E64BA4CBF0D", hash_generated_method = "F88441A1360D065BE9CBBA2C79A39443")
    public void remove(String key) {
        mValues.remove(key);
        addTaint(key.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.137 -0400", hash_original_method = "08286611C689211C8F9484889D0FA29C", hash_generated_method = "BF85B5F668E6CB7B60B49325EA514CB6")
    public void clear() {
        mValues.clear();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.137 -0400", hash_original_method = "26760966C3F3EED5AADC7592B64BFAAE", hash_generated_method = "B14F9FF3D05F8A307F3D1FB5E10E0EF7")
    public boolean containsKey(String key) {
        boolean var1A922EEE95FE1D978384090336DB26E0_90530654 = (mValues.containsKey(key));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2071149379 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2071149379;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.141 -0400", hash_original_method = "F0AF95EE9AB5B022FDA3C4DAA44F68C1", hash_generated_method = "F6D6CF7701C3325823A7294D4E2E3945")
    public Object get(String key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1239278243 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1239278243 = mValues.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1239278243.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1239278243;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.144 -0400", hash_original_method = "FD6B0B33BC77B5F3D2D2C6DE92834A83", hash_generated_method = "FE8C45F5FBF03CF8BE4C720E95841CDB")
    public String getAsString(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_2145982446 = null; 
        Object value = mValues.get(key);
        varB4EAC82CA7396A68D541C85D26508E83_2145982446 = value != null ? value.toString() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2145982446.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2145982446;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.151 -0400", hash_original_method = "50D64D5E49DC2F013CFC471F23AA3A1E", hash_generated_method = "26BF8CEB1903A0C04B13426DCDF31E7A")
    public Long getAsLong(String key) {
        Long varB4EAC82CA7396A68D541C85D26508E83_525519289 = null; 
        Long varB4EAC82CA7396A68D541C85D26508E83_1286531842 = null; 
        Long varB4EAC82CA7396A68D541C85D26508E83_1636483500 = null; 
        Long varB4EAC82CA7396A68D541C85D26508E83_1383207864 = null; 
        Object value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_525519289 = value != null ? ((Number) value).longValue() : null;
        } 
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1286531842 = Long.valueOf(value.toString());
                } 
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1636483500 = null;
                } 
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1383207864 = null;
            } 
        } 
        addTaint(key.getTaint());
        Long varA7E53CE21691AB073D9660D615818899_134849029; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_134849029 = varB4EAC82CA7396A68D541C85D26508E83_525519289;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_134849029 = varB4EAC82CA7396A68D541C85D26508E83_1286531842;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_134849029 = varB4EAC82CA7396A68D541C85D26508E83_1636483500;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_134849029 = varB4EAC82CA7396A68D541C85D26508E83_1383207864;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_134849029.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_134849029;
        
        
        
            
        
            
                
                    
                
                    
                    
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.158 -0400", hash_original_method = "C11C55EBF0D230069C8558AD456DF6B2", hash_generated_method = "C70FDE6EFFEFA485A5C249588FF40AD7")
    public Integer getAsInteger(String key) {
        Integer varB4EAC82CA7396A68D541C85D26508E83_1258868541 = null; 
        Integer varB4EAC82CA7396A68D541C85D26508E83_418669347 = null; 
        Integer varB4EAC82CA7396A68D541C85D26508E83_700919724 = null; 
        Integer varB4EAC82CA7396A68D541C85D26508E83_101361289 = null; 
        Object value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1258868541 = value != null ? ((Number) value).intValue() : null;
        } 
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_418669347 = Integer.valueOf(value.toString());
                } 
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_700919724 = null;
                } 
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_101361289 = null;
            } 
        } 
        addTaint(key.getTaint());
        Integer varA7E53CE21691AB073D9660D615818899_49814378; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_49814378 = varB4EAC82CA7396A68D541C85D26508E83_1258868541;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_49814378 = varB4EAC82CA7396A68D541C85D26508E83_418669347;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_49814378 = varB4EAC82CA7396A68D541C85D26508E83_700919724;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_49814378 = varB4EAC82CA7396A68D541C85D26508E83_101361289;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_49814378.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_49814378;
        
        
        
            
        
            
                
                    
                
                    
                    
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.164 -0400", hash_original_method = "20021B08C31B81AF996FD4C57E428DFB", hash_generated_method = "B4747BE2FCA295B2C4C2FE37E6037F8E")
    public Short getAsShort(String key) {
        Short varB4EAC82CA7396A68D541C85D26508E83_560733741 = null; 
        Short varB4EAC82CA7396A68D541C85D26508E83_1005583233 = null; 
        Short varB4EAC82CA7396A68D541C85D26508E83_472775053 = null; 
        Short varB4EAC82CA7396A68D541C85D26508E83_998423675 = null; 
        Object value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_560733741 = value != null ? ((Number) value).shortValue() : null;
        } 
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1005583233 = Short.valueOf(value.toString());
                } 
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_472775053 = null;
                } 
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_998423675 = null;
            } 
        } 
        addTaint(key.getTaint());
        Short varA7E53CE21691AB073D9660D615818899_1774212851; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1774212851 = varB4EAC82CA7396A68D541C85D26508E83_560733741;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1774212851 = varB4EAC82CA7396A68D541C85D26508E83_1005583233;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1774212851 = varB4EAC82CA7396A68D541C85D26508E83_472775053;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1774212851 = varB4EAC82CA7396A68D541C85D26508E83_998423675;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1774212851.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1774212851;
        
        
        
            
        
            
                
                    
                
                    
                    
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.171 -0400", hash_original_method = "10A45AB5E2B4A25109E88A986B8ABD1E", hash_generated_method = "21DC420AC878CA060879A7B8C302C0D2")
    public Byte getAsByte(String key) {
        Byte varB4EAC82CA7396A68D541C85D26508E83_1144258604 = null; 
        Byte varB4EAC82CA7396A68D541C85D26508E83_823865683 = null; 
        Byte varB4EAC82CA7396A68D541C85D26508E83_664254735 = null; 
        Byte varB4EAC82CA7396A68D541C85D26508E83_264493595 = null; 
        Object value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1144258604 = value != null ? ((Number) value).byteValue() : null;
        } 
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_823865683 = Byte.valueOf(value.toString());
                } 
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_664254735 = null;
                } 
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_264493595 = null;
            } 
        } 
        addTaint(key.getTaint());
        Byte varA7E53CE21691AB073D9660D615818899_679489458; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_679489458 = varB4EAC82CA7396A68D541C85D26508E83_1144258604;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_679489458 = varB4EAC82CA7396A68D541C85D26508E83_823865683;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_679489458 = varB4EAC82CA7396A68D541C85D26508E83_664254735;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_679489458 = varB4EAC82CA7396A68D541C85D26508E83_264493595;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_679489458.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_679489458;
        
        
        
            
        
            
                
                    
                
                    
                    
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.178 -0400", hash_original_method = "43D54EF438725B45BE89593CD2466062", hash_generated_method = "EB602A0EF81CE2777494EED887179FAF")
    public Double getAsDouble(String key) {
        Double varB4EAC82CA7396A68D541C85D26508E83_541128714 = null; 
        Double varB4EAC82CA7396A68D541C85D26508E83_1300484940 = null; 
        Double varB4EAC82CA7396A68D541C85D26508E83_1626891164 = null; 
        Double varB4EAC82CA7396A68D541C85D26508E83_923900189 = null; 
        Object value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_541128714 = value != null ? ((Number) value).doubleValue() : null;
        } 
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1300484940 = Double.valueOf(value.toString());
                } 
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1626891164 = null;
                } 
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_923900189 = null;
            } 
        } 
        addTaint(key.getTaint());
        Double varA7E53CE21691AB073D9660D615818899_748817247; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_748817247 = varB4EAC82CA7396A68D541C85D26508E83_541128714;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_748817247 = varB4EAC82CA7396A68D541C85D26508E83_1300484940;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_748817247 = varB4EAC82CA7396A68D541C85D26508E83_1626891164;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_748817247 = varB4EAC82CA7396A68D541C85D26508E83_923900189;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_748817247.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_748817247;
        
        
        
            
        
            
                
                    
                
                    
                    
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.183 -0400", hash_original_method = "72E58B472E78C1EB7239E330F6CA9313", hash_generated_method = "0FAAA7BBE00E2A96D3B3BD9D3AE761F5")
    public Float getAsFloat(String key) {
        Float varB4EAC82CA7396A68D541C85D26508E83_2113235742 = null; 
        Float varB4EAC82CA7396A68D541C85D26508E83_1594201236 = null; 
        Float varB4EAC82CA7396A68D541C85D26508E83_1066598649 = null; 
        Float varB4EAC82CA7396A68D541C85D26508E83_511641704 = null; 
        Object value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2113235742 = value != null ? ((Number) value).floatValue() : null;
        } 
        catch (ClassCastException e)
        {
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1594201236 = Float.valueOf(value.toString());
                } 
                catch (NumberFormatException e2)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1066598649 = null;
                } 
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_511641704 = null;
            } 
        } 
        addTaint(key.getTaint());
        Float varA7E53CE21691AB073D9660D615818899_1904660934; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1904660934 = varB4EAC82CA7396A68D541C85D26508E83_2113235742;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1904660934 = varB4EAC82CA7396A68D541C85D26508E83_1594201236;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1904660934 = varB4EAC82CA7396A68D541C85D26508E83_1066598649;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1904660934 = varB4EAC82CA7396A68D541C85D26508E83_511641704;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1904660934.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1904660934;
        
        
        
            
        
            
                
                    
                
                    
                    
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.191 -0400", hash_original_method = "26BA447DF201321FA24067450431D916", hash_generated_method = "FF67069DF0A051556744FD9D06FB987E")
    public Boolean getAsBoolean(String key) {
        Boolean varB4EAC82CA7396A68D541C85D26508E83_1271574874 = null; 
        Boolean varB4EAC82CA7396A68D541C85D26508E83_559502620 = null; 
        Boolean varB4EAC82CA7396A68D541C85D26508E83_758040018 = null; 
        Boolean varB4EAC82CA7396A68D541C85D26508E83_467482074 = null; 
        Object value = mValues.get(key);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1271574874 = (Boolean) value;
        } 
        catch (ClassCastException e)
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_559502620 = Boolean.valueOf(value.toString());
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_758040018 = ((Number) value).intValue() != 0;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_467482074 = null;
            } 
        } 
        addTaint(key.getTaint());
        Boolean varA7E53CE21691AB073D9660D615818899_2113310895; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2113310895 = varB4EAC82CA7396A68D541C85D26508E83_1271574874;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2113310895 = varB4EAC82CA7396A68D541C85D26508E83_559502620;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_2113310895 = varB4EAC82CA7396A68D541C85D26508E83_758040018;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2113310895 = varB4EAC82CA7396A68D541C85D26508E83_467482074;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2113310895.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2113310895;
        
        
        
            
        
            
                
            
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.193 -0400", hash_original_method = "A780551E0EA49FF2BF74805BA852B981", hash_generated_method = "47D1790393DBC3D72EBE6F027E93F695")
    public byte[] getAsByteArray(String key) {
        Object value = mValues.get(key);
        addTaint(key.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_289889646 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_289889646;
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.197 -0400", hash_original_method = "CB190561C8A3BAECAF3D6E789BEEE6E0", hash_generated_method = "C2B9C16E3F0C767E423F870D341B27FD")
    public Set<Map.Entry<String, Object>> valueSet() {
        Set<Map.Entry<String, Object>> varB4EAC82CA7396A68D541C85D26508E83_481176785 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_481176785 = mValues.entrySet();
        varB4EAC82CA7396A68D541C85D26508E83_481176785.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_481176785;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.200 -0400", hash_original_method = "424C133E0D7FEE4B423B7AD7977A2226", hash_generated_method = "80B788B956A107A7C77F4512A102FD05")
    public Set<String> keySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1200647154 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1200647154 = mValues.keySet();
        varB4EAC82CA7396A68D541C85D26508E83_1200647154.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1200647154;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.201 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1EA906F4C985FFFC5AFA6C0FBF189D5B")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977078194 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977078194;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.202 -0400", hash_original_method = "2C0F18C86DFE76C8F92DFC9EBC596E26", hash_generated_method = "F91DDDA7A9D6CFB65CC75136F15628C6")
    @SuppressWarnings("deprecation")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeMap(mValues);
        addTaint(parcel.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.204 -0400", hash_original_method = "F9E2AE250F36F443A2E1239B6C3C3E6F", hash_generated_method = "05FDD8C042F741DFE9E4F4535D06C748")
    @Deprecated
    public void putStringArrayList(String key, ArrayList<String> value) {
        mValues.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.210 -0400", hash_original_method = "F231C09776862BE2F464FBA056529E22", hash_generated_method = "51291CF021CBAF7BEAA98BD90AAE67D2")
    @SuppressWarnings("unchecked")
    @Deprecated
    public ArrayList<String> getStringArrayList(String key) {
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_376945168 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_376945168 = (ArrayList<String>) mValues.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_376945168.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_376945168;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.223 -0400", hash_original_method = "7B4B42E004B10F53CC96D4FD27076B59", hash_generated_method = "6A235F44EEB6EC0F8212F42B96C17454")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1447541882 = null; 
        StringBuilder sb = new StringBuilder();
        {
            Iterator<String> varC858E3D8CE741BE1E06DE4187B96D0A0_1423158167 = (mValues.keySet()).iterator();
            varC858E3D8CE741BE1E06DE4187B96D0A0_1423158167.hasNext();
            String name = varC858E3D8CE741BE1E06DE4187B96D0A0_1423158167.next();
            {
                String value = getAsString(name);
                {
                    boolean var44E9D3A0138A31D1E5A269420690E988_968050388 = (sb.length() > 0);
                    sb.append(" ");
                } 
                sb.append(name + "=" + value);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1447541882 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1447541882.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1447541882;
        
        
        
            
            
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.223 -0400", hash_original_field = "152549EAC6853488AFD777EF8FF3AD43", hash_generated_field = "AB3063BFEEBD1A5014F8E7157F8C6CDE")

    public static final String TAG = "ContentValues";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.224 -0400", hash_original_field = "4984E8C692C60517E25A1E921D4F008F", hash_generated_field = "507973BFDDF20607CD005815DB6B91C3")

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
    
    @SuppressWarnings({"deprecation", "unchecked"})
        public ContentValues createFromParcel(Parcel in) {
            
            HashMap<String, Object> values = in.readHashMap(null);
            return new ContentValues(values);
        }
    
    
    public ContentValues[] newArray(int size) {
            return new ContentValues[size];
        }
    
}

