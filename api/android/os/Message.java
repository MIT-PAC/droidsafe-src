package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public final class Message implements Parcelable {
    
    public static Message obtain(){
		// Original method
		/*
		{
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
		*/
        return new Message();
	}

    /**
     * Same as {@link #obtain()}, but copies the values of an existing
     * message (including its target) into the new one.
     * @param orig Original message to copy.
     * @return A Message object from the global pool.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.317 -0500", hash_original_method = "3DDDC922E39D84127A2DC1786D3B33D2", hash_generated_method = "FB481C3AFDFA8C19EBE869A80159C902")
    
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

    /**
     * Same as {@link #obtain()}, but sets the value for the <em>target</em> member on the Message returned.
     * @param h  Handler to assign to the returned Message object's <em>target</em> member.
     * @return A Message object from the global pool.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.319 -0500", hash_original_method = "F1E1A90C9FE0056DE27D4BDD6B0CFE0C", hash_generated_method = "D9647A6DA04D00CC1B48559ADDC91104")
    
public static Message obtain(Handler h) {
        Message m = obtain();
        m.target = h;

        return m;
    }

    /**
     * Same as {@link #obtain(Handler)}, but assigns a callback Runnable on
     * the Message that is returned.
     * @param h  Handler to assign to the returned Message object's <em>target</em> member.
     * @param callback Runnable that will execute when the message is handled.
     * @return A Message object from the global pool.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.321 -0500", hash_original_method = "073C1A8A82742334214D17BA541D97D4", hash_generated_method = "4A3DA3C99DDA22F9E99EA5853834959A")
    
public static Message obtain(Handler h, Runnable callback) {
        Message m = obtain();
        m.target = h;
        m.callback = callback;

        return m;
    }

    /**
     * Same as {@link #obtain()}, but sets the values for both <em>target</em> and
     * <em>what</em> members on the Message.
     * @param h  Value to assign to the <em>target</em> member.
     * @param what  Value to assign to the <em>what</em> member.
     * @return A Message object from the global pool.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.324 -0500", hash_original_method = "E26B7D4E6B35F5234F7DF4974522919A", hash_generated_method = "735878BCF4D4D13F8EC3A8CC8DF1B845")
    
public static Message obtain(Handler h, int what) {
        Message m = obtain();
        m.target = h;
        m.what = what;

        return m;
    }

    /**
     * Same as {@link #obtain()}, but sets the values of the <em>target</em>, <em>what</em>, and <em>obj</em>
     * members.
     * @param h  The <em>target</em> value to set.
     * @param what  The <em>what</em> value to set.
     * @param obj  The <em>object</em> method to set.
     * @return  A Message object from the global pool.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.326 -0500", hash_original_method = "DD09B29D12E38FF7883BAB5D6B58243F", hash_generated_method = "48467203DADCBADA8EFADA7691CEBF70")
    
public static Message obtain(Handler h, int what, Object obj) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.obj = obj;

        return m;
    }

    /**
     * Same as {@link #obtain()}, but sets the values of the <em>target</em>, <em>what</em>, 
     * <em>arg1</em>, and <em>arg2</em> members.
     * 
     * @param h  The <em>target</em> value to set.
     * @param what  The <em>what</em> value to set.
     * @param arg1  The <em>arg1</em> value to set.
     * @param arg2  The <em>arg2</em> value to set.
     * @return  A Message object from the global pool.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.329 -0500", hash_original_method = "4DCC15A1D3B41D0AD35502FBE5B811FF", hash_generated_method = "F3CC485A508121FCA56CF2574BB30B5D")
    
public static Message obtain(Handler h, int what, int arg1, int arg2) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.arg1 = arg1;
        m.arg2 = arg2;

        return m;
    }
    
	public static Message obtain(Handler h, int what, 
            int arg1, int arg2, Object obj){
		// Original method
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.arg1 = arg1;
        m.arg2 = arg2;
        m.obj = obj;
		return null;
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.286 -0500", hash_original_field = "B7262A81C8C3C702FB75E30B43F29131", hash_generated_field = "D6FE2D8FA032C972D45CEB59E1725115")

    /*package*/ static final int FLAG_IN_USE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.288 -0500", hash_original_field = "B698EC7A6E7F3E331BE58A2AABAFCA83", hash_generated_field = "B724A0AE6F5320D2FC62A4A420CFF218")

    /*package*/ static final int FLAGS_RESERVED = ~FLAG_IN_USE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.290 -0500", hash_original_field = "CB1614A7B7A4082A72FBDBC2B3642351", hash_generated_field = "6D7FC1E39E92BE6F9E8397A1F17D22B9")

    /*package*/ static final int FLAGS_TO_CLEAR_ON_COPY_FROM = FLAGS_RESERVED | FLAG_IN_USE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.305 -0500", hash_original_field = "FF70C662CB92BB1987F6CF4637424D6E", hash_generated_field = "D5B99AC4B86CE940DBBD3CF3FA1D542C")

    private static final Object sPoolSync = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.307 -0500", hash_original_field = "C3B98DB7170BE56DC73323FF4F23BC29", hash_generated_field = "3C48422D8BFA116BB318D4BB60A34BBD")

    private static Message sPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.310 -0500", hash_original_field = "58C64529682BFD4E11D662842F129355", hash_generated_field = "A60993B78066ACEFAC0F4A6F4AB10BB4")

    private static int sPoolSize = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.312 -0500", hash_original_field = "3257F81BBFE679E3360141AA5EA9D518", hash_generated_field = "FB8E412EAB46029C42E8E38ED918C6D9")

    private static final int MAX_POOL_SIZE = 10;
    public static final Parcelable.Creator<Message> CREATOR
            = new Parcelable.Creator<Message>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.370 -0500", hash_original_method = "C469647B7E7B16486A85AB4B8FE1AC44", hash_generated_method = "5A2A7B37F6B69DB49B562A947E4208DD")
        
public Message createFromParcel(Parcel source) {
            Message msg = Message.obtain();
            msg.readFromParcel(source);
            return msg;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.373 -0500", hash_original_method = "84E6F9E4CA0DE670DE1B09305CE190D8", hash_generated_method = "A0D6808AEB48C6CE5F9ABA06C358C991")
        
public Message[] newArray(int size) {
            return new Message[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.275 -0500", hash_original_field = "6100FAC75E91CAC232945E82029A9682", hash_generated_field = "130AB11BC4A7C28A3CB0C97AC053381A")

    public int what;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.277 -0500", hash_original_field = "EAD1E05EADC4FCE9A2805284ABC44CBA", hash_generated_field = "1808B9C59CDAD2173540A83CCC2F12FC")

    public int arg1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.279 -0500", hash_original_field = "44EAABC8C1135EBC30E3C32CC3AA66C4", hash_generated_field = "D3008AC94E91096C7F8D70DE5B308A98")

    public int arg2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.281 -0500", hash_original_field = "B907C3B1813ED5337E8F8B30F31ED00A", hash_generated_field = "3D030F645B0E31EC2638A0FDB262ACF0")

    public Object obj;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.283 -0500", hash_original_field = "A7F2C73FD7B73467CFE74828F3D2576F", hash_generated_field = "59ACAA216DB03F1B21C3B4CE2CA4F885")

    public Messenger replyTo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.292 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "E0CDE1A38A40425C446F52269E5723DC")
 int flags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.294 -0500", hash_original_field = "4E7289569777021C55877266ACAD1845", hash_generated_field = "4E7289569777021C55877266ACAD1845")
 long when;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.296 -0500", hash_original_field = "BB882EDD7B91CD5D615428BED9D11B40", hash_generated_field = "BB882EDD7B91CD5D615428BED9D11B40")
 Bundle data;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.297 -0500", hash_original_field = "6747FE4EAD68C59D650E1B0351577C58", hash_generated_field = "6747FE4EAD68C59D650E1B0351577C58")
 Handler target;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.301 -0500", hash_original_field = "717897033CD9178FC069A108DDA31DCB", hash_generated_field = "717897033CD9178FC069A108DDA31DCB")
 Runnable callback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.303 -0500", hash_original_field = "165CCC48EE62810C4F5C8218FA3C8FD1", hash_generated_field = "62CEF496F5209D649A6403F718468720")

    /*package*/ Message next;

    /** Constructor (but the preferred way to get a Message is to call {@link #obtain() Message.obtain()}).
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.362 -0500", hash_original_method = "07161C5E5BFC528DA3FC2F6017B16172", hash_generated_method = "C388122C31305A6494A3C73AA60B75A9")
    
public Message() {
    }
    
    public void recycle(){
		// Original method
		/*
		{
        clearForRecycle();
        synchronized (sPoolSync) {
            if (sPoolSize < MAX_POOL_SIZE) {
                next = sPool;
                sPool = this;
                sPoolSize++;
            }
        }
    }
		*/
		//Return nothing
	}

    /**
     * Make this message like o.  Performs a shallow copy of the data field.
     * Does not copy the linked list fields, nor the timestamp or
     * target/callback of the original message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.336 -0500", hash_original_method = "964842F017E82BDA48950DE2BC18315A", hash_generated_method = "53C38DCE26AD4C0BE411F5C62632EEC7")
    
public void copyFrom(Message o) {
        this.flags = o.flags & ~FLAGS_TO_CLEAR_ON_COPY_FROM;
        this.what = o.what;
        this.arg1 = o.arg1;
        this.arg2 = o.arg2;
        this.obj = o.obj;
        this.replyTo = o.replyTo;

        if (o.data != null) {
            this.data = (Bundle) o.data.clone();
        } else {
            this.data = null;
        }
    }

    /**
     * Return the targeted delivery time of this message, in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.338 -0500", hash_original_method = "003296F505672677447BEB837B373395", hash_generated_method = "02D49CA56ECAA0D2FBAA9CCB74889B76")
    
public long getWhen() {
        return when;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.340 -0500", hash_original_method = "4206C8A14E5D790EB7EB282A0235F495", hash_generated_method = "8433B6591EF18DAC07E9801FFBD6D29E")
    
public void setTarget(Handler target) {
        this.target = target;
    }

    /**
     * Retrieve the a {@link android.os.Handler Handler} implementation that
     * will receive this message. The object must implement
     * {@link android.os.Handler#handleMessage(android.os.Message)
     * Handler.handleMessage()}. Each Handler has its own name-space for
     * message codes, so you do not need to
     * worry about yours conflicting with other handlers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.342 -0500", hash_original_method = "71A342D68A16A50B25BC4BF2093BFF62", hash_generated_method = "DB4CE288ABA8CC2FF8E21FD5CD6A260A")
    
public Handler getTarget() {
        return target;
    }

    /**
     * Retrieve callback object that will execute when this message is handled.
     * This object must implement Runnable. This is called by
     * the <em>target</em> {@link Handler} that is receiving this Message to
     * dispatch it.  If
     * not set, the message will be dispatched to the receiving Handler's
     * {@link Handler#handleMessage(Message Handler.handleMessage())}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.344 -0500", hash_original_method = "BE120AA50B796443E57F262EC015813E", hash_generated_method = "F3037125B1FF2FF11986F79F6A898A18")
    
public Runnable getCallback() {
        return callback;
    }
    
	public Bundle getData(){
        return data = new Bundle();
	}

    /** 
     * Like getData(), but does not lazily create the Bundle.  A null
     * is returned if the Bundle does not already exist.  See
     * {@link #getData} for further information on this.
     * @see #getData()
     * @see #setData(Bundle)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.349 -0500", hash_original_method = "82F96E5D1D9A678E87ADC3DA47E10262", hash_generated_method = "2AA1FD4D3B1E705F84956FE40AA49734")
    
public Bundle peekData() {
        return data;
    }

    /**
     * Sets a Bundle of arbitrary data values. Use arg1 and arg1 members 
     * as a lower cost way to send a few simple integer values, if you can.
     * @see #getData() 
     * @see #peekData()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.351 -0500", hash_original_method = "2A3AF1BEE5D39047FC40D7968EE3828B", hash_generated_method = "E6DE205F5507518F4C757F398D9B9FC5")
    
public void setData(Bundle data) {
        this.data = data;
    }

    /**
     * Sends this Message to the Handler specified by {@link #getTarget}.
     * Throws a null pointer exception if this field has not been set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.353 -0500", hash_original_method = "2D3F3759D60A7A1CBA79B8F487061097", hash_generated_method = "35E9C435AC941949A3E301FED5BE4231")
    
public void sendToTarget() {
        target.sendMessage(this);
    }
    
    void clearForRecycle(){
		// Original method
		/*
		{
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
		*/
		//Return nothing
	}
    
    boolean isInUse(){
		// Original method
		/*
		{
        return ((flags & FLAG_IN_USE) == FLAG_IN_USE);
    }
		*/
		return getTaintBoolean();
	}
    
    void markInUse(){
		// Original method
		/*
		{
        flags |= FLAG_IN_USE;
    }
		*/
		//Return nothing
	}
    
    public String toString(){
		// Original method
		/*
		{
        return toString(SystemClock.uptimeMillis());
    }
		*/
		return "";
	}
    
    String toString(long now){
		// Original method
		/*
		{
        StringBuilder   b = new StringBuilder();
        b.append("{ what=");
        b.append(what);
        b.append(" when=");
        TimeUtils.formatDuration(when-now, b);
        if (arg1 != 0) {
            b.append(" arg1=");
            b.append(arg1);
        }
        if (arg2 != 0) {
            b.append(" arg2=");
            b.append(arg2);
        }
        if (obj != null) {
            b.append(" obj=");
            b.append(obj);
        }
        b.append(" }");
        return b.toString();
    }
		*/
		return "";
	}
    
    public int describeContents(){
		// Original method
		/*
		{
        return 0;
    }
		*/
		return getTaintInt();
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void writeToParcel(Parcel dest, int flags){
		// Original method
        if (DroidSafeAndroidRuntime.control) {
            RuntimeException ex = new RuntimeException("Can't marshal callbacks across processes.");
            ex.addTaint(getTaint());
            throw ex;
        }
        
        dest.writeInt(what);
        dest.writeInt(arg1);
        dest.writeInt(arg2);
        if (obj != null) {
            try {
                Parcelable p = (Parcelable)obj;
                dest.writeInt(1);
                dest.writeParcelable(p, flags);
            } catch (ClassCastException e) {
                throw new RuntimeException(
                    "Can't marshal non-Parcelable objects across processes.");
            }
        } else {
            dest.writeInt(0);
        }
        dest.writeLong(when);
        dest.writeBundle(data);
        Messenger.writeMessengerOrNullToParcel(replyTo, dest);
	}
    
    private final void readFromParcel(Parcel source){
        addTaint(source.getTaint());
		// Original method
        what = source.readInt();
        arg1 = source.readInt();
        arg2 = source.readInt();
        if (source.readInt() != 0) {
            obj = new Object();
        }
        when = source.readLong();
        data = source.readBundle();
        replyTo = Messenger.readMessengerOrNullFromParcel(source);
	}
}

