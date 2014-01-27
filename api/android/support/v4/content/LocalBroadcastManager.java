package android.support.v4.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;

public class LocalBroadcastManager {

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.523 -0500", hash_original_method = "3CB1B74AD53F3369E7790EFD811F3D13", hash_generated_method = "47819F899C9500AFBEECAF5945D64459")
    
public static LocalBroadcastManager getInstance(Context context) {
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            return mInstance;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.488 -0500", hash_original_field = "95EA59689DB3F23B3D542ECA81CE7023", hash_generated_field = "BF4C210169D9CD8EE4EB7FDFBA8151D6")

    private static final String TAG = "LocalBroadcastManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.491 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.513 -0500", hash_original_field = "9DD71F6CE060E1F83CB2095757C4FFB6", hash_generated_field = "62F64C7DBF4C8EA8DBEAB2C0BCF66703")

    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.518 -0500", hash_original_field = "83DB9DCBBD2D99A708D9A1934D5CD5AB", hash_generated_field = "CA3747CC2EC4B1C7DB6ABC7879C88A34")

    private static final Object mLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.521 -0500", hash_original_field = "FD097A25508999963B21983D4882C2B3", hash_generated_field = "C42A5AFEF5DDC3EB8FF2FCB322675454")

    private static LocalBroadcastManager mInstance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.502 -0500", hash_original_field = "EA4750DA6687DD56CD040978206975ED", hash_generated_field = "722D46A23A9E453AC7AC6D5797C29418")

    private  Context mAppContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.505 -0500", hash_original_field = "9C55A75C7EE57F61960730AE42681320", hash_generated_field = "07FFA70DD32DFA27A9E1E6FAA73F1FDA")

    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers
            = new HashMap<BroadcastReceiver, ArrayList<IntentFilter>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.507 -0500", hash_original_field = "E03096C72328313E3BACA907C65B4395", hash_generated_field = "A942E9E79E2149A4FF9308B612EC1D8E")

    private final HashMap<String, ArrayList<ReceiverRecord>> mActions
            = new HashMap<String, ArrayList<ReceiverRecord>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.510 -0500", hash_original_field = "F0822C225C2440DE5445C05A068B4566", hash_generated_field = "64369177E49D20F3A922FD3B9CC9E74F")

