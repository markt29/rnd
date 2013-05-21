package com.mark.rnd.springbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class TaskletThree implements Tasklet {

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println("TaskletThree:" + i);
			Thread.sleep(300);
		}
		// throw new RuntimeException("TestException for taskletthree");
		return RepeatStatus.FINISHED;
	}

}
