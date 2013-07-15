package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.net.http.EventHandler;
import android.net.http.Headers;
import android.os.Handler;
import android.os.Message;
import java.io.IOException;
import java.io.InputStream;

abstract class StreamLoader implements Handler.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.233 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.233 -0400", hash_original_field = "FD98EF1D956356B754B181390D5904EB", hash_generated_field = "E2AC94C6534F51915562E9E51CE4D893")

    protected LoadListener mLoadListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.234 -0400", hash_original_field = "71176C7D8BB8A867631C3FBAD06414DC", hash_generated_field = "F182CEB3CE562DC3186CF7BAB9AD8EC7")

    protected InputStream mDataStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.234 -0400", hash_original_field = "D4BC2D0F0185C97879D7062C4CEFD633", hash_generated_field = "D56DA25B404AFDA8695ED0F36A7C56D4")

    protected long mContentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.234 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "04254C7D5555806109D3DE22B9918A82")

    private byte [] mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.234 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.234 -0400", hash_original_method = "5C97985D356D0B8BED26A67B0D8173AD", hash_generated_method = "946A007DCB3F4FFE5E10BC4ACF10927B")
      StreamLoader(LoadListener loadlistener) {
        mLoadListener = loadlistener;
        mContext = loadlistener.getContext();
        // ---------- Original Method ----------
        //mLoadListener = loadlistener;
        //mContext = loadlistener.getContext();
    }

    
    protected abstract boolean setupStreamAndSendStatus();

    
    abstract protected void buildHeaders(Headers headers);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.235 -0400", hash_original_method = "9A005467E60C2D9227C099A6A0EA45F6", hash_generated_method = "E90337EC0A476EFB36BEAF650C7551C5")
    final void load() {
        synchronized
(this)        {
    if(mHandler == null)            
            {
                mHandler = new Handler(this);
            } //End block
        } //End block
    if(!mLoadListener.isSynchronous())        
        {
            mHandler.sendEmptyMessage(MSG_STATUS);
        } //End block
        else
        {
    if(setupStreamAndSendStatus())            
            {
                mData = new byte[8192];
                sendHeaders();
                while
(!sendData() && !mLoadListener.cancelled())                
                ;
                closeStreamAndSendEndData();
                mLoadListener.loadSynchronousMessages();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mHandler == null) {
                //mHandler = new Handler(this);
            //}
        //}
        //if (!mLoadListener.isSynchronous()) {
            //mHandler.sendEmptyMessage(MSG_STATUS);
        //} else {
            //if (setupStreamAndSendStatus()) {
                //mData = new byte[8192];
                //sendHeaders();
                //while (!sendData() && !mLoadListener.cancelled());
                //closeStreamAndSendEndData();
                //mLoadListener.loadSynchronousMessages();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.236 -0400", hash_original_method = "00FB85FDD84A2FA0A52746CD7D8A6203", hash_generated_method = "E2BE931B2F9680B9517BEBB95CF299F9")
    public boolean handleMessage(Message msg) {
        addTaint(msg.getTaint());
    if(mLoadListener.isSynchronous())        
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1488693432 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1488693432.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_1488693432;
        } //End block
    if(mLoadListener.cancelled())        
        {
            closeStreamAndSendEndData();
            boolean varB326B5062B2F0E69046810717534CB09_10406571 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_135581520 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_135581520;
        } //End block
switch(msg.what){
        case MSG_STATUS:
    if(setupStreamAndSendStatus())        
        {
            mData = new byte[8192];
            mHandler.sendEmptyMessage(MSG_HEADERS);
        } //End block
        break;
        case MSG_HEADERS:
        sendHeaders();
        mHandler.sendEmptyMessage(MSG_DATA);
        break;
        case MSG_DATA:
    if(sendData())        
        {
            mHandler.sendEmptyMessage(MSG_END);
        } //End block
        else
        {
            mHandler.sendEmptyMessage(MSG_DATA);
        } //End block
        break;
        case MSG_END:
        closeStreamAndSendEndData();
        break;
        default:
        boolean var68934A3E9455FA72420237EB05902327_1367928807 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_735526465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_735526465;
}        boolean varB326B5062B2F0E69046810717534CB09_259823343 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_136106617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_136106617;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.237 -0400", hash_original_method = "65A84C3A774E903513B92EB5B550F331", hash_generated_method = "F97064E3938DEEBD16AA40E70959E257")
    private void sendHeaders() {
        Headers headers = new Headers();
    if(mContentLength > 0)        
        {
            headers.setContentLength(mContentLength);
        } //End block
        buildHeaders(headers);
        mLoadListener.headers(headers);
        // ---------- Original Method ----------
        //Headers headers = new Headers();
        //if (mContentLength > 0) {
            //headers.setContentLength(mContentLength);
        //}
        //buildHeaders(headers);
        //mLoadListener.headers(headers);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.237 -0400", hash_original_method = "4C4D4DF9D04A987F005277A578061144", hash_generated_method = "843F4079FC6D0343441424EC50493D73")
    private boolean sendData() {
    if(mDataStream != null)        
        {
            try 
            {
                int amount = mDataStream.read(mData);
    if(amount > 0)                
                {
                    mLoadListener.data(mData, amount);
                    boolean var68934A3E9455FA72420237EB05902327_1525664698 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2070088053 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2070088053;
                } //End block
            } //End block
            catch (IOException ex)
            {
                mLoadListener.error(EventHandler.FILE_ERROR, ex.getMessage());
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1743668612 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_861646612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_861646612;
        // ---------- Original Method ----------
        //if (mDataStream != null) {
            //try {
                //int amount = mDataStream.read(mData);
                //if (amount > 0) {
                    //mLoadListener.data(mData, amount);
                    //return false;
                //}
            //} catch (IOException ex) {
                //mLoadListener.error(EventHandler.FILE_ERROR, ex.getMessage());
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.238 -0400", hash_original_method = "1E3300194DB856434710C1AC838853B7", hash_generated_method = "85C7FCBAE96F31152501A4FECB65A952")
    private void closeStreamAndSendEndData() {
    if(mDataStream != null)        
        {
            try 
            {
                mDataStream.close();
            } //End block
            catch (IOException ex)
            {
            } //End block
        } //End block
        mLoadListener.endData();
        // ---------- Original Method ----------
        //if (mDataStream != null) {
            //try {
                //mDataStream.close();
            //} catch (IOException ex) {
            //}
        //}
        //mLoadListener.endData();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.238 -0400", hash_original_field = "3B4EDCD356FF8FD8A81606390C1D31E7", hash_generated_field = "116567EA42424CED6A518F03ECAEF9D0")

    private static final int MSG_STATUS = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.238 -0400", hash_original_field = "B5CF47C9CB13830E5FEF6A561C9C73CD", hash_generated_field = "2560EAA9C0C83E19C62565F808C069B9")

    private static final int MSG_HEADERS = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.238 -0400", hash_original_field = "824252C5EBC5267DA1C9532BA0F4F003", hash_generated_field = "B7C277C22A8740A16DB4ABF4E167CE64")

    private static final int MSG_DATA = 102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.238 -0400", hash_original_field = "7B0322BAC1CD991CE8CA33B865EEC5BD", hash_generated_field = "02484FCE1BED4E8C22849757523483A9")

    private static final int MSG_END = 103;
}

