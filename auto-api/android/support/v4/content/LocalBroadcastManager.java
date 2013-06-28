package android.support.v4.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import android.util.Log;

public class LocalBroadcastManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.330 -0400", hash_original_field = "5ABA4A253E78386295F297E632FF4E34", hash_generated_field = "722D46A23A9E453AC7AC6D5797C29418")

    private Context mAppContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.330 -0400", hash_original_field = "CF1ED9DC36CA7F5EE607FA3611C8E9F9", hash_generated_field = "07FFA70DD32DFA27A9E1E6FAA73F1FDA")

    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap<BroadcastReceiver, ArrayList<IntentFilter>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.330 -0400", hash_original_field = "CBCE1400F5F4FB069927315C28310C8E", hash_generated_field = "A942E9E79E2149A4FF9308B612EC1D8E")

    private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap<String, ArrayList<ReceiverRecord>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.330 -0400", hash_original_field = "DE97FF32B9E7DC19E99BB6165F6D3715", hash_generated_field = "64369177E49D20F3A922FD3B9CC9E74F")

    private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList<BroadcastRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.330 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.331 -0400", hash_original_method = "839AC2DB210099F0B624D40E6378447E", hash_generated_method = "7927900E19A315406D09DA8517B4949A")
    private  LocalBroadcastManager(Context context) {
        mAppContext = context;
        mHandler = new Handler(context.getMainLooper()) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.331 -0400", hash_original_method = "83DCC689423DD34BA48280EAD0078C8B", hash_generated_method = "8768E9F95CC97BA95BE9EA1B61F64374")
            @Override
            public void handleMessage(Message msg) {
                //Begin case MSG_EXEC_PENDING_BROADCASTS 
                executePendingBroadcasts();
                //End case MSG_EXEC_PENDING_BROADCASTS 
                //Begin case default 
                super.handleMessage(msg);
                //End case default 
                addTaint(msg.getTaint());
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

    
        public static LocalBroadcastManager getInstance(Context context) {
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            return mInstance;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.332 -0400", hash_original_method = "D32BC0D25E86F605EE68EB4056334640", hash_generated_method = "48F4C1E4FFB98687F2DFD63F92A3717E")
    public void registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        {
            ReceiverRecord entry = new ReceiverRecord(filter, receiver);
            ArrayList<IntentFilter> filters = mReceivers.get(receiver);
            {
                filters = new ArrayList<IntentFilter>(1);
                mReceivers.put(receiver, filters);
            } //End block
            filters.add(filter);
            {
                int i = 0;
                boolean varAAD646A696A0F28C4C8C37C6F1F415EB_1936551600 = (i<filter.countActions());
                {
                    String action = filter.getAction(i);
                    ArrayList<ReceiverRecord> entries = mActions.get(action);
                    {
                        entries = new ArrayList<ReceiverRecord>(1);
                        mActions.put(action, entries);
                    } //End block
                    entries.add(entry);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.333 -0400", hash_original_method = "8566D0E7C4974CA9CB93E779F651E45B", hash_generated_method = "CC959B041E7D8EF28B97D2D8E1D55E4F")
    public void unregisterReceiver(BroadcastReceiver receiver) {
        {
            ArrayList<IntentFilter> filters = mReceivers.remove(receiver);
            {
                int i = 0;
                boolean var6EF0ACD2F1D6BAA1F522E7486C297BE3_920963205 = (i<filters.size());
                {
                    IntentFilter filter = filters.get(i);
                    {
                        int j = 0;
                        boolean var21823A1752963B76A06B28E61C1E6256_1489824893 = (j<filter.countActions());
                        {
                            String action = filter.getAction(j);
                            ArrayList<ReceiverRecord> receivers = mActions.get(action);
                            {
                                {
                                    int k = 0;
                                    boolean var5556FD7F55B02AD1E5AD476AAB40761A_2027813070 = (k<receivers.size());
                                    {
                                        {
                                            boolean var204C4D0780D72B9665FEA752CB5727B4_331735204 = (receivers.get(k).receiver == receiver);
                                            {
                                                receivers.remove(k);
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                } //End collapsed parenthetic
                                {
                                    boolean var21B5F9DD1CF05B49A466EB3465279263_578588099 = (receivers.size() <= 0);
                                    {
                                        mActions.remove(action);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(receiver.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.334 -0400", hash_original_method = "D242868C7C53E8784BBDECD4F038DC32", hash_generated_method = "C01D458A7C2FB6FF8B31B38234FA4A42")
    public boolean sendBroadcast(Intent intent) {
        {
            final String action = intent.getAction();
            final String type = intent.resolveTypeIfNeeded(
                    mAppContext.getContentResolver());
            final Uri data = intent.getData();
            final String scheme = intent.getScheme();
            final Set<String> categories = intent.getCategories();
            final boolean debug = DEBUG ||
                    ((intent.getFlags() & Intent.FLAG_DEBUG_LOG_RESOLUTION) != 0);
            ArrayList<ReceiverRecord> entries = mActions.get(intent.getAction());
            {
                ArrayList<ReceiverRecord> receivers = null;
                {
                    int i = 0;
                    boolean varF903D9A2A4C1688DEC9B71BAE4B9031F_2143920129 = (i<entries.size());
                    {
                        ReceiverRecord receiver = entries.get(i);
                        int match = receiver.filter.match(action, type, scheme, data,
                            categories, "LocalBroadcastManager");
                        {
                            {
                                receivers = new ArrayList<ReceiverRecord>();
                            } //End block
                            receivers.add(receiver);
                            receiver.broadcasting = true;
                        } //End block
                        {
                            {
                                String reason;
                                //Begin case IntentFilter.NO_MATCH_ACTION 
                                reason = "action";
                                //End case IntentFilter.NO_MATCH_ACTION 
                                //Begin case IntentFilter.NO_MATCH_CATEGORY 
                                reason = "category";
                                //End case IntentFilter.NO_MATCH_CATEGORY 
                                //Begin case IntentFilter.NO_MATCH_DATA 
                                reason = "data";
                                //End case IntentFilter.NO_MATCH_DATA 
                                //Begin case IntentFilter.NO_MATCH_TYPE 
                                reason = "type";
                                //End case IntentFilter.NO_MATCH_TYPE 
                                //Begin case default 
                                reason = "unknown reason";
                                //End case default 
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        int i = 0;
                        boolean var5174ACD26D785FE3D9FBE932B90AC2E9_2106685504 = (i<receivers.size());
                        {
                            receivers.get(i).broadcasting = false;
                        } //End block
                    } //End collapsed parenthetic
                    mPendingBroadcasts.add(new BroadcastRecord(intent, receivers));
                    {
                        boolean var8519EB213129236BD57B99C2409DFA9A_118898435 = (!mHandler.hasMessages(MSG_EXEC_PENDING_BROADCASTS));
                        {
                            mHandler.sendEmptyMessage(MSG_EXEC_PENDING_BROADCASTS);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End block
        addTaint(intent.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1090104157 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1090104157;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.334 -0400", hash_original_method = "6A77C49D1FDA5F97149304A23CA19549", hash_generated_method = "30796E330C6ADE66EC5A9DCC74A083D0")
    public void sendBroadcastSync(Intent intent) {
        {
            boolean varD093B39402F43C48B30156FAFB746858_443544672 = (sendBroadcast(intent));
            {
                executePendingBroadcasts();
            } //End block
        } //End collapsed parenthetic
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //if (sendBroadcast(intent)) {
            //executePendingBroadcasts();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.335 -0400", hash_original_method = "3F6742DF10D1E655ECFD08018DEE1CF4", hash_generated_method = "58C88C4181DF64A8EF984B9E4187CDAC")
    private void executePendingBroadcasts() {
        {
            BroadcastRecord[] brs = null;
            {
                final int N = mPendingBroadcasts.size();
                brs = new BroadcastRecord[N];
                mPendingBroadcasts.toArray(brs);
                mPendingBroadcasts.clear();
            } //End block
            {
                int i = 0;
                {
                    BroadcastRecord br = brs[i];
                    {
                        int j = 0;
                        boolean var54E6167BE1C436BE068C8BF6236AA9F1_862937288 = (j<br.receivers.size());
                        {
                            br.receivers.get(j).receiver.onReceive(mAppContext, br.intent);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.335 -0400", hash_original_field = "B2C97AE425DD751B0E48A3ACAE79CF4A", hash_generated_field = "7DA86C636503E600C04786FD252B8201")

        IntentFilter filter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.335 -0400", hash_original_field = "A2AE6CC9A7ACFFF494422585A43459C2", hash_generated_field = "5CD98931683D8080FFA0C51C86AE5674")

        BroadcastReceiver receiver;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.335 -0400", hash_original_field = "1D6D7B236FAA73F43F4BA879E374E7C7", hash_generated_field = "3CD7C92A131FB292437CE24C046ECABD")

        boolean broadcasting;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.335 -0400", hash_original_method = "5206887270700039FD440F8685BB60D3", hash_generated_method = "212619789C30CC39BAD38C1E63722CB2")
          ReceiverRecord(IntentFilter _filter, BroadcastReceiver _receiver) {
            filter = _filter;
            receiver = _receiver;
            // ---------- Original Method ----------
            //filter = _filter;
            //receiver = _receiver;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.336 -0400", hash_original_method = "5F4A257948A58F0B78B34620CDA69880", hash_generated_method = "AF41414BD3BDE9B145C97B0C94947356")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1633743229 = null; //Variable for return #1
            StringBuilder builder = new StringBuilder(128);
            builder.append("Receiver{");
            builder.append(receiver);
            builder.append(" filter=");
            builder.append(filter);
            builder.append("}");
            varB4EAC82CA7396A68D541C85D26508E83_1633743229 = builder.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1633743229.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1633743229;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.336 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.336 -0400", hash_original_field = "32AB90C836B8DF619C5CACEBFA708C12", hash_generated_field = "06A99CF3B8E73116492C21E622D66AE0")

        ArrayList<ReceiverRecord> receivers;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.337 -0400", hash_original_method = "AA1A90161822F4E9C86DDF136B615F55", hash_generated_method = "BBEA8E4A968954170762D1941E5579F8")
          BroadcastRecord(Intent _intent, ArrayList<ReceiverRecord> _receivers) {
            intent = _intent;
            receivers = _receivers;
            // ---------- Original Method ----------
            //intent = _intent;
            //receivers = _receivers;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.337 -0400", hash_original_field = "1B6C72BBB594D89FF127DA8203A89F0F", hash_generated_field = "BF4C210169D9CD8EE4EB7FDFBA8151D6")

    private static final String TAG = "LocalBroadcastManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.337 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.337 -0400", hash_original_field = "DAEB47A0EE24E502A5170047929FDA76", hash_generated_field = "62F64C7DBF4C8EA8DBEAB2C0BCF66703")

    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.338 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "CA3747CC2EC4B1C7DB6ABC7879C88A34")

    private static final Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.338 -0400", hash_original_field = "DD62467EBA66E288A1769E403146FE2D", hash_generated_field = "C42A5AFEF5DDC3EB8FF2FCB322675454")

    private static LocalBroadcastManager mInstance;
}

