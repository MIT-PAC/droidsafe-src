package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Keyframe implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.514 -0400", hash_original_field = "8F2259335A204727B633197C1255E450", hash_generated_field = "F9B3CD45EBBDFA29E8A724A34A590B87")

    float mFraction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.517 -0400", hash_original_field = "98DE3BF49406C5ACB6938D9BD7C43E69", hash_generated_field = "28819529602B8605503B4054C761CC6C")

    Class mValueType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.521 -0400", hash_original_field = "155E7AEE84F40EF345E533B402141672", hash_generated_field = "D386D0EA78AAE2D770304D273EDA0A38")

    private TimeInterpolator mInterpolator = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.524 -0400", hash_original_field = "9582B1A85C4A02CE687C1D3131009947", hash_generated_field = "9025E6183B41BD7E7E45DA7F2620D0DA")

    boolean mHasValue = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.526 -0400", hash_original_method = "59B475F2675EC1DB9A85E43A7051AABA", hash_generated_method = "59B475F2675EC1DB9A85E43A7051AABA")
    public Keyframe ()
    {
        //Synthesized constructor
    }


        public static Keyframe ofInt(float fraction, int value) {
        return new IntKeyframe(fraction, value);
    }

    
        public static Keyframe ofInt(float fraction) {
        return new IntKeyframe(fraction);
    }

    
        public static Keyframe ofFloat(float fraction, float value) {
        return new FloatKeyframe(fraction, value);
    }

    
        public static Keyframe ofFloat(float fraction) {
        return new FloatKeyframe(fraction);
    }

    
        public static Keyframe ofObject(float fraction, Object value) {
        return new ObjectKeyframe(fraction, value);
    }

    
        public static Keyframe ofObject(float fraction) {
        return new ObjectKeyframe(fraction, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.608 -0400", hash_original_method = "6BBC2B3892833CAF7F05465AB80866BD", hash_generated_method = "8D1F184E2C4C75E2A1617A880563F0A6")
    public boolean hasValue() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2103370935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2103370935;
        // ---------- Original Method ----------
        //return mHasValue;
    }

    
    public abstract Object getValue();

    
    public abstract void setValue(Object value);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.641 -0400", hash_original_method = "35C097CFF55F90D1886F0C54195244F1", hash_generated_method = "08C581ED5088C6864DB9DA460AE55982")
    public float getFraction() {
        float var546ADE640B6EDFBC8A086EF31347E768_588330968 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_588330968;
        // ---------- Original Method ----------
        //return mFraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.663 -0400", hash_original_method = "D865B000D8DE764D2EF6EBC1ED2A153F", hash_generated_method = "B828439CB960C667E31928238589D41F")
    public void setFraction(float fraction) {
        mFraction = fraction;
        // ---------- Original Method ----------
        //mFraction = fraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.691 -0400", hash_original_method = "69CBD09EBE4A4B5ECD6AD8540DB7CFD0", hash_generated_method = "1ABD2AD16E6BF2ECAA5A6B22715948A4")
    public TimeInterpolator getInterpolator() {
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_2080010959 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2080010959 = mInterpolator;
        varB4EAC82CA7396A68D541C85D26508E83_2080010959.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2080010959;
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.711 -0400", hash_original_method = "DFEEC0662B39CED0069D1B2AE05648AB", hash_generated_method = "47F1226E1202976956E07A77F6CEA7FC")
    public void setInterpolator(TimeInterpolator interpolator) {
        mInterpolator = interpolator;
        // ---------- Original Method ----------
        //mInterpolator = interpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.725 -0400", hash_original_method = "464D9B25E7EBB7EEA5039E323C745893", hash_generated_method = "F5FD9020E0CF2198C9034EFE25BC724E")
    public Class getType() {
        Class varB4EAC82CA7396A68D541C85D26508E83_351755235 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_351755235 = mValueType;
        varB4EAC82CA7396A68D541C85D26508E83_351755235.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_351755235;
        // ---------- Original Method ----------
        //return mValueType;
    }

    
        @Override
public abstract Keyframe clone();

    
    static class ObjectKeyframe extends Keyframe {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.744 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "10C88B3F201F56410DE7B0BF9A3CF880")

        Object mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.785 -0400", hash_original_method = "203797AF2B16BA31CF618ABFC3881151", hash_generated_method = "1A7212EFE4A133122180BCC5B36CC552")
          ObjectKeyframe(float fraction, Object value) {
            mFraction = fraction;
            mValue = value;
            mHasValue = (value != null);
            mValueType = mHasValue ? value.getClass() : Object.class;
            addTaint(fraction);
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValue = value;
            //mHasValue = (value != null);
            //mValueType = mHasValue ? value.getClass() : Object.class;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.816 -0400", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "A2EAB49ABB3103420A1D1979AD653C05")
        public Object getValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_730400938 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_730400938 = mValue;
            varB4EAC82CA7396A68D541C85D26508E83_730400938.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_730400938;
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.835 -0400", hash_original_method = "A57ED313A37784FB1DA17FC9F39344A7", hash_generated_method = "BCD44A16AB81E639720244E80BED9701")
        public void setValue(Object value) {
            mValue = value;
            mHasValue = (value != null);
            // ---------- Original Method ----------
            //mValue = value;
            //mHasValue = (value != null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.877 -0400", hash_original_method = "D24C77D2B6663612F515281C3853AB21", hash_generated_method = "F6170E9CB3F85B89CC59491BD4C21AFE")
        @Override
        public ObjectKeyframe clone() {
            ObjectKeyframe varB4EAC82CA7396A68D541C85D26508E83_1567790635 = null; //Variable for return #1
            ObjectKeyframe kfClone;
            kfClone = new ObjectKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
            varB4EAC82CA7396A68D541C85D26508E83_1567790635 = kfClone;
            varB4EAC82CA7396A68D541C85D26508E83_1567790635.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1567790635;
            // ---------- Original Method ----------
            //ObjectKeyframe kfClone = new ObjectKeyframe(getFraction(), mValue);
            //kfClone.setInterpolator(getInterpolator());
            //return kfClone;
        }

        
    }


    
    static class IntKeyframe extends Keyframe {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.878 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC")

        int mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.902 -0400", hash_original_method = "EEAB8C81F88FA2F655356211D4887153", hash_generated_method = "8EF59FFEB5E748453F05BE3DC3C902BA")
          IntKeyframe(float fraction, int value) {
            mFraction = fraction;
            mValue = value;
            mValueType = int.class;
            mHasValue = true;
            addTaint(fraction);
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValue = value;
            //mValueType = int.class;
            //mHasValue = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.933 -0400", hash_original_method = "361D7315F9884E2CC45B77F9DFFA5D0B", hash_generated_method = "714DFBCA3BACC090C4420C562B319F6D")
          IntKeyframe(float fraction) {
            mFraction = fraction;
            mValueType = int.class;
            addTaint(fraction);
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValueType = int.class;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.953 -0400", hash_original_method = "7D27B9B7622273E5F87FD5AC6ACFC5AE", hash_generated_method = "A987B41A60125100555DB1555A91C560")
        public int getIntValue() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729311141 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729311141;
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.966 -0400", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "E1C9DF97E24A2CBAEDD5853DB8846DBF")
        public Object getValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_750141659 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_750141659 = mValue;
            varB4EAC82CA7396A68D541C85D26508E83_750141659.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_750141659;
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:48.995 -0400", hash_original_method = "C5497A399E3F74A58085B920F39E31DE", hash_generated_method = "58CEE51D7FFA72320015EBB651EFD4F9")
        public void setValue(Object value) {
            {
                boolean varDB7BF07CE0FD24C6422AFCD4E275ADB3_1224348258 = (value != null && value.getClass() == Integer.class);
                {
                    mValue = ((Integer)value).intValue();
                    mHasValue = true;
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (value != null && value.getClass() == Integer.class) {
                //mValue = ((Integer)value).intValue();
                //mHasValue = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:49.013 -0400", hash_original_method = "25DF873BDC1EC275AA64D474732FCE13", hash_generated_method = "D5ACB8A80F5CEEDAEF15A1C47EA92E71")
        @Override
        public IntKeyframe clone() {
            IntKeyframe varB4EAC82CA7396A68D541C85D26508E83_760402517 = null; //Variable for return #1
            IntKeyframe kfClone;
            kfClone = new IntKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
            varB4EAC82CA7396A68D541C85D26508E83_760402517 = kfClone;
            varB4EAC82CA7396A68D541C85D26508E83_760402517.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_760402517;
            // ---------- Original Method ----------
            //IntKeyframe kfClone = new IntKeyframe(getFraction(), mValue);
            //kfClone.setInterpolator(getInterpolator());
            //return kfClone;
        }

        
    }


    
    static class FloatKeyframe extends Keyframe {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:49.031 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "61B2557CF01F8FBFCA3655F32AFF6E67")

        float mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:49.057 -0400", hash_original_method = "12EFD0F6FC013537F5F7DD4B7E13C7C3", hash_generated_method = "941002996CE15D60B928D84A76BD1A2D")
          FloatKeyframe(float fraction, float value) {
            mFraction = fraction;
            mValue = value;
            mValueType = float.class;
            mHasValue = true;
            addTaint(fraction);
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValue = value;
            //mValueType = float.class;
            //mHasValue = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:49.076 -0400", hash_original_method = "68E29C538F7AE79A8714A7F41CC12063", hash_generated_method = "81E8FA33679F5D31CEC5F3A76615D1FE")
          FloatKeyframe(float fraction) {
            mFraction = fraction;
            mValueType = float.class;
            addTaint(fraction);
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValueType = float.class;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:49.088 -0400", hash_original_method = "4878123D1CBF5008E7E0955AB5FB61F2", hash_generated_method = "DD29AFB347617C52E104E37A12788D5C")
        public float getFloatValue() {
            float var546ADE640B6EDFBC8A086EF31347E768_138822690 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_138822690;
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:49.110 -0400", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "95A8507A1327B1A9534B69FAE1ECB488")
        public Object getValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_248537254 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_248537254 = mValue;
            varB4EAC82CA7396A68D541C85D26508E83_248537254.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_248537254;
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:49.141 -0400", hash_original_method = "7C5BB3EB4CAFBCF934453BA7EC3D20EB", hash_generated_method = "D09E4E0A8B1FCB7B62B72CB04BD39722")
        public void setValue(Object value) {
            {
                boolean varED80EC8254639872427A6B5CD05CC588_1596777317 = (value != null && value.getClass() == Float.class);
                {
                    mValue = ((Float)value).floatValue();
                    mHasValue = true;
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (value != null && value.getClass() == Float.class) {
                //mValue = ((Float)value).floatValue();
                //mHasValue = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:49.162 -0400", hash_original_method = "5FDA2B31FC1B703F745BE5BB0395A79D", hash_generated_method = "B626635B5CC30B3855F430D713ED0B35")
        @Override
        public FloatKeyframe clone() {
            FloatKeyframe varB4EAC82CA7396A68D541C85D26508E83_745306934 = null; //Variable for return #1
            FloatKeyframe kfClone;
            kfClone = new FloatKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
            varB4EAC82CA7396A68D541C85D26508E83_745306934 = kfClone;
            varB4EAC82CA7396A68D541C85D26508E83_745306934.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_745306934;
            // ---------- Original Method ----------
            //FloatKeyframe kfClone = new FloatKeyframe(getFraction(), mValue);
            //kfClone.setInterpolator(getInterpolator());
            //return kfClone;
        }

        
    }


    
}

