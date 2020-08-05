package com.hb.servlet;

import java.io.IOException;

public class StaticResourceProcessor {
	public StaticResourceProcessor (ServletRequestTest request,ServletResponseTest response) {
		try {
			response.sendStaticResource();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
