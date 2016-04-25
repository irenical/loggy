package org.irenical.loggy;

import org.junit.Test;

public class LoggyTest {
  
  @Test
  public void testBoot(){
    LoggingLifecycle l = new LoggingLifecycle();
    l.start();
  }

}
