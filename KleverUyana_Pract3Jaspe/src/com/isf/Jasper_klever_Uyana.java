package com.isf;
import java.util.Map;

import com.mysql.cj.exceptions.CJCommunicationsException;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class Jasper_klever_Uyana {

	public static void main(String[] args) {
		String reportSource = "./plantilla/plantilla.jrxml";
		String reportHTML = "./informes/Informe.html";
		String reportPDF = "./informes/Informe.pdf";
		String reportXML = "./informes/Informe.xml";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("titulo", "PRACTICA JASPER");
		params.put("autor", "KLEVER UYANA BARAHONA");
		params.put("fecha", (new java.util.Date()).toString());

		try {

			JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newschema","root","258013" );

			JasperPrint MiInforme = JasperFillManager.fillReport(jasperReport, params, conn);

			JasperViewer.viewReport(MiInforme);
	
			JasperExportManager.exportReportToHtmlFile(MiInforme, reportHTML);
		
			JasperExportManager.exportReportToPdfFile(MiInforme, reportPDF);

			JasperExportManager.exportReportToXmlFile(MiInforme, reportXML, false);
			System.out.println("Archivos creados");
		} catch (CJCommunicationsException c) {
			System.out.println(" Error de comunicacion con la BD. No arrancada.");
		} catch (ClassNotFoundException e) {
			System.out.println(" Error driver. ");
		} catch (SQLException e) {
			System.out.println(" Error al ejecutar sentencia SQL ");
		} catch (JRException ex) {
			System.out.println(" Error Jasper.");
			ex.printStackTrace();
		}
	}

}
