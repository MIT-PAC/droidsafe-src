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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.772 -0400", hash_original_field = "D40867AE35FD7434138AD06437D816AD", hash_generated_field = "17A77D319EA2543AEE6DEDC1CDEFB4EA")

    ArrayList<Bitmap> mBitmaps = new ArrayList<Bitmap>(5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.772 -0400", hash_original_field = "B27B52DEE91FF1260919C0152F8A3F5A", hash_generated_field = "B2F7DA6F3E4A8F7E7A9EA569E557EA23")

    private GLES20RecordingCanvas mCanvas;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.772 -0400", hash_original_field = "AB06C0B5FE02AF09E4F911D76AAEE4B2", hash_generated_field = "EA21572F663EFE15B9390D06509A48DD")

    private boolean mValid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.773 -0400", hash_original_field = "2D0BC5276619D20C917420C774FF5089", hash_generated_field = "CE668A6A9F47BC4EB8C56E4B4F351717")

    private DisplayListFinalizer mFinalizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.773 -0400", hash_original_method = "AE604D63277D457D456549CB93FF76C1", hash_generated_method = "AE604D63277D457D456549CB93FF76C1")
    public GLES20DisplayList ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.773 -0400", hash_original_method = "95D7EAA4B043B28D3D04F5E259ED8AAD", hash_generated_method = "B4CD08FB316884ED55E1996C0A7A572C")
     int getNativeDisplayList() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The display list is not valid.");
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1528452050 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1528452050;
        // ---------- Original Method ----------
        //if (!mValid || mFinalizer == null) {
            //throw new IllegalStateException("The display list is not valid.");
        //}
        //return mFinalizer.mNativeDisplayList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.786 -0400", hash_original_method = "E5C596CBDCD8BE3EF1855673907A59B8", hash_generated_method = "4101EE1720C508B95CCCC143D3A11B33")
    @Override
     HardwareCanvas start() {
        HardwareCanvas varB4EAC82CA7396A68D541C85D26508E83_519496850 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Recording has already started");
        } //End block
        mValid = false;
        mCanvas = GLES20RecordingCanvas.obtain(this);
        mCanvas.start();
        varB4EAC82CA7396A68D541C85D26508E83_519496850 = mCanvas;
        varB4EAC82CA7396A68D541C85D26508E83_519496850.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_519496850;
        // ---------- Original Method ----------
        //if (mCanvas != null) {
            //throw new IllegalStateException("Recording has already started");
        //}
        //mValid = false;
        //mCanvas = GLES20RecordingCanvas.obtain(this);
        //mCanvas.start();
        //return mCanvas;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.786 -0400", hash_original_method = "247D3D8A3D31E91BE5C013DB24963870", hash_generated_method = "EA0C6AC66F1D1B0276B44C5AF04F5131")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.792 -0400", hash_original_method = "3D6474677C8929AA6741081CA86616E2", hash_generated_method = "F2D1F5D053633797EB0CAC215F951CA0")
    @Override
     boolean isValid() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_916388144 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_916388144;
        // ---------- Original Method ----------
        //return mValid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.792 -0400", hash_original_method = "96CA5C3852449FF9B74309A832926627", hash_generated_method = "42A3030B4F1EA00DB634A100334DEBA0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.793 -0400", hash_original_method = "3E7FC40C3EA5DE4EA51EEDE8E80652F9", hash_generated_method = "CA8BB071F6572C6A4A2CB4B9BA74B0B4")
    @Override
     int getSize() {
        int varB2890EA812AE28FA4D154D7F2D962AEF_206937319 = (GLES20Canvas.getDisplayListSize(mFinalizer.mNativeDisplayList));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132644408 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132644408;
        // ---------- Original Method ----------
        //if (mFinalizer == null) return 0;
        //return GLES20Canvas.getDisplayListSize(mFinalizer.mNativeDisplayList);
    }

    
    private static class DisplayListFinalizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.793 -0400", hash_original_field = "18F4097D685B19CE7DD654C13CA0EBEA", hash_generated_field = "79CD38F4DEF89D187CA539E02ADB2412")

        int mNativeDisplayList;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.794 -0400", hash_original_method = "0B1B093880262044EED2D5421EB7C8E9", hash_generated_method = "DAAE4ADD86F9B0F97F318309228FD8AA")
        public  DisplayListFinalizer(int nativeDisplayList) {
            mNativeDisplayList = nativeDisplayList;
            // ---------- Original Method ----------
            //mNativeDisplayList = nativeDisplayList;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.794 -0400", hash_original_method = "FB7FF5339A61C1A66F37CCF40E62B9AC", hash_generated_method = "E7681B50DE99CA561B64705CC62CB068")
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

