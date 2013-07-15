package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayAdapter<T> extends BaseAdapter implements Filterable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.441 -0400", hash_original_field = "EBF544E4173D2D8B065068D8E591BD40", hash_generated_field = "C5D6BBA40E88AD4B20810C36AB0B4200")

    private List<T> mObjects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.442 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")

    private final Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.442 -0400", hash_original_field = "513ECCC3F2175FF90ADFE90E4852BF1D", hash_generated_field = "6ED56B37E58621AEB8D63CC1C5EA1E67")

    private int mResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.442 -0400", hash_original_field = "4E551418A503FBC4B46C7DAAADA3FAEC", hash_generated_field = "605FFB4549B20BAE4E7EBD72916F9C8F")

    private int mDropDownResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.442 -0400", hash_original_field = "BB0FD1BF4E8B0289908324805EFFCBAF", hash_generated_field = "D4C9AF545A1F6103644303EF50B22F18")

    private int mFieldId = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.442 -0400", hash_original_field = "39770135A671276A8EDCF9E10B640D7D", hash_generated_field = "FE0D43348CFC831A210569F9A601B409")

    private boolean mNotifyOnChange = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.442 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.442 -0400", hash_original_field = "7E1411E28582E7BB5CB8D7EF06A96926", hash_generated_field = "D3DC3ECDE417C076679DF4CF25A2ECC3")

    private ArrayList<T> mOriginalValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.442 -0400", hash_original_field = "C781ED17A87FBE09F8079C6EC63D1F26", hash_generated_field = "A0F0365EB2712D5C3F88231E50941E9D")

    private ArrayFilter mFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.442 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.443 -0400", hash_original_method = "789F3BF67B69FD6C237A5778FFC1188F", hash_generated_method = "9F2D5759E56F73FA5A593FA701BA5C3D")
    public  ArrayAdapter(Context context, int textViewResourceId) {
        addTaint(textViewResourceId);
        addTaint(context.getTaint());
        init(context, textViewResourceId, 0, new ArrayList<T>());
        // ---------- Original Method ----------
        //init(context, textViewResourceId, 0, new ArrayList<T>());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.443 -0400", hash_original_method = "8D997C3441EFBFDB8F1974C979BCB748", hash_generated_method = "BB5F52F252315BDE0DD91C6E208DD112")
    public  ArrayAdapter(Context context, int resource, int textViewResourceId) {
        addTaint(textViewResourceId);
        addTaint(resource);
        addTaint(context.getTaint());
        init(context, resource, textViewResourceId, new ArrayList<T>());
        // ---------- Original Method ----------
        //init(context, resource, textViewResourceId, new ArrayList<T>());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.443 -0400", hash_original_method = "0DF55CD51396FFBE8E2D3620B337DDA2", hash_generated_method = "9F3552473E409CDC70C3F78CA54E2BCF")
    public  ArrayAdapter(Context context, int textViewResourceId, T[] objects) {
        addTaint(objects[0].getTaint());
        addTaint(textViewResourceId);
        addTaint(context.getTaint());
        init(context, textViewResourceId, 0, Arrays.asList(objects));
        // ---------- Original Method ----------
        //init(context, textViewResourceId, 0, Arrays.asList(objects));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.444 -0400", hash_original_method = "69F6C47A6CFAD9DAEB9B15D26A429BD2", hash_generated_method = "0AD77E38C114B56F67EBF8911FE368C0")
    public  ArrayAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
        addTaint(objects[0].getTaint());
        addTaint(textViewResourceId);
        addTaint(resource);
        addTaint(context.getTaint());
        init(context, resource, textViewResourceId, Arrays.asList(objects));
        // ---------- Original Method ----------
        //init(context, resource, textViewResourceId, Arrays.asList(objects));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.444 -0400", hash_original_method = "223AE4BB7D76AAEAE470FF2DB97AEEF6", hash_generated_method = "DD11C5A81EFE6DF4FD1647D1D1ACBC58")
    public  ArrayAdapter(Context context, int textViewResourceId, List<T> objects) {
        addTaint(objects.getTaint());
        addTaint(textViewResourceId);
        addTaint(context.getTaint());
        init(context, textViewResourceId, 0, objects);
        // ---------- Original Method ----------
        //init(context, textViewResourceId, 0, objects);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.444 -0400", hash_original_method = "25BF5070AB68B4CC94195FE94A6CDD15", hash_generated_method = "45C05D2F6900A6552B59CA1E74D9A522")
    public  ArrayAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
        addTaint(objects.getTaint());
        addTaint(textViewResourceId);
        addTaint(resource);
        addTaint(context.getTaint());
        init(context, resource, textViewResourceId, objects);
        // ---------- Original Method ----------
        //init(context, resource, textViewResourceId, objects);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.445 -0400", hash_original_method = "576CB9C40229B2A1A68C443644828160", hash_generated_method = "B1EEEF55436439C5964563B3D4F378AB")
    public void add(T object) {
        addTaint(object.getTaint());
        synchronized
(mLock)        {
    if(mOriginalValues != null)            
            {
                mOriginalValues.add(object);
            } //End block
            else
            {
                mObjects.add(object);
            } //End block
        } //End block
    if(mNotifyOnChange)        
        notifyDataSetChanged();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //if (mOriginalValues != null) {
                //mOriginalValues.add(object);
            //} else {
                //mObjects.add(object);
            //}
        //}
        //if (mNotifyOnChange) notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.445 -0400", hash_original_method = "2106A171487E5CA0624DE157360DB991", hash_generated_method = "79FA754AF55A7046C9471BCF42F16886")
    public void addAll(Collection<? extends T> collection) {
        addTaint(collection.getTaint());
        synchronized
(mLock)        {
    if(mOriginalValues != null)            
            {
                mOriginalValues.addAll(collection);
            } //End block
            else
            {
                mObjects.addAll(collection);
            } //End block
        } //End block
    if(mNotifyOnChange)        
        notifyDataSetChanged();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //if (mOriginalValues != null) {
                //mOriginalValues.addAll(collection);
            //} else {
                //mObjects.addAll(collection);
            //}
        //}
        //if (mNotifyOnChange) notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.446 -0400", hash_original_method = "0FB4566239B43452682D3C6768E6D3AE", hash_generated_method = "F42D037C8C7AD0C6C7A4391992090E1D")
    public void addAll(T ... items) {
        addTaint(items[0].getTaint());
        synchronized
(mLock)        {
    if(mOriginalValues != null)            
            {
                Collections.addAll(mOriginalValues, items);
            } //End block
            else
            {
                Collections.addAll(mObjects, items);
            } //End block
        } //End block
    if(mNotifyOnChange)        
        notifyDataSetChanged();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //if (mOriginalValues != null) {
                //Collections.addAll(mOriginalValues, items);
            //} else {
                //Collections.addAll(mObjects, items);
            //}
        //}
        //if (mNotifyOnChange) notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.446 -0400", hash_original_method = "E6733B2C388AB0385CFE6D2E53E92DC8", hash_generated_method = "C3B7E909806CA2AF41449C8A9AB2A7EE")
    public void insert(T object, int index) {
        addTaint(index);
        addTaint(object.getTaint());
        synchronized
(mLock)        {
    if(mOriginalValues != null)            
            {
                mOriginalValues.add(index, object);
            } //End block
            else
            {
                mObjects.add(index, object);
            } //End block
        } //End block
    if(mNotifyOnChange)        
        notifyDataSetChanged();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //if (mOriginalValues != null) {
                //mOriginalValues.add(index, object);
            //} else {
                //mObjects.add(index, object);
            //}
        //}
        //if (mNotifyOnChange) notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.446 -0400", hash_original_method = "6A184D6E0EB34E61EA380878C12E3D42", hash_generated_method = "45D17E6A0AF764C0FD5FF96FC91D8B9D")
    public void remove(T object) {
        addTaint(object.getTaint());
        synchronized
(mLock)        {
    if(mOriginalValues != null)            
            {
                mOriginalValues.remove(object);
            } //End block
            else
            {
                mObjects.remove(object);
            } //End block
        } //End block
    if(mNotifyOnChange)        
        notifyDataSetChanged();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //if (mOriginalValues != null) {
                //mOriginalValues.remove(object);
            //} else {
                //mObjects.remove(object);
            //}
        //}
        //if (mNotifyOnChange) notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.447 -0400", hash_original_method = "E80E28672DD45A1486192C70E40EF7F5", hash_generated_method = "C4F1F91442599AE68F832F75FB6037BB")
    public void clear() {
        synchronized
(mLock)        {
    if(mOriginalValues != null)            
            {
                mOriginalValues.clear();
            } //End block
            else
            {
                mObjects.clear();
            } //End block
        } //End block
    if(mNotifyOnChange)        
        notifyDataSetChanged();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //if (mOriginalValues != null) {
                //mOriginalValues.clear();
            //} else {
                //mObjects.clear();
            //}
        //}
        //if (mNotifyOnChange) notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.447 -0400", hash_original_method = "56420943E8AF9990310F4859FACB8646", hash_generated_method = "3DA380F8887A0573D7C23BFEE52E0CDB")
    public void sort(Comparator<? super T> comparator) {
        addTaint(comparator.getTaint());
        synchronized
(mLock)        {
    if(mOriginalValues != null)            
            {
                Collections.sort(mOriginalValues, comparator);
            } //End block
            else
            {
                Collections.sort(mObjects, comparator);
            } //End block
        } //End block
    if(mNotifyOnChange)        
        notifyDataSetChanged();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //if (mOriginalValues != null) {
                //Collections.sort(mOriginalValues, comparator);
            //} else {
                //Collections.sort(mObjects, comparator);
            //}
        //}
        //if (mNotifyOnChange) notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.448 -0400", hash_original_method = "4B6963AC4824E23107C3535DF32052A8", hash_generated_method = "B498C1B15F4E1C97F48F52763590B81C")
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        mNotifyOnChange = true;
        // ---------- Original Method ----------
        //super.notifyDataSetChanged();
        //mNotifyOnChange = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.448 -0400", hash_original_method = "B014C1A32626DBADC83EC827393C5854", hash_generated_method = "DF16B68FF23EAD56FA4255B3D48770B3")
    public void setNotifyOnChange(boolean notifyOnChange) {
        mNotifyOnChange = notifyOnChange;
        // ---------- Original Method ----------
        //mNotifyOnChange = notifyOnChange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.449 -0400", hash_original_method = "0AB52E86A6B570420A2DD21D48564743", hash_generated_method = "2E9BCD700482CBFCE630F7DA8D860DD7")
    private void init(Context context, int resource, int textViewResourceId, List<T> objects) {
        mContext = context;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mResource = mDropDownResource = resource;
        mObjects = objects;
        mFieldId = textViewResourceId;
        // ---------- Original Method ----------
        //mContext = context;
        //mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //mResource = mDropDownResource = resource;
        //mObjects = objects;
        //mFieldId = textViewResourceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.449 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "9CECD4A406E27DE4B90900C54A8A7CCB")
    public Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_102176101 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_102176101.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_102176101;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.450 -0400", hash_original_method = "4A653ADD34C98191FCFB37B57CB3ED83", hash_generated_method = "F79DC104F6A51DFC774F52823CFC3365")
    public int getCount() {
        int var44E774A130391DD13FA0C3E1F798FA8F_242329734 = (mObjects.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181074576 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181074576;
        // ---------- Original Method ----------
        //return mObjects.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.450 -0400", hash_original_method = "88739C4EC6C6A6692FBDE51909D97703", hash_generated_method = "BCBAE3D39376EF59F6DE9869E62D5BDA")
    public T getItem(int position) {
        addTaint(position);
T var764B6AF9DF92D219D9605835E00EC09F_160918835 =         mObjects.get(position);
        var764B6AF9DF92D219D9605835E00EC09F_160918835.addTaint(taint);
        return var764B6AF9DF92D219D9605835E00EC09F_160918835;
        // ---------- Original Method ----------
        //return mObjects.get(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.450 -0400", hash_original_method = "4B52B65CCBAD37C22D6FCF1BE4A30381", hash_generated_method = "9C1DB788D6368C5CF348C58850BBF2F3")
    public int getPosition(T item) {
        addTaint(item.getTaint());
        int varDFBE5BD03266E32EAAAEB8FB3F55CCB4_679431139 = (mObjects.indexOf(item));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_626313566 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_626313566;
        // ---------- Original Method ----------
        //return mObjects.indexOf(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.451 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "8D1110A83D59CD0F6F81FBAF210DA5FC")
    public long getItemId(int position) {
        addTaint(position);
        long var4757FE07FD492A8BE0EA6A760D683D6E_2132326737 = (position);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1774496650 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1774496650;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.451 -0400", hash_original_method = "180EEF863853B86A02E5E476168E516D", hash_generated_method = "574D767BB66F86CCFB78A07ECC874138")
    public View getView(int position, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(position);
View varC7C74D1A1F888482D2EEA96BBD632B6B_308821408 =         createViewFromResource(position, convertView, parent, mResource);
        varC7C74D1A1F888482D2EEA96BBD632B6B_308821408.addTaint(taint);
        return varC7C74D1A1F888482D2EEA96BBD632B6B_308821408;
        // ---------- Original Method ----------
        //return createViewFromResource(position, convertView, parent, mResource);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.453 -0400", hash_original_method = "86812A0CF4501D7696F9CF0CE2E4D2EB", hash_generated_method = "9E29EFF1FBD40D23D91113C5B826F181")
    private View createViewFromResource(int position, View convertView, ViewGroup parent,
            int resource) {
        addTaint(resource);
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(position);
        View view;
        TextView text;
    if(convertView == null)        
        {
            view = mInflater.inflate(resource, parent, false);
        } //End block
        else
        {
            view = convertView;
        } //End block
        try 
        {
    if(mFieldId == 0)            
            {
                text = (TextView) view;
            } //End block
            else
            {
                text = (TextView) view.findViewById(mFieldId);
            } //End block
        } //End block
        catch (ClassCastException e)
        {
            IllegalStateException var462FBD2CDEE1AF0647B8C952849FC1E5_1747396043 = new IllegalStateException(
                    "ArrayAdapter requires the resource ID to be a TextView", e);
            var462FBD2CDEE1AF0647B8C952849FC1E5_1747396043.addTaint(taint);
            throw var462FBD2CDEE1AF0647B8C952849FC1E5_1747396043;
        } //End block
        T item = getItem(position);
    if(item instanceof CharSequence)        
        {
            text.setText((CharSequence)item);
        } //End block
        else
        {
            text.setText(item.toString());
        } //End block
View var057D265746AE9672AFE5F9FF6338071D_723460512 =         view;
        var057D265746AE9672AFE5F9FF6338071D_723460512.addTaint(taint);
        return var057D265746AE9672AFE5F9FF6338071D_723460512;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.454 -0400", hash_original_method = "614355FA33E2A17CA6280A34FDBFFDC0", hash_generated_method = "166D468151E808B5172814612FD9B5A0")
    public void setDropDownViewResource(int resource) {
        this.mDropDownResource = resource;
        // ---------- Original Method ----------
        //this.mDropDownResource = resource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.454 -0400", hash_original_method = "55A24C3FF57565648C18AD1B34A1D191", hash_generated_method = "04D1BC27A95BEE5D080D847562758ABA")
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(position);
View var73BABEDDC942C821B8059F08E1C361F2_1938515674 =         createViewFromResource(position, convertView, parent, mDropDownResource);
        var73BABEDDC942C821B8059F08E1C361F2_1938515674.addTaint(taint);
        return var73BABEDDC942C821B8059F08E1C361F2_1938515674;
        // ---------- Original Method ----------
        //return createViewFromResource(position, convertView, parent, mDropDownResource);
    }

    
        public static ArrayAdapter<CharSequence> createFromResource(Context context,
            int textArrayResId, int textViewResId) {
        CharSequence[] strings = context.getResources().getTextArray(textArrayResId);
        return new ArrayAdapter<CharSequence>(context, textViewResId, strings);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.455 -0400", hash_original_method = "93D8CD6E71E9F9D3F84ACCA40E0F811C", hash_generated_method = "11AD9FC27B3BC6BC739EF3D671004810")
    public Filter getFilter() {
    if(mFilter == null)        
        {
            mFilter = new ArrayFilter();
        } //End block
Filter var6104E4BD549FCD2640641D136DD683A6_1488121355 =         mFilter;
        var6104E4BD549FCD2640641D136DD683A6_1488121355.addTaint(taint);
        return var6104E4BD549FCD2640641D136DD683A6_1488121355;
        // ---------- Original Method ----------
        //if (mFilter == null) {
            //mFilter = new ArrayFilter();
        //}
        //return mFilter;
    }

    
    private class ArrayFilter extends Filter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.455 -0400", hash_original_method = "1D9325EC6EFFDE6F3FA421C05C5C6F5E", hash_generated_method = "1D9325EC6EFFDE6F3FA421C05C5C6F5E")
        public ArrayFilter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.456 -0400", hash_original_method = "FCA1EE8188101C684A4D4FE1495B8102", hash_generated_method = "DE6B167B4964E349A0CFB4095B7E8DC1")
        @Override
        protected FilterResults performFiltering(CharSequence prefix) {
            addTaint(prefix.getTaint());
            FilterResults results = new FilterResults();
    if(mOriginalValues == null)            
            {
                synchronized
(mLock)                {
                    mOriginalValues = new ArrayList<T>(mObjects);
                } //End block
            } //End block
    if(prefix == null || prefix.length() == 0)            
            {
                ArrayList<T> list;
                synchronized
(mLock)                {
                    list = new ArrayList<T>(mOriginalValues);
                } //End block
                results.values = list;
                results.count = list.size();
            } //End block
            else
            {
                String prefixString = prefix.toString().toLowerCase();
                ArrayList<T> values;
                synchronized
(mLock)                {
                    values = new ArrayList<T>(mOriginalValues);
                } //End block
                final int count = values.size();
                final ArrayList<T> newValues = new ArrayList<T>();
for(int i = 0;i < count;i++)
                {
                    final T value = values.get(i);
                    final String valueText = value.toString().toLowerCase();
    if(valueText.startsWith(prefixString))                    
                    {
                        newValues.add(value);
                    } //End block
                    else
                    {
                        final String[] words = valueText.split(" ");
                        final int wordCount = words.length;
for(int k = 0;k < wordCount;k++)
                        {
    if(words[k].startsWith(prefixString))                            
                            {
                                newValues.add(value);
                                break;
                            } //End block
                        } //End block
                    } //End block
                } //End block
                results.values = newValues;
                results.count = newValues.size();
            } //End block
FilterResults var238ECCC9872FFCA0B3C3DB83598FF044_93833358 =             results;
            var238ECCC9872FFCA0B3C3DB83598FF044_93833358.addTaint(taint);
            return var238ECCC9872FFCA0B3C3DB83598FF044_93833358;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.456 -0400", hash_original_method = "109574F1A4050F52746E85DE95C85548", hash_generated_method = "5B6F78F6A02E7BD8ACA6B8A140F40B21")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            addTaint(results.getTaint());
            addTaint(constraint.getTaint());
            mObjects = (List<T>) results.values;
    if(results.count > 0)            
            {
                notifyDataSetChanged();
            } //End block
            else
            {
                notifyDataSetInvalidated();
            } //End block
            // ---------- Original Method ----------
            //mObjects = (List<T>) results.values;
            //if (results.count > 0) {
                //notifyDataSetChanged();
            //} else {
                //notifyDataSetInvalidated();
            //}
        }

        
    }


    
}

