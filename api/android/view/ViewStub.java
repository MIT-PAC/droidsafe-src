package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.android.internal.R;
import java.lang.ref.WeakReference;

public final class ViewStub extends View {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.688 -0400", hash_original_field = "1B9BAD1B673A228AC1F5D0B0D0148A81", hash_generated_field = "BFA3E80188244F67D086E6C1264D1920")

    private int mLayoutResource = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.688 -0400", hash_original_field = "D1010496B3E3EC6836447943C5AA44FC", hash_generated_field = "C3B4AD2AB5263CF512143499D74024F5")

    private int mInflatedId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.688 -0400", hash_original_field = "0CC0D34619938906E86647F5C7D7DD1C", hash_generated_field = "925A912F414D892ECDB1D6C3C53B2B5D")

    private WeakReference<View> mInflatedViewRef;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.688 -0400", hash_original_field = "69FBE0B3636C2E3E89A0098AC4EB68CB", hash_generated_field = "C8623B9EF6EC871725D2916E9875638C")

    private OnInflateListener mInflateListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.688 -0400", hash_original_method = "D5B4F404EDB1F7EE3A8219EE57BB8326", hash_generated_method = "593B806270491638C702C9C2674616C9")
    public  ViewStub(Context context) {
        addTaint(context.getTaint());
        initialize(context);
        // ---------- Original Method ----------
        //initialize(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.689 -0400", hash_original_method = "5E88FD8C49C63D6BF51F68D5B3DF0B7F", hash_generated_method = "D81182F8A2F7FA042DE0755F365A38FA")
    public  ViewStub(Context context, int layoutResource) {
        addTaint(context.getTaint());
        mLayoutResource = layoutResource;
        initialize(context);
        // ---------- Original Method ----------
        //mLayoutResource = layoutResource;
        //initialize(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.689 -0400", hash_original_method = "333AE282E8B61286AB619D673C2E7E08", hash_generated_method = "7B6A7A4D6C726F6DCB53F6FF3B7A5CFA")
    public  ViewStub(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.690 -0400", hash_original_method = "D3AED5A95127BD0FBA7E121FA6467007", hash_generated_method = "9B82AAC50DA7492A4C5FA91536F0ED3D")
    @SuppressWarnings({"UnusedDeclaration"})
    public  ViewStub(Context context, AttributeSet attrs, int defStyle) {
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ViewStub,
                defStyle, 0);
        mInflatedId = a.getResourceId(R.styleable.ViewStub_inflatedId, NO_ID);
        mLayoutResource = a.getResourceId(R.styleable.ViewStub_layout, 0);
        a.recycle();
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.View, defStyle, 0);
        mID = a.getResourceId(R.styleable.View_id, NO_ID);
        a.recycle();
        initialize(context);
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ViewStub,
                //defStyle, 0);
        //mInflatedId = a.getResourceId(R.styleable.ViewStub_inflatedId, NO_ID);
        //mLayoutResource = a.getResourceId(R.styleable.ViewStub_layout, 0);
        //a.recycle();
        //a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.View, defStyle, 0);
        //mID = a.getResourceId(R.styleable.View_id, NO_ID);
        //a.recycle();
        //initialize(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.690 -0400", hash_original_method = "7D8DDEBB17ED3180A708C3B6F0212F68", hash_generated_method = "CCF3516282D357CF9B0D0F281C26EB81")
    private void initialize(Context context) {
        addTaint(context.getTaint());
        mContext = context;
        setVisibility(GONE);
        setWillNotDraw(true);
        // ---------- Original Method ----------
        //mContext = context;
        //setVisibility(GONE);
        //setWillNotDraw(true);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.690 -0400", hash_original_method = "DD261735D727F86389B5178B589BDC0E", hash_generated_method = "38176E1539BDAD049DB7DDE251C2427D")
    public int getInflatedId() {
        int varD1010496B3E3EC6836447943C5AA44FC_604455750 = (mInflatedId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000132754 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000132754;
        // ---------- Original Method ----------
        //return mInflatedId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.691 -0400", hash_original_method = "86B5E29885E599B44EC441F118D9B30F", hash_generated_method = "EBA6AEE4A4115F5E2962979EEB78D8EF")
    public void setInflatedId(int inflatedId) {
        mInflatedId = inflatedId;
        // ---------- Original Method ----------
        //mInflatedId = inflatedId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.691 -0400", hash_original_method = "027E5859DCA96FAAAAB58CE710A8870F", hash_generated_method = "D912B9B6A4B1061E4FA2163524CD1DD5")
    public int getLayoutResource() {
        int varCAD69CF3708A5AE65F3F60DF86F222EC_1131134209 = (mLayoutResource);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1941891865 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1941891865;
        // ---------- Original Method ----------
        //return mLayoutResource;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.691 -0400", hash_original_method = "9A9CDCEDF7B2E8EB813F1BBF2264D05B", hash_generated_method = "8A1DC50EC3A8DB509125E7858400A622")
    public void setLayoutResource(int layoutResource) {
        mLayoutResource = layoutResource;
        // ---------- Original Method ----------
        //mLayoutResource = layoutResource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.692 -0400", hash_original_method = "5C9393E5CC8833BE15FFC01B23AE5CB2", hash_generated_method = "629F227210A19E60C4FCCEE9AE8F490F")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        setMeasuredDimension(0, 0);
        // ---------- Original Method ----------
        //setMeasuredDimension(0, 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.692 -0400", hash_original_method = "D063B9229A7B99E7AD0A562CA5051177", hash_generated_method = "B4FDD4C6E53F70C771C0461AF2312DCC")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.692 -0400", hash_original_method = "0296ECFD4FBB578ABFB3DEE9D2F54084", hash_generated_method = "8827C1FA31E6998965C439129AE20899")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.692 -0400", hash_original_method = "8020455B6FCF7D6831D6E164290A9878", hash_generated_method = "AB428ADE4C3542603E1E3CDC31C49B9E")
    @Override
    public void setVisibility(int visibility) {
        addTaint(visibility);
    if(mInflatedViewRef != null)        
        {
            View view = mInflatedViewRef.get();
    if(view != null)            
            {
                view.setVisibility(visibility);
            } //End block
            else
            {
                IllegalStateException var5B7DB2EA9ADA71CDB4265EB197B279A7_78210869 = new IllegalStateException("setVisibility called on un-referenced view");
                var5B7DB2EA9ADA71CDB4265EB197B279A7_78210869.addTaint(taint);
                throw var5B7DB2EA9ADA71CDB4265EB197B279A7_78210869;
            } //End block
        } //End block
        else
        {
            super.setVisibility(visibility);
    if(visibility == VISIBLE || visibility == INVISIBLE)            
            {
                inflate();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mInflatedViewRef != null) {
            //View view = mInflatedViewRef.get();
            //if (view != null) {
                //view.setVisibility(visibility);
            //} else {
                //throw new IllegalStateException("setVisibility called on un-referenced view");
            //}
        //} else {
            //super.setVisibility(visibility);
            //if (visibility == VISIBLE || visibility == INVISIBLE) {
                //inflate();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.693 -0400", hash_original_method = "FA523E28924F274233340119C3A40101", hash_generated_method = "A816E82B733C7A3198A776D647B82370")
    public View inflate() {
        final ViewParent viewParent = getParent();
    if(viewParent != null && viewParent instanceof ViewGroup)        
        {
    if(mLayoutResource != 0)            
            {
                final ViewGroup parent = (ViewGroup) viewParent;
                final LayoutInflater factory = LayoutInflater.from(mContext);
                final View view = factory.inflate(mLayoutResource, parent,
                        false);
    if(mInflatedId != NO_ID)                
                {
                    view.setId(mInflatedId);
                } //End block
                final int index = parent.indexOfChild(this);
                parent.removeViewInLayout(this);
                final ViewGroup.LayoutParams layoutParams = getLayoutParams();
    if(layoutParams != null)                
                {
                    parent.addView(view, index, layoutParams);
                } //End block
                else
                {
                    parent.addView(view, index);
                } //End block
                mInflatedViewRef = new WeakReference<View>(view);
    if(mInflateListener != null)                
                {
                    mInflateListener.onInflate(this, view);
                } //End block
View var057D265746AE9672AFE5F9FF6338071D_414210484 =                 view;
                var057D265746AE9672AFE5F9FF6338071D_414210484.addTaint(taint);
                return var057D265746AE9672AFE5F9FF6338071D_414210484;
            } //End block
            else
            {
                IllegalArgumentException var1220522CB703E38D2718150BEFFACEE3_2002295537 = new IllegalArgumentException("ViewStub must have a valid layoutResource");
                var1220522CB703E38D2718150BEFFACEE3_2002295537.addTaint(taint);
                throw var1220522CB703E38D2718150BEFFACEE3_2002295537;
            } //End block
        } //End block
        else
        {
            IllegalStateException varB3F67048480D8BB699F5593D87EE912A_2141602051 = new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
            varB3F67048480D8BB699F5593D87EE912A_2141602051.addTaint(taint);
            throw varB3F67048480D8BB699F5593D87EE912A_2141602051;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.694 -0400", hash_original_method = "082FDB27359F9D2A7A4CA2B124FBADFF", hash_generated_method = "B32FFC65DC1775C44018C6EB136B16B0")
    public void setOnInflateListener(OnInflateListener inflateListener) {
        mInflateListener = inflateListener;
        // ---------- Original Method ----------
        //mInflateListener = inflateListener;
    }

    
    public static interface OnInflateListener {
        
        void onInflate(ViewStub stub, View inflated);
    }
    
}

