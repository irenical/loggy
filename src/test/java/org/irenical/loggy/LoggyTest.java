package org.irenical.loggy;

import org.junit.Test;

public class LoggyTest {
  
  @Test
  public void testBoot(){
    Loggy l = new Loggy();
    l.start();
  }

}
