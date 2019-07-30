package com.scorpiospace.domain.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName ErrorLog
 * @Description TODO
 * @Author zq
 * @Date 2019/7/30 15:16
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class ErrorLog {
    private String id;
    private Date logTime;
    private String logInfo;
    private Integer type;
}
