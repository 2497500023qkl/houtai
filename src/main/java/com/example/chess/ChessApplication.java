package com.example.chess;

import com.example.chess.Server.initialization;
import com.example.chess.Server.receive;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ChessApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ChessApplication.class, args);
//		initialization i=new initialization();
//		i.getiInitialization();
//		receive r=new receive(i);
	}

}
