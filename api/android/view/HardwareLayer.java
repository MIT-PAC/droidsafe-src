package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;





abstract class HardwareLayer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.518 -0500", hash_original_field = "896F9809B12CD6B33EC4B8CC7EEE5DC9", hash_generated_field = "D9DDBF776703AC435E6910725BF95A3E")

    static final int DIMENSION_UNDEFINED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.520 -0500", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")

    
    int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.522 -0500", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "7DDAE255893B528E7BEBEC203BC2D9F3")

    int mHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.524 -0500", hash_original_field = "1A5E1BEFDB0DF6CE4A573A377262DC5D", hash_generated_field = "1A5E1BEFDB0DF6CE4A573A377262DC5D")


    boolean mOpaque;

    /**
     * Creates a new hardware layer with undefined dimensions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.526 -0500", hash_original_method = "4AE458D6667BFFD1B9464B983848F2AB", hash_generated_method = "4AE458D6667BFFD1B9464B983848F2AB")
    
HardwareLayer() {
        this(DIMENSION_UNDEFINED, DIMENSION_UNDEFINED, false);
    }

    /**
     * Creates a new hardware layer at least as large as the supplied
     * dimensions.
     * 
     * @param width The minimum width of the layer
     * @param height The minimum height of the layer
     * @param isOpaque Whether the layer should be opaque or not
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.529 -0500", hash_original_method = "1344419F3E25BE7760177B4956551826", hash_generated_method = "1344419F3E25BE7760177B4956551826")
    
HardwareLayer(int width, int height, boolean isOpaque) {
        mWidth = width;
        mHeight = height;
        mOpaque = isOpaque;
    }

    /**
     * Returns the minimum width of the layer.
     * 
     * @return The minimum desired width of the hardware layer 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.531 -0500", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "AA9BA105372BFC95AFBABED408315F5C")
    
int getWidth() {
        return mWidth;
    }

    /**
     * Returns the minimum height of the layer.
     * 
     * @return The minimum desired height of the hardware layer 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.533 -0500", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD")
    
int getHeight() {
        return mHeight;
    }

    /**
     * Returns whether or not this layer is opaque.
     * 
     * @return True if the layer is opaque, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.535 -0500", hash_original_method = "AB6C012A4EC234C0DA96929A7EE984CD", hash_generated_method = "AB6C012A4EC234C0DA96929A7EE984CD")
    
boolean isOpaque() {
        return mOpaque;
    }

    /**
     * Indicates whether this layer can be rendered.
     * 
     * @return True if the layer can be rendered into, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.537 -0500", hash_original_method = "F1240C06AF1BA9E648B2E780B8155F1C", hash_generated_method = "DAA5FB924C73E71617DA3BC7565C7DD2")
    
abstract boolean isValid();

    /**
     * Resize the layer, if necessary, to be at least as large
     * as the supplied dimensions.
     * 
     * @param width The new desired minimum width for this layer
     * @param height The new desired minimum height for this layer
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.540 -0500", hash_original_method = "7F52CCCEA09902DD8F30BE748C16C42B", hash_generated_method = "348566AF1F47DBEC85FC0972526488D8")
    
abstract void resize(int width, int height);

    /**
     * Returns a hardware canvas that can be used to render onto
     * this layer.
     * 
     * @return A hardware canvas, or null if a canvas cannot be created
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.542 -0500", hash_original_method = "0D7F234467EBE3155552A1EF9B644626", hash_generated_method = "C04C8CCAD8E35259D9227E6936774422")
    
abstract HardwareCanvas getCanvas();

    /**
     * Destroys resources without waiting for a GC. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.545 -0500", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "DE2DDCE3809B7180E18DC945CC98BF98")
    
abstract void destroy();

    /**
     * This must be invoked before drawing onto this layer.
     * @param currentCanvas
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.547 -0500", hash_original_method = "C5DA33CB29D061496C26842D520A89A2", hash_generated_method = "7B233C35AB2E20BD626C9AA790207FDF")
    
abstract HardwareCanvas start(Canvas currentCanvas);
    
    /**
     * This must be invoked after drawing onto this layer.
     * @param currentCanvas
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.549 -0500", hash_original_method = "294B5A3212CF7F0E13291CC50E0A3DAD", hash_generated_method = "6A7496E88E385B4730230247813A01DC")
    
abstract void end(Canvas currentCanvas);

    /**
     * Copies this layer into the specified bitmap.
     * 
     * @param bitmap The bitmap to copy they layer into
     * 
     * @return True if the copy was successful, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.551 -0500", hash_original_method = "F190DADC37F7C891E6704C8FF5911C05", hash_generated_method = "4CB68FAC3555CC7DE2D5D015A028FE50")
    
abstract boolean copyInto(Bitmap bitmap);

    /**
     * Update the layer's properties. This method should be used
     * when the underlying storage is modified by an external entity.
     * To change the underlying storage, use the {@link #resize(int, int)}
     * method instead.
     * 
     * @param width The new width of this layer
     * @param height The new height of this layer
     * @param isOpaque Whether this layer is opaque
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.553 -0500", hash_original_method = "5ABA86D5BFEB1909CF7BF3A4764A9281", hash_generated_method = "5ABA86D5BFEB1909CF7BF3A4764A9281")
    
void update(int width, int height, boolean isOpaque) {
        mWidth = width;
        mHeight = height;
        mOpaque = isOpaque;
    }

    /**
     * Sets an optional transform on this layer.
     * 
     * @param matrix The transform to apply to the layer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:12.555 -0500", hash_original_method = "985A34548D6614FF3421D9F47D8BF1FF", hash_generated_method = "2A88785437AC9C9D1C79D3C5AFFA5E30")
    
abstract void setTransform(Matrix matrix);
}

