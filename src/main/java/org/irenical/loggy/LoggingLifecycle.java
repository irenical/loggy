package org.irenical.loggy;

import org.irenical.lifecycle.LifeCycle;
import org.irenical.slf4j.GelfLoggerConfigurator;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

public class LoggingLifecycle implements LifeCycle {

  private boolean started = false;

  @Override
  public void start() {
    if (!started) {
      SLF4JBridgeHandler.removeHandlersForRootLogger();
      SLF4JBridgeHandler.install();
      java.util.logging.Logger.getGlobal().setLevel(java.util.logging.Level.ALL);

      LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
      Logger rootLogger = loggerContext.getLogger(Logger.ROOT_LOGGER_NAME);
      rootLogger.setLevel(Level.INFO);
      
      GelfLoggerConfigurator configurator = new GelfLoggerConfigurator();
      LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
      configurator.setContext(context);
      context.reset();
      configurator.configure(context);
      started = true;
    }
  }

  @Override
  public void stop() {
    ((LoggerContext) LoggerFactory.getILoggerFactory()).stop();
    started = false;
  }

  @Override
  public boolean isRunning() {
    return started;
  }

}
