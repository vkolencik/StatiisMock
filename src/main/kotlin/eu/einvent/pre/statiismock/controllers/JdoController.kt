package eu.einvent.pre.statiismock.controllers

import cz.pre.einvent.s3.common.entity.JdoItem
import eu.einvent.pre.statiismock.dao.JdoDao
import eu.einvent.pre.statiismock.dto.JdoItemDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class JdoController {
    @Autowired lateinit var jdoDao: JdoDao

    @GetMapping("/jdo")
    @ResponseBody
    fun getJdos(search: String): List<JdoItemDto> {
        val example = JdoItem()
        example.oznaceni = search
        val jdo = jdoDao.findAll(Example.of(example)).stream().findFirst().get()

        val jdoDto = JdoItemDto(jdo.oznaceni, jdo.jid)
        return listOf(jdoDto)
    }
}