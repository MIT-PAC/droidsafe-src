package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Bitmap;





abstract class GLES20Layer extends HardwareLayer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.058 -0500", hash_original_field = "ADD2D11ABDFD02268E62F53E7A576EE2", hash_generated_field = "ADD2D11ABDFD02268E62F53E7A576EE2")

    int mLayer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.060 -0500", hash_original_field = "242B64458AFC875825EB34B3C303060F", hash_generated_field = "242B64458AFC875825EB34B3C303060F")

    Finalizer mFinalizer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.062 -0500", hash_original_method = "FA1FFA78F6EB5DB42F3E3C14749B8FCB", hash_generated_method = "FA1FFA78F6EB5DB42F3E3C14749B8FCB")
    
GLES20Layer() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.064 -0500", hash_original_method = "C152CA876A44487347A67A14265C89C6", hash_generated_method = "C152CA876A44487347A67A14265C89C6")
    
GLES20Layer(int width, int height, boolean opaque) {
        super(width, height, opaque);
    }

    /**
     * Returns the native layer object used to render this layer.
     * 
     * @return A pointer to the native layer object, or 0 if the object is NULL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.067 -0500", hash_original_method = "1433CF09BAF49EB0158C4CBA390321AC", hash_generated_method = "100FF04436870172DF760F03F5BFF8CA")
    
public int getLayer() {
        return mLayer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.070 -0500", hash_original_method = "EC2EF6564AC27596601815B02E5CA477", hash_generated_method = "A11FE97EF0FFEF3F2D1D1B6A991C272E")
    
@Override
    boolean copyInto(Bitmap bitmap) {
        return GLES20Canvas.nCopyLayer(mLayer, bitmap.mNativeBitmap);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.072 -0500", hash_original_method = "029DFD798166E5D5C7A45581B8E77BAB", hash_generated_method = "A3B6DCDAD2B66945895B14984FA2EF45")
    
@Override
    void update(int width, int height, boolean isOpaque) {
        super.update(width, height, isOpaque);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.075 -0500", hash_original_method = "2F5D80F3F3B9905F82317A3BBAA77B2C", hash_generated_method = "42C089A63F237766C246D0EAFFAC4F5F")
    
@Override
    void destroy() {
        if (mFinalizer != null) {
            mFinalizer.destroy();
            mFinalizer = null;
        }
        mLayer = 0;
    }

    
    static class Finalizer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.077 -0500", hash_original_field = "87B98882F1AA0DC12DBEC859DA06C635", hash_generated_field = "01A3B0B17EC6AEBA31ACE6507CBA418F")

        private int mLayerId;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.080 -0500", hash_original_method = "9B571A83D1A9A17FB8274187B13F16F6", hash_generated_method = "4579FCB6C842AE54006B606C0A592577")
        
public Finalizer(int layerId) {
            mLayerId = layerId;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.083 -0500", hash_original_method = "C9B02BF326BE144CFBB3A19B3133BF7D", hash_generated_method = "5A830126B201B9DDD9368FECF93ACBAE")
        
@Override
        protected void finalize() throws Throwable {
            try {
                if (mLayerId != 0) {
                    GLES20Canvas.nDestroyLayerDeferred(mLayerId);
                }
            } finally {
                super.finalize();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.085 -0500", hash_original_method = "7590F3F5AEB9FFE0334022A0C3C47C46", hash_generated_method = "7590F3F5AEB9FFE0334022A0C3C47C46")
        
void destroy() {
            GLES20Canvas.nDestroyLayer(mLayerId);
            mLayerId = 0;
        }

        
    }


    
}

