package com.es.example;

import com.es.example.model.Medicine;
import com.es.example.process.ElasticSearchHandler;
import com.es.example.util.DataFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;

import java.util.List;

/**
 * Created by maomao on 16/4/21.
 */
public class EsMain {
    public static void main(String[] args) {
        ElasticSearchHandler esHandler = new ElasticSearchHandler();
        List<String> jsonData = DataFactory.getInstance().getInitJsonData();

        String indexName = "index-demo";
        String type = "type-demo";

        esHandler.createIndex(indexName, type, jsonData);

        // QueryBuilder queryBuilder = QueryBuilders.matchQuery("name", "感冒");
        QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(new QueryStringQueryBuilder("感冒").field("name"));

        List<Medicine> result = esHandler.searcher(queryBuilder, indexName, type);

        result.forEach(medicine ->
                System.out.println("(" + medicine.getId() + ") 药品名称: " +
                        medicine.getName() + "\t\t" + medicine.getFunction()));
    }
}
