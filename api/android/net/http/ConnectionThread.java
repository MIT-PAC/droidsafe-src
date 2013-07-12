package android.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.os.SystemClock;
import org.apache.http.HttpHost;
import java.lang.Thread;

class ConnectionThread extends Thread {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.043 -0400", hash_original_field = "793D188D0FFF23A6E7CC768DA7F9B840", hash_generated_field = "E966A0C9EF7AB198CDE57AFDD0799F34")

    long mCurrentThreadTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.043 -0400", hash_original_field = "C9F4DB9309CF10FB205FD29A0183D3F8", hash_generated_field = "16BF64DFEFBE8CCBBAB04441B66D83E5")

    long mTotalThreadTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.043 -0400", hash_original_field = "DC0BE9C6260397A900BE7253A2B9890D", hash_generated_field = "665647B80D6EB31435625685BA1ECE83")

    private boolean mWaiting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.043 -0400", hash_original_field = "4ED22F80A4118E31698980812AE1749C", hash_generated_field = "1680C4AF884999C7E334262B1B6BB81C")

    private volatile boolean mRunning = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.043 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.043 -0400", hash_original_field = "5EFC8D474E5D8AC9B1E5CD45F5EB1E60", hash_generated_field = "5E862F9BC4AF6A124C2523C96F48D143")

    private RequestQueue.ConnectionManager mConnectionManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.043 -0400", hash_original_field = "2E54C55B0E19AE6A5D3D5CB288053E14", hash_generated_field = "AB9F34A7715DF2E623F95D1821A3CBDB")

    private RequestFeeder mRequestFeeder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.043 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.043 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "D468AD0EA1184CE89FA8A45254E2CDD6")

    Connection mConnection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.044 -0400", hash_original_method = "49EA97FC2CE469A889BBEB2F2C20CC1F", hash_generated_method = "097443EBF9CF323667CA17E46171EA8B")
      ConnectionThread(Context context,
                     int id,
                     RequestQueue.ConnectionManager connectionManager,
                     RequestFeeder requestFeeder) {
        super();
        mContext = context;
        setName("http" + id);
        mId = id;
        mConnectionManager = connectionManager;
        mRequestFeeder = requestFeeder;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.045 -0400", hash_original_method = "A5666AE0946DEF68E8FF606C0FDBCF6D", hash_generated_method = "675E9DAA678FFBEB722D5811FBE321FA")
     void requestStop() {
        synchronized
(mRequestFeeder)        {
            mRunning = false;
            mRequestFeeder.notify();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.046 -0400", hash_original_method = "CA4464BE27725D08DF2A2ECD7DD50C0A", hash_generated_method = "321CAEEC0AA72FE52E3C35F0897689E5")
    public void run() {
        android.os.Process.setThreadPriority(
                android.os.Process.THREAD_PRIORITY_DEFAULT +
                android.os.Process.THREAD_PRIORITY_LESS_FAVORABLE);
        mCurrentThreadTime = 0;
        mTotalThreadTime = 0;
        while
(mRunning)        
        {
    if(mCurrentThreadTime == -1)            
            {
                mCurrentThreadTime = SystemClock.currentThreadTimeMillis();
            } 
            Request request;
            request = mRequestFeeder.getRequest();
    if(request == null)            
            {
                synchronized
(mRequestFeeder)                {
    if(HttpLog.LOGV)                    
                    HttpLog.v("ConnectionThread: Waiting for work");
                    mWaiting = true;
                    try 
                    {
                        mRequestFeeder.wait();
                    } 
                    catch (InterruptedException e)
                    {
                    } 
                    mWaiting = false;
    if(mCurrentThreadTime != 0)                    
                    {
                        mCurrentThreadTime = SystemClock
                                .currentThreadTimeMillis();
                    } 
                } 
            } 
            else
            {
    if(HttpLog.LOGV)                
                HttpLog.v("ConnectionThread: new request " +
                                            request.mHost + " " + request );
                mConnection = mConnectionManager.getConnection(mContext,
                        request.mHost);
                mConnection.processRequests(request);
    if(mConnection.getCanPersist())                
                {
    if(!mConnectionManager.recycleConnection(mConnection))                    
                    {
                        mConnection.closeConnection();
                    } 
                } 
                else
                {
                    mConnection.closeConnection();
                } 
                mConnection = null;
    if(mCurrentThreadTime > 0)                
                {
                    long start = mCurrentThreadTime;
                    mCurrentThreadTime = SystemClock.currentThreadTimeMillis();
                    mTotalThreadTime += mCurrentThreadTime - start;
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.047 -0400", hash_original_method = "E5691DA5C4D558B8174DB10F2BE5CF59", hash_generated_method = "404E008F71741DAEF6B475E0834C6375")
    public synchronized String toString() {
        String con = mConnection == null ? "" : mConnection.toString();
        String active = mWaiting ? "w" : "a";
String var98F50121D64DEEC996C69F99D7531F87_1079496413 =         "cid " + mId + " " + active + " "  + con;
        var98F50121D64DEEC996C69F99D7531F87_1079496413.addTaint(taint);
        return var98F50121D64DEEC996C69F99D7531F87_1079496413;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.047 -0400", hash_original_field = "37F1071189E290FFCE62D59EA5B3875F", hash_generated_field = "CDF9EFF3FF58D3FBB7389BB4E67088C6")

    static final int WAIT_TIMEOUT = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.047 -0400", hash_original_field = "A74DA8C525A93C3AE2D4F4930D47C83E", hash_generated_field = "6434CE10B92F984DC3B223CA51302E19")

    static final int WAIT_TICK = 1000;
}

