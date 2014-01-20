package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintWriter;

public class Matrix {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int native_create(int native_src_or_zero){
		//Formerly a native function
		return 0;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_isIdentity(int native_object){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_rectStaysRect(int native_object){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_reset(int native_object){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_set(int native_object, int other){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_setTranslate(int native_object,
                                                   float dx, float dy){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_setScale(int native_object,
                                        float sx, float sy, float px, float py){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_setScale(int native_object,
                                               float sx, float sy){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_setRotate(int native_object,
                                            float degrees, float px, float py){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_setRotate(int native_object,
                                                float degrees){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_setSinCos(int native_object,
                            float sinValue, float cosValue, float px, float py){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_setSinCos(int native_object,
                                                float sinValue, float cosValue){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_setSkew(int native_object,
                                        float kx, float ky, float px, float py){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_setSkew(int native_object,
                                              float kx, float ky){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_setConcat(int native_object,
                                                   int a, int b){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_preTranslate(int native_object,
                                                      float dx, float dy){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_preScale(int native_object,
                                        float sx, float sy, float px, float py){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_preScale(int native_object,
                                                  float sx, float sy){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_preRotate(int native_object,
                                            float degrees, float px, float py){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_preRotate(int native_object,
                                                   float degrees){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_preSkew(int native_object,
                                        float kx, float ky, float px, float py){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_preSkew(int native_object,
                                                 float kx, float ky){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_preConcat(int native_object,
                                                   int other_matrix){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_postTranslate(int native_object,
                                                       float dx, float dy){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_postScale(int native_object,
                                        float sx, float sy, float px, float py){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_postScale(int native_object,
                                                   float sx, float sy){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_postRotate(int native_object,
                                            float degrees, float px, float py){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_postRotate(int native_object,
                                                    float degrees){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_postSkew(int native_object,
                                        float kx, float ky, float px, float py){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_postSkew(int native_object,
                                                  float kx, float ky){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_postConcat(int native_object,
                                                    int other_matrix){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_setRectToRect(int native_object,
                                                RectF src, RectF dst, int stf){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_setPolyToPoly(int native_object,
        float[] src, int srcIndex, float[] dst, int dstIndex, int pointCount){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_invert(int native_object, int inverse){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_mapPoints(int native_object,
                        float[] dst, int dstIndex, float[] src, int srcIndex,
                        int ptCount, boolean isPts){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_mapRect(int native_object,
                                                 RectF dst, RectF src){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static float native_mapRadius(int native_object,
                                                 float radius){
		//Formerly a native function
		return 0;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_getValues(int native_object,
                                                float[] values){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_setValues(int native_object,
                                                float[] values){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_equals(int native_a, int native_b){
		//Formerly a native function
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void finalizer(int native_instance){
		//Formerly a native function
		//Return nothing
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:21.461 -0500", hash_original_field = "397F6C4BE2DD640B9585E93522FF654F", hash_generated_field = "EFA3DBAD301BED225815D2F749817006")

    public static final int MSCALE_X = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:21.464 -0500", hash_original_field = "D8BA06E22D3857EC9F5D5294939E37E2", hash_generated_field = "67EAC113D4E4932D73D3A487643F0FD1")

    public static final int MSKEW_X  = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:21.466 -0500", hash_original_field = "6DC0939477C0263C9490EE8154FC5BD1", hash_generated_field = "07E5E1B67F0C9E5278715AAB25E91DAB")

    public static final int MTRANS_X = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:21.468 -0500", hash_original_field = "2B35732BD55A3DD3A77625CB5BB2F729", hash_generated_field = "41EBD7259F41631F6876F58AE3C95D05")

    public static final int MSKEW_Y  = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:21.471 -0500", hash_original_field = "06A95EC58DA72F86869B1D82485A40A0", hash_generated_field = "27781A2223BB5718506AC48FB1837DB0")

    public static final int MSCALE_Y = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:21.473 -0500", hash_original_field = "984FA747058BF7EE322A5D2AB3B15B91", hash_generated_field = "43C2504D96C28B177ABC2A96E8E9F767")

    public static final int MTRANS_Y = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:21.475 -0500", hash_original_field = "1C4A2F3F0A315431CB378C42988A8AA9", hash_generated_field = "5A7F9B6FF116E340A9248A261942F12B")

    public static final int MPERSP_0 = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:21.478 -0500", hash_original_field = "4F6AA819731A8266BC8B15F0578DA8AE", hash_generated_field = "4F80C0BDF0D0A262209ADA0919682BD4")

    public static final int MPERSP_1 = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:21.480 -0500", hash_original_field = "8E124C62359AC9F8056E069E958B7FE7", hash_generated_field = "1EF21E44267C42FB84A589D371DA23B3")

    public static final int MPERSP_2 = 8;
    public static Matrix IDENTITY_MATRIX = new Matrix();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:21.571 -0500", hash_original_field = "1353DF0D3FEF59358BA81F3F4AC59875", hash_generated_field = "368FA2DC569BFE75826F8A8AC6BD5246")

    public int native_instance;
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public Matrix(){
		/*
		native_instance = native_create(0);
		*/
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public Matrix(Matrix src){
		/*
		native_instance = native_create(src != null ? src.native_instance : 0);
		*/
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean isIdentity(){
		// Original method
		/*
		{
        return native_isIdentity(native_instance);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean rectStaysRect(){
		// Original method
		/*
		{
        return native_rectStaysRect(native_instance);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void reset(){
		// Original method
		/*
		{
        native_reset(native_instance);
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setTranslate(float dx, float dy){
		// Original method
		/*
		{
        native_setTranslate(native_instance, dx, dy);
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setScale(float sx, float sy, float px, float py){
		// Original method
		/*
		{
        native_setScale(native_instance, sx, sy, px, py);
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setScale(float sx, float sy){
		// Original method
		/*
		{
        native_setScale(native_instance, sx, sy);
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setRotate(float degrees, float px, float py){
		// Original method
		/*
		{
        native_setRotate(native_instance, degrees, px, py);
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setRotate(float degrees){
		// Original method
		/*
		{
        native_setRotate(native_instance, degrees);
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setSinCos(float sinValue, float cosValue, float px, float py){
		// Original method
		/*
		{
        native_setSinCos(native_instance, sinValue, cosValue, px, py);
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setSinCos(float sinValue, float cosValue){
		// Original method
		/*
		{
        native_setSinCos(native_instance, sinValue, cosValue);
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setSkew(float kx, float ky, float px, float py){
		// Original method
		/*
		{
        native_setSkew(native_instance, kx, ky, px, py);
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setSkew(float kx, float ky){
		// Original method
		/*
		{
        native_setSkew(native_instance, kx, ky);
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean preTranslate(float dx, float dy){
		// Original method
		/*
		{
        return native_preTranslate(native_instance, dx, dy);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean preScale(float sx, float sy, float px, float py){
		// Original method
		/*
		{
        return native_preScale(native_instance, sx, sy, px, py);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean preScale(float sx, float sy){
		// Original method
		/*
		{
        return native_preScale(native_instance, sx, sy);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean preRotate(float degrees, float px, float py){
		// Original method
		/*
		{
        return native_preRotate(native_instance, degrees, px, py);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean preRotate(float degrees){
		// Original method
		/*
		{
        return native_preRotate(native_instance, degrees);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean preSkew(float kx, float ky, float px, float py){
		// Original method
		/*
		{
        return native_preSkew(native_instance, kx, ky, px, py);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean preSkew(float kx, float ky){
		// Original method
		/*
		{
        return native_preSkew(native_instance, kx, ky);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean preConcat(Matrix other){
		// Original method
		/*
		{
        return native_preConcat(native_instance, other.native_instance);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean postTranslate(float dx, float dy){
		// Original method
		/*
		{
        return native_postTranslate(native_instance, dx, dy);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean postScale(float sx, float sy, float px, float py){
		// Original method
		/*
		{
        return native_postScale(native_instance, sx, sy, px, py);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean postScale(float sx, float sy){
		// Original method
		/*
		{
        return native_postScale(native_instance, sx, sy);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean postRotate(float degrees, float px, float py){
		// Original method
		/*
		{
        return native_postRotate(native_instance, degrees, px, py);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean postRotate(float degrees){
		// Original method
		/*
		{
        return native_postRotate(native_instance, degrees);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean postSkew(float kx, float ky, float px, float py){
		// Original method
		/*
		{
        return native_postSkew(native_instance, kx, ky, px, py);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean postSkew(float kx, float ky){
		// Original method
		/*
		{
        return native_postSkew(native_instance, kx, ky);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean postConcat(Matrix other){
		// Original method
		/*
		{
        return native_postConcat(native_instance, other.native_instance);
    }
		*/
		return false;
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean invert(Matrix inverse){
		// Original method
		/*
		{
        return native_invert(native_instance, inverse.native_instance);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void mapPoints(float[] pts){
		// Original method
		/*
		{
        mapPoints(pts, 0, pts, 0, pts.length >> 1);
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void mapVectors(float[] vecs){
		// Original method
		/*
		{
        mapVectors(vecs, 0, vecs, 0, vecs.length >> 1);
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    public enum ScaleToFit {
        FILL    (0),
        START   (1),
        CENTER  (2),
        END     (3);

        // the native values must match those in SkMatrix.h 
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:21.647 -0500", hash_original_method = "63FB077414864D6FD8B685EA30FF9871", hash_generated_method = "63FB077414864D6FD8B685EA30FF9871")
            
ScaleToFit(int nativeInt) {
            this.nativeInt = nativeInt;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:21.649 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "6B116C6445FBD920A2653C64D32C9FB3")

         int nativeInt;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean mapRect(RectF rect){
		// Original method
		/*
		{
        return mapRect(rect, rect);
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public float mapRadius(float radius){
		// Original method
		/*
		{
        return native_mapRadius(native_instance, radius);
    }
		*/
		return 0;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    protected void finalize(){
		// Original method
		/*
		{
        finalizer(native_instance);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    final int ni(){
		return getTaintInt();
		// Original method
		/*
		{
        return native_instance;
    }
		*/
	}
}

