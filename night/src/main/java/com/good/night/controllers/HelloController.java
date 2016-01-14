package com.good.night.controllers;

import com.good.night.interceptors.TestZhang;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@TestZhang
@Path("/hello/")
public class HelloController {
	@Get("world")
	public String index() {
		System.out.println("HelloWorld!!!!");
		return "@hello world";
	}
}
