select produto.*, categoria.nome as CATEGORIA_NOME
from PRODUTO 
inner join CATEGORIA  on categoria.id = produto.ID_CATEGORIA 