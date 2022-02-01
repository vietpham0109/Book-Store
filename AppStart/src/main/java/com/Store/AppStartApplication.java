package com.Store;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppStartApplication.class, args);
		
		/* System.out.println(new BCryptPasswordEncoder().encode("2")); */
		/*
		int amount = 34753065;
		Locale vn = new Locale("vn", "VN");
		NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(vn);
		System.out.println(dollarFormat.format(amount).substring(2));
		*/
	}
}
