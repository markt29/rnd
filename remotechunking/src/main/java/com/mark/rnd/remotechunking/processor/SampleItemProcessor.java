package com.mark.rnd.remotechunking.processor;

import org.springframework.batch.item.ItemProcessor;

import com.mark.rnd.remotechunking.entity.SampleEntity;

public class SampleItemProcessor implements
		ItemProcessor<SampleEntity, SampleEntity> {

	public SampleEntity process(SampleEntity sampleEntity) throws Exception {
		System.out
				.println("process start: " + Thread.currentThread().getName());
		SampleEntity processedEntity = new SampleEntity();
		processedEntity.setId(sampleEntity.getId());
		processedEntity.setName(sampleEntity.getName() + "xxxProcessedxxx");
		processedEntity.setDescription(sampleEntity.getDescription()
				+ "xxxProcessedxxx");
		System.out.println("process end: " + Thread.currentThread().getName());
		return processedEntity;
	}

}
