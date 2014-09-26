package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

import droidsafe.helpers.DSOnlyType;

public class DroidsafePendingResult implements PendingResult {

	public DroidsafePendingResult(DSOnlyType dontcare) {
		
	}
	
	@Override
	public Result await() {
		// TODO Auto-generated method stub
		Result res = new Status(getTaintInt());
		return res;
	}

	@Override
	public Result await(long l0, TimeUnit r1) {
		// TODO Auto-generated method stub
		Result res = new Status(getTaintInt());
		res.addTaint(l0);
		res.addTaint(r1.getTaintInt());
		return res;

	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCanceled() {
		// TODO Auto-generated method stub
		return getTaintBoolean();
	}

}
