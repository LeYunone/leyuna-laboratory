package com.leyunone.laboratory.web.project.resultcode.controller;

import cn.hutool.core.io.FileUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-17
 */
public class MuFileUtil {

    /**
     * 将MultipartFile转换为File
     *
     *
     * @param outFilePath 参数
     * @param multiFile 参数
     * @return 执行结果
     */
    public static File multipartFileToFile(String outFilePath, MultipartFile multiFile) {
        // 获取文件名
        if (null == multiFile) {
            return null;
        }
        String fileName = multiFile.getOriginalFilename();
        if (null == fileName) {
            return null;
        }
        try {
            File toFile;
            InputStream ins;
            ins = multiFile.getInputStream();
            //指定存储路径
            toFile = new File(outFilePath.concat(File.separator).concat(multiFile.getOriginalFilename()));
            if(!toFile.exists()){
                FileUtil.touch(toFile);
            }
            inputStreamToFile(ins, toFile);
            return toFile;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static void inputStreamToFile(InputStream ins, File file) {
        try (OutputStream os = new FileOutputStream(file)) {
            int bytesRead;
            int bytes = 8192;
            byte[] buffer = new byte[bytes];
            while ((bytesRead = ins.read(buffer, 0, bytes)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
