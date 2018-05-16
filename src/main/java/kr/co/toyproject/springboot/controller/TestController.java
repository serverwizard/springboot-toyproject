package kr.co.toyproject.springboot.controller;

import kr.co.toyproject.springboot.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by daou on 2018-05-16.
 */
@Slf4j
@Controller
public class TestController {

    @GetMapping("/")
    public String view() {
        return "test";
    }

    /**
     * TODO
     * 1. spring.servlet.multipart.max-file-size= 설정값 초과시 alert 보여주는 방법
     * 2. static 멤버변수에 @Autowired를 사용할 수 있나? 없음. 이유는?
     *
     * DONE
     * 1. File.separator 사용 이유 : 시스템에 맞게 자동으로 표시해줌
     * 2. @RequestParam 역할 : get, post방식 모두 받을수 있음
     * 3. @Component를 쓰는 이유 : 스프링 빈으로 등록
     * 4. 파일을 업로드하고 원본파일명을 DB에 저장하는 이유 : 사용자가 다운로드 받을 때 원본 이름으로 내려주기 위해
     *                                                     (다운로드할 일이 없다면 저장할 필요X)
     *  5.
     *
     */
    @PostMapping("/")
    public String upload(Model model, @RequestParam("imgFile") MultipartFile
            multipartFile) {

        log.info("param: {}", multipartFile);
        String fileName = multipartFile.getOriginalFilename();
        log.info("file name:{}", fileName); // 파일 이름
        String name = multipartFile.getName();
        log.info("name: {}", name); // 파라미터 이름
        long size = multipartFile.getSize();
        log.info("size : {}", size); // 파일 크기 (byte)

        log.info("FileUtils.isValidFileExt : {}", FileUtils.isValidFileExt
                (fileName));
        log.info("FileUtils.isValidFileSize : {}", FileUtils.isValidFileSize
                (size));

        FileUtils.upload(multipartFile);
        model.addAttribute("fileName", fileName);

        return "test";
    }

    @ResponseBody
    @RequestMapping("/imageView")
    public void imageView(@RequestParam String fileName,
                          HttpServletResponse response)
            throws FileNotFoundException, IOException {

        log.info("file name:{}", fileName);

        byte[] bytes = FileUtils.getContents(fileName, "image");

        OutputStream output = response.getOutputStream();
        output.write(bytes);
        output.flush();
        output.close();
    }
}
