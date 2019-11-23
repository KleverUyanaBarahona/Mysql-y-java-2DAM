package com.islasfilipinas.practica_ut2_crud;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		MySQL nuevo = new MySQL();
		
		int op=0;
		Scanner tecla = new Scanner(System.in);
		try {
		
		do {
			System.out.println("****************************");
			System.out.println("******** MENU CRUD *********");
			System.out.println("****************************");
			System.out.println("\n");
			System.out.println("1 Listado de emplados");
			System.out.println("2 Alta de emplados");
			System.out.println("3 Modificacion de emplados");
			System.out.println("4 Baja de Emplados");
			System.out.println("5 Salir");
			
			op=tecla.nextInt();
			
			if(op == 1) {
				nuevo.SeleciontablaEmple_nomdep();
				System.out.println("\n");
			}else if(op == 2){
				nuevo.inserttablaEmple_2(); //PreparedStatement
			}else if(op == 3){
				nuevo.updatetablaEmple();
			}else if(op == 4){
				nuevo.deleteablaEmple(); //PreparedStatement
			}else if(op != 1||op != 2||op != 3||op != 4||op != 5 ){
				System.out.println("no");
			}
			
		}while(op!=5);
		}catch(InputMismatchException e) {
			System.out.println("Seleciona una de las opciones");
		}

		System.out.println("Has salido del programa..Adios");
	}
	
}
