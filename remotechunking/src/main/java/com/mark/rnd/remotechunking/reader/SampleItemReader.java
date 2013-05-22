package com.mark.rnd.remotechunking.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.mark.rnd.remotechunking.entity.SampleEntity;

public class SampleItemReader implements ItemReader<SampleEntity> {

	private List<SampleEntity> entityList = new ArrayList<SampleEntity>();
	private AtomicInteger atomicIndex = new AtomicInteger();

	public SampleItemReader() {
		atomicIndex.set(0);
		for (int i = 0; i <= 1000; i++) {
			SampleEntity sampleEntity = new SampleEntity();
			sampleEntity.setId(i);
			sampleEntity.setName("Name:" + i);
			sampleEntity.setDescription("Description: " + i);
			entityList.add(sampleEntity);
		}
	}

	public SampleEntity read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		if (atomicIndex.get() == entityList.size()) {
			//null means end
			return null;
		}
		return entityList.get(atomicIndex.getAndIncrement());
	}

}
