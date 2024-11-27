package br.com.rd.api_cliente.controller;

import br.com.rd.api_cliente.entity.Cliente;
import br.com.rd.api_cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        Cliente clienteCriado = this.clienteService.salvar(cliente);
        return new ResponseEntity<>(clienteCriado, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente clienteAtualizado = this.clienteService.atualizar(cliente, id);
        return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        Cliente cliente = this.clienteService.buscarPorId(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        this.clienteService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos() {
        List<Cliente> clientes = this.clienteService.buscarTodos();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

}