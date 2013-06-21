package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Poolable;
import android.util.Pool;
import android.util.Pools;
import android.util.PoolableManager;

public final class VelocityTracker implements Poolable<VelocityTracker> {
    private int mPtr;
    private VelocityTracker mNext;
    private boolean mIsPooled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.540 -0400", hash_original_method = "F7334C8DF7CFD0702F8B319FC0AAEBEC", hash_generated_method = "D85E3DAABC499710A355B9A59E327BBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private VelocityTracker() {
        mPtr = nativeInitialize();
        // ---------- Original Method ----------
        //mPtr = nativeInitialize();
    }

    
        private static int nativeInitialize() {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void nativeDispose(int ptr) {
    }

    
        private static void nativeClear(int ptr) {
    }

    
        private static void nativeAddMovement(int ptr, MotionEvent event) {
    }

    
        private static void nativeComputeCurrentVelocity(int ptr, int units, float maxVelocity) {
    }

    
        private static float nativeGetXVelocity(int ptr, int id) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
        private static float nativeGetYVelocity(int ptr, int id) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
        private static boolean nativeGetEstimator(int ptr, int id,
            int degree, int horizonMillis, Estimator outEstimator) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        static public VelocityTracker obtain() {
        return sPool.acquire();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.541 -0400", hash_original_method = "E0F67E3C99A5EE80DA0668A59C0EFAE4", hash_generated_method = "0846A8ED2E43BFFDC09D1A7A77AFC8B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void recycle() {
        sPool.release(this);
        // ---------- Original Method ----------
        //sPool.release(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.541 -0400", hash_original_method = "2CC1A1BE49EC62DFF418BB32459396A9", hash_generated_method = "006D5F9BA84C6CD13D0135B125B59E4F")
    @DSModeled(DSC.SAFE)
    public void setNextPoolable(VelocityTracker element) {
        dsTaint.addTaint(element.dsTaint);
        // ---------- Original Method ----------
        //mNext = element;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.541 -0400", hash_original_method = "DEA3C3D2ED346DE60DC91CC9918022D0", hash_generated_method = "29E7917647CEFA8D22F59AE52832B35E")
    @DSModeled(DSC.SAFE)
    public VelocityTracker getNextPoolable() {
        return (VelocityTracker)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mNext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.541 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "5D15E99725D43744F3178673C8B6AC3C")
    @DSModeled(DSC.SAFE)
    public boolean isPooled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsPooled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.541 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "A19BE98D20006B14A3686F1F697F4E6E")
    @DSModeled(DSC.SAFE)
    public void setPooled(boolean isPooled) {
        dsTaint.addTaint(isPooled);
        // ---------- Original Method ----------
        //mIsPooled = isPooled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.542 -0400", hash_original_method = "388B6019F11DE2E32EE5A9A9056EF526", hash_generated_method = "67860CE34A62351A9262D687B4539116")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.542 -0400", hash_original_method = "3EB8DC396E0D228312A300339405C305", hash_generated_method = "E72C8D02D6D5031CDDA2CF440FD3B4C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        nativeClear(mPtr);
        // ---------- Original Method ----------
        //nativeClear(mPtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.542 -0400", hash_original_method = "47F4DCEEC62F25E97556D9BB3D79B1AA", hash_generated_method = "B04D65183CB60670E84E47F0BE4FEC40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.543 -0400", hash_original_method = "2C861C2E66E6C5ED5AC5356AA16D4AE7", hash_generated_method = "60AF78FFA1FE51ACF0DE2FBB1EC117C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void computeCurrentVelocity(int units) {
        dsTaint.addTaint(units);
        nativeComputeCurrentVelocity(mPtr, units, Float.MAX_VALUE);
        // ---------- Original Method ----------
        //nativeComputeCurrentVelocity(mPtr, units, Float.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.543 -0400", hash_original_method = "AAC1E150F0714A1C0618591FDBA33AD9", hash_generated_method = "C3B16DB3B76EEE4FD9A1F6FE910F7C04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void computeCurrentVelocity(int units, float maxVelocity) {
        dsTaint.addTaint(maxVelocity);
        dsTaint.addTaint(units);
        nativeComputeCurrentVelocity(mPtr, units, maxVelocity);
        // ---------- Original Method ----------
        //nativeComputeCurrentVelocity(mPtr, units, maxVelocity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.543 -0400", hash_original_method = "175B9FF596A60DD4A27A3E2F4F8FB36B", hash_generated_method = "29B2522A0919E20132A5CC346FCFA349")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getXVelocity() {
        float varEF6EB6007A69FA84B157F348BC46F077_1183776821 = (nativeGetXVelocity(mPtr, ACTIVE_POINTER_ID));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetXVelocity(mPtr, ACTIVE_POINTER_ID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.543 -0400", hash_original_method = "7522D7DB1CC0324C793DB225FECF96EF", hash_generated_method = "2315782F641B0904CC0FF62BAE14CA2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getYVelocity() {
        float varA836CE77B04F283B3AE722B99F53A026_1441046477 = (nativeGetYVelocity(mPtr, ACTIVE_POINTER_ID));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetYVelocity(mPtr, ACTIVE_POINTER_ID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.544 -0400", hash_original_method = "E88E46619158ECDA6CFC39862B1412B8", hash_generated_method = "F51D549738EE8AA34BFF1719FA8FAF05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getXVelocity(int id) {
        dsTaint.addTaint(id);
        float var7B1658FD1F00DCF18FF085C070307AFF_1333148793 = (nativeGetXVelocity(mPtr, id));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetXVelocity(mPtr, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.544 -0400", hash_original_method = "3A1681E069274B63F81D41BA2ABBDF60", hash_generated_method = "910CCBCE28EE3F53C76994F145E6E0BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getYVelocity(int id) {
        dsTaint.addTaint(id);
        float varB6CE2C7467D225522F782DC0FFE159B9_1208850293 = (nativeGetYVelocity(mPtr, id));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetYVelocity(mPtr, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.544 -0400", hash_original_method = "53182452353A9C74BE3B46A3229E5647", hash_generated_method = "BB6F5AB1DF904EE986E0E0B64BB421AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getEstimator(int id, int degree, int horizonMillis, Estimator outEstimator) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(degree);
        dsTaint.addTaint(outEstimator.dsTaint);
        dsTaint.addTaint(horizonMillis);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("outEstimator must not be null");
        } //End block
        boolean varB9B431FEE5CF127FE496DD1277AA2E23_209685828 = (nativeGetEstimator(mPtr, id, degree, horizonMillis, outEstimator));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (outEstimator == null) {
            //throw new IllegalArgumentException("outEstimator must not be null");
        //}
        //return nativeGetEstimator(mPtr, id, degree, horizonMillis, outEstimator);
    }

    
    public static final class Estimator {
        public float[] xCoeff = new float[MAX_DEGREE + 1];
        public float[] yCoeff = new float[MAX_DEGREE + 1];
        public int degree;
        public float confidence;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.544 -0400", hash_original_method = "E403BE1E844BC69503AA74DAAF72D37A", hash_generated_method = "E403BE1E844BC69503AA74DAAF72D37A")
                public Estimator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.545 -0400", hash_original_method = "EF4145D98D5D09EB61112BFE6D9F064E", hash_generated_method = "C1269673B931333DCE0544D43D47F5C8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public float estimateX(float time) {
            dsTaint.addTaint(time);
            float varD2F41F7DCCDB33B464FD432116295CA0_92146429 = (estimate(time, xCoeff));
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return estimate(time, xCoeff);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.545 -0400", hash_original_method = "4B57BC9609218FF4FD5DA8FDF96C43D9", hash_generated_method = "5D1FA73D826E8547F7CF8B7A13884B86")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public float estimateY(float time) {
            dsTaint.addTaint(time);
            float varD96A25489895EAFDAB21F43C286C60AD_2092681618 = (estimate(time, yCoeff));
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return estimate(time, yCoeff);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.545 -0400", hash_original_method = "17E8AE405780B4520E14D05EC083CF07", hash_generated_method = "12344387BBE71213A53E0C118E4EBEEF")
        @DSModeled(DSC.SAFE)
        private float estimate(float time, float[] c) {
            dsTaint.addTaint(time);
            dsTaint.addTaint(c[0]);
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

        
        private static final int MAX_DEGREE = 2;
    }


    
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
}

