package com.mark.rnd.springbatch.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class SynchronizedJdbcCursorItemReader<T> implements ItemReader<T>,
		ItemStream {

	private ItemReader<?> jdbcItemReader;

	private ItemStream jdbcItemStream;

	public synchronized T read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		return (T) jdbcItemReader.read();
	}

	public ItemReader<?> getJdbcItemReader() {
		return jdbcItemReader;
	}

	public void setJdbcItemReader(ItemReader<?> itemReader) {
		this.jdbcItemReader = itemReader;
	}

	public synchronized void close() throws ItemStreamException {
		// TODO Auto-generated method stub
		jdbcItemStream.close();
	}

	public synchronized void open(ExecutionContext arg0)
			throws ItemStreamException {
		// TODO Auto-generated method stub
		jdbcItemStream.open(arg0);
	}

	public synchronized void update(ExecutionContext arg0)
			throws ItemStreamException {
		// TODO Auto-generated method stub
		jdbcItemStream.update(arg0);
	}

	public ItemStream getJdbcItemStream() {
		return jdbcItemStream;
	}

	public void setJdbcItemStream(ItemStream jdbcItemStream) {
		this.jdbcItemStream = jdbcItemStream;
	}
}
