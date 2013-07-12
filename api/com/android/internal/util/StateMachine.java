package com.android.internal.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class StateMachine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.856 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.856 -0400", hash_original_field = "33B36581F13AC889824230814044F92D", hash_generated_field = "8DC42536419669DDCF0A80F5D8F0EF49")

    private SmHandler mSmHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.856 -0400", hash_original_field = "1B2530384BA7DBB381B8FEDB305B67DE", hash_generated_field = "60795A86AEB0DA28C5A6A37DF9379911")

    private HandlerThread mSmThread;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.856 -0400", hash_original_method = "965279A1412D73A89A7122845884F290", hash_generated_method = "7AB2C0F0E68385CFE81E906CE1E3C278")
    protected  StateMachine(String name) {
        mSmThread = new HandlerThread(name);
        mSmThread.start();
        Looper looper = mSmThread.getLooper();
        initStateMachine(name, looper);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.857 -0400", hash_original_method = "8270C3E9AEADC5B23E7F677870CDA596", hash_generated_method = "657AC64255CCD87AEFD82CB18DED1BDB")
    protected  StateMachine(String name, Looper looper) {
        addTaint(looper.getTaint());
        addTaint(name.getTaint());
        initStateMachine(name, looper);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.857 -0400", hash_original_method = "DAD3CAAA263F09CC114EE283728F2037", hash_generated_method = "D21F8B22AE9EC63CB714D28752378E7F")
    private void initStateMachine(String name, Looper looper) {
        mName = name;
        mSmHandler = new SmHandler(looper, this);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.857 -0400", hash_original_method = "9CB95CDEC2272D9103D9B302315B1CF0", hash_generated_method = "28C464863B68A47A8290CD9118E579CE")
    protected final void addState(State state, State parent) {
        addTaint(parent.getTaint());
        addTaint(state.getTaint());
        mSmHandler.addState(state, parent);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.858 -0400", hash_original_method = "E9B863EE3D8BE2542840411248513D5A", hash_generated_method = "8CBA12A950ED79A6BE3D1C5ECC4F8D20")
    protected final Message getCurrentMessage() {
Message var6DE0409BA77556124F05E6E0BC457F8E_180180948 =         mSmHandler.getCurrentMessage();
        var6DE0409BA77556124F05E6E0BC457F8E_180180948.addTaint(taint);
        return var6DE0409BA77556124F05E6E0BC457F8E_180180948;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.858 -0400", hash_original_method = "D598BDB56AFF58F966F9A8594C83023E", hash_generated_method = "FE0B2FF30023A51C63B7EB26A912BEEA")
    protected final IState getCurrentState() {
IState var87CBDBACE722DFE921BE617500791021_59867699 =         mSmHandler.getCurrentState();
        var87CBDBACE722DFE921BE617500791021_59867699.addTaint(taint);
        return var87CBDBACE722DFE921BE617500791021_59867699;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.858 -0400", hash_original_method = "3FDCC93D71F6B56C0FCF47E8C68EDFCE", hash_generated_method = "3FD2A6EEF21DA200A813ECC404CB7F10")
    protected final void addState(State state) {
        addTaint(state.getTaint());
        mSmHandler.addState(state, null);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.859 -0400", hash_original_method = "FA85C85D6842E1150C141EC2987FEC52", hash_generated_method = "FEB1F31790862389A097AD3C12B54838")
    protected final void setInitialState(State initialState) {
        addTaint(initialState.getTaint());
        mSmHandler.setInitialState(initialState);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.859 -0400", hash_original_method = "DDAEED1DEC80DD4893B8BEC6C1C4D0F1", hash_generated_method = "711D230171DDF91ED7B7EDFEB0D5F6C7")
    protected final void transitionTo(IState destState) {
        addTaint(destState.getTaint());
        mSmHandler.transitionTo(destState);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.859 -0400", hash_original_method = "42225DFCDD57D6590F4D09D0862811E2", hash_generated_method = "3678DC5016DC80DE1E1F3AFEA8AEDDF7")
    protected final void transitionToHaltingState() {
        mSmHandler.transitionTo(mSmHandler.mHaltingState);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.860 -0400", hash_original_method = "261AEA0DB1968E370C4ADDBA675B5E74", hash_generated_method = "70C9356D9A186BCD800D2ACD1DD51EFF")
    protected final void deferMessage(Message msg) {
        addTaint(msg.getTaint());
        mSmHandler.deferMessage(msg);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.860 -0400", hash_original_method = "7997D0B28C80AB12F09EF0050700F72A", hash_generated_method = "6E0C7C7910BA808735B2117E4BCA1D82")
    protected void unhandledMessage(Message msg) {
        addTaint(msg.getTaint());
    if(mSmHandler.mDbg){ }
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.860 -0400", hash_original_method = "056AA616A824F08818D1B78343E1C249", hash_generated_method = "426AFD9B07DC3D2547D5ACCC0F320026")
    protected void haltedProcessMessage(Message msg) {
        addTaint(msg.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.860 -0400", hash_original_method = "4C387498336ED4C08F04A3A81289F626", hash_generated_method = "EA73277B96710E0F4513520F578025C0")
    protected void halting() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.860 -0400", hash_original_method = "B35375ECAB57B816953617EBE5B4DD2F", hash_generated_method = "5DFECD953D2CD9C7B3894A937D26E233")
    protected void quitting() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.861 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "EF6E448ABF5CBA7A4AFA5A3D8ACB5BD9")
    public final String getName() {
String varDBF15A5FB8102A5C28D5046A0E92E443_1444076153 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_1444076153.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_1444076153;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.861 -0400", hash_original_method = "3B515C020FBA4525296124D17148DAD9", hash_generated_method = "E03F008F517FBF2524CA8F255AF655E0")
    public final void setProcessedMessagesSize(int maxSize) {
        addTaint(maxSize);
        mSmHandler.setProcessedMessagesSize(maxSize);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.861 -0400", hash_original_method = "9A0BF952A27C97CD544B7334CD0A8AD7", hash_generated_method = "3AD047E671900609101BE8752DCF2F26")
    public final int getProcessedMessagesSize() {
        int var8BCCDD9953FBD41F6D8FC231FB6F5038_578196633 = (mSmHandler.getProcessedMessagesSize());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463555863 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463555863;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.861 -0400", hash_original_method = "7E321218401071A5914E48165DB351C0", hash_generated_method = "6AC36B020A05BCE8B266BFA822678D72")
    public final int getProcessedMessagesCount() {
        int varF1FA28E3C322E743A3DBEB8A452115DD_1379239096 = (mSmHandler.getProcessedMessagesCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_700392778 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_700392778;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.862 -0400", hash_original_method = "C801EF2BEB9E095EF75CD2E078DF8F4D", hash_generated_method = "A9230FCA59AEA81FA936B0F7059A8743")
    public final ProcessedMessageInfo getProcessedMessageInfo(int index) {
        addTaint(index);
ProcessedMessageInfo var44CDF072D7CE0466224321FD71491D60_2041961990 =         mSmHandler.getProcessedMessageInfo(index);
        var44CDF072D7CE0466224321FD71491D60_2041961990.addTaint(taint);
        return var44CDF072D7CE0466224321FD71491D60_2041961990;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.862 -0400", hash_original_method = "467C85CDF2FD06F7E6D6E1A3F89DC6AE", hash_generated_method = "DD717FBE4A3422B9B4F41B928A2A5B56")
    public final Handler getHandler() {
Handler varC9ABC94E33FEDFB77929294DE04E290E_327646278 =         mSmHandler;
        varC9ABC94E33FEDFB77929294DE04E290E_327646278.addTaint(taint);
        return varC9ABC94E33FEDFB77929294DE04E290E_327646278;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.862 -0400", hash_original_method = "ECC92B44317075FA349076F0B0608CC3", hash_generated_method = "FF43669FBB99A5F49A319175EB4608A8")
    public final Message obtainMessage() {
    if(mSmHandler == null)        
        {
Message var540C13E9E156B687226421B24F2DF178_1201974451 =         null;
        var540C13E9E156B687226421B24F2DF178_1201974451.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1201974451;
        }
Message var06A7E3174649C438755C134323CA92B3_1961550308 =         Message.obtain(mSmHandler);
        var06A7E3174649C438755C134323CA92B3_1961550308.addTaint(taint);
        return var06A7E3174649C438755C134323CA92B3_1961550308;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.862 -0400", hash_original_method = "F3ABD31C8A8A675CAB7BDC7D39B74873", hash_generated_method = "0BE551D687B29E15612EFCE35DB201DE")
    public final Message obtainMessage(int what) {
        addTaint(what);
    if(mSmHandler == null)        
        {
Message var540C13E9E156B687226421B24F2DF178_386005528 =         null;
        var540C13E9E156B687226421B24F2DF178_386005528.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_386005528;
        }
Message var16CEED01D33295D016A33FC638A9783D_2058412318 =         Message.obtain(mSmHandler, what);
        var16CEED01D33295D016A33FC638A9783D_2058412318.addTaint(taint);
        return var16CEED01D33295D016A33FC638A9783D_2058412318;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.863 -0400", hash_original_method = "2782AA628D17C295F1631BCDEC3DEA27", hash_generated_method = "ACF3BD62A57A6D9E98B68A902F758730")
    public final Message obtainMessage(int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
    if(mSmHandler == null)        
        {
Message var540C13E9E156B687226421B24F2DF178_450957415 =         null;
        var540C13E9E156B687226421B24F2DF178_450957415.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_450957415;
        }
Message var37FBEECD1E8C45EE1E4DD5DF909ECA9B_324119310 =         Message.obtain(mSmHandler, what, obj);
        var37FBEECD1E8C45EE1E4DD5DF909ECA9B_324119310.addTaint(taint);
        return var37FBEECD1E8C45EE1E4DD5DF909ECA9B_324119310;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.863 -0400", hash_original_method = "90FE3D951CADE6238FC04DAF938292E8", hash_generated_method = "B1B2160E2B3CAC81B9431D9830997411")
    public final Message obtainMessage(int what, int arg1, int arg2) {
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
    if(mSmHandler == null)        
        {
Message var540C13E9E156B687226421B24F2DF178_1518096250 =         null;
        var540C13E9E156B687226421B24F2DF178_1518096250.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1518096250;
        }
Message varE707DD3749BB2B73281F7251B469E1CB_351064877 =         Message.obtain(mSmHandler, what, arg1, arg2);
        varE707DD3749BB2B73281F7251B469E1CB_351064877.addTaint(taint);
        return varE707DD3749BB2B73281F7251B469E1CB_351064877;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.863 -0400", hash_original_method = "9FA101C66AEE3272C97FB43923C2AC9F", hash_generated_method = "240EF3BB4B28C9A5D5197677C01A4D54")
    public final Message obtainMessage(int what, int arg1, int arg2, Object obj) {
        addTaint(obj.getTaint());
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
    if(mSmHandler == null)        
        {
Message var540C13E9E156B687226421B24F2DF178_2110845790 =         null;
        var540C13E9E156B687226421B24F2DF178_2110845790.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2110845790;
        }
Message var380DE8A7980E1DC17463DA27538AA69B_178099595 =         Message.obtain(mSmHandler, what, arg1, arg2, obj);
        var380DE8A7980E1DC17463DA27538AA69B_178099595.addTaint(taint);
        return var380DE8A7980E1DC17463DA27538AA69B_178099595;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.864 -0400", hash_original_method = "4C17D9C303E0C63CA9FC8056DA52EF3D", hash_generated_method = "29483A89F093DB59CE6C077660DF4922")
    public final void sendMessage(int what) {
        addTaint(what);
    if(mSmHandler == null)        
        return;
        mSmHandler.sendMessage(obtainMessage(what));
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.864 -0400", hash_original_method = "FBA6CF7C9F3F790F28B53AD9439353BD", hash_generated_method = "8EE41092DBE3DC79F08BCDBCD6BBCB07")
    public final void sendMessage(int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
    if(mSmHandler == null)        
        return;
        mSmHandler.sendMessage(obtainMessage(what,obj));
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.864 -0400", hash_original_method = "6E13019DC70D12278C5C1075A86F8BFE", hash_generated_method = "C5DE0645448A9DF6C41A503898E272C3")
    public final void sendMessage(Message msg) {
        addTaint(msg.getTaint());
    if(mSmHandler == null)        
        return;
        mSmHandler.sendMessage(msg);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.865 -0400", hash_original_method = "6F45F99BF67AD2AF5583C8727970AA91", hash_generated_method = "4CEE9827394182123A2BB3A5E06BBBE6")
    public final void sendMessageDelayed(int what, long delayMillis) {
        addTaint(delayMillis);
        addTaint(what);
    if(mSmHandler == null)        
        return;
        mSmHandler.sendMessageDelayed(obtainMessage(what), delayMillis);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.865 -0400", hash_original_method = "39A6E49D71A514B448DAD14BF952A265", hash_generated_method = "829C9E9B91D763148DC880C11046F801")
    public final void sendMessageDelayed(int what, Object obj, long delayMillis) {
        addTaint(delayMillis);
        addTaint(obj.getTaint());
        addTaint(what);
    if(mSmHandler == null)        
        return;
        mSmHandler.sendMessageDelayed(obtainMessage(what, obj), delayMillis);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.865 -0400", hash_original_method = "9D9110C540430F2A7712B1C42CF073E5", hash_generated_method = "A56E52EECFFFD7BBA5A46CEE731FEFAF")
    public final void sendMessageDelayed(Message msg, long delayMillis) {
        addTaint(delayMillis);
        addTaint(msg.getTaint());
    if(mSmHandler == null)        
        return;
        mSmHandler.sendMessageDelayed(msg, delayMillis);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.866 -0400", hash_original_method = "687B3882728A203A122F07AED4E62B4F", hash_generated_method = "B0C95F135629785B31F7C973C0934E98")
    protected final void sendMessageAtFrontOfQueue(int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(what, obj));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.866 -0400", hash_original_method = "57A82123C5C1A73035060A1546C23399", hash_generated_method = "F6DA3F700FB5878A96C1B3F58492A1A3")
    protected final void sendMessageAtFrontOfQueue(int what) {
        addTaint(what);
        mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(what));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.866 -0400", hash_original_method = "DAD8B3BB967F6D568CBDEF14E7D7FC31", hash_generated_method = "B650D5A4FCA8F30EBA56384C7BC0A408")
    protected final void sendMessageAtFrontOfQueue(Message msg) {
        addTaint(msg.getTaint());
        mSmHandler.sendMessageAtFrontOfQueue(msg);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.866 -0400", hash_original_method = "58582EEB8BE4D233D0E7915A49A3AF70", hash_generated_method = "C3AAD85778ACC9DC2267D786741017D7")
    protected final void removeMessages(int what) {
        addTaint(what);
        mSmHandler.removeMessages(what);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.867 -0400", hash_original_method = "13321C8CCD65EA0BFC64015C162CADFF", hash_generated_method = "92DC48A8CCCD43C142F255595B606241")
    public final void quit() {
    if(mSmHandler == null)        
        return;
        mSmHandler.quit();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.867 -0400", hash_original_method = "E5B9CF023676BDCA212E1B122FA8A525", hash_generated_method = "A016B411D3E16CC7CD8E59DCD4014B96")
    protected final boolean isQuit(Message msg) {
        addTaint(msg.getTaint());
        boolean var1C7A2292FAB5CF4349EF5084A8BC9A89_805475507 = (mSmHandler.isQuit(msg));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_272587517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_272587517;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.868 -0400", hash_original_method = "60458C30D1CF7065D8253B7B3CE713BC", hash_generated_method = "3179CC82C11DCD8DE1CD4B93DC88941D")
    public boolean isDbg() {
    if(mSmHandler == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_502583260 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_238805032 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_238805032;
        }
        boolean varCB2AF79DB8338DE4E75BDCC6E63D8D8F_1069899330 = (mSmHandler.isDbg());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1682111847 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1682111847;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.868 -0400", hash_original_method = "DD47B988861B3BEC7B551FD48507E8F0", hash_generated_method = "394243B40C1F736F8DF7F228BD8DF2C8")
    public void setDbg(boolean dbg) {
        addTaint(dbg);
    if(mSmHandler == null)        
        return;
        mSmHandler.setDbg(dbg);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.869 -0400", hash_original_method = "25624AE7DCD0D0ACD27C83DB1C9CEB1E", hash_generated_method = "5773164C4A72B7C2F871BBCCC0879ED4")
    public void start() {
    if(mSmHandler == null)        
        return;
        mSmHandler.completeConstruction();
        
        
        
    }

    
    public static class ProcessedMessageInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.869 -0400", hash_original_field = "4A2028ECEAC5E1F4D252EA13C71ECEC6", hash_generated_field = "A000BD07D4DBA654B5ACE4EC76BBFFA1")

        private int what;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.869 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "1BABB00C62C02094F906A511C44D4ACB")

        private State state;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.869 -0400", hash_original_field = "84B886956AD7EF0B14B59F53A6811BE6", hash_generated_field = "31B05008E27000A3E17D4629DFC22D7C")

        private State orgState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.870 -0400", hash_original_method = "7EA9EE86A36AF0562D3C01EEF98869EA", hash_generated_method = "F12143007D932EA9BB1E0A7FBFA5EDEF")
          ProcessedMessageInfo(Message message, State state, State orgState) {
            addTaint(orgState.getTaint());
            addTaint(state.getTaint());
            addTaint(message.getTaint());
            update(message, state, orgState);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.870 -0400", hash_original_method = "AE92957E52CD2ECF48167D0FF23A4162", hash_generated_method = "A47569B5D257EE43083BE43CD751A5F9")
        public void update(Message message, State state, State orgState) {
            this.what = message.what;
            this.state = state;
            this.orgState = orgState;
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.871 -0400", hash_original_method = "4AA8DBE0617D26A2E34EC5BDBA364E43", hash_generated_method = "1047ECBE2C5527322512F8D9D6A013D2")
        public int getWhat() {
            int var4A2028ECEAC5E1F4D252EA13C71ECEC6_299442039 = (what);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166144692 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166144692;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.871 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "0E1A36266A07C90DE713152CD960F2EA")
        public State getState() {
State var37C56C9D63C623261861C16DCFB73F6D_1798438730 =             state;
            var37C56C9D63C623261861C16DCFB73F6D_1798438730.addTaint(taint);
            return var37C56C9D63C623261861C16DCFB73F6D_1798438730;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.871 -0400", hash_original_method = "6453845FB279EEE2A3A97B4923853CA9", hash_generated_method = "6A22A00A31E058581FF0B7435FD28D4E")
        public State getOriginalState() {
State var5D1739645EB8BD1974676CD7C05290CF_1840041913 =             orgState;
            var5D1739645EB8BD1974676CD7C05290CF_1840041913.addTaint(taint);
            return var5D1739645EB8BD1974676CD7C05290CF_1840041913;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.872 -0400", hash_original_method = "1BEC9C7E840A94CA1F6D8F0CAE4CCE3D", hash_generated_method = "47CBC371654CBC07D0F31CC5B6E13CD5")
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("what=");
            sb.append(what);
            sb.append(" state=");
            sb.append(cn(state));
            sb.append(" orgState=");
            sb.append(cn(orgState));
String var2460B846747F8B22185AD8BE722266A5_2060391017 =             sb.toString();
            var2460B846747F8B22185AD8BE722266A5_2060391017.addTaint(taint);
            return var2460B846747F8B22185AD8BE722266A5_2060391017;
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.873 -0400", hash_original_method = "BFE06EA51077266A4C3CDDB9CF5A61E9", hash_generated_method = "050540546905F456B25BF0082E952DD4")
        private String cn(Object n) {
            addTaint(n.getTaint());
    if(n == null)            
            {
String var1D801F10795A50869C3F1F514D9B9BF5_2105671272 =                 "null";
                var1D801F10795A50869C3F1F514D9B9BF5_2105671272.addTaint(taint);
                return var1D801F10795A50869C3F1F514D9B9BF5_2105671272;
            } 
            else
            {
                String name = n.getClass().getName();
                int lastDollar = name.lastIndexOf('$');
String varD7C421C03C1A323F8F634419CD6A2301_1069625565 =                 name.substring(lastDollar + 1);
                varD7C421C03C1A323F8F634419CD6A2301_1069625565.addTaint(taint);
                return varD7C421C03C1A323F8F634419CD6A2301_1069625565;
            } 
            
            
                
            
                
                
                
            
        }

        
    }


    
    private static class ProcessedMessages {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.873 -0400", hash_original_field = "4638111749607EC0E774B56C9045C2CC", hash_generated_field = "E3B7DBE08CEF79947D2C5DA6C5D670A8")

        private Vector<ProcessedMessageInfo> mMessages = new Vector<ProcessedMessageInfo>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.873 -0400", hash_original_field = "F9CD99A937CD9E3754E933B84CFC743E", hash_generated_field = "706F44912DCFEA7F4271168A8A5FEC7F")

        private int mMaxSize = DEFAULT_SIZE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.873 -0400", hash_original_field = "F1519A9A45F068C08F9CBF2710683986", hash_generated_field = "ACB9E601905428D5F1514FA73B95CCB8")

        private int mOldestIndex = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.874 -0400", hash_original_field = "DFBC16768366A2556A52E5DCDCD8E737", hash_generated_field = "FF64F9A7A53D85DAFE355CC940E3F92D")

        private int mCount = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.874 -0400", hash_original_method = "8C2E4982B56D335A57BD25CE5A99A95E", hash_generated_method = "7FF397A4DBE391D9CE0F14D5D355725E")
          ProcessedMessages() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.874 -0400", hash_original_method = "E690879E37418633C091A0E6D09F0FE8", hash_generated_method = "216C5521964D93A1CDEE19D269CF8281")
         void setSize(int maxSize) {
            mMaxSize = maxSize;
            mCount = 0;
            mMessages.clear();
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.875 -0400", hash_original_method = "661C67FDA7F2FAF16A0B73519F701A14", hash_generated_method = "D58DC64E73BCFE2B90A5FAF1FF62563A")
         int size() {
            int var039B4D0A1D5620B03C083FD928F25731_1765611950 = (mMessages.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_736159537 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_736159537;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.875 -0400", hash_original_method = "173278F07A9E3F76B246C31AF2BEE799", hash_generated_method = "D011FE3E8063D7AC1A90A6C867584480")
         int count() {
            int var4A5FC91463CC1EF00D3AA26340B946C6_1817329110 = (mCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_704014650 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_704014650;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.875 -0400", hash_original_method = "7C55F1E05538CA172591209F0EED6056", hash_generated_method = "CFD4D7A4E005D0B113E95B968C008CBA")
         void cleanup() {
            mMessages.clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.876 -0400", hash_original_method = "9D508AC508F62C2D8A912ED09416EAAB", hash_generated_method = "D6286D857F557E90FCE65EE4581A01F9")
         ProcessedMessageInfo get(int index) {
            addTaint(index);
            int nextIndex = mOldestIndex + index;
    if(nextIndex >= mMaxSize)            
            {
                nextIndex -= mMaxSize;
            } 
    if(nextIndex >= size())            
            {
ProcessedMessageInfo var540C13E9E156B687226421B24F2DF178_514373412 =                 null;
                var540C13E9E156B687226421B24F2DF178_514373412.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_514373412;
            } 
            else
            {
ProcessedMessageInfo var072772DCE9C04049724EC1E86EAAC882_1064094912 =                 mMessages.get(nextIndex);
                var072772DCE9C04049724EC1E86EAAC882_1064094912.addTaint(taint);
                return var072772DCE9C04049724EC1E86EAAC882_1064094912;
            } 
            
            
            
                
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.877 -0400", hash_original_method = "43A85B457185E158137E22B107CD3124", hash_generated_method = "04F4B19B5C2D22F30A76FC0F6AE1FFCF")
         void add(Message message, State state, State orgState) {
            addTaint(orgState.getTaint());
            addTaint(state.getTaint());
            addTaint(message.getTaint());
            mCount += 1;
    if(mMessages.size() < mMaxSize)            
            {
                mMessages.add(new ProcessedMessageInfo(message, state, orgState));
            } 
            else
            {
                ProcessedMessageInfo pmi = mMessages.get(mOldestIndex);
                mOldestIndex += 1;
    if(mOldestIndex >= mMaxSize)                
                {
                    mOldestIndex = 0;
                } 
                pmi.update(message, state, orgState);
            } 
            
            
            
                
            
                
                
                
                    
                
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.877 -0400", hash_original_field = "6536C404918AD1022187839619C3C25D", hash_generated_field = "D046EB83567C8AE65CE2B140E78656A6")

        private static final int DEFAULT_SIZE = 20;
    }


    
    private static class SmHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.877 -0400", hash_original_field = "D637A04D9B36EA9FF45230461984CC3E", hash_generated_field = "84BF5FE621A31FF82764E5E75B6B2B40")

        private boolean mDbg = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.877 -0400", hash_original_field = "C4DCF848508A3A0ABA8450C0F3B9BF3D", hash_generated_field = "54E38D66DD7526E5701FBBAD9B009DFE")

        private Message mMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.877 -0400", hash_original_field = "6DECEE3CD612ED3FBA500681A2165295", hash_generated_field = "EFAC02A563A53F74A935F29F327B6CC6")

        private ProcessedMessages mProcessedMessages = new ProcessedMessages();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.877 -0400", hash_original_field = "9E58F2395A68F920724BDD0461F83351", hash_generated_field = "AD0490DB6C87F3957759A9A5591E811D")

        private boolean mIsConstructionCompleted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.877 -0400", hash_original_field = "7B3C672F41C8401F3EC1A1CDE67AC651", hash_generated_field = "C83A631E77C81B863F638A8667284991")

        private StateInfo mStateStack[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.877 -0400", hash_original_field = "053B862326E7E28918E3D2FC4CEAEA92", hash_generated_field = "5CD90CA8F874AD9DE38AB1A114D42E12")

        private int mStateStackTopIndex = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.878 -0400", hash_original_field = "6332B1101C479BE3AA701E56ECE264D9", hash_generated_field = "195AFABD8F84AE5B999C5618E29EE0A7")

        private StateInfo mTempStateStack[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.878 -0400", hash_original_field = "99B1C74E686603EE6C6D1169C99F51C9", hash_generated_field = "D2085166BB400AAC15FE91947D0BFF38")

        private int mTempStateStackCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.878 -0400", hash_original_field = "C7F616C9E03B3B6507A06751626E6CCF", hash_generated_field = "3CD37F42E2372296C9C2572BA23C4A97")

        private HaltingState mHaltingState = new HaltingState();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.878 -0400", hash_original_field = "553AB6363F7656BDB9C5433B877F3B5F", hash_generated_field = "D53866FD4D0C4A9897E6FF6C3007B607")

        private QuittingState mQuittingState = new QuittingState();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.878 -0400", hash_original_field = "963A155DBBA15FD138C5B331DC805578", hash_generated_field = "AB776014D6CDB1ACE48E8228A4B89DB5")

        private StateMachine mSm;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.878 -0400", hash_original_field = "D6BB2A8B0FAD9BC94D3C82D9BD9B0E34", hash_generated_field = "8E6100B795A7F8D492BA2A30C1BEF10A")

        private HashMap<State, StateInfo> mStateInfo = new HashMap<State, StateInfo>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.878 -0400", hash_original_field = "770C5F39AD9B0B98C77DB76934C5017D", hash_generated_field = "E1B8064614A214E3580105C073B6BA74")

        private State mInitialState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.878 -0400", hash_original_field = "175AA0ABFBE77D0FD2DF841C574B19BF", hash_generated_field = "21253050F2EAF229CC27D2C6C469DC71")

        private State mDestState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.878 -0400", hash_original_field = "30361009376CEAADB89079D3726BC4B8", hash_generated_field = "25F851047AB015EAE2C78DF11239F59E")

        private ArrayList<Message> mDeferredMessages = new ArrayList<Message>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.878 -0400", hash_original_method = "02CDDC1E29D68D2242CCC3ED8987E93B", hash_generated_method = "66E78850F20CFBE8CC9D4FDA3AB9408C")
        private  SmHandler(Looper looper, StateMachine sm) {
            super(looper);
            addTaint(looper.getTaint());
            mSm = sm;
            addState(mHaltingState, null);
            addState(mQuittingState, null);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.879 -0400", hash_original_method = "47FB80A3CFEFEB59EA9B936E333C1DEB", hash_generated_method = "D4CCF220A12FAD51873661D5EC92E97F")
        @Override
        public final void handleMessage(Message msg) {
    if(mDbg)            
            Log.d(TAG, "handleMessage: E msg.what=" + msg.what);
            mMsg = msg;
    if(!mIsConstructionCompleted)            
            {
                return;
            } 
            processMsg(msg);
            performTransitions();
    if(mDbg)            
            Log.d(TAG, "handleMessage: X");
            
            
            
            
                
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.879 -0400", hash_original_method = "A1FA2FFB8197AA42C7B119825051565B", hash_generated_method = "D65C3CAB98BCA9E593850EB09CCF137D")
        private void performTransitions() {
            State destState = null;
            while
(mDestState != null)            
            {
    if(mDbg)                
                Log.d(TAG, "handleMessage: new destination call exit");
                destState = mDestState;
                mDestState = null;
                StateInfo commonStateInfo = setupTempStateStackWithStatesToEnter(destState);
                invokeExitMethods(commonStateInfo);
                int stateStackEnteringIndex = moveTempStateStackToStateStack();
                invokeEnterMethods(stateStackEnteringIndex);
                moveDeferredMessageAtFrontOfQueue();
            } 
    if(destState != null)            
            {
    if(destState == mQuittingState)                
                {
                    cleanupAfterQuitting();
                } 
                else
    if(destState == mHaltingState)                
                {
                    mSm.halting();
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.881 -0400", hash_original_method = "7DAEABCEDA46187D72BCFC1924088344", hash_generated_method = "089F9990EE2A00013D56201FDDD2D045")
        private final void cleanupAfterQuitting() {
            mSm.quitting();
    if(mSm.mSmThread != null)            
            {
                getLooper().quit();
                mSm.mSmThread = null;
            } 
            mSm.mSmHandler = null;
            mSm = null;
            mMsg = null;
            mProcessedMessages.cleanup();
            mStateStack = null;
            mTempStateStack = null;
            mStateInfo.clear();
            mInitialState = null;
            mDestState = null;
            mDeferredMessages.clear();
            
            
            
                
                
            
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.882 -0400", hash_original_method = "2988A35ECCAC86323C503A15399549F2", hash_generated_method = "8659F656A96E65DB961F3B4F5560B55C")
        private final void completeConstruction() {
    if(mDbg)            
            Log.d(TAG, "completeConstruction: E");
            int maxDepth = 0;
for(StateInfo si : mStateInfo.values())
            {
                int depth = 0;
for(StateInfo i = si;i != null;depth++)
                {
                    i = i.parentStateInfo;
                } 
    if(maxDepth < depth)                
                {
                    maxDepth = depth;
                } 
            } 
    if(mDbg)            
            Log.d(TAG, "completeConstruction: maxDepth=" + maxDepth);
            mStateStack = new StateInfo[maxDepth];
            mTempStateStack = new StateInfo[maxDepth];
            setupInitialStateStack();
            mIsConstructionCompleted = true;
            mMsg = obtainMessage(SM_INIT_CMD);
            invokeEnterMethods(0);
            performTransitions();
    if(mDbg)            
            Log.d(TAG, "completeConstruction: X");
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.882 -0400", hash_original_method = "01E4D9F834B911866303A5B2D2AF3A41", hash_generated_method = "173A3666E37BAB798D007485C9DF2EF4")
        private final void processMsg(Message msg) {
            addTaint(msg.getTaint());
            StateInfo curStateInfo = mStateStack[mStateStackTopIndex];
    if(mDbg)            
            {
                Log.d(TAG, "processMsg: " + curStateInfo.state.getName());
            } 
            while
(!curStateInfo.state.processMessage(msg))            
            {
                curStateInfo = curStateInfo.parentStateInfo;
    if(curStateInfo == null)                
                {
                    mSm.unhandledMessage(msg);
    if(isQuit(msg))                    
                    {
                        transitionTo(mQuittingState);
                    } 
                    break;
                } 
    if(mDbg)                
                {
                    Log.d(TAG, "processMsg: " + curStateInfo.state.getName());
                } 
            } 
    if(curStateInfo != null)            
            {
                State orgState = mStateStack[mStateStackTopIndex].state;
                mProcessedMessages.add(msg, curStateInfo.state, orgState);
            } 
            else
            {
                mProcessedMessages.add(msg, null, null);
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.883 -0400", hash_original_method = "DE2778671ED61CA7054BB4798B489854", hash_generated_method = "5F1111616B44AD4EB11EF7FB881EBECF")
        private final void invokeExitMethods(StateInfo commonStateInfo) {
            addTaint(commonStateInfo.getTaint());
            while
((mStateStackTopIndex >= 0) &&
                    (mStateStack[mStateStackTopIndex] != commonStateInfo))            
            {
                State curState = mStateStack[mStateStackTopIndex].state;
    if(mDbg)                
                Log.d(TAG, "invokeExitMethods: " + curState.getName());
                curState.exit();
                mStateStack[mStateStackTopIndex].active = false;
                mStateStackTopIndex -= 1;
            } 
            
            
                    
                
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.884 -0400", hash_original_method = "BBB0EEA794A5EB08AF57745D59E4ED21", hash_generated_method = "C6BEA9A488DA87E7B40F480965D20A82")
        private final void invokeEnterMethods(int stateStackEnteringIndex) {
            addTaint(stateStackEnteringIndex);
for(int i = stateStackEnteringIndex;i <= mStateStackTopIndex;i++)
            {
    if(mDbg)                
                Log.d(TAG, "invokeEnterMethods: " + mStateStack[i].state.getName());
                mStateStack[i].state.enter();
                mStateStack[i].active = true;
            } 
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.884 -0400", hash_original_method = "C63EF04ECCAE1AA00B9666D00D691AB5", hash_generated_method = "B80AB34A58C712450E65B6193766B2E5")
        private final void moveDeferredMessageAtFrontOfQueue() {
for(int i = mDeferredMessages.size() - 1;i >= 0;i--)
            {
                Message curMsg = mDeferredMessages.get(i);
    if(mDbg)                
                Log.d(TAG, "moveDeferredMessageAtFrontOfQueue; what=" + curMsg.what);
                sendMessageAtFrontOfQueue(curMsg);
            } 
            mDeferredMessages.clear();
            
            
                
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.885 -0400", hash_original_method = "22489CF328AA5B68E3D4CD4685E1B0FF", hash_generated_method = "C444A9F9BE981E42675AF67F329D6E4E")
        private final int moveTempStateStackToStateStack() {
            int startingIndex = mStateStackTopIndex + 1;
            int i = mTempStateStackCount - 1;
            int j = startingIndex;
            while
(i >= 0)            
            {
    if(mDbg)                
                Log.d(TAG, "moveTempStackToStateStack: i=" + i + ",j=" + j);
                mStateStack[j] = mTempStateStack[i];
                j += 1;
                i -= 1;
            } 
            mStateStackTopIndex = j - 1;
    if(mDbg)            
            {
                Log.d(TAG, "moveTempStackToStateStack: X mStateStackTop="
                      + mStateStackTopIndex + ",startingIndex=" + startingIndex
                      + ",Top=" + mStateStack[mStateStackTopIndex].state.getName());
            } 
            int var89B480734F8AB26B90977B94ABABE047_1469609822 = (startingIndex);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080631494 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080631494;
            
            
            
            
            
                
                
                
                
            
            
            
                
                      
                      
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.886 -0400", hash_original_method = "47EF66F8DA6A53298BD1106F4D1229BB", hash_generated_method = "1D57ED62384260443B0BA11D59716B83")
        private final StateInfo setupTempStateStackWithStatesToEnter(State destState) {
            addTaint(destState.getTaint());
            mTempStateStackCount = 0;
            StateInfo curStateInfo = mStateInfo.get(destState);
            do {
                {
                    mTempStateStack[mTempStateStackCount++] = curStateInfo;
                    curStateInfo = curStateInfo.parentStateInfo;
                } 
} while ((curStateInfo != null) && !curStateInfo.active);
    if(mDbg)            
            {
                Log.d(TAG, "setupTempStateStackWithStatesToEnter: X mTempStateStackCount="
                      + mTempStateStackCount + ",curStateInfo: " + curStateInfo);
            } 
StateInfo varF9D24DCC789A52B9C9D285EA13580196_476129136 =             curStateInfo;
            varF9D24DCC789A52B9C9D285EA13580196_476129136.addTaint(taint);
            return varF9D24DCC789A52B9C9D285EA13580196_476129136;
            
            
            
            
                
                
            
            
                
                      
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.886 -0400", hash_original_method = "1F517A6C2C8B64C63155F67495EF1EF9", hash_generated_method = "6087CA622AF116863FBCBABA240C9B4A")
        private final void setupInitialStateStack() {
    if(mDbg)            
            {
                Log.d(TAG, "setupInitialStateStack: E mInitialState="
                    + mInitialState.getName());
            } 
            StateInfo curStateInfo = mStateInfo.get(mInitialState);
for(mTempStateStackCount = 0;curStateInfo != null;mTempStateStackCount++)
            {
                mTempStateStack[mTempStateStackCount] = curStateInfo;
                curStateInfo = curStateInfo.parentStateInfo;
            } 
            mStateStackTopIndex = -1;
            moveTempStateStackToStateStack();
            
            
                
                    
            
            
            
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.886 -0400", hash_original_method = "38EC5F2FF9273B7F113CC175A6D6CA55", hash_generated_method = "5FA4A66FA81AA1BB65719BA16522BFE2")
        private final Message getCurrentMessage() {
Message var16D531DD5AE27AEEC0FC02A6E57F1F79_2115402433 =             mMsg;
            var16D531DD5AE27AEEC0FC02A6E57F1F79_2115402433.addTaint(taint);
            return var16D531DD5AE27AEEC0FC02A6E57F1F79_2115402433;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.886 -0400", hash_original_method = "4DAC448F0AE857FB37AA7C8477011F21", hash_generated_method = "C4FA85FDC41B2E0D506FEAC014004CCA")
        private final IState getCurrentState() {
IState var8C274D350550CFAE87368DDD6F6EB59C_1605864763 =             mStateStack[mStateStackTopIndex].state;
            var8C274D350550CFAE87368DDD6F6EB59C_1605864763.addTaint(taint);
            return var8C274D350550CFAE87368DDD6F6EB59C_1605864763;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.887 -0400", hash_original_method = "D4FAF1FE6F5065E5FE32CF44151438D5", hash_generated_method = "F33903FB656BA3EAEC7D8A1524731094")
        private final StateInfo addState(State state, State parent) {
            addTaint(parent.getTaint());
            addTaint(state.getTaint());
    if(mDbg)            
            {
                Log.d(TAG, "addStateInternal: E state=" + state.getName()
                        + ",parent=" + ((parent == null) ? "" : parent.getName()));
            } 
            StateInfo parentStateInfo = null;
    if(parent != null)            
            {
                parentStateInfo = mStateInfo.get(parent);
    if(parentStateInfo == null)                
                {
                    parentStateInfo = addState(parent, null);
                } 
            } 
            StateInfo stateInfo = mStateInfo.get(state);
    if(stateInfo == null)            
            {
                stateInfo = new StateInfo();
                mStateInfo.put(state, stateInfo);
            } 
    if((stateInfo.parentStateInfo != null) &&
                    (stateInfo.parentStateInfo != parentStateInfo))            
            {
                RuntimeException var1CABAB0B836FD33F4D03408BA113F0A7_2005878476 = new RuntimeException("state already added");
                var1CABAB0B836FD33F4D03408BA113F0A7_2005878476.addTaint(taint);
                throw var1CABAB0B836FD33F4D03408BA113F0A7_2005878476;
            } 
            stateInfo.state = state;
            stateInfo.parentStateInfo = parentStateInfo;
            stateInfo.active = false;
    if(mDbg)            
            Log.d(TAG, "addStateInternal: X stateInfo: " + stateInfo);
StateInfo varED7F07AFDD82F6543D2737963BD5E70F_648918498 =             stateInfo;
            varED7F07AFDD82F6543D2737963BD5E70F_648918498.addTaint(taint);
            return varED7F07AFDD82F6543D2737963BD5E70F_648918498;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.887 -0400", hash_original_method = "6BCC70723A0A0266DFEF3F6F9EAE3DFA", hash_generated_method = "9B09B3E23227406D1A8D30314AD74D28")
        private final void setInitialState(State initialState) {
    if(mDbg)            
            Log.d(TAG, "setInitialState: initialState" + initialState.getName());
            mInitialState = initialState;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.887 -0400", hash_original_method = "21890E800BC5188E239893B522387EDA", hash_generated_method = "9E57AAF3703EA8D274842918749EE14A")
        private final void transitionTo(IState destState) {
            mDestState = (State) destState;
    if(mDbg)            
            Log.d(TAG, "StateMachine.transitionTo EX destState" + mDestState.getName());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.887 -0400", hash_original_method = "E228351895B227260722E6D77267BEC1", hash_generated_method = "C59AEE105888DB8BF16CD08AD40159D6")
        private final void deferMessage(Message msg) {
            addTaint(msg.getTaint());
    if(mDbg)            
            Log.d(TAG, "deferMessage: msg=" + msg.what);
            Message newMsg = obtainMessage();
            newMsg.copyFrom(msg);
            mDeferredMessages.add(newMsg);
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.888 -0400", hash_original_method = "70D38ABCE91561514ACD98C85375A9A1", hash_generated_method = "CFC09CB0AF7B893036B43E92312F511B")
        private final void quit() {
    if(mDbg)            
            Log.d(TAG, "quit:");
            sendMessage(obtainMessage(SM_QUIT_CMD, mQuitObj));
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.888 -0400", hash_original_method = "BAB49FBE24A81490A5F317754A03EEE6", hash_generated_method = "AB51B7A11A9F6B3055441B2E5A5CAAEB")
        private final boolean isQuit(Message msg) {
            addTaint(msg.getTaint());
            boolean varC2CAF77CD88F5CF1CF9DF0E5860594BA_541714891 = ((msg.what == SM_QUIT_CMD) && (msg.obj == mQuitObj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1856570496 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1856570496;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.888 -0400", hash_original_method = "0EC17970A8F6815D37F02ED3B599FE78", hash_generated_method = "C19C240E240DEA08A8708E1A69092B6A")
        private final boolean isDbg() {
            boolean var44ACAC101472BE8FC80671CD461C5D61_1131294731 = (mDbg);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1626859858 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1626859858;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.888 -0400", hash_original_method = "2FBE0CE6F45608217065DCE46294BFD1", hash_generated_method = "BA70DD150B20B15D1FA853B35448103D")
        private final void setDbg(boolean dbg) {
            mDbg = dbg;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.888 -0400", hash_original_method = "80DE9CB8772B169AC72245D032E86B1D", hash_generated_method = "71C31C18791B5F2381D4BFC9A3E8DFBC")
        private final void setProcessedMessagesSize(int maxSize) {
            addTaint(maxSize);
            mProcessedMessages.setSize(maxSize);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.888 -0400", hash_original_method = "8FB0F44FDB0C5DC10452484BB601B3E7", hash_generated_method = "3EC650E063C5615B0F959C4E18B0B77E")
        private final int getProcessedMessagesSize() {
            int varCEB86E61170E1C9D4ABBC0D63D171917_725819449 = (mProcessedMessages.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2116610544 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2116610544;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.888 -0400", hash_original_method = "92EED68DA49DE907A6704035F6436DD3", hash_generated_method = "363B0E93AC6D4DC5CF623A35F5DD5F71")
        private final int getProcessedMessagesCount() {
            int var627416CD9801515D97ACFAAB1D0F5F10_1108097157 = (mProcessedMessages.count());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509988779 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509988779;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.888 -0400", hash_original_method = "1E4BC1F21BF61852DF075DACE8E37071", hash_generated_method = "8E795C7184D39EE09A1B39D37828B798")
        private final ProcessedMessageInfo getProcessedMessageInfo(int index) {
            addTaint(index);
ProcessedMessageInfo var6B272BD4F7E73A4D9CDD2556381DC146_43487030 =             mProcessedMessages.get(index);
            var6B272BD4F7E73A4D9CDD2556381DC146_43487030.addTaint(taint);
            return var6B272BD4F7E73A4D9CDD2556381DC146_43487030;
            
            
        }

        
        private class StateInfo {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.888 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "05D925C5BEC5275A59607FB5FAF72E84")

            State state;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.889 -0400", hash_original_field = "77CCEFFC07D942944F4F5BD610E55EA5", hash_generated_field = "306C0C906AA6DAA2CF8E599E0B8563F9")

            StateInfo parentStateInfo;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.889 -0400", hash_original_field = "C76A5E84E4BDEE527E274EA30C680D79", hash_generated_field = "51A28EFFDC4123E8CF1B6051031E7683")

            boolean active;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.889 -0400", hash_original_method = "87ADFE3F226D3DC74DE0940453A6AE41", hash_generated_method = "87ADFE3F226D3DC74DE0940453A6AE41")
            public StateInfo ()
            {
                
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.889 -0400", hash_original_method = "ABB8BC4D82891CF5369714A62A1A931C", hash_generated_method = "A84590B735660F2BD793E4047A2B2666")
            @Override
            public String toString() {
String varF3AE67A4E259FEAC858FD24410EF34B4_1848812144 =                 "state=" + state.getName() + ",active=" + active
                        + ",parent=" + ((parentStateInfo == null) ?
                                        "null" : parentStateInfo.state.getName());
                varF3AE67A4E259FEAC858FD24410EF34B4_1848812144.addTaint(taint);
                return varF3AE67A4E259FEAC858FD24410EF34B4_1848812144;
                
                
                        
                                        
            }

            
        }


        
        private class HaltingState extends State {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.889 -0400", hash_original_method = "F9537758E4D6CCA48E760EA40D22DF18", hash_generated_method = "F9537758E4D6CCA48E760EA40D22DF18")
            public HaltingState ()
            {
                
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.889 -0400", hash_original_method = "58076C952A23C34E44D31450392EEB12", hash_generated_method = "B7073C03CEAFAAAF61750E2EA30388AE")
            @Override
            public boolean processMessage(Message msg) {
                addTaint(msg.getTaint());
                mSm.haltedProcessMessage(msg);
                boolean varB326B5062B2F0E69046810717534CB09_1745069989 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_685336663 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_685336663;
                
                
                
            }

            
        }


        
        private class QuittingState extends State {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.889 -0400", hash_original_method = "769C07BAAE1E710E9D1020720F6EA4CE", hash_generated_method = "769C07BAAE1E710E9D1020720F6EA4CE")
            public QuittingState ()
            {
                
            }


            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.889 -0400", hash_original_method = "5D2BC087464A61E35A06899EEE03AD06", hash_generated_method = "F2FD022A8F390B987ADEDFFF2F418ACB")
            @Override
            public boolean processMessage(Message msg) {
                addTaint(msg.getTaint());
                boolean var0B9AB98DCA1A5B86ADDE2EAF09C95AEA_1683261177 = (NOT_HANDLED);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1691167187 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1691167187;
                
                
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.889 -0400", hash_original_field = "DC15EA213BD47E4BE39D710E17DFF4B6", hash_generated_field = "79B0F5D3D1C26EC177F0047971DE5AB2")

        private static final Object mQuitObj = new Object();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.900 -0400", hash_original_field = "537F1DDA7538F7A72494749C0F12F704", hash_generated_field = "CAD0D1AF78117508D5FE12695CB44B34")

    private static final String TAG = "StateMachine";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.901 -0400", hash_original_field = "15B717F550BED77CE69C04E1242173FB", hash_generated_field = "2DF10E3674476E7DE2945B0A711F8281")

    public static final int SM_QUIT_CMD = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.901 -0400", hash_original_field = "3522E5C9D1D8629B086D6AC8350A3C6A", hash_generated_field = "F4722196E019D2E6C260778CB0A7C91A")

    public static final int SM_INIT_CMD = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.901 -0400", hash_original_field = "5552FF5042034D9C12191D70306B2B80", hash_generated_field = "C37530D81C60F59480493B32E2235094")

    public static final boolean HANDLED = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.901 -0400", hash_original_field = "00334D351D3DBCEA247880E929510ECD", hash_generated_field = "A7A249A527FCD19FBF4EEC3A15F4F044")

    public static final boolean NOT_HANDLED = false;
}

