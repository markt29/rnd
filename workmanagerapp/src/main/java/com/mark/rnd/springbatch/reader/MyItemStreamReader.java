package com.mark.rnd.springbatch.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import com.mark.rnd.springbatch.entity.Rate;

@Component
public class MyItemStreamReader implements ItemStreamReader<Rate> {

	private List<Rate> rateList = new ArrayList<Rate>();
	private AtomicInteger atomicIndex = new AtomicInteger();
	private String INDEX_KEY = "FlatFileItemWriter.written";// "rate.processed.index";

	public MyItemStreamReader() {
		for (int i = 0; i <= 100; i++) {
			Rate rate = new Rate();
			rate.setBranch("branch" + i);
			rate.setXrateType("xrateType" + i);
			rate.setCurrency("currency" + i);
			rate.setQouteType("qouteType" + i);
			rate.setMidRate("midRate" + i);
			rate.setCentralBankRate("centralBankRate" + i);
			rate.setBuySpread("buySpread" + i);
			rate.setSellSpread("sellSpread" + i);
			rate.setBuyRate("buyRate" + i);
			rate.setSellRate("sellRate" + i);
			rateList.add(rate);
		}
	}

	public void close() throws ItemStreamException {
		System.out.println("close start");
		System.out.println("close end");
	}

	public void open(ExecutionContext executionContext)
			throws ItemStreamException {
		System.out.println("open start:" + Thread.currentThread().getName());
		if (executionContext.containsKey(INDEX_KEY)) {
			int index = Integer.parseInt(String.valueOf(executionContext
					.getLong(INDEX_KEY)));
			System.out.println("index:" + index);
			atomicIndex.set(index);
		} else {
			atomicIndex.set(0);
		}
		System.out.println("open end:" + Thread.currentThread().getName());
	}

	public void update(ExecutionContext executionContext)
			throws ItemStreamException {
		// System.out.println("update start:" + Thread.currentThread().getName()
		// + ":" + atomicIndex.get());
		// executionContext.putInt(INDEX_KEY, atomicIndex.get());
		// System.out.println("update end:" + Thread.currentThread().getName()
		// + ":" + atomicIndex.get());
	}

	public Rate read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		System.out.println("read start:" + Thread.currentThread().getName()
				+ ":" + atomicIndex.get());
		Rate rate = null;
//		if (atomicIndex.get() > 20) {
//			throw new RuntimeException(
//					"Forced runtime exception when index is greater than 20");
//		}
		if (atomicIndex.get() < rateList.size()) {
			rate = rateList.get(atomicIndex.getAndIncrement());
		}
		System.out.println("read end:" + Thread.currentThread().getName() + ":"
				+ atomicIndex.get());

		return rate;

	}
}
