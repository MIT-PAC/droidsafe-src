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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.959 -0400", hash_original_field = "34F930F150EAEEFF27D6C0C8E4629911", hash_generated_field = "E9A8054C2C57C0CE861FDCA982433D1A")

    private int mPtr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.959 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "5B4B8EC4C61CE05CF5BB2F5E71D6C6C3")

    private VelocityTracker mNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.959 -0400", hash_original_field = "224D05F4261498DA1D9DF38424832532", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

    private boolean mIsPooled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.959 -0400", hash_original_method = "F7334C8DF7CFD0702F8B319FC0AAEBEC", hash_generated_method = "D85E3DAABC499710A355B9A59E327BBA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.962 -0400", hash_original_method = "E0F67E3C99A5EE80DA0668A59C0EFAE4", hash_generated_method = "0846A8ED2E43BFFDC09D1A7A77AFC8B7")
    public void recycle() {
        sPool.release(this);
        // ---------- Original Method ----------
        //sPool.release(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.963 -0400", hash_original_method = "2CC1A1BE49EC62DFF418BB32459396A9", hash_generated_method = "74AE9F16F0DD1BBCC61D5A9BA8889C0C")
    public void setNextPoolable(VelocityTracker element) {
        mNext = element;
        // ---------- Original Method ----------
        //mNext = element;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.963 -0400", hash_original_method = "DEA3C3D2ED346DE60DC91CC9918022D0", hash_generated_method = "A09AD0BA965BF064861887CAB82F3194")
    public VelocityTracker getNextPoolable() {
VelocityTracker varA29C6A1F0F29A0F3732076BE541D5DCD_488863880 =         mNext;
        varA29C6A1F0F29A0F3732076BE541D5DCD_488863880.addTaint(taint);
        return varA29C6A1F0F29A0F3732076BE541D5DCD_488863880;
        // ---------- Original Method ----------
        //return mNext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.964 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "77272E194749156C77211BEA59A74CFE")
    public boolean isPooled() {
        boolean var224D05F4261498DA1D9DF38424832532_651633496 = (mIsPooled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_932136750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_932136750;
        // ---------- Original Method ----------
        //return mIsPooled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.965 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "31CEC37D69D770078DC2E4A0F4797B2A")
    public void setPooled(boolean isPooled) {
        mIsPooled = isPooled;
        // ---------- Original Method ----------
        //mIsPooled = isPooled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.965 -0400", hash_original_method = "388B6019F11DE2E32EE5A9A9056EF526", hash_generated_method = "E2BE9397284FB49BDE3E875614886F4D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.966 -0400", hash_original_method = "3EB8DC396E0D228312A300339405C305", hash_generated_method = "E72C8D02D6D5031CDDA2CF440FD3B4C9")
    public void clear() {
        nativeClear(mPtr);
        // ---------- Original Method ----------
        //nativeClear(mPtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.966 -0400", hash_original_method = "47F4DCEEC62F25E97556D9BB3D79B1AA", hash_generated_method = "9A16042EC729F5F16CFF4F381B9A6B54")
    public void addMovement(MotionEvent event) {
        addTaint(event.getTaint());
    if(event == null)        
        {
            IllegalArgumentException var3920A277CD7F529F4F356CA2BB30C0CA_839083986 = new IllegalArgumentException("event must not be null");
            var3920A277CD7F529F4F356CA2BB30C0CA_839083986.addTaint(taint);
            throw var3920A277CD7F529F4F356CA2BB30C0CA_839083986;
        } //End block
        nativeAddMovement(mPtr, event);
        // ---------- Original Method ----------
        //if (event == null) {
            //throw new IllegalArgumentException("event must not be null");
        //}
        //nativeAddMovement(mPtr, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.967 -0400", hash_original_method = "2C861C2E66E6C5ED5AC5356AA16D4AE7", hash_generated_method = "242D20317C94F501D1AC280CAF79E160")
    public void computeCurrentVelocity(int units) {
        addTaint(units);
        nativeComputeCurrentVelocity(mPtr, units, Float.MAX_VALUE);
        // ---------- Original Method ----------
        //nativeComputeCurrentVelocity(mPtr, units, Float.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.967 -0400", hash_original_method = "AAC1E150F0714A1C0618591FDBA33AD9", hash_generated_method = "63E80A429840D6FEFD79A0DF6E72CB58")
    public void computeCurrentVelocity(int units, float maxVelocity) {
        addTaint(maxVelocity);
        addTaint(units);
        nativeComputeCurrentVelocity(mPtr, units, maxVelocity);
        // ---------- Original Method ----------
        //nativeComputeCurrentVelocity(mPtr, units, maxVelocity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.967 -0400", hash_original_method = "175B9FF596A60DD4A27A3E2F4F8FB36B", hash_generated_method = "935C562AD75B01BA386ACC55F42ECB5A")
    public float getXVelocity() {
        float var1F3A8E958A4C92A70937DB1AC04434E8_1358704620 = (nativeGetXVelocity(mPtr, ACTIVE_POINTER_ID));
                float var546ADE640B6EDFBC8A086EF31347E768_971592470 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_971592470;
        // ---------- Original Method ----------
        //return nativeGetXVelocity(mPtr, ACTIVE_POINTER_ID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.968 -0400", hash_original_method = "7522D7DB1CC0324C793DB225FECF96EF", hash_generated_method = "EA1A79BCEE23105B7BD1FED525B00C95")
    public float getYVelocity() {
        float var901305552139D9C59B978FB160946120_1768815958 = (nativeGetYVelocity(mPtr, ACTIVE_POINTER_ID));
                float var546ADE640B6EDFBC8A086EF31347E768_216581153 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_216581153;
        // ---------- Original Method ----------
        //return nativeGetYVelocity(mPtr, ACTIVE_POINTER_ID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.968 -0400", hash_original_method = "E88E46619158ECDA6CFC39862B1412B8", hash_generated_method = "740584CC9CF268CA24210602241D4572")
    public float getXVelocity(int id) {
        addTaint(id);
        float var3E6C2E1F412411771F1C26F88E9C5428_377407553 = (nativeGetXVelocity(mPtr, id));
                float var546ADE640B6EDFBC8A086EF31347E768_704218175 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_704218175;
        // ---------- Original Method ----------
        //return nativeGetXVelocity(mPtr, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.968 -0400", hash_original_method = "3A1681E069274B63F81D41BA2ABBDF60", hash_generated_method = "1267C6075357FA8914CB536EE84695BF")
    public float getYVelocity(int id) {
        addTaint(id);
        float var8690B61C933BB7DCEEF44DD34DB6E5F7_1838234516 = (nativeGetYVelocity(mPtr, id));
                float var546ADE640B6EDFBC8A086EF31347E768_1015464059 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1015464059;
        // ---------- Original Method ----------
        //return nativeGetYVelocity(mPtr, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.969 -0400", hash_original_method = "53182452353A9C74BE3B46A3229E5647", hash_generated_method = "7FA06F9215DF341F38E891F22245AEE3")
    public boolean getEstimator(int id, int degree, int horizonMillis, Estimator outEstimator) {
        addTaint(outEstimator.getTaint());
        addTaint(horizonMillis);
        addTaint(degree);
        addTaint(id);
    if(outEstimator == null)        
        {
            IllegalArgumentException var7729680BD01F210BDAE467823B75DEFF_605746202 = new IllegalArgumentException("outEstimator must not be null");
            var7729680BD01F210BDAE467823B75DEFF_605746202.addTaint(taint);
            throw var7729680BD01F210BDAE467823B75DEFF_605746202;
        } //End block
        boolean varC992AEF59FE90C4936A5F7B111BF1929_717017837 = (nativeGetEstimator(mPtr, id, degree, horizonMillis, outEstimator));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_692420609 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_692420609;
        // ---------- Original Method ----------
        //if (outEstimator == null) {
            //throw new IllegalArgumentException("outEstimator must not be null");
        //}
        //return nativeGetEstimator(mPtr, id, degree, horizonMillis, outEstimator);
    }

    
    public static final class Estimator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.969 -0400", hash_original_field = "F912F76B126AAE00981054A0E1B74B9E", hash_generated_field = "DAF278AF332EC45DD2F6AAB0F51AC500")

        public final float[] xCoeff = new float[MAX_DEGREE + 1];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.969 -0400", hash_original_field = "917AB8BA1B6C7A079A777F441F7E0131", hash_generated_field = "32F2BEFC622B3A8C2EFB2E54B5590144")

        public final float[] yCoeff = new float[MAX_DEGREE + 1];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.969 -0400", hash_original_field = "FB81C91EB92D6CB64AEB64C3F37EF2C4", hash_generated_field = "A21FC26B54D92E07E39E10EA3DEF93F3")

        public int degree;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.969 -0400", hash_original_field = "8BF91B0F43DDF159ED36AD0F50EE3E04", hash_generated_field = "9300AFCF844D22EA28DB8E928CFE60EB")

        public float confidence;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.969 -0400", hash_original_method = "3C04CD9D0E5CF8A244AF16BC346C84B6", hash_generated_method = "3C04CD9D0E5CF8A244AF16BC346C84B6")
        public Estimator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.969 -0400", hash_original_method = "EF4145D98D5D09EB61112BFE6D9F064E", hash_generated_method = "3ED1C5A157C6D7C98740EE58D8C68605")
        public float estimateX(float time) {
            addTaint(time);
            float var11437C0E100EAF34BB6AD8A0E1B2CFF3_1982728012 = (estimate(time, xCoeff));
                        float var546ADE640B6EDFBC8A086EF31347E768_1561482744 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1561482744;
            // ---------- Original Method ----------
            //return estimate(time, xCoeff);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.970 -0400", hash_original_method = "4B57BC9609218FF4FD5DA8FDF96C43D9", hash_generated_method = "A764D4559E80816C664D0FFC02AAD9FA")
        public float estimateY(float time) {
            addTaint(time);
            float var44F180C001ADBDFDB0826BBD6FA6109D_973601787 = (estimate(time, yCoeff));
                        float var546ADE640B6EDFBC8A086EF31347E768_1339029621 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1339029621;
            // ---------- Original Method ----------
            //return estimate(time, yCoeff);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.970 -0400", hash_original_method = "17E8AE405780B4520E14D05EC083CF07", hash_generated_method = "A30968E91F5D697DE452CBCDCEAED8BD")
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
            float var0CC175B9C0F1B6A831C399E269772661_887684543 = (a);
                        float var546ADE640B6EDFBC8A086EF31347E768_786175840 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_786175840;
            // ---------- Original Method ----------
            //float a = 0;
            //float scale = 1;
            //for (int i = 0; i <= degree; i++) {
                //a += c[i] * scale;
                //scale *= time;
            //}
            //return a;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.970 -0400", hash_original_field = "A54F523E6A7DF5613B641195F2A7AF2B", hash_generated_field = "6B300D0F1610BC31482D34A0922264D0")

        private static final int MAX_DEGREE = 2;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.970 -0400", hash_original_field = "7D322AC6B02AE1303D1EE66F45C4A4CD", hash_generated_field = "B8A4DDDA4C487415D4255708CB5FC0DF")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.971 -0400", hash_original_field = "B23005BED9309443B0ABD014F4C6507F", hash_generated_field = "FF8FF6E56B8D783C306CE7F0923B38D1")

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

