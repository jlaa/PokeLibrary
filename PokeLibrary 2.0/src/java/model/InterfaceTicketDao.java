/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author LucasPC
 */
public interface InterfaceTicketDao
{
    public abstract void AdicionarTicket(int idUsuario, String DescricaoErro, String tituloErro);
}
