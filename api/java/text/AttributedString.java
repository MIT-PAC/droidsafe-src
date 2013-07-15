package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.910 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "9EF4B8A5DE4B8BD37EE465C3BB62CC6C")

    String text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.910 -0400", hash_original_field = "EC5B70424D6106D0D37EACD23354A330", hash_generated_field = "EA3CF0028C57B0F0FB6C371B620465D1")

    Map<AttributedCharacterIterator.Attribute, List<Range>> attributeMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.911 -0400", hash_original_method = "5638BBE38DFF9B04A672F4EC9A02409B", hash_generated_method = "A51193DACC009B9A0F49FC0DA5615B57")
    public  AttributedString(AttributedCharacterIterator iterator) {
        addTaint(iterator.getTaint());
    if(iterator.getBeginIndex() > iterator.getEndIndex())        
        {
            IllegalArgumentException varEA5C1AA17767DA731A134E095AD75FCD_1341637838 = new IllegalArgumentException("Invalid substring range");
            varEA5C1AA17767DA731A134E095AD75FCD_1341637838.addTaint(taint);
            throw varEA5C1AA17767DA731A134E095AD75FCD_1341637838;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.913 -0400", hash_original_method = "3A8973AD4EBE1F3B94E1633368C42F9D", hash_generated_method = "634949131C186B03865C2B115F846E2A")
    private  AttributedString(AttributedCharacterIterator iterator, int start,
            int end, Set<Attribute> attributes) {
        addTaint(end);
        addTaint(start);
        addTaint(iterator.getTaint());
    if(start < iterator.getBeginIndex() || end > iterator.getEndIndex()
                || start > end)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_2086677229 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_2086677229.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_2086677229;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.913 -0400", hash_original_method = "D0E1FC5545253EA6E008AE3675A9452F", hash_generated_method = "4626B692A0BDADD9D4B59FC620D439B6")
    public  AttributedString(AttributedCharacterIterator iterator, int start,
            int end) {
        this(iterator, start, end, iterator.getAllAttributeKeys());
        addTaint(end);
        addTaint(start);
        addTaint(iterator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.914 -0400", hash_original_method = "B4766721E168BC843A6EA06CFE59500E", hash_generated_method = "928450B8D7368B8EFBED1CDD7867A1D1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.914 -0400", hash_original_method = "A0ACF5D97B9D79B3295575A771939692", hash_generated_method = "319732FF47A4CEFFA4C9FF2E51344E0F")
    public  AttributedString(String value) {
    if(value == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1947582763 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1947582763.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1947582763;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.915 -0400", hash_original_method = "85CF866984BA31F6F3E97322323F86BA", hash_generated_method = "C47CE75053A78F4DC130372A5DC69BDC")
    public  AttributedString(String value,
            Map<? extends AttributedCharacterIterator.Attribute, ?> attributes) {
    if(value == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1691901318 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1691901318.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1691901318;
        } //End block
    if(value.length() == 0 && !attributes.isEmpty())        
        {
            IllegalArgumentException var931412BA27CF9259672C9348B0271FBB_353773640 = new IllegalArgumentException("Cannot add attributes to empty string");
            var931412BA27CF9259672C9348B0271FBB_353773640.addTaint(taint);
            throw var931412BA27CF9259672C9348B0271FBB_353773640;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.916 -0400", hash_original_method = "F800EB2F1E580436E49CB51D04E3F37C", hash_generated_method = "7633FED047BFD9AD18953C5FC98D7E7D")
    public void addAttribute(AttributedCharacterIterator.Attribute attribute, Object value) {
        addTaint(value.getTaint());
        addTaint(attribute.getTaint());
    if(attribute == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_45511544 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_45511544.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_45511544;
        } //End block
    if(text.length() == 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_111674605 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_111674605.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_111674605;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.919 -0400", hash_original_method = "1EA9CE9DE6197B4051F39E120F823C8E", hash_generated_method = "5FFB2050816CC48C33B16024C4DA4E93")
    public void addAttribute(AttributedCharacterIterator.Attribute attribute,
            Object value, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(value.getTaint());
        addTaint(attribute.getTaint());
    if(attribute == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_885191343 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_885191343.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_885191343;
        } //End block
    if(start < 0 || end > text.length() || start >= end)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_209364810 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_209364810.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_209364810;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.920 -0400", hash_original_method = "9BDF8CEEC650CFF21B203033378C7411", hash_generated_method = "8A7D4B516825A215343DE33607637FAD")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.920 -0400", hash_original_method = "3C3A14639543169375B4E8491231683C", hash_generated_method = "1120B6D0F2D978667C97CD8D127B3AB1")
    public AttributedCharacterIterator getIterator() {
AttributedCharacterIterator var46DD1405AD0D5C49D9EFCF18E2C00E51_1392194245 =         new AttributedIterator(this);
        var46DD1405AD0D5C49D9EFCF18E2C00E51_1392194245.addTaint(taint);
        return var46DD1405AD0D5C49D9EFCF18E2C00E51_1392194245;
        // ---------- Original Method ----------
        //return new AttributedIterator(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.921 -0400", hash_original_method = "AFA08901CAEF730E40B185484FAABB29", hash_generated_method = "53033B866CEBCBDAC2D12DCC4D8A6BD6")
    public AttributedCharacterIterator getIterator(
            AttributedCharacterIterator.Attribute[] attributes) {
        addTaint(attributes[0].getTaint());
AttributedCharacterIterator var52C3F1C9CCF48C54D0F98704FFC0C943_958515193 =         new AttributedIterator(this, attributes, 0, text.length());
        var52C3F1C9CCF48C54D0F98704FFC0C943_958515193.addTaint(taint);
        return var52C3F1C9CCF48C54D0F98704FFC0C943_958515193;
        // ---------- Original Method ----------
        //return new AttributedIterator(this, attributes, 0, text.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.921 -0400", hash_original_method = "EF8FB9411A496C9D99CDE8B83C48CE6B", hash_generated_method = "563E28E3EFC7CF3C254245D3732DA26D")
    public AttributedCharacterIterator getIterator(
            AttributedCharacterIterator.Attribute[] attributes, int start,
            int end) {
        addTaint(end);
        addTaint(start);
        addTaint(attributes[0].getTaint());
AttributedCharacterIterator var04CD81DC23CA8D46DA7FC302651498EC_785872935 =         new AttributedIterator(this, attributes, start, end);
        var04CD81DC23CA8D46DA7FC302651498EC_785872935.addTaint(taint);
        return var04CD81DC23CA8D46DA7FC302651498EC_785872935;
        // ---------- Original Method ----------
        //return new AttributedIterator(this, attributes, start, end);
    }

    
    static class Range {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.922 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

        int start;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.922 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "302E5A3147803830441A79AED31F4022")

        int end;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.922 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.923 -0400", hash_original_method = "9919123D3D1FFC7D42BA1CB1CAFB2DA5", hash_generated_method = "8228AF779F86680294F263E155884242")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.923 -0400", hash_original_field = "8D589AFA4DFAEEED85FFF5AA78E5FF6A", hash_generated_field = "D0C174A901D805EE41B6CF46156FC355")

        private int begin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.923 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

        private int end;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.923 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

        private int offset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.923 -0400", hash_original_field = "2C8BD562555E6AE4F52959440C6BA23B", hash_generated_field = "D02499DC7F8023F8CAFDC0A4B220FECC")

        private AttributedString attrString;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.923 -0400", hash_original_field = "FF2C1866830EA081CCEAD6E49749026E", hash_generated_field = "8E1D222DFFE5F062ACF483541B60F0D5")

        private HashSet<Attribute> attributesAllowed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.924 -0400", hash_original_method = "E441422DE6FDEDB0F1BB74606A67171C", hash_generated_method = "7AE495FC46AA7C0AB1D4C3ED30DBE5AF")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.925 -0400", hash_original_method = "43841E67E512106866A3902EDBE2D718", hash_generated_method = "B2786005CCAF9086EF649619D1238525")
          AttributedIterator(AttributedString attrString,
                AttributedCharacterIterator.Attribute[] attributes, int begin,
                int end) {
            addTaint(attributes[0].getTaint());
    if(begin < 0 || end > attrString.text.length() || begin > end)            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1504699577 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_1504699577.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_1504699577;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.926 -0400", hash_original_method = "CC2190075ADAC44CCBDC93141CA9BE6C", hash_generated_method = "0E65C9E6C10B14D21D3B9D1DBC476162")
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
Object var3DE52045BFD3C1BF3742F994ED6139AD_1686079388 =                 clone;
                var3DE52045BFD3C1BF3742F994ED6139AD_1686079388.addTaint(taint);
                return var3DE52045BFD3C1BF3742F994ED6139AD_1686079388;
            } //End block
            catch (CloneNotSupportedException e)
            {
                AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_692300071 = new AssertionError(e);
                varA5A331D65C8C3F32D42E49D64BCF4109_692300071.addTaint(taint);
                throw varA5A331D65C8C3F32D42E49D64BCF4109_692300071;
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

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.927 -0400", hash_original_method = "81A9D498AF1F73C3D962F8C3EDD6D3D9", hash_generated_method = "CBA664F93A8C4F618FCA06C3C9D48E21")
        public char current() {
    if(offset == end)            
            {
                char var2BA22E58CA17BB728D522BBA36CF8350_502576063 = (DONE);
                                char varA87DEB01C5F539E6BDA34829C8EF2368_1983125840 = getTaintChar();
                return varA87DEB01C5F539E6BDA34829C8EF2368_1983125840;
            } //End block
            char varD4DF8E0D19A4AC464C0D3F857EEA5AE1_675209609 = (attrString.text.charAt(offset));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1724640942 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1724640942;
            // ---------- Original Method ----------
            //if (offset == end) {
                //return DONE;
            //}
            //return attrString.text.charAt(offset);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.927 -0400", hash_original_method = "4AF9D055D17E58470820B415A8EBAFA4", hash_generated_method = "8878C71750ADBC03B29137C36A4AC803")
        public char first() {
    if(begin == end)            
            {
                char var2BA22E58CA17BB728D522BBA36CF8350_1993588190 = (DONE);
                                char varA87DEB01C5F539E6BDA34829C8EF2368_365495974 = getTaintChar();
                return varA87DEB01C5F539E6BDA34829C8EF2368_365495974;
            } //End block
            offset = begin;
            char varD4DF8E0D19A4AC464C0D3F857EEA5AE1_413822779 = (attrString.text.charAt(offset));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_645388508 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_645388508;
            // ---------- Original Method ----------
            //if (begin == end) {
                //return DONE;
            //}
            //offset = begin;
            //return attrString.text.charAt(offset);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.928 -0400", hash_original_method = "1D4D2C19F23B97FE6ECF3D3284916FD4", hash_generated_method = "14A14435D407A61DF3E5517780C46282")
        public int getBeginIndex() {
            int var8D589AFA4DFAEEED85FFF5AA78E5FF6A_267467491 = (begin);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149476209 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149476209;
            // ---------- Original Method ----------
            //return begin;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.928 -0400", hash_original_method = "2693C2AA223CB37D0504CD257C6327BC", hash_generated_method = "6C00364052DDBCA52C0A1CDECF8304BF")
        public int getEndIndex() {
            int var7F021A1415B86F2D013B2618FB31AE53_1722303095 = (end);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797804399 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797804399;
            // ---------- Original Method ----------
            //return end;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.928 -0400", hash_original_method = "0952456464DB8DF9DBB7507E3C2ED53C", hash_generated_method = "39FDBE312C15DAD59C710AC297822C2F")
        public int getIndex() {
            int var7A86C157EE9713C34FBD7A1EE40F0C5A_1567795764 = (offset);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260528493 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260528493;
            // ---------- Original Method ----------
            //return offset;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.929 -0400", hash_original_method = "20101C80E99D94E4CD68776989F0B447", hash_generated_method = "C694B04986642EE497449285EE42A925")
        private boolean inRange(Range range) {
            addTaint(range.getTaint());
    if(!(range.value instanceof Annotation))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_169234368 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_953243430 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_953243430;
            } //End block
            boolean var62A7BFAE3446FF68A4D9D5F636A17930_1606237427 = (range.start >= begin && range.start < end
                    && range.end > begin && range.end <= end);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_452785419 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_452785419;
            // ---------- Original Method ----------
            //if (!(range.value instanceof Annotation)) {
                //return true;
            //}
            //return range.start >= begin && range.start < end
                    //&& range.end > begin && range.end <= end;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.929 -0400", hash_original_method = "D282867E9466B5652FFBD5F7BCA71B9B", hash_generated_method = "5988B924AE24292AF2438F307788BB57")
        private boolean inRange(List<Range> ranges) {
            addTaint(ranges.getTaint());
            Iterator<Range> it = ranges.iterator();
            while
(it.hasNext())            
            {
                Range range = it.next();
    if(range.start >= begin && range.start < end)                
                {
                    boolean var56EC510F15525296BCCE24CE7196981D_496280250 = (!(range.value instanceof Annotation)
                            || (range.end > begin && range.end <= end));
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_367349089 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_367349089;
                } //End block
                else
    if(range.end > begin && range.end <= end)                
                {
                    boolean varCB1279ACCFA4A38C846532FD1C58550A_1352536084 = (!(range.value instanceof Annotation)
                            || (range.start >= begin && range.start < end));
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_971342278 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_971342278;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1999031688 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_456182213 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_456182213;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.930 -0400", hash_original_method = "1F90FC3406D3E88B418E6F5A05B249D4", hash_generated_method = "F468F7D5118877E498B789B7330879AE")
        public Set<AttributedIterator.Attribute> getAllAttributeKeys() {
    if(begin == 0 && end == attrString.text.length()
                    && attributesAllowed == null)            
            {
Set<AttributedIterator.Attribute> varAF881EDCE1569E28E17DBC7776AF3CBE_449274833 =                 attrString.attributeMap.keySet();
                varAF881EDCE1569E28E17DBC7776AF3CBE_449274833.addTaint(taint);
                return varAF881EDCE1569E28E17DBC7776AF3CBE_449274833;
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
Set<AttributedIterator.Attribute> varDC838461EE2FA0CA4C9BBB70A15456B0_1589386340 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1589386340.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1589386340;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.931 -0400", hash_original_method = "7F47FD199B74CEDC765420E2B0AD1B85", hash_generated_method = "60CA4530505984836FEC98C9886381DC")
        private Object currentValue(List<Range> ranges) {
            addTaint(ranges.getTaint());
            Iterator<Range> it = ranges.iterator();
            while
(it.hasNext())            
            {
                Range range = it.next();
    if(offset >= range.start && offset < range.end)                
                {
Object varB67D0A824E88AD91A910EE769EA3F925_737099070 =                     inRange(range) ? range.value : null;
                    varB67D0A824E88AD91A910EE769EA3F925_737099070.addTaint(taint);
                    return varB67D0A824E88AD91A910EE769EA3F925_737099070;
                } //End block
            } //End block
Object var540C13E9E156B687226421B24F2DF178_1753050163 =             null;
            var540C13E9E156B687226421B24F2DF178_1753050163.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1753050163;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.931 -0400", hash_original_method = "9256DFDAE9CB8C43C18A44C8B3AC6DAC", hash_generated_method = "F86E84706ECF3EA2F51CE49C407805E5")
        public Object getAttribute(
                AttributedCharacterIterator.Attribute attribute) {
            addTaint(attribute.getTaint());
    if(attributesAllowed != null
                    && !attributesAllowed.contains(attribute))            
            {
Object var540C13E9E156B687226421B24F2DF178_17709050 =                 null;
                var540C13E9E156B687226421B24F2DF178_17709050.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_17709050;
            } //End block
            ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
    if(ranges == null)            
            {
Object var540C13E9E156B687226421B24F2DF178_543111615 =                 null;
                var540C13E9E156B687226421B24F2DF178_543111615.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_543111615;
            } //End block
Object var4BF3C7A8DC3CB9DB5225B86D6F9EDADE_1114071949 =             currentValue(ranges);
            var4BF3C7A8DC3CB9DB5225B86D6F9EDADE_1114071949.addTaint(taint);
            return var4BF3C7A8DC3CB9DB5225B86D6F9EDADE_1114071949;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.932 -0400", hash_original_method = "AAAFE2E009783E25A93A8B590538D893", hash_generated_method = "EBDE108DE5699D446419B5742A3631C2")
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
Map<Attribute, Object> varDC838461EE2FA0CA4C9BBB70A15456B0_2013142045 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_2013142045.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_2013142045;
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

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.932 -0400", hash_original_method = "B67CDF67136100A9ADF2991D47BD9A14", hash_generated_method = "5DA3D83EFBA94A55A5673E2C0259E4AF")
        public int getRunLimit() {
            int varF48E71281B9957BEF8C9D8BC031D9F77_242084258 = (getRunLimit(getAllAttributeKeys()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807425939 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807425939;
            // ---------- Original Method ----------
            //return getRunLimit(getAllAttributeKeys());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.933 -0400", hash_original_method = "40F484258D42E498FCA29FFC5F596001", hash_generated_method = "FFA58E3E784E2E1F3D3F34EEC491D94E")
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
                    int var3AA2D2BBBB2DE1BB01F490FA3C462E8A_910693316 = (inRange(range) ? range.end : result);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2040783877 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2040783877;
                } //End block
                else
    if(offset >= range.end)                
                {
                    break;
                } //End block
                result = range.start;
            } //End block
            int varB4A88417B3D0170D754C647C30B7216A_57570889 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090430655 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090430655;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.934 -0400", hash_original_method = "F819F4AC98ED7B00F15856104CEA6D7F", hash_generated_method = "AA4B2289EF77C42348389AC42A78CE53")
        public int getRunLimit(AttributedCharacterIterator.Attribute attribute) {
            addTaint(attribute.getTaint());
    if(attributesAllowed != null
                    && !attributesAllowed.contains(attribute))            
            {
                int var7F021A1415B86F2D013B2618FB31AE53_1237422439 = (end);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_632211460 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_632211460;
            } //End block
            ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
    if(ranges == null)            
            {
                int var7F021A1415B86F2D013B2618FB31AE53_1405674069 = (end);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732428931 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732428931;
            } //End block
            int var195F39D37541819E68527A355035B59E_1452450415 = (runLimit(ranges));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_447715842 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_447715842;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.935 -0400", hash_original_method = "39CD1571C1B0AAE61A932D3B1E130DFE", hash_generated_method = "83B3E6C18209CADD2DB6CE378C013669")
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
            int varAA9F73EEA60A006820D0F8768BC8A3FC_2056047779 = (limit);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166416101 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166416101;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.935 -0400", hash_original_method = "FE3F08CD8D40BCC02EAAB9CF9D349F73", hash_generated_method = "93850A8ACF47C7F47C9D3FE87B584ED2")
        public int getRunStart() {
            int var66EF06154BA045D7B60A2F9B84A03690_1413160013 = (getRunStart(getAllAttributeKeys()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716420709 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716420709;
            // ---------- Original Method ----------
            //return getRunStart(getAllAttributeKeys());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.936 -0400", hash_original_method = "3940F742081E74CA234FF11DA5FD3120", hash_generated_method = "AF22B320C0D2616FD16928B471F0886A")
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
                    int var00C82408181A96F2AA3DB07594325758_588710385 = (inRange(range) ? range.start : result);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_171804383 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_171804383;
                } //End block
                else
    if(offset < range.start)                
                {
                    break;
                } //End block
                result = range.end;
            } //End block
            int varB4A88417B3D0170D754C647C30B7216A_964188825 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_976990319 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_976990319;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.938 -0400", hash_original_method = "D8F9F8B7D0C4F74D05FEF10E27E7F588", hash_generated_method = "DD1E24A5FC550526627E5CB508F35F5E")
        public int getRunStart(AttributedCharacterIterator.Attribute attribute) {
            addTaint(attribute.getTaint());
    if(attributesAllowed != null
                    && !attributesAllowed.contains(attribute))            
            {
                int var8D589AFA4DFAEEED85FFF5AA78E5FF6A_1605614962 = (begin);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214212921 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214212921;
            } //End block
            ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
    if(ranges == null)            
            {
                int var8D589AFA4DFAEEED85FFF5AA78E5FF6A_1826624786 = (begin);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1750330866 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1750330866;
            } //End block
            int varDCA12829FF4A29F1C1BB61C7F4648109_1608890186 = (runStart(ranges));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445013376 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445013376;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.939 -0400", hash_original_method = "62E2E3A1AAFB276945B722FDB547D45B", hash_generated_method = "86ECCC729F395CA9335CF67120A9D63D")
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
            int varEA2B2676C28C0DB26D39331A336C6B92_1497633251 = (start);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1086600508 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1086600508;
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

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.939 -0400", hash_original_method = "6CAD62DAB178D2919A2036BE42DEC497", hash_generated_method = "E975A70429735BF57E7D241395D38CE0")
        public char last() {
    if(begin == end)            
            {
                char var2BA22E58CA17BB728D522BBA36CF8350_1616022734 = (DONE);
                                char varA87DEB01C5F539E6BDA34829C8EF2368_1261413790 = getTaintChar();
                return varA87DEB01C5F539E6BDA34829C8EF2368_1261413790;
            } //End block
            offset = end - 1;
            char varD4DF8E0D19A4AC464C0D3F857EEA5AE1_2027407320 = (attrString.text.charAt(offset));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_796087839 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_796087839;
            // ---------- Original Method ----------
            //if (begin == end) {
                //return DONE;
            //}
            //offset = end - 1;
            //return attrString.text.charAt(offset);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.940 -0400", hash_original_method = "B623F272BE854A8CF15368B2FE2B8A97", hash_generated_method = "F69284B7830F38BF50C3BA189D13A6BE")
        public char next() {
    if(offset >= (end - 1))            
            {
                offset = end;
                char var2BA22E58CA17BB728D522BBA36CF8350_1992856504 = (DONE);
                                char varA87DEB01C5F539E6BDA34829C8EF2368_1712091670 = getTaintChar();
                return varA87DEB01C5F539E6BDA34829C8EF2368_1712091670;
            } //End block
            char var419DAA10799C8553B92F177610E8E624_1456945489 = (attrString.text.charAt(++offset));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_538232820 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_538232820;
            // ---------- Original Method ----------
            //if (offset >= (end - 1)) {
                //offset = end;
                //return DONE;
            //}
            //return attrString.text.charAt(++offset);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.940 -0400", hash_original_method = "E77E60DF0F891730B03F44D98923AB66", hash_generated_method = "AFCB65AA5998100D3B540EF76F6F921D")
        public char previous() {
    if(offset == begin)            
            {
                char var2BA22E58CA17BB728D522BBA36CF8350_1693693948 = (DONE);
                                char varA87DEB01C5F539E6BDA34829C8EF2368_450257118 = getTaintChar();
                return varA87DEB01C5F539E6BDA34829C8EF2368_450257118;
            } //End block
            char var4A3BCB83410616D4485C3C43959A26B4_490294526 = (attrString.text.charAt(--offset));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_154178431 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_154178431;
            // ---------- Original Method ----------
            //if (offset == begin) {
                //return DONE;
            //}
            //return attrString.text.charAt(--offset);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.941 -0400", hash_original_method = "C542CEFF91217DDB3083AD983C51F194", hash_generated_method = "568BBEE500D5D88035E254CF4D7CBC8B")
        public char setIndex(int location) {
    if(location < begin || location > end)            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1696507123 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_1696507123.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_1696507123;
            } //End block
            offset = location;
    if(offset == end)            
            {
                char var2BA22E58CA17BB728D522BBA36CF8350_1577363919 = (DONE);
                                char varA87DEB01C5F539E6BDA34829C8EF2368_2081655643 = getTaintChar();
                return varA87DEB01C5F539E6BDA34829C8EF2368_2081655643;
            } //End block
            char varD4DF8E0D19A4AC464C0D3F857EEA5AE1_1862038761 = (attrString.text.charAt(offset));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_682504957 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_682504957;
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

