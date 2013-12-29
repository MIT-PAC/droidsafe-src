package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.FloatMath;




public class PointF implements Parcelable {
    
    /**
     * Returns the euclidian distance from (0,0) to (x,y)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.363 -0500", hash_original_method = "465129C188D91F5542AA39E43CB0E49D", hash_generated_method = "1D2193BD88EC285E5911F89209C0F412")
    public static float length(float x, float y) {
        return FloatMath.sqrt(x * x + y * y);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.566 -0400", hash_original_field = "A8B72BB8FF20DCD3E42E3990C2FB1A2D", hash_generated_field = "290F12F848FCA2A5689B95FB1FE844BB")

    public static final Parcelable.Creator<PointF> CREATOR = new Parcelable.Creator<PointF>() {
        /**
         * Return a new point from the data in the specified parcel.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.367 -0500", hash_original_method = "61A0B58FC44A88594A723273F46294F0", hash_generated_method = "C4173C65484473D7D9921BE854FAB1D7")
        public PointF createFromParcel(Parcel in) {
            PointF r = new PointF();
            r.readFromParcel(in);
            return r;
        }

        /**
         * Return an array of rectangles of the specified size.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.368 -0500", hash_original_method = "F83030BA99FDC4DFE01ED7A9F8C375B2", hash_generated_method = "F0EEC024B5375C5D798963D867D8502C")
        public PointF[] newArray(int size) {
            return new PointF[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.355 -0500", hash_original_field = "EED2933541FCCE7155092AF77A402EA9", hash_generated_field = "0CC4A8770822EF2A4B3BD536BBF6C113")

    public float x;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.356 -0500", hash_original_field = "531E5158163E3809C8650CC9FEEE1C8C", hash_generated_field = "E8D9A0915E4274087E59C025C4DCDA11")

    public float y;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.356 -0500", hash_original_method = "AC71EBB0EDB844032A48DF20A80FB47B", hash_generated_method = "C7971DDDF14A176537AD598EA326BF59")
    public PointF() {}

    
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
    @Override public int describeContents(){
        return getTaintInt();
    }

    /**
     * Write this point to the specified parcel. To restore a point from
     * a parcel, use readFromParcel()
     * @param out The parcel to write the point's coordinates into
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.366 -0500", hash_original_method = "498F687E010E97B616DAA29FD28A4DFC", hash_generated_method = "714CC2DDD987CBCA3EFA76DDF3CD6A9D")
    @Override
public void writeToParcel(Parcel out, int flags) {
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
}

