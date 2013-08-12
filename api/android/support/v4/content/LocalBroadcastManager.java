package android.support.v4.content;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.921 -0400", hash_original_field = "5ABA4A253E78386295F297E632FF4E34", hash_generated_field = "722D46A23A9E453AC7AC6D5797C29418")

    private Context mAppContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.921 -0400", hash_original_field = "CF1ED9DC36CA7F5EE607FA3611C8E9F9", hash_generated_field = "07FFA70DD32DFA27A9E1E6FAA73F1FDA")

    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap<BroadcastReceiver, ArrayList<IntentFilter>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.921 -0400", hash_original_field = "CBCE1400F5F4FB069927315C28310C8E", hash_generated_field = "A942E9E79E2149A4FF9308B612EC1D8E")

    private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap<String, ArrayList<ReceiverRecord>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.921 -0400", hash_original_field = "DE97FF32B9E7DC19E99BB6165F6D3715", hash_generated_field = "64369177E49D20F3A922FD3B9CC9E74F")

    private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList<BroadcastRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.921 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.922 -0400", hash_original_method = "839AC2DB210099F0B624D40E6378447E", hash_generated_method = "1963CB7FD696A59C71B1B0E04AC6874D")
    private  LocalBroadcastManager(Context context) {
        mAppContext = context;
        mHandler = new Handler(context.getMainLooper()) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.922 -0400", hash_original_method = "83DCC689423DD34BA48280EAD0078C8B", hash_generated_method = "76B3AFC1F546C36752176F8D87CD265F")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case MSG_EXEC_PENDING_BROADCASTS:
            executePendingBroadcasts();
            break;
            default:
            super.handleMessage(msg);
}
            // ---------- Original Method ----------
            //switch (msg.what) {
                    //case MSG_EXEC_PENDING_BROADCASTS:
                        //executePendingBroadcasts();
                        //break;
                    //default:
                        //super.handleMessage(msg);
                //}
        }
};
        // ---------- Original Method ----------
        //mAppContext = context;
        //mHandler = new Handler(context.getMainLooper()) {
            //@Override
            //public void handleMessage(Message msg) {
                //switch (msg.what) {
                    //case MSG_EXEC_PENDING_BROADCASTS:
                        //executePendingBroadcasts();
                        //break;
                    //default:
                        //super.handleMessage(msg);
                //}
            //}
        //};
    }

    
    @DSModeled(DSC.SAFE)
    public static LocalBroadcastManager getInstance(Context context) {
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            return mInstance;
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.924 -0400", hash_original_method = "D32BC0D25E86F605EE68EB4056334640", hash_generated_method = "DEB5CCDAF9907A914B6D32E8A8C076EB")
    public void registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
        synchronized
(mReceivers)        {
            ReceiverRecord entry = new ReceiverRecord(filter, receiver);
            ArrayList<IntentFilter> filters = mReceivers.get(receiver);
            if(filters == null)            
            {
                filters = new ArrayList<IntentFilter>(1);
                mReceivers.put(receiver, filters);
            } //End block
            filters.add(filter);
for(int i=0;i<filter.countActions();i++)
            {
                String action = filter.getAction(i);
                ArrayList<ReceiverRecord> entries = mActions.get(action);
                if(entries == null)                
                {
                    entries = new ArrayList<ReceiverRecord>(1);
                    mActions.put(action, entries);
                } //End block
                entries.add(entry);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mReceivers) {
            //ReceiverRecord entry = new ReceiverRecord(filter, receiver);
            //ArrayList<IntentFilter> filters = mReceivers.get(receiver);
            //if (filters == null) {
                //filters = new ArrayList<IntentFilter>(1);
                //mReceivers.put(receiver, filters);
            //}
            //filters.add(filter);
            //for (int i=0; i<filter.countActions(); i++) {
                //String action = filter.getAction(i);
                //ArrayList<ReceiverRecord> entries = mActions.get(action);
                //if (entries == null) {
                    //entries = new ArrayList<ReceiverRecord>(1);
                    //mActions.put(action, entries);
                //}
                //entries.add(entry);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.925 -0400", hash_original_method = "8566D0E7C4974CA9CB93E779F651E45B", hash_generated_method = "3625ED483570B46782C4A5B100AE37DF")
    public void unregisterReceiver(BroadcastReceiver receiver) {
        addTaint(receiver.getTaint());
        synchronized
(mReceivers)        {
            ArrayList<IntentFilter> filters = mReceivers.remove(receiver);
            if(filters == null)            
            {
                return;
            } //End block
for(int i=0;i<filters.size();i++)
            {
                IntentFilter filter = filters.get(i);
for(int j=0;j<filter.countActions();j++)
                {
                    String action = filter.getAction(j);
                    ArrayList<ReceiverRecord> receivers = mActions.get(action);
                    if(receivers != null)                    
                    {
for(int k=0;k<receivers.size();k++)
                        {
                            if(receivers.get(k).receiver == receiver)                            
                            {
                                receivers.remove(k);
                                k--;
                            } //End block
                        } //End block
                        if(receivers.size() <= 0)                        
                        {
                            mActions.remove(action);
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.929 -0400", hash_original_method = "D242868C7C53E8784BBDECD4F038DC32", hash_generated_method = "A4B2124FB1D8205A585771663AB06232")
    public boolean sendBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        synchronized
(mReceivers)        {
            final String action = intent.getAction();
            final String type = intent.resolveTypeIfNeeded(
                    mAppContext.getContentResolver());
            final Uri data = intent.getData();
            final String scheme = intent.getScheme();
            final Set<String> categories = intent.getCategories();
            final boolean debug = DEBUG ||
                    ((intent.getFlags() & Intent.FLAG_DEBUG_LOG_RESOLUTION) != 0);
            if(debug){ }            ArrayList<ReceiverRecord> entries = mActions.get(intent.getAction());
            if(entries != null)            
            {
                if(debug){ }                ArrayList<ReceiverRecord> receivers = null;
for(int i=0;i<entries.size();i++)
                {
                    ReceiverRecord receiver = entries.get(i);
                    if(debug){ }                    if(receiver.broadcasting)                    
                    {
                        if(debug)                        
                        {
                        } //End block
                        continue;
                    } //End block
                    int match = receiver.filter.match(action, type, scheme, data,
                            categories, "LocalBroadcastManager");
                    if(match >= 0)                    
                    {
                        if(debug){ }                        if(receivers == null)                        
                        {
                            receivers = new ArrayList<ReceiverRecord>();
                        } //End block
                        receivers.add(receiver);
                        receiver.broadcasting = true;
                    } //End block
                    else
                    {
                        if(debug)                        
                        {
                            String reason;
switch(match){
                            case IntentFilter.NO_MATCH_ACTION:
                            reason = "action";
                            break;
                            case IntentFilter.NO_MATCH_CATEGORY:
                            reason = "category";
                            break;
                            case IntentFilter.NO_MATCH_DATA:
                            reason = "data";
                            break;
                            case IntentFilter.NO_MATCH_TYPE:
                            reason = "type";
                            break;
                            default:
                            reason = "unknown reason";
                            break;
}
                        } //End block
                    } //End block
                } //End block
                if(receivers != null)                
                {
for(int i=0;i<receivers.size();i++)
                    {
                        receivers.get(i).broadcasting = false;
                    } //End block
                    mPendingBroadcasts.add(new BroadcastRecord(intent, receivers));
                    if(!mHandler.hasMessages(MSG_EXEC_PENDING_BROADCASTS))                    
                    {
                        mHandler.sendEmptyMessage(MSG_EXEC_PENDING_BROADCASTS);
                    } //End block
                    boolean varB326B5062B2F0E69046810717534CB09_1409914868 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1867205580 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1867205580;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1594787830 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1457264947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1457264947;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.930 -0400", hash_original_method = "6A77C49D1FDA5F97149304A23CA19549", hash_generated_method = "06A55254D0C8834ABD9179F35C96405C")
    public void sendBroadcastSync(Intent intent) {
        addTaint(intent.getTaint());
        if(sendBroadcast(intent))        
        {
            executePendingBroadcasts();
        } //End block
        // ---------- Original Method ----------
        //if (sendBroadcast(intent)) {
            //executePendingBroadcasts();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.931 -0400", hash_original_method = "3F6742DF10D1E655ECFD08018DEE1CF4", hash_generated_method = "04FAAF88FDEB1E40F0F726195B57428A")
    private void executePendingBroadcasts() {
        while
(true)        
        {
            BroadcastRecord[] brs = null;
            synchronized
(mReceivers)            {
                final int N = mPendingBroadcasts.size();
                if(N <= 0)                
                {
                    return;
                } //End block
                brs = new BroadcastRecord[N];
                mPendingBroadcasts.toArray(brs);
                mPendingBroadcasts.clear();
            } //End block
for(int i=0;i<brs.length;i++)
            {
                BroadcastRecord br = brs[i];
for(int j=0;j<br.receivers.size();j++)
                {
                    br.receivers.get(j).receiver.onReceive(mAppContext, br.intent);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //while (true) {
            //BroadcastRecord[] brs = null;
            //synchronized (mReceivers) {
                //final int N = mPendingBroadcasts.size();
                //if (N <= 0) {
                    //return;
                //}
                //brs = new BroadcastRecord[N];
                //mPendingBroadcasts.toArray(brs);
                //mPendingBroadcasts.clear();
            //}
            //for (int i=0; i<brs.length; i++) {
                //BroadcastRecord br = brs[i];
                //for (int j=0; j<br.receivers.size(); j++) {
                    //br.receivers.get(j).receiver.onReceive(mAppContext, br.intent);
                //}
            //}
        //}
    }

    
    private static class ReceiverRecord {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.932 -0400", hash_original_field = "B2C97AE425DD751B0E48A3ACAE79CF4A", hash_generated_field = "7DA86C636503E600C04786FD252B8201")

        IntentFilter filter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.932 -0400", hash_original_field = "A2AE6CC9A7ACFFF494422585A43459C2", hash_generated_field = "5CD98931683D8080FFA0C51C86AE5674")

        BroadcastReceiver receiver;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.932 -0400", hash_original_field = "1D6D7B236FAA73F43F4BA879E374E7C7", hash_generated_field = "3CD7C92A131FB292437CE24C046ECABD")

        boolean broadcasting;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.932 -0400", hash_original_method = "5206887270700039FD440F8685BB60D3", hash_generated_method = "212619789C30CC39BAD38C1E63722CB2")
          ReceiverRecord(IntentFilter _filter, BroadcastReceiver _receiver) {
            filter = _filter;
            receiver = _receiver;
            // ---------- Original Method ----------
            //filter = _filter;
            //receiver = _receiver;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.932 -0400", hash_original_method = "5F4A257948A58F0B78B34620CDA69880", hash_generated_method = "B5B26F8F90BBB26F623C349471AA859E")
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder(128);
            builder.append("Receiver{");
            builder.append(receiver);
            builder.append(" filter=");
            builder.append(filter);
            builder.append("}");
String varF4CF030572656354ACFDF83FEE21D7A6_771655950 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_771655950.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_771655950;
            // ---------- Original Method ----------
            //StringBuilder builder = new StringBuilder(128);
            //builder.append("Receiver{");
            //builder.append(receiver);
            //builder.append(" filter=");
            //builder.append(filter);
            //builder.append("}");
            //return builder.toString();
        }

        
    }


    
    private static class BroadcastRecord {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.933 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.933 -0400", hash_original_field = "32AB90C836B8DF619C5CACEBFA708C12", hash_generated_field = "06A99CF3B8E73116492C21E622D66AE0")

        ArrayList<ReceiverRecord> receivers;
        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.934 -0400", hash_original_method = "AA1A90161822F4E9C86DDF136B615F55", hash_generated_method = "BBEA8E4A968954170762D1941E5579F8")
          BroadcastRecord(Intent _intent, ArrayList<ReceiverRecord> _receivers) {
            intent = _intent;
            receivers = _receivers;
            // ---------- Original Method ----------
            //intent = _intent;
            //receivers = _receivers;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.934 -0400", hash_original_field = "1B6C72BBB594D89FF127DA8203A89F0F", hash_generated_field = "BF4C210169D9CD8EE4EB7FDFBA8151D6")

    private static final String TAG = "LocalBroadcastManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.934 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.934 -0400", hash_original_field = "DAEB47A0EE24E502A5170047929FDA76", hash_generated_field = "62F64C7DBF4C8EA8DBEAB2C0BCF66703")

    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.934 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "CA3747CC2EC4B1C7DB6ABC7879C88A34")

    private static final Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.934 -0400", hash_original_field = "DD62467EBA66E288A1769E403146FE2D", hash_generated_field = "C42A5AFEF5DDC3EB8FF2FCB322675454")

    private static LocalBroadcastManager mInstance;
}

