package com.android.internal.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class StateMachine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.881 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.882 -0400", hash_original_field = "33B36581F13AC889824230814044F92D", hash_generated_field = "8DC42536419669DDCF0A80F5D8F0EF49")

    private SmHandler mSmHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.882 -0400", hash_original_field = "1B2530384BA7DBB381B8FEDB305B67DE", hash_generated_field = "60795A86AEB0DA28C5A6A37DF9379911")

    private HandlerThread mSmThread;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.882 -0400", hash_original_method = "965279A1412D73A89A7122845884F290", hash_generated_method = "7AB2C0F0E68385CFE81E906CE1E3C278")
    protected  StateMachine(String name) {
        mSmThread = new HandlerThread(name);
        mSmThread.start();
        Looper looper = mSmThread.getLooper();
        initStateMachine(name, looper);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.882 -0400", hash_original_method = "8270C3E9AEADC5B23E7F677870CDA596", hash_generated_method = "2986D2FE1942A51EEDF18C4932C7F108")
    protected  StateMachine(String name, Looper looper) {
        initStateMachine(name, looper);
        addTaint(name.getTaint());
        addTaint(looper.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.883 -0400", hash_original_method = "DAD3CAAA263F09CC114EE283728F2037", hash_generated_method = "D21F8B22AE9EC63CB714D28752378E7F")
    private void initStateMachine(String name, Looper looper) {
        mName = name;
        mSmHandler = new SmHandler(looper, this);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.883 -0400", hash_original_method = "9CB95CDEC2272D9103D9B302315B1CF0", hash_generated_method = "9BE82B0927F1997319CC887BEEFA69B2")
    protected final void addState(State state, State parent) {
        mSmHandler.addState(state, parent);
        addTaint(state.getTaint());
        addTaint(parent.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.883 -0400", hash_original_method = "E9B863EE3D8BE2542840411248513D5A", hash_generated_method = "B8C0E37A1004F07A145B44CE120597A4")
    protected final Message getCurrentMessage() {
        Message varB4EAC82CA7396A68D541C85D26508E83_299557772 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_299557772 = mSmHandler.getCurrentMessage();
        varB4EAC82CA7396A68D541C85D26508E83_299557772.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_299557772;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.884 -0400", hash_original_method = "D598BDB56AFF58F966F9A8594C83023E", hash_generated_method = "2E3F3A5D6392DC8A2C848738770E9280")
    protected final IState getCurrentState() {
        IState varB4EAC82CA7396A68D541C85D26508E83_472001041 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_472001041 = mSmHandler.getCurrentState();
        varB4EAC82CA7396A68D541C85D26508E83_472001041.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_472001041;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.884 -0400", hash_original_method = "3FDCC93D71F6B56C0FCF47E8C68EDFCE", hash_generated_method = "14C73D83AFEB0619D17F1CE7CFE64C67")
    protected final void addState(State state) {
        mSmHandler.addState(state, null);
        addTaint(state.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.884 -0400", hash_original_method = "FA85C85D6842E1150C141EC2987FEC52", hash_generated_method = "41766A55C7FBD8962E28ADF1708ED34D")
    protected final void setInitialState(State initialState) {
        mSmHandler.setInitialState(initialState);
        addTaint(initialState.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.884 -0400", hash_original_method = "DDAEED1DEC80DD4893B8BEC6C1C4D0F1", hash_generated_method = "5F86413A0885510048986B8C275CE02A")
    protected final void transitionTo(IState destState) {
        mSmHandler.transitionTo(destState);
        addTaint(destState.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.885 -0400", hash_original_method = "42225DFCDD57D6590F4D09D0862811E2", hash_generated_method = "3678DC5016DC80DE1E1F3AFEA8AEDDF7")
    protected final void transitionToHaltingState() {
        mSmHandler.transitionTo(mSmHandler.mHaltingState);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.885 -0400", hash_original_method = "261AEA0DB1968E370C4ADDBA675B5E74", hash_generated_method = "BA32418E2393F0832EABEC41AF86964B")
    protected final void deferMessage(Message msg) {
        mSmHandler.deferMessage(msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.885 -0400", hash_original_method = "7997D0B28C80AB12F09EF0050700F72A", hash_generated_method = "427E0A845BE3FD9FE8E2D4B9B7F211E1")
    protected void unhandledMessage(Message msg) {
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.885 -0400", hash_original_method = "056AA616A824F08818D1B78343E1C249", hash_generated_method = "426AFD9B07DC3D2547D5ACCC0F320026")
    protected void haltedProcessMessage(Message msg) {
        addTaint(msg.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.885 -0400", hash_original_method = "4C387498336ED4C08F04A3A81289F626", hash_generated_method = "EA73277B96710E0F4513520F578025C0")
    protected void halting() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.886 -0400", hash_original_method = "B35375ECAB57B816953617EBE5B4DD2F", hash_generated_method = "5DFECD953D2CD9C7B3894A937D26E233")
    protected void quitting() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.886 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "E6538620B6E9FB6EBE28BC6C5D6F8549")
    public final String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1659459207 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1659459207 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_1659459207.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1659459207;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.886 -0400", hash_original_method = "3B515C020FBA4525296124D17148DAD9", hash_generated_method = "5537F4AF25E81F4E799FAFE162ED6E69")
    public final void setProcessedMessagesSize(int maxSize) {
        mSmHandler.setProcessedMessagesSize(maxSize);
        addTaint(maxSize);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.887 -0400", hash_original_method = "9A0BF952A27C97CD544B7334CD0A8AD7", hash_generated_method = "43696C1E3DF5E4CEE3184E3C18BCB756")
    public final int getProcessedMessagesSize() {
        int varADB516616D44D9188EDE23425BBA855F_469043896 = (mSmHandler.getProcessedMessagesSize());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2019323246 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2019323246;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.887 -0400", hash_original_method = "7E321218401071A5914E48165DB351C0", hash_generated_method = "BC5694652DBFB21E8DEAA9DC9156C2EF")
    public final int getProcessedMessagesCount() {
        int var8079425B963FA8795091F5002B0F237A_206591774 = (mSmHandler.getProcessedMessagesCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784434973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784434973;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.887 -0400", hash_original_method = "C801EF2BEB9E095EF75CD2E078DF8F4D", hash_generated_method = "3102AC09E977D6A6186FA765A97D028C")
    public final ProcessedMessageInfo getProcessedMessageInfo(int index) {
        ProcessedMessageInfo varB4EAC82CA7396A68D541C85D26508E83_1400414193 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1400414193 = mSmHandler.getProcessedMessageInfo(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1400414193.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1400414193;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.888 -0400", hash_original_method = "467C85CDF2FD06F7E6D6E1A3F89DC6AE", hash_generated_method = "EA2440F37FBD507A4D44805DB1C37523")
    public final Handler getHandler() {
        Handler varB4EAC82CA7396A68D541C85D26508E83_2076663705 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2076663705 = mSmHandler;
        varB4EAC82CA7396A68D541C85D26508E83_2076663705.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2076663705;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.888 -0400", hash_original_method = "ECC92B44317075FA349076F0B0608CC3", hash_generated_method = "F46CE3FB0CC0D30D1820CE85CAADEA22")
    public final Message obtainMessage() {
        Message varB4EAC82CA7396A68D541C85D26508E83_1806057272 = null; 
        Message varB4EAC82CA7396A68D541C85D26508E83_353662259 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1806057272 = null;
        varB4EAC82CA7396A68D541C85D26508E83_353662259 = Message.obtain(mSmHandler);
        Message varA7E53CE21691AB073D9660D615818899_1631398958; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1631398958 = varB4EAC82CA7396A68D541C85D26508E83_1806057272;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1631398958 = varB4EAC82CA7396A68D541C85D26508E83_353662259;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1631398958.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1631398958;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.889 -0400", hash_original_method = "F3ABD31C8A8A675CAB7BDC7D39B74873", hash_generated_method = "2775A671CA15CD02FAC281C3B5CC0CD0")
    public final Message obtainMessage(int what) {
        Message varB4EAC82CA7396A68D541C85D26508E83_215005979 = null; 
        Message varB4EAC82CA7396A68D541C85D26508E83_347535217 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_215005979 = null;
        varB4EAC82CA7396A68D541C85D26508E83_347535217 = Message.obtain(mSmHandler, what);
        addTaint(what);
        Message varA7E53CE21691AB073D9660D615818899_1177639146; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1177639146 = varB4EAC82CA7396A68D541C85D26508E83_215005979;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1177639146 = varB4EAC82CA7396A68D541C85D26508E83_347535217;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1177639146.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1177639146;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.889 -0400", hash_original_method = "2782AA628D17C295F1631BCDEC3DEA27", hash_generated_method = "803694677470D94A70B4E738977D8041")
    public final Message obtainMessage(int what, Object obj) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1865137966 = null; 
        Message varB4EAC82CA7396A68D541C85D26508E83_558297440 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1865137966 = null;
        varB4EAC82CA7396A68D541C85D26508E83_558297440 = Message.obtain(mSmHandler, what, obj);
        addTaint(what);
        addTaint(obj.getTaint());
        Message varA7E53CE21691AB073D9660D615818899_1293875778; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1293875778 = varB4EAC82CA7396A68D541C85D26508E83_1865137966;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1293875778 = varB4EAC82CA7396A68D541C85D26508E83_558297440;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1293875778.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1293875778;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.890 -0400", hash_original_method = "90FE3D951CADE6238FC04DAF938292E8", hash_generated_method = "6971C822587A3442300CA5CBB6697240")
    public final Message obtainMessage(int what, int arg1, int arg2) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1517834979 = null; 
        Message varB4EAC82CA7396A68D541C85D26508E83_1604396785 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1517834979 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1604396785 = Message.obtain(mSmHandler, what, arg1, arg2);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        Message varA7E53CE21691AB073D9660D615818899_1054021733; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1054021733 = varB4EAC82CA7396A68D541C85D26508E83_1517834979;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1054021733 = varB4EAC82CA7396A68D541C85D26508E83_1604396785;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1054021733.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1054021733;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.890 -0400", hash_original_method = "9FA101C66AEE3272C97FB43923C2AC9F", hash_generated_method = "67754618B6E93CD17AFEC8D094A163F3")
    public final Message obtainMessage(int what, int arg1, int arg2, Object obj) {
        Message varB4EAC82CA7396A68D541C85D26508E83_623837621 = null; 
        Message varB4EAC82CA7396A68D541C85D26508E83_502022316 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_623837621 = null;
        varB4EAC82CA7396A68D541C85D26508E83_502022316 = Message.obtain(mSmHandler, what, arg1, arg2, obj);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        addTaint(obj.getTaint());
        Message varA7E53CE21691AB073D9660D615818899_1708190153; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1708190153 = varB4EAC82CA7396A68D541C85D26508E83_623837621;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1708190153 = varB4EAC82CA7396A68D541C85D26508E83_502022316;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1708190153.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1708190153;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.890 -0400", hash_original_method = "4C17D9C303E0C63CA9FC8056DA52EF3D", hash_generated_method = "459FC75428C6C8E736092C7582CF85CD")
    public final void sendMessage(int what) {
        mSmHandler.sendMessage(obtainMessage(what));
        addTaint(what);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.890 -0400", hash_original_method = "FBA6CF7C9F3F790F28B53AD9439353BD", hash_generated_method = "3868BC008FF0193C809D68A682688E83")
    public final void sendMessage(int what, Object obj) {
        mSmHandler.sendMessage(obtainMessage(what,obj));
        addTaint(what);
        addTaint(obj.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.891 -0400", hash_original_method = "6E13019DC70D12278C5C1075A86F8BFE", hash_generated_method = "B2AFA5708DD70417E62940E0F11B8D11")
    public final void sendMessage(Message msg) {
        mSmHandler.sendMessage(msg);
        addTaint(msg.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.891 -0400", hash_original_method = "6F45F99BF67AD2AF5583C8727970AA91", hash_generated_method = "348A9A1668FD22F3E948432BAC1A0AD6")
    public final void sendMessageDelayed(int what, long delayMillis) {
        mSmHandler.sendMessageDelayed(obtainMessage(what), delayMillis);
        addTaint(what);
        addTaint(delayMillis);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.891 -0400", hash_original_method = "39A6E49D71A514B448DAD14BF952A265", hash_generated_method = "16F76CAB29778EF62F35E02914624A00")
    public final void sendMessageDelayed(int what, Object obj, long delayMillis) {
        mSmHandler.sendMessageDelayed(obtainMessage(what, obj), delayMillis);
        addTaint(what);
        addTaint(obj.getTaint());
        addTaint(delayMillis);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.891 -0400", hash_original_method = "9D9110C540430F2A7712B1C42CF073E5", hash_generated_method = "4DF2A132FDAF810F5C457C2766AFCF73")
    public final void sendMessageDelayed(Message msg, long delayMillis) {
        mSmHandler.sendMessageDelayed(msg, delayMillis);
        addTaint(msg.getTaint());
        addTaint(delayMillis);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.892 -0400", hash_original_method = "687B3882728A203A122F07AED4E62B4F", hash_generated_method = "2B0C7C3153DF3E13553D544F17C1C02F")
    protected final void sendMessageAtFrontOfQueue(int what, Object obj) {
        mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(what, obj));
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.892 -0400", hash_original_method = "57A82123C5C1A73035060A1546C23399", hash_generated_method = "1EA0A74137993A429B3CD48F34326A0E")
    protected final void sendMessageAtFrontOfQueue(int what) {
        mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(what));
        addTaint(what);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.892 -0400", hash_original_method = "DAD8B3BB967F6D568CBDEF14E7D7FC31", hash_generated_method = "F8669A2FFF4F83D51978BCD9ACF8AD23")
    protected final void sendMessageAtFrontOfQueue(Message msg) {
        mSmHandler.sendMessageAtFrontOfQueue(msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.892 -0400", hash_original_method = "58582EEB8BE4D233D0E7915A49A3AF70", hash_generated_method = "565BB5CD399D0EA5061ECAA0DCAED993")
    protected final void removeMessages(int what) {
        mSmHandler.removeMessages(what);
        addTaint(what);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.892 -0400", hash_original_method = "13321C8CCD65EA0BFC64015C162CADFF", hash_generated_method = "BF8AFCA18B8F8723A014C656B4331DB0")
    public final void quit() {
        mSmHandler.quit();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.893 -0400", hash_original_method = "E5B9CF023676BDCA212E1B122FA8A525", hash_generated_method = "D32DD5DFDC14138787981E40304E95BD")
    protected final boolean isQuit(Message msg) {
        boolean var2A8D6458325668C3536388AFF71BF89B_1674996127 = (mSmHandler.isQuit(msg));
        addTaint(msg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1043332295 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1043332295;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.893 -0400", hash_original_method = "60458C30D1CF7065D8253B7B3CE713BC", hash_generated_method = "F12DD5D082097CFC79DD0CC4B848FCCD")
    public boolean isDbg() {
        boolean var1D9817B269DC7C83256BA20D04F9F774_477240582 = (mSmHandler.isDbg());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116314187 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_116314187;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.893 -0400", hash_original_method = "DD47B988861B3BEC7B551FD48507E8F0", hash_generated_method = "69C7843AA4EBB38D5B3E8BC86F01C33A")
    public void setDbg(boolean dbg) {
        mSmHandler.setDbg(dbg);
        addTaint(dbg);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.893 -0400", hash_original_method = "25624AE7DCD0D0ACD27C83DB1C9CEB1E", hash_generated_method = "94BD4AC6F97EBCF1EE9DD94260E9F311")
    public void start() {
        mSmHandler.completeConstruction();
        
        
        
    }

    
    public static class ProcessedMessageInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.893 -0400", hash_original_field = "4A2028ECEAC5E1F4D252EA13C71ECEC6", hash_generated_field = "A000BD07D4DBA654B5ACE4EC76BBFFA1")

        private int what;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.893 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "1BABB00C62C02094F906A511C44D4ACB")

        private State state;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.893 -0400", hash_original_field = "84B886956AD7EF0B14B59F53A6811BE6", hash_generated_field = "31B05008E27000A3E17D4629DFC22D7C")

        private State orgState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.894 -0400", hash_original_method = "7EA9EE86A36AF0562D3C01EEF98869EA", hash_generated_method = "6E1CB995380CA64BA3A4D59822EDEEBC")
          ProcessedMessageInfo(Message message, State state, State orgState) {
            update(message, state, orgState);
            addTaint(message.getTaint());
            addTaint(state.getTaint());
            addTaint(orgState.getTaint());
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.894 -0400", hash_original_method = "AE92957E52CD2ECF48167D0FF23A4162", hash_generated_method = "A47569B5D257EE43083BE43CD751A5F9")
        public void update(Message message, State state, State orgState) {
            this.what = message.what;
            this.state = state;
            this.orgState = orgState;
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.894 -0400", hash_original_method = "4AA8DBE0617D26A2E34EC5BDBA364E43", hash_generated_method = "6F1AE8C23C4D94D44EFD13F48BE54989")
        public int getWhat() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_569309065 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_569309065;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.895 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "3F4ADE28C7113F038D248E7DB68D7E32")
        public State getState() {
            State varB4EAC82CA7396A68D541C85D26508E83_142498864 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_142498864 = state;
            varB4EAC82CA7396A68D541C85D26508E83_142498864.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_142498864;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.895 -0400", hash_original_method = "6453845FB279EEE2A3A97B4923853CA9", hash_generated_method = "9B3DF60FCD897ED6F48AB6B9ABD64928")
        public State getOriginalState() {
            State varB4EAC82CA7396A68D541C85D26508E83_459998359 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_459998359 = orgState;
            varB4EAC82CA7396A68D541C85D26508E83_459998359.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_459998359;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.896 -0400", hash_original_method = "1BEC9C7E840A94CA1F6D8F0CAE4CCE3D", hash_generated_method = "FD9A45450B2FD7C8E1E0EC8737002312")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1498372125 = null; 
            StringBuilder sb = new StringBuilder();
            sb.append("what=");
            sb.append(what);
            sb.append(" state=");
            sb.append(cn(state));
            sb.append(" orgState=");
            sb.append(cn(orgState));
            varB4EAC82CA7396A68D541C85D26508E83_1498372125 = sb.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1498372125.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1498372125;
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.897 -0400", hash_original_method = "BFE06EA51077266A4C3CDDB9CF5A61E9", hash_generated_method = "8E547D8BEB10CE607E698B06078D4FA9")
        private String cn(Object n) {
            String varB4EAC82CA7396A68D541C85D26508E83_967133516 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_574369880 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_967133516 = "null";
            } 
            {
                String name = n.getClass().getName();
                int lastDollar = name.lastIndexOf('$');
                varB4EAC82CA7396A68D541C85D26508E83_574369880 = name.substring(lastDollar + 1);
            } 
            addTaint(n.getTaint());
            String varA7E53CE21691AB073D9660D615818899_463453284; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_463453284 = varB4EAC82CA7396A68D541C85D26508E83_967133516;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_463453284 = varB4EAC82CA7396A68D541C85D26508E83_574369880;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_463453284.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_463453284;
            
            
                
            
                
                
                
            
        }

        
    }


    
    private static class ProcessedMessages {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.898 -0400", hash_original_field = "4638111749607EC0E774B56C9045C2CC", hash_generated_field = "E3B7DBE08CEF79947D2C5DA6C5D670A8")

        private Vector<ProcessedMessageInfo> mMessages = new Vector<ProcessedMessageInfo>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.898 -0400", hash_original_field = "F9CD99A937CD9E3754E933B84CFC743E", hash_generated_field = "706F44912DCFEA7F4271168A8A5FEC7F")

        private int mMaxSize = DEFAULT_SIZE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.898 -0400", hash_original_field = "F1519A9A45F068C08F9CBF2710683986", hash_generated_field = "ACB9E601905428D5F1514FA73B95CCB8")

        private int mOldestIndex = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.898 -0400", hash_original_field = "DFBC16768366A2556A52E5DCDCD8E737", hash_generated_field = "FF64F9A7A53D85DAFE355CC940E3F92D")

        private int mCount = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.898 -0400", hash_original_method = "8C2E4982B56D335A57BD25CE5A99A95E", hash_generated_method = "7FF397A4DBE391D9CE0F14D5D355725E")
          ProcessedMessages() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.899 -0400", hash_original_method = "E690879E37418633C091A0E6D09F0FE8", hash_generated_method = "216C5521964D93A1CDEE19D269CF8281")
         void setSize(int maxSize) {
            mMaxSize = maxSize;
            mCount = 0;
            mMessages.clear();
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.899 -0400", hash_original_method = "661C67FDA7F2FAF16A0B73519F701A14", hash_generated_method = "96BC5BD28DF333E5CFDBC3380F11B3D0")
         int size() {
            int var74A32522226B505A2B9E801F7AC22358_1750628382 = (mMessages.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110435414 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110435414;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.899 -0400", hash_original_method = "173278F07A9E3F76B246C31AF2BEE799", hash_generated_method = "A99F675D8D5CEAF755098293A4863537")
         int count() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1147562979 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1147562979;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.900 -0400", hash_original_method = "7C55F1E05538CA172591209F0EED6056", hash_generated_method = "CFD4D7A4E005D0B113E95B968C008CBA")
         void cleanup() {
            mMessages.clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.900 -0400", hash_original_method = "9D508AC508F62C2D8A912ED09416EAAB", hash_generated_method = "3A965D69E7FBE076E8A99DC1473A2E11")
         ProcessedMessageInfo get(int index) {
            ProcessedMessageInfo varB4EAC82CA7396A68D541C85D26508E83_731471145 = null; 
            ProcessedMessageInfo varB4EAC82CA7396A68D541C85D26508E83_926226815 = null; 
            int nextIndex = mOldestIndex + index;
            {
                nextIndex -= mMaxSize;
            } 
            {
                boolean var7A7E76C00B0E5411DCE1739E06AE8795_363658720 = (nextIndex >= size());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_731471145 = null;
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_926226815 = mMessages.get(nextIndex);
                } 
            } 
            addTaint(index);
            ProcessedMessageInfo varA7E53CE21691AB073D9660D615818899_1284486651; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1284486651 = varB4EAC82CA7396A68D541C85D26508E83_731471145;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1284486651 = varB4EAC82CA7396A68D541C85D26508E83_926226815;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1284486651.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1284486651;
            
            
            
                
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_method = "43A85B457185E158137E22B107CD3124", hash_generated_method = "221A86B92F6562B4B73033AC0542F7C7")
         void add(Message message, State state, State orgState) {
            mCount += 1;
            {
                boolean varB4226A5C9FBC4A9560CE67F9F9C6A507_139713133 = (mMessages.size() < mMaxSize);
                {
                    mMessages.add(new ProcessedMessageInfo(message, state, orgState));
                } 
                {
                    ProcessedMessageInfo pmi = mMessages.get(mOldestIndex);
                    mOldestIndex += 1;
                    {
                        mOldestIndex = 0;
                    } 
                    pmi.update(message, state, orgState);
                } 
            } 
            addTaint(message.getTaint());
            addTaint(state.getTaint());
            addTaint(orgState.getTaint());
            
            
            
                
            
                
                
                
                    
                
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "6536C404918AD1022187839619C3C25D", hash_generated_field = "D046EB83567C8AE65CE2B140E78656A6")

        private static final int DEFAULT_SIZE = 20;
    }


    
    private static class SmHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "D637A04D9B36EA9FF45230461984CC3E", hash_generated_field = "84BF5FE621A31FF82764E5E75B6B2B40")

        private boolean mDbg = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "C4DCF848508A3A0ABA8450C0F3B9BF3D", hash_generated_field = "54E38D66DD7526E5701FBBAD9B009DFE")

        private Message mMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "6DECEE3CD612ED3FBA500681A2165295", hash_generated_field = "EFAC02A563A53F74A935F29F327B6CC6")

        private ProcessedMessages mProcessedMessages = new ProcessedMessages();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "9E58F2395A68F920724BDD0461F83351", hash_generated_field = "AD0490DB6C87F3957759A9A5591E811D")

        private boolean mIsConstructionCompleted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "7B3C672F41C8401F3EC1A1CDE67AC651", hash_generated_field = "C83A631E77C81B863F638A8667284991")

        private StateInfo mStateStack[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "053B862326E7E28918E3D2FC4CEAEA92", hash_generated_field = "5CD90CA8F874AD9DE38AB1A114D42E12")

        private int mStateStackTopIndex = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "6332B1101C479BE3AA701E56ECE264D9", hash_generated_field = "195AFABD8F84AE5B999C5618E29EE0A7")

        private StateInfo mTempStateStack[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "99B1C74E686603EE6C6D1169C99F51C9", hash_generated_field = "D2085166BB400AAC15FE91947D0BFF38")

        private int mTempStateStackCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "C7F616C9E03B3B6507A06751626E6CCF", hash_generated_field = "3CD37F42E2372296C9C2572BA23C4A97")

        private HaltingState mHaltingState = new HaltingState();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "553AB6363F7656BDB9C5433B877F3B5F", hash_generated_field = "D53866FD4D0C4A9897E6FF6C3007B607")

        private QuittingState mQuittingState = new QuittingState();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "963A155DBBA15FD138C5B331DC805578", hash_generated_field = "AB776014D6CDB1ACE48E8228A4B89DB5")

        private StateMachine mSm;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "D6BB2A8B0FAD9BC94D3C82D9BD9B0E34", hash_generated_field = "8E6100B795A7F8D492BA2A30C1BEF10A")

        private HashMap<State, StateInfo> mStateInfo = new HashMap<State, StateInfo>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "770C5F39AD9B0B98C77DB76934C5017D", hash_generated_field = "E1B8064614A214E3580105C073B6BA74")

        private State mInitialState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "175AA0ABFBE77D0FD2DF841C574B19BF", hash_generated_field = "21253050F2EAF229CC27D2C6C469DC71")

        private State mDestState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.901 -0400", hash_original_field = "30361009376CEAADB89079D3726BC4B8", hash_generated_field = "25F851047AB015EAE2C78DF11239F59E")

        private ArrayList<Message> mDeferredMessages = new ArrayList<Message>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.902 -0400", hash_original_method = "02CDDC1E29D68D2242CCC3ED8987E93B", hash_generated_method = "2F925025AF1BD66D88CF249160F6A506")
        private  SmHandler(Looper looper, StateMachine sm) {
            super(looper);
            mSm = sm;
            addState(mHaltingState, null);
            addState(mQuittingState, null);
            addTaint(looper.getTaint());
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.902 -0400", hash_original_method = "47FB80A3CFEFEB59EA9B936E333C1DEB", hash_generated_method = "9183E21A1F2DB68206049BAB5E91084E")
        @Override
        public final void handleMessage(Message msg) {
            Log.d(TAG, "handleMessage: E msg.what=" + msg.what);
            mMsg = msg;
            processMsg(msg);
            performTransitions();
            Log.d(TAG, "handleMessage: X");
            
            
            
            
                
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.903 -0400", hash_original_method = "A1FA2FFB8197AA42C7B119825051565B", hash_generated_method = "200ADF8F1EB612AD1F17A9475CF8CB27")
        private void performTransitions() {
            State destState = null;
            {
                Log.d(TAG, "handleMessage: new destination call exit");
                destState = mDestState;
                mDestState = null;
                StateInfo commonStateInfo = setupTempStateStackWithStatesToEnter(destState);
                invokeExitMethods(commonStateInfo);
                int stateStackEnteringIndex = moveTempStateStackToStateStack();
                invokeEnterMethods(stateStackEnteringIndex);
                moveDeferredMessageAtFrontOfQueue();
            } 
            {
                {
                    cleanupAfterQuitting();
                } 
                {
                    mSm.halting();
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.903 -0400", hash_original_method = "7DAEABCEDA46187D72BCFC1924088344", hash_generated_method = "040A384508DAEDC24A918762F04115D6")
        private final void cleanupAfterQuitting() {
            mSm.quitting();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.910 -0400", hash_original_method = "2988A35ECCAC86323C503A15399549F2", hash_generated_method = "773B702B1F1A208C23D029CA9D916925")
        private final void completeConstruction() {
            Log.d(TAG, "completeConstruction: E");
            int maxDepth = 0;
            {
                Iterator<StateInfo> varB53D1970237922FAE4E4E15BAB1598EB_603183109 = (mStateInfo.values()).iterator();
                varB53D1970237922FAE4E4E15BAB1598EB_603183109.hasNext();
                StateInfo si = varB53D1970237922FAE4E4E15BAB1598EB_603183109.next();
                {
                    int depth = 0;
                    {
                        StateInfo i = si;
                        {
                            i = i.parentStateInfo;
                        } 
                    } 
                    {
                        maxDepth = depth;
                    } 
                } 
            } 
            Log.d(TAG, "completeConstruction: maxDepth=" + maxDepth);
            mStateStack = new StateInfo[maxDepth];
            mTempStateStack = new StateInfo[maxDepth];
            setupInitialStateStack();
            mIsConstructionCompleted = true;
            mMsg = obtainMessage(SM_INIT_CMD);
            invokeEnterMethods(0);
            performTransitions();
            Log.d(TAG, "completeConstruction: X");
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.911 -0400", hash_original_method = "01E4D9F834B911866303A5B2D2AF3A41", hash_generated_method = "427D162D5A2C204A9E1325C641615630")
        private final void processMsg(Message msg) {
            StateInfo curStateInfo = mStateStack[mStateStackTopIndex];
            {
                Log.d(TAG, "processMsg: " + curStateInfo.state.getName());
            } 
            {
                boolean var5B75882492BC3F42AA5580C4F10745A9_2064699650 = (!curStateInfo.state.processMessage(msg));
                {
                    curStateInfo = curStateInfo.parentStateInfo;
                    {
                        mSm.unhandledMessage(msg);
                        {
                            boolean var980CF6578C138F02008BF1FB10188C29_1582719391 = (isQuit(msg));
                            {
                                transitionTo(mQuittingState);
                            } 
                        } 
                    } 
                    {
                        Log.d(TAG, "processMsg: " + curStateInfo.state.getName());
                    } 
                } 
            } 
            {
                State orgState = mStateStack[mStateStackTopIndex].state;
                mProcessedMessages.add(msg, curStateInfo.state, orgState);
            } 
            {
                mProcessedMessages.add(msg, null, null);
            } 
            addTaint(msg.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.912 -0400", hash_original_method = "DE2778671ED61CA7054BB4798B489854", hash_generated_method = "6EBC72D6FEE54FD387641F0475488E66")
        private final void invokeExitMethods(StateInfo commonStateInfo) {
            {
                State curState = mStateStack[mStateStackTopIndex].state;
                Log.d(TAG, "invokeExitMethods: " + curState.getName());
                curState.exit();
                mStateStack[mStateStackTopIndex].active = false;
                mStateStackTopIndex -= 1;
            } 
            addTaint(commonStateInfo.getTaint());
            
            
                    
                
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.912 -0400", hash_original_method = "BBB0EEA794A5EB08AF57745D59E4ED21", hash_generated_method = "324C280502FA6E4FB68F44715F2570DE")
        private final void invokeEnterMethods(int stateStackEnteringIndex) {
            {
                int i = stateStackEnteringIndex;
                {
                    Log.d(TAG, "invokeEnterMethods: " + mStateStack[i].state.getName());
                    mStateStack[i].state.enter();
                    mStateStack[i].active = true;
                } 
            } 
            addTaint(stateStackEnteringIndex);
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.913 -0400", hash_original_method = "C63EF04ECCAE1AA00B9666D00D691AB5", hash_generated_method = "120EBEF5CF28033EECFCFA2BE4B1E631")
        private final void moveDeferredMessageAtFrontOfQueue() {
            {
                int i = mDeferredMessages.size() - 1;
                {
                    Message curMsg = mDeferredMessages.get(i);
                    Log.d(TAG, "moveDeferredMessageAtFrontOfQueue; what=" + curMsg.what);
                    sendMessageAtFrontOfQueue(curMsg);
                } 
            } 
            mDeferredMessages.clear();
            
            
                
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.913 -0400", hash_original_method = "22489CF328AA5B68E3D4CD4685E1B0FF", hash_generated_method = "8DB15F6D2FAB3AE9A642565252D91E74")
        private final int moveTempStateStackToStateStack() {
            int startingIndex = mStateStackTopIndex + 1;
            int i = mTempStateStackCount - 1;
            int j = startingIndex;
            {
                Log.d(TAG, "moveTempStackToStateStack: i=" + i + ",j=" + j);
                mStateStack[j] = mTempStateStack[i];
                j += 1;
                i -= 1;
            } 
            mStateStackTopIndex = j - 1;
            {
                Log.d(TAG, "moveTempStackToStateStack: X mStateStackTop="
                      + mStateStackTopIndex + ",startingIndex=" + startingIndex
                      + ",Top=" + mStateStack[mStateStackTopIndex].state.getName());
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_313964552 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_313964552;
            
            
            
            
            
                
                
                
                
            
            
            
                
                      
                      
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.914 -0400", hash_original_method = "47EF66F8DA6A53298BD1106F4D1229BB", hash_generated_method = "BBFCA1FC09D39B9BEA3A1EBB00C06D40")
        private final StateInfo setupTempStateStackWithStatesToEnter(State destState) {
            StateInfo varB4EAC82CA7396A68D541C85D26508E83_462975226 = null; 
            mTempStateStackCount = 0;
            StateInfo curStateInfo = mStateInfo.get(destState);
            {
                mTempStateStack[mTempStateStackCount++] = curStateInfo;
                curStateInfo = curStateInfo.parentStateInfo;
            } 
            {
                Log.d(TAG, "setupTempStateStackWithStatesToEnter: X mTempStateStackCount="
                      + mTempStateStackCount + ",curStateInfo: " + curStateInfo);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_462975226 = curStateInfo;
            addTaint(destState.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_462975226.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_462975226;
            
            
            
            
                
                
            
            
                
                      
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.915 -0400", hash_original_method = "1F517A6C2C8B64C63155F67495EF1EF9", hash_generated_method = "FE00B38B64B00AB62DB4DCDC95458C69")
        private final void setupInitialStateStack() {
            {
                Log.d(TAG, "setupInitialStateStack: E mInitialState="
                    + mInitialState.getName());
            } 
            StateInfo curStateInfo = mStateInfo.get(mInitialState);
            {
                mTempStateStackCount = 0;
                {
                    mTempStateStack[mTempStateStackCount] = curStateInfo;
                    curStateInfo = curStateInfo.parentStateInfo;
                } 
            } 
            mStateStackTopIndex = -1;
            moveTempStateStackToStateStack();
            
            
                
                    
            
            
            
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.916 -0400", hash_original_method = "38EC5F2FF9273B7F113CC175A6D6CA55", hash_generated_method = "49B68F066C34C253DB76A6B129C56914")
        private final Message getCurrentMessage() {
            Message varB4EAC82CA7396A68D541C85D26508E83_416088779 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_416088779 = mMsg;
            varB4EAC82CA7396A68D541C85D26508E83_416088779.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_416088779;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.917 -0400", hash_original_method = "4DAC448F0AE857FB37AA7C8477011F21", hash_generated_method = "F74BE37129F9F70B6B9AF5A3760E3D7A")
        private final IState getCurrentState() {
            IState varB4EAC82CA7396A68D541C85D26508E83_508181977 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_508181977 = mStateStack[mStateStackTopIndex].state;
            varB4EAC82CA7396A68D541C85D26508E83_508181977.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_508181977;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.919 -0400", hash_original_method = "D4FAF1FE6F5065E5FE32CF44151438D5", hash_generated_method = "D86A43418867174D49C70F0F24704D98")
        private final StateInfo addState(State state, State parent) {
            StateInfo varB4EAC82CA7396A68D541C85D26508E83_1816099211 = null; 
            {
                Log.d(TAG, "addStateInternal: E state=" + state.getName()
                        + ",parent=" + ((parent == null) ? "" : parent.getName()));
            } 
            StateInfo parentStateInfo = null;
            {
                parentStateInfo = mStateInfo.get(parent);
                {
                    parentStateInfo = addState(parent, null);
                } 
            } 
            StateInfo stateInfo = mStateInfo.get(state);
            {
                stateInfo = new StateInfo();
                mStateInfo.put(state, stateInfo);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("state already added");
            } 
            stateInfo.state = state;
            stateInfo.parentStateInfo = parentStateInfo;
            stateInfo.active = false;
            Log.d(TAG, "addStateInternal: X stateInfo: " + stateInfo);
            varB4EAC82CA7396A68D541C85D26508E83_1816099211 = stateInfo;
            addTaint(state.getTaint());
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1816099211.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1816099211;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.921 -0400", hash_original_method = "6BCC70723A0A0266DFEF3F6F9EAE3DFA", hash_generated_method = "435ACFD7DB2D7AEA819812D3E201FCBF")
        private final void setInitialState(State initialState) {
            Log.d(TAG, "setInitialState: initialState" + initialState.getName());
            mInitialState = initialState;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.922 -0400", hash_original_method = "21890E800BC5188E239893B522387EDA", hash_generated_method = "B9387CAD1717AAE34A6C57356A4ED4B2")
        private final void transitionTo(IState destState) {
            mDestState = (State) destState;
            Log.d(TAG, "StateMachine.transitionTo EX destState" + mDestState.getName());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.923 -0400", hash_original_method = "E228351895B227260722E6D77267BEC1", hash_generated_method = "DBD0065A9D6CD2D955D89D99CA279D39")
        private final void deferMessage(Message msg) {
            Log.d(TAG, "deferMessage: msg=" + msg.what);
            Message newMsg = obtainMessage();
            newMsg.copyFrom(msg);
            mDeferredMessages.add(newMsg);
            addTaint(msg.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.924 -0400", hash_original_method = "70D38ABCE91561514ACD98C85375A9A1", hash_generated_method = "5FFB9A9C7A3FE67573A1B6D4FCC8C237")
        private final void quit() {
            Log.d(TAG, "quit:");
            sendMessage(obtainMessage(SM_QUIT_CMD, mQuitObj));
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.924 -0400", hash_original_method = "BAB49FBE24A81490A5F317754A03EEE6", hash_generated_method = "A0431A0DF163EB24BC8215AC964AD5A8")
        private final boolean isQuit(Message msg) {
            addTaint(msg.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2136419169 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2136419169;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.925 -0400", hash_original_method = "0EC17970A8F6815D37F02ED3B599FE78", hash_generated_method = "12735CE95C7C7728BBDAD7A8DB9F61A3")
        private final boolean isDbg() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_692752464 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_692752464;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.925 -0400", hash_original_method = "2FBE0CE6F45608217065DCE46294BFD1", hash_generated_method = "BA70DD150B20B15D1FA853B35448103D")
        private final void setDbg(boolean dbg) {
            mDbg = dbg;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.926 -0400", hash_original_method = "80DE9CB8772B169AC72245D032E86B1D", hash_generated_method = "11D6668D620CBC2C7F85098BB0D52C7A")
        private final void setProcessedMessagesSize(int maxSize) {
            mProcessedMessages.setSize(maxSize);
            addTaint(maxSize);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.926 -0400", hash_original_method = "8FB0F44FDB0C5DC10452484BB601B3E7", hash_generated_method = "5C99EB069BCF8BF7937560CC77092D09")
        private final int getProcessedMessagesSize() {
            int var7094F3E812A5A7B9807ACDF8F0A83A82_1757592866 = (mProcessedMessages.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1976425840 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1976425840;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.927 -0400", hash_original_method = "92EED68DA49DE907A6704035F6436DD3", hash_generated_method = "FCD80CCC5B61DBA8FC99CE04B8C1411F")
        private final int getProcessedMessagesCount() {
            int var35155D08ADED50853B800820545DA8A4_811119043 = (mProcessedMessages.count());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1118355085 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1118355085;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.928 -0400", hash_original_method = "1E4BC1F21BF61852DF075DACE8E37071", hash_generated_method = "29A3687FC1DCAB906E7DD1B39B210D7F")
        private final ProcessedMessageInfo getProcessedMessageInfo(int index) {
            ProcessedMessageInfo varB4EAC82CA7396A68D541C85D26508E83_1615569498 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1615569498 = mProcessedMessages.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1615569498.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1615569498;
            
            
        }

        
        private class StateInfo {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.928 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "05D925C5BEC5275A59607FB5FAF72E84")

            State state;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.928 -0400", hash_original_field = "77CCEFFC07D942944F4F5BD610E55EA5", hash_generated_field = "306C0C906AA6DAA2CF8E599E0B8563F9")

            StateInfo parentStateInfo;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.928 -0400", hash_original_field = "C76A5E84E4BDEE527E274EA30C680D79", hash_generated_field = "51A28EFFDC4123E8CF1B6051031E7683")

            boolean active;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.928 -0400", hash_original_method = "87ADFE3F226D3DC74DE0940453A6AE41", hash_generated_method = "87ADFE3F226D3DC74DE0940453A6AE41")
            public StateInfo ()
            {
                
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.930 -0400", hash_original_method = "ABB8BC4D82891CF5369714A62A1A931C", hash_generated_method = "0266250EE0A9E6C979E0FE48DB51021C")
            @Override
            public String toString() {
                String varB4EAC82CA7396A68D541C85D26508E83_1742578614 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1742578614 = "state=" + state.getName() + ",active=" + active
                        + ",parent=" + ((parentStateInfo == null) ?
                                        "null" : parentStateInfo.state.getName());
                varB4EAC82CA7396A68D541C85D26508E83_1742578614.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1742578614;
                
                
                        
                                        
            }

            
        }


        
        private class HaltingState extends State {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.930 -0400", hash_original_method = "F9537758E4D6CCA48E760EA40D22DF18", hash_generated_method = "F9537758E4D6CCA48E760EA40D22DF18")
            public HaltingState ()
            {
                
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.930 -0400", hash_original_method = "58076C952A23C34E44D31450392EEB12", hash_generated_method = "58444DBBBBB5BE7CDA296B9D912D1FF6")
            @Override
            public boolean processMessage(Message msg) {
                mSm.haltedProcessMessage(msg);
                addTaint(msg.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_795643904 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_795643904;
                
                
                
            }

            
        }


        
        private class QuittingState extends State {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.930 -0400", hash_original_method = "769C07BAAE1E710E9D1020720F6EA4CE", hash_generated_method = "769C07BAAE1E710E9D1020720F6EA4CE")
            public QuittingState ()
            {
                
            }


            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.931 -0400", hash_original_method = "5D2BC087464A61E35A06899EEE03AD06", hash_generated_method = "1B6D2F34C8CC4F5F55A17E63A6E45247")
            @Override
            public boolean processMessage(Message msg) {
                addTaint(msg.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_186896240 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_186896240;
                
                
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.931 -0400", hash_original_field = "DC15EA213BD47E4BE39D710E17DFF4B6", hash_generated_field = "79B0F5D3D1C26EC177F0047971DE5AB2")

        private static final Object mQuitObj = new Object();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.931 -0400", hash_original_field = "537F1DDA7538F7A72494749C0F12F704", hash_generated_field = "CAD0D1AF78117508D5FE12695CB44B34")

    private static final String TAG = "StateMachine";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.931 -0400", hash_original_field = "15B717F550BED77CE69C04E1242173FB", hash_generated_field = "2DF10E3674476E7DE2945B0A711F8281")

    public static final int SM_QUIT_CMD = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.931 -0400", hash_original_field = "3522E5C9D1D8629B086D6AC8350A3C6A", hash_generated_field = "F4722196E019D2E6C260778CB0A7C91A")

    public static final int SM_INIT_CMD = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.931 -0400", hash_original_field = "5552FF5042034D9C12191D70306B2B80", hash_generated_field = "C37530D81C60F59480493B32E2235094")

    public static final boolean HANDLED = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.931 -0400", hash_original_field = "00334D351D3DBCEA247880E929510ECD", hash_generated_field = "A7A249A527FCD19FBF4EEC3A15F4F044")

    public static final boolean NOT_HANDLED = false;
}

