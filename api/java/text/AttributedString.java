package java.text;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;






public class AttributedString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.529 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "9EF4B8A5DE4B8BD37EE465C3BB62CC6C")

    String text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.529 -0400", hash_original_field = "EC5B70424D6106D0D37EACD23354A330", hash_generated_field = "EA3CF0028C57B0F0FB6C371B620465D1")

    Map<AttributedCharacterIterator.Attribute, List<Range>> attributeMap;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.530 -0400", hash_original_method = "5638BBE38DFF9B04A672F4EC9A02409B", hash_generated_method = "975AC590DC6B1FC3FFDF581028A8E302")
    public  AttributedString(AttributedCharacterIterator iterator) {
        addTaint(iterator.getTaint());
        if(iterator.getBeginIndex() > iterator.getEndIndex())        
        {
            IllegalArgumentException varEA5C1AA17767DA731A134E095AD75FCD_1220951520 = new IllegalArgumentException("Invalid substring range");
            varEA5C1AA17767DA731A134E095AD75FCD_1220951520.addTaint(taint);
            throw varEA5C1AA17767DA731A134E095AD75FCD_1220951520;
        } //End block
        StringBuilder buffer = new StringBuilder();
for(int i = iterator.getBeginIndex();i < iterator.getEndIndex();i++)
        {
            buffer.append(iterator.current());
            iterator.next();
        } //End block
        text = buffer.toString();
        Set<AttributedCharacterIterator.Attribute> attributes = iterator
                .getAllAttributeKeys();
        if(attributes == null)        
        {
            return;
        } //End block
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);
        Iterator<Attribute> it = attributes.iterator();
        while
