package android.widget;

import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class ArrayAdapter<T> extends BaseAdapter implements Filterable {
	private int mResource;
	private LayoutInflater mInflater;
	private int mFieldId = 0;
    private boolean mNotifyOnChange = true;
    private Context mContext;
    private List<T> mObjects;
    private int mDropDownResource;
	
	
	@DSModeled(DSC.SAFE)
	public ArrayAdapter(Context context, int textViewResourceId, T[] objects) {
        init(context, textViewResourceId, 0, Arrays.asList(objects));
    }
	
	@DSModeled(DSC.SAFE)
	public ArrayAdapter(Context context, int textViewResourceId, List<T> objects) {
        init(context, textViewResourceId, 0, objects);
    }
	
	@DSModeled(DSC.SAFE)
	private void init(Context context, int resource, int textViewResourceId, List<T> objects) {
        mContext = context;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mResource = mDropDownResource = resource;
        mObjects = objects;
        mFieldId = textViewResourceId;
    }

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

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(position, convertView, parent, mResource);
    }

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
	
	@DSModeled(DSC.SAFE)
	public void add(T object) {
        mObjects.add(object);
        notifyDataSetChanged();
    }
	
	@Override
	@DSModeled(DSC.SAFE)
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        mNotifyOnChange = true;
    }

}
