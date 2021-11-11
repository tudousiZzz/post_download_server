package com.tnx.demo1;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @ClassName DemoController
 * @Description TODO
 * @Author Nanxing Tang
 * @Date 2021--07--10--14:44
 **/
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @PostMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletResponse response, String FileType) throws Exception {
        log.info("FileType: {}", FileType);
        //获取数据
        List<String> list = new ArrayList<>();

        //excel标题
        String[] title = {"111", "222", "333"};

        //excel文件名
        String fileName = "test" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "test";

        String [][] content = new String[list.size()][5];

        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            String obj = list.get(i);
            content[i][0] = obj;
            content[i][1] = obj;
            content[i][2] = obj;
            content[i][3] = obj;
            content[i][4] = obj;
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtils.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送响应流方法
     */
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
