package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.846 -0400", hash_original_field = "EBF544E4173D2D8B065068D8E591BD40", hash_generated_field = "C5D6BBA40E88AD4B20810C36AB0B4200")

    private List<T> mObjects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.846 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")

    private final Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.846 -0400", hash_original_field = "513ECCC3F2175FF90ADFE90E4852BF1D", hash_generated_field = "6ED56B37E58621AEB8D63CC1C5EA1E67")

    private int mResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.846 -0400", hash_original_field = "4E551418A503FBC4B46C7DAAADA3FAEC", hash_generated_field = "605FFB4549B20BAE4E7EBD72916F9C8F")

    private int mDropDownResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.846 -0400", hash_original_field = "BB0FD1BF4E8B0289908324805EFFCBAF", hash_generated_field = "D4C9AF545A1F6103644303EF50B22F18")

    private int mFieldId = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.846 -0400", hash_original_field = "39770135A671276A8EDCF9E10B640D7D", hash_generated_field = "FE0D43348CFC831A210569F9A601B409")

    private boolean mNotifyOnChange = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.846 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.846 -0400", hash_original_field = "7E1411E28582E7BB5CB8D7EF06A96926", hash_generated_field = "D3DC3ECDE417C076679DF4CF25A2ECC3")

    private ArrayList<T> mOriginalValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.846 -0400", hash_original_field = "C781ED17A87FBE09F8079C6EC63D1F26", hash_generated_field = "A0F0365EB2712D5C3F88231E50941E9D")

    private ArrayFilter mFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.846 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.846 -0400", hash_original_method = "789F3BF67B69FD6C237A5778FFC1188F", hash_generated_method = "5339F759B567E344C6360CC18D6F29D4")
    public  ArrayAdapter(Context context, int textViewResourceId) {
        init(context, textViewResourceId, 0, new ArrayList<T>());
        addTaint(context.getTaint());
        addTaint(textViewResourceId);
        // ---------- Original Method ----------
        //init(context, textViewResourceId, 0, new ArrayList<T>());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.847 -0400", hash_original_method = "8D997C3441EFBFDB8F1974C979BCB748", hash_generated_method = "208346FF4C5EF343977F36A9D1952D2C")
    public  ArrayAdapter(Context context, int resource, int textViewResourceId) {
        init(context, resource, textViewResourceId, new ArrayList<T>());
        addTaint(context.getTaint());
        addTaint(resource);
        addTaint(textViewResourceId);
        // ---------- Original Method ----------
        //init(context, resource, textViewResourceId, new ArrayList<T>());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.847 -0400", hash_original_method = "0DF55CD51396FFBE8E2D3620B337DDA2", hash_generated_method = "955FD578659949341F1DD777876CCEBD")
    public  ArrayAdapter(Context context, int textViewResourceId, T[] objects) {
        init(context, textViewResourceId, 0, Arrays.asList(objects));
        addTaint(context.getTaint());
        addTaint(textViewResourceId);
        addTaint(objects[0].getTaint());
        // ---------- Original Method ----------
        //init(context, textViewResourceId, 0, Arrays.asList(objects));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.847 -0400", hash_original_method = "69F6C47A6CFAD9DAEB9B15D26A429BD2", hash_generated_method = "C0DEAD7315A497B6DBF8BDF12B3352D3")
    public  ArrayAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
        init(context, resource, textViewResourceId, Arrays.asList(objects));
        addTaint(context.getTaint());
        addTaint(resource);
        addTaint(textViewResourceId);
        addTaint(objects[0].getTaint());
        // ---------- Original Method ----------
        //init(context, resource, textViewResourceId, Arrays.asList(objects));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.847 -0400", hash_original_method = "223AE4BB7D76AAEAE470FF2DB97AEEF6", hash_generated_method = "860C4E8E321CAB2DBA2573635A0C0E13")
    public  ArrayAdapter(Context context, int textViewResourceId, List<T> objects) {
        init(context, textViewResourceId, 0, objects);
        addTaint(context.getTaint());
        addTaint(textViewResourceId);
        addTaint(objects.getTaint());
        // ---------- Original Method ----------
        //init(context, textViewResourceId, 0, objects);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.847 -0400", hash_original_method = "25BF5070AB68B4CC94195FE94A6CDD15", hash_generated_method = "4786F4DB480C4875E44E463550E1FCC9")
    public  ArrayAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
        init(context, resource, textViewResourceId, objects);
        addTaint(context.getTaint());
        addTaint(resource);
        addTaint(textViewResourceId);
        addTaint(objects.getTaint());
        // ---------- Original Method ----------
        //init(context, resource, textViewResourceId, objects);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.848 -0400", hash_original_method = "576CB9C40229B2A1A68C443644828160", hash_generated_method = "8CDA1AC8044C317C7FED82724EC47E36")
    public void add(T object) {
        {
            {
                mOriginalValues.add(object);
            } //End block
            {
                mObjects.add(object);
            } //End block
        } //End block
        notifyDataSetChanged();
        addTaint(object.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.848 -0400", hash_original_method = "2106A171487E5CA0624DE157360DB991", hash_generated_method = "CF98F411F6285DDABB58FF08AC251254")
    public void addAll(Collection<? extends T> collection) {
        {
            {
                mOriginalValues.addAll(collection);
            } //End block
            {
                mObjects.addAll(collection);
            } //End block
        } //End block
        notifyDataSetChanged();
        addTaint(collection.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.848 -0400", hash_original_method = "0FB4566239B43452682D3C6768E6D3AE", hash_generated_method = "E56FBEBA6DC79C25271EF392D862B306")
    public void addAll(T ... items) {
        {
            {
                Collections.addAll(mOriginalValues, items);
            } //End block
            {
                Collections.addAll(mObjects, items);
            } //End block
        } //End block
        notifyDataSetChanged();
        addTaint(items[0].getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.849 -0400", hash_original_method = "E6733B2C388AB0385CFE6D2E53E92DC8", hash_generated_method = "9615234190F7120EC8E7DBAD9DFB581B")
    public void insert(T object, int index) {
        {
            {
                mOriginalValues.add(index, object);
            } //End block
            {
                mObjects.add(index, object);
            } //End block
        } //End block
        notifyDataSetChanged();
        addTaint(object.getTaint());
        addTaint(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.849 -0400", hash_original_method = "6A184D6E0EB34E61EA380878C12E3D42", hash_generated_method = "2AA98E3C5E5CBD374AEDEEFA87F2631C")
    public void remove(T object) {
        {
            {
                mOriginalValues.remove(object);
            } //End block
            {
                mObjects.remove(object);
            } //End block
        } //End block
        notifyDataSetChanged();
        addTaint(object.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.850 -0400", hash_original_method = "E80E28672DD45A1486192C70E40EF7F5", hash_generated_method = "D0EE9DB86B4184AD54D74223A6563EBD")
    public void clear() {
        {
            {
                mOriginalValues.clear();
            } //End block
            {
                mObjects.clear();
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.850 -0400", hash_original_method = "56420943E8AF9990310F4859FACB8646", hash_generated_method = "A672839546E7A7C943E3A0A2FD28A1E1")
    public void sort(Comparator<? super T> comparator) {
        {
            {
                Collections.sort(mOriginalValues, comparator);
            } //End block
            {
                Collections.sort(mObjects, comparator);
            } //End block
        } //End block
        notifyDataSetChanged();
        addTaint(comparator.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.851 -0400", hash_original_method = "4B6963AC4824E23107C3535DF32052A8", hash_generated_method = "B498C1B15F4E1C97F48F52763590B81C")
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        mNotifyOnChange = true;
        // ---------- Original Method ----------
        //super.notifyDataSetChanged();
        //mNotifyOnChange = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.851 -0400", hash_original_method = "B014C1A32626DBADC83EC827393C5854", hash_generated_method = "DF16B68FF23EAD56FA4255B3D48770B3")
    public void setNotifyOnChange(boolean notifyOnChange) {
        mNotifyOnChange = notifyOnChange;
        // ---------- Original Method ----------
        //mNotifyOnChange = notifyOnChange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.851 -0400", hash_original_method = "0AB52E86A6B570420A2DD21D48564743", hash_generated_method = "2E9BCD700482CBFCE630F7DA8D860DD7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.852 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "D924872DDDDEBEFD12E5AC3AE981E104")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_696610950 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_696610950 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_696610950.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_696610950;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.852 -0400", hash_original_method = "4A653ADD34C98191FCFB37B57CB3ED83", hash_generated_method = "E13CF1D2110DFDBD8831C33486690AC5")
    public int getCount() {
        int var5ADE4B4DEF5A0C302073793E67A9CF7D_161264112 = (mObjects.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878316142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878316142;
        // ---------- Original Method ----------
        //return mObjects.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.853 -0400", hash_original_method = "88739C4EC6C6A6692FBDE51909D97703", hash_generated_method = "E7EC6C84E1CFEA6FC1F7B16FD7D08887")
    public T getItem(int position) {
        T varB4EAC82CA7396A68D541C85D26508E83_370810023 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_370810023 = mObjects.get(position);
        addTaint(position);
        varB4EAC82CA7396A68D541C85D26508E83_370810023.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_370810023;
        // ---------- Original Method ----------
        //return mObjects.get(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.853 -0400", hash_original_method = "4B52B65CCBAD37C22D6FCF1BE4A30381", hash_generated_method = "081F6D8C55893622F1E10ECD2BFC6375")
    public int getPosition(T item) {
        int varD5AAEE2CF798CCCE08D67049B6E97450_273042463 = (mObjects.indexOf(item));
        addTaint(item.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1641790899 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1641790899;
        // ---------- Original Method ----------
        //return mObjects.indexOf(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.854 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "3FAA52821ABF959A3414CE6BB097D52B")
    public long getItemId(int position) {
        addTaint(position);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1870557709 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1870557709;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.854 -0400", hash_original_method = "180EEF863853B86A02E5E476168E516D", hash_generated_method = "7CE93F0234EDC8521B867B7987A515C9")
    public View getView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_1513037275 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1513037275 = createViewFromResource(position, convertView, parent, mResource);
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1513037275.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1513037275;
        // ---------- Original Method ----------
        //return createViewFromResource(position, convertView, parent, mResource);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.855 -0400", hash_original_method = "86812A0CF4501D7696F9CF0CE2E4D2EB", hash_generated_method = "F804D9ED17DD3ECD41338AAD71A7D5BF")
    private View createViewFromResource(int position, View convertView, ViewGroup parent,
            int resource) {
        View varB4EAC82CA7396A68D541C85D26508E83_105404536 = null; //Variable for return #1
        View view;
        TextView text;
        {
            view = mInflater.inflate(resource, parent, false);
        } //End block
        {
            view = convertView;
        } //End block
        try 
        {
            {
                text = (TextView) view;
            } //End block
            {
                text = (TextView) view.findViewById(mFieldId);
            } //End block
        } //End block
        catch (ClassCastException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "ArrayAdapter requires the resource ID to be a TextView", e);
        } //End block
        T item = getItem(position);
        {
            text.setText((CharSequence)item);
        } //End block
        {
            text.setText(item.toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_105404536 = view;
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        addTaint(resource);
        varB4EAC82CA7396A68D541C85D26508E83_105404536.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_105404536;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.855 -0400", hash_original_method = "614355FA33E2A17CA6280A34FDBFFDC0", hash_generated_method = "166D468151E808B5172814612FD9B5A0")
    public void setDropDownViewResource(int resource) {
        this.mDropDownResource = resource;
        // ---------- Original Method ----------
        //this.mDropDownResource = resource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.855 -0400", hash_original_method = "55A24C3FF57565648C18AD1B34A1D191", hash_generated_method = "E521F6D6DE2DA46F4F7EE258A0C2A986")
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_1880750599 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1880750599 = createViewFromResource(position, convertView, parent, mDropDownResource);
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1880750599.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1880750599;
        // ---------- Original Method ----------
        //return createViewFromResource(position, convertView, parent, mDropDownResource);
    }

    
    public static ArrayAdapter<CharSequence> createFromResource(Context context,
            int textArrayResId, int textViewResId) {
        CharSequence[] strings = context.getResources().getTextArray(textArrayResId);
        return new ArrayAdapter<CharSequence>(context, textViewResId, strings);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.856 -0400", hash_original_method = "93D8CD6E71E9F9D3F84ACCA40E0F811C", hash_generated_method = "95649663C9141E15E358193B5EEADF4F")
    public Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_1129769465 = null; //Variable for return #1
        {
            mFilter = new ArrayFilter();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1129769465 = mFilter;
        varB4EAC82CA7396A68D541C85D26508E83_1129769465.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1129769465;
        // ---------- Original Method ----------
        //if (mFilter == null) {
            //mFilter = new ArrayFilter();
        //}
        //return mFilter;
    }

    
    private class ArrayFilter extends Filter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.856 -0400", hash_original_method = "1D9325EC6EFFDE6F3FA421C05C5C6F5E", hash_generated_method = "1D9325EC6EFFDE6F3FA421C05C5C6F5E")
        public ArrayFilter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.857 -0400", hash_original_method = "FCA1EE8188101C684A4D4FE1495B8102", hash_generated_method = "ACDA61A9ED7865746B45FB01B2BBF251")
        @Override
        protected FilterResults performFiltering(CharSequence prefix) {
            FilterResults varB4EAC82CA7396A68D541C85D26508E83_126943164 = null; //Variable for return #1
            FilterResults results = new FilterResults();
            {
                {
                    mOriginalValues = new ArrayList<T>(mObjects);
                } //End block
            } //End block
            {
                boolean varC2A2CF8A9676195B62AC39EAB2DC8746_2044080742 = (prefix == null || prefix.length() == 0);
                {
                    ArrayList<T> list;
                    {
                        list = new ArrayList<T>(mOriginalValues);
                    } //End block
                    results.values = list;
                    results.count = list.size();
                } //End block
                {
                    String prefixString = prefix.toString().toLowerCase();
                    ArrayList<T> values;
                    {
                        values = new ArrayList<T>(mOriginalValues);
                    } //End block
                    final int count = values.size();
                    final ArrayList<T> newValues = new ArrayList<T>();
                    {
                        int i = 0;
                        {
                            final T value = values.get(i);
                            final String valueText = value.toString().toLowerCase();
                            {
                                boolean varC74DE7BC36FAC7675733A0D7891E756D_1126260726 = (valueText.startsWith(prefixString));
                                {
                                    newValues.add(value);
                                } //End block
                                {
                                    final String[] words = valueText.split(" ");
                                    final int wordCount = words.length;
                                    {
                                        int k = 0;
                                        {
                                            {
                                                boolean var9D40720128ABFAE9C601988D1E59EBD5_1413658440 = (words[k].startsWith(prefixString));
                                                {
                                                    newValues.add(value);
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    results.values = newValues;
                    results.count = newValues.size();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_126943164 = results;
            addTaint(prefix.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_126943164.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_126943164;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.858 -0400", hash_original_method = "109574F1A4050F52746E85DE95C85548", hash_generated_method = "BBDFD82DA2894E8E053DE505642A7414")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mObjects = (List<T>) results.values;
            {
                notifyDataSetChanged();
            } //End block
            {
                notifyDataSetInvalidated();
            } //End block
            addTaint(constraint.getTaint());
            addTaint(results.getTaint());
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

