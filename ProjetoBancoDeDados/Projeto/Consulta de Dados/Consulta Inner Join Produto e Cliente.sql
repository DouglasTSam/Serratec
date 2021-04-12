select cliente.NOME_COMPLETO , pedido.DATA_PEDIDO, produto.NOME as NOME_PRODUTO, pedido_itens.QUANTIDADE, pedido_itens.PRECO 
from PEDIDO 
inner join cliente on cliente.id = pedido.ID_CLIENTE 
INNER JOIN PEDIDO_ITENS on pedido_itens.ID_PEDIDO = pedido.ID 
INNER JOIN PRODUTO on produto.ID = pedido_itens.ID_PRODUTO 
WHERE CLIENTE.ID = 1