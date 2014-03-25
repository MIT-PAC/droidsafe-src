/*
 * Copyright (C) 2010 The Android Open Source Project
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

package android.drm;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The main programming interface for the DRM framework. An application must instantiate this class
 * to access DRM agents through the DRM framework.
 *
 */
public class DrmManagerClient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.090 -0400", hash_original_field = "7262751995CEE296BDC927B8BA5F94E3", hash_generated_field = "853B69086D65D5FA2DA3126AF8617F0A")

    public static final int ERROR_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.094 -0400", hash_original_field = "209D4F3FB4D76B6502AAE7960C2FB40E", hash_generated_field = "3A9A08C612A6524FF7C80B2B630D6782")

    public static final int ERROR_UNKNOWN = -2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.098 -0400", hash_original_field = "E5C2E6664493495959FB2E818B678F74", hash_generated_field = "076B896D316BBB5209298DCE70079CBA")


    private static final String TAG = "DrmManagerClient";

    static {
        // Load the respective library
        System.loadLibrary("drmframework_jni");
    }

    /**
     * Interface definition for a callback that receives status messages and warnings
     * during registration and rights acquisition.
     */
    public interface OnInfoListener {
        /**
         * Called when the DRM framework sends status or warning information during registration
         * and rights acquisition.
         *
         * @param client The <code>DrmManagerClient</code> instance.
         * @param event The {@link DrmInfoEvent} instance that wraps the status information or 
         * warnings.
         */
        public void onInfo(DrmManagerClient client, DrmInfoEvent event);
    }

    /**
     * Interface definition for a callback that receives information
     * about DRM processing events.
     */
    public interface OnEventListener {
        /**
         * Called when the DRM framework sends information about a DRM processing request.
         *
         * @param client The <code>DrmManagerClient</code> instance.
         * @param event The {@link DrmEvent} instance that wraps the information being
         * conveyed, such as the information type and message.
         */
        public void onEvent(DrmManagerClient client, DrmEvent event);
    }

    /**
     * Interface definition for a callback that receives information about DRM framework errors.
     */
    public interface OnErrorListener {
        /**
         * Called when the DRM framework sends error information.
         *
         * @param client The <code>DrmManagerClient</code> instance.
         * @param event The {@link DrmErrorEvent} instance that wraps the error type and message.
         */
        public void onError(DrmManagerClient client, DrmErrorEvent event);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.115 -0400", hash_original_field = "90993985FDA992E6963015904D3A842C", hash_generated_field = "495BD96DF55F83A9FEE8C5913EFDE005")


    private static final int ACTION_REMOVE_ALL_RIGHTS = 1001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.119 -0400", hash_original_field = "C18BBCAA6C0CEB8C35B229D41F8A2E30", hash_generated_field = "A982B29FF6F9BEA698F8FA003763E4F0")

    private static final int ACTION_PROCESS_DRM_INFO = 1002;

    /**
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.165 -0400", hash_original_method = "92BEB645D50445DA7DD9FF769CAB8425", hash_generated_method = "1A7A66D957F752BB40BB602A9E9291C0")
    
public static void notify(
            Object thisReference, int uniqueId, int infoType, String message) {
        DrmManagerClient instance = (DrmManagerClient)((WeakReference)thisReference).get();

        if (null != instance && null != instance.mInfoHandler) {
            Message m = instance.mInfoHandler.obtainMessage(
                InfoHandler.INFO_EVENT_TYPE, uniqueId, infoType, message);
            instance.mInfoHandler.sendMessage(m);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.122 -0400", hash_original_field = "9F92F4106274D2629F33867183512BB7", hash_generated_field = "702EBB63B52AE60657B34C8A34DF32C2")


    private int mUniqueId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.125 -0400", hash_original_field = "A4A4998D7B0D1DA56BE7F415CF4F3BBD", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.129 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.132 -0400", hash_original_field = "140DEE05F99F48CB94244C02AF8590A9", hash_generated_field = "418584872BAB4EE0453BFCCAE6E30841")

    private InfoHandler mInfoHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.135 -0400", hash_original_field = "48DBEFEB1D57D7425F34775E3B0822FD", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.139 -0400", hash_original_field = "31E70E6AB1204402EDA8B1303830B586", hash_generated_field = "1D3DA06942FC758771FAEF9EA193F57C")

    private OnInfoListener mOnInfoListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.143 -0400", hash_original_field = "AAEB2AE710D29E6FE8DA2D1FD04854AE", hash_generated_field = "0C88A25472D6AD00401C2E6301C35016")

    private OnEventListener mOnEventListener;

    private class EventHandler extends Handler {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.151 -0400", hash_original_method = "4C7A877E4BE32D4145A967F6B988F2F0", hash_generated_method = "47CCB5A82C902FC2B6115310FA279718")
        
public EventHandler(Looper looper) {
            super(looper);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.157 -0400", hash_original_method = "EF48130EA40C9E7392CB075E37B1FD0A", hash_generated_method = "6C8F1BC02D74E5C0EACD77533463EE3C")
        
public void handleMessage(Message msg) {
            DrmEvent event = null;
            DrmErrorEvent error = null;
            HashMap<String, Object> attributes = new HashMap<String, Object>();

            switch(msg.what) {
            case ACTION_PROCESS_DRM_INFO: {
                final DrmInfo drmInfo = (DrmInfo) msg.obj;
                DrmInfoStatus status = _processDrmInfo(mUniqueId, drmInfo);

                attributes.put(DrmEvent.DRM_INFO_STATUS_OBJECT, status);
                attributes.put(DrmEvent.DRM_INFO_OBJECT, drmInfo);

                if (null != status && DrmInfoStatus.STATUS_OK == status.statusCode) {
                    event = new DrmEvent(mUniqueId,
                            getEventType(status.infoType), null, attributes);
                } else {
                    int infoType = (null != status) ? status.infoType : drmInfo.getInfoType();
                    error = new DrmErrorEvent(mUniqueId,
                            getErrorType(infoType), null, attributes);
                }
                break;
            }
            case ACTION_REMOVE_ALL_RIGHTS: {
                if (ERROR_NONE == _removeAllRights(mUniqueId)) {
                    event = new DrmEvent(mUniqueId, DrmEvent.TYPE_ALL_RIGHTS_REMOVED, null);
                } else {
                    error = new DrmErrorEvent(mUniqueId,
                            DrmErrorEvent.TYPE_REMOVE_ALL_RIGHTS_FAILED, null);
                }
                break;
            }
            default:
                Log.e(TAG, "Unknown message type " + msg.what);
                return;
            }
            if (null != mOnEventListener && null != event) {
                mOnEventListener.onEvent(DrmManagerClient.this, event);
            }
            if (null != mOnErrorListener && null != error) {
                mOnErrorListener.onError(DrmManagerClient.this, error);
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.147 -0400", hash_original_field = "C38C52334F0DC8BAE5DDF67054F8F272", hash_generated_field = "16CDD39A55F7F6321E357628DB75DCA6")

    private OnErrorListener mOnErrorListener;

    private class InfoHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.172 -0400", hash_original_field = "ABF0EAB95950C7D77E561F013B983FE1", hash_generated_field = "442F9DCC01A447A73C23F6D14FABAF5C")

        public static final int INFO_EVENT_TYPE = 1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.176 -0400", hash_original_method = "5D24C6343ECAEF320815C62ED07E6ECD", hash_generated_method = "84051D627561FECA1E29C41780A393DC")
        
public InfoHandler(Looper looper) {
            super(looper);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.180 -0400", hash_original_method = "96826AFABE3485B81254D80D0C112106", hash_generated_method = "55D79A5C38CD5130575E61B0212A0A4F")
        
public void handleMessage(Message msg) {
            DrmInfoEvent info = null;
            DrmErrorEvent error = null;

            switch (msg.what) {
            case InfoHandler.INFO_EVENT_TYPE:
                int uniqueId = msg.arg1;
                int infoType = msg.arg2;
                String message = msg.obj.toString();

                switch (infoType) {
                case DrmInfoEvent.TYPE_REMOVE_RIGHTS: {
                    try {
                        DrmUtils.removeFile(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    info = new DrmInfoEvent(uniqueId, infoType, message);
                    break;
                }
                case DrmInfoEvent.TYPE_ALREADY_REGISTERED_BY_ANOTHER_ACCOUNT:
                case DrmInfoEvent.TYPE_RIGHTS_INSTALLED:
                case DrmInfoEvent.TYPE_WAIT_FOR_RIGHTS:
                case DrmInfoEvent.TYPE_ACCOUNT_ALREADY_REGISTERED:
                case DrmInfoEvent.TYPE_RIGHTS_REMOVED: {
                    info = new DrmInfoEvent(uniqueId, infoType, message);
                    break;
                }
                default:
                    error = new DrmErrorEvent(uniqueId, infoType, message);
                    break;
                }

                if (null != mOnInfoListener && null != info) {
                    mOnInfoListener.onInfo(DrmManagerClient.this, info);
                }
                if (null != mOnErrorListener && null != error) {
                    mOnErrorListener.onError(DrmManagerClient.this, error);
                }
                return;
            default:
                Log.e(TAG, "Unknown message type " + msg.what);
                return;
            }
        }
    }

    /**
     * Creates a <code>DrmManagerClient</code>.
     *
     * @param context Context of the caller.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.187 -0400", hash_original_method = "71E2280FDD89F14B532E25463BCF8AA0", hash_generated_method = "1A09C0C5058F5CBF94943C266DB1539B")
    
public DrmManagerClient(Context context) {
        mContext = context;

        HandlerThread infoThread = new HandlerThread("DrmManagerClient.InfoHandler");
        infoThread.start();
        mInfoHandler = new InfoHandler(infoThread.getLooper());

        HandlerThread eventThread = new HandlerThread("DrmManagerClient.EventHandler");
        eventThread.start();
        mEventHandler = new EventHandler(eventThread.getLooper());

        // save the unique id
        mUniqueId = _initialize(new WeakReference<DrmManagerClient>(this));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.191 -0400", hash_original_method = "98AE580F8215C77D1AAB700254F4968B", hash_generated_method = "2AAA97F05B98A88F36D5C1DFB17D6A18")
    
protected void finalize() {
        _finalize(mUniqueId);
    }

    /**
     * Registers an {@link DrmManagerClient.OnInfoListener} callback, which is invoked when the 
     * DRM framework sends status or warning information during registration or rights acquisition.
     *
     * @param infoListener Interface definition for the callback.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.194 -0400", hash_original_method = "A5070DD47A55AF552FDF69C07EC950F4", hash_generated_method = "5921FBD581AD3C39579388C75C5FF658")
    
public synchronized void setOnInfoListener(OnInfoListener infoListener) {
        if (null != infoListener) {
            mOnInfoListener = infoListener;
        }
    }

    /**
     * Registers an {@link DrmManagerClient.OnEventListener} callback, which is invoked when the 
     * DRM framework sends information about DRM processing.
     *
     * @param eventListener Interface definition for the callback.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.197 -0400", hash_original_method = "B727696DD742A9E1D6068BCD911D9925", hash_generated_method = "D26F9A7CFF081E7BD01A71179FE04918")
    
public synchronized void setOnEventListener(OnEventListener eventListener) {
        if (null != eventListener) {
            mOnEventListener = eventListener;
        }
    }

    /**
     * Registers an {@link DrmManagerClient.OnErrorListener} callback, which is invoked when 
     * the DRM framework sends error information.
     *
     * @param errorListener Interface definition for the callback.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.200 -0400", hash_original_method = "3B1018132B40D11E31A2CED491CAB9D9", hash_generated_method = "62C42223F38B9046371EF83E4FC2E7AD")
    
public synchronized void setOnErrorListener(OnErrorListener errorListener) {
        if (null != errorListener) {
            mOnErrorListener = errorListener;
        }
    }

    /**
     * Retrieves information about all the DRM plug-ins (agents) that are registered with
     * the DRM framework.
     *
     * @return A <code>String</code> array of DRM plug-in descriptions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.204 -0400", hash_original_method = "27F98E430227E55AE2322B348DC26C60", hash_generated_method = "AE297F535F2041FFC087A7C574E3F260")
    
public String[] getAvailableDrmEngines() {
        DrmSupportInfo[] supportInfos = _getAllSupportInfo(mUniqueId);
        ArrayList<String> descriptions = new ArrayList<String>();

        for (int i = 0; i < supportInfos.length; i++) {
            descriptions.add(supportInfos[i].getDescriprition());
        }

        String[] drmEngines = new String[descriptions.size()];
        return descriptions.toArray(drmEngines);
    }

    /**
     * Retrieves constraint information for rights-protected content.
     *
     * @param path Path to the content from which you are retrieving DRM constraints.
     * @param action Action defined in {@link DrmStore.Action}.
     *
     * @return A {@link android.content.ContentValues} instance that contains
     * key-value pairs representing the constraints. Null in case of failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.209 -0400", hash_original_method = "042DB05B1E32623EB1A356A7D72AE1A4", hash_generated_method = "BF2476111796D3E603F962A235BD790C")
    
public ContentValues getConstraints(String path, int action) {
        if (null == path || path.equals("") || !DrmStore.Action.isValid(action)) {
            throw new IllegalArgumentException("Given usage or path is invalid/null");
        }
        return _getConstraints(mUniqueId, path, action);
    }

   /**
    * Retrieves metadata information for rights-protected content.
    *
    * @param path Path to the content from which you are retrieving metadata information.
    *
    * @return A {@link android.content.ContentValues} instance that contains
    * key-value pairs representing the metadata. Null in case of failure.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.213 -0400", hash_original_method = "7F1AB0DFB625F6D83C9BACF27AE5A6D8", hash_generated_method = "ABC43DF37D2042AB541477D906762864")
    
public ContentValues getMetadata(String path) {
        if (null == path || path.equals("")) {
            throw new IllegalArgumentException("Given path is invalid/null");
        }
        return _getMetadata(mUniqueId, path);
    }

    /**
     * Retrieves constraint information for rights-protected content.
     *
     * @param uri URI for the content from which you are retrieving DRM constraints.
     * @param action Action defined in {@link DrmStore.Action}.
     *
     * @return A {@link android.content.ContentValues} instance that contains
     * key-value pairs representing the constraints. Null in case of failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.216 -0400", hash_original_method = "3E805CE657B58532C80254CD0C495E1C", hash_generated_method = "D48EFB2C73B390A3F9773315DC3ECA4A")
    
public ContentValues getConstraints(Uri uri, int action) {
        if (null == uri || Uri.EMPTY == uri) {
            throw new IllegalArgumentException("Uri should be non null");
        }
        return getConstraints(convertUriToPath(uri), action);
    }

   /**
    * Retrieves metadata information for rights-protected content.
    *
    * @param uri URI for the content from which you are retrieving metadata information.
    *
    * @return A {@link android.content.ContentValues} instance that contains
    * key-value pairs representing the constraints. Null in case of failure.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.220 -0400", hash_original_method = "7862F20FC78B9D2A465509FC525AD2FA", hash_generated_method = "2B50D9A1429EDAFD85104B734C989F03")
    
public ContentValues getMetadata(Uri uri) {
        if (null == uri || Uri.EMPTY == uri) {
            throw new IllegalArgumentException("Uri should be non null");
        }
        return getMetadata(convertUriToPath(uri));
    }

    /**
     * Saves rights to a specified path and associates that path with the content path.
     * 
     * <p class="note"><strong>Note:</strong> For OMA or WM-DRM, <code>rightsPath</code> and
     * <code>contentPath</code> can be null.</p>
     *
     * @param drmRights The {@link DrmRights} to be saved.
     * @param rightsPath File path where rights will be saved.
     * @param contentPath File path where content is saved.
     *
     * @return ERROR_NONE for success; ERROR_UNKNOWN for failure.
     *
     * @throws IOException If the call failed to save rights information at the given
     * <code>rightsPath</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.223 -0400", hash_original_method = "82730B820430243DB06DC3D1CC6B9A7F", hash_generated_method = "B35067374F8E9393E9DED85F54AAD26A")
    
public int saveRights(
            DrmRights drmRights, String rightsPath, String contentPath) throws IOException {
        if (null == drmRights || !drmRights.isValid()) {
            throw new IllegalArgumentException("Given drmRights or contentPath is not valid");
        }
        if (null != rightsPath && !rightsPath.equals("")) {
            DrmUtils.writeToFile(rightsPath, drmRights.getData());
        }
        return _saveRights(mUniqueId, drmRights, rightsPath, contentPath);
    }

    /**
     * Installs a new DRM plug-in (agent) at runtime.
     *
     * @param engineFilePath File path to the plug-in file to be installed.
     *
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.227 -0400", hash_original_method = "27BE7A1BF0167F1E125EBE152C5C011A", hash_generated_method = "57F592F51FA66E09267D2D9E4BEB4761")
    
public void installDrmEngine(String engineFilePath) {
        if (null == engineFilePath || engineFilePath.equals("")) {
            throw new IllegalArgumentException(
                "Given engineFilePath: "+ engineFilePath + "is not valid");
        }
        _installDrmEngine(mUniqueId, engineFilePath);
    }

    /**
     * Checks whether the given MIME type or path can be handled.
     *
     * @param path Path of the content to be handled.
     * @param mimeType MIME type of the object to be handled.
     *
     * @return True if the given MIME type or path can be handled; false if they cannot be handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.230 -0400", hash_original_method = "5AFB26199063452B7A341F80089733EA", hash_generated_method = "BAB03E283F7DF32F1F03A06B1B8EE0BB")
    
public boolean canHandle(String path, String mimeType) {
        if ((null == path || path.equals("")) && (null == mimeType || mimeType.equals(""))) {
            throw new IllegalArgumentException("Path or the mimetype should be non null");
        }
        return _canHandle(mUniqueId, path, mimeType);
    }

    /**
     * Checks whether the given MIME type or URI can be handled.
     *
     * @param uri URI for the content to be handled.
     * @param mimeType MIME type of the object to be handled
     *
     * @return True if the given MIME type or URI can be handled; false if they cannot be handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.234 -0400", hash_original_method = "60045FC77B678F8BE2B53C4FE62B3607", hash_generated_method = "7C9A3079693BAEDAED50668121B6AF9D")
    
public boolean canHandle(Uri uri, String mimeType) {
        if ((null == uri || Uri.EMPTY == uri) && (null == mimeType || mimeType.equals(""))) {
            throw new IllegalArgumentException("Uri or the mimetype should be non null");
        }
        return canHandle(convertUriToPath(uri), mimeType);
    }

    /**
     * Processes the given DRM information based on the information type.
     *
     * @param drmInfo The {@link DrmInfo} to be processed.
     * @return ERROR_NONE for success; ERROR_UNKNOWN for failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.237 -0400", hash_original_method = "4160DD4D2AB23D6A3206796597B787B6", hash_generated_method = "F7265C633BB22E561BD86BD034FC1D7F")
    
public int processDrmInfo(DrmInfo drmInfo) {
        if (null == drmInfo || !drmInfo.isValid()) {
            throw new IllegalArgumentException("Given drmInfo is invalid/null");
        }
        int result = ERROR_UNKNOWN;
        if (null != mEventHandler) {
            Message msg = mEventHandler.obtainMessage(ACTION_PROCESS_DRM_INFO, drmInfo);
            result = (mEventHandler.sendMessage(msg)) ? ERROR_NONE : result;
        }
        return result;
    }

    /**
     * Retrieves information for registering, unregistering, or acquiring rights.
     *
     * @param drmInfoRequest The {@link DrmInfoRequest} that specifies the type of DRM
     * information being retrieved.
     *
     * @return A {@link DrmInfo} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.241 -0400", hash_original_method = "7FCCC6823B5ACC90E04FFB17624D0567", hash_generated_method = "7399A2ADBDD006212FC3EB0935EDDA49")
    
public DrmInfo acquireDrmInfo(DrmInfoRequest drmInfoRequest) {
        if (null == drmInfoRequest || !drmInfoRequest.isValid()) {
            throw new IllegalArgumentException("Given drmInfoRequest is invalid/null");
        }
        return _acquireDrmInfo(mUniqueId, drmInfoRequest);
    }

    /**
     * Processes a given {@link DrmInfoRequest} and returns the rights information asynchronously.
     *<p>
     * This is a utility method that consists of an
     * {@link #acquireDrmInfo(DrmInfoRequest) acquireDrmInfo()} and a
     * {@link #processDrmInfo(DrmInfo) processDrmInfo()} method call. This utility method can be 
     * used only if the selected DRM plug-in (agent) supports this sequence of calls. Some DRM
     * agents, such as OMA, do not support this utility method, in which case an application must
     * invoke {@link #acquireDrmInfo(DrmInfoRequest) acquireDrmInfo()} and
     * {@link #processDrmInfo(DrmInfo) processDrmInfo()} separately.
     *
     * @param drmInfoRequest The {@link DrmInfoRequest} used to acquire the rights.
     * @return ERROR_NONE for success; ERROR_UNKNOWN for failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.244 -0400", hash_original_method = "EE09A6B12347B3D7A9BD7A4B0CCCD863", hash_generated_method = "68852EFE39B284BA39F1509BEDB6A238")
    
public int acquireRights(DrmInfoRequest drmInfoRequest) {
        DrmInfo drmInfo = acquireDrmInfo(drmInfoRequest);
        if (null == drmInfo) {
            return ERROR_UNKNOWN;
        }
        return processDrmInfo(drmInfo);
    }

    /**
     * Retrieves the type of rights-protected object (for example, content object, rights
     * object, and so on) using the specified path or MIME type. At least one parameter must
     * be specified to retrieve the DRM object type.
     *
     * @param path Path to the content or null.
     * @param mimeType MIME type of the content or null.
     * 
     * @return An <code>int</code> that corresponds to a {@link DrmStore.DrmObjectType}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.247 -0400", hash_original_method = "4B73D028ABBE9BC166CF43C133DD5056", hash_generated_method = "2E09228B752B71FF15950C6269E45B4F")
    
public int getDrmObjectType(String path, String mimeType) {
        if ((null == path || path.equals("")) && (null == mimeType || mimeType.equals(""))) {
            throw new IllegalArgumentException("Path or the mimetype should be non null");
        }
        return _getDrmObjectType(mUniqueId, path, mimeType);
    }

    /**
     * Retrieves the type of rights-protected object (for example, content object, rights
     * object, and so on) using the specified URI or MIME type. At least one parameter must
     * be specified to retrieve the DRM object type.
     *
     * @param uri URI for the content or null.
     * @param mimeType MIME type of the content or null.
     * 
     * @return An <code>int</code> that corresponds to a {@link DrmStore.DrmObjectType}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.252 -0400", hash_original_method = "0D9032FED94DA3FEB74F1625692A6AFB", hash_generated_method = "51E06267B24E8B44AB1E004FDB1C075E")
    
public int getDrmObjectType(Uri uri, String mimeType) {
        if ((null == uri || Uri.EMPTY == uri) && (null == mimeType || mimeType.equals(""))) {
            throw new IllegalArgumentException("Uri or the mimetype should be non null");
        }
        String path = "";
        try {
            path = convertUriToPath(uri);
        } catch (Exception e) {
            // Even uri is invalid the mimetype shall be valid, so allow to proceed further.
            Log.w(TAG, "Given Uri could not be found in media store");
        }
        return getDrmObjectType(path, mimeType);
    }

    /**
     * Retrieves the MIME type embedded in the original content.
     *
     * @param path Path to the rights-protected content.
     *
     * @return The MIME type of the original content, such as <code>video/mpeg</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.255 -0400", hash_original_method = "43F523520A07ECCA4CF5F045D44B6736", hash_generated_method = "ED7D995A2A99E6C05A2A1F783FAFF1F3")
    
public String getOriginalMimeType(String path) {
        if (null == path || path.equals("")) {
            throw new IllegalArgumentException("Given path should be non null");
        }
        return _getOriginalMimeType(mUniqueId, path);
    }

    /**
     * Retrieves the MIME type embedded in the original content.
     *
     * @param uri URI of the rights-protected content.
     *
     * @return MIME type of the original content, such as <code>video/mpeg</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.258 -0400", hash_original_method = "893A3F9379E6E2BA6601B58956805188", hash_generated_method = "CB0E0AAF3343C0019E0E663121159BC0")
    
public String getOriginalMimeType(Uri uri) {
        if (null == uri || Uri.EMPTY == uri) {
            throw new IllegalArgumentException("Given uri is not valid");
        }
        return getOriginalMimeType(convertUriToPath(uri));
    }

    /**
     * Checks whether the given content has valid rights.
     *
     * @param path Path to the rights-protected content.
     *
     * @return An <code>int</code> representing the {@link DrmStore.RightsStatus} of the content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.261 -0400", hash_original_method = "A54DCC0C40740269B904668E89C663B5", hash_generated_method = "415483F3FAAC344252B1FEC97221EDE7")
    
public int checkRightsStatus(String path) {
        return checkRightsStatus(path, DrmStore.Action.DEFAULT);
    }

    /**
     * Check whether the given content has valid rights.
     *
     * @param uri URI of the rights-protected content.
     *
     * @return An <code>int</code> representing the {@link DrmStore.RightsStatus} of the content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.264 -0400", hash_original_method = "DD1831698FCEEE78C6775304A4BF26EC", hash_generated_method = "C166BC01B422BE2504F2116672615BE7")
    
public int checkRightsStatus(Uri uri) {
        if (null == uri || Uri.EMPTY == uri) {
            throw new IllegalArgumentException("Given uri is not valid");
        }
        return checkRightsStatus(convertUriToPath(uri));
    }

    /**
     * Checks whether the given rights-protected content has valid rights for the specified
     * {@link DrmStore.Action}.
     *
     * @param path Path to the rights-protected content.
     * @param action The {@link DrmStore.Action} to perform.
     *
     * @return An <code>int</code> representing the {@link DrmStore.RightsStatus} of the content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.267 -0400", hash_original_method = "A10C6E9AF75F323343A65C608AEBD97F", hash_generated_method = "D37551BFE0A8F31F7C3EE727BEDD26FD")
    
public int checkRightsStatus(String path, int action) {
        if (null == path || path.equals("") || !DrmStore.Action.isValid(action)) {
            throw new IllegalArgumentException("Given path or action is not valid");
        }
        return _checkRightsStatus(mUniqueId, path, action);
    }

    /**
     * Checks whether the given rights-protected content has valid rights for the specified
     * {@link DrmStore.Action}.
     *
     * @param uri URI for the rights-protected content.
     * @param action The {@link DrmStore.Action} to perform.
     *
     * @return An <code>int</code> representing the {@link DrmStore.RightsStatus} of the content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.270 -0400", hash_original_method = "4FF84C4E1398B2DEE49321F74E5FB7BB", hash_generated_method = "D0DE93B2A282E836DB363D9877C60C65")
    
public int checkRightsStatus(Uri uri, int action) {
        if (null == uri || Uri.EMPTY == uri) {
            throw new IllegalArgumentException("Given uri is not valid");
        }
        return checkRightsStatus(convertUriToPath(uri), action);
    }

    /**
     * Removes the rights associated with the given rights-protected content.
     *
     * @param path Path to the rights-protected content.
     *
     * @return ERROR_NONE for success; ERROR_UNKNOWN for failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.275 -0400", hash_original_method = "6B74B635AAAD13481C1E384081FE3C4A", hash_generated_method = "9DF14808D09EC3E36F6ACF9E0D1F5BE1")
    
public int removeRights(String path) {
        if (null == path || path.equals("")) {
            throw new IllegalArgumentException("Given path should be non null");
        }
        return _removeRights(mUniqueId, path);
    }

    /**
     * Removes the rights associated with the given rights-protected content.
     *
     * @param uri URI for the rights-protected content.
     *
     * @return ERROR_NONE for success; ERROR_UNKNOWN for failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.278 -0400", hash_original_method = "3D8C89E65745CD9FCE9618BD7F2565EF", hash_generated_method = "E8A813ACCAD0C0DB3CB1B2E0C9A83545")
    
public int removeRights(Uri uri) {
        if (null == uri || Uri.EMPTY == uri) {
            throw new IllegalArgumentException("Given uri is not valid");
        }
        return removeRights(convertUriToPath(uri));
    }

    /**
     * Removes all the rights information of every DRM plug-in (agent) associated with
     * the DRM framework. Will be used during a master reset.
     *
     * @return ERROR_NONE for success; ERROR_UNKNOWN for failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.281 -0400", hash_original_method = "47A8A1B291C3342EDBBC3D77628D5E52", hash_generated_method = "5E9A8C8857C43AF3CAB808CEE1A0A26A")
    
public int removeAllRights() {
        int result = ERROR_UNKNOWN;
        if (null != mEventHandler) {
            Message msg = mEventHandler.obtainMessage(ACTION_REMOVE_ALL_RIGHTS);
            result = (mEventHandler.sendMessage(msg)) ? ERROR_NONE : result;
        }
        return result;
    }

    /**
     * Initiates a new conversion session. An application must initiate a conversion session
     * with this method each time it downloads a rights-protected file that needs to be converted.
     *<p>
     * This method applies only to forward-locking (copy protection) DRM schemes.
     *
     * @param mimeType MIME type of the input data packet.
     *
     * @return A convert ID that is used used to maintain the conversion session.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.285 -0400", hash_original_method = "DF251F6E08ED4923EA0843689AD946FD", hash_generated_method = "C0CC30DD37463EE935B3317AADCA41D8")
    
public int openConvertSession(String mimeType) {
        if (null == mimeType || mimeType.equals("")) {
            throw new IllegalArgumentException("Path or the mimeType should be non null");
        }
        return _openConvertSession(mUniqueId, mimeType);
    }

    /**
     * Converts the input data (content) that is part of a rights-protected file. The converted
     * data and status is returned in a {@link DrmConvertedStatus} object. This method should be
     * called each time there is a new block of data received by the application.
     *
     * @param convertId Handle for the conversion session.
     * @param inputData Input data that needs to be converted.
     *
     * @return A {@link DrmConvertedStatus} object that contains the status of the data conversion,
     * the converted data, and offset for the header and body signature. An application can 
     * ignore the offset because it is only relevant to the
     * {@link #closeConvertSession closeConvertSession()} method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.289 -0400", hash_original_method = "5A2A08EA82468776E64ABEFFE239A3AF", hash_generated_method = "E1123DF35D600D639C4AC311D3D8C4FD")
    
public DrmConvertedStatus convertData(int convertId, byte[] inputData) {
        if (null == inputData || 0 >= inputData.length) {
            throw new IllegalArgumentException("Given inputData should be non null");
        }
        return _convertData(mUniqueId, convertId, inputData);
    }

    /**
     * Informs the DRM plug-in (agent) that there is no more data to convert or that an error 
     * has occurred. Upon successful conversion of the data, the DRM agent will provide an offset
     * value indicating where the header and body signature should be added. Appending the 
     * signature is necessary to protect the integrity of the converted file.
     *
     * @param convertId Handle for the conversion session.
     *
     * @return A {@link DrmConvertedStatus} object that contains the status of the data conversion,
     * the converted data, and the offset for the header and body signature.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.292 -0400", hash_original_method = "24A49D1BF79112FE094A6734EDE8C7FF", hash_generated_method = "712705DDF407F87A8C498217DECC2DDB")
    
public DrmConvertedStatus closeConvertSession(int convertId) {
        return _closeConvertSession(mUniqueId, convertId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.295 -0400", hash_original_method = "9855423FD13F80F3D62D66EDDA5872E6", hash_generated_method = "8B2DC0D09E68564A2BFF1D995E13F50D")
    
private int getEventType(int infoType) {
        int eventType = -1;

        switch (infoType) {
        case DrmInfoRequest.TYPE_REGISTRATION_INFO:
        case DrmInfoRequest.TYPE_UNREGISTRATION_INFO:
        case DrmInfoRequest.TYPE_RIGHTS_ACQUISITION_INFO:
            eventType = DrmEvent.TYPE_DRM_INFO_PROCESSED;
            break;
        }
        return eventType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.298 -0400", hash_original_method = "5DF6A69DFA5844E08C603C710FFA2377", hash_generated_method = "E9CE265E7136B2467605FB71E9A89D29")
    
private int getErrorType(int infoType) {
        int error = -1;

        switch (infoType) {
        case DrmInfoRequest.TYPE_REGISTRATION_INFO:
        case DrmInfoRequest.TYPE_UNREGISTRATION_INFO:
        case DrmInfoRequest.TYPE_RIGHTS_ACQUISITION_INFO:
            error = DrmErrorEvent.TYPE_PROCESS_DRM_INFO_FAILED;
            break;
        }
        return error;
    }

    /**
     * This method expects uri in the following format
     *     content://media/<table_name>/<row_index> (or)
     *     file://sdcard/test.mp4
     *     http://test.com/test.mp4
     *
     * Here <table_name> shall be "video" or "audio" or "images"
     * <row_index> the index of the content in given table
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.304 -0400", hash_original_method = "E0C2E487242E6400825F9231ED9E7CAC", hash_generated_method = "29283986372CF1A4D4EB4D1947D4D3CE")
    
private String convertUriToPath(Uri uri) {
        String path = null;
        if (null != uri) {
            String scheme = uri.getScheme();
            if (null == scheme || scheme.equals("") ||
                    scheme.equals(ContentResolver.SCHEME_FILE)) {
                path = uri.getPath();

            } else if (scheme.equals("http")) {
                path = uri.toString();

            } else if (scheme.equals(ContentResolver.SCHEME_CONTENT)) {
                String[] projection = new String[] {MediaStore.MediaColumns.DATA};
                Cursor cursor = null;
                try {
                    cursor = mContext.getContentResolver().query(uri, projection, null,
                            null, null);
                    if (null == cursor || 0 == cursor.getCount() || !cursor.moveToFirst()) {
                        throw new IllegalArgumentException("Given Uri could not be found" +
                                " in media store");
                    }
                    int pathIndex = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
                    path = cursor.getString(pathIndex);
                } catch (SQLiteException e) {
                    throw new IllegalArgumentException("Given Uri is not formatted in a way " +
                            "so that it can be found in media store.");
                } finally {
                    if (null != cursor) {
                        cursor.close();
                    }
                }
            } else {
                throw new IllegalArgumentException("Given Uri scheme is not supported");
            }
        }
        return path;
    }

    // private native interfaces
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.314 -0400", hash_original_method = "16C19CA6D6B3410306CA7F2BE76A420B", hash_generated_method = "104C1B4261CD5DF20F5F9722FA32F589")
    
    private int _initialize(Object weak_this){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += weak_this.getTaintInt();
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.320 -0400", hash_original_method = "82AD145F7F972A9AC764D18C53EF9ECE", hash_generated_method = "42D7ADBA406EEA492DC9C1338C42BB24")
    
    private void _finalize(int uniqueId){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	addTaint(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.327 -0400", hash_original_method = "10C3560C76415AE2C2E05D202EB05632", hash_generated_method = "C53CED7C860017EDD6A4E36FC7F22B4E")
    
    private void _installDrmEngine(int uniqueId, String engineFilepath){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	taintDouble += engineFilepath.getTaintInt();
    	addTaint(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.334 -0400", hash_original_method = "35738F7D5501035318499551A9C8AA04", hash_generated_method = "4F130AD5234069472C73368002C2E776")
    
    private ContentValues _getConstraints(int uniqueId, String path, int usage){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	taintDouble += path.getTaintInt();
    	taintDouble += usage;
    	addTaint(taintDouble);
    
    	ContentValues retObj = new ContentValues(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.340 -0400", hash_original_method = "41A2CE5D531E356140EF2C3BCB8A8FFA", hash_generated_method = "136173C87630C7323E7C2A775B46E19F")
    
    private ContentValues _getMetadata(int uniqueId, String path){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	taintDouble += path.getTaintInt();
    	addTaint(taintDouble);
    
    	ContentValues retObj = new ContentValues(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.346 -0400", hash_original_method = "133D601F466AB771B97CDE121F5CA0E7", hash_generated_method = "37C732EC676AF6481A1F392C389DB7CC")
    
    private boolean _canHandle(int uniqueId, String path, String mimeType){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	taintDouble += path.getTaintInt();
    	taintDouble += mimeType.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.354 -0400", hash_original_method = "DA4A150A4386AF296514FABE0EE51600", hash_generated_method = "269C060BE37A8F9D110499F0FE7852AE")
    
    private DrmInfoStatus _processDrmInfo(int uniqueId, DrmInfo drmInfo){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	taintDouble += drmInfo.getTaintInt();
    	addTaint(taintDouble);
    
    	DrmInfoStatus retObj = new DrmInfoStatus(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.360 -0400", hash_original_method = "8FC5CBFF7578A07313C6E36869586565", hash_generated_method = "0036C2BB486B3C28749850C5F877E279")
    
    private DrmInfo _acquireDrmInfo(int uniqueId, DrmInfoRequest drmInfoRequest){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	taintDouble += drmInfoRequest.getTaintInt();
    	addTaint(taintDouble);
    
    	DrmInfo retObj = new DrmInfo(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.366 -0400", hash_original_method = "76F35664110A45230AA60540BD730594", hash_generated_method = "CEE27D0339B9C6E63ED78AC5F63B52CC")
    
    private int _saveRights(
                int uniqueId, DrmRights drmRights, String rightsPath, String contentPath){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	taintDouble += drmRights.getTaintInt();
    	taintDouble += rightsPath.getTaintInt();
    	taintDouble += contentPath.getTaintInt();
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.373 -0400", hash_original_method = "1F08BEA1706E5ACC5826B133E1B794B5", hash_generated_method = "15A605CA6BCDA2628E817EB6164B5013")
    
    private int _getDrmObjectType(int uniqueId, String path, String mimeType){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	taintDouble += path.getTaintInt();
    	taintDouble += mimeType.getTaintInt();
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.379 -0400", hash_original_method = "EB7B36555D6393B523461B14C8FC9677", hash_generated_method = "C012073AC94254F005CA23458E8961E3")
    
    private String _getOriginalMimeType(int uniqueId, String path){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	taintDouble += path.getTaintInt();
    	addTaint(taintDouble);
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.385 -0400", hash_original_method = "444F65C4C941360E75D0D7A65002C285", hash_generated_method = "04BB0C8711854902AF5220EB18BD2EB8")
    
    private int _checkRightsStatus(int uniqueId, String path, int action){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	taintDouble += path.getTaintInt();
    	taintDouble += action;
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.392 -0400", hash_original_method = "09CE9A0CB1393E45CD9B13F3EFB77A4D", hash_generated_method = "C13177FC590AB049E27407F340F3A9F7")
    
    private int _removeRights(int uniqueId, String path){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	taintDouble += path.getTaintInt();
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.401 -0400", hash_original_method = "04862FC9B26F83280D25E16DB021E3AE", hash_generated_method = "489EF7DF1FB7D3427F3DD390E76A86AC")
    
    private int _removeAllRights(int uniqueId){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.409 -0400", hash_original_method = "35D8D2ADFE595E9700A96EA0BA798ABC", hash_generated_method = "AE777F8E5FCBAC7CC06D57C9B039181F")
    
    private int _openConvertSession(int uniqueId, String mimeType){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	taintDouble += mimeType.getTaintInt();
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.416 -0400", hash_original_method = "CBFF4F3D0E2CB8741EC6CF40226A6709", hash_generated_method = "1EA4640EB04CD463B32CD5455052897D")
    
    private DrmConvertedStatus _convertData(
                int uniqueId, int convertId, byte[] inputData){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	taintDouble += convertId;
    	taintDouble += inputData[0];
    	addTaint(taintDouble);
    
    	DrmConvertedStatus retObj = new DrmConvertedStatus(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.422 -0400", hash_original_method = "275720A41A16EB24CB948EDAF777FD7E", hash_generated_method = "C64677D2B0FAC24AFA6D34A7D3E2991F")
    
    private DrmConvertedStatus _closeConvertSession(int uniqueId, int convertId){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	taintDouble += convertId;
    	addTaint(taintDouble);
    
    	DrmConvertedStatus retObj = new DrmConvertedStatus(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:14.429 -0400", hash_original_method = "C4212EDC383E2AB4376B6B0CB3F7509D", hash_generated_method = "B6C783C1204CDDED0A208176B5F1CDCD")
    
    private DrmSupportInfo[] _getAllSupportInfo(int uniqueId){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += uniqueId;
    	addTaint(taintDouble);
    
    	DrmSupportInfo[] retObj = new DrmSupportInfo[1]; 
    	retObj[0] = new DrmSupportInfo(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }




}

