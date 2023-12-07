package senac.com.br.Projeto.Integrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import senac.com.br.Projeto.Integrador.entitys.Clientes;
import senac.com.br.Projeto.Integrador.frameWork.annotions.LogRest;
import senac.com.br.Projeto.Integrador.useCases.clientes.AuthService;
import senac.com.br.Projeto.Integrador.useCases.clientes.impl.repositorys.ClientesRepository;

@RestController
public class AuthController{

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private AuthService authService;

    @PostMapping("/registro")
    @LogRest
    public String registrarUsuario(@RequestParam String nome, @RequestParam String sobreNome, @RequestParam String email, @RequestParam String senha){

        return authService.registrar(nome, sobreNome, email, senha);
    }

    @PostMapping("/login")
    @LogRest
    public String autenticar(@RequestParam String email, @RequestParam String senha){
        Clientes clienteExistente = clientesRepository.findByEmail(email);
        if (authService.autenticar(email, senha)){

            return "Login bem-sucedido!";
        }else {
            return "Credenciais inválidas!";
        }
    }
}
