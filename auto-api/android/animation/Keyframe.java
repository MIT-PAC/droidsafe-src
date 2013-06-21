package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Keyframe implements Cloneable {
    float mFraction;
    Class mValueType;
    private TimeInterpolator mInterpolator = null;
    boolean mHasValue = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.943 -0400", hash_original_method = "844C5698179A876829148D881FDEA44E", hash_generated_method = "844C5698179A876829148D881FDEA44E")
        public Keyframe ()
    {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.956 -0400", hash_original_method = "6BBC2B3892833CAF7F05465AB80866BD", hash_generated_method = "0D7259E2A0A8A28E67F24EF54F90F38A")
    @DSModeled(DSC.SAFE)
    public boolean hasValue() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHasValue;
    }

    
    public abstract Object getValue();

    
    public abstract void setValue(Object value);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.966 -0400", hash_original_method = "35C097CFF55F90D1886F0C54195244F1", hash_generated_method = "84119A4078977B661E309A4F4BC3E412")
    @DSModeled(DSC.SAFE)
    public float getFraction() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mFraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.967 -0400", hash_original_method = "D865B000D8DE764D2EF6EBC1ED2A153F", hash_generated_method = "C316354690EF57A6B299DEDD67BF41D1")
    @DSModeled(DSC.SAFE)
    public void setFraction(float fraction) {
        dsTaint.addTaint(fraction);
        // ---------- Original Method ----------
        //mFraction = fraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.968 -0400", hash_original_method = "69CBD09EBE4A4B5ECD6AD8540DB7CFD0", hash_generated_method = "3D7C5E61728E00CFB484A2D5B90535DE")
    @DSModeled(DSC.SAFE)
    public TimeInterpolator getInterpolator() {
        return (TimeInterpolator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.968 -0400", hash_original_method = "DFEEC0662B39CED0069D1B2AE05648AB", hash_generated_method = "331EE81354461BDDF7FB411C3E93DB0E")
    @DSModeled(DSC.SAFE)
    public void setInterpolator(TimeInterpolator interpolator) {
        dsTaint.addTaint(interpolator.dsTaint);
        // ---------- Original Method ----------
        //mInterpolator = interpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.969 -0400", hash_original_method = "464D9B25E7EBB7EEA5039E323C745893", hash_generated_method = "D1044A127F6D946DB29C06690CFC176F")
    @DSModeled(DSC.SAFE)
    public Class getType() {
        return (Class)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mValueType;
    }

    
        @Override
public abstract Keyframe clone();

    
    static class ObjectKeyframe extends Keyframe {
        Object mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.970 -0400", hash_original_method = "203797AF2B16BA31CF618ABFC3881151", hash_generated_method = "2B7299F5D8D946D4D51912508F3BD8CA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ObjectKeyframe(float fraction, Object value) {
            dsTaint.addTaint(fraction);
            dsTaint.addTaint(value.dsTaint);
            mFraction = fraction;
            mHasValue = (value != null);
            mValueType = mHasValue ? value.getClass() : Object.class;
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValue = value;
            //mHasValue = (value != null);
            //mValueType = mHasValue ? value.getClass() : Object.class;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.971 -0400", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "A056596DD2311F67980ED6F9229A1651")
        @DSModeled(DSC.SAFE)
        public Object getValue() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.972 -0400", hash_original_method = "A57ED313A37784FB1DA17FC9F39344A7", hash_generated_method = "F57D720774CEA906ACF9B594EB867405")
        @DSModeled(DSC.SAFE)
        public void setValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            mHasValue = (value != null);
            // ---------- Original Method ----------
            //mValue = value;
            //mHasValue = (value != null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.973 -0400", hash_original_method = "D24C77D2B6663612F515281C3853AB21", hash_generated_method = "123F0A7159F1CBD679D2268EE5258F1F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ObjectKeyframe clone() {
            ObjectKeyframe kfClone;
            kfClone = new ObjectKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
            return (ObjectKeyframe)dsTaint.getTaint();
            // ---------- Original Method ----------
            //ObjectKeyframe kfClone = new ObjectKeyframe(getFraction(), mValue);
            //kfClone.setInterpolator(getInterpolator());
            //return kfClone;
        }

        
    }


    
    static class IntKeyframe extends Keyframe {
        int mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.976 -0400", hash_original_method = "EEAB8C81F88FA2F655356211D4887153", hash_generated_method = "30B029EFFB20564BF602BAEEB25E3D33")
        @DSModeled(DSC.SAFE)
         IntKeyframe(float fraction, int value) {
            dsTaint.addTaint(fraction);
            dsTaint.addTaint(value);
            mFraction = fraction;
            mValueType = int.class;
            mHasValue = true;
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValue = value;
            //mValueType = int.class;
            //mHasValue = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.977 -0400", hash_original_method = "361D7315F9884E2CC45B77F9DFFA5D0B", hash_generated_method = "BFC48A7E5114B9EFA2C2A8610FDC983A")
        @DSModeled(DSC.SAFE)
         IntKeyframe(float fraction) {
            dsTaint.addTaint(fraction);
            mFraction = fraction;
            mValueType = int.class;
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValueType = int.class;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.978 -0400", hash_original_method = "7D27B9B7622273E5F87FD5AC6ACFC5AE", hash_generated_method = "4AF15B2D7E663047762C9233788B3EA5")
        @DSModeled(DSC.SAFE)
        public int getIntValue() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.986 -0400", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "A056596DD2311F67980ED6F9229A1651")
        @DSModeled(DSC.SAFE)
        public Object getValue() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.988 -0400", hash_original_method = "C5497A399E3F74A58085B920F39E31DE", hash_generated_method = "381127285EB31756E6334702841196B8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            {
                boolean varDB7BF07CE0FD24C6422AFCD4E275ADB3_188194336 = (value != null && value.getClass() == Integer.class);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.990 -0400", hash_original_method = "25DF873BDC1EC275AA64D474732FCE13", hash_generated_method = "9ECB1D06FA7B1BAA2FBD42456C498AF4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public IntKeyframe clone() {
            IntKeyframe kfClone;
            kfClone = new IntKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
            return (IntKeyframe)dsTaint.getTaint();
            // ---------- Original Method ----------
            //IntKeyframe kfClone = new IntKeyframe(getFraction(), mValue);
            //kfClone.setInterpolator(getInterpolator());
            //return kfClone;
        }

        
    }


    
    static class FloatKeyframe extends Keyframe {
        float mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.991 -0400", hash_original_method = "12EFD0F6FC013537F5F7DD4B7E13C7C3", hash_generated_method = "1B5ACD83FF5DCFB12B7BBCD1F48487B2")
        @DSModeled(DSC.SAFE)
         FloatKeyframe(float fraction, float value) {
            dsTaint.addTaint(fraction);
            dsTaint.addTaint(value);
            mFraction = fraction;
            mValueType = float.class;
            mHasValue = true;
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValue = value;
            //mValueType = float.class;
            //mHasValue = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.001 -0400", hash_original_method = "68E29C538F7AE79A8714A7F41CC12063", hash_generated_method = "FD952633D478A41A382D7BEB6688CEC1")
        @DSModeled(DSC.SAFE)
         FloatKeyframe(float fraction) {
            dsTaint.addTaint(fraction);
            mFraction = fraction;
            mValueType = float.class;
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValueType = float.class;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.002 -0400", hash_original_method = "4878123D1CBF5008E7E0955AB5FB61F2", hash_generated_method = "2E6A5AA8E280B0677C2354C9BCE2F9F8")
        @DSModeled(DSC.SAFE)
        public float getFloatValue() {
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.002 -0400", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "A056596DD2311F67980ED6F9229A1651")
        @DSModeled(DSC.SAFE)
        public Object getValue() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.003 -0400", hash_original_method = "7C5BB3EB4CAFBCF934453BA7EC3D20EB", hash_generated_method = "7B0F1ACF3BB54B5871E1B9B8B43772BD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            {
                boolean varED80EC8254639872427A6B5CD05CC588_601688384 = (value != null && value.getClass() == Float.class);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.004 -0400", hash_original_method = "5FDA2B31FC1B703F745BE5BB0395A79D", hash_generated_method = "AD491994BD077ABC070C95E9B2A7A4DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public FloatKeyframe clone() {
            FloatKeyframe kfClone;
            kfClone = new FloatKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
            return (FloatKeyframe)dsTaint.getTaint();
            // ---------- Original Method ----------
            //FloatKeyframe kfClone = new FloatKeyframe(getFraction(), mValue);
            //kfClone.setInterpolator(getInterpolator());
            //return kfClone;
        }

        
    }


    
}

