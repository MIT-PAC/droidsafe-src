package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public enum TimeUnit {
    NANOSECONDS {
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.599 -0500", hash_original_method = "5A3BB1697B0C4B64A8068241CCE5D5C5", hash_generated_method = "BD70F916881E36DA5DF230A75A67A335")
        
public long toNanos(long d)   { return d; }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.602 -0500", hash_original_method = "B26D4C0CA4EAEF579D191C63A23322F6", hash_generated_method = "9C69D2622E891C6450BFBF348DABF395")
        
public long toMicros(long d)  { return d/(C1/C0); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.604 -0500", hash_original_method = "2A3538B933233C23032477C0A7C777D8", hash_generated_method = "EC966FE80A7FBCA1EC4EDA5326A62582")
        
public long toMillis(long d)  { return d/(C2/C0); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.606 -0500", hash_original_method = "E4449E154B5B0117300490EFA60ED904", hash_generated_method = "F4777B9AE6980BBE4F673927095A2E44")
        
public long toSeconds(long d) { return d/(C3/C0); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.609 -0500", hash_original_method = "3FC8EFB3B83D4B4146FE62C71523D960", hash_generated_method = "3E94F7384D9B5A51E059AC6982D12FBA")
        
public long toMinutes(long d) { return d/(C4/C0); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.612 -0500", hash_original_method = "E2C903F4707AE11CAAC038BE39C03DC1", hash_generated_method = "BA4DFEE17050D223B64AD32D8CEF13B8")
        
public long toHours(long d)   { return d/(C5/C0); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.614 -0500", hash_original_method = "9F9AB121E6BAC7AEAD3A0DCD05237779", hash_generated_method = "977D2A69BC2F6E65D3ECC182F3A27664")
        
public long toDays(long d)    { return d/(C6/C0); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.617 -0500", hash_original_method = "AD12EFFC3F8A8D5FD75D4397692F6489", hash_generated_method = "6FABC2B8AA13DB088324183332A0B814")
        
public long convert(long d, TimeUnit u) { return u.toNanos(d); }
        @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.619 -0500", hash_original_method = "BCFB0717E861CA1FD4286EEE5FCFD602", hash_generated_method = "BCFB0717E861CA1FD4286EEE5FCFD602")
        
int excessNanos(long d, long m) { return (int)(d - (m*C2)); }
    },
    MICROSECONDS {
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.622 -0500", hash_original_method = "0D77CEA8A46DB4045E63AD7EF1418D42", hash_generated_method = "EFE5615B124C368E3E3E787CC0CE6BC8")
        
public long toNanos(long d)   { return x(d, C1/C0, MAX/(C1/C0)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.624 -0500", hash_original_method = "F8C692747F76368798AFDAD846E51457", hash_generated_method = "9E4CB52C5A2B7E291E173E7E679E29BA")
        
public long toMicros(long d)  { return d; }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.627 -0500", hash_original_method = "6F3B61E78C500A3ACDD1E8FC69C7D359", hash_generated_method = "1338B91CA5691F497602B16770C3D97B")
        
public long toMillis(long d)  { return d/(C2/C1); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.629 -0500", hash_original_method = "A6B5B4F85BA40CFAB7BDE0FD2AD63072", hash_generated_method = "7346659F457FA568C2162E8FBD6A16BF")
        
public long toSeconds(long d) { return d/(C3/C1); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.632 -0500", hash_original_method = "D5B64BAA1A98045F95EAC55F732C3FB3", hash_generated_method = "2FB5A63B74795281EFDC84F1516D02EA")
        
public long toMinutes(long d) { return d/(C4/C1); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.635 -0500", hash_original_method = "AFD9ACE7C83BD32531D35204544C27B6", hash_generated_method = "B47B8052A2B13D429A69E9487DA837D9")
        
public long toHours(long d)   { return d/(C5/C1); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.637 -0500", hash_original_method = "4C8D3886084833000E7C10AC94C788BC", hash_generated_method = "4CE15CDC4D8AFEE12CE5B72BF49382A0")
        
public long toDays(long d)    { return d/(C6/C1); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.639 -0500", hash_original_method = "7582439DD95119D7C3713CB064B3B085", hash_generated_method = "6286790BE3FE635FE5E73CF787ECB456")
        
public long convert(long d, TimeUnit u) { return u.toMicros(d); }
        @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.642 -0500", hash_original_method = "DBA5C8A3FBB5937CEE49B6E512B472F6", hash_generated_method = "DBA5C8A3FBB5937CEE49B6E512B472F6")
        
int excessNanos(long d, long m) { return (int)((d*C1) - (m*C2)); }
    },
    MILLISECONDS {
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.645 -0500", hash_original_method = "77F0B80C63141051551F33624D2EAE7F", hash_generated_method = "E979EEF2907D534F0D8B9F4F8DF59B59")
        
public long toNanos(long d)   { return x(d, C2/C0, MAX/(C2/C0)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.648 -0500", hash_original_method = "CF4A5399BCAC084984BE470FCE6BA7E3", hash_generated_method = "83469C7840D75352CCE8A48B45FB8C97")
        
public long toMicros(long d)  { return x(d, C2/C1, MAX/(C2/C1)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.650 -0500", hash_original_method = "5C078795E01D4FA861AEBEB0BC27CFBA", hash_generated_method = "FC6B0D6F58B2C0CA14B5DA544F80990D")
        
public long toMillis(long d)  { return d; }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.653 -0500", hash_original_method = "FC611197BE66AE66BDC0E16F63CBDEBF", hash_generated_method = "5DF50075E94430A709D07E6F89883CD8")
        
public long toSeconds(long d) { return d/(C3/C2); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.655 -0500", hash_original_method = "66F6F852CDED8DE301BEA0043532B8EA", hash_generated_method = "9D52A67EA82E19E3449991B8856DAB19")
        
public long toMinutes(long d) { return d/(C4/C2); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.657 -0500", hash_original_method = "69F389D78FA63947D66B155CD2EC4C7F", hash_generated_method = "B7F96C3F9E0B90360A29788DDC91217E")
        
public long toHours(long d)   { return d/(C5/C2); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.660 -0500", hash_original_method = "E255F1FC21F7C81D5A74B60AB8B89538", hash_generated_method = "A976FD988AEB65C69D3DCDDF3E693304")
        
public long toDays(long d)    { return d/(C6/C2); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.662 -0500", hash_original_method = "2CDA81D3461F4349885613B47A33D9BD", hash_generated_method = "1C46CC9085E8CF68B5FBBF4634DD5F76")
        
public long convert(long d, TimeUnit u) { return u.toMillis(d); }
        @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.756 -0500", hash_original_method = "C13D751186CEAFB77DDF919689857B6D", hash_generated_method = "C13D751186CEAFB77DDF919689857B6D")
        
int excessNanos(long d, long m) { return 0; }
    },
    SECONDS {
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.668 -0500", hash_original_method = "94B978560589228DF8ED6B430E17E991", hash_generated_method = "0BD0B40ADC891DEFC08CA487B28A64B4")
        
public long toNanos(long d)   { return x(d, C3/C0, MAX/(C3/C0)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.670 -0500", hash_original_method = "CC8DD3DADB9AB473D5121FC84C3222D4", hash_generated_method = "8818B2DD32837179AA44EE83F22DD9B4")
        
public long toMicros(long d)  { return x(d, C3/C1, MAX/(C3/C1)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.673 -0500", hash_original_method = "041D848A2B246AC07652CB67812CBBAC", hash_generated_method = "7648174B13BB0481611BF15327CED988")
        
public long toMillis(long d)  { return x(d, C3/C2, MAX/(C3/C2)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.675 -0500", hash_original_method = "077D444F35D8B646D15EEE35869B24F9", hash_generated_method = "8BC3C00D32A720FB2ACC5929778655D5")
        
public long toSeconds(long d) { return d; }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.677 -0500", hash_original_method = "AFAC863074CD9E002A7E3221ED8D15E1", hash_generated_method = "00F0273B62451C6A41C0AAC101715229")
        
public long toMinutes(long d) { return d/(C4/C3); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.680 -0500", hash_original_method = "2B982907A52BA68382FA774F93A1D7BC", hash_generated_method = "6509D9F9A0234ADE2FB427CA1E05D984")
        
public long toHours(long d)   { return d/(C5/C3); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.682 -0500", hash_original_method = "3D3A4C023E74C7E6A5343E6FA9460569", hash_generated_method = "F1F68B5608842E207F3B49783BDC4596")
        
public long toDays(long d)    { return d/(C6/C3); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.684 -0500", hash_original_method = "E52263BC74BA291DA5A366D72DB46150", hash_generated_method = "DC03BE00956A2A68859F6261CB891549")
        
public long convert(long d, TimeUnit u) { return u.toSeconds(d); }
        
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int excessNanos(long d, long m) { return 0; }
    },
    MINUTES {
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.690 -0500", hash_original_method = "6E5350FCF76AC1936913793FE1648777", hash_generated_method = "1CA9715808DDD945E13BE7BA2A7634BB")
        
public long toNanos(long d)   { return x(d, C4/C0, MAX/(C4/C0)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.692 -0500", hash_original_method = "27E17FB430D08B01F8ECADBB4C17B6A4", hash_generated_method = "6AAEEED248EE3FC91623A383CDDF72D2")
        
public long toMicros(long d)  { return x(d, C4/C1, MAX/(C4/C1)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.696 -0500", hash_original_method = "D08EBA5D9305EBF49A2FF28F6D2EAB7A", hash_generated_method = "F7A73D25ED55C6B0D4C3DAFC47D2B375")
        
public long toMillis(long d)  { return x(d, C4/C2, MAX/(C4/C2)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.698 -0500", hash_original_method = "0591F16FB75BF3E9FDC7B79CB81357DF", hash_generated_method = "DC0C297E89028CA5F64920023EB7CF05")
        
public long toSeconds(long d) { return x(d, C4/C3, MAX/(C4/C3)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.701 -0500", hash_original_method = "E8C9CD58A51B0423D231CAF6D9FF38E9", hash_generated_method = "B3AC1AAE3BBC966C3C5A5E6562EFCACB")
        
public long toMinutes(long d) { return d; }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.703 -0500", hash_original_method = "3D3D046E4641B34AB48AD8A390C8DDD7", hash_generated_method = "27AC861AC77D4F56974A40E77531382C")
        
public long toHours(long d)   { return d/(C5/C4); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.706 -0500", hash_original_method = "6F818D840D79D6A92B18D73C4E605CCC", hash_generated_method = "8CCE955B6D13C36C47AB89BD053BFB23")
        
public long toDays(long d)    { return d/(C6/C4); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.708 -0500", hash_original_method = "E828B0AD5B842D0648FCF753305C1CB1", hash_generated_method = "B374929F6F9734022C766AA80DC26DF5")
        
public long convert(long d, TimeUnit u) { return u.toMinutes(d); }
        
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int excessNanos(long d, long m) { return 0; }
    },
    HOURS {
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.713 -0500", hash_original_method = "7B19B346E832D39D526469F13EC36D36", hash_generated_method = "C5BF5BB29B9DFF676991AB6B3F999968")
        
public long toNanos(long d)   { return x(d, C5/C0, MAX/(C5/C0)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.716 -0500", hash_original_method = "CE14B3106CDF32CF393E661E6D65690C", hash_generated_method = "B12ADAAA5343C1D3D60071B9E50091BE")
        
public long toMicros(long d)  { return x(d, C5/C1, MAX/(C5/C1)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.718 -0500", hash_original_method = "55A16A3ECD7F9AC86D55E3FBFAF80CF3", hash_generated_method = "6A36AB81E06BA3E7B94BBBED5A253EB5")
        
public long toMillis(long d)  { return x(d, C5/C2, MAX/(C5/C2)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.721 -0500", hash_original_method = "AC53F41266838B73BB4C9EA295F6CF21", hash_generated_method = "8FCA03F3B61E681187B4FC09A4DDBD79")
        
public long toSeconds(long d) { return x(d, C5/C3, MAX/(C5/C3)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.723 -0500", hash_original_method = "AEEE49E549C294827B5CC4956B24F2C4", hash_generated_method = "EE10276BDEE6ACAD59F8E7B6311B6B64")
        
public long toMinutes(long d) { return x(d, C5/C4, MAX/(C5/C4)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.725 -0500", hash_original_method = "D96C52CECBAB5106B5FE34114DE44EA5", hash_generated_method = "AA629C463EA553106BED9BD43ED3572B")
        
public long toHours(long d)   { return d; }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.727 -0500", hash_original_method = "C0ECC52C79F5E96227A612785B1E04B4", hash_generated_method = "83F906954D496EB484E2B5C87FE847C7")
        
public long toDays(long d)    { return d/(C6/C5); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.730 -0500", hash_original_method = "9ED6DE6F66E6C7FB1031F74041695D8B", hash_generated_method = "89AC0A6ADA6DC5E91EDCFEB9A54364AE")
        
public long convert(long d, TimeUnit u) { return u.toHours(d); }
        
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int excessNanos(long d, long m) { return 0; }
    },
    DAYS {
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.736 -0500", hash_original_method = "5AABE54F289D6CF1B97E7D6F5B762F64", hash_generated_method = "934B0B8DAAA4B6D3D3DEA4129B98CC6A")
        
public long toNanos(long d)   { return x(d, C6/C0, MAX/(C6/C0)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.739 -0500", hash_original_method = "BDE91BAB29F0EF1FE68DEC18F7541D4F", hash_generated_method = "DC2D04AEBEC0BDC4C8B6CB88ADD526E1")
        
public long toMicros(long d)  { return x(d, C6/C1, MAX/(C6/C1)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.741 -0500", hash_original_method = "138ACE569A9D01599722E8B63CFC3101", hash_generated_method = "5B308016EF60270164BE3376B41162E6")
        
public long toMillis(long d)  { return x(d, C6/C2, MAX/(C6/C2)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.744 -0500", hash_original_method = "4E687FF0B84E33ECCFBD5CCCCD27451E", hash_generated_method = "5DCDAA5C6B1E750ACA7A11993FDA9B00")
        
public long toSeconds(long d) { return x(d, C6/C3, MAX/(C6/C3)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.746 -0500", hash_original_method = "DE76E340CBB068EEA34558516357E1CD", hash_generated_method = "DD1711205520B99F4730229B08F57CF7")
        
public long toMinutes(long d) { return x(d, C6/C4, MAX/(C6/C4)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.749 -0500", hash_original_method = "5D844948FAFABD45968F71A8606DD02E", hash_generated_method = "A4DC343849A52D80424767F79F2C5DA5")
        
public long toHours(long d)   { return x(d, C6/C5, MAX/(C6/C5)); }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.751 -0500", hash_original_method = "0A796DB1D56C8F04A50037F7BF05A5FE", hash_generated_method = "A663313C824A1EC6CE09A18892C5BD23")
        
public long toDays(long d)    { return d; }
        @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.753 -0500", hash_original_method = "B06A317D4AEF754186F64EB2DF9099C1", hash_generated_method = "D57F7E4ED9C5708DA28DF76FE0FDA361")
        
public long convert(long d, TimeUnit u) { return u.toDays(d); }
        
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int excessNanos(long d, long m) { return 0; }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.758 -0500", hash_original_field = "41883E058A4D5BF3B3B351969A126F22", hash_generated_field = "3EDEA9D06D99DD008D88AA6A904F2541")

    static final long C0 = 1L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.761 -0500", hash_original_field = "775675EE3B85876DE1542F3FCE6D1B3B", hash_generated_field = "51CAC011022B58044FFC550756EB561C")

    static final long C1 = C0 * 1000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.764 -0500", hash_original_field = "66F6D3C0BB0589FDE023D9FF36C8E2D8", hash_generated_field = "07728A75F06465464B54F623DC85A018")

    static final long C2 = C1 * 1000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.766 -0500", hash_original_field = "2868D018ECCC5A2C986A21382A6AD0FE", hash_generated_field = "7A569E2A788050854F5F3A201BD46393")

    static final long C3 = C2 * 1000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.768 -0500", hash_original_field = "D712B82AA0FC0AE9DEBF398B90B12237", hash_generated_field = "7734563A71CE7D472D54810AA42AA608")

    static final long C4 = C3 * 60L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.771 -0500", hash_original_field = "364CAE3501E67CA4000AC2DAC9BB66FE", hash_generated_field = "ABA774BBFF3CBFC378CEB9EAD0D6AA13")

    static final long C5 = C4 * 60L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.773 -0500", hash_original_field = "1E815435229EF9705B28AE35DEC65113", hash_generated_field = "A892F849509490AB6680A45AC1CA4907")

    static final long C6 = C5 * 24L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.776 -0500", hash_original_field = "5AE27AA60A1C0B3B42E14F9CFAF99999", hash_generated_field = "76D049B98D4BF4AE7DC749FF1A3CB079")

    static final long MAX = Long.MAX_VALUE;

    /**
     * Scale d by m, checking for overflow.
     * This has a short name to make above code more readable.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.779 -0500", hash_original_method = "E02CBE850FB7AD3385FB8E996FCCE58C", hash_generated_method = "A13F25213CEBB0119215C3180DFD1DCE")
        
static long x(long d, long m, long over) {
        if (d >  over) return Long.MAX_VALUE;
        if (d < -over) return Long.MIN_VALUE;
        return d * m;
    }

    // To maintain full signature compatibility with 1.5, and to improve the
    // clarity of the generated javadoc (see 6287639: Abstract methods in
    // enum classes should not be listed as abstract), method convert
    // etc. are not declared abstract but otherwise act as abstract methods.

    /**
     * Convert the given time duration in the given unit to this
     * unit.  Conversions from finer to coarser granularities
     * truncate, so lose precision. For example converting
     * <tt>999</tt> milliseconds to seconds results in
     * <tt>0</tt>. Conversions from coarser to finer granularities
     * with arguments that would numerically overflow saturate to
     * <tt>Long.MIN_VALUE</tt> if negative or <tt>Long.MAX_VALUE</tt>
     * if positive.
     *
     * <p>For example, to convert 10 minutes to milliseconds, use:
     * <tt>TimeUnit.MILLISECONDS.convert(10L, TimeUnit.MINUTES)</tt>
     *
     * @param sourceDuration the time duration in the given <tt>sourceUnit</tt>
     * @param sourceUnit the unit of the <tt>sourceDuration</tt> argument
     * @return the converted duration in this unit,
     * or <tt>Long.MIN_VALUE</tt> if conversion would negatively
     * overflow, or <tt>Long.MAX_VALUE</tt> if it would positively overflow.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.781 -0500", hash_original_method = "2C4B498583C7989ABB0C3FA2FD47FC6A", hash_generated_method = "D432A3B313D247D87A6598806F1B2B6B")
        
public long convert(long sourceDuration, TimeUnit sourceUnit) {
        throw new AbstractMethodError();
    }

    /**
     * Equivalent to <tt>NANOSECONDS.convert(duration, this)</tt>.
     * @param duration the duration
     * @return the converted duration,
     * or <tt>Long.MIN_VALUE</tt> if conversion would negatively
     * overflow, or <tt>Long.MAX_VALUE</tt> if it would positively overflow.
     * @see #convert
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.784 -0500", hash_original_method = "9F3241E70E26E609D81CFE0E814CD897", hash_generated_method = "E772B59CD923655FB79BE394B9D76AE6")
        
public long toNanos(long duration) {
        throw new AbstractMethodError();
    }

    /**
     * Equivalent to <tt>MICROSECONDS.convert(duration, this)</tt>.
     * @param duration the duration
     * @return the converted duration,
     * or <tt>Long.MIN_VALUE</tt> if conversion would negatively
     * overflow, or <tt>Long.MAX_VALUE</tt> if it would positively overflow.
     * @see #convert
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.786 -0500", hash_original_method = "24E5DD68DD5E3A994A65C1B06980253B", hash_generated_method = "B23A2DD93994E84773D7BA0EA302AF9B")
        
public long toMicros(long duration) {
        throw new AbstractMethodError();
    }

    /**
     * Equivalent to <tt>MILLISECONDS.convert(duration, this)</tt>.
     * @param duration the duration
     * @return the converted duration,
     * or <tt>Long.MIN_VALUE</tt> if conversion would negatively
     * overflow, or <tt>Long.MAX_VALUE</tt> if it would positively overflow.
     * @see #convert
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.789 -0500", hash_original_method = "F299978D45112E13E1D2F56CD0380D63", hash_generated_method = "54DC496A58B06AD4B88964C77E6B1202")
        
public long toMillis(long duration) {
        throw new AbstractMethodError();
    }

    /**
     * Equivalent to <tt>SECONDS.convert(duration, this)</tt>.
     * @param duration the duration
     * @return the converted duration,
     * or <tt>Long.MIN_VALUE</tt> if conversion would negatively
     * overflow, or <tt>Long.MAX_VALUE</tt> if it would positively overflow.
     * @see #convert
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.791 -0500", hash_original_method = "35DEBE4949806A1B37ECD1E3FF068F9B", hash_generated_method = "80D8C8BE4540FBAE34176695897F71A0")
        
public long toSeconds(long duration) {
        throw new AbstractMethodError();
    }

    /**
     * Equivalent to <tt>MINUTES.convert(duration, this)</tt>.
     * @param duration the duration
     * @return the converted duration,
     * or <tt>Long.MIN_VALUE</tt> if conversion would negatively
     * overflow, or <tt>Long.MAX_VALUE</tt> if it would positively overflow.
     * @see #convert
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.793 -0500", hash_original_method = "10EEDDC6D14F0CA047CA7FDBD83F49DC", hash_generated_method = "E2298159D7B1F45E47430A460B3C7831")
        
public long toMinutes(long duration) {
        throw new AbstractMethodError();
    }

    /**
     * Equivalent to <tt>HOURS.convert(duration, this)</tt>.
     * @param duration the duration
     * @return the converted duration,
     * or <tt>Long.MIN_VALUE</tt> if conversion would negatively
     * overflow, or <tt>Long.MAX_VALUE</tt> if it would positively overflow.
     * @see #convert
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.796 -0500", hash_original_method = "92D1BDBF0366DE9FF1DF46828116B97F", hash_generated_method = "093036075E8085C49723C52533EA6A2A")
        
public long toHours(long duration) {
        throw new AbstractMethodError();
    }

    /**
     * Equivalent to <tt>DAYS.convert(duration, this)</tt>.
     * @param duration the duration
     * @return the converted duration
     * @see #convert
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.798 -0500", hash_original_method = "53D661FF4116F87F794EADAC9360AF1E", hash_generated_method = "F2DCE09A32D9BFD6A5B80DB0C0ACF4E4")
        
public long toDays(long duration) {
        throw new AbstractMethodError();
    }

    /**
     * Utility to compute the excess-nanosecond argument to wait,
     * sleep, join.
     * @param d the duration
     * @param m the number of milliseconds
     * @return the number of nanoseconds
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.801 -0500", hash_original_method = "E6640857FF4D832FA38F82E1242CC47C", hash_generated_method = "A2AEAC412E7A1D573C6A0B82B12FB8A8")
        
abstract int excessNanos(long d, long m);

    /**
     * Performs a timed {@link Object#wait(long, int) Object.wait}
     * using this time unit.
     * This is a convenience method that converts timeout arguments
     * into the form required by the <tt>Object.wait</tt> method.
     *
     * <p>For example, you could implement a blocking <tt>poll</tt>
     * method (see {@link BlockingQueue#poll BlockingQueue.poll})
     * using:
     *
     *  <pre> {@code
     * public synchronized Object poll(long timeout, TimeUnit unit)
     *     throws InterruptedException {
     *   while (empty) {
     *     unit.timedWait(this, timeout);
     *     ...
     *   }
     * }}</pre>
     *
     * @param obj the object to wait on
     * @param timeout the maximum time to wait. If less than
     * or equal to zero, do not wait at all.
     * @throws InterruptedException if interrupted while waiting
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.803 -0500", hash_original_method = "F663CCE919D23B5E3B6B4166AD4433DC", hash_generated_method = "C0E9343568290BF03C3549D974764AFA")
        
public void timedWait(Object obj, long timeout)
            throws InterruptedException {
        if (timeout > 0) {
            long ms = toMillis(timeout);
            int ns = excessNanos(timeout, ms);
            obj.wait(ms, ns);
        }
    }

    /**
     * Performs a timed {@link Thread#join(long, int) Thread.join}
     * using this time unit.
     * This is a convenience method that converts time arguments into the
     * form required by the <tt>Thread.join</tt> method.
     *
     * @param thread the thread to wait for
     * @param timeout the maximum time to wait. If less than
     * or equal to zero, do not wait at all.
     * @throws InterruptedException if interrupted while waiting
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.806 -0500", hash_original_method = "638CEC4A69055AD29CBBFF486CE83187", hash_generated_method = "DB8A6FCF74D1CC336DF422E6626809E7")
        
public void timedJoin(Thread thread, long timeout)
            throws InterruptedException {
        if (timeout > 0) {
            long ms = toMillis(timeout);
            int ns = excessNanos(timeout, ms);
            thread.join(ms, ns);
        }
    }

    /**
     * Performs a {@link Thread#sleep(long, int) Thread.sleep} using
     * this time unit.
     * This is a convenience method that converts time arguments into the
     * form required by the <tt>Thread.sleep</tt> method.
     *
     * @param timeout the minimum time to sleep. If less than
     * or equal to zero, do not sleep at all.
     * @throws InterruptedException if interrupted while sleeping
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:10.808 -0500", hash_original_method = "797B54766C0BB969AAABEF703EDDE4EF", hash_generated_method = "CF75CCD24EA0E4851817CC14AF8BF5D7")
        
public void sleep(long timeout) throws InterruptedException {
        if (timeout > 0) {
            long ms = toMillis(timeout);
            int ns = excessNanos(timeout, ms);
            Thread.sleep(ms, ns);
        }
    }
}