(it.hasNext())        
        {
            AttributedCharacterIterator.Attribute attribute = it.next();
            iterator.setIndex(0);
            while
(iterator.current() != CharacterIterator.DONE)            
            {
                int start = iterator.getRunStart(attribute);
                int limit = iterator.getRunLimit(attribute);
                Object value = iterator.getAttribute(attribute);
                if(value != null)                
                {
                    addAttribute(attribute, value, start, limit);
                } //End block
                iterator.setIndex(limit);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.531 -0400", hash_original_method = "3A8973AD4EBE1F3B94E1633368C42F9D", hash_generated_method = "C411FA53F84E9C9DE5B8293C340E514E")
    private  AttributedString(AttributedCharacterIterator iterator, int start,
            int end, Set<Attribute> attributes) {
        addTaint(end);
        addTaint(start);
        addTaint(iterator.getTaint());
        if(start < iterator.getBeginIndex() || end > iterator.getEndIndex()
                || start > end)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_192807246 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_192807246.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_192807246;
        } //End block
        if(attributes == null)        
        {
            return;
        } //End block
        StringBuilder buffer = new StringBuilder();
        iterator.setIndex(start);
        while
(iterator.getIndex() < end)        
        {
            buffer.append(iterator.current());
            iterator.next();
        } //End block
        text = buffer.toString();
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);
        Iterator<Attribute> it = attributes.iterator();
        while
(it.hasNext())        
        {
            AttributedCharacterIterator.Attribute attribute = it.next();
            iterator.setIndex(start);
            while
(iterator.getIndex() < end)            
            {
                Object value = iterator.getAttribute(attribute);
                int runStart = iterator.getRunStart(attribute);
                int limit = iterator.getRunLimit(attribute);
                if((value instanceof Annotation && runStart >= start && limit <= end)
                        || (value != null && !(value instanceof Annotation)))                
                {
                    addAttribute(attribute, value, (runStart < start ? start
                            : runStart)
                            - start, (limit > end ? end : limit) - start);
                } //End block
                iterator.setIndex(limit);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.532 -0400", hash_original_method = "D0E1FC5545253EA6E008AE3675A9452F", hash_generated_method = "4626B692A0BDADD9D4B59FC620D439B6")
    public  AttributedString(AttributedCharacterIterator iterator, int start,
            int end) {
        this(iterator, start, end, iterator.getAllAttributeKeys());
        addTaint(end);
        addTaint(start);
        addTaint(iterator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.532 -0400", hash_original_method = "B4766721E168BC843A6EA06CFE59500E", hash_generated_method = "928450B8D7368B8EFBED1CDD7867A1D1")
    public  AttributedString(AttributedCharacterIterator iterator, int start,
            int end, AttributedCharacterIterator.Attribute[] attributes) {
        this(iterator, start, end, (attributes == null
                ? new HashSet<Attribute>()
                : new HashSet<Attribute>(Arrays.asList(attributes))));
        addTaint(attributes[0].getTaint());
        addTaint(end);
        addTaint(start);
        addTaint(iterator.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.533 -0400", hash_original_method = "A0ACF5D97B9D79B3295575A771939692", hash_generated_method = "B225F961263305229750A0346BC5840B")
    public  AttributedString(String value) {
        if(value == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_900660594 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_900660594.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_900660594;
        } //End block
        text = value;
        attributeMap = new HashMap<Attribute, List<Range>>(11);
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new NullPointerException();
        //}
        //text = value;
        //attributeMap = new HashMap<Attribute, List<Range>>(11);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.534 -0400", hash_original_method = "85CF866984BA31F6F3E97322323F86BA", hash_generated_method = "2AD5E6B08D8448D8B46866E95E7C8F86")
    public  AttributedString(String value,
            Map<? extends AttributedCharacterIterator.Attribute, ?> attributes) {
        if(value == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_607912725 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_607912725.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_607912725;
        } //End block
        if(value.length() == 0 && !attributes.isEmpty())        
        {
            IllegalArgumentException var931412BA27CF9259672C9348B0271FBB_198837075 = new IllegalArgumentException("Cannot add attributes to empty string");
            var931412BA27CF9259672C9348B0271FBB_198837075.addTaint(taint);
            throw var931412BA27CF9259672C9348B0271FBB_198837075;
        } //End block
        text = value;
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);
        Iterator<?> it = attributes.entrySet().iterator();
        while
(it.hasNext())        
        {
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
            ArrayList<Range> ranges = new ArrayList<Range>(1);
            ranges.add(new Range(0, text.length(), entry.getValue()));
            attributeMap.put((AttributedCharacterIterator.Attribute) entry
                    .getKey(), ranges);
        } //End block
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new NullPointerException();
        //}
        //if (value.length() == 0 && !attributes.isEmpty()) {
            //throw new IllegalArgumentException("Cannot add attributes to empty string");
        //}
        //text = value;
        //attributeMap = new HashMap<Attribute, List<Range>>(
                //(attributes.size() * 4 / 3) + 1);
        //Iterator<?> it = attributes.entrySet().iterator();
        //while (it.hasNext()) {
            //Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
            //ArrayList<Range> ranges = new ArrayList<Range>(1);
            //ranges.add(new Range(0, text.length(), entry.getValue()));
            //attributeMap.put((AttributedCharacterIterator.Attribute) entry
                    //.getKey(), ranges);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.535 -0400", hash_original_method = "F800EB2F1E580436E49CB51D04E3F37C", hash_generated_method = "03CCA7BAC8E68AAB6382EF208B73CFBB")
    public void addAttribute(AttributedCharacterIterator.Attribute attribute, Object value) {
        addTaint(value.getTaint());
        addTaint(attribute.getTaint());
        if(attribute == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1198645199 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1198645199.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1198645199;
        } //End block
        if(text.length() == 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1233429261 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1233429261.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1233429261;
        } //End block
        List<Range> ranges = attributeMap.get(attribute);
        if(ranges == null)        
        {
            ranges = new ArrayList<Range>(1);
            attributeMap.put(attribute, ranges);
        } //End block
        else
        {
            ranges.clear();
        } //End block
        ranges.add(new Range(0, text.length(), value));
        // ---------- Original Method ----------
        //if (attribute == null) {
            //throw new NullPointerException();
        //}
        //if (text.length() == 0) {
            //throw new IllegalArgumentException();
        //}
        //List<Range> ranges = attributeMap.get(attribute);
        //if (ranges == null) {
            //ranges = new ArrayList<Range>(1);
            //attributeMap.put(attribute, ranges);
        //} else {
            //ranges.clear();
        //}
        //ranges.add(new Range(0, text.length(), value));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.537 -0400", hash_original_method = "1EA9CE9DE6197B4051F39E120F823C8E", hash_generated_method = "FC34D431FA28974CA8FA161C4ED157B9")
    public void addAttribute(AttributedCharacterIterator.Attribute attribute,
            Object value, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(value.getTaint());
        addTaint(attribute.getTaint());
        if(attribute == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1773968660 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1773968660.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1773968660;
        } //End block
        if(start < 0 || end > text.length() || start >= end)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1297642445 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1297642445.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1297642445;
        } //End block
        if(value == null)        
        {
            return;
        } //End block
        List<Range> ranges = attributeMap.get(attribute);
        if(ranges == null)        
        {
            ranges = new ArrayList<Range>(1);
            ranges.add(new Range(start, end, value));
            attributeMap.put(attribute, ranges);
            return;
        } //End block
        ListIterator<Range> it = ranges.listIterator();
        while
(it.hasNext())        
        {
            Range range = it.next();
            if(end <= range.start)            
            {
                it.previous();
                break;
            } //End block
            else
            if(start < range.end
                    || (start == range.end && value.equals(range.value)))            
            {
                Range r1 = null;
                Range r3;
                it.remove();
                r1 = new Range(range.start, start, range.value);
                r3 = new Range(end, range.end, range.value);
                while
(end > range.end && it.hasNext())                
                {
                    range = it.next();
                    if(end <= range.end)                    
                    {
                        if(end > range.start
                                || (end == range.start && value.equals(range.value)))                        
                        {
                            it.remove();
                            r3 = new Range(end, range.end, range.value);
                            break;
                        } //End block
                    } //End block
                    else
                    {
                        it.remove();
                    } //End block
                } //End block
                if(value.equals(r1.value))                
                {
                    if(value.equals(r3.value))                    
                    {
                        it.add(new Range(r1.start < start ? r1.start : start,
                                r3.end > end ? r3.end : end, r1.value));
                    } //End block
                    else
                    {
                        it.add(new Range(r1.start < start ? r1.start : start,
                                end, r1.value));
                        if(r3.start < r3.end)                        
                        {
                            it.add(r3);
                        } //End block
                    } //End block
                } //End block
                else
                {
                    if(value.equals(r3.value))                    
                    {
                        if(r1.start < r1.end)                        
                        {
                            it.add(r1);
                        } //End block
                        it.add(new Range(start, r3.end > end ? r3.end : end,
                                r3.value));
                    } //End block
                    else
                    {
                        if(r1.start < r1.end)                        
                        {
                            it.add(r1);
                        } //End block
                        it.add(new Range(start, end, value));
                        if(r3.start < r3.end)                        
                        {
                            it.add(r3);
                        } //End block
                    } //End block
                } //End block
                return;
            } //End block
        } //End block
        it.add(new Range(start, end, value));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.539 -0400", hash_original_method = "9BDF8CEEC650CFF21B203033378C7411", hash_generated_method = "8A7D4B516825A215343DE33607637FAD")
    public void addAttributes(
            Map<? extends AttributedCharacterIterator.Attribute, ?> attributes,
            int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(attributes.getTaint());
        Iterator<?> it = attributes.entrySet().iterator();
        while
(it.hasNext())        
        {
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
            addAttribute(
                    (AttributedCharacterIterator.Attribute) entry.getKey(),
                    entry.getValue(), start, end);
        } //End block
        // ---------- Original Method ----------
        //Iterator<?> it = attributes.entrySet().iterator();
        //while (it.hasNext()) {
            //Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
            //addAttribute(
                    //(AttributedCharacterIterator.Attribute) entry.getKey(),
                    //entry.getValue(), start, end);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.539 -0400", hash_original_method = "3C3A14639543169375B4E8491231683C", hash_generated_method = "8DB01ECC397EAE15F4124B5956E9311A")
    public AttributedCharacterIterator getIterator() {
AttributedCharacterIterator var46DD1405AD0D5C49D9EFCF18E2C00E51_1319171419 =         new AttributedIterator(this);
        var46DD1405AD0D5C49D9EFCF18E2C00E51_1319171419.addTaint(taint);
        return var46DD1405AD0D5C49D9EFCF18E2C00E51_1319171419;
        // ---------- Original Method ----------
        //return new AttributedIterator(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.539 -0400", hash_original_method = "AFA08901CAEF730E40B185484FAABB29", hash_generated_method = "51B1EF82FD86735A6ED9F09B52B6A07E")
    public AttributedCharacterIterator getIterator(
            AttributedCharacterIterator.Attribute[] attributes) {
        addTaint(attributes[0].getTaint());
AttributedCharacterIterator var52C3F1C9CCF48C54D0F98704FFC0C943_403331709 =         new AttributedIterator(this, attributes, 0, text.length());
        var52C3F1C9CCF48C54D0F98704FFC0C943_403331709.addTaint(taint);
        return var52C3F1C9CCF48C54D0F98704FFC0C943_403331709;
        // ---------- Original Method ----------
        //return new AttributedIterator(this, attributes, 0, text.length());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.540 -0400", hash_original_method = "EF8FB9411A496C9D99CDE8B83C48CE6B", hash_generated_method = "0BC40C6AC1F0127AEC45AC157B38962C")
    public AttributedCharacterIterator getIterator(
            AttributedCharacterIterator.Attribute[] attributes, int start,
            int end) {
        addTaint(end);
        addTaint(start);
        addTaint(attributes[0].getTaint());
AttributedCharacterIterator var04CD81DC23CA8D46DA7FC302651498EC_1728950227 =         new AttributedIterator(this, attributes, start, end);
        var04CD81DC23CA8D46DA7FC302651498EC_1728950227.addTaint(taint);
        return var04CD81DC23CA8D46DA7FC302651498EC_1728950227;
        // ---------- Original Method ----------
        //return new AttributedIterator(this, attributes, start, end);
    }

    
    static class Range {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.540 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

        int start;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.540 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "302E5A3147803830441A79AED31F4022")

        int end;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.540 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.541 -0400", hash_original_method = "9919123D3D1FFC7D42BA1CB1CAFB2DA5", hash_generated_method = "8228AF779F86680294F263E155884242")
          Range(int s, int e, Object v) {
            start = s;
            end = e;
            value = v;
            // ---------- Original Method ----------
            //start = s;
            //end = e;
            //value = v;
        }

        
    }


    
    static class AttributedIterator implements AttributedCharacterIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.541 -0400", hash_original_field = "8D589AFA4DFAEEED85FFF5AA78E5FF6A", hash_generated_field = "D0C174A901D805EE41B6CF46156FC355")

        private int begin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.541 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

        private int end;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.541 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

        private int offset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.541 -0400", hash_original_field = "2C8BD562555E6AE4F52959440C6BA23B", hash_generated_field = "D02499DC7F8023F8CAFDC0A4B220FECC")

        private AttributedString attrString;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.541 -0400", hash_original_field = "FF2C1866830EA081CCEAD6E49749026E", hash_generated_field = "8E1D222DFFE5F062ACF483541B60F0D5")

        private HashSet<Attribute> attributesAllowed;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.542 -0400", hash_original_method = "E441422DE6FDEDB0F1BB74606A67171C", hash_generated_method = "7AE495FC46AA7C0AB1D4C3ED30DBE5AF")
          AttributedIterator(AttributedString attrString) {
            this.attrString = attrString;
            begin = 0;
            end = attrString.text.length();
            offset = 0;
            // ---------- Original Method ----------
            //this.attrString = attrString;
            //begin = 0;
            //end = attrString.text.length();
            //offset = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.543 -0400", hash_original_method = "43841E67E512106866A3902EDBE2D718", hash_generated_method = "F2BD11736D7C6FA1689BAFD861862459")
          AttributedIterator(AttributedString attrString,
                AttributedCharacterIterator.Attribute[] attributes, int begin,
                int end) {
            addTaint(attributes[0].getTaint());
            if(begin < 0 || end > attrString.text.length() || begin > end)            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1747418786 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_1747418786.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_1747418786;
            } //End block
            this.begin = begin;
            this.end = end;
            offset = begin;
            this.attrString = attrString;
            if(attributes != null)            
            {
                HashSet<Attribute> set = new HashSet<Attribute>(
                        (attributes.length * 4 / 3) + 1);
for(int i = attributes.length;--i >= 0;)
                {
                    set.add(attributes[i]);
                } //End block
                attributesAllowed = set;
            } //End block
            // ---------- Original Method ----------
            //if (begin < 0 || end > attrString.text.length() || begin > end) {
                //throw new IllegalArgumentException();
            //}
            //this.begin = begin;
            //this.end = end;
            //offset = begin;
            //this.attrString = attrString;
            //if (attributes != null) {
                //HashSet<Attribute> set = new HashSet<Attribute>(
                        //(attributes.length * 4 / 3) + 1);
                //for (int i = attributes.length; --i >= 0;) {
                    //set.add(attributes[i]);
                //}
                //attributesAllowed = set;
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.543 -0400", hash_original_method = "CC2190075ADAC44CCBDC93141CA9BE6C", hash_generated_method = "1EDC0ED4D4A27930241BD0A6204FB34C")
        @Override
        @SuppressWarnings("unchecked")
        public Object clone() {
            try 
            {
                AttributedIterator clone = (AttributedIterator) super.clone();
                if(attributesAllowed != null)                
                {
                    clone.attributesAllowed = (HashSet<Attribute>) attributesAllowed
                            .clone();
                } //End block
Object var3DE52045BFD3C1BF3742F994ED6139AD_932780858 =                 clone;
                var3DE52045BFD3C1BF3742F994ED6139AD_932780858.addTaint(taint);
                return var3DE52045BFD3C1BF3742F994ED6139AD_932780858;
            } //End block
            catch (CloneNotSupportedException e)
            {
                AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_83863785 = new AssertionError(e);
                varA5A331D65C8C3F32D42E49D64BCF4109_83863785.addTaint(taint);
                throw varA5A331D65C8C3F32D42E49D64BCF4109_83863785;
            } //End block
            // ---------- Original Method ----------
            //try {
                //AttributedIterator clone = (AttributedIterator) super.clone();
                //if (attributesAllowed != null) {
                    //clone.attributesAllowed = (HashSet<Attribute>) attributesAllowed
                            //.clone();
                //}
                //return clone;
            //} catch (CloneNotSupportedException e) {
                //throw new AssertionError(e);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.543 -0400", hash_original_method = "81A9D498AF1F73C3D962F8C3EDD6D3D9", hash_generated_method = "190EC57A6B933097C68D21C51A5DD8EC")
        public char current() {
            if(offset == end)            
            {
                char var2BA22E58CA17BB728D522BBA36CF8350_1356560132 = (DONE);
                                char varA87DEB01C5F539E6BDA34829C8EF2368_1034996216 = getTaintChar();
                return varA87DEB01C5F539E6BDA34829C8EF2368_1034996216;
            } //End block
            char varD4DF8E0D19A4AC464C0D3F857EEA5AE1_1952149396 = (attrString.text.charAt(offset));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1763183966 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1763183966;
            // ---------- Original Method ----------
            //if (offset == end) {
                //return DONE;
            //}
            //return attrString.text.charAt(offset);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.544 -0400", hash_original_method = "4AF9D055D17E58470820B415A8EBAFA4", hash_generated_method = "C46A08D99628B74D125A157718C354A1")
        public char first() {
            if(begin == end)            
            {
                char var2BA22E58CA17BB728D522BBA36CF8350_1315940370 = (DONE);
                                char varA87DEB01C5F539E6BDA34829C8EF2368_1372209619 = getTaintChar();
                return varA87DEB01C5F539E6BDA34829C8EF2368_1372209619;
            } //End block
            offset = begin;
            char varD4DF8E0D19A4AC464C0D3F857EEA5AE1_1329361645 = (attrString.text.charAt(offset));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_954216126 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_954216126;
            // ---------- Original Method ----------
            //if (begin == end) {
                //return DONE;
            //}
            //offset = begin;
            //return attrString.text.charAt(offset);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.544 -0400", hash_original_method = "1D4D2C19F23B97FE6ECF3D3284916FD4", hash_generated_method = "937F5C981D67B88DEEAC9D17E0149AB2")
        public int getBeginIndex() {
            int var8D589AFA4DFAEEED85FFF5AA78E5FF6A_126831578 = (begin);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_977096157 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_977096157;
            // ---------- Original Method ----------
            //return begin;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.544 -0400", hash_original_method = "2693C2AA223CB37D0504CD257C6327BC", hash_generated_method = "C8B8879117930770D92D21554569DC21")
        public int getEndIndex() {
            int var7F021A1415B86F2D013B2618FB31AE53_731006887 = (end);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125076435 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125076435;
            // ---------- Original Method ----------
            //return end;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.544 -0400", hash_original_method = "0952456464DB8DF9DBB7507E3C2ED53C", hash_generated_method = "E332C6A415BE5653745153ADB8167D82")
        public int getIndex() {
            int var7A86C157EE9713C34FBD7A1EE40F0C5A_1232238429 = (offset);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1902701748 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1902701748;
            // ---------- Original Method ----------
            //return offset;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.565 -0400", hash_original_method = "20101C80E99D94E4CD68776989F0B447", hash_generated_method = "83B7A4B1FE66725A6A8200ED558401EE")
        private boolean inRange(Range range) {
            addTaint(range.getTaint());
            if(!(range.value instanceof Annotation))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_752566008 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_72418257 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_72418257;
            } //End block
            boolean var62A7BFAE3446FF68A4D9D5F636A17930_231468962 = (range.start >= begin && range.start < end
                    && range.end > begin && range.end <= end);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1110459416 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1110459416;
            // ---------- Original Method ----------
            //if (!(range.value instanceof Annotation)) {
                //return true;
            //}
            //return range.start >= begin && range.start < end
                    //&& range.end > begin && range.end <= end;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.566 -0400", hash_original_method = "D282867E9466B5652FFBD5F7BCA71B9B", hash_generated_method = "B7BA13ED47D370C7C51160D86548B0C8")
        private boolean inRange(List<Range> ranges) {
            addTaint(ranges.getTaint());
            Iterator<Range> it = ranges.iterator();
            while
(it.hasNext())            
            {
                Range range = it.next();
                if(range.start >= begin && range.start < end)                
                {
                    boolean var56EC510F15525296BCCE24CE7196981D_1406944720 = (!(range.value instanceof Annotation)
                            || (range.end > begin && range.end <= end));
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1651744762 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1651744762;
                } //End block
                else
                if(range.end > begin && range.end <= end)                
                {
                    boolean varCB1279ACCFA4A38C846532FD1C58550A_1543749568 = (!(range.value instanceof Annotation)
                            || (range.start >= begin && range.start < end));
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_35419430 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_35419430;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_859616424 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_57351661 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_57351661;
            // ---------- Original Method ----------
            //Iterator<Range> it = ranges.iterator();
            //while (it.hasNext()) {
                //Range range = it.next();
                //if (range.start >= begin && range.start < end) {
                    //return !(range.value instanceof Annotation)
                            //|| (range.end > begin && range.end <= end);
                //} else if (range.end > begin && range.end <= end) {
                    //return !(range.value instanceof Annotation)
                            //|| (range.start >= begin && range.start < end);
                //}
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.566 -0400", hash_original_method = "1F90FC3406D3E88B418E6F5A05B249D4", hash_generated_method = "7A26C4DB6559D94816947511DA79A645")
        public Set<AttributedIterator.Attribute> getAllAttributeKeys() {
            if(begin == 0 && end == attrString.text.length()
                    && attributesAllowed == null)            
            {
Set<AttributedIterator.Attribute> varAF881EDCE1569E28E17DBC7776AF3CBE_1882664349 =                 attrString.attributeMap.keySet();
                varAF881EDCE1569E28E17DBC7776AF3CBE_1882664349.addTaint(taint);
                return varAF881EDCE1569E28E17DBC7776AF3CBE_1882664349;
            } //End block
            Set<AttributedIterator.Attribute> result = new HashSet<Attribute>(
                    (attrString.attributeMap.size() * 4 / 3) + 1);
            Iterator<Map.Entry<Attribute, List<Range>>> it = attrString.attributeMap
                    .entrySet().iterator();
            while
(it.hasNext())            
            {
                Map.Entry<Attribute, List<Range>> entry = it.next();
                if(attributesAllowed == null
                        || attributesAllowed.contains(entry.getKey()))                
                {
                    List<Range> ranges = entry.getValue();
                    if(inRange(ranges))                    
                    {
                        result.add(entry.getKey());
                    } //End block
                } //End block
            } //End block
Set<AttributedIterator.Attribute> varDC838461EE2FA0CA4C9BBB70A15456B0_606233894 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_606233894.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_606233894;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.566 -0400", hash_original_method = "7F47FD199B74CEDC765420E2B0AD1B85", hash_generated_method = "C60283ACFE619CB7E557000762FFEAE0")
        private Object currentValue(List<Range> ranges) {
            addTaint(ranges.getTaint());
            Iterator<Range> it = ranges.iterator();
            while
(it.hasNext())            
            {
                Range range = it.next();
                if(offset >= range.start && offset < range.end)                
                {
Object varB67D0A824E88AD91A910EE769EA3F925_893875366 =                     inRange(range) ? range.value : null;
                    varB67D0A824E88AD91A910EE769EA3F925_893875366.addTaint(taint);
                    return varB67D0A824E88AD91A910EE769EA3F925_893875366;
                } //End block
            } //End block
Object var540C13E9E156B687226421B24F2DF178_1783333192 =             null;
            var540C13E9E156B687226421B24F2DF178_1783333192.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1783333192;
            // ---------- Original Method ----------
            //Iterator<Range> it = ranges.iterator();
            //while (it.hasNext()) {
                //Range range = it.next();
                //if (offset >= range.start && offset < range.end) {
                    //return inRange(range) ? range.value : null;
                //}
            //}
            //return null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.567 -0400", hash_original_method = "9256DFDAE9CB8C43C18A44C8B3AC6DAC", hash_generated_method = "74C2393D775666E348A871E22FC94CFC")
        public Object getAttribute(
                AttributedCharacterIterator.Attribute attribute) {
            addTaint(attribute.getTaint());
            if(attributesAllowed != null
                    && !attributesAllowed.contains(attribute))            
            {
Object var540C13E9E156B687226421B24F2DF178_1450351835 =                 null;
                var540C13E9E156B687226421B24F2DF178_1450351835.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1450351835;
            } //End block
            ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            if(ranges == null)            
            {
Object var540C13E9E156B687226421B24F2DF178_1314016369 =                 null;
                var540C13E9E156B687226421B24F2DF178_1314016369.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1314016369;
            } //End block
Object var4BF3C7A8DC3CB9DB5225B86D6F9EDADE_23684027 =             currentValue(ranges);
            var4BF3C7A8DC3CB9DB5225B86D6F9EDADE_23684027.addTaint(taint);
            return var4BF3C7A8DC3CB9DB5225B86D6F9EDADE_23684027;
            // ---------- Original Method ----------
            //if (attributesAllowed != null
                    //&& !attributesAllowed.contains(attribute)) {
                //return null;
            //}
            //ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    //.get(attribute);
            //if (ranges == null) {
                //return null;
            //}
            //return currentValue(ranges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.567 -0400", hash_original_method = "AAAFE2E009783E25A93A8B590538D893", hash_generated_method = "AE7F14082C0A9E1545F9821DB28D37B2")
        public Map<Attribute, Object> getAttributes() {
            Map<Attribute, Object> result = new HashMap<Attribute, Object>(
                    (attrString.attributeMap.size() * 4 / 3) + 1);
            Iterator<Map.Entry<Attribute, List<Range>>> it = attrString.attributeMap
                    .entrySet().iterator();
            while
(it.hasNext())            
            {
                Map.Entry<Attribute, List<Range>> entry = it.next();
                if(attributesAllowed == null
                        || attributesAllowed.contains(entry.getKey()))                
                {
                    Object value = currentValue(entry.getValue());
                    if(value != null)                    
                    {
                        result.put(entry.getKey(), value);
                    } //End block
                } //End block
            } //End block
Map<Attribute, Object> varDC838461EE2FA0CA4C9BBB70A15456B0_1212282340 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1212282340.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1212282340;
            // ---------- Original Method ----------
            //Map<Attribute, Object> result = new HashMap<Attribute, Object>(
                    //(attrString.attributeMap.size() * 4 / 3) + 1);
            //Iterator<Map.Entry<Attribute, List<Range>>> it = attrString.attributeMap
                    //.entrySet().iterator();
            //while (it.hasNext()) {
                //Map.Entry<Attribute, List<Range>> entry = it.next();
                //if (attributesAllowed == null
                        //|| attributesAllowed.contains(entry.getKey())) {
                    //Object value = currentValue(entry.getValue());
                    //if (value != null) {
                        //result.put(entry.getKey(), value);
                    //}
                //}
            //}
            //return result;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.567 -0400", hash_original_method = "B67CDF67136100A9ADF2991D47BD9A14", hash_generated_method = "3F322BF505FE36B659F53178032F0A0E")
        public int getRunLimit() {
            int varF48E71281B9957BEF8C9D8BC031D9F77_1372122685 = (getRunLimit(getAllAttributeKeys()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_977154566 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_977154566;
            // ---------- Original Method ----------
            //return getRunLimit(getAllAttributeKeys());
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.567 -0400", hash_original_method = "40F484258D42E498FCA29FFC5F596001", hash_generated_method = "C0B6066A7B7B170D599DA3CD3F5AE957")
        private int runLimit(List<Range> ranges) {
            addTaint(ranges.getTaint());
            int result = end;
            ListIterator<Range> it = ranges.listIterator(ranges.size());
            while
(it.hasPrevious())            
            {
                Range range = it.previous();
                if(range.end <= begin)                
                {
                    break;
                } //End block
                if(offset >= range.start && offset < range.end)                
                {
                    int var3AA2D2BBBB2DE1BB01F490FA3C462E8A_371893410 = (inRange(range) ? range.end : result);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485623232 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485623232;
                } //End block
                else
                if(offset >= range.end)                
                {
                    break;
                } //End block
                result = range.start;
            } //End block
            int varB4A88417B3D0170D754C647C30B7216A_1861427923 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318281353 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318281353;
            // ---------- Original Method ----------
            //int result = end;
            //ListIterator<Range> it = ranges.listIterator(ranges.size());
            //while (it.hasPrevious()) {
                //Range range = it.previous();
                //if (range.end <= begin) {
                    //break;
                //}
                //if (offset >= range.start && offset < range.end) {
                    //return inRange(range) ? range.end : result;
                //} else if (offset >= range.end) {
                    //break;
                //}
                //result = range.start;
            //}
            //return result;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.567 -0400", hash_original_method = "F819F4AC98ED7B00F15856104CEA6D7F", hash_generated_method = "05D829CADAB60820BD5A2FDCFCAE40F0")
        public int getRunLimit(AttributedCharacterIterator.Attribute attribute) {
            addTaint(attribute.getTaint());
            if(attributesAllowed != null
                    && !attributesAllowed.contains(attribute))            
            {
                int var7F021A1415B86F2D013B2618FB31AE53_1165527177 = (end);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2004100396 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2004100396;
            } //End block
            ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            if(ranges == null)            
            {
                int var7F021A1415B86F2D013B2618FB31AE53_2045023747 = (end);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657536417 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657536417;
            } //End block
            int var195F39D37541819E68527A355035B59E_1534442556 = (runLimit(ranges));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254140530 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254140530;
            // ---------- Original Method ----------
            //if (attributesAllowed != null
                    //&& !attributesAllowed.contains(attribute)) {
                //return end;
            //}
            //ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    //.get(attribute);
            //if (ranges == null) {
                //return end;
            //}
            //return runLimit(ranges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.568 -0400", hash_original_method = "39CD1571C1B0AAE61A932D3B1E130DFE", hash_generated_method = "64EB03F74188701A17F738718A89F70B")
        public int getRunLimit(Set<? extends Attribute> attributes) {
            addTaint(attributes.getTaint());
            int limit = end;
            Iterator<? extends Attribute> it = attributes.iterator();
            while
(it.hasNext())            
            {
                AttributedCharacterIterator.Attribute attribute = it.next();
                int newLimit = getRunLimit(attribute);
                if(newLimit < limit)                
                {
                    limit = newLimit;
                } //End block
            } //End block
            int varAA9F73EEA60A006820D0F8768BC8A3FC_1339338475 = (limit);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461662656 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461662656;
            // ---------- Original Method ----------
            //int limit = end;
            //Iterator<? extends Attribute> it = attributes.iterator();
            //while (it.hasNext()) {
                //AttributedCharacterIterator.Attribute attribute = it.next();
                //int newLimit = getRunLimit(attribute);
                //if (newLimit < limit) {
                    //limit = newLimit;
                //}
            //}
            //return limit;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.568 -0400", hash_original_method = "FE3F08CD8D40BCC02EAAB9CF9D349F73", hash_generated_method = "24C197821E96FB2ECC4EB0007FE51CFB")
        public int getRunStart() {
            int var66EF06154BA045D7B60A2F9B84A03690_796571034 = (getRunStart(getAllAttributeKeys()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1621075805 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1621075805;
            // ---------- Original Method ----------
            //return getRunStart(getAllAttributeKeys());
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.568 -0400", hash_original_method = "3940F742081E74CA234FF11DA5FD3120", hash_generated_method = "1B2ECBF777A2D0DB15B58D7B9D784527")
        private int runStart(List<Range> ranges) {
            addTaint(ranges.getTaint());
            int result = begin;
            Iterator<Range> it = ranges.iterator();
            while
(it.hasNext())            
            {
                Range range = it.next();
                if(range.start >= end)                
                {
                    break;
                } //End block
                if(offset >= range.start && offset < range.end)                
                {
                    int var00C82408181A96F2AA3DB07594325758_1384912562 = (inRange(range) ? range.start : result);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214443453 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214443453;
                } //End block
                else
                if(offset < range.start)                
                {
                    break;
                } //End block
                result = range.end;
            } //End block
            int varB4A88417B3D0170D754C647C30B7216A_131463800 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725492716 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725492716;
            // ---------- Original Method ----------
            //int result = begin;
            //Iterator<Range> it = ranges.iterator();
            //while (it.hasNext()) {
                //Range range = it.next();
                //if (range.start >= end) {
                    //break;
                //}
                //if (offset >= range.start && offset < range.end) {
                    //return inRange(range) ? range.start : result;
                //} else if (offset < range.start) {
                    //break;
                //}
                //result = range.end;
            //}
            //return result;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.568 -0400", hash_original_method = "D8F9F8B7D0C4F74D05FEF10E27E7F588", hash_generated_method = "1F724F50844537700EA6DEBC93CF3EAF")
        public int getRunStart(AttributedCharacterIterator.Attribute attribute) {
            addTaint(attribute.getTaint());
            if(attributesAllowed != null
                    && !attributesAllowed.contains(attribute))            
            {
                int var8D589AFA4DFAEEED85FFF5AA78E5FF6A_288499179 = (begin);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187159541 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187159541;
            } //End block
            ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            if(ranges == null)            
            {
                int var8D589AFA4DFAEEED85FFF5AA78E5FF6A_1635849653 = (begin);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088949001 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088949001;
            } //End block
            int varDCA12829FF4A29F1C1BB61C7F4648109_1837900955 = (runStart(ranges));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_575532465 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_575532465;
            // ---------- Original Method ----------
            //if (attributesAllowed != null
                    //&& !attributesAllowed.contains(attribute)) {
                //return begin;
            //}
            //ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    //.get(attribute);
            //if (ranges == null) {
                //return begin;
            //}
            //return runStart(ranges);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.568 -0400", hash_original_method = "62E2E3A1AAFB276945B722FDB547D45B", hash_generated_method = "2BF0CAC4E4BEF9F74EBD2610FCBA4E78")
        public int getRunStart(Set<? extends Attribute> attributes) {
            addTaint(attributes.getTaint());
            int start = begin;
            Iterator<? extends Attribute> it = attributes.iterator();
            while
(it.hasNext())            
            {
                AttributedCharacterIterator.Attribute attribute = it.next();
                int newStart = getRunStart(attribute);
                if(newStart > start)                
                {
                    start = newStart;
                } //End block
            } //End block
            int varEA2B2676C28C0DB26D39331A336C6B92_2051941907 = (start);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331961454 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331961454;
            // ---------- Original Method ----------
            //int start = begin;
            //Iterator<? extends Attribute> it = attributes.iterator();
            //while (it.hasNext()) {
                //AttributedCharacterIterator.Attribute attribute = it.next();
                //int newStart = getRunStart(attribute);
                //if (newStart > start) {
                    //start = newStart;
                //}
            //}
            //return start;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.569 -0400", hash_original_method = "6CAD62DAB178D2919A2036BE42DEC497", hash_generated_method = "DA4931286B580DE064422EC7BFC82844")
        public char last() {
            if(begin == end)            
            {
                char var2BA22E58CA17BB728D522BBA36CF8350_1051655123 = (DONE);
                                char varA87DEB01C5F539E6BDA34829C8EF2368_1675134224 = getTaintChar();
                return varA87DEB01C5F539E6BDA34829C8EF2368_1675134224;
            } //End block
            offset = end - 1;
            char varD4DF8E0D19A4AC464C0D3F857EEA5AE1_1559981586 = (attrString.text.charAt(offset));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1615145733 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1615145733;
            // ---------- Original Method ----------
            //if (begin == end) {
                //return DONE;
            //}
            //offset = end - 1;
            //return attrString.text.charAt(offset);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.569 -0400", hash_original_method = "B623F272BE854A8CF15368B2FE2B8A97", hash_generated_method = "CF7166F5EEEBA855EEFFA40520B57578")
        public char next() {
            if(offset >= (end - 1))            
            {
                offset = end;
                char var2BA22E58CA17BB728D522BBA36CF8350_1015178241 = (DONE);
                                char varA87DEB01C5F539E6BDA34829C8EF2368_855408109 = getTaintChar();
                return varA87DEB01C5F539E6BDA34829C8EF2368_855408109;
            } //End block
            char var419DAA10799C8553B92F177610E8E624_61369751 = (attrString.text.charAt(++offset));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_988910216 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_988910216;
            // ---------- Original Method ----------
            //if (offset >= (end - 1)) {
                //offset = end;
                //return DONE;
            //}
            //return attrString.text.charAt(++offset);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.569 -0400", hash_original_method = "E77E60DF0F891730B03F44D98923AB66", hash_generated_method = "2BC3A18D915BE1C9FB958E2CE6E65C53")
        public char previous() {
            if(offset == begin)            
            {
                char var2BA22E58CA17BB728D522BBA36CF8350_712999783 = (DONE);
                                char varA87DEB01C5F539E6BDA34829C8EF2368_2069179935 = getTaintChar();
                return varA87DEB01C5F539E6BDA34829C8EF2368_2069179935;
            } //End block
            char var4A3BCB83410616D4485C3C43959A26B4_1358895573 = (attrString.text.charAt(--offset));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1810920607 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1810920607;
            // ---------- Original Method ----------
            //if (offset == begin) {
                //return DONE;
            //}
            //return attrString.text.charAt(--offset);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.569 -0400", hash_original_method = "C542CEFF91217DDB3083AD983C51F194", hash_generated_method = "C69BB1AD4474917F75F42637EF18114B")
        public char setIndex(int location) {
            if(location < begin || location > end)            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1487570251 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_1487570251.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_1487570251;
            } //End block
            offset = location;
            if(offset == end)            
            {
                char var2BA22E58CA17BB728D522BBA36CF8350_1039084096 = (DONE);
                                char varA87DEB01C5F539E6BDA34829C8EF2368_201395824 = getTaintChar();
                return varA87DEB01C5F539E6BDA34829C8EF2368_201395824;
            } //End block
            char varD4DF8E0D19A4AC464C0D3F857EEA5AE1_789707723 = (attrString.text.charAt(offset));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1142188586 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1142188586;
            // ---------- Original Method ----------
            //if (location < begin || location > end) {
                //throw new IllegalArgumentException();
            //}
            //offset = location;
            //if (offset == end) {
                //return DONE;
            //}
            //return attrString.text.charAt(offset);
        }

        
    }


    
}

