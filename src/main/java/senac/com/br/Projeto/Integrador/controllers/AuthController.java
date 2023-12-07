package senac.com.br.Projeto.Integrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import senac.com.br.Projeto.Integrador.entitys.Clientes;
import senac.com.br.Projeto.Integrador.frameWork.annotions.LogRest;
import senac.com.br.Projeto.Integrador.useCases.clientes.impl.repositorys.ClientesRepository;

@RestController
public class AuthController {

    @Autowired
    private ClientesRepository clientesRepository;

    @PostMapping("/registro")
    @LogRest
    public String registrarUsuario(@RequestParam String email, String senha){
        Clientes novoCliente = new Clientes();
        novoCliente.setEmail(email);
        novoCliente.setSenha(senha);
        clientesRepository.save(novoCliente);

        return "Cliente registrado com sucesso!";
    }

    @PostMapping("/login")
    @LogRest
    public String autenticarUsuario(@RequestParam String email, @RequestParam String senha){
        Clientes clienteExistente = clientesRepository.findByEmail(email).orElse(null);
        if (clienteExistente != null && clienteExistente.getSenha().equals(senha)){
            return "Login bem-sucedido!";
        }else {
            return "Credenciais inválidas!";
        }
    }
}
