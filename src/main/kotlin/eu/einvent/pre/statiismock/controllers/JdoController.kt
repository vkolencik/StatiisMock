package eu.einvent.pre.statiismock.controllers

import eu.einvent.pre.statiismock.models.JdoItem
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class JdoController {

    @GetMapping("/jdo")
    @ResponseBody
    fun getJdos(search: String?): List<JdoItem> {
        val jdo = JdoItem()
        jdo.jid = 1
        jdo.oznaceni = "asdf"
        return listOf(jdo)
    }
}