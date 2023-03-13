package com.ggardet.graphql.repository

import com.ggardet.graphql.model.Task
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TaskRepository : CrudRepository<Task, UUID>
