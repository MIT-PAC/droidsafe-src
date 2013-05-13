package android.os;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Message implements Parcelable {
	Runnable callback;
	
	public Object obj;
	public int what;
	public int arg1;
	public int arg2;
	public int arg3;
	public int arg4;
	public int arg5;
	public int arg6;
	public int arg7;
	public int arg8;
	public int arg9;
	
	public Message() {
    }
	
	@DSModeled(DSC.SAFE)
	public static Message obtain() {
		return new Message();
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
		// TODO Auto-generated method stub
	}
}
