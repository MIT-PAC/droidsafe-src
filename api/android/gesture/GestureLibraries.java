/*
 * Copyright (C) 2009 The Android Open Source Project
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

package android.gesture;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import static android.gesture.GestureConstants.*;
import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public final class GestureLibraries {

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.014 -0500", hash_original_method = "36C2566972C9E7C5A89CB148B99828C5", hash_generated_method = "EB171114E70DEA09E730F03A5BA67241")
    
public static GestureLibrary fromFile(String path) {
        return fromFile(new File(path));
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.019 -0500", hash_original_method = "7E84D781468DAB3B4FC2BB57E6984751", hash_generated_method = "9FB20FF54F87CC5A2BCE073191450279")
    @DSComment("Gesture instantiation")
    @DSSpec(DSCat.SPEC_OTHERS)

public static GestureLibrary fromFile(File path) {
        return new FileGestureLibrary(path);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.026 -0500", hash_original_method = "B0B626D9ADD9B4A65A0CC2D575141283", hash_generated_method = "002F61A54041D96583A10BFD3918EF8F")
    
public static GestureLibrary fromPrivateFile(Context context, String name) {
        return fromFile(context.getFileStreamPath(name));
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.033 -0500", hash_original_method = "ECCCCFA4B335026C9D86999C5E7C070D", hash_generated_method = "9638F4AEB2445A7384294C50E43D9FC7")
    @DSComment("Gesture instantiation")
    @DSSpec(DSCat.SPEC_OTHERS)

public static GestureLibrary fromRawResource(Context context, int resourceId) {
        return new ResourceGestureLibrary(context, resourceId);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.004 -0500", hash_original_method = "5D35F1C2DD549E898BC93F9B607C5349", hash_generated_method = "625250A16EA789F15A1A86A124DC62B4")
    
private GestureLibraries() {
    }

    private static class FileGestureLibrary extends GestureLibrary {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.042 -0500", hash_original_field = "127E5C3E3958ADC321F874F5B9A87E57", hash_generated_field = "7C8D4D4D30DF213A8DC9A321DFCE11A3")

        private  File mPath;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.048 -0500", hash_original_method = "D39DBA234DE0E08BE1C3C89EFB13CBF6", hash_generated_method = "C3AAE44DED330D4E4D738FB0581B3DBB")
        
public FileGestureLibrary(File path) {
            mPath = path;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.066 -0500", hash_original_method = "487D1546AB6DA50F6A0F6EEF3B43F25E", hash_generated_method = "F6AE9CC85F135D56F9F61531DA82B99C")
        
@Override
        public boolean isReadOnly() {
            return !mPath.canWrite();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.080 -0500", hash_original_method = "4D0F28F8F2FA2DDFF4146F4F99E4E080", hash_generated_method = "04B877382BC7861307F3A2DDDCB32688")
        
public boolean save() {
            if (!mStore.hasChanged()) return true;

            final File file = mPath;

            final File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                if (!parentFile.mkdirs()) {
                    return false;
                }
            }

            boolean result = false;
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
                mStore.save(new FileOutputStream(file), true);
                result = true;
            } catch (FileNotFoundException e) {
                Log.d(LOG_TAG, "Could not save the gesture library in " + mPath, e);
            } catch (IOException e) {
                Log.d(LOG_TAG, "Could not save the gesture library in " + mPath, e);
            }

            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.092 -0500", hash_original_method = "E97FC097692D7B4B3BC36E002DC0ED9B", hash_generated_method = "8A99FCA19A30011741D1C256D119A707")
        
public boolean load() {
            boolean result = false;
            final File file = mPath;
            if (file.exists() && file.canRead()) {
                try {
                    mStore.load(new FileInputStream(file), true);
                    result = true;
                } catch (FileNotFoundException e) {
                    Log.d(LOG_TAG, "Could not load the gesture library from " + mPath, e);
                } catch (IOException e) {
                    Log.d(LOG_TAG, "Could not load the gesture library from " + mPath, e);
                }
            }

            return result;
        }
    }

    private static class ResourceGestureLibrary extends GestureLibrary {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.117 -0500", hash_original_field = "2D7921208090D543F2B317D3475C92D7", hash_generated_field = "905AA6E8F1328291167777E2F411AAD3")

        private  WeakReference<Context> mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.123 -0500", hash_original_field = "641E06FC0A3C0A94A3294754C591BD1B", hash_generated_field = "C75E6DA122FF842A3C7D587E6E200AF8")

        private  int mResourceId;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.130 -0500", hash_original_method = "471C1451FEB613BF2F89DC8F235549EE", hash_generated_method = "7D161AFF8870C8E31D895C6DC5EA71BA")
        
public ResourceGestureLibrary(Context context, int resourceId) {
            mContext = new WeakReference<Context>(context);
            mResourceId = resourceId;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.136 -0500", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "E930BFBB15BF0F3A3E2A714B41BC0488")
        
@Override
        public boolean isReadOnly() {
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.141 -0500", hash_original_method = "EDD00F04EEEBFBBFE2AEC236F9F4B2BF", hash_generated_method = "21DAA22E1D410D932C57F1EF4639A0E5")
        
public boolean save() {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 12:50:06.150 -0500", hash_original_method = "73AAB88122AD60CA48D1793ECC55A1FF", hash_generated_method = "7027F9A1047F9D25433D9671E0D313CD")
        
public boolean load() {
            boolean result = false;
            final Context context = mContext.get();
            if (context != null) {
                final InputStream in = context.getResources().openRawResource(mResourceId);
                try {
                    mStore.load(in, true);
                    result = true;
                } catch (IOException e) {
                    Log.d(LOG_TAG, "Could not load the gesture library from raw resource " +
                            context.getResources().getResourceName(mResourceId), e);
                }
            }

            return result;
        }
    }
}
