package com.productstorage;

import com.productstorage.dao.repo.StorageRepository;
import com.productstorage.util.event.LimitPieceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootApplication
public class ProductstorageApplication implements CommandLineRunner {

	@Autowired
	StorageRepository storageRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductstorageApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		Long a = 123123L;
		Long b = 12312345L;

		if (a>b){
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
		}
	}
}
