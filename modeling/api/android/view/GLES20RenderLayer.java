package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Canvas;
import android.graphics.Matrix;

class GLES20RenderLayer extends GLES20Layer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.028 -0500", hash_original_field = "C23E57C45D6013374D81287F280959A0", hash_generated_field = "6CE69E33D331522DEEDAAE7DFC370CEC")

    private int mLayerWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.031 -0500", hash_original_field = "40DD04AA42E431ED4338A605EF8D010F", hash_generated_field = "9447103C7619FC9FCAB4543B13DECB8F")

    private int mLayerHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.034 -0500", hash_original_field = "2E009C2898BBCB66E6B9427FBFE1DA4A", hash_generated_field = "16F4A35E0CD1838DD1F95EE11EDB2D11")

    private  GLES20Canvas mCanvas;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.037 -0500", hash_original_method = "D4B7D579B17E08A54081CE8ABAF79334", hash_generated_method = "D4B7D579B17E08A54081CE8ABAF79334")
    
GLES20RenderLayer(int width, int height, boolean isOpaque) {
        super(width, height, isOpaque);

        int[] layerInfo = new int[2];
        mLayer = GLES20Canvas.nCreateLayer(width, height, isOpaque, layerInfo);
        if (mLayer != 0) {
            mLayerWidth = layerInfo[0];
            mLayerHeight = layerInfo[1];

            mCanvas = new GLES20Canvas(mLayer, !isOpaque);
            mFinalizer = new Finalizer(mLayer);
        } else {
            mCanvas = null;
            mFinalizer = null;
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.039 -0500", hash_original_method = "27637E49BAB94EC056B8444376552B7F", hash_generated_method = "312D77EF1EE0AE6CC5B0613D1FB00A2C")
    
@Override
    boolean isValid() {
        return mLayer != 0 && mLayerWidth > 0 && mLayerHeight > 0;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.042 -0500", hash_original_method = "63622532C5FA451BFFE13D4E08C1E4DD", hash_generated_method = "7336BAABA20D655D2F856896E1FFB650")
    
@Override
    void resize(int width, int height) {
        if (!isValid() || width <= 0 || height <= 0) return;

        mWidth = width;
        mHeight = height;
        
        if (width != mLayerWidth || height != mLayerHeight) {
            int[] layerInfo = new int[2];

            GLES20Canvas.nResizeLayer(mLayer, width, height, layerInfo);

            mLayerWidth = layerInfo[0];
            mLayerHeight = layerInfo[1];
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.044 -0500", hash_original_method = "03525402B3DC937D128A720724E320B3", hash_generated_method = "8DFF870ACAE374B016A5345B9168DC2B")
    
@Override
    HardwareCanvas getCanvas() {
        return mCanvas;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.047 -0500", hash_original_method = "3C804CAC1F48115A32BF6D1258E6260C", hash_generated_method = "87A19208B91B9D88F898507E366DE73C")
    
@Override
    void end(Canvas currentCanvas) {
        if (currentCanvas instanceof GLES20Canvas) {
            ((GLES20Canvas) currentCanvas).resume();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.049 -0500", hash_original_method = "C87B2ED046DB5084DDAC583F9566C531", hash_generated_method = "D7E34FCA60C21F3DEC8F6B625BBE9C92")
    
@Override
    HardwareCanvas start(Canvas currentCanvas) {
        if (currentCanvas instanceof GLES20Canvas) {
            ((GLES20Canvas) currentCanvas).interrupt();
        }
        return getCanvas();
    }

    /**
     * Ignored
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.051 -0500", hash_original_method = "4B8F7BEEB4E6A31727A7AE50B1045BA3", hash_generated_method = "99B3D29A8479A3433C4A5438CAC4D62B")
    
@Override
    void setTransform(Matrix matrix) {
    }
    
}

