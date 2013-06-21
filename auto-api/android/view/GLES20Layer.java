package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Bitmap;

abstract class GLES20Layer extends HardwareLayer {
    int mLayer;
    Finalizer mFinalizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.662 -0400", hash_original_method = "FA1FFA78F6EB5DB42F3E3C14749B8FCB", hash_generated_method = "1255CD39DEDE49D084B5750E6B9EDE73")
    @DSModeled(DSC.SAFE)
     GLES20Layer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.662 -0400", hash_original_method = "C152CA876A44487347A67A14265C89C6", hash_generated_method = "F4B46BA5FE597132DAE93D6A8DA45E6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     GLES20Layer(int width, int height, boolean opaque) {
        super(width, height, opaque);
        dsTaint.addTaint(height);
        dsTaint.addTaint(opaque);
        dsTaint.addTaint(width);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.663 -0400", hash_original_method = "1433CF09BAF49EB0158C4CBA390321AC", hash_generated_method = "186E986AC6D685240593AA4D236CF7CF")
    @DSModeled(DSC.SAFE)
    public int getLayer() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLayer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.663 -0400", hash_original_method = "EC2EF6564AC27596601815B02E5CA477", hash_generated_method = "1BDC8BF9C549C35DEAA95C1B3AA28564")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     boolean copyInto(Bitmap bitmap) {
        dsTaint.addTaint(bitmap.dsTaint);
        boolean varEC55BFB35E67E16E06C71B1CD1AB44ED_1914231155 = (GLES20Canvas.nCopyLayer(mLayer, bitmap.mNativeBitmap));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return GLES20Canvas.nCopyLayer(mLayer, bitmap.mNativeBitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.663 -0400", hash_original_method = "029DFD798166E5D5C7A45581B8E77BAB", hash_generated_method = "2182FD47BD839102A3F38518212938B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void update(int width, int height, boolean isOpaque) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(isOpaque);
        super.update(width, height, isOpaque);
        // ---------- Original Method ----------
        //super.update(width, height, isOpaque);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.663 -0400", hash_original_method = "2F5D80F3F3B9905F82317A3BBAA77B2C", hash_generated_method = "6346D82730895C60516FF3631E7DBA11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        private int mLayerId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.664 -0400", hash_original_method = "9B571A83D1A9A17FB8274187B13F16F6", hash_generated_method = "BADF2D499437BB4B5936AF42CDFB69B4")
        @DSModeled(DSC.SAFE)
        public Finalizer(int layerId) {
            dsTaint.addTaint(layerId);
            // ---------- Original Method ----------
            //mLayerId = layerId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.664 -0400", hash_original_method = "C9B02BF326BE144CFBB3A19B3133BF7D", hash_generated_method = "3B6917F3640F4F64E852D142EA786AC3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.664 -0400", hash_original_method = "7590F3F5AEB9FFE0334022A0C3C47C46", hash_generated_method = "FCB6BE9C7071D9FEDE0DFAB107D26AE6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void destroy() {
            GLES20Canvas.nDestroyLayer(mLayerId);
            mLayerId = 0;
            // ---------- Original Method ----------
            //GLES20Canvas.nDestroyLayer(mLayerId);
            //mLayerId = 0;
        }

        
    }


    
}

