package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SimpleAdapter extends BaseAdapter implements Filterable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.310 -0500", hash_original_field = "51C70736F499787D82D1093BC908680A", hash_generated_field = "4C75B27E9A59CA7EBF688E20590B2441")

    private int[] mTo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.312 -0500", hash_original_field = "4F04F028BC0DB02812592093ADACE52E", hash_generated_field = "35EBD27CA01856F232FA9082B22FD3F8")

    private String[] mFrom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.315 -0500", hash_original_field = "5860CDE70C11C388F482671B0B0F2511", hash_generated_field = "308F8B2EF2E94DF958649BB3CD716341")

    private ViewBinder mViewBinder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.317 -0500", hash_original_field = "97A1765CFE78F9833BEBE08C51CB5132", hash_generated_field = "6074598C0E32C4907A625F2379246095")

    private List<? extends Map<String, ?>> mData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.320 -0500", hash_original_field = "803A97A9A69A64DC7CFAABA01F910CD8", hash_generated_field = "6ED56B37E58621AEB8D63CC1C5EA1E67")

    private int mResource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.322 -0500", hash_original_field = "20C2241273ABB539644EF14C80A7B539", hash_generated_field = "605FFB4549B20BAE4E7EBD72916F9C8F")

    private int mDropDownResource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.324 -0500", hash_original_field = "B03B4DAE3F576B7166425BEE37B96C5E", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.326 -0500", hash_original_field = "649E243894B5316B03CC65ACB768B90D", hash_generated_field = "E07CA12DC71BDAAC40179802990B419F")

    private SimpleFilter mFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.328 -0500", hash_original_field = "532C0ED5F1519CD4ACF3A7742BC36137", hash_generated_field = "4184788CAB453C820B908EB1BFD2CAF1")

    private ArrayList<Map<String, ?>> mUnfilteredData;

    /**
     * Constructor
     * 
     * @param context The context where the View associated with this SimpleAdapter is running
     * @param data A List of Maps. Each entry in the List corresponds to one row in the list. The
     *        Maps contain the data for each row, and should include all the entries specified in
     *        "from"
     * @param resource Resource identifier of a view layout that defines the views for this list
     *        item. The layout file should include at least those named views defined in "to"
     * @param from A list of column names that will be added to the Map associated with each
     *        item.
     * @param to The views that should display column in the "from" parameter. These should all be
     *        TextViews. The first N views in this list are given the values of the first N columns
     *        in the from parameter.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.331 -0500", hash_original_method = "69327F085AF9DF0CBB2A648A26326E3D", hash_generated_method = "6ADEBFD33F3773261F6FEF165F166053")
    
public SimpleAdapter(Context context, List<? extends Map<String, ?>> data,
            int resource, String[] from, int[] to) {
        mData = data;
        mResource = mDropDownResource = resource;
        mFrom = from;
        mTo = to;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    /**
     * @see android.widget.Adapter#getCount()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.333 -0500", hash_original_method = "42219B54C0DE57D9E8EFCE349042BDFC", hash_generated_method = "9501D47462738A6B2D02A04C78529276")
    
public int getCount() {
        return mData.size();
    }

    /**
     * @see android.widget.Adapter#getItem(int)
     */
    @DSSpec(DSCat.DB_CURSOR)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.335 -0500", hash_original_method = "DCE185E9FC70557F4514C683017F4175", hash_generated_method = "8D686EFAA64456725DD2FB6EC7806F01")
    
