package android.app;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Fragment implements ComponentCallbacks2, OnCreateContextMenuListener {

	@DSModeled	
	public Fragment() {
		onCreateView(new LayoutInflater(), null, null);
	}
	
	@DSModeled
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//return null;
		return new View(container.getContext());
		
	}
	
	@Override
	public void onConfigurationChanged(Configuration arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTrimMemory(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@DSModeled
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		
	}


}
