package com.paginar.controllers;

import com.paginar.entity.Cliente;
import com.paginar.services.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/crear")
    public String crearCliente() {
        return "crear-cliente.html";
    }

    @PostMapping("/creado")
    public String crearCliente(@ModelAttribute("cliente") Cliente cliente) {
        System.out.println(cliente.getNombre());
        clienteService.save(cliente.getNombre(), cliente.getApellido(), cliente.getEmail());
        return "redirect:/cliente/crear";
    }

    @GetMapping("/lista")
    public String listarItems(@PageableDefault(page = 0, size = 5) Pageable pageable, Model model) {
        Page<Cliente> page = clienteService.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("currentPage", page.getNumber());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("totalPages", page.getTotalPages());
        return "listar.html";
    }
}
