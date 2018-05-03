package com.cathay.holdings.aop.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.ch.myr.utils.aop.services.ConfigService;
import com.ch.myr.utils.aop.services.ScanServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ScanServiceImplTest {
  
  @InjectMocks
  private static ScanServiceImpl scanService = new ScanServiceImpl();
  
  @Mock
  private ConfigService configService;
  
  private String staticScanNames = "com.cathay.holdings";
  
  private String dynamicScanNames[] = {"com.cathay.bank","com.cathay.life"};
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {
    when(configService.getStaticScanNames()).thenReturn(staticScanNames);
    
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testInit() {
    scanService.init();
    String result = scanService.getStaticNames().stream().findFirst().get();
    assertEquals(result, staticScanNames);
  }

  @Test
  public void testGetStaticNames() {
    String result = scanService.getStaticNames().stream().findFirst().get();
    assertEquals(result, staticScanNames);
  }

  @Test
  public void testGetDynamicNames() {
    scanService.insertDynamicNames(Arrays.asList(dynamicScanNames));
    long result = scanService.getDynamicNames().stream().count();
    assertEquals(new Long(result).intValue(), dynamicScanNames.length);
  }

  @Test
  public void testInsertDynamicNames() {
    scanService.insertDynamicNames(Arrays.asList(dynamicScanNames));
    long result = scanService.getDynamicNames().stream().count();
    assertEquals(new Long(result).intValue(), dynamicScanNames.length);
  }

  @Test
  public void testDeleteDynamicNames() {
    scanService.insertDynamicNames(Arrays.asList(dynamicScanNames));
    scanService.deleteDynamicNames(Arrays.asList(dynamicScanNames[0]));
    assertEquals(dynamicScanNames[1], scanService.getDynamicNames().stream().findFirst().get());
  }

  @Test
  public void testIsInScanNames() {
    assertFalse(scanService.isInScanNames("abc"));
    assertTrue(scanService.isInScanNames(staticScanNames));
  }

}
