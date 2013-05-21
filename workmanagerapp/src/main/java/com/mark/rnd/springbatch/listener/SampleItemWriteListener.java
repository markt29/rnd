package com.mark.rnd.springbatch.listener;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mark.rnd.springbatch.entity.SampleEntity;


public class SampleItemWriteListener extends JdbcTemplate implements
		ItemWriteListener<SampleEntity> {

	private String SQL = " set processed = true ";
	private String tableName;
	private String whereClause = "";

	public void beforeWrite(List<? extends SampleEntity> items) {
		// TODO Auto-generated method stub

	}

	public void afterWrite(List<? extends SampleEntity> items) {
		for (SampleEntity sampleEntity : items) {
			update("update " + tableName + SQL + whereClause,
					new Object[] { sampleEntity.getId() });
		}
	}

	public void onWriteError(Exception exception,
			List<? extends SampleEntity> items) {
		// TODO Auto-generated method stub

	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void setWhereClause(String whereClause) {
		this.whereClause = whereClause;
	}
}
