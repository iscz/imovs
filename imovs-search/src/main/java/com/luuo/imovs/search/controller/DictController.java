package com.luuo.imovs.search.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;
import com.luuo.imovs.search.entity.CustomDict;
import com.luuo.imovs.search.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/open-api/dict")
public class DictController {

    @Autowired
    private DictService dictService;

    @GetMapping(value = "/getCustomDict", produces = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public String getCustomDict(HttpServletResponse response) {
        log.info("========================来请求啦========================");
        String result = "";
        try {
            List<CustomDict> customDict = dictService.getCustomDict();
            List<String> keywords = customDict.stream().map(CustomDict::getKeyword).collect(Collectors.toList());//获取所有分词，这里可以改进使用缓存等。
            StringBuilder sb = new StringBuilder();
            // 设置头信息。
            response.setDateHeader(HttpHeaders.LAST_MODIFIED, customDict.get(0).getLastModifyTime().getTime());
            response.setHeader(HttpHeaders.ETAG, String.valueOf(keywords.size()));
            //拼装结果
            for (String tempWord : keywords) {
                if (!Strings.isNullOrEmpty(tempWord)) {
                    //分词之间以换行符连接
                    if (!Strings.isNullOrEmpty(sb.toString())) {
                        sb.append("\r\n");
                    }
                    sb.append(tempWord);
                }
            }
            result = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
