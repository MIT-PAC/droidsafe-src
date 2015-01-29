package android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class ListView extends AbsListView {

	public ListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public ListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@DSModeled(DSC.SAFE)
	public ListView(Context context) {
		super(context);
	}

	@DSModeled(DSC.SAFE)
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}
	
	@Override
	@DSModeled(DSC.SAFE)
	public void setAdapter(ListAdapter adapter) {
		super.setAdapter(adapter); // Taint in AbsListView
	}
	
	@Override
	void fillGap(boolean down) {
		// TODO Auto-generated method stub
		
	}

	@Override
	int findMotionRow(int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void setSelectionInt(int position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateViewLayout(View view,
			android.view.ViewGroup.LayoutParams params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListAdapter getAdapter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSelection(int position) {
		// TODO Auto-generated method stub
		
	}

}
