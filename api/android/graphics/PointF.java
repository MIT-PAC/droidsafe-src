package android.graphics;

// Droidsafe Imports
import android.os.Parcel;
import android.os.Parcelable;
import android.util.FloatMath;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class PointF implements Parcelable {
    
    public float x;
    public float y;
    
    @DSModeled(DSC.SAFE)
    public PointF(){
    }
    
    @DSModeled(DSC.SAFE)
    public PointF(float x, float y){
        addTaint(x);
        addTaint(y);
    }
    
    @DSModeled(DSC.SAFE)
    public PointF(Point p){
        addTaint(p);
        /*
        this.x = p.x;
        this.y = p.y;
        */
    }
    
    @DSModeled(DSC.SAFE)
    public final void set(float x, float y){
        addTaint(x);
        addTaint(y);
    }
    
    
    @DSModeled(DSC.SAFE)
    public final void set(PointF p){
        addTaint(p);
    }
    
    @DSModeled(DSC.SAFE)
    public final void negate(){
        addTaint(x);
        addTaint(y);
    }
    
    @DSModeled(DSC.SAFE)
    public final void offset(float dx, float dy){
        addTaint(dx);
        addTaint(dy);
    }
    
    public final boolean equals(float x, float y){
        return getTaintBoolean();

        // Original method
        /*
        { 
        return this.x == x && this.y == y; 
    }
        */
    }
    
    public final float length(){
        return getTaintFloat();

        // Original method
        /*
        { 
        return length(x, y); 
    }
        */
    }
    
    public static float length(float x, float y) {
        return FloatMath.sqrt(x * x + y * y);
    }
    
    @Override public int describeContents(){
        return getTaintInt();
    }
    
    @Override public void writeToParcel(Parcel out, int flags){
        out.writeFloat(x);
        out.writeFloat(y);
    }
    
    /*
    public static final Parcelable.Creator<PointF> CREATOR = new Parcelable.Creator<PointF>() {
        public PointF createFromParcel(Parcel in) {
            PointF r = new PointF();
            r.readFromParcel(in);
            return r;
        }

        public PointF[] newArray(int size) {
            return new PointF[size];
        }
    };
    */
    
    
    public void readFromParcel(Parcel in){
        // Original method
        /*
        {
        x = in.readFloat();
        y = in.readFloat();
    }
        */
    }
}

