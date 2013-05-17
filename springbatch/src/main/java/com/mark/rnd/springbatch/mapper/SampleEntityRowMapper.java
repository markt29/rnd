package com.mark.rnd.springbatch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mark.rnd.springbatch.entity.SampleEntity;

@Component
public class SampleEntityRowMapper implements RowMapper<SampleEntity> {

	public SampleEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		SampleEntity entity = new SampleEntity();

		entity.setId(rs.getInt("id"));
		entity.setName(rs.getString("name"));
		entity.setJobid(rs.getString("job_id"));
		entity.setProcessIndicator(rs.getBoolean("process_indicator"));

		return entity;
	}

}
