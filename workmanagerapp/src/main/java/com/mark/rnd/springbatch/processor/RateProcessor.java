package com.mark.rnd.springbatch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.mark.rnd.springbatch.entity.Rate;

@Component
public class RateProcessor implements ItemProcessor<Rate, Rate> {

	public Rate process(Rate rawRate) throws Exception {
		final String processedMarker = "xxxPROCESSEDxxx";
		Rate processedRate = new Rate();
		processedRate.setBranch(rawRate.getBranch() + processedMarker);
		processedRate.setXrateType(rawRate.getXrateType() + processedMarker);
		processedRate.setCurrency(rawRate.getCurrency() + processedMarker);
		processedRate.setQouteType(rawRate.getQouteType() + processedMarker);
		processedRate.setMidRate(rawRate.getMidRate() + processedMarker);
		processedRate.setCentralBankRate(rawRate.getCentralBankRate()
				+ processedMarker);
		processedRate.setBuySpread(rawRate.getBuySpread() + processedMarker);
		processedRate.setSellSpread(rawRate.getSellSpread() + processedMarker);
		processedRate.setBuyRate(rawRate.getBuyRate() + processedMarker);
		processedRate.setSellRate(rawRate.getSellRate() + processedMarker);
		return processedRate;
	}
}
