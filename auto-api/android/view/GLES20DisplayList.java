package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Bitmap;
import java.util.ArrayList;

class GLES20DisplayList extends DisplayList {
    ArrayList<Bitmap> mBitmaps = new ArrayList<Bitmap>(5);
    private GLES20RecordingCanvas mCanvas;
    private boolean mValid;
    private DisplayListFinalizer mFinalizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.657 -0400", hash_original_method = "09CDC468F422A51E6713E8DD778C8B0C", hash_generated_method = "09CDC468F422A51E6713E8DD778C8B0C")
        public GLES20DisplayList ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.657 -0400", hash_original_method = "95D7EAA4B043B28D3D04F5E259ED8AAD", hash_generated_method = "7650402DC31E7E5CD2D82CA9123CB53D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getNativeDisplayList() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The display list is not valid.");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!mValid || mFinalizer == null) {
            //throw new IllegalStateException("The display list is not valid.");
        //}
        //return mFinalizer.mNativeDisplayList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.657 -0400", hash_original_method = "E5C596CBDCD8BE3EF1855673907A59B8", hash_generated_method = "1A4B6AD489DD69EF53C8D4A308AF4A45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     HardwareCanvas start() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Recording has already started");
        } //End block
        mValid = false;
        mCanvas = GLES20RecordingCanvas.obtain(this);
        mCanvas.start();
        return (HardwareCanvas)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mCanvas != null) {
            //throw new IllegalStateException("Recording has already started");
        //}
        //mValid = false;
        //mCanvas = GLES20RecordingCanvas.obtain(this);
        //mCanvas.start();
        //return mCanvas;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.658 -0400", hash_original_method = "247D3D8A3D31E91BE5C013DB24963870", hash_generated_method = "EA0C6AC66F1D1B0276B44C5AF04F5131")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void invalidate() {
        {
            mCanvas.recycle();
            mCanvas = null;
        } //End block
        mValid = false;
        // ---------- Original Method ----------
        //if (mCanvas != null) {
            //mCanvas.recycle();
            //mCanvas = null;
        //}
        //mValid = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.658 -0400", hash_original_method = "3D6474677C8929AA6741081CA86616E2", hash_generated_method = "CA1098F1D6206033D7115659A0720438")
    @DSModeled(DSC.SAFE)
    @Override
     boolean isValid() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mValid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.658 -0400", hash_original_method = "96CA5C3852449FF9B74309A832926627", hash_generated_method = "42A3030B4F1EA00DB634A100334DEBA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void end() {
        {
            {
                mCanvas.end(mFinalizer.mNativeDisplayList);
            } //End block
            {
                mFinalizer = new DisplayListFinalizer(mCanvas.end(0));
            } //End block
            mCanvas.recycle();
            mCanvas = null;
            mValid = true;
        } //End block
        // ---------- Original Method ----------
        //if (mCanvas != null) {
            //if (mFinalizer != null) {
                //mCanvas.end(mFinalizer.mNativeDisplayList);
            //} else {
                //mFinalizer = new DisplayListFinalizer(mCanvas.end(0));
            //}
            //mCanvas.recycle();
            //mCanvas = null;
            //mValid = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.658 -0400", hash_original_method = "3E7FC40C3EA5DE4EA51EEDE8E80652F9", hash_generated_method = "561A57C8C6CBC96EACFDDBB631DAE927")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     int getSize() {
        int varB2890EA812AE28FA4D154D7F2D962AEF_603788569 = (GLES20Canvas.getDisplayListSize(mFinalizer.mNativeDisplayList));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mFinalizer == null) return 0;
        //return GLES20Canvas.getDisplayListSize(mFinalizer.mNativeDisplayList);
    }

    
    private static class DisplayListFinalizer {
        int mNativeDisplayList;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.659 -0400", hash_original_method = "0B1B093880262044EED2D5421EB7C8E9", hash_generated_method = "A699B138E80BBA661BC200DEF638DAAC")
        @DSModeled(DSC.SAFE)
        public DisplayListFinalizer(int nativeDisplayList) {
            dsTaint.addTaint(nativeDisplayList);
            // ---------- Original Method ----------
            //mNativeDisplayList = nativeDisplayList;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.659 -0400", hash_original_method = "FB7FF5339A61C1A66F37CCF40E62B9AC", hash_generated_method = "E7681B50DE99CA561B64705CC62CB068")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                GLES20Canvas.destroyDisplayList(mNativeDisplayList);
            } //End block
            finally 
            {
                super.finalize();
            } //End block
            // ---------- Original Method ----------
            //try {
                //GLES20Canvas.destroyDisplayList(mNativeDisplayList);
            //} finally {
                //super.finalize();
            //}
        }

        
    }


    
}

