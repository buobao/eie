package com.buobao.eie.action.com;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by dqf on 2015/9/17.
 */
@ParentPackage("com")
public class HelloAction extends ActionSupport{
    private String username;
    private File upload;
    private String message;
    private int number;

    //提交过来的file的名字
    private String uploadFileName;

    //提交过来的file的MIME类型
    private String uploadContentType;

    public String input(){
        System.out.println("input...");
        return "input";
    }

    public String show() throws IOException {
        message = "";
        return "upload";
    }

    public String upload() throws IOException {
//        InputStream is = new FileInputStream(upload);

        //设置文件上传的目录
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
        //设置目录文件
        File toFile = new File(uploadPath+File.separator+uploadFileName);
        FileUtils.copyFile(upload, toFile);
        //创建输出流，输出到文件
//        OutputStream op = new FileOutputStream(toFile);
//
//        byte[] buffer = new byte[1024];
//        int length = 0;
//
//        //读取文件
//        while ((length = is.read(buffer))>0){
//            op.write(buffer,0,length);
//        }
        System.out.println("上传用户:"+username);
        System.out.println("上传文件名:"+uploadFileName);
        System.out.println("上传文件类型:"+uploadContentType);
//        is.close();
//        op.close();
        message = "文件上传成功！";
        //ServletActionContext.getRequest().setAttribute("uploadFileName",uploadFileName);
        return "download";
    }

    public InputStream  download() throws Exception{
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");

        File file = new File("/upload/"+uploadFileName);
        //InputStream in = ServletActionContext.getServletContext().getResourceAsStream("/upload/"+uploadFileName);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType(uploadContentType);
//        response.setHeader("Content-Disposition", "attachment;filename=" + uploadFileName);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(uploadFileName.getBytes("UTF-8"), "iso-8859-1") + "\"");
        response.setContentLength((int) file.length());
        if (file.length() > 0){
            InputStream inStream = new FileInputStream(file);
            byte[] buf = new byte[4096];
            ServletOutputStream servletOS = response.getOutputStream();
            int readLength;
            while (((readLength = inStream.read(buf)) != -1)) {
                servletOS.write(buf, 0, readLength);
            }
            inStream.close();
            servletOS.flush();
            servletOS.close();
        }
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
