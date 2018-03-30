package eu.einvent.pre.statiismock.dao

import cz.pre.einvent.s3.common.entity.JdoItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JdoDao : JpaRepository<JdoItem, Long> {

}