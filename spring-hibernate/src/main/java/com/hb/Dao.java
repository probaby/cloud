package com.hb;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;
@Component("dao")
public class Dao {
		
	private Service servic;

	public Service getServic() {
		return servic;
	}

	@Resource(name="service")
	public void setServic(Service servic) {
		this.servic = servic;
	}
	
	public void  excuteService(){
		servic.show();
	}


}
