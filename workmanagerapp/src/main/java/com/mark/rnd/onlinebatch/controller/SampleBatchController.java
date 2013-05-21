package com.mark.rnd.onlinebatch.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/samplebatch")
public class SampleBatchController {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	@RequestMapping(method = RequestMethod.GET)
	public String startBatchJob() throws JobExecutionAlreadyRunningException,
			JobRestartException, JobInstanceAlreadyCompleteException,
			JobParametersInvalidException {
		Map<String, JobParameter> parameterMap = new HashMap<String, JobParameter>();

		JobParameter runIdJobParameter = new JobParameter("1");
		JobParameter nameJobParameter = new JobParameter("jdbcJob13");

		parameterMap.put("run.id", runIdJobParameter);
		parameterMap.put("name", nameJobParameter);

		jobLauncher.run(job, new JobParameters(parameterMap));
		return "batch";
	}

}
