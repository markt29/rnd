package com.mark.rnd.springbatch.entity;

public class SampleEntity {

	private int id;
	private String name;
	private String jobid;
	private boolean processIndicator;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public boolean isProcessIndicator() {
		return processIndicator;
	}

	public void setProcessIndicator(boolean processIndicator) {
		this.processIndicator = processIndicator;
	}

}
