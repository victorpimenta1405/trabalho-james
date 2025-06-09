package com.example.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.api.model.Cliente;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @SuppressWarnings("FieldMayBeFinal")
    private List<Cliente> clientes = new ArrayList<>();

    public ClienteController() {
        clientes.add(new Cliente(1L, "João", "joao123@gmail.com", "senha123"));
        clientes.add(new Cliente(2L, "Maria", "maria321@gmail.com", "senha321"));
    }

    @GetMapping
    public List<Cliente> listar() {
        return clientes;
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(id)) {
                clientes.set(i, clienteAtualizado);
                return clienteAtualizado;
            }
        }
        return null;
    }

    @PatchMapping("/{id}")
    public Cliente atualizarParcialmente(@PathVariable Long id, @RequestBody Cliente clienteParcial) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                if (clienteParcial.getEmail() != null) {
                    cliente.setEmail(clienteParcial.getEmail());
                }
                if (clienteParcial.getSenha() != null) {
                    cliente.setSenha(clienteParcial.getSenha());
                }
                return cliente;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = clientes.removeIf(cliente -> cliente.getId().equals(id));
        if (removido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
