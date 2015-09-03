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
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

/**
 * A toast is a view containing a quick little message for the user.  The toast class
 * helps you create and show those.
 * {@more}
 *
 * <p>
 * When the view is shown to the user, appears as a floating view over the
 * application.  It will never receive focus.  The user will probably be in the
 * middle of typing something else.  The idea is to be as unobtrusive as
 * possible, while still showing the user the information you want them to see.
 * Two examples are the volume control, and the brief message saying that your
 * settings have been saved.
 * <p>
 * The easiest way to use this class is to call one of the static methods that constructs
 * everything you need and returns a new Toast object.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about creating Toast notifications, read the
 * <a href="{@docRoot}guide/topics/ui/notifiers/toasts.html">Toast Notifications</a> developer
 * guide.</p>
 * </div>
 */ 
public class Toast {
    static final String TAG = "Toast";
    static final boolean localLOGV = false;
    
    /**
     * Show the view or text notification for a short period of time.  This time
     * could be user-definable.  This is the default.
     * @see #setDuration
     */
    public static final int LENGTH_SHORT = 0;

    /**
     * Show the view or text notification for a long period of time.  This time
     * could be user-definable.
     * @see #setDuration
     */
    public static final int LENGTH_LONG = 1;

    final Context mContext;
    //final TN mTN;
    int mDuration;
    View mNextView;

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context  The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     */
    @DSModeled(DSC.SAFE)
    public Toast(Context context) {
        mContext = context;
        /*
        mTN = new TN();
        mTN.mY = context.getResources().getDimensionPixelSize(
                com.android.internal.R.dimen.toast_y_offset);
         */
    }
    
    /**
     * Show the view for the specified duration.
     */
    @DSModeled(DSC.SAFE)
    public void show() {
    	/*  DSModel: nothing
        if (mNextView == null) {
            throw new RuntimeException("setView must have been called");
        }

        INotificationManager service = getService();
        String pkg = mContext.getPackageName();
        TN tn = mTN;
        tn.mNextView = mNextView;

        try {
            service.enqueueToast(pkg, tn, mDuration);
        } catch (RemoteException e) {
            // Empty
        }*/
    }

    /**
     * Close the view if it's showing, or don't show it if it isn't showing yet.
     * You do not normally have to call this.  Normally view will disappear on its own
     * after the appropriate duration.
     */
    @DSModeled(DSC.SAFE)
    public void cancel() {
        //mTN.hide();
    }
    
    /**
     * Set the view to show.
     * @see #getView
     */
    public void setView(View view) {
        mNextView = view;
    }

    /**
     * Return the view.
     * @see #setView
     */
    public View getView() {
        return mNextView;
    }

    /**
     * Set how long to show the view for.
     * @see #LENGTH_SHORT
     * @see #LENGTH_LONG
     */
    public void setDuration(int duration) {
        mDuration = duration;
    }

    /**
     * Return the duration.
     * @see #setDuration
     */
    public int getDuration() {
        return mDuration;
    }
    
    /**
     * Set the margins of the view.
     *
     * @param horizontalMargin The horizontal margin, in percentage of the
     *        container width, between the container's edges and the
     *        notification
     * @param verticalMargin The vertical margin, in percentage of the
     *        container height, between the container's edges and the
     *        notification
     */
    @DSModeled(DSC.SAFE)
    public void setMargin(float horizontalMargin, float verticalMargin) {
    	addTaint(horizontalMargin);
    	addTaint(verticalMargin);
    	//DSModel nothing
        //mTN.mHorizontalMargin = horizontalMargin;
        //mTN.mVerticalMargin = verticalMargin;
    }

    /**
     * Return the horizontal margin.
     */
    @DSModeled(DSC.SAFE)
    public float getHorizontalMargin() {
        return getTaintFloat();
    }

    /**
     * Return the vertical margin.
     */
    @DSModeled(DSC.SAFE)
    public float getVerticalMargin() {
    	 return getTaintFloat();
    }

    /**
     * Set the location at which the notification should appear on the screen.
     * @see android.view.Gravity
     * @see #getGravity
     */
    @DSModeled(DSC.SAFE)
    //just spread around 
    public void setGravity(int gravity, int xOffset, int yOffset) {
    	addTaint(gravity);
    	addTaint(xOffset);
    	addTaint(yOffset);
    }

     /**
     * Get the location at which the notification should appear on the screen.
     * @see android.view.Gravity
     * @see #getGravity
     */
    @DSModeled(DSC.SAFE)
    public int getGravity() {
        return getTaintInt();
    }

    /**
     * Return the X offset in pixels to apply to the gravity's location.
     */
    @DSModeled(DSC.SAFE)
    public int getXOffset() {
    	return getTaintInt();
    }
    
    /**
     * Return the Y offset in pixels to apply to the gravity's location.
     */
    @DSModeled(DSC.SAFE)
    public int getYOffset() {
    	return getTaintInt();
    }
    
    /**
     * Make a standard toast that just contains a text view.
     *
     * @param context  The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     * @param text     The text to show.  Can be formatted text.
     * @param duration How long to display the message.  Either {@link #LENGTH_SHORT} or
     *                 {@link #LENGTH_LONG}
     *
     */
    @DSModeled()
    public static Toast makeText(Context context, CharSequence text, int duration) {
        Toast result = new Toast(context);
        result.addTaint(text.getTaint());
        result.addTaint(duration);

        /*  DSModel: Not needed for ds modeling
        LayoutInflater inflate = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(com.android.internal.R.layout.transient_notification, null);
        TextView tv = (TextView)v.findViewById(com.android.internal.R.id.message);
        tv.setText(text);
        
        result.mNextView = v;
        result.mDuration = duration;
         */
        return result;
    }

    /**
     * Make a standard toast that just contains a text view with the text from a resource.
     *
     * @param context  The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     * @param resId    The resource id of the string resource to use.  Can be formatted text.
     * @param duration How long to display the message.  Either {@link #LENGTH_SHORT} or
     *                 {@link #LENGTH_LONG}
     *
     * @throws Resources.NotFoundException if the resource can't be found.
     */
    @DSModeled()
    public static Toast makeText(Context context, int resId, int duration)
                                throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(resId), duration);
    }

    /**
     * Update the text in a Toast that was previously created using one of the makeText() methods.
     * @param resId The new text for the Toast.
     */
    @DSModeled(DSC.SAFE)
    public void setText(int resId) {
        addTaint(resId);
    }
    
    /**
     * Update the text in a Toast that was previously created using one of the makeText() methods.
     * @param s The new text for the Toast.
     */
    @DSModeled(DSC.SAFE)
    public void setText(CharSequence s) {
    	addTaint(s.toString().getTaint());
    	/*
        if (mNextView == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        TextView tv = (TextView) mNextView.findViewById(com.android.internal.R.id.message);
        if (tv == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        tv.setText(s);
        */
    }


   
}
