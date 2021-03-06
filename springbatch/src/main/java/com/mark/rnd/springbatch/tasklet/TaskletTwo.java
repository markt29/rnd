package com.mark.rnd.springbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class TaskletTwo implements Tasklet {

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println("TaskletTwo" + i);
			Thread.sleep(500);
		}
		// throw new RuntimeException("TaskletTwoRuntimeException");
		return RepeatStatus.FINISHED;
	}

}
