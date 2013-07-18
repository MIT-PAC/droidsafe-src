package android.animation;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class Keyframe implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.757 -0400", hash_original_field = "8F2259335A204727B633197C1255E450", hash_generated_field = "F9B3CD45EBBDFA29E8A724A34A590B87")

    float mFraction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.758 -0400", hash_original_field = "98DE3BF49406C5ACB6938D9BD7C43E69", hash_generated_field = "28819529602B8605503B4054C761CC6C")

    Class mValueType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.759 -0400", hash_original_field = "155E7AEE84F40EF345E533B402141672", hash_generated_field = "D386D0EA78AAE2D770304D273EDA0A38")

    private TimeInterpolator mInterpolator = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.759 -0400", hash_original_field = "9582B1A85C4A02CE687C1D3131009947", hash_generated_field = "9025E6183B41BD7E7E45DA7F2620D0DA")

    boolean mHasValue = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.760 -0400", hash_original_method = "59B475F2675EC1DB9A85E43A7051AABA", hash_generated_method = "59B475F2675EC1DB9A85E43A7051AABA")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.768 -0400", hash_original_method = "6BBC2B3892833CAF7F05465AB80866BD", hash_generated_method = "DD197230C86C717856DE89B441168C89")
    public boolean hasValue() {
        boolean var976B418A652F6F5885E6187F73F4BE48_1825824534 = (mHasValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482254446 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482254446;
        // ---------- Original Method ----------
        //return mHasValue;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract Object getValue();

    
    @DSModeled(DSC.SAFE)
    public abstract void setValue(Object value);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.773 -0400", hash_original_method = "35C097CFF55F90D1886F0C54195244F1", hash_generated_method = "0F337A4D4AAA0B05799FC688749D67C0")
    public float getFraction() {
        float var8F2259335A204727B633197C1255E450_664748949 = (mFraction);
                float var546ADE640B6EDFBC8A086EF31347E768_1658140496 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1658140496;
        // ---------- Original Method ----------
        //return mFraction;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.775 -0400", hash_original_method = "D865B000D8DE764D2EF6EBC1ED2A153F", hash_generated_method = "B828439CB960C667E31928238589D41F")
    public void setFraction(float fraction) {
        mFraction = fraction;
        // ---------- Original Method ----------
        //mFraction = fraction;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.778 -0400", hash_original_method = "69CBD09EBE4A4B5ECD6AD8540DB7CFD0", hash_generated_method = "10BBD34F1247283D26FBC76AEB037D59")
    public TimeInterpolator getInterpolator() {
TimeInterpolator var9FA301F6AF154FEBBB2C7439D021F894_1889241193 =         mInterpolator;
        var9FA301F6AF154FEBBB2C7439D021F894_1889241193.addTaint(taint);
        return var9FA301F6AF154FEBBB2C7439D021F894_1889241193;
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.781 -0400", hash_original_method = "DFEEC0662B39CED0069D1B2AE05648AB", hash_generated_method = "47F1226E1202976956E07A77F6CEA7FC")
    public void setInterpolator(TimeInterpolator interpolator) {
        mInterpolator = interpolator;
        // ---------- Original Method ----------
        //mInterpolator = interpolator;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.782 -0400", hash_original_method = "464D9B25E7EBB7EEA5039E323C745893", hash_generated_method = "863DFE864FAF977123E6726ABC869FA8")
    public Class getType() {
Class varEB4C76CBDB3A6E5E3E03E299B7E6BC66_724169297 =         mValueType;
        varEB4C76CBDB3A6E5E3E03E299B7E6BC66_724169297.addTaint(taint);
        return varEB4C76CBDB3A6E5E3E03E299B7E6BC66_724169297;
        // ---------- Original Method ----------
        //return mValueType;
    }

    
    @DSModeled(DSC.SAFE)
    @Override
public abstract Keyframe clone();

    
    static class ObjectKeyframe extends Keyframe {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.784 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "10C88B3F201F56410DE7B0BF9A3CF880")

        Object mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.789 -0400", hash_original_method = "203797AF2B16BA31CF618ABFC3881151", hash_generated_method = "EF6D837C95C2537A7E649A182C3D153B")
          ObjectKeyframe(float fraction, Object value) {
            addTaint(fraction);
            mFraction = fraction;
            mValue = value;
            mHasValue = (value != null);
            mValueType = mHasValue ? value.getClass() : Object.class;
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValue = value;
            //mHasValue = (value != null);
            //mValueType = mHasValue ? value.getClass() : Object.class;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.791 -0400", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "3FA6F20CBEB2706CDA02FA9A554CDC4C")
        public Object getValue() {
Object varD1FEA3F5EE4618A9C3646312F018E4AC_935454600 =             mValue;
            varD1FEA3F5EE4618A9C3646312F018E4AC_935454600.addTaint(taint);
            return varD1FEA3F5EE4618A9C3646312F018E4AC_935454600;
            // ---------- Original Method ----------
            //return mValue;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.794 -0400", hash_original_method = "A57ED313A37784FB1DA17FC9F39344A7", hash_generated_method = "BCD44A16AB81E639720244E80BED9701")
        public void setValue(Object value) {
            mValue = value;
            mHasValue = (value != null);
            // ---------- Original Method ----------
            //mValue = value;
            //mHasValue = (value != null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.796 -0400", hash_original_method = "D24C77D2B6663612F515281C3853AB21", hash_generated_method = "E1F1B556F25E6B045FB8EBA03855F804")
        @Override
        public ObjectKeyframe clone() {
            ObjectKeyframe kfClone = new ObjectKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
ObjectKeyframe varA9EDFBA5634D9136F6D4A7121F574350_47187565 =             kfClone;
            varA9EDFBA5634D9136F6D4A7121F574350_47187565.addTaint(taint);
            return varA9EDFBA5634D9136F6D4A7121F574350_47187565;
            // ---------- Original Method ----------
            //ObjectKeyframe kfClone = new ObjectKeyframe(getFraction(), mValue);
            //kfClone.setInterpolator(getInterpolator());
            //return kfClone;
        }

        
    }


    
    static class IntKeyframe extends Keyframe {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.799 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC")

        int mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.806 -0400", hash_original_method = "EEAB8C81F88FA2F655356211D4887153", hash_generated_method = "FAC6295CEF7D71B247A193CEC6A7ED67")
          IntKeyframe(float fraction, int value) {
            addTaint(fraction);
            mFraction = fraction;
            mValue = value;
            mValueType = int.class;
            mHasValue = true;
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValue = value;
            //mValueType = int.class;
            //mHasValue = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.812 -0400", hash_original_method = "361D7315F9884E2CC45B77F9DFFA5D0B", hash_generated_method = "3C19D511DDD09AC510004D7A49BDDD9D")
          IntKeyframe(float fraction) {
            addTaint(fraction);
            mFraction = fraction;
            mValueType = int.class;
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValueType = int.class;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.824 -0400", hash_original_method = "7D27B9B7622273E5F87FD5AC6ACFC5AE", hash_generated_method = "31B46FDEDE3A48FE8FB14A47EBB365F9")
        public int getIntValue() {
            int varCBAFE11E7BAE23358D70D54D132C3064_1174715168 = (mValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740741621 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740741621;
            // ---------- Original Method ----------
            //return mValue;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.827 -0400", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "B6EBD9F709D822E62AB24EBAF7D1220E")
        public Object getValue() {
Object varD1FEA3F5EE4618A9C3646312F018E4AC_83057489 =             mValue;
            varD1FEA3F5EE4618A9C3646312F018E4AC_83057489.addTaint(taint);
            return varD1FEA3F5EE4618A9C3646312F018E4AC_83057489;
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.830 -0400", hash_original_method = "C5497A399E3F74A58085B920F39E31DE", hash_generated_method = "CE7D06261F31E5BAE4199A125B4DD615")
        public void setValue(Object value) {
            if(value != null && value.getClass() == Integer.class)            
            {
                mValue = ((Integer)value).intValue();
                mHasValue = true;
            } //End block
            // ---------- Original Method ----------
            //if (value != null && value.getClass() == Integer.class) {
                //mValue = ((Integer)value).intValue();
                //mHasValue = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.833 -0400", hash_original_method = "25DF873BDC1EC275AA64D474732FCE13", hash_generated_method = "C3B806D14CF38FD8EEB900BB1C2D17A6")
        @Override
        public IntKeyframe clone() {
            IntKeyframe kfClone = new IntKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
IntKeyframe varA9EDFBA5634D9136F6D4A7121F574350_1942622977 =             kfClone;
            varA9EDFBA5634D9136F6D4A7121F574350_1942622977.addTaint(taint);
            return varA9EDFBA5634D9136F6D4A7121F574350_1942622977;
            // ---------- Original Method ----------
            //IntKeyframe kfClone = new IntKeyframe(getFraction(), mValue);
            //kfClone.setInterpolator(getInterpolator());
            //return kfClone;
        }

        
    }


    
    static class FloatKeyframe extends Keyframe {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.835 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "61B2557CF01F8FBFCA3655F32AFF6E67")

        float mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.837 -0400", hash_original_method = "12EFD0F6FC013537F5F7DD4B7E13C7C3", hash_generated_method = "608D5AC62F83C0500F69F52B00DCF78F")
          FloatKeyframe(float fraction, float value) {
            addTaint(fraction);
            mFraction = fraction;
            mValue = value;
            mValueType = float.class;
            mHasValue = true;
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValue = value;
            //mValueType = float.class;
            //mHasValue = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.839 -0400", hash_original_method = "68E29C538F7AE79A8714A7F41CC12063", hash_generated_method = "F6B9DF35CC5E88889F76E0E2AD32E921")
          FloatKeyframe(float fraction) {
            addTaint(fraction);
            mFraction = fraction;
            mValueType = float.class;
            // ---------- Original Method ----------
            //mFraction = fraction;
            //mValueType = float.class;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.841 -0400", hash_original_method = "4878123D1CBF5008E7E0955AB5FB61F2", hash_generated_method = "37104690B957624C2494E6C2AB39752C")
        public float getFloatValue() {
            float varCBAFE11E7BAE23358D70D54D132C3064_1846915941 = (mValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_303503451 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_303503451;
            // ---------- Original Method ----------
            //return mValue;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.844 -0400", hash_original_method = "8110BFED38B99D4A69F8125D4CA46C20", hash_generated_method = "88AE94A027B15A207393411E64D9A565")
        public Object getValue() {
Object varD1FEA3F5EE4618A9C3646312F018E4AC_213966022 =             mValue;
            varD1FEA3F5EE4618A9C3646312F018E4AC_213966022.addTaint(taint);
            return varD1FEA3F5EE4618A9C3646312F018E4AC_213966022;
            // ---------- Original Method ----------
            //return mValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.847 -0400", hash_original_method = "7C5BB3EB4CAFBCF934453BA7EC3D20EB", hash_generated_method = "2A46FFBA3E0452D20D17B75256AAFD5A")
        public void setValue(Object value) {
            if(value != null && value.getClass() == Float.class)            
            {
                mValue = ((Float)value).floatValue();
                mHasValue = true;
            } //End block
            // ---------- Original Method ----------
            //if (value != null && value.getClass() == Float.class) {
                //mValue = ((Float)value).floatValue();
                //mHasValue = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.852 -0400", hash_original_method = "5FDA2B31FC1B703F745BE5BB0395A79D", hash_generated_method = "A1F4B9A06BB68C8A9262A839678EF0C1")
        @Override
        public FloatKeyframe clone() {
            FloatKeyframe kfClone = new FloatKeyframe(getFraction(), mValue);
            kfClone.setInterpolator(getInterpolator());
FloatKeyframe varA9EDFBA5634D9136F6D4A7121F574350_1851767575 =             kfClone;
            varA9EDFBA5634D9136F6D4A7121F574350_1851767575.addTaint(taint);
            return varA9EDFBA5634D9136F6D4A7121F574350_1851767575;
            // ---------- Original Method ----------
            //FloatKeyframe kfClone = new FloatKeyframe(getFraction(), mValue);
            //kfClone.setInterpolator(getInterpolator());
            //return kfClone;
        }

        
    }


    
}

