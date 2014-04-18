package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import android.os.Parcel;
import android.os.Parcelable;

public final class Rect implements Parcelable {
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static Rect unflattenFromString(String str){
		// Original method
        /*
        Matcher matcher = FLATTENED_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        */
        Rect rect = new Rect(DSUtils.FAKE_INT, DSUtils.FAKE_INT,
                             DSUtils.FAKE_INT, DSUtils.FAKE_INT);
        
        rect.addTaintLocal(str.getTaintInt());
        return rect;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static boolean intersects(Rect a, Rect b){
		// Original method
		/*
		{
        return a.left < b.right && b.left < a.right
               && a.top < b.bottom && b.top < a.bottom;
    }
		*/
        return toTaintBoolean(a.getSumTaintInt() + b.getSumTaintInt());
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:24.574 -0500", hash_original_field = "C827880A18B6ACBC60E1778FF671B928", hash_generated_field = "22CBDD4FA5AC4D71EB10C39DCFB71CD2")

    private static final Pattern FLATTENED_PATTERN = Pattern.compile(
            "(-?\\d+) (-?\\d+) (-?\\d+) (-?\\d+)");
    public static final Parcelable.Creator<Rect> CREATOR = new Parcelable.Creator<Rect>() {
        /**
         * Return a new rectangle from the data in the specified parcel.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:24.663 -0500", hash_original_method = "A9B8238B616BE351FF7BBE6405761278", hash_generated_method = "F945D9E311BDCA10D30B0106282427DE")
        
public Rect createFromParcel(Parcel in) {
            Rect r = new Rect();
            r.readFromParcel(in);
            return r;
        }

        /**
         * Return an array of rectangles of the specified size.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:24.666 -0500", hash_original_method = "6E3A450019A5044B67A49D3D4BD4953E", hash_generated_method = "A2E9B5AB9555B7EA582BEFC558753027")
        
public Rect[] newArray(int size) {
            return new Rect[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:24.565 -0500", hash_original_field = "F8DAB7F926CD7972429F7B948D9F5533", hash_generated_field = "1DC0B64660F00182FB9FBCCB50A51F92")

    public int left;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:24.567 -0500", hash_original_field = "9620536E5A5D6E12CC93092A5EBB857E", hash_generated_field = "4FB04C904AA02F82B407995BA570583C")

    public int top;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:24.569 -0500", hash_original_field = "49C6BE2EEC7270CFEAEFBD796F2C423B", hash_generated_field = "8D8E5E7DA2C11F273C631EF06D16F776")

    public int right;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:24.571 -0500", hash_original_field = "7F74B1869951CB3A6660AA746710A714", hash_generated_field = "F7035266BD2A20B12FE551C6FAE7D704")

    public int bottom;

    /**
     * Create a new empty Rect. All coordinates are initialized to 0.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:24.576 -0500", hash_original_method = "2824AA033EB3CD5BF749E2296CB51BE8", hash_generated_method = "C673E9B57A7025273AA936A51CDE4468")
    
public Rect() {}
    
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafeUpdateMembers() {
        this.bottom = getSumTaintInt();
        this.top    = getSumTaintInt();
        this.left   = getSumTaintInt();
        this.right  = getSumTaintInt();
    }

	@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    public Rect(int left, int top, int right, int bottom){
		addTaintLocal(left);
		addTaintLocal(top);
		addTaintLocal(right);
		addTaintLocal(bottom);
		/*
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		*/
		droidsafeUpdateMembers();
	}
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    public Rect(Rect r){
		addTaintLocal(r.getSumTaintInt());
		/*
		left = r.left;
		top = r.top;
		right = r.right;
		bottom = r.bottom;
		*/
		droidsafeUpdateMembers();
	}
    
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    private void addTaintLocal(double t) {
        super.addTaint(t);
        droidsafeUpdateMembers();
    }

    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    private void addTaintLocal(boolean t) {
        super.addTaint(t);
        droidsafeUpdateMembers();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @Override public boolean equals(Object obj){
		// Original method
		/*
		{
        Rect r = (Rect) obj;
        if (r != null) {
            return left == r.left && top == r.top && right == r.right
                    && bottom == r.bottom;
        }
        return false;
    }
		*/
        Rect r = (Rect) obj;
        if (r != null) {
            return toTaintBoolean(r.getSumTaintInt() + getSumTaintInt());
        }
 
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @Override public String toString(){
		// Original method
		/*
		{
        StringBuilder sb = new StringBuilder(32);
        sb.append("Rect("); sb.append(left); sb.append(", ");
        sb.append(top); sb.append(" - "); sb.append(right);
        sb.append(", "); sb.append(bottom); sb.append(")");
        return sb.toString();
    }
		*/
        String str = new String();
        str.addTaint(getSumTaintInt());
		return str;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public String toShortString(){
		// Original method
		/*
		{
        return toShortString(new StringBuilder(32));
    }
		*/
        String str = new String();
        str.addTaint(getSumTaintInt());
		return str;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public String toShortString(StringBuilder sb){
		// Original method
		/*
		{
        sb.setLength(0);
        sb.append('['); sb.append(left); sb.append(',');
        sb.append(top); sb.append("]["); sb.append(right);
        sb.append(','); sb.append(bottom); sb.append(']');
        return sb.toString();
    }
		*/
        sb.addTaint(getSumTaintInt());
		return sb.toString();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public String flattenToString(){
		// Original method
		/*
		{
        StringBuilder sb = new StringBuilder(32);
        sb.append(left);
        sb.append(' ');
        sb.append(top);
        sb.append(' ');
        sb.append(right);
        sb.append(' ');
        sb.append(bottom);
        return sb.toString();
    }
		*/
		return toShortString();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void printShortString(PrintWriter pw){
		// Original method
		/*
		{
        pw.print('['); pw.print(left); pw.print(',');
        pw.print(top); pw.print("]["); pw.print(right);
        pw.print(','); pw.print(bottom); pw.print(']');
    }
		*/
		//Return nothing
        pw.addTaint(getSumTaintInt());
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final boolean isEmpty(){
		// Original method
		/*
		{
        return left >= right || top >= bottom;
    }
		*/
		return toTaintBoolean(getSumTaintInt());
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final int width(){
		// Original method
		/*
		{
        return right - left;
    }
		*/
		return getSumTaintInt();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final int height(){
		// Original method
		/*
		{
        return bottom - top;
    }
		*/
		return getSumTaintInt();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final int centerX(){
		// Original method
		/*
		{
        return (left + right) >> 1;
    }
		*/
		return getSumTaintInt();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final int centerY(){
		// Original method
		/*
		{
        return (top + bottom) >> 1;
    }
		*/
		return getSumTaintInt();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final float exactCenterX(){
		// Original method
		/*
		{
        return (left + right) * 0.5f;
    }
		*/
		return getSumTaintInt();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final float exactCenterY(){
		// Original method
		/*
		{
        return (top + bottom) * 0.5f;
    }
		*/
		return getSumTaintInt();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void setEmpty(){
		// Original method
		/*
		{
        left = right = top = bottom = 0;
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void set(int left, int top, int right, int bottom){
		// Original method
		/*
		{
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }
		*/
		//Return nothing
        addTaintLocal(left + top + right + bottom);
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    public void set(Rect src){
		// Original method
		/*
		{
        this.left = src.left;
        this.top = src.top;
        this.right = src.right;
        this.bottom = src.bottom;
    }
		*/
        addTaintLocal(src.getSumTaintInt());
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void offset(int dx, int dy){
		// Original method
		/*
		{
        left += dx;
        top += dy;
        right += dx;
        bottom += dy;
    }
		*/
		//Return nothing
        addTaintLocal(dx + dy);
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void offsetTo(int newLeft, int newTop){
		addTaintLocal(newLeft + newTop);
		// Original method
		/*
		{
        right += newLeft - left;
        bottom += newTop - top;
        left = newLeft;
        top = newTop;
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void inset(int dx, int dy){
		// Original method
		/*
		{
        left += dx;
        top += dy;
        right -= dx;
        bottom -= dy;
    }
		*/
		//Return nothing
        addTaintLocal(dx + dy);
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean contains(int x, int y){
		// Original method
		/*
		{
        return left < right && top < bottom  
               && x >= left && x < right && y >= top && y < bottom;
    }
		*/
		return toTaintBoolean(x + y + getSumTaintInt());
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean contains(int left, int top, int right, int bottom){
		// Original method
		/*
		{
        return this.left < this.right && this.top < this.bottom
                && this.left <= left && this.top <= top
                && this.right >= right && this.bottom >= bottom;
    }
		*/
		return toTaintBoolean(left + top + right + bottom + getSumTaintInt());
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean contains(Rect r){
		// Original method
		/*
		{
        return this.left < this.right && this.top < this.bottom
               && left <= r.left && top <= r.top
               && right >= r.right && bottom >= r.bottom;
    }
		*/
		return toTaintBoolean(r.getSumTaintInt() + getSumTaintInt());
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean intersect(int left, int top, int right, int bottom){
		// Original method
		/*
		{
        if (this.left < right && left < this.right
                && this.top < bottom && top < this.bottom) {
            if (this.left < left) {
                this.left = left;
            }
            if (this.top < top) {
                this.top = top;
            }
            if (this.right > right) {
                this.right = right;
            }
            if (this.bottom > bottom) {
                this.bottom = bottom;
            }
            return true;
        }
        return false;
    }
		*/
        addTaintLocal(left + top + right + bottom);
		return getTaintBoolean();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean intersect(Rect r){
		// Original method
		/*
		{
        return intersect(r.left, r.top, r.right, r.bottom);
    }
		*/
        addTaintLocal(r.getSumTaintInt());
		return getTaintBoolean();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public boolean setIntersect(Rect a, Rect b){
		// Original method
		/*
		{
        if (a.left < b.right && b.left < a.right
                && a.top < b.bottom && b.top < a.bottom) {
            left = Math.max(a.left, b.left);
            top = Math.max(a.top, b.top);
            right = Math.min(a.right, b.right);
            bottom = Math.min(a.bottom, b.bottom);
            return true;
        }
        return false;
    }
		*/
        addTaintLocal(a.getSumTaintInt() + b.getSumTaintInt());
		return getTaintBoolean();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean intersects(int left, int top, int right, int bottom){
		// Original method
		/*
		{
        return this.left < right && left < this.right
               && this.top < bottom && top < this.bottom;
    }
		*/
        return toTaintBoolean(left + top + right + bottom + getSumTaintInt());
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void union(int left, int top, int right, int bottom){
		// Original method
		/*
		{
        if ((left < right) && (top < bottom)) {
            if ((this.left < this.right) && (this.top < this.bottom)) {
                if (this.left > left)
                    this.left = left;
                if (this.top > top)
                    this.top = top;
                if (this.right < right)
                    this.right = right;
                if (this.bottom < bottom)
                    this.bottom = bottom;
            } else {
                this.left = left;
                this.top = top;
                this.right = right;
                this.bottom = bottom;
            }
        }
    }
		*/
		//Return nothing

        addTaintLocal(left + top + right + bottom);
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void union(Rect r){
		// Original method
		/*
		{
        union(r.left, r.top, r.right, r.bottom);
    }
		*/
		//Return nothing
        addTaintLocal(r.getSumTaintInt());
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void union(int x, int y){
		// Original method
		/*
		{
        if (x < left) {
            left = x;
        } else if (x > right) {
            right = x;
        }
        if (y < top) {
            top = y;
        } else if (y > bottom) {
            bottom = y;
        }
    }
		*/
		//Return nothing
        addTaintLocal(x + y);
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void sort(){
		// Original method
		/*
		{
        if (left > right) {
            int temp = left;
            left = right;
            right = temp;
        }
        if (top > bottom) {
            int temp = top;
            top = bottom;
            bottom = temp;
        }
    }
		*/
		//Return nothing
	}

    /**
     * Parcelable interface methods
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:24.658 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return getSumTaintInt();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void writeToParcel(Parcel out, int flags){
		// Original method
		/*
		{
        out.writeInt(left);
        out.writeInt(top);
        out.writeInt(right);
        out.writeInt(bottom);
    }
		*/
		//Return nothing
        out.addTaint(getSumTaintInt() + flags);
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void readFromParcel(Parcel in){
		// Original method
		/*
		{
        left = in.readInt();
        top = in.readInt();
        right = in.readInt();
        bottom = in.readInt();
    }
		*/
		//Return nothing
        addTaintLocal(in.getTaintInt());
		droidsafeUpdateMembers();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void scale(float scale){
		// Original method
		/*
		{
        if (scale != 1.0f) {
            left = (int) (left * scale + 0.5f);
            top = (int) (top * scale + 0.5f);
            right = (int) (right * scale + 0.5f);
            bottom = (int) (bottom * scale + 0.5f);
        }
    }
		*/
		//Return nothing
        addTaintLocal(scale);
	}
    
    public int getSumTaintInt() {
        return (int)(getSumTaintInt() + bottom + top + left + right);
    }
}

