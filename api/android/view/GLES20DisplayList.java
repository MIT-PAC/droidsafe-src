package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.graphics.Bitmap;





class GLES20DisplayList extends DisplayList {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.968 -0500", hash_original_field = "17A77D319EA2543AEE6DEDC1CDEFB4EA", hash_generated_field = "BB6CBCF49DD2510CC95665D64C80E794")

    // as the DisplayList is alive.  The Bitmaps are populated by the GLES20RecordingCanvas.
    final ArrayList<Bitmap> mBitmaps = new ArrayList<Bitmap>(5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.971 -0500", hash_original_field = "228D9B5C973A3A2FF113899814C2285A", hash_generated_field = "B2F7DA6F3E4A8F7E7A9EA569E557EA23")


    private GLES20RecordingCanvas mCanvas;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.974 -0500", hash_original_field = "ED254D523CA59D4B79795578544CDA27", hash_generated_field = "EA21572F663EFE15B9390D06509A48DD")

    private boolean mValid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.977 -0500", hash_original_field = "5A76FE7ACED42EFB378D229482CCBBCE", hash_generated_field = "413ADECCD4FB0534D1236EA57039E646")

    // DO NOT overwrite this reference once it is set.
    private DisplayListFinalizer mFinalizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.173 -0400", hash_original_method = "AE604D63277D457D456549CB93FF76C1", hash_generated_method = "AE604D63277D457D456549CB93FF76C1")
    public GLES20DisplayList ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.980 -0500", hash_original_method = "95D7EAA4B043B28D3D04F5E259ED8AAD", hash_generated_method = "95D7EAA4B043B28D3D04F5E259ED8AAD")
    
int getNativeDisplayList() {
        if (!mValid || mFinalizer == null) {
            throw new IllegalStateException("The display list is not valid.");
        }
        return mFinalizer.mNativeDisplayList;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.983 -0500", hash_original_method = "E5C596CBDCD8BE3EF1855673907A59B8", hash_generated_method = "08FF9D06F5EF6732D26BE2D0CF420832")
    
@Override
    HardwareCanvas start() {
        if (mCanvas != null) {
            throw new IllegalStateException("Recording has already started");
        }

        mValid = false;
        mCanvas = GLES20RecordingCanvas.obtain(this);
        mCanvas.start();
        return mCanvas;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.985 -0500", hash_original_method = "247D3D8A3D31E91BE5C013DB24963870", hash_generated_method = "D5C134E8BA617FD5E9C3B870609591B2")
    
@Override
    void invalidate() {
        if (mCanvas != null) {
            mCanvas.recycle();
            mCanvas = null;
        }
        mValid = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.987 -0500", hash_original_method = "3D6474677C8929AA6741081CA86616E2", hash_generated_method = "1A8E4178B3ECA5148654C00257679474")
    
@Override
    boolean isValid() {
        return mValid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.990 -0500", hash_original_method = "96CA5C3852449FF9B74309A832926627", hash_generated_method = "5DEFE479F718B276DE361E7B4349A8E4")
    
@Override
    void end() {
        if (mCanvas != null) {
            if (mFinalizer != null) {
                mCanvas.end(mFinalizer.mNativeDisplayList);
            } else {
                mFinalizer = new DisplayListFinalizer(mCanvas.end(0));
            }
            mCanvas.recycle();
            mCanvas = null;
            mValid = true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.993 -0500", hash_original_method = "3E7FC40C3EA5DE4EA51EEDE8E80652F9", hash_generated_method = "E58D98676E92D658A598AEE9912F9C18")
    
@Override
    int getSize() {
        if (mFinalizer == null) return 0;
        return GLES20Canvas.getDisplayListSize(mFinalizer.mNativeDisplayList);
    }

    
    private static class DisplayListFinalizer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.997 -0500", hash_original_field = "79CD38F4DEF89D187CA539E02ADB2412", hash_generated_field = "79CD38F4DEF89D187CA539E02ADB2412")

         int mNativeDisplayList;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.000 -0500", hash_original_method = "0B1B093880262044EED2D5421EB7C8E9", hash_generated_method = "68D89C8E7DBFDAB15F81C1F37DFF77DF")
        
public DisplayListFinalizer(int nativeDisplayList) {
            mNativeDisplayList = nativeDisplayList;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.003 -0500", hash_original_method = "FB7FF5339A61C1A66F37CCF40E62B9AC", hash_generated_method = "49AF9AB9CF1FB4D42D572F6B74BA63B2")
        
@Override
        protected void finalize() throws Throwable {
            try {
                GLES20Canvas.destroyDisplayList(mNativeDisplayList);
            } finally {
                super.finalize();
            }
        }

        
    }


    
}

