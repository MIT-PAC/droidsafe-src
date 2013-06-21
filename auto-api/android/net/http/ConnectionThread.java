package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.SystemClock;
import org.apache.http.HttpHost;
import java.lang.Thread;

class ConnectionThread extends Thread {
    long mCurrentThreadTime;
    long mTotalThreadTime;
    private boolean mWaiting;
    private volatile boolean mRunning = true;
    private Context mContext;
    private RequestQueue.ConnectionManager mConnectionManager;
    private RequestFeeder mRequestFeeder;
    private int mId;
    Connection mConnection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.764 -0400", hash_original_method = "49EA97FC2CE469A889BBEB2F2C20CC1F", hash_generated_method = "CE391A857C72B462F232525D3411AFE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ConnectionThread(Context context,
                     int id,
                     RequestQueue.ConnectionManager connectionManager,
                     RequestFeeder requestFeeder) {
        super();
        dsTaint.addTaint(id);
        dsTaint.addTaint(requestFeeder.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(connectionManager.dsTaint);
        setName("http" + id);
        // ---------- Original Method ----------
        //mContext = context;
        //setName("http" + id);
        //mId = id;
        //mConnectionManager = connectionManager;
        //mRequestFeeder = requestFeeder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.764 -0400", hash_original_method = "A5666AE0946DEF68E8FF606C0FDBCF6D", hash_generated_method = "146A132A51D2014347E7E60F759AB8B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void requestStop() {
        {
            mRunning = false;
            mRequestFeeder.notify();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mRequestFeeder) {
            //mRunning = false;
            //mRequestFeeder.notify();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.765 -0400", hash_original_method = "CA4464BE27725D08DF2A2ECD7DD50C0A", hash_generated_method = "220C7FF12C63C632CDC1DBA9774F444A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void run() {
        android.os.Process.setThreadPriority(
                android.os.Process.THREAD_PRIORITY_DEFAULT +
                android.os.Process.THREAD_PRIORITY_LESS_FAVORABLE);
        mCurrentThreadTime = 0;
        mTotalThreadTime = 0;
        {
            {
                mCurrentThreadTime = SystemClock.currentThreadTimeMillis();
            } //End block
            Request request;
            request = mRequestFeeder.getRequest();
            {
                {
                    HttpLog.v("ConnectionThread: Waiting for work");
                    mWaiting = true;
                    try 
                    {
                        mRequestFeeder.wait();
                    } //End block
                    catch (InterruptedException e)
                    { }
                    mWaiting = false;
                    {
                        mCurrentThreadTime = SystemClock
                                .currentThreadTimeMillis();
                    } //End block
                } //End block
            } //End block
            {
                HttpLog.v("ConnectionThread: new request " +
                                            request.mHost + " " + request );
                mConnection = mConnectionManager.getConnection(mContext,
                        request.mHost);
                mConnection.processRequests(request);
                {
                    boolean varD5AEC6D093310AD720CDB061A6373BFF_1432420232 = (mConnection.getCanPersist());
                    {
                        {
                            boolean var4DDBADB5FFB4D38AD68D095920A44FB9_1809968427 = (!mConnectionManager.recycleConnection(mConnection));
                            {
                                mConnection.closeConnection();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        mConnection.closeConnection();
                    } //End block
                } //End collapsed parenthetic
                mConnection = null;
                {
                    long start;
                    start = mCurrentThreadTime;
                    mCurrentThreadTime = SystemClock.currentThreadTimeMillis();
                    mTotalThreadTime += mCurrentThreadTime - start;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.765 -0400", hash_original_method = "E5691DA5C4D558B8174DB10F2BE5CF59", hash_generated_method = "31FC6B50B19543E539E653E8EA3BEBB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized String toString() {
        String con;
        con = "";
        con = mConnection.toString();
        String active;
        active = "w";
        active = "a";
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String con = mConnection == null ? "" : mConnection.toString();
        //String active = mWaiting ? "w" : "a";
        //return "cid " + mId + " " + active + " "  + con;
    }

    
    static final int WAIT_TIMEOUT = 5000;
    static final int WAIT_TICK = 1000;
}

