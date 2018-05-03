package com.ch.myr.utils.aop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AopConfig {}
