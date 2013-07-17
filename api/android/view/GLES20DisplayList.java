package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import java.util.ArrayList;

class GLES20DisplayList extends DisplayList {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.173 -0400", hash_original_field = "D40867AE35FD7434138AD06437D816AD", hash_generated_field = "43DF9227571FB6A174765DA4CC1A8056")

    final ArrayList<Bitmap> mBitmaps = new ArrayList<Bitmap>(5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.173 -0400", hash_original_field = "B27B52DEE91FF1260919C0152F8A3F5A", hash_generated_field = "B2F7DA6F3E4A8F7E7A9EA569E557EA23")

    private GLES20RecordingCanvas mCanvas;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.173 -0400", hash_original_field = "AB06C0B5FE02AF09E4F911D76AAEE4B2", hash_generated_field = "EA21572F663EFE15B9390D06509A48DD")

    private boolean mValid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.173 -0400", hash_original_field = "2D0BC5276619D20C917420C774FF5089", hash_generated_field = "CE668A6A9F47BC4EB8C56E4B4F351717")

    private DisplayListFinalizer mFinalizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.173 -0400", hash_original_method = "AE604D63277D457D456549CB93FF76C1", hash_generated_method = "AE604D63277D457D456549CB93FF76C1")
    public GLES20DisplayList ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.173 -0400", hash_original_method = "95D7EAA4B043B28D3D04F5E259ED8AAD", hash_generated_method = "08A5F1B0EC3DD95217F8E0510AB93174")
     int getNativeDisplayList() {
        if(!mValid || mFinalizer == null)        
        {
            IllegalStateException var06213F52B8ACA3D2AEADB12DC5DE2AD4_779247872 = new IllegalStateException("The display list is not valid.");
            var06213F52B8ACA3D2AEADB12DC5DE2AD4_779247872.addTaint(taint);
            throw var06213F52B8ACA3D2AEADB12DC5DE2AD4_779247872;
        } //End block
        int varDBB802A0B6A30849748EBD456BC6D92D_1310913616 = (mFinalizer.mNativeDisplayList);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261594914 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261594914;
        // ---------- Original Method ----------
        //if (!mValid || mFinalizer == null) {
            //throw new IllegalStateException("The display list is not valid.");
        //}
        //return mFinalizer.mNativeDisplayList;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.173 -0400", hash_original_method = "E5C596CBDCD8BE3EF1855673907A59B8", hash_generated_method = "3F41CD41B2466E75C8F5253BCB08572C")
    @Override
     HardwareCanvas start() {
        if(mCanvas != null)        
        {
            IllegalStateException varE1235A2E7A59005DC28786550630B7BD_3997826 = new IllegalStateException("Recording has already started");
            varE1235A2E7A59005DC28786550630B7BD_3997826.addTaint(taint);
            throw varE1235A2E7A59005DC28786550630B7BD_3997826;
        } //End block
        mValid = false;
        mCanvas = GLES20RecordingCanvas.obtain(this);
        mCanvas.start();
HardwareCanvas var3AB98B3CCAF89A85C04BAFF3A3FCA5C1_1336634008 =         mCanvas;
        var3AB98B3CCAF89A85C04BAFF3A3FCA5C1_1336634008.addTaint(taint);
        return var3AB98B3CCAF89A85C04BAFF3A3FCA5C1_1336634008;
        // ---------- Original Method ----------
        //if (mCanvas != null) {
            //throw new IllegalStateException("Recording has already started");
        //}
        //mValid = false;
        //mCanvas = GLES20RecordingCanvas.obtain(this);
        //mCanvas.start();
        //return mCanvas;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.173 -0400", hash_original_method = "247D3D8A3D31E91BE5C013DB24963870", hash_generated_method = "5324511ABE521DB3D2590643621BE97D")
    @Override
     void invalidate() {
        if(mCanvas != null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.173 -0400", hash_original_method = "3D6474677C8929AA6741081CA86616E2", hash_generated_method = "78003B0FE4160167B9AFF27A34C8A78C")
    @Override
     boolean isValid() {
        boolean varAB06C0B5FE02AF09E4F911D76AAEE4B2_7295560 = (mValid);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1611815074 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1611815074;
        // ---------- Original Method ----------
        //return mValid;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.174 -0400", hash_original_method = "96CA5C3852449FF9B74309A832926627", hash_generated_method = "233B6BDCB06001155F9BF184EA762713")
    @Override
     void end() {
        if(mCanvas != null)        
        {
            if(mFinalizer != null)            
            {
                mCanvas.end(mFinalizer.mNativeDisplayList);
            } //End block
            else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.174 -0400", hash_original_method = "3E7FC40C3EA5DE4EA51EEDE8E80652F9", hash_generated_method = "994FFC97A43516E544CAE96680E92B76")
    @Override
     int getSize() {
        if(mFinalizer == null)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_927244020 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900720493 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900720493;
        }
        int varEE53FC709F4FAB92B6A4D13DAC062304_1527352428 = (GLES20Canvas.getDisplayListSize(mFinalizer.mNativeDisplayList));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1498681216 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1498681216;
        // ---------- Original Method ----------
        //if (mFinalizer == null) return 0;
        //return GLES20Canvas.getDisplayListSize(mFinalizer.mNativeDisplayList);
    }

    
    private static class DisplayListFinalizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.174 -0400", hash_original_field = "18F4097D685B19CE7DD654C13CA0EBEA", hash_generated_field = "79CD38F4DEF89D187CA539E02ADB2412")

        int mNativeDisplayList;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.174 -0400", hash_original_method = "0B1B093880262044EED2D5421EB7C8E9", hash_generated_method = "DAAE4ADD86F9B0F97F318309228FD8AA")
        public  DisplayListFinalizer(int nativeDisplayList) {
            mNativeDisplayList = nativeDisplayList;
            // ---------- Original Method ----------
            //mNativeDisplayList = nativeDisplayList;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.175 -0400", hash_original_method = "FB7FF5339A61C1A66F37CCF40E62B9AC", hash_generated_method = "E7681B50DE99CA561B64705CC62CB068")
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

