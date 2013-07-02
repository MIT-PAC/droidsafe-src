package android.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class Keyframe implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.892 -0400", hash_original_field = "8F2259335A204727B633197C1255E450", hash_generated_field = "F9B3CD45EBBDFA29E8A724A34A590B87")

    float mFraction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.892 -0400", hash_original_field = "98DE3BF49406C5ACB6938D9BD7C43E69", hash_generated_field = "28819529602B8605503B4054C761CC6C")

    Class mValueType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.892 -0400", hash_original_field = "155E7AEE84F40EF345E533B402141672", hash_generated_field = "D386D0EA78AAE2D770304D273EDA0A38")

    private TimeInterpolator mInterpolator = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.893 -0400", hash_original_field = "9582B1A85C4A02CE687C1D3131009947", hash_generated_field = "9025E6183B41BD7E7E45DA7F2620D0DA")

    boolean mHasValue = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.893 -0400", hash_original_method = "59B475F2675EC1DB9A85E43A7051AABA", hash_generated_method = "59B475F2675EC1DB9A85E43A7051AABA")
    public Keyframe ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static Keyframe ofInt(float fraction, int value) {
        return new IntKeyframe(fraction, value);
    }

    
    @DSModeled(DSC.SAFE)
    public static Keyframe ofInt(float fraction) {
        return new IntKeyframe(fraction);
    }

    
    @DSModeled(DSC.SAFE)
    public static Keyframe ofFloat(float fraction, float value) {
        return new FloatKeyframe(fraction, value);
    }

    
    @DSModeled(DSC.SAFE)
    public static Keyframe ofFloat(float fraction) {
        return new FloatKeyframe(fraction);
    }

    
    @DSModeled(DSC.SAFE)
    public static Keyframe ofObject(float fraction, Object value) {
        return new ObjectKeyframe(fraction, value);
    }

    
    @DSModeled(DSC.SAFE)
    public static Keyframe ofObject(float fraction) {
        return new ObjectKeyframe(fraction, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.900 -0400", hash_original_method = "6BBC2B3892833CAF7F05465AB80866BD", hash_generated_method = "3201E82FA2D061AF2B7F3C53486F73F0")
    public boolean hasValue() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1163981829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1163981829;
        
        
    }

    
    public abstract Object getValue();

    
    public abstract void setValue(Object value);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.903 -0400", hash_original_method = "35C097CFF55F90D1886F0C54195244F1", hash_generated_method = "D30161CB12C58F0B7B9CE26CD4E840F4")
    public float getFraction() {
        float var546ADE640B6EDFBC8A086EF31347E768_1599421637 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1599421637;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.904 -0400", hash_original_method = "D865B000D8DE764D2EF6EBC1ED2A153F", hash_generated_method = "B828439CB960C667E31928238589D41F")
    public void setFraction(float fraction) {
        mFraction = fraction;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.907 -0400", hash_original_method = "69CBD09EBE4A4B5ECD6AD8540DB7CFD0", hash_generated_method = "5B95913439B78948EA52355990C897E8")
    public TimeInterpolator getInterpolator() {
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_351683649 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_351683649 = mInterpolator;
        varB4EAC82CA7396A68D541C85D26508E83_351683649.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_351683649;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.910 -0400", hash_original_method = "DFEEC0662B39CED0069D1B2AE05648AB", hash_generated_method = "47F1226E1202976956E07A77F6CEA7FC")
    public void setInterpolator(TimeInterpolator interpolator) {
        mInterpolator = interpolator;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.914 -0400", hash_original_method = "464D9B25E7EBB7EEA5039E323C745893", hash_generated_method = "80AEBD5608B30580E1D83A5CAF5CE7E2")
    public Class getType() {
        Class varB4EAC82CA7396A68D541C85D26508E83_824081716 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_824081716 = mValueType;
        varB4EAC82CA7396A68D541C85D26508E83_824081716.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_824081716;
        
        
    }

    
    @Override
public abstract Keyframe clone();

    
    static class ObjectKeyframe extends Keyframe {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.915 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "10C88B3F201F56410DE7B0BF9A3CF880")

        Object mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.917 -0400", hash_original_method = "203797AF2B16BA31CF618ABFC3881151", hash_generated_method = "1A7212EFE4A133122180BCC5B36CC552")
          ObjectKeyframe(float fraction, Object value) {
            mFraction = fraction;
            mValue = value;
            mHasValue = (value != null);
            mValueType = mHasValue ? value.getClass() : Object.class;
            addTaint(fraction);
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.922 -0400", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "E84D1C8741AAFDEC5FD2A7FBE9F82B3B")
        public Object getValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1389412478 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1389412478 = mValue;
            varB4EAC82CA7396A68D541C85D26508E83_1389412478.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1389412478;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.923 -0400", hash_original_method = "A57ED313A37784FB1DA17FC9F39344A7", hash_generated_method = "BCD44A16AB81E639720244E80BED9701")
        public void setValue(Object value) {
            mValue = value;
            mHasValue = (value != null);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.927 -0400", hash_original_method = "D24C77D2B6663612F515281C3853AB21", hash_generated_method = "C78324ABD2BB859CD142220FA908A7AC")
        @Override
        public ObjectKeyframe clone() {
            ObjectKeyframe varB4EAC82CA7396A68D541C85D26508E83_335616363 = null; 
            ObjectKeyframe kfClone = new ObjectKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
            varB4EAC82CA7396A68D541C85D26508E83_335616363 = kfClone;
            varB4EAC82CA7396A68D541C85D26508E83_335616363.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_335616363;
            
            
            
            
        }

        
    }


    
    static class IntKeyframe extends Keyframe {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.928 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC")

        int mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.931 -0400", hash_original_method = "EEAB8C81F88FA2F655356211D4887153", hash_generated_method = "8EF59FFEB5E748453F05BE3DC3C902BA")
          IntKeyframe(float fraction, int value) {
            mFraction = fraction;
            mValue = value;
            mValueType = int.class;
            mHasValue = true;
            addTaint(fraction);
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.933 -0400", hash_original_method = "361D7315F9884E2CC45B77F9DFFA5D0B", hash_generated_method = "714DFBCA3BACC090C4420C562B319F6D")
          IntKeyframe(float fraction) {
            mFraction = fraction;
            mValueType = int.class;
            addTaint(fraction);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.935 -0400", hash_original_method = "7D27B9B7622273E5F87FD5AC6ACFC5AE", hash_generated_method = "CF9F37A3C954BF1B154915D55F7322A5")
        public int getIntValue() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1362801644 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1362801644;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.939 -0400", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "AAD73B56F571AB4BBAFA50657DDA3B1C")
        public Object getValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1644150164 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1644150164 = mValue;
            varB4EAC82CA7396A68D541C85D26508E83_1644150164.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1644150164;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.942 -0400", hash_original_method = "C5497A399E3F74A58085B920F39E31DE", hash_generated_method = "F820917D3C12E113FD03A434B28FAF3C")
        public void setValue(Object value) {
            {
                boolean varDB7BF07CE0FD24C6422AFCD4E275ADB3_150983090 = (value != null && value.getClass() == Integer.class);
                {
                    mValue = ((Integer)value).intValue();
                    mHasValue = true;
                } 
            } 
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.947 -0400", hash_original_method = "25DF873BDC1EC275AA64D474732FCE13", hash_generated_method = "1AEDE9994527CFA4C9DD7A4941014706")
        @Override
        public IntKeyframe clone() {
            IntKeyframe varB4EAC82CA7396A68D541C85D26508E83_1186311517 = null; 
            IntKeyframe kfClone = new IntKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
            varB4EAC82CA7396A68D541C85D26508E83_1186311517 = kfClone;
            varB4EAC82CA7396A68D541C85D26508E83_1186311517.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1186311517;
            
            
            
            
        }

        
    }


    
    static class FloatKeyframe extends Keyframe {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.947 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "61B2557CF01F8FBFCA3655F32AFF6E67")

        float mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.950 -0400", hash_original_method = "12EFD0F6FC013537F5F7DD4B7E13C7C3", hash_generated_method = "941002996CE15D60B928D84A76BD1A2D")
          FloatKeyframe(float fraction, float value) {
            mFraction = fraction;
            mValue = value;
            mValueType = float.class;
            mHasValue = true;
            addTaint(fraction);
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.952 -0400", hash_original_method = "68E29C538F7AE79A8714A7F41CC12063", hash_generated_method = "81E8FA33679F5D31CEC5F3A76615D1FE")
          FloatKeyframe(float fraction) {
            mFraction = fraction;
            mValueType = float.class;
            addTaint(fraction);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.954 -0400", hash_original_method = "4878123D1CBF5008E7E0955AB5FB61F2", hash_generated_method = "00FC9A53D1D12F5BEED36971240BE750")
        public float getFloatValue() {
            float var546ADE640B6EDFBC8A086EF31347E768_711955671 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_711955671;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.958 -0400", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "C6C3C1F705F2A5A7094C53C02B113627")
        public Object getValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_32380878 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_32380878 = mValue;
            varB4EAC82CA7396A68D541C85D26508E83_32380878.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_32380878;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.962 -0400", hash_original_method = "7C5BB3EB4CAFBCF934453BA7EC3D20EB", hash_generated_method = "2C9D6ECC983BC908675EC4CEBFD62281")
        public void setValue(Object value) {
            {
                boolean varED80EC8254639872427A6B5CD05CC588_779124226 = (value != null && value.getClass() == Float.class);
                {
                    mValue = ((Float)value).floatValue();
                    mHasValue = true;
                } 
            } 
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.966 -0400", hash_original_method = "5FDA2B31FC1B703F745BE5BB0395A79D", hash_generated_method = "4841396A0BA98651288E880020B0A5FF")
        @Override
        public FloatKeyframe clone() {
            FloatKeyframe varB4EAC82CA7396A68D541C85D26508E83_274389739 = null; 
            FloatKeyframe kfClone = new FloatKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
            varB4EAC82CA7396A68D541C85D26508E83_274389739 = kfClone;
            varB4EAC82CA7396A68D541C85D26508E83_274389739.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_274389739;
            
            
            
            
        }

        
    }


    
}

