package com.islasfilipinas.parctica1_ut2;
import java.sql.*;
public class MySQL {
Connection c = null;
Statement stmt = null;

public void ConeccionMySQL() {
    try {
       Class.forName("com.mysql.cj.jdbc.Driver");
       c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo","root","258013");
		System.out.println("conecccion ok");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Error al cargar el contralador");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("Error en la conexxion");
			e.printStackTrace();
		}
 }

public void SeleciontablaDep() {
	 try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo","root","258013");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM departamentos;" );
	      System.out.println( "\n Tabla Departamentos \n");
	      while ( rs.next() ) {
	         int dept_no = rs.getInt("dept_no");
	         String  dnombre = rs.getString("dnombre");
	         String loc  = rs.getString("loc");
	   
	         
	         System.out.print( dept_no );
	         System.out.print( " | ");
	         System.out.print(dnombre );
	         System.out.print( " | ");
	         System.out.print(loc );
	         System.out.println();
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	   } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	   }
	   System.out.println("Operation done successfully");

}

public void SeleciontablaEmple() {
	 try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo","root","258013");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM empleados;" );
	      
	      System.out.println( " \n Tabla Empleados \n");
	      while ( rs.next() ) {
	         int emp_no = rs.getInt("emp_no");
	         String  apellido = rs.getString("apellido");
	         String nombre  = rs.getString("nombre");
	         String oficio  = rs.getString("oficio");
	         int dir  = rs.getInt("dir");
	         String fecha_alta  = rs.getString("fecha_alta");
	         int salario  = rs.getInt("salario");
	         int comision  = rs.getInt("comision");
	         int dept_no = rs.getInt("dept_no");
	   
	         
	         System.out.print(dept_no );
	         System.out.print( " | ");
	         System.out.print(apellido );
	         System.out.print( " | ");
	         System.out.print(nombre );
	         System.out.print( " | ");
	         System.out.print(oficio );
	         System.out.print( " | ");
	         System.out.print(dir );
	         System.out.print( " | ");
	         System.out.print(fecha_alta );
	         System.out.print( " | ");
	         System.out.print(salario );
	         System.out.print( " | ");
	         System.out.print(comision );
	         System.out.print( " | ");
	         System.out.print(dept_no );
	         System.out.println();
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	   } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	   }
	   System.out.println("Operation done successfully");

}

}
