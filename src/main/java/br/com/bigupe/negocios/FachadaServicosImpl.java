/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bigupe.negocios;

import br.com.bigupe.entidades.Aluno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcus Vinicius
 */
@Service
public class FachadaServicosImpl implements FachadaServicos {

    @Autowired
    private ServicosAluno servicosAluno;
    @Override
    public void cadastrar(Aluno aluno) throws AlunoExistenteException {
        servicosAluno.cadastrar(aluno);
    }

    @Override
    public void atualizar(Aluno aluno) throws AlunoInexistenteException {
        servicosAluno.atualizar(aluno);
    }

    @Override
    public void remover(String email) throws AlunoInexistenteException {
        servicosAluno.remover(email);
    }

    @Override
    public List<Aluno> listarTodos() {
        return servicosAluno.listarTodos();
    }

    @Override
    public Aluno listarPorEmail(String email) throws AlunoInexistenteException {
        return servicosAluno.listarPorEmail(email);
    }
    
}
