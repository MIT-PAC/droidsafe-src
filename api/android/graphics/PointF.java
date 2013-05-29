package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.FloatMath;

public class PointF implements Parcelable {
    
    public float x;
    public float y;
    
    @DSModeled(DSC.SAFE)
    public PointF(){
    }
    
    @DSModeled(DSC.SAFE)
    public PointF(float x, float y){
        dsTaint.addTaint(x);
        dsTaint.addTaint(y);
    }
    
    @DSModeled(DSC.SAFE)
    public PointF(Point p){
        dsTaint.addTaint(p.dsTaint);
        /*
        this.x = p.x;
        this.y = p.y;
        */
    }
    
    @DSModeled(DSC.SAFE)
    public final void set(float x, float y){
        dsTaint.addTaint(x);
        dsTaint.addTaint(y);
    }
    
    
    @DSModeled(DSC.SAFE)
    public final void set(PointF p){
        dsTaint.addTaint(p.dsTaint);
    }
    
    @DSModeled(DSC.SAFE)
    public final void negate(){
        dsTaint.addTaint(x);
        dsTaint.addTaint(y);
    }
    
    @DSModeled(DSC.SAFE)
    public final void offset(float dx, float dy){
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
    }
    
    public final boolean equals(float x, float y){
        return dsTaint.getTaintBoolean();

        // Original method
        /*
        { 
        return this.x == x && this.y == y; 
    }
        */
    }
    
    public final float length(){
        return dsTaint.getTaintFloat();

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
        return dsTaint.getTaintInt();
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

