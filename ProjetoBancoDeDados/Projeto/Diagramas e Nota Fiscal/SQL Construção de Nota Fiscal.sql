SELECT produto.NOME as NOME_PRODUTO, pedido_itens.QUANTIDADE, pedido_itens.PRECO, (pedido_itens.quantidade * pedido_itens.PRECO) as SUBTOTAL
from PEDIDO
inner join cliente on cliente.id = pedido.ID_CLIENTE 
INNER JOIN PEDIDO_ITENS on pedido_itens.ID_PEDIDO = pedido.ID
INNER JOIN PRODUTO on produto.ID = pedido_itens.ID_PRODUTO
WHERE PEDIDO.ID = 1;


SELECT pedido.id as NUMERO_NOTA_FISCAL, cliente.NOME_COMPLETO , endereco.RUA , endereco.NUMERO, endereco.COMPLEMENTO, endereco.CEP, endereco.BAIRRO, endereco.CIDADE, endereco.ESTADO,
pedido.DATA_PEDIDO, SUM(pedido_itens.quantidade * pedido_itens.PRECO) as TOTAL
from PEDIDO
inner join cliente on cliente.id = pedido.ID_CLIENTE
inner join ENDERECO on endereco.id = cliente.ID_ENDERECO 
INNER JOIN PEDIDO_ITENS on pedido_itens.ID_PEDIDO = pedido.ID
INNER JOIN PRODUTO on produto.ID = pedido_itens.ID_PRODUTO
WHERE PEDIDO.ID = 1