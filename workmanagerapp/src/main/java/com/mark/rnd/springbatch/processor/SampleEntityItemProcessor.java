package com.mark.rnd.springbatch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.mark.rnd.springbatch.entity.SampleEntity;

@Component
public class SampleEntityItemProcessor implements
		ItemProcessor<SampleEntity, SampleEntity> {

	public SampleEntity process(SampleEntity sampleEntity) throws Exception {
		SampleEntity processedEntity = new SampleEntity();

		processedEntity.setId(sampleEntity.getId());
		processedEntity.setName(sampleEntity.getName() + "PROCESSED BY: "
				+ Thread.currentThread().getName());
		processedEntity.setJobid(sampleEntity.getJobid());
		processedEntity.setProcessed(sampleEntity.isProcessed());

//		if (Thread.currentThread().getName().contains("11")) {
//			throw new RuntimeException("xxxTest runtime errorxxx");
//		}

		return processedEntity;
	}

}