    private final ArrayList<BroadcastRecord> mPendingBroadcasts
            = new ArrayList<BroadcastRecord>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.515 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private  Handler mHandler;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.531 -0500", hash_original_method = "839AC2DB210099F0B624D40E6378447E", hash_generated_method = "4B2DF27FE67F3CA7DB3A66BAED021A71")
    
private LocalBroadcastManager(Context context) {
        mAppContext = context;
        mHandler = new Handler(context.getMainLooper()) {

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 10:56:31.175 -0500", hash_original_method = "83DCC689423DD34BA48280EAD0078C8B", hash_generated_method = "9EF740E24F28E1B88201FF8077F270D2")
            
@Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case MSG_EXEC_PENDING_BROADCASTS:
                        executePendingBroadcasts();
                        break;
                    default:
                        super.handleMessage(msg);
                }
            }
        };
    }
    
    private static class ReceiverRecord {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.459 -0500", hash_original_field = "7DA86C636503E600C04786FD252B8201", hash_generated_field = "7DA86C636503E600C04786FD252B8201")

         IntentFilter filter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.462 -0500", hash_original_field = "5CD98931683D8080FFA0C51C86AE5674", hash_generated_field = "5CD98931683D8080FFA0C51C86AE5674")

         BroadcastReceiver receiver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.464 -0500", hash_original_field = "3CD7C92A131FB292437CE24C046ECABD", hash_generated_field = "3CD7C92A131FB292437CE24C046ECABD")

        boolean broadcasting;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.467 -0500", hash_original_method = "5206887270700039FD440F8685BB60D3", hash_generated_method = "5206887270700039FD440F8685BB60D3")
        
ReceiverRecord(IntentFilter _filter, BroadcastReceiver _receiver) {
            filter = _filter;
            receiver = _receiver;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.470 -0500", hash_original_method = "5F4A257948A58F0B78B34620CDA69880", hash_generated_method = "9783CB893F434FB4C630D5B56CC5188B")
        
@Override
        public String toString() {
            StringBuilder builder = new StringBuilder(128);
            builder.append("Receiver{");
            builder.append(receiver);
            builder.append(" filter=");
            builder.append(filter);
            builder.append("}");
            return builder.toString();
        }
        
    }
    
    private static class BroadcastRecord {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.475 -0500", hash_original_field = "170FCA7A98A65D8003A3D20D5B3C245D", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

         Intent intent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.479 -0500", hash_original_field = "06A99CF3B8E73116492C21E622D66AE0", hash_generated_field = "06A99CF3B8E73116492C21E622D66AE0")

         ArrayList<ReceiverRecord> receivers;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.484 -0500", hash_original_method = "AA1A90161822F4E9C86DDF136B615F55", hash_generated_method = "AA1A90161822F4E9C86DDF136B615F55")
        
BroadcastRecord(Intent _intent, ArrayList<ReceiverRecord> _receivers) {
            intent = _intent;
            receivers = _receivers;
        }
        
    }

    /**
     * Register a receive for any local broadcasts that match the given IntentFilter.
     *
     * @param receiver The BroadcastReceiver to handle the broadcast.
     * @param filter Selects the Intent broadcasts to be received.
     *
     * @see #unregisterReceiver
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.534 -0500", hash_original_method = "D32BC0D25E86F605EE68EB4056334640", hash_generated_method = "828E2E55CD6766C364D07FA88A5CE8D5")
    
public void registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        synchronized (mReceivers) {
            ReceiverRecord entry = new ReceiverRecord(filter, receiver);
            ArrayList<IntentFilter> filters = mReceivers.get(receiver);
            if (filters == null) {
                filters = new ArrayList<IntentFilter>(1);
                mReceivers.put(receiver, filters);
            }
            filters.add(filter);
            for (int i=0; i<filter.countActions(); i++) {
                String action = filter.getAction(i);
                ArrayList<ReceiverRecord> entries = mActions.get(action);
                if (entries == null) {
                    entries = new ArrayList<ReceiverRecord>(1);
                    mActions.put(action, entries);
                }
                entries.add(entry);
            }
        }
    }

    /**
     * Unregister a previously registered BroadcastReceiver.  <em>All</em>
     * filters that have been registered for this BroadcastReceiver will be
     * removed.
     *
     * @param receiver The BroadcastReceiver to unregister.
     *
     * @see #registerReceiver
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.537 -0500", hash_original_method = "8566D0E7C4974CA9CB93E779F651E45B", hash_generated_method = "0636FABA3318CBEDB289BB9DD6803AAE")
    
public void unregisterReceiver(BroadcastReceiver receiver) {
        synchronized (mReceivers) {
            ArrayList<IntentFilter> filters = mReceivers.remove(receiver);
            if (filters == null) {
                return;
            }
            for (int i=0; i<filters.size(); i++) {
                IntentFilter filter = filters.get(i);
                for (int j=0; j<filter.countActions(); j++) {
                    String action = filter.getAction(j);
                    ArrayList<ReceiverRecord> receivers = mActions.get(action);
                    if (receivers != null) {
                        for (int k=0; k<receivers.size(); k++) {
                            if (receivers.get(k).receiver == receiver) {
                                receivers.remove(k);
                                k--;
                            }
                        }
                        if (receivers.size() <= 0) {
                            mActions.remove(action);
                        }
                    }
                }
            }
        }
    }

    /**
     * Broadcast the given intent to all interested BroadcastReceivers.  This
     * call is asynchronous; it returns immediately, and you will continue
     * executing while the receivers are run.
     *
     * @param intent The Intent to broadcast; all receivers matching this
     *     Intent will receive the broadcast.
     *
     * @see #registerReceiver
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.542 -0500", hash_original_method = "D242868C7C53E8784BBDECD4F038DC32", hash_generated_method = "C889A277772E7F5A7183DAD0C616AEDF")
    
public boolean sendBroadcast(Intent intent) {
        synchronized (mReceivers) {
            final String action = intent.getAction();
            final String type = intent.resolveTypeIfNeeded(
                    mAppContext.getContentResolver());
            final Uri data = intent.getData();
            final String scheme = intent.getScheme();
            final Set<String> categories = intent.getCategories();

            final boolean debug = DEBUG ||
                    ((intent.getFlags() & Intent.FLAG_DEBUG_LOG_RESOLUTION) != 0);
            if (debug) Log.v(
                    TAG, "Resolving type " + type + " scheme " + scheme
                    + " of intent " + intent);

            ArrayList<ReceiverRecord> entries = mActions.get(intent.getAction());
            if (entries != null) {
                if (debug) Log.v(TAG, "Action list: " + entries);

                ArrayList<ReceiverRecord> receivers = null;
                for (int i=0; i<entries.size(); i++) {
                    ReceiverRecord receiver = entries.get(i);
                    if (debug) Log.v(TAG, "Matching against filter " + receiver.filter);

                    if (receiver.broadcasting) {
                        if (debug) {
                            Log.v(TAG, "  Filter's target already added");
                        }
                        continue;
                    }

                    int match = receiver.filter.match(action, type, scheme, data,
                            categories, "LocalBroadcastManager");
                    if (match >= 0) {
                        if (debug) Log.v(TAG, "  Filter matched!  match=0x" +
                                Integer.toHexString(match));
                        if (receivers == null) {
                            receivers = new ArrayList<ReceiverRecord>();
                        }
                        receivers.add(receiver);
                        receiver.broadcasting = true;
                    } else {
                        if (debug) {
                            String reason;
                            switch (match) {
                                case IntentFilter.NO_MATCH_ACTION: reason = "action"; break;
                                case IntentFilter.NO_MATCH_CATEGORY: reason = "category"; break;
                                case IntentFilter.NO_MATCH_DATA: reason = "data"; break;
                                case IntentFilter.NO_MATCH_TYPE: reason = "type"; break;
                                default: reason = "unknown reason"; break;
                            }
                            Log.v(TAG, "  Filter did not match: " + reason);
                        }
                    }
                }

                if (receivers != null) {
                    for (int i=0; i<receivers.size(); i++) {
                        receivers.get(i).broadcasting = false;
                    }
                    mPendingBroadcasts.add(new BroadcastRecord(intent, receivers));
                    if (!mHandler.hasMessages(MSG_EXEC_PENDING_BROADCASTS)) {
                        mHandler.sendEmptyMessage(MSG_EXEC_PENDING_BROADCASTS);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Like {@link #sendBroadcast(Intent)}, but if there are any receivers for
     * the Intent this function will block and immediately dispatch them before
     * returning.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.544 -0500", hash_original_method = "6A77C49D1FDA5F97149304A23CA19549", hash_generated_method = "A3CEB97D233FA0C900D9BEA324A80F69")
    
public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:29.547 -0500", hash_original_method = "3F6742DF10D1E655ECFD08018DEE1CF4", hash_generated_method = "2833AEBD2A648D4F5FC47CC83599C8FF")
    
private void executePendingBroadcasts() {
        while (true) {
            BroadcastRecord[] brs = null;
            synchronized (mReceivers) {
                final int N = mPendingBroadcasts.size();
                if (N <= 0) {
                    return;
                }
                brs = new BroadcastRecord[N];
                mPendingBroadcasts.toArray(brs);
                mPendingBroadcasts.clear();
            }
            for (int i=0; i<brs.length; i++) {
                BroadcastRecord br = brs[i];
                for (int j=0; j<br.receivers.size(); j++) {
                    br.receivers.get(j).receiver.onReceive(mAppContext, br.intent);
                }
            }
        }
    }
}

