package com.good.night.interceptors;

import java.lang.annotation.Annotation;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;

public class TestZhangInterceptor extends ControllerInterceptorAdapter{

	@Override
	protected Class<? extends Annotation> getRequiredAnnotationClass() {
		return TestZhang.class; // 这是一个注解，只有标过的controller才会调用这个拦截器。
	}
	
	@Override
	protected Object before(Invocation inv) throws Exception {
		System.out.println("get in TestZhangInterceptor before");
		return true;
	}
	
	@Override
	protected Object after(Invocation inv, Object instruction) throws Exception {
		System.out.println("get in TestZhangInterceptor after");
		return true;
	}
	
	@Override
	public void afterCompletion(Invocation inv, Throwable ex) throws Exception {
		System.out.println("get in TestZhangInterceptor afterCompletion");
	}
}
