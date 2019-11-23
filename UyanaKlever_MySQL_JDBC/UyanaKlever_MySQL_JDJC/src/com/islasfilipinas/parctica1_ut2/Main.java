package com.islasfilipinas.parctica1_ut2;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {
	public static void main(String[] args) {
		MySQL nuevo = new MySQL();
		nuevo.ConeccionMySQL();
		nuevo.SeleciontablaDep();
		nuevo.SeleciontablaEmple();
	}

}
