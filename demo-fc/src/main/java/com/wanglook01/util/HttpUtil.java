package com.wanglook01.util;

import com.wanglook01.dto.D3Data;
import com.wanglook01.dto.D3GetResponse;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HttpUtil {

    private static final RestTemplate REST_TEMPLATE;

    public static class TextJsonMessageConverter extends MappingJackson2HttpMessageConverter {
        public TextJsonMessageConverter() {
            List<MediaType> mediaTypes = new ArrayList<>();
            mediaTypes.add(MediaType.valueOf("text/json;charset=UTF-8"));
            setSupportedMediaTypes(mediaTypes);
        }

    }

    static {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);
        factory.setConnectTimeout(5000);
        REST_TEMPLATE = new RestTemplate(factory);
        REST_TEMPLATE.getMessageConverters().add(new TextJsonMessageConverter());
    }


    private static D3GetResponse get3DDataByPage(int issueCount, int pageNo) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        headers.add("Accept", "application/json, text/javascript, */*; q=0.01");
        //去掉这2个header解决乱码问题：https://www.cnblogs.com/changxy-codest/p/13466857.html
        //headers.add("Accept-Encoding", "gzip, deflate, br");
        //headers.add("Accept-Language", "zh-CN,zh;q=0.9");
        headers.add("Connection", "keep-alive");
        headers.add("Cookie", "HMF_CI=dc70a4b4db5f187d54057ccd2a8b8b7cea3602559348a6caa29b887558c7c73783bf8fff64d8f5f27217f06ecd7449c97bf63ab1b8af76b472cef2b0eda941a7e1; 21_vq=41");
        headers.add("Host", "www.cwl.gov.cn");
        headers.add("Referer", "https://www.cwl.gov.cn/ygkj/wqkjgg/fc3d/");
        headers.add("Sec-Ch-Ua", "\"Not_A Brand\";v=\"8\", \"Chromium\";v=\"120\", \"Google Chrome\";v=\"120\"");
        headers.add("Sec-Ch-Ua-Mobile", "?0");
        headers.add("Sec-Ch-Ua-Platform", "\"Windows\"");
        headers.add("Sec-Fetch-Dest", "empty");
        headers.add("Sec-Fetch-Mode", "cors");
        headers.add("Sec-Fetch-Site", "same-origin");
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        headers.add("X-Requested-With", "XMLHttpRequest");
        HttpEntity<String> request = new HttpEntity<>(headers);
        //
        String address = "https://www.cwl.gov.cn/cwl_admin/front/cwlkj/search/kjxx/findDrawNotice?name=3d&issueCount=" + issueCount + "&issueStart=&issueEnd=&dayStart=&dayEnd=&pageNo=" + pageNo + "&pageSize=30&week=&systemType=PC";
        //
        ResponseEntity<D3GetResponse> exchange = REST_TEMPLATE.exchange(address, HttpMethod.GET, request, D3GetResponse.class);
        return exchange.getBody();
    }

    public static List<D3Data> get3DData(int issueCount) {
        D3GetResponse d3Response = get3DDataByPage(issueCount, 1);
        List<D3Data> resultList = D3Util.convert(d3Response);
        Integer pageSize = d3Response.getPageSize();
        if (pageSize == 1) {
            return resultList;
        }
        for (int pn = 2; pn <= pageSize; pn++) {
            D3GetResponse response = get3DDataByPage(issueCount, pn);
            resultList.addAll(D3Util.convert(response));
        }
        resultList.sort(Comparator.comparing(D3Data::getDate));
        return resultList;
    }


    public static void main(String[] args) {
        List<D3Data> dData = get3DData(400);
        System.out.println(dData);
    }
}