public Object getItem(int position) {
        return mData.get(position);
    }

    /**
     * @see android.widget.Adapter#getItemId(int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.337 -0500", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "86EF76D6295D66F6DBBE39DCDBA9A1C9")
    
public long getItemId(int position) {
        return position;
    }

    /**
     * @see android.widget.Adapter#getView(int, View, ViewGroup)
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.339 -0500", hash_original_method = "180EEF863853B86A02E5E476168E516D", hash_generated_method = "A5B1D9C00E70EDAFF5DE72AD387583B6")
    
public View getView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(position, convertView, parent, mResource);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.342 -0500", hash_original_method = "9F7D1FC25501C8F0267FBA100FA00D09", hash_generated_method = "D38AE64F8ED815ED3F5F4076006BFF3B")
    
private View createViewFromResource(int position, View convertView,
            ViewGroup parent, int resource) {
        View v;
        if (convertView == null) {
            v = mInflater.inflate(resource, parent, false);
        } else {
            v = convertView;
        }

        bindView(position, v);

        return v;
    }

    /**
     * <p>Sets the layout resource to create the drop down views.</p>
     *
     * @param resource the layout resource defining the drop down views
     * @see #getDropDownView(int, android.view.View, android.view.ViewGroup)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.344 -0500", hash_original_method = "614355FA33E2A17CA6280A34FDBFFDC0", hash_generated_method = "53E9BC2B4CD88AE698F664DCCF80E05A")
    
public void setDropDownViewResource(int resource) {
        this.mDropDownResource = resource;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.346 -0500", hash_original_method = "55A24C3FF57565648C18AD1B34A1D191", hash_generated_method = "354A608CAB67E58C0C02915FF74A2A17")
    
@Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(position, convertView, parent, mDropDownResource);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.349 -0500", hash_original_method = "BE6FDCE3CF7BF2397C7FC2DCDCAE8C07", hash_generated_method = "C72CC2EB481B5E8FB1525E8103E154BB")
    
private void bindView(int position, View view) {
        final Map dataSet = mData.get(position);
        if (dataSet == null) {
            return;
        }

        final ViewBinder binder = mViewBinder;
        final String[] from = mFrom;
        final int[] to = mTo;
        final int count = to.length;

        for (int i = 0; i < count; i++) {
            final View v = view.findViewById(to[i]);
            if (v != null) {
                final Object data = dataSet.get(from[i]);
                String text = data == null ? "" : data.toString();
                if (text == null) {
                    text = "";
                }

                boolean bound = false;
                if (binder != null) {
                    bound = binder.setViewValue(v, data, text);
                }

                if (!bound) {
                    if (v instanceof Checkable) {
                        if (data instanceof Boolean) {
                            ((Checkable) v).setChecked((Boolean) data);
                        } else if (v instanceof TextView) {
                            // Note: keep the instanceof TextView check at the bottom of these
                            // ifs since a lot of views are TextViews (e.g. CheckBoxes).
                            setViewText((TextView) v, text);
                        } else {
                            throw new IllegalStateException(v.getClass().getName() +
                                    " should be bound to a Boolean, not a " +
                                    (data == null ? "<unknown type>" : data.getClass()));
                        }
                    } else if (v instanceof TextView) {
                        // Note: keep the instanceof TextView check at the bottom of these
                        // ifs since a lot of views are TextViews (e.g. CheckBoxes).
                        setViewText((TextView) v, text);
                    } else if (v instanceof ImageView) {
                        if (data instanceof Integer) {
                            setViewImage((ImageView) v, (Integer) data);                            
                        } else {
                            setViewImage((ImageView) v, text);
                        }
                    } else {
                        throw new IllegalStateException(v.getClass().getName() + " is not a " +
                                " view that can be bounds by this SimpleAdapter");
                    }
                }
            }
        }
    }

    /**
     * Returns the {@link ViewBinder} used to bind data to views.
     *
     * @return a ViewBinder or null if the binder does not exist
     *
     * @see #setViewBinder(android.widget.SimpleAdapter.ViewBinder)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.351 -0500", hash_original_method = "E0E2C9BDE209838004B6CAB60CB87613", hash_generated_method = "24EF2DCAC9F252399E7488BB4B6717A3")
    
public ViewBinder getViewBinder() {
        return mViewBinder;
    }

    /**
     * Sets the binder used to bind data to views.
     *
     * @param viewBinder the binder used to bind data to views, can be null to
     *        remove the existing binder
     *
     * @see #getViewBinder()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.353 -0500", hash_original_method = "119DFC3ED073D5B4FB9A3C0337902379", hash_generated_method = "CD8F00DE3A674A18D556142232BB8469")
    
public void setViewBinder(ViewBinder viewBinder) {
        mViewBinder = viewBinder;
    }

    /**
     * Called by bindView() to set the image for an ImageView but only if
     * there is no existing ViewBinder or if the existing ViewBinder cannot
     * handle binding to an ImageView.
     *
     * This method is called instead of {@link #setViewImage(ImageView, String)}
     * if the supplied data is an int or Integer.
     *
     * @param v ImageView to receive an image
     * @param value the value retrieved from the data set
     *
     * @see #setViewImage(ImageView, String)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.355 -0500", hash_original_method = "8236568D142C0CAA775378341E7BB8F7", hash_generated_method = "F0D35AB2B8AAE27CA82AD7D7A545D22D")
    
public void setViewImage(ImageView v, int value) {
        v.setImageResource(value);
    }

    /**
     * Called by bindView() to set the image for an ImageView but only if
     * there is no existing ViewBinder or if the existing ViewBinder cannot
     * handle binding to an ImageView.
     *
     * By default, the value will be treated as an image resource. If the
     * value cannot be used as an image resource, the value is used as an
     * image Uri.
     *
     * This method is called instead of {@link #setViewImage(ImageView, int)}
     * if the supplied data is not an int or Integer.
     *
     * @param v ImageView to receive an image
     * @param value the value retrieved from the data set
     *
     * @see #setViewImage(ImageView, int) 
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.357 -0500", hash_original_method = "31A5526470C992FDAE212BFFA88B0730", hash_generated_method = "A3BA9232B932A48C4241116FDADFE82E")
    
public void setViewImage(ImageView v, String value) {
        try {
            v.setImageResource(Integer.parseInt(value));
        } catch (NumberFormatException nfe) {
            v.setImageURI(Uri.parse(value));
        }
    }

    /**
     * Called by bindView() to set the text for a TextView but only if
     * there is no existing ViewBinder or if the existing ViewBinder cannot
     * handle binding to an TextView.
     *
     * @param v TextView to receive text
     * @param text the text to be set for the TextView
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.360 -0500", hash_original_method = "5AA8DD17AC94ADB8D267F5D4267EA13E", hash_generated_method = "78A796D1AAAB9527A328641E2AF2A0ED")
    
public void setViewText(TextView v, String text) {
        v.setText(text);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.363 -0500", hash_original_method = "D6072B8C53AE1E6461A6E29F4F69F458", hash_generated_method = "81A78CF776B05410DF2F67E3FD3F3B53")
    
public Filter getFilter() {
        if (mFilter == null) {
            mFilter = new SimpleFilter();
        }
        return mFilter;
    }
    
    private class SimpleFilter extends Filter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.981 -0400", hash_original_method = "D26AD51AFC295494F6A54B60978FDA11", hash_generated_method = "D26AD51AFC295494F6A54B60978FDA11")
        public SimpleFilter ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.369 -0500", hash_original_method = "04E3499844790A872CDFD26E55084EC3", hash_generated_method = "A3BEF41A95DC0B72F04D1E334253858D")
        
@Override
        protected FilterResults performFiltering(CharSequence prefix) {
            FilterResults results = new FilterResults();

            if (mUnfilteredData == null) {
                mUnfilteredData = new ArrayList<Map<String, ?>>(mData);
            }

            if (prefix == null || prefix.length() == 0) {
                ArrayList<Map<String, ?>> list = mUnfilteredData;
                results.values = list;
                results.count = list.size();
            } else {
                String prefixString = prefix.toString().toLowerCase();

                ArrayList<Map<String, ?>> unfilteredValues = mUnfilteredData;
                int count = unfilteredValues.size();

                ArrayList<Map<String, ?>> newValues = new ArrayList<Map<String, ?>>(count);

                for (int i = 0; i < count; i++) {
                    Map<String, ?> h = unfilteredValues.get(i);
                    if (h != null) {
                        
                        int len = mTo.length;

                        for (int j=0; j<len; j++) {
                            String str =  (String)h.get(mFrom[j]);
                            
                            String[] words = str.split(" ");
                            int wordCount = words.length;
                            
                            for (int k = 0; k < wordCount; k++) {
                                String word = words[k];
                                
                                if (word.toLowerCase().startsWith(prefixString)) {
                                    newValues.add(h);
                                    break;
                                }
                            }
                        }
                    }
                }

                results.values = newValues;
                results.count = newValues.size();
            }

            return results;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.372 -0500", hash_original_method = "0895A2400EE6AFA382B9EEA2BA108345", hash_generated_method = "BFDAC8DA48E92DF689661022DAEDFB50")
        
@Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            //noinspection unchecked
            mData = (List<Map<String, ?>>) results.values;
            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }
        
    }
    
    public static interface ViewBinder {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean setViewValue(View view, Object data, String textRepresentation);
    }
    
}

