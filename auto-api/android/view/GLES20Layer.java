package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Bitmap;

abstract class GLES20Layer extends HardwareLayer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.131 -0400", hash_original_field = "005B4338173753DA1B50DCC47C3EC00C", hash_generated_field = "ADD2D11ABDFD02268E62F53E7A576EE2")

    int mLayer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.131 -0400", hash_original_field = "2D0BC5276619D20C917420C774FF5089", hash_generated_field = "242B64458AFC875825EB34B3C303060F")

    Finalizer mFinalizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.132 -0400", hash_original_method = "FA1FFA78F6EB5DB42F3E3C14749B8FCB", hash_generated_method = "1255CD39DEDE49D084B5750E6B9EDE73")
      GLES20Layer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.132 -0400", hash_original_method = "C152CA876A44487347A67A14265C89C6", hash_generated_method = "4534E650595DA0DC942BDAD9FD2A0406")
      GLES20Layer(int width, int height, boolean opaque) {
        super(width, height, opaque);
        addTaint(width);
        addTaint(height);
        addTaint(opaque);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.132 -0400", hash_original_method = "1433CF09BAF49EB0158C4CBA390321AC", hash_generated_method = "C2E487D5965001FF1B08896B18975413")
    public int getLayer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1605625159 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1605625159;
        // ---------- Original Method ----------
        //return mLayer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.145 -0400", hash_original_method = "EC2EF6564AC27596601815B02E5CA477", hash_generated_method = "6D22CE2CB77543A453B67EE5D58B1A90")
    @Override
     boolean copyInto(Bitmap bitmap) {
        boolean varEC55BFB35E67E16E06C71B1CD1AB44ED_294216462 = (GLES20Canvas.nCopyLayer(mLayer, bitmap.mNativeBitmap));
        addTaint(bitmap.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_591975929 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_591975929;
        // ---------- Original Method ----------
        //return GLES20Canvas.nCopyLayer(mLayer, bitmap.mNativeBitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.145 -0400", hash_original_method = "029DFD798166E5D5C7A45581B8E77BAB", hash_generated_method = "C74A5A46247EB6F60384BF31D8BAEE47")
    @Override
     void update(int width, int height, boolean isOpaque) {
        super.update(width, height, isOpaque);
        addTaint(width);
        addTaint(height);
        addTaint(isOpaque);
        // ---------- Original Method ----------
        //super.update(width, height, isOpaque);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.146 -0400", hash_original_method = "2F5D80F3F3B9905F82317A3BBAA77B2C", hash_generated_method = "6346D82730895C60516FF3631E7DBA11")
    @Override
     void destroy() {
        {
            mFinalizer.destroy();
            mFinalizer = null;
        } //End block
        mLayer = 0;
        // ---------- Original Method ----------
        //if (mFinalizer != null) {
            //mFinalizer.destroy();
            //mFinalizer = null;
        //}
        //mLayer = 0;
    }

    
    static class Finalizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.146 -0400", hash_original_field = "423CC4402F8D3587E875F43ABDF936AA", hash_generated_field = "01A3B0B17EC6AEBA31ACE6507CBA418F")

        private int mLayerId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.146 -0400", hash_original_method = "9B571A83D1A9A17FB8274187B13F16F6", hash_generated_method = "E484AED4E3A97A093A8B77A02284ED4A")
        public  Finalizer(int layerId) {
            mLayerId = layerId;
            // ---------- Original Method ----------
            //mLayerId = layerId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.146 -0400", hash_original_method = "C9B02BF326BE144CFBB3A19B3133BF7D", hash_generated_method = "3B6917F3640F4F64E852D142EA786AC3")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                {
                    GLES20Canvas.nDestroyLayerDeferred(mLayerId);
                } //End block
            } //End block
            finally 
            {
                super.finalize();
            } //End block
            // ---------- Original Method ----------
            //try {
                //if (mLayerId != 0) {
                    //GLES20Canvas.nDestroyLayerDeferred(mLayerId);
                //}
            //} finally {
                //super.finalize();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.147 -0400", hash_original_method = "7590F3F5AEB9FFE0334022A0C3C47C46", hash_generated_method = "FCB6BE9C7071D9FEDE0DFAB107D26AE6")
         void destroy() {
            GLES20Canvas.nDestroyLayer(mLayerId);
            mLayerId = 0;
            // ---------- Original Method ----------
            //GLES20Canvas.nDestroyLayer(mLayerId);
            //mLayerId = 0;
        }

        
    }


    
}

