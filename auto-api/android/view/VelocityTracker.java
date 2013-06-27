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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.692 -0400", hash_original_field = "34F930F150EAEEFF27D6C0C8E4629911", hash_generated_field = "E9A8054C2C57C0CE861FDCA982433D1A")

    private int mPtr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.692 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "5B4B8EC4C61CE05CF5BB2F5E71D6C6C3")

    private VelocityTracker mNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.692 -0400", hash_original_field = "224D05F4261498DA1D9DF38424832532", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

    private boolean mIsPooled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.692 -0400", hash_original_method = "F7334C8DF7CFD0702F8B319FC0AAEBEC", hash_generated_method = "D85E3DAABC499710A355B9A59E327BBA")
    private  VelocityTracker() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.708 -0400", hash_original_method = "E0F67E3C99A5EE80DA0668A59C0EFAE4", hash_generated_method = "0846A8ED2E43BFFDC09D1A7A77AFC8B7")
    public void recycle() {
        sPool.release(this);
        // ---------- Original Method ----------
        //sPool.release(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.708 -0400", hash_original_method = "2CC1A1BE49EC62DFF418BB32459396A9", hash_generated_method = "74AE9F16F0DD1BBCC61D5A9BA8889C0C")
    public void setNextPoolable(VelocityTracker element) {
        mNext = element;
        // ---------- Original Method ----------
        //mNext = element;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.709 -0400", hash_original_method = "DEA3C3D2ED346DE60DC91CC9918022D0", hash_generated_method = "359F553167049F04F5E82CAF76821DA8")
    public VelocityTracker getNextPoolable() {
        VelocityTracker varB4EAC82CA7396A68D541C85D26508E83_1552283631 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1552283631 = mNext;
        varB4EAC82CA7396A68D541C85D26508E83_1552283631.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1552283631;
        // ---------- Original Method ----------
        //return mNext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.709 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "44BF334B1FCCD82A7943013EEC1E155A")
    public boolean isPooled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821101027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_821101027;
        // ---------- Original Method ----------
        //return mIsPooled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.710 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "31CEC37D69D770078DC2E4A0F4797B2A")
    public void setPooled(boolean isPooled) {
        mIsPooled = isPooled;
        // ---------- Original Method ----------
        //mIsPooled = isPooled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.710 -0400", hash_original_method = "388B6019F11DE2E32EE5A9A9056EF526", hash_generated_method = "67860CE34A62351A9262D687B4539116")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.710 -0400", hash_original_method = "3EB8DC396E0D228312A300339405C305", hash_generated_method = "E72C8D02D6D5031CDDA2CF440FD3B4C9")
    public void clear() {
        nativeClear(mPtr);
        // ---------- Original Method ----------
        //nativeClear(mPtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.717 -0400", hash_original_method = "47F4DCEEC62F25E97556D9BB3D79B1AA", hash_generated_method = "CD616A172A9FFB7D428464500E045924")
    public void addMovement(MotionEvent event) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("event must not be null");
        } //End block
        nativeAddMovement(mPtr, event);
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //if (event == null) {
            //throw new IllegalArgumentException("event must not be null");
        //}
        //nativeAddMovement(mPtr, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.718 -0400", hash_original_method = "2C861C2E66E6C5ED5AC5356AA16D4AE7", hash_generated_method = "BBF9490F7CF1E53129DB46E631BD4CBF")
    public void computeCurrentVelocity(int units) {
        nativeComputeCurrentVelocity(mPtr, units, Float.MAX_VALUE);
        addTaint(units);
        // ---------- Original Method ----------
        //nativeComputeCurrentVelocity(mPtr, units, Float.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.718 -0400", hash_original_method = "AAC1E150F0714A1C0618591FDBA33AD9", hash_generated_method = "CB99D8FC95D8490A5FD5988BF36A10AB")
    public void computeCurrentVelocity(int units, float maxVelocity) {
        nativeComputeCurrentVelocity(mPtr, units, maxVelocity);
        addTaint(units);
        addTaint(maxVelocity);
        // ---------- Original Method ----------
        //nativeComputeCurrentVelocity(mPtr, units, maxVelocity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.718 -0400", hash_original_method = "175B9FF596A60DD4A27A3E2F4F8FB36B", hash_generated_method = "D15AB4D506C606D83BB49DD10033FB30")
    public float getXVelocity() {
        float varEF6EB6007A69FA84B157F348BC46F077_1743472462 = (nativeGetXVelocity(mPtr, ACTIVE_POINTER_ID));
        float var546ADE640B6EDFBC8A086EF31347E768_623240574 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_623240574;
        // ---------- Original Method ----------
        //return nativeGetXVelocity(mPtr, ACTIVE_POINTER_ID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.719 -0400", hash_original_method = "7522D7DB1CC0324C793DB225FECF96EF", hash_generated_method = "4AD5BE851EF62139A03787B7F33147D9")
    public float getYVelocity() {
        float varA836CE77B04F283B3AE722B99F53A026_1705515997 = (nativeGetYVelocity(mPtr, ACTIVE_POINTER_ID));
        float var546ADE640B6EDFBC8A086EF31347E768_150036435 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_150036435;
        // ---------- Original Method ----------
        //return nativeGetYVelocity(mPtr, ACTIVE_POINTER_ID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.719 -0400", hash_original_method = "E88E46619158ECDA6CFC39862B1412B8", hash_generated_method = "04E6582A7D72763D956C6A9F42D6CD63")
    public float getXVelocity(int id) {
        float var7B1658FD1F00DCF18FF085C070307AFF_1401410450 = (nativeGetXVelocity(mPtr, id));
        addTaint(id);
        float var546ADE640B6EDFBC8A086EF31347E768_1441538188 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1441538188;
        // ---------- Original Method ----------
        //return nativeGetXVelocity(mPtr, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.719 -0400", hash_original_method = "3A1681E069274B63F81D41BA2ABBDF60", hash_generated_method = "055C88BAD35A447C8768EE1D3CB1F8E0")
    public float getYVelocity(int id) {
        float varB6CE2C7467D225522F782DC0FFE159B9_1587825260 = (nativeGetYVelocity(mPtr, id));
        addTaint(id);
        float var546ADE640B6EDFBC8A086EF31347E768_1173373185 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1173373185;
        // ---------- Original Method ----------
        //return nativeGetYVelocity(mPtr, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.731 -0400", hash_original_method = "53182452353A9C74BE3B46A3229E5647", hash_generated_method = "B93C6B00A5F95C87B7113F7E848F05A8")
    public boolean getEstimator(int id, int degree, int horizonMillis, Estimator outEstimator) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("outEstimator must not be null");
        } //End block
        boolean varB9B431FEE5CF127FE496DD1277AA2E23_1407650584 = (nativeGetEstimator(mPtr, id, degree, horizonMillis, outEstimator));
        addTaint(id);
        addTaint(degree);
        addTaint(horizonMillis);
        addTaint(outEstimator.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2018743815 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2018743815;
        // ---------- Original Method ----------
        //if (outEstimator == null) {
            //throw new IllegalArgumentException("outEstimator must not be null");
        //}
        //return nativeGetEstimator(mPtr, id, degree, horizonMillis, outEstimator);
    }

    
    public static final class Estimator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.731 -0400", hash_original_field = "F912F76B126AAE00981054A0E1B74B9E", hash_generated_field = "61DA8F5CEF6813A46E4848AB215FB7FC")

        public float[] xCoeff = new float[MAX_DEGREE + 1];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.731 -0400", hash_original_field = "917AB8BA1B6C7A079A777F441F7E0131", hash_generated_field = "480F859A6490FEB0D5736DA11D90A335")

        public float[] yCoeff = new float[MAX_DEGREE + 1];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.731 -0400", hash_original_field = "FB81C91EB92D6CB64AEB64C3F37EF2C4", hash_generated_field = "A21FC26B54D92E07E39E10EA3DEF93F3")

        public int degree;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.731 -0400", hash_original_field = "8BF91B0F43DDF159ED36AD0F50EE3E04", hash_generated_field = "9300AFCF844D22EA28DB8E928CFE60EB")

        public float confidence;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.731 -0400", hash_original_method = "3C04CD9D0E5CF8A244AF16BC346C84B6", hash_generated_method = "3C04CD9D0E5CF8A244AF16BC346C84B6")
        public Estimator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.732 -0400", hash_original_method = "EF4145D98D5D09EB61112BFE6D9F064E", hash_generated_method = "ED106BFF88596598A90ADCFD94F1CADB")
        public float estimateX(float time) {
            float varD2F41F7DCCDB33B464FD432116295CA0_1775309426 = (estimate(time, xCoeff));
            addTaint(time);
            float var546ADE640B6EDFBC8A086EF31347E768_795915161 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_795915161;
            // ---------- Original Method ----------
            //return estimate(time, xCoeff);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.732 -0400", hash_original_method = "4B57BC9609218FF4FD5DA8FDF96C43D9", hash_generated_method = "A103F4AE42ED1BF5CCE6BE648A7139C6")
        public float estimateY(float time) {
            float varD96A25489895EAFDAB21F43C286C60AD_654369704 = (estimate(time, yCoeff));
            addTaint(time);
            float var546ADE640B6EDFBC8A086EF31347E768_1077469495 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1077469495;
            // ---------- Original Method ----------
            //return estimate(time, yCoeff);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.733 -0400", hash_original_method = "17E8AE405780B4520E14D05EC083CF07", hash_generated_method = "30BA4BEE984AF5C2D92913B44690F38E")
        private float estimate(float time, float[] c) {
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
            addTaint(time);
            addTaint(c[0]);
            float var546ADE640B6EDFBC8A086EF31347E768_1262129845 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1262129845;
            // ---------- Original Method ----------
            //float a = 0;
            //float scale = 1;
            //for (int i = 0; i <= degree; i++) {
                //a += c[i] * scale;
                //scale *= time;
            //}
            //return a;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.733 -0400", hash_original_field = "A54F523E6A7DF5613B641195F2A7AF2B", hash_generated_field = "2907B8D670A69B2663312E1AD6A6B7E9")

        private static int MAX_DEGREE = 2;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.733 -0400", hash_original_field = "7D322AC6B02AE1303D1EE66F45C4A4CD", hash_generated_field = "5A476611E66F2F82DDD196D1A394CC9F")

    private static Pool<VelocityTracker> sPool = Pools.synchronizedPool(
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.733 -0400", hash_original_field = "B23005BED9309443B0ABD014F4C6507F", hash_generated_field = "9C60E6F0DC418C96025261ABA72B512D")

    private static int ACTIVE_POINTER_ID = -1;
}

