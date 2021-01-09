package cn.wjh.dao;




import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiOperation {
	
	
	
	public PoiOperation() throws IOException {
		String excelFile="d:/ware.xlsx";
		Workbook wb=new XSSFWorkbook();
		Sheet sheet=wb.createSheet("仓库");
	
		FileOutputStream fileout=new FileOutputStream(excelFile);
		
		Row row=sheet.createRow(0);
		Cell c=row.createCell(0);
		c.setCellValue("商品种类");
		row.createCell(1).setCellValue("商品名");
		row.createCell(2).setCellValue("库存");
		row.createCell(3).setCellValue("库存时间");
		row.createCell(4).setCellValue("供货商");
		for(int i=1;i<10000;i++) {
			Row row2=sheet.createRow(i);
			row2.createCell(0).setCellValue(4);
			row2.createCell(1).setCellValue(2);
			row2.createCell(2).setCellValue(1);
			row2.createCell(3).setCellValue(3);
			row2.createCell(4).setCellValue(5);
		}
		wb.write(fileout);
		wb.close();
	}
	public PoiOperation(int i,String s,String s1,String s2,String s3,String s4) throws IOException {
		String excelFile="d:/ware.xlsx";
		Workbook wb=new XSSFWorkbook();
		Sheet sheet=wb.createSheet("仓库");
		FileOutputStream fileout=new FileOutputStream(excelFile);
		
		Row row=sheet.createRow(0);
		Cell c=row.createCell(0);
		c.setCellValue("商品种类");
		row.createCell(1).setCellValue("商品名");
		row.createCell(2).setCellValue("库存");
		row.createCell(3).setCellValue("库存时间");
		row.createCell(4).setCellValue("供货商");
		
		System.out.println(i);
		Row row2=sheet.createRow(i);
		row2.createCell(0).setCellValue(s);
		row2.createCell(1).setCellValue(s1);
		row2.createCell(2).setCellValue(s2);
		row2.createCell(3).setCellValue(s3);
		row2.createCell(4).setCellValue(s4);
		
		wb.write(fileout);
	}

	public static void main(String[] args) {
		sqlOperation s=new sqlOperation();
		try {
			s.qurey();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			PoiOperation p=new PoiOperation();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	} 
}
