/*
 * Copyright (C) 2013 The Android Open Source Project
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

package android.support.v7.internal.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * This class represents a data model for choosing a component for handing a
 * given {@link Intent}. The model is responsible for querying the system for
 * activities that can handle the given intent and order found activities
 * based on historical data of previous choices. The historical data is stored
 * in an application private file. If a client does not want to have persistent
 * choice history the file can be omitted, thus the activities will be ordered
 * based on historical usage for the current session.
 * <p>
 * </p>
 * For each backing history file there is a singleton instance of this class. Thus,
 * several clients that specify the same history file will share the same model. Note
 * that if multiple clients are sharing the same model they should implement semantically
 * equivalent functionality since setting the model intent will change the found
 * activities and they may be inconsistent with the functionality of some of the clients.
 * For example, choosing a share activity can be implemented by a single backing
 * model and two different views for performing the selection. If however, one of the
 * views is used for sharing but the other for importing, for example, then each
 * view should be backed by a separate model.
 * </p>
 * <p>
 * The way clients interact with this class is as follows:
 * </p>
 * <p>
 * <pre>
 * <code>
 *  // Get a model and set it to a couple of clients with semantically similar function.
 *  ActivityChooserModel dataModel =
 *      ActivityChooserModel.get(context, "task_specific_history_file_name.xml");
 *
 *  ActivityChooserModelClient modelClient1 = getActivityChooserModelClient1();
 *  modelClient1.setActivityChooserModel(dataModel);
 *
 *  ActivityChooserModelClient modelClient2 = getActivityChooserModelClient2();
 *  modelClient2.setActivityChooserModel(dataModel);
 *
 *  // Set an intent to choose a an activity for.
 *  dataModel.setIntent(intent);
 * <pre>
 * <code>
 * </p>
 * <p>
 * <strong>Note:</strong> This class is thread safe.
 * </p>
 *
 * @hide
 */
public class ActivityChooserModel extends DataSetObservable {

    /**
     * Client that utilizes an {@link ActivityChooserModel}.
     */
    public interface ActivityChooserModelClient {

        /**
         * Sets the {@link ActivityChooserModel}.
         *
         * @param dataModel The model.
         */
        public void setActivityChooserModel(ActivityChooserModel dataModel);
    }

    /**
     * Defines a sorter that is responsible for sorting the activities
     * based on the provided historical choices and an intent.
     */
    public interface ActivitySorter {

        /**
         * Sorts the <code>activities</code> in descending order of relevance
         * based on previous history and an intent.
         *
         * @param intent The {@link Intent}.
         * @param activities Activities to be sorted.
         * @param historicalRecords Historical records.
         */
        // This cannot be done by a simple comparator since an Activity weight
        // is computed from history. Note that Activity implements Comparable.
        public void sort(Intent intent, List<ActivityResolveInfo> activities,
                List<HistoricalRecord> historicalRecords);
    }

    /**
     * Listener for choosing an activity.
     */
    public interface OnChooseActivityListener {

        /**
         * Called when an activity has been chosen. The client can decide whether
         * an activity can be chosen and if so the caller of
         * {@link ActivityChooserModel#chooseActivity(int)} will receive and {@link Intent}
         * for launching it.
         * <p>
         * <strong>Note:</strong> Modifying the intent is not permitted and
         *     any changes to the latter will be ignored.
         * </p>
         *
         * @param host The listener's host model.
         * @param intent The intent for launching the chosen activity.
         * @return Whether the intent is handled and should not be delivered to clients.
         *
         * @see ActivityChooserModel#chooseActivity(int)
         */
        public boolean onChooseActivity(ActivityChooserModel host, Intent intent);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.612 -0400", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.615 -0400", hash_original_field = "E037CBE0BE3FBA8A7961920B44AD080F", hash_generated_field = "C0E6428FC538C3E98CD4F3F3FD104AD3")

    private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.617 -0400", hash_original_field = "E20593E22FC31D904E7E5B3A71EE8318", hash_generated_field = "2F78BC6BF3EA40EEBFAAF4062888B202")

    private static final String TAG_HISTORICAL_RECORDS = "historical-records";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.621 -0400", hash_original_field = "5F967947C66B27389D126D99E03528B1", hash_generated_field = "B57E7DC30CE2B7036D338B99DE1C8F4A")

    private static final String TAG_HISTORICAL_RECORD = "historical-record";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.623 -0400", hash_original_field = "56AFAE4CDEC4680C8609FCB3EDBC717D", hash_generated_field = "4F997BDD322ABDE394E143C88BE19902")

