package com.standard.app.interceptor

import org.apache.ibatis.executor.statement.StatementHandler
import org.apache.ibatis.plugin.*
import org.slf4j.LoggerFactory
import java.sql.Connection
import java.util.*

@Intercepts(
    Signature(type = StatementHandler::class, method = "prepare", args = arrayOf(Connection::class, Integer::class))
)
class MybatisInterceptor() : Interceptor {

    private var time: Int = 0
    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun intercept(invocation: Invocation?): Any {
        var statementHandler = invocation!!.target as StatementHandler
        var boundSql = statementHandler.boundSql
        var sql = boundSql.sql
        var start = System.currentTimeMillis()
        var proceed = invocation.proceed()
        var end = System.currentTimeMillis()
        if ((end - start) > time) {
            log.info("sql====" + sql + "执行时间:" +  (end - start))
        }
        return proceed
    }

    override fun setProperties(properties: Properties?) {
        time = properties!!["time"] as Int
    }

    override fun plugin(target: Any?): Any {
        return Plugin.wrap(target, this)
    }
}