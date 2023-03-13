package com.ggardet.graphql

import com.ggardet.graphql.model.Task
import com.ggardet.graphql.repository.TaskRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class GraphqlApplication

fun main(args: Array<String>) {
    runApplication<GraphqlApplication>(*args)
}
