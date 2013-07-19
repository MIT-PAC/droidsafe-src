package android.view;

// Droidsafe Imports
import android.graphics.Canvas;
import android.graphics.Matrix;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class GLES20RenderLayer extends GLES20Layer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.247 -0400", hash_original_field = "1FCA621F2A671FBE9E481D66953EB925", hash_generated_field = "6CE69E33D331522DEEDAAE7DFC370CEC")

    private int mLayerWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.247 -0400", hash_original_field = "4053DC387BD240D365988C191AA6BA5F", hash_generated_field = "9447103C7619FC9FCAB4543B13DECB8F")

    private int mLayerHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.247 -0400", hash_original_field = "B27B52DEE91FF1260919C0152F8A3F5A", hash_generated_field = "16F4A35E0CD1838DD1F95EE11EDB2D11")

    private GLES20Canvas mCanvas;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.249 -0400", hash_original_method = "D4B7D579B17E08A54081CE8ABAF79334", hash_generated_method = "A9899E63C4C871A25CED270B82E1DB47")
      GLES20RenderLayer(int width, int height, boolean isOpaque) {
        super(width, height, isOpaque);
        addTaint(height);
        addTaint(width);
        int[] layerInfo = new int[2];
        mLayer = GLES20Canvas.nCreateLayer(width, height, isOpaque, layerInfo);
        if(mLayer != 0)        
        {
            mLayerWidth = layerInfo[0];
            mLayerHeight = layerInfo[1];
            mCanvas = new GLES20Canvas(mLayer, !isOpaque);
            mFinalizer = new Finalizer(mLayer);
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.250 -0400", hash_original_method = "27637E49BAB94EC056B8444376552B7F", hash_generated_method = "1067D9D38CDD76170837847F6618BC09")
    @Override
     boolean isValid() {
        boolean var4D4E53B7232CB8E6630ECECE3AB2CEB8_1283567764 = (mLayer != 0 && mLayerWidth > 0 && mLayerHeight > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_186994447 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_186994447;
        // ---------- Original Method ----------
        //return mLayer != 0 && mLayerWidth > 0 && mLayerHeight > 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.251 -0400", hash_original_method = "63622532C5FA451BFFE13D4E08C1E4DD", hash_generated_method = "F15CF29CF1D7A179A64BE571767DD746")
    @Override
     void resize(int width, int height) {
        addTaint(height);
        addTaint(width);
        if(!isValid() || width <= 0 || height <= 0)        
        return;
        mWidth = width;
        mHeight = height;
        if(width != mLayerWidth || height != mLayerHeight)        
        {
            int[] layerInfo = new int[2];
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.252 -0400", hash_original_method = "03525402B3DC937D128A720724E320B3", hash_generated_method = "0F79E353ED2FA5B7EFE0708BE8BD5D6F")
    @Override
     HardwareCanvas getCanvas() {
HardwareCanvas var3AB98B3CCAF89A85C04BAFF3A3FCA5C1_1046858263 =         mCanvas;
        var3AB98B3CCAF89A85C04BAFF3A3FCA5C1_1046858263.addTaint(taint);
        return var3AB98B3CCAF89A85C04BAFF3A3FCA5C1_1046858263;
        // ---------- Original Method ----------
        //return mCanvas;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.252 -0400", hash_original_method = "3C804CAC1F48115A32BF6D1258E6260C", hash_generated_method = "7C99D1B4E1A76EE922E70A021205AF89")
    @Override
     void end(Canvas currentCanvas) {
        addTaint(currentCanvas.getTaint());
        if(currentCanvas instanceof GLES20Canvas)        
        {
            ((GLES20Canvas) currentCanvas).resume();
        } //End block
        // ---------- Original Method ----------
        //if (currentCanvas instanceof GLES20Canvas) {
            //((GLES20Canvas) currentCanvas).resume();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.253 -0400", hash_original_method = "C87B2ED046DB5084DDAC583F9566C531", hash_generated_method = "4ED75F785DC64E4934E3D5719371E92E")
    @Override
     HardwareCanvas start(Canvas currentCanvas) {
        addTaint(currentCanvas.getTaint());
        if(currentCanvas instanceof GLES20Canvas)        
        {
            ((GLES20Canvas) currentCanvas).interrupt();
        } //End block
HardwareCanvas varC98421EDCA5974E2CF23DD5BCD11D32D_859258450 =         getCanvas();
        varC98421EDCA5974E2CF23DD5BCD11D32D_859258450.addTaint(taint);
        return varC98421EDCA5974E2CF23DD5BCD11D32D_859258450;
        // ---------- Original Method ----------
        //if (currentCanvas instanceof GLES20Canvas) {
            //((GLES20Canvas) currentCanvas).interrupt();
        //}
        //return getCanvas();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.253 -0400", hash_original_method = "4B8F7BEEB4E6A31727A7AE50B1045BA3", hash_generated_method = "D84BFEAF1F7F2DD612ECDA04718E2436")
    @Override
     void setTransform(Matrix matrix) {
        addTaint(matrix.getTaint());
        // ---------- Original Method ----------
    }

    
}

