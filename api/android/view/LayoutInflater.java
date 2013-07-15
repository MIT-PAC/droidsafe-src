package android.view;
import android.content.Context;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import android.util.AttributeSet;

public class LayoutInflater {
	@DSModeled(DSC.SAFE)
	public LayoutInflater() {
		
	}

	@DSModeled(DSC.SAFE)
	 public View inflate(int resource, ViewGroup root, boolean attachToRoot) {
		View newView = new View();
		return newView;	
	}
	
	@DSModeled(DSC.SAFE)
	public void setPrivateFactory(Factory2 factory) {
    }
	
    public interface Factory {
        public View onCreateView(String name, Context context, AttributeSet attrs);
    }


	public interface Factory2 extends Factory {

		public View onCreateView(View parent, String name, Context context, AttributeSet attrs);
	}


	
}
