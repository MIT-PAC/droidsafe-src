package android.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public abstract class Keyframe implements Cloneable {

    /**
     * Constructs a Keyframe object with the given time and value. The time defines the
     * time, as a proportion of an overall animation's duration, at which the value will hold true
     * for the animation. The value for the animation between keyframes will be calculated as
     * an interpolation between the values at those keyframes.
     *
     * @param fraction The time, expressed as a value between 0 and 1, representing the fraction
     * of time elapsed of the overall animation duration.
     * @param value The value that the object will animate to as the animation time approaches
     * the time in this keyframe, and the the value animated from as the time passes the time in
     * this keyframe.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.980 -0500", hash_original_method = "84D5DEA8FB185DFF017D7EA9B9159938", hash_generated_method = "D35378904CC6AD422C27A00EB6868E80")
    
public static Keyframe ofInt(float fraction, int value) {
        return new IntKeyframe(fraction, value);
    }

    /**
     * Constructs a Keyframe object with the given time. The value at this time will be derived
     * from the target object when the animation first starts (note that this implies that keyframes
     * with no initial value must be used as part of an {@link ObjectAnimator}).
     * The time defines the
     * time, as a proportion of an overall animation's duration, at which the value will hold true
     * for the animation. The value for the animation between keyframes will be calculated as
     * an interpolation between the values at those keyframes.
     *
     * @param fraction The time, expressed as a value between 0 and 1, representing the fraction
     * of time elapsed of the overall animation duration.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.983 -0500", hash_original_method = "61707A62E34CB44E1A0B394219C39C2A", hash_generated_method = "8670BE3EA82AFC4547EACDD02556E194")
    
public static Keyframe ofInt(float fraction) {
        return new IntKeyframe(fraction);
    }

    /**
     * Constructs a Keyframe object with the given time and value. The time defines the
     * time, as a proportion of an overall animation's duration, at which the value will hold true
     * for the animation. The value for the animation between keyframes will be calculated as
     * an interpolation between the values at those keyframes.
     *
     * @param fraction The time, expressed as a value between 0 and 1, representing the fraction
     * of time elapsed of the overall animation duration.
     * @param value The value that the object will animate to as the animation time approaches
     * the time in this keyframe, and the the value animated from as the time passes the time in
     * this keyframe.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.985 -0500", hash_original_method = "058E9168611C529131E49EDF0FE1203B", hash_generated_method = "2D587086D1376F3EC9B2D890E77FEE14")
    
public static Keyframe ofFloat(float fraction, float value) {
        return new FloatKeyframe(fraction, value);
    }

    /**
     * Constructs a Keyframe object with the given time. The value at this time will be derived
     * from the target object when the animation first starts (note that this implies that keyframes
     * with no initial value must be used as part of an {@link ObjectAnimator}).
     * The time defines the
     * time, as a proportion of an overall animation's duration, at which the value will hold true
     * for the animation. The value for the animation between keyframes will be calculated as
     * an interpolation between the values at those keyframes.
     *
     * @param fraction The time, expressed as a value between 0 and 1, representing the fraction
     * of time elapsed of the overall animation duration.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.987 -0500", hash_original_method = "4433897A1157942B92CBF16B43C059FC", hash_generated_method = "6FAB493FD4694CDF44DF043BB338A4E9")
    
public static Keyframe ofFloat(float fraction) {
        return new FloatKeyframe(fraction);
    }

    /**
     * Constructs a Keyframe object with the given time and value. The time defines the
     * time, as a proportion of an overall animation's duration, at which the value will hold true
     * for the animation. The value for the animation between keyframes will be calculated as
     * an interpolation between the values at those keyframes.
     *
     * @param fraction The time, expressed as a value between 0 and 1, representing the fraction
     * of time elapsed of the overall animation duration.
     * @param value The value that the object will animate to as the animation time approaches
     * the time in this keyframe, and the the value animated from as the time passes the time in
     * this keyframe.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.989 -0500", hash_original_method = "9D932806C99A7FAC12536ABC4A06EEEF", hash_generated_method = "A40BC04F07586763B95E87E319D81B3A")
    
public static Keyframe ofObject(float fraction, Object value) {
        return new ObjectKeyframe(fraction, value);
    }

    /**
     * Constructs a Keyframe object with the given time. The value at this time will be derived
     * from the target object when the animation first starts (note that this implies that keyframes
     * with no initial value must be used as part of an {@link ObjectAnimator}).
     * The time defines the
     * time, as a proportion of an overall animation's duration, at which the value will hold true
     * for the animation. The value for the animation between keyframes will be calculated as
     * an interpolation between the values at those keyframes.
     *
     * @param fraction The time, expressed as a value between 0 and 1, representing the fraction
     * of time elapsed of the overall animation duration.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.992 -0500", hash_original_method = "2EA7149C937F77B1CA3FA652EAC27470", hash_generated_method = "CA4E4F7ECFD9EDB04F222584AEA4194E")
    
public static Keyframe ofObject(float fraction) {
        return new ObjectKeyframe(fraction, null);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.972 -0500", hash_original_field = "F9B3CD45EBBDFA29E8A724A34A590B87", hash_generated_field = "F9B3CD45EBBDFA29E8A724A34A590B87")

    float mFraction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.974 -0500", hash_original_field = "28819529602B8605503B4054C761CC6C", hash_generated_field = "28819529602B8605503B4054C761CC6C")

    Class mValueType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.976 -0500", hash_original_field = "B6D84463A85A6E2662575158FDB86460", hash_generated_field = "D386D0EA78AAE2D770304D273EDA0A38")

    private TimeInterpolator mInterpolator = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.978 -0500", hash_original_field = "9025E6183B41BD7E7E45DA7F2620D0DA", hash_generated_field = "9025E6183B41BD7E7E45DA7F2620D0DA")

    boolean mHasValue = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.760 -0400", hash_original_method = "59B475F2675EC1DB9A85E43A7051AABA", hash_generated_method = "59B475F2675EC1DB9A85E43A7051AABA")
    @DSModeled(DSC.SAFE)
    public Keyframe ()
    {
        //Synthesized constructor
    }

    /**
     * Indicates whether this keyframe has a valid value. This method is called internally when
     * an {@link ObjectAnimator} first starts; keyframes without values are assigned values at
     * that time by deriving the value for the property from the target object.
     *
     * @return boolean Whether this object has a value assigned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.994 -0500", hash_original_method = "6BBC2B3892833CAF7F05465AB80866BD", hash_generated_method = "5D04B803BC66E9D8BE02824FFB2602E4")
    
public boolean hasValue() {
        return mHasValue;
    }

    /**
     * Gets the value for this Keyframe.
     *
     * @return The value for this Keyframe.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.996 -0500", hash_original_method = "2BAF52093DF90C012CD98E75F6017DB6", hash_generated_method = "0BBDF3917B1F70E411088037046C99F8")
    
public abstract Object getValue();

    /**
     * Sets the value for this Keyframe.
     *
     * @param value value for this Keyframe.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.998 -0500", hash_original_method = "0331A921E67C9DBFCFD1B97103D5AA96", hash_generated_method = "FD3EE2B12CCD0465A5CF86CA5F089295")
    
public abstract void setValue(Object value);

    /**
     * Gets the time for this keyframe, as a fraction of the overall animation duration.
     *
     * @return The time associated with this keyframe, as a fraction of the overall animation
     * duration. This should be a value between 0 and 1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.000 -0500", hash_original_method = "35C097CFF55F90D1886F0C54195244F1", hash_generated_method = "6C02CABAE06C246455B369035F54D142")
    
public float getFraction() {
        return mFraction;
    }

    /**
     * Sets the time for this keyframe, as a fraction of the overall animation duration.
     *
     * @param fraction time associated with this keyframe, as a fraction of the overall animation
     * duration. This should be a value between 0 and 1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.002 -0500", hash_original_method = "D865B000D8DE764D2EF6EBC1ED2A153F", hash_generated_method = "D2006EDBA807B27186ED793BDB862B2F")
    
public void setFraction(float fraction) {
        mFraction = fraction;
    }

    /**
     * Gets the optional interpolator for this Keyframe. A value of <code>null</code> indicates
     * that there is no interpolation, which is the same as linear interpolation.
     *
     * @return The optional interpolator for this Keyframe.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.004 -0500", hash_original_method = "69CBD09EBE4A4B5ECD6AD8540DB7CFD0", hash_generated_method = "3B07035547B797301E020DE6A117B867")
    
public TimeInterpolator getInterpolator() {
        return mInterpolator;
    }

    /**
     * Sets the optional interpolator for this Keyframe. A value of <code>null</code> indicates
     * that there is no interpolation, which is the same as linear interpolation.
     *
     * @return The optional interpolator for this Keyframe.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.006 -0500", hash_original_method = "DFEEC0662B39CED0069D1B2AE05648AB", hash_generated_method = "426C84FD7C8731373CAE4B41C945E81D")
    
public void setInterpolator(TimeInterpolator interpolator) {
        mInterpolator = interpolator;
    }

    /**
     * Gets the type of keyframe. This information is used by ValueAnimator to determine the type of
     * {@link TypeEvaluator} to use when calculating values between keyframes. The type is based
     * on the type of Keyframe created.
     *
     * @return The type of the value stored in the Keyframe.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.008 -0500", hash_original_method = "464D9B25E7EBB7EEA5039E323C745893", hash_generated_method = "373EA3C72E808356806B34A002DB0968")
    
public Class getType() {
        return mValueType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.012 -0500", hash_original_method = "195CDEEBE964F431C4EC3BA6D3E40199", hash_generated_method = "2E6D16650854665C10782A699DC48FF5")
    
@Override
    public abstract Keyframe clone();

    
    static class ObjectKeyframe extends Keyframe {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.014 -0500", hash_original_field = "10C88B3F201F56410DE7B0BF9A3CF880", hash_generated_field = "10C88B3F201F56410DE7B0BF9A3CF880")

        Object mValue;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.016 -0500", hash_original_method = "203797AF2B16BA31CF618ABFC3881151", hash_generated_method = "203797AF2B16BA31CF618ABFC3881151")
        
ObjectKeyframe(float fraction, Object value) {
            mFraction = fraction;
            mValue = value;
            mHasValue = (value != null);
            mValueType = mHasValue ? value.getClass() : Object.class;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.018 -0500", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "53C1D4B1B03560E5A7007A4513F340A4")
        
public Object getValue() {
            return mValue;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.020 -0500", hash_original_method = "A57ED313A37784FB1DA17FC9F39344A7", hash_generated_method = "4804638E8130EAA067BB5C83062DE91A")
        
public void setValue(Object value) {
            mValue = value;
            mHasValue = (value != null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.023 -0500", hash_original_method = "D24C77D2B6663612F515281C3853AB21", hash_generated_method = "CA5A13BF158BB63C489C8D1F8BC75A27")
        
@Override
        public ObjectKeyframe clone() {
            ObjectKeyframe kfClone = new ObjectKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
            return kfClone;
        }

        
    }


    
    static class IntKeyframe extends Keyframe {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.028 -0500", hash_original_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC", hash_generated_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC")

        int mValue;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.030 -0500", hash_original_method = "EEAB8C81F88FA2F655356211D4887153", hash_generated_method = "EEAB8C81F88FA2F655356211D4887153")
        
IntKeyframe(float fraction, int value) {
            mFraction = fraction;
            mValue = value;
            mValueType = int.class;
            mHasValue = true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.032 -0500", hash_original_method = "361D7315F9884E2CC45B77F9DFFA5D0B", hash_generated_method = "361D7315F9884E2CC45B77F9DFFA5D0B")
        
IntKeyframe(float fraction) {
            mFraction = fraction;
            mValueType = int.class;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.035 -0500", hash_original_method = "7D27B9B7622273E5F87FD5AC6ACFC5AE", hash_generated_method = "F99D4F40655E264044BA01C8E4BDD2A0")
        
public int getIntValue() {
            return mValue;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.037 -0500", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "53C1D4B1B03560E5A7007A4513F340A4")
        
public Object getValue() {
            return mValue;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.039 -0500", hash_original_method = "C5497A399E3F74A58085B920F39E31DE", hash_generated_method = "7D6918691B5CEA30D90D66FE632B55E6")
        
public void setValue(Object value) {
            if (value != null && value.getClass() == Integer.class) {
                mValue = ((Integer)value).intValue();
                mHasValue = true;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.042 -0500", hash_original_method = "25DF873BDC1EC275AA64D474732FCE13", hash_generated_method = "A703EFF1C1B6D7F9BFB3B4DE8884D8E5")
        
@Override
        public IntKeyframe clone() {
            IntKeyframe kfClone = new IntKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
            return kfClone;
        }

        
    }


    
    static class FloatKeyframe extends Keyframe {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.046 -0500", hash_original_field = "61B2557CF01F8FBFCA3655F32AFF6E67", hash_generated_field = "61B2557CF01F8FBFCA3655F32AFF6E67")

        float mValue;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.048 -0500", hash_original_method = "12EFD0F6FC013537F5F7DD4B7E13C7C3", hash_generated_method = "12EFD0F6FC013537F5F7DD4B7E13C7C3")
        
FloatKeyframe(float fraction, float value) {
            mFraction = fraction;
            mValue = value;
            mValueType = float.class;
            mHasValue = true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.050 -0500", hash_original_method = "68E29C538F7AE79A8714A7F41CC12063", hash_generated_method = "68E29C538F7AE79A8714A7F41CC12063")
        
FloatKeyframe(float fraction) {
            mFraction = fraction;
            mValueType = float.class;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.053 -0500", hash_original_method = "4878123D1CBF5008E7E0955AB5FB61F2", hash_generated_method = "4BFAE8FB3F325F4DCE35DCA9CEF1E776")
        
public float getFloatValue() {
            return mValue;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.056 -0500", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "53C1D4B1B03560E5A7007A4513F340A4")
        
public Object getValue() {
            return mValue;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.058 -0500", hash_original_method = "7C5BB3EB4CAFBCF934453BA7EC3D20EB", hash_generated_method = "CC841C193FE3627422758784B6643796")
        
public void setValue(Object value) {
            if (value != null && value.getClass() == Float.class) {
                mValue = ((Float)value).floatValue();
                mHasValue = true;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:34.060 -0500", hash_original_method = "5FDA2B31FC1B703F745BE5BB0395A79D", hash_generated_method = "0027F4FD0C2ACEC3A7A2EE154479D45F")
        
@Override
        public FloatKeyframe clone() {
            FloatKeyframe kfClone = new FloatKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
            return kfClone;
        }

        
    }


    
}

