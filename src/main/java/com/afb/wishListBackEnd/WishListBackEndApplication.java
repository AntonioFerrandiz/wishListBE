package com.afb.wishListBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableCaching
@SpringBootApplication
@EnableSpringDataWebSupport
public class WishListBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(WishListBackEndApplication.class, args);
	}

}
