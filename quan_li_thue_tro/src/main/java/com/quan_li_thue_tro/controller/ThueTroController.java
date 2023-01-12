package com.quan_li_thue_tro.controller;

import com.quan_li_thue_tro.model.ThueTro;
import com.quan_li_thue_tro.service.IHinhThucThanhToanService;
import com.quan_li_thue_tro.service.IThueTroService;
import dto.IThueTroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/thueTro")
public class ThueTroController {
    @Autowired
    IThueTroService thueTroService;
    @Autowired
    IHinhThucThanhToanService hinhThucThanhToanService;
    @GetMapping("/listThueTro")
    public String listThueTro(@RequestParam(defaultValue = "") String tenNguoiThueTro,
                              @RequestParam(defaultValue = "")String tenHinhThucThanhToan,
                              Pageable pageable,
                              Model model) {
        Page<IThueTroDTO> listThueTro = thueTroService.listThueTro(tenNguoiThueTro,tenHinhThucThanhToan,pageable);
        model.addAttribute("listThueTro",listThueTro);
        model.addAttribute("listHinhThucThanhToan",hinhThucThanhToanService.findAll());
        return "thueTro/list";
    }

    @GetMapping("/showFromCreate")
    public String showFromCreate(Model model){
        model.addAttribute("thueTro", new ThueTro());

        model.addAttribute("hinhThucThanhToan",hinhThucThanhToanService.findAll());
        return "thueTro/create";
    }

    @PostMapping("/create")
    public String createThueTro(@Validated @ModelAttribute("thueTro") ThueTro thueTro,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model){
        thueTro.validate(thueTro,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("hinhThucThanhToan",hinhThucThanhToanService.findAll());
            return "thueTro/create";
        }
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        thueTroService.save(thueTro);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/thueTro/listThueTro";
    }
    @GetMapping("/{id}/update")
    public String showFormCreate(@PathVariable("id")int id,
                                 Model model){
        ThueTro thueTro = thueTroService.findById(id).get();
        model.addAttribute("thueTro",thueTro);
        model.addAttribute("hinhThucThanhToan",hinhThucThanhToanService.findAll());
        return "thueTro/update";
    }
    @PostMapping("/update")
    public String updateThueTro(@Validated @ModelAttribute("thueTro")ThueTro thueTro,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model){
        thueTro.validate(thueTro,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("hinhThucThanhToan",hinhThucThanhToanService.findAll());
            return "thueTro/update";
        }
        thueTroService.save(thueTro);
        redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công");
        return "redirect:/thueTro/listThueTro";
    }

    @PostMapping("/remove")
    public String deleteThueTro(@RequestParam("id")int id,RedirectAttributes redirectAttributes){
        thueTroService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/thueTro/listThueTro";
    }

}