    private static final String ATTRIBUTE_ACTIVITY = "activity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.626 -0400", hash_original_field = "40ADE1807AC7E1E341C80E5BC4D9CE29", hash_generated_field = "4657BA7339C2DB58947DE9CCAAA8BCAF")

    private static final String ATTRIBUTE_TIME = "time";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.629 -0400", hash_original_field = "77BBD3343B372696409C101C8F9C60BF", hash_generated_field = "8399470D08376E2A59EAC9C79DB79A9E")

    private static final String ATTRIBUTE_WEIGHT = "weight";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.632 -0400", hash_original_field = "8B8F9583173AB764EC9F9A025F38F1E5", hash_generated_field = "C17F091D6E1676968D87EC382F2A60E4")

    public static final String DEFAULT_HISTORY_FILE_NAME =
            "activity_choser_model_history.xml";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.635 -0400", hash_original_field = "815CFEE32450A538972A8F43519898CD", hash_generated_field = "51D1ECB43E515D53A9B4473F163B06AD")

    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.638 -0400", hash_original_field = "2AA93006CF4F51E2D3A52871199C92F7", hash_generated_field = "450784023A27CD5EC5CEF077D5E372FC")

    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.640 -0400", hash_original_field = "3296A6C22BF2803ACD276A7DC849A5FF", hash_generated_field = "48D4985B801C29FF4FB9AF6C46ABE846")

    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.642 -0400", hash_original_field = "B25DE5464F3B2FB0F1678D1D64A7BC0C", hash_generated_field = "5BDD81AF45C2360A5D0488EF180F0B0E")

    private static final String HISTORY_FILE_EXTENSION = ".xml";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.645 -0400", hash_original_field = "79922DB043510C9A19B5CA2602F88574", hash_generated_field = "19F556E730E88DC545CC4ADD400592D6")

    private static final int INVALID_INDEX = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.648 -0400", hash_original_field = "2A85441306B6DA10925576EDB0829DE9", hash_generated_field = "922B32A26FF0AAB23FEB7772C78F88BB")

    private static final Object sRegistryLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.651 -0400", hash_original_field = "D12002D66861D7C4CD7306DAE98689EB", hash_generated_field = "BB4344C9185B0C58F3786BE4083DEBFE")

    private static final Map<String, ActivityChooserModel> sDataModelRegistry =
            new HashMap<String, ActivityChooserModel>();

    /**
     * Gets the data model backed by the contents of the provided file with historical data.
     * Note that only one data model is backed by a given file, thus multiple calls with
     * the same file name will return the same model instance. If no such instance is present
     * it is created.
     * <p>
     * <strong>Note:</strong> To use the default historical data file clients should explicitly
     * pass as file name {@link #DEFAULT_HISTORY_FILE_NAME}. If no persistence of the choice
     * history is desired clients should pass <code>null</code> for the file name. In such
     * case a new model is returned for each invocation.
     * </p>
     *
     * <p>
     * <strong>Always use difference historical data files for semantically different actions.
     * For example, sharing is different from importing.</strong>
     * </p>
     *
     * @param context Context for loading resources.
     * @param historyFileName File name with choice history, <code>null</code>
     *        if the model should not be backed by a file. In this case the activities
     *        will be ordered only by data from the current session.
     *
     * @return The model.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.683 -0400", hash_original_method = "FB8C54A39D7C61FF0CE3E2FAB0EA8CA1", hash_generated_method = "5C651673D31A886DC2B8AC58C596302C")
                
public static ActivityChooserModel get(Context context, String historyFileName) {
        synchronized (sRegistryLock) {
            ActivityChooserModel dataModel = sDataModelRegistry.get(historyFileName);
            if (dataModel == null) {
                dataModel = new ActivityChooserModel(context, historyFileName);
                sDataModelRegistry.put(historyFileName, dataModel);
            }
            return dataModel;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.654 -0400", hash_original_field = "C1EC34416CA5919EC9DC169918854311", hash_generated_field = "6392F8242B4A9D3DC6E2F079ACDCEA46")

    private final Object mInstanceLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.656 -0400", hash_original_field = "0422A53AB66991450BD4D2C0CCBA5F0A", hash_generated_field = "6351DEE8AA9F7C4271EBD0CE8D46F462")

    private final List<ActivityResolveInfo> mActivities = new ArrayList<ActivityResolveInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.659 -0400", hash_original_field = "3AC8F7346660D77AD24249C0102BEBB2", hash_generated_field = "CD99824E96948584D748917073F44E2A")

    private final List<HistoricalRecord> mHistoricalRecords = new ArrayList<HistoricalRecord>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.661 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.663 -0400", hash_original_field = "460D23C5FE834DF5E670AC904F537CE8", hash_generated_field = "357B9AB2EB9473252BE7FAC7D1E15CF3")

    private  String mHistoryFileName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.665 -0400", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.667 -0400", hash_original_field = "CDFE9562459CF682CD5791AE8590AE22", hash_generated_field = "972A273635E03BCAAB877E2B3CA36A43")

    private ActivitySorter mActivitySorter = new DefaultSorter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.670 -0400", hash_original_field = "9E260D706DA037E28705F134F95A2D17", hash_generated_field = "EDEDBBB721F293D506B0D4333D55AA26")

    private int mHistoryMaxSize = DEFAULT_HISTORY_MAX_LENGTH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.672 -0400", hash_original_field = "8A47E82C5B6544A76C54534A1159111E", hash_generated_field = "2CA5D5746328370D849F634661FCCB3C")

    private boolean mCanReadHistoricalData = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.674 -0400", hash_original_field = "AFD63AFE6577D9D6820D1BD49F835A0F", hash_generated_field = "A0038BE823A55BDB17A2EB5E4620EF9F")

    private boolean mReadShareHistoryCalled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.676 -0400", hash_original_field = "B9DA8B44212AE5FF74D5FDCB48DCA951", hash_generated_field = "4EFA8B1A885AF19B054DFCDA0E6D3607")

    private boolean mHistoricalRecordsChanged = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.678 -0400", hash_original_field = "639C3DA8F90FC671C8AF9A1B9CB203A6", hash_generated_field = "816187A5F26366437D1EBDDF7EC76DBF")

    private boolean mReloadActivities = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.681 -0400", hash_original_field = "B556ED2FBA0B414787FE1A89D6F15079", hash_generated_field = "84BCBE36C424794EB40EAAE6D9BDAEAE")

    private OnChooseActivityListener mActivityChoserModelPolicy;

    /**
     * Creates a new instance.
     *
     * @param context Context for loading resources.
     * @param historyFileName The history XML file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.686 -0400", hash_original_method = "9EA2DBE5D8DF8D71294D35C0E9F7E246", hash_generated_method = "943E831667D2FE667F5302293717428A")
                
private ActivityChooserModel(Context context, String historyFileName) {
        mContext = context.getApplicationContext();
        if (!TextUtils.isEmpty(historyFileName)
                && !historyFileName.endsWith(HISTORY_FILE_EXTENSION)) {
            mHistoryFileName = historyFileName + HISTORY_FILE_EXTENSION;
        } else {
            mHistoryFileName = historyFileName;
        }
    }

    /**
     * Sets an intent for which to choose a activity.
     * <p>
     * <strong>Note:</strong> Clients must set only semantically similar
     * intents for each data model.
     * <p>
     *
     * @param intent The intent.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.690 -0400", hash_original_method = "9EC6E574DF9F53B3D60531ED7660ED4E", hash_generated_method = "CAAB4F801D5425E09B1CBC44551EA237")
                
public void setIntent(Intent intent) {
        synchronized (mInstanceLock) {
            if (mIntent == intent) {
                return;
            }
            mIntent = intent;
            mReloadActivities = true;
            ensureConsistentState();
        }
    }

    /**
     * Gets the intent for which a activity is being chosen.
     *
     * @return The intent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.692 -0400", hash_original_method = "27A17A1D87D77EAA50C2FB6DFA94EC7A", hash_generated_method = "932C480F63E4BDC434E715C77D01BFED")
                
public Intent getIntent() {
        synchronized (mInstanceLock) {
            return mIntent;
        }
    }

    /**
     * Gets the number of activities that can handle the intent.
     *
     * @return The activity count.
     *
     * @see #setIntent(Intent)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.695 -0400", hash_original_method = "CB604CF6F7EC306A817BBCAF0F70025A", hash_generated_method = "CFE76709EAC76551C13A72BD1DAE1783")
                
public int getActivityCount() {
        synchronized (mInstanceLock) {
            ensureConsistentState();
            return mActivities.size();
        }
    }

    /**
     * Gets an activity at a given index.
     *
     * @return The activity.
     *
     * @see ActivityResolveInfo
     * @see #setIntent(Intent)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.697 -0400", hash_original_method = "1B0A3814AC487B67DAF612DBEF1BDFE5", hash_generated_method = "E3FD7DE6668E7CF4A379AC9AF949E8D6")
                
public ResolveInfo getActivity(int index) {
        synchronized (mInstanceLock) {
            ensureConsistentState();
            return mActivities.get(index).resolveInfo;
        }
    }

    /**
     * Gets the index of a the given activity.
     *
     * @param activity The activity index.
     *
     * @return The index if found, -1 otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.700 -0400", hash_original_method = "AD65ED2867E599270F70CD60FB235911", hash_generated_method = "E680CBBC7240CEC731AADC1B2CEBD8A0")
                
public int getActivityIndex(ResolveInfo activity) {
        synchronized (mInstanceLock) {
            ensureConsistentState();
            List<ActivityResolveInfo> activities = mActivities;
            final int activityCount = activities.size();
            for (int i = 0; i < activityCount; i++) {
                ActivityResolveInfo currentActivity = activities.get(i);
                if (currentActivity.resolveInfo == activity) {
                    return i;
                }
            }
            return INVALID_INDEX;
        }
    }

    /**
     * Chooses a activity to handle the current intent. This will result in
     * adding a historical record for that action and construct intent with
     * its component name set such that it can be immediately started by the
     * client.
     * <p>
     * <strong>Note:</strong> By calling this method the client guarantees
     * that the returned intent will be started. This intent is returned to
     * the client solely to let additional customization before the start.
     * </p>
     *
     * @return An {@link Intent} for launching the activity or null if the
     *         policy has consumed the intent or there is not current intent
     *         set via {@link #setIntent(Intent)}.
     *
     * @see HistoricalRecord
     * @see OnChooseActivityListener
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.704 -0400", hash_original_method = "1DC600F29ED81B06DEF3384D196E650E", hash_generated_method = "ED81C9D10ACF0D7FA17B05467B13E9B5")
                
public Intent chooseActivity(int index) {
        synchronized (mInstanceLock) {
            if (mIntent == null) {
                return null;
            }

            ensureConsistentState();

            ActivityResolveInfo chosenActivity = mActivities.get(index);

            ComponentName chosenName = new ComponentName(
                    chosenActivity.resolveInfo.activityInfo.packageName,
                    chosenActivity.resolveInfo.activityInfo.name);

            Intent choiceIntent = new Intent(mIntent);
            choiceIntent.setComponent(chosenName);

            if (mActivityChoserModelPolicy != null) {
                // Do not allow the policy to change the intent.
                Intent choiceIntentCopy = new Intent(choiceIntent);
                final boolean handled = mActivityChoserModelPolicy.onChooseActivity(this,
                        choiceIntentCopy);
                if (handled) {
                    return null;
                }
            }

            HistoricalRecord historicalRecord = new HistoricalRecord(chosenName,
                    System.currentTimeMillis(), DEFAULT_HISTORICAL_RECORD_WEIGHT);
            addHisoricalRecord(historicalRecord);

            return choiceIntent;
        }
    }

    /**
     * Sets the listener for choosing an activity.
     *
     * @param listener The listener.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.706 -0400", hash_original_method = "EB55A208F402E96A3376D4F0422A1E09", hash_generated_method = "FD0E448CC6F127033633D71927F19035")
                
public void setOnChooseActivityListener(OnChooseActivityListener listener) {
        synchronized (mInstanceLock) {
            mActivityChoserModelPolicy = listener;
        }
    }

    /**
     * Gets the default activity, The default activity is defined as the one
     * with highest rank i.e. the first one in the list of activities that can
     * handle the intent.
     *
     * @return The default activity, <code>null</code> id not activities.
     *
     * @see #getActivity(int)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.709 -0400", hash_original_method = "FA7B4E129FB5F6C086A6E3A337504581", hash_generated_method = "FC0DC0D763744F504FDBAC841038ADD4")
                
public ResolveInfo getDefaultActivity() {
        synchronized (mInstanceLock) {
            ensureConsistentState();
            if (!mActivities.isEmpty()) {
                return mActivities.get(0).resolveInfo;
            }
        }
        return null;
    }

    /**
     * Sets the default activity. The default activity is set by adding a
     * historical record with weight high enough that this activity will
     * become the highest ranked. Such a strategy guarantees that the default
     * will eventually change if not used. Also the weight of the record for
     * setting a default is inflated with a constant amount to guarantee that
     * it will stay as default for awhile.
     *
     * @param index The index of the activity to set as default.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.712 -0400", hash_original_method = "8B0DB707CEA03E4BA7B6875C0E496601", hash_generated_method = "7DB741163C7B8647E43E359FFDD18D7E")
                
public void setDefaultActivity(int index) {
        synchronized (mInstanceLock) {
            ensureConsistentState();

            ActivityResolveInfo newDefaultActivity = mActivities.get(index);
            ActivityResolveInfo oldDefaultActivity = mActivities.get(0);

            final float weight;
            if (oldDefaultActivity != null) {
                // Add a record with weight enough to boost the chosen at the top.
                weight = oldDefaultActivity.weight - newDefaultActivity.weight
                        + DEFAULT_ACTIVITY_INFLATION;
            } else {
                weight = DEFAULT_HISTORICAL_RECORD_WEIGHT;
            }

            ComponentName defaultName = new ComponentName(
                    newDefaultActivity.resolveInfo.activityInfo.packageName,
                    newDefaultActivity.resolveInfo.activityInfo.name);
            HistoricalRecord historicalRecord = new HistoricalRecord(defaultName,
                    System.currentTimeMillis(), weight);
            addHisoricalRecord(historicalRecord);
        }
    }

    /**
     * Persists the history data to the backing file if the latter
     * was provided. Calling this method before a call to {@link #readHistoricalDataIfNeeded()}
     * throws an exception. Calling this method more than one without choosing an
     * activity has not effect.
     *
     * @throws IllegalStateException If this method is called before a call to
     *         {@link #readHistoricalDataIfNeeded()}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.715 -0400", hash_original_method = "209A62AF988D749892F65257D6145080", hash_generated_method = "1C1A41C0B54EEA6513D648B8C20A7D7D")
                
private void persistHistoricalDataIfNeeded() {
        if (!mReadShareHistoryCalled) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (!mHistoricalRecordsChanged) {
            return;
        }
        mHistoricalRecordsChanged = false;
        if (!TextUtils.isEmpty(mHistoryFileName)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                executePersistHistoryAsyncTaskSDK11();
            } else {
                executePersistHistoryAsyncTaskBase();
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.720 -0400", hash_original_method = "BAFD993BBD82CB84276576F8D5FDD895", hash_generated_method = "E672EC03A1D4F00C5C0ACEC8CC4D7C50")
                
private void executePersistHistoryAsyncTaskBase() {
        new PersistHistoryAsyncTask().execute(new ArrayList<HistoricalRecord>(mHistoricalRecords),
                mHistoryFileName);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.723 -0400", hash_original_method = "FADD507E0E85921409C707BA6101DE40", hash_generated_method = "F8DCB8D6A5EBD82E833AA05190DB1110")
                
private void executePersistHistoryAsyncTaskSDK11() {
        new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR,
                new ArrayList<HistoricalRecord>(mHistoricalRecords), mHistoryFileName);
    }

    /**
     * Sets the sorter for ordering activities based on historical data and an intent.
     *
     * @param activitySorter The sorter.
     *
     * @see ActivitySorter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.725 -0400", hash_original_method = "CBC4E13210BE17EEE938B0738EF31907", hash_generated_method = "B9946B783772693FDAF2051677EF97C7")
                
public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized (mInstanceLock) {
            if (mActivitySorter == activitySorter) {
                return;
            }
            mActivitySorter = activitySorter;
            if (sortActivitiesIfNeeded()) {
                notifyChanged();
            }
        }
    }

    /**
     * Sets the maximal size of the historical data. Defaults to
     * {@link #DEFAULT_HISTORY_MAX_LENGTH}
     * <p>
     *   <strong>Note:</strong> Setting this property will immediately
     *   enforce the specified max history size by dropping enough old
     *   historical records to enforce the desired size. Thus, any
     *   records that exceed the history size will be discarded and
     *   irreversibly lost.
     * </p>
     *
     * @param historyMaxSize The max history size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.727 -0400", hash_original_method = "8A281A25F22C5FD34C277BC234A3769F", hash_generated_method = "20601CAFE00F856D0781F9E1F5A3BE01")
                
public void setHistoryMaxSize(int historyMaxSize) {
        synchronized (mInstanceLock) {
            if (mHistoryMaxSize == historyMaxSize) {
                return;
            }
            mHistoryMaxSize = historyMaxSize;
            pruneExcessiveHistoricalRecordsIfNeeded();
            if (sortActivitiesIfNeeded()) {
                notifyChanged();
            }
        }
    }

    /**
     * Gets the history max size.
     *
     * @return The history max size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.729 -0400", hash_original_method = "EBCBD4C754CE0391425067ED25453667", hash_generated_method = "2801A2704E59069A32759C53A4F30CA7")
                
public int getHistoryMaxSize() {
        synchronized (mInstanceLock) {
            return mHistoryMaxSize;
        }
    }

    /**
     * Gets the history size.
     *
     * @return The history size.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.731 -0400", hash_original_method = "9B45C2BFC279CDACCB9347FAF1679D51", hash_generated_method = "9F1C451129AA1B546D062A652652D32F")
                
public int getHistorySize() {
        synchronized (mInstanceLock) {
            ensureConsistentState();
            return mHistoricalRecords.size();
        }
    }

    /**
     * Ensures the model is in a consistent state which is the
     * activities for the current intent have been loaded, the
     * most recent history has been read, and the activities
     * are sorted.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.733 -0400", hash_original_method = "C8E6729DBDDC67B48FBBDC2AC81E5D74", hash_generated_method = "0E9ECC7A7CB2B733DEF50A0230D5335B")
                
private void ensureConsistentState() {
        boolean stateChanged = loadActivitiesIfNeeded();
        stateChanged |= readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (stateChanged) {
            sortActivitiesIfNeeded();
            notifyChanged();
        }
    }

    /**
     * Sorts the activities if necessary which is if there is a
     * sorter, there are some activities to sort, and there is some
     * historical data.
     *
     * @return Whether sorting was performed.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.735 -0400", hash_original_method = "1A8605E4E7CD77197A5F5DA1109DB487", hash_generated_method = "1BC00650A7A485F43F43BD54A977C6BF")
                
private boolean sortActivitiesIfNeeded() {
        if (mActivitySorter != null && mIntent != null
                && !mActivities.isEmpty() && !mHistoricalRecords.isEmpty()) {
            mActivitySorter.sort(mIntent, mActivities,
                    Collections.unmodifiableList(mHistoricalRecords));
            return true;
        }
        return false;
    }

    /**
     * Loads the activities for the current intent if needed which is
     * if they are not already loaded for the current intent.
     *
     * @return Whether loading was performed.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.739 -0400", hash_original_method = "3B904F3732F4C6E82850FFDDFD903CF6", hash_generated_method = "5FE7C06D940C569780DCBD63CB028860")
                
private boolean loadActivitiesIfNeeded() {
        if (mReloadActivities && mIntent != null) {
            mReloadActivities = false;
            mActivities.clear();
            List<ResolveInfo> resolveInfos = mContext.getPackageManager()
                    .queryIntentActivities(mIntent, 0);
            final int resolveInfoCount = resolveInfos.size();
            for (int i = 0; i < resolveInfoCount; i++) {
                ResolveInfo resolveInfo = resolveInfos.get(i);
                mActivities.add(new ActivityResolveInfo(resolveInfo));
            }
            return true;
        }
        return false;
    }

    /**
     * Reads the historical data if necessary which is it has
     * changed, there is a history file, and there is not persist
     * in progress.
     *
     * @return Whether reading was performed.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.742 -0400", hash_original_method = "49E4E78833E76EEF4730637B23CDA76B", hash_generated_method = "A6ADE035B455659ADF76CC19B178D78F")
                
private boolean readHistoricalDataIfNeeded() {
        if (mCanReadHistoricalData && mHistoricalRecordsChanged &&
                !TextUtils.isEmpty(mHistoryFileName)) {
            mCanReadHistoricalData = false;
            mReadShareHistoryCalled = true;
            readHistoricalDataImpl();
            return true;
        }
        return false;
    }

    /**
     * Adds a historical record.
     *
     * @param historicalRecord The record to add.
     * @return True if the record was added.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.745 -0400", hash_original_method = "F623006C7E6259D3299EB4AD1E2DE1D8", hash_generated_method = "F219D6A4B7B079D54E315E4D72568431")
                
private boolean addHisoricalRecord(HistoricalRecord historicalRecord) {
        final boolean added = mHistoricalRecords.add(historicalRecord);
        if (added) {
            mHistoricalRecordsChanged = true;
            pruneExcessiveHistoricalRecordsIfNeeded();
            persistHistoricalDataIfNeeded();
            sortActivitiesIfNeeded();
            notifyChanged();
        }
        return added;
    }

    /**
     * Prunes older excessive records to guarantee maxHistorySize.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.747 -0400", hash_original_method = "3591731D17F4E6B8170BBCAE2D523197", hash_generated_method = "16DD98FB2EFB5890ECB469304383E555")
                
private void pruneExcessiveHistoricalRecordsIfNeeded() {
        final int pruneCount = mHistoricalRecords.size() - mHistoryMaxSize;
        if (pruneCount <= 0) {
            return;
        }
        mHistoricalRecordsChanged = true;
        for (int i = 0; i < pruneCount; i++) {
            HistoricalRecord prunedRecord = mHistoricalRecords.remove(0);
            if (DEBUG) {
                Log.i(LOG_TAG, "Pruned: " + prunedRecord);
            }
        }
    }

    /**
     * Represents a record in the history.
     */
    public final static class HistoricalRecord {

        /**
         * The activity name.
         */
        public final ComponentName activity;

        /**
         * The choice time.
         */
        public final long time;

        /**
         * The record weight.
         */
        public final float weight;

        /**
         * Creates a new instance.
         *
         * @param activityName The activity component name flattened to string.
         * @param time The time the activity was chosen.
         * @param weight The weight of the record.
         */
        public HistoricalRecord(String activityName, long time, float weight) {
            this(ComponentName.unflattenFromString(activityName), time, weight);
        }

        /**
         * Creates a new instance.
         *
         * @param activityName The activity name.
         * @param time The time the activity was chosen.
         * @param weight The weight of the record.
         */
        public HistoricalRecord(ComponentName activityName, long time, float weight) {
            this.activity = activityName;
            this.time = time;
            this.weight = weight;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((activity == null) ? 0 : activity.hashCode());
            result = prime * result + (int) (time ^ (time >>> 32));
            result = prime * result + Float.floatToIntBits(weight);
            return result;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            HistoricalRecord other = (HistoricalRecord) obj;
            if (activity == null) {
                if (other.activity != null) {
                    return false;
                }
            } else if (!activity.equals(other.activity)) {
                return false;
            }
            if (time != other.time) {
                return false;
            }
            if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight)) {
                return false;
            }
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("; activity:").append(activity);
            builder.append("; time:").append(time);
            builder.append("; weight:").append(new BigDecimal(weight));
            builder.append("]");
            return builder.toString();
        }
    }

    /**
     * Represents an activity.
     */
    public final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {

        /**
         * The {@link ResolveInfo} of the activity.
         */
        public final ResolveInfo resolveInfo;

        /**
         * Weight of the activity. Useful for sorting.
         */
        public float weight;

        /**
         * Creates a new instance.
         *
         * @param resolveInfo activity {@link ResolveInfo}.
         */
        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int hashCode() {
            return 31 + Float.floatToIntBits(weight);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            ActivityResolveInfo other = (ActivityResolveInfo) obj;
            if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight)) {
                return false;
            }
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int compareTo(ActivityResolveInfo another) {
            return  Float.floatToIntBits(another.weight) - Float.floatToIntBits(weight);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("resolveInfo:").append(resolveInfo.toString());
            builder.append("; weight:").append(new BigDecimal(weight));
            builder.append("]");
            return builder.toString();
        }
    }

    /**
     * Default activity sorter implementation.
     */
    private final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;

        private final Map<String, ActivityResolveInfo> mPackageNameToActivityMap =
                new HashMap<String, ActivityResolveInfo>();

        @DSSafe(DSCat.SAFE_LIST)
        public void sort(Intent intent, List<ActivityResolveInfo> activities,
                List<HistoricalRecord> historicalRecords) {
            Map<String, ActivityResolveInfo> packageNameToActivityMap =
                    mPackageNameToActivityMap;
            packageNameToActivityMap.clear();

            final int activityCount = activities.size();
            for (int i = 0; i < activityCount; i++) {
                ActivityResolveInfo activity = activities.get(i);
                activity.weight = 0.0f;
                String packageName = activity.resolveInfo.activityInfo.packageName;
                packageNameToActivityMap.put(packageName, activity);
            }

            final int lastShareIndex = historicalRecords.size() - 1;
            float nextRecordWeight = 1;
            for (int i = lastShareIndex; i >= 0; i--) {
                HistoricalRecord historicalRecord = historicalRecords.get(i);
                String packageName = historicalRecord.activity.getPackageName();
                ActivityResolveInfo activity = packageNameToActivityMap.get(packageName);
                if (activity != null) {
                    activity.weight += historicalRecord.weight * nextRecordWeight;
                    nextRecordWeight = nextRecordWeight * WEIGHT_DECAY_COEFFICIENT;
                }
            }

            Collections.sort(activities);

            if (DEBUG) {
                for (int i = 0; i < activityCount; i++) {
                    Log.i(LOG_TAG, "Sorted: " + activities.get(i));
                }
            }
        }
    }

    /**
     * Command for reading the historical records from a file off the UI thread.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:45.819 -0400", hash_original_method = "D36B62E6A823BBB40CAD2D69425DF5D9", hash_generated_method = "91466DCA219D6894A701DAEF160C42B0")
                
private void readHistoricalDataImpl() {
        FileInputStream fis = null;
        try {
            fis = mContext.openFileInput(mHistoryFileName);
        } catch (FileNotFoundException fnfe) {
            if (DEBUG) {
                Log.i(LOG_TAG, "Could not open historical records file: " + mHistoryFileName);
            }
            return;
        }
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(fis, null);

            int type = XmlPullParser.START_DOCUMENT;
            while (type != XmlPullParser.END_DOCUMENT && type != XmlPullParser.START_TAG) {
                type = parser.next();
            }

            if (!TAG_HISTORICAL_RECORDS.equals(parser.getName())) {
                throw new XmlPullParserException("Share records file does not start with "
                        + TAG_HISTORICAL_RECORDS + " tag.");
            }

            List<HistoricalRecord> historicalRecords = mHistoricalRecords;
            historicalRecords.clear();

            while (true) {
                type = parser.next();
                if (type == XmlPullParser.END_DOCUMENT) {
                    break;
                }
                if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                    continue;
                }
                String nodeName = parser.getName();
                if (!TAG_HISTORICAL_RECORD.equals(nodeName)) {
                    throw new XmlPullParserException("Share records file not well-formed.");
                }

                String activity = parser.getAttributeValue(null, ATTRIBUTE_ACTIVITY);
                final long time =
                        Long.parseLong(parser.getAttributeValue(null, ATTRIBUTE_TIME));
                final float weight =
                        Float.parseFloat(parser.getAttributeValue(null, ATTRIBUTE_WEIGHT));
                HistoricalRecord readRecord = new HistoricalRecord(activity, time, weight);
                historicalRecords.add(readRecord);

                if (DEBUG) {
                    Log.i(LOG_TAG, "Read " + readRecord.toString());
                }
            }

            if (DEBUG) {
                Log.i(LOG_TAG, "Read " + historicalRecords.size() + " historical records.");
            }
        } catch (XmlPullParserException xppe) {
            Log.e(LOG_TAG, "Error reading historical recrod file: " + mHistoryFileName, xppe);
        } catch (IOException ioe) {
            Log.e(LOG_TAG, "Error reading historical recrod file: " + mHistoryFileName, ioe);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ioe) {
                    /* ignore */
                }
            }
        }
    }

    /**
     * Command for persisting the historical records to a file off the UI thread.
     */
    private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        @SuppressWarnings("unchecked")
        public Void doInBackground(Object... args) {
            List<HistoricalRecord> historicalRecords = (List<HistoricalRecord>) args[0];
            String hostoryFileName = (String) args[1];

            FileOutputStream fos = null;

            try {
                fos = mContext.openFileOutput(hostoryFileName, Context.MODE_PRIVATE);
            } catch (FileNotFoundException fnfe) {
                Log.e(LOG_TAG, "Error writing historical recrod file: " + hostoryFileName, fnfe);
                return null;
            }

            XmlSerializer serializer = Xml.newSerializer();

            try {
                serializer.setOutput(fos, null);
                serializer.startDocument("UTF-8", true);
                serializer.startTag(null, TAG_HISTORICAL_RECORDS);

                final int recordCount = historicalRecords.size();
                for (int i = 0; i < recordCount; i++) {
                    HistoricalRecord record = historicalRecords.remove(0);
                    serializer.startTag(null, TAG_HISTORICAL_RECORD);
                    serializer.attribute(null, ATTRIBUTE_ACTIVITY,
                            record.activity.flattenToString());
                    serializer.attribute(null, ATTRIBUTE_TIME, String.valueOf(record.time));
                    serializer.attribute(null, ATTRIBUTE_WEIGHT, String.valueOf(record.weight));
                    serializer.endTag(null, TAG_HISTORICAL_RECORD);
                    if (DEBUG) {
                        Log.i(LOG_TAG, "Wrote " + record.toString());
                    }
                }

                serializer.endTag(null, TAG_HISTORICAL_RECORDS);
                serializer.endDocument();

                if (DEBUG) {
                    Log.i(LOG_TAG, "Wrote " + recordCount + " historical records.");
                }
            } catch (IllegalArgumentException iae) {
                Log.e(LOG_TAG, "Error writing historical recrod file: " + mHistoryFileName, iae);
            } catch (IllegalStateException ise) {
                Log.e(LOG_TAG, "Error writing historical recrod file: " + mHistoryFileName, ise);
            } catch (IOException ioe) {
                Log.e(LOG_TAG, "Error writing historical recrod file: " + mHistoryFileName, ioe);
            } finally {
                mCanReadHistoricalData = true;
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        /* ignore */
                    }
                }
            }
            return null;
        }
    }
}