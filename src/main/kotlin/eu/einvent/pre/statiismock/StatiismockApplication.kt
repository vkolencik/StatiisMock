package eu.einvent.pre.statiismock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan
@EntityScan(
        "cz.pre.einvent.s3.common.entity",
        "cz.pre.einvent.s3.data.entity",
        "cz.pre.einvent.s3.domo.entity",
        "cz.pre.einvent.s3.ev.entity",
        "cz.pre.einvent.s3.imports.entity",
        "cz.pre.einvent.s3.sa.entity",
        "cz.pre.einvent.s3.st.entity",
        "cz.pre.einvent.s3.zadosti.entity")
class StatiismockApplication

fun main(args: Array<String>) {
    runApplication<StatiismockApplication>(*args)
}
