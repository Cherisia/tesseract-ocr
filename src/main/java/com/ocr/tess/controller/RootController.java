package com.ocr.tess.controller;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class RootController {

    @RequestMapping("/")
    public String root() {
        String result = "";
        try {
            // 테서렉트 객체 생성 & 설정
            Tesseract tesseract = new Tesseract();
            tesseract.setDatapath(new ClassPathResource("tessdata").getFile().getAbsolutePath());
            tesseract.setLanguage("kor");
            tesseract.setPageSegMode(1);
            tesseract.setOcrEngineMode(1);

            result = tesseract.doOCR(new ClassPathResource("static/test.png").getFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
