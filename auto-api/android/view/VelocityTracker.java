package android.view;

// Droidsafe Imports
import android.util.Pool;
import android.util.Poolable;
import android.util.PoolableManager;
import android.util.Pools;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public final class VelocityTracker implements Poolable<VelocityTracker> {
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
    private static final int ACTIVE_POINTER_ID = -1;
    private int mPtr;
    private VelocityTracker mNext;
    private boolean mIsPooled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.568 -0400", hash_original_method = "F7334C8DF7CFD0702F8B319FC0AAEBEC", hash_generated_method = "98EB5212E35F9299161AC250DCABE782")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private VelocityTracker() {
        mPtr = nativeInitialize();
        // ---------- Original Method ----------
        //mPtr = nativeInitialize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.568 -0400", hash_original_method = "ADE3BC3A58A2BA0E28131F1DF78B0709", hash_generated_method = "DD03A5E1C7452D141CF4B283B6DFF744")
    private static int nativeInitialize() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.568 -0400", hash_original_method = "62D22E54D2287BCFB12AF53C33B4CDAE", hash_generated_method = "E31DEE0DEB4DDCFCF415ECA9533B7C2A")
    private static void nativeDispose(int ptr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.568 -0400", hash_original_method = "42B933D9B745DD4BDDF439D522DC985D", hash_generated_method = "9CE92F66C16CC61AB92B881A43201C00")
    private static void nativeClear(int ptr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.568 -0400", hash_original_method = "0A75E0D3B99035BB25B4E9EE0EB72813", hash_generated_method = "EF3BA9927A5A35752BA2065D19C2112D")
    private static void nativeAddMovement(int ptr, MotionEvent event) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.568 -0400", hash_original_method = "8A30CDF630FEB9311143F288B2C77687", hash_generated_method = "6984249A9DC5EB434211853D9E72314F")
    private static void nativeComputeCurrentVelocity(int ptr, int units, float maxVelocity) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.568 -0400", hash_original_method = "C28A31A87FD521C5F1F20C45E8FA5EC3", hash_generated_method = "B16EF2F0A07120389144B35D5A0E5276")
    private static float nativeGetXVelocity(int ptr, int id) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.568 -0400", hash_original_method = "83D9B0299A440B2A67E48FE9259E951F", hash_generated_method = "2682626BC019914F07CDA8FDB02AF21B")
    private static float nativeGetYVelocity(int ptr, int id) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.568 -0400", hash_original_method = "997E64B62563B4D849EDC16E3B80D56E", hash_generated_method = "F7FC397D6ADCA79297DC96DC6886979D")
    private static boolean nativeGetEstimator(int ptr, int id,
            int degree, int horizonMillis, Estimator outEstimator) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.568 -0400", hash_original_method = "83965EAF73271D6A9CB89F99F2C4B6CA", hash_generated_method = "CA09BFD1026C74084FB63F043FC190B2")
    static public VelocityTracker obtain() {
        return sPool.acquire();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.568 -0400", hash_original_method = "E0F67E3C99A5EE80DA0668A59C0EFAE4", hash_generated_method = "BDCE2301EE869D29E94762191ECB3840")
    @DSModeled(DSC.SAFE)
    public void recycle() {
        sPool.release(this);
        // ---------- Original Method ----------
        //sPool.release(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.568 -0400", hash_original_method = "2CC1A1BE49EC62DFF418BB32459396A9", hash_generated_method = "2A0CB45F0CFF5FF90D25A8B7C56E7A44")
    @DSModeled(DSC.SAFE)
    public void setNextPoolable(VelocityTracker element) {
        dsTaint.addTaint(element.dsTaint);
        // ---------- Original Method ----------
        //mNext = element;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.568 -0400", hash_original_method = "DEA3C3D2ED346DE60DC91CC9918022D0", hash_generated_method = "E59FBE4965FAE9C5CAE13A10127A9203")
    @DSModeled(DSC.SAFE)
    public VelocityTracker getNextPoolable() {
        return (VelocityTracker)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mNext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.568 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "80FFB187A01961D0CBA265CB5CA66DE6")
    @DSModeled(DSC.SAFE)
    public boolean isPooled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsPooled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.569 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "36A555F939A13685926002FBFBD79870")
    @DSModeled(DSC.SAFE)
    public void setPooled(boolean isPooled) {
        dsTaint.addTaint(isPooled);
        // ---------- Original Method ----------
        //mIsPooled = isPooled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.569 -0400", hash_original_method = "388B6019F11DE2E32EE5A9A9056EF526", hash_generated_method = "E77A9C173283E2CBCC5856B2B8038D67")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() throws Throwable {
        try 
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.569 -0400", hash_original_method = "3EB8DC396E0D228312A300339405C305", hash_generated_method = "DC26E48C82606800054C4C196AEEDE07")
    @DSModeled(DSC.SAFE)
    public void clear() {
        nativeClear(mPtr);
        // ---------- Original Method ----------
        //nativeClear(mPtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.569 -0400", hash_original_method = "47F4DCEEC62F25E97556D9BB3D79B1AA", hash_generated_method = "A607F1BCBAC05D68246A274F4D44A276")
    @DSModeled(DSC.SAFE)
    public void addMovement(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("event must not be null");
        } //End block
        nativeAddMovement(mPtr, event);
        // ---------- Original Method ----------
        //if (event == null) {
            //throw new IllegalArgumentException("event must not be null");
        //}
        //nativeAddMovement(mPtr, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.569 -0400", hash_original_method = "2C861C2E66E6C5ED5AC5356AA16D4AE7", hash_generated_method = "39EF91EC5482A83D07EFD9E01B15CA6A")
    @DSModeled(DSC.SAFE)
    public void computeCurrentVelocity(int units) {
        dsTaint.addTaint(units);
        nativeComputeCurrentVelocity(mPtr, units, Float.MAX_VALUE);
        // ---------- Original Method ----------
        //nativeComputeCurrentVelocity(mPtr, units, Float.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.569 -0400", hash_original_method = "AAC1E150F0714A1C0618591FDBA33AD9", hash_generated_method = "3298150E44DB65A5BD3BB6EC6C9E3426")
    @DSModeled(DSC.SAFE)
    public void computeCurrentVelocity(int units, float maxVelocity) {
        dsTaint.addTaint(maxVelocity);
        dsTaint.addTaint(units);
        nativeComputeCurrentVelocity(mPtr, units, maxVelocity);
        // ---------- Original Method ----------
        //nativeComputeCurrentVelocity(mPtr, units, maxVelocity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.569 -0400", hash_original_method = "175B9FF596A60DD4A27A3E2F4F8FB36B", hash_generated_method = "E082C8F224190EDB90AA433ED24D359E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getXVelocity() {
        float varEF6EB6007A69FA84B157F348BC46F077_1636929992 = (nativeGetXVelocity(mPtr, ACTIVE_POINTER_ID));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetXVelocity(mPtr, ACTIVE_POINTER_ID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.569 -0400", hash_original_method = "7522D7DB1CC0324C793DB225FECF96EF", hash_generated_method = "318B8F48D0C77E85D0E86D190C3DF32A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getYVelocity() {
        float varA836CE77B04F283B3AE722B99F53A026_1156425246 = (nativeGetYVelocity(mPtr, ACTIVE_POINTER_ID));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetYVelocity(mPtr, ACTIVE_POINTER_ID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.569 -0400", hash_original_method = "E88E46619158ECDA6CFC39862B1412B8", hash_generated_method = "8A384DEB7C9B4E481F4578799FC20F6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getXVelocity(int id) {
        dsTaint.addTaint(id);
        float var7B1658FD1F00DCF18FF085C070307AFF_2081042680 = (nativeGetXVelocity(mPtr, id));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetXVelocity(mPtr, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.569 -0400", hash_original_method = "3A1681E069274B63F81D41BA2ABBDF60", hash_generated_method = "2F947EBD82B9C916353FF9ACEA531048")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getYVelocity(int id) {
        dsTaint.addTaint(id);
        float varB6CE2C7467D225522F782DC0FFE159B9_1744985642 = (nativeGetYVelocity(mPtr, id));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetYVelocity(mPtr, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.569 -0400", hash_original_method = "53182452353A9C74BE3B46A3229E5647", hash_generated_method = "C82BB70B1F01CEA781EDB501C61182C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getEstimator(int id, int degree, int horizonMillis, Estimator outEstimator) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(degree);
        dsTaint.addTaint(outEstimator.dsTaint);
        dsTaint.addTaint(horizonMillis);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("outEstimator must not be null");
        } //End block
        boolean varB9B431FEE5CF127FE496DD1277AA2E23_1135224017 = (nativeGetEstimator(mPtr, id, degree, horizonMillis, outEstimator));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (outEstimator == null) {
            //throw new IllegalArgumentException("outEstimator must not be null");
        //}
        //return nativeGetEstimator(mPtr, id, degree, horizonMillis, outEstimator);
    }

    
    public static final class Estimator {
        private static final int MAX_DEGREE = 2;
        public final float[] xCoeff = new float[MAX_DEGREE + 1];
        public final float[] yCoeff = new float[MAX_DEGREE + 1];
        public int degree;
        public float confidence;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.569 -0400", hash_original_method = "EF4145D98D5D09EB61112BFE6D9F064E", hash_generated_method = "0428EFB2AD1DCDCA857E044797D17869")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public float estimateX(float time) {
            dsTaint.addTaint(time);
            float varD2F41F7DCCDB33B464FD432116295CA0_1286902756 = (estimate(time, xCoeff));
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return estimate(time, xCoeff);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.570 -0400", hash_original_method = "4B57BC9609218FF4FD5DA8FDF96C43D9", hash_generated_method = "364DF7FBF01F02EDE0ADBCA367C2F016")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public float estimateY(float time) {
            dsTaint.addTaint(time);
            float varD96A25489895EAFDAB21F43C286C60AD_1318058823 = (estimate(time, yCoeff));
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return estimate(time, yCoeff);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.570 -0400", hash_original_method = "17E8AE405780B4520E14D05EC083CF07", hash_generated_method = "C49CC5D3D6FBFA35F2DA0AAF4B23E8D3")
        @DSModeled(DSC.SAFE)
        private float estimate(float time, float[] c) {
            dsTaint.addTaint(time);
            dsTaint.addTaint(c);
            float a;
            a = 0;
            float scale;
            scale = 1;
            {
                int i;
                i = 0;
                {
                    a += c[i] * scale;
                    scale *= time;
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //float a = 0;
            //float scale = 1;
            //for (int i = 0; i <= degree; i++) {
                //a += c[i] * scale;
                //scale *= time;
            //}
            //return a;
        }

        
    }


    
}


