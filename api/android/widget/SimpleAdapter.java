package android.widget;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.970 -0400", hash_original_field = "6F69D0C4D879F039DD614BB6C1B21419", hash_generated_field = "4C75B27E9A59CA7EBF688E20590B2441")

    private int[] mTo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.971 -0400", hash_original_field = "EDE7DB5B0C4E79BD52B42E685F59B951", hash_generated_field = "35EBD27CA01856F232FA9082B22FD3F8")

    private String[] mFrom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.971 -0400", hash_original_field = "DDDBAA0AB795AF915BA6E626A345701D", hash_generated_field = "308F8B2EF2E94DF958649BB3CD716341")

    private ViewBinder mViewBinder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.971 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "6074598C0E32C4907A625F2379246095")

    private List<? extends Map<String, ?>> mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.971 -0400", hash_original_field = "513ECCC3F2175FF90ADFE90E4852BF1D", hash_generated_field = "6ED56B37E58621AEB8D63CC1C5EA1E67")

    private int mResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.971 -0400", hash_original_field = "4E551418A503FBC4B46C7DAAADA3FAEC", hash_generated_field = "605FFB4549B20BAE4E7EBD72916F9C8F")

    private int mDropDownResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.971 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.971 -0400", hash_original_field = "C781ED17A87FBE09F8079C6EC63D1F26", hash_generated_field = "E07CA12DC71BDAAC40179802990B419F")

    private SimpleFilter mFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.971 -0400", hash_original_field = "32CA257E23125AC179943086274D0693", hash_generated_field = "4184788CAB453C820B908EB1BFD2CAF1")

    private ArrayList<Map<String, ?>> mUnfilteredData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.972 -0400", hash_original_method = "69327F085AF9DF0CBB2A648A26326E3D", hash_generated_method = "A7941A4098F4330BDE5104808F753C3C")
    public  SimpleAdapter(Context context, List<? extends Map<String, ?>> data,
            int resource, String[] from, int[] to) {
        mData = data;
        mResource = mDropDownResource = resource;
        mFrom = from;
        mTo = to;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // ---------- Original Method ----------
        //mData = data;
        //mResource = mDropDownResource = resource;
        //mFrom = from;
        //mTo = to;
        //mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.972 -0400", hash_original_method = "42219B54C0DE57D9E8EFCE349042BDFC", hash_generated_method = "C9348D0CAC3A06DF4B8E87360804FD1D")
    public int getCount() {
        int var9987FB1A7FBC9F7F6B09B5AA2A98E534_241944282 = (mData.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37336382 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37336382;
        // ---------- Original Method ----------
        //return mData.size();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.973 -0400", hash_original_method = "DCE185E9FC70557F4514C683017F4175", hash_generated_method = "D39611AA097F489A961FEA7AC21E508B")
    public Object getItem(int position) {
        addTaint(position);
Object var97565132EBA5A592B8E95DB1E8B35615_317453039 =         mData.get(position);
        var97565132EBA5A592B8E95DB1E8B35615_317453039.addTaint(taint);
        return var97565132EBA5A592B8E95DB1E8B35615_317453039;
        // ---------- Original Method ----------
        //return mData.get(position);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.973 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "7F36AE8665497737E05528FB5725BD43")
    public long getItemId(int position) {
        addTaint(position);
        long var4757FE07FD492A8BE0EA6A760D683D6E_1436086065 = (position);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1462858203 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1462858203;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.974 -0400", hash_original_method = "180EEF863853B86A02E5E476168E516D", hash_generated_method = "F3446048E79DC2C27E17A172D13711D8")
    public View getView(int position, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(position);
View varC7C74D1A1F888482D2EEA96BBD632B6B_656653800 =         createViewFromResource(position, convertView, parent, mResource);
        varC7C74D1A1F888482D2EEA96BBD632B6B_656653800.addTaint(taint);
        return varC7C74D1A1F888482D2EEA96BBD632B6B_656653800;
        // ---------- Original Method ----------
        //return createViewFromResource(position, convertView, parent, mResource);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.975 -0400", hash_original_method = "9F7D1FC25501C8F0267FBA100FA00D09", hash_generated_method = "4DC7E393E81D0377B77BB87DD66B7F86")
    private View createViewFromResource(int position, View convertView,
            ViewGroup parent, int resource) {
        addTaint(resource);
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(position);
        View v;
        if(convertView == null)        
        {
            v = mInflater.inflate(resource, parent, false);
        } //End block
        else
        {
            v = convertView;
        } //End block
        bindView(position, v);
View var6DC76BC51820DD65E8396280E884AA78_747988581 =         v;
        var6DC76BC51820DD65E8396280E884AA78_747988581.addTaint(taint);
        return var6DC76BC51820DD65E8396280E884AA78_747988581;
        // ---------- Original Method ----------
        //View v;
        //if (convertView == null) {
            //v = mInflater.inflate(resource, parent, false);
        //} else {
            //v = convertView;
        //}
        //bindView(position, v);
        //return v;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.976 -0400", hash_original_method = "614355FA33E2A17CA6280A34FDBFFDC0", hash_generated_method = "166D468151E808B5172814612FD9B5A0")
    public void setDropDownViewResource(int resource) {
        this.mDropDownResource = resource;
        // ---------- Original Method ----------
        //this.mDropDownResource = resource;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.976 -0400", hash_original_method = "55A24C3FF57565648C18AD1B34A1D191", hash_generated_method = "751BDE3AE49CE1C5F757C478B78C3F87")
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(position);
View var73BABEDDC942C821B8059F08E1C361F2_237151036 =         createViewFromResource(position, convertView, parent, mDropDownResource);
        var73BABEDDC942C821B8059F08E1C361F2_237151036.addTaint(taint);
        return var73BABEDDC942C821B8059F08E1C361F2_237151036;
        // ---------- Original Method ----------
        //return createViewFromResource(position, convertView, parent, mDropDownResource);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.977 -0400", hash_original_method = "BE6FDCE3CF7BF2397C7FC2DCDCAE8C07", hash_generated_method = "CBD8BF588B60C8D94EB99BBC2BEC45BB")
    private void bindView(int position, View view) {
        addTaint(view.getTaint());
        addTaint(position);
        final Map dataSet = mData.get(position);
        if(dataSet == null)        
        {
            return;
        } //End block
        final ViewBinder binder = mViewBinder;
        final String[] from = mFrom;
        final int[] to = mTo;
        final int count = to.length;
for(int i = 0;i < count;i++)
        {
            final View v = view.findViewById(to[i]);
            if(v != null)            
            {
                final Object data = dataSet.get(from[i]);
                String text = data == null ? "" : data.toString();
                if(text == null)                
                {
                    text = "";
                } //End block
                boolean bound = false;
                if(binder != null)                
                {
                    bound = binder.setViewValue(v, data, text);
                } //End block
                if(!bound)                
                {
                    if(v instanceof Checkable)                    
                    {
                        if(data instanceof Boolean)                        
                        {
                            ((Checkable) v).setChecked((Boolean) data);
                        } //End block
                        else
                        if(v instanceof TextView)                        
                        {
                            setViewText((TextView) v, text);
                        } //End block
                        else
                        {
                            IllegalStateException varC2F770133D589D9A5ACC832FC7436CEA_1509087306 = new IllegalStateException(v.getClass().getName() +
                                    " should be bound to a Boolean, not a " +
                                    (data == null ? "<unknown type>" : data.getClass()));
                            varC2F770133D589D9A5ACC832FC7436CEA_1509087306.addTaint(taint);
                            throw varC2F770133D589D9A5ACC832FC7436CEA_1509087306;
                        } //End block
                    } //End block
                    else
                    if(v instanceof TextView)                    
                    {
                        setViewText((TextView) v, text);
                    } //End block
                    else
                    if(v instanceof ImageView)                    
                    {
                        if(data instanceof Integer)                        
                        {
                            setViewImage((ImageView) v, (Integer) data);
                        } //End block
                        else
                        {
                            setViewImage((ImageView) v, text);
                        } //End block
                    } //End block
                    else
                    {
                        IllegalStateException var06E706E4A7789AB3ED57CA59EF0FA959_1512065165 = new IllegalStateException(v.getClass().getName() + " is not a " +
                                " view that can be bounds by this SimpleAdapter");
                        var06E706E4A7789AB3ED57CA59EF0FA959_1512065165.addTaint(taint);
                        throw var06E706E4A7789AB3ED57CA59EF0FA959_1512065165;
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.978 -0400", hash_original_method = "E0E2C9BDE209838004B6CAB60CB87613", hash_generated_method = "951F81B80906D94FAB791F16C580E815")
    public ViewBinder getViewBinder() {
ViewBinder var3599647BDC732C2D53724CC7D8743271_265919206 =         mViewBinder;
        var3599647BDC732C2D53724CC7D8743271_265919206.addTaint(taint);
        return var3599647BDC732C2D53724CC7D8743271_265919206;
        // ---------- Original Method ----------
        //return mViewBinder;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.979 -0400", hash_original_method = "119DFC3ED073D5B4FB9A3C0337902379", hash_generated_method = "3E071F9EE6E9AEAADA16E4C43987A93F")
    public void setViewBinder(ViewBinder viewBinder) {
        mViewBinder = viewBinder;
        // ---------- Original Method ----------
        //mViewBinder = viewBinder;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.979 -0400", hash_original_method = "8236568D142C0CAA775378341E7BB8F7", hash_generated_method = "AC18A29AB8189C6E7999BC08B7E7AB02")
    public void setViewImage(ImageView v, int value) {
        addTaint(value);
        addTaint(v.getTaint());
        v.setImageResource(value);
        // ---------- Original Method ----------
        //v.setImageResource(value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.980 -0400", hash_original_method = "31A5526470C992FDAE212BFFA88B0730", hash_generated_method = "E06B0A7D875362159E7B590763BC1C85")
    public void setViewImage(ImageView v, String value) {
        addTaint(value.getTaint());
        addTaint(v.getTaint());
        try 
        {
            v.setImageResource(Integer.parseInt(value));
        } //End block
        catch (NumberFormatException nfe)
        {
            v.setImageURI(Uri.parse(value));
        } //End block
        // ---------- Original Method ----------
        //try {
            //v.setImageResource(Integer.parseInt(value));
        //} catch (NumberFormatException nfe) {
            //v.setImageURI(Uri.parse(value));
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.980 -0400", hash_original_method = "5AA8DD17AC94ADB8D267F5D4267EA13E", hash_generated_method = "6059A05BA24D864572F36CFBDDA47D36")
    public void setViewText(TextView v, String text) {
        addTaint(text.getTaint());
        addTaint(v.getTaint());
        v.setText(text);
        // ---------- Original Method ----------
        //v.setText(text);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.981 -0400", hash_original_method = "D6072B8C53AE1E6461A6E29F4F69F458", hash_generated_method = "AD2326A480BC93B3C6647355D9860E02")
    public Filter getFilter() {
        if(mFilter == null)        
        {
            mFilter = new SimpleFilter();
        } //End block
Filter var6104E4BD549FCD2640641D136DD683A6_884267215 =         mFilter;
        var6104E4BD549FCD2640641D136DD683A6_884267215.addTaint(taint);
        return var6104E4BD549FCD2640641D136DD683A6_884267215;
        // ---------- Original Method ----------
        //if (mFilter == null) {
            //mFilter = new SimpleFilter();
        //}
        //return mFilter;
    }

    
    private class SimpleFilter extends Filter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.981 -0400", hash_original_method = "D26AD51AFC295494F6A54B60978FDA11", hash_generated_method = "D26AD51AFC295494F6A54B60978FDA11")
        public SimpleFilter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.983 -0400", hash_original_method = "04E3499844790A872CDFD26E55084EC3", hash_generated_method = "5724FCBD13D0C007342F62EB51E3AF0C")
        @Override
        protected FilterResults performFiltering(CharSequence prefix) {
            addTaint(prefix.getTaint());
            FilterResults results = new FilterResults();
            if(mUnfilteredData == null)            
            {
                mUnfilteredData = new ArrayList<Map<String, ?>>(mData);
            } //End block
            if(prefix == null || prefix.length() == 0)            
            {
                ArrayList<Map<String, ?>> list = mUnfilteredData;
                results.values = list;
                results.count = list.size();
            } //End block
            else
            {
                String prefixString = prefix.toString().toLowerCase();
                ArrayList<Map<String, ?>> unfilteredValues = mUnfilteredData;
                int count = unfilteredValues.size();
                ArrayList<Map<String, ?>> newValues = new ArrayList<Map<String, ?>>(count);
for(int i = 0;i < count;i++)
                {
                    Map<String, ?> h = unfilteredValues.get(i);
                    if(h != null)                    
                    {
                        int len = mTo.length;
for(int j=0;j<len;j++)
                        {
                            String str = (String)h.get(mFrom[j]);
                            String[] words = str.split(" ");
                            int wordCount = words.length;
for(int k = 0;k < wordCount;k++)
                            {
                                String word = words[k];
                                if(word.toLowerCase().startsWith(prefixString))                                
                                {
                                    newValues.add(h);
                                    break;
                                } //End block
                            } //End block
                        } //End block
                    } //End block
                } //End block
                results.values = newValues;
                results.count = newValues.size();
            } //End block
FilterResults var238ECCC9872FFCA0B3C3DB83598FF044_1519823445 =             results;
            var238ECCC9872FFCA0B3C3DB83598FF044_1519823445.addTaint(taint);
            return var238ECCC9872FFCA0B3C3DB83598FF044_1519823445;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.985 -0400", hash_original_method = "0895A2400EE6AFA382B9EEA2BA108345", hash_generated_method = "5559170BA46B77B0B6A20283D39D8D56")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            addTaint(results.getTaint());
            addTaint(constraint.getTaint());
            mData = (List<Map<String, ?>>) results.values;
            if(results.count > 0)            
            {
                notifyDataSetChanged();
            } //End block
            else
            {
                notifyDataSetInvalidated();
            } //End block
            // ---------- Original Method ----------
            //mData = (List<Map<String, ?>>) results.values;
            //if (results.count > 0) {
                //notifyDataSetChanged();
            //} else {
                //notifyDataSetInvalidated();
            //}
        }

        
    }


    
    public static interface ViewBinder {
        
        boolean setViewValue(View view, Object data, String textRepresentation);
    }
    
}

