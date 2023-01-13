package design.springboot.zjj.utils;

import design.springboot.zjj.entity.Market;
import design.springboot.zjj.entity.Repertory;
import design.springboot.zjj.entity.Syslog;
import design.springboot.zjj.entity.Type;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
    private static XSSFWorkbook work;
    //readType
    public static List<Type> readType(String path)throws IOException {
        List<Type> Types = new ArrayList<>();
        work = new XSSFWorkbook(Files.newInputStream(Paths.get(path)));
        XSSFSheet sheet = work.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <=lastRowNum; i++) {
            XSSFRow row=sheet.getRow(i);
            if (row!=null) {
                List<String>list=new ArrayList<>();
                for (Cell cell : row) {
                    if (cell!=null) {
                        cell.setCellType(CellType.STRING);
                        String value = cell.getStringCellValue();
                        if (value!=null&&!"".equals(value)) {
                            list.add(value);
                        }
                    }
                }
                if (list.size()>0) {
                    Type type = new Type(list.get(0),list.get(1),list.get(2),list.get(3),Double.valueOf(list.get(4)));
                    Types.add(type);
                }
            }
        }
        return Types;
    }
    //writeType
    public static int writeType(List<Type>list,String path) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "手机型号表");
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        row.createCell(0).setCellValue("手机id");
        row.createCell(1).setCellValue("手机名称");
        row.createCell(2).setCellValue("手机型号");
        row.createCell(3).setCellValue("手机内存");
        row.createCell(4).setCellValue("手机颜色");
        row.createCell(5).setCellValue("手机价格");
        for (int i = 0; i < list.size(); i++) {
            XSSFRow row1 = sheet.createRow(i+1);
            row1.createCell(0).setCellValue(list.get(i).getpId());
            row1.createCell(1).setCellValue(list.get(i).getpName());
            row1.createCell(2).setCellValue(list.get(i).getpModel());
            row1.createCell(3).setCellValue(list.get(i).getpMemory());
            row1.createCell(4).setCellValue(list.get(i).getpColour());
            row1.createCell(5).setCellValue(list.get(i).getpPrice());
        }
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        OutputStream outputStream = Files.newOutputStream(file.toPath());
        outputStream.toString();
        workbook.write(outputStream);
        System.out.println("数据导出成功");
        workbook.close();
        return 1;
    }
    //readMarket
    public static List<Market> readMarket(String path)throws IOException {
        List<Market> markets = new ArrayList<>();
        work = new XSSFWorkbook(Files.newInputStream(Paths.get(path)));
        XSSFSheet sheet = work.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <=lastRowNum; i++) {
            XSSFRow row=sheet.getRow(i);
            if (row!=null) {
                List<String>list=new ArrayList<>();
                for (Cell cell : row) {
                    if (cell!=null) {
                        cell.setCellType(CellType.STRING);
                        String value = cell.getStringCellValue();
                        if (value!=null&&!"".equals(value)) {
                            list.add(value);
                        }
                    }
                }
                if (list.size()>0) {
                    Market market = new Market(list.get(0),
                            list.get(1),
                            Double.valueOf(list.get(2)),
                            Double.valueOf(list.get(3)),
                            Integer.valueOf(list.get(4)));
                    markets.add(market);
                }
            }
        }
        return markets;
    }
    //writeMarket
    public static int writeMarket(List<Market>list,String path) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "手机销售表");
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        row.createCell(0).setCellValue("手机名称");
        row.createCell(1).setCellValue("手机型号");
        row.createCell(2).setCellValue("手机进价");
        row.createCell(3).setCellValue("手机售价");
        row.createCell(4).setCellValue("手机销量");
        for (int i = 0; i < list.size(); i++) {
            XSSFRow row1 = sheet.createRow(i+1);
            row1.createCell(0).setCellValue(list.get(i).getpName());
            row1.createCell(1).setCellValue(list.get(i).getpModel());
            row1.createCell(2).setCellValue(list.get(i).getpBid());
            row1.createCell(3).setCellValue(list.get(i).getpPrice());
            row1.createCell(4).setCellValue(list.get(i).getpSales());
        }
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        OutputStream outputStream = Files.newOutputStream(file.toPath());
        outputStream.toString();
        workbook.write(outputStream);
        System.out.println("数据导出成功");
        workbook.close();
        return 1;
    }
    //readRepertory
    public static List<Repertory> readRepertory(String path)throws IOException {
        List<Repertory> repertoryList = new ArrayList<>();
        work = new XSSFWorkbook(Files.newInputStream(Paths.get(path)));
        XSSFSheet sheet = work.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <=lastRowNum; i++) {
            XSSFRow row=sheet.getRow(i);
            if (row!=null) {
                List<String>list=new ArrayList<>();
                for (Cell cell : row) {
                    if (cell!=null) {
                        cell.setCellType(CellType.STRING);
                        String value = cell.getStringCellValue();
                        if (value!=null&&!"".equals(value)) {
                            list.add(value);
                        }
                    }
                }
                if (list.size()>0) {
                    Repertory repertory = new Repertory(list.get(0),
                            list.get(1),
                            Integer.valueOf(list.get(2)),
                            Integer.valueOf(list.get(3)),
                            Integer.valueOf(list.get(4)));
                    repertoryList.add(repertory);
                }
            }
        }
        return repertoryList;
    }
    //writeRepertory
    public static int writeRepertory(List<Repertory>list,String path) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "手机库存表");
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        row.createCell(0).setCellValue("手机名称");
        row.createCell(1).setCellValue("手机型号");
        row.createCell(2).setCellValue("手机进货量");
        row.createCell(3).setCellValue("手机出货量");
        row.createCell(4).setCellValue("手机库存量");
        for (int i = 0; i < list.size(); i++) {
            XSSFRow row1 = sheet.createRow(i+1);
            row1.createCell(0).setCellValue(list.get(i).getpName());
            row1.createCell(1).setCellValue(list.get(i).getpModel());
            row1.createCell(2).setCellValue(list.get(i).getpEnter());
            row1.createCell(3).setCellValue(list.get(i).getpOut());
            row1.createCell(4).setCellValue(list.get(i).getpStock());
        }
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        OutputStream outputStream = Files.newOutputStream(file.toPath());
        outputStream.toString();
        workbook.write(outputStream);
        System.out.println("数据导出成功");
        workbook.close();
        return 1;
    }
    //writeLog
    public static int writeLog(List<Syslog>list, String path) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "操作日志");
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        row.createCell(0).setCellValue("id");
        row.createCell(1).setCellValue("操作人员");
        row.createCell(2).setCellValue("操作");
        row.createCell(3).setCellValue("使用的方法");
        row.createCell(4).setCellValue("操作时间");
        for (int i = 0; i < list.size(); i++) {
            XSSFRow row1 = sheet.createRow(i+1);
            row1.createCell(0).setCellValue(list.get(i).getId());
            row1.createCell(1).setCellValue(list.get(i).getUsername());
            row1.createCell(2).setCellValue(list.get(i).getOperation());
            row1.createCell(3).setCellValue(list.get(i).getMethod());
            row1.createCell(4).setCellValue(list.get(i).getCreateDate());
        }
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        OutputStream outputStream = Files.newOutputStream(file.toPath());
        outputStream.toString();
        workbook.write(outputStream);
        System.out.println("数据导出成功");
        workbook.close();
        return 1;
    }

}

