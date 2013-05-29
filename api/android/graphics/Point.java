package android.graphics;

// Droidsafe Imports
import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Point implements Parcelable {
    
    public int x;
    public int y;
    
    public Point(){
    }
    
    @DSModeled(DSC.SAFE)
    public Point(int x, int y){
        dsTaint.addTaint(x);
        dsTaint.addTaint(y);
    }
    
    @DSModeled(DSC.SAFE)
    public Point(Point src){
        dsTaint.addTaint(src.dsTaint);
        /*
        this.x = src.x;
        this.y = src.y;
        */
    }
    
    @DSModeled(DSC.SAFE)
    public void set(int x, int y){
        dsTaint.addTaint(x);
        dsTaint.addTaint(y);
        // Original method
        /*
        {
        this.x = x;
        this.y = y;
    }
        */
    }
    
    @DSModeled(DSC.SAFE)
    public final void negate(){
        dsTaint.addTaint(x);
        dsTaint.addTaint(y);
    }
    
    public final void offset(int dx, int dy){
        x += dx;
        y += dy;
        // Original method
        /*
        {
        x += dx;
        y += dy;
    }
        */
    }
    
    public final boolean equals(int x, int y){
        return dsTaint.getTaintBoolean();

        // Original method
        /*
        {
        return this.x == x && this.y == y;
    }
        */
    }
    
    @Override public boolean equals(Object o){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Point p = (Point) o;
        return dsTaint.getTaintBoolean();

        // Original method
        /*
        {
        if (o instanceof Point) {
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
        }
        return false;
    }
        */
    }
    
    @Override public int hashCode(){
        return dsTaint.getTaintInt();

        // Original method
        /*
        {
        return x * 32713 + y;
    }
        */
    }
    
    @Override public String toString(){
        return dsTaint.getTaintString();

        // Original method
        /*
        {
        return "Point(" + x + ", " + y+ ")";
    }
        */
    }
    
    @Override public int describeContents(){
        return dsTaint.getTaintInt();

        // Original method
        /*
        {
        return 0;
    }
        */
    }
    
    @Override public void writeToParcel(Parcel out, int flags){
        out.writeInt(x);
        out.writeInt(y);
        // Original method
        /*
        {
        out.writeInt(x);
        out.writeInt(y);
    }
        */
    }
    public static final Parcelable.Creator<Point> CREATOR = new Parcelable.Creator<Point>() {
        
        public Point createFromParcel(Parcel in) {
            Point r = new Point();
            r.readFromParcel(in);
            return r;
        }

        
        public Point[] newArray(int size) {
            return new Point[size];
        }
    };
    
    public void readFromParcel(Parcel in){
        // Original method
        /*
        {
        x = in.readInt();
        y = in.readInt();
    }
        */
    }
}

