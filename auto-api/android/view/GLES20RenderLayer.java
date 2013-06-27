package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Matrix;

class GLES20RenderLayer extends GLES20Layer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:48.089 -0400", hash_original_field = "1FCA621F2A671FBE9E481D66953EB925", hash_generated_field = "6CE69E33D331522DEEDAAE7DFC370CEC")

    private int mLayerWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:48.090 -0400", hash_original_field = "4053DC387BD240D365988C191AA6BA5F", hash_generated_field = "9447103C7619FC9FCAB4543B13DECB8F")

    private int mLayerHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:48.090 -0400", hash_original_field = "B27B52DEE91FF1260919C0152F8A3F5A", hash_generated_field = "16F4A35E0CD1838DD1F95EE11EDB2D11")

    private GLES20Canvas mCanvas;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:48.101 -0400", hash_original_method = "D4B7D579B17E08A54081CE8ABAF79334", hash_generated_method = "A2F1656E6376FE477176797EDA7FED8A")
      GLES20RenderLayer(int width, int height, boolean isOpaque) {
        super(width, height, isOpaque);
        int[] layerInfo;
        layerInfo = new int[2];
        mLayer = GLES20Canvas.nCreateLayer(width, height, isOpaque, layerInfo);
        {
            mLayerWidth = layerInfo[0];
            mLayerHeight = layerInfo[1];
            mCanvas = new GLES20Canvas(mLayer, !isOpaque);
            mFinalizer = new Finalizer(mLayer);
        } //End block
        {
            mCanvas = null;
            mFinalizer = null;
        } //End block
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
        //int[] layerInfo = new int[2];
        //mLayer = GLES20Canvas.nCreateLayer(width, height, isOpaque, layerInfo);
        //if (mLayer != 0) {
            //mLayerWidth = layerInfo[0];
            //mLayerHeight = layerInfo[1];
            //mCanvas = new GLES20Canvas(mLayer, !isOpaque);
            //mFinalizer = new Finalizer(mLayer);
        //} else {
            //mCanvas = null;
            //mFinalizer = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:48.101 -0400", hash_original_method = "27637E49BAB94EC056B8444376552B7F", hash_generated_method = "2F89308CC35101EFD251A2EF54746DA1")
    @Override
     boolean isValid() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1247784128 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1247784128;
        // ---------- Original Method ----------
        //return mLayer != 0 && mLayerWidth > 0 && mLayerHeight > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:48.102 -0400", hash_original_method = "63622532C5FA451BFFE13D4E08C1E4DD", hash_generated_method = "F3E80C2066557B10F1520DA981AF14BC")
    @Override
     void resize(int width, int height) {
        {
            boolean varB6187C6063EC950533DF2105C60D4B42_883260670 = (!isValid() || width <= 0 || height <= 0);
        } //End collapsed parenthetic
        mWidth = width;
        mHeight = height;
        {
            int[] layerInfo;
            layerInfo = new int[2];
            GLES20Canvas.nResizeLayer(mLayer, width, height, layerInfo);
            mLayerWidth = layerInfo[0];
            mLayerHeight = layerInfo[1];
        } //End block
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
        //if (!isValid() || width <= 0 || height <= 0) return;
        //mWidth = width;
        //mHeight = height;
        //if (width != mLayerWidth || height != mLayerHeight) {
            //int[] layerInfo = new int[2];
            //GLES20Canvas.nResizeLayer(mLayer, width, height, layerInfo);
            //mLayerWidth = layerInfo[0];
            //mLayerHeight = layerInfo[1];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:48.103 -0400", hash_original_method = "03525402B3DC937D128A720724E320B3", hash_generated_method = "4DACD1C9AD91546E2BF9E727373C3B77")
    @Override
     HardwareCanvas getCanvas() {
        HardwareCanvas varB4EAC82CA7396A68D541C85D26508E83_1977830472 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1977830472 = mCanvas;
        varB4EAC82CA7396A68D541C85D26508E83_1977830472.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1977830472;
        // ---------- Original Method ----------
        //return mCanvas;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:48.104 -0400", hash_original_method = "3C804CAC1F48115A32BF6D1258E6260C", hash_generated_method = "CDD1DE47C8569F8431D88C9F20B7E9CB")
    @Override
     void end(Canvas currentCanvas) {
        {
            ((GLES20Canvas) currentCanvas).resume();
        } //End block
        addTaint(currentCanvas.getTaint());
        // ---------- Original Method ----------
        //if (currentCanvas instanceof GLES20Canvas) {
            //((GLES20Canvas) currentCanvas).resume();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:48.104 -0400", hash_original_method = "C87B2ED046DB5084DDAC583F9566C531", hash_generated_method = "906A68BADF94610D0571F6192DF0AF54")
    @Override
     HardwareCanvas start(Canvas currentCanvas) {
        HardwareCanvas varB4EAC82CA7396A68D541C85D26508E83_439689313 = null; //Variable for return #1
        {
            ((GLES20Canvas) currentCanvas).interrupt();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_439689313 = getCanvas();
        addTaint(currentCanvas.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_439689313.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_439689313;
        // ---------- Original Method ----------
        //if (currentCanvas instanceof GLES20Canvas) {
            //((GLES20Canvas) currentCanvas).interrupt();
        //}
        //return getCanvas();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:48.104 -0400", hash_original_method = "4B8F7BEEB4E6A31727A7AE50B1045BA3", hash_generated_method = "D84BFEAF1F7F2DD612ECDA04718E2436")
    @Override
     void setTransform(Matrix matrix) {
        addTaint(matrix.getTaint());
        // ---------- Original Method ----------
    }

    
}

