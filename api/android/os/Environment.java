package android.os;

import java.io.File;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public class Environment {
	 private static DSTaintObject taint = new DSTaintObject();
	 
	 /**
	     * Standard directory in which to place pictures that are available to
	     * the user.  Note that this is primarily a convention for the top-level
	     * public directory, as the media scanner will find and collect pictures
	     * in any directory.
	     */
	    public static String DIRECTORY_PICTURES = "Pictures";
	    
	/**
     * Get a top-level public external storage directory for placing files of
     * a particular type.  This is where the user will typically place and
     * manage their own files, so you should be careful about what you put here
     * to ensure you don't erase their files or get in the way of their own
     * organization.
     * 
     * <p>Here is an example of typical code to manipulate a picture on
     * the public external storage:</p>
     * 
     * {@sample development/samples/ApiDemos/src/com/example/android/apis/content/ExternalStorage.java
     * public_picture}
     * 
     * @param type The type of storage directory to return.  Should be one of
     * {@link #DIRECTORY_MUSIC}, {@link #DIRECTORY_PODCASTS},
     * {@link #DIRECTORY_RINGTONES}, {@link #DIRECTORY_ALARMS},
     * {@link #DIRECTORY_NOTIFICATIONS}, {@link #DIRECTORY_PICTURES},
     * {@link #DIRECTORY_MOVIES}, {@link #DIRECTORY_DOWNLOADS}, or
     * {@link #DIRECTORY_DCIM}.  May not be null.
     * 
     * @return Returns the File path for the directory.  Note that this
     * directory may not yet exist, so you must make sure it exists before
     * using it such as with {@link File#mkdirs File.mkdirs()}.
     */
	// GITI DSModeled - using taint object to track access to the sdcard
	@DSModeled(DSC.SPEC)
    public static File getExternalStoragePublicDirectory(String type) {
    	taint.addTaint(type);
        return new File("mnt/sdcard");
    }
}
