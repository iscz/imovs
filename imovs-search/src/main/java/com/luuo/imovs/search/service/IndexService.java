package com.luuo.imovs.search.service;

import java.io.IOException;
import java.util.List;

import com.luuo.imovs.search.elasticsearch.EsDocument;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {


    private static final int BATCH_SIZE = 2000;

    @Autowired
    private RestHighLevelClient restHighLevelClient;


    private void fullIndex(String indexName, List<? extends EsDocument> esDocumentList) {
        BulkRequest bulkRequest = new BulkRequest();
        esDocumentList.forEach(doc -> bulkRequest.add(
                new IndexRequest(indexName)
                        .id(String.valueOf(doc.getEsId()))
                        .source(doc.getDoc(), XContentType.JSON)));
        try {
            BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);

            if (bulkResponse != null) {
                for (BulkItemResponse bulkItemResponse : bulkResponse) {
                    DocWriteResponse itemResponse = bulkItemResponse.getResponse();

                    if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.INDEX
                            || bulkItemResponse.getOpType() == DocWriteRequest.OpType.CREATE) {
                        IndexResponse indexResponse = (IndexResponse) itemResponse;
                        //TODO 新增成功的处理
                        System.out.println("新增成功,{}" + indexResponse.toString());
                    } else if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.UPDATE) {
                        UpdateResponse updateResponse = (UpdateResponse) itemResponse;
                        //TODO 修改成功的处理
                        System.out.println("修改成功,{}" + updateResponse.toString());
                    } else if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.DELETE) {
                        DeleteResponse deleteResponse = (DeleteResponse) itemResponse;
                        //TODO 删除成功的处理
                        System.out.println("删除成功,{}" + deleteResponse.toString());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
