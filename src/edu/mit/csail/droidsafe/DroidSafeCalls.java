package edu.mit.csail.droidsafe;

import android.widget.TextView;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DigitalClock;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * The DroidSafeCalls class provides standard methods for accomplishing specific
 * tasks in Android.  Use of these methods simplifies the specification and
 * in some cases is mandatory for compliance.
 */

public class DroidSafeCalls {

  private static boolean bad_tv (TextView tv) {
    return (tv instanceof Button) || (tv instanceof Chronometer)
      || (tv instanceof DigitalClock);
  }

  /**
   * Set the text in a TextView.  This is safe (users expect arbitrary text
   * in a text view).  But changing button names (which this call does
   * for the Button class) can fool a user (and is thus not allowed).  Button
   * text can only be specified in an XML file
   */
  public static void setText(TextView tv, int resid) {
    if (bad_tv (tv))
      throw new RuntimeException ("Setting text on non-TextView: " + tv);
    tv.setText (resid);
  }

  /** see setText(TextView, int) **/
  public static void setText(TextView tv, char[] text, int start, int len) {
    if (bad_tv (tv))
      throw new RuntimeException ("Setting text on non-TextView: " + tv);
    tv.setText (text, start, len);
  }

  /** see setText(TextView, int) **/
  public static void setText(TextView tv, int resid, TextView.BufferType type) {
    if (bad_tv (tv))
      throw new RuntimeException ("Setting text on non-TextView: " + tv);
    tv.setText (resid, type);
  }

  /** see setText(TextView, int) **/
  public static void setText(TextView tv, CharSequence text) {
    if (bad_tv (tv))
      throw new RuntimeException ("Setting text on non-TextView: " + tv);
    tv.setText (text);
  }

  /** see setText(TextView, int) **/
  public static void setText(TextView tv, CharSequence text, 
                      TextView.BufferType type) {
    if (bad_tv (tv))
      throw new RuntimeException ("Setting text on non-TextView: " + tv);
    tv.setText (text, type);
  }

  /**
   * Sets up a service to be run periodically.  The service is specified
   * by its class.  The service will run once immediately and then at 
   * intervalMillis milliseconds after that.  Normally this should be
   * called with a constants for service_class and intervalMillis.
   */
  public static void setupAlarmService (Context context, 
                                Class<?> service_class, long intervalMillis) {

    // Create the pending intent
    Intent intent = new Intent(context, service_class);  
    PendingIntent pendingIntent = PendingIntent.getService(context, -1, intent,
        PendingIntent.FLAG_UPDATE_CURRENT); 

    // Setup alarm service to wake up and start service periodically
    AlarmManager alarmManager = (AlarmManager) context
        .getSystemService(Context.ALARM_SERVICE); // <5>
    alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME, System
        .currentTimeMillis(), intervalMillis, pendingIntent); // <6>
  }

  /**
   * Queries the specified URI using the specified context's ContentResolver.
   * The uri_str parameter must be a string representation of a URI.
   * 
   * This call will probably only be required temporarily until the analysis
   * and spec support URIs more completely.
   */
  public static Cursor queryURI (Context context, String uri_str, 
                                 String[] projection, String selection, 
                                 String[] selectionArgs, String sortOrder) {
 
    return context.getContentResolver()
      .query (Uri.parse (uri_str), projection, selection, selectionArgs,
              sortOrder);
  }

  public static Cursor managedQuery (Activity activity, String uri_str, 
          String[] projection, String selection, String selectionArgs,
                                     String sortOrder) {

    return activity.managedQuery (Uri.parse (uri_str), projection, selection,
                                  selectionArgs, sortOrder);
  }

  /**
   * Setups the RemoteView (usually used in a widget) to run the specified
   * activity when it is clicked.
   */
  public static void setOnClickRunActivity (Context context, RemoteViews view,
                                          int viewId, Class<?> activityClass) {

    view.setOnClickPendingIntent(viewId, PendingIntent
              .getActivity(context, 0, new Intent(context,
                  activityClass), 0));
  }
                                            
  /**
   * Runs the activity specified by activity class.
   */
  public static void startActivity (Context context, Class activityClass) {
    context.startActivity (new Intent (context, activityClass));
  }


}
