package senac.com.br.Projeto.Integrador.useCases.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.com.br.Projeto.Integrador.entitys.Clientes;
import senac.com.br.Projeto.Integrador.useCases.clientes.impl.repositorys.ClientesRepository;


@Service
public class AuthService {

    @Autowired
    private ClientesRepository clientesRepository;


    public boolean autenticar(String email, String senha){
        Clientes clientes = clientesRepository.findByEmail(email);

        return clientes != null && clientes.getSenha().equals(senha);
    }

    public String registrar(String nome, String sobreNome, String email, String senha) {
        if (clientesRepository.findByEmail(email) != null){

            return "Usuario já registrado!";
        }

        Clientes novoCliente = new Clientes();
        novoCliente.setNome(nome);
        novoCliente.setSobrenome(sobreNome);
        novoCliente.setEmail(email);
        novoCliente.setSenha(senha);



        clientesRepository.save(novoCliente);

        return "Usuario registrado com sucesso!";

    }
}
