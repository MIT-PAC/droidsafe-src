package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.net.http.EventHandler;
import android.net.http.Headers;
import android.os.Handler;
import android.os.Message;
import java.io.IOException;
import java.io.InputStream;

abstract class StreamLoader implements Handler.Callback {
    protected Context mContext;
    protected LoadListener mLoadListener;
    protected InputStream mDataStream;
    protected long mContentLength;
    private byte [] mData;
    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.771 -0400", hash_original_method = "5C97985D356D0B8BED26A67B0D8173AD", hash_generated_method = "3CB499B5A99E6D6CFAC451C812B099C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     StreamLoader(LoadListener loadlistener) {
        dsTaint.addTaint(loadlistener.dsTaint);
        mContext = loadlistener.getContext();
        // ---------- Original Method ----------
        //mLoadListener = loadlistener;
        //mContext = loadlistener.getContext();
    }

    
    protected abstract boolean setupStreamAndSendStatus();

    
    abstract protected void buildHeaders(Headers headers);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.771 -0400", hash_original_method = "9A005467E60C2D9227C099A6A0EA45F6", hash_generated_method = "6D08B3123E5644DAD5B97D59E1A0F544")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void load() {
        {
            {
                mHandler = new Handler(this);
            } //End block
        } //End block
        {
            boolean varD651E46A84333BE14ED7DC06FB27D56B_2002917731 = (!mLoadListener.isSynchronous());
            {
                mHandler.sendEmptyMessage(MSG_STATUS);
            } //End block
            {
                {
                    boolean varF501B1EE8895D7D1801560BFBD5B0223_1751217604 = (setupStreamAndSendStatus());
                    {
                        mData = new byte[8192];
                        sendHeaders();
                        {
                            boolean var2196D987793B000A45CE9DC816F7AA78_811456183 = (!sendData() && !mLoadListener.cancelled());
                            ;
                        } //End collapsed parenthetic
                        closeStreamAndSendEndData();
                        mLoadListener.loadSynchronousMessages();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.772 -0400", hash_original_method = "00FB85FDD84A2FA0A52746CD7D8A6203", hash_generated_method = "84D96B768DF3AB5870A63C38869942F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        {
            boolean var27BC34C7E113EAD226D4C2800E637990_325359457 = (mLoadListener.isSynchronous());
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var51592F2E4BF10483FBCB8D3F978AF6EE_66118064 = (mLoadListener.cancelled());
            {
                closeStreamAndSendEndData();
            } //End block
        } //End collapsed parenthetic
        //Begin case MSG_STATUS 
        {
            boolean varD51F49474299435EFAFBEB409E9FC4DF_667246932 = (setupStreamAndSendStatus());
            {
                mData = new byte[8192];
                mHandler.sendEmptyMessage(MSG_HEADERS);
            } //End block
        } //End collapsed parenthetic
        //End case MSG_STATUS 
        //Begin case MSG_HEADERS 
        sendHeaders();
        //End case MSG_HEADERS 
        //Begin case MSG_HEADERS 
        mHandler.sendEmptyMessage(MSG_DATA);
        //End case MSG_HEADERS 
        //Begin case MSG_DATA 
        {
            boolean var1A20D36B5DB1848297E95A16125122BA_562371779 = (sendData());
            {
                mHandler.sendEmptyMessage(MSG_END);
            } //End block
            {
                mHandler.sendEmptyMessage(MSG_DATA);
            } //End block
        } //End collapsed parenthetic
        //End case MSG_DATA 
        //Begin case MSG_END 
        closeStreamAndSendEndData();
        //End case MSG_END 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.772 -0400", hash_original_method = "65A84C3A774E903513B92EB5B550F331", hash_generated_method = "0D61EC49BDDEE6D8A5014A6B6EAEC832")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendHeaders() {
        Headers headers;
        headers = new Headers();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.772 -0400", hash_original_method = "4C4D4DF9D04A987F005277A578061144", hash_generated_method = "32D9C3CE7D48BFA4DF8B4D08D5C5979D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean sendData() {
        {
            try 
            {
                int amount;
                amount = mDataStream.read(mData);
                {
                    mLoadListener.data(mData, amount);
                } //End block
            } //End block
            catch (IOException ex)
            {
                mLoadListener.error(EventHandler.FILE_ERROR, ex.getMessage());
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.772 -0400", hash_original_method = "1E3300194DB856434710C1AC838853B7", hash_generated_method = "A24F5F05DD5CC0F492ED74118F9075A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void closeStreamAndSendEndData() {
        {
            try 
            {
                mDataStream.close();
            } //End block
            catch (IOException ex)
            { }
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

    
    private static final int MSG_STATUS = 100;
    private static final int MSG_HEADERS = 101;
    private static final int MSG_DATA = 102;
    private static final int MSG_END = 103;
}

