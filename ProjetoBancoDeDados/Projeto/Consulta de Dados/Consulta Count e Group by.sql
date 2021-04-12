select categoria.NOME as CATEGORIA, COUNT(produto.ID_CATEGORIA) as QT_PRODUTOS
from PRODUTO 
inner join categoria on produto.id_categoria = categoria.id
group by categoria.NOME