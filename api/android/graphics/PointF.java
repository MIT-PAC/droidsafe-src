package android.graphics;

// Droidsafe Imports
import android.os.Parcel;
import android.os.Parcelable;
import android.util.FloatMath;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
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
        addTaint(p.getTaint());
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
        addTaint(p.getTaint());
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

    
    @DSModeled(DSC.SAFE)
    public final boolean equals(float x, float y){
        return getTaintBoolean();
        // Original method
        /*
        { 
        return this.x == x && this.y == y; 
    }
        */
    }

    
    @DSModeled(DSC.SAFE)
    public final float length(){
        return getTaintFloat();
        // Original method
        /*
        { 
        return length(x, y); 
    }
        */
    }

    
    @DSModeled(DSC.SAFE)
    public static float length(float x, float y) {
        return FloatMath.sqrt(x * x + y * y);
    }

    
    @DSModeled(DSC.SAFE)
    @Override public int describeContents(){
        return getTaintInt();
    }

    
    @DSModeled(DSC.SAFE)
    @Override public void writeToParcel(Parcel out, int flags){
        out.writeFloat(x);
        out.writeFloat(y);
    }

    
    @DSModeled(DSC.SAFE)
    public void readFromParcel(Parcel in){
        // Original method
        /*
        {
        x = in.readFloat();
        y = in.readFloat();
    }
        */
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.566 -0400", hash_original_field = "A8B72BB8FF20DCD3E42E3990C2FB1A2D", hash_generated_field = "290F12F848FCA2A5689B95FB1FE844BB")

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
}

