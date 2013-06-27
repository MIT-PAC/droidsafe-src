package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Keyframe implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.436 -0400", hash_original_field = "8F2259335A204727B633197C1255E450", hash_generated_field = "F9B3CD45EBBDFA29E8A724A34A590B87")

    float mFraction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.441 -0400", hash_original_field = "98DE3BF49406C5ACB6938D9BD7C43E69", hash_generated_field = "28819529602B8605503B4054C761CC6C")

    Class mValueType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.442 -0400", hash_original_field = "155E7AEE84F40EF345E533B402141672", hash_generated_field = "D386D0EA78AAE2D770304D273EDA0A38")

    private TimeInterpolator mInterpolator = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.443 -0400", hash_original_field = "9582B1A85C4A02CE687C1D3131009947", hash_generated_field = "9025E6183B41BD7E7E45DA7F2620D0DA")

    boolean mHasValue = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.458 -0400", hash_original_method = "59B475F2675EC1DB9A85E43A7051AABA", hash_generated_method = "59B475F2675EC1DB9A85E43A7051AABA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.497 -0400", hash_original_method = "6BBC2B3892833CAF7F05465AB80866BD", hash_generated_method = "A68C77479339AB83FDBCDBE66CBD64B1")
    public boolean hasValue() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_932888050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_932888050;
        // ---------- Original Method ----------
        //return mHasValue;
    }

    
    public abstract Object getValue();

    
    public abstract void setValue(Object value);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.525 -0400", hash_original_method = "35C097CFF55F90D1886F0C54195244F1", hash_generated_method = "C5107217576980475BF3C808869794DA")
    public float getFraction() {
        float var546ADE640B6EDFBC8A086EF31347E768_1267839876 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1267839876;
        // ---------- Original Method ----------
        //return mFraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.536 -0400", hash_original_method = "D865B000D8DE764D2EF6EBC1ED2A153F", hash_generated_method = "B828439CB960C667E31928238589D41F")
    public void setFraction(float fraction) {
        mFraction = fraction;
        // ---------- Original Method ----------
        //mFraction = fraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.558 -0400", hash_original_method = "69CBD09EBE4A4B5ECD6AD8540DB7CFD0", hash_generated_method = "E5C5E39FB2F6C4A67253428B122328D4")
    public TimeInterpolator getInterpolator() {
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_1685122248 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1685122248 = mInterpolator;
        varB4EAC82CA7396A68D541C85D26508E83_1685122248.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1685122248;
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.572 -0400", hash_original_method = "DFEEC0662B39CED0069D1B2AE05648AB", hash_generated_method = "47F1226E1202976956E07A77F6CEA7FC")
    public void setInterpolator(TimeInterpolator interpolator) {
        mInterpolator = interpolator;
        // ---------- Original Method ----------
        //mInterpolator = interpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.590 -0400", hash_original_method = "464D9B25E7EBB7EEA5039E323C745893", hash_generated_method = "137C80AFA4706CF724C375A15C5D4F1B")
    public Class getType() {
        Class varB4EAC82CA7396A68D541C85D26508E83_1908655627 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1908655627 = mValueType;
        varB4EAC82CA7396A68D541C85D26508E83_1908655627.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1908655627;
        // ---------- Original Method ----------
        //return mValueType;
    }

    
        @Override
public abstract Keyframe clone();

    
    static class ObjectKeyframe extends Keyframe {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.606 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "10C88B3F201F56410DE7B0BF9A3CF880")

        Object mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.623 -0400", hash_original_method = "203797AF2B16BA31CF618ABFC3881151", hash_generated_method = "1A7212EFE4A133122180BCC5B36CC552")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.640 -0400", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "1ECD8934E02C951FEF07519A8BD801C9")
        public Object getValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_452375333 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_452375333 = mValue;
            varB4EAC82CA7396A68D541C85D26508E83_452375333.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_452375333;
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.659 -0400", hash_original_method = "A57ED313A37784FB1DA17FC9F39344A7", hash_generated_method = "BCD44A16AB81E639720244E80BED9701")
        public void setValue(Object value) {
            mValue = value;
            mHasValue = (value != null);
            // ---------- Original Method ----------
            //mValue = value;
            //mHasValue = (value != null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.676 -0400", hash_original_method = "D24C77D2B6663612F515281C3853AB21", hash_generated_method = "27C6F45A42BE2B67E80F64F151A359F4")
        @Override
        public ObjectKeyframe clone() {
            ObjectKeyframe varB4EAC82CA7396A68D541C85D26508E83_1953330167 = null; //Variable for return #1
            ObjectKeyframe kfClone;
            kfClone = new ObjectKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
            varB4EAC82CA7396A68D541C85D26508E83_1953330167 = kfClone;
            varB4EAC82CA7396A68D541C85D26508E83_1953330167.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1953330167;
            // ---------- Original Method ----------
            //ObjectKeyframe kfClone = new ObjectKeyframe(getFraction(), mValue);
            //kfClone.setInterpolator(getInterpolator());
            //return kfClone;
        }

        
    }


    
    static class IntKeyframe extends Keyframe {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.683 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC")

        int mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.717 -0400", hash_original_method = "EEAB8C81F88FA2F655356211D4887153", hash_generated_method = "8EF59FFEB5E748453F05BE3DC3C902BA")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.734 -0400", hash_original_method = "361D7315F9884E2CC45B77F9DFFA5D0B", hash_generated_method = "714DFBCA3BACC090C4420C562B319F6D")
          IntKeyframe(float fraction) {
            mFraction = fraction;
            mValueType = int.class;
            addTaint(fraction);
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValueType = int.class;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.737 -0400", hash_original_method = "7D27B9B7622273E5F87FD5AC6ACFC5AE", hash_generated_method = "A451437523E973D8F3C86EE4B3467B86")
        public int getIntValue() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745758408 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745758408;
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.759 -0400", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "FC8C49E24EDCC4D7E1488A1BE451A360")
        public Object getValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_2114931505 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2114931505 = mValue;
            varB4EAC82CA7396A68D541C85D26508E83_2114931505.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2114931505;
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.808 -0400", hash_original_method = "C5497A399E3F74A58085B920F39E31DE", hash_generated_method = "D527060A1DD2CE34025EE744814F5B60")
        public void setValue(Object value) {
            {
                boolean varDB7BF07CE0FD24C6422AFCD4E275ADB3_533370319 = (value != null && value.getClass() == Integer.class);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.823 -0400", hash_original_method = "25DF873BDC1EC275AA64D474732FCE13", hash_generated_method = "84CED197825E8A4E2EE900F002C82FCE")
        @Override
        public IntKeyframe clone() {
            IntKeyframe varB4EAC82CA7396A68D541C85D26508E83_1377925801 = null; //Variable for return #1
            IntKeyframe kfClone;
            kfClone = new IntKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
            varB4EAC82CA7396A68D541C85D26508E83_1377925801 = kfClone;
            varB4EAC82CA7396A68D541C85D26508E83_1377925801.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1377925801;
            // ---------- Original Method ----------
            //IntKeyframe kfClone = new IntKeyframe(getFraction(), mValue);
            //kfClone.setInterpolator(getInterpolator());
            //return kfClone;
        }

        
    }


    
    static class FloatKeyframe extends Keyframe {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.825 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "61B2557CF01F8FBFCA3655F32AFF6E67")

        float mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.847 -0400", hash_original_method = "12EFD0F6FC013537F5F7DD4B7E13C7C3", hash_generated_method = "941002996CE15D60B928D84A76BD1A2D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.860 -0400", hash_original_method = "68E29C538F7AE79A8714A7F41CC12063", hash_generated_method = "81E8FA33679F5D31CEC5F3A76615D1FE")
          FloatKeyframe(float fraction) {
            mFraction = fraction;
            mValueType = float.class;
            addTaint(fraction);
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValueType = float.class;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.878 -0400", hash_original_method = "4878123D1CBF5008E7E0955AB5FB61F2", hash_generated_method = "AA7E2181CFED661015A0D3D02C1624EF")
        public float getFloatValue() {
            float var546ADE640B6EDFBC8A086EF31347E768_436873934 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_436873934;
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.897 -0400", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "7BAEC2AF2E251EBC5878AFADAAF410EC")
        public Object getValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_305783914 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_305783914 = mValue;
            varB4EAC82CA7396A68D541C85D26508E83_305783914.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_305783914;
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.910 -0400", hash_original_method = "7C5BB3EB4CAFBCF934453BA7EC3D20EB", hash_generated_method = "A00E817DFB53D13CCC7D3582996FB0FB")
        public void setValue(Object value) {
            {
                boolean varED80EC8254639872427A6B5CD05CC588_22355918 = (value != null && value.getClass() == Float.class);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.931 -0400", hash_original_method = "5FDA2B31FC1B703F745BE5BB0395A79D", hash_generated_method = "A4857EB0D956CD98522A8792E69D7D22")
        @Override
        public FloatKeyframe clone() {
            FloatKeyframe varB4EAC82CA7396A68D541C85D26508E83_1063741089 = null; //Variable for return #1
            FloatKeyframe kfClone;
            kfClone = new FloatKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
            varB4EAC82CA7396A68D541C85D26508E83_1063741089 = kfClone;
            varB4EAC82CA7396A68D541C85D26508E83_1063741089.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1063741089;
            // ---------- Original Method ----------
            //FloatKeyframe kfClone = new FloatKeyframe(getFraction(), mValue);
            //kfClone.setInterpolator(getInterpolator());
            //return kfClone;
        }

        
    }


    
}

