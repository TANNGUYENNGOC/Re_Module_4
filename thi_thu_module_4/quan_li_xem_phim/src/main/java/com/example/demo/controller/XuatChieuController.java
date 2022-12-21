package com.example.demo.controller;

import com.example.demo.dto.XuatChieuDto;
import com.example.demo.model.XuatChieu;
import com.example.demo.service.IPhimService;
import com.example.demo.service.IXuatChieuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/xuatChieu")
public class XuatChieuController {
    @Autowired
    IXuatChieuService xuatChieuService;
    @Autowired
    IPhimService phimService;

    @GetMapping("/list")
    public String showList(Model model,@PageableDefault(size = 3,page = 0) Pageable pageable){
        model.addAttribute("list",xuatChieuService.findAll(pageable));
        model.addAttribute("xuatChieuDto",new XuatChieuDto());
        model.addAttribute("listPhim",phimService.findAll());
        return "/list";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable("id") int id,Model model){
        XuatChieu xuatChieu = xuatChieuService.findById(id).get();
        XuatChieuDto xuatChieuDto = new XuatChieuDto();
        BeanUtils.copyProperties(xuatChieu,xuatChieuDto);
        model.addAttribute("xuatChieuDto",xuatChieuDto);
        model.addAttribute("listPhim",phimService.findAll());
        return "/update";
    }

    @PostMapping("/update")
    public String updateXuatChieu(@ModelAttribute("xuatChieuDto") XuatChieuDto xuatChieuDto, RedirectAttributes redirectAttributes){
        XuatChieu xuatChieu = new XuatChieu();
        BeanUtils.copyProperties(xuatChieuDto,xuatChieu);
        xuatChieuService.save(xuatChieu);
        redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công");
        return "redirect:/xuatChieu/list";
    }
    @GetMapping("/remove/{id}")
    public String showFormRemove(@PathVariable("id") int id,Model model){
        XuatChieu xuatChieu = xuatChieuService.findById(id).get();
        XuatChieuDto xuatChieuDto = new XuatChieuDto();
        BeanUtils.copyProperties(xuatChieu,xuatChieuDto);
        model.addAttribute("xuatChieuDto",xuatChieuDto);
        model.addAttribute("listPhim",phimService.findAll());
        return "/remove";
    }

    @PostMapping("/remove")
    public String removeXuatChieu(@RequestParam("id") int id, RedirectAttributes redirectAttributes){
        xuatChieuService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/xuatChieu/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("xuatChieuDto",new XuatChieuDto());
        model.addAttribute("listPhim",phimService.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("xuatChieuDto")XuatChieuDto xuatChieuDto,RedirectAttributes redirectAttributes){
        XuatChieu xuatChieu = new XuatChieu();
        BeanUtils.copyProperties(xuatChieuDto,xuatChieu);
        xuatChieuService.save(xuatChieu);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/xuatChieu/list";
    }

}
