/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bigupe.negocios;

import br.com.bigupe.entidades.Aluno;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Marcus Vinicius
 */
public interface FachadaServicos extends Serializable {
    public void cadastrar(Aluno aluno) throws AlunoExistenteException;
    public void atualizar(Aluno aluno) throws AlunoInexistenteException;
    public void remover(String email) throws AlunoInexistenteException;
    public List<Aluno> listarTodos();
    public Aluno listarPorEmail(String email) throws AlunoInexistenteException;
    
}
