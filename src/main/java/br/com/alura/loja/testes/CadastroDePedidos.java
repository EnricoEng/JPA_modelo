package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.*;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDePedidos {
    
    public static void main(String[] args){
		popularBancoDeDados();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        Produto produto = produtoDao.buscarPorId(1l);


        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(20, pedido, produto));

		em.getTransaction().begin();
        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido);
		em.getTransaction().commit();
	}

    private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );

		Cliente cliente = new Cliente("Rodrigo", "123456789");

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
	}

}
