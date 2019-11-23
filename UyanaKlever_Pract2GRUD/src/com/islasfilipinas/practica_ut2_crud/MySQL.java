package com.islasfilipinas.practica_ut2_crud;
import java.sql.*;
import java.util.Calendar;
import java.sql.PreparedStatement;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class MySQL {
Connection c = null;
Statement stmt = null;

public void ConeccionMySQL() {
    try {
       Class.forName("com.mysql.cj.jdbc.Driver");
       c = DriverManager.getConnection("jdbc:mysql://localhost:3306/newschema","root","258013");
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
	      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/newschema","root","258013");
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
	      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/newschema","root","258013");
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

public void SeleciontablaEmple_nomdep() {
	 try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/newschema","root","258013");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT emp_no, apellido, nombre, oficio, dir, fecha_alta, salario, comision, dnombre FROM newschema.empleados INNER JOIN newschema.departamentos ON empleados.dept_no=departamentos.dept_no;" );
	      
	      System.out.println( " \n Tabla Empleados_Nombre Departamentos  \n");
	      while ( rs.next() ) {
	         int emp_no = rs.getInt("emp_no");
	         String  apellido = rs.getString("apellido");
	         String nombre  = rs.getString("nombre");
	         String oficio  = rs.getString("oficio");
	         int dir  = rs.getInt("dir");
	         String fecha_alta  = rs.getString("fecha_alta");
	         int salario  = rs.getInt("salario");
	         int comision  = rs.getInt("comision");
	         String dnombre = rs.getString("dnombre");
	   
	         
	         System.out.print(emp_no );
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
	         System.out.print(dnombre );
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

public void seleciontablaEmple_Dep() {
	 try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/newschema","root","258013");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	     /* ResultSet rs = stmt.executeQuery( "SELECT nombre, apellido, dnombre  "
	      									+ "FROM empleados, departamentos"
	      									+ " WHERE empleados.dept_no=departamentos.dept_no;" );*/
	      
	      ResultSet rs = stmt.executeQuery( "SELECT nombre, apellido, dnombre "
	      		+ "FROM empleados INNER JOIN departamentos "
	      		+ "ON empleados.dept_no=departamentos.dept_no;" );
	      
	      System.out.println( " \n Tabla Empleados Departamentos \n");
	      while ( rs.next() ) {
	        
	         String nombre = rs.getString("nombre");
	         String apellido  = rs.getString("apellido");
	         String dnombre  = rs.getString("dnombre");
	      
	         
	         System.out.print(nombre );
	         System.out.print( " | ");
	         System.out.print(apellido );
	         System.out.print( " | ");
	         System.out.print(dnombre );
	       
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

public void inserttablaEmple() {
	Calendar fecha = new GregorianCalendar();
	String apellido;
	String nombre;
	String oficio;
	int dir;
	String fecha_alta;
	int salario;
	int comision;
	int dept_no;
	int año = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    String Fecha =año + "-" + (mes+1) + "-" + dia;
    Scanner sc = new Scanner(System.in); 


	
	System.out.println("\n Se insertara un registro en la Tabla Empleados\n");
    System.out.println(Fecha);
	System.out.println("\n");
	System.out.println("Emp_no = Autonumerico");
	System.out.println("Introduce Apellido :");
	apellido = sc.nextLine();
	System.out.println("Introduce Nombre :");
	nombre = sc.nextLine(); 
	System.out.println("Introduce Oficio :");
	oficio = sc.nextLine(); 
	System.out.println("Introduce Dir :");
	dir = sc.nextInt(); 
	System.out.println("Introduce Fecha Alta : Del Systema\n");
	System.out.println("Introduce Salario :");
	salario = sc.nextInt(); 
	System.out.println("Introduce Comision :");
	comision = sc.nextInt(); 
	System.out.println("Introduce Detp_no : entre el 1-5" );
	dept_no = sc.nextInt(); 

	
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
	      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/newschema","root","258013");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");
	      
	     
	     stmt = c.createStatement();
	      String sql = "INSERT INTO empleados (apellido, nombre, oficio, dir, fecha_alta, salario, comision, dept_no) " +
                        "VALUES ('"+apellido+"','"+nombre+"', '"+oficio+"', "+dir+",'"+Fecha+"',"+salario+", "+comision+","+dept_no+" );"; 
	      stmt.executeUpdate(sql);
	     
      
         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }

public void inserttablaEmple_2() {
	Calendar fecha = new GregorianCalendar();
	String apellido;
	String nombre;
	String oficio;
	int dir;
	String fecha_alta;
	int salario;
	int comision;
	int dept_no;
	int año = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    String Fecha =año + "-" + (mes+1) + "-" + dia;
    Scanner sc = new Scanner(System.in); 

	
	System.out.println("\nSe insertara un registro en la Tabla Empleados\n");
    System.out.println(Fecha);
	System.out.println("\n");
	System.out.println("Emp_no = Autonumerico");
	System.out.println("Introduce Apellido :");
	apellido = sc.nextLine();
	System.out.println("Introduce Nombre :");
	nombre = sc.nextLine(); 
	System.out.println("Introduce Oficio :");
	oficio = sc.nextLine(); 
	System.out.println("Introduce Dir :");
	dir = sc.nextInt(); 
	System.out.println("Introduce Fecha Alta : Del Systema");
	System.out.println("Introduce Salario :");
	salario = sc.nextInt(); 
	System.out.println("Introduce Comision :");
	comision = sc.nextInt(); 
	System.out.println("Introduce Detp_no : entre el 1-5" );
	dept_no = sc.nextInt(); 

	
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
	      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/newschema","root","258013");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

        
         String sql = "INSERT INTO empleados (apellido, nombre, oficio, dir, fecha_alta, salario, comision, dept_no) " +
                        "VALUES (?,?,?,?,?,?,?,?);"; 
         PreparedStatement pstmt = c.prepareStatement(sql); 
             pstmt.setString(1, apellido);
             pstmt.setString(2, nombre);
             pstmt.setString(3, oficio);
             pstmt.setDouble(4, dir);
             pstmt.setString(5, Fecha);
             pstmt.setDouble(6, salario);
             pstmt.setDouble(7, comision);
             pstmt.setDouble(8, dept_no);

             //pstmt.setDouble(2, nombre);
             int status = pstmt.executeUpdate();
			if(status > 0) {
                 System.out.println("Record is inserted successfully !!!");
              }

        // stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
          e.printStackTrace();
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }

public void updatetablaEmple() {
	Calendar fecha = new GregorianCalendar();
	String apellido;
	String nombre;
	String oficio;
	int dir;
	String fecha_alta;
	int salario;
	int comision;
	int dept_no;
	int año = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    String Fecha =año + "-" + (mes+1) + "-" + dia;
    Scanner sc = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);
    Scanner sc3 = new Scanner(System.in);
    int n;

	System.out.println("\n Se actualizara un registro en la Tabla Empleados\n");
    System.out.println(Fecha);
	System.out.println("\n");
	System.out.println("Selecciona emplado a modificar, por emp_no");
	n= sc.nextInt();
	System.out.println("Introduce Apellido :\n");
	apellido = sc.next();
	System.out.println("Introduce Nombre :\n");
	nombre = sc.next(); 
	System.out.println("Introduce Oficio :");
	oficio = sc.next(); 
	System.out.println("Introduce Dir :");
	dir = sc.nextInt(); 
	System.out.println("Introduce Fecha Alta : Del Systema\n");
	System.out.println("Introduce Salario :");
	salario = sc.nextInt(); 
	System.out.println("Introduce Comision :");
	comision = sc.nextInt(); 
	System.out.println("Introduce Detp_no : entre el 1-5" );
	dept_no = sc.nextInt(); 

	
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
	      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/newschema","root","258013");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");
	      
	      
	      Statement sentencia = c.createStatement();
	      String comprobar = "SELECT EMP_NO FROM EMPLEADOS WHERE EMP_NO=" + n;
	      ResultSet resul = sentencia.executeQuery(comprobar);
	      
	      if (resul.next()) {

         stmt = c.createStatement();
         String sql = "UPDATE `newschema`.`empleados` SET `apellido` = '"+apellido+"', `nombre` = '"+nombre+"', `oficio` = '"+oficio+"', `dir` = '"+dir+"', `fecha_alta` = '"+Fecha+"', `salario` = '"+salario+"', `comision` = '"+comision+"', `dept_no` = '"+dept_no+"' WHERE (`emp_no` = '"+n+"');";
         																/*String sql = "INSERT INTO empleados (apellido, nombre, oficio, dir, fecha_alta, salario, comision, dept_no) " +
                 														"VALUES ('"+apellido+"','"+nombre+"', '"+oficio+"', "+dir+",'"+Fecha+"',"+salario+", "+comision+","+dept_no+" );"; */
    //UPDATE COMPANY set SALARY = 25000.00 where ID=1;
         stmt.executeUpdate(sql);
	      }else {
	    	  System.out.println("Empleado no existe");
	      }

         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }

public void deleteablaEmple() {

    Scanner sc = new Scanner(System.in);

    int n;

	System.out.println("\n Se Borrara un registro en la Tabla Empleados\n");

	System.out.println("\n");
	System.out.println("Selecciona emplado a borrar, por emp_no");
	n= sc.nextInt(); 

	
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
	      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/newschema","root","258013");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	     
	      Statement sentencia = c.createStatement();
	      String comprobar = "SELECT EMP_NO FROM EMPLEADOS WHERE EMP_NO=" + n;
	      ResultSet resul = sentencia.executeQuery(comprobar);
	      
	      if (resul.next()) { 
         stmt = c.createStatement();
         String sql = "DELETE from empleados where emp_no="+n+";";
         																/*String sql = "INSERT INTO empleados (apellido, nombre, oficio, dir, fecha_alta, salario, comision, dept_no) " +
                 														"VALUES ('"+apellido+"','"+nombre+"', '"+oficio+"', "+dir+",'"+Fecha+"',"+salario+", "+comision+","+dept_no+" );"; */
    //UPDATE COMPANY set SALARY = 25000.00 where ID=1;
         stmt.executeUpdate(sql);
	      }else {
	    	  System.out.print("no se a encontrado empleado");
	      }
         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
	 System.out.println("\nSe ha borrado el registro\n");
      System.out.println("Records created successfully");
   }

}
