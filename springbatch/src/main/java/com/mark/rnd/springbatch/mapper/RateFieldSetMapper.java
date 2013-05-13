package com.mark.rnd.springbatch.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.mark.rnd.springbatch.entity.Rate;

public class RateFieldSetMapper implements FieldSetMapper<Rate> {

	public Rate mapFieldSet(FieldSet fieldSet) throws BindException {
		Rate rate = new Rate();

		rate.setBranch(fieldSet.readString("branch"));
		rate.setXrateType(fieldSet.readString("xrateType"));
		rate.setCurrency(fieldSet.readString("currency"));
		rate.setQouteType(fieldSet.readString("qouteType"));
		rate.setMidRate(fieldSet.readString("midRate"));
		rate.setCentralBankRate(fieldSet.readString("centralBankRate"));
		rate.setBuySpread(fieldSet.readString("buySpread"));
		rate.setSellSpread(fieldSet.readString("sellSpread"));
		rate.setBuyRate(fieldSet.readString("buyRate"));
		rate.setSellRate(fieldSet.readString("sellRate"));

		return rate;
	}
}
