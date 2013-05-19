package com.mark.rnd.util;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:launch-context.xml" })
public class PopulateSampleTable {

	@Autowired
	private DataSource dataSource;

	private static JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Transactional
	@Rollback(false)
	@Before
	public void setUpJdbcTemplate() {
		if (jdbcTemplate == null) {
			jdbcTemplate = new JdbcTemplate(dataSource);
		}

		String sql = "DELETE FROM SAMPLE";
		jdbcTemplate.update(sql);
	}

	@Transactional
	@Rollback(false)
	@Test
	public void insert() {

		String sql = "INSERT INTO SAMPLE "
				+ "(ID, NAME, JOB_ID, PROCESSED) VALUES (?, ?, ?, ?)";

		// jdbcTemplate = new JdbcTemplate(dataSource);

		for (int i = 1; i <= 1000; i++) {
			jdbcTemplate
					.update(sql, new Object[] { i, "name" + i, null, null });
		}

	}
}
