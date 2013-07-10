package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.net.http.EventHandler;
import android.net.http.Headers;
import android.os.Handler;
import android.os.Message;
import java.io.IOException;
import java.io.InputStream;

abstract class StreamLoader implements Handler.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.575 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.575 -0400", hash_original_field = "FD98EF1D956356B754B181390D5904EB", hash_generated_field = "E2AC94C6534F51915562E9E51CE4D893")

    protected LoadListener mLoadListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.575 -0400", hash_original_field = "71176C7D8BB8A867631C3FBAD06414DC", hash_generated_field = "F182CEB3CE562DC3186CF7BAB9AD8EC7")

    protected InputStream mDataStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.575 -0400", hash_original_field = "D4BC2D0F0185C97879D7062C4CEFD633", hash_generated_field = "D56DA25B404AFDA8695ED0F36A7C56D4")

    protected long mContentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.575 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "04254C7D5555806109D3DE22B9918A82")

    private byte [] mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.575 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.575 -0400", hash_original_method = "5C97985D356D0B8BED26A67B0D8173AD", hash_generated_method = "946A007DCB3F4FFE5E10BC4ACF10927B")
      StreamLoader(LoadListener loadlistener) {
        mLoadListener = loadlistener;
        mContext = loadlistener.getContext();
        
        
        
    }

    
    protected abstract boolean setupStreamAndSendStatus();

    
    abstract protected void buildHeaders(Headers headers);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.578 -0400", hash_original_method = "9A005467E60C2D9227C099A6A0EA45F6", hash_generated_method = "C98B62421F908782BC001083F2002B27")
    final void load() {
        {
            {
                mHandler = new Handler(this);
            } 
        } 
        {
            boolean varD651E46A84333BE14ED7DC06FB27D56B_359312853 = (!mLoadListener.isSynchronous());
            {
                mHandler.sendEmptyMessage(MSG_STATUS);
            } 
            {
                {
                    boolean varF501B1EE8895D7D1801560BFBD5B0223_532401723 = (setupStreamAndSendStatus());
                    {
                        mData = new byte[8192];
                        sendHeaders();
                        {
                            boolean var2196D987793B000A45CE9DC816F7AA78_1378856706 = (!sendData() && !mLoadListener.cancelled());
                            ;
                        } 
                        closeStreamAndSendEndData();
                        mLoadListener.loadSynchronousMessages();
                    } 
                } 
            } 
        } 
        
        
            
                
            
        
        
            
        
            
                
                
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.579 -0400", hash_original_method = "00FB85FDD84A2FA0A52746CD7D8A6203", hash_generated_method = "059C2B827E5CEFF7AC8463E64E1C70B3")
    public boolean handleMessage(Message msg) {
        {
            boolean var27BC34C7E113EAD226D4C2800E637990_1297479347 = (mLoadListener.isSynchronous());
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } 
        } 
        {
            boolean var51592F2E4BF10483FBCB8D3F978AF6EE_1446548596 = (mLoadListener.cancelled());
            {
                closeStreamAndSendEndData();
            } 
        } 
        
        {
            boolean varD51F49474299435EFAFBEB409E9FC4DF_1375679494 = (setupStreamAndSendStatus());
            {
                mData = new byte[8192];
                mHandler.sendEmptyMessage(MSG_HEADERS);
            } 
        } 
        
        
        sendHeaders();
        
        
        mHandler.sendEmptyMessage(MSG_DATA);
        
        
        {
            boolean var1A20D36B5DB1848297E95A16125122BA_845346007 = (sendData());
            {
                mHandler.sendEmptyMessage(MSG_END);
            } 
            {
                mHandler.sendEmptyMessage(MSG_DATA);
            } 
        } 
        
        
        closeStreamAndSendEndData();
        
        addTaint(msg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1886173606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1886173606;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.580 -0400", hash_original_method = "65A84C3A774E903513B92EB5B550F331", hash_generated_method = "567377B6B77AC4C020F73606376D2DC4")
    private void sendHeaders() {
        Headers headers = new Headers();
        {
            headers.setContentLength(mContentLength);
        } 
        buildHeaders(headers);
        mLoadListener.headers(headers);
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.580 -0400", hash_original_method = "4C4D4DF9D04A987F005277A578061144", hash_generated_method = "ED46815B202E5AD949AFA7F955E6BCC1")
    private boolean sendData() {
        {
            try 
            {
                int amount = mDataStream.read(mData);
                {
                    mLoadListener.data(mData, amount);
                } 
            } 
            catch (IOException ex)
            {
                mLoadListener.error(EventHandler.FILE_ERROR, ex.getMessage());
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_647007435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_647007435;
        
        
            
                
                
                    
                    
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.581 -0400", hash_original_method = "1E3300194DB856434710C1AC838853B7", hash_generated_method = "A24F5F05DD5CC0F492ED74118F9075A1")
    private void closeStreamAndSendEndData() {
        {
            try 
            {
                mDataStream.close();
            } 
            catch (IOException ex)
            { }
        } 
        mLoadListener.endData();
        
        
            
                
            
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.581 -0400", hash_original_field = "3B4EDCD356FF8FD8A81606390C1D31E7", hash_generated_field = "116567EA42424CED6A518F03ECAEF9D0")

    private static final int MSG_STATUS = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.581 -0400", hash_original_field = "B5CF47C9CB13830E5FEF6A561C9C73CD", hash_generated_field = "2560EAA9C0C83E19C62565F808C069B9")

    private static final int MSG_HEADERS = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.581 -0400", hash_original_field = "824252C5EBC5267DA1C9532BA0F4F003", hash_generated_field = "B7C277C22A8740A16DB4ABF4E167CE64")

    private static final int MSG_DATA = 102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.581 -0400", hash_original_field = "7B0322BAC1CD991CE8CA33B865EEC5BD", hash_generated_field = "02484FCE1BED4E8C22849757523483A9")

    private static final int MSG_END = 103;
}

