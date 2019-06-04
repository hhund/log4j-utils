package de.rwh.utils.log4j2;

import org.apache.logging.slf4j.Log4jLoggerFactory;
import org.apache.logging.slf4j.Log4jMDCAdapter;
import org.apache.logging.slf4j.Log4jMarkerFactory;
import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

public class Log4jServiceProvider implements SLF4JServiceProvider
{
	public static final String REQUESTED_API_VERSION = "1.8";

	private ILoggerFactory loggerFactory;
	private IMarkerFactory markerFactory;
	private MDCAdapter mdcAdapter;

	@Override
	public ILoggerFactory getLoggerFactory()
	{
		return loggerFactory;
	}

	@Override
	public IMarkerFactory getMarkerFactory()
	{
		return markerFactory;
	}

	@Override
	public MDCAdapter getMDCAdapter()
	{
		return mdcAdapter;
	}

	@Override
	public String getRequesteApiVersion()
	{
		return REQUESTED_API_VERSION;
	}

	@Override
	public void initialize()
	{
		loggerFactory = new Log4jLoggerFactory();
		markerFactory = new Log4jMarkerFactory();
		mdcAdapter = new Log4jMDCAdapter();
	}
}
