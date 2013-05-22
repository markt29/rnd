package com.mark.rnd.remotechunking.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.mark.rnd.remotechunking.entity.SampleEntity;

public class SampleItemWriter implements ItemWriter<SampleEntity> {

	public void write(List<? extends SampleEntity> sampleEntityList)
			throws Exception {
		System.out.println("write start");
		for (SampleEntity entity : sampleEntityList) {
			System.out.println(entity);
		}
		System.out.println("write end");
	}

}
