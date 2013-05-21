package com.mark.rnd.springbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class TaskletFour implements Tasklet {

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println("TaskletFour:" + i);
			Thread.sleep(700);
		}
		return RepeatStatus.FINISHED;
	}

}
