package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;

abstract class GLES20Layer extends HardwareLayer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.983 -0400", hash_original_field = "005B4338173753DA1B50DCC47C3EC00C", hash_generated_field = "ADD2D11ABDFD02268E62F53E7A576EE2")

    int mLayer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.983 -0400", hash_original_field = "2D0BC5276619D20C917420C774FF5089", hash_generated_field = "242B64458AFC875825EB34B3C303060F")

    Finalizer mFinalizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.983 -0400", hash_original_method = "FA1FFA78F6EB5DB42F3E3C14749B8FCB", hash_generated_method = "1255CD39DEDE49D084B5750E6B9EDE73")
      GLES20Layer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.983 -0400", hash_original_method = "C152CA876A44487347A67A14265C89C6", hash_generated_method = "6946263A499B9744BB8EBB113F604330")
      GLES20Layer(int width, int height, boolean opaque) {
        super(width, height, opaque);
        addTaint(opaque);
        addTaint(height);
        addTaint(width);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.983 -0400", hash_original_method = "1433CF09BAF49EB0158C4CBA390321AC", hash_generated_method = "82085099D0E6A4B13361E56187376929")
    public int getLayer() {
        int var005B4338173753DA1B50DCC47C3EC00C_156292498 = (mLayer);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_333326400 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_333326400;
        // ---------- Original Method ----------
        //return mLayer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.984 -0400", hash_original_method = "EC2EF6564AC27596601815B02E5CA477", hash_generated_method = "E3C35F0B3A8847B3F0B5674D16B42B53")
    @Override
     boolean copyInto(Bitmap bitmap) {
        addTaint(bitmap.getTaint());
        boolean varCBDFBDC0E0B084E5B0498EB09AFEF4D8_187234751 = (GLES20Canvas.nCopyLayer(mLayer, bitmap.mNativeBitmap));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1916324556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1916324556;
        // ---------- Original Method ----------
        //return GLES20Canvas.nCopyLayer(mLayer, bitmap.mNativeBitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.984 -0400", hash_original_method = "029DFD798166E5D5C7A45581B8E77BAB", hash_generated_method = "85D5A6199DD21C8291897461B969B8A5")
    @Override
     void update(int width, int height, boolean isOpaque) {
        addTaint(isOpaque);
        addTaint(height);
        addTaint(width);
        super.update(width, height, isOpaque);
        // ---------- Original Method ----------
        //super.update(width, height, isOpaque);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.984 -0400", hash_original_method = "2F5D80F3F3B9905F82317A3BBAA77B2C", hash_generated_method = "C536F96D6D7D11E400EB516A9CD04970")
    @Override
     void destroy() {
    if(mFinalizer != null)        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.985 -0400", hash_original_field = "423CC4402F8D3587E875F43ABDF936AA", hash_generated_field = "01A3B0B17EC6AEBA31ACE6507CBA418F")

        private int mLayerId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.985 -0400", hash_original_method = "9B571A83D1A9A17FB8274187B13F16F6", hash_generated_method = "E484AED4E3A97A093A8B77A02284ED4A")
        public  Finalizer(int layerId) {
            mLayerId = layerId;
            // ---------- Original Method ----------
            //mLayerId = layerId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.985 -0400", hash_original_method = "C9B02BF326BE144CFBB3A19B3133BF7D", hash_generated_method = "8A44B6F007F325C4D91D392ADD98C1FE")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
    if(mLayerId != 0)                
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.986 -0400", hash_original_method = "7590F3F5AEB9FFE0334022A0C3C47C46", hash_generated_method = "FCB6BE9C7071D9FEDE0DFAB107D26AE6")
         void destroy() {
            GLES20Canvas.nDestroyLayer(mLayerId);
            mLayerId = 0;
            // ---------- Original Method ----------
            //GLES20Canvas.nDestroyLayer(mLayerId);
            //mLayerId = 0;
        }

        
    }


    
}

