package com.example.demo.controller;

import com.example.demo.dto.ThueTroDto;
import com.example.demo.model.ThueTro;
import com.example.demo.service.IHinhThucThanhToanService;
import com.example.demo.service.IThueTroService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/thueTro")
public class ThueTroController {
    @Autowired
    IThueTroService thueTroService;
    @Autowired
    IHinhThucThanhToanService hinhThucThanhToanService;

    @GetMapping("/showList")
    public String showListThueTro(Model model,Pageable pageable,@RequestParam(defaultValue = "")String id
                                                                ,@RequestParam(defaultValue = "") String tenNguoiThueTro
                                                                ,@RequestParam(defaultValue = "")String soDienThoai){
        model.addAttribute("listThueTro",thueTroService.listSearch(pageable,id,tenNguoiThueTro,soDienThoai));
        model.addAttribute("thueTroDto",new ThueTroDto());
        model.addAttribute("listHinhThucThanhToan",hinhThucThanhToanService.findAll());
        return "thue_tro/list";
    }

    @GetMapping("/showFormCreate")
    public String showFormCreate(Model model){
        model.addAttribute("thueTroDto",new ThueTroDto());
        model.addAttribute("listHinhThucThanhToan",hinhThucThanhToanService.findAll());
        return "/create";
    }
    @PostMapping("/createThueTro")
    public String createThueTro(@ModelAttribute("thueTroDto") ThueTroDto thueTroDto, RedirectAttributes redirectAttributes){
        ThueTro thueTro = new ThueTro();
        BeanUtils.copyProperties(thueTroDto,thueTro);
        thueTroService.save(thueTro);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/thueTro/showList";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable("id") int id,Model model){
        ThueTro thueTro = thueTroService.findById(id).get();
        ThueTroDto thueTroDto = new ThueTroDto();
        BeanUtils.copyProperties(thueTro,thueTroDto);
        model.addAttribute("thueTroDto",thueTroDto);
        model.addAttribute("listHinhThucThanhToan",hinhThucThanhToanService.findAll());
        return "thue_tro/update";
    }

    @PostMapping("/updateThueTro")
    public String updateThueTro(@ModelAttribute("thueTroDto") ThueTroDto thueTroDto,RedirectAttributes redirectAttributes){
        ThueTro thueTro = new ThueTro();
        BeanUtils.copyProperties(thueTroDto,thueTro);
        thueTroService.save(thueTro);
        redirectAttributes.addFlashAttribute("mess","update thành công");
        return "redirect:/thueTro/showList";
    }

    @GetMapping("/remove/{id}")
    public String showFormRemoveThueTro(@PathVariable("id") int id,Model model){
        ThueTro thueTro = thueTroService.findById(id).get();
        ThueTroDto thueTroDto = new ThueTroDto();
        BeanUtils.copyProperties(thueTro,thueTroDto);
        model.addAttribute("thueTroDto",thueTroDto);
        model.addAttribute("listHinhThucThanhToan",hinhThucThanhToanService.findAll());
        return "thue_tro/remove";
    }
    @PostMapping("/removeThueTro")
    public String removeThueTro(@RequestParam("id") int id,RedirectAttributes redirectAttributes){
        thueTroService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/thueTro/showList";
    }

    @GetMapping("/removeModalThueTro")
    public String removeModalThueTro(@RequestParam("idRemove") int id,RedirectAttributes redirectAttributes){
        thueTroService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/thueTro/showList";
    }
}
