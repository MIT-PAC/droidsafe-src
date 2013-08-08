package android.graphics;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;



public class Point implements Parcelable {
    public int x;
    public int y;
    
    @DSModeled(DSC.SAFE)
    public Point(){
    }

    
    @DSModeled(DSC.SAFE)
    public Point(int x, int y){
        addTaint(x);
        addTaint(y);
    }

    
    @DSModeled(DSC.SAFE)
    public Point(Point src){
        addTaint(src.getTaint());
        /*
        this.x = src.x;
        this.y = src.y;
        */
    }

    
    @DSModeled(DSC.SAFE)
    public void set(int x, int y){
        addTaint(x);
        addTaint(y);
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
        addTaint(x);
        addTaint(y);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public final boolean equals(int x, int y){
        return getTaintBoolean();
        // Original method
        /*
        {
        return this.x == x && this.y == y;
    }
        */
    }

    
    @DSModeled(DSC.SAFE)
    @Override public boolean equals(Object o){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Point p = (Point) o;
        return getTaintBoolean();
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

    
    @DSModeled(DSC.SAFE)
    @Override public int hashCode(){
        return getTaintInt();
        // Original method
        /*
        {
        return x * 32713 + y;
    }
        */
    }

    
    @DSModeled(DSC.SAFE)
    @Override public String toString(){
        String str = new String();
        str.addTaint(getTaint());
        return str;
        // Original method
        /*
        {
        return "Point(" + x + ", " + y+ ")";
    }
        */
    }

    
    @DSModeled(DSC.SAFE)
    @Override public int describeContents(){
        return getTaintInt();
        // Original method
        /*
        {
        return 0;
    }
        */
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public void readFromParcel(Parcel in){
        // Original method
        /*
        {
        x = in.readInt();
        y = in.readInt();
    }
        */
    }

    
    public static final Parcelable.Creator<Point> CREATOR = new Parcelable.Creator<Point>() {
        
        public Point createFromParcel(Parcel in) {
            Point r = new Point();
            r.readFromParcel(in);
            return r;
        }

        
        @DSModeled(DSC.SAFE)
        public Point[] newArray(int size) {
            return new Point[size];
        }
    };
}

