/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package android.view;

import java.util.Random;

import com.android.internal.policy.PolicyManager;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder.Callback2;
import android.view.ViewGroup.LayoutParams;
// Droidsafe imports
import droidsafe.annotations.*;

/**
 * Created this class to provide a {@link Window} object for Droidsafe PTA.
 * 
 * @author droidsafe
 *
 */
public class WindowImpl extends Window {

	public Context context = null;
	
    public WindowImpl(Context context) {
		super(context);
		this.context = context;
	}

	@Override
	public void takeSurface(Callback2 callback) {
		// TODO: perform callback invocation
	    if (callback != null) {
	        addTaint(callback.getTaint());
	    }
	}

	@Override
	public void takeInputQueue(android.view.InputQueue.Callback callback) {
		// TODO Auto-generated method stub
	    addTaint(callback.getTaint());
	    android.view.InputQueue inputQueue = new InputQueue(null);
	    callback.onInputQueueCreated(inputQueue);
	    callback.onInputQueueDestroyed(inputQueue);
	}

	@Override
	public boolean isFloating() {
		// TODO Auto-generated method stub
		return getTaintBoolean();
	}

	@Override
	public void alwaysReadCloseOnTouchAttr() {
		// TODO Auto-generated method stub

	}
	
    @Override
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub

	}
	
    @Override
	public void setContentView(View view) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addContentView(View view, LayoutParams params) {
		// TODO Auto-generated method stub

	}

	@Override
	public View getCurrentFocus() {
		// TODO Auto-generated method stub
        View v = new View();
        v.addTaint(getTaint());
		return v;
	}

	@Override
	public LayoutInflater getLayoutInflater() {
		// TODO Auto-generated method stub
	       LayoutInflater manager = PolicyManager.makeNewLayoutInflater(getContext());
           manager.addTaint(getTaint());
           return manager;
	}

	@Override
	public void setTitle(CharSequence title) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTitleColor(int textColor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void openPanel(int featureId, KeyEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void closePanel(int featureId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void togglePanel(int featureId, KeyEvent event) {
		// TODO Auto-generated method stub

	}
	
    @Override
	public void invalidatePanelMenu(int featureId) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean performPanelShortcut(int featureId, int keyCode,
			KeyEvent event, int flags) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean performPanelIdentifierAction(int featureId, int id, int flags) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void closeAllPanels() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean performContextMenuIdentifierAction(int id, int flags) {
		// TODO Auto-generated method stub
		return false;
	}
	
    @Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBackgroundDrawable(Drawable drawable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFeatureDrawableResource(int featureId, int resId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFeatureDrawableUri(int featureId, Uri uri) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFeatureDrawable(int featureId, Drawable drawable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFeatureDrawableAlpha(int featureId, int alpha) {
		// TODO Auto-generated method stub

	}

	@DSSafe(DSCat.SAFE_LIST)
    @Override
	public void setFeatureInt(int featureId, int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void takeKeyEvents(boolean get) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean superDispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean superDispatchKeyShortcutEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean superDispatchTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean superDispatchTrackballEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean superDispatchGenericMotionEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	
    @DSSafe(DSCat.GUI)
    @Override
	public View getDecorView() {
		// TODO Auto-generated method stub
		View view = new View();
        view.addTaint(getTaint());
        return view;
	}
	
	@Override
	public View peekDecorView() {
		// TODO Auto-generated method stub
	    View view = new View();
	    view.addTaint(getTaint());
	    return view;
	}
	
    @Override
	public Bundle saveHierarchyState() {
		// TODO Auto-generated method stub
		return new Bundle();
	}

	@Override
	public void restoreHierarchyState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onActive() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setChildDrawable(int featureId, Drawable drawable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setChildInt(int featureId, int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isShortcutKey(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	
    @Override
	public void setVolumeControlStream(int streamType) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getVolumeControlStream() {
		// TODO Auto-generated method stub
		return 0;
	}

}
