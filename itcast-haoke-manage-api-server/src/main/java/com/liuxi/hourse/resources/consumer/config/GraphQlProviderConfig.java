package com.liuxi.hourse.resources.consumer.config;

import com.liuxi.hourse.resources.consumer.api.service.HouseResourcesService;
import com.liuxi.hourse.resources.consumer.graphql.MyDateFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * <p>
 * 将 GraphQL 对象载入到 Spring 容器，并且完成 GraphQL 对象的初始化功能
 * </P>
 * @author liu xi
 * @date 2022/3/15 21:04
 */
@Configuration
public class GraphQlProviderConfig {

    private GraphQL graphQL;

    @Autowired
    private HouseResourcesService houseResourcesService;

    @Autowired
    private List<MyDateFetcher> dateFetcherList;

    @Bean
    public GraphQL graphQL() {

        return this.graphQL;
    }

    /**
     * @PostConstruct 修饰非静态的 void 方法
     * 在 bean 初始化之后执行
     */
    @PostConstruct
    public void init() {
        try {
            File graphQlFile = ResourceUtils.getFile("classpath:haoke.graphql");
            this.graphQL = GraphQL.newGraphQL(buildGraphQlSchema(graphQlFile)).build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析 haoke.graphql 文件
     * @param file
     * @return
     */
    private GraphQLSchema buildGraphQlSchema(File file) {
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(file);

        return new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, buildWiring());
    }

    /**
     * 硬编码，不灵活
     * @return
     */
    @Deprecated
    private RuntimeWiring buildWiringDeprecated() {
        // 查询类型
        return RuntimeWiring.newRuntimeWiring().type("HaoKeQuery", builder -> {
            // 返回类型
            return builder.dataFetcher("HouseResources", environment -> {
                // 拿到请求参数
                Long id = environment.getArgument("id");
                return houseResourcesService.queryHouseResourcesById(id);
            });
        }).build();
    }

    /**
     * 动态执行
     * @return
     */
    private RuntimeWiring buildWiring() {
        // 查询类型
        return RuntimeWiring.newRuntimeWiring().type("HaoKeQuery", builder -> {
            for (MyDateFetcher dateFetcher : dateFetcherList) {
                builder.dataFetcher(dateFetcher.fieldName(), dateFetcher::dataFetcher);
            }
            return builder;
        }).build();
    }
}
