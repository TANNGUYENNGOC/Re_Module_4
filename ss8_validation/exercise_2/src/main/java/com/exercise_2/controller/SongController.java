package com.exercise_2.controller;

import com.exercise_2.dto.SongDTO;
import com.exercise_2.model.Song;
import com.exercise_2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    ISongService songService;

    @GetMapping("")
    public String showList(Model model, Pageable pageable) {
        model.addAttribute("listSong", songService.findAll(pageable));
        return ("song/list");
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("songDto", new SongDTO());
        return "song/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("songDto") SongDTO songDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "song/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO,song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/song/";
    }
}
