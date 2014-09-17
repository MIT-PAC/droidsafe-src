/*
 * Copyright (C) 2012 The Android Open Source Project
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

package android.support.v4.content;

import android.os.Environment;
import android.os.StatFs;
import android.support.v4.os.EnvironmentCompat;
import java.io.File;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

/**
 * Helper for accessing features in {@link android.content.Context}
 * introduced after API level 4 in a backwards compatible fashion.
 */
public class ContextCompat {

    /**
     * Start a set of activities as a synthesized task stack, if able.
     *
     * <p>In API level 11 (Android 3.0/Honeycomb) the recommended conventions for
     * app navigation using the back key changed. The back key's behavior is local
     * to the current task and does not capture navigation across different tasks.
     * Navigating across tasks and easily reaching the previous task is accomplished
     * through the "recents" UI, accessible through the software-provided Recents key
     * on the navigation or system bar. On devices with the older hardware button configuration
     * the recents UI can be accessed with a long press on the Home key.</p>
     *
     * <p>When crossing from one task stack to another post-Android 3.0,
     * the application should synthesize a back stack/history for the new task so that
     * the user may navigate out of the new task and back to the Launcher by repeated
     * presses of the back key. Back key presses should not navigate across task stacks.</p>
     *
     * <p>startActivities provides a mechanism for constructing a synthetic task stack of
     * multiple activities. If the underlying API is not available on the system this method
     * will return false.</p>
     *
     * @param context Start activities using this activity as the starting context
     * @param intents Array of intents defining the activities that will be started. The element
     *                length-1 will correspond to the top activity on the resulting task stack.
     * @return true if the underlying API was available and the call was successful, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:33.583 -0500", hash_original_method = "8D45E71D432CDD40BD281029502FF1F3", hash_generated_method = "A282D89E7B4612096D1395CC8DDD2706")
    
public static boolean startActivities(Context context, Intent[] intents) {
        return startActivities(context, intents, null);
    }

    /**
     * Start a set of activities as a synthesized task stack, if able.
     *
     * <p>In API level 11 (Android 3.0/Honeycomb) the recommended conventions for
     * app navigation using the back key changed. The back key's behavior is local
     * to the current task and does not capture navigation across different tasks.
     * Navigating across tasks and easily reaching the previous task is accomplished
     * through the "recents" UI, accessible through the software-provided Recents key
     * on the navigation or system bar. On devices with the older hardware button configuration
     * the recents UI can be accessed with a long press on the Home key.</p>
     *
     * <p>When crossing from one task stack to another post-Android 3.0,
     * the application should synthesize a back stack/history for the new task so that
     * the user may navigate out of the new task and back to the Launcher by repeated
     * presses of the back key. Back key presses should not navigate across task stacks.</p>
     *
     * <p>startActivities provides a mechanism for constructing a synthetic task stack of
     * multiple activities. If the underlying API is not available on the system this method
     * will return false.</p>
     *
     * @param context Start activities using this activity as the starting context
     * @param intents Array of intents defining the activities that will be started. The element
     *                length-1 will correspond to the top activity on the resulting task stack.
     * @param options Additional options for how the Activity should be started.
     * See {@link android.content.Context#startActivity(Intent, Bundle)
     * @return true if the underlying API was available and the call was successful, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.239 -0400", hash_original_method = "2CC55E2F385232BCD097C19E9A10379E", hash_generated_method = "FA8CEC8DA0E9EBF40DD9D327F34E15F2")
    
public static boolean startActivities(Context context, Intent[] intents,
            Bundle options) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 16) {
            ContextCompatJellybean.startActivities(context, intents, options);
            return true;
        } else if (version >= 11) {
            ContextCompatHoneycomb.startActivities(context, intents);
            return true;
        }
        return false;
    }



    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.271 -0400", hash_original_method = "3ADE214E3239194E3DF15454E5A49DEB", hash_generated_method = "6FE0BA99257D31C7AAC4CAC47ECE1CFA")
    
private static File buildPath(File base, String... segments) {
        File cur = base;
        for (String segment : segments) {
            if (cur == null) {
                cur = new File(segment);
            } else if (segment != null) {
                cur = new File(cur, segment);
            }
        }
        return cur;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.213 -0400", hash_original_field = "E4B51200B3C2511AFBADA0F882A4DDE7", hash_generated_field = "BDA2A67D5FB94911EED89D4C2A6EEBDE")

    private static final String DIR_OBB = "obb";

    /**
     * Returns absolute paths to application-specific directories on all
     * external storage devices where the application can place persistent files
     * it owns. These files are internal to the application, and not typically
     * visible to the user as media.
     * <p>
     * This is like {@link Context#getFilesDir()} in that these files will be
     * deleted when the application is uninstalled, however there are some
     * important differences:
     * <ul>
     * <li>External files are not always available: they will disappear if the
     * user mounts the external storage on a computer or removes it.
     * <li>There is no security enforced with these files.
     * </ul>
     * <p>
     * External storage devices returned here are considered a permanent part of
     * the device, including both emulated external storage and physical media
     * slots, such as SD cards in a battery compartment. The returned paths do
     * not include transient devices, such as USB flash drives.
     * <p>
     * An application may store data on any or all of the returned devices. For
     * example, an app may choose to store large files on the device with the
     * most available space, as measured by {@link StatFs}.
     * <p>
     * Starting in {@link android.os.Build.VERSION_CODES#KITKAT}, no permissions
     * are required to write to the returned paths; they're always accessible to
     * the calling app. Before then,
     * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} is required to
     * write. Write access outside of these paths on secondary external storage
     * devices is not available. To request external storage access in a
     * backwards compatible way, consider using {@code android:maxSdkVersion}
     * like this:
     *
     * <pre class="prettyprint">&lt;uses-permission
     *     android:name="android.permission.WRITE_EXTERNAL_STORAGE"
     *     android:maxSdkVersion="18" /&gt;</pre>
     * <p>
     * The first path returned is the same as
     * {@link Context#getExternalFilesDir(String)}. Returned paths may be
     * {@code null} if a storage device is unavailable.
     *
     * @see Context#getExternalFilesDir(String)
     * @see EnvironmentCompat#getStorageState(File)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.256 -0400", hash_original_method = "909018EB843B8BAA925579252A1E2692", hash_generated_method = "7CC0B1DFEF7B8A79EEFFCA764D1C25E7")
    
public static File[] getExternalFilesDirs(Context context, String type) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 19) {
            return ContextCompatKitKat.getExternalFilesDirs(context, type);
        } else {
            final File single;
            if (version >= 8) {
                single = ContextCompatFroyo.getExternalFilesDir(context, type);
            } else {
                single = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_DATA,
                        context.getPackageName(), DIR_FILES, type);
            }
            return new File[] { single };
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.207 -0400", hash_original_field = "A3B09A1970739A268FCAEAC7BE0F74D0", hash_generated_field = "34A1F18455F825C1BE1E4E56FE39DF40")

    private static final String DIR_DATA = "data";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.225 -0400", hash_original_field = "CD3BE0475B4DEEC2C713F463660F284B", hash_generated_field = "B9711BB072FE48E9B0E2879F0DB5352A")

    private static final String DIR_CACHE = "cache";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.200 -0400", hash_original_field = "3E5613E3DD3CC5CE35AE391AC6D0F1F0", hash_generated_field = "14A89A0CAB70891CD03C85B8A3D6A8AD")


    private static final String DIR_ANDROID = "Android";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.219 -0400", hash_original_field = "2CC1B6DFC460D235D147E2C23782F235", hash_generated_field = "7A13482C0C036C5D2EAA9096120D54C6")

    private static final String DIR_FILES = "files";

    /**
     * Returns absolute paths to application-specific directories on all
     * external storage devices where the application's OBB files (if there are
     * any) can be found. Note if the application does not have any OBB files,
     * these directories may not exist.
     * <p>
     * This is like {@link Context#getFilesDir()} in that these files will be
     * deleted when the application is uninstalled, however there are some
     * important differences:
     * <ul>
     * <li>External files are not always available: they will disappear if the
     * user mounts the external storage on a computer or removes it.
     * <li>There is no security enforced with these files.
     * </ul>
     * <p>
     * External storage devices returned here are considered a permanent part of
     * the device, including both emulated external storage and physical media
     * slots, such as SD cards in a battery compartment. The returned paths do
     * not include transient devices, such as USB flash drives.
     * <p>
     * An application may store data on any or all of the returned devices. For
     * example, an app may choose to store large files on the device with the
     * most available space, as measured by {@link StatFs}.
     * <p>
     * Starting in {@link android.os.Build.VERSION_CODES#KITKAT}, no permissions
     * are required to write to the returned paths; they're always accessible to
     * the calling app. Before then,
     * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} is required to
     * write. Write access outside of these paths on secondary external storage
     * devices is not available. To request external storage access in a
     * backwards compatible way, consider using {@code android:maxSdkVersion}
     * like this:
     *
     * <pre class="prettyprint">&lt;uses-permission
     *     android:name="android.permission.WRITE_EXTERNAL_STORAGE"
     *     android:maxSdkVersion="18" /&gt;</pre>
     * <p>
     * The first path returned is the same as {@link Context#getObbDir()}.
     * Returned paths may be {@code null} if a storage device is unavailable.
     *
     * @see Context#getObbDir()
     * @see EnvironmentCompat#getStorageState(File)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.248 -0400", hash_original_method = "B8A2C925142C6EA6651E845C6816CCD1", hash_generated_method = "A2A55FEE24DD1507859D793E57D76550")
    
public static File[] getObbDirs(Context context) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 19) {
            return ContextCompatKitKat.getObbDirs(context);
        } else {
            final File single;
            if (version >= 11) {
                single = ContextCompatHoneycomb.getObbDir(context);
            } else {
                single = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_OBB,
                        context.getPackageName());
            }
            return new File[] { single };
        }
    }

    /**
     * Returns absolute paths to application-specific directories on all
     * external storage devices where the application can place cache files it
     * owns. These files are internal to the application, and not typically
     * visible to the user as media.
     * <p>
     * This is like {@link Context#getCacheDir()} in that these files will be
     * deleted when the application is uninstalled, however there are some
     * important differences:
     * <ul>
     * <li>External files are not always available: they will disappear if the
     * user mounts the external storage on a computer or removes it.
     * <li>There is no security enforced with these files.
     * </ul>
     * <p>
     * External storage devices returned here are considered a permanent part of
     * the device, including both emulated external storage and physical media
     * slots, such as SD cards in a battery compartment. The returned paths do
     * not include transient devices, such as USB flash drives.
     * <p>
     * An application may store data on any or all of the returned devices. For
     * example, an app may choose to store large files on the device with the
     * most available space, as measured by {@link StatFs}.
     * <p>
     * Starting in {@link android.os.Build.VERSION_CODES#KITKAT}, no permissions
     * are required to write to the returned paths; they're always accessible to
     * the calling app. Before then,
     * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} is required to
     * write. Write access outside of these paths on secondary external storage
     * devices is not available. To request external storage access in a
     * backwards compatible way, consider using {@code android:maxSdkVersion}
     * like this:
     *
     * <pre class="prettyprint">&lt;uses-permission
     *     android:name="android.permission.WRITE_EXTERNAL_STORAGE"
     *     android:maxSdkVersion="18" /&gt;</pre>
     * <p>
     * The first path returned is the same as
     * {@link Context#getExternalCacheDir()}. Returned paths may be {@code null}
     * if a storage device is unavailable.
     *
     * @see Context#getExternalCacheDir()
     * @see EnvironmentCompat#getStorageState(File)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.263 -0400", hash_original_method = "02293604260702E0D29913A62D6BA19C", hash_generated_method = "13865B49155366B233E18CF8C35324A1")
    
public static File[] getExternalCacheDirs(Context context) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 19) {
            return ContextCompatKitKat.getExternalCacheDirs(context);
        } else {
            final File single;
            if (version >= 8) {
                single = ContextCompatFroyo.getExternalCacheDir(context);
            } else {
                single = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_DATA,
                        context.getPackageName(), DIR_CACHE);
            }
            return new File[] { single };
        }
    }}
