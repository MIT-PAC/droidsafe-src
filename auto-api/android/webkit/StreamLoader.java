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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.336 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.336 -0400", hash_original_field = "FD98EF1D956356B754B181390D5904EB", hash_generated_field = "E2AC94C6534F51915562E9E51CE4D893")

    protected LoadListener mLoadListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.336 -0400", hash_original_field = "71176C7D8BB8A867631C3FBAD06414DC", hash_generated_field = "F182CEB3CE562DC3186CF7BAB9AD8EC7")

    protected InputStream mDataStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.336 -0400", hash_original_field = "D4BC2D0F0185C97879D7062C4CEFD633", hash_generated_field = "D56DA25B404AFDA8695ED0F36A7C56D4")

    protected long mContentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.336 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "04254C7D5555806109D3DE22B9918A82")

    private byte [] mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.336 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.337 -0400", hash_original_method = "5C97985D356D0B8BED26A67B0D8173AD", hash_generated_method = "946A007DCB3F4FFE5E10BC4ACF10927B")
      StreamLoader(LoadListener loadlistener) {
        mLoadListener = loadlistener;
        mContext = loadlistener.getContext();
        // ---------- Original Method ----------
        //mLoadListener = loadlistener;
        //mContext = loadlistener.getContext();
    }

    
    protected abstract boolean setupStreamAndSendStatus();

    
    abstract protected void buildHeaders(Headers headers);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.338 -0400", hash_original_method = "9A005467E60C2D9227C099A6A0EA45F6", hash_generated_method = "EE33525D19ECB8F999CC3954EEE54425")
    final void load() {
        {
            {
                mHandler = new Handler(this);
            } //End block
        } //End block
        {
            boolean varD651E46A84333BE14ED7DC06FB27D56B_1165571721 = (!mLoadListener.isSynchronous());
            {
                mHandler.sendEmptyMessage(MSG_STATUS);
            } //End block
            {
                {
                    boolean varF501B1EE8895D7D1801560BFBD5B0223_1053813322 = (setupStreamAndSendStatus());
                    {
                        mData = new byte[8192];
                        sendHeaders();
                        {
                            boolean var2196D987793B000A45CE9DC816F7AA78_433534389 = (!sendData() && !mLoadListener.cancelled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.339 -0400", hash_original_method = "00FB85FDD84A2FA0A52746CD7D8A6203", hash_generated_method = "0296EE62877EB27BE8000E70E04C5F38")
    public boolean handleMessage(Message msg) {
        {
            boolean var27BC34C7E113EAD226D4C2800E637990_536798973 = (mLoadListener.isSynchronous());
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var51592F2E4BF10483FBCB8D3F978AF6EE_515542830 = (mLoadListener.cancelled());
            {
                closeStreamAndSendEndData();
            } //End block
        } //End collapsed parenthetic
        //Begin case MSG_STATUS 
        {
            boolean varD51F49474299435EFAFBEB409E9FC4DF_315700772 = (setupStreamAndSendStatus());
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
            boolean var1A20D36B5DB1848297E95A16125122BA_2077756184 = (sendData());
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
        addTaint(msg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_432592547 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_432592547;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.340 -0400", hash_original_method = "65A84C3A774E903513B92EB5B550F331", hash_generated_method = "0D61EC49BDDEE6D8A5014A6B6EAEC832")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.340 -0400", hash_original_method = "4C4D4DF9D04A987F005277A578061144", hash_generated_method = "26A3649185378012B04A2D6D57FF45E4")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_308029153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_308029153;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.341 -0400", hash_original_method = "1E3300194DB856434710C1AC838853B7", hash_generated_method = "A24F5F05DD5CC0F492ED74118F9075A1")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.341 -0400", hash_original_field = "3B4EDCD356FF8FD8A81606390C1D31E7", hash_generated_field = "8A56D94C3ADF04AD5911A6FDECB86B6B")

    private static int MSG_STATUS = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.341 -0400", hash_original_field = "B5CF47C9CB13830E5FEF6A561C9C73CD", hash_generated_field = "680591CAB5E78588FDFECE64F3500684")

    private static int MSG_HEADERS = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.341 -0400", hash_original_field = "824252C5EBC5267DA1C9532BA0F4F003", hash_generated_field = "BF6097A2FAAFEE39486B65E83CC2DFBC")

    private static int MSG_DATA = 102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.341 -0400", hash_original_field = "7B0322BAC1CD991CE8CA33B865EEC5BD", hash_generated_field = "F5FDC12A8B2BAE0977C6077FADC46465")

    private static int MSG_END = 103;
}

