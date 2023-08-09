package com.leyunone.laboratory.web.project.resultcode.bean;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author leyunone
 * @create 2021-09-10 13:51
 *
 * 记录lucene查询结果
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LuceneCO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long totole;

    private List listData;
}
