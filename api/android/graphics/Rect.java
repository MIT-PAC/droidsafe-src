package android.graphics;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import android.os.Parcel;
import android.os.Parcelable;



public final class Rect implements Parcelable {
    public int left;
    public int top;
    public int right;
    public int bottom;
    
    @DSModeled(DSC.SAFE)
	public Rect(){
	}

    
    @DSModeled(DSC.SAFE)
	public Rect(int left, int top, int right, int bottom){
		addTaint(left);
		addTaint(top);
		addTaint(right);
		addTaint(bottom);
		/*
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public Rect(Rect r){
		addTaint(r.getTaint());
		/*
		left = r.left;
		top = r.top;
		right = r.right;
		bottom = r.bottom;
		*/
	}

    
    @DSModeled(DSC.SAFE)
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
		return false;
	}

    
    @DSModeled(DSC.SAFE)
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
		return "";
	}

    
    @DSModeled(DSC.SAFE)
    public String toShortString(){
		// Original method
		/*
		{
        return toShortString(new StringBuilder(32));
    }
		*/
		return "";
	}

    
    @DSModeled(DSC.BAN)
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
		return "";
	}

    
    @DSModeled(DSC.SAFE)
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
		return "";
	}

    
    @DSModeled(DSC.SAFE)
    public static Rect unflattenFromString(String str){
		// Original method
		/*
		{
        Matcher matcher = FLATTENED_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        return new Rect(Integer.parseInt(matcher.group(1)),
                Integer.parseInt(matcher.group(2)),
                Integer.parseInt(matcher.group(3)),
                Integer.parseInt(matcher.group(4)));
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.BAN)
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
	}

    
    @DSModeled(DSC.SAFE)
    public final boolean isEmpty(){
		// Original method
		/*
		{
        return left >= right || top >= bottom;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public final int width(){
		// Original method
		/*
		{
        return right - left;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public final int height(){
		// Original method
		/*
		{
        return bottom - top;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public final int centerX(){
		// Original method
		/*
		{
        return (left + right) >> 1;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public final int centerY(){
		// Original method
		/*
		{
        return (top + bottom) >> 1;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public final float exactCenterX(){
		// Original method
		/*
		{
        return (left + right) * 0.5f;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public final float exactCenterY(){
		// Original method
		/*
		{
        return (top + bottom) * 0.5f;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public void setEmpty(){
		// Original method
		/*
		{
        left = right = top = bottom = 0;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
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
	}

    
    @DSModeled(DSC.SAFE)
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
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
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
	}

    
    @DSModeled(DSC.SAFE)
    public void offsetTo(int newLeft, int newTop){
		addTaint(newLeft);
		left = newLeft;  //Preserved
		addTaint(newTop);
		top = newTop;  //Preserved
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

    
    @DSModeled(DSC.SAFE)
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
	}

    
    @DSModeled(DSC.SAFE)
    public boolean contains(int x, int y){
		// Original method
		/*
		{
        return left < right && top < bottom  
               && x >= left && x < right && y >= top && y < bottom;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean contains(int left, int top, int right, int bottom){
		// Original method
		/*
		{
        return this.left < this.right && this.top < this.bottom
                && this.left <= left && this.top <= top
                && this.right >= right && this.bottom >= bottom;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean contains(Rect r){
		// Original method
		/*
		{
        return this.left < this.right && this.top < this.bottom
               && left <= r.left && top <= r.top
               && right >= r.right && bottom >= r.bottom;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
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
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean intersect(Rect r){
		// Original method
		/*
		{
        return intersect(r.left, r.top, r.right, r.bottom);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
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
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean intersects(int left, int top, int right, int bottom){
		// Original method
		/*
		{
        return this.left < right && left < this.right
               && this.top < bottom && top < this.bottom;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean intersects(Rect a, Rect b){
		// Original method
		/*
		{
        return a.left < b.right && b.left < a.right
               && a.top < b.bottom && b.top < a.bottom;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
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
	}

    
    @DSModeled(DSC.SAFE)
    public void union(Rect r){
		// Original method
		/*
		{
        union(r.left, r.top, r.right, r.bottom);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
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
	}

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public int describeContents(){
		// Original method
		/*
		{
        return 0;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
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
	}

    
    @DSModeled(DSC.SAFE)
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
	}

    
    @DSModeled(DSC.BAN)
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
	}

    
    private static final Pattern FLATTENED_PATTERN = Pattern.compile(
            "(-?\\d+) (-?\\d+) (-?\\d+) (-?\\d+)");
    public static final Parcelable.Creator<Rect> CREATOR = new Parcelable.Creator<Rect>() {
        
        public Rect createFromParcel(Parcel in) {
            Rect r = new Rect();
            r.readFromParcel(in);
            return r;
        }

        
        @DSModeled(DSC.SAFE)
        public Rect[] newArray(int size) {
            return new Rect[size];
        }
    };
}

