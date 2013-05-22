package com.mark.rnd.remotechunking.processor;

import org.springframework.batch.item.ItemProcessor;

import com.mark.rnd.remotechunking.entity.SampleEntity;

public class SampleItemProcessor implements
		ItemProcessor<SampleEntity, SampleEntity> {

	public SampleEntity process(SampleEntity sampleEntity) throws Exception {
		SampleEntity processedEntity = new SampleEntity();
		processedEntity.setId(sampleEntity.getId());
		processedEntity.setName(sampleEntity.getName() + "xxxProcessedxxx");
		processedEntity.setDescription(sampleEntity.getDescription()
				+ "xxxProcessedxxx");
		return processedEntity;
	}

}
