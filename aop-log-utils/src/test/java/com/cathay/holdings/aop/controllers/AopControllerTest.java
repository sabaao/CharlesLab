package com.cathay.holdings.aop.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.ch.myr.utils.aop.controllers.AopController;
import com.ch.myr.utils.aop.services.ScanService;

@RunWith(MockitoJUnitRunner.class)
public class AopControllerTest {
  
  @InjectMocks
  private AopController controller = new AopController();
  
  @Mock
  private ScanService scanService;
  
  private String staticScanNames = "com.cathay.holdings";
  
  private String dynamicScanNames = "com.cathay.bank,com.cathay.life";
  
  private Set<String> staticScanNamesSet;
  
  private Set<String> dynamicScanNamesSet;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {
    staticScanNamesSet = new HashSet<String>(Arrays.asList(staticScanNames));
    dynamicScanNamesSet = new HashSet<String>(Arrays.asList(dynamicScanNames));
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testGetStaticNames() {
    when(scanService.getStaticNames()).thenReturn(staticScanNamesSet);
    assertEquals(staticScanNames, controller.getStaticNames().stream().findFirst().get());
  }

  @Test
  public void testGetDynamicNames() {
    when(scanService.getDynamicNames()).thenReturn(dynamicScanNamesSet);
    assertEquals(dynamicScanNames, controller.getDynamicNames().stream().findFirst().get());
  }

  @Test
  public void testInsertDynamicNames() {
    when(scanService.insertDynamicNames(any())).thenReturn(true);
    List<String> list = new ArrayList<String>(dynamicScanNamesSet);
    boolean result = controller.insertDynamicNames(list);
    assertTrue(result);
    
  }

  @Test
  public void testDeleteDynamicNames() {
    when(scanService.deleteDynamicNames(any())).thenReturn(true);
    List<String> list = new ArrayList<String>(dynamicScanNamesSet);
    boolean result = controller.deleteDynamicNames(list);
    assertTrue(result);
  }

}
