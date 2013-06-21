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
    private int mLayerWidth;
    private int mLayerHeight;
    private GLES20Canvas mCanvas;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.684 -0400", hash_original_method = "D4B7D579B17E08A54081CE8ABAF79334", hash_generated_method = "3D31EEB85523D4A10EFBFE6F34A53754")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     GLES20RenderLayer(int width, int height, boolean isOpaque) {
        super(width, height, isOpaque);
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(isOpaque);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.685 -0400", hash_original_method = "27637E49BAB94EC056B8444376552B7F", hash_generated_method = "A09E91BEABCAF4CBB850391085A37C3D")
    @DSModeled(DSC.SAFE)
    @Override
     boolean isValid() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLayer != 0 && mLayerWidth > 0 && mLayerHeight > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.686 -0400", hash_original_method = "63622532C5FA451BFFE13D4E08C1E4DD", hash_generated_method = "AFB5C1B4958EDDC0985D460D3011F672")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void resize(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        {
            boolean varB6187C6063EC950533DF2105C60D4B42_727987042 = (!isValid() || width <= 0 || height <= 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.687 -0400", hash_original_method = "03525402B3DC937D128A720724E320B3", hash_generated_method = "191DFA269901C4ED3CB41BA1E496CC89")
    @DSModeled(DSC.SAFE)
    @Override
     HardwareCanvas getCanvas() {
        return (HardwareCanvas)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCanvas;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.687 -0400", hash_original_method = "3C804CAC1F48115A32BF6D1258E6260C", hash_generated_method = "C912DC23C892E720A14851259C4E5C33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void end(Canvas currentCanvas) {
        dsTaint.addTaint(currentCanvas.dsTaint);
        {
            ((GLES20Canvas) currentCanvas).resume();
        } //End block
        // ---------- Original Method ----------
        //if (currentCanvas instanceof GLES20Canvas) {
            //((GLES20Canvas) currentCanvas).resume();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.687 -0400", hash_original_method = "C87B2ED046DB5084DDAC583F9566C531", hash_generated_method = "C18C80E4001DD1ACAE2E895639810A85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     HardwareCanvas start(Canvas currentCanvas) {
        dsTaint.addTaint(currentCanvas.dsTaint);
        {
            ((GLES20Canvas) currentCanvas).interrupt();
        } //End block
        HardwareCanvas varE1EF018A95287DD150F9B89FB4D4AE38_1404837064 = (getCanvas());
        return (HardwareCanvas)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (currentCanvas instanceof GLES20Canvas) {
            //((GLES20Canvas) currentCanvas).interrupt();
        //}
        //return getCanvas();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.687 -0400", hash_original_method = "4B8F7BEEB4E6A31727A7AE50B1045BA3", hash_generated_method = "C8AA3100E1C7B0DBCE8EE553B5CDA1FA")
    @DSModeled(DSC.SAFE)
    @Override
     void setTransform(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        // ---------- Original Method ----------
    }

    
}

