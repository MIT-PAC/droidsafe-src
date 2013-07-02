package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.TimeUtils;

public final class Message implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.508 -0400", hash_original_field = "4A2028ECEAC5E1F4D252EA13C71ECEC6", hash_generated_field = "130AB11BC4A7C28A3CB0C97AC053381A")

    public int what;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.508 -0400", hash_original_field = "E866231598ED4CB18BE5E493240A11B0", hash_generated_field = "1808B9C59CDAD2173540A83CCC2F12FC")

    public int arg1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.508 -0400", hash_original_field = "80A26383E00E892C98EBD598EDCC5DBB", hash_generated_field = "D3008AC94E91096C7F8D70DE5B308A98")

    public int arg2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.508 -0400", hash_original_field = "BE8F80182E0C983916DA7338C2C1C040", hash_generated_field = "3D030F645B0E31EC2638A0FDB262ACF0")

    public Object obj;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.508 -0400", hash_original_field = "18870C945F5A9236EE66F25EEE76F849", hash_generated_field = "59ACAA216DB03F1B21C3B4CE2CA4F885")

    public Messenger replyTo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.508 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "E0CDE1A38A40425C446F52269E5723DC")

    int flags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.508 -0400", hash_original_field = "DF491A4DE50739FA9CFFDBD4E3F4B4BB", hash_generated_field = "4E7289569777021C55877266ACAD1845")

    long when;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.508 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BB882EDD7B91CD5D615428BED9D11B40")

    Bundle data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.508 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "6747FE4EAD68C59D650E1B0351577C58")

    Handler target;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.508 -0400", hash_original_field = "924A8CEEAC17F54D3BE3F8CDF1C04EB2", hash_generated_field = "717897033CD9178FC069A108DDA31DCB")

    Runnable callback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.508 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "165CCC48EE62810C4F5C8218FA3C8FD1")

    Message next;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.508 -0400", hash_original_method = "07161C5E5BFC528DA3FC2F6017B16172", hash_generated_method = "95F5AD60FAEEEF50B67BC5FEEDEC5F61")
    public  Message() {
        
    }

    
    @DSModeled(DSC.SAFE)
    public static Message obtain() {
        synchronized (sPoolSync) {
            if (sPool != null) {
                Message m = sPool;
                sPool = m.next;
                m.next = null;
                sPoolSize--;
                return m;
            }
        }
        return new Message();
    }

    
    @DSModeled(DSC.SAFE)
    public static Message obtain(Message orig) {
        Message m = obtain();
        m.what = orig.what;
        m.arg1 = orig.arg1;
        m.arg2 = orig.arg2;
        m.obj = orig.obj;
        m.replyTo = orig.replyTo;
        if (orig.data != null) {
            m.data = new Bundle(orig.data);
        }
        m.target = orig.target;
        m.callback = orig.callback;
        return m;
    }

    
    @DSModeled(DSC.SAFE)
    public static Message obtain(Handler h) {
        Message m = obtain();
        m.target = h;
        return m;
    }

    
    @DSModeled(DSC.SAFE)
    public static Message obtain(Handler h, Runnable callback) {
        Message m = obtain();
        m.target = h;
        m.callback = callback;
        return m;
    }

    
    @DSModeled(DSC.SAFE)
    public static Message obtain(Handler h, int what) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        return m;
    }

    
    @DSModeled(DSC.SAFE)
    public static Message obtain(Handler h, int what, Object obj) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.obj = obj;
        return m;
    }

    
    @DSModeled(DSC.SAFE)
    public static Message obtain(Handler h, int what, int arg1, int arg2) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.arg1 = arg1;
        m.arg2 = arg2;
        return m;
    }

    
    @DSModeled(DSC.SAFE)
    public static Message obtain(Handler h, int what, 
            int arg1, int arg2, Object obj) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.arg1 = arg1;
        m.arg2 = arg2;
        m.obj = obj;
        return m;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.510 -0400", hash_original_method = "0036C7E97F14F697C30BFE1437947C9D", hash_generated_method = "8AA523264671A583435FF7781AA08DE0")
    public void recycle() {
        clearForRecycle();
        {
            {
                next = sPool;
                sPool = this;
            } 
        } 
        
        
        
            
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.511 -0400", hash_original_method = "964842F017E82BDA48950DE2BC18315A", hash_generated_method = "320A286D06B9973214AE9DD5A0E1FD71")
    public void copyFrom(Message o) {
        this.flags = o.flags & ~FLAGS_TO_CLEAR_ON_COPY_FROM;
        this.what = o.what;
        this.arg1 = o.arg1;
        this.arg2 = o.arg2;
        this.obj = o.obj;
        this.replyTo = o.replyTo;
        {
            this.data = (Bundle) o.data.clone();
        } 
        {
            this.data = null;
        } 
        
        
        
        
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.511 -0400", hash_original_method = "003296F505672677447BEB837B373395", hash_generated_method = "DD38AFAE361E5ADD5D10C3A40C52C4FB")
    public long getWhen() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1257977225 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1257977225;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.512 -0400", hash_original_method = "4206C8A14E5D790EB7EB282A0235F495", hash_generated_method = "BFA69EC1EEA25086C4D9E40A15F143AE")
    public void setTarget(Handler target) {
        this.target = target;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.512 -0400", hash_original_method = "71A342D68A16A50B25BC4BF2093BFF62", hash_generated_method = "7B5DA9A1B868F3F92A970B03D0F9B6A1")
    public Handler getTarget() {
        Handler varB4EAC82CA7396A68D541C85D26508E83_1803010247 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1803010247 = target;
        varB4EAC82CA7396A68D541C85D26508E83_1803010247.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1803010247;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.513 -0400", hash_original_method = "BE120AA50B796443E57F262EC015813E", hash_generated_method = "172F97B99231B2C63783924F9C2330E7")
    public Runnable getCallback() {
        Runnable varB4EAC82CA7396A68D541C85D26508E83_1376576412 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1376576412 = callback;
        varB4EAC82CA7396A68D541C85D26508E83_1376576412.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1376576412;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.514 -0400", hash_original_method = "1D2563192E30736CE7AB1C4867F66034", hash_generated_method = "4F7A22CCE5BCA54B8755B9C0C49227E8")
    public Bundle getData() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_698040526 = null; 
        {
            data = new Bundle();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_698040526 = data;
        varB4EAC82CA7396A68D541C85D26508E83_698040526.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_698040526;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.514 -0400", hash_original_method = "82F96E5D1D9A678E87ADC3DA47E10262", hash_generated_method = "25177481273ECF1B23495A4F7B3175CA")
    public Bundle peekData() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_57126940 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_57126940 = data;
        varB4EAC82CA7396A68D541C85D26508E83_57126940.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_57126940;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.515 -0400", hash_original_method = "2A3AF1BEE5D39047FC40D7968EE3828B", hash_generated_method = "EAE8CA4F21A678E5FDC9CFA85AC5AD0E")
    public void setData(Bundle data) {
        this.data = data;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.515 -0400", hash_original_method = "2D3F3759D60A7A1CBA79B8F487061097", hash_generated_method = "3B7F287400275060A2AE0E3943AFE99E")
    public void sendToTarget() {
        target.sendMessage(this);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.516 -0400", hash_original_method = "9CE194651C6176A08C0A91B012A85C32", hash_generated_method = "11A13B0F3660F78F0D526315F89EA24B")
     void clearForRecycle() {
        flags = 0;
        what = 0;
        arg1 = 0;
        arg2 = 0;
        obj = null;
        replyTo = null;
        when = 0;
        target = null;
        callback = null;
        data = null;
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.517 -0400", hash_original_method = "2F71B67A0204C39D3FE8504F70842AAF", hash_generated_method = "2CB4B54765CCE679E6C59E278C618300")
     boolean isInUse() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1835580528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1835580528;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.517 -0400", hash_original_method = "05D8812E72ABC796A0F0FB73D8BB23FD", hash_generated_method = "2406C8342B30A3F95EC80EECA1F8197F")
     void markInUse() {
        flags |= FLAG_IN_USE;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.518 -0400", hash_original_method = "F5F2ADD77ACF5EFEB7E2DD825A11C06D", hash_generated_method = "7EEBC6763F6F696761DB8356EF2EA8B2")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_937512879 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_937512879 = toString(SystemClock.uptimeMillis());
        varB4EAC82CA7396A68D541C85D26508E83_937512879.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_937512879;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.519 -0400", hash_original_method = "94FE68A35FA2D79CB6E07D112DBAE9F2", hash_generated_method = "003969D8A91CB92CCFAEC5DA521FB5A7")
     String toString(long now) {
        String varB4EAC82CA7396A68D541C85D26508E83_162526914 = null; 
        StringBuilder b = new StringBuilder();
        b.append("{ what=");
        b.append(what);
        b.append(" when=");
        TimeUtils.formatDuration(when-now, b);
        {
            b.append(" arg1=");
            b.append(arg1);
        } 
        {
            b.append(" arg2=");
            b.append(arg2);
        } 
        {
            b.append(" obj=");
            b.append(obj);
        } 
        b.append(" }");
        varB4EAC82CA7396A68D541C85D26508E83_162526914 = b.toString();
        addTaint(now);
        varB4EAC82CA7396A68D541C85D26508E83_162526914.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_162526914;
        
        
        
        
        
        
        
            
            
        
        
            
            
        
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.519 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "355A97CA100052ED3709657D854ADCF0")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688839518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688839518;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.520 -0400", hash_original_method = "FA929F9306B89098CA5E11E46F85B0F7", hash_generated_method = "EB20A471EB7AF55DBE2ABE2126681728")
    public void writeToParcel(Parcel dest, int flags) {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                "Can't marshal callbacks across processes.");
        } 
        dest.writeInt(what);
        dest.writeInt(arg1);
        dest.writeInt(arg2);
        {
            try 
            {
                Parcelable p = (Parcelable)obj;
                dest.writeInt(1);
                dest.writeParcelable(p, flags);
            } 
            catch (ClassCastException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Can't marshal non-Parcelable objects across processes.");
            } 
        } 
        {
            dest.writeInt(0);
        } 
        dest.writeLong(when);
        dest.writeBundle(data);
        Messenger.writeMessengerOrNullToParcel(replyTo, dest);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
            
                
        
        
        
        
        
            
                
                
                
            
                
                    
            
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.520 -0400", hash_original_method = "95144FD69C7B3357510BFAF1773BB579", hash_generated_method = "F807EF1D061E3C0FEF31587D1C6B34C1")
    private final void readFromParcel(Parcel source) {
        what = source.readInt();
        arg1 = source.readInt();
        arg2 = source.readInt();
        {
            boolean varFD16828A378FD83700BE97539951F787_977269624 = (source.readInt() != 0);
            {
                obj = source.readParcelable(getClass().getClassLoader());
            } 
        } 
        when = source.readLong();
        data = source.readBundle();
        replyTo = Messenger.readMessengerOrNullFromParcel(source);
        
        
        
        
        
            
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.520 -0400", hash_original_field = "57B7C7421075F6B6420F911D3527AFB6", hash_generated_field = "878DEDDD7B572ED9867CCDEBD4347356")

    static final int FLAG_IN_USE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.520 -0400", hash_original_field = "F2146583483B569FF112D02F21977BC5", hash_generated_field = "63BCD1D96706E3D5340B3C46A4396022")

    static final int FLAGS_RESERVED = ~FLAG_IN_USE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.520 -0400", hash_original_field = "3D49B55061DF5B14043047E338410BBA", hash_generated_field = "35B37EFAF229985395377BFF3A8A2664")

    static final int FLAGS_TO_CLEAR_ON_COPY_FROM = FLAGS_RESERVED | FLAG_IN_USE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.520 -0400", hash_original_field = "695C1FB30F6443A40182A7409583CA63", hash_generated_field = "D5B99AC4B86CE940DBBD3CF3FA1D542C")

    private static final Object sPoolSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.520 -0400", hash_original_field = "0DDC63886CD8DB777504574D2935937E", hash_generated_field = "3C48422D8BFA116BB318D4BB60A34BBD")

    private static Message sPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.520 -0400", hash_original_field = "4F049A98A9127B46EEEAAAE7FA453CDC", hash_generated_field = "A60993B78066ACEFAC0F4A6F4AB10BB4")

    private static int sPoolSize = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.520 -0400", hash_original_field = "EB2583C9A133F7C44A9BFAD1B17484D6", hash_generated_field = "FB8E412EAB46029C42E8E38ED918C6D9")

    private static final int MAX_POOL_SIZE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.520 -0400", hash_original_field = "43229C35F8261605B76A284A560DF109", hash_generated_field = "E157BCD0B97CB6AF314D46703252D6F2")

    public static final Parcelable.Creator<Message> CREATOR
            = new Parcelable.Creator<Message>() {
        public Message createFromParcel(Parcel source) {
            Message msg = Message.obtain();
            msg.readFromParcel(source);
            return msg;
        }
        
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };
    
    public Message createFromParcel(Parcel source) {
            Message msg = Message.obtain();
            msg.readFromParcel(source);
            return msg;
        }
    
    
    public Message[] newArray(int size) {
            return new Message[size];
        }
    
}

