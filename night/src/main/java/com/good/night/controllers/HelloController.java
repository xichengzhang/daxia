package com.good.night.controllers;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("/hello/")
public class HelloController {
	@Get("world")
	public String index() {
		System.out.println("SSSSSSS");
		return "@hello world";
	}
}
