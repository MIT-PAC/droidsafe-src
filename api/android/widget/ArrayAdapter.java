package android.widget;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ArrayAdapter<T> extends BaseAdapter implements Filterable {
    private List<T> mObjects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.309 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")

    private final Object mLock = new Object();
    private int mResource;
    private int mDropDownResource;
    private int mFieldId = 0;
    private boolean mNotifyOnChange = true;
    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.309 -0400", hash_original_field = "7E1411E28582E7BB5CB8D7EF06A96926", hash_generated_field = "D3DC3ECDE417C076679DF4CF25A2ECC3")

    private ArrayList<T> mOriginalValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.309 -0400", hash_original_field = "C781ED17A87FBE09F8079C6EC63D1F26", hash_generated_field = "A0F0365EB2712D5C3F88231E50941E9D")

    private ArrayFilter mFilter;
    private LayoutInflater mInflater;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.310 -0400", hash_original_method = "789F3BF67B69FD6C237A5778FFC1188F", hash_generated_method = "9F2D5759E56F73FA5A593FA701BA5C3D")
    public  ArrayAdapter(Context context, int textViewResourceId) {
        addTaint(textViewResourceId);
        addTaint(context.getTaint());
        init(context, textViewResourceId, 0, new ArrayList<T>());
        // ---------- Original Method ----------
        //init(context, textViewResourceId, 0, new ArrayList<T>());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.311 -0400", hash_original_method = "8D997C3441EFBFDB8F1974C979BCB748", hash_generated_method = "BB5F52F252315BDE0DD91C6E208DD112")
    public  ArrayAdapter(Context context, int resource, int textViewResourceId) {
        addTaint(textViewResourceId);
        addTaint(resource);
        addTaint(context.getTaint());
        init(context, resource, textViewResourceId, new ArrayList<T>());
        // ---------- Original Method ----------
        //init(context, resource, textViewResourceId, new ArrayList<T>());
    }

    
    @DSModeled(DSC.SAFE)
	public ArrayAdapter(Context context, int textViewResourceId, T[] objects) {
        init(context, textViewResourceId, 0, Arrays.asList(objects));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.311 -0400", hash_original_method = "69F6C47A6CFAD9DAEB9B15D26A429BD2", hash_generated_method = "0AD77E38C114B56F67EBF8911FE368C0")
    public  ArrayAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
        addTaint(objects[0].getTaint());
        addTaint(textViewResourceId);
        addTaint(resource);
        addTaint(context.getTaint());
        init(context, resource, textViewResourceId, Arrays.asList(objects));
        // ---------- Original Method ----------
        //init(context, resource, textViewResourceId, Arrays.asList(objects));
    }

    
    @DSModeled(DSC.SAFE)
	public ArrayAdapter(Context context, int textViewResourceId, List<T> objects) {
        init(context, textViewResourceId, 0, objects);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.312 -0400", hash_original_method = "25BF5070AB68B4CC94195FE94A6CDD15", hash_generated_method = "45C05D2F6900A6552B59CA1E74D9A522")
    public  ArrayAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
        addTaint(objects.getTaint());
        addTaint(textViewResourceId);
        addTaint(resource);
        addTaint(context.getTaint());
        init(context, resource, textViewResourceId, objects);
        // ---------- Original Method ----------
        //init(context, resource, textViewResourceId, objects);
    }

    
    @DSModeled(DSC.SAFE)
	public void add(T object) {
        mObjects.add(object);
        notifyDataSetChanged();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.313 -0400", hash_original_method = "2106A171487E5CA0624DE157360DB991", hash_generated_method = "79FA754AF55A7046C9471BCF42F16886")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.314 -0400", hash_original_method = "0FB4566239B43452682D3C6768E6D3AE", hash_generated_method = "F42D037C8C7AD0C6C7A4391992090E1D")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.315 -0400", hash_original_method = "E6733B2C388AB0385CFE6D2E53E92DC8", hash_generated_method = "C3B7E909806CA2AF41449C8A9AB2A7EE")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.315 -0400", hash_original_method = "6A184D6E0EB34E61EA380878C12E3D42", hash_generated_method = "45D17E6A0AF764C0FD5FF96FC91D8B9D")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.316 -0400", hash_original_method = "E80E28672DD45A1486192C70E40EF7F5", hash_generated_method = "C4F1F91442599AE68F832F75FB6037BB")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.316 -0400", hash_original_method = "56420943E8AF9990310F4859FACB8646", hash_generated_method = "3DA380F8887A0573D7C23BFEE52E0CDB")
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

    
    @Override
	@DSModeled(DSC.SAFE)
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        mNotifyOnChange = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.317 -0400", hash_original_method = "B014C1A32626DBADC83EC827393C5854", hash_generated_method = "DF16B68FF23EAD56FA4255B3D48770B3")
    public void setNotifyOnChange(boolean notifyOnChange) {
        mNotifyOnChange = notifyOnChange;
        // ---------- Original Method ----------
        //mNotifyOnChange = notifyOnChange;
    }

    
    @DSModeled(DSC.SAFE)
	private void init(Context context, int resource, int textViewResourceId, List<T> objects) {
        mContext = context;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mResource = mDropDownResource = resource;
        mObjects = objects;
        mFieldId = textViewResourceId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.318 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "E1F8BA78AFDA16DD62827582E21F0D52")
    public Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_967216275 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_967216275.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_967216275;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSModeled(DSC.SAFE)
    @Override
	public int getCount() {
		return 0;
        //return mObjects.size();
    }

    
    @Override
	public Object getItem(int position) {
		return getTaint();
	    //return mObjects.get(position);
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.320 -0400", hash_original_method = "4B52B65CCBAD37C22D6FCF1BE4A30381", hash_generated_method = "4306745B19EF41037F68A6DA3555ACDB")
    public int getPosition(T item) {
        addTaint(item.getTaint());
        int varDFBE5BD03266E32EAAAEB8FB3F55CCB4_1480060948 = (mObjects.indexOf(item));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050412391 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050412391;
        // ---------- Original Method ----------
        //return mObjects.indexOf(item);
    }

    
    @DSModeled(DSC.SAFE)
    @Override
	public long getItemId(int position) {
		return position;
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(position, convertView, parent, mResource);
    }

    
    @DSModeled(DSC.SAFE)
    private View createViewFromResource(int position, View convertView, ViewGroup parent,
            int resource) {
        View view;
        TextView text;
        if (convertView == null) {
            view = mInflater.inflate(resource, parent, false);
        } else {
            view = convertView;
        }
        try {
            if (mFieldId == 0) {
                //  If no custom field is assigned, assume the whole resource is a TextView
                text = (TextView) view;
            } else {
                //  Otherwise, find the TextView field within the layout
                text = (TextView) view.findViewById(mFieldId);
            }
        } catch (ClassCastException e) {
            Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException(
                    "ArrayAdapter requires the resource ID to be a TextView", e);
        }
        T item = (T)getItem(position);
        if (item instanceof CharSequence) {
            text.setText((CharSequence)item);
        } else {
            text.setText(item.toString());
        }
        return view;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.327 -0400", hash_original_method = "614355FA33E2A17CA6280A34FDBFFDC0", hash_generated_method = "166D468151E808B5172814612FD9B5A0")
    public void setDropDownViewResource(int resource) {
        this.mDropDownResource = resource;
        // ---------- Original Method ----------
        //this.mDropDownResource = resource;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.327 -0400", hash_original_method = "55A24C3FF57565648C18AD1B34A1D191", hash_generated_method = "0D0D9F47EFB820C2116417EC15C21887")
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(position);
View var73BABEDDC942C821B8059F08E1C361F2_1090442088 =         createViewFromResource(position, convertView, parent, mDropDownResource);
        var73BABEDDC942C821B8059F08E1C361F2_1090442088.addTaint(taint);
        return var73BABEDDC942C821B8059F08E1C361F2_1090442088;
        // ---------- Original Method ----------
        //return createViewFromResource(position, convertView, parent, mDropDownResource);
    }

    
    @DSModeled(DSC.SAFE)
    public static ArrayAdapter<CharSequence> createFromResource(Context context,
            int textArrayResId, int textViewResId) {
        CharSequence[] strings = context.getResources().getTextArray(textArrayResId);
        return new ArrayAdapter<CharSequence>(context, textViewResId, strings);
    }

    
    @DSModeled(DSC.SAFE)
    @Override
	public Filter getFilter() {
		return new ArrayFilter();
		/*
        if (mFilter == null) {
            mFilter = new ArrayFilter();
        }
        return mFilter;
        */
    }

    
    private class ArrayFilter extends Filter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.328 -0400", hash_original_method = "1D9325EC6EFFDE6F3FA421C05C5C6F5E", hash_generated_method = "1D9325EC6EFFDE6F3FA421C05C5C6F5E")
        public ArrayFilter ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @Override
		protected FilterResults performFiltering(CharSequence prefix) {
            FilterResults results = new FilterResults();
            return results;
            /*
            mOriginalValues = new ArrayList<T>(mObjects);
            if (mOriginalValues == null) {
                synchronized (mLock) {
                    mOriginalValues = new ArrayList<T>(mObjects);
                }
            }
            if (prefix == null || prefix.length() == 0) {
                ArrayList<T> list;
                synchronized (mLock) {
                    list = new ArrayList<T>(mOriginalValues);
                }
                results.values = list;
                results.count = list.size();
            } else {
                String prefixString = prefix.toString().toLowerCase();
                ArrayList<T> values;
                synchronized (mLock) {
                    values = new ArrayList<T>(mOriginalValues);
                }
                final int count = values.size();
                final ArrayList<T> newValues = new ArrayList<T>();
                for (int i = 0; i < count; i++) {
                    final T value = values.get(i);
                    final String valueText = value.toString().toLowerCase();
                    // First match against the whole, non-splitted value
                    if (valueText.startsWith(prefixString)) {
                        newValues.add(value);
                    } else {
                        final String[] words = valueText.split(" ");
                        final int wordCount = words.length;
                        // Start at index 0, in case valueText starts with space(s)
                        for (int k = 0; k < wordCount; k++) {
                            if (words[k].startsWith(prefixString)) {
                                newValues.add(value);
                                break;
                            }
                        }
                    }
                }
                results.values = newValues;
                results.count = newValues.size();
            }
            return results;
            */
        }

        
        @DSModeled(DSC.SAFE)
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            //noinspection unchecked
            mObjects = (List<T>) results.values;
            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }

        
    }


    
}

