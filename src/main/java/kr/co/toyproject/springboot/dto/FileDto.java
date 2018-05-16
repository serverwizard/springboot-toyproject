package kr.co.toyproject.springboot.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by daou on 2018-05-16.
 */
@Data
public class FileDto {

    private Integer fileNo;            //파일고유번호
    private Integer seqNo;            //순서번호
    private Integer fileKey;        //파일키
    private String originFileNm;    //원본파일명
    private String savedFileNm;        //저장된파일명
    private String filePath;        //저장파일경로
    private String fileExt;            //파일확장자
    private long fileSize;            //파일사이즈
    private String useCd;            //사용유무
    private Integer isrtUser;        //작성자
    private Date isrtDt;            //작성일
    private Integer updtUser;        //수정자
    private Date updtDt;            //수정일시
    private Integer width;            //width
    private Integer height;            //height

}

