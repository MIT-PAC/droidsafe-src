package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.android.internal.R;






public final class ViewStub extends View {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.926 -0500", hash_original_field = "F027C8324C9EA544A6DEF6F0954ED652", hash_generated_field = "BFA3E80188244F67D086E6C1264D1920")

    private int mLayoutResource = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.928 -0500", hash_original_field = "24EC4B380E54A595A52BF29F0B37C124", hash_generated_field = "C3B4AD2AB5263CF512143499D74024F5")

    private int mInflatedId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.930 -0500", hash_original_field = "F19710BC255E7367DD68F653C2AC6F4E", hash_generated_field = "925A912F414D892ECDB1D6C3C53B2B5D")


    private WeakReference<View> mInflatedViewRef;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.932 -0500", hash_original_field = "7E90D4FB095EBE65153FCE42EE9ED5C8", hash_generated_field = "C8623B9EF6EC871725D2916E9875638C")


    private OnInflateListener mInflateListener;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.935 -0500", hash_original_method = "D5B4F404EDB1F7EE3A8219EE57BB8326", hash_generated_method = "A754F8EB006299F9824EAF2C692C5001")
    
public ViewStub(Context context) {
        initialize(context);
    }

    /**
     * Creates a new ViewStub with the specified layout resource.
     *
     * @param context The application's environment.
     * @param layoutResource The reference to a layout resource that will be inflated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.937 -0500", hash_original_method = "5E88FD8C49C63D6BF51F68D5B3DF0B7F", hash_generated_method = "8A3BBCEF06480A088FBF97BFFA711946")
    
public ViewStub(Context context, int layoutResource) {
        mLayoutResource = layoutResource;
        initialize(context);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.940 -0500", hash_original_method = "333AE282E8B61286AB619D673C2E7E08", hash_generated_method = "7EB3FFEF98194F07EC596E4D14EC8605")
    
public ViewStub(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.944 -0500", hash_original_method = "D3AED5A95127BD0FBA7E121FA6467007", hash_generated_method = "2B96CCB8CFC4E14A21FC5381DDC7F770")
    
@SuppressWarnings({"UnusedDeclaration"})
    public ViewStub(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ViewStub,
                defStyle, 0);

        mInflatedId = a.getResourceId(R.styleable.ViewStub_inflatedId, NO_ID);
        mLayoutResource = a.getResourceId(R.styleable.ViewStub_layout, 0);

        a.recycle();

        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.View, defStyle, 0);
        mID = a.getResourceId(R.styleable.View_id, NO_ID);
        a.recycle();

        initialize(context);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.946 -0500", hash_original_method = "7D8DDEBB17ED3180A708C3B6F0212F68", hash_generated_method = "4E039481AEC54873A1C9C32873DD6977")
    
private void initialize(Context context) {
        mContext = context;
        setVisibility(GONE);
        setWillNotDraw(true);
    }

    /**
     * Returns the id taken by the inflated view. If the inflated id is
     * {@link View#NO_ID}, the inflated view keeps its original id.
     *
     * @return A positive integer used to identify the inflated view or
     *         {@link #NO_ID} if the inflated view should keep its id.
     *
     * @see #setInflatedId(int)
     * @attr ref android.R.styleable#ViewStub_inflatedId
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.948 -0500", hash_original_method = "DD261735D727F86389B5178B589BDC0E", hash_generated_method = "1A746281F6C14FA67AE838E4653C504D")
    
public int getInflatedId() {
        return mInflatedId;
    }

    /**
     * Defines the id taken by the inflated view. If the inflated id is
     * {@link View#NO_ID}, the inflated view keeps its original id.
     *
     * @param inflatedId A positive integer used to identify the inflated view or
     *                   {@link #NO_ID} if the inflated view should keep its id.
     *
     * @see #getInflatedId()
     * @attr ref android.R.styleable#ViewStub_inflatedId
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.951 -0500", hash_original_method = "86B5E29885E599B44EC441F118D9B30F", hash_generated_method = "6771EA5153BB0083E02D3D30F1195C36")
    
public void setInflatedId(int inflatedId) {
        mInflatedId = inflatedId;
    }

    /**
     * Returns the layout resource that will be used by {@link #setVisibility(int)} or
     * {@link #inflate()} to replace this StubbedView
     * in its parent by another view.
     *
     * @return The layout resource identifier used to inflate the new View.
     *
     * @see #setLayoutResource(int)
     * @see #setVisibility(int)
     * @see #inflate()
     * @attr ref android.R.styleable#ViewStub_layout
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.953 -0500", hash_original_method = "027E5859DCA96FAAAAB58CE710A8870F", hash_generated_method = "472A3EA0671274E1B92DB17D195FE7E9")
    
public int getLayoutResource() {
        return mLayoutResource;
    }

    /**
     * Specifies the layout resource to inflate when this StubbedView becomes visible or invisible
     * or when {@link #inflate()} is invoked. The View created by inflating the layout resource is
     * used to replace this StubbedView in its parent.
     * 
     * @param layoutResource A valid layout resource identifier (different from 0.)
     * 
     * @see #getLayoutResource()
     * @see #setVisibility(int)
     * @see #inflate()
     * @attr ref android.R.styleable#ViewStub_layout
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.956 -0500", hash_original_method = "9A9CDCEDF7B2E8EB813F1BBF2264D05B", hash_generated_method = "793DE6BB79704D798635B99391F89D86")
    
public void setLayoutResource(int layoutResource) {
        mLayoutResource = layoutResource;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.958 -0500", hash_original_method = "5C9393E5CC8833BE15FFC01B23AE5CB2", hash_generated_method = "E61C2DFF8918B9384F2B8810B2CF4A46")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.960 -0500", hash_original_method = "D063B9229A7B99E7AD0A562CA5051177", hash_generated_method = "B69B8EA5ED9C6C7D68A2994B2D5AAEBF")
    
@Override
    public void draw(Canvas canvas) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.963 -0500", hash_original_method = "0296ECFD4FBB578ABFB3DEE9D2F54084", hash_generated_method = "F8C5428F835DB6479F18A9FDD8AEA5EE")
    
@Override
    protected void dispatchDraw(Canvas canvas) {
    }

    /**
     * When visibility is set to {@link #VISIBLE} or {@link #INVISIBLE},
     * {@link #inflate()} is invoked and this StubbedView is replaced in its parent
     * by the inflated layout resource.
     *
     * @param visibility One of {@link #VISIBLE}, {@link #INVISIBLE}, or {@link #GONE}.
     *
     * @see #inflate() 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.965 -0500", hash_original_method = "8020455B6FCF7D6831D6E164290A9878", hash_generated_method = "D8DF3125A2A570AD87322216145036E2")
    
@Override
    public void setVisibility(int visibility) {
        if (mInflatedViewRef != null) {
            View view = mInflatedViewRef.get();
            if (view != null) {
                view.setVisibility(visibility);
            } else {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
        } else {
            super.setVisibility(visibility);
            if (visibility == VISIBLE || visibility == INVISIBLE) {
                inflate();
            }
        }
    }

    /**
     * Inflates the layout resource identified by {@link #getLayoutResource()}
     * and replaces this StubbedView in its parent by the inflated layout resource.
     *
     * @return The inflated layout resource.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.968 -0500", hash_original_method = "FA523E28924F274233340119C3A40101", hash_generated_method = "BD9E8BCBEC1864F20E904F304653A7C6")
    
public View inflate() {
        final ViewParent viewParent = getParent();

        if (viewParent != null && viewParent instanceof ViewGroup) {
            if (mLayoutResource != 0) {
                final ViewGroup parent = (ViewGroup) viewParent;
                final LayoutInflater factory = LayoutInflater.from(mContext);
                final View view = factory.inflate(mLayoutResource, parent,
                        false);

                if (mInflatedId != NO_ID) {
                    view.setId(mInflatedId);
                }

                final int index = parent.indexOfChild(this);
                parent.removeViewInLayout(this);

                final ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    parent.addView(view, index, layoutParams);
                } else {
                    parent.addView(view, index);
                }

                mInflatedViewRef = new WeakReference<View>(view);

                if (mInflateListener != null) {
                    mInflateListener.onInflate(this, view);
                }

                return view;
            } else {
                throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
            }
        } else {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
    }

    /**
     * Specifies the inflate listener to be notified after this ViewStub successfully
     * inflated its layout resource.
     *
     * @param inflateListener The OnInflateListener to notify of successful inflation.
     *
     * @see android.view.ViewStub.OnInflateListener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.971 -0500", hash_original_method = "082FDB27359F9D2A7A4CA2B124FBADFF", hash_generated_method = "EA27AF607DA3F75F5FC228A5625A1FDB")
    
public void setOnInflateListener(OnInflateListener inflateListener) {
        mInflateListener = inflateListener;
    }

    
    public static interface OnInflateListener {
        
        void onInflate(ViewStub stub, View inflated);
    }
    
}

