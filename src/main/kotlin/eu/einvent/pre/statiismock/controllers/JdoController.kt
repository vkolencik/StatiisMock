package eu.einvent.pre.statiismock.controllers

import eu.einvent.pre.statiismock.dao.JdoDao
import eu.einvent.pre.statiismock.dto.JdoItemDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Suppress("unused")
@Controller
class JdoController {
    @Autowired lateinit var jdoDao: JdoDao

    @GetMapping("/jdo")
    @ResponseBody
    fun getJdos(search: String): List<JdoItemDto> {
        val jdo = jdoDao.findByOznaceni(search).stream().findFirst().get()

        val jdoDto = JdoItemDto(jdo.oznaceni, jdo.jid)
        return listOf(jdoDto)
    }
}