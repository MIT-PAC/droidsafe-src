package android.graphics;

// Droidsafe Imports
import java.io.PrintWriter;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Matrix {
	public static final int MSCALE_X = 0;
	public static final int MSKEW_X  = 1;
	public static final int MTRANS_X = 2;
	public static final int MSKEW_Y  = 3;
	public static final int MSCALE_Y = 4;
	public static final int MTRANS_Y = 5;
	public static final int MPERSP_0 = 6;
	public static final int MPERSP_1 = 7;
	public static final int MPERSP_2 = 8;
	public static Matrix IDENTITY_MATRIX = new Matrix();
	public int native_instance;
	
	@DSModeled(DSC.SAFE)
	public Matrix(){
		/*
		native_instance = native_create(0);
		*/
	}
	
	public Matrix(Matrix src){
		/*
		native_instance = native_create(src != null ? src.native_instance : 0);
		*/
	}
	
	public boolean isIdentity(){
		
		// Original method
		/*
		{
        return native_isIdentity(native_instance);
    }
		*/
		return false;
	}
	
	public boolean rectStaysRect(){
		
		// Original method
		/*
		{
        return native_rectStaysRect(native_instance);
    }
		*/
		return false;
	}
	
	public void set(Matrix src){
		
		// Original method
		/*
		{
        if (src == null) {
            reset();
        } else {
            native_set(native_instance, src.native_instance);
        }
    }
		*/
		//Return nothing
	}
	
	public boolean equals(Object obj){
		
		// Original method
		/*
		{
        return obj != null &&
               obj instanceof Matrix &&
               native_equals(native_instance, ((Matrix)obj).native_instance);
    }
		*/
		return false;
	}
	
	public void reset(){
		
		// Original method
		/*
		{
        native_reset(native_instance);
    }
		*/
		//Return nothing
	}
	
	public void setTranslate(float dx, float dy){
		
		// Original method
		/*
		{
        native_setTranslate(native_instance, dx, dy);
    }
		*/
		//Return nothing
	}
	
	public void setScale(float sx, float sy, float px, float py){
		
		// Original method
		/*
		{
        native_setScale(native_instance, sx, sy, px, py);
    }
		*/
		//Return nothing
	}
	
	public void setScale(float sx, float sy){
		
		// Original method
		/*
		{
        native_setScale(native_instance, sx, sy);
    }
		*/
		//Return nothing
	}
	
	public void setRotate(float degrees, float px, float py){
		
		// Original method
		/*
		{
        native_setRotate(native_instance, degrees, px, py);
    }
		*/
		//Return nothing
	}
	
	public void setRotate(float degrees){
		
		// Original method
		/*
		{
        native_setRotate(native_instance, degrees);
    }
		*/
		//Return nothing
	}
	
	public void setSinCos(float sinValue, float cosValue, float px, float py){
		
		// Original method
		/*
		{
        native_setSinCos(native_instance, sinValue, cosValue, px, py);
    }
		*/
		//Return nothing
	}
	
	public void setSinCos(float sinValue, float cosValue){
		
		// Original method
		/*
		{
        native_setSinCos(native_instance, sinValue, cosValue);
    }
		*/
		//Return nothing
	}
	
	public void setSkew(float kx, float ky, float px, float py){
		
		// Original method
		/*
		{
        native_setSkew(native_instance, kx, ky, px, py);
    }
		*/
		//Return nothing
	}
	
	public void setSkew(float kx, float ky){
		
		// Original method
		/*
		{
        native_setSkew(native_instance, kx, ky);
    }
		*/
		//Return nothing
	}
	
	public boolean setConcat(Matrix a, Matrix b){
		
		// Original method
		/*
		{
        return native_setConcat(native_instance, a.native_instance,
                                b.native_instance);
    }
		*/
		return false;
	}
	
	public boolean preTranslate(float dx, float dy){
		
		// Original method
		/*
		{
        return native_preTranslate(native_instance, dx, dy);
    }
		*/
		return false;
	}
	
	public boolean preScale(float sx, float sy, float px, float py){
		
		// Original method
		/*
		{
        return native_preScale(native_instance, sx, sy, px, py);
    }
		*/
		return false;
	}
	
	public boolean preScale(float sx, float sy){
		
		// Original method
		/*
		{
        return native_preScale(native_instance, sx, sy);
    }
		*/
		return false;
	}
	
	public boolean preRotate(float degrees, float px, float py){
		
		// Original method
		/*
		{
        return native_preRotate(native_instance, degrees, px, py);
    }
		*/
		return false;
	}
	
	public boolean preRotate(float degrees){
		
		// Original method
		/*
		{
        return native_preRotate(native_instance, degrees);
    }
		*/
		return false;
	}
	
	public boolean preSkew(float kx, float ky, float px, float py){
		
		// Original method
		/*
		{
        return native_preSkew(native_instance, kx, ky, px, py);
    }
		*/
		return false;
	}
	
	public boolean preSkew(float kx, float ky){
		
		// Original method
		/*
		{
        return native_preSkew(native_instance, kx, ky);
    }
		*/
		return false;
	}
	
	public boolean preConcat(Matrix other){
		
		// Original method
		/*
		{
        return native_preConcat(native_instance, other.native_instance);
    }
		*/
		return false;
	}
	
	public boolean postTranslate(float dx, float dy){
		
		// Original method
		/*
		{
        return native_postTranslate(native_instance, dx, dy);
    }
		*/
		return false;
	}
	
	public boolean postScale(float sx, float sy, float px, float py){
		
		// Original method
		/*
		{
        return native_postScale(native_instance, sx, sy, px, py);
    }
		*/
		return false;
	}
	
	public boolean postScale(float sx, float sy){
		
		// Original method
		/*
		{
        return native_postScale(native_instance, sx, sy);
    }
		*/
		return false;
	}
	
	public boolean postRotate(float degrees, float px, float py){
		
		// Original method
		/*
		{
        return native_postRotate(native_instance, degrees, px, py);
    }
		*/
		return false;
	}
	
	public boolean postRotate(float degrees){
		
		// Original method
		/*
		{
        return native_postRotate(native_instance, degrees);
    }
		*/
		return false;
	}
	
	public boolean postSkew(float kx, float ky, float px, float py){
		
		// Original method
		/*
		{
        return native_postSkew(native_instance, kx, ky, px, py);
    }
		*/
		return false;
	}
	
	public boolean postSkew(float kx, float ky){
		
		// Original method
		/*
		{
        return native_postSkew(native_instance, kx, ky);
    }
		*/
		return false;
	}
	
	public boolean postConcat(Matrix other){
		
		// Original method
		/*
		{
        return native_postConcat(native_instance, other.native_instance);
    }
		*/
		return false;
	}
	
	enum ScaleToFit {
        
        FILL    (0),
        
        START   (1),
        
        CENTER  (2),
        
        END     (3);

        
        ScaleToFit(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        final int nativeInt;
    }
	
	
	public boolean setRectToRect(RectF src, RectF dst, ScaleToFit stf){
		
		// Original method
		/*
		{
        if (dst == null || src == null) {
            throw new NullPointerException();
        }
        return native_setRectToRect(native_instance, src, dst, stf.nativeInt);
    }
		*/
		return false;
	}
	
	private static void checkPointArrays(float[] src, int srcIndex,
                                         float[] dst, int dstIndex,
                                         int pointCount){
		
		// Original method
		/*
		{
        
        int srcStop = srcIndex + (pointCount << 1);
        int dstStop = dstIndex + (pointCount << 1);
        if ((pointCount | srcIndex | dstIndex | srcStop | dstStop) < 0 ||
                srcStop > src.length || dstStop > dst.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
		*/
		//Return nothing
	}
	
	public boolean setPolyToPoly(float[] src, int srcIndex,
                                 float[] dst, int dstIndex,
                                 int pointCount){
		
		// Original method
		/*
		{
        if (pointCount > 4) {
            throw new IllegalArgumentException();
        }
        checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        return native_setPolyToPoly(native_instance, src, srcIndex,
                                    dst, dstIndex, pointCount);
    }
		*/
		return false;
	}
	
	public boolean invert(Matrix inverse){
		
		// Original method
		/*
		{
        return native_invert(native_instance, inverse.native_instance);
    }
		*/
		return false;
	}
	
	public void mapPoints(float[] dst, int dstIndex, float[] src, int srcIndex,
                          int pointCount){
		
		// Original method
		/*
		{
        checkPointArrays(src, srcIndex, dst, dstIndex, pointCount);
        native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         pointCount, true);
    }
		*/
		//Return nothing
	}
	
	public void mapVectors(float[] dst, int dstIndex, float[] src, int srcIndex,
                          int vectorCount){
		
		// Original method
		/*
		{
        checkPointArrays(src, srcIndex, dst, dstIndex, vectorCount);
        native_mapPoints(native_instance, dst, dstIndex, src, srcIndex,
                         vectorCount, false);
    }
		*/
		//Return nothing
	}
	
	public void mapPoints(float[] dst, float[] src){
		
		// Original method
		/*
		{
        if (dst.length != src.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        mapPoints(dst, 0, src, 0, dst.length >> 1);
    }
		*/
		//Return nothing
	}
	
	public void mapVectors(float[] dst, float[] src){
		
		// Original method
		/*
		{
        if (dst.length != src.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        mapVectors(dst, 0, src, 0, dst.length >> 1);
    }
		*/
		//Return nothing
	}
	
	public void mapPoints(float[] pts){
		
		// Original method
		/*
		{
        mapPoints(pts, 0, pts, 0, pts.length >> 1);
    }
		*/
		//Return nothing
	}
	
	public void mapVectors(float[] vecs){
		
		// Original method
		/*
		{
        mapVectors(vecs, 0, vecs, 0, vecs.length >> 1);
    }
		*/
		//Return nothing
	}
	
	public boolean mapRect(RectF dst, RectF src){
		
		// Original method
		/*
		{
        if (dst == null || src == null) {
            throw new NullPointerException();
        }
        return native_mapRect(native_instance, dst, src);
    }
		*/
		return false;
	}
	
	public boolean mapRect(RectF rect){
		
		// Original method
		/*
		{
        return mapRect(rect, rect);
    }
		*/
		return false;
	}
	
	public float mapRadius(float radius){
		
		// Original method
		/*
		{
        return native_mapRadius(native_instance, radius);
    }
		*/
		return 0;
	}
	
	public void getValues(float[] values){
		
		// Original method
		/*
		{
        if (values.length < 9) {
            throw new ArrayIndexOutOfBoundsException();
        }
        native_getValues(native_instance, values);
    }
		*/
		//Return nothing
	}
	
	public void setValues(float[] values){
		
		// Original method
		/*
		{
        if (values.length < 9) {
            throw new ArrayIndexOutOfBoundsException();
        }
        native_setValues(native_instance, values);
    }
		*/
		//Return nothing
	}
	
	public String toString(){
		
		// Original method
		/*
		{
        StringBuilder sb = new StringBuilder(64);
        sb.append("Matrix{");
        toShortString(sb);
        sb.append('}');
        return sb.toString();
                
    }
		*/
		return "";
	}
	
	public String toShortString(){
		
		// Original method
		/*
		{
        StringBuilder sb = new StringBuilder(64);
        toShortString(sb);
        return sb.toString();
    }
		*/
		return "";
	}
	
	public void toShortString(StringBuilder sb){
		
		// Original method
		/*
		{
        float[] values = new float[9];
        getValues(values);
        sb.append('[');
        sb.append(values[0]); sb.append(", "); sb.append(values[1]); sb.append(", ");
        sb.append(values[2]); sb.append("][");
        sb.append(values[3]); sb.append(", "); sb.append(values[4]); sb.append(", ");
        sb.append(values[5]); sb.append("][");
        sb.append(values[6]); sb.append(", "); sb.append(values[7]); sb.append(", ");
        sb.append(values[8]); sb.append(']');
    }
		*/
		//Return nothing
	}
	
	public void printShortString(PrintWriter pw){
		
		// Original method
		/*
		{
        float[] values = new float[9];
        getValues(values);
        pw.print('[');
        pw.print(values[0]); pw.print(", "); pw.print(values[1]); pw.print(", ");
                pw.print(values[2]); pw.print("][");
        pw.print(values[3]); pw.print(", "); pw.print(values[4]); pw.print(", ");
                pw.print(values[5]); pw.print("][");
        pw.print(values[6]); pw.print(", "); pw.print(values[7]); pw.print(", ");
                pw.print(values[8]); pw.print(']');
                
    }
		*/
		//Return nothing
	}
	
	@DSModeled
	protected void finalize(){
		
		// Original method
		/*
		{
        finalizer(native_instance);
    }
		*/
		//Return nothing
	}
	
	final int ni(){
		return getTaintInt();
		
		// Original method
		/*
		{
        return native_instance;
    }
		*/
	}
	
	private static int native_create(int native_src_or_zero){
		//Formerly a native function
		return 0;
	}
	
	private static boolean native_isIdentity(int native_object){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_rectStaysRect(int native_object){
		//Formerly a native function
		return false;
	}
	
	private static void native_reset(int native_object){
		//Formerly a native function
		//Return nothing
	}
	
	private static void native_set(int native_object, int other){
		//Formerly a native function
		//Return nothing
	}
	
	private static void native_setTranslate(int native_object,
                                                   float dx, float dy){
		//Formerly a native function
		//Return nothing
	}
	
	private static void native_setScale(int native_object,
                                        float sx, float sy, float px, float py){
		//Formerly a native function
		//Return nothing
	}
	
	private static void native_setScale(int native_object,
                                               float sx, float sy){
		//Formerly a native function
		//Return nothing
	}
	
	private static void native_setRotate(int native_object,
                                            float degrees, float px, float py){
		//Formerly a native function
		//Return nothing
	}
	
	private static void native_setRotate(int native_object,
                                                float degrees){
		//Formerly a native function
		//Return nothing
	}
	
	private static void native_setSinCos(int native_object,
                            float sinValue, float cosValue, float px, float py){
		//Formerly a native function
		//Return nothing
	}
	
	private static void native_setSinCos(int native_object,
                                                float sinValue, float cosValue){
		//Formerly a native function
		//Return nothing
	}
	
	private static void native_setSkew(int native_object,
                                        float kx, float ky, float px, float py){
		//Formerly a native function
		//Return nothing
	}
	
	private static void native_setSkew(int native_object,
                                              float kx, float ky){
		//Formerly a native function
		//Return nothing
	}
	
	private static boolean native_setConcat(int native_object,
                                                   int a, int b){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_preTranslate(int native_object,
                                                      float dx, float dy){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_preScale(int native_object,
                                        float sx, float sy, float px, float py){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_preScale(int native_object,
                                                  float sx, float sy){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_preRotate(int native_object,
                                            float degrees, float px, float py){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_preRotate(int native_object,
                                                   float degrees){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_preSkew(int native_object,
                                        float kx, float ky, float px, float py){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_preSkew(int native_object,
                                                 float kx, float ky){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_preConcat(int native_object,
                                                   int other_matrix){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_postTranslate(int native_object,
                                                       float dx, float dy){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_postScale(int native_object,
                                        float sx, float sy, float px, float py){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_postScale(int native_object,
                                                   float sx, float sy){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_postRotate(int native_object,
                                            float degrees, float px, float py){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_postRotate(int native_object,
                                                    float degrees){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_postSkew(int native_object,
                                        float kx, float ky, float px, float py){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_postSkew(int native_object,
                                                  float kx, float ky){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_postConcat(int native_object,
                                                    int other_matrix){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_setRectToRect(int native_object,
                                                RectF src, RectF dst, int stf){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_setPolyToPoly(int native_object,
        float[] src, int srcIndex, float[] dst, int dstIndex, int pointCount){
		//Formerly a native function
		return false;
	}
	
	private static boolean native_invert(int native_object, int inverse){
		//Formerly a native function
		return false;
	}
	
	private static void native_mapPoints(int native_object,
                        float[] dst, int dstIndex, float[] src, int srcIndex,
                        int ptCount, boolean isPts){
		//Formerly a native function
		//Return nothing
	}
	
	private static boolean native_mapRect(int native_object,
                                                 RectF dst, RectF src){
		//Formerly a native function
		return false;
	}
	
	private static float native_mapRadius(int native_object,
                                                 float radius){
		//Formerly a native function
		return 0;
	}
	
	private static void native_getValues(int native_object,
                                                float[] values){
		//Formerly a native function
		//Return nothing
	}
	
	private static void native_setValues(int native_object,
                                                float[] values){
		//Formerly a native function
		//Return nothing
	}
	
	private static boolean native_equals(int native_a, int native_b){
		//Formerly a native function
		return false;
	}
	
	private static void finalizer(int native_instance){
		//Formerly a native function
		//Return nothing
	}
}

