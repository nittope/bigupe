/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bigupe.negocios;

import br.com.bigupe.entidades.Aluno;
import br.com.bigupe.persistencia.RepositorioAlunos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcus Vinicius
 */
@Service
public class ServicosAlunoImpl implements ServicosAluno {

    @Autowired
    private RepositorioAlunos repositorio;
    
    @Override
    public void cadastrar(Aluno aluno) throws AlunoExistenteException {
        
        if (repositorio.findByEmail(aluno.getEmail())!= null)
            throw new AlunoExistenteException ();
        repositorio.save(aluno);
    }

    @Override
    public void atualizar(Aluno aluno) throws AlunoInexistenteException {
       Aluno alunoAtualizar = repositorio.findByEmail(aluno.getEmail()) ;      
       
        if (alunoAtualizar == null)
            throw new AlunoInexistenteException();
        alunoAtualizar.setNome(aluno.getNome());
        alunoAtualizar.setDestino(aluno.getDestino());
        alunoAtualizar.setOrigem(aluno.getOrigem());
        alunoAtualizar.setViagens(aluno.getViagens());
        alunoAtualizar.setSenha(aluno.getSenha());
        
        repositorio.save(alunoAtualizar);
        
    }

    @Override
    public void remover(String email) throws AlunoInexistenteException {
        Aluno alunoAtualizar = repositorio.findByEmail(email) ;      
       
        if (alunoAtualizar == null)
            throw new AlunoInexistenteException();
        if (alunoAtualizar.getViagens().isEmpty())            
            repositorio.delete(alunoAtualizar);
        else{
            alunoAtualizar.setAtivo(false);
            repositorio.save(alunoAtualizar);
        }
        
    }

    @Override
    public List<Aluno> listarTodos(){
     return (List<Aluno>) repositorio.findAll();
    }

    @Override
    public Aluno listarPorEmail(String email) throws AlunoInexistenteException {
      Aluno alunoAtualizar = repositorio.findByEmail(email) ;      
       
        if (alunoAtualizar == null)
            throw new AlunoInexistenteException();
        return alunoAtualizar;
    }
    
}
