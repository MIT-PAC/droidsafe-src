package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.PrintWriter;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.FloatMath;
import com.android.internal.util.FastMath;

public class RectF implements Parcelable {
    private float left;
    private float top;
    private float right;
    private float bottom;
    
    @DSModeled(DSC.SAFE)
    public RectF() {
    }

    
    @DSModeled(DSC.SAFE)
    public RectF(float left, float top, float right, float bottom) {    
    	this();
    	addTaint(left);
    	addTaint(top);
    	addTaint(right);
    	addTaint(bottom);
    }

    
    @DSModeled(DSC.SAFE)
    public RectF(RectF r) { 
    	this();
    	addTaint(r.getTaint());
    }

    
    @DSModeled(DSC.SAFE)
    public RectF(Rect r) {
    	this();
    	addTaint(r.left);
    	addTaint(r.right);
    	addTaint(r.top);
    	addTaint(r.bottom);
    }

    
    @DSModeled(DSC.SAFE)
    public String toString() {
    	String str = new String();
    	return str;        
    }

    
    @DSModeled(DSC.SAFE)
    public String toShortString() {    	
    	String str = new String("");
        return str;
    }

    
    @DSModeled (DSC.SAFE)
    public String toShortString(StringBuilder sb) {    	
    	sb.append(1);
    	return sb.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public void printShortString(PrintWriter pw) {
    	char c = 0;
    	pw.append(c);
    }

    
    @DSModeled(DSC.SAFE)
    public final boolean isEmpty() {
        return false;
    }

    
    @DSModeled(DSC.SAFE)
    public final float width() {
    	return getTaintInt();
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    public final float height() {
    	return getTaintInt();
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    public final float centerX() {
        return 0;
    }

    
    @DSModeled(DSC.SAFE)
    public final float centerY() {
        return 0;
    }

    
    @DSModeled(DSC.SAFE)
    public void setEmpty() {
    	//addTaint(0.getTaint());	//No need to track , just an initializer type function setting things to 0   
    }

    
    @DSModeled(DSC.SAFE)
    public void set(float left, float top, float right, float bottom) {
    	addTaint(left);
    	addTaint(top);
    	addTaint(right);
    	addTaint(bottom);  
    }

    
    @DSModeled(DSC.SAFE)
    public void set(RectF src) {
    	addTaint(src.getTaint());
    }

    
    @DSModeled(DSC.SAFE)
    public void set(Rect src) {
    	addTaint(src.left);
    	addTaint(src.top);
    	addTaint(src.right);
    	addTaint(src.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.321 -0400", hash_original_method = "987CF6DAC95BF2616996F2B7580ECF09", hash_generated_method = "69E19F3AA943EB5750A9E7830A61E539")
    public void offset(float dx, float dy) {
        left    += dx;
        top     += dy;
        right   += dx;
        bottom  += dy;
        // ---------- Original Method ----------
        //left    += dx;
        //top     += dy;
        //right   += dx;
        //bottom  += dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.322 -0400", hash_original_method = "17E8F6A0DA6BEF949708E45EF28FBDEC", hash_generated_method = "84DEB00742BF1B269391B92566372004")
    public void offsetTo(float newLeft, float newTop) {
        right += newLeft - left;
        bottom += newTop - top;
        left = newLeft;
        top = newTop;
        // ---------- Original Method ----------
        //right += newLeft - left;
        //bottom += newTop - top;
        //left = newLeft;
        //top = newTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.322 -0400", hash_original_method = "4ED8FEC7EC4817417CFF539CEB8CD3D5", hash_generated_method = "04F62736CE8F4E9564C2C46286D37109")
    public void inset(float dx, float dy) {
        left    += dx;
        top     += dy;
        right   -= dx;
        bottom  -= dy;
        // ---------- Original Method ----------
        //left    += dx;
        //top     += dy;
        //right   -= dx;
        //bottom  -= dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.323 -0400", hash_original_method = "7C65F21BA78E9C886CB99F3A821D7FC2", hash_generated_method = "EE912AFE5FA3DC0BF637383173073A1B")
    public boolean contains(float x, float y) {
        addTaint(y);
        addTaint(x);
        boolean var25BF9CC4752259093CAAA87DDA4C0BD6_1022253666 = (left < right && top < bottom  
                && x >= left && x < right && y >= top && y < bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_239459619 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_239459619;
        // ---------- Original Method ----------
        //return left < right && top < bottom  
                //&& x >= left && x < right && y >= top && y < bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.323 -0400", hash_original_method = "5736B1A89F8587C3C51B72E5484012E7", hash_generated_method = "5BCBCD28F6E9B249A61D7B407DB8300C")
    public boolean contains(float left, float top, float right, float bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean varA66DD9D365F5FD000A7A0453D2434F55_881613896 = (this.left < this.right && this.top < this.bottom
                && this.left <= left && this.top <= top
                && this.right >= right && this.bottom >= bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_519851139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_519851139;
        // ---------- Original Method ----------
        //return this.left < this.right && this.top < this.bottom
                //&& this.left <= left && this.top <= top
                //&& this.right >= right && this.bottom >= bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.324 -0400", hash_original_method = "89862D8BCB63DE9E9B3F12DF7005EDAF", hash_generated_method = "D685C9BEEB5A1A9834A3AD00FE512680")
    public boolean contains(RectF r) {
        addTaint(r.getTaint());
        boolean varCB22694901ED7DDFB5C7128EDFABB063_1347241795 = (this.left < this.right && this.top < this.bottom
                && left <= r.left && top <= r.top
                && right >= r.right && bottom >= r.bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1054352022 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1054352022;
        // ---------- Original Method ----------
        //return this.left < this.right && this.top < this.bottom
                //&& left <= r.left && top <= r.top
                //&& right >= r.right && bottom >= r.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.326 -0400", hash_original_method = "B665C4D2FA87DEF248CEB5906A538992", hash_generated_method = "A4724ED46658EAB25F2D629F70B27318")
    public boolean intersect(float left, float top, float right, float bottom) {
        if(this.left < right && left < this.right
                && this.top < bottom && top < this.bottom)        
        {
            if(this.left < left)            
            {
                this.left = left;
            } //End block
            if(this.top < top)            
            {
                this.top = top;
            } //End block
            if(this.right > right)            
            {
                this.right = right;
            } //End block
            if(this.bottom > bottom)            
            {
                this.bottom = bottom;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_966622397 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1240158391 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1240158391;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_805928674 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1521706810 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1521706810;
        // ---------- Original Method ----------
        //if (this.left < right && left < this.right
                //&& this.top < bottom && top < this.bottom) {
            //if (this.left < left) {
                //this.left = left;
            //}
            //if (this.top < top) {
                //this.top = top;
            //}
            //if (this.right > right) {
                //this.right = right;
            //}
            //if (this.bottom > bottom) {
                //this.bottom = bottom;
            //}
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.326 -0400", hash_original_method = "F1511D7F30AFB03A76430BC5FB3647DC", hash_generated_method = "D69879488389F1A0B65E03BCA36935E9")
    public boolean intersect(RectF r) {
        addTaint(r.getTaint());
        boolean varBDDD5DA93332D9D54ACD4F6F853C3B70_171291034 = (intersect(r.left, r.top, r.right, r.bottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_328405121 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_328405121;
        // ---------- Original Method ----------
        //return intersect(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.329 -0400", hash_original_method = "798EF6BEBDE27EE5C0F4552CB6C0BADF", hash_generated_method = "6AD1B606FED4A2C4AAEEB991D25D80C5")
    public boolean setIntersect(RectF a, RectF b) {
        if(a.left < b.right && b.left < a.right
                && a.top < b.bottom && b.top < a.bottom)        
        {
            left = Math.max(a.left, b.left);
            top = Math.max(a.top, b.top);
            right = Math.min(a.right, b.right);
            bottom = Math.min(a.bottom, b.bottom);
            boolean varB326B5062B2F0E69046810717534CB09_1284561145 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2111817355 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2111817355;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1805379290 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1985960004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1985960004;
        // ---------- Original Method ----------
        //if (a.left < b.right && b.left < a.right
                //&& a.top < b.bottom && b.top < a.bottom) {
            //left = Math.max(a.left, b.left);
            //top = Math.max(a.top, b.top);
            //right = Math.min(a.right, b.right);
            //bottom = Math.min(a.bottom, b.bottom);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.330 -0400", hash_original_method = "7636A1ABF3E5D698C7B1F582C19267F0", hash_generated_method = "39077DB506F085499BB7E423D1C904E5")
    public boolean intersects(float left, float top, float right,
                              float bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean varF9D0769DA301445206C652D15DD88A78_1055915621 = (this.left < right && left < this.right
                && this.top < bottom && top < this.bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_730180473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_730180473;
        // ---------- Original Method ----------
        //return this.left < right && left < this.right
                //&& this.top < bottom && top < this.bottom;
    }

    
    public static boolean intersects(RectF a, RectF b) {
        return a.left < b.right && b.left < a.right
                && a.top < b.bottom && b.top < a.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.331 -0400", hash_original_method = "1D9E886326ACAAED42A7320F81B83BDE", hash_generated_method = "3DDC4F376A4EE8E084A0EF39CD957DCB")
    public void round(Rect dst) {
        addTaint(dst.getTaint());
        dst.set(FastMath.round(left), FastMath.round(top),
                FastMath.round(right), FastMath.round(bottom));
        // ---------- Original Method ----------
        //dst.set(FastMath.round(left), FastMath.round(top),
                //FastMath.round(right), FastMath.round(bottom));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.331 -0400", hash_original_method = "5165AD4866DE272C811B07E7C1D571CC", hash_generated_method = "1F275E2CCBC62A047D6A759361926175")
    public void roundOut(Rect dst) {
        addTaint(dst.getTaint());
        dst.set((int) FloatMath.floor(left), (int) FloatMath.floor(top),
                (int) FloatMath.ceil(right), (int) FloatMath.ceil(bottom));
        // ---------- Original Method ----------
        //dst.set((int) FloatMath.floor(left), (int) FloatMath.floor(top),
                //(int) FloatMath.ceil(right), (int) FloatMath.ceil(bottom));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.332 -0400", hash_original_method = "4ED17A6A0BD221C6F562FF187EDE0EC1", hash_generated_method = "0985665CC34BA903BEF0108EFE0E233D")
    public void union(float left, float top, float right, float bottom) {
        if((left < right) && (top < bottom))        
        {
            if((this.left < this.right) && (this.top < this.bottom))            
            {
                if(this.left > left)                
                this.left = left;
                if(this.top > top)                
                this.top = top;
                if(this.right < right)                
                this.right = right;
                if(this.bottom < bottom)                
                this.bottom = bottom;
            } //End block
            else
            {
                this.left = left;
                this.top = top;
                this.right = right;
                this.bottom = bottom;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if ((left < right) && (top < bottom)) {
            //if ((this.left < this.right) && (this.top < this.bottom)) {
                //if (this.left > left)
                    //this.left = left;
                //if (this.top > top)
                    //this.top = top;
                //if (this.right < right)
                    //this.right = right;
                //if (this.bottom < bottom)
                    //this.bottom = bottom;
            //} else {
                //this.left = left;
                //this.top = top;
                //this.right = right;
                //this.bottom = bottom;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.333 -0400", hash_original_method = "7333A4F184A018E8DCD665D788936108", hash_generated_method = "488F1849C916BD78F32B6DED7CCA4767")
    public void union(RectF r) {
        addTaint(r.getTaint());
        union(r.left, r.top, r.right, r.bottom);
        // ---------- Original Method ----------
        //union(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.334 -0400", hash_original_method = "5491E96A191FF9AA58559CF28A27B675", hash_generated_method = "CA5B36864605D093C669765F523DEF4A")
    public void union(float x, float y) {
        if(x < left)        
        {
            left = x;
        } //End block
        else
        if(x > right)        
        {
            right = x;
        } //End block
        if(y < top)        
        {
            top = y;
        } //End block
        else
        if(y > bottom)        
        {
            bottom = y;
        } //End block
        // ---------- Original Method ----------
        //if (x < left) {
            //left = x;
        //} else if (x > right) {
            //right = x;
        //}
        //if (y < top) {
            //top = y;
        //} else if (y > bottom) {
            //bottom = y;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.335 -0400", hash_original_method = "5E187609DBD260B5F8E2F7AA44836C46", hash_generated_method = "6E8A505939D38FD3959D3E0F9920FADC")
    public void sort() {
        if(left > right)        
        {
            float temp = left;
            left = right;
            right = temp;
        } //End block
        if(top > bottom)        
        {
            float temp = top;
            top = bottom;
            bottom = temp;
        } //End block
        // ---------- Original Method ----------
        //if (left > right) {
            //float temp = left;
            //left = right;
            //right = temp;
        //}
        //if (top > bottom) {
            //float temp = top;
            //top = bottom;
            //bottom = temp;
        //}
    }

    
    @Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.336 -0400", hash_original_method = "5C789B83F9658DFF3AD82091DAFFDD49", hash_generated_method = "8AF90B799398630A2D8FEE2DEEF7185B")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeFloat(left);
        out.writeFloat(top);
        out.writeFloat(right);
        out.writeFloat(bottom);
        // ---------- Original Method ----------
        //out.writeFloat(left);
        //out.writeFloat(top);
        //out.writeFloat(right);
        //out.writeFloat(bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.336 -0400", hash_original_method = "BACCEAD3B6EC38250A4D00D9AA0D9F78", hash_generated_method = "5840D49EC2222CD5F0BDEB5ED8E3F923")
    public void readFromParcel(Parcel in) {
        left = in.readFloat();
        top = in.readFloat();
        right = in.readFloat();
        bottom = in.readFloat();
        // ---------- Original Method ----------
        //left = in.readFloat();
        //top = in.readFloat();
        //right = in.readFloat();
        //bottom = in.readFloat();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.336 -0400", hash_original_field = "5E7201C60E05C026DD3550B3101B80A5", hash_generated_field = "C46FA4AE8D434E2146AE8F7264B82507")

    public static final Parcelable.Creator<RectF> CREATOR = new Parcelable.Creator<RectF>() {
        
        public RectF createFromParcel(Parcel in) {
            RectF r = new RectF();
            r.readFromParcel(in);
            return r;
        }
        
        
        public RectF[] newArray(int size) {
            return new RectF[size];
        }
    };
    // orphaned legacy method
    @DSModeled(DSC.SAFE)
	public final float top() {
		return getTaintFloat();
	}
    
    // orphaned legacy method
    @DSModeled(DSC.SAFE)
	public final float left() {
		return getTaintFloat();
	}
    
    // orphaned legacy method
    @Override
	public void writeToParcel(Parcel arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
    
}

