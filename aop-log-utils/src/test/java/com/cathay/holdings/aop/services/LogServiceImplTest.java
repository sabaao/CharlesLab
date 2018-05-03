package com.cathay.holdings.aop.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import com.ch.myr.utils.aop.beans.LogObject;
import com.ch.myr.utils.aop.services.LogServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LogServiceImplTest {
  
  @InjectMocks
  private LogServiceImpl logService = new LogServiceImpl();
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testGetLogObjectStringListString() {
    String className = "com.cathay.holdings.HelloController";
    String arg = "Hello";
    List inputArgs = new ArrayList();
    inputArgs.add(arg);
    String methodName = "hello";
    LogObject log = logService.getLogObject(className, inputArgs, methodName);
    assertEquals(className, log.getClassName());
    assertEquals(arg, log.getInputArgs().stream().findFirst().get().toString());
    assertEquals(methodName, log.getMethodName());
  }

  @Test
  public void testGetLogObject() {
    LogObject log = logService.getLogObject();
    assertNotNull(log.getStartTime());
  }

//  @Test
//  public void testRecord() {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testLog() {
//    fail("Not yet implemented");
//  }

}
