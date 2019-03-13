package com.example.controller;

import com.example.pojo.NewMan;
import org.apache.http.HttpRequest;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/elastic")
public class NewManController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping("/find")
    @ResponseBody
    public String findMan(HttpRequest httpRequest){
        // 构造搜索条件
        QueryBuilder builder = QueryBuilders.existsQuery("name");
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(builder).build();

        List<NewMan> list = elasticsearchTemplate.queryForList(searchQuery,NewMan.class);

        for (NewMan newMan :list){
            System.out.println( newMan.toString());
        }
        return "Search Success";
    }

}
