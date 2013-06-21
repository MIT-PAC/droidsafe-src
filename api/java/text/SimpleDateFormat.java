package java.text;

import java.util.Date;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class SimpleDateFormat extends DateFormat {
	
	@DSModeled(DSC.SAFE)
	public SimpleDateFormat(String pattern) {
		addTaint(pattern.getTaint());
	}

	@Override
	@DSModeled(DSC.SAFE)
	public StringBuffer format(Date date, StringBuffer toAppendTo,
			FieldPosition fieldPosition) {
		addTaint(date.toString().getTaint());
		addTaint(toAppendTo.toString().getTaint());
		return new StringBuffer();
	}

	@Override
	@DSModeled(DSC.SAFE)
	public Date parse(String source, ParsePosition pos) {
		addTaint(source.getTaint());
		return new Date();
	}

	@Override
	public StringBuffer format(Object obj, StringBuffer toAppendTo,
			FieldPosition pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object parseObject(String source, ParsePosition pos) {
		// TODO Auto-generated method stub
		return null;
	}

}
