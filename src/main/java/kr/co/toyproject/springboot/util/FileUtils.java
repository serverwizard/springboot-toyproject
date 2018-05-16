package kr.co.toyproject.springboot.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;

@Slf4j
public class FileUtils {

    private static final String[] BAD_EXTENSION = {"jsp", "php", "asp",
            "html", "perl"};
    private static final long FILE_MAX_SIZE = 10 * 1024 * 1024; // 10MB

    //    @Autowired
//    private FileConfig fileConfig;
    public static boolean isValidFileExt(String fileName) {
        String ext = getFileExt(fileName);
        log.info("ext : {}", ext);

        int len = BAD_EXTENSION.length;
        for (int i = 0; i < len; i++) {
            if (ext.equalsIgnoreCase(BAD_EXTENSION[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidFileSize(long fileSize) {
        return (fileSize > 0 && fileSize < FILE_MAX_SIZE);
    }

    private static String getFileExt(String fileName) {
        return fileName
                .substring(fileName.lastIndexOf(".") + 1, fileName.length())
                .toLowerCase();
    }

    public static void upload(MultipartFile
                                      multipartFile) {
        String baseDir = "D:" + File.separator + "data_asp00";
        File saveFolder = new File(baseDir);

        // 디렉토리 생성
        if (!saveFolder.exists() || saveFolder.isFile()) {
            saveFolder.mkdirs();
        }

        InputStream stream;
        try {
            String tmpFile = Long.toString(System.currentTimeMillis());
            String savedFileName = tmpFile + "." + getFileExt(multipartFile
                    .getOriginalFilename());

            stream = multipartFile.getInputStream();
            baseDir = baseDir + File.separator + multipartFile
                    .getOriginalFilename();
            log.info("=====================[" + baseDir + "]");

            OutputStream bos = new FileOutputStream(baseDir);

            int bytesRead = 0;
            byte[] buffer = new byte[4096];
            while ((bytesRead = stream.read(buffer, 0, 4096)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            bos.close();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static byte[] getContents(String filePath, String fileType) throws
            IOException {

        String baseDir = "D:" + File.separator + "data_asp00";
        filePath = baseDir + File.separator + filePath;

        File file = new File(filePath);
        if (!file.canRead()) {
            throw new FileNotFoundException();
        }

        Boolean isValidType = new MimetypesFileTypeMap().getContentType(file)
                .startsWith(fileType);
        if (isValidType == false) {
            throw new FileNotFoundException();
        }

        BufferedInputStream bufferdStream = null;
        byte[] bytes = null;

        try {
            bufferdStream = new BufferedInputStream(new FileInputStream
                    (filePath));
            int length = bufferdStream.available();
            bytes = new byte[length];
            bufferdStream.read(bytes);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (bufferdStream != null) {
                try {
                    bufferdStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytes;
    }
}