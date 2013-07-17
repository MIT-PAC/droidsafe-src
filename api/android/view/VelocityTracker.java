package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Poolable;
import android.util.Pool;
import android.util.Pools;
import android.util.PoolableManager;

public final class VelocityTracker implements Poolable<VelocityTracker> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.273 -0400", hash_original_field = "34F930F150EAEEFF27D6C0C8E4629911", hash_generated_field = "E9A8054C2C57C0CE861FDCA982433D1A")

    private int mPtr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.274 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "5B4B8EC4C61CE05CF5BB2F5E71D6C6C3")

    private VelocityTracker mNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.274 -0400", hash_original_field = "224D05F4261498DA1D9DF38424832532", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

    private boolean mIsPooled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.274 -0400", hash_original_method = "F7334C8DF7CFD0702F8B319FC0AAEBEC", hash_generated_method = "D85E3DAABC499710A355B9A59E327BBA")
    private  VelocityTracker() {
        mPtr = nativeInitialize();
        // ---------- Original Method ----------
        //mPtr = nativeInitialize();
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeInitialize() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDispose(int ptr) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeClear(int ptr) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeAddMovement(int ptr, MotionEvent event) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeComputeCurrentVelocity(int ptr, int units, float maxVelocity) {
    }

    
    @DSModeled(DSC.SAFE)
    private static float nativeGetXVelocity(int ptr, int id) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSModeled(DSC.SAFE)
    private static float nativeGetYVelocity(int ptr, int id) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeGetEstimator(int ptr, int id,
            int degree, int horizonMillis, Estimator outEstimator) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    static public VelocityTracker obtain() {
        return sPool.acquire();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.277 -0400", hash_original_method = "E0F67E3C99A5EE80DA0668A59C0EFAE4", hash_generated_method = "0846A8ED2E43BFFDC09D1A7A77AFC8B7")
    public void recycle() {
        sPool.release(this);
        // ---------- Original Method ----------
        //sPool.release(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.278 -0400", hash_original_method = "2CC1A1BE49EC62DFF418BB32459396A9", hash_generated_method = "74AE9F16F0DD1BBCC61D5A9BA8889C0C")
    public void setNextPoolable(VelocityTracker element) {
        mNext = element;
        // ---------- Original Method ----------
        //mNext = element;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.278 -0400", hash_original_method = "DEA3C3D2ED346DE60DC91CC9918022D0", hash_generated_method = "D759BE744DE65F8503CFDE8BF1C09521")
    public VelocityTracker getNextPoolable() {
VelocityTracker varA29C6A1F0F29A0F3732076BE541D5DCD_1505590188 =         mNext;
        varA29C6A1F0F29A0F3732076BE541D5DCD_1505590188.addTaint(taint);
        return varA29C6A1F0F29A0F3732076BE541D5DCD_1505590188;
        // ---------- Original Method ----------
        //return mNext;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.279 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "799B6D87CDBE00F9A9E87FFAD5DA0B1D")
    public boolean isPooled() {
        boolean var224D05F4261498DA1D9DF38424832532_322340227 = (mIsPooled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1873514300 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1873514300;
        // ---------- Original Method ----------
        //return mIsPooled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.279 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "31CEC37D69D770078DC2E4A0F4797B2A")
    public void setPooled(boolean isPooled) {
        mIsPooled = isPooled;
        // ---------- Original Method ----------
        //mIsPooled = isPooled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.280 -0400", hash_original_method = "388B6019F11DE2E32EE5A9A9056EF526", hash_generated_method = "E2BE9397284FB49BDE3E875614886F4D")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            if(mPtr != 0)            
            {
                nativeDispose(mPtr);
                mPtr = 0;
            } //End block
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (mPtr != 0) {
                //nativeDispose(mPtr);
                //mPtr = 0;
            //}
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.280 -0400", hash_original_method = "3EB8DC396E0D228312A300339405C305", hash_generated_method = "E72C8D02D6D5031CDDA2CF440FD3B4C9")
    public void clear() {
        nativeClear(mPtr);
        // ---------- Original Method ----------
        //nativeClear(mPtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.281 -0400", hash_original_method = "47F4DCEEC62F25E97556D9BB3D79B1AA", hash_generated_method = "911A930433188FB50AB26BD58E97B1C0")
    public void addMovement(MotionEvent event) {
        addTaint(event.getTaint());
        if(event == null)        
        {
            IllegalArgumentException var3920A277CD7F529F4F356CA2BB30C0CA_185678483 = new IllegalArgumentException("event must not be null");
            var3920A277CD7F529F4F356CA2BB30C0CA_185678483.addTaint(taint);
            throw var3920A277CD7F529F4F356CA2BB30C0CA_185678483;
        } //End block
        nativeAddMovement(mPtr, event);
        // ---------- Original Method ----------
        //if (event == null) {
            //throw new IllegalArgumentException("event must not be null");
        //}
        //nativeAddMovement(mPtr, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.281 -0400", hash_original_method = "2C861C2E66E6C5ED5AC5356AA16D4AE7", hash_generated_method = "242D20317C94F501D1AC280CAF79E160")
    public void computeCurrentVelocity(int units) {
        addTaint(units);
        nativeComputeCurrentVelocity(mPtr, units, Float.MAX_VALUE);
        // ---------- Original Method ----------
        //nativeComputeCurrentVelocity(mPtr, units, Float.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.282 -0400", hash_original_method = "AAC1E150F0714A1C0618591FDBA33AD9", hash_generated_method = "63E80A429840D6FEFD79A0DF6E72CB58")
    public void computeCurrentVelocity(int units, float maxVelocity) {
        addTaint(maxVelocity);
        addTaint(units);
        nativeComputeCurrentVelocity(mPtr, units, maxVelocity);
        // ---------- Original Method ----------
        //nativeComputeCurrentVelocity(mPtr, units, maxVelocity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.282 -0400", hash_original_method = "175B9FF596A60DD4A27A3E2F4F8FB36B", hash_generated_method = "C9D7FDAF9DEED4D052FB7C215D7387A9")
    public float getXVelocity() {
        float var1F3A8E958A4C92A70937DB1AC04434E8_1823270462 = (nativeGetXVelocity(mPtr, ACTIVE_POINTER_ID));
                float var546ADE640B6EDFBC8A086EF31347E768_849561950 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_849561950;
        // ---------- Original Method ----------
        //return nativeGetXVelocity(mPtr, ACTIVE_POINTER_ID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.282 -0400", hash_original_method = "7522D7DB1CC0324C793DB225FECF96EF", hash_generated_method = "49E22005585C178B0AD431A573B92793")
    public float getYVelocity() {
        float var901305552139D9C59B978FB160946120_1786988650 = (nativeGetYVelocity(mPtr, ACTIVE_POINTER_ID));
                float var546ADE640B6EDFBC8A086EF31347E768_676894050 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_676894050;
        // ---------- Original Method ----------
        //return nativeGetYVelocity(mPtr, ACTIVE_POINTER_ID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.284 -0400", hash_original_method = "E88E46619158ECDA6CFC39862B1412B8", hash_generated_method = "E45074C1DEB3EB22D502B92268B7E209")
    public float getXVelocity(int id) {
        addTaint(id);
        float var3E6C2E1F412411771F1C26F88E9C5428_2097078881 = (nativeGetXVelocity(mPtr, id));
                float var546ADE640B6EDFBC8A086EF31347E768_1491936835 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1491936835;
        // ---------- Original Method ----------
        //return nativeGetXVelocity(mPtr, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.284 -0400", hash_original_method = "3A1681E069274B63F81D41BA2ABBDF60", hash_generated_method = "B8D5C7626480CA89C2215D5DE8C31605")
    public float getYVelocity(int id) {
        addTaint(id);
        float var8690B61C933BB7DCEEF44DD34DB6E5F7_2077896313 = (nativeGetYVelocity(mPtr, id));
                float var546ADE640B6EDFBC8A086EF31347E768_394274757 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_394274757;
        // ---------- Original Method ----------
        //return nativeGetYVelocity(mPtr, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.285 -0400", hash_original_method = "53182452353A9C74BE3B46A3229E5647", hash_generated_method = "25FAD989A83856E77552CF916EE74520")
    public boolean getEstimator(int id, int degree, int horizonMillis, Estimator outEstimator) {
        addTaint(outEstimator.getTaint());
        addTaint(horizonMillis);
        addTaint(degree);
        addTaint(id);
        if(outEstimator == null)        
        {
            IllegalArgumentException var7729680BD01F210BDAE467823B75DEFF_382819993 = new IllegalArgumentException("outEstimator must not be null");
            var7729680BD01F210BDAE467823B75DEFF_382819993.addTaint(taint);
            throw var7729680BD01F210BDAE467823B75DEFF_382819993;
        } //End block
        boolean varC992AEF59FE90C4936A5F7B111BF1929_758486644 = (nativeGetEstimator(mPtr, id, degree, horizonMillis, outEstimator));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1368644836 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1368644836;
        // ---------- Original Method ----------
        //if (outEstimator == null) {
            //throw new IllegalArgumentException("outEstimator must not be null");
        //}
        //return nativeGetEstimator(mPtr, id, degree, horizonMillis, outEstimator);
    }

    
    public static final class Estimator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.285 -0400", hash_original_field = "F912F76B126AAE00981054A0E1B74B9E", hash_generated_field = "DAF278AF332EC45DD2F6AAB0F51AC500")

        public final float[] xCoeff = new float[MAX_DEGREE + 1];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.285 -0400", hash_original_field = "917AB8BA1B6C7A079A777F441F7E0131", hash_generated_field = "32F2BEFC622B3A8C2EFB2E54B5590144")

        public final float[] yCoeff = new float[MAX_DEGREE + 1];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.286 -0400", hash_original_field = "FB81C91EB92D6CB64AEB64C3F37EF2C4", hash_generated_field = "A21FC26B54D92E07E39E10EA3DEF93F3")

        public int degree;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.286 -0400", hash_original_field = "8BF91B0F43DDF159ED36AD0F50EE3E04", hash_generated_field = "9300AFCF844D22EA28DB8E928CFE60EB")

        public float confidence;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.286 -0400", hash_original_method = "3C04CD9D0E5CF8A244AF16BC346C84B6", hash_generated_method = "3C04CD9D0E5CF8A244AF16BC346C84B6")
        public Estimator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.286 -0400", hash_original_method = "EF4145D98D5D09EB61112BFE6D9F064E", hash_generated_method = "C66B2860453EC04C168AFB24B2F3B164")
        public float estimateX(float time) {
            addTaint(time);
            float var11437C0E100EAF34BB6AD8A0E1B2CFF3_1754365454 = (estimate(time, xCoeff));
                        float var546ADE640B6EDFBC8A086EF31347E768_1885102205 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1885102205;
            // ---------- Original Method ----------
            //return estimate(time, xCoeff);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.287 -0400", hash_original_method = "4B57BC9609218FF4FD5DA8FDF96C43D9", hash_generated_method = "D34BEBCEFD6BE1B47305DB93B3024F8E")
        public float estimateY(float time) {
            addTaint(time);
            float var44F180C001ADBDFDB0826BBD6FA6109D_316786110 = (estimate(time, yCoeff));
                        float var546ADE640B6EDFBC8A086EF31347E768_591495364 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_591495364;
            // ---------- Original Method ----------
            //return estimate(time, yCoeff);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.287 -0400", hash_original_method = "17E8AE405780B4520E14D05EC083CF07", hash_generated_method = "5189F636DC7F0031576DAB3F4B6EA466")
        private float estimate(float time, float[] c) {
            addTaint(c[0]);
            addTaint(time);
            float a = 0;
            float scale = 1;
for(int i = 0;i <= degree;i++)
            {
                a += c[i] * scale;
                scale *= time;
            } //End block
            float var0CC175B9C0F1B6A831C399E269772661_981686732 = (a);
                        float var546ADE640B6EDFBC8A086EF31347E768_989080532 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_989080532;
            // ---------- Original Method ----------
            //float a = 0;
            //float scale = 1;
            //for (int i = 0; i <= degree; i++) {
                //a += c[i] * scale;
                //scale *= time;
            //}
            //return a;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.287 -0400", hash_original_field = "A54F523E6A7DF5613B641195F2A7AF2B", hash_generated_field = "6B300D0F1610BC31482D34A0922264D0")

        private static final int MAX_DEGREE = 2;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.287 -0400", hash_original_field = "7D322AC6B02AE1303D1EE66F45C4A4CD", hash_generated_field = "B8A4DDDA4C487415D4255708CB5FC0DF")

    private static final Pool<VelocityTracker> sPool = Pools.synchronizedPool(
            Pools.finitePool(new PoolableManager<VelocityTracker>() {
                public VelocityTracker newInstance() {
                    return new VelocityTracker();
                }

                public void onAcquired(VelocityTracker element) {
                }

                public void onReleased(VelocityTracker element) {
                    element.clear();
                }
            }, 2));
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.287 -0400", hash_original_field = "B23005BED9309443B0ABD014F4C6507F", hash_generated_field = "FF8FF6E56B8D783C306CE7F0923B38D1")

    private static final int ACTIVE_POINTER_ID = -1;
    // orphaned legacy method
    public void onAcquired(VelocityTracker element) {
                }
    
    // orphaned legacy method
    public VelocityTracker newInstance() {
                    return new VelocityTracker();
                }
    
    // orphaned legacy method
    public void onReleased(VelocityTracker element) {
                    element.clear();
                }
    
}

