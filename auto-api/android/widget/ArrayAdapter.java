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
    private List<T> mObjects;
    private Object mLock = new Object();
    private int mResource;
    private int mDropDownResource;
    private int mFieldId = 0;
    private boolean mNotifyOnChange = true;
    private Context mContext;
    private ArrayList<T> mOriginalValues;
    private ArrayFilter mFilter;
    private LayoutInflater mInflater;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.270 -0400", hash_original_method = "789F3BF67B69FD6C237A5778FFC1188F", hash_generated_method = "E0A3039B87A888BC868A2F6820BDFEB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayAdapter(Context context, int textViewResourceId) {
        dsTaint.addTaint(textViewResourceId);
        dsTaint.addTaint(context.dsTaint);
        init(context, textViewResourceId, 0, new ArrayList<T>());
        // ---------- Original Method ----------
        //init(context, textViewResourceId, 0, new ArrayList<T>());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.270 -0400", hash_original_method = "8D997C3441EFBFDB8F1974C979BCB748", hash_generated_method = "1D428A41B04D6B1F462385777E79119A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayAdapter(Context context, int resource, int textViewResourceId) {
        dsTaint.addTaint(textViewResourceId);
        dsTaint.addTaint(resource);
        dsTaint.addTaint(context.dsTaint);
        init(context, resource, textViewResourceId, new ArrayList<T>());
        // ---------- Original Method ----------
        //init(context, resource, textViewResourceId, new ArrayList<T>());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.271 -0400", hash_original_method = "0DF55CD51396FFBE8E2D3620B337DDA2", hash_generated_method = "6DF26D9EAE2996E8F6D3AB57DC21CBF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayAdapter(Context context, int textViewResourceId, T[] objects) {
        dsTaint.addTaint(textViewResourceId);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(objects[0].dsTaint);
        init(context, textViewResourceId, 0, Arrays.asList(objects));
        // ---------- Original Method ----------
        //init(context, textViewResourceId, 0, Arrays.asList(objects));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.271 -0400", hash_original_method = "69F6C47A6CFAD9DAEB9B15D26A429BD2", hash_generated_method = "2211E17CF3FCAAE4507C83BF4C88A865")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
        dsTaint.addTaint(textViewResourceId);
        dsTaint.addTaint(resource);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(objects[0].dsTaint);
        init(context, resource, textViewResourceId, Arrays.asList(objects));
        // ---------- Original Method ----------
        //init(context, resource, textViewResourceId, Arrays.asList(objects));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.271 -0400", hash_original_method = "223AE4BB7D76AAEAE470FF2DB97AEEF6", hash_generated_method = "177E71A11DBDAFC3ED5EBFD38D9C45E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayAdapter(Context context, int textViewResourceId, List<T> objects) {
        dsTaint.addTaint(textViewResourceId);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(objects.dsTaint);
        init(context, textViewResourceId, 0, objects);
        // ---------- Original Method ----------
        //init(context, textViewResourceId, 0, objects);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.271 -0400", hash_original_method = "25BF5070AB68B4CC94195FE94A6CDD15", hash_generated_method = "7421F5CF7225E11E991B437451CCBE62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
        dsTaint.addTaint(textViewResourceId);
        dsTaint.addTaint(resource);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(objects.dsTaint);
        init(context, resource, textViewResourceId, objects);
        // ---------- Original Method ----------
        //init(context, resource, textViewResourceId, objects);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.271 -0400", hash_original_method = "576CB9C40229B2A1A68C443644828160", hash_generated_method = "B254EB887DDFDBE37BF47AA00DA0BEC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void add(T object) {
        dsTaint.addTaint(object.dsTaint);
        {
            {
                mOriginalValues.add(object);
            } //End block
            {
                mObjects.add(object);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.272 -0400", hash_original_method = "2106A171487E5CA0624DE157360DB991", hash_generated_method = "E5AD9E6948855E22FED2237D6BD1E51A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addAll(Collection<? extends T> collection) {
        dsTaint.addTaint(collection.dsTaint);
        {
            {
                mOriginalValues.addAll(collection);
            } //End block
            {
                mObjects.addAll(collection);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.272 -0400", hash_original_method = "0FB4566239B43452682D3C6768E6D3AE", hash_generated_method = "81C86894E25FE3762F9C2989293C5317")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addAll(T ... items) {
        dsTaint.addTaint(items[0].dsTaint);
        {
            {
                Collections.addAll(mOriginalValues, items);
            } //End block
            {
                Collections.addAll(mObjects, items);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.272 -0400", hash_original_method = "E6733B2C388AB0385CFE6D2E53E92DC8", hash_generated_method = "7F6C245B22123D358097B03EBCFBDC1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void insert(T object, int index) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(object.dsTaint);
        {
            {
                mOriginalValues.add(index, object);
            } //End block
            {
                mObjects.add(index, object);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.272 -0400", hash_original_method = "6A184D6E0EB34E61EA380878C12E3D42", hash_generated_method = "1E6001E649EFF61005C196980787265D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void remove(T object) {
        dsTaint.addTaint(object.dsTaint);
        {
            {
                mOriginalValues.remove(object);
            } //End block
            {
                mObjects.remove(object);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.273 -0400", hash_original_method = "E80E28672DD45A1486192C70E40EF7F5", hash_generated_method = "D0EE9DB86B4184AD54D74223A6563EBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.273 -0400", hash_original_method = "56420943E8AF9990310F4859FACB8646", hash_generated_method = "06850C8AF58D240676E71B0B2EB7F15D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sort(Comparator<? super T> comparator) {
        dsTaint.addTaint(comparator.dsTaint);
        {
            {
                Collections.sort(mOriginalValues, comparator);
            } //End block
            {
                Collections.sort(mObjects, comparator);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.273 -0400", hash_original_method = "4B6963AC4824E23107C3535DF32052A8", hash_generated_method = "B498C1B15F4E1C97F48F52763590B81C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        mNotifyOnChange = true;
        // ---------- Original Method ----------
        //super.notifyDataSetChanged();
        //mNotifyOnChange = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.274 -0400", hash_original_method = "B014C1A32626DBADC83EC827393C5854", hash_generated_method = "5A7AAA1E8E8A1ADDDA24BF901E930714")
    @DSModeled(DSC.SAFE)
    public void setNotifyOnChange(boolean notifyOnChange) {
        dsTaint.addTaint(notifyOnChange);
        // ---------- Original Method ----------
        //mNotifyOnChange = notifyOnChange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.274 -0400", hash_original_method = "0AB52E86A6B570420A2DD21D48564743", hash_generated_method = "D19DD457FB514A9CBD7D121F06EE3660")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(Context context, int resource, int textViewResourceId, List<T> objects) {
        dsTaint.addTaint(textViewResourceId);
        dsTaint.addTaint(resource);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(objects.dsTaint);
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mResource = mDropDownResource = resource;
        // ---------- Original Method ----------
        //mContext = context;
        //mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //mResource = mDropDownResource = resource;
        //mObjects = objects;
        //mFieldId = textViewResourceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.274 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "DFA42A6C39C27C217BA4B1F8A6817BD5")
    @DSModeled(DSC.SAFE)
    public Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.274 -0400", hash_original_method = "4A653ADD34C98191FCFB37B57CB3ED83", hash_generated_method = "D093F737DE0A10BCE562ED6235DE2920")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCount() {
        int var5ADE4B4DEF5A0C302073793E67A9CF7D_1162062985 = (mObjects.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mObjects.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.275 -0400", hash_original_method = "88739C4EC6C6A6692FBDE51909D97703", hash_generated_method = "B2C7620DE9FCCEE25BF9103A8D549293")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public T getItem(int position) {
        dsTaint.addTaint(position);
        T var543EEB610DC74386B0ACAC0C11A20DD4_1552151026 = (mObjects.get(position));
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mObjects.get(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.275 -0400", hash_original_method = "4B52B65CCBAD37C22D6FCF1BE4A30381", hash_generated_method = "EABAF7E46F4CBD403BB32005A60A2DC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPosition(T item) {
        dsTaint.addTaint(item.dsTaint);
        int varD5AAEE2CF798CCCE08D67049B6E97450_829940763 = (mObjects.indexOf(item));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mObjects.indexOf(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.275 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "AA5DF335B2BC02EEAA6ECE822AE11A88")
    @DSModeled(DSC.SAFE)
    public long getItemId(int position) {
        dsTaint.addTaint(position);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.275 -0400", hash_original_method = "180EEF863853B86A02E5E476168E516D", hash_generated_method = "D6D4B7C803BB873A9CD43A73F6710479")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getView(int position, View convertView, ViewGroup parent) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
        View var1D4B27E24C6D471FAD6504E7C2A036BF_208818094 = (createViewFromResource(position, convertView, parent, mResource));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return createViewFromResource(position, convertView, parent, mResource);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.276 -0400", hash_original_method = "86812A0CF4501D7696F9CF0CE2E4D2EB", hash_generated_method = "ADF4CCCEA7054CBB8FBD89E438FDC3D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View createViewFromResource(int position, View convertView, ViewGroup parent,
            int resource) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(resource);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
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
        T item;
        item = getItem(position);
        {
            text.setText((CharSequence)item);
        } //End block
        {
            text.setText(item.toString());
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.276 -0400", hash_original_method = "614355FA33E2A17CA6280A34FDBFFDC0", hash_generated_method = "7FE708B12E1446E2E68CB984DD912751")
    @DSModeled(DSC.SAFE)
    public void setDropDownViewResource(int resource) {
        dsTaint.addTaint(resource);
        // ---------- Original Method ----------
        //this.mDropDownResource = resource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.276 -0400", hash_original_method = "55A24C3FF57565648C18AD1B34A1D191", hash_generated_method = "4184CDACC1D61BA9BF313F04CB9B2DBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
        View var61C6E6B1526637B5811D151D53ADF284_87066794 = (createViewFromResource(position, convertView, parent, mDropDownResource));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return createViewFromResource(position, convertView, parent, mDropDownResource);
    }

    
        public static ArrayAdapter<CharSequence> createFromResource(Context context,
            int textArrayResId, int textViewResId) {
        CharSequence[] strings = context.getResources().getTextArray(textArrayResId);
        return new ArrayAdapter<CharSequence>(context, textViewResId, strings);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.276 -0400", hash_original_method = "93D8CD6E71E9F9D3F84ACCA40E0F811C", hash_generated_method = "99064F35940E136CA8F828ECB2D7F96E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Filter getFilter() {
        {
            mFilter = new ArrayFilter();
        } //End block
        return (Filter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mFilter == null) {
            //mFilter = new ArrayFilter();
        //}
        //return mFilter;
    }

    
    private class ArrayFilter extends Filter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.276 -0400", hash_original_method = "6A0FCBA1F5DC3ADD41DA0790308549D9", hash_generated_method = "6A0FCBA1F5DC3ADD41DA0790308549D9")
                public ArrayFilter ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.277 -0400", hash_original_method = "FCA1EE8188101C684A4D4FE1495B8102", hash_generated_method = "FC7A8B9D22A0F30C9881C864A5D8C337")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected FilterResults performFiltering(CharSequence prefix) {
            dsTaint.addTaint(prefix);
            FilterResults results;
            results = new FilterResults();
            {
                {
                    mOriginalValues = new ArrayList<T>(mObjects);
                } //End block
            } //End block
            {
                boolean varC2A2CF8A9676195B62AC39EAB2DC8746_301609117 = (prefix == null || prefix.length() == 0);
                {
                    ArrayList<T> list;
                    {
                        list = new ArrayList<T>(mOriginalValues);
                    } //End block
                    results.values = list;
                    results.count = list.size();
                } //End block
                {
                    String prefixString;
                    prefixString = prefix.toString().toLowerCase();
                    ArrayList<T> values;
                    {
                        values = new ArrayList<T>(mOriginalValues);
                    } //End block
                    int count;
                    count = values.size();
                    ArrayList<T> newValues;
                    newValues = new ArrayList<T>();
                    {
                        int i;
                        i = 0;
                        {
                            T value;
                            value = values.get(i);
                            String valueText;
                            valueText = value.toString().toLowerCase();
                            {
                                boolean varC74DE7BC36FAC7675733A0D7891E756D_29931365 = (valueText.startsWith(prefixString));
                                {
                                    newValues.add(value);
                                } //End block
                                {
                                    String[] words;
                                    words = valueText.split(" ");
                                    int wordCount;
                                    wordCount = words.length;
                                    {
                                        int k;
                                        k = 0;
                                        {
                                            {
                                                boolean var9D40720128ABFAE9C601988D1E59EBD5_1580078622 = (words[k].startsWith(prefixString));
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
            return (FilterResults)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.277 -0400", hash_original_method = "109574F1A4050F52746E85DE95C85548", hash_generated_method = "519EC364868086425372302AC702A35C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dsTaint.addTaint(results.dsTaint);
            dsTaint.addTaint(constraint);
            mObjects = (List<T>) results.values;
            {
                notifyDataSetChanged();
            } //End block
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

