package me.barlots.depotx.controller

import me.barlots.depotx.entity.dto.ImageLinkDto
import me.barlots.depotx.service.FileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class ResourceController {
//    @Autowired
//    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var fileService: FileService

//    @PostMapping("/strings/{xxx}")
//    fun addString(@PathVariable xxx: String): ResponseEntity<Any> {
//        userRepository.save(User().apply { content = xxx })
//        return ResponseEntity(HttpStatus.CREATED)
//    }

    @PostMapping("/images")
    fun addImage(@RequestParam filename: String): ResponseEntity<Any> {
        //userRepository.save(User().apply { content = xxx })
        val link = ImageLinkDto(filename, filename)
        return ResponseEntity(link, HttpStatus.CREATED)
    }

    @PostMapping("/services")
    fun testService(@RequestParam sentence: String) : ResponseEntity<Any> {
        val said = fileService.say(sentence);
        return ResponseEntity(said, HttpStatus.OK)
    }
}
