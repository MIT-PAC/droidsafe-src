package android.os;

public class Message implements Parcelable {
	Runnable callback;
	
	public Object obj;
	public int what;
	
	public Message() {
    }
	
	public Message obtain() {
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
